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
 * Test PowerSystemStabilizerDynamics class.
 *
 * @author your_name_here
 */
public class PowerSystemStabilizerDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PowerSystemStabilizerDynamicsTest() {
		subscriber = new PowerSystemStabilizerDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PowerSystemStabilizerDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PowerSystemStabilizerDynamics...");
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
	 * jumpstart the process by instantiating2 PowerSystemStabilizerDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		powerSystemStabilizerDynamicsId = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance()
		.createPowerSystemStabilizerDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance()
				.createPowerSystemStabilizerDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.powerSystemStabilizerDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PowerSystemStabilizerDynamics : " + successValue.getPowerSystemStabilizerDynamicsId());
							  if (successValue.getPowerSystemStabilizerDynamicsId().equals(powerSystemStabilizerDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPowerSystemStabilizerDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PowerSystemStabilizerDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemStabilizerDynamics consumed")
					);
			subscriber.powerSystemStabilizerDynamicsSubscribe( powerSystemStabilizerDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PowerSystemStabilizerDynamics : " + successValue.getPowerSystemStabilizerDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPowerSystemStabilizerDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemStabilizerDynamics for powerSystemStabilizerDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PowerSystemStabilizerDynamics. 
	 */
	protected PowerSystemStabilizerDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PowerSystemStabilizerDynamics" );

		PowerSystemStabilizerDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PowerSystemStabilizerDynamics with primary key" );
		msg.append( powerSystemStabilizerDynamicsId );
		
		PowerSystemStabilizerDynamicsFetchOneSummary fetchOneSummary = new PowerSystemStabilizerDynamicsFetchOneSummary( powerSystemStabilizerDynamicsId );

		try {
			entity = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().getPowerSystemStabilizerDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PowerSystemStabilizerDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PowerSystemStabilizerDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PowerSystemStabilizerDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a PowerSystemStabilizerDynamics : " );        
		PowerSystemStabilizerDynamics entity = read();
		UpdatePowerSystemStabilizerDynamicsCommand command = generateUpdateCommand();
		command.setPowerSystemStabilizerDynamicsId(entity.getPowerSystemStabilizerDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PowerSystemStabilizerDynamics." );

			// for use later on...
			powerSystemStabilizerDynamicsId = entity.getPowerSystemStabilizerDynamicsId();

			PowerSystemStabilizerDynamicsBusinessDelegate proxy = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance();  

			proxy.updatePowerSystemStabilizerDynamics( command ).get();

			LOGGER.info( "-- Successfully saved PowerSystemStabilizerDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + powerSystemStabilizerDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PowerSystemStabilizerDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PowerSystemStabilizerDynamics." );

		PowerSystemStabilizerDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PowerSystemStabilizerDynamics with id " + powerSystemStabilizerDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PowerSystemStabilizerDynamics with id " + powerSystemStabilizerDynamicsId );

			throw e;
		}

		try{
			PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().delete( new DeletePowerSystemStabilizerDynamicsCommand( entity.getPowerSystemStabilizerDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted PowerSystemStabilizerDynamics with id " + powerSystemStabilizerDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PowerSystemStabilizerDynamics with id " + powerSystemStabilizerDynamicsId );

			throw e;
		}
	}

	/**
	 * get all PowerSystemStabilizerDynamicss.
	 */
	protected List<PowerSystemStabilizerDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PowerSystemStabilizerDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PowerSystemStabilizerDynamics : " );        
		List<PowerSystemStabilizerDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the PowerSystemStabilizerDynamicsBusinessDelegate
			collection = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().getAllPowerSystemStabilizerDynamics();
			assertNotNull( collection, "An Empty collection of PowerSystemStabilizerDynamics was incorrectly returned.");
			
			// Now print out the values
			PowerSystemStabilizerDynamics entity = null;            
			Iterator<PowerSystemStabilizerDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPowerSystemStabilizerDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PowerSystemStabilizerDynamicsTest
	 */
	protected PowerSystemStabilizerDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PowerSystemStabilizerDynamics
	 * 
	 * @return CreatePowerSystemStabilizerDynamicsCommand alias
	 */
	protected CreatePowerSystemStabilizerDynamicsCommand generateNewCommand() {
        CreatePowerSystemStabilizerDynamicsCommand command = new CreatePowerSystemStabilizerDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PowerSystemStabilizerDynamics
		 * 
		 * @return UpdatePowerSystemStabilizerDynamicsCommand alias
		 */
	protected UpdatePowerSystemStabilizerDynamicsCommand generateUpdateCommand() {
	        UpdatePowerSystemStabilizerDynamicsCommand command = new UpdatePowerSystemStabilizerDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID powerSystemStabilizerDynamicsId = null;
	protected PowerSystemStabilizerDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PowerSystemStabilizerDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPowerSystemStabilizerDynamicsList = 0;
}
