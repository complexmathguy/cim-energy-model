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
 * Test WindContPitchAngleIEC class.
 *
 * @author your_name_here
 */
public class WindContPitchAngleIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContPitchAngleIECTest() {
		subscriber = new WindContPitchAngleIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContPitchAngleIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContPitchAngleIEC...");
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
	 * jumpstart the process by instantiating2 WindContPitchAngleIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContPitchAngleIECId = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
		.createWindContPitchAngleIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
				.createWindContPitchAngleIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContPitchAngleIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContPitchAngleIEC : " + successValue.getWindContPitchAngleIECId());
							  if (successValue.getWindContPitchAngleIECId().equals(windContPitchAngleIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContPitchAngleIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContPitchAngleIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPitchAngleIEC consumed")
					);
			subscriber.windContPitchAngleIECSubscribe( windContPitchAngleIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContPitchAngleIEC : " + successValue.getWindContPitchAngleIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContPitchAngleIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPitchAngleIEC for windContPitchAngleIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContPitchAngleIEC. 
	 */
	protected WindContPitchAngleIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContPitchAngleIEC" );

		WindContPitchAngleIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContPitchAngleIEC with primary key" );
		msg.append( windContPitchAngleIECId );
		
		WindContPitchAngleIECFetchOneSummary fetchOneSummary = new WindContPitchAngleIECFetchOneSummary( windContPitchAngleIECId );

		try {
			entity = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().getWindContPitchAngleIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContPitchAngleIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContPitchAngleIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContPitchAngleIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContPitchAngleIEC : " );        
		WindContPitchAngleIEC entity = read();
		UpdateWindContPitchAngleIECCommand command = generateUpdateCommand();
		command.setWindContPitchAngleIECId(entity.getWindContPitchAngleIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContPitchAngleIEC." );

			// for use later on...
			windContPitchAngleIECId = entity.getWindContPitchAngleIECId();

			WindContPitchAngleIECBusinessDelegate proxy = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();  

			proxy.updateWindContPitchAngleIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContPitchAngleIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContPitchAngleIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContPitchAngleIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContPitchAngleIEC." );

		WindContPitchAngleIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContPitchAngleIEC with id " + windContPitchAngleIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContPitchAngleIEC with id " + windContPitchAngleIECId );

			throw e;
		}

		try{
			WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().delete( new DeleteWindContPitchAngleIECCommand( entity.getWindContPitchAngleIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContPitchAngleIEC with id " + windContPitchAngleIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContPitchAngleIEC with id " + windContPitchAngleIECId );

			throw e;
		}
	}

	/**
	 * get all WindContPitchAngleIECs.
	 */
	protected List<WindContPitchAngleIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContPitchAngleIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContPitchAngleIEC : " );        
		List<WindContPitchAngleIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContPitchAngleIECBusinessDelegate
			collection = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().getAllWindContPitchAngleIEC();
			assertNotNull( collection, "An Empty collection of WindContPitchAngleIEC was incorrectly returned.");
			
			// Now print out the values
			WindContPitchAngleIEC entity = null;            
			Iterator<WindContPitchAngleIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContPitchAngleIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContPitchAngleIECTest
	 */
	protected WindContPitchAngleIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContPitchAngleIEC
	 * 
	 * @return CreateWindContPitchAngleIECCommand alias
	 */
	protected CreateWindContPitchAngleIECCommand generateNewCommand() {
        CreateWindContPitchAngleIECCommand command = new CreateWindContPitchAngleIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContPitchAngleIEC
		 * 
		 * @return UpdateWindContPitchAngleIECCommand alias
		 */
	protected UpdateWindContPitchAngleIECCommand generateUpdateCommand() {
	        UpdateWindContPitchAngleIECCommand command = new UpdateWindContPitchAngleIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContPitchAngleIECId = null;
	protected WindContPitchAngleIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContPitchAngleIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContPitchAngleIECList = 0;
}
