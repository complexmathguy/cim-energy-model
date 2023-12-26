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
 * Test SynchronousMachineEquivalentCircuit class.
 *
 * @author your_name_here
 */
public class SynchronousMachineEquivalentCircuitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineEquivalentCircuitTest() {
		subscriber = new SynchronousMachineEquivalentCircuitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineEquivalentCircuitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineEquivalentCircuit...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineEquivalentCircuit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineEquivalentCircuitId = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance()
		.createSynchronousMachineEquivalentCircuit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance()
				.createSynchronousMachineEquivalentCircuit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineEquivalentCircuitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineEquivalentCircuit : " + successValue.getSynchronousMachineEquivalentCircuitId());
							  if (successValue.getSynchronousMachineEquivalentCircuitId().equals(synchronousMachineEquivalentCircuitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineEquivalentCircuitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineEquivalentCircuit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineEquivalentCircuit consumed")
					);
			subscriber.synchronousMachineEquivalentCircuitSubscribe( synchronousMachineEquivalentCircuitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineEquivalentCircuit : " + successValue.getSynchronousMachineEquivalentCircuitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineEquivalentCircuitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineEquivalentCircuit for synchronousMachineEquivalentCircuitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineEquivalentCircuit. 
	 */
	protected SynchronousMachineEquivalentCircuit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineEquivalentCircuit" );

		SynchronousMachineEquivalentCircuit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineEquivalentCircuit with primary key" );
		msg.append( synchronousMachineEquivalentCircuitId );
		
		SynchronousMachineEquivalentCircuitFetchOneSummary fetchOneSummary = new SynchronousMachineEquivalentCircuitFetchOneSummary( synchronousMachineEquivalentCircuitId );

		try {
			entity = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().getSynchronousMachineEquivalentCircuit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineEquivalentCircuit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineEquivalentCircuit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineEquivalentCircuit." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineEquivalentCircuit : " );        
		SynchronousMachineEquivalentCircuit entity = read();
		UpdateSynchronousMachineEquivalentCircuitCommand command = generateUpdateCommand();
		command.setSynchronousMachineEquivalentCircuitId(entity.getSynchronousMachineEquivalentCircuitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineEquivalentCircuit." );

			// for use later on...
			synchronousMachineEquivalentCircuitId = entity.getSynchronousMachineEquivalentCircuitId();

			SynchronousMachineEquivalentCircuitBusinessDelegate proxy = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance();  

			proxy.updateSynchronousMachineEquivalentCircuit( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineEquivalentCircuit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineEquivalentCircuitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineEquivalentCircuit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineEquivalentCircuit." );

		SynchronousMachineEquivalentCircuit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineEquivalentCircuit with id " + synchronousMachineEquivalentCircuitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineEquivalentCircuit with id " + synchronousMachineEquivalentCircuitId );

			throw e;
		}

		try{
			SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().delete( new DeleteSynchronousMachineEquivalentCircuitCommand( entity.getSynchronousMachineEquivalentCircuitId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineEquivalentCircuit with id " + synchronousMachineEquivalentCircuitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineEquivalentCircuit with id " + synchronousMachineEquivalentCircuitId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineEquivalentCircuits.
	 */
	protected List<SynchronousMachineEquivalentCircuit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineEquivalentCircuits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineEquivalentCircuit : " );        
		List<SynchronousMachineEquivalentCircuit> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineEquivalentCircuitBusinessDelegate
			collection = SynchronousMachineEquivalentCircuitBusinessDelegate.getSynchronousMachineEquivalentCircuitInstance().getAllSynchronousMachineEquivalentCircuit();
			assertNotNull( collection, "An Empty collection of SynchronousMachineEquivalentCircuit was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineEquivalentCircuit entity = null;            
			Iterator<SynchronousMachineEquivalentCircuit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineEquivalentCircuitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineEquivalentCircuitTest
	 */
	protected SynchronousMachineEquivalentCircuitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineEquivalentCircuit
	 * 
	 * @return CreateSynchronousMachineEquivalentCircuitCommand alias
	 */
	protected CreateSynchronousMachineEquivalentCircuitCommand generateNewCommand() {
        CreateSynchronousMachineEquivalentCircuitCommand command = new CreateSynchronousMachineEquivalentCircuitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineEquivalentCircuit
		 * 
		 * @return UpdateSynchronousMachineEquivalentCircuitCommand alias
		 */
	protected UpdateSynchronousMachineEquivalentCircuitCommand generateUpdateCommand() {
	        UpdateSynchronousMachineEquivalentCircuitCommand command = new UpdateSynchronousMachineEquivalentCircuitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineEquivalentCircuitId = null;
	protected SynchronousMachineEquivalentCircuitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineEquivalentCircuitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineEquivalentCircuitList = 0;
}
