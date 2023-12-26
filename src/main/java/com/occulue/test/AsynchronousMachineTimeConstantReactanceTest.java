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
 * Test AsynchronousMachineTimeConstantReactance class.
 *
 * @author your_name_here
 */
public class AsynchronousMachineTimeConstantReactanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AsynchronousMachineTimeConstantReactanceTest() {
		subscriber = new AsynchronousMachineTimeConstantReactanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AsynchronousMachineTimeConstantReactanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AsynchronousMachineTimeConstantReactance...");
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
	 * jumpstart the process by instantiating2 AsynchronousMachineTimeConstantReactance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		asynchronousMachineTimeConstantReactanceId = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance()
		.createAsynchronousMachineTimeConstantReactance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance()
				.createAsynchronousMachineTimeConstantReactance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.asynchronousMachineTimeConstantReactanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AsynchronousMachineTimeConstantReactance : " + successValue.getAsynchronousMachineTimeConstantReactanceId());
							  if (successValue.getAsynchronousMachineTimeConstantReactanceId().equals(asynchronousMachineTimeConstantReactanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAsynchronousMachineTimeConstantReactanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AsynchronousMachineTimeConstantReactance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineTimeConstantReactance consumed")
					);
			subscriber.asynchronousMachineTimeConstantReactanceSubscribe( asynchronousMachineTimeConstantReactanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AsynchronousMachineTimeConstantReactance : " + successValue.getAsynchronousMachineTimeConstantReactanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAsynchronousMachineTimeConstantReactanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineTimeConstantReactance for asynchronousMachineTimeConstantReactanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AsynchronousMachineTimeConstantReactance. 
	 */
	protected AsynchronousMachineTimeConstantReactance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AsynchronousMachineTimeConstantReactance" );

		AsynchronousMachineTimeConstantReactance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AsynchronousMachineTimeConstantReactance with primary key" );
		msg.append( asynchronousMachineTimeConstantReactanceId );
		
		AsynchronousMachineTimeConstantReactanceFetchOneSummary fetchOneSummary = new AsynchronousMachineTimeConstantReactanceFetchOneSummary( asynchronousMachineTimeConstantReactanceId );

		try {
			entity = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance().getAsynchronousMachineTimeConstantReactance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AsynchronousMachineTimeConstantReactance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AsynchronousMachineTimeConstantReactance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AsynchronousMachineTimeConstantReactance." );

		StringBuilder msg = new StringBuilder( "Failed to update a AsynchronousMachineTimeConstantReactance : " );        
		AsynchronousMachineTimeConstantReactance entity = read();
		UpdateAsynchronousMachineTimeConstantReactanceCommand command = generateUpdateCommand();
		command.setAsynchronousMachineTimeConstantReactanceId(entity.getAsynchronousMachineTimeConstantReactanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AsynchronousMachineTimeConstantReactance." );

			// for use later on...
			asynchronousMachineTimeConstantReactanceId = entity.getAsynchronousMachineTimeConstantReactanceId();

			AsynchronousMachineTimeConstantReactanceBusinessDelegate proxy = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance();  

			proxy.updateAsynchronousMachineTimeConstantReactance( command ).get();

			LOGGER.info( "-- Successfully saved AsynchronousMachineTimeConstantReactance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + asynchronousMachineTimeConstantReactanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AsynchronousMachineTimeConstantReactance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AsynchronousMachineTimeConstantReactance." );

		AsynchronousMachineTimeConstantReactance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AsynchronousMachineTimeConstantReactance with id " + asynchronousMachineTimeConstantReactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AsynchronousMachineTimeConstantReactance with id " + asynchronousMachineTimeConstantReactanceId );

			throw e;
		}

		try{
			AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance().delete( new DeleteAsynchronousMachineTimeConstantReactanceCommand( entity.getAsynchronousMachineTimeConstantReactanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted AsynchronousMachineTimeConstantReactance with id " + asynchronousMachineTimeConstantReactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AsynchronousMachineTimeConstantReactance with id " + asynchronousMachineTimeConstantReactanceId );

			throw e;
		}
	}

	/**
	 * get all AsynchronousMachineTimeConstantReactances.
	 */
	protected List<AsynchronousMachineTimeConstantReactance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AsynchronousMachineTimeConstantReactances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AsynchronousMachineTimeConstantReactance : " );        
		List<AsynchronousMachineTimeConstantReactance> collection  = new ArrayList<>();

		try {
			// call the static get method on the AsynchronousMachineTimeConstantReactanceBusinessDelegate
			collection = AsynchronousMachineTimeConstantReactanceBusinessDelegate.getAsynchronousMachineTimeConstantReactanceInstance().getAllAsynchronousMachineTimeConstantReactance();
			assertNotNull( collection, "An Empty collection of AsynchronousMachineTimeConstantReactance was incorrectly returned.");
			
			// Now print out the values
			AsynchronousMachineTimeConstantReactance entity = null;            
			Iterator<AsynchronousMachineTimeConstantReactance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAsynchronousMachineTimeConstantReactanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AsynchronousMachineTimeConstantReactanceTest
	 */
	protected AsynchronousMachineTimeConstantReactanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AsynchronousMachineTimeConstantReactance
	 * 
	 * @return CreateAsynchronousMachineTimeConstantReactanceCommand alias
	 */
	protected CreateAsynchronousMachineTimeConstantReactanceCommand generateNewCommand() {
        CreateAsynchronousMachineTimeConstantReactanceCommand command = new CreateAsynchronousMachineTimeConstantReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AsynchronousMachineTimeConstantReactance
		 * 
		 * @return UpdateAsynchronousMachineTimeConstantReactanceCommand alias
		 */
	protected UpdateAsynchronousMachineTimeConstantReactanceCommand generateUpdateCommand() {
	        UpdateAsynchronousMachineTimeConstantReactanceCommand command = new UpdateAsynchronousMachineTimeConstantReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID asynchronousMachineTimeConstantReactanceId = null;
	protected AsynchronousMachineTimeConstantReactanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AsynchronousMachineTimeConstantReactanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAsynchronousMachineTimeConstantReactanceList = 0;
}
