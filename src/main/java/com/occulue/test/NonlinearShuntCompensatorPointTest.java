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
 * Test NonlinearShuntCompensatorPoint class.
 *
 * @author your_name_here
 */
public class NonlinearShuntCompensatorPointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NonlinearShuntCompensatorPointTest() {
		subscriber = new NonlinearShuntCompensatorPointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NonlinearShuntCompensatorPointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NonlinearShuntCompensatorPoint...");
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
	 * jumpstart the process by instantiating2 NonlinearShuntCompensatorPoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nonlinearShuntCompensatorPointId = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
		.createNonlinearShuntCompensatorPoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
				.createNonlinearShuntCompensatorPoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nonlinearShuntCompensatorPointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NonlinearShuntCompensatorPoint : " + successValue.getNonlinearShuntCompensatorPointId());
							  if (successValue.getNonlinearShuntCompensatorPointId().equals(nonlinearShuntCompensatorPointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNonlinearShuntCompensatorPointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NonlinearShuntCompensatorPoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonlinearShuntCompensatorPoint consumed")
					);
			subscriber.nonlinearShuntCompensatorPointSubscribe( nonlinearShuntCompensatorPointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NonlinearShuntCompensatorPoint : " + successValue.getNonlinearShuntCompensatorPointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNonlinearShuntCompensatorPointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonlinearShuntCompensatorPoint for nonlinearShuntCompensatorPointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NonlinearShuntCompensatorPoint. 
	 */
	protected NonlinearShuntCompensatorPoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NonlinearShuntCompensatorPoint" );

		NonlinearShuntCompensatorPoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NonlinearShuntCompensatorPoint with primary key" );
		msg.append( nonlinearShuntCompensatorPointId );
		
		NonlinearShuntCompensatorPointFetchOneSummary fetchOneSummary = new NonlinearShuntCompensatorPointFetchOneSummary( nonlinearShuntCompensatorPointId );

		try {
			entity = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().getNonlinearShuntCompensatorPoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NonlinearShuntCompensatorPoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NonlinearShuntCompensatorPoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NonlinearShuntCompensatorPoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a NonlinearShuntCompensatorPoint : " );        
		NonlinearShuntCompensatorPoint entity = read();
		UpdateNonlinearShuntCompensatorPointCommand command = generateUpdateCommand();
		command.setNonlinearShuntCompensatorPointId(entity.getNonlinearShuntCompensatorPointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NonlinearShuntCompensatorPoint." );

			// for use later on...
			nonlinearShuntCompensatorPointId = entity.getNonlinearShuntCompensatorPointId();

			NonlinearShuntCompensatorPointBusinessDelegate proxy = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance();  

			proxy.updateNonlinearShuntCompensatorPoint( command ).get();

			LOGGER.info( "-- Successfully saved NonlinearShuntCompensatorPoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nonlinearShuntCompensatorPointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NonlinearShuntCompensatorPoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NonlinearShuntCompensatorPoint." );

		NonlinearShuntCompensatorPoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NonlinearShuntCompensatorPoint with id " + nonlinearShuntCompensatorPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NonlinearShuntCompensatorPoint with id " + nonlinearShuntCompensatorPointId );

			throw e;
		}

		try{
			NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().delete( new DeleteNonlinearShuntCompensatorPointCommand( entity.getNonlinearShuntCompensatorPointId() ) ).get();
			LOGGER.info( "-- Successfully deleted NonlinearShuntCompensatorPoint with id " + nonlinearShuntCompensatorPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NonlinearShuntCompensatorPoint with id " + nonlinearShuntCompensatorPointId );

			throw e;
		}
	}

	/**
	 * get all NonlinearShuntCompensatorPoints.
	 */
	protected List<NonlinearShuntCompensatorPoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NonlinearShuntCompensatorPoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NonlinearShuntCompensatorPoint : " );        
		List<NonlinearShuntCompensatorPoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the NonlinearShuntCompensatorPointBusinessDelegate
			collection = NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance().getAllNonlinearShuntCompensatorPoint();
			assertNotNull( collection, "An Empty collection of NonlinearShuntCompensatorPoint was incorrectly returned.");
			
			// Now print out the values
			NonlinearShuntCompensatorPoint entity = null;            
			Iterator<NonlinearShuntCompensatorPoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNonlinearShuntCompensatorPointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NonlinearShuntCompensatorPointTest
	 */
	protected NonlinearShuntCompensatorPointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NonlinearShuntCompensatorPoint
	 * 
	 * @return CreateNonlinearShuntCompensatorPointCommand alias
	 */
	protected CreateNonlinearShuntCompensatorPointCommand generateNewCommand() {
        CreateNonlinearShuntCompensatorPointCommand command = new CreateNonlinearShuntCompensatorPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated NonlinearShuntCompensatorPoint
		 * 
		 * @return UpdateNonlinearShuntCompensatorPointCommand alias
		 */
	protected UpdateNonlinearShuntCompensatorPointCommand generateUpdateCommand() {
	        UpdateNonlinearShuntCompensatorPointCommand command = new UpdateNonlinearShuntCompensatorPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nonlinearShuntCompensatorPointId = null;
	protected NonlinearShuntCompensatorPointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NonlinearShuntCompensatorPointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNonlinearShuntCompensatorPointList = 0;
}
