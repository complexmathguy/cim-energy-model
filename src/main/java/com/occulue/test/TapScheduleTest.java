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
 * Test TapSchedule class.
 *
 * @author your_name_here
 */
public class TapScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TapScheduleTest() {
		subscriber = new TapScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TapScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TapSchedule...");
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
	 * jumpstart the process by instantiating2 TapSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		tapScheduleId = TapScheduleBusinessDelegate.getTapScheduleInstance()
		.createTapSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TapScheduleBusinessDelegate.getTapScheduleInstance()
				.createTapSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.tapScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TapSchedule : " + successValue.getTapScheduleId());
							  if (successValue.getTapScheduleId().equals(tapScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTapScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TapSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapSchedule consumed")
					);
			subscriber.tapScheduleSubscribe( tapScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TapSchedule : " + successValue.getTapScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTapScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapSchedule for tapScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TapSchedule. 
	 */
	protected TapSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TapSchedule" );

		TapSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TapSchedule with primary key" );
		msg.append( tapScheduleId );
		
		TapScheduleFetchOneSummary fetchOneSummary = new TapScheduleFetchOneSummary( tapScheduleId );

		try {
			entity = TapScheduleBusinessDelegate.getTapScheduleInstance().getTapSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TapSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TapSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TapSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a TapSchedule : " );        
		TapSchedule entity = read();
		UpdateTapScheduleCommand command = generateUpdateCommand();
		command.setTapScheduleId(entity.getTapScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TapSchedule." );

			// for use later on...
			tapScheduleId = entity.getTapScheduleId();

			TapScheduleBusinessDelegate proxy = TapScheduleBusinessDelegate.getTapScheduleInstance();  

			proxy.updateTapSchedule( command ).get();

			LOGGER.info( "-- Successfully saved TapSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + tapScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TapSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TapSchedule." );

		TapSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TapSchedule with id " + tapScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TapSchedule with id " + tapScheduleId );

			throw e;
		}

		try{
			TapScheduleBusinessDelegate.getTapScheduleInstance().delete( new DeleteTapScheduleCommand( entity.getTapScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted TapSchedule with id " + tapScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TapSchedule with id " + tapScheduleId );

			throw e;
		}
	}

	/**
	 * get all TapSchedules.
	 */
	protected List<TapSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TapSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TapSchedule : " );        
		List<TapSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the TapScheduleBusinessDelegate
			collection = TapScheduleBusinessDelegate.getTapScheduleInstance().getAllTapSchedule();
			assertNotNull( collection, "An Empty collection of TapSchedule was incorrectly returned.");
			
			// Now print out the values
			TapSchedule entity = null;            
			Iterator<TapSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTapScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TapScheduleTest
	 */
	protected TapScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TapSchedule
	 * 
	 * @return CreateTapScheduleCommand alias
	 */
	protected CreateTapScheduleCommand generateNewCommand() {
        CreateTapScheduleCommand command = new CreateTapScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated TapSchedule
		 * 
		 * @return UpdateTapScheduleCommand alias
		 */
	protected UpdateTapScheduleCommand generateUpdateCommand() {
	        UpdateTapScheduleCommand command = new UpdateTapScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID tapScheduleId = null;
	protected TapScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TapScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTapScheduleList = 0;
}
