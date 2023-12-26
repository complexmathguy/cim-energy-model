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
 * Test ActivePowerPerFrequency class.
 *
 * @author your_name_here
 */
public class ActivePowerPerFrequencyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ActivePowerPerFrequencyTest() {
		subscriber = new ActivePowerPerFrequencySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ActivePowerPerFrequencyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ActivePowerPerFrequency...");
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
	 * jumpstart the process by instantiating2 ActivePowerPerFrequency
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		activePowerPerFrequencyId = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
		.createActivePowerPerFrequency( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance()
				.createActivePowerPerFrequency( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.activePowerPerFrequencySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ActivePowerPerFrequency : " + successValue.getActivePowerPerFrequencyId());
							  if (successValue.getActivePowerPerFrequencyId().equals(activePowerPerFrequencyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfActivePowerPerFrequencyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ActivePowerPerFrequency test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerPerFrequency consumed")
					);
			subscriber.activePowerPerFrequencySubscribe( activePowerPerFrequencyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ActivePowerPerFrequency : " + successValue.getActivePowerPerFrequencyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfActivePowerPerFrequencyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePowerPerFrequency for activePowerPerFrequencyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ActivePowerPerFrequency. 
	 */
	protected ActivePowerPerFrequency read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ActivePowerPerFrequency" );

		ActivePowerPerFrequency entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ActivePowerPerFrequency with primary key" );
		msg.append( activePowerPerFrequencyId );
		
		ActivePowerPerFrequencyFetchOneSummary fetchOneSummary = new ActivePowerPerFrequencyFetchOneSummary( activePowerPerFrequencyId );

		try {
			entity = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().getActivePowerPerFrequency( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ActivePowerPerFrequency " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ActivePowerPerFrequency.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ActivePowerPerFrequency." );

		StringBuilder msg = new StringBuilder( "Failed to update a ActivePowerPerFrequency : " );        
		ActivePowerPerFrequency entity = read();
		UpdateActivePowerPerFrequencyCommand command = generateUpdateCommand();
		command.setActivePowerPerFrequencyId(entity.getActivePowerPerFrequencyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ActivePowerPerFrequency." );

			// for use later on...
			activePowerPerFrequencyId = entity.getActivePowerPerFrequencyId();

			ActivePowerPerFrequencyBusinessDelegate proxy = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance();  

			proxy.updateActivePowerPerFrequency( command ).get();

			LOGGER.info( "-- Successfully saved ActivePowerPerFrequency - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + activePowerPerFrequencyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ActivePowerPerFrequency.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ActivePowerPerFrequency." );

		ActivePowerPerFrequency entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ActivePowerPerFrequency with id " + activePowerPerFrequencyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ActivePowerPerFrequency with id " + activePowerPerFrequencyId );

			throw e;
		}

		try{
			ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().delete( new DeleteActivePowerPerFrequencyCommand( entity.getActivePowerPerFrequencyId() ) ).get();
			LOGGER.info( "-- Successfully deleted ActivePowerPerFrequency with id " + activePowerPerFrequencyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ActivePowerPerFrequency with id " + activePowerPerFrequencyId );

			throw e;
		}
	}

	/**
	 * get all ActivePowerPerFrequencys.
	 */
	protected List<ActivePowerPerFrequency> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ActivePowerPerFrequencys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ActivePowerPerFrequency : " );        
		List<ActivePowerPerFrequency> collection  = new ArrayList<>();

		try {
			// call the static get method on the ActivePowerPerFrequencyBusinessDelegate
			collection = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().getAllActivePowerPerFrequency();
			assertNotNull( collection, "An Empty collection of ActivePowerPerFrequency was incorrectly returned.");
			
			// Now print out the values
			ActivePowerPerFrequency entity = null;            
			Iterator<ActivePowerPerFrequency> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getActivePowerPerFrequencyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ActivePowerPerFrequencyTest
	 */
	protected ActivePowerPerFrequencyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ActivePowerPerFrequency
	 * 
	 * @return CreateActivePowerPerFrequencyCommand alias
	 */
	protected CreateActivePowerPerFrequencyCommand generateNewCommand() {
        CreateActivePowerPerFrequencyCommand command = new CreateActivePowerPerFrequencyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ActivePowerPerFrequency
		 * 
		 * @return UpdateActivePowerPerFrequencyCommand alias
		 */
	protected UpdateActivePowerPerFrequencyCommand generateUpdateCommand() {
	        UpdateActivePowerPerFrequencyCommand command = new UpdateActivePowerPerFrequencyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID activePowerPerFrequencyId = null;
	protected ActivePowerPerFrequencySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ActivePowerPerFrequencyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfActivePowerPerFrequencyList = 0;
}
