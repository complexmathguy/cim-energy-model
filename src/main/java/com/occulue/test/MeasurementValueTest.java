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
 * Test MeasurementValue class.
 *
 * @author your_name_here
 */
public class MeasurementValueTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MeasurementValueTest() {
		subscriber = new MeasurementValueSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MeasurementValueTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MeasurementValue...");
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
	 * jumpstart the process by instantiating2 MeasurementValue
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		measurementValueId = MeasurementValueBusinessDelegate.getMeasurementValueInstance()
		.createMeasurementValue( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MeasurementValueBusinessDelegate.getMeasurementValueInstance()
				.createMeasurementValue( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.measurementValueSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MeasurementValue : " + successValue.getMeasurementValueId());
							  if (successValue.getMeasurementValueId().equals(measurementValueId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMeasurementValueList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MeasurementValue test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValue consumed")
					);
			subscriber.measurementValueSubscribe( measurementValueId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MeasurementValue : " + successValue.getMeasurementValueId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMeasurementValueList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValue for measurementValueId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MeasurementValue. 
	 */
	protected MeasurementValue read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MeasurementValue" );

		MeasurementValue entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MeasurementValue with primary key" );
		msg.append( measurementValueId );
		
		MeasurementValueFetchOneSummary fetchOneSummary = new MeasurementValueFetchOneSummary( measurementValueId );

		try {
			entity = MeasurementValueBusinessDelegate.getMeasurementValueInstance().getMeasurementValue( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MeasurementValue " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MeasurementValue.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MeasurementValue." );

		StringBuilder msg = new StringBuilder( "Failed to update a MeasurementValue : " );        
		MeasurementValue entity = read();
		UpdateMeasurementValueCommand command = generateUpdateCommand();
		command.setMeasurementValueId(entity.getMeasurementValueId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MeasurementValue." );

			// for use later on...
			measurementValueId = entity.getMeasurementValueId();

			MeasurementValueBusinessDelegate proxy = MeasurementValueBusinessDelegate.getMeasurementValueInstance();  

			proxy.updateMeasurementValue( command ).get();

			LOGGER.info( "-- Successfully saved MeasurementValue - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + measurementValueId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MeasurementValue.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MeasurementValue." );

		MeasurementValue entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MeasurementValue with id " + measurementValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MeasurementValue with id " + measurementValueId );

			throw e;
		}

		try{
			MeasurementValueBusinessDelegate.getMeasurementValueInstance().delete( new DeleteMeasurementValueCommand( entity.getMeasurementValueId() ) ).get();
			LOGGER.info( "-- Successfully deleted MeasurementValue with id " + measurementValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MeasurementValue with id " + measurementValueId );

			throw e;
		}
	}

	/**
	 * get all MeasurementValues.
	 */
	protected List<MeasurementValue> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MeasurementValues:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MeasurementValue : " );        
		List<MeasurementValue> collection  = new ArrayList<>();

		try {
			// call the static get method on the MeasurementValueBusinessDelegate
			collection = MeasurementValueBusinessDelegate.getMeasurementValueInstance().getAllMeasurementValue();
			assertNotNull( collection, "An Empty collection of MeasurementValue was incorrectly returned.");
			
			// Now print out the values
			MeasurementValue entity = null;            
			Iterator<MeasurementValue> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMeasurementValueId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MeasurementValueTest
	 */
	protected MeasurementValueTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MeasurementValue
	 * 
	 * @return CreateMeasurementValueCommand alias
	 */
	protected CreateMeasurementValueCommand generateNewCommand() {
        CreateMeasurementValueCommand command = new CreateMeasurementValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated MeasurementValue
		 * 
		 * @return UpdateMeasurementValueCommand alias
		 */
	protected UpdateMeasurementValueCommand generateUpdateCommand() {
	        UpdateMeasurementValueCommand command = new UpdateMeasurementValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID measurementValueId = null;
	protected MeasurementValueSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MeasurementValueTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMeasurementValueList = 0;
}
