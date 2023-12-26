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
 * Test CoordinateSystem class.
 *
 * @author your_name_here
 */
public class CoordinateSystemTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CoordinateSystemTest() {
		subscriber = new CoordinateSystemSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CoordinateSystemTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CoordinateSystem...");
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
	 * jumpstart the process by instantiating2 CoordinateSystem
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		coordinateSystemId = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance()
		.createCoordinateSystem( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CoordinateSystemBusinessDelegate.getCoordinateSystemInstance()
				.createCoordinateSystem( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.coordinateSystemSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CoordinateSystem : " + successValue.getCoordinateSystemId());
							  if (successValue.getCoordinateSystemId().equals(coordinateSystemId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCoordinateSystemList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CoordinateSystem test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on coordinateSystem consumed")
					);
			subscriber.coordinateSystemSubscribe( coordinateSystemId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CoordinateSystem : " + successValue.getCoordinateSystemId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCoordinateSystemList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on coordinateSystem for coordinateSystemId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CoordinateSystem. 
	 */
	protected CoordinateSystem read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CoordinateSystem" );

		CoordinateSystem entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CoordinateSystem with primary key" );
		msg.append( coordinateSystemId );
		
		CoordinateSystemFetchOneSummary fetchOneSummary = new CoordinateSystemFetchOneSummary( coordinateSystemId );

		try {
			entity = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().getCoordinateSystem( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CoordinateSystem " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CoordinateSystem.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CoordinateSystem." );

		StringBuilder msg = new StringBuilder( "Failed to update a CoordinateSystem : " );        
		CoordinateSystem entity = read();
		UpdateCoordinateSystemCommand command = generateUpdateCommand();
		command.setCoordinateSystemId(entity.getCoordinateSystemId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CoordinateSystem." );

			// for use later on...
			coordinateSystemId = entity.getCoordinateSystemId();

			CoordinateSystemBusinessDelegate proxy = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance();  

			proxy.updateCoordinateSystem( command ).get();

			LOGGER.info( "-- Successfully saved CoordinateSystem - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + coordinateSystemId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CoordinateSystem.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CoordinateSystem." );

		CoordinateSystem entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CoordinateSystem with id " + coordinateSystemId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CoordinateSystem with id " + coordinateSystemId );

			throw e;
		}

		try{
			CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().delete( new DeleteCoordinateSystemCommand( entity.getCoordinateSystemId() ) ).get();
			LOGGER.info( "-- Successfully deleted CoordinateSystem with id " + coordinateSystemId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CoordinateSystem with id " + coordinateSystemId );

			throw e;
		}
	}

	/**
	 * get all CoordinateSystems.
	 */
	protected List<CoordinateSystem> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CoordinateSystems:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CoordinateSystem : " );        
		List<CoordinateSystem> collection  = new ArrayList<>();

		try {
			// call the static get method on the CoordinateSystemBusinessDelegate
			collection = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().getAllCoordinateSystem();
			assertNotNull( collection, "An Empty collection of CoordinateSystem was incorrectly returned.");
			
			// Now print out the values
			CoordinateSystem entity = null;            
			Iterator<CoordinateSystem> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCoordinateSystemId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CoordinateSystemTest
	 */
	protected CoordinateSystemTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CoordinateSystem
	 * 
	 * @return CreateCoordinateSystemCommand alias
	 */
	protected CreateCoordinateSystemCommand generateNewCommand() {
        CreateCoordinateSystemCommand command = new CreateCoordinateSystemCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CoordinateSystem
		 * 
		 * @return UpdateCoordinateSystemCommand alias
		 */
	protected UpdateCoordinateSystemCommand generateUpdateCommand() {
	        UpdateCoordinateSystemCommand command = new UpdateCoordinateSystemCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID coordinateSystemId = null;
	protected CoordinateSystemSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CoordinateSystemTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCoordinateSystemList = 0;
}
