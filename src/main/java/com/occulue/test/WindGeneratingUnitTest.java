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
 * Test WindGeneratingUnit class.
 *
 * @author your_name_here
 */
public class WindGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindGeneratingUnitTest() {
		subscriber = new WindGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 WindGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windGeneratingUnitId = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance()
		.createWindGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance()
				.createWindGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindGeneratingUnit : " + successValue.getWindGeneratingUnitId());
							  if (successValue.getWindGeneratingUnitId().equals(windGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGeneratingUnit consumed")
					);
			subscriber.windGeneratingUnitSubscribe( windGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindGeneratingUnit : " + successValue.getWindGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windGeneratingUnit for windGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindGeneratingUnit. 
	 */
	protected WindGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindGeneratingUnit" );

		WindGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindGeneratingUnit with primary key" );
		msg.append( windGeneratingUnitId );
		
		WindGeneratingUnitFetchOneSummary fetchOneSummary = new WindGeneratingUnitFetchOneSummary( windGeneratingUnitId );

		try {
			entity = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().getWindGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindGeneratingUnit : " );        
		WindGeneratingUnit entity = read();
		UpdateWindGeneratingUnitCommand command = generateUpdateCommand();
		command.setWindGeneratingUnitId(entity.getWindGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindGeneratingUnit." );

			// for use later on...
			windGeneratingUnitId = entity.getWindGeneratingUnitId();

			WindGeneratingUnitBusinessDelegate proxy = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance();  

			proxy.updateWindGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved WindGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindGeneratingUnit." );

		WindGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindGeneratingUnit with id " + windGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindGeneratingUnit with id " + windGeneratingUnitId );

			throw e;
		}

		try{
			WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().delete( new DeleteWindGeneratingUnitCommand( entity.getWindGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindGeneratingUnit with id " + windGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindGeneratingUnit with id " + windGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all WindGeneratingUnits.
	 */
	protected List<WindGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindGeneratingUnit : " );        
		List<WindGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindGeneratingUnitBusinessDelegate
			collection = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().getAllWindGeneratingUnit();
			assertNotNull( collection, "An Empty collection of WindGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			WindGeneratingUnit entity = null;            
			Iterator<WindGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindGeneratingUnitTest
	 */
	protected WindGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindGeneratingUnit
	 * 
	 * @return CreateWindGeneratingUnitCommand alias
	 */
	protected CreateWindGeneratingUnitCommand generateNewCommand() {
        CreateWindGeneratingUnitCommand command = new CreateWindGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindGeneratingUnit
		 * 
		 * @return UpdateWindGeneratingUnitCommand alias
		 */
	protected UpdateWindGeneratingUnitCommand generateUpdateCommand() {
	        UpdateWindGeneratingUnitCommand command = new UpdateWindGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windGeneratingUnitId = null;
	protected WindGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindGeneratingUnitList = 0;
}
