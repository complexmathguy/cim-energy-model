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
 * Test WindContPType3IEC class.
 *
 * @author your_name_here
 */
public class WindContPType3IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContPType3IECTest() {
		subscriber = new WindContPType3IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContPType3IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContPType3IEC...");
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
	 * jumpstart the process by instantiating2 WindContPType3IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContPType3IECId = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance()
		.createWindContPType3IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContPType3IECBusinessDelegate.getWindContPType3IECInstance()
				.createWindContPType3IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContPType3IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContPType3IEC : " + successValue.getWindContPType3IECId());
							  if (successValue.getWindContPType3IECId().equals(windContPType3IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContPType3IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContPType3IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType3IEC consumed")
					);
			subscriber.windContPType3IECSubscribe( windContPType3IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContPType3IEC : " + successValue.getWindContPType3IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContPType3IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType3IEC for windContPType3IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContPType3IEC. 
	 */
	protected WindContPType3IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContPType3IEC" );

		WindContPType3IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContPType3IEC with primary key" );
		msg.append( windContPType3IECId );
		
		WindContPType3IECFetchOneSummary fetchOneSummary = new WindContPType3IECFetchOneSummary( windContPType3IECId );

		try {
			entity = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().getWindContPType3IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContPType3IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContPType3IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContPType3IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContPType3IEC : " );        
		WindContPType3IEC entity = read();
		UpdateWindContPType3IECCommand command = generateUpdateCommand();
		command.setWindContPType3IECId(entity.getWindContPType3IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContPType3IEC." );

			// for use later on...
			windContPType3IECId = entity.getWindContPType3IECId();

			WindContPType3IECBusinessDelegate proxy = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance();  

			proxy.updateWindContPType3IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContPType3IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContPType3IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContPType3IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContPType3IEC." );

		WindContPType3IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContPType3IEC with id " + windContPType3IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContPType3IEC with id " + windContPType3IECId );

			throw e;
		}

		try{
			WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().delete( new DeleteWindContPType3IECCommand( entity.getWindContPType3IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContPType3IEC with id " + windContPType3IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContPType3IEC with id " + windContPType3IECId );

			throw e;
		}
	}

	/**
	 * get all WindContPType3IECs.
	 */
	protected List<WindContPType3IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContPType3IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContPType3IEC : " );        
		List<WindContPType3IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContPType3IECBusinessDelegate
			collection = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().getAllWindContPType3IEC();
			assertNotNull( collection, "An Empty collection of WindContPType3IEC was incorrectly returned.");
			
			// Now print out the values
			WindContPType3IEC entity = null;            
			Iterator<WindContPType3IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContPType3IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContPType3IECTest
	 */
	protected WindContPType3IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContPType3IEC
	 * 
	 * @return CreateWindContPType3IECCommand alias
	 */
	protected CreateWindContPType3IECCommand generateNewCommand() {
        CreateWindContPType3IECCommand command = new CreateWindContPType3IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContPType3IEC
		 * 
		 * @return UpdateWindContPType3IECCommand alias
		 */
	protected UpdateWindContPType3IECCommand generateUpdateCommand() {
	        UpdateWindContPType3IECCommand command = new UpdateWindContPType3IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContPType3IECId = null;
	protected WindContPType3IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContPType3IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContPType3IECList = 0;
}
