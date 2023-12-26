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
 * Test AccumulatorValue class.
 *
 * @author your_name_here
 */
public class AccumulatorValueTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AccumulatorValueTest() {
		subscriber = new AccumulatorValueSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AccumulatorValueTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AccumulatorValue...");
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
	 * jumpstart the process by instantiating2 AccumulatorValue
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		accumulatorValueId = AccumulatorValueBusinessDelegate.getAccumulatorValueInstance()
		.createAccumulatorValue( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AccumulatorValueBusinessDelegate.getAccumulatorValueInstance()
				.createAccumulatorValue( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.accumulatorValueSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AccumulatorValue : " + successValue.getAccumulatorValueId());
							  if (successValue.getAccumulatorValueId().equals(accumulatorValueId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAccumulatorValueList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AccumulatorValue test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorValue consumed")
					);
			subscriber.accumulatorValueSubscribe( accumulatorValueId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AccumulatorValue : " + successValue.getAccumulatorValueId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAccumulatorValueList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulatorValue for accumulatorValueId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AccumulatorValue. 
	 */
	protected AccumulatorValue read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AccumulatorValue" );

		AccumulatorValue entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AccumulatorValue with primary key" );
		msg.append( accumulatorValueId );
		
		AccumulatorValueFetchOneSummary fetchOneSummary = new AccumulatorValueFetchOneSummary( accumulatorValueId );

		try {
			entity = AccumulatorValueBusinessDelegate.getAccumulatorValueInstance().getAccumulatorValue( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AccumulatorValue " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AccumulatorValue.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AccumulatorValue." );

		StringBuilder msg = new StringBuilder( "Failed to update a AccumulatorValue : " );        
		AccumulatorValue entity = read();
		UpdateAccumulatorValueCommand command = generateUpdateCommand();
		command.setAccumulatorValueId(entity.getAccumulatorValueId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AccumulatorValue." );

			// for use later on...
			accumulatorValueId = entity.getAccumulatorValueId();

			AccumulatorValueBusinessDelegate proxy = AccumulatorValueBusinessDelegate.getAccumulatorValueInstance();  

			proxy.updateAccumulatorValue( command ).get();

			LOGGER.info( "-- Successfully saved AccumulatorValue - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + accumulatorValueId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AccumulatorValue.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AccumulatorValue." );

		AccumulatorValue entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AccumulatorValue with id " + accumulatorValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AccumulatorValue with id " + accumulatorValueId );

			throw e;
		}

		try{
			AccumulatorValueBusinessDelegate.getAccumulatorValueInstance().delete( new DeleteAccumulatorValueCommand( entity.getAccumulatorValueId() ) ).get();
			LOGGER.info( "-- Successfully deleted AccumulatorValue with id " + accumulatorValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AccumulatorValue with id " + accumulatorValueId );

			throw e;
		}
	}

	/**
	 * get all AccumulatorValues.
	 */
	protected List<AccumulatorValue> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AccumulatorValues:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AccumulatorValue : " );        
		List<AccumulatorValue> collection  = new ArrayList<>();

		try {
			// call the static get method on the AccumulatorValueBusinessDelegate
			collection = AccumulatorValueBusinessDelegate.getAccumulatorValueInstance().getAllAccumulatorValue();
			assertNotNull( collection, "An Empty collection of AccumulatorValue was incorrectly returned.");
			
			// Now print out the values
			AccumulatorValue entity = null;            
			Iterator<AccumulatorValue> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAccumulatorValueId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AccumulatorValueTest
	 */
	protected AccumulatorValueTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AccumulatorValue
	 * 
	 * @return CreateAccumulatorValueCommand alias
	 */
	protected CreateAccumulatorValueCommand generateNewCommand() {
        CreateAccumulatorValueCommand command = new CreateAccumulatorValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AccumulatorValue
		 * 
		 * @return UpdateAccumulatorValueCommand alias
		 */
	protected UpdateAccumulatorValueCommand generateUpdateCommand() {
	        UpdateAccumulatorValueCommand command = new UpdateAccumulatorValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID accumulatorValueId = null;
	protected AccumulatorValueSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AccumulatorValueTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAccumulatorValueList = 0;
}
