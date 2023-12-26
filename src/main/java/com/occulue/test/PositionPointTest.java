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
 * Test PositionPoint class.
 *
 * @author your_name_here
 */
public class PositionPointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PositionPointTest() {
		subscriber = new PositionPointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PositionPointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PositionPoint...");
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
	 * jumpstart the process by instantiating2 PositionPoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		positionPointId = PositionPointBusinessDelegate.getPositionPointInstance()
		.createPositionPoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PositionPointBusinessDelegate.getPositionPointInstance()
				.createPositionPoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.positionPointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PositionPoint : " + successValue.getPositionPointId());
							  if (successValue.getPositionPointId().equals(positionPointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPositionPointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PositionPoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on positionPoint consumed")
					);
			subscriber.positionPointSubscribe( positionPointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PositionPoint : " + successValue.getPositionPointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPositionPointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on positionPoint for positionPointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PositionPoint. 
	 */
	protected PositionPoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PositionPoint" );

		PositionPoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PositionPoint with primary key" );
		msg.append( positionPointId );
		
		PositionPointFetchOneSummary fetchOneSummary = new PositionPointFetchOneSummary( positionPointId );

		try {
			entity = PositionPointBusinessDelegate.getPositionPointInstance().getPositionPoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PositionPoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PositionPoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PositionPoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a PositionPoint : " );        
		PositionPoint entity = read();
		UpdatePositionPointCommand command = generateUpdateCommand();
		command.setPositionPointId(entity.getPositionPointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PositionPoint." );

			// for use later on...
			positionPointId = entity.getPositionPointId();

			PositionPointBusinessDelegate proxy = PositionPointBusinessDelegate.getPositionPointInstance();  

			proxy.updatePositionPoint( command ).get();

			LOGGER.info( "-- Successfully saved PositionPoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + positionPointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PositionPoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PositionPoint." );

		PositionPoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PositionPoint with id " + positionPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PositionPoint with id " + positionPointId );

			throw e;
		}

		try{
			PositionPointBusinessDelegate.getPositionPointInstance().delete( new DeletePositionPointCommand( entity.getPositionPointId() ) ).get();
			LOGGER.info( "-- Successfully deleted PositionPoint with id " + positionPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PositionPoint with id " + positionPointId );

			throw e;
		}
	}

	/**
	 * get all PositionPoints.
	 */
	protected List<PositionPoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PositionPoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PositionPoint : " );        
		List<PositionPoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the PositionPointBusinessDelegate
			collection = PositionPointBusinessDelegate.getPositionPointInstance().getAllPositionPoint();
			assertNotNull( collection, "An Empty collection of PositionPoint was incorrectly returned.");
			
			// Now print out the values
			PositionPoint entity = null;            
			Iterator<PositionPoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPositionPointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PositionPointTest
	 */
	protected PositionPointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PositionPoint
	 * 
	 * @return CreatePositionPointCommand alias
	 */
	protected CreatePositionPointCommand generateNewCommand() {
        CreatePositionPointCommand command = new CreatePositionPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PositionPoint
		 * 
		 * @return UpdatePositionPointCommand alias
		 */
	protected UpdatePositionPointCommand generateUpdateCommand() {
	        UpdatePositionPointCommand command = new UpdatePositionPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID positionPointId = null;
	protected PositionPointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PositionPointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPositionPointList = 0;
}
