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
 * Test NonConformLoadSchedule class.
 *
 * @author your_name_here
 */
public class NonConformLoadScheduleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NonConformLoadScheduleTest() {
		subscriber = new NonConformLoadScheduleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NonConformLoadScheduleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NonConformLoadSchedule...");
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
	 * jumpstart the process by instantiating2 NonConformLoadSchedule
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nonConformLoadScheduleId = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance()
		.createNonConformLoadSchedule( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance()
				.createNonConformLoadSchedule( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nonConformLoadScheduleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NonConformLoadSchedule : " + successValue.getNonConformLoadScheduleId());
							  if (successValue.getNonConformLoadScheduleId().equals(nonConformLoadScheduleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNonConformLoadScheduleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NonConformLoadSchedule test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoadSchedule consumed")
					);
			subscriber.nonConformLoadScheduleSubscribe( nonConformLoadScheduleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NonConformLoadSchedule : " + successValue.getNonConformLoadScheduleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNonConformLoadScheduleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoadSchedule for nonConformLoadScheduleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NonConformLoadSchedule. 
	 */
	protected NonConformLoadSchedule read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NonConformLoadSchedule" );

		NonConformLoadSchedule entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NonConformLoadSchedule with primary key" );
		msg.append( nonConformLoadScheduleId );
		
		NonConformLoadScheduleFetchOneSummary fetchOneSummary = new NonConformLoadScheduleFetchOneSummary( nonConformLoadScheduleId );

		try {
			entity = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().getNonConformLoadSchedule( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NonConformLoadSchedule " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NonConformLoadSchedule.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NonConformLoadSchedule." );

		StringBuilder msg = new StringBuilder( "Failed to update a NonConformLoadSchedule : " );        
		NonConformLoadSchedule entity = read();
		UpdateNonConformLoadScheduleCommand command = generateUpdateCommand();
		command.setNonConformLoadScheduleId(entity.getNonConformLoadScheduleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NonConformLoadSchedule." );

			// for use later on...
			nonConformLoadScheduleId = entity.getNonConformLoadScheduleId();

			NonConformLoadScheduleBusinessDelegate proxy = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance();  

			proxy.updateNonConformLoadSchedule( command ).get();

			LOGGER.info( "-- Successfully saved NonConformLoadSchedule - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nonConformLoadScheduleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NonConformLoadSchedule.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NonConformLoadSchedule." );

		NonConformLoadSchedule entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NonConformLoadSchedule with id " + nonConformLoadScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NonConformLoadSchedule with id " + nonConformLoadScheduleId );

			throw e;
		}

		try{
			NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().delete( new DeleteNonConformLoadScheduleCommand( entity.getNonConformLoadScheduleId() ) ).get();
			LOGGER.info( "-- Successfully deleted NonConformLoadSchedule with id " + nonConformLoadScheduleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NonConformLoadSchedule with id " + nonConformLoadScheduleId );

			throw e;
		}
	}

	/**
	 * get all NonConformLoadSchedules.
	 */
	protected List<NonConformLoadSchedule> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NonConformLoadSchedules:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NonConformLoadSchedule : " );        
		List<NonConformLoadSchedule> collection  = new ArrayList<>();

		try {
			// call the static get method on the NonConformLoadScheduleBusinessDelegate
			collection = NonConformLoadScheduleBusinessDelegate.getNonConformLoadScheduleInstance().getAllNonConformLoadSchedule();
			assertNotNull( collection, "An Empty collection of NonConformLoadSchedule was incorrectly returned.");
			
			// Now print out the values
			NonConformLoadSchedule entity = null;            
			Iterator<NonConformLoadSchedule> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNonConformLoadScheduleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NonConformLoadScheduleTest
	 */
	protected NonConformLoadScheduleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NonConformLoadSchedule
	 * 
	 * @return CreateNonConformLoadScheduleCommand alias
	 */
	protected CreateNonConformLoadScheduleCommand generateNewCommand() {
        CreateNonConformLoadScheduleCommand command = new CreateNonConformLoadScheduleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated NonConformLoadSchedule
		 * 
		 * @return UpdateNonConformLoadScheduleCommand alias
		 */
	protected UpdateNonConformLoadScheduleCommand generateUpdateCommand() {
	        UpdateNonConformLoadScheduleCommand command = new UpdateNonConformLoadScheduleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nonConformLoadScheduleId = null;
	protected NonConformLoadScheduleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NonConformLoadScheduleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNonConformLoadScheduleList = 0;
}
