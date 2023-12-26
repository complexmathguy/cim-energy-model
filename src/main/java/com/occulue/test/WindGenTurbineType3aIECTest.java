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
 * Test WindGenTurbineType3aIEC class.
 *
 * @author your_name_here
 */
public class WindGenTurbineType3aIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenTurbineType3aIECTest() {
		subscriber = new WindGenTurbineType3aIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenTurbineType3aIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenTurbineType3aIEC...");
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
	 * jumpstart the process by instantiating2 WindGenTurbineType3aIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenTurbineType3aIECId = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
		.createWindGenTurbineType3aIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
				.createWindGenTurbineType3aIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenTurbineType3aIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenTurbineType3aIEC : " + successValue.getWindGenTurbineType3aIECId());
							  if (successValue.getWindGenTurbineType3aIECId().equals(windGenTurbineType3aIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenTurbineType3aIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenTurbineType3aIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3aIEC consumed")
					);
			subscriber.windGenTurbineType3aIECSubscribe( windGenTurbineType3aIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenTurbineType3aIEC : " + successValue.getWindGenTurbineType3aIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenTurbineType3aIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType3aIEC for windGenTurbineType3aIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenTurbineType3aIEC. 
	 */
	protected WindGenTurbineType3aIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenTurbineType3aIEC" );

		WindGenTurbineType3aIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenTurbineType3aIEC with primary key" );
		msg.append( windGenTurbineType3aIECId );
		
		WindGenTurbineType3aIECFetchOneSummary fetchOneSummary = new WindGenTurbineType3aIECFetchOneSummary( windGenTurbineType3aIECId );

		try {
			entity = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().getWindGenTurbineType3aIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenTurbineType3aIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenTurbineType3aIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenTurbineType3aIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenTurbineType3aIEC : " );        
		WindGenTurbineType3aIEC entity = read();
		UpdateWindGenTurbineType3aIECCommand command = generateUpdateCommand();
		command.setWindGenTurbineType3aIECId(entity.getWindGenTurbineType3aIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenTurbineType3aIEC." );

			// for use later on...
			windGenTurbineType3aIECId = entity.getWindGenTurbineType3aIECId();

			WindGenTurbineType3aIECBusinessDelegate proxy = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();  

			proxy.updateWindGenTurbineType3aIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenTurbineType3aIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenTurbineType3aIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenTurbineType3aIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenTurbineType3aIEC." );

		WindGenTurbineType3aIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenTurbineType3aIEC with id " + windGenTurbineType3aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenTurbineType3aIEC with id " + windGenTurbineType3aIECId );

			throw e;
		}

		try{
			WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().delete( new DeleteWindGenTurbineType3aIECCommand( entity.getWindGenTurbineType3aIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenTurbineType3aIEC with id " + windGenTurbineType3aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenTurbineType3aIEC with id " + windGenTurbineType3aIECId );

			throw e;
		}
	}

	/**
	 * get all WindGenTurbineType3aIECs.
	 */
	protected List<WindGenTurbineType3aIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenTurbineType3aIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenTurbineType3aIEC : " );        
		List<WindGenTurbineType3aIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenTurbineType3aIECBusinessDelegate
			collection = WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance().getAllWindGenTurbineType3aIEC();
			assertNotNull( collection, "An Empty collection of WindGenTurbineType3aIEC was incorrectly returned.");
			
			// Now print out the values
			WindGenTurbineType3aIEC entity = null;            
			Iterator<WindGenTurbineType3aIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenTurbineType3aIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenTurbineType3aIECTest
	 */
	protected WindGenTurbineType3aIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenTurbineType3aIEC
	 * 
	 * @return CreateWindGenTurbineType3aIECCommand alias
	 */
	protected CreateWindGenTurbineType3aIECCommand generateNewCommand() {
        CreateWindGenTurbineType3aIECCommand command = new CreateWindGenTurbineType3aIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenTurbineType3aIEC
		 * 
		 * @return UpdateWindGenTurbineType3aIECCommand alias
		 */
	protected UpdateWindGenTurbineType3aIECCommand generateUpdateCommand() {
	        UpdateWindGenTurbineType3aIECCommand command = new UpdateWindGenTurbineType3aIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenTurbineType3aIECId = null;
	protected WindGenTurbineType3aIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenTurbineType3aIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenTurbineType3aIECList = 0;
}
