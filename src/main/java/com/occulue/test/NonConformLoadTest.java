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
 * Test NonConformLoad class.
 *
 * @author your_name_here
 */
public class NonConformLoadTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NonConformLoadTest() {
		subscriber = new NonConformLoadSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NonConformLoadTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NonConformLoad...");
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
	 * jumpstart the process by instantiating2 NonConformLoad
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nonConformLoadId = NonConformLoadBusinessDelegate.getNonConformLoadInstance()
		.createNonConformLoad( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NonConformLoadBusinessDelegate.getNonConformLoadInstance()
				.createNonConformLoad( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nonConformLoadSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NonConformLoad : " + successValue.getNonConformLoadId());
							  if (successValue.getNonConformLoadId().equals(nonConformLoadId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNonConformLoadList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NonConformLoad test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoad consumed")
					);
			subscriber.nonConformLoadSubscribe( nonConformLoadId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NonConformLoad : " + successValue.getNonConformLoadId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNonConformLoadList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonConformLoad for nonConformLoadId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NonConformLoad. 
	 */
	protected NonConformLoad read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NonConformLoad" );

		NonConformLoad entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NonConformLoad with primary key" );
		msg.append( nonConformLoadId );
		
		NonConformLoadFetchOneSummary fetchOneSummary = new NonConformLoadFetchOneSummary( nonConformLoadId );

		try {
			entity = NonConformLoadBusinessDelegate.getNonConformLoadInstance().getNonConformLoad( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NonConformLoad " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NonConformLoad.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NonConformLoad." );

		StringBuilder msg = new StringBuilder( "Failed to update a NonConformLoad : " );        
		NonConformLoad entity = read();
		UpdateNonConformLoadCommand command = generateUpdateCommand();
		command.setNonConformLoadId(entity.getNonConformLoadId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NonConformLoad." );

			// for use later on...
			nonConformLoadId = entity.getNonConformLoadId();

			NonConformLoadBusinessDelegate proxy = NonConformLoadBusinessDelegate.getNonConformLoadInstance();  

			proxy.updateNonConformLoad( command ).get();

			LOGGER.info( "-- Successfully saved NonConformLoad - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nonConformLoadId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NonConformLoad.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NonConformLoad." );

		NonConformLoad entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NonConformLoad with id " + nonConformLoadId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NonConformLoad with id " + nonConformLoadId );

			throw e;
		}

		try{
			NonConformLoadBusinessDelegate.getNonConformLoadInstance().delete( new DeleteNonConformLoadCommand( entity.getNonConformLoadId() ) ).get();
			LOGGER.info( "-- Successfully deleted NonConformLoad with id " + nonConformLoadId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NonConformLoad with id " + nonConformLoadId );

			throw e;
		}
	}

	/**
	 * get all NonConformLoads.
	 */
	protected List<NonConformLoad> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NonConformLoads:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NonConformLoad : " );        
		List<NonConformLoad> collection  = new ArrayList<>();

		try {
			// call the static get method on the NonConformLoadBusinessDelegate
			collection = NonConformLoadBusinessDelegate.getNonConformLoadInstance().getAllNonConformLoad();
			assertNotNull( collection, "An Empty collection of NonConformLoad was incorrectly returned.");
			
			// Now print out the values
			NonConformLoad entity = null;            
			Iterator<NonConformLoad> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNonConformLoadId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NonConformLoadTest
	 */
	protected NonConformLoadTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NonConformLoad
	 * 
	 * @return CreateNonConformLoadCommand alias
	 */
	protected CreateNonConformLoadCommand generateNewCommand() {
        CreateNonConformLoadCommand command = new CreateNonConformLoadCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated NonConformLoad
		 * 
		 * @return UpdateNonConformLoadCommand alias
		 */
	protected UpdateNonConformLoadCommand generateUpdateCommand() {
	        UpdateNonConformLoadCommand command = new UpdateNonConformLoadCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nonConformLoadId = null;
	protected NonConformLoadSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NonConformLoadTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNonConformLoadList = 0;
}
