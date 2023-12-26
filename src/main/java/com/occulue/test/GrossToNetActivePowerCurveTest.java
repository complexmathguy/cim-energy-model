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
 * Test GrossToNetActivePowerCurve class.
 *
 * @author your_name_here
 */
public class GrossToNetActivePowerCurveTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GrossToNetActivePowerCurveTest() {
		subscriber = new GrossToNetActivePowerCurveSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GrossToNetActivePowerCurveTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GrossToNetActivePowerCurve...");
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
	 * jumpstart the process by instantiating2 GrossToNetActivePowerCurve
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		grossToNetActivePowerCurveId = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance()
		.createGrossToNetActivePowerCurve( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance()
				.createGrossToNetActivePowerCurve( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.grossToNetActivePowerCurveSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GrossToNetActivePowerCurve : " + successValue.getGrossToNetActivePowerCurveId());
							  if (successValue.getGrossToNetActivePowerCurveId().equals(grossToNetActivePowerCurveId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGrossToNetActivePowerCurveList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GrossToNetActivePowerCurve test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on grossToNetActivePowerCurve consumed")
					);
			subscriber.grossToNetActivePowerCurveSubscribe( grossToNetActivePowerCurveId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GrossToNetActivePowerCurve : " + successValue.getGrossToNetActivePowerCurveId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGrossToNetActivePowerCurveList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on grossToNetActivePowerCurve for grossToNetActivePowerCurveId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GrossToNetActivePowerCurve. 
	 */
	protected GrossToNetActivePowerCurve read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GrossToNetActivePowerCurve" );

		GrossToNetActivePowerCurve entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GrossToNetActivePowerCurve with primary key" );
		msg.append( grossToNetActivePowerCurveId );
		
		GrossToNetActivePowerCurveFetchOneSummary fetchOneSummary = new GrossToNetActivePowerCurveFetchOneSummary( grossToNetActivePowerCurveId );

		try {
			entity = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().getGrossToNetActivePowerCurve( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GrossToNetActivePowerCurve " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GrossToNetActivePowerCurve.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GrossToNetActivePowerCurve." );

		StringBuilder msg = new StringBuilder( "Failed to update a GrossToNetActivePowerCurve : " );        
		GrossToNetActivePowerCurve entity = read();
		UpdateGrossToNetActivePowerCurveCommand command = generateUpdateCommand();
		command.setGrossToNetActivePowerCurveId(entity.getGrossToNetActivePowerCurveId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GrossToNetActivePowerCurve." );

			// for use later on...
			grossToNetActivePowerCurveId = entity.getGrossToNetActivePowerCurveId();

			GrossToNetActivePowerCurveBusinessDelegate proxy = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance();  

			proxy.updateGrossToNetActivePowerCurve( command ).get();

			LOGGER.info( "-- Successfully saved GrossToNetActivePowerCurve - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + grossToNetActivePowerCurveId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GrossToNetActivePowerCurve.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GrossToNetActivePowerCurve." );

		GrossToNetActivePowerCurve entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GrossToNetActivePowerCurve with id " + grossToNetActivePowerCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GrossToNetActivePowerCurve with id " + grossToNetActivePowerCurveId );

			throw e;
		}

		try{
			GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().delete( new DeleteGrossToNetActivePowerCurveCommand( entity.getGrossToNetActivePowerCurveId() ) ).get();
			LOGGER.info( "-- Successfully deleted GrossToNetActivePowerCurve with id " + grossToNetActivePowerCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GrossToNetActivePowerCurve with id " + grossToNetActivePowerCurveId );

			throw e;
		}
	}

	/**
	 * get all GrossToNetActivePowerCurves.
	 */
	protected List<GrossToNetActivePowerCurve> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GrossToNetActivePowerCurves:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GrossToNetActivePowerCurve : " );        
		List<GrossToNetActivePowerCurve> collection  = new ArrayList<>();

		try {
			// call the static get method on the GrossToNetActivePowerCurveBusinessDelegate
			collection = GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance().getAllGrossToNetActivePowerCurve();
			assertNotNull( collection, "An Empty collection of GrossToNetActivePowerCurve was incorrectly returned.");
			
			// Now print out the values
			GrossToNetActivePowerCurve entity = null;            
			Iterator<GrossToNetActivePowerCurve> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGrossToNetActivePowerCurveId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GrossToNetActivePowerCurveTest
	 */
	protected GrossToNetActivePowerCurveTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GrossToNetActivePowerCurve
	 * 
	 * @return CreateGrossToNetActivePowerCurveCommand alias
	 */
	protected CreateGrossToNetActivePowerCurveCommand generateNewCommand() {
        CreateGrossToNetActivePowerCurveCommand command = new CreateGrossToNetActivePowerCurveCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated GrossToNetActivePowerCurve
		 * 
		 * @return UpdateGrossToNetActivePowerCurveCommand alias
		 */
	protected UpdateGrossToNetActivePowerCurveCommand generateUpdateCommand() {
	        UpdateGrossToNetActivePowerCurveCommand command = new UpdateGrossToNetActivePowerCurveCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID grossToNetActivePowerCurveId = null;
	protected GrossToNetActivePowerCurveSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GrossToNetActivePowerCurveTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGrossToNetActivePowerCurveList = 0;
}
