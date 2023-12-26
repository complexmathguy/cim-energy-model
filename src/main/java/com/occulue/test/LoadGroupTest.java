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
 * Test LoadGroup class.
 *
 * @author your_name_here
 */
public class LoadGroupTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadGroupTest() {
		subscriber = new LoadGroupSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadGroupTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadGroup...");
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
	 * jumpstart the process by instantiating2 LoadGroup
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadGroupId = LoadGroupBusinessDelegate.getLoadGroupInstance()
		.createLoadGroup( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadGroupBusinessDelegate.getLoadGroupInstance()
				.createLoadGroup( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadGroupSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadGroup : " + successValue.getLoadGroupId());
							  if (successValue.getLoadGroupId().equals(loadGroupId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadGroupList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadGroup test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadGroup consumed")
					);
			subscriber.loadGroupSubscribe( loadGroupId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadGroup : " + successValue.getLoadGroupId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadGroupList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadGroup for loadGroupId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadGroup. 
	 */
	protected LoadGroup read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadGroup" );

		LoadGroup entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadGroup with primary key" );
		msg.append( loadGroupId );
		
		LoadGroupFetchOneSummary fetchOneSummary = new LoadGroupFetchOneSummary( loadGroupId );

		try {
			entity = LoadGroupBusinessDelegate.getLoadGroupInstance().getLoadGroup( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadGroup " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadGroup.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadGroup." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadGroup : " );        
		LoadGroup entity = read();
		UpdateLoadGroupCommand command = generateUpdateCommand();
		command.setLoadGroupId(entity.getLoadGroupId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadGroup." );

			// for use later on...
			loadGroupId = entity.getLoadGroupId();

			LoadGroupBusinessDelegate proxy = LoadGroupBusinessDelegate.getLoadGroupInstance();  

			proxy.updateLoadGroup( command ).get();

			LOGGER.info( "-- Successfully saved LoadGroup - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadGroupId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadGroup.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadGroup." );

		LoadGroup entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadGroup with id " + loadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadGroup with id " + loadGroupId );

			throw e;
		}

		try{
			LoadGroupBusinessDelegate.getLoadGroupInstance().delete( new DeleteLoadGroupCommand( entity.getLoadGroupId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadGroup with id " + loadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadGroup with id " + loadGroupId );

			throw e;
		}
	}

	/**
	 * get all LoadGroups.
	 */
	protected List<LoadGroup> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadGroups:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadGroup : " );        
		List<LoadGroup> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadGroupBusinessDelegate
			collection = LoadGroupBusinessDelegate.getLoadGroupInstance().getAllLoadGroup();
			assertNotNull( collection, "An Empty collection of LoadGroup was incorrectly returned.");
			
			// Now print out the values
			LoadGroup entity = null;            
			Iterator<LoadGroup> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadGroupId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadGroupTest
	 */
	protected LoadGroupTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadGroup
	 * 
	 * @return CreateLoadGroupCommand alias
	 */
	protected CreateLoadGroupCommand generateNewCommand() {
        CreateLoadGroupCommand command = new CreateLoadGroupCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadGroup
		 * 
		 * @return UpdateLoadGroupCommand alias
		 */
	protected UpdateLoadGroupCommand generateUpdateCommand() {
	        UpdateLoadGroupCommand command = new UpdateLoadGroupCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadGroupId = null;
	protected LoadGroupSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadGroupTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadGroupList = 0;
}
