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
 * Test SynchronousMachineTimeConstantReactance class.
 *
 * @author your_name_here
 */
public class SynchronousMachineTimeConstantReactanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineTimeConstantReactanceTest() {
		subscriber = new SynchronousMachineTimeConstantReactanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineTimeConstantReactanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineTimeConstantReactance...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineTimeConstantReactance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineTimeConstantReactanceId = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance()
		.createSynchronousMachineTimeConstantReactance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance()
				.createSynchronousMachineTimeConstantReactance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineTimeConstantReactanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineTimeConstantReactance : " + successValue.getSynchronousMachineTimeConstantReactanceId());
							  if (successValue.getSynchronousMachineTimeConstantReactanceId().equals(synchronousMachineTimeConstantReactanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineTimeConstantReactanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineTimeConstantReactance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineTimeConstantReactance consumed")
					);
			subscriber.synchronousMachineTimeConstantReactanceSubscribe( synchronousMachineTimeConstantReactanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineTimeConstantReactance : " + successValue.getSynchronousMachineTimeConstantReactanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineTimeConstantReactanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineTimeConstantReactance for synchronousMachineTimeConstantReactanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineTimeConstantReactance. 
	 */
	protected SynchronousMachineTimeConstantReactance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineTimeConstantReactance" );

		SynchronousMachineTimeConstantReactance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineTimeConstantReactance with primary key" );
		msg.append( synchronousMachineTimeConstantReactanceId );
		
		SynchronousMachineTimeConstantReactanceFetchOneSummary fetchOneSummary = new SynchronousMachineTimeConstantReactanceFetchOneSummary( synchronousMachineTimeConstantReactanceId );

		try {
			entity = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().getSynchronousMachineTimeConstantReactance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineTimeConstantReactance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineTimeConstantReactance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineTimeConstantReactance." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineTimeConstantReactance : " );        
		SynchronousMachineTimeConstantReactance entity = read();
		UpdateSynchronousMachineTimeConstantReactanceCommand command = generateUpdateCommand();
		command.setSynchronousMachineTimeConstantReactanceId(entity.getSynchronousMachineTimeConstantReactanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineTimeConstantReactance." );

			// for use later on...
			synchronousMachineTimeConstantReactanceId = entity.getSynchronousMachineTimeConstantReactanceId();

			SynchronousMachineTimeConstantReactanceBusinessDelegate proxy = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance();  

			proxy.updateSynchronousMachineTimeConstantReactance( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineTimeConstantReactance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineTimeConstantReactanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineTimeConstantReactance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineTimeConstantReactance." );

		SynchronousMachineTimeConstantReactance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineTimeConstantReactance with id " + synchronousMachineTimeConstantReactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineTimeConstantReactance with id " + synchronousMachineTimeConstantReactanceId );

			throw e;
		}

		try{
			SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().delete( new DeleteSynchronousMachineTimeConstantReactanceCommand( entity.getSynchronousMachineTimeConstantReactanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineTimeConstantReactance with id " + synchronousMachineTimeConstantReactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineTimeConstantReactance with id " + synchronousMachineTimeConstantReactanceId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineTimeConstantReactances.
	 */
	protected List<SynchronousMachineTimeConstantReactance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineTimeConstantReactances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineTimeConstantReactance : " );        
		List<SynchronousMachineTimeConstantReactance> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineTimeConstantReactanceBusinessDelegate
			collection = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().getAllSynchronousMachineTimeConstantReactance();
			assertNotNull( collection, "An Empty collection of SynchronousMachineTimeConstantReactance was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineTimeConstantReactance entity = null;            
			Iterator<SynchronousMachineTimeConstantReactance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineTimeConstantReactanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineTimeConstantReactanceTest
	 */
	protected SynchronousMachineTimeConstantReactanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineTimeConstantReactance
	 * 
	 * @return CreateSynchronousMachineTimeConstantReactanceCommand alias
	 */
	protected CreateSynchronousMachineTimeConstantReactanceCommand generateNewCommand() {
        CreateSynchronousMachineTimeConstantReactanceCommand command = new CreateSynchronousMachineTimeConstantReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineTimeConstantReactance
		 * 
		 * @return UpdateSynchronousMachineTimeConstantReactanceCommand alias
		 */
	protected UpdateSynchronousMachineTimeConstantReactanceCommand generateUpdateCommand() {
	        UpdateSynchronousMachineTimeConstantReactanceCommand command = new UpdateSynchronousMachineTimeConstantReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineTimeConstantReactanceId = null;
	protected SynchronousMachineTimeConstantReactanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineTimeConstantReactanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineTimeConstantReactanceList = 0;
}
