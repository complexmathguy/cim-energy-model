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
 * Test TurbineGovernorDynamics class.
 *
 * @author your_name_here
 */
public class TurbineGovernorDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TurbineGovernorDynamicsTest() {
		subscriber = new TurbineGovernorDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TurbineGovernorDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TurbineGovernorDynamics...");
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
	 * jumpstart the process by instantiating2 TurbineGovernorDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		turbineGovernorDynamicsId = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
		.createTurbineGovernorDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance()
				.createTurbineGovernorDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.turbineGovernorDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TurbineGovernorDynamics : " + successValue.getTurbineGovernorDynamicsId());
							  if (successValue.getTurbineGovernorDynamicsId().equals(turbineGovernorDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTurbineGovernorDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TurbineGovernorDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineGovernorDynamics consumed")
					);
			subscriber.turbineGovernorDynamicsSubscribe( turbineGovernorDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TurbineGovernorDynamics : " + successValue.getTurbineGovernorDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTurbineGovernorDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineGovernorDynamics for turbineGovernorDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TurbineGovernorDynamics. 
	 */
	protected TurbineGovernorDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TurbineGovernorDynamics" );

		TurbineGovernorDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TurbineGovernorDynamics with primary key" );
		msg.append( turbineGovernorDynamicsId );
		
		TurbineGovernorDynamicsFetchOneSummary fetchOneSummary = new TurbineGovernorDynamicsFetchOneSummary( turbineGovernorDynamicsId );

		try {
			entity = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().getTurbineGovernorDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TurbineGovernorDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TurbineGovernorDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TurbineGovernorDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a TurbineGovernorDynamics : " );        
		TurbineGovernorDynamics entity = read();
		UpdateTurbineGovernorDynamicsCommand command = generateUpdateCommand();
		command.setTurbineGovernorDynamicsId(entity.getTurbineGovernorDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TurbineGovernorDynamics." );

			// for use later on...
			turbineGovernorDynamicsId = entity.getTurbineGovernorDynamicsId();

			TurbineGovernorDynamicsBusinessDelegate proxy = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance();  

			proxy.updateTurbineGovernorDynamics( command ).get();

			LOGGER.info( "-- Successfully saved TurbineGovernorDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + turbineGovernorDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TurbineGovernorDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TurbineGovernorDynamics." );

		TurbineGovernorDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TurbineGovernorDynamics with id " + turbineGovernorDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TurbineGovernorDynamics with id " + turbineGovernorDynamicsId );

			throw e;
		}

		try{
			TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().delete( new DeleteTurbineGovernorDynamicsCommand( entity.getTurbineGovernorDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted TurbineGovernorDynamics with id " + turbineGovernorDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TurbineGovernorDynamics with id " + turbineGovernorDynamicsId );

			throw e;
		}
	}

	/**
	 * get all TurbineGovernorDynamicss.
	 */
	protected List<TurbineGovernorDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TurbineGovernorDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TurbineGovernorDynamics : " );        
		List<TurbineGovernorDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the TurbineGovernorDynamicsBusinessDelegate
			collection = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().getAllTurbineGovernorDynamics();
			assertNotNull( collection, "An Empty collection of TurbineGovernorDynamics was incorrectly returned.");
			
			// Now print out the values
			TurbineGovernorDynamics entity = null;            
			Iterator<TurbineGovernorDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTurbineGovernorDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TurbineGovernorDynamicsTest
	 */
	protected TurbineGovernorDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TurbineGovernorDynamics
	 * 
	 * @return CreateTurbineGovernorDynamicsCommand alias
	 */
	protected CreateTurbineGovernorDynamicsCommand generateNewCommand() {
        CreateTurbineGovernorDynamicsCommand command = new CreateTurbineGovernorDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated TurbineGovernorDynamics
		 * 
		 * @return UpdateTurbineGovernorDynamicsCommand alias
		 */
	protected UpdateTurbineGovernorDynamicsCommand generateUpdateCommand() {
	        UpdateTurbineGovernorDynamicsCommand command = new UpdateTurbineGovernorDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID turbineGovernorDynamicsId = null;
	protected TurbineGovernorDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TurbineGovernorDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTurbineGovernorDynamicsList = 0;
}
