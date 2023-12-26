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
 * Test StationSupply class.
 *
 * @author your_name_here
 */
public class StationSupplyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StationSupplyTest() {
		subscriber = new StationSupplySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StationSupplyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StationSupply...");
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
	 * jumpstart the process by instantiating2 StationSupply
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		stationSupplyId = StationSupplyBusinessDelegate.getStationSupplyInstance()
		.createStationSupply( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StationSupplyBusinessDelegate.getStationSupplyInstance()
				.createStationSupply( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.stationSupplySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StationSupply : " + successValue.getStationSupplyId());
							  if (successValue.getStationSupplyId().equals(stationSupplyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStationSupplyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StationSupply test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stationSupply consumed")
					);
			subscriber.stationSupplySubscribe( stationSupplyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StationSupply : " + successValue.getStationSupplyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStationSupplyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stationSupply for stationSupplyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StationSupply. 
	 */
	protected StationSupply read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StationSupply" );

		StationSupply entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StationSupply with primary key" );
		msg.append( stationSupplyId );
		
		StationSupplyFetchOneSummary fetchOneSummary = new StationSupplyFetchOneSummary( stationSupplyId );

		try {
			entity = StationSupplyBusinessDelegate.getStationSupplyInstance().getStationSupply( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StationSupply " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StationSupply.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StationSupply." );

		StringBuilder msg = new StringBuilder( "Failed to update a StationSupply : " );        
		StationSupply entity = read();
		UpdateStationSupplyCommand command = generateUpdateCommand();
		command.setStationSupplyId(entity.getStationSupplyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StationSupply." );

			// for use later on...
			stationSupplyId = entity.getStationSupplyId();

			StationSupplyBusinessDelegate proxy = StationSupplyBusinessDelegate.getStationSupplyInstance();  

			proxy.updateStationSupply( command ).get();

			LOGGER.info( "-- Successfully saved StationSupply - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + stationSupplyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StationSupply.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StationSupply." );

		StationSupply entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StationSupply with id " + stationSupplyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StationSupply with id " + stationSupplyId );

			throw e;
		}

		try{
			StationSupplyBusinessDelegate.getStationSupplyInstance().delete( new DeleteStationSupplyCommand( entity.getStationSupplyId() ) ).get();
			LOGGER.info( "-- Successfully deleted StationSupply with id " + stationSupplyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StationSupply with id " + stationSupplyId );

			throw e;
		}
	}

	/**
	 * get all StationSupplys.
	 */
	protected List<StationSupply> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StationSupplys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StationSupply : " );        
		List<StationSupply> collection  = new ArrayList<>();

		try {
			// call the static get method on the StationSupplyBusinessDelegate
			collection = StationSupplyBusinessDelegate.getStationSupplyInstance().getAllStationSupply();
			assertNotNull( collection, "An Empty collection of StationSupply was incorrectly returned.");
			
			// Now print out the values
			StationSupply entity = null;            
			Iterator<StationSupply> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStationSupplyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StationSupplyTest
	 */
	protected StationSupplyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StationSupply
	 * 
	 * @return CreateStationSupplyCommand alias
	 */
	protected CreateStationSupplyCommand generateNewCommand() {
        CreateStationSupplyCommand command = new CreateStationSupplyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated StationSupply
		 * 
		 * @return UpdateStationSupplyCommand alias
		 */
	protected UpdateStationSupplyCommand generateUpdateCommand() {
	        UpdateStationSupplyCommand command = new UpdateStationSupplyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID stationSupplyId = null;
	protected StationSupplySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StationSupplyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStationSupplyList = 0;
}
