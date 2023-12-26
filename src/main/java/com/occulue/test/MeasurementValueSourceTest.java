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
 * Test MeasurementValueSource class.
 *
 * @author your_name_here
 */
public class MeasurementValueSourceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MeasurementValueSourceTest() {
		subscriber = new MeasurementValueSourceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MeasurementValueSourceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MeasurementValueSource...");
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
	 * jumpstart the process by instantiating2 MeasurementValueSource
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		measurementValueSourceId = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance()
		.createMeasurementValueSource( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance()
				.createMeasurementValueSource( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.measurementValueSourceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MeasurementValueSource : " + successValue.getMeasurementValueSourceId());
							  if (successValue.getMeasurementValueSourceId().equals(measurementValueSourceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMeasurementValueSourceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MeasurementValueSource test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValueSource consumed")
					);
			subscriber.measurementValueSourceSubscribe( measurementValueSourceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MeasurementValueSource : " + successValue.getMeasurementValueSourceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMeasurementValueSourceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on measurementValueSource for measurementValueSourceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MeasurementValueSource. 
	 */
	protected MeasurementValueSource read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MeasurementValueSource" );

		MeasurementValueSource entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MeasurementValueSource with primary key" );
		msg.append( measurementValueSourceId );
		
		MeasurementValueSourceFetchOneSummary fetchOneSummary = new MeasurementValueSourceFetchOneSummary( measurementValueSourceId );

		try {
			entity = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().getMeasurementValueSource( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MeasurementValueSource " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MeasurementValueSource.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MeasurementValueSource." );

		StringBuilder msg = new StringBuilder( "Failed to update a MeasurementValueSource : " );        
		MeasurementValueSource entity = read();
		UpdateMeasurementValueSourceCommand command = generateUpdateCommand();
		command.setMeasurementValueSourceId(entity.getMeasurementValueSourceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MeasurementValueSource." );

			// for use later on...
			measurementValueSourceId = entity.getMeasurementValueSourceId();

			MeasurementValueSourceBusinessDelegate proxy = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance();  

			proxy.updateMeasurementValueSource( command ).get();

			LOGGER.info( "-- Successfully saved MeasurementValueSource - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + measurementValueSourceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MeasurementValueSource.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MeasurementValueSource." );

		MeasurementValueSource entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MeasurementValueSource with id " + measurementValueSourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MeasurementValueSource with id " + measurementValueSourceId );

			throw e;
		}

		try{
			MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().delete( new DeleteMeasurementValueSourceCommand( entity.getMeasurementValueSourceId() ) ).get();
			LOGGER.info( "-- Successfully deleted MeasurementValueSource with id " + measurementValueSourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MeasurementValueSource with id " + measurementValueSourceId );

			throw e;
		}
	}

	/**
	 * get all MeasurementValueSources.
	 */
	protected List<MeasurementValueSource> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MeasurementValueSources:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MeasurementValueSource : " );        
		List<MeasurementValueSource> collection  = new ArrayList<>();

		try {
			// call the static get method on the MeasurementValueSourceBusinessDelegate
			collection = MeasurementValueSourceBusinessDelegate.getMeasurementValueSourceInstance().getAllMeasurementValueSource();
			assertNotNull( collection, "An Empty collection of MeasurementValueSource was incorrectly returned.");
			
			// Now print out the values
			MeasurementValueSource entity = null;            
			Iterator<MeasurementValueSource> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMeasurementValueSourceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MeasurementValueSourceTest
	 */
	protected MeasurementValueSourceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MeasurementValueSource
	 * 
	 * @return CreateMeasurementValueSourceCommand alias
	 */
	protected CreateMeasurementValueSourceCommand generateNewCommand() {
        CreateMeasurementValueSourceCommand command = new CreateMeasurementValueSourceCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated MeasurementValueSource
		 * 
		 * @return UpdateMeasurementValueSourceCommand alias
		 */
	protected UpdateMeasurementValueSourceCommand generateUpdateCommand() {
	        UpdateMeasurementValueSourceCommand command = new UpdateMeasurementValueSourceCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID measurementValueSourceId = null;
	protected MeasurementValueSourceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MeasurementValueSourceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMeasurementValueSourceList = 0;
}
