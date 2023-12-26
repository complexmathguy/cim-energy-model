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
 * Test TieFlow class.
 *
 * @author your_name_here
 */
public class TieFlowTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TieFlowTest() {
		subscriber = new TieFlowSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TieFlowTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TieFlow...");
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
	 * jumpstart the process by instantiating2 TieFlow
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		tieFlowId = TieFlowBusinessDelegate.getTieFlowInstance()
		.createTieFlow( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TieFlowBusinessDelegate.getTieFlowInstance()
				.createTieFlow( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.tieFlowSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TieFlow : " + successValue.getTieFlowId());
							  if (successValue.getTieFlowId().equals(tieFlowId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTieFlowList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TieFlow test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tieFlow consumed")
					);
			subscriber.tieFlowSubscribe( tieFlowId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TieFlow : " + successValue.getTieFlowId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTieFlowList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tieFlow for tieFlowId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TieFlow. 
	 */
	protected TieFlow read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TieFlow" );

		TieFlow entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TieFlow with primary key" );
		msg.append( tieFlowId );
		
		TieFlowFetchOneSummary fetchOneSummary = new TieFlowFetchOneSummary( tieFlowId );

		try {
			entity = TieFlowBusinessDelegate.getTieFlowInstance().getTieFlow( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TieFlow " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TieFlow.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TieFlow." );

		StringBuilder msg = new StringBuilder( "Failed to update a TieFlow : " );        
		TieFlow entity = read();
		UpdateTieFlowCommand command = generateUpdateCommand();
		command.setTieFlowId(entity.getTieFlowId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TieFlow." );

			// for use later on...
			tieFlowId = entity.getTieFlowId();

			TieFlowBusinessDelegate proxy = TieFlowBusinessDelegate.getTieFlowInstance();  

			proxy.updateTieFlow( command ).get();

			LOGGER.info( "-- Successfully saved TieFlow - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + tieFlowId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TieFlow.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TieFlow." );

		TieFlow entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TieFlow with id " + tieFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TieFlow with id " + tieFlowId );

			throw e;
		}

		try{
			TieFlowBusinessDelegate.getTieFlowInstance().delete( new DeleteTieFlowCommand( entity.getTieFlowId() ) ).get();
			LOGGER.info( "-- Successfully deleted TieFlow with id " + tieFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TieFlow with id " + tieFlowId );

			throw e;
		}
	}

	/**
	 * get all TieFlows.
	 */
	protected List<TieFlow> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TieFlows:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TieFlow : " );        
		List<TieFlow> collection  = new ArrayList<>();

		try {
			// call the static get method on the TieFlowBusinessDelegate
			collection = TieFlowBusinessDelegate.getTieFlowInstance().getAllTieFlow();
			assertNotNull( collection, "An Empty collection of TieFlow was incorrectly returned.");
			
			// Now print out the values
			TieFlow entity = null;            
			Iterator<TieFlow> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTieFlowId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TieFlowTest
	 */
	protected TieFlowTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TieFlow
	 * 
	 * @return CreateTieFlowCommand alias
	 */
	protected CreateTieFlowCommand generateNewCommand() {
        CreateTieFlowCommand command = new CreateTieFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TieFlow
		 * 
		 * @return UpdateTieFlowCommand alias
		 */
	protected UpdateTieFlowCommand generateUpdateCommand() {
	        UpdateTieFlowCommand command = new UpdateTieFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID tieFlowId = null;
	protected TieFlowSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TieFlowTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTieFlowList = 0;
}
