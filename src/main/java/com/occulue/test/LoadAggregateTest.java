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
 * Test LoadAggregate class.
 *
 * @author your_name_here
 */
public class LoadAggregateTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadAggregateTest() {
		subscriber = new LoadAggregateSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadAggregateTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadAggregate...");
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
	 * jumpstart the process by instantiating2 LoadAggregate
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadAggregateId = LoadAggregateBusinessDelegate.getLoadAggregateInstance()
		.createLoadAggregate( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadAggregateBusinessDelegate.getLoadAggregateInstance()
				.createLoadAggregate( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadAggregateSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadAggregate : " + successValue.getLoadAggregateId());
							  if (successValue.getLoadAggregateId().equals(loadAggregateId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadAggregateList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadAggregate test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadAggregate consumed")
					);
			subscriber.loadAggregateSubscribe( loadAggregateId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadAggregate : " + successValue.getLoadAggregateId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadAggregateList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadAggregate for loadAggregateId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadAggregate. 
	 */
	protected LoadAggregate read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadAggregate" );

		LoadAggregate entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadAggregate with primary key" );
		msg.append( loadAggregateId );
		
		LoadAggregateFetchOneSummary fetchOneSummary = new LoadAggregateFetchOneSummary( loadAggregateId );

		try {
			entity = LoadAggregateBusinessDelegate.getLoadAggregateInstance().getLoadAggregate( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadAggregate " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadAggregate.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadAggregate." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadAggregate : " );        
		LoadAggregate entity = read();
		UpdateLoadAggregateCommand command = generateUpdateCommand();
		command.setLoadAggregateId(entity.getLoadAggregateId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadAggregate." );

			// for use later on...
			loadAggregateId = entity.getLoadAggregateId();

			LoadAggregateBusinessDelegate proxy = LoadAggregateBusinessDelegate.getLoadAggregateInstance();  

			proxy.updateLoadAggregate( command ).get();

			LOGGER.info( "-- Successfully saved LoadAggregate - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadAggregateId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadAggregate.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadAggregate." );

		LoadAggregate entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadAggregate with id " + loadAggregateId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadAggregate with id " + loadAggregateId );

			throw e;
		}

		try{
			LoadAggregateBusinessDelegate.getLoadAggregateInstance().delete( new DeleteLoadAggregateCommand( entity.getLoadAggregateId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadAggregate with id " + loadAggregateId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadAggregate with id " + loadAggregateId );

			throw e;
		}
	}

	/**
	 * get all LoadAggregates.
	 */
	protected List<LoadAggregate> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadAggregates:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadAggregate : " );        
		List<LoadAggregate> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadAggregateBusinessDelegate
			collection = LoadAggregateBusinessDelegate.getLoadAggregateInstance().getAllLoadAggregate();
			assertNotNull( collection, "An Empty collection of LoadAggregate was incorrectly returned.");
			
			// Now print out the values
			LoadAggregate entity = null;            
			Iterator<LoadAggregate> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadAggregateId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadAggregateTest
	 */
	protected LoadAggregateTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadAggregate
	 * 
	 * @return CreateLoadAggregateCommand alias
	 */
	protected CreateLoadAggregateCommand generateNewCommand() {
        CreateLoadAggregateCommand command = new CreateLoadAggregateCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadAggregate
		 * 
		 * @return UpdateLoadAggregateCommand alias
		 */
	protected UpdateLoadAggregateCommand generateUpdateCommand() {
	        UpdateLoadAggregateCommand command = new UpdateLoadAggregateCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadAggregateId = null;
	protected LoadAggregateSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadAggregateTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadAggregateList = 0;
}
