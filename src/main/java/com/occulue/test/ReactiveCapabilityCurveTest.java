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
 * Test ReactiveCapabilityCurve class.
 *
 * @author your_name_here
 */
public class ReactiveCapabilityCurveTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ReactiveCapabilityCurveTest() {
		subscriber = new ReactiveCapabilityCurveSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ReactiveCapabilityCurveTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ReactiveCapabilityCurve...");
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
	 * jumpstart the process by instantiating2 ReactiveCapabilityCurve
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		reactiveCapabilityCurveId = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance()
		.createReactiveCapabilityCurve( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance()
				.createReactiveCapabilityCurve( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.reactiveCapabilityCurveSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ReactiveCapabilityCurve : " + successValue.getReactiveCapabilityCurveId());
							  if (successValue.getReactiveCapabilityCurveId().equals(reactiveCapabilityCurveId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfReactiveCapabilityCurveList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ReactiveCapabilityCurve test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactiveCapabilityCurve consumed")
					);
			subscriber.reactiveCapabilityCurveSubscribe( reactiveCapabilityCurveId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ReactiveCapabilityCurve : " + successValue.getReactiveCapabilityCurveId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfReactiveCapabilityCurveList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactiveCapabilityCurve for reactiveCapabilityCurveId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ReactiveCapabilityCurve. 
	 */
	protected ReactiveCapabilityCurve read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ReactiveCapabilityCurve" );

		ReactiveCapabilityCurve entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ReactiveCapabilityCurve with primary key" );
		msg.append( reactiveCapabilityCurveId );
		
		ReactiveCapabilityCurveFetchOneSummary fetchOneSummary = new ReactiveCapabilityCurveFetchOneSummary( reactiveCapabilityCurveId );

		try {
			entity = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().getReactiveCapabilityCurve( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ReactiveCapabilityCurve " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ReactiveCapabilityCurve.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ReactiveCapabilityCurve." );

		StringBuilder msg = new StringBuilder( "Failed to update a ReactiveCapabilityCurve : " );        
		ReactiveCapabilityCurve entity = read();
		UpdateReactiveCapabilityCurveCommand command = generateUpdateCommand();
		command.setReactiveCapabilityCurveId(entity.getReactiveCapabilityCurveId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ReactiveCapabilityCurve." );

			// for use later on...
			reactiveCapabilityCurveId = entity.getReactiveCapabilityCurveId();

			ReactiveCapabilityCurveBusinessDelegate proxy = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance();  

			proxy.updateReactiveCapabilityCurve( command ).get();

			LOGGER.info( "-- Successfully saved ReactiveCapabilityCurve - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + reactiveCapabilityCurveId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ReactiveCapabilityCurve.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ReactiveCapabilityCurve." );

		ReactiveCapabilityCurve entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ReactiveCapabilityCurve with id " + reactiveCapabilityCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ReactiveCapabilityCurve with id " + reactiveCapabilityCurveId );

			throw e;
		}

		try{
			ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().delete( new DeleteReactiveCapabilityCurveCommand( entity.getReactiveCapabilityCurveId() ) ).get();
			LOGGER.info( "-- Successfully deleted ReactiveCapabilityCurve with id " + reactiveCapabilityCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ReactiveCapabilityCurve with id " + reactiveCapabilityCurveId );

			throw e;
		}
	}

	/**
	 * get all ReactiveCapabilityCurves.
	 */
	protected List<ReactiveCapabilityCurve> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ReactiveCapabilityCurves:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ReactiveCapabilityCurve : " );        
		List<ReactiveCapabilityCurve> collection  = new ArrayList<>();

		try {
			// call the static get method on the ReactiveCapabilityCurveBusinessDelegate
			collection = ReactiveCapabilityCurveBusinessDelegate.getReactiveCapabilityCurveInstance().getAllReactiveCapabilityCurve();
			assertNotNull( collection, "An Empty collection of ReactiveCapabilityCurve was incorrectly returned.");
			
			// Now print out the values
			ReactiveCapabilityCurve entity = null;            
			Iterator<ReactiveCapabilityCurve> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getReactiveCapabilityCurveId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ReactiveCapabilityCurveTest
	 */
	protected ReactiveCapabilityCurveTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ReactiveCapabilityCurve
	 * 
	 * @return CreateReactiveCapabilityCurveCommand alias
	 */
	protected CreateReactiveCapabilityCurveCommand generateNewCommand() {
        CreateReactiveCapabilityCurveCommand command = new CreateReactiveCapabilityCurveCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ReactiveCapabilityCurve
		 * 
		 * @return UpdateReactiveCapabilityCurveCommand alias
		 */
	protected UpdateReactiveCapabilityCurveCommand generateUpdateCommand() {
	        UpdateReactiveCapabilityCurveCommand command = new UpdateReactiveCapabilityCurveCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID reactiveCapabilityCurveId = null;
	protected ReactiveCapabilityCurveSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ReactiveCapabilityCurveTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfReactiveCapabilityCurveList = 0;
}
