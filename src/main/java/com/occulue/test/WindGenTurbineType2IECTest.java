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
 * Test WindGenTurbineType2IEC class.
 *
 * @author your_name_here
 */
public class WindGenTurbineType2IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenTurbineType2IECTest() {
		subscriber = new WindGenTurbineType2IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenTurbineType2IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenTurbineType2IEC...");
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
	 * jumpstart the process by instantiating2 WindGenTurbineType2IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenTurbineType2IECId = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance()
		.createWindGenTurbineType2IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance()
				.createWindGenTurbineType2IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenTurbineType2IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenTurbineType2IEC : " + successValue.getWindGenTurbineType2IECId());
							  if (successValue.getWindGenTurbineType2IECId().equals(windGenTurbineType2IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenTurbineType2IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenTurbineType2IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType2IEC consumed")
					);
			subscriber.windGenTurbineType2IECSubscribe( windGenTurbineType2IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenTurbineType2IEC : " + successValue.getWindGenTurbineType2IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenTurbineType2IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType2IEC for windGenTurbineType2IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenTurbineType2IEC. 
	 */
	protected WindGenTurbineType2IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenTurbineType2IEC" );

		WindGenTurbineType2IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenTurbineType2IEC with primary key" );
		msg.append( windGenTurbineType2IECId );
		
		WindGenTurbineType2IECFetchOneSummary fetchOneSummary = new WindGenTurbineType2IECFetchOneSummary( windGenTurbineType2IECId );

		try {
			entity = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().getWindGenTurbineType2IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenTurbineType2IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenTurbineType2IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenTurbineType2IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenTurbineType2IEC : " );        
		WindGenTurbineType2IEC entity = read();
		UpdateWindGenTurbineType2IECCommand command = generateUpdateCommand();
		command.setWindGenTurbineType2IECId(entity.getWindGenTurbineType2IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenTurbineType2IEC." );

			// for use later on...
			windGenTurbineType2IECId = entity.getWindGenTurbineType2IECId();

			WindGenTurbineType2IECBusinessDelegate proxy = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance();  

			proxy.updateWindGenTurbineType2IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenTurbineType2IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenTurbineType2IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenTurbineType2IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenTurbineType2IEC." );

		WindGenTurbineType2IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenTurbineType2IEC with id " + windGenTurbineType2IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenTurbineType2IEC with id " + windGenTurbineType2IECId );

			throw e;
		}

		try{
			WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().delete( new DeleteWindGenTurbineType2IECCommand( entity.getWindGenTurbineType2IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenTurbineType2IEC with id " + windGenTurbineType2IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenTurbineType2IEC with id " + windGenTurbineType2IECId );

			throw e;
		}
	}

	/**
	 * get all WindGenTurbineType2IECs.
	 */
	protected List<WindGenTurbineType2IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenTurbineType2IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenTurbineType2IEC : " );        
		List<WindGenTurbineType2IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenTurbineType2IECBusinessDelegate
			collection = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().getAllWindGenTurbineType2IEC();
			assertNotNull( collection, "An Empty collection of WindGenTurbineType2IEC was incorrectly returned.");
			
			// Now print out the values
			WindGenTurbineType2IEC entity = null;            
			Iterator<WindGenTurbineType2IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenTurbineType2IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenTurbineType2IECTest
	 */
	protected WindGenTurbineType2IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenTurbineType2IEC
	 * 
	 * @return CreateWindGenTurbineType2IECCommand alias
	 */
	protected CreateWindGenTurbineType2IECCommand generateNewCommand() {
        CreateWindGenTurbineType2IECCommand command = new CreateWindGenTurbineType2IECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenTurbineType2IEC
		 * 
		 * @return UpdateWindGenTurbineType2IECCommand alias
		 */
	protected UpdateWindGenTurbineType2IECCommand generateUpdateCommand() {
	        UpdateWindGenTurbineType2IECCommand command = new UpdateWindGenTurbineType2IECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenTurbineType2IECId = null;
	protected WindGenTurbineType2IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenTurbineType2IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenTurbineType2IECList = 0;
}
