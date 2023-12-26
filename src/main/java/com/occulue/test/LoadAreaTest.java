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
 * Test LoadArea class.
 *
 * @author your_name_here
 */
public class LoadAreaTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadAreaTest() {
		subscriber = new LoadAreaSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadAreaTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadArea...");
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
	 * jumpstart the process by instantiating2 LoadArea
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadAreaId = LoadAreaBusinessDelegate.getLoadAreaInstance()
		.createLoadArea( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadAreaBusinessDelegate.getLoadAreaInstance()
				.createLoadArea( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadAreaSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadArea : " + successValue.getLoadAreaId());
							  if (successValue.getLoadAreaId().equals(loadAreaId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadAreaList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadArea test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadArea consumed")
					);
			subscriber.loadAreaSubscribe( loadAreaId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadArea : " + successValue.getLoadAreaId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadAreaList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadArea for loadAreaId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadArea. 
	 */
	protected LoadArea read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadArea" );

		LoadArea entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadArea with primary key" );
		msg.append( loadAreaId );
		
		LoadAreaFetchOneSummary fetchOneSummary = new LoadAreaFetchOneSummary( loadAreaId );

		try {
			entity = LoadAreaBusinessDelegate.getLoadAreaInstance().getLoadArea( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadArea " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadArea.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadArea." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadArea : " );        
		LoadArea entity = read();
		UpdateLoadAreaCommand command = generateUpdateCommand();
		command.setLoadAreaId(entity.getLoadAreaId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadArea." );

			// for use later on...
			loadAreaId = entity.getLoadAreaId();

			LoadAreaBusinessDelegate proxy = LoadAreaBusinessDelegate.getLoadAreaInstance();  

			proxy.updateLoadArea( command ).get();

			LOGGER.info( "-- Successfully saved LoadArea - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadAreaId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadArea.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadArea." );

		LoadArea entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadArea with id " + loadAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadArea with id " + loadAreaId );

			throw e;
		}

		try{
			LoadAreaBusinessDelegate.getLoadAreaInstance().delete( new DeleteLoadAreaCommand( entity.getLoadAreaId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadArea with id " + loadAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadArea with id " + loadAreaId );

			throw e;
		}
	}

	/**
	 * get all LoadAreas.
	 */
	protected List<LoadArea> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadAreas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadArea : " );        
		List<LoadArea> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadAreaBusinessDelegate
			collection = LoadAreaBusinessDelegate.getLoadAreaInstance().getAllLoadArea();
			assertNotNull( collection, "An Empty collection of LoadArea was incorrectly returned.");
			
			// Now print out the values
			LoadArea entity = null;            
			Iterator<LoadArea> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadAreaId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadAreaTest
	 */
	protected LoadAreaTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadArea
	 * 
	 * @return CreateLoadAreaCommand alias
	 */
	protected CreateLoadAreaCommand generateNewCommand() {
        CreateLoadAreaCommand command = new CreateLoadAreaCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadArea
		 * 
		 * @return UpdateLoadAreaCommand alias
		 */
	protected UpdateLoadAreaCommand generateUpdateCommand() {
	        UpdateLoadAreaCommand command = new UpdateLoadAreaCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadAreaId = null;
	protected LoadAreaSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadAreaTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadAreaList = 0;
}
