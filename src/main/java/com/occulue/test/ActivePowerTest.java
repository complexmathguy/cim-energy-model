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
 * Test ActivePower class.
 *
 * @author your_name_here
 */
public class ActivePowerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ActivePowerTest() {
		subscriber = new ActivePowerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ActivePowerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ActivePower...");
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
	 * jumpstart the process by instantiating2 ActivePower
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		activePowerId = ActivePowerBusinessDelegate.getActivePowerInstance()
		.createActivePower( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ActivePowerBusinessDelegate.getActivePowerInstance()
				.createActivePower( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.activePowerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ActivePower : " + successValue.getActivePowerId());
							  if (successValue.getActivePowerId().equals(activePowerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfActivePowerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ActivePower test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePower consumed")
					);
			subscriber.activePowerSubscribe( activePowerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ActivePower : " + successValue.getActivePowerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfActivePowerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on activePower for activePowerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ActivePower. 
	 */
	protected ActivePower read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ActivePower" );

		ActivePower entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ActivePower with primary key" );
		msg.append( activePowerId );
		
		ActivePowerFetchOneSummary fetchOneSummary = new ActivePowerFetchOneSummary( activePowerId );

		try {
			entity = ActivePowerBusinessDelegate.getActivePowerInstance().getActivePower( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ActivePower " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ActivePower.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ActivePower." );

		StringBuilder msg = new StringBuilder( "Failed to update a ActivePower : " );        
		ActivePower entity = read();
		UpdateActivePowerCommand command = generateUpdateCommand();
		command.setActivePowerId(entity.getActivePowerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ActivePower." );

			// for use later on...
			activePowerId = entity.getActivePowerId();

			ActivePowerBusinessDelegate proxy = ActivePowerBusinessDelegate.getActivePowerInstance();  

			proxy.updateActivePower( command ).get();

			LOGGER.info( "-- Successfully saved ActivePower - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + activePowerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ActivePower.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ActivePower." );

		ActivePower entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ActivePower with id " + activePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ActivePower with id " + activePowerId );

			throw e;
		}

		try{
			ActivePowerBusinessDelegate.getActivePowerInstance().delete( new DeleteActivePowerCommand( entity.getActivePowerId() ) ).get();
			LOGGER.info( "-- Successfully deleted ActivePower with id " + activePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ActivePower with id " + activePowerId );

			throw e;
		}
	}

	/**
	 * get all ActivePowers.
	 */
	protected List<ActivePower> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ActivePowers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ActivePower : " );        
		List<ActivePower> collection  = new ArrayList<>();

		try {
			// call the static get method on the ActivePowerBusinessDelegate
			collection = ActivePowerBusinessDelegate.getActivePowerInstance().getAllActivePower();
			assertNotNull( collection, "An Empty collection of ActivePower was incorrectly returned.");
			
			// Now print out the values
			ActivePower entity = null;            
			Iterator<ActivePower> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getActivePowerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ActivePowerTest
	 */
	protected ActivePowerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ActivePower
	 * 
	 * @return CreateActivePowerCommand alias
	 */
	protected CreateActivePowerCommand generateNewCommand() {
        CreateActivePowerCommand command = new CreateActivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ActivePower
		 * 
		 * @return UpdateActivePowerCommand alias
		 */
	protected UpdateActivePowerCommand generateUpdateCommand() {
	        UpdateActivePowerCommand command = new UpdateActivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID activePowerId = null;
	protected ActivePowerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ActivePowerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfActivePowerList = 0;
}
