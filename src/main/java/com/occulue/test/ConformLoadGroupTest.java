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
 * Test ConformLoadGroup class.
 *
 * @author your_name_here
 */
public class ConformLoadGroupTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConformLoadGroupTest() {
		subscriber = new ConformLoadGroupSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConformLoadGroupTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConformLoadGroup...");
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
	 * jumpstart the process by instantiating2 ConformLoadGroup
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conformLoadGroupId = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance()
		.createConformLoadGroup( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance()
				.createConformLoadGroup( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conformLoadGroupSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConformLoadGroup : " + successValue.getConformLoadGroupId());
							  if (successValue.getConformLoadGroupId().equals(conformLoadGroupId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConformLoadGroupList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConformLoadGroup test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoadGroup consumed")
					);
			subscriber.conformLoadGroupSubscribe( conformLoadGroupId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConformLoadGroup : " + successValue.getConformLoadGroupId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConformLoadGroupList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoadGroup for conformLoadGroupId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConformLoadGroup. 
	 */
	protected ConformLoadGroup read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConformLoadGroup" );

		ConformLoadGroup entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConformLoadGroup with primary key" );
		msg.append( conformLoadGroupId );
		
		ConformLoadGroupFetchOneSummary fetchOneSummary = new ConformLoadGroupFetchOneSummary( conformLoadGroupId );

		try {
			entity = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().getConformLoadGroup( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConformLoadGroup " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConformLoadGroup.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConformLoadGroup." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConformLoadGroup : " );        
		ConformLoadGroup entity = read();
		UpdateConformLoadGroupCommand command = generateUpdateCommand();
		command.setConformLoadGroupId(entity.getConformLoadGroupId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConformLoadGroup." );

			// for use later on...
			conformLoadGroupId = entity.getConformLoadGroupId();

			ConformLoadGroupBusinessDelegate proxy = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance();  

			proxy.updateConformLoadGroup( command ).get();

			LOGGER.info( "-- Successfully saved ConformLoadGroup - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conformLoadGroupId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConformLoadGroup.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConformLoadGroup." );

		ConformLoadGroup entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConformLoadGroup with id " + conformLoadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConformLoadGroup with id " + conformLoadGroupId );

			throw e;
		}

		try{
			ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().delete( new DeleteConformLoadGroupCommand( entity.getConformLoadGroupId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConformLoadGroup with id " + conformLoadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConformLoadGroup with id " + conformLoadGroupId );

			throw e;
		}
	}

	/**
	 * get all ConformLoadGroups.
	 */
	protected List<ConformLoadGroup> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConformLoadGroups:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConformLoadGroup : " );        
		List<ConformLoadGroup> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConformLoadGroupBusinessDelegate
			collection = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().getAllConformLoadGroup();
			assertNotNull( collection, "An Empty collection of ConformLoadGroup was incorrectly returned.");
			
			// Now print out the values
			ConformLoadGroup entity = null;            
			Iterator<ConformLoadGroup> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConformLoadGroupId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConformLoadGroupTest
	 */
	protected ConformLoadGroupTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConformLoadGroup
	 * 
	 * @return CreateConformLoadGroupCommand alias
	 */
	protected CreateConformLoadGroupCommand generateNewCommand() {
        CreateConformLoadGroupCommand command = new CreateConformLoadGroupCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ConformLoadGroup
		 * 
		 * @return UpdateConformLoadGroupCommand alias
		 */
	protected UpdateConformLoadGroupCommand generateUpdateCommand() {
	        UpdateConformLoadGroupCommand command = new UpdateConformLoadGroupCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conformLoadGroupId = null;
	protected ConformLoadGroupSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConformLoadGroupTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConformLoadGroupList = 0;
}
