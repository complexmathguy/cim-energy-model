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
 * Test CurrentLimit class.
 *
 * @author your_name_here
 */
public class CurrentLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CurrentLimitTest() {
		subscriber = new CurrentLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CurrentLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CurrentLimit...");
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
	 * jumpstart the process by instantiating2 CurrentLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		currentLimitId = CurrentLimitBusinessDelegate.getCurrentLimitInstance()
		.createCurrentLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CurrentLimitBusinessDelegate.getCurrentLimitInstance()
				.createCurrentLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.currentLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CurrentLimit : " + successValue.getCurrentLimitId());
							  if (successValue.getCurrentLimitId().equals(currentLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCurrentLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CurrentLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on currentLimit consumed")
					);
			subscriber.currentLimitSubscribe( currentLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CurrentLimit : " + successValue.getCurrentLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCurrentLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on currentLimit for currentLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CurrentLimit. 
	 */
	protected CurrentLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CurrentLimit" );

		CurrentLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CurrentLimit with primary key" );
		msg.append( currentLimitId );
		
		CurrentLimitFetchOneSummary fetchOneSummary = new CurrentLimitFetchOneSummary( currentLimitId );

		try {
			entity = CurrentLimitBusinessDelegate.getCurrentLimitInstance().getCurrentLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CurrentLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CurrentLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CurrentLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a CurrentLimit : " );        
		CurrentLimit entity = read();
		UpdateCurrentLimitCommand command = generateUpdateCommand();
		command.setCurrentLimitId(entity.getCurrentLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CurrentLimit." );

			// for use later on...
			currentLimitId = entity.getCurrentLimitId();

			CurrentLimitBusinessDelegate proxy = CurrentLimitBusinessDelegate.getCurrentLimitInstance();  

			proxy.updateCurrentLimit( command ).get();

			LOGGER.info( "-- Successfully saved CurrentLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + currentLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CurrentLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CurrentLimit." );

		CurrentLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CurrentLimit with id " + currentLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CurrentLimit with id " + currentLimitId );

			throw e;
		}

		try{
			CurrentLimitBusinessDelegate.getCurrentLimitInstance().delete( new DeleteCurrentLimitCommand( entity.getCurrentLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted CurrentLimit with id " + currentLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CurrentLimit with id " + currentLimitId );

			throw e;
		}
	}

	/**
	 * get all CurrentLimits.
	 */
	protected List<CurrentLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CurrentLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CurrentLimit : " );        
		List<CurrentLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the CurrentLimitBusinessDelegate
			collection = CurrentLimitBusinessDelegate.getCurrentLimitInstance().getAllCurrentLimit();
			assertNotNull( collection, "An Empty collection of CurrentLimit was incorrectly returned.");
			
			// Now print out the values
			CurrentLimit entity = null;            
			Iterator<CurrentLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCurrentLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CurrentLimitTest
	 */
	protected CurrentLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CurrentLimit
	 * 
	 * @return CreateCurrentLimitCommand alias
	 */
	protected CreateCurrentLimitCommand generateNewCommand() {
        CreateCurrentLimitCommand command = new CreateCurrentLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CurrentLimit
		 * 
		 * @return UpdateCurrentLimitCommand alias
		 */
	protected UpdateCurrentLimitCommand generateUpdateCommand() {
	        UpdateCurrentLimitCommand command = new UpdateCurrentLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID currentLimitId = null;
	protected CurrentLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CurrentLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCurrentLimitList = 0;
}
