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
 * Test PowerTransformerEnd class.
 *
 * @author your_name_here
 */
public class PowerTransformerEndTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PowerTransformerEndTest() {
		subscriber = new PowerTransformerEndSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PowerTransformerEndTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PowerTransformerEnd...");
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
	 * jumpstart the process by instantiating2 PowerTransformerEnd
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		powerTransformerEndId = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
		.createPowerTransformerEnd( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
				.createPowerTransformerEnd( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.powerTransformerEndSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PowerTransformerEnd : " + successValue.getPowerTransformerEndId());
							  if (successValue.getPowerTransformerEndId().equals(powerTransformerEndId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPowerTransformerEndList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PowerTransformerEnd test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerTransformerEnd consumed")
					);
			subscriber.powerTransformerEndSubscribe( powerTransformerEndId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PowerTransformerEnd : " + successValue.getPowerTransformerEndId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPowerTransformerEndList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerTransformerEnd for powerTransformerEndId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PowerTransformerEnd. 
	 */
	protected PowerTransformerEnd read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PowerTransformerEnd" );

		PowerTransformerEnd entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PowerTransformerEnd with primary key" );
		msg.append( powerTransformerEndId );
		
		PowerTransformerEndFetchOneSummary fetchOneSummary = new PowerTransformerEndFetchOneSummary( powerTransformerEndId );

		try {
			entity = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().getPowerTransformerEnd( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PowerTransformerEnd " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PowerTransformerEnd.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PowerTransformerEnd." );

		StringBuilder msg = new StringBuilder( "Failed to update a PowerTransformerEnd : " );        
		PowerTransformerEnd entity = read();
		UpdatePowerTransformerEndCommand command = generateUpdateCommand();
		command.setPowerTransformerEndId(entity.getPowerTransformerEndId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PowerTransformerEnd." );

			// for use later on...
			powerTransformerEndId = entity.getPowerTransformerEndId();

			PowerTransformerEndBusinessDelegate proxy = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();  

			proxy.updatePowerTransformerEnd( command ).get();

			LOGGER.info( "-- Successfully saved PowerTransformerEnd - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + powerTransformerEndId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PowerTransformerEnd.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PowerTransformerEnd." );

		PowerTransformerEnd entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PowerTransformerEnd with id " + powerTransformerEndId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PowerTransformerEnd with id " + powerTransformerEndId );

			throw e;
		}

		try{
			PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().delete( new DeletePowerTransformerEndCommand( entity.getPowerTransformerEndId() ) ).get();
			LOGGER.info( "-- Successfully deleted PowerTransformerEnd with id " + powerTransformerEndId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PowerTransformerEnd with id " + powerTransformerEndId );

			throw e;
		}
	}

	/**
	 * get all PowerTransformerEnds.
	 */
	protected List<PowerTransformerEnd> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PowerTransformerEnds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PowerTransformerEnd : " );        
		List<PowerTransformerEnd> collection  = new ArrayList<>();

		try {
			// call the static get method on the PowerTransformerEndBusinessDelegate
			collection = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().getAllPowerTransformerEnd();
			assertNotNull( collection, "An Empty collection of PowerTransformerEnd was incorrectly returned.");
			
			// Now print out the values
			PowerTransformerEnd entity = null;            
			Iterator<PowerTransformerEnd> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPowerTransformerEndId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PowerTransformerEndTest
	 */
	protected PowerTransformerEndTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PowerTransformerEnd
	 * 
	 * @return CreatePowerTransformerEndCommand alias
	 */
	protected CreatePowerTransformerEndCommand generateNewCommand() {
        CreatePowerTransformerEndCommand command = new CreatePowerTransformerEndCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PowerTransformerEnd
		 * 
		 * @return UpdatePowerTransformerEndCommand alias
		 */
	protected UpdatePowerTransformerEndCommand generateUpdateCommand() {
	        UpdatePowerTransformerEndCommand command = new UpdatePowerTransformerEndCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID powerTransformerEndId = null;
	protected PowerTransformerEndSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PowerTransformerEndTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPowerTransformerEndList = 0;
}
