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
 * Test ConformLoadSchedule class.
 *
 * @author your_name_here
 */
public class ConformLoadScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConformLoadScheduleTest() {
		subscriber = new ConformLoadScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConformLoadScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConformLoadSchedule...");
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
	 * jumpstart the process by instantiating2 ConformLoadSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conformLoadScheduleId = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
		.createConformLoadSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance()
				.createConformLoadSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conformLoadScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConformLoadSchedule : " + successValue.getConformLoadScheduleId());
							  if (successValue.getConformLoadScheduleId().equals(conformLoadScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConformLoadScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConformLoadSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoadSchedule consumed")
					);
			subscriber.conformLoadScheduleSubscribe( conformLoadScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConformLoadSchedule : " + successValue.getConformLoadScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConformLoadScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoadSchedule for conformLoadScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConformLoadSchedule. 
	 */
	protected ConformLoadSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConformLoadSchedule" );

		ConformLoadSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConformLoadSchedule with primary key" );
		msg.append( conformLoadScheduleId );
		
		ConformLoadScheduleFetchOneSummary fetchOneSummary = new ConformLoadScheduleFetchOneSummary( conformLoadScheduleId );

		try {
			entity = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().getConformLoadSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConformLoadSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConformLoadSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConformLoadSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConformLoadSchedule : " );        
		ConformLoadSchedule entity = read();
		UpdateConformLoadScheduleCommand command = generateUpdateCommand();
		command.setConformLoadScheduleId(entity.getConformLoadScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConformLoadSchedule." );

			// for use later on...
			conformLoadScheduleId = entity.getConformLoadScheduleId();

			ConformLoadScheduleBusinessDelegate proxy = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance();  

			proxy.updateConformLoadSchedule( command ).get();

			LOGGER.info( "-- Successfully saved ConformLoadSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conformLoadScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConformLoadSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConformLoadSchedule." );

		ConformLoadSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConformLoadSchedule with id " + conformLoadScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConformLoadSchedule with id " + conformLoadScheduleId );

			throw e;
		}

		try{
			ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().delete( new DeleteConformLoadScheduleCommand( entity.getConformLoadScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConformLoadSchedule with id " + conformLoadScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConformLoadSchedule with id " + conformLoadScheduleId );

			throw e;
		}
	}

	/**
	 * get all ConformLoadSchedules.
	 */
	protected List<ConformLoadSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConformLoadSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConformLoadSchedule : " );        
		List<ConformLoadSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConformLoadScheduleBusinessDelegate
			collection = ConformLoadScheduleBusinessDelegate.getConformLoadScheduleInstance().getAllConformLoadSchedule();
			assertNotNull( collection, "An Empty collection of ConformLoadSchedule was incorrectly returned.");
			
			// Now print out the values
			ConformLoadSchedule entity = null;            
			Iterator<ConformLoadSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConformLoadScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConformLoadScheduleTest
	 */
	protected ConformLoadScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConformLoadSchedule
	 * 
	 * @return CreateConformLoadScheduleCommand alias
	 */
	protected CreateConformLoadScheduleCommand generateNewCommand() {
        CreateConformLoadScheduleCommand command = new CreateConformLoadScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ConformLoadSchedule
		 * 
		 * @return UpdateConformLoadScheduleCommand alias
		 */
	protected UpdateConformLoadScheduleCommand generateUpdateCommand() {
	        UpdateConformLoadScheduleCommand command = new UpdateConformLoadScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conformLoadScheduleId = null;
	protected ConformLoadScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConformLoadScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConformLoadScheduleList = 0;
}
