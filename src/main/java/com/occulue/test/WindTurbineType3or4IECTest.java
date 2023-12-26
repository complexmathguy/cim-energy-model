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
 * Test WindTurbineType3or4IEC class.
 *
 * @author your_name_here
 */
public class WindTurbineType3or4IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType3or4IECTest() {
		subscriber = new WindTurbineType3or4IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType3or4IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType3or4IEC...");
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
	 * jumpstart the process by instantiating2 WindTurbineType3or4IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType3or4IECId = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
		.createWindTurbineType3or4IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
				.createWindTurbineType3or4IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType3or4IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType3or4IEC : " + successValue.getWindTurbineType3or4IECId());
							  if (successValue.getWindTurbineType3or4IECId().equals(windTurbineType3or4IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType3or4IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType3or4IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType3or4IEC consumed")
					);
			subscriber.windTurbineType3or4IECSubscribe( windTurbineType3or4IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType3or4IEC : " + successValue.getWindTurbineType3or4IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType3or4IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType3or4IEC for windTurbineType3or4IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType3or4IEC. 
	 */
	protected WindTurbineType3or4IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType3or4IEC" );

		WindTurbineType3or4IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType3or4IEC with primary key" );
		msg.append( windTurbineType3or4IECId );
		
		WindTurbineType3or4IECFetchOneSummary fetchOneSummary = new WindTurbineType3or4IECFetchOneSummary( windTurbineType3or4IECId );

		try {
			entity = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance().getWindTurbineType3or4IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType3or4IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType3or4IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType3or4IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType3or4IEC : " );        
		WindTurbineType3or4IEC entity = read();
		UpdateWindTurbineType3or4IECCommand command = generateUpdateCommand();
		command.setWindTurbineType3or4IECId(entity.getWindTurbineType3or4IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType3or4IEC." );

			// for use later on...
			windTurbineType3or4IECId = entity.getWindTurbineType3or4IECId();

			WindTurbineType3or4IECBusinessDelegate proxy = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance();  

			proxy.updateWindTurbineType3or4IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType3or4IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType3or4IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType3or4IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType3or4IEC." );

		WindTurbineType3or4IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType3or4IEC with id " + windTurbineType3or4IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType3or4IEC with id " + windTurbineType3or4IECId );

			throw e;
		}

		try{
			WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance().delete( new DeleteWindTurbineType3or4IECCommand( entity.getWindTurbineType3or4IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType3or4IEC with id " + windTurbineType3or4IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType3or4IEC with id " + windTurbineType3or4IECId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType3or4IECs.
	 */
	protected List<WindTurbineType3or4IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType3or4IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType3or4IEC : " );        
		List<WindTurbineType3or4IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType3or4IECBusinessDelegate
			collection = WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance().getAllWindTurbineType3or4IEC();
			assertNotNull( collection, "An Empty collection of WindTurbineType3or4IEC was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType3or4IEC entity = null;            
			Iterator<WindTurbineType3or4IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType3or4IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType3or4IECTest
	 */
	protected WindTurbineType3or4IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType3or4IEC
	 * 
	 * @return CreateWindTurbineType3or4IECCommand alias
	 */
	protected CreateWindTurbineType3or4IECCommand generateNewCommand() {
        CreateWindTurbineType3or4IECCommand command = new CreateWindTurbineType3or4IECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType3or4IEC
		 * 
		 * @return UpdateWindTurbineType3or4IECCommand alias
		 */
	protected UpdateWindTurbineType3or4IECCommand generateUpdateCommand() {
	        UpdateWindTurbineType3or4IECCommand command = new UpdateWindTurbineType3or4IECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType3or4IECId = null;
	protected WindTurbineType3or4IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType3or4IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType3or4IECList = 0;
}
