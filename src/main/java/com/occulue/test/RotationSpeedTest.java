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
 * Test RotationSpeed class.
 *
 * @author your_name_here
 */
public class RotationSpeedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RotationSpeedTest() {
		subscriber = new RotationSpeedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RotationSpeedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RotationSpeed...");
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
	 * jumpstart the process by instantiating2 RotationSpeed
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		rotationSpeedId = RotationSpeedBusinessDelegate.getRotationSpeedInstance()
		.createRotationSpeed( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RotationSpeedBusinessDelegate.getRotationSpeedInstance()
				.createRotationSpeed( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.rotationSpeedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RotationSpeed : " + successValue.getRotationSpeedId());
							  if (successValue.getRotationSpeedId().equals(rotationSpeedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRotationSpeedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RotationSpeed test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotationSpeed consumed")
					);
			subscriber.rotationSpeedSubscribe( rotationSpeedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RotationSpeed : " + successValue.getRotationSpeedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRotationSpeedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotationSpeed for rotationSpeedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RotationSpeed. 
	 */
	protected RotationSpeed read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RotationSpeed" );

		RotationSpeed entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RotationSpeed with primary key" );
		msg.append( rotationSpeedId );
		
		RotationSpeedFetchOneSummary fetchOneSummary = new RotationSpeedFetchOneSummary( rotationSpeedId );

		try {
			entity = RotationSpeedBusinessDelegate.getRotationSpeedInstance().getRotationSpeed( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RotationSpeed " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RotationSpeed.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RotationSpeed." );

		StringBuilder msg = new StringBuilder( "Failed to update a RotationSpeed : " );        
		RotationSpeed entity = read();
		UpdateRotationSpeedCommand command = generateUpdateCommand();
		command.setRotationSpeedId(entity.getRotationSpeedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RotationSpeed." );

			// for use later on...
			rotationSpeedId = entity.getRotationSpeedId();

			RotationSpeedBusinessDelegate proxy = RotationSpeedBusinessDelegate.getRotationSpeedInstance();  

			proxy.updateRotationSpeed( command ).get();

			LOGGER.info( "-- Successfully saved RotationSpeed - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + rotationSpeedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RotationSpeed.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RotationSpeed." );

		RotationSpeed entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RotationSpeed with id " + rotationSpeedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RotationSpeed with id " + rotationSpeedId );

			throw e;
		}

		try{
			RotationSpeedBusinessDelegate.getRotationSpeedInstance().delete( new DeleteRotationSpeedCommand( entity.getRotationSpeedId() ) ).get();
			LOGGER.info( "-- Successfully deleted RotationSpeed with id " + rotationSpeedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RotationSpeed with id " + rotationSpeedId );

			throw e;
		}
	}

	/**
	 * get all RotationSpeeds.
	 */
	protected List<RotationSpeed> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RotationSpeeds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RotationSpeed : " );        
		List<RotationSpeed> collection  = new ArrayList<>();

		try {
			// call the static get method on the RotationSpeedBusinessDelegate
			collection = RotationSpeedBusinessDelegate.getRotationSpeedInstance().getAllRotationSpeed();
			assertNotNull( collection, "An Empty collection of RotationSpeed was incorrectly returned.");
			
			// Now print out the values
			RotationSpeed entity = null;            
			Iterator<RotationSpeed> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRotationSpeedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RotationSpeedTest
	 */
	protected RotationSpeedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RotationSpeed
	 * 
	 * @return CreateRotationSpeedCommand alias
	 */
	protected CreateRotationSpeedCommand generateNewCommand() {
        CreateRotationSpeedCommand command = new CreateRotationSpeedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RotationSpeed
		 * 
		 * @return UpdateRotationSpeedCommand alias
		 */
	protected UpdateRotationSpeedCommand generateUpdateCommand() {
	        UpdateRotationSpeedCommand command = new UpdateRotationSpeedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID rotationSpeedId = null;
	protected RotationSpeedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RotationSpeedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRotationSpeedList = 0;
}
