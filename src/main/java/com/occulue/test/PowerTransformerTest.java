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
 * Test PowerTransformer class.
 *
 * @author your_name_here
 */
public class PowerTransformerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PowerTransformerTest() {
		subscriber = new PowerTransformerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PowerTransformerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PowerTransformer...");
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
	 * jumpstart the process by instantiating2 PowerTransformer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		powerTransformerId = PowerTransformerBusinessDelegate.getPowerTransformerInstance()
		.createPowerTransformer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PowerTransformerBusinessDelegate.getPowerTransformerInstance()
				.createPowerTransformer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.powerTransformerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PowerTransformer : " + successValue.getPowerTransformerId());
							  if (successValue.getPowerTransformerId().equals(powerTransformerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPowerTransformerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PowerTransformer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerTransformer consumed")
					);
			subscriber.powerTransformerSubscribe( powerTransformerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PowerTransformer : " + successValue.getPowerTransformerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPowerTransformerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on powerTransformer for powerTransformerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PowerTransformer. 
	 */
	protected PowerTransformer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PowerTransformer" );

		PowerTransformer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PowerTransformer with primary key" );
		msg.append( powerTransformerId );
		
		PowerTransformerFetchOneSummary fetchOneSummary = new PowerTransformerFetchOneSummary( powerTransformerId );

		try {
			entity = PowerTransformerBusinessDelegate.getPowerTransformerInstance().getPowerTransformer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PowerTransformer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PowerTransformer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PowerTransformer." );

		StringBuilder msg = new StringBuilder( "Failed to update a PowerTransformer : " );        
		PowerTransformer entity = read();
		UpdatePowerTransformerCommand command = generateUpdateCommand();
		command.setPowerTransformerId(entity.getPowerTransformerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PowerTransformer." );

			// for use later on...
			powerTransformerId = entity.getPowerTransformerId();

			PowerTransformerBusinessDelegate proxy = PowerTransformerBusinessDelegate.getPowerTransformerInstance();  

			proxy.updatePowerTransformer( command ).get();

			LOGGER.info( "-- Successfully saved PowerTransformer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + powerTransformerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PowerTransformer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PowerTransformer." );

		PowerTransformer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PowerTransformer with id " + powerTransformerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PowerTransformer with id " + powerTransformerId );

			throw e;
		}

		try{
			PowerTransformerBusinessDelegate.getPowerTransformerInstance().delete( new DeletePowerTransformerCommand( entity.getPowerTransformerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PowerTransformer with id " + powerTransformerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PowerTransformer with id " + powerTransformerId );

			throw e;
		}
	}

	/**
	 * get all PowerTransformers.
	 */
	protected List<PowerTransformer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PowerTransformers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PowerTransformer : " );        
		List<PowerTransformer> collection  = new ArrayList<>();

		try {
			// call the static get method on the PowerTransformerBusinessDelegate
			collection = PowerTransformerBusinessDelegate.getPowerTransformerInstance().getAllPowerTransformer();
			assertNotNull( collection, "An Empty collection of PowerTransformer was incorrectly returned.");
			
			// Now print out the values
			PowerTransformer entity = null;            
			Iterator<PowerTransformer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPowerTransformerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PowerTransformerTest
	 */
	protected PowerTransformerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PowerTransformer
	 * 
	 * @return CreatePowerTransformerCommand alias
	 */
	protected CreatePowerTransformerCommand generateNewCommand() {
        CreatePowerTransformerCommand command = new CreatePowerTransformerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PowerTransformer
		 * 
		 * @return UpdatePowerTransformerCommand alias
		 */
	protected UpdatePowerTransformerCommand generateUpdateCommand() {
	        UpdatePowerTransformerCommand command = new UpdatePowerTransformerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID powerTransformerId = null;
	protected PowerTransformerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PowerTransformerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPowerTransformerList = 0;
}
