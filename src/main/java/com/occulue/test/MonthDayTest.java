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
 * Test MonthDay class.
 *
 * @author your_name_here
 */
public class MonthDayTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MonthDayTest() {
		subscriber = new MonthDaySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MonthDayTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MonthDay...");
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
	 * jumpstart the process by instantiating2 MonthDay
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		monthDayId = MonthDayBusinessDelegate.getMonthDayInstance()
		.createMonthDay( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MonthDayBusinessDelegate.getMonthDayInstance()
				.createMonthDay( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.monthDaySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MonthDay : " + successValue.getMonthDayId());
							  if (successValue.getMonthDayId().equals(monthDayId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMonthDayList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MonthDay test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on monthDay consumed")
					);
			subscriber.monthDaySubscribe( monthDayId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MonthDay : " + successValue.getMonthDayId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMonthDayList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on monthDay for monthDayId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MonthDay. 
	 */
	protected MonthDay read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MonthDay" );

		MonthDay entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MonthDay with primary key" );
		msg.append( monthDayId );
		
		MonthDayFetchOneSummary fetchOneSummary = new MonthDayFetchOneSummary( monthDayId );

		try {
			entity = MonthDayBusinessDelegate.getMonthDayInstance().getMonthDay( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MonthDay " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MonthDay.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MonthDay." );

		StringBuilder msg = new StringBuilder( "Failed to update a MonthDay : " );        
		MonthDay entity = read();
		UpdateMonthDayCommand command = generateUpdateCommand();
		command.setMonthDayId(entity.getMonthDayId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MonthDay." );

			// for use later on...
			monthDayId = entity.getMonthDayId();

			MonthDayBusinessDelegate proxy = MonthDayBusinessDelegate.getMonthDayInstance();  

			proxy.updateMonthDay( command ).get();

			LOGGER.info( "-- Successfully saved MonthDay - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + monthDayId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MonthDay.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MonthDay." );

		MonthDay entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MonthDay with id " + monthDayId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MonthDay with id " + monthDayId );

			throw e;
		}

		try{
			MonthDayBusinessDelegate.getMonthDayInstance().delete( new DeleteMonthDayCommand( entity.getMonthDayId() ) ).get();
			LOGGER.info( "-- Successfully deleted MonthDay with id " + monthDayId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MonthDay with id " + monthDayId );

			throw e;
		}
	}

	/**
	 * get all MonthDays.
	 */
	protected List<MonthDay> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MonthDays:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MonthDay : " );        
		List<MonthDay> collection  = new ArrayList<>();

		try {
			// call the static get method on the MonthDayBusinessDelegate
			collection = MonthDayBusinessDelegate.getMonthDayInstance().getAllMonthDay();
			assertNotNull( collection, "An Empty collection of MonthDay was incorrectly returned.");
			
			// Now print out the values
			MonthDay entity = null;            
			Iterator<MonthDay> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMonthDayId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MonthDayTest
	 */
	protected MonthDayTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MonthDay
	 * 
	 * @return CreateMonthDayCommand alias
	 */
	protected CreateMonthDayCommand generateNewCommand() {
        CreateMonthDayCommand command = new CreateMonthDayCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated MonthDay
		 * 
		 * @return UpdateMonthDayCommand alias
		 */
	protected UpdateMonthDayCommand generateUpdateCommand() {
	        UpdateMonthDayCommand command = new UpdateMonthDayCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID monthDayId = null;
	protected MonthDaySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MonthDayTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMonthDayList = 0;
}
