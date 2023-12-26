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
 * Test AccumulatorReset class.
 *
 * @author your_name_here
 */
public class AccumulatorResetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AccumulatorResetTest() {
		subscriber = new AccumulatorResetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AccumulatorResetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AccumulatorReset...");
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
	 * jumpstart the process by instantiating2 AccumulatorReset
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		accumulatorResetId = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance()
		.createAccumulatorReset( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AccumulatorResetBusinessDelegate.getAccumulatorResetInstance()
				.createAccumulatorReset( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.accumulatorResetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AccumulatorReset : " + successValue.getAccumulatorResetId());
							  if (successValue.getAccumulatorResetId().equals(accumulatorResetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAccumulatorResetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AccumulatorReset test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorReset consumed")
					);
			subscriber.accumulatorResetSubscribe( accumulatorResetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AccumulatorReset : " + successValue.getAccumulatorResetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAccumulatorResetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorReset for accumulatorResetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AccumulatorReset. 
	 */
	protected AccumulatorReset read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AccumulatorReset" );

		AccumulatorReset entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AccumulatorReset with primary key" );
		msg.append( accumulatorResetId );
		
		AccumulatorResetFetchOneSummary fetchOneSummary = new AccumulatorResetFetchOneSummary( accumulatorResetId );

		try {
			entity = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().getAccumulatorReset( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AccumulatorReset " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AccumulatorReset.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AccumulatorReset." );

		StringBuilder msg = new StringBuilder( "Failed to update a AccumulatorReset : " );        
		AccumulatorReset entity = read();
		UpdateAccumulatorResetCommand command = generateUpdateCommand();
		command.setAccumulatorResetId(entity.getAccumulatorResetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AccumulatorReset." );

			// for use later on...
			accumulatorResetId = entity.getAccumulatorResetId();

			AccumulatorResetBusinessDelegate proxy = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance();  

			proxy.updateAccumulatorReset( command ).get();

			LOGGER.info( "-- Successfully saved AccumulatorReset - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + accumulatorResetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AccumulatorReset.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AccumulatorReset." );

		AccumulatorReset entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AccumulatorReset with id " + accumulatorResetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AccumulatorReset with id " + accumulatorResetId );

			throw e;
		}

		try{
			AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().delete( new DeleteAccumulatorResetCommand( entity.getAccumulatorResetId() ) ).get();
			LOGGER.info( "-- Successfully deleted AccumulatorReset with id " + accumulatorResetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AccumulatorReset with id " + accumulatorResetId );

			throw e;
		}
	}

	/**
	 * get all AccumulatorResets.
	 */
	protected List<AccumulatorReset> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AccumulatorResets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AccumulatorReset : " );        
		List<AccumulatorReset> collection  = new ArrayList<>();

		try {
			// call the static get method on the AccumulatorResetBusinessDelegate
			collection = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().getAllAccumulatorReset();
			assertNotNull( collection, "An Empty collection of AccumulatorReset was incorrectly returned.");
			
			// Now print out the values
			AccumulatorReset entity = null;            
			Iterator<AccumulatorReset> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAccumulatorResetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AccumulatorResetTest
	 */
	protected AccumulatorResetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AccumulatorReset
	 * 
	 * @return CreateAccumulatorResetCommand alias
	 */
	protected CreateAccumulatorResetCommand generateNewCommand() {
        CreateAccumulatorResetCommand command = new CreateAccumulatorResetCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated AccumulatorReset
		 * 
		 * @return UpdateAccumulatorResetCommand alias
		 */
	protected UpdateAccumulatorResetCommand generateUpdateCommand() {
	        UpdateAccumulatorResetCommand command = new UpdateAccumulatorResetCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID accumulatorResetId = null;
	protected AccumulatorResetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AccumulatorResetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAccumulatorResetList = 0;
}
