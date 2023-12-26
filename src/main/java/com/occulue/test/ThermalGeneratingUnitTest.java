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
 * Test ThermalGeneratingUnit class.
 *
 * @author your_name_here
 */
public class ThermalGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ThermalGeneratingUnitTest() {
		subscriber = new ThermalGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ThermalGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ThermalGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 ThermalGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		thermalGeneratingUnitId = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance()
		.createThermalGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance()
				.createThermalGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.thermalGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ThermalGeneratingUnit : " + successValue.getThermalGeneratingUnitId());
							  if (successValue.getThermalGeneratingUnitId().equals(thermalGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfThermalGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ThermalGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on thermalGeneratingUnit consumed")
					);
			subscriber.thermalGeneratingUnitSubscribe( thermalGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ThermalGeneratingUnit : " + successValue.getThermalGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfThermalGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on thermalGeneratingUnit for thermalGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ThermalGeneratingUnit. 
	 */
	protected ThermalGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ThermalGeneratingUnit" );

		ThermalGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ThermalGeneratingUnit with primary key" );
		msg.append( thermalGeneratingUnitId );
		
		ThermalGeneratingUnitFetchOneSummary fetchOneSummary = new ThermalGeneratingUnitFetchOneSummary( thermalGeneratingUnitId );

		try {
			entity = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().getThermalGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ThermalGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ThermalGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ThermalGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a ThermalGeneratingUnit : " );        
		ThermalGeneratingUnit entity = read();
		UpdateThermalGeneratingUnitCommand command = generateUpdateCommand();
		command.setThermalGeneratingUnitId(entity.getThermalGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ThermalGeneratingUnit." );

			// for use later on...
			thermalGeneratingUnitId = entity.getThermalGeneratingUnitId();

			ThermalGeneratingUnitBusinessDelegate proxy = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance();  

			proxy.updateThermalGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved ThermalGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + thermalGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ThermalGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ThermalGeneratingUnit." );

		ThermalGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ThermalGeneratingUnit with id " + thermalGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ThermalGeneratingUnit with id " + thermalGeneratingUnitId );

			throw e;
		}

		try{
			ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().delete( new DeleteThermalGeneratingUnitCommand( entity.getThermalGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted ThermalGeneratingUnit with id " + thermalGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ThermalGeneratingUnit with id " + thermalGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all ThermalGeneratingUnits.
	 */
	protected List<ThermalGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ThermalGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ThermalGeneratingUnit : " );        
		List<ThermalGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the ThermalGeneratingUnitBusinessDelegate
			collection = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().getAllThermalGeneratingUnit();
			assertNotNull( collection, "An Empty collection of ThermalGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			ThermalGeneratingUnit entity = null;            
			Iterator<ThermalGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getThermalGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ThermalGeneratingUnitTest
	 */
	protected ThermalGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ThermalGeneratingUnit
	 * 
	 * @return CreateThermalGeneratingUnitCommand alias
	 */
	protected CreateThermalGeneratingUnitCommand generateNewCommand() {
        CreateThermalGeneratingUnitCommand command = new CreateThermalGeneratingUnitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ThermalGeneratingUnit
		 * 
		 * @return UpdateThermalGeneratingUnitCommand alias
		 */
	protected UpdateThermalGeneratingUnitCommand generateUpdateCommand() {
	        UpdateThermalGeneratingUnitCommand command = new UpdateThermalGeneratingUnitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID thermalGeneratingUnitId = null;
	protected ThermalGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ThermalGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfThermalGeneratingUnitList = 0;
}
