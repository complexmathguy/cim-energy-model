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
 * Test StateVariablesVersion class.
 *
 * @author your_name_here
 */
public class StateVariablesVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StateVariablesVersionTest() {
		subscriber = new StateVariablesVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StateVariablesVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StateVariablesVersion...");
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
	 * jumpstart the process by instantiating2 StateVariablesVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		stateVariablesVersionId = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
		.createStateVariablesVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
				.createStateVariablesVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.stateVariablesVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StateVariablesVersion : " + successValue.getStateVariablesVersionId());
							  if (successValue.getStateVariablesVersionId().equals(stateVariablesVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStateVariablesVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StateVariablesVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stateVariablesVersion consumed")
					);
			subscriber.stateVariablesVersionSubscribe( stateVariablesVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StateVariablesVersion : " + successValue.getStateVariablesVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStateVariablesVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stateVariablesVersion for stateVariablesVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StateVariablesVersion. 
	 */
	protected StateVariablesVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StateVariablesVersion" );

		StateVariablesVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StateVariablesVersion with primary key" );
		msg.append( stateVariablesVersionId );
		
		StateVariablesVersionFetchOneSummary fetchOneSummary = new StateVariablesVersionFetchOneSummary( stateVariablesVersionId );

		try {
			entity = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().getStateVariablesVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StateVariablesVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StateVariablesVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StateVariablesVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a StateVariablesVersion : " );        
		StateVariablesVersion entity = read();
		UpdateStateVariablesVersionCommand command = generateUpdateCommand();
		command.setStateVariablesVersionId(entity.getStateVariablesVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StateVariablesVersion." );

			// for use later on...
			stateVariablesVersionId = entity.getStateVariablesVersionId();

			StateVariablesVersionBusinessDelegate proxy = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance();  

			proxy.updateStateVariablesVersion( command ).get();

			LOGGER.info( "-- Successfully saved StateVariablesVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + stateVariablesVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StateVariablesVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StateVariablesVersion." );

		StateVariablesVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StateVariablesVersion with id " + stateVariablesVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StateVariablesVersion with id " + stateVariablesVersionId );

			throw e;
		}

		try{
			StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().delete( new DeleteStateVariablesVersionCommand( entity.getStateVariablesVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted StateVariablesVersion with id " + stateVariablesVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StateVariablesVersion with id " + stateVariablesVersionId );

			throw e;
		}
	}

	/**
	 * get all StateVariablesVersions.
	 */
	protected List<StateVariablesVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StateVariablesVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StateVariablesVersion : " );        
		List<StateVariablesVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the StateVariablesVersionBusinessDelegate
			collection = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().getAllStateVariablesVersion();
			assertNotNull( collection, "An Empty collection of StateVariablesVersion was incorrectly returned.");
			
			// Now print out the values
			StateVariablesVersion entity = null;            
			Iterator<StateVariablesVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStateVariablesVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StateVariablesVersionTest
	 */
	protected StateVariablesVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StateVariablesVersion
	 * 
	 * @return CreateStateVariablesVersionCommand alias
	 */
	protected CreateStateVariablesVersionCommand generateNewCommand() {
        CreateStateVariablesVersionCommand command = new CreateStateVariablesVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated StateVariablesVersion
		 * 
		 * @return UpdateStateVariablesVersionCommand alias
		 */
	protected UpdateStateVariablesVersionCommand generateUpdateCommand() {
	        UpdateStateVariablesVersionCommand command = new UpdateStateVariablesVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID stateVariablesVersionId = null;
	protected StateVariablesVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StateVariablesVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStateVariablesVersionList = 0;
}
