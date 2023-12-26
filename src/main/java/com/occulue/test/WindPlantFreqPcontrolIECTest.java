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
 * Test WindPlantFreqPcontrolIEC class.
 *
 * @author your_name_here
 */
public class WindPlantFreqPcontrolIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPlantFreqPcontrolIECTest() {
		subscriber = new WindPlantFreqPcontrolIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPlantFreqPcontrolIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPlantFreqPcontrolIEC...");
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
	 * jumpstart the process by instantiating2 WindPlantFreqPcontrolIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPlantFreqPcontrolIECId = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
		.createWindPlantFreqPcontrolIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
				.createWindPlantFreqPcontrolIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPlantFreqPcontrolIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPlantFreqPcontrolIEC : " + successValue.getWindPlantFreqPcontrolIECId());
							  if (successValue.getWindPlantFreqPcontrolIECId().equals(windPlantFreqPcontrolIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPlantFreqPcontrolIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPlantFreqPcontrolIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantFreqPcontrolIEC consumed")
					);
			subscriber.windPlantFreqPcontrolIECSubscribe( windPlantFreqPcontrolIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPlantFreqPcontrolIEC : " + successValue.getWindPlantFreqPcontrolIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPlantFreqPcontrolIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantFreqPcontrolIEC for windPlantFreqPcontrolIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPlantFreqPcontrolIEC. 
	 */
	protected WindPlantFreqPcontrolIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPlantFreqPcontrolIEC" );

		WindPlantFreqPcontrolIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPlantFreqPcontrolIEC with primary key" );
		msg.append( windPlantFreqPcontrolIECId );
		
		WindPlantFreqPcontrolIECFetchOneSummary fetchOneSummary = new WindPlantFreqPcontrolIECFetchOneSummary( windPlantFreqPcontrolIECId );

		try {
			entity = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().getWindPlantFreqPcontrolIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPlantFreqPcontrolIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPlantFreqPcontrolIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPlantFreqPcontrolIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPlantFreqPcontrolIEC : " );        
		WindPlantFreqPcontrolIEC entity = read();
		UpdateWindPlantFreqPcontrolIECCommand command = generateUpdateCommand();
		command.setWindPlantFreqPcontrolIECId(entity.getWindPlantFreqPcontrolIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPlantFreqPcontrolIEC." );

			// for use later on...
			windPlantFreqPcontrolIECId = entity.getWindPlantFreqPcontrolIECId();

			WindPlantFreqPcontrolIECBusinessDelegate proxy = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();  

			proxy.updateWindPlantFreqPcontrolIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindPlantFreqPcontrolIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPlantFreqPcontrolIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPlantFreqPcontrolIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPlantFreqPcontrolIEC." );

		WindPlantFreqPcontrolIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPlantFreqPcontrolIEC with id " + windPlantFreqPcontrolIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPlantFreqPcontrolIEC with id " + windPlantFreqPcontrolIECId );

			throw e;
		}

		try{
			WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().delete( new DeleteWindPlantFreqPcontrolIECCommand( entity.getWindPlantFreqPcontrolIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPlantFreqPcontrolIEC with id " + windPlantFreqPcontrolIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPlantFreqPcontrolIEC with id " + windPlantFreqPcontrolIECId );

			throw e;
		}
	}

	/**
	 * get all WindPlantFreqPcontrolIECs.
	 */
	protected List<WindPlantFreqPcontrolIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPlantFreqPcontrolIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPlantFreqPcontrolIEC : " );        
		List<WindPlantFreqPcontrolIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPlantFreqPcontrolIECBusinessDelegate
			collection = WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance().getAllWindPlantFreqPcontrolIEC();
			assertNotNull( collection, "An Empty collection of WindPlantFreqPcontrolIEC was incorrectly returned.");
			
			// Now print out the values
			WindPlantFreqPcontrolIEC entity = null;            
			Iterator<WindPlantFreqPcontrolIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPlantFreqPcontrolIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPlantFreqPcontrolIECTest
	 */
	protected WindPlantFreqPcontrolIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPlantFreqPcontrolIEC
	 * 
	 * @return CreateWindPlantFreqPcontrolIECCommand alias
	 */
	protected CreateWindPlantFreqPcontrolIECCommand generateNewCommand() {
        CreateWindPlantFreqPcontrolIECCommand command = new CreateWindPlantFreqPcontrolIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPlantFreqPcontrolIEC
		 * 
		 * @return UpdateWindPlantFreqPcontrolIECCommand alias
		 */
	protected UpdateWindPlantFreqPcontrolIECCommand generateUpdateCommand() {
	        UpdateWindPlantFreqPcontrolIECCommand command = new UpdateWindPlantFreqPcontrolIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPlantFreqPcontrolIECId = null;
	protected WindPlantFreqPcontrolIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPlantFreqPcontrolIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPlantFreqPcontrolIECList = 0;
}
