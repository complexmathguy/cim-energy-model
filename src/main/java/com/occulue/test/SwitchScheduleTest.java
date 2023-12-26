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
 * Test SwitchSchedule class.
 *
 * @author your_name_here
 */
public class SwitchScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SwitchScheduleTest() {
		subscriber = new SwitchScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SwitchScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SwitchSchedule...");
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
	 * jumpstart the process by instantiating2 SwitchSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		switchScheduleId = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance()
		.createSwitchSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SwitchScheduleBusinessDelegate.getSwitchScheduleInstance()
				.createSwitchSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.switchScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SwitchSchedule : " + successValue.getSwitchScheduleId());
							  if (successValue.getSwitchScheduleId().equals(switchScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSwitchScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SwitchSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchSchedule consumed")
					);
			subscriber.switchScheduleSubscribe( switchScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SwitchSchedule : " + successValue.getSwitchScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSwitchScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchSchedule for switchScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SwitchSchedule. 
	 */
	protected SwitchSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SwitchSchedule" );

		SwitchSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SwitchSchedule with primary key" );
		msg.append( switchScheduleId );
		
		SwitchScheduleFetchOneSummary fetchOneSummary = new SwitchScheduleFetchOneSummary( switchScheduleId );

		try {
			entity = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance().getSwitchSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SwitchSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SwitchSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SwitchSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a SwitchSchedule : " );        
		SwitchSchedule entity = read();
		UpdateSwitchScheduleCommand command = generateUpdateCommand();
		command.setSwitchScheduleId(entity.getSwitchScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SwitchSchedule." );

			// for use later on...
			switchScheduleId = entity.getSwitchScheduleId();

			SwitchScheduleBusinessDelegate proxy = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance();  

			proxy.updateSwitchSchedule( command ).get();

			LOGGER.info( "-- Successfully saved SwitchSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + switchScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SwitchSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SwitchSchedule." );

		SwitchSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SwitchSchedule with id " + switchScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SwitchSchedule with id " + switchScheduleId );

			throw e;
		}

		try{
			SwitchScheduleBusinessDelegate.getSwitchScheduleInstance().delete( new DeleteSwitchScheduleCommand( entity.getSwitchScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted SwitchSchedule with id " + switchScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SwitchSchedule with id " + switchScheduleId );

			throw e;
		}
	}

	/**
	 * get all SwitchSchedules.
	 */
	protected List<SwitchSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SwitchSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SwitchSchedule : " );        
		List<SwitchSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the SwitchScheduleBusinessDelegate
			collection = SwitchScheduleBusinessDelegate.getSwitchScheduleInstance().getAllSwitchSchedule();
			assertNotNull( collection, "An Empty collection of SwitchSchedule was incorrectly returned.");
			
			// Now print out the values
			SwitchSchedule entity = null;            
			Iterator<SwitchSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSwitchScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SwitchScheduleTest
	 */
	protected SwitchScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SwitchSchedule
	 * 
	 * @return CreateSwitchScheduleCommand alias
	 */
	protected CreateSwitchScheduleCommand generateNewCommand() {
        CreateSwitchScheduleCommand command = new CreateSwitchScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SwitchSchedule
		 * 
		 * @return UpdateSwitchScheduleCommand alias
		 */
	protected UpdateSwitchScheduleCommand generateUpdateCommand() {
	        UpdateSwitchScheduleCommand command = new UpdateSwitchScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID switchScheduleId = null;
	protected SwitchScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SwitchScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSwitchScheduleList = 0;
}
