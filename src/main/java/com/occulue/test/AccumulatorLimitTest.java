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
 * Test AccumulatorLimit class.
 *
 * @author your_name_here
 */
public class AccumulatorLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AccumulatorLimitTest() {
		subscriber = new AccumulatorLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AccumulatorLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AccumulatorLimit...");
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
	 * jumpstart the process by instantiating2 AccumulatorLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		accumulatorLimitId = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance()
		.createAccumulatorLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance()
				.createAccumulatorLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.accumulatorLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AccumulatorLimit : " + successValue.getAccumulatorLimitId());
							  if (successValue.getAccumulatorLimitId().equals(accumulatorLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAccumulatorLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AccumulatorLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorLimit consumed")
					);
			subscriber.accumulatorLimitSubscribe( accumulatorLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AccumulatorLimit : " + successValue.getAccumulatorLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAccumulatorLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorLimit for accumulatorLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AccumulatorLimit. 
	 */
	protected AccumulatorLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AccumulatorLimit" );

		AccumulatorLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AccumulatorLimit with primary key" );
		msg.append( accumulatorLimitId );
		
		AccumulatorLimitFetchOneSummary fetchOneSummary = new AccumulatorLimitFetchOneSummary( accumulatorLimitId );

		try {
			entity = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance().getAccumulatorLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AccumulatorLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AccumulatorLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AccumulatorLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a AccumulatorLimit : " );        
		AccumulatorLimit entity = read();
		UpdateAccumulatorLimitCommand command = generateUpdateCommand();
		command.setAccumulatorLimitId(entity.getAccumulatorLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AccumulatorLimit." );

			// for use later on...
			accumulatorLimitId = entity.getAccumulatorLimitId();

			AccumulatorLimitBusinessDelegate proxy = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();  

			proxy.updateAccumulatorLimit( command ).get();

			LOGGER.info( "-- Successfully saved AccumulatorLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + accumulatorLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AccumulatorLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AccumulatorLimit." );

		AccumulatorLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AccumulatorLimit with id " + accumulatorLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AccumulatorLimit with id " + accumulatorLimitId );

			throw e;
		}

		try{
			AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance().delete( new DeleteAccumulatorLimitCommand( entity.getAccumulatorLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted AccumulatorLimit with id " + accumulatorLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AccumulatorLimit with id " + accumulatorLimitId );

			throw e;
		}
	}

	/**
	 * get all AccumulatorLimits.
	 */
	protected List<AccumulatorLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AccumulatorLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AccumulatorLimit : " );        
		List<AccumulatorLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the AccumulatorLimitBusinessDelegate
			collection = AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance().getAllAccumulatorLimit();
			assertNotNull( collection, "An Empty collection of AccumulatorLimit was incorrectly returned.");
			
			// Now print out the values
			AccumulatorLimit entity = null;            
			Iterator<AccumulatorLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAccumulatorLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AccumulatorLimitTest
	 */
	protected AccumulatorLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AccumulatorLimit
	 * 
	 * @return CreateAccumulatorLimitCommand alias
	 */
	protected CreateAccumulatorLimitCommand generateNewCommand() {
        CreateAccumulatorLimitCommand command = new CreateAccumulatorLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AccumulatorLimit
		 * 
		 * @return UpdateAccumulatorLimitCommand alias
		 */
	protected UpdateAccumulatorLimitCommand generateUpdateCommand() {
	        UpdateAccumulatorLimitCommand command = new UpdateAccumulatorLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID accumulatorLimitId = null;
	protected AccumulatorLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AccumulatorLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAccumulatorLimitList = 0;
}
