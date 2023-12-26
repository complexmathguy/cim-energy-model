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
 * Test AsynchronousMachine class.
 *
 * @author your_name_here
 */
public class AsynchronousMachineTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AsynchronousMachineTest() {
		subscriber = new AsynchronousMachineSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AsynchronousMachineTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AsynchronousMachine...");
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
	 * jumpstart the process by instantiating2 AsynchronousMachine
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		asynchronousMachineId = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
		.createAsynchronousMachine( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
				.createAsynchronousMachine( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.asynchronousMachineSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AsynchronousMachine : " + successValue.getAsynchronousMachineId());
							  if (successValue.getAsynchronousMachineId().equals(asynchronousMachineId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAsynchronousMachineList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AsynchronousMachine test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachine consumed")
					);
			subscriber.asynchronousMachineSubscribe( asynchronousMachineId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AsynchronousMachine : " + successValue.getAsynchronousMachineId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAsynchronousMachineList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachine for asynchronousMachineId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AsynchronousMachine. 
	 */
	protected AsynchronousMachine read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AsynchronousMachine" );

		AsynchronousMachine entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AsynchronousMachine with primary key" );
		msg.append( asynchronousMachineId );
		
		AsynchronousMachineFetchOneSummary fetchOneSummary = new AsynchronousMachineFetchOneSummary( asynchronousMachineId );

		try {
			entity = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().getAsynchronousMachine( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AsynchronousMachine " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AsynchronousMachine.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AsynchronousMachine." );

		StringBuilder msg = new StringBuilder( "Failed to update a AsynchronousMachine : " );        
		AsynchronousMachine entity = read();
		UpdateAsynchronousMachineCommand command = generateUpdateCommand();
		command.setAsynchronousMachineId(entity.getAsynchronousMachineId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AsynchronousMachine." );

			// for use later on...
			asynchronousMachineId = entity.getAsynchronousMachineId();

			AsynchronousMachineBusinessDelegate proxy = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();  

			proxy.updateAsynchronousMachine( command ).get();

			LOGGER.info( "-- Successfully saved AsynchronousMachine - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + asynchronousMachineId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AsynchronousMachine.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AsynchronousMachine." );

		AsynchronousMachine entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AsynchronousMachine with id " + asynchronousMachineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AsynchronousMachine with id " + asynchronousMachineId );

			throw e;
		}

		try{
			AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().delete( new DeleteAsynchronousMachineCommand( entity.getAsynchronousMachineId() ) ).get();
			LOGGER.info( "-- Successfully deleted AsynchronousMachine with id " + asynchronousMachineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AsynchronousMachine with id " + asynchronousMachineId );

			throw e;
		}
	}

	/**
	 * get all AsynchronousMachines.
	 */
	protected List<AsynchronousMachine> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AsynchronousMachines:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AsynchronousMachine : " );        
		List<AsynchronousMachine> collection  = new ArrayList<>();

		try {
			// call the static get method on the AsynchronousMachineBusinessDelegate
			collection = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().getAllAsynchronousMachine();
			assertNotNull( collection, "An Empty collection of AsynchronousMachine was incorrectly returned.");
			
			// Now print out the values
			AsynchronousMachine entity = null;            
			Iterator<AsynchronousMachine> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAsynchronousMachineId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AsynchronousMachineTest
	 */
	protected AsynchronousMachineTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AsynchronousMachine
	 * 
	 * @return CreateAsynchronousMachineCommand alias
	 */
	protected CreateAsynchronousMachineCommand generateNewCommand() {
        CreateAsynchronousMachineCommand command = new CreateAsynchronousMachineCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AsynchronousMachine
		 * 
		 * @return UpdateAsynchronousMachineCommand alias
		 */
	protected UpdateAsynchronousMachineCommand generateUpdateCommand() {
	        UpdateAsynchronousMachineCommand command = new UpdateAsynchronousMachineCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID asynchronousMachineId = null;
	protected AsynchronousMachineSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AsynchronousMachineTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAsynchronousMachineList = 0;
}
