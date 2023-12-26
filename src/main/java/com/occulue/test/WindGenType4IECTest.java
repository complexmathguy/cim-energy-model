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
 * Test WindGenType4IEC class.
 *
 * @author your_name_here
 */
public class WindGenType4IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenType4IECTest() {
		subscriber = new WindGenType4IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenType4IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenType4IEC...");
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
	 * jumpstart the process by instantiating2 WindGenType4IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenType4IECId = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance()
		.createWindGenType4IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenType4IECBusinessDelegate.getWindGenType4IECInstance()
				.createWindGenType4IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenType4IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenType4IEC : " + successValue.getWindGenType4IECId());
							  if (successValue.getWindGenType4IECId().equals(windGenType4IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenType4IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenType4IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenType4IEC consumed")
					);
			subscriber.windGenType4IECSubscribe( windGenType4IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenType4IEC : " + successValue.getWindGenType4IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenType4IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenType4IEC for windGenType4IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenType4IEC. 
	 */
	protected WindGenType4IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenType4IEC" );

		WindGenType4IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenType4IEC with primary key" );
		msg.append( windGenType4IECId );
		
		WindGenType4IECFetchOneSummary fetchOneSummary = new WindGenType4IECFetchOneSummary( windGenType4IECId );

		try {
			entity = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().getWindGenType4IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenType4IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenType4IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenType4IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenType4IEC : " );        
		WindGenType4IEC entity = read();
		UpdateWindGenType4IECCommand command = generateUpdateCommand();
		command.setWindGenType4IECId(entity.getWindGenType4IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenType4IEC." );

			// for use later on...
			windGenType4IECId = entity.getWindGenType4IECId();

			WindGenType4IECBusinessDelegate proxy = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance();  

			proxy.updateWindGenType4IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenType4IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenType4IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenType4IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenType4IEC." );

		WindGenType4IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenType4IEC with id " + windGenType4IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenType4IEC with id " + windGenType4IECId );

			throw e;
		}

		try{
			WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().delete( new DeleteWindGenType4IECCommand( entity.getWindGenType4IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenType4IEC with id " + windGenType4IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenType4IEC with id " + windGenType4IECId );

			throw e;
		}
	}

	/**
	 * get all WindGenType4IECs.
	 */
	protected List<WindGenType4IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenType4IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenType4IEC : " );        
		List<WindGenType4IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenType4IECBusinessDelegate
			collection = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().getAllWindGenType4IEC();
			assertNotNull( collection, "An Empty collection of WindGenType4IEC was incorrectly returned.");
			
			// Now print out the values
			WindGenType4IEC entity = null;            
			Iterator<WindGenType4IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenType4IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenType4IECTest
	 */
	protected WindGenType4IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenType4IEC
	 * 
	 * @return CreateWindGenType4IECCommand alias
	 */
	protected CreateWindGenType4IECCommand generateNewCommand() {
        CreateWindGenType4IECCommand command = new CreateWindGenType4IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenType4IEC
		 * 
		 * @return UpdateWindGenType4IECCommand alias
		 */
	protected UpdateWindGenType4IECCommand generateUpdateCommand() {
	        UpdateWindGenType4IECCommand command = new UpdateWindGenType4IECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenType4IECId = null;
	protected WindGenType4IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenType4IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenType4IECList = 0;
}
