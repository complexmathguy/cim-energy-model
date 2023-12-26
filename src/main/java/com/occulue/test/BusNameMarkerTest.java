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
 * Test BusNameMarker class.
 *
 * @author your_name_here
 */
public class BusNameMarkerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BusNameMarkerTest() {
		subscriber = new BusNameMarkerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BusNameMarkerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BusNameMarker...");
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
	 * jumpstart the process by instantiating2 BusNameMarker
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		busNameMarkerId = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance()
		.createBusNameMarker( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BusNameMarkerBusinessDelegate.getBusNameMarkerInstance()
				.createBusNameMarker( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.busNameMarkerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BusNameMarker : " + successValue.getBusNameMarkerId());
							  if (successValue.getBusNameMarkerId().equals(busNameMarkerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBusNameMarkerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BusNameMarker test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on busNameMarker consumed")
					);
			subscriber.busNameMarkerSubscribe( busNameMarkerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BusNameMarker : " + successValue.getBusNameMarkerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBusNameMarkerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on busNameMarker for busNameMarkerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BusNameMarker. 
	 */
	protected BusNameMarker read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BusNameMarker" );

		BusNameMarker entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BusNameMarker with primary key" );
		msg.append( busNameMarkerId );
		
		BusNameMarkerFetchOneSummary fetchOneSummary = new BusNameMarkerFetchOneSummary( busNameMarkerId );

		try {
			entity = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance().getBusNameMarker( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BusNameMarker " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BusNameMarker.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BusNameMarker." );

		StringBuilder msg = new StringBuilder( "Failed to update a BusNameMarker : " );        
		BusNameMarker entity = read();
		UpdateBusNameMarkerCommand command = generateUpdateCommand();
		command.setBusNameMarkerId(entity.getBusNameMarkerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BusNameMarker." );

			// for use later on...
			busNameMarkerId = entity.getBusNameMarkerId();

			BusNameMarkerBusinessDelegate proxy = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance();  

			proxy.updateBusNameMarker( command ).get();

			LOGGER.info( "-- Successfully saved BusNameMarker - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + busNameMarkerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BusNameMarker.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BusNameMarker." );

		BusNameMarker entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BusNameMarker with id " + busNameMarkerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BusNameMarker with id " + busNameMarkerId );

			throw e;
		}

		try{
			BusNameMarkerBusinessDelegate.getBusNameMarkerInstance().delete( new DeleteBusNameMarkerCommand( entity.getBusNameMarkerId() ) ).get();
			LOGGER.info( "-- Successfully deleted BusNameMarker with id " + busNameMarkerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BusNameMarker with id " + busNameMarkerId );

			throw e;
		}
	}

	/**
	 * get all BusNameMarkers.
	 */
	protected List<BusNameMarker> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BusNameMarkers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BusNameMarker : " );        
		List<BusNameMarker> collection  = new ArrayList<>();

		try {
			// call the static get method on the BusNameMarkerBusinessDelegate
			collection = BusNameMarkerBusinessDelegate.getBusNameMarkerInstance().getAllBusNameMarker();
			assertNotNull( collection, "An Empty collection of BusNameMarker was incorrectly returned.");
			
			// Now print out the values
			BusNameMarker entity = null;            
			Iterator<BusNameMarker> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBusNameMarkerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BusNameMarkerTest
	 */
	protected BusNameMarkerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BusNameMarker
	 * 
	 * @return CreateBusNameMarkerCommand alias
	 */
	protected CreateBusNameMarkerCommand generateNewCommand() {
        CreateBusNameMarkerCommand command = new CreateBusNameMarkerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated BusNameMarker
		 * 
		 * @return UpdateBusNameMarkerCommand alias
		 */
	protected UpdateBusNameMarkerCommand generateUpdateCommand() {
	        UpdateBusNameMarkerCommand command = new UpdateBusNameMarkerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID busNameMarkerId = null;
	protected BusNameMarkerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BusNameMarkerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBusNameMarkerList = 0;
}
