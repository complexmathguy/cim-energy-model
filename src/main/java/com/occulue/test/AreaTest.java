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
 * Test Area class.
 *
 * @author your_name_here
 */
public class AreaTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AreaTest() {
		subscriber = new AreaSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AreaTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Area...");
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
	 * jumpstart the process by instantiating2 Area
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		areaId = AreaBusinessDelegate.getAreaInstance()
		.createArea( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AreaBusinessDelegate.getAreaInstance()
				.createArea( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.areaSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Area : " + successValue.getAreaId());
							  if (successValue.getAreaId().equals(areaId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAreaList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Area test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on area consumed")
					);
			subscriber.areaSubscribe( areaId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Area : " + successValue.getAreaId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAreaList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on area for areaId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Area. 
	 */
	protected Area read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Area" );

		Area entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Area with primary key" );
		msg.append( areaId );
		
		AreaFetchOneSummary fetchOneSummary = new AreaFetchOneSummary( areaId );

		try {
			entity = AreaBusinessDelegate.getAreaInstance().getArea( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Area " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Area.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Area." );

		StringBuilder msg = new StringBuilder( "Failed to update a Area : " );        
		Area entity = read();
		UpdateAreaCommand command = generateUpdateCommand();
		command.setAreaId(entity.getAreaId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Area." );

			// for use later on...
			areaId = entity.getAreaId();

			AreaBusinessDelegate proxy = AreaBusinessDelegate.getAreaInstance();  

			proxy.updateArea( command ).get();

			LOGGER.info( "-- Successfully saved Area - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + areaId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Area.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Area." );

		Area entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Area with id " + areaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Area with id " + areaId );

			throw e;
		}

		try{
			AreaBusinessDelegate.getAreaInstance().delete( new DeleteAreaCommand( entity.getAreaId() ) ).get();
			LOGGER.info( "-- Successfully deleted Area with id " + areaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Area with id " + areaId );

			throw e;
		}
	}

	/**
	 * get all Areas.
	 */
	protected List<Area> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Areas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Area : " );        
		List<Area> collection  = new ArrayList<>();

		try {
			// call the static get method on the AreaBusinessDelegate
			collection = AreaBusinessDelegate.getAreaInstance().getAllArea();
			assertNotNull( collection, "An Empty collection of Area was incorrectly returned.");
			
			// Now print out the values
			Area entity = null;            
			Iterator<Area> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAreaId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AreaTest
	 */
	protected AreaTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Area
	 * 
	 * @return CreateAreaCommand alias
	 */
	protected CreateAreaCommand generateNewCommand() {
        CreateAreaCommand command = new CreateAreaCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Area
		 * 
		 * @return UpdateAreaCommand alias
		 */
	protected UpdateAreaCommand generateUpdateCommand() {
	        UpdateAreaCommand command = new UpdateAreaCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID areaId = null;
	protected AreaSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AreaTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAreaList = 0;
}
