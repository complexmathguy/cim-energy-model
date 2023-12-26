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
 * Test Temperature class.
 *
 * @author your_name_here
 */
public class TemperatureTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TemperatureTest() {
		subscriber = new TemperatureSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TemperatureTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Temperature...");
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
	 * jumpstart the process by instantiating2 Temperature
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		temperatureId = TemperatureBusinessDelegate.getTemperatureInstance()
		.createTemperature( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TemperatureBusinessDelegate.getTemperatureInstance()
				.createTemperature( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.temperatureSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Temperature : " + successValue.getTemperatureId());
							  if (successValue.getTemperatureId().equals(temperatureId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTemperatureList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Temperature test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on temperature consumed")
					);
			subscriber.temperatureSubscribe( temperatureId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Temperature : " + successValue.getTemperatureId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTemperatureList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on temperature for temperatureId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Temperature. 
	 */
	protected Temperature read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Temperature" );

		Temperature entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Temperature with primary key" );
		msg.append( temperatureId );
		
		TemperatureFetchOneSummary fetchOneSummary = new TemperatureFetchOneSummary( temperatureId );

		try {
			entity = TemperatureBusinessDelegate.getTemperatureInstance().getTemperature( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Temperature " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Temperature.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Temperature." );

		StringBuilder msg = new StringBuilder( "Failed to update a Temperature : " );        
		Temperature entity = read();
		UpdateTemperatureCommand command = generateUpdateCommand();
		command.setTemperatureId(entity.getTemperatureId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Temperature." );

			// for use later on...
			temperatureId = entity.getTemperatureId();

			TemperatureBusinessDelegate proxy = TemperatureBusinessDelegate.getTemperatureInstance();  

			proxy.updateTemperature( command ).get();

			LOGGER.info( "-- Successfully saved Temperature - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + temperatureId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Temperature.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Temperature." );

		Temperature entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Temperature with id " + temperatureId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Temperature with id " + temperatureId );

			throw e;
		}

		try{
			TemperatureBusinessDelegate.getTemperatureInstance().delete( new DeleteTemperatureCommand( entity.getTemperatureId() ) ).get();
			LOGGER.info( "-- Successfully deleted Temperature with id " + temperatureId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Temperature with id " + temperatureId );

			throw e;
		}
	}

	/**
	 * get all Temperatures.
	 */
	protected List<Temperature> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Temperatures:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Temperature : " );        
		List<Temperature> collection  = new ArrayList<>();

		try {
			// call the static get method on the TemperatureBusinessDelegate
			collection = TemperatureBusinessDelegate.getTemperatureInstance().getAllTemperature();
			assertNotNull( collection, "An Empty collection of Temperature was incorrectly returned.");
			
			// Now print out the values
			Temperature entity = null;            
			Iterator<Temperature> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTemperatureId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TemperatureTest
	 */
	protected TemperatureTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Temperature
	 * 
	 * @return CreateTemperatureCommand alias
	 */
	protected CreateTemperatureCommand generateNewCommand() {
        CreateTemperatureCommand command = new CreateTemperatureCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Temperature
		 * 
		 * @return UpdateTemperatureCommand alias
		 */
	protected UpdateTemperatureCommand generateUpdateCommand() {
	        UpdateTemperatureCommand command = new UpdateTemperatureCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID temperatureId = null;
	protected TemperatureSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TemperatureTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTemperatureList = 0;
}
