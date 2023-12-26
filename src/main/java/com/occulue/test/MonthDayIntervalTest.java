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
 * Test MonthDayInterval class.
 *
 * @author your_name_here
 */
public class MonthDayIntervalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MonthDayIntervalTest() {
		subscriber = new MonthDayIntervalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MonthDayIntervalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MonthDayInterval...");
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
	 * jumpstart the process by instantiating2 MonthDayInterval
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		monthDayIntervalId = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance()
		.createMonthDayInterval( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance()
				.createMonthDayInterval( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.monthDayIntervalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MonthDayInterval : " + successValue.getMonthDayIntervalId());
							  if (successValue.getMonthDayIntervalId().equals(monthDayIntervalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMonthDayIntervalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MonthDayInterval test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on monthDayInterval consumed")
					);
			subscriber.monthDayIntervalSubscribe( monthDayIntervalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MonthDayInterval : " + successValue.getMonthDayIntervalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMonthDayIntervalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on monthDayInterval for monthDayIntervalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MonthDayInterval. 
	 */
	protected MonthDayInterval read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MonthDayInterval" );

		MonthDayInterval entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MonthDayInterval with primary key" );
		msg.append( monthDayIntervalId );
		
		MonthDayIntervalFetchOneSummary fetchOneSummary = new MonthDayIntervalFetchOneSummary( monthDayIntervalId );

		try {
			entity = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().getMonthDayInterval( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MonthDayInterval " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MonthDayInterval.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MonthDayInterval." );

		StringBuilder msg = new StringBuilder( "Failed to update a MonthDayInterval : " );        
		MonthDayInterval entity = read();
		UpdateMonthDayIntervalCommand command = generateUpdateCommand();
		command.setMonthDayIntervalId(entity.getMonthDayIntervalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MonthDayInterval." );

			// for use later on...
			monthDayIntervalId = entity.getMonthDayIntervalId();

			MonthDayIntervalBusinessDelegate proxy = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance();  

			proxy.updateMonthDayInterval( command ).get();

			LOGGER.info( "-- Successfully saved MonthDayInterval - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + monthDayIntervalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MonthDayInterval.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MonthDayInterval." );

		MonthDayInterval entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MonthDayInterval with id " + monthDayIntervalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MonthDayInterval with id " + monthDayIntervalId );

			throw e;
		}

		try{
			MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().delete( new DeleteMonthDayIntervalCommand( entity.getMonthDayIntervalId() ) ).get();
			LOGGER.info( "-- Successfully deleted MonthDayInterval with id " + monthDayIntervalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MonthDayInterval with id " + monthDayIntervalId );

			throw e;
		}
	}

	/**
	 * get all MonthDayIntervals.
	 */
	protected List<MonthDayInterval> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MonthDayIntervals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MonthDayInterval : " );        
		List<MonthDayInterval> collection  = new ArrayList<>();

		try {
			// call the static get method on the MonthDayIntervalBusinessDelegate
			collection = MonthDayIntervalBusinessDelegate.getMonthDayIntervalInstance().getAllMonthDayInterval();
			assertNotNull( collection, "An Empty collection of MonthDayInterval was incorrectly returned.");
			
			// Now print out the values
			MonthDayInterval entity = null;            
			Iterator<MonthDayInterval> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMonthDayIntervalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MonthDayIntervalTest
	 */
	protected MonthDayIntervalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MonthDayInterval
	 * 
	 * @return CreateMonthDayIntervalCommand alias
	 */
	protected CreateMonthDayIntervalCommand generateNewCommand() {
        CreateMonthDayIntervalCommand command = new CreateMonthDayIntervalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated MonthDayInterval
		 * 
		 * @return UpdateMonthDayIntervalCommand alias
		 */
	protected UpdateMonthDayIntervalCommand generateUpdateCommand() {
	        UpdateMonthDayIntervalCommand command = new UpdateMonthDayIntervalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID monthDayIntervalId = null;
	protected MonthDayIntervalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MonthDayIntervalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMonthDayIntervalList = 0;
}
