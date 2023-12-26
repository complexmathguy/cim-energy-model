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
 * Test WindContPType4bIEC class.
 *
 * @author your_name_here
 */
public class WindContPType4bIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContPType4bIECTest() {
		subscriber = new WindContPType4bIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContPType4bIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContPType4bIEC...");
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
	 * jumpstart the process by instantiating2 WindContPType4bIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContPType4bIECId = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance()
		.createWindContPType4bIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance()
				.createWindContPType4bIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContPType4bIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContPType4bIEC : " + successValue.getWindContPType4bIECId());
							  if (successValue.getWindContPType4bIECId().equals(windContPType4bIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContPType4bIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContPType4bIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType4bIEC consumed")
					);
			subscriber.windContPType4bIECSubscribe( windContPType4bIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContPType4bIEC : " + successValue.getWindContPType4bIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContPType4bIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType4bIEC for windContPType4bIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContPType4bIEC. 
	 */
	protected WindContPType4bIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContPType4bIEC" );

		WindContPType4bIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContPType4bIEC with primary key" );
		msg.append( windContPType4bIECId );
		
		WindContPType4bIECFetchOneSummary fetchOneSummary = new WindContPType4bIECFetchOneSummary( windContPType4bIECId );

		try {
			entity = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().getWindContPType4bIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContPType4bIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContPType4bIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContPType4bIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContPType4bIEC : " );        
		WindContPType4bIEC entity = read();
		UpdateWindContPType4bIECCommand command = generateUpdateCommand();
		command.setWindContPType4bIECId(entity.getWindContPType4bIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContPType4bIEC." );

			// for use later on...
			windContPType4bIECId = entity.getWindContPType4bIECId();

			WindContPType4bIECBusinessDelegate proxy = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();  

			proxy.updateWindContPType4bIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContPType4bIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContPType4bIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContPType4bIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContPType4bIEC." );

		WindContPType4bIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContPType4bIEC with id " + windContPType4bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContPType4bIEC with id " + windContPType4bIECId );

			throw e;
		}

		try{
			WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().delete( new DeleteWindContPType4bIECCommand( entity.getWindContPType4bIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContPType4bIEC with id " + windContPType4bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContPType4bIEC with id " + windContPType4bIECId );

			throw e;
		}
	}

	/**
	 * get all WindContPType4bIECs.
	 */
	protected List<WindContPType4bIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContPType4bIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContPType4bIEC : " );        
		List<WindContPType4bIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContPType4bIECBusinessDelegate
			collection = WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance().getAllWindContPType4bIEC();
			assertNotNull( collection, "An Empty collection of WindContPType4bIEC was incorrectly returned.");
			
			// Now print out the values
			WindContPType4bIEC entity = null;            
			Iterator<WindContPType4bIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContPType4bIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContPType4bIECTest
	 */
	protected WindContPType4bIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContPType4bIEC
	 * 
	 * @return CreateWindContPType4bIECCommand alias
	 */
	protected CreateWindContPType4bIECCommand generateNewCommand() {
        CreateWindContPType4bIECCommand command = new CreateWindContPType4bIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContPType4bIEC
		 * 
		 * @return UpdateWindContPType4bIECCommand alias
		 */
	protected UpdateWindContPType4bIECCommand generateUpdateCommand() {
	        UpdateWindContPType4bIECCommand command = new UpdateWindContPType4bIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContPType4bIECId = null;
	protected WindContPType4bIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContPType4bIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContPType4bIECList = 0;
}
