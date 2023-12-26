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
 * Test RegularIntervalSchedule class.
 *
 * @author your_name_here
 */
public class RegularIntervalScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RegularIntervalScheduleTest() {
		subscriber = new RegularIntervalScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RegularIntervalScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RegularIntervalSchedule...");
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
	 * jumpstart the process by instantiating2 RegularIntervalSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		regularIntervalScheduleId = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
		.createRegularIntervalSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance()
				.createRegularIntervalSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.regularIntervalScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RegularIntervalSchedule : " + successValue.getRegularIntervalScheduleId());
							  if (successValue.getRegularIntervalScheduleId().equals(regularIntervalScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRegularIntervalScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RegularIntervalSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regularIntervalSchedule consumed")
					);
			subscriber.regularIntervalScheduleSubscribe( regularIntervalScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RegularIntervalSchedule : " + successValue.getRegularIntervalScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRegularIntervalScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regularIntervalSchedule for regularIntervalScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RegularIntervalSchedule. 
	 */
	protected RegularIntervalSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RegularIntervalSchedule" );

		RegularIntervalSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RegularIntervalSchedule with primary key" );
		msg.append( regularIntervalScheduleId );
		
		RegularIntervalScheduleFetchOneSummary fetchOneSummary = new RegularIntervalScheduleFetchOneSummary( regularIntervalScheduleId );

		try {
			entity = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().getRegularIntervalSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RegularIntervalSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RegularIntervalSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RegularIntervalSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a RegularIntervalSchedule : " );        
		RegularIntervalSchedule entity = read();
		UpdateRegularIntervalScheduleCommand command = generateUpdateCommand();
		command.setRegularIntervalScheduleId(entity.getRegularIntervalScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RegularIntervalSchedule." );

			// for use later on...
			regularIntervalScheduleId = entity.getRegularIntervalScheduleId();

			RegularIntervalScheduleBusinessDelegate proxy = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance();  

			proxy.updateRegularIntervalSchedule( command ).get();

			LOGGER.info( "-- Successfully saved RegularIntervalSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + regularIntervalScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RegularIntervalSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RegularIntervalSchedule." );

		RegularIntervalSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RegularIntervalSchedule with id " + regularIntervalScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RegularIntervalSchedule with id " + regularIntervalScheduleId );

			throw e;
		}

		try{
			RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().delete( new DeleteRegularIntervalScheduleCommand( entity.getRegularIntervalScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted RegularIntervalSchedule with id " + regularIntervalScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RegularIntervalSchedule with id " + regularIntervalScheduleId );

			throw e;
		}
	}

	/**
	 * get all RegularIntervalSchedules.
	 */
	protected List<RegularIntervalSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RegularIntervalSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RegularIntervalSchedule : " );        
		List<RegularIntervalSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the RegularIntervalScheduleBusinessDelegate
			collection = RegularIntervalScheduleBusinessDelegate.getRegularIntervalScheduleInstance().getAllRegularIntervalSchedule();
			assertNotNull( collection, "An Empty collection of RegularIntervalSchedule was incorrectly returned.");
			
			// Now print out the values
			RegularIntervalSchedule entity = null;            
			Iterator<RegularIntervalSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRegularIntervalScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RegularIntervalScheduleTest
	 */
	protected RegularIntervalScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RegularIntervalSchedule
	 * 
	 * @return CreateRegularIntervalScheduleCommand alias
	 */
	protected CreateRegularIntervalScheduleCommand generateNewCommand() {
        CreateRegularIntervalScheduleCommand command = new CreateRegularIntervalScheduleCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RegularIntervalSchedule
		 * 
		 * @return UpdateRegularIntervalScheduleCommand alias
		 */
	protected UpdateRegularIntervalScheduleCommand generateUpdateCommand() {
	        UpdateRegularIntervalScheduleCommand command = new UpdateRegularIntervalScheduleCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID regularIntervalScheduleId = null;
	protected RegularIntervalScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RegularIntervalScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRegularIntervalScheduleList = 0;
}
