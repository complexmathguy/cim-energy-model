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
 * Test DCBreaker class.
 *
 * @author your_name_here
 */
public class DCBreakerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCBreakerTest() {
		subscriber = new DCBreakerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCBreakerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCBreaker...");
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
	 * jumpstart the process by instantiating2 DCBreaker
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCBreakerId = DCBreakerBusinessDelegate.getDCBreakerInstance()
		.createDCBreaker( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCBreakerBusinessDelegate.getDCBreakerInstance()
				.createDCBreaker( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCBreakerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCBreaker : " + successValue.getDCBreakerId());
							  if (successValue.getDCBreakerId().equals(dCBreakerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCBreakerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCBreaker test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBreaker consumed")
					);
			subscriber.dCBreakerSubscribe( dCBreakerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCBreaker : " + successValue.getDCBreakerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCBreakerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBreaker for dCBreakerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCBreaker. 
	 */
	protected DCBreaker read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCBreaker" );

		DCBreaker entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCBreaker with primary key" );
		msg.append( dCBreakerId );
		
		DCBreakerFetchOneSummary fetchOneSummary = new DCBreakerFetchOneSummary( dCBreakerId );

		try {
			entity = DCBreakerBusinessDelegate.getDCBreakerInstance().getDCBreaker( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCBreaker " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCBreaker.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCBreaker." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCBreaker : " );        
		DCBreaker entity = read();
		UpdateDCBreakerCommand command = generateUpdateCommand();
		command.setDCBreakerId(entity.getDCBreakerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCBreaker." );

			// for use later on...
			dCBreakerId = entity.getDCBreakerId();

			DCBreakerBusinessDelegate proxy = DCBreakerBusinessDelegate.getDCBreakerInstance();  

			proxy.updateDCBreaker( command ).get();

			LOGGER.info( "-- Successfully saved DCBreaker - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCBreakerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCBreaker.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCBreaker." );

		DCBreaker entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCBreaker with id " + dCBreakerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCBreaker with id " + dCBreakerId );

			throw e;
		}

		try{
			DCBreakerBusinessDelegate.getDCBreakerInstance().delete( new DeleteDCBreakerCommand( entity.getDCBreakerId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCBreaker with id " + dCBreakerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCBreaker with id " + dCBreakerId );

			throw e;
		}
	}

	/**
	 * get all DCBreakers.
	 */
	protected List<DCBreaker> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCBreakers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCBreaker : " );        
		List<DCBreaker> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCBreakerBusinessDelegate
			collection = DCBreakerBusinessDelegate.getDCBreakerInstance().getAllDCBreaker();
			assertNotNull( collection, "An Empty collection of DCBreaker was incorrectly returned.");
			
			// Now print out the values
			DCBreaker entity = null;            
			Iterator<DCBreaker> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCBreakerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCBreakerTest
	 */
	protected DCBreakerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCBreaker
	 * 
	 * @return CreateDCBreakerCommand alias
	 */
	protected CreateDCBreakerCommand generateNewCommand() {
        CreateDCBreakerCommand command = new CreateDCBreakerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCBreaker
		 * 
		 * @return UpdateDCBreakerCommand alias
		 */
	protected UpdateDCBreakerCommand generateUpdateCommand() {
	        UpdateDCBreakerCommand command = new UpdateDCBreakerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCBreakerId = null;
	protected DCBreakerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCBreakerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCBreakerList = 0;
}
