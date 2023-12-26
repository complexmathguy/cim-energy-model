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
 * Test WindPlantReactiveControlIEC class.
 *
 * @author your_name_here
 */
public class WindPlantReactiveControlIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPlantReactiveControlIECTest() {
		subscriber = new WindPlantReactiveControlIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPlantReactiveControlIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPlantReactiveControlIEC...");
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
	 * jumpstart the process by instantiating2 WindPlantReactiveControlIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPlantReactiveControlIECId = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
		.createWindPlantReactiveControlIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
				.createWindPlantReactiveControlIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPlantReactiveControlIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPlantReactiveControlIEC : " + successValue.getWindPlantReactiveControlIECId());
							  if (successValue.getWindPlantReactiveControlIECId().equals(windPlantReactiveControlIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPlantReactiveControlIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPlantReactiveControlIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantReactiveControlIEC consumed")
					);
			subscriber.windPlantReactiveControlIECSubscribe( windPlantReactiveControlIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPlantReactiveControlIEC : " + successValue.getWindPlantReactiveControlIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPlantReactiveControlIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantReactiveControlIEC for windPlantReactiveControlIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPlantReactiveControlIEC. 
	 */
	protected WindPlantReactiveControlIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPlantReactiveControlIEC" );

		WindPlantReactiveControlIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPlantReactiveControlIEC with primary key" );
		msg.append( windPlantReactiveControlIECId );
		
		WindPlantReactiveControlIECFetchOneSummary fetchOneSummary = new WindPlantReactiveControlIECFetchOneSummary( windPlantReactiveControlIECId );

		try {
			entity = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().getWindPlantReactiveControlIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPlantReactiveControlIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPlantReactiveControlIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPlantReactiveControlIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPlantReactiveControlIEC : " );        
		WindPlantReactiveControlIEC entity = read();
		UpdateWindPlantReactiveControlIECCommand command = generateUpdateCommand();
		command.setWindPlantReactiveControlIECId(entity.getWindPlantReactiveControlIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPlantReactiveControlIEC." );

			// for use later on...
			windPlantReactiveControlIECId = entity.getWindPlantReactiveControlIECId();

			WindPlantReactiveControlIECBusinessDelegate proxy = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();  

			proxy.updateWindPlantReactiveControlIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindPlantReactiveControlIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPlantReactiveControlIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPlantReactiveControlIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPlantReactiveControlIEC." );

		WindPlantReactiveControlIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPlantReactiveControlIEC with id " + windPlantReactiveControlIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPlantReactiveControlIEC with id " + windPlantReactiveControlIECId );

			throw e;
		}

		try{
			WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().delete( new DeleteWindPlantReactiveControlIECCommand( entity.getWindPlantReactiveControlIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPlantReactiveControlIEC with id " + windPlantReactiveControlIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPlantReactiveControlIEC with id " + windPlantReactiveControlIECId );

			throw e;
		}
	}

	/**
	 * get all WindPlantReactiveControlIECs.
	 */
	protected List<WindPlantReactiveControlIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPlantReactiveControlIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPlantReactiveControlIEC : " );        
		List<WindPlantReactiveControlIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPlantReactiveControlIECBusinessDelegate
			collection = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().getAllWindPlantReactiveControlIEC();
			assertNotNull( collection, "An Empty collection of WindPlantReactiveControlIEC was incorrectly returned.");
			
			// Now print out the values
			WindPlantReactiveControlIEC entity = null;            
			Iterator<WindPlantReactiveControlIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPlantReactiveControlIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPlantReactiveControlIECTest
	 */
	protected WindPlantReactiveControlIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPlantReactiveControlIEC
	 * 
	 * @return CreateWindPlantReactiveControlIECCommand alias
	 */
	protected CreateWindPlantReactiveControlIECCommand generateNewCommand() {
        CreateWindPlantReactiveControlIECCommand command = new CreateWindPlantReactiveControlIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPlantReactiveControlIEC
		 * 
		 * @return UpdateWindPlantReactiveControlIECCommand alias
		 */
	protected UpdateWindPlantReactiveControlIECCommand generateUpdateCommand() {
	        UpdateWindPlantReactiveControlIECCommand command = new UpdateWindPlantReactiveControlIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPlantReactiveControlIECId = null;
	protected WindPlantReactiveControlIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPlantReactiveControlIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPlantReactiveControlIECList = 0;
}
