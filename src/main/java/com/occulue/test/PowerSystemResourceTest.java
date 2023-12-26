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
 * Test PowerSystemResource class.
 *
 * @author your_name_here
 */
public class PowerSystemResourceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PowerSystemResourceTest() {
		subscriber = new PowerSystemResourceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PowerSystemResourceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PowerSystemResource...");
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
	 * jumpstart the process by instantiating2 PowerSystemResource
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		powerSystemResourceId = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance()
		.createPowerSystemResource( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance()
				.createPowerSystemResource( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.powerSystemResourceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PowerSystemResource : " + successValue.getPowerSystemResourceId());
							  if (successValue.getPowerSystemResourceId().equals(powerSystemResourceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPowerSystemResourceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PowerSystemResource test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemResource consumed")
					);
			subscriber.powerSystemResourceSubscribe( powerSystemResourceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PowerSystemResource : " + successValue.getPowerSystemResourceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPowerSystemResourceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemResource for powerSystemResourceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PowerSystemResource. 
	 */
	protected PowerSystemResource read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PowerSystemResource" );

		PowerSystemResource entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PowerSystemResource with primary key" );
		msg.append( powerSystemResourceId );
		
		PowerSystemResourceFetchOneSummary fetchOneSummary = new PowerSystemResourceFetchOneSummary( powerSystemResourceId );

		try {
			entity = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().getPowerSystemResource( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PowerSystemResource " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PowerSystemResource.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PowerSystemResource." );

		StringBuilder msg = new StringBuilder( "Failed to update a PowerSystemResource : " );        
		PowerSystemResource entity = read();
		UpdatePowerSystemResourceCommand command = generateUpdateCommand();
		command.setPowerSystemResourceId(entity.getPowerSystemResourceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PowerSystemResource." );

			// for use later on...
			powerSystemResourceId = entity.getPowerSystemResourceId();

			PowerSystemResourceBusinessDelegate proxy = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance();  

			proxy.updatePowerSystemResource( command ).get();

			LOGGER.info( "-- Successfully saved PowerSystemResource - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + powerSystemResourceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PowerSystemResource.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PowerSystemResource." );

		PowerSystemResource entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PowerSystemResource with id " + powerSystemResourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PowerSystemResource with id " + powerSystemResourceId );

			throw e;
		}

		try{
			PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().delete( new DeletePowerSystemResourceCommand( entity.getPowerSystemResourceId() ) ).get();
			LOGGER.info( "-- Successfully deleted PowerSystemResource with id " + powerSystemResourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PowerSystemResource with id " + powerSystemResourceId );

			throw e;
		}
	}

	/**
	 * get all PowerSystemResources.
	 */
	protected List<PowerSystemResource> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PowerSystemResources:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PowerSystemResource : " );        
		List<PowerSystemResource> collection  = new ArrayList<>();

		try {
			// call the static get method on the PowerSystemResourceBusinessDelegate
			collection = PowerSystemResourceBusinessDelegate.getPowerSystemResourceInstance().getAllPowerSystemResource();
			assertNotNull( collection, "An Empty collection of PowerSystemResource was incorrectly returned.");
			
			// Now print out the values
			PowerSystemResource entity = null;            
			Iterator<PowerSystemResource> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPowerSystemResourceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PowerSystemResourceTest
	 */
	protected PowerSystemResourceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PowerSystemResource
	 * 
	 * @return CreatePowerSystemResourceCommand alias
	 */
	protected CreatePowerSystemResourceCommand generateNewCommand() {
        CreatePowerSystemResourceCommand command = new CreatePowerSystemResourceCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PowerSystemResource
		 * 
		 * @return UpdatePowerSystemResourceCommand alias
		 */
	protected UpdatePowerSystemResourceCommand generateUpdateCommand() {
	        UpdatePowerSystemResourceCommand command = new UpdatePowerSystemResourceCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID powerSystemResourceId = null;
	protected PowerSystemResourceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PowerSystemResourceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPowerSystemResourceList = 0;
}
