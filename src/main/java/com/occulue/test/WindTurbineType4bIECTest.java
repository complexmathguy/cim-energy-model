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
 * Test WindTurbineType4bIEC class.
 *
 * @author your_name_here
 */
public class WindTurbineType4bIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType4bIECTest() {
		subscriber = new WindTurbineType4bIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType4bIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType4bIEC...");
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
	 * jumpstart the process by instantiating2 WindTurbineType4bIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType4bIECId = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
		.createWindTurbineType4bIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
				.createWindTurbineType4bIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType4bIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType4bIEC : " + successValue.getWindTurbineType4bIECId());
							  if (successValue.getWindTurbineType4bIECId().equals(windTurbineType4bIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType4bIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType4bIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType4bIEC consumed")
					);
			subscriber.windTurbineType4bIECSubscribe( windTurbineType4bIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType4bIEC : " + successValue.getWindTurbineType4bIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType4bIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType4bIEC for windTurbineType4bIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType4bIEC. 
	 */
	protected WindTurbineType4bIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType4bIEC" );

		WindTurbineType4bIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType4bIEC with primary key" );
		msg.append( windTurbineType4bIECId );
		
		WindTurbineType4bIECFetchOneSummary fetchOneSummary = new WindTurbineType4bIECFetchOneSummary( windTurbineType4bIECId );

		try {
			entity = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().getWindTurbineType4bIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType4bIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType4bIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType4bIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType4bIEC : " );        
		WindTurbineType4bIEC entity = read();
		UpdateWindTurbineType4bIECCommand command = generateUpdateCommand();
		command.setWindTurbineType4bIECId(entity.getWindTurbineType4bIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType4bIEC." );

			// for use later on...
			windTurbineType4bIECId = entity.getWindTurbineType4bIECId();

			WindTurbineType4bIECBusinessDelegate proxy = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance();  

			proxy.updateWindTurbineType4bIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType4bIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType4bIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType4bIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType4bIEC." );

		WindTurbineType4bIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType4bIEC with id " + windTurbineType4bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType4bIEC with id " + windTurbineType4bIECId );

			throw e;
		}

		try{
			WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().delete( new DeleteWindTurbineType4bIECCommand( entity.getWindTurbineType4bIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType4bIEC with id " + windTurbineType4bIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType4bIEC with id " + windTurbineType4bIECId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType4bIECs.
	 */
	protected List<WindTurbineType4bIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType4bIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType4bIEC : " );        
		List<WindTurbineType4bIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType4bIECBusinessDelegate
			collection = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().getAllWindTurbineType4bIEC();
			assertNotNull( collection, "An Empty collection of WindTurbineType4bIEC was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType4bIEC entity = null;            
			Iterator<WindTurbineType4bIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType4bIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType4bIECTest
	 */
	protected WindTurbineType4bIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType4bIEC
	 * 
	 * @return CreateWindTurbineType4bIECCommand alias
	 */
	protected CreateWindTurbineType4bIECCommand generateNewCommand() {
        CreateWindTurbineType4bIECCommand command = new CreateWindTurbineType4bIECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType4bIEC
		 * 
		 * @return UpdateWindTurbineType4bIECCommand alias
		 */
	protected UpdateWindTurbineType4bIECCommand generateUpdateCommand() {
	        UpdateWindTurbineType4bIECCommand command = new UpdateWindTurbineType4bIECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType4bIECId = null;
	protected WindTurbineType4bIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType4bIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType4bIECList = 0;
}
