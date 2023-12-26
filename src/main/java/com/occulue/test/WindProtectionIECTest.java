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
 * Test WindProtectionIEC class.
 *
 * @author your_name_here
 */
public class WindProtectionIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindProtectionIECTest() {
		subscriber = new WindProtectionIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindProtectionIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindProtectionIEC...");
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
	 * jumpstart the process by instantiating2 WindProtectionIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windProtectionIECId = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
		.createWindProtectionIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
				.createWindProtectionIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windProtectionIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindProtectionIEC : " + successValue.getWindProtectionIECId());
							  if (successValue.getWindProtectionIECId().equals(windProtectionIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindProtectionIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindProtectionIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windProtectionIEC consumed")
					);
			subscriber.windProtectionIECSubscribe( windProtectionIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindProtectionIEC : " + successValue.getWindProtectionIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindProtectionIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windProtectionIEC for windProtectionIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindProtectionIEC. 
	 */
	protected WindProtectionIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindProtectionIEC" );

		WindProtectionIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindProtectionIEC with primary key" );
		msg.append( windProtectionIECId );
		
		WindProtectionIECFetchOneSummary fetchOneSummary = new WindProtectionIECFetchOneSummary( windProtectionIECId );

		try {
			entity = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().getWindProtectionIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindProtectionIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindProtectionIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindProtectionIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindProtectionIEC : " );        
		WindProtectionIEC entity = read();
		UpdateWindProtectionIECCommand command = generateUpdateCommand();
		command.setWindProtectionIECId(entity.getWindProtectionIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindProtectionIEC." );

			// for use later on...
			windProtectionIECId = entity.getWindProtectionIECId();

			WindProtectionIECBusinessDelegate proxy = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance();  

			proxy.updateWindProtectionIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindProtectionIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windProtectionIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindProtectionIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindProtectionIEC." );

		WindProtectionIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindProtectionIEC with id " + windProtectionIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindProtectionIEC with id " + windProtectionIECId );

			throw e;
		}

		try{
			WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().delete( new DeleteWindProtectionIECCommand( entity.getWindProtectionIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindProtectionIEC with id " + windProtectionIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindProtectionIEC with id " + windProtectionIECId );

			throw e;
		}
	}

	/**
	 * get all WindProtectionIECs.
	 */
	protected List<WindProtectionIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindProtectionIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindProtectionIEC : " );        
		List<WindProtectionIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindProtectionIECBusinessDelegate
			collection = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().getAllWindProtectionIEC();
			assertNotNull( collection, "An Empty collection of WindProtectionIEC was incorrectly returned.");
			
			// Now print out the values
			WindProtectionIEC entity = null;            
			Iterator<WindProtectionIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindProtectionIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindProtectionIECTest
	 */
	protected WindProtectionIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindProtectionIEC
	 * 
	 * @return CreateWindProtectionIECCommand alias
	 */
	protected CreateWindProtectionIECCommand generateNewCommand() {
        CreateWindProtectionIECCommand command = new CreateWindProtectionIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindProtectionIEC
		 * 
		 * @return UpdateWindProtectionIECCommand alias
		 */
	protected UpdateWindProtectionIECCommand generateUpdateCommand() {
	        UpdateWindProtectionIECCommand command = new UpdateWindProtectionIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windProtectionIECId = null;
	protected WindProtectionIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindProtectionIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindProtectionIECList = 0;
}
