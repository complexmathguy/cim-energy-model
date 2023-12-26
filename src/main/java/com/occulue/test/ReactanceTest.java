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
 * Test Reactance class.
 *
 * @author your_name_here
 */
public class ReactanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ReactanceTest() {
		subscriber = new ReactanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ReactanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Reactance...");
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
	 * jumpstart the process by instantiating2 Reactance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		reactanceId = ReactanceBusinessDelegate.getReactanceInstance()
		.createReactance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ReactanceBusinessDelegate.getReactanceInstance()
				.createReactance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.reactanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Reactance : " + successValue.getReactanceId());
							  if (successValue.getReactanceId().equals(reactanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfReactanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Reactance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactance consumed")
					);
			subscriber.reactanceSubscribe( reactanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Reactance : " + successValue.getReactanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfReactanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactance for reactanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Reactance. 
	 */
	protected Reactance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Reactance" );

		Reactance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Reactance with primary key" );
		msg.append( reactanceId );
		
		ReactanceFetchOneSummary fetchOneSummary = new ReactanceFetchOneSummary( reactanceId );

		try {
			entity = ReactanceBusinessDelegate.getReactanceInstance().getReactance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Reactance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Reactance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Reactance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Reactance : " );        
		Reactance entity = read();
		UpdateReactanceCommand command = generateUpdateCommand();
		command.setReactanceId(entity.getReactanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Reactance." );

			// for use later on...
			reactanceId = entity.getReactanceId();

			ReactanceBusinessDelegate proxy = ReactanceBusinessDelegate.getReactanceInstance();  

			proxy.updateReactance( command ).get();

			LOGGER.info( "-- Successfully saved Reactance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + reactanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Reactance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Reactance." );

		Reactance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Reactance with id " + reactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Reactance with id " + reactanceId );

			throw e;
		}

		try{
			ReactanceBusinessDelegate.getReactanceInstance().delete( new DeleteReactanceCommand( entity.getReactanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Reactance with id " + reactanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Reactance with id " + reactanceId );

			throw e;
		}
	}

	/**
	 * get all Reactances.
	 */
	protected List<Reactance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Reactances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Reactance : " );        
		List<Reactance> collection  = new ArrayList<>();

		try {
			// call the static get method on the ReactanceBusinessDelegate
			collection = ReactanceBusinessDelegate.getReactanceInstance().getAllReactance();
			assertNotNull( collection, "An Empty collection of Reactance was incorrectly returned.");
			
			// Now print out the values
			Reactance entity = null;            
			Iterator<Reactance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getReactanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ReactanceTest
	 */
	protected ReactanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Reactance
	 * 
	 * @return CreateReactanceCommand alias
	 */
	protected CreateReactanceCommand generateNewCommand() {
        CreateReactanceCommand command = new CreateReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Reactance
		 * 
		 * @return UpdateReactanceCommand alias
		 */
	protected UpdateReactanceCommand generateUpdateCommand() {
	        UpdateReactanceCommand command = new UpdateReactanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID reactanceId = null;
	protected ReactanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ReactanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfReactanceList = 0;
}
