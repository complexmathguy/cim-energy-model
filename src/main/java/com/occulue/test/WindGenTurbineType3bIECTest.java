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
 * Test WindGenTurbineType3bIEC class.
 *
 * @author your_name_here
 */
public class WindGenTurbineType3bIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenTurbineType3bIECTest() {
		subscriber = new WindGenTurbineType3bIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenTurbineType3bIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenTurbineType3bIEC...");
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
	 * jumpstart the process by instantiating2 WindGenTurbineType3bIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenTurbineType3bIECId = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
		.createWindGenTurbineType3bIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
				.createWindGenTurbineType3bIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenTurbineType3bIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenTurbineType3bIEC : " + successValue.getWindGenTurbineType3bIECId());
							  if (successValue.getWindGenTurbineType3bIECId().equals(windGenTurbineType3bIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenTurbineType3bIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenTurbineType3bIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3bIEC consumed")
					);
			subscriber.windGenTurbineType3bIECSubscribe( windGenTurbineType3bIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenTurbineType3bIEC : " + successValue.getWindGenTurbineType3bIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenTurbineType3bIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3bIEC for windGenTurbineType3bIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenTurbineType3bIEC. 
	 */
	protected WindGenTurbineType3bIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenTurbineType3bIEC" );

		WindGenTurbineType3bIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenTurbineType3bIEC with primary key" );
		msg.append( windGenTurbineType3bIECId );
		
		WindGenTurbineType3bIECFetchOneSummary fetchOneSummary = new WindGenTurbineType3bIECFetchOneSummary( windGenTurbineType3bIECId );

		try {
			entity = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().getWindGenTurbineType3bIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenTurbineType3bIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenTurbineType3bIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenTurbineType3bIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenTurbineType3bIEC : " );        
		WindGenTurbineType3bIEC entity = read();
		UpdateWindGenTurbineType3bIECCommand command = generateUpdateCommand();
		command.setWindGenTurbineType3bIECId(entity.getWindGenTurbineType3bIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenTurbineType3bIEC." );

			// for use later on...
			windGenTurbineType3bIECId = entity.getWindGenTurbineType3bIECId();

			WindGenTurbineType3bIECBusinessDelegate proxy = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();  

			proxy.updateWindGenTurbineType3bIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenTurbineType3bIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenTurbineType3bIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenTurbineType3bIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenTurbineType3bIEC." );

		WindGenTurbineType3bIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenTurbineType3bIEC with id " + windGenTurbineType3bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenTurbineType3bIEC with id " + windGenTurbineType3bIECId );

			throw e;
		}

		try{
			WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().delete( new DeleteWindGenTurbineType3bIECCommand( entity.getWindGenTurbineType3bIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenTurbineType3bIEC with id " + windGenTurbineType3bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenTurbineType3bIEC with id " + windGenTurbineType3bIECId );

			throw e;
		}
	}

	/**
	 * get all WindGenTurbineType3bIECs.
	 */
	protected List<WindGenTurbineType3bIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenTurbineType3bIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenTurbineType3bIEC : " );        
		List<WindGenTurbineType3bIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenTurbineType3bIECBusinessDelegate
			collection = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().getAllWindGenTurbineType3bIEC();
			assertNotNull( collection, "An Empty collection of WindGenTurbineType3bIEC was incorrectly returned.");
			
			// Now print out the values
			WindGenTurbineType3bIEC entity = null;            
			Iterator<WindGenTurbineType3bIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenTurbineType3bIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenTurbineType3bIECTest
	 */
	protected WindGenTurbineType3bIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenTurbineType3bIEC
	 * 
	 * @return CreateWindGenTurbineType3bIECCommand alias
	 */
	protected CreateWindGenTurbineType3bIECCommand generateNewCommand() {
        CreateWindGenTurbineType3bIECCommand command = new CreateWindGenTurbineType3bIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenTurbineType3bIEC
		 * 
		 * @return UpdateWindGenTurbineType3bIECCommand alias
		 */
	protected UpdateWindGenTurbineType3bIECCommand generateUpdateCommand() {
	        UpdateWindGenTurbineType3bIECCommand command = new UpdateWindGenTurbineType3bIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenTurbineType3bIECId = null;
	protected WindGenTurbineType3bIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenTurbineType3bIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenTurbineType3bIECList = 0;
}
