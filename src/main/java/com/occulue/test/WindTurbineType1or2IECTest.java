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
 * Test WindTurbineType1or2IEC class.
 *
 * @author your_name_here
 */
public class WindTurbineType1or2IECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType1or2IECTest() {
		subscriber = new WindTurbineType1or2IECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType1or2IECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType1or2IEC...");
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
	 * jumpstart the process by instantiating2 WindTurbineType1or2IEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType1or2IECId = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
		.createWindTurbineType1or2IEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
				.createWindTurbineType1or2IEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType1or2IECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType1or2IEC : " + successValue.getWindTurbineType1or2IECId());
							  if (successValue.getWindTurbineType1or2IECId().equals(windTurbineType1or2IECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType1or2IECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType1or2IEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType1or2IEC consumed")
					);
			subscriber.windTurbineType1or2IECSubscribe( windTurbineType1or2IECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType1or2IEC : " + successValue.getWindTurbineType1or2IECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType1or2IECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType1or2IEC for windTurbineType1or2IECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType1or2IEC. 
	 */
	protected WindTurbineType1or2IEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType1or2IEC" );

		WindTurbineType1or2IEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType1or2IEC with primary key" );
		msg.append( windTurbineType1or2IECId );
		
		WindTurbineType1or2IECFetchOneSummary fetchOneSummary = new WindTurbineType1or2IECFetchOneSummary( windTurbineType1or2IECId );

		try {
			entity = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().getWindTurbineType1or2IEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType1or2IEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType1or2IEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType1or2IEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType1or2IEC : " );        
		WindTurbineType1or2IEC entity = read();
		UpdateWindTurbineType1or2IECCommand command = generateUpdateCommand();
		command.setWindTurbineType1or2IECId(entity.getWindTurbineType1or2IECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType1or2IEC." );

			// for use later on...
			windTurbineType1or2IECId = entity.getWindTurbineType1or2IECId();

			WindTurbineType1or2IECBusinessDelegate proxy = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance();  

			proxy.updateWindTurbineType1or2IEC( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType1or2IEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType1or2IECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType1or2IEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType1or2IEC." );

		WindTurbineType1or2IEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType1or2IEC with id " + windTurbineType1or2IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType1or2IEC with id " + windTurbineType1or2IECId );

			throw e;
		}

		try{
			WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().delete( new DeleteWindTurbineType1or2IECCommand( entity.getWindTurbineType1or2IECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType1or2IEC with id " + windTurbineType1or2IECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType1or2IEC with id " + windTurbineType1or2IECId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType1or2IECs.
	 */
	protected List<WindTurbineType1or2IEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType1or2IECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType1or2IEC : " );        
		List<WindTurbineType1or2IEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType1or2IECBusinessDelegate
			collection = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().getAllWindTurbineType1or2IEC();
			assertNotNull( collection, "An Empty collection of WindTurbineType1or2IEC was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType1or2IEC entity = null;            
			Iterator<WindTurbineType1or2IEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType1or2IECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType1or2IECTest
	 */
	protected WindTurbineType1or2IECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType1or2IEC
	 * 
	 * @return CreateWindTurbineType1or2IECCommand alias
	 */
	protected CreateWindTurbineType1or2IECCommand generateNewCommand() {
        CreateWindTurbineType1or2IECCommand command = new CreateWindTurbineType1or2IECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType1or2IEC
		 * 
		 * @return UpdateWindTurbineType1or2IECCommand alias
		 */
	protected UpdateWindTurbineType1or2IECCommand generateUpdateCommand() {
	        UpdateWindTurbineType1or2IECCommand command = new UpdateWindTurbineType1or2IECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType1or2IECId = null;
	protected WindTurbineType1or2IECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType1or2IECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType1or2IECList = 0;
}
