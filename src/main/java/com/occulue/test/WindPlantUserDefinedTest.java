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
 * Test WindPlantUserDefined class.
 *
 * @author your_name_here
 */
public class WindPlantUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPlantUserDefinedTest() {
		subscriber = new WindPlantUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPlantUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPlantUserDefined...");
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
	 * jumpstart the process by instantiating2 WindPlantUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPlantUserDefinedId = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
		.createWindPlantUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance()
				.createWindPlantUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPlantUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPlantUserDefined : " + successValue.getWindPlantUserDefinedId());
							  if (successValue.getWindPlantUserDefinedId().equals(windPlantUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPlantUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPlantUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantUserDefined consumed")
					);
			subscriber.windPlantUserDefinedSubscribe( windPlantUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPlantUserDefined : " + successValue.getWindPlantUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPlantUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantUserDefined for windPlantUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPlantUserDefined. 
	 */
	protected WindPlantUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPlantUserDefined" );

		WindPlantUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPlantUserDefined with primary key" );
		msg.append( windPlantUserDefinedId );
		
		WindPlantUserDefinedFetchOneSummary fetchOneSummary = new WindPlantUserDefinedFetchOneSummary( windPlantUserDefinedId );

		try {
			entity = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().getWindPlantUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPlantUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPlantUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPlantUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPlantUserDefined : " );        
		WindPlantUserDefined entity = read();
		UpdateWindPlantUserDefinedCommand command = generateUpdateCommand();
		command.setWindPlantUserDefinedId(entity.getWindPlantUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPlantUserDefined." );

			// for use later on...
			windPlantUserDefinedId = entity.getWindPlantUserDefinedId();

			WindPlantUserDefinedBusinessDelegate proxy = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance();  

			proxy.updateWindPlantUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved WindPlantUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPlantUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPlantUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPlantUserDefined." );

		WindPlantUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPlantUserDefined with id " + windPlantUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPlantUserDefined with id " + windPlantUserDefinedId );

			throw e;
		}

		try{
			WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().delete( new DeleteWindPlantUserDefinedCommand( entity.getWindPlantUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPlantUserDefined with id " + windPlantUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPlantUserDefined with id " + windPlantUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all WindPlantUserDefineds.
	 */
	protected List<WindPlantUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPlantUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPlantUserDefined : " );        
		List<WindPlantUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPlantUserDefinedBusinessDelegate
			collection = WindPlantUserDefinedBusinessDelegate.getWindPlantUserDefinedInstance().getAllWindPlantUserDefined();
			assertNotNull( collection, "An Empty collection of WindPlantUserDefined was incorrectly returned.");
			
			// Now print out the values
			WindPlantUserDefined entity = null;            
			Iterator<WindPlantUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPlantUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPlantUserDefinedTest
	 */
	protected WindPlantUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPlantUserDefined
	 * 
	 * @return CreateWindPlantUserDefinedCommand alias
	 */
	protected CreateWindPlantUserDefinedCommand generateNewCommand() {
        CreateWindPlantUserDefinedCommand command = new CreateWindPlantUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPlantUserDefined
		 * 
		 * @return UpdateWindPlantUserDefinedCommand alias
		 */
	protected UpdateWindPlantUserDefinedCommand generateUpdateCommand() {
	        UpdateWindPlantUserDefinedCommand command = new UpdateWindPlantUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPlantUserDefinedId = null;
	protected WindPlantUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPlantUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPlantUserDefinedList = 0;
}
