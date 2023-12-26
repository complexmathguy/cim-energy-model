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
 * Test TapChangerTablePoint class.
 *
 * @author your_name_here
 */
public class TapChangerTablePointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TapChangerTablePointTest() {
		subscriber = new TapChangerTablePointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TapChangerTablePointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TapChangerTablePoint...");
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
	 * jumpstart the process by instantiating2 TapChangerTablePoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		tapChangerTablePointId = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance()
		.createTapChangerTablePoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance()
				.createTapChangerTablePoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.tapChangerTablePointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TapChangerTablePoint : " + successValue.getTapChangerTablePointId());
							  if (successValue.getTapChangerTablePointId().equals(tapChangerTablePointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTapChangerTablePointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TapChangerTablePoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChangerTablePoint consumed")
					);
			subscriber.tapChangerTablePointSubscribe( tapChangerTablePointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TapChangerTablePoint : " + successValue.getTapChangerTablePointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTapChangerTablePointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChangerTablePoint for tapChangerTablePointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TapChangerTablePoint. 
	 */
	protected TapChangerTablePoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TapChangerTablePoint" );

		TapChangerTablePoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TapChangerTablePoint with primary key" );
		msg.append( tapChangerTablePointId );
		
		TapChangerTablePointFetchOneSummary fetchOneSummary = new TapChangerTablePointFetchOneSummary( tapChangerTablePointId );

		try {
			entity = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().getTapChangerTablePoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TapChangerTablePoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TapChangerTablePoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TapChangerTablePoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a TapChangerTablePoint : " );        
		TapChangerTablePoint entity = read();
		UpdateTapChangerTablePointCommand command = generateUpdateCommand();
		command.setTapChangerTablePointId(entity.getTapChangerTablePointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TapChangerTablePoint." );

			// for use later on...
			tapChangerTablePointId = entity.getTapChangerTablePointId();

			TapChangerTablePointBusinessDelegate proxy = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();  

			proxy.updateTapChangerTablePoint( command ).get();

			LOGGER.info( "-- Successfully saved TapChangerTablePoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + tapChangerTablePointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TapChangerTablePoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TapChangerTablePoint." );

		TapChangerTablePoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TapChangerTablePoint with id " + tapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TapChangerTablePoint with id " + tapChangerTablePointId );

			throw e;
		}

		try{
			TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().delete( new DeleteTapChangerTablePointCommand( entity.getTapChangerTablePointId() ) ).get();
			LOGGER.info( "-- Successfully deleted TapChangerTablePoint with id " + tapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TapChangerTablePoint with id " + tapChangerTablePointId );

			throw e;
		}
	}

	/**
	 * get all TapChangerTablePoints.
	 */
	protected List<TapChangerTablePoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TapChangerTablePoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TapChangerTablePoint : " );        
		List<TapChangerTablePoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the TapChangerTablePointBusinessDelegate
			collection = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().getAllTapChangerTablePoint();
			assertNotNull( collection, "An Empty collection of TapChangerTablePoint was incorrectly returned.");
			
			// Now print out the values
			TapChangerTablePoint entity = null;            
			Iterator<TapChangerTablePoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTapChangerTablePointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TapChangerTablePointTest
	 */
	protected TapChangerTablePointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TapChangerTablePoint
	 * 
	 * @return CreateTapChangerTablePointCommand alias
	 */
	protected CreateTapChangerTablePointCommand generateNewCommand() {
        CreateTapChangerTablePointCommand command = new CreateTapChangerTablePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TapChangerTablePoint
		 * 
		 * @return UpdateTapChangerTablePointCommand alias
		 */
	protected UpdateTapChangerTablePointCommand generateUpdateCommand() {
	        UpdateTapChangerTablePointCommand command = new UpdateTapChangerTablePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID tapChangerTablePointId = null;
	protected TapChangerTablePointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TapChangerTablePointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTapChangerTablePointList = 0;
}
