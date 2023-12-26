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
 * Test Limit class.
 *
 * @author your_name_here
 */
public class LimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LimitTest() {
		subscriber = new LimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Limit...");
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
	 * jumpstart the process by instantiating2 Limit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		limitId = LimitBusinessDelegate.getLimitInstance()
		.createLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LimitBusinessDelegate.getLimitInstance()
				.createLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.limitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Limit : " + successValue.getLimitId());
							  if (successValue.getLimitId().equals(limitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Limit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on limit consumed")
					);
			subscriber.limitSubscribe( limitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Limit : " + successValue.getLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on limit for limitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Limit. 
	 */
	protected Limit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Limit" );

		Limit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Limit with primary key" );
		msg.append( limitId );
		
		LimitFetchOneSummary fetchOneSummary = new LimitFetchOneSummary( limitId );

		try {
			entity = LimitBusinessDelegate.getLimitInstance().getLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Limit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Limit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Limit." );

		StringBuilder msg = new StringBuilder( "Failed to update a Limit : " );        
		Limit entity = read();
		UpdateLimitCommand command = generateUpdateCommand();
		command.setLimitId(entity.getLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Limit." );

			// for use later on...
			limitId = entity.getLimitId();

			LimitBusinessDelegate proxy = LimitBusinessDelegate.getLimitInstance();  

			proxy.updateLimit( command ).get();

			LOGGER.info( "-- Successfully saved Limit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + limitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Limit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Limit." );

		Limit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Limit with id " + limitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Limit with id " + limitId );

			throw e;
		}

		try{
			LimitBusinessDelegate.getLimitInstance().delete( new DeleteLimitCommand( entity.getLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted Limit with id " + limitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Limit with id " + limitId );

			throw e;
		}
	}

	/**
	 * get all Limits.
	 */
	protected List<Limit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Limits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Limit : " );        
		List<Limit> collection  = new ArrayList<>();

		try {
			// call the static get method on the LimitBusinessDelegate
			collection = LimitBusinessDelegate.getLimitInstance().getAllLimit();
			assertNotNull( collection, "An Empty collection of Limit was incorrectly returned.");
			
			// Now print out the values
			Limit entity = null;            
			Iterator<Limit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LimitTest
	 */
	protected LimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Limit
	 * 
	 * @return CreateLimitCommand alias
	 */
	protected CreateLimitCommand generateNewCommand() {
        CreateLimitCommand command = new CreateLimitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Limit
		 * 
		 * @return UpdateLimitCommand alias
		 */
	protected UpdateLimitCommand generateUpdateCommand() {
	        UpdateLimitCommand command = new UpdateLimitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID limitId = null;
	protected LimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLimitList = 0;
}
