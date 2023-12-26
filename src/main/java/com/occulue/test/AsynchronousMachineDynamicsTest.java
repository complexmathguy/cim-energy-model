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
 * Test AsynchronousMachineDynamics class.
 *
 * @author your_name_here
 */
public class AsynchronousMachineDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AsynchronousMachineDynamicsTest() {
		subscriber = new AsynchronousMachineDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AsynchronousMachineDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AsynchronousMachineDynamics...");
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
	 * jumpstart the process by instantiating2 AsynchronousMachineDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		asynchronousMachineDynamicsId = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance()
		.createAsynchronousMachineDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance()
				.createAsynchronousMachineDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.asynchronousMachineDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AsynchronousMachineDynamics : " + successValue.getAsynchronousMachineDynamicsId());
							  if (successValue.getAsynchronousMachineDynamicsId().equals(asynchronousMachineDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAsynchronousMachineDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AsynchronousMachineDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineDynamics consumed")
					);
			subscriber.asynchronousMachineDynamicsSubscribe( asynchronousMachineDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AsynchronousMachineDynamics : " + successValue.getAsynchronousMachineDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAsynchronousMachineDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineDynamics for asynchronousMachineDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AsynchronousMachineDynamics. 
	 */
	protected AsynchronousMachineDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AsynchronousMachineDynamics" );

		AsynchronousMachineDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AsynchronousMachineDynamics with primary key" );
		msg.append( asynchronousMachineDynamicsId );
		
		AsynchronousMachineDynamicsFetchOneSummary fetchOneSummary = new AsynchronousMachineDynamicsFetchOneSummary( asynchronousMachineDynamicsId );

		try {
			entity = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().getAsynchronousMachineDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AsynchronousMachineDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AsynchronousMachineDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AsynchronousMachineDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a AsynchronousMachineDynamics : " );        
		AsynchronousMachineDynamics entity = read();
		UpdateAsynchronousMachineDynamicsCommand command = generateUpdateCommand();
		command.setAsynchronousMachineDynamicsId(entity.getAsynchronousMachineDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AsynchronousMachineDynamics." );

			// for use later on...
			asynchronousMachineDynamicsId = entity.getAsynchronousMachineDynamicsId();

			AsynchronousMachineDynamicsBusinessDelegate proxy = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance();  

			proxy.updateAsynchronousMachineDynamics( command ).get();

			LOGGER.info( "-- Successfully saved AsynchronousMachineDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + asynchronousMachineDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AsynchronousMachineDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AsynchronousMachineDynamics." );

		AsynchronousMachineDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AsynchronousMachineDynamics with id " + asynchronousMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AsynchronousMachineDynamics with id " + asynchronousMachineDynamicsId );

			throw e;
		}

		try{
			AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().delete( new DeleteAsynchronousMachineDynamicsCommand( entity.getAsynchronousMachineDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted AsynchronousMachineDynamics with id " + asynchronousMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AsynchronousMachineDynamics with id " + asynchronousMachineDynamicsId );

			throw e;
		}
	}

	/**
	 * get all AsynchronousMachineDynamicss.
	 */
	protected List<AsynchronousMachineDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AsynchronousMachineDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AsynchronousMachineDynamics : " );        
		List<AsynchronousMachineDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the AsynchronousMachineDynamicsBusinessDelegate
			collection = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().getAllAsynchronousMachineDynamics();
			assertNotNull( collection, "An Empty collection of AsynchronousMachineDynamics was incorrectly returned.");
			
			// Now print out the values
			AsynchronousMachineDynamics entity = null;            
			Iterator<AsynchronousMachineDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAsynchronousMachineDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AsynchronousMachineDynamicsTest
	 */
	protected AsynchronousMachineDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AsynchronousMachineDynamics
	 * 
	 * @return CreateAsynchronousMachineDynamicsCommand alias
	 */
	protected CreateAsynchronousMachineDynamicsCommand generateNewCommand() {
        CreateAsynchronousMachineDynamicsCommand command = new CreateAsynchronousMachineDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated AsynchronousMachineDynamics
		 * 
		 * @return UpdateAsynchronousMachineDynamicsCommand alias
		 */
	protected UpdateAsynchronousMachineDynamicsCommand generateUpdateCommand() {
	        UpdateAsynchronousMachineDynamicsCommand command = new UpdateAsynchronousMachineDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID asynchronousMachineDynamicsId = null;
	protected AsynchronousMachineDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AsynchronousMachineDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAsynchronousMachineDynamicsList = 0;
}
