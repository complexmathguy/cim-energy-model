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
 * Test WindGenTurbineType3IEC class.
 *
 * @author your_name_here
 */
public class WindGenTurbineType3IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenTurbineType3IECTest() {
		subscriber = new WindGenTurbineType3IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenTurbineType3IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenTurbineType3IEC...");
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
	 * jumpstart the process by instantiating2 WindGenTurbineType3IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenTurbineType3IECId = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
		.createWindGenTurbineType3IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
				.createWindGenTurbineType3IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenTurbineType3IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenTurbineType3IEC : " + successValue.getWindGenTurbineType3IECId());
							  if (successValue.getWindGenTurbineType3IECId().equals(windGenTurbineType3IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenTurbineType3IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenTurbineType3IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3IEC consumed")
					);
			subscriber.windGenTurbineType3IECSubscribe( windGenTurbineType3IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenTurbineType3IEC : " + successValue.getWindGenTurbineType3IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenTurbineType3IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3IEC for windGenTurbineType3IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenTurbineType3IEC. 
	 */
	protected WindGenTurbineType3IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenTurbineType3IEC" );

		WindGenTurbineType3IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenTurbineType3IEC with primary key" );
		msg.append( windGenTurbineType3IECId );
		
		WindGenTurbineType3IECFetchOneSummary fetchOneSummary = new WindGenTurbineType3IECFetchOneSummary( windGenTurbineType3IECId );

		try {
			entity = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance().getWindGenTurbineType3IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenTurbineType3IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenTurbineType3IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenTurbineType3IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenTurbineType3IEC : " );        
		WindGenTurbineType3IEC entity = read();
		UpdateWindGenTurbineType3IECCommand command = generateUpdateCommand();
		command.setWindGenTurbineType3IECId(entity.getWindGenTurbineType3IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenTurbineType3IEC." );

			// for use later on...
			windGenTurbineType3IECId = entity.getWindGenTurbineType3IECId();

			WindGenTurbineType3IECBusinessDelegate proxy = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance();  

			proxy.updateWindGenTurbineType3IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenTurbineType3IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenTurbineType3IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenTurbineType3IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenTurbineType3IEC." );

		WindGenTurbineType3IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenTurbineType3IEC with id " + windGenTurbineType3IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenTurbineType3IEC with id " + windGenTurbineType3IECId );

			throw e;
		}

		try{
			WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance().delete( new DeleteWindGenTurbineType3IECCommand( entity.getWindGenTurbineType3IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenTurbineType3IEC with id " + windGenTurbineType3IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenTurbineType3IEC with id " + windGenTurbineType3IECId );

			throw e;
		}
	}

	/**
	 * get all WindGenTurbineType3IECs.
	 */
	protected List<WindGenTurbineType3IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenTurbineType3IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenTurbineType3IEC : " );        
		List<WindGenTurbineType3IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenTurbineType3IECBusinessDelegate
			collection = WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance().getAllWindGenTurbineType3IEC();
			assertNotNull( collection, "An Empty collection of WindGenTurbineType3IEC was incorrectly returned.");
			
			// Now print out the values
			WindGenTurbineType3IEC entity = null;            
			Iterator<WindGenTurbineType3IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenTurbineType3IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenTurbineType3IECTest
	 */
	protected WindGenTurbineType3IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenTurbineType3IEC
	 * 
	 * @return CreateWindGenTurbineType3IECCommand alias
	 */
	protected CreateWindGenTurbineType3IECCommand generateNewCommand() {
        CreateWindGenTurbineType3IECCommand command = new CreateWindGenTurbineType3IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenTurbineType3IEC
		 * 
		 * @return UpdateWindGenTurbineType3IECCommand alias
		 */
	protected UpdateWindGenTurbineType3IECCommand generateUpdateCommand() {
	        UpdateWindGenTurbineType3IECCommand command = new UpdateWindGenTurbineType3IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenTurbineType3IECId = null;
	protected WindGenTurbineType3IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenTurbineType3IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenTurbineType3IECList = 0;
}
