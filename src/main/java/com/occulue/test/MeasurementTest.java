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
 * Test Measurement class.
 *
 * @author your_name_here
 */
public class MeasurementTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MeasurementTest() {
		subscriber = new MeasurementSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MeasurementTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Measurement...");
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
	 * jumpstart the process by instantiating2 Measurement
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		measurementId = MeasurementBusinessDelegate.getMeasurementInstance()
		.createMeasurement( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MeasurementBusinessDelegate.getMeasurementInstance()
				.createMeasurement( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.measurementSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Measurement : " + successValue.getMeasurementId());
							  if (successValue.getMeasurementId().equals(measurementId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMeasurementList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Measurement test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurement consumed")
					);
			subscriber.measurementSubscribe( measurementId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Measurement : " + successValue.getMeasurementId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMeasurementList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurement for measurementId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Measurement. 
	 */
	protected Measurement read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Measurement" );

		Measurement entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Measurement with primary key" );
		msg.append( measurementId );
		
		MeasurementFetchOneSummary fetchOneSummary = new MeasurementFetchOneSummary( measurementId );

		try {
			entity = MeasurementBusinessDelegate.getMeasurementInstance().getMeasurement( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Measurement " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Measurement.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Measurement." );

		StringBuilder msg = new StringBuilder( "Failed to update a Measurement : " );        
		Measurement entity = read();
		UpdateMeasurementCommand command = generateUpdateCommand();
		command.setMeasurementId(entity.getMeasurementId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Measurement." );

			// for use later on...
			measurementId = entity.getMeasurementId();

			MeasurementBusinessDelegate proxy = MeasurementBusinessDelegate.getMeasurementInstance();  

			proxy.updateMeasurement( command ).get();

			LOGGER.info( "-- Successfully saved Measurement - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + measurementId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Measurement.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Measurement." );

		Measurement entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Measurement with id " + measurementId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Measurement with id " + measurementId );

			throw e;
		}

		try{
			MeasurementBusinessDelegate.getMeasurementInstance().delete( new DeleteMeasurementCommand( entity.getMeasurementId() ) ).get();
			LOGGER.info( "-- Successfully deleted Measurement with id " + measurementId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Measurement with id " + measurementId );

			throw e;
		}
	}

	/**
	 * get all Measurements.
	 */
	protected List<Measurement> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Measurements:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Measurement : " );        
		List<Measurement> collection  = new ArrayList<>();

		try {
			// call the static get method on the MeasurementBusinessDelegate
			collection = MeasurementBusinessDelegate.getMeasurementInstance().getAllMeasurement();
			assertNotNull( collection, "An Empty collection of Measurement was incorrectly returned.");
			
			// Now print out the values
			Measurement entity = null;            
			Iterator<Measurement> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMeasurementId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MeasurementTest
	 */
	protected MeasurementTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Measurement
	 * 
	 * @return CreateMeasurementCommand alias
	 */
	protected CreateMeasurementCommand generateNewCommand() {
        CreateMeasurementCommand command = new CreateMeasurementCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Measurement
		 * 
		 * @return UpdateMeasurementCommand alias
		 */
	protected UpdateMeasurementCommand generateUpdateCommand() {
	        UpdateMeasurementCommand command = new UpdateMeasurementCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID measurementId = null;
	protected MeasurementSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MeasurementTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMeasurementList = 0;
}
