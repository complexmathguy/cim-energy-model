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
 * Test WindDynamicsLookupTable class.
 *
 * @author your_name_here
 */
public class WindDynamicsLookupTableTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindDynamicsLookupTableTest() {
		subscriber = new WindDynamicsLookupTableSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindDynamicsLookupTableTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindDynamicsLookupTable...");
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
	 * jumpstart the process by instantiating2 WindDynamicsLookupTable
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windDynamicsLookupTableId = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance()
		.createWindDynamicsLookupTable( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance()
				.createWindDynamicsLookupTable( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windDynamicsLookupTableSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindDynamicsLookupTable : " + successValue.getWindDynamicsLookupTableId());
							  if (successValue.getWindDynamicsLookupTableId().equals(windDynamicsLookupTableId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindDynamicsLookupTableList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindDynamicsLookupTable test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windDynamicsLookupTable consumed")
					);
			subscriber.windDynamicsLookupTableSubscribe( windDynamicsLookupTableId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindDynamicsLookupTable : " + successValue.getWindDynamicsLookupTableId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindDynamicsLookupTableList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windDynamicsLookupTable for windDynamicsLookupTableId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindDynamicsLookupTable. 
	 */
	protected WindDynamicsLookupTable read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindDynamicsLookupTable" );

		WindDynamicsLookupTable entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindDynamicsLookupTable with primary key" );
		msg.append( windDynamicsLookupTableId );
		
		WindDynamicsLookupTableFetchOneSummary fetchOneSummary = new WindDynamicsLookupTableFetchOneSummary( windDynamicsLookupTableId );

		try {
			entity = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().getWindDynamicsLookupTable( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindDynamicsLookupTable " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindDynamicsLookupTable.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindDynamicsLookupTable." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindDynamicsLookupTable : " );        
		WindDynamicsLookupTable entity = read();
		UpdateWindDynamicsLookupTableCommand command = generateUpdateCommand();
		command.setWindDynamicsLookupTableId(entity.getWindDynamicsLookupTableId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindDynamicsLookupTable." );

			// for use later on...
			windDynamicsLookupTableId = entity.getWindDynamicsLookupTableId();

			WindDynamicsLookupTableBusinessDelegate proxy = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance();  

			proxy.updateWindDynamicsLookupTable( command ).get();

			LOGGER.info( "-- Successfully saved WindDynamicsLookupTable - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windDynamicsLookupTableId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindDynamicsLookupTable.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindDynamicsLookupTable." );

		WindDynamicsLookupTable entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindDynamicsLookupTable with id " + windDynamicsLookupTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindDynamicsLookupTable with id " + windDynamicsLookupTableId );

			throw e;
		}

		try{
			WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().delete( new DeleteWindDynamicsLookupTableCommand( entity.getWindDynamicsLookupTableId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindDynamicsLookupTable with id " + windDynamicsLookupTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindDynamicsLookupTable with id " + windDynamicsLookupTableId );

			throw e;
		}
	}

	/**
	 * get all WindDynamicsLookupTables.
	 */
	protected List<WindDynamicsLookupTable> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindDynamicsLookupTables:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindDynamicsLookupTable : " );        
		List<WindDynamicsLookupTable> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindDynamicsLookupTableBusinessDelegate
			collection = WindDynamicsLookupTableBusinessDelegate.getWindDynamicsLookupTableInstance().getAllWindDynamicsLookupTable();
			assertNotNull( collection, "An Empty collection of WindDynamicsLookupTable was incorrectly returned.");
			
			// Now print out the values
			WindDynamicsLookupTable entity = null;            
			Iterator<WindDynamicsLookupTable> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindDynamicsLookupTableId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindDynamicsLookupTableTest
	 */
	protected WindDynamicsLookupTableTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindDynamicsLookupTable
	 * 
	 * @return CreateWindDynamicsLookupTableCommand alias
	 */
	protected CreateWindDynamicsLookupTableCommand generateNewCommand() {
        CreateWindDynamicsLookupTableCommand command = new CreateWindDynamicsLookupTableCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindDynamicsLookupTable
		 * 
		 * @return UpdateWindDynamicsLookupTableCommand alias
		 */
	protected UpdateWindDynamicsLookupTableCommand generateUpdateCommand() {
	        UpdateWindDynamicsLookupTableCommand command = new UpdateWindDynamicsLookupTableCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windDynamicsLookupTableId = null;
	protected WindDynamicsLookupTableSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindDynamicsLookupTableTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindDynamicsLookupTableList = 0;
}
