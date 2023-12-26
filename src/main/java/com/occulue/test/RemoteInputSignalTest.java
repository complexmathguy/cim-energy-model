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
 * Test RemoteInputSignal class.
 *
 * @author your_name_here
 */
public class RemoteInputSignalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RemoteInputSignalTest() {
		subscriber = new RemoteInputSignalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RemoteInputSignalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RemoteInputSignal...");
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
	 * jumpstart the process by instantiating2 RemoteInputSignal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		remoteInputSignalId = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
		.createRemoteInputSignal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
				.createRemoteInputSignal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.remoteInputSignalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RemoteInputSignal : " + successValue.getRemoteInputSignalId());
							  if (successValue.getRemoteInputSignalId().equals(remoteInputSignalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRemoteInputSignalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RemoteInputSignal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on remoteInputSignal consumed")
					);
			subscriber.remoteInputSignalSubscribe( remoteInputSignalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RemoteInputSignal : " + successValue.getRemoteInputSignalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRemoteInputSignalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on remoteInputSignal for remoteInputSignalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RemoteInputSignal. 
	 */
	protected RemoteInputSignal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RemoteInputSignal" );

		RemoteInputSignal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RemoteInputSignal with primary key" );
		msg.append( remoteInputSignalId );
		
		RemoteInputSignalFetchOneSummary fetchOneSummary = new RemoteInputSignalFetchOneSummary( remoteInputSignalId );

		try {
			entity = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance().getRemoteInputSignal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RemoteInputSignal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RemoteInputSignal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RemoteInputSignal." );

		StringBuilder msg = new StringBuilder( "Failed to update a RemoteInputSignal : " );        
		RemoteInputSignal entity = read();
		UpdateRemoteInputSignalCommand command = generateUpdateCommand();
		command.setRemoteInputSignalId(entity.getRemoteInputSignalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RemoteInputSignal." );

			// for use later on...
			remoteInputSignalId = entity.getRemoteInputSignalId();

			RemoteInputSignalBusinessDelegate proxy = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance();  

			proxy.updateRemoteInputSignal( command ).get();

			LOGGER.info( "-- Successfully saved RemoteInputSignal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + remoteInputSignalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RemoteInputSignal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RemoteInputSignal." );

		RemoteInputSignal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RemoteInputSignal with id " + remoteInputSignalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RemoteInputSignal with id " + remoteInputSignalId );

			throw e;
		}

		try{
			RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance().delete( new DeleteRemoteInputSignalCommand( entity.getRemoteInputSignalId() ) ).get();
			LOGGER.info( "-- Successfully deleted RemoteInputSignal with id " + remoteInputSignalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RemoteInputSignal with id " + remoteInputSignalId );

			throw e;
		}
	}

	/**
	 * get all RemoteInputSignals.
	 */
	protected List<RemoteInputSignal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RemoteInputSignals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RemoteInputSignal : " );        
		List<RemoteInputSignal> collection  = new ArrayList<>();

		try {
			// call the static get method on the RemoteInputSignalBusinessDelegate
			collection = RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance().getAllRemoteInputSignal();
			assertNotNull( collection, "An Empty collection of RemoteInputSignal was incorrectly returned.");
			
			// Now print out the values
			RemoteInputSignal entity = null;            
			Iterator<RemoteInputSignal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRemoteInputSignalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RemoteInputSignalTest
	 */
	protected RemoteInputSignalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RemoteInputSignal
	 * 
	 * @return CreateRemoteInputSignalCommand alias
	 */
	protected CreateRemoteInputSignalCommand generateNewCommand() {
        CreateRemoteInputSignalCommand command = new CreateRemoteInputSignalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RemoteInputSignal
		 * 
		 * @return UpdateRemoteInputSignalCommand alias
		 */
	protected UpdateRemoteInputSignalCommand generateUpdateCommand() {
	        UpdateRemoteInputSignalCommand command = new UpdateRemoteInputSignalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID remoteInputSignalId = null;
	protected RemoteInputSignalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RemoteInputSignalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRemoteInputSignalList = 0;
}
