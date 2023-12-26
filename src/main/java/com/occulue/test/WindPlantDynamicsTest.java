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
 * Test WindPlantDynamics class.
 *
 * @author your_name_here
 */
public class WindPlantDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindPlantDynamicsTest() {
		subscriber = new WindPlantDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindPlantDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindPlantDynamics...");
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
	 * jumpstart the process by instantiating2 WindPlantDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windPlantDynamicsId = WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
		.createWindPlantDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
				.createWindPlantDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windPlantDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindPlantDynamics : " + successValue.getWindPlantDynamicsId());
							  if (successValue.getWindPlantDynamicsId().equals(windPlantDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindPlantDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindPlantDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantDynamics consumed")
					);
			subscriber.windPlantDynamicsSubscribe( windPlantDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindPlantDynamics : " + successValue.getWindPlantDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindPlantDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windPlantDynamics for windPlantDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindPlantDynamics. 
	 */
	protected WindPlantDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindPlantDynamics" );

		WindPlantDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindPlantDynamics with primary key" );
		msg.append( windPlantDynamicsId );
		
		WindPlantDynamicsFetchOneSummary fetchOneSummary = new WindPlantDynamicsFetchOneSummary( windPlantDynamicsId );

		try {
			entity = WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance().getWindPlantDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindPlantDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindPlantDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindPlantDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindPlantDynamics : " );        
		WindPlantDynamics entity = read();
		UpdateWindPlantDynamicsCommand command = generateUpdateCommand();
		command.setWindPlantDynamicsId(entity.getWindPlantDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindPlantDynamics." );

			// for use later on...
			windPlantDynamicsId = entity.getWindPlantDynamicsId();

			WindPlantDynamicsBusinessDelegate proxy = WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance();  

			proxy.updateWindPlantDynamics( command ).get();

			LOGGER.info( "-- Successfully saved WindPlantDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windPlantDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindPlantDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindPlantDynamics." );

		WindPlantDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindPlantDynamics with id " + windPlantDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindPlantDynamics with id " + windPlantDynamicsId );

			throw e;
		}

		try{
			WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance().delete( new DeleteWindPlantDynamicsCommand( entity.getWindPlantDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindPlantDynamics with id " + windPlantDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindPlantDynamics with id " + windPlantDynamicsId );

			throw e;
		}
	}

	/**
	 * get all WindPlantDynamicss.
	 */
	protected List<WindPlantDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindPlantDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindPlantDynamics : " );        
		List<WindPlantDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindPlantDynamicsBusinessDelegate
			collection = WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance().getAllWindPlantDynamics();
			assertNotNull( collection, "An Empty collection of WindPlantDynamics was incorrectly returned.");
			
			// Now print out the values
			WindPlantDynamics entity = null;            
			Iterator<WindPlantDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindPlantDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindPlantDynamicsTest
	 */
	protected WindPlantDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindPlantDynamics
	 * 
	 * @return CreateWindPlantDynamicsCommand alias
	 */
	protected CreateWindPlantDynamicsCommand generateNewCommand() {
        CreateWindPlantDynamicsCommand command = new CreateWindPlantDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindPlantDynamics
		 * 
		 * @return UpdateWindPlantDynamicsCommand alias
		 */
	protected UpdateWindPlantDynamicsCommand generateUpdateCommand() {
	        UpdateWindPlantDynamicsCommand command = new UpdateWindPlantDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windPlantDynamicsId = null;
	protected WindPlantDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindPlantDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindPlantDynamicsList = 0;
}
