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
 * Test ProtectedSwitch class.
 *
 * @author your_name_here
 */
public class ProtectedSwitchTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ProtectedSwitchTest() {
		subscriber = new ProtectedSwitchSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ProtectedSwitchTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ProtectedSwitch...");
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
	 * jumpstart the process by instantiating2 ProtectedSwitch
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		protectedSwitchId = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance()
		.createProtectedSwitch( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance()
				.createProtectedSwitch( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.protectedSwitchSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ProtectedSwitch : " + successValue.getProtectedSwitchId());
							  if (successValue.getProtectedSwitchId().equals(protectedSwitchId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfProtectedSwitchList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ProtectedSwitch test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on protectedSwitch consumed")
					);
			subscriber.protectedSwitchSubscribe( protectedSwitchId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ProtectedSwitch : " + successValue.getProtectedSwitchId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfProtectedSwitchList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on protectedSwitch for protectedSwitchId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ProtectedSwitch. 
	 */
	protected ProtectedSwitch read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ProtectedSwitch" );

		ProtectedSwitch entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ProtectedSwitch with primary key" );
		msg.append( protectedSwitchId );
		
		ProtectedSwitchFetchOneSummary fetchOneSummary = new ProtectedSwitchFetchOneSummary( protectedSwitchId );

		try {
			entity = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().getProtectedSwitch( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ProtectedSwitch " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ProtectedSwitch.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ProtectedSwitch." );

		StringBuilder msg = new StringBuilder( "Failed to update a ProtectedSwitch : " );        
		ProtectedSwitch entity = read();
		UpdateProtectedSwitchCommand command = generateUpdateCommand();
		command.setProtectedSwitchId(entity.getProtectedSwitchId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ProtectedSwitch." );

			// for use later on...
			protectedSwitchId = entity.getProtectedSwitchId();

			ProtectedSwitchBusinessDelegate proxy = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance();  

			proxy.updateProtectedSwitch( command ).get();

			LOGGER.info( "-- Successfully saved ProtectedSwitch - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + protectedSwitchId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ProtectedSwitch.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ProtectedSwitch." );

		ProtectedSwitch entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ProtectedSwitch with id " + protectedSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ProtectedSwitch with id " + protectedSwitchId );

			throw e;
		}

		try{
			ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().delete( new DeleteProtectedSwitchCommand( entity.getProtectedSwitchId() ) ).get();
			LOGGER.info( "-- Successfully deleted ProtectedSwitch with id " + protectedSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ProtectedSwitch with id " + protectedSwitchId );

			throw e;
		}
	}

	/**
	 * get all ProtectedSwitchs.
	 */
	protected List<ProtectedSwitch> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ProtectedSwitchs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ProtectedSwitch : " );        
		List<ProtectedSwitch> collection  = new ArrayList<>();

		try {
			// call the static get method on the ProtectedSwitchBusinessDelegate
			collection = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().getAllProtectedSwitch();
			assertNotNull( collection, "An Empty collection of ProtectedSwitch was incorrectly returned.");
			
			// Now print out the values
			ProtectedSwitch entity = null;            
			Iterator<ProtectedSwitch> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getProtectedSwitchId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ProtectedSwitchTest
	 */
	protected ProtectedSwitchTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ProtectedSwitch
	 * 
	 * @return CreateProtectedSwitchCommand alias
	 */
	protected CreateProtectedSwitchCommand generateNewCommand() {
        CreateProtectedSwitchCommand command = new CreateProtectedSwitchCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ProtectedSwitch
		 * 
		 * @return UpdateProtectedSwitchCommand alias
		 */
	protected UpdateProtectedSwitchCommand generateUpdateCommand() {
	        UpdateProtectedSwitchCommand command = new UpdateProtectedSwitchCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID protectedSwitchId = null;
	protected ProtectedSwitchSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ProtectedSwitchTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfProtectedSwitchList = 0;
}
