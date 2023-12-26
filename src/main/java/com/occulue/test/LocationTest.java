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
 * Test Location class.
 *
 * @author your_name_here
 */
public class LocationTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LocationTest() {
		subscriber = new LocationSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LocationTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Location...");
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
	 * jumpstart the process by instantiating2 Location
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		locationId = LocationBusinessDelegate.getLocationInstance()
		.createLocation( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LocationBusinessDelegate.getLocationInstance()
				.createLocation( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.locationSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Location : " + successValue.getLocationId());
							  if (successValue.getLocationId().equals(locationId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLocationList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Location test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on location consumed")
					);
			subscriber.locationSubscribe( locationId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Location : " + successValue.getLocationId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLocationList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on location for locationId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Location. 
	 */
	protected Location read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Location" );

		Location entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Location with primary key" );
		msg.append( locationId );
		
		LocationFetchOneSummary fetchOneSummary = new LocationFetchOneSummary( locationId );

		try {
			entity = LocationBusinessDelegate.getLocationInstance().getLocation( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Location " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Location.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Location." );

		StringBuilder msg = new StringBuilder( "Failed to update a Location : " );        
		Location entity = read();
		UpdateLocationCommand command = generateUpdateCommand();
		command.setLocationId(entity.getLocationId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Location." );

			// for use later on...
			locationId = entity.getLocationId();

			LocationBusinessDelegate proxy = LocationBusinessDelegate.getLocationInstance();  

			proxy.updateLocation( command ).get();

			LOGGER.info( "-- Successfully saved Location - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + locationId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Location.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Location." );

		Location entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Location with id " + locationId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Location with id " + locationId );

			throw e;
		}

		try{
			LocationBusinessDelegate.getLocationInstance().delete( new DeleteLocationCommand( entity.getLocationId() ) ).get();
			LOGGER.info( "-- Successfully deleted Location with id " + locationId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Location with id " + locationId );

			throw e;
		}
	}

	/**
	 * get all Locations.
	 */
	protected List<Location> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Locations:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Location : " );        
		List<Location> collection  = new ArrayList<>();

		try {
			// call the static get method on the LocationBusinessDelegate
			collection = LocationBusinessDelegate.getLocationInstance().getAllLocation();
			assertNotNull( collection, "An Empty collection of Location was incorrectly returned.");
			
			// Now print out the values
			Location entity = null;            
			Iterator<Location> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLocationId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LocationTest
	 */
	protected LocationTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Location
	 * 
	 * @return CreateLocationCommand alias
	 */
	protected CreateLocationCommand generateNewCommand() {
        CreateLocationCommand command = new CreateLocationCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Location
		 * 
		 * @return UpdateLocationCommand alias
		 */
	protected UpdateLocationCommand generateUpdateCommand() {
	        UpdateLocationCommand command = new UpdateLocationCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID locationId = null;
	protected LocationSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LocationTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLocationList = 0;
}
