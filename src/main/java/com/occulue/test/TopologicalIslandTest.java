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
 * Test TopologicalIsland class.
 *
 * @author your_name_here
 */
public class TopologicalIslandTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TopologicalIslandTest() {
		subscriber = new TopologicalIslandSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TopologicalIslandTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TopologicalIsland...");
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
	 * jumpstart the process by instantiating2 TopologicalIsland
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		topologicalIslandId = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
		.createTopologicalIsland( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
				.createTopologicalIsland( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.topologicalIslandSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TopologicalIsland : " + successValue.getTopologicalIslandId());
							  if (successValue.getTopologicalIslandId().equals(topologicalIslandId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTopologicalIslandList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TopologicalIsland test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologicalIsland consumed")
					);
			subscriber.topologicalIslandSubscribe( topologicalIslandId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TopologicalIsland : " + successValue.getTopologicalIslandId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTopologicalIslandList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologicalIsland for topologicalIslandId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TopologicalIsland. 
	 */
	protected TopologicalIsland read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TopologicalIsland" );

		TopologicalIsland entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TopologicalIsland with primary key" );
		msg.append( topologicalIslandId );
		
		TopologicalIslandFetchOneSummary fetchOneSummary = new TopologicalIslandFetchOneSummary( topologicalIslandId );

		try {
			entity = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().getTopologicalIsland( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TopologicalIsland " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TopologicalIsland.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TopologicalIsland." );

		StringBuilder msg = new StringBuilder( "Failed to update a TopologicalIsland : " );        
		TopologicalIsland entity = read();
		UpdateTopologicalIslandCommand command = generateUpdateCommand();
		command.setTopologicalIslandId(entity.getTopologicalIslandId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TopologicalIsland." );

			// for use later on...
			topologicalIslandId = entity.getTopologicalIslandId();

			TopologicalIslandBusinessDelegate proxy = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();  

			proxy.updateTopologicalIsland( command ).get();

			LOGGER.info( "-- Successfully saved TopologicalIsland - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + topologicalIslandId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TopologicalIsland.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TopologicalIsland." );

		TopologicalIsland entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TopologicalIsland with id " + topologicalIslandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TopologicalIsland with id " + topologicalIslandId );

			throw e;
		}

		try{
			TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().delete( new DeleteTopologicalIslandCommand( entity.getTopologicalIslandId() ) ).get();
			LOGGER.info( "-- Successfully deleted TopologicalIsland with id " + topologicalIslandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TopologicalIsland with id " + topologicalIslandId );

			throw e;
		}
	}

	/**
	 * get all TopologicalIslands.
	 */
	protected List<TopologicalIsland> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TopologicalIslands:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TopologicalIsland : " );        
		List<TopologicalIsland> collection  = new ArrayList<>();

		try {
			// call the static get method on the TopologicalIslandBusinessDelegate
			collection = TopologicalIslandBusinessDelegate.getTopologicalIslandInstance().getAllTopologicalIsland();
			assertNotNull( collection, "An Empty collection of TopologicalIsland was incorrectly returned.");
			
			// Now print out the values
			TopologicalIsland entity = null;            
			Iterator<TopologicalIsland> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTopologicalIslandId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TopologicalIslandTest
	 */
	protected TopologicalIslandTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TopologicalIsland
	 * 
	 * @return CreateTopologicalIslandCommand alias
	 */
	protected CreateTopologicalIslandCommand generateNewCommand() {
        CreateTopologicalIslandCommand command = new CreateTopologicalIslandCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated TopologicalIsland
		 * 
		 * @return UpdateTopologicalIslandCommand alias
		 */
	protected UpdateTopologicalIslandCommand generateUpdateCommand() {
	        UpdateTopologicalIslandCommand command = new UpdateTopologicalIslandCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID topologicalIslandId = null;
	protected TopologicalIslandSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TopologicalIslandTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTopologicalIslandList = 0;
}
