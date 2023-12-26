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
 * Test LoadResponseCharacteristic class.
 *
 * @author your_name_here
 */
public class LoadResponseCharacteristicTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadResponseCharacteristicTest() {
		subscriber = new LoadResponseCharacteristicSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadResponseCharacteristicTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadResponseCharacteristic...");
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
	 * jumpstart the process by instantiating2 LoadResponseCharacteristic
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadResponseCharacteristicId = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
		.createLoadResponseCharacteristic( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
				.createLoadResponseCharacteristic( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadResponseCharacteristicSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadResponseCharacteristic : " + successValue.getLoadResponseCharacteristicId());
							  if (successValue.getLoadResponseCharacteristicId().equals(loadResponseCharacteristicId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadResponseCharacteristicList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadResponseCharacteristic test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadResponseCharacteristic consumed")
					);
			subscriber.loadResponseCharacteristicSubscribe( loadResponseCharacteristicId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadResponseCharacteristic : " + successValue.getLoadResponseCharacteristicId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadResponseCharacteristicList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadResponseCharacteristic for loadResponseCharacteristicId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadResponseCharacteristic. 
	 */
	protected LoadResponseCharacteristic read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadResponseCharacteristic" );

		LoadResponseCharacteristic entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadResponseCharacteristic with primary key" );
		msg.append( loadResponseCharacteristicId );
		
		LoadResponseCharacteristicFetchOneSummary fetchOneSummary = new LoadResponseCharacteristicFetchOneSummary( loadResponseCharacteristicId );

		try {
			entity = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance().getLoadResponseCharacteristic( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadResponseCharacteristic " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadResponseCharacteristic.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadResponseCharacteristic." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadResponseCharacteristic : " );        
		LoadResponseCharacteristic entity = read();
		UpdateLoadResponseCharacteristicCommand command = generateUpdateCommand();
		command.setLoadResponseCharacteristicId(entity.getLoadResponseCharacteristicId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadResponseCharacteristic." );

			// for use later on...
			loadResponseCharacteristicId = entity.getLoadResponseCharacteristicId();

			LoadResponseCharacteristicBusinessDelegate proxy = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();  

			proxy.updateLoadResponseCharacteristic( command ).get();

			LOGGER.info( "-- Successfully saved LoadResponseCharacteristic - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadResponseCharacteristicId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadResponseCharacteristic.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadResponseCharacteristic." );

		LoadResponseCharacteristic entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadResponseCharacteristic with id " + loadResponseCharacteristicId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadResponseCharacteristic with id " + loadResponseCharacteristicId );

			throw e;
		}

		try{
			LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance().delete( new DeleteLoadResponseCharacteristicCommand( entity.getLoadResponseCharacteristicId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadResponseCharacteristic with id " + loadResponseCharacteristicId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadResponseCharacteristic with id " + loadResponseCharacteristicId );

			throw e;
		}
	}

	/**
	 * get all LoadResponseCharacteristics.
	 */
	protected List<LoadResponseCharacteristic> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadResponseCharacteristics:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadResponseCharacteristic : " );        
		List<LoadResponseCharacteristic> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadResponseCharacteristicBusinessDelegate
			collection = LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance().getAllLoadResponseCharacteristic();
			assertNotNull( collection, "An Empty collection of LoadResponseCharacteristic was incorrectly returned.");
			
			// Now print out the values
			LoadResponseCharacteristic entity = null;            
			Iterator<LoadResponseCharacteristic> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadResponseCharacteristicId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadResponseCharacteristicTest
	 */
	protected LoadResponseCharacteristicTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadResponseCharacteristic
	 * 
	 * @return CreateLoadResponseCharacteristicCommand alias
	 */
	protected CreateLoadResponseCharacteristicCommand generateNewCommand() {
        CreateLoadResponseCharacteristicCommand command = new CreateLoadResponseCharacteristicCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadResponseCharacteristic
		 * 
		 * @return UpdateLoadResponseCharacteristicCommand alias
		 */
	protected UpdateLoadResponseCharacteristicCommand generateUpdateCommand() {
	        UpdateLoadResponseCharacteristicCommand command = new UpdateLoadResponseCharacteristicCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadResponseCharacteristicId = null;
	protected LoadResponseCharacteristicSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadResponseCharacteristicTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadResponseCharacteristicList = 0;
}
