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
 * Test RegulationSchedule class.
 *
 * @author your_name_here
 */
public class RegulationScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RegulationScheduleTest() {
		subscriber = new RegulationScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RegulationScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RegulationSchedule...");
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
	 * jumpstart the process by instantiating2 RegulationSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		regulationScheduleId = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance()
		.createRegulationSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RegulationScheduleBusinessDelegate.getRegulationScheduleInstance()
				.createRegulationSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.regulationScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RegulationSchedule : " + successValue.getRegulationScheduleId());
							  if (successValue.getRegulationScheduleId().equals(regulationScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRegulationScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RegulationSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulationSchedule consumed")
					);
			subscriber.regulationScheduleSubscribe( regulationScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RegulationSchedule : " + successValue.getRegulationScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRegulationScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulationSchedule for regulationScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RegulationSchedule. 
	 */
	protected RegulationSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RegulationSchedule" );

		RegulationSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RegulationSchedule with primary key" );
		msg.append( regulationScheduleId );
		
		RegulationScheduleFetchOneSummary fetchOneSummary = new RegulationScheduleFetchOneSummary( regulationScheduleId );

		try {
			entity = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().getRegulationSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RegulationSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RegulationSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RegulationSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a RegulationSchedule : " );        
		RegulationSchedule entity = read();
		UpdateRegulationScheduleCommand command = generateUpdateCommand();
		command.setRegulationScheduleId(entity.getRegulationScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RegulationSchedule." );

			// for use later on...
			regulationScheduleId = entity.getRegulationScheduleId();

			RegulationScheduleBusinessDelegate proxy = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance();  

			proxy.updateRegulationSchedule( command ).get();

			LOGGER.info( "-- Successfully saved RegulationSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + regulationScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RegulationSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RegulationSchedule." );

		RegulationSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RegulationSchedule with id " + regulationScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RegulationSchedule with id " + regulationScheduleId );

			throw e;
		}

		try{
			RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().delete( new DeleteRegulationScheduleCommand( entity.getRegulationScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted RegulationSchedule with id " + regulationScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RegulationSchedule with id " + regulationScheduleId );

			throw e;
		}
	}

	/**
	 * get all RegulationSchedules.
	 */
	protected List<RegulationSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RegulationSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RegulationSchedule : " );        
		List<RegulationSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the RegulationScheduleBusinessDelegate
			collection = RegulationScheduleBusinessDelegate.getRegulationScheduleInstance().getAllRegulationSchedule();
			assertNotNull( collection, "An Empty collection of RegulationSchedule was incorrectly returned.");
			
			// Now print out the values
			RegulationSchedule entity = null;            
			Iterator<RegulationSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRegulationScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RegulationScheduleTest
	 */
	protected RegulationScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RegulationSchedule
	 * 
	 * @return CreateRegulationScheduleCommand alias
	 */
	protected CreateRegulationScheduleCommand generateNewCommand() {
        CreateRegulationScheduleCommand command = new CreateRegulationScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated RegulationSchedule
		 * 
		 * @return UpdateRegulationScheduleCommand alias
		 */
	protected UpdateRegulationScheduleCommand generateUpdateCommand() {
	        UpdateRegulationScheduleCommand command = new UpdateRegulationScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID regulationScheduleId = null;
	protected RegulationScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RegulationScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRegulationScheduleList = 0;
}
