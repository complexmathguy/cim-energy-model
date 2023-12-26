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
 * Test WindTurbineType4aIEC class.
 *
 * @author your_name_here
 */
public class WindTurbineType4aIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType4aIECTest() {
		subscriber = new WindTurbineType4aIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType4aIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType4aIEC...");
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
	 * jumpstart the process by instantiating2 WindTurbineType4aIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType4aIECId = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance()
		.createWindTurbineType4aIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance()
				.createWindTurbineType4aIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType4aIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType4aIEC : " + successValue.getWindTurbineType4aIECId());
							  if (successValue.getWindTurbineType4aIECId().equals(windTurbineType4aIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType4aIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType4aIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType4aIEC consumed")
					);
			subscriber.windTurbineType4aIECSubscribe( windTurbineType4aIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType4aIEC : " + successValue.getWindTurbineType4aIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType4aIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType4aIEC for windTurbineType4aIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType4aIEC. 
	 */
	protected WindTurbineType4aIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType4aIEC" );

		WindTurbineType4aIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType4aIEC with primary key" );
		msg.append( windTurbineType4aIECId );
		
		WindTurbineType4aIECFetchOneSummary fetchOneSummary = new WindTurbineType4aIECFetchOneSummary( windTurbineType4aIECId );

		try {
			entity = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().getWindTurbineType4aIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType4aIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType4aIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType4aIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType4aIEC : " );        
		WindTurbineType4aIEC entity = read();
		UpdateWindTurbineType4aIECCommand command = generateUpdateCommand();
		command.setWindTurbineType4aIECId(entity.getWindTurbineType4aIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType4aIEC." );

			// for use later on...
			windTurbineType4aIECId = entity.getWindTurbineType4aIECId();

			WindTurbineType4aIECBusinessDelegate proxy = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance();  

			proxy.updateWindTurbineType4aIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType4aIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType4aIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType4aIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType4aIEC." );

		WindTurbineType4aIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType4aIEC with id " + windTurbineType4aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType4aIEC with id " + windTurbineType4aIECId );

			throw e;
		}

		try{
			WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().delete( new DeleteWindTurbineType4aIECCommand( entity.getWindTurbineType4aIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType4aIEC with id " + windTurbineType4aIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType4aIEC with id " + windTurbineType4aIECId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType4aIECs.
	 */
	protected List<WindTurbineType4aIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType4aIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType4aIEC : " );        
		List<WindTurbineType4aIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType4aIECBusinessDelegate
			collection = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().getAllWindTurbineType4aIEC();
			assertNotNull( collection, "An Empty collection of WindTurbineType4aIEC was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType4aIEC entity = null;            
			Iterator<WindTurbineType4aIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType4aIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType4aIECTest
	 */
	protected WindTurbineType4aIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType4aIEC
	 * 
	 * @return CreateWindTurbineType4aIECCommand alias
	 */
	protected CreateWindTurbineType4aIECCommand generateNewCommand() {
        CreateWindTurbineType4aIECCommand command = new CreateWindTurbineType4aIECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType4aIEC
		 * 
		 * @return UpdateWindTurbineType4aIECCommand alias
		 */
	protected UpdateWindTurbineType4aIECCommand generateUpdateCommand() {
	        UpdateWindTurbineType4aIECCommand command = new UpdateWindTurbineType4aIECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType4aIECId = null;
	protected WindTurbineType4aIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType4aIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType4aIECList = 0;
}
