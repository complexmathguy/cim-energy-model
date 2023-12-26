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
 * Test AnalogLimit class.
 *
 * @author your_name_here
 */
public class AnalogLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AnalogLimitTest() {
		subscriber = new AnalogLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AnalogLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AnalogLimit...");
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
	 * jumpstart the process by instantiating2 AnalogLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		analogLimitId = AnalogLimitBusinessDelegate.getAnalogLimitInstance()
		.createAnalogLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AnalogLimitBusinessDelegate.getAnalogLimitInstance()
				.createAnalogLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.analogLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AnalogLimit : " + successValue.getAnalogLimitId());
							  if (successValue.getAnalogLimitId().equals(analogLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAnalogLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AnalogLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogLimit consumed")
					);
			subscriber.analogLimitSubscribe( analogLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AnalogLimit : " + successValue.getAnalogLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAnalogLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogLimit for analogLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AnalogLimit. 
	 */
	protected AnalogLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AnalogLimit" );

		AnalogLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AnalogLimit with primary key" );
		msg.append( analogLimitId );
		
		AnalogLimitFetchOneSummary fetchOneSummary = new AnalogLimitFetchOneSummary( analogLimitId );

		try {
			entity = AnalogLimitBusinessDelegate.getAnalogLimitInstance().getAnalogLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AnalogLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AnalogLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AnalogLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a AnalogLimit : " );        
		AnalogLimit entity = read();
		UpdateAnalogLimitCommand command = generateUpdateCommand();
		command.setAnalogLimitId(entity.getAnalogLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AnalogLimit." );

			// for use later on...
			analogLimitId = entity.getAnalogLimitId();

			AnalogLimitBusinessDelegate proxy = AnalogLimitBusinessDelegate.getAnalogLimitInstance();  

			proxy.updateAnalogLimit( command ).get();

			LOGGER.info( "-- Successfully saved AnalogLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + analogLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AnalogLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AnalogLimit." );

		AnalogLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AnalogLimit with id " + analogLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AnalogLimit with id " + analogLimitId );

			throw e;
		}

		try{
			AnalogLimitBusinessDelegate.getAnalogLimitInstance().delete( new DeleteAnalogLimitCommand( entity.getAnalogLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted AnalogLimit with id " + analogLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AnalogLimit with id " + analogLimitId );

			throw e;
		}
	}

	/**
	 * get all AnalogLimits.
	 */
	protected List<AnalogLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AnalogLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AnalogLimit : " );        
		List<AnalogLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the AnalogLimitBusinessDelegate
			collection = AnalogLimitBusinessDelegate.getAnalogLimitInstance().getAllAnalogLimit();
			assertNotNull( collection, "An Empty collection of AnalogLimit was incorrectly returned.");
			
			// Now print out the values
			AnalogLimit entity = null;            
			Iterator<AnalogLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAnalogLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AnalogLimitTest
	 */
	protected AnalogLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AnalogLimit
	 * 
	 * @return CreateAnalogLimitCommand alias
	 */
	protected CreateAnalogLimitCommand generateNewCommand() {
        CreateAnalogLimitCommand command = new CreateAnalogLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AnalogLimit
		 * 
		 * @return UpdateAnalogLimitCommand alias
		 */
	protected UpdateAnalogLimitCommand generateUpdateCommand() {
	        UpdateAnalogLimitCommand command = new UpdateAnalogLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID analogLimitId = null;
	protected AnalogLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AnalogLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAnalogLimitList = 0;
}
