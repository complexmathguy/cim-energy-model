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
 * Test DCTopologicalIsland class.
 *
 * @author your_name_here
 */
public class DCTopologicalIslandTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCTopologicalIslandTest() {
		subscriber = new DCTopologicalIslandSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCTopologicalIslandTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCTopologicalIsland...");
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
	 * jumpstart the process by instantiating2 DCTopologicalIsland
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCTopologicalIslandId = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance()
		.createDCTopologicalIsland( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance()
				.createDCTopologicalIsland( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCTopologicalIslandSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCTopologicalIsland : " + successValue.getDCTopologicalIslandId());
							  if (successValue.getDCTopologicalIslandId().equals(dCTopologicalIslandId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCTopologicalIslandList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCTopologicalIsland test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTopologicalIsland consumed")
					);
			subscriber.dCTopologicalIslandSubscribe( dCTopologicalIslandId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCTopologicalIsland : " + successValue.getDCTopologicalIslandId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCTopologicalIslandList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTopologicalIsland for dCTopologicalIslandId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCTopologicalIsland. 
	 */
	protected DCTopologicalIsland read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCTopologicalIsland" );

		DCTopologicalIsland entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCTopologicalIsland with primary key" );
		msg.append( dCTopologicalIslandId );
		
		DCTopologicalIslandFetchOneSummary fetchOneSummary = new DCTopologicalIslandFetchOneSummary( dCTopologicalIslandId );

		try {
			entity = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().getDCTopologicalIsland( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCTopologicalIsland " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCTopologicalIsland.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCTopologicalIsland." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCTopologicalIsland : " );        
		DCTopologicalIsland entity = read();
		UpdateDCTopologicalIslandCommand command = generateUpdateCommand();
		command.setDCTopologicalIslandId(entity.getDCTopologicalIslandId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCTopologicalIsland." );

			// for use later on...
			dCTopologicalIslandId = entity.getDCTopologicalIslandId();

			DCTopologicalIslandBusinessDelegate proxy = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance();  

			proxy.updateDCTopologicalIsland( command ).get();

			LOGGER.info( "-- Successfully saved DCTopologicalIsland - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCTopologicalIslandId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCTopologicalIsland.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCTopologicalIsland." );

		DCTopologicalIsland entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCTopologicalIsland with id " + dCTopologicalIslandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCTopologicalIsland with id " + dCTopologicalIslandId );

			throw e;
		}

		try{
			DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().delete( new DeleteDCTopologicalIslandCommand( entity.getDCTopologicalIslandId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCTopologicalIsland with id " + dCTopologicalIslandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCTopologicalIsland with id " + dCTopologicalIslandId );

			throw e;
		}
	}

	/**
	 * get all DCTopologicalIslands.
	 */
	protected List<DCTopologicalIsland> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCTopologicalIslands:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCTopologicalIsland : " );        
		List<DCTopologicalIsland> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCTopologicalIslandBusinessDelegate
			collection = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().getAllDCTopologicalIsland();
			assertNotNull( collection, "An Empty collection of DCTopologicalIsland was incorrectly returned.");
			
			// Now print out the values
			DCTopologicalIsland entity = null;            
			Iterator<DCTopologicalIsland> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCTopologicalIslandId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCTopologicalIslandTest
	 */
	protected DCTopologicalIslandTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCTopologicalIsland
	 * 
	 * @return CreateDCTopologicalIslandCommand alias
	 */
	protected CreateDCTopologicalIslandCommand generateNewCommand() {
        CreateDCTopologicalIslandCommand command = new CreateDCTopologicalIslandCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCTopologicalIsland
		 * 
		 * @return UpdateDCTopologicalIslandCommand alias
		 */
	protected UpdateDCTopologicalIslandCommand generateUpdateCommand() {
	        UpdateDCTopologicalIslandCommand command = new UpdateDCTopologicalIslandCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCTopologicalIslandId = null;
	protected DCTopologicalIslandSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCTopologicalIslandTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCTopologicalIslandList = 0;
}
