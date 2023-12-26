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
 * Test HydroPowerPlant class.
 *
 * @author your_name_here
 */
public class HydroPowerPlantTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public HydroPowerPlantTest() {
		subscriber = new HydroPowerPlantSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate HydroPowerPlantTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on HydroPowerPlant...");
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
	 * jumpstart the process by instantiating2 HydroPowerPlant
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		hydroPowerPlantId = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance()
		.createHydroPowerPlant( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance()
				.createHydroPowerPlant( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.hydroPowerPlantSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for HydroPowerPlant : " + successValue.getHydroPowerPlantId());
							  if (successValue.getHydroPowerPlantId().equals(hydroPowerPlantId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfHydroPowerPlantList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("HydroPowerPlant test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroPowerPlant consumed")
					);
			subscriber.hydroPowerPlantSubscribe( hydroPowerPlantId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for HydroPowerPlant : " + successValue.getHydroPowerPlantId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfHydroPowerPlantList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroPowerPlant for hydroPowerPlantId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a HydroPowerPlant. 
	 */
	protected HydroPowerPlant read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created HydroPowerPlant" );

		HydroPowerPlant entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read HydroPowerPlant with primary key" );
		msg.append( hydroPowerPlantId );
		
		HydroPowerPlantFetchOneSummary fetchOneSummary = new HydroPowerPlantFetchOneSummary( hydroPowerPlantId );

		try {
			entity = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().getHydroPowerPlant( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found HydroPowerPlant " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a HydroPowerPlant.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a HydroPowerPlant." );

		StringBuilder msg = new StringBuilder( "Failed to update a HydroPowerPlant : " );        
		HydroPowerPlant entity = read();
		UpdateHydroPowerPlantCommand command = generateUpdateCommand();
		command.setHydroPowerPlantId(entity.getHydroPowerPlantId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created HydroPowerPlant." );

			// for use later on...
			hydroPowerPlantId = entity.getHydroPowerPlantId();

			HydroPowerPlantBusinessDelegate proxy = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance();  

			proxy.updateHydroPowerPlant( command ).get();

			LOGGER.info( "-- Successfully saved HydroPowerPlant - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + hydroPowerPlantId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a HydroPowerPlant.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created HydroPowerPlant." );

		HydroPowerPlant entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read HydroPowerPlant with id " + hydroPowerPlantId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read HydroPowerPlant with id " + hydroPowerPlantId );

			throw e;
		}

		try{
			HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().delete( new DeleteHydroPowerPlantCommand( entity.getHydroPowerPlantId() ) ).get();
			LOGGER.info( "-- Successfully deleted HydroPowerPlant with id " + hydroPowerPlantId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete HydroPowerPlant with id " + hydroPowerPlantId );

			throw e;
		}
	}

	/**
	 * get all HydroPowerPlants.
	 */
	protected List<HydroPowerPlant> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of HydroPowerPlants:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all HydroPowerPlant : " );        
		List<HydroPowerPlant> collection  = new ArrayList<>();

		try {
			// call the static get method on the HydroPowerPlantBusinessDelegate
			collection = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().getAllHydroPowerPlant();
			assertNotNull( collection, "An Empty collection of HydroPowerPlant was incorrectly returned.");
			
			// Now print out the values
			HydroPowerPlant entity = null;            
			Iterator<HydroPowerPlant> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getHydroPowerPlantId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		HydroPowerPlantTest
	 */
	protected HydroPowerPlantTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated HydroPowerPlant
	 * 
	 * @return CreateHydroPowerPlantCommand alias
	 */
	protected CreateHydroPowerPlantCommand generateNewCommand() {
        CreateHydroPowerPlantCommand command = new CreateHydroPowerPlantCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated HydroPowerPlant
		 * 
		 * @return UpdateHydroPowerPlantCommand alias
		 */
	protected UpdateHydroPowerPlantCommand generateUpdateCommand() {
	        UpdateHydroPowerPlantCommand command = new UpdateHydroPowerPlantCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID hydroPowerPlantId = null;
	protected HydroPowerPlantSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(HydroPowerPlantTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfHydroPowerPlantList = 0;
}
