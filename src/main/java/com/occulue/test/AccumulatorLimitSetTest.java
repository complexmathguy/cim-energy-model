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
 * Test AccumulatorLimitSet class.
 *
 * @author your_name_here
 */
public class AccumulatorLimitSetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AccumulatorLimitSetTest() {
		subscriber = new AccumulatorLimitSetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AccumulatorLimitSetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AccumulatorLimitSet...");
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
	 * jumpstart the process by instantiating2 AccumulatorLimitSet
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		accumulatorLimitSetId = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
		.createAccumulatorLimitSet( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
				.createAccumulatorLimitSet( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.accumulatorLimitSetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AccumulatorLimitSet : " + successValue.getAccumulatorLimitSetId());
							  if (successValue.getAccumulatorLimitSetId().equals(accumulatorLimitSetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAccumulatorLimitSetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AccumulatorLimitSet test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorLimitSet consumed")
					);
			subscriber.accumulatorLimitSetSubscribe( accumulatorLimitSetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AccumulatorLimitSet : " + successValue.getAccumulatorLimitSetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAccumulatorLimitSetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorLimitSet for accumulatorLimitSetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AccumulatorLimitSet. 
	 */
	protected AccumulatorLimitSet read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AccumulatorLimitSet" );

		AccumulatorLimitSet entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AccumulatorLimitSet with primary key" );
		msg.append( accumulatorLimitSetId );
		
		AccumulatorLimitSetFetchOneSummary fetchOneSummary = new AccumulatorLimitSetFetchOneSummary( accumulatorLimitSetId );

		try {
			entity = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().getAccumulatorLimitSet( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AccumulatorLimitSet " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AccumulatorLimitSet.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AccumulatorLimitSet." );

		StringBuilder msg = new StringBuilder( "Failed to update a AccumulatorLimitSet : " );        
		AccumulatorLimitSet entity = read();
		UpdateAccumulatorLimitSetCommand command = generateUpdateCommand();
		command.setAccumulatorLimitSetId(entity.getAccumulatorLimitSetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AccumulatorLimitSet." );

			// for use later on...
			accumulatorLimitSetId = entity.getAccumulatorLimitSetId();

			AccumulatorLimitSetBusinessDelegate proxy = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance();  

			proxy.updateAccumulatorLimitSet( command ).get();

			LOGGER.info( "-- Successfully saved AccumulatorLimitSet - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + accumulatorLimitSetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AccumulatorLimitSet.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AccumulatorLimitSet." );

		AccumulatorLimitSet entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AccumulatorLimitSet with id " + accumulatorLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AccumulatorLimitSet with id " + accumulatorLimitSetId );

			throw e;
		}

		try{
			AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().delete( new DeleteAccumulatorLimitSetCommand( entity.getAccumulatorLimitSetId() ) ).get();
			LOGGER.info( "-- Successfully deleted AccumulatorLimitSet with id " + accumulatorLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AccumulatorLimitSet with id " + accumulatorLimitSetId );

			throw e;
		}
	}

	/**
	 * get all AccumulatorLimitSets.
	 */
	protected List<AccumulatorLimitSet> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AccumulatorLimitSets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AccumulatorLimitSet : " );        
		List<AccumulatorLimitSet> collection  = new ArrayList<>();

		try {
			// call the static get method on the AccumulatorLimitSetBusinessDelegate
			collection = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().getAllAccumulatorLimitSet();
			assertNotNull( collection, "An Empty collection of AccumulatorLimitSet was incorrectly returned.");
			
			// Now print out the values
			AccumulatorLimitSet entity = null;            
			Iterator<AccumulatorLimitSet> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAccumulatorLimitSetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AccumulatorLimitSetTest
	 */
	protected AccumulatorLimitSetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AccumulatorLimitSet
	 * 
	 * @return CreateAccumulatorLimitSetCommand alias
	 */
	protected CreateAccumulatorLimitSetCommand generateNewCommand() {
        CreateAccumulatorLimitSetCommand command = new CreateAccumulatorLimitSetCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated AccumulatorLimitSet
		 * 
		 * @return UpdateAccumulatorLimitSetCommand alias
		 */
	protected UpdateAccumulatorLimitSetCommand generateUpdateCommand() {
	        UpdateAccumulatorLimitSetCommand command = new UpdateAccumulatorLimitSetCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID accumulatorLimitSetId = null;
	protected AccumulatorLimitSetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AccumulatorLimitSetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAccumulatorLimitSetList = 0;
}
