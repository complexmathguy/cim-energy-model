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
 * Test Breaker class.
 *
 * @author your_name_here
 */
public class BreakerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BreakerTest() {
		subscriber = new BreakerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BreakerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Breaker...");
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
	 * jumpstart the process by instantiating2 Breaker
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		breakerId = BreakerBusinessDelegate.getBreakerInstance()
		.createBreaker( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BreakerBusinessDelegate.getBreakerInstance()
				.createBreaker( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.breakerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Breaker : " + successValue.getBreakerId());
							  if (successValue.getBreakerId().equals(breakerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBreakerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Breaker test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on breaker consumed")
					);
			subscriber.breakerSubscribe( breakerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Breaker : " + successValue.getBreakerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBreakerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on breaker for breakerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Breaker. 
	 */
	protected Breaker read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Breaker" );

		Breaker entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Breaker with primary key" );
		msg.append( breakerId );
		
		BreakerFetchOneSummary fetchOneSummary = new BreakerFetchOneSummary( breakerId );

		try {
			entity = BreakerBusinessDelegate.getBreakerInstance().getBreaker( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Breaker " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Breaker.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Breaker." );

		StringBuilder msg = new StringBuilder( "Failed to update a Breaker : " );        
		Breaker entity = read();
		UpdateBreakerCommand command = generateUpdateCommand();
		command.setBreakerId(entity.getBreakerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Breaker." );

			// for use later on...
			breakerId = entity.getBreakerId();

			BreakerBusinessDelegate proxy = BreakerBusinessDelegate.getBreakerInstance();  

			proxy.updateBreaker( command ).get();

			LOGGER.info( "-- Successfully saved Breaker - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + breakerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Breaker.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Breaker." );

		Breaker entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Breaker with id " + breakerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Breaker with id " + breakerId );

			throw e;
		}

		try{
			BreakerBusinessDelegate.getBreakerInstance().delete( new DeleteBreakerCommand( entity.getBreakerId() ) ).get();
			LOGGER.info( "-- Successfully deleted Breaker with id " + breakerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Breaker with id " + breakerId );

			throw e;
		}
	}

	/**
	 * get all Breakers.
	 */
	protected List<Breaker> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Breakers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Breaker : " );        
		List<Breaker> collection  = new ArrayList<>();

		try {
			// call the static get method on the BreakerBusinessDelegate
			collection = BreakerBusinessDelegate.getBreakerInstance().getAllBreaker();
			assertNotNull( collection, "An Empty collection of Breaker was incorrectly returned.");
			
			// Now print out the values
			Breaker entity = null;            
			Iterator<Breaker> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBreakerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BreakerTest
	 */
	protected BreakerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Breaker
	 * 
	 * @return CreateBreakerCommand alias
	 */
	protected CreateBreakerCommand generateNewCommand() {
        CreateBreakerCommand command = new CreateBreakerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Breaker
		 * 
		 * @return UpdateBreakerCommand alias
		 */
	protected UpdateBreakerCommand generateUpdateCommand() {
	        UpdateBreakerCommand command = new UpdateBreakerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID breakerId = null;
	protected BreakerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BreakerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBreakerList = 0;
}
