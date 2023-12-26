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
 * Test TurbineLoadControllerDynamics class.
 *
 * @author your_name_here
 */
public class TurbineLoadControllerDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TurbineLoadControllerDynamicsTest() {
		subscriber = new TurbineLoadControllerDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TurbineLoadControllerDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TurbineLoadControllerDynamics...");
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
	 * jumpstart the process by instantiating2 TurbineLoadControllerDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		turbineLoadControllerDynamicsId = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
		.createTurbineLoadControllerDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
				.createTurbineLoadControllerDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.turbineLoadControllerDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TurbineLoadControllerDynamics : " + successValue.getTurbineLoadControllerDynamicsId());
							  if (successValue.getTurbineLoadControllerDynamicsId().equals(turbineLoadControllerDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTurbineLoadControllerDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TurbineLoadControllerDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineLoadControllerDynamics consumed")
					);
			subscriber.turbineLoadControllerDynamicsSubscribe( turbineLoadControllerDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TurbineLoadControllerDynamics : " + successValue.getTurbineLoadControllerDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTurbineLoadControllerDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineLoadControllerDynamics for turbineLoadControllerDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TurbineLoadControllerDynamics. 
	 */
	protected TurbineLoadControllerDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TurbineLoadControllerDynamics" );

		TurbineLoadControllerDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TurbineLoadControllerDynamics with primary key" );
		msg.append( turbineLoadControllerDynamicsId );
		
		TurbineLoadControllerDynamicsFetchOneSummary fetchOneSummary = new TurbineLoadControllerDynamicsFetchOneSummary( turbineLoadControllerDynamicsId );

		try {
			entity = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().getTurbineLoadControllerDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TurbineLoadControllerDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TurbineLoadControllerDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TurbineLoadControllerDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a TurbineLoadControllerDynamics : " );        
		TurbineLoadControllerDynamics entity = read();
		UpdateTurbineLoadControllerDynamicsCommand command = generateUpdateCommand();
		command.setTurbineLoadControllerDynamicsId(entity.getTurbineLoadControllerDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TurbineLoadControllerDynamics." );

			// for use later on...
			turbineLoadControllerDynamicsId = entity.getTurbineLoadControllerDynamicsId();

			TurbineLoadControllerDynamicsBusinessDelegate proxy = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance();  

			proxy.updateTurbineLoadControllerDynamics( command ).get();

			LOGGER.info( "-- Successfully saved TurbineLoadControllerDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + turbineLoadControllerDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TurbineLoadControllerDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TurbineLoadControllerDynamics." );

		TurbineLoadControllerDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TurbineLoadControllerDynamics with id " + turbineLoadControllerDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TurbineLoadControllerDynamics with id " + turbineLoadControllerDynamicsId );

			throw e;
		}

		try{
			TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().delete( new DeleteTurbineLoadControllerDynamicsCommand( entity.getTurbineLoadControllerDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted TurbineLoadControllerDynamics with id " + turbineLoadControllerDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TurbineLoadControllerDynamics with id " + turbineLoadControllerDynamicsId );

			throw e;
		}
	}

	/**
	 * get all TurbineLoadControllerDynamicss.
	 */
	protected List<TurbineLoadControllerDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TurbineLoadControllerDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TurbineLoadControllerDynamics : " );        
		List<TurbineLoadControllerDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the TurbineLoadControllerDynamicsBusinessDelegate
			collection = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().getAllTurbineLoadControllerDynamics();
			assertNotNull( collection, "An Empty collection of TurbineLoadControllerDynamics was incorrectly returned.");
			
			// Now print out the values
			TurbineLoadControllerDynamics entity = null;            
			Iterator<TurbineLoadControllerDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTurbineLoadControllerDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TurbineLoadControllerDynamicsTest
	 */
	protected TurbineLoadControllerDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TurbineLoadControllerDynamics
	 * 
	 * @return CreateTurbineLoadControllerDynamicsCommand alias
	 */
	protected CreateTurbineLoadControllerDynamicsCommand generateNewCommand() {
        CreateTurbineLoadControllerDynamicsCommand command = new CreateTurbineLoadControllerDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated TurbineLoadControllerDynamics
		 * 
		 * @return UpdateTurbineLoadControllerDynamicsCommand alias
		 */
	protected UpdateTurbineLoadControllerDynamicsCommand generateUpdateCommand() {
	        UpdateTurbineLoadControllerDynamicsCommand command = new UpdateTurbineLoadControllerDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID turbineLoadControllerDynamicsId = null;
	protected TurbineLoadControllerDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TurbineLoadControllerDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTurbineLoadControllerDynamicsList = 0;
}
