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
 * Test NonConformLoadGroup class.
 *
 * @author your_name_here
 */
public class NonConformLoadGroupTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NonConformLoadGroupTest() {
		subscriber = new NonConformLoadGroupSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NonConformLoadGroupTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NonConformLoadGroup...");
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
	 * jumpstart the process by instantiating2 NonConformLoadGroup
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nonConformLoadGroupId = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance()
		.createNonConformLoadGroup( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance()
				.createNonConformLoadGroup( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nonConformLoadGroupSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NonConformLoadGroup : " + successValue.getNonConformLoadGroupId());
							  if (successValue.getNonConformLoadGroupId().equals(nonConformLoadGroupId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNonConformLoadGroupList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NonConformLoadGroup test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoadGroup consumed")
					);
			subscriber.nonConformLoadGroupSubscribe( nonConformLoadGroupId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NonConformLoadGroup : " + successValue.getNonConformLoadGroupId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNonConformLoadGroupList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoadGroup for nonConformLoadGroupId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NonConformLoadGroup. 
	 */
	protected NonConformLoadGroup read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NonConformLoadGroup" );

		NonConformLoadGroup entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NonConformLoadGroup with primary key" );
		msg.append( nonConformLoadGroupId );
		
		NonConformLoadGroupFetchOneSummary fetchOneSummary = new NonConformLoadGroupFetchOneSummary( nonConformLoadGroupId );

		try {
			entity = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().getNonConformLoadGroup( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NonConformLoadGroup " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NonConformLoadGroup.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NonConformLoadGroup." );

		StringBuilder msg = new StringBuilder( "Failed to update a NonConformLoadGroup : " );        
		NonConformLoadGroup entity = read();
		UpdateNonConformLoadGroupCommand command = generateUpdateCommand();
		command.setNonConformLoadGroupId(entity.getNonConformLoadGroupId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NonConformLoadGroup." );

			// for use later on...
			nonConformLoadGroupId = entity.getNonConformLoadGroupId();

			NonConformLoadGroupBusinessDelegate proxy = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance();  

			proxy.updateNonConformLoadGroup( command ).get();

			LOGGER.info( "-- Successfully saved NonConformLoadGroup - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nonConformLoadGroupId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NonConformLoadGroup.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NonConformLoadGroup." );

		NonConformLoadGroup entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NonConformLoadGroup with id " + nonConformLoadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NonConformLoadGroup with id " + nonConformLoadGroupId );

			throw e;
		}

		try{
			NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().delete( new DeleteNonConformLoadGroupCommand( entity.getNonConformLoadGroupId() ) ).get();
			LOGGER.info( "-- Successfully deleted NonConformLoadGroup with id " + nonConformLoadGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NonConformLoadGroup with id " + nonConformLoadGroupId );

			throw e;
		}
	}

	/**
	 * get all NonConformLoadGroups.
	 */
	protected List<NonConformLoadGroup> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NonConformLoadGroups:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NonConformLoadGroup : " );        
		List<NonConformLoadGroup> collection  = new ArrayList<>();

		try {
			// call the static get method on the NonConformLoadGroupBusinessDelegate
			collection = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().getAllNonConformLoadGroup();
			assertNotNull( collection, "An Empty collection of NonConformLoadGroup was incorrectly returned.");
			
			// Now print out the values
			NonConformLoadGroup entity = null;            
			Iterator<NonConformLoadGroup> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNonConformLoadGroupId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NonConformLoadGroupTest
	 */
	protected NonConformLoadGroupTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NonConformLoadGroup
	 * 
	 * @return CreateNonConformLoadGroupCommand alias
	 */
	protected CreateNonConformLoadGroupCommand generateNewCommand() {
        CreateNonConformLoadGroupCommand command = new CreateNonConformLoadGroupCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated NonConformLoadGroup
		 * 
		 * @return UpdateNonConformLoadGroupCommand alias
		 */
	protected UpdateNonConformLoadGroupCommand generateUpdateCommand() {
	        UpdateNonConformLoadGroupCommand command = new UpdateNonConformLoadGroupCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nonConformLoadGroupId = null;
	protected NonConformLoadGroupSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NonConformLoadGroupTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNonConformLoadGroupList = 0;
}
