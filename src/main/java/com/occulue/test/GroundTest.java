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
 * Test Ground class.
 *
 * @author your_name_here
 */
public class GroundTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GroundTest() {
		subscriber = new GroundSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GroundTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Ground...");
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
	 * jumpstart the process by instantiating2 Ground
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		groundId = GroundBusinessDelegate.getGroundInstance()
		.createGround( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GroundBusinessDelegate.getGroundInstance()
				.createGround( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.groundSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Ground : " + successValue.getGroundId());
							  if (successValue.getGroundId().equals(groundId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGroundList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Ground test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ground consumed")
					);
			subscriber.groundSubscribe( groundId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Ground : " + successValue.getGroundId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGroundList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ground for groundId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Ground. 
	 */
	protected Ground read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Ground" );

		Ground entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Ground with primary key" );
		msg.append( groundId );
		
		GroundFetchOneSummary fetchOneSummary = new GroundFetchOneSummary( groundId );

		try {
			entity = GroundBusinessDelegate.getGroundInstance().getGround( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Ground " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Ground.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Ground." );

		StringBuilder msg = new StringBuilder( "Failed to update a Ground : " );        
		Ground entity = read();
		UpdateGroundCommand command = generateUpdateCommand();
		command.setGroundId(entity.getGroundId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Ground." );

			// for use later on...
			groundId = entity.getGroundId();

			GroundBusinessDelegate proxy = GroundBusinessDelegate.getGroundInstance();  

			proxy.updateGround( command ).get();

			LOGGER.info( "-- Successfully saved Ground - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + groundId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Ground.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Ground." );

		Ground entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Ground with id " + groundId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Ground with id " + groundId );

			throw e;
		}

		try{
			GroundBusinessDelegate.getGroundInstance().delete( new DeleteGroundCommand( entity.getGroundId() ) ).get();
			LOGGER.info( "-- Successfully deleted Ground with id " + groundId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Ground with id " + groundId );

			throw e;
		}
	}

	/**
	 * get all Grounds.
	 */
	protected List<Ground> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Grounds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Ground : " );        
		List<Ground> collection  = new ArrayList<>();

		try {
			// call the static get method on the GroundBusinessDelegate
			collection = GroundBusinessDelegate.getGroundInstance().getAllGround();
			assertNotNull( collection, "An Empty collection of Ground was incorrectly returned.");
			
			// Now print out the values
			Ground entity = null;            
			Iterator<Ground> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGroundId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GroundTest
	 */
	protected GroundTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Ground
	 * 
	 * @return CreateGroundCommand alias
	 */
	protected CreateGroundCommand generateNewCommand() {
        CreateGroundCommand command = new CreateGroundCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Ground
		 * 
		 * @return UpdateGroundCommand alias
		 */
	protected UpdateGroundCommand generateUpdateCommand() {
	        UpdateGroundCommand command = new UpdateGroundCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID groundId = null;
	protected GroundSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GroundTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGroundList = 0;
}
