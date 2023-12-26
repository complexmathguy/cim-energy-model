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
 * Test GroundDisconnector class.
 *
 * @author your_name_here
 */
public class GroundDisconnectorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GroundDisconnectorTest() {
		subscriber = new GroundDisconnectorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GroundDisconnectorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GroundDisconnector...");
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
	 * jumpstart the process by instantiating2 GroundDisconnector
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		groundDisconnectorId = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance()
		.createGroundDisconnector( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance()
				.createGroundDisconnector( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.groundDisconnectorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GroundDisconnector : " + successValue.getGroundDisconnectorId());
							  if (successValue.getGroundDisconnectorId().equals(groundDisconnectorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGroundDisconnectorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GroundDisconnector test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on groundDisconnector consumed")
					);
			subscriber.groundDisconnectorSubscribe( groundDisconnectorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GroundDisconnector : " + successValue.getGroundDisconnectorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGroundDisconnectorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on groundDisconnector for groundDisconnectorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GroundDisconnector. 
	 */
	protected GroundDisconnector read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GroundDisconnector" );

		GroundDisconnector entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GroundDisconnector with primary key" );
		msg.append( groundDisconnectorId );
		
		GroundDisconnectorFetchOneSummary fetchOneSummary = new GroundDisconnectorFetchOneSummary( groundDisconnectorId );

		try {
			entity = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().getGroundDisconnector( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GroundDisconnector " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GroundDisconnector.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GroundDisconnector." );

		StringBuilder msg = new StringBuilder( "Failed to update a GroundDisconnector : " );        
		GroundDisconnector entity = read();
		UpdateGroundDisconnectorCommand command = generateUpdateCommand();
		command.setGroundDisconnectorId(entity.getGroundDisconnectorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GroundDisconnector." );

			// for use later on...
			groundDisconnectorId = entity.getGroundDisconnectorId();

			GroundDisconnectorBusinessDelegate proxy = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance();  

			proxy.updateGroundDisconnector( command ).get();

			LOGGER.info( "-- Successfully saved GroundDisconnector - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + groundDisconnectorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GroundDisconnector.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GroundDisconnector." );

		GroundDisconnector entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GroundDisconnector with id " + groundDisconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GroundDisconnector with id " + groundDisconnectorId );

			throw e;
		}

		try{
			GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().delete( new DeleteGroundDisconnectorCommand( entity.getGroundDisconnectorId() ) ).get();
			LOGGER.info( "-- Successfully deleted GroundDisconnector with id " + groundDisconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GroundDisconnector with id " + groundDisconnectorId );

			throw e;
		}
	}

	/**
	 * get all GroundDisconnectors.
	 */
	protected List<GroundDisconnector> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GroundDisconnectors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GroundDisconnector : " );        
		List<GroundDisconnector> collection  = new ArrayList<>();

		try {
			// call the static get method on the GroundDisconnectorBusinessDelegate
			collection = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().getAllGroundDisconnector();
			assertNotNull( collection, "An Empty collection of GroundDisconnector was incorrectly returned.");
			
			// Now print out the values
			GroundDisconnector entity = null;            
			Iterator<GroundDisconnector> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGroundDisconnectorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GroundDisconnectorTest
	 */
	protected GroundDisconnectorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GroundDisconnector
	 * 
	 * @return CreateGroundDisconnectorCommand alias
	 */
	protected CreateGroundDisconnectorCommand generateNewCommand() {
        CreateGroundDisconnectorCommand command = new CreateGroundDisconnectorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated GroundDisconnector
		 * 
		 * @return UpdateGroundDisconnectorCommand alias
		 */
	protected UpdateGroundDisconnectorCommand generateUpdateCommand() {
	        UpdateGroundDisconnectorCommand command = new UpdateGroundDisconnectorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID groundDisconnectorId = null;
	protected GroundDisconnectorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GroundDisconnectorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGroundDisconnectorList = 0;
}
