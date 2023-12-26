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
 * Test WindTurbineType1or2Dynamics class.
 *
 * @author your_name_here
 */
public class WindTurbineType1or2DynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindTurbineType1or2DynamicsTest() {
		subscriber = new WindTurbineType1or2DynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindTurbineType1or2DynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindTurbineType1or2Dynamics...");
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
	 * jumpstart the process by instantiating2 WindTurbineType1or2Dynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windTurbineType1or2DynamicsId = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
		.createWindTurbineType1or2Dynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance()
				.createWindTurbineType1or2Dynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windTurbineType1or2DynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindTurbineType1or2Dynamics : " + successValue.getWindTurbineType1or2DynamicsId());
							  if (successValue.getWindTurbineType1or2DynamicsId().equals(windTurbineType1or2DynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindTurbineType1or2DynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindTurbineType1or2Dynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType1or2Dynamics consumed")
					);
			subscriber.windTurbineType1or2DynamicsSubscribe( windTurbineType1or2DynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindTurbineType1or2Dynamics : " + successValue.getWindTurbineType1or2DynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindTurbineType1or2DynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windTurbineType1or2Dynamics for windTurbineType1or2DynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindTurbineType1or2Dynamics. 
	 */
	protected WindTurbineType1or2Dynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindTurbineType1or2Dynamics" );

		WindTurbineType1or2Dynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindTurbineType1or2Dynamics with primary key" );
		msg.append( windTurbineType1or2DynamicsId );
		
		WindTurbineType1or2DynamicsFetchOneSummary fetchOneSummary = new WindTurbineType1or2DynamicsFetchOneSummary( windTurbineType1or2DynamicsId );

		try {
			entity = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance().getWindTurbineType1or2Dynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindTurbineType1or2Dynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindTurbineType1or2Dynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindTurbineType1or2Dynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindTurbineType1or2Dynamics : " );        
		WindTurbineType1or2Dynamics entity = read();
		UpdateWindTurbineType1or2DynamicsCommand command = generateUpdateCommand();
		command.setWindTurbineType1or2DynamicsId(entity.getWindTurbineType1or2DynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindTurbineType1or2Dynamics." );

			// for use later on...
			windTurbineType1or2DynamicsId = entity.getWindTurbineType1or2DynamicsId();

			WindTurbineType1or2DynamicsBusinessDelegate proxy = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance();  

			proxy.updateWindTurbineType1or2Dynamics( command ).get();

			LOGGER.info( "-- Successfully saved WindTurbineType1or2Dynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windTurbineType1or2DynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindTurbineType1or2Dynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindTurbineType1or2Dynamics." );

		WindTurbineType1or2Dynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindTurbineType1or2Dynamics with id " + windTurbineType1or2DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindTurbineType1or2Dynamics with id " + windTurbineType1or2DynamicsId );

			throw e;
		}

		try{
			WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance().delete( new DeleteWindTurbineType1or2DynamicsCommand( entity.getWindTurbineType1or2DynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindTurbineType1or2Dynamics with id " + windTurbineType1or2DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindTurbineType1or2Dynamics with id " + windTurbineType1or2DynamicsId );

			throw e;
		}
	}

	/**
	 * get all WindTurbineType1or2Dynamicss.
	 */
	protected List<WindTurbineType1or2Dynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindTurbineType1or2Dynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindTurbineType1or2Dynamics : " );        
		List<WindTurbineType1or2Dynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindTurbineType1or2DynamicsBusinessDelegate
			collection = WindTurbineType1or2DynamicsBusinessDelegate.getWindTurbineType1or2DynamicsInstance().getAllWindTurbineType1or2Dynamics();
			assertNotNull( collection, "An Empty collection of WindTurbineType1or2Dynamics was incorrectly returned.");
			
			// Now print out the values
			WindTurbineType1or2Dynamics entity = null;            
			Iterator<WindTurbineType1or2Dynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindTurbineType1or2DynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindTurbineType1or2DynamicsTest
	 */
	protected WindTurbineType1or2DynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindTurbineType1or2Dynamics
	 * 
	 * @return CreateWindTurbineType1or2DynamicsCommand alias
	 */
	protected CreateWindTurbineType1or2DynamicsCommand generateNewCommand() {
        CreateWindTurbineType1or2DynamicsCommand command = new CreateWindTurbineType1or2DynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindTurbineType1or2Dynamics
		 * 
		 * @return UpdateWindTurbineType1or2DynamicsCommand alias
		 */
	protected UpdateWindTurbineType1or2DynamicsCommand generateUpdateCommand() {
	        UpdateWindTurbineType1or2DynamicsCommand command = new UpdateWindTurbineType1or2DynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windTurbineType1or2DynamicsId = null;
	protected WindTurbineType1or2DynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindTurbineType1or2DynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindTurbineType1or2DynamicsList = 0;
}
