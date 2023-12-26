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
 * Test GeographicalRegion class.
 *
 * @author your_name_here
 */
public class GeographicalRegionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GeographicalRegionTest() {
		subscriber = new GeographicalRegionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GeographicalRegionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GeographicalRegion...");
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
	 * jumpstart the process by instantiating2 GeographicalRegion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		geographicalRegionId = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance()
		.createGeographicalRegion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GeographicalRegionBusinessDelegate.getGeographicalRegionInstance()
				.createGeographicalRegion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.geographicalRegionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GeographicalRegion : " + successValue.getGeographicalRegionId());
							  if (successValue.getGeographicalRegionId().equals(geographicalRegionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGeographicalRegionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GeographicalRegion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on geographicalRegion consumed")
					);
			subscriber.geographicalRegionSubscribe( geographicalRegionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GeographicalRegion : " + successValue.getGeographicalRegionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGeographicalRegionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on geographicalRegion for geographicalRegionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GeographicalRegion. 
	 */
	protected GeographicalRegion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GeographicalRegion" );

		GeographicalRegion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GeographicalRegion with primary key" );
		msg.append( geographicalRegionId );
		
		GeographicalRegionFetchOneSummary fetchOneSummary = new GeographicalRegionFetchOneSummary( geographicalRegionId );

		try {
			entity = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().getGeographicalRegion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GeographicalRegion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GeographicalRegion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GeographicalRegion." );

		StringBuilder msg = new StringBuilder( "Failed to update a GeographicalRegion : " );        
		GeographicalRegion entity = read();
		UpdateGeographicalRegionCommand command = generateUpdateCommand();
		command.setGeographicalRegionId(entity.getGeographicalRegionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GeographicalRegion." );

			// for use later on...
			geographicalRegionId = entity.getGeographicalRegionId();

			GeographicalRegionBusinessDelegate proxy = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance();  

			proxy.updateGeographicalRegion( command ).get();

			LOGGER.info( "-- Successfully saved GeographicalRegion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + geographicalRegionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GeographicalRegion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GeographicalRegion." );

		GeographicalRegion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GeographicalRegion with id " + geographicalRegionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GeographicalRegion with id " + geographicalRegionId );

			throw e;
		}

		try{
			GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().delete( new DeleteGeographicalRegionCommand( entity.getGeographicalRegionId() ) ).get();
			LOGGER.info( "-- Successfully deleted GeographicalRegion with id " + geographicalRegionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GeographicalRegion with id " + geographicalRegionId );

			throw e;
		}
	}

	/**
	 * get all GeographicalRegions.
	 */
	protected List<GeographicalRegion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GeographicalRegions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GeographicalRegion : " );        
		List<GeographicalRegion> collection  = new ArrayList<>();

		try {
			// call the static get method on the GeographicalRegionBusinessDelegate
			collection = GeographicalRegionBusinessDelegate.getGeographicalRegionInstance().getAllGeographicalRegion();
			assertNotNull( collection, "An Empty collection of GeographicalRegion was incorrectly returned.");
			
			// Now print out the values
			GeographicalRegion entity = null;            
			Iterator<GeographicalRegion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGeographicalRegionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GeographicalRegionTest
	 */
	protected GeographicalRegionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GeographicalRegion
	 * 
	 * @return CreateGeographicalRegionCommand alias
	 */
	protected CreateGeographicalRegionCommand generateNewCommand() {
        CreateGeographicalRegionCommand command = new CreateGeographicalRegionCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated GeographicalRegion
		 * 
		 * @return UpdateGeographicalRegionCommand alias
		 */
	protected UpdateGeographicalRegionCommand generateUpdateCommand() {
	        UpdateGeographicalRegionCommand command = new UpdateGeographicalRegionCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID geographicalRegionId = null;
	protected GeographicalRegionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GeographicalRegionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGeographicalRegionList = 0;
}
