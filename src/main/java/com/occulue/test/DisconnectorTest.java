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
 * Test Disconnector class.
 *
 * @author your_name_here
 */
public class DisconnectorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DisconnectorTest() {
		subscriber = new DisconnectorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DisconnectorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Disconnector...");
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
	 * jumpstart the process by instantiating2 Disconnector
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		disconnectorId = DisconnectorBusinessDelegate.getDisconnectorInstance()
		.createDisconnector( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DisconnectorBusinessDelegate.getDisconnectorInstance()
				.createDisconnector( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.disconnectorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Disconnector : " + successValue.getDisconnectorId());
							  if (successValue.getDisconnectorId().equals(disconnectorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDisconnectorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Disconnector test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on disconnector consumed")
					);
			subscriber.disconnectorSubscribe( disconnectorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Disconnector : " + successValue.getDisconnectorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDisconnectorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on disconnector for disconnectorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Disconnector. 
	 */
	protected Disconnector read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Disconnector" );

		Disconnector entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Disconnector with primary key" );
		msg.append( disconnectorId );
		
		DisconnectorFetchOneSummary fetchOneSummary = new DisconnectorFetchOneSummary( disconnectorId );

		try {
			entity = DisconnectorBusinessDelegate.getDisconnectorInstance().getDisconnector( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Disconnector " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Disconnector.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Disconnector." );

		StringBuilder msg = new StringBuilder( "Failed to update a Disconnector : " );        
		Disconnector entity = read();
		UpdateDisconnectorCommand command = generateUpdateCommand();
		command.setDisconnectorId(entity.getDisconnectorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Disconnector." );

			// for use later on...
			disconnectorId = entity.getDisconnectorId();

			DisconnectorBusinessDelegate proxy = DisconnectorBusinessDelegate.getDisconnectorInstance();  

			proxy.updateDisconnector( command ).get();

			LOGGER.info( "-- Successfully saved Disconnector - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + disconnectorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Disconnector.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Disconnector." );

		Disconnector entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Disconnector with id " + disconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Disconnector with id " + disconnectorId );

			throw e;
		}

		try{
			DisconnectorBusinessDelegate.getDisconnectorInstance().delete( new DeleteDisconnectorCommand( entity.getDisconnectorId() ) ).get();
			LOGGER.info( "-- Successfully deleted Disconnector with id " + disconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Disconnector with id " + disconnectorId );

			throw e;
		}
	}

	/**
	 * get all Disconnectors.
	 */
	protected List<Disconnector> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Disconnectors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Disconnector : " );        
		List<Disconnector> collection  = new ArrayList<>();

		try {
			// call the static get method on the DisconnectorBusinessDelegate
			collection = DisconnectorBusinessDelegate.getDisconnectorInstance().getAllDisconnector();
			assertNotNull( collection, "An Empty collection of Disconnector was incorrectly returned.");
			
			// Now print out the values
			Disconnector entity = null;            
			Iterator<Disconnector> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDisconnectorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DisconnectorTest
	 */
	protected DisconnectorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Disconnector
	 * 
	 * @return CreateDisconnectorCommand alias
	 */
	protected CreateDisconnectorCommand generateNewCommand() {
        CreateDisconnectorCommand command = new CreateDisconnectorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Disconnector
		 * 
		 * @return UpdateDisconnectorCommand alias
		 */
	protected UpdateDisconnectorCommand generateUpdateCommand() {
	        UpdateDisconnectorCommand command = new UpdateDisconnectorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID disconnectorId = null;
	protected DisconnectorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DisconnectorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDisconnectorList = 0;
}
