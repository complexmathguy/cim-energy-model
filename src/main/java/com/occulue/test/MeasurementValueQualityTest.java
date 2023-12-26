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
 * Test MeasurementValueQuality class.
 *
 * @author your_name_here
 */
public class MeasurementValueQualityTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MeasurementValueQualityTest() {
		subscriber = new MeasurementValueQualitySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MeasurementValueQualityTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MeasurementValueQuality...");
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
	 * jumpstart the process by instantiating2 MeasurementValueQuality
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		measurementValueQualityId = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
		.createMeasurementValueQuality( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
				.createMeasurementValueQuality( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.measurementValueQualitySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MeasurementValueQuality : " + successValue.getMeasurementValueQualityId());
							  if (successValue.getMeasurementValueQualityId().equals(measurementValueQualityId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMeasurementValueQualityList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MeasurementValueQuality test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValueQuality consumed")
					);
			subscriber.measurementValueQualitySubscribe( measurementValueQualityId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MeasurementValueQuality : " + successValue.getMeasurementValueQualityId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMeasurementValueQualityList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValueQuality for measurementValueQualityId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MeasurementValueQuality. 
	 */
	protected MeasurementValueQuality read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MeasurementValueQuality" );

		MeasurementValueQuality entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MeasurementValueQuality with primary key" );
		msg.append( measurementValueQualityId );
		
		MeasurementValueQualityFetchOneSummary fetchOneSummary = new MeasurementValueQualityFetchOneSummary( measurementValueQualityId );

		try {
			entity = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().getMeasurementValueQuality( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MeasurementValueQuality " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MeasurementValueQuality.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MeasurementValueQuality." );

		StringBuilder msg = new StringBuilder( "Failed to update a MeasurementValueQuality : " );        
		MeasurementValueQuality entity = read();
		UpdateMeasurementValueQualityCommand command = generateUpdateCommand();
		command.setMeasurementValueQualityId(entity.getMeasurementValueQualityId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MeasurementValueQuality." );

			// for use later on...
			measurementValueQualityId = entity.getMeasurementValueQualityId();

			MeasurementValueQualityBusinessDelegate proxy = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance();  

			proxy.updateMeasurementValueQuality( command ).get();

			LOGGER.info( "-- Successfully saved MeasurementValueQuality - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + measurementValueQualityId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MeasurementValueQuality.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MeasurementValueQuality." );

		MeasurementValueQuality entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MeasurementValueQuality with id " + measurementValueQualityId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MeasurementValueQuality with id " + measurementValueQualityId );

			throw e;
		}

		try{
			MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().delete( new DeleteMeasurementValueQualityCommand( entity.getMeasurementValueQualityId() ) ).get();
			LOGGER.info( "-- Successfully deleted MeasurementValueQuality with id " + measurementValueQualityId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MeasurementValueQuality with id " + measurementValueQualityId );

			throw e;
		}
	}

	/**
	 * get all MeasurementValueQualitys.
	 */
	protected List<MeasurementValueQuality> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MeasurementValueQualitys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MeasurementValueQuality : " );        
		List<MeasurementValueQuality> collection  = new ArrayList<>();

		try {
			// call the static get method on the MeasurementValueQualityBusinessDelegate
			collection = MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance().getAllMeasurementValueQuality();
			assertNotNull( collection, "An Empty collection of MeasurementValueQuality was incorrectly returned.");
			
			// Now print out the values
			MeasurementValueQuality entity = null;            
			Iterator<MeasurementValueQuality> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMeasurementValueQualityId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MeasurementValueQualityTest
	 */
	protected MeasurementValueQualityTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MeasurementValueQuality
	 * 
	 * @return CreateMeasurementValueQualityCommand alias
	 */
	protected CreateMeasurementValueQualityCommand generateNewCommand() {
        CreateMeasurementValueQualityCommand command = new CreateMeasurementValueQualityCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated MeasurementValueQuality
		 * 
		 * @return UpdateMeasurementValueQualityCommand alias
		 */
	protected UpdateMeasurementValueQualityCommand generateUpdateCommand() {
	        UpdateMeasurementValueQualityCommand command = new UpdateMeasurementValueQualityCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID measurementValueQualityId = null;
	protected MeasurementValueQualitySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MeasurementValueQualityTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMeasurementValueQualityList = 0;
}
