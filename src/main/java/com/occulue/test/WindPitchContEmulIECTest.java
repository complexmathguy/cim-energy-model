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
 * Test WindPitchContEmulIEC class.
 *
 * @author your_name_here
 */
public class WindPitchContEmulIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPitchContEmulIECTest() {
		subscriber = new WindPitchContEmulIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPitchContEmulIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPitchContEmulIEC...");
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
	 * jumpstart the process by instantiating2 WindPitchContEmulIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPitchContEmulIECId = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
		.createWindPitchContEmulIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
				.createWindPitchContEmulIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPitchContEmulIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPitchContEmulIEC : " + successValue.getWindPitchContEmulIECId());
							  if (successValue.getWindPitchContEmulIECId().equals(windPitchContEmulIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPitchContEmulIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPitchContEmulIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPitchContEmulIEC consumed")
					);
			subscriber.windPitchContEmulIECSubscribe( windPitchContEmulIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPitchContEmulIEC : " + successValue.getWindPitchContEmulIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPitchContEmulIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPitchContEmulIEC for windPitchContEmulIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPitchContEmulIEC. 
	 */
	protected WindPitchContEmulIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPitchContEmulIEC" );

		WindPitchContEmulIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPitchContEmulIEC with primary key" );
		msg.append( windPitchContEmulIECId );
		
		WindPitchContEmulIECFetchOneSummary fetchOneSummary = new WindPitchContEmulIECFetchOneSummary( windPitchContEmulIECId );

		try {
			entity = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().getWindPitchContEmulIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPitchContEmulIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPitchContEmulIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPitchContEmulIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPitchContEmulIEC : " );        
		WindPitchContEmulIEC entity = read();
		UpdateWindPitchContEmulIECCommand command = generateUpdateCommand();
		command.setWindPitchContEmulIECId(entity.getWindPitchContEmulIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPitchContEmulIEC." );

			// for use later on...
			windPitchContEmulIECId = entity.getWindPitchContEmulIECId();

			WindPitchContEmulIECBusinessDelegate proxy = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();  

			proxy.updateWindPitchContEmulIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindPitchContEmulIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPitchContEmulIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPitchContEmulIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPitchContEmulIEC." );

		WindPitchContEmulIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPitchContEmulIEC with id " + windPitchContEmulIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPitchContEmulIEC with id " + windPitchContEmulIECId );

			throw e;
		}

		try{
			WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().delete( new DeleteWindPitchContEmulIECCommand( entity.getWindPitchContEmulIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPitchContEmulIEC with id " + windPitchContEmulIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPitchContEmulIEC with id " + windPitchContEmulIECId );

			throw e;
		}
	}

	/**
	 * get all WindPitchContEmulIECs.
	 */
	protected List<WindPitchContEmulIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPitchContEmulIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPitchContEmulIEC : " );        
		List<WindPitchContEmulIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPitchContEmulIECBusinessDelegate
			collection = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().getAllWindPitchContEmulIEC();
			assertNotNull( collection, "An Empty collection of WindPitchContEmulIEC was incorrectly returned.");
			
			// Now print out the values
			WindPitchContEmulIEC entity = null;            
			Iterator<WindPitchContEmulIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPitchContEmulIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPitchContEmulIECTest
	 */
	protected WindPitchContEmulIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPitchContEmulIEC
	 * 
	 * @return CreateWindPitchContEmulIECCommand alias
	 */
	protected CreateWindPitchContEmulIECCommand generateNewCommand() {
        CreateWindPitchContEmulIECCommand command = new CreateWindPitchContEmulIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPitchContEmulIEC
		 * 
		 * @return UpdateWindPitchContEmulIECCommand alias
		 */
	protected UpdateWindPitchContEmulIECCommand generateUpdateCommand() {
	        UpdateWindPitchContEmulIECCommand command = new UpdateWindPitchContEmulIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPitchContEmulIECId = null;
	protected WindPitchContEmulIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPitchContEmulIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPitchContEmulIECList = 0;
}
