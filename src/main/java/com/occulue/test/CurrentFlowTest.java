/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.test;

import java.io.*;
import java.util.*;
import java.util.logging.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.util.Assert.state;

import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.api.*;
import com.occulue.subscriber.*;

/**
 * Test CurrentFlow class.
 *
 * @author your_name_here
 */
public class CurrentFlowTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CurrentFlowTest() {
		subscriber = new CurrentFlowSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CurrentFlowTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CurrentFlow...");
			LOGGER.info("**********************************************************\n");
			
			// ---------------------------------------------
			// jumpstart process
			// ---------------------------------------------
			jumpStart();
			
		} catch (Throwable e) {
			throw e;
		} finally {
		}
	}

	/** 
	 * jumpstart the process by instantiating2 CurrentFlow
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		currentFlowId = CurrentFlowBusinessDelegate.getCurrentFlowInstance()
		.createCurrentFlow( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CurrentFlowBusinessDelegate.getCurrentFlowInstance()
				.createCurrentFlow( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.currentFlowSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CurrentFlow : " + successValue.getCurrentFlowId());
							  if (successValue.getCurrentFlowId().equals(currentFlowId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCurrentFlowList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CurrentFlow test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on currentFlow consumed")
					);
			subscriber.currentFlowSubscribe( currentFlowId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CurrentFlow : " + successValue.getCurrentFlowId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCurrentFlowList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on currentFlow for currentFlowId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CurrentFlow. 
	 */
	protected CurrentFlow read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CurrentFlow" );

		CurrentFlow entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CurrentFlow with primary key" );
		msg.append( currentFlowId );
		
		CurrentFlowFetchOneSummary fetchOneSummary = new CurrentFlowFetchOneSummary( currentFlowId );

		try {
			entity = CurrentFlowBusinessDelegate.getCurrentFlowInstance().getCurrentFlow( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CurrentFlow " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CurrentFlow.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CurrentFlow." );

		StringBuilder msg = new StringBuilder( "Failed to update a CurrentFlow : " );        
		CurrentFlow entity = read();
		UpdateCurrentFlowCommand command = generateUpdateCommand();
		command.setCurrentFlowId(entity.getCurrentFlowId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CurrentFlow." );

			// for use later on...
			currentFlowId = entity.getCurrentFlowId();

			CurrentFlowBusinessDelegate proxy = CurrentFlowBusinessDelegate.getCurrentFlowInstance();  

			proxy.updateCurrentFlow( command ).get();

			LOGGER.info( "-- Successfully saved CurrentFlow - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + currentFlowId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CurrentFlow.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CurrentFlow." );

		CurrentFlow entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CurrentFlow with id " + currentFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CurrentFlow with id " + currentFlowId );

			throw e;
		}

		try{
			CurrentFlowBusinessDelegate.getCurrentFlowInstance().delete( new DeleteCurrentFlowCommand( entity.getCurrentFlowId() ) ).get();
			LOGGER.info( "-- Successfully deleted CurrentFlow with id " + currentFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CurrentFlow with id " + currentFlowId );

			throw e;
		}
	}

	/**
	 * get all CurrentFlows.
	 */
	protected List<CurrentFlow> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CurrentFlows:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CurrentFlow : " );        
		List<CurrentFlow> collection  = new ArrayList<>();

		try {
			// call the static get method on the CurrentFlowBusinessDelegate
			collection = CurrentFlowBusinessDelegate.getCurrentFlowInstance().getAllCurrentFlow();
			assertNotNull( collection, "An Empty collection of CurrentFlow was incorrectly returned.");
			
			// Now print out the values
			CurrentFlow entity = null;            
			Iterator<CurrentFlow> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCurrentFlowId(), "-- entity in Collection has a null primary key" );        

				LOGGER.info( " - " + String.valueOf(index) + ". " + entity.toString() );
				index++;
			}
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return collection;			
	}

	/**
	 * Assigns a common log handler for each test class in the suite 
	 * in the event log output needs to go elsewhere
	 * 
	 * @param		handler	Handler
	 * @return		CurrentFlowTest
	 */
	protected CurrentFlowTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CurrentFlow
	 * 
	 * @return CreateCurrentFlowCommand alias
	 */
	protected CreateCurrentFlowCommand generateNewCommand() {
        CreateCurrentFlowCommand command = new CreateCurrentFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CurrentFlow
		 * 
		 * @return UpdateCurrentFlowCommand alias
		 */
	protected UpdateCurrentFlowCommand generateUpdateCommand() {
	        UpdateCurrentFlowCommand command = new UpdateCurrentFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID currentFlowId = null;
	protected CurrentFlowSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CurrentFlowTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCurrentFlowList = 0;
}
