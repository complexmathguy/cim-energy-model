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
 * Test SetPoint class.
 *
 * @author your_name_here
 */
public class SetPointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SetPointTest() {
		subscriber = new SetPointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SetPointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SetPoint...");
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
	 * jumpstart the process by instantiating2 SetPoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		setPointId = SetPointBusinessDelegate.getSetPointInstance()
		.createSetPoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SetPointBusinessDelegate.getSetPointInstance()
				.createSetPoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.setPointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SetPoint : " + successValue.getSetPointId());
							  if (successValue.getSetPointId().equals(setPointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSetPointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SetPoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on setPoint consumed")
					);
			subscriber.setPointSubscribe( setPointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SetPoint : " + successValue.getSetPointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSetPointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on setPoint for setPointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SetPoint. 
	 */
	protected SetPoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SetPoint" );

		SetPoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SetPoint with primary key" );
		msg.append( setPointId );
		
		SetPointFetchOneSummary fetchOneSummary = new SetPointFetchOneSummary( setPointId );

		try {
			entity = SetPointBusinessDelegate.getSetPointInstance().getSetPoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SetPoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SetPoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SetPoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a SetPoint : " );        
		SetPoint entity = read();
		UpdateSetPointCommand command = generateUpdateCommand();
		command.setSetPointId(entity.getSetPointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SetPoint." );

			// for use later on...
			setPointId = entity.getSetPointId();

			SetPointBusinessDelegate proxy = SetPointBusinessDelegate.getSetPointInstance();  

			proxy.updateSetPoint( command ).get();

			LOGGER.info( "-- Successfully saved SetPoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + setPointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SetPoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SetPoint." );

		SetPoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SetPoint with id " + setPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SetPoint with id " + setPointId );

			throw e;
		}

		try{
			SetPointBusinessDelegate.getSetPointInstance().delete( new DeleteSetPointCommand( entity.getSetPointId() ) ).get();
			LOGGER.info( "-- Successfully deleted SetPoint with id " + setPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SetPoint with id " + setPointId );

			throw e;
		}
	}

	/**
	 * get all SetPoints.
	 */
	protected List<SetPoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SetPoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SetPoint : " );        
		List<SetPoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the SetPointBusinessDelegate
			collection = SetPointBusinessDelegate.getSetPointInstance().getAllSetPoint();
			assertNotNull( collection, "An Empty collection of SetPoint was incorrectly returned.");
			
			// Now print out the values
			SetPoint entity = null;            
			Iterator<SetPoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSetPointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SetPointTest
	 */
	protected SetPointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SetPoint
	 * 
	 * @return CreateSetPointCommand alias
	 */
	protected CreateSetPointCommand generateNewCommand() {
        CreateSetPointCommand command = new CreateSetPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SetPoint
		 * 
		 * @return UpdateSetPointCommand alias
		 */
	protected UpdateSetPointCommand generateUpdateCommand() {
	        UpdateSetPointCommand command = new UpdateSetPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID setPointId = null;
	protected SetPointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SetPointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSetPointList = 0;
}
