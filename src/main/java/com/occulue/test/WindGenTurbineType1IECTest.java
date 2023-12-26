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
 * Test WindGenTurbineType1IEC class.
 *
 * @author your_name_here
 */
public class WindGenTurbineType1IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGenTurbineType1IECTest() {
		subscriber = new WindGenTurbineType1IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGenTurbineType1IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGenTurbineType1IEC...");
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
	 * jumpstart the process by instantiating2 WindGenTurbineType1IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGenTurbineType1IECId = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance()
		.createWindGenTurbineType1IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance()
				.createWindGenTurbineType1IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGenTurbineType1IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGenTurbineType1IEC : " + successValue.getWindGenTurbineType1IECId());
							  if (successValue.getWindGenTurbineType1IECId().equals(windGenTurbineType1IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGenTurbineType1IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGenTurbineType1IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType1IEC consumed")
					);
			subscriber.windGenTurbineType1IECSubscribe( windGenTurbineType1IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGenTurbineType1IEC : " + successValue.getWindGenTurbineType1IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGenTurbineType1IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGenTurbineType1IEC for windGenTurbineType1IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGenTurbineType1IEC. 
	 */
	protected WindGenTurbineType1IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGenTurbineType1IEC" );

		WindGenTurbineType1IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGenTurbineType1IEC with primary key" );
		msg.append( windGenTurbineType1IECId );
		
		WindGenTurbineType1IECFetchOneSummary fetchOneSummary = new WindGenTurbineType1IECFetchOneSummary( windGenTurbineType1IECId );

		try {
			entity = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().getWindGenTurbineType1IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGenTurbineType1IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGenTurbineType1IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGenTurbineType1IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGenTurbineType1IEC : " );        
		WindGenTurbineType1IEC entity = read();
		UpdateWindGenTurbineType1IECCommand command = generateUpdateCommand();
		command.setWindGenTurbineType1IECId(entity.getWindGenTurbineType1IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGenTurbineType1IEC." );

			// for use later on...
			windGenTurbineType1IECId = entity.getWindGenTurbineType1IECId();

			WindGenTurbineType1IECBusinessDelegate proxy = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance();  

			proxy.updateWindGenTurbineType1IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindGenTurbineType1IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGenTurbineType1IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGenTurbineType1IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGenTurbineType1IEC." );

		WindGenTurbineType1IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGenTurbineType1IEC with id " + windGenTurbineType1IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGenTurbineType1IEC with id " + windGenTurbineType1IECId );

			throw e;
		}

		try{
			WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().delete( new DeleteWindGenTurbineType1IECCommand( entity.getWindGenTurbineType1IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGenTurbineType1IEC with id " + windGenTurbineType1IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGenTurbineType1IEC with id " + windGenTurbineType1IECId );

			throw e;
		}
	}

	/**
	 * get all WindGenTurbineType1IECs.
	 */
	protected List<WindGenTurbineType1IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGenTurbineType1IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGenTurbineType1IEC : " );        
		List<WindGenTurbineType1IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGenTurbineType1IECBusinessDelegate
			collection = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().getAllWindGenTurbineType1IEC();
			assertNotNull( collection, "An Empty collection of WindGenTurbineType1IEC was incorrectly returned.");
			
			// Now print out the values
			WindGenTurbineType1IEC entity = null;            
			Iterator<WindGenTurbineType1IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGenTurbineType1IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGenTurbineType1IECTest
	 */
	protected WindGenTurbineType1IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGenTurbineType1IEC
	 * 
	 * @return CreateWindGenTurbineType1IECCommand alias
	 */
	protected CreateWindGenTurbineType1IECCommand generateNewCommand() {
        CreateWindGenTurbineType1IECCommand command = new CreateWindGenTurbineType1IECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGenTurbineType1IEC
		 * 
		 * @return UpdateWindGenTurbineType1IECCommand alias
		 */
	protected UpdateWindGenTurbineType1IECCommand generateUpdateCommand() {
	        UpdateWindGenTurbineType1IECCommand command = new UpdateWindGenTurbineType1IECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGenTurbineType1IECId = null;
	protected WindGenTurbineType1IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGenTurbineType1IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGenTurbineType1IECList = 0;
}
