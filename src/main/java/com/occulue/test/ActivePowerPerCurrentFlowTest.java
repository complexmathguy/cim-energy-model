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
 * Test ActivePowerPerCurrentFlow class.
 *
 * @author your_name_here
 */
public class ActivePowerPerCurrentFlowTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ActivePowerPerCurrentFlowTest() {
		subscriber = new ActivePowerPerCurrentFlowSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ActivePowerPerCurrentFlowTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ActivePowerPerCurrentFlow...");
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
	 * jumpstart the process by instantiating2 ActivePowerPerCurrentFlow
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		activePowerPerCurrentFlowId = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance()
		.createActivePowerPerCurrentFlow( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance()
				.createActivePowerPerCurrentFlow( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.activePowerPerCurrentFlowSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ActivePowerPerCurrentFlow : " + successValue.getActivePowerPerCurrentFlowId());
							  if (successValue.getActivePowerPerCurrentFlowId().equals(activePowerPerCurrentFlowId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfActivePowerPerCurrentFlowList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ActivePowerPerCurrentFlow test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerPerCurrentFlow consumed")
					);
			subscriber.activePowerPerCurrentFlowSubscribe( activePowerPerCurrentFlowId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ActivePowerPerCurrentFlow : " + successValue.getActivePowerPerCurrentFlowId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfActivePowerPerCurrentFlowList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerPerCurrentFlow for activePowerPerCurrentFlowId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ActivePowerPerCurrentFlow. 
	 */
	protected ActivePowerPerCurrentFlow read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ActivePowerPerCurrentFlow" );

		ActivePowerPerCurrentFlow entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ActivePowerPerCurrentFlow with primary key" );
		msg.append( activePowerPerCurrentFlowId );
		
		ActivePowerPerCurrentFlowFetchOneSummary fetchOneSummary = new ActivePowerPerCurrentFlowFetchOneSummary( activePowerPerCurrentFlowId );

		try {
			entity = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().getActivePowerPerCurrentFlow( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ActivePowerPerCurrentFlow " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ActivePowerPerCurrentFlow.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ActivePowerPerCurrentFlow." );

		StringBuilder msg = new StringBuilder( "Failed to update a ActivePowerPerCurrentFlow : " );        
		ActivePowerPerCurrentFlow entity = read();
		UpdateActivePowerPerCurrentFlowCommand command = generateUpdateCommand();
		command.setActivePowerPerCurrentFlowId(entity.getActivePowerPerCurrentFlowId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ActivePowerPerCurrentFlow." );

			// for use later on...
			activePowerPerCurrentFlowId = entity.getActivePowerPerCurrentFlowId();

			ActivePowerPerCurrentFlowBusinessDelegate proxy = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance();  

			proxy.updateActivePowerPerCurrentFlow( command ).get();

			LOGGER.info( "-- Successfully saved ActivePowerPerCurrentFlow - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + activePowerPerCurrentFlowId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ActivePowerPerCurrentFlow.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ActivePowerPerCurrentFlow." );

		ActivePowerPerCurrentFlow entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ActivePowerPerCurrentFlow with id " + activePowerPerCurrentFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ActivePowerPerCurrentFlow with id " + activePowerPerCurrentFlowId );

			throw e;
		}

		try{
			ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().delete( new DeleteActivePowerPerCurrentFlowCommand( entity.getActivePowerPerCurrentFlowId() ) ).get();
			LOGGER.info( "-- Successfully deleted ActivePowerPerCurrentFlow with id " + activePowerPerCurrentFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ActivePowerPerCurrentFlow with id " + activePowerPerCurrentFlowId );

			throw e;
		}
	}

	/**
	 * get all ActivePowerPerCurrentFlows.
	 */
	protected List<ActivePowerPerCurrentFlow> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ActivePowerPerCurrentFlows:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ActivePowerPerCurrentFlow : " );        
		List<ActivePowerPerCurrentFlow> collection  = new ArrayList<>();

		try {
			// call the static get method on the ActivePowerPerCurrentFlowBusinessDelegate
			collection = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().getAllActivePowerPerCurrentFlow();
			assertNotNull( collection, "An Empty collection of ActivePowerPerCurrentFlow was incorrectly returned.");
			
			// Now print out the values
			ActivePowerPerCurrentFlow entity = null;            
			Iterator<ActivePowerPerCurrentFlow> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getActivePowerPerCurrentFlowId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ActivePowerPerCurrentFlowTest
	 */
	protected ActivePowerPerCurrentFlowTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ActivePowerPerCurrentFlow
	 * 
	 * @return CreateActivePowerPerCurrentFlowCommand alias
	 */
	protected CreateActivePowerPerCurrentFlowCommand generateNewCommand() {
        CreateActivePowerPerCurrentFlowCommand command = new CreateActivePowerPerCurrentFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ActivePowerPerCurrentFlow
		 * 
		 * @return UpdateActivePowerPerCurrentFlowCommand alias
		 */
	protected UpdateActivePowerPerCurrentFlowCommand generateUpdateCommand() {
	        UpdateActivePowerPerCurrentFlowCommand command = new UpdateActivePowerPerCurrentFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID activePowerPerCurrentFlowId = null;
	protected ActivePowerPerCurrentFlowSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ActivePowerPerCurrentFlowTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfActivePowerPerCurrentFlowList = 0;
}
