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
 * Test LoadBreakSwitch class.
 *
 * @author your_name_here
 */
public class LoadBreakSwitchTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadBreakSwitchTest() {
		subscriber = new LoadBreakSwitchSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadBreakSwitchTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadBreakSwitch...");
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
	 * jumpstart the process by instantiating2 LoadBreakSwitch
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadBreakSwitchId = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance()
		.createLoadBreakSwitch( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance()
				.createLoadBreakSwitch( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadBreakSwitchSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadBreakSwitch : " + successValue.getLoadBreakSwitchId());
							  if (successValue.getLoadBreakSwitchId().equals(loadBreakSwitchId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadBreakSwitchList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadBreakSwitch test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadBreakSwitch consumed")
					);
			subscriber.loadBreakSwitchSubscribe( loadBreakSwitchId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadBreakSwitch : " + successValue.getLoadBreakSwitchId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadBreakSwitchList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadBreakSwitch for loadBreakSwitchId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadBreakSwitch. 
	 */
	protected LoadBreakSwitch read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadBreakSwitch" );

		LoadBreakSwitch entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadBreakSwitch with primary key" );
		msg.append( loadBreakSwitchId );
		
		LoadBreakSwitchFetchOneSummary fetchOneSummary = new LoadBreakSwitchFetchOneSummary( loadBreakSwitchId );

		try {
			entity = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().getLoadBreakSwitch( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadBreakSwitch " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadBreakSwitch.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadBreakSwitch." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadBreakSwitch : " );        
		LoadBreakSwitch entity = read();
		UpdateLoadBreakSwitchCommand command = generateUpdateCommand();
		command.setLoadBreakSwitchId(entity.getLoadBreakSwitchId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadBreakSwitch." );

			// for use later on...
			loadBreakSwitchId = entity.getLoadBreakSwitchId();

			LoadBreakSwitchBusinessDelegate proxy = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance();  

			proxy.updateLoadBreakSwitch( command ).get();

			LOGGER.info( "-- Successfully saved LoadBreakSwitch - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadBreakSwitchId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadBreakSwitch.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadBreakSwitch." );

		LoadBreakSwitch entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadBreakSwitch with id " + loadBreakSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadBreakSwitch with id " + loadBreakSwitchId );

			throw e;
		}

		try{
			LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().delete( new DeleteLoadBreakSwitchCommand( entity.getLoadBreakSwitchId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadBreakSwitch with id " + loadBreakSwitchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadBreakSwitch with id " + loadBreakSwitchId );

			throw e;
		}
	}

	/**
	 * get all LoadBreakSwitchs.
	 */
	protected List<LoadBreakSwitch> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadBreakSwitchs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadBreakSwitch : " );        
		List<LoadBreakSwitch> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadBreakSwitchBusinessDelegate
			collection = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().getAllLoadBreakSwitch();
			assertNotNull( collection, "An Empty collection of LoadBreakSwitch was incorrectly returned.");
			
			// Now print out the values
			LoadBreakSwitch entity = null;            
			Iterator<LoadBreakSwitch> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadBreakSwitchId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadBreakSwitchTest
	 */
	protected LoadBreakSwitchTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadBreakSwitch
	 * 
	 * @return CreateLoadBreakSwitchCommand alias
	 */
	protected CreateLoadBreakSwitchCommand generateNewCommand() {
        CreateLoadBreakSwitchCommand command = new CreateLoadBreakSwitchCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadBreakSwitch
		 * 
		 * @return UpdateLoadBreakSwitchCommand alias
		 */
	protected UpdateLoadBreakSwitchCommand generateUpdateCommand() {
	        UpdateLoadBreakSwitchCommand command = new UpdateLoadBreakSwitchCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadBreakSwitchId = null;
	protected LoadBreakSwitchSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadBreakSwitchTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadBreakSwitchList = 0;
}
