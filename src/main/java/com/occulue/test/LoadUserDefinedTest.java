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
 * Test LoadUserDefined class.
 *
 * @author your_name_here
 */
public class LoadUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadUserDefinedTest() {
		subscriber = new LoadUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadUserDefined...");
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
	 * jumpstart the process by instantiating2 LoadUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadUserDefinedId = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance()
		.createLoadUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance()
				.createLoadUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadUserDefined : " + successValue.getLoadUserDefinedId());
							  if (successValue.getLoadUserDefinedId().equals(loadUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadUserDefined consumed")
					);
			subscriber.loadUserDefinedSubscribe( loadUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadUserDefined : " + successValue.getLoadUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadUserDefined for loadUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadUserDefined. 
	 */
	protected LoadUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadUserDefined" );

		LoadUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadUserDefined with primary key" );
		msg.append( loadUserDefinedId );
		
		LoadUserDefinedFetchOneSummary fetchOneSummary = new LoadUserDefinedFetchOneSummary( loadUserDefinedId );

		try {
			entity = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().getLoadUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadUserDefined : " );        
		LoadUserDefined entity = read();
		UpdateLoadUserDefinedCommand command = generateUpdateCommand();
		command.setLoadUserDefinedId(entity.getLoadUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadUserDefined." );

			// for use later on...
			loadUserDefinedId = entity.getLoadUserDefinedId();

			LoadUserDefinedBusinessDelegate proxy = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance();  

			proxy.updateLoadUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved LoadUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadUserDefined." );

		LoadUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadUserDefined with id " + loadUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadUserDefined with id " + loadUserDefinedId );

			throw e;
		}

		try{
			LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().delete( new DeleteLoadUserDefinedCommand( entity.getLoadUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadUserDefined with id " + loadUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadUserDefined with id " + loadUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all LoadUserDefineds.
	 */
	protected List<LoadUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadUserDefined : " );        
		List<LoadUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadUserDefinedBusinessDelegate
			collection = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().getAllLoadUserDefined();
			assertNotNull( collection, "An Empty collection of LoadUserDefined was incorrectly returned.");
			
			// Now print out the values
			LoadUserDefined entity = null;            
			Iterator<LoadUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadUserDefinedTest
	 */
	protected LoadUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadUserDefined
	 * 
	 * @return CreateLoadUserDefinedCommand alias
	 */
	protected CreateLoadUserDefinedCommand generateNewCommand() {
        CreateLoadUserDefinedCommand command = new CreateLoadUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadUserDefined
		 * 
		 * @return UpdateLoadUserDefinedCommand alias
		 */
	protected UpdateLoadUserDefinedCommand generateUpdateCommand() {
	        UpdateLoadUserDefinedCommand command = new UpdateLoadUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadUserDefinedId = null;
	protected LoadUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadUserDefinedList = 0;
}
