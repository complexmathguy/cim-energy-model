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
 * Test ControlAreaGeneratingUnit class.
 *
 * @author your_name_here
 */
public class ControlAreaGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ControlAreaGeneratingUnitTest() {
		subscriber = new ControlAreaGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ControlAreaGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ControlAreaGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 ControlAreaGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		controlAreaGeneratingUnitId = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
		.createControlAreaGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance()
				.createControlAreaGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.controlAreaGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ControlAreaGeneratingUnit : " + successValue.getControlAreaGeneratingUnitId());
							  if (successValue.getControlAreaGeneratingUnitId().equals(controlAreaGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfControlAreaGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ControlAreaGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on controlAreaGeneratingUnit consumed")
					);
			subscriber.controlAreaGeneratingUnitSubscribe( controlAreaGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ControlAreaGeneratingUnit : " + successValue.getControlAreaGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfControlAreaGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on controlAreaGeneratingUnit for controlAreaGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ControlAreaGeneratingUnit. 
	 */
	protected ControlAreaGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ControlAreaGeneratingUnit" );

		ControlAreaGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ControlAreaGeneratingUnit with primary key" );
		msg.append( controlAreaGeneratingUnitId );
		
		ControlAreaGeneratingUnitFetchOneSummary fetchOneSummary = new ControlAreaGeneratingUnitFetchOneSummary( controlAreaGeneratingUnitId );

		try {
			entity = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance().getControlAreaGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ControlAreaGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ControlAreaGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ControlAreaGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a ControlAreaGeneratingUnit : " );        
		ControlAreaGeneratingUnit entity = read();
		UpdateControlAreaGeneratingUnitCommand command = generateUpdateCommand();
		command.setControlAreaGeneratingUnitId(entity.getControlAreaGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ControlAreaGeneratingUnit." );

			// for use later on...
			controlAreaGeneratingUnitId = entity.getControlAreaGeneratingUnitId();

			ControlAreaGeneratingUnitBusinessDelegate proxy = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance();  

			proxy.updateControlAreaGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved ControlAreaGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + controlAreaGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ControlAreaGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ControlAreaGeneratingUnit." );

		ControlAreaGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ControlAreaGeneratingUnit with id " + controlAreaGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ControlAreaGeneratingUnit with id " + controlAreaGeneratingUnitId );

			throw e;
		}

		try{
			ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance().delete( new DeleteControlAreaGeneratingUnitCommand( entity.getControlAreaGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted ControlAreaGeneratingUnit with id " + controlAreaGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ControlAreaGeneratingUnit with id " + controlAreaGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all ControlAreaGeneratingUnits.
	 */
	protected List<ControlAreaGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ControlAreaGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ControlAreaGeneratingUnit : " );        
		List<ControlAreaGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the ControlAreaGeneratingUnitBusinessDelegate
			collection = ControlAreaGeneratingUnitBusinessDelegate.getControlAreaGeneratingUnitInstance().getAllControlAreaGeneratingUnit();
			assertNotNull( collection, "An Empty collection of ControlAreaGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			ControlAreaGeneratingUnit entity = null;            
			Iterator<ControlAreaGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getControlAreaGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ControlAreaGeneratingUnitTest
	 */
	protected ControlAreaGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ControlAreaGeneratingUnit
	 * 
	 * @return CreateControlAreaGeneratingUnitCommand alias
	 */
	protected CreateControlAreaGeneratingUnitCommand generateNewCommand() {
        CreateControlAreaGeneratingUnitCommand command = new CreateControlAreaGeneratingUnitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ControlAreaGeneratingUnit
		 * 
		 * @return UpdateControlAreaGeneratingUnitCommand alias
		 */
	protected UpdateControlAreaGeneratingUnitCommand generateUpdateCommand() {
	        UpdateControlAreaGeneratingUnitCommand command = new UpdateControlAreaGeneratingUnitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID controlAreaGeneratingUnitId = null;
	protected ControlAreaGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ControlAreaGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfControlAreaGeneratingUnitList = 0;
}
