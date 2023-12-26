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
 * Test DateTime class.
 *
 * @author your_name_here
 */
public class DateTimeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DateTimeTest() {
		subscriber = new DateTimeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DateTimeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DateTime...");
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
	 * jumpstart the process by instantiating2 DateTime
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dateTimeId = DateTimeBusinessDelegate.getDateTimeInstance()
		.createDateTime( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DateTimeBusinessDelegate.getDateTimeInstance()
				.createDateTime( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dateTimeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DateTime : " + successValue.getDateTimeId());
							  if (successValue.getDateTimeId().equals(dateTimeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDateTimeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DateTime test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dateTime consumed")
					);
			subscriber.dateTimeSubscribe( dateTimeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DateTime : " + successValue.getDateTimeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDateTimeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dateTime for dateTimeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DateTime. 
	 */
	protected DateTime read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DateTime" );

		DateTime entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DateTime with primary key" );
		msg.append( dateTimeId );
		
		DateTimeFetchOneSummary fetchOneSummary = new DateTimeFetchOneSummary( dateTimeId );

		try {
			entity = DateTimeBusinessDelegate.getDateTimeInstance().getDateTime( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DateTime " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DateTime.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DateTime." );

		StringBuilder msg = new StringBuilder( "Failed to update a DateTime : " );        
		DateTime entity = read();
		UpdateDateTimeCommand command = generateUpdateCommand();
		command.setDateTimeId(entity.getDateTimeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DateTime." );

			// for use later on...
			dateTimeId = entity.getDateTimeId();

			DateTimeBusinessDelegate proxy = DateTimeBusinessDelegate.getDateTimeInstance();  

			proxy.updateDateTime( command ).get();

			LOGGER.info( "-- Successfully saved DateTime - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dateTimeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DateTime.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DateTime." );

		DateTime entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DateTime with id " + dateTimeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DateTime with id " + dateTimeId );

			throw e;
		}

		try{
			DateTimeBusinessDelegate.getDateTimeInstance().delete( new DeleteDateTimeCommand( entity.getDateTimeId() ) ).get();
			LOGGER.info( "-- Successfully deleted DateTime with id " + dateTimeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DateTime with id " + dateTimeId );

			throw e;
		}
	}

	/**
	 * get all DateTimes.
	 */
	protected List<DateTime> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DateTimes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DateTime : " );        
		List<DateTime> collection  = new ArrayList<>();

		try {
			// call the static get method on the DateTimeBusinessDelegate
			collection = DateTimeBusinessDelegate.getDateTimeInstance().getAllDateTime();
			assertNotNull( collection, "An Empty collection of DateTime was incorrectly returned.");
			
			// Now print out the values
			DateTime entity = null;            
			Iterator<DateTime> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDateTimeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DateTimeTest
	 */
	protected DateTimeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DateTime
	 * 
	 * @return CreateDateTimeCommand alias
	 */
	protected CreateDateTimeCommand generateNewCommand() {
        CreateDateTimeCommand command = new CreateDateTimeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DateTime
		 * 
		 * @return UpdateDateTimeCommand alias
		 */
	protected UpdateDateTimeCommand generateUpdateCommand() {
	        UpdateDateTimeCommand command = new UpdateDateTimeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dateTimeId = null;
	protected DateTimeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DateTimeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDateTimeList = 0;
}
