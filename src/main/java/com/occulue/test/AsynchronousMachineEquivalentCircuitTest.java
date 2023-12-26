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
 * Test AsynchronousMachineEquivalentCircuit class.
 *
 * @author your_name_here
 */
public class AsynchronousMachineEquivalentCircuitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AsynchronousMachineEquivalentCircuitTest() {
		subscriber = new AsynchronousMachineEquivalentCircuitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AsynchronousMachineEquivalentCircuitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AsynchronousMachineEquivalentCircuit...");
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
	 * jumpstart the process by instantiating2 AsynchronousMachineEquivalentCircuit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		asynchronousMachineEquivalentCircuitId = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance()
		.createAsynchronousMachineEquivalentCircuit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance()
				.createAsynchronousMachineEquivalentCircuit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.asynchronousMachineEquivalentCircuitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AsynchronousMachineEquivalentCircuit : " + successValue.getAsynchronousMachineEquivalentCircuitId());
							  if (successValue.getAsynchronousMachineEquivalentCircuitId().equals(asynchronousMachineEquivalentCircuitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAsynchronousMachineEquivalentCircuitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AsynchronousMachineEquivalentCircuit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineEquivalentCircuit consumed")
					);
			subscriber.asynchronousMachineEquivalentCircuitSubscribe( asynchronousMachineEquivalentCircuitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AsynchronousMachineEquivalentCircuit : " + successValue.getAsynchronousMachineEquivalentCircuitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAsynchronousMachineEquivalentCircuitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineEquivalentCircuit for asynchronousMachineEquivalentCircuitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AsynchronousMachineEquivalentCircuit. 
	 */
	protected AsynchronousMachineEquivalentCircuit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AsynchronousMachineEquivalentCircuit" );

		AsynchronousMachineEquivalentCircuit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AsynchronousMachineEquivalentCircuit with primary key" );
		msg.append( asynchronousMachineEquivalentCircuitId );
		
		AsynchronousMachineEquivalentCircuitFetchOneSummary fetchOneSummary = new AsynchronousMachineEquivalentCircuitFetchOneSummary( asynchronousMachineEquivalentCircuitId );

		try {
			entity = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance().getAsynchronousMachineEquivalentCircuit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AsynchronousMachineEquivalentCircuit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AsynchronousMachineEquivalentCircuit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AsynchronousMachineEquivalentCircuit." );

		StringBuilder msg = new StringBuilder( "Failed to update a AsynchronousMachineEquivalentCircuit : " );        
		AsynchronousMachineEquivalentCircuit entity = read();
		UpdateAsynchronousMachineEquivalentCircuitCommand command = generateUpdateCommand();
		command.setAsynchronousMachineEquivalentCircuitId(entity.getAsynchronousMachineEquivalentCircuitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AsynchronousMachineEquivalentCircuit." );

			// for use later on...
			asynchronousMachineEquivalentCircuitId = entity.getAsynchronousMachineEquivalentCircuitId();

			AsynchronousMachineEquivalentCircuitBusinessDelegate proxy = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance();  

			proxy.updateAsynchronousMachineEquivalentCircuit( command ).get();

			LOGGER.info( "-- Successfully saved AsynchronousMachineEquivalentCircuit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + asynchronousMachineEquivalentCircuitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AsynchronousMachineEquivalentCircuit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AsynchronousMachineEquivalentCircuit." );

		AsynchronousMachineEquivalentCircuit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AsynchronousMachineEquivalentCircuit with id " + asynchronousMachineEquivalentCircuitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AsynchronousMachineEquivalentCircuit with id " + asynchronousMachineEquivalentCircuitId );

			throw e;
		}

		try{
			AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance().delete( new DeleteAsynchronousMachineEquivalentCircuitCommand( entity.getAsynchronousMachineEquivalentCircuitId() ) ).get();
			LOGGER.info( "-- Successfully deleted AsynchronousMachineEquivalentCircuit with id " + asynchronousMachineEquivalentCircuitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AsynchronousMachineEquivalentCircuit with id " + asynchronousMachineEquivalentCircuitId );

			throw e;
		}
	}

	/**
	 * get all AsynchronousMachineEquivalentCircuits.
	 */
	protected List<AsynchronousMachineEquivalentCircuit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AsynchronousMachineEquivalentCircuits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AsynchronousMachineEquivalentCircuit : " );        
		List<AsynchronousMachineEquivalentCircuit> collection  = new ArrayList<>();

		try {
			// call the static get method on the AsynchronousMachineEquivalentCircuitBusinessDelegate
			collection = AsynchronousMachineEquivalentCircuitBusinessDelegate.getAsynchronousMachineEquivalentCircuitInstance().getAllAsynchronousMachineEquivalentCircuit();
			assertNotNull( collection, "An Empty collection of AsynchronousMachineEquivalentCircuit was incorrectly returned.");
			
			// Now print out the values
			AsynchronousMachineEquivalentCircuit entity = null;            
			Iterator<AsynchronousMachineEquivalentCircuit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAsynchronousMachineEquivalentCircuitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AsynchronousMachineEquivalentCircuitTest
	 */
	protected AsynchronousMachineEquivalentCircuitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AsynchronousMachineEquivalentCircuit
	 * 
	 * @return CreateAsynchronousMachineEquivalentCircuitCommand alias
	 */
	protected CreateAsynchronousMachineEquivalentCircuitCommand generateNewCommand() {
        CreateAsynchronousMachineEquivalentCircuitCommand command = new CreateAsynchronousMachineEquivalentCircuitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AsynchronousMachineEquivalentCircuit
		 * 
		 * @return UpdateAsynchronousMachineEquivalentCircuitCommand alias
		 */
	protected UpdateAsynchronousMachineEquivalentCircuitCommand generateUpdateCommand() {
	        UpdateAsynchronousMachineEquivalentCircuitCommand command = new UpdateAsynchronousMachineEquivalentCircuitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID asynchronousMachineEquivalentCircuitId = null;
	protected AsynchronousMachineEquivalentCircuitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AsynchronousMachineEquivalentCircuitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAsynchronousMachineEquivalentCircuitList = 0;
}
