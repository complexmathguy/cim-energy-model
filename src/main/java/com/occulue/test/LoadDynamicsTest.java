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
 * Test LoadDynamics class.
 *
 * @author your_name_here
 */
public class LoadDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadDynamicsTest() {
		subscriber = new LoadDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadDynamics...");
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
	 * jumpstart the process by instantiating2 LoadDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadDynamicsId = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance()
		.createLoadDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadDynamicsBusinessDelegate.getLoadDynamicsInstance()
				.createLoadDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadDynamics : " + successValue.getLoadDynamicsId());
							  if (successValue.getLoadDynamicsId().equals(loadDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadDynamics consumed")
					);
			subscriber.loadDynamicsSubscribe( loadDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadDynamics : " + successValue.getLoadDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadDynamics for loadDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadDynamics. 
	 */
	protected LoadDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadDynamics" );

		LoadDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadDynamics with primary key" );
		msg.append( loadDynamicsId );
		
		LoadDynamicsFetchOneSummary fetchOneSummary = new LoadDynamicsFetchOneSummary( loadDynamicsId );

		try {
			entity = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance().getLoadDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadDynamics : " );        
		LoadDynamics entity = read();
		UpdateLoadDynamicsCommand command = generateUpdateCommand();
		command.setLoadDynamicsId(entity.getLoadDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadDynamics." );

			// for use later on...
			loadDynamicsId = entity.getLoadDynamicsId();

			LoadDynamicsBusinessDelegate proxy = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance();  

			proxy.updateLoadDynamics( command ).get();

			LOGGER.info( "-- Successfully saved LoadDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadDynamics." );

		LoadDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadDynamics with id " + loadDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadDynamics with id " + loadDynamicsId );

			throw e;
		}

		try{
			LoadDynamicsBusinessDelegate.getLoadDynamicsInstance().delete( new DeleteLoadDynamicsCommand( entity.getLoadDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadDynamics with id " + loadDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadDynamics with id " + loadDynamicsId );

			throw e;
		}
	}

	/**
	 * get all LoadDynamicss.
	 */
	protected List<LoadDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadDynamics : " );        
		List<LoadDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadDynamicsBusinessDelegate
			collection = LoadDynamicsBusinessDelegate.getLoadDynamicsInstance().getAllLoadDynamics();
			assertNotNull( collection, "An Empty collection of LoadDynamics was incorrectly returned.");
			
			// Now print out the values
			LoadDynamics entity = null;            
			Iterator<LoadDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadDynamicsTest
	 */
	protected LoadDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadDynamics
	 * 
	 * @return CreateLoadDynamicsCommand alias
	 */
	protected CreateLoadDynamicsCommand generateNewCommand() {
        CreateLoadDynamicsCommand command = new CreateLoadDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadDynamics
		 * 
		 * @return UpdateLoadDynamicsCommand alias
		 */
	protected UpdateLoadDynamicsCommand generateUpdateCommand() {
	        UpdateLoadDynamicsCommand command = new UpdateLoadDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadDynamicsId = null;
	protected LoadDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadDynamicsList = 0;
}
