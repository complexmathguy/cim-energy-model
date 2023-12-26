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
 * Test WindPlantIEC class.
 *
 * @author your_name_here
 */
public class WindPlantIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPlantIECTest() {
		subscriber = new WindPlantIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPlantIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPlantIEC...");
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
	 * jumpstart the process by instantiating2 WindPlantIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPlantIECId = WindPlantIECBusinessDelegate.getWindPlantIECInstance()
		.createWindPlantIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPlantIECBusinessDelegate.getWindPlantIECInstance()
				.createWindPlantIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPlantIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPlantIEC : " + successValue.getWindPlantIECId());
							  if (successValue.getWindPlantIECId().equals(windPlantIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPlantIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPlantIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantIEC consumed")
					);
			subscriber.windPlantIECSubscribe( windPlantIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPlantIEC : " + successValue.getWindPlantIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPlantIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantIEC for windPlantIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPlantIEC. 
	 */
	protected WindPlantIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPlantIEC" );

		WindPlantIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPlantIEC with primary key" );
		msg.append( windPlantIECId );
		
		WindPlantIECFetchOneSummary fetchOneSummary = new WindPlantIECFetchOneSummary( windPlantIECId );

		try {
			entity = WindPlantIECBusinessDelegate.getWindPlantIECInstance().getWindPlantIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPlantIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPlantIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPlantIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPlantIEC : " );        
		WindPlantIEC entity = read();
		UpdateWindPlantIECCommand command = generateUpdateCommand();
		command.setWindPlantIECId(entity.getWindPlantIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPlantIEC." );

			// for use later on...
			windPlantIECId = entity.getWindPlantIECId();

			WindPlantIECBusinessDelegate proxy = WindPlantIECBusinessDelegate.getWindPlantIECInstance();  

			proxy.updateWindPlantIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindPlantIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPlantIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPlantIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPlantIEC." );

		WindPlantIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPlantIEC with id " + windPlantIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPlantIEC with id " + windPlantIECId );

			throw e;
		}

		try{
			WindPlantIECBusinessDelegate.getWindPlantIECInstance().delete( new DeleteWindPlantIECCommand( entity.getWindPlantIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPlantIEC with id " + windPlantIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPlantIEC with id " + windPlantIECId );

			throw e;
		}
	}

	/**
	 * get all WindPlantIECs.
	 */
	protected List<WindPlantIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPlantIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPlantIEC : " );        
		List<WindPlantIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPlantIECBusinessDelegate
			collection = WindPlantIECBusinessDelegate.getWindPlantIECInstance().getAllWindPlantIEC();
			assertNotNull( collection, "An Empty collection of WindPlantIEC was incorrectly returned.");
			
			// Now print out the values
			WindPlantIEC entity = null;            
			Iterator<WindPlantIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPlantIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPlantIECTest
	 */
	protected WindPlantIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPlantIEC
	 * 
	 * @return CreateWindPlantIECCommand alias
	 */
	protected CreateWindPlantIECCommand generateNewCommand() {
        CreateWindPlantIECCommand command = new CreateWindPlantIECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPlantIEC
		 * 
		 * @return UpdateWindPlantIECCommand alias
		 */
	protected UpdateWindPlantIECCommand generateUpdateCommand() {
	        UpdateWindPlantIECCommand command = new UpdateWindPlantIECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPlantIECId = null;
	protected WindPlantIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPlantIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPlantIECList = 0;
}
