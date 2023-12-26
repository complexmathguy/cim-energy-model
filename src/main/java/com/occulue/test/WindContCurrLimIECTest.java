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
 * Test WindContCurrLimIEC class.
 *
 * @author your_name_here
 */
public class WindContCurrLimIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContCurrLimIECTest() {
		subscriber = new WindContCurrLimIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContCurrLimIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContCurrLimIEC...");
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
	 * jumpstart the process by instantiating2 WindContCurrLimIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContCurrLimIECId = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance()
		.createWindContCurrLimIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance()
				.createWindContCurrLimIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContCurrLimIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContCurrLimIEC : " + successValue.getWindContCurrLimIECId());
							  if (successValue.getWindContCurrLimIECId().equals(windContCurrLimIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContCurrLimIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContCurrLimIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContCurrLimIEC consumed")
					);
			subscriber.windContCurrLimIECSubscribe( windContCurrLimIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContCurrLimIEC : " + successValue.getWindContCurrLimIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContCurrLimIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContCurrLimIEC for windContCurrLimIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContCurrLimIEC. 
	 */
	protected WindContCurrLimIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContCurrLimIEC" );

		WindContCurrLimIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContCurrLimIEC with primary key" );
		msg.append( windContCurrLimIECId );
		
		WindContCurrLimIECFetchOneSummary fetchOneSummary = new WindContCurrLimIECFetchOneSummary( windContCurrLimIECId );

		try {
			entity = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().getWindContCurrLimIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContCurrLimIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContCurrLimIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContCurrLimIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContCurrLimIEC : " );        
		WindContCurrLimIEC entity = read();
		UpdateWindContCurrLimIECCommand command = generateUpdateCommand();
		command.setWindContCurrLimIECId(entity.getWindContCurrLimIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContCurrLimIEC." );

			// for use later on...
			windContCurrLimIECId = entity.getWindContCurrLimIECId();

			WindContCurrLimIECBusinessDelegate proxy = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();  

			proxy.updateWindContCurrLimIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContCurrLimIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContCurrLimIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContCurrLimIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContCurrLimIEC." );

		WindContCurrLimIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContCurrLimIEC with id " + windContCurrLimIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContCurrLimIEC with id " + windContCurrLimIECId );

			throw e;
		}

		try{
			WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().delete( new DeleteWindContCurrLimIECCommand( entity.getWindContCurrLimIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContCurrLimIEC with id " + windContCurrLimIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContCurrLimIEC with id " + windContCurrLimIECId );

			throw e;
		}
	}

	/**
	 * get all WindContCurrLimIECs.
	 */
	protected List<WindContCurrLimIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContCurrLimIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContCurrLimIEC : " );        
		List<WindContCurrLimIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContCurrLimIECBusinessDelegate
			collection = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().getAllWindContCurrLimIEC();
			assertNotNull( collection, "An Empty collection of WindContCurrLimIEC was incorrectly returned.");
			
			// Now print out the values
			WindContCurrLimIEC entity = null;            
			Iterator<WindContCurrLimIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContCurrLimIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContCurrLimIECTest
	 */
	protected WindContCurrLimIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContCurrLimIEC
	 * 
	 * @return CreateWindContCurrLimIECCommand alias
	 */
	protected CreateWindContCurrLimIECCommand generateNewCommand() {
        CreateWindContCurrLimIECCommand command = new CreateWindContCurrLimIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContCurrLimIEC
		 * 
		 * @return UpdateWindContCurrLimIECCommand alias
		 */
	protected UpdateWindContCurrLimIECCommand generateUpdateCommand() {
	        UpdateWindContCurrLimIECCommand command = new UpdateWindContCurrLimIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContCurrLimIECId = null;
	protected WindContCurrLimIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContCurrLimIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContCurrLimIECList = 0;
}
