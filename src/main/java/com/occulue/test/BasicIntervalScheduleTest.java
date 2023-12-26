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
 * Test BasicIntervalSchedule class.
 *
 * @author your_name_here
 */
public class BasicIntervalScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BasicIntervalScheduleTest() {
		subscriber = new BasicIntervalScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BasicIntervalScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BasicIntervalSchedule...");
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
	 * jumpstart the process by instantiating2 BasicIntervalSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		basicIntervalScheduleId = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
		.createBasicIntervalSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance()
				.createBasicIntervalSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.basicIntervalScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BasicIntervalSchedule : " + successValue.getBasicIntervalScheduleId());
							  if (successValue.getBasicIntervalScheduleId().equals(basicIntervalScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBasicIntervalScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BasicIntervalSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on basicIntervalSchedule consumed")
					);
			subscriber.basicIntervalScheduleSubscribe( basicIntervalScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BasicIntervalSchedule : " + successValue.getBasicIntervalScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBasicIntervalScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on basicIntervalSchedule for basicIntervalScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BasicIntervalSchedule. 
	 */
	protected BasicIntervalSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BasicIntervalSchedule" );

		BasicIntervalSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BasicIntervalSchedule with primary key" );
		msg.append( basicIntervalScheduleId );
		
		BasicIntervalScheduleFetchOneSummary fetchOneSummary = new BasicIntervalScheduleFetchOneSummary( basicIntervalScheduleId );

		try {
			entity = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().getBasicIntervalSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BasicIntervalSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BasicIntervalSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BasicIntervalSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a BasicIntervalSchedule : " );        
		BasicIntervalSchedule entity = read();
		UpdateBasicIntervalScheduleCommand command = generateUpdateCommand();
		command.setBasicIntervalScheduleId(entity.getBasicIntervalScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BasicIntervalSchedule." );

			// for use later on...
			basicIntervalScheduleId = entity.getBasicIntervalScheduleId();

			BasicIntervalScheduleBusinessDelegate proxy = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance();  

			proxy.updateBasicIntervalSchedule( command ).get();

			LOGGER.info( "-- Successfully saved BasicIntervalSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + basicIntervalScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BasicIntervalSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BasicIntervalSchedule." );

		BasicIntervalSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BasicIntervalSchedule with id " + basicIntervalScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BasicIntervalSchedule with id " + basicIntervalScheduleId );

			throw e;
		}

		try{
			BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().delete( new DeleteBasicIntervalScheduleCommand( entity.getBasicIntervalScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted BasicIntervalSchedule with id " + basicIntervalScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BasicIntervalSchedule with id " + basicIntervalScheduleId );

			throw e;
		}
	}

	/**
	 * get all BasicIntervalSchedules.
	 */
	protected List<BasicIntervalSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BasicIntervalSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BasicIntervalSchedule : " );        
		List<BasicIntervalSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the BasicIntervalScheduleBusinessDelegate
			collection = BasicIntervalScheduleBusinessDelegate.getBasicIntervalScheduleInstance().getAllBasicIntervalSchedule();
			assertNotNull( collection, "An Empty collection of BasicIntervalSchedule was incorrectly returned.");
			
			// Now print out the values
			BasicIntervalSchedule entity = null;            
			Iterator<BasicIntervalSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBasicIntervalScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BasicIntervalScheduleTest
	 */
	protected BasicIntervalScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BasicIntervalSchedule
	 * 
	 * @return CreateBasicIntervalScheduleCommand alias
	 */
	protected CreateBasicIntervalScheduleCommand generateNewCommand() {
        CreateBasicIntervalScheduleCommand command = new CreateBasicIntervalScheduleCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated BasicIntervalSchedule
		 * 
		 * @return UpdateBasicIntervalScheduleCommand alias
		 */
	protected UpdateBasicIntervalScheduleCommand generateUpdateCommand() {
	        UpdateBasicIntervalScheduleCommand command = new UpdateBasicIntervalScheduleCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID basicIntervalScheduleId = null;
	protected BasicIntervalScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BasicIntervalScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBasicIntervalScheduleList = 0;
}
