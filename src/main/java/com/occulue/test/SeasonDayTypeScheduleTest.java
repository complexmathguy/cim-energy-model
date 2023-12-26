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
 * Test SeasonDayTypeSchedule class.
 *
 * @author your_name_here
 */
public class SeasonDayTypeScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SeasonDayTypeScheduleTest() {
		subscriber = new SeasonDayTypeScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SeasonDayTypeScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SeasonDayTypeSchedule...");
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
	 * jumpstart the process by instantiating2 SeasonDayTypeSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		seasonDayTypeScheduleId = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
		.createSeasonDayTypeSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
				.createSeasonDayTypeSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.seasonDayTypeScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SeasonDayTypeSchedule : " + successValue.getSeasonDayTypeScheduleId());
							  if (successValue.getSeasonDayTypeScheduleId().equals(seasonDayTypeScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSeasonDayTypeScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SeasonDayTypeSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seasonDayTypeSchedule consumed")
					);
			subscriber.seasonDayTypeScheduleSubscribe( seasonDayTypeScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SeasonDayTypeSchedule : " + successValue.getSeasonDayTypeScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSeasonDayTypeScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seasonDayTypeSchedule for seasonDayTypeScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SeasonDayTypeSchedule. 
	 */
	protected SeasonDayTypeSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SeasonDayTypeSchedule" );

		SeasonDayTypeSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SeasonDayTypeSchedule with primary key" );
		msg.append( seasonDayTypeScheduleId );
		
		SeasonDayTypeScheduleFetchOneSummary fetchOneSummary = new SeasonDayTypeScheduleFetchOneSummary( seasonDayTypeScheduleId );

		try {
			entity = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().getSeasonDayTypeSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SeasonDayTypeSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SeasonDayTypeSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SeasonDayTypeSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a SeasonDayTypeSchedule : " );        
		SeasonDayTypeSchedule entity = read();
		UpdateSeasonDayTypeScheduleCommand command = generateUpdateCommand();
		command.setSeasonDayTypeScheduleId(entity.getSeasonDayTypeScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SeasonDayTypeSchedule." );

			// for use later on...
			seasonDayTypeScheduleId = entity.getSeasonDayTypeScheduleId();

			SeasonDayTypeScheduleBusinessDelegate proxy = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance();  

			proxy.updateSeasonDayTypeSchedule( command ).get();

			LOGGER.info( "-- Successfully saved SeasonDayTypeSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + seasonDayTypeScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SeasonDayTypeSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SeasonDayTypeSchedule." );

		SeasonDayTypeSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SeasonDayTypeSchedule with id " + seasonDayTypeScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SeasonDayTypeSchedule with id " + seasonDayTypeScheduleId );

			throw e;
		}

		try{
			SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().delete( new DeleteSeasonDayTypeScheduleCommand( entity.getSeasonDayTypeScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted SeasonDayTypeSchedule with id " + seasonDayTypeScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SeasonDayTypeSchedule with id " + seasonDayTypeScheduleId );

			throw e;
		}
	}

	/**
	 * get all SeasonDayTypeSchedules.
	 */
	protected List<SeasonDayTypeSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SeasonDayTypeSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SeasonDayTypeSchedule : " );        
		List<SeasonDayTypeSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the SeasonDayTypeScheduleBusinessDelegate
			collection = SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance().getAllSeasonDayTypeSchedule();
			assertNotNull( collection, "An Empty collection of SeasonDayTypeSchedule was incorrectly returned.");
			
			// Now print out the values
			SeasonDayTypeSchedule entity = null;            
			Iterator<SeasonDayTypeSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSeasonDayTypeScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SeasonDayTypeScheduleTest
	 */
	protected SeasonDayTypeScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SeasonDayTypeSchedule
	 * 
	 * @return CreateSeasonDayTypeScheduleCommand alias
	 */
	protected CreateSeasonDayTypeScheduleCommand generateNewCommand() {
        CreateSeasonDayTypeScheduleCommand command = new CreateSeasonDayTypeScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SeasonDayTypeSchedule
		 * 
		 * @return UpdateSeasonDayTypeScheduleCommand alias
		 */
	protected UpdateSeasonDayTypeScheduleCommand generateUpdateCommand() {
	        UpdateSeasonDayTypeScheduleCommand command = new UpdateSeasonDayTypeScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID seasonDayTypeScheduleId = null;
	protected SeasonDayTypeScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SeasonDayTypeScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSeasonDayTypeScheduleList = 0;
}
