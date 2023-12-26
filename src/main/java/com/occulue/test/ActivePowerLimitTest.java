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
 * Test ActivePowerLimit class.
 *
 * @author your_name_here
 */
public class ActivePowerLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ActivePowerLimitTest() {
		subscriber = new ActivePowerLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ActivePowerLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ActivePowerLimit...");
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
	 * jumpstart the process by instantiating2 ActivePowerLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		activePowerLimitId = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance()
		.createActivePowerLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance()
				.createActivePowerLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.activePowerLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ActivePowerLimit : " + successValue.getActivePowerLimitId());
							  if (successValue.getActivePowerLimitId().equals(activePowerLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfActivePowerLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ActivePowerLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerLimit consumed")
					);
			subscriber.activePowerLimitSubscribe( activePowerLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ActivePowerLimit : " + successValue.getActivePowerLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfActivePowerLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerLimit for activePowerLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ActivePowerLimit. 
	 */
	protected ActivePowerLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ActivePowerLimit" );

		ActivePowerLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ActivePowerLimit with primary key" );
		msg.append( activePowerLimitId );
		
		ActivePowerLimitFetchOneSummary fetchOneSummary = new ActivePowerLimitFetchOneSummary( activePowerLimitId );

		try {
			entity = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().getActivePowerLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ActivePowerLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ActivePowerLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ActivePowerLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a ActivePowerLimit : " );        
		ActivePowerLimit entity = read();
		UpdateActivePowerLimitCommand command = generateUpdateCommand();
		command.setActivePowerLimitId(entity.getActivePowerLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ActivePowerLimit." );

			// for use later on...
			activePowerLimitId = entity.getActivePowerLimitId();

			ActivePowerLimitBusinessDelegate proxy = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance();  

			proxy.updateActivePowerLimit( command ).get();

			LOGGER.info( "-- Successfully saved ActivePowerLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + activePowerLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ActivePowerLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ActivePowerLimit." );

		ActivePowerLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ActivePowerLimit with id " + activePowerLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ActivePowerLimit with id " + activePowerLimitId );

			throw e;
		}

		try{
			ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().delete( new DeleteActivePowerLimitCommand( entity.getActivePowerLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted ActivePowerLimit with id " + activePowerLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ActivePowerLimit with id " + activePowerLimitId );

			throw e;
		}
	}

	/**
	 * get all ActivePowerLimits.
	 */
	protected List<ActivePowerLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ActivePowerLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ActivePowerLimit : " );        
		List<ActivePowerLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the ActivePowerLimitBusinessDelegate
			collection = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().getAllActivePowerLimit();
			assertNotNull( collection, "An Empty collection of ActivePowerLimit was incorrectly returned.");
			
			// Now print out the values
			ActivePowerLimit entity = null;            
			Iterator<ActivePowerLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getActivePowerLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ActivePowerLimitTest
	 */
	protected ActivePowerLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ActivePowerLimit
	 * 
	 * @return CreateActivePowerLimitCommand alias
	 */
	protected CreateActivePowerLimitCommand generateNewCommand() {
        CreateActivePowerLimitCommand command = new CreateActivePowerLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ActivePowerLimit
		 * 
		 * @return UpdateActivePowerLimitCommand alias
		 */
	protected UpdateActivePowerLimitCommand generateUpdateCommand() {
	        UpdateActivePowerLimitCommand command = new UpdateActivePowerLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID activePowerLimitId = null;
	protected ActivePowerLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ActivePowerLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfActivePowerLimitList = 0;
}
