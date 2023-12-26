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
 * Test LoadGenericNonLinear class.
 *
 * @author your_name_here
 */
public class LoadGenericNonLinearTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadGenericNonLinearTest() {
		subscriber = new LoadGenericNonLinearSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadGenericNonLinearTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadGenericNonLinear...");
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
	 * jumpstart the process by instantiating2 LoadGenericNonLinear
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadGenericNonLinearId = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance()
		.createLoadGenericNonLinear( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance()
				.createLoadGenericNonLinear( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadGenericNonLinearSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadGenericNonLinear : " + successValue.getLoadGenericNonLinearId());
							  if (successValue.getLoadGenericNonLinearId().equals(loadGenericNonLinearId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadGenericNonLinearList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadGenericNonLinear test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadGenericNonLinear consumed")
					);
			subscriber.loadGenericNonLinearSubscribe( loadGenericNonLinearId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadGenericNonLinear : " + successValue.getLoadGenericNonLinearId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadGenericNonLinearList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadGenericNonLinear for loadGenericNonLinearId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadGenericNonLinear. 
	 */
	protected LoadGenericNonLinear read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadGenericNonLinear" );

		LoadGenericNonLinear entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadGenericNonLinear with primary key" );
		msg.append( loadGenericNonLinearId );
		
		LoadGenericNonLinearFetchOneSummary fetchOneSummary = new LoadGenericNonLinearFetchOneSummary( loadGenericNonLinearId );

		try {
			entity = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().getLoadGenericNonLinear( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadGenericNonLinear " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadGenericNonLinear.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadGenericNonLinear." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadGenericNonLinear : " );        
		LoadGenericNonLinear entity = read();
		UpdateLoadGenericNonLinearCommand command = generateUpdateCommand();
		command.setLoadGenericNonLinearId(entity.getLoadGenericNonLinearId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadGenericNonLinear." );

			// for use later on...
			loadGenericNonLinearId = entity.getLoadGenericNonLinearId();

			LoadGenericNonLinearBusinessDelegate proxy = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();  

			proxy.updateLoadGenericNonLinear( command ).get();

			LOGGER.info( "-- Successfully saved LoadGenericNonLinear - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadGenericNonLinearId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadGenericNonLinear.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadGenericNonLinear." );

		LoadGenericNonLinear entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadGenericNonLinear with id " + loadGenericNonLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadGenericNonLinear with id " + loadGenericNonLinearId );

			throw e;
		}

		try{
			LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().delete( new DeleteLoadGenericNonLinearCommand( entity.getLoadGenericNonLinearId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadGenericNonLinear with id " + loadGenericNonLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadGenericNonLinear with id " + loadGenericNonLinearId );

			throw e;
		}
	}

	/**
	 * get all LoadGenericNonLinears.
	 */
	protected List<LoadGenericNonLinear> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadGenericNonLinears:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadGenericNonLinear : " );        
		List<LoadGenericNonLinear> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadGenericNonLinearBusinessDelegate
			collection = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().getAllLoadGenericNonLinear();
			assertNotNull( collection, "An Empty collection of LoadGenericNonLinear was incorrectly returned.");
			
			// Now print out the values
			LoadGenericNonLinear entity = null;            
			Iterator<LoadGenericNonLinear> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadGenericNonLinearId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadGenericNonLinearTest
	 */
	protected LoadGenericNonLinearTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadGenericNonLinear
	 * 
	 * @return CreateLoadGenericNonLinearCommand alias
	 */
	protected CreateLoadGenericNonLinearCommand generateNewCommand() {
        CreateLoadGenericNonLinearCommand command = new CreateLoadGenericNonLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadGenericNonLinear
		 * 
		 * @return UpdateLoadGenericNonLinearCommand alias
		 */
	protected UpdateLoadGenericNonLinearCommand generateUpdateCommand() {
	        UpdateLoadGenericNonLinearCommand command = new UpdateLoadGenericNonLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadGenericNonLinearId = null;
	protected LoadGenericNonLinearSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadGenericNonLinearTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadGenericNonLinearList = 0;
}
