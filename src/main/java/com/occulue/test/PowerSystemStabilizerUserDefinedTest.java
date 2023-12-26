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
 * Test PowerSystemStabilizerUserDefined class.
 *
 * @author your_name_here
 */
public class PowerSystemStabilizerUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PowerSystemStabilizerUserDefinedTest() {
		subscriber = new PowerSystemStabilizerUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PowerSystemStabilizerUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PowerSystemStabilizerUserDefined...");
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
	 * jumpstart the process by instantiating2 PowerSystemStabilizerUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		powerSystemStabilizerUserDefinedId = PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance()
		.createPowerSystemStabilizerUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance()
				.createPowerSystemStabilizerUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.powerSystemStabilizerUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PowerSystemStabilizerUserDefined : " + successValue.getPowerSystemStabilizerUserDefinedId());
							  if (successValue.getPowerSystemStabilizerUserDefinedId().equals(powerSystemStabilizerUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPowerSystemStabilizerUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PowerSystemStabilizerUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemStabilizerUserDefined consumed")
					);
			subscriber.powerSystemStabilizerUserDefinedSubscribe( powerSystemStabilizerUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PowerSystemStabilizerUserDefined : " + successValue.getPowerSystemStabilizerUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPowerSystemStabilizerUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerSystemStabilizerUserDefined for powerSystemStabilizerUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PowerSystemStabilizerUserDefined. 
	 */
	protected PowerSystemStabilizerUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PowerSystemStabilizerUserDefined" );

		PowerSystemStabilizerUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PowerSystemStabilizerUserDefined with primary key" );
		msg.append( powerSystemStabilizerUserDefinedId );
		
		PowerSystemStabilizerUserDefinedFetchOneSummary fetchOneSummary = new PowerSystemStabilizerUserDefinedFetchOneSummary( powerSystemStabilizerUserDefinedId );

		try {
			entity = PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance().getPowerSystemStabilizerUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PowerSystemStabilizerUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PowerSystemStabilizerUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PowerSystemStabilizerUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a PowerSystemStabilizerUserDefined : " );        
		PowerSystemStabilizerUserDefined entity = read();
		UpdatePowerSystemStabilizerUserDefinedCommand command = generateUpdateCommand();
		command.setPowerSystemStabilizerUserDefinedId(entity.getPowerSystemStabilizerUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PowerSystemStabilizerUserDefined." );

			// for use later on...
			powerSystemStabilizerUserDefinedId = entity.getPowerSystemStabilizerUserDefinedId();

			PowerSystemStabilizerUserDefinedBusinessDelegate proxy = PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance();  

			proxy.updatePowerSystemStabilizerUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved PowerSystemStabilizerUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + powerSystemStabilizerUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PowerSystemStabilizerUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PowerSystemStabilizerUserDefined." );

		PowerSystemStabilizerUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PowerSystemStabilizerUserDefined with id " + powerSystemStabilizerUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PowerSystemStabilizerUserDefined with id " + powerSystemStabilizerUserDefinedId );

			throw e;
		}

		try{
			PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance().delete( new DeletePowerSystemStabilizerUserDefinedCommand( entity.getPowerSystemStabilizerUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted PowerSystemStabilizerUserDefined with id " + powerSystemStabilizerUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PowerSystemStabilizerUserDefined with id " + powerSystemStabilizerUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all PowerSystemStabilizerUserDefineds.
	 */
	protected List<PowerSystemStabilizerUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PowerSystemStabilizerUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PowerSystemStabilizerUserDefined : " );        
		List<PowerSystemStabilizerUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the PowerSystemStabilizerUserDefinedBusinessDelegate
			collection = PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance().getAllPowerSystemStabilizerUserDefined();
			assertNotNull( collection, "An Empty collection of PowerSystemStabilizerUserDefined was incorrectly returned.");
			
			// Now print out the values
			PowerSystemStabilizerUserDefined entity = null;            
			Iterator<PowerSystemStabilizerUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPowerSystemStabilizerUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PowerSystemStabilizerUserDefinedTest
	 */
	protected PowerSystemStabilizerUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PowerSystemStabilizerUserDefined
	 * 
	 * @return CreatePowerSystemStabilizerUserDefinedCommand alias
	 */
	protected CreatePowerSystemStabilizerUserDefinedCommand generateNewCommand() {
        CreatePowerSystemStabilizerUserDefinedCommand command = new CreatePowerSystemStabilizerUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PowerSystemStabilizerUserDefined
		 * 
		 * @return UpdatePowerSystemStabilizerUserDefinedCommand alias
		 */
	protected UpdatePowerSystemStabilizerUserDefinedCommand generateUpdateCommand() {
	        UpdatePowerSystemStabilizerUserDefinedCommand command = new UpdatePowerSystemStabilizerUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID powerSystemStabilizerUserDefinedId = null;
	protected PowerSystemStabilizerUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PowerSystemStabilizerUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPowerSystemStabilizerUserDefinedList = 0;
}
