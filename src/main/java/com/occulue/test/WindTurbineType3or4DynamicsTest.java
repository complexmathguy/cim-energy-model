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
 * Test WindTurbineType3or4Dynamics class.
 *
 * @author your_name_here
 */
public class WindTurbineType3or4DynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType3or4DynamicsTest() {
		subscriber = new WindTurbineType3or4DynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType3or4DynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType3or4Dynamics...");
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
	 * jumpstart the process by instantiating2 WindTurbineType3or4Dynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType3or4DynamicsId = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
		.createWindTurbineType3or4Dynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance()
				.createWindTurbineType3or4Dynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType3or4DynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType3or4Dynamics : " + successValue.getWindTurbineType3or4DynamicsId());
							  if (successValue.getWindTurbineType3or4DynamicsId().equals(windTurbineType3or4DynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType3or4DynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType3or4Dynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType3or4Dynamics consumed")
					);
			subscriber.windTurbineType3or4DynamicsSubscribe( windTurbineType3or4DynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType3or4Dynamics : " + successValue.getWindTurbineType3or4DynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType3or4DynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType3or4Dynamics for windTurbineType3or4DynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType3or4Dynamics. 
	 */
	protected WindTurbineType3or4Dynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType3or4Dynamics" );

		WindTurbineType3or4Dynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType3or4Dynamics with primary key" );
		msg.append( windTurbineType3or4DynamicsId );
		
		WindTurbineType3or4DynamicsFetchOneSummary fetchOneSummary = new WindTurbineType3or4DynamicsFetchOneSummary( windTurbineType3or4DynamicsId );

		try {
			entity = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance().getWindTurbineType3or4Dynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType3or4Dynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType3or4Dynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType3or4Dynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType3or4Dynamics : " );        
		WindTurbineType3or4Dynamics entity = read();
		UpdateWindTurbineType3or4DynamicsCommand command = generateUpdateCommand();
		command.setWindTurbineType3or4DynamicsId(entity.getWindTurbineType3or4DynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType3or4Dynamics." );

			// for use later on...
			windTurbineType3or4DynamicsId = entity.getWindTurbineType3or4DynamicsId();

			WindTurbineType3or4DynamicsBusinessDelegate proxy = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance();  

			proxy.updateWindTurbineType3or4Dynamics( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType3or4Dynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType3or4DynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType3or4Dynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType3or4Dynamics." );

		WindTurbineType3or4Dynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType3or4Dynamics with id " + windTurbineType3or4DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType3or4Dynamics with id " + windTurbineType3or4DynamicsId );

			throw e;
		}

		try{
			WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance().delete( new DeleteWindTurbineType3or4DynamicsCommand( entity.getWindTurbineType3or4DynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType3or4Dynamics with id " + windTurbineType3or4DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType3or4Dynamics with id " + windTurbineType3or4DynamicsId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType3or4Dynamicss.
	 */
	protected List<WindTurbineType3or4Dynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType3or4Dynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType3or4Dynamics : " );        
		List<WindTurbineType3or4Dynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType3or4DynamicsBusinessDelegate
			collection = WindTurbineType3or4DynamicsBusinessDelegate.getWindTurbineType3or4DynamicsInstance().getAllWindTurbineType3or4Dynamics();
			assertNotNull( collection, "An Empty collection of WindTurbineType3or4Dynamics was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType3or4Dynamics entity = null;            
			Iterator<WindTurbineType3or4Dynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType3or4DynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType3or4DynamicsTest
	 */
	protected WindTurbineType3or4DynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType3or4Dynamics
	 * 
	 * @return CreateWindTurbineType3or4DynamicsCommand alias
	 */
	protected CreateWindTurbineType3or4DynamicsCommand generateNewCommand() {
        CreateWindTurbineType3or4DynamicsCommand command = new CreateWindTurbineType3or4DynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType3or4Dynamics
		 * 
		 * @return UpdateWindTurbineType3or4DynamicsCommand alias
		 */
	protected UpdateWindTurbineType3or4DynamicsCommand generateUpdateCommand() {
	        UpdateWindTurbineType3or4DynamicsCommand command = new UpdateWindTurbineType3or4DynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType3or4DynamicsId = null;
	protected WindTurbineType3or4DynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType3or4DynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType3or4DynamicsList = 0;
}
