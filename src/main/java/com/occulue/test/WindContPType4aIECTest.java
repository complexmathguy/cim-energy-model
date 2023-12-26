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
 * Test WindContPType4aIEC class.
 *
 * @author your_name_here
 */
public class WindContPType4aIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindContPType4aIECTest() {
		subscriber = new WindContPType4aIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindContPType4aIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindContPType4aIEC...");
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
	 * jumpstart the process by instantiating2 WindContPType4aIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windContPType4aIECId = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance()
		.createWindContPType4aIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance()
				.createWindContPType4aIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windContPType4aIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindContPType4aIEC : " + successValue.getWindContPType4aIECId());
							  if (successValue.getWindContPType4aIECId().equals(windContPType4aIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindContPType4aIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindContPType4aIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType4aIEC consumed")
					);
			subscriber.windContPType4aIECSubscribe( windContPType4aIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindContPType4aIEC : " + successValue.getWindContPType4aIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindContPType4aIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windContPType4aIEC for windContPType4aIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindContPType4aIEC. 
	 */
	protected WindContPType4aIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindContPType4aIEC" );

		WindContPType4aIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindContPType4aIEC with primary key" );
		msg.append( windContPType4aIECId );
		
		WindContPType4aIECFetchOneSummary fetchOneSummary = new WindContPType4aIECFetchOneSummary( windContPType4aIECId );

		try {
			entity = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().getWindContPType4aIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindContPType4aIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindContPType4aIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindContPType4aIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindContPType4aIEC : " );        
		WindContPType4aIEC entity = read();
		UpdateWindContPType4aIECCommand command = generateUpdateCommand();
		command.setWindContPType4aIECId(entity.getWindContPType4aIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindContPType4aIEC." );

			// for use later on...
			windContPType4aIECId = entity.getWindContPType4aIECId();

			WindContPType4aIECBusinessDelegate proxy = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance();  

			proxy.updateWindContPType4aIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindContPType4aIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windContPType4aIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindContPType4aIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindContPType4aIEC." );

		WindContPType4aIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindContPType4aIEC with id " + windContPType4aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindContPType4aIEC with id " + windContPType4aIECId );

			throw e;
		}

		try{
			WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().delete( new DeleteWindContPType4aIECCommand( entity.getWindContPType4aIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindContPType4aIEC with id " + windContPType4aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindContPType4aIEC with id " + windContPType4aIECId );

			throw e;
		}
	}

	/**
	 * get all WindContPType4aIECs.
	 */
	protected List<WindContPType4aIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindContPType4aIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindContPType4aIEC : " );        
		List<WindContPType4aIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindContPType4aIECBusinessDelegate
			collection = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().getAllWindContPType4aIEC();
			assertNotNull( collection, "An Empty collection of WindContPType4aIEC was incorrectly returned.");
			
			// Now print out the values
			WindContPType4aIEC entity = null;            
			Iterator<WindContPType4aIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindContPType4aIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindContPType4aIECTest
	 */
	protected WindContPType4aIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindContPType4aIEC
	 * 
	 * @return CreateWindContPType4aIECCommand alias
	 */
	protected CreateWindContPType4aIECCommand generateNewCommand() {
        CreateWindContPType4aIECCommand command = new CreateWindContPType4aIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindContPType4aIEC
		 * 
		 * @return UpdateWindContPType4aIECCommand alias
		 */
	protected UpdateWindContPType4aIECCommand generateUpdateCommand() {
	        UpdateWindContPType4aIECCommand command = new UpdateWindContPType4aIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windContPType4aIECId = null;
	protected WindContPType4aIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindContPType4aIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindContPType4aIECList = 0;
}
