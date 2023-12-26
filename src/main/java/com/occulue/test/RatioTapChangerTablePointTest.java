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
 * Test RatioTapChangerTablePoint class.
 *
 * @author your_name_here
 */
public class RatioTapChangerTablePointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RatioTapChangerTablePointTest() {
		subscriber = new RatioTapChangerTablePointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RatioTapChangerTablePointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RatioTapChangerTablePoint...");
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
	 * jumpstart the process by instantiating2 RatioTapChangerTablePoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		ratioTapChangerTablePointId = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
		.createRatioTapChangerTablePoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
				.createRatioTapChangerTablePoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.ratioTapChangerTablePointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RatioTapChangerTablePoint : " + successValue.getRatioTapChangerTablePointId());
							  if (successValue.getRatioTapChangerTablePointId().equals(ratioTapChangerTablePointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRatioTapChangerTablePointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RatioTapChangerTablePoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChangerTablePoint consumed")
					);
			subscriber.ratioTapChangerTablePointSubscribe( ratioTapChangerTablePointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RatioTapChangerTablePoint : " + successValue.getRatioTapChangerTablePointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRatioTapChangerTablePointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChangerTablePoint for ratioTapChangerTablePointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RatioTapChangerTablePoint. 
	 */
	protected RatioTapChangerTablePoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RatioTapChangerTablePoint" );

		RatioTapChangerTablePoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RatioTapChangerTablePoint with primary key" );
		msg.append( ratioTapChangerTablePointId );
		
		RatioTapChangerTablePointFetchOneSummary fetchOneSummary = new RatioTapChangerTablePointFetchOneSummary( ratioTapChangerTablePointId );

		try {
			entity = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().getRatioTapChangerTablePoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RatioTapChangerTablePoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RatioTapChangerTablePoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RatioTapChangerTablePoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a RatioTapChangerTablePoint : " );        
		RatioTapChangerTablePoint entity = read();
		UpdateRatioTapChangerTablePointCommand command = generateUpdateCommand();
		command.setRatioTapChangerTablePointId(entity.getRatioTapChangerTablePointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RatioTapChangerTablePoint." );

			// for use later on...
			ratioTapChangerTablePointId = entity.getRatioTapChangerTablePointId();

			RatioTapChangerTablePointBusinessDelegate proxy = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance();  

			proxy.updateRatioTapChangerTablePoint( command ).get();

			LOGGER.info( "-- Successfully saved RatioTapChangerTablePoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + ratioTapChangerTablePointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RatioTapChangerTablePoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RatioTapChangerTablePoint." );

		RatioTapChangerTablePoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RatioTapChangerTablePoint with id " + ratioTapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RatioTapChangerTablePoint with id " + ratioTapChangerTablePointId );

			throw e;
		}

		try{
			RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().delete( new DeleteRatioTapChangerTablePointCommand( entity.getRatioTapChangerTablePointId() ) ).get();
			LOGGER.info( "-- Successfully deleted RatioTapChangerTablePoint with id " + ratioTapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RatioTapChangerTablePoint with id " + ratioTapChangerTablePointId );

			throw e;
		}
	}

	/**
	 * get all RatioTapChangerTablePoints.
	 */
	protected List<RatioTapChangerTablePoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RatioTapChangerTablePoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RatioTapChangerTablePoint : " );        
		List<RatioTapChangerTablePoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the RatioTapChangerTablePointBusinessDelegate
			collection = RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance().getAllRatioTapChangerTablePoint();
			assertNotNull( collection, "An Empty collection of RatioTapChangerTablePoint was incorrectly returned.");
			
			// Now print out the values
			RatioTapChangerTablePoint entity = null;            
			Iterator<RatioTapChangerTablePoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRatioTapChangerTablePointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RatioTapChangerTablePointTest
	 */
	protected RatioTapChangerTablePointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RatioTapChangerTablePoint
	 * 
	 * @return CreateRatioTapChangerTablePointCommand alias
	 */
	protected CreateRatioTapChangerTablePointCommand generateNewCommand() {
        CreateRatioTapChangerTablePointCommand command = new CreateRatioTapChangerTablePointCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated RatioTapChangerTablePoint
		 * 
		 * @return UpdateRatioTapChangerTablePointCommand alias
		 */
	protected UpdateRatioTapChangerTablePointCommand generateUpdateCommand() {
	        UpdateRatioTapChangerTablePointCommand command = new UpdateRatioTapChangerTablePointCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID ratioTapChangerTablePointId = null;
	protected RatioTapChangerTablePointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RatioTapChangerTablePointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRatioTapChangerTablePointList = 0;
}
