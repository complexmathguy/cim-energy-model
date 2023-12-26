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
 * Test Season class.
 *
 * @author your_name_here
 */
public class SeasonTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SeasonTest() {
		subscriber = new SeasonSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SeasonTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Season...");
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
	 * jumpstart the process by instantiating2 Season
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		seasonId = SeasonBusinessDelegate.getSeasonInstance()
		.createSeason( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SeasonBusinessDelegate.getSeasonInstance()
				.createSeason( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.seasonSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Season : " + successValue.getSeasonId());
							  if (successValue.getSeasonId().equals(seasonId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSeasonList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Season test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on season consumed")
					);
			subscriber.seasonSubscribe( seasonId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Season : " + successValue.getSeasonId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSeasonList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on season for seasonId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Season. 
	 */
	protected Season read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Season" );

		Season entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Season with primary key" );
		msg.append( seasonId );
		
		SeasonFetchOneSummary fetchOneSummary = new SeasonFetchOneSummary( seasonId );

		try {
			entity = SeasonBusinessDelegate.getSeasonInstance().getSeason( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Season " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Season.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Season." );

		StringBuilder msg = new StringBuilder( "Failed to update a Season : " );        
		Season entity = read();
		UpdateSeasonCommand command = generateUpdateCommand();
		command.setSeasonId(entity.getSeasonId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Season." );

			// for use later on...
			seasonId = entity.getSeasonId();

			SeasonBusinessDelegate proxy = SeasonBusinessDelegate.getSeasonInstance();  

			proxy.updateSeason( command ).get();

			LOGGER.info( "-- Successfully saved Season - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + seasonId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Season.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Season." );

		Season entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Season with id " + seasonId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Season with id " + seasonId );

			throw e;
		}

		try{
			SeasonBusinessDelegate.getSeasonInstance().delete( new DeleteSeasonCommand( entity.getSeasonId() ) ).get();
			LOGGER.info( "-- Successfully deleted Season with id " + seasonId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Season with id " + seasonId );

			throw e;
		}
	}

	/**
	 * get all Seasons.
	 */
	protected List<Season> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Seasons:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Season : " );        
		List<Season> collection  = new ArrayList<>();

		try {
			// call the static get method on the SeasonBusinessDelegate
			collection = SeasonBusinessDelegate.getSeasonInstance().getAllSeason();
			assertNotNull( collection, "An Empty collection of Season was incorrectly returned.");
			
			// Now print out the values
			Season entity = null;            
			Iterator<Season> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSeasonId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SeasonTest
	 */
	protected SeasonTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Season
	 * 
	 * @return CreateSeasonCommand alias
	 */
	protected CreateSeasonCommand generateNewCommand() {
        CreateSeasonCommand command = new CreateSeasonCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Season
		 * 
		 * @return UpdateSeasonCommand alias
		 */
	protected UpdateSeasonCommand generateUpdateCommand() {
	        UpdateSeasonCommand command = new UpdateSeasonCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID seasonId = null;
	protected SeasonSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SeasonTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSeasonList = 0;
}
