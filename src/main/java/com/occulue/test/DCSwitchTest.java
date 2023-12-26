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
 * Test DCSwitch class.
 *
 * @author your_name_here
 */
public class DCSwitchTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCSwitchTest() {
		subscriber = new DCSwitchSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCSwitchTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCSwitch...");
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
	 * jumpstart the process by instantiating2 DCSwitch
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCSwitchId = DCSwitchBusinessDelegate.getDCSwitchInstance()
		.createDCSwitch( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCSwitchBusinessDelegate.getDCSwitchInstance()
				.createDCSwitch( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCSwitchSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCSwitch : " + successValue.getDCSwitchId());
							  if (successValue.getDCSwitchId().equals(dCSwitchId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCSwitchList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCSwitch test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCSwitch consumed")
					);
			subscriber.dCSwitchSubscribe( dCSwitchId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCSwitch : " + successValue.getDCSwitchId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCSwitchList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCSwitch for dCSwitchId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCSwitch. 
	 */
	protected DCSwitch read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCSwitch" );

		DCSwitch entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCSwitch with primary key" );
		msg.append( dCSwitchId );
		
		DCSwitchFetchOneSummary fetchOneSummary = new DCSwitchFetchOneSummary( dCSwitchId );

		try {
			entity = DCSwitchBusinessDelegate.getDCSwitchInstance().getDCSwitch( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCSwitch " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCSwitch.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCSwitch." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCSwitch : " );        
		DCSwitch entity = read();
		UpdateDCSwitchCommand command = generateUpdateCommand();
		command.setDCSwitchId(entity.getDCSwitchId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCSwitch." );

			// for use later on...
			dCSwitchId = entity.getDCSwitchId();

			DCSwitchBusinessDelegate proxy = DCSwitchBusinessDelegate.getDCSwitchInstance();  

			proxy.updateDCSwitch( command ).get();

			LOGGER.info( "-- Successfully saved DCSwitch - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCSwitchId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCSwitch.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCSwitch." );

		DCSwitch entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCSwitch with id " + dCSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCSwitch with id " + dCSwitchId );

			throw e;
		}

		try{
			DCSwitchBusinessDelegate.getDCSwitchInstance().delete( new DeleteDCSwitchCommand( entity.getDCSwitchId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCSwitch with id " + dCSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCSwitch with id " + dCSwitchId );

			throw e;
		}
	}

	/**
	 * get all DCSwitchs.
	 */
	protected List<DCSwitch> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCSwitchs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCSwitch : " );        
		List<DCSwitch> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCSwitchBusinessDelegate
			collection = DCSwitchBusinessDelegate.getDCSwitchInstance().getAllDCSwitch();
			assertNotNull( collection, "An Empty collection of DCSwitch was incorrectly returned.");
			
			// Now print out the values
			DCSwitch entity = null;            
			Iterator<DCSwitch> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCSwitchId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCSwitchTest
	 */
	protected DCSwitchTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCSwitch
	 * 
	 * @return CreateDCSwitchCommand alias
	 */
	protected CreateDCSwitchCommand generateNewCommand() {
        CreateDCSwitchCommand command = new CreateDCSwitchCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCSwitch
		 * 
		 * @return UpdateDCSwitchCommand alias
		 */
	protected UpdateDCSwitchCommand generateUpdateCommand() {
	        UpdateDCSwitchCommand command = new UpdateDCSwitchCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCSwitchId = null;
	protected DCSwitchSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCSwitchTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCSwitchList = 0;
}
