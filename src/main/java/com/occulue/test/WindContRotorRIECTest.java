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
 * Test WindContRotorRIEC class.
 *
 * @author your_name_here
 */
public class WindContRotorRIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContRotorRIECTest() {
		subscriber = new WindContRotorRIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContRotorRIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContRotorRIEC...");
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
	 * jumpstart the process by instantiating2 WindContRotorRIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContRotorRIECId = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance()
		.createWindContRotorRIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance()
				.createWindContRotorRIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContRotorRIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContRotorRIEC : " + successValue.getWindContRotorRIECId());
							  if (successValue.getWindContRotorRIECId().equals(windContRotorRIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContRotorRIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContRotorRIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContRotorRIEC consumed")
					);
			subscriber.windContRotorRIECSubscribe( windContRotorRIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContRotorRIEC : " + successValue.getWindContRotorRIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContRotorRIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContRotorRIEC for windContRotorRIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContRotorRIEC. 
	 */
	protected WindContRotorRIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContRotorRIEC" );

		WindContRotorRIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContRotorRIEC with primary key" );
		msg.append( windContRotorRIECId );
		
		WindContRotorRIECFetchOneSummary fetchOneSummary = new WindContRotorRIECFetchOneSummary( windContRotorRIECId );

		try {
			entity = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().getWindContRotorRIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContRotorRIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContRotorRIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContRotorRIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContRotorRIEC : " );        
		WindContRotorRIEC entity = read();
		UpdateWindContRotorRIECCommand command = generateUpdateCommand();
		command.setWindContRotorRIECId(entity.getWindContRotorRIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContRotorRIEC." );

			// for use later on...
			windContRotorRIECId = entity.getWindContRotorRIECId();

			WindContRotorRIECBusinessDelegate proxy = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();  

			proxy.updateWindContRotorRIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContRotorRIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContRotorRIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContRotorRIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContRotorRIEC." );

		WindContRotorRIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContRotorRIEC with id " + windContRotorRIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContRotorRIEC with id " + windContRotorRIECId );

			throw e;
		}

		try{
			WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().delete( new DeleteWindContRotorRIECCommand( entity.getWindContRotorRIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContRotorRIEC with id " + windContRotorRIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContRotorRIEC with id " + windContRotorRIECId );

			throw e;
		}
	}

	/**
	 * get all WindContRotorRIECs.
	 */
	protected List<WindContRotorRIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContRotorRIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContRotorRIEC : " );        
		List<WindContRotorRIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContRotorRIECBusinessDelegate
			collection = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().getAllWindContRotorRIEC();
			assertNotNull( collection, "An Empty collection of WindContRotorRIEC was incorrectly returned.");
			
			// Now print out the values
			WindContRotorRIEC entity = null;            
			Iterator<WindContRotorRIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContRotorRIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContRotorRIECTest
	 */
	protected WindContRotorRIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContRotorRIEC
	 * 
	 * @return CreateWindContRotorRIECCommand alias
	 */
	protected CreateWindContRotorRIECCommand generateNewCommand() {
        CreateWindContRotorRIECCommand command = new CreateWindContRotorRIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContRotorRIEC
		 * 
		 * @return UpdateWindContRotorRIECCommand alias
		 */
	protected UpdateWindContRotorRIECCommand generateUpdateCommand() {
	        UpdateWindContRotorRIECCommand command = new UpdateWindContRotorRIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContRotorRIECId = null;
	protected WindContRotorRIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContRotorRIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContRotorRIECList = 0;
}
