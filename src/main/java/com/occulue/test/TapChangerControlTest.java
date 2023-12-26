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
 * Test TapChangerControl class.
 *
 * @author your_name_here
 */
public class TapChangerControlTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TapChangerControlTest() {
		subscriber = new TapChangerControlSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TapChangerControlTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TapChangerControl...");
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
	 * jumpstart the process by instantiating2 TapChangerControl
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		tapChangerControlId = TapChangerControlBusinessDelegate.getTapChangerControlInstance()
		.createTapChangerControl( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TapChangerControlBusinessDelegate.getTapChangerControlInstance()
				.createTapChangerControl( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.tapChangerControlSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TapChangerControl : " + successValue.getTapChangerControlId());
							  if (successValue.getTapChangerControlId().equals(tapChangerControlId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTapChangerControlList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TapChangerControl test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChangerControl consumed")
					);
			subscriber.tapChangerControlSubscribe( tapChangerControlId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TapChangerControl : " + successValue.getTapChangerControlId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTapChangerControlList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChangerControl for tapChangerControlId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TapChangerControl. 
	 */
	protected TapChangerControl read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TapChangerControl" );

		TapChangerControl entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TapChangerControl with primary key" );
		msg.append( tapChangerControlId );
		
		TapChangerControlFetchOneSummary fetchOneSummary = new TapChangerControlFetchOneSummary( tapChangerControlId );

		try {
			entity = TapChangerControlBusinessDelegate.getTapChangerControlInstance().getTapChangerControl( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TapChangerControl " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TapChangerControl.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TapChangerControl." );

		StringBuilder msg = new StringBuilder( "Failed to update a TapChangerControl : " );        
		TapChangerControl entity = read();
		UpdateTapChangerControlCommand command = generateUpdateCommand();
		command.setTapChangerControlId(entity.getTapChangerControlId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TapChangerControl." );

			// for use later on...
			tapChangerControlId = entity.getTapChangerControlId();

			TapChangerControlBusinessDelegate proxy = TapChangerControlBusinessDelegate.getTapChangerControlInstance();  

			proxy.updateTapChangerControl( command ).get();

			LOGGER.info( "-- Successfully saved TapChangerControl - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + tapChangerControlId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TapChangerControl.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TapChangerControl." );

		TapChangerControl entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TapChangerControl with id " + tapChangerControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TapChangerControl with id " + tapChangerControlId );

			throw e;
		}

		try{
			TapChangerControlBusinessDelegate.getTapChangerControlInstance().delete( new DeleteTapChangerControlCommand( entity.getTapChangerControlId() ) ).get();
			LOGGER.info( "-- Successfully deleted TapChangerControl with id " + tapChangerControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TapChangerControl with id " + tapChangerControlId );

			throw e;
		}
	}

	/**
	 * get all TapChangerControls.
	 */
	protected List<TapChangerControl> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TapChangerControls:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TapChangerControl : " );        
		List<TapChangerControl> collection  = new ArrayList<>();

		try {
			// call the static get method on the TapChangerControlBusinessDelegate
			collection = TapChangerControlBusinessDelegate.getTapChangerControlInstance().getAllTapChangerControl();
			assertNotNull( collection, "An Empty collection of TapChangerControl was incorrectly returned.");
			
			// Now print out the values
			TapChangerControl entity = null;            
			Iterator<TapChangerControl> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTapChangerControlId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TapChangerControlTest
	 */
	protected TapChangerControlTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TapChangerControl
	 * 
	 * @return CreateTapChangerControlCommand alias
	 */
	protected CreateTapChangerControlCommand generateNewCommand() {
        CreateTapChangerControlCommand command = new CreateTapChangerControlCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated TapChangerControl
		 * 
		 * @return UpdateTapChangerControlCommand alias
		 */
	protected UpdateTapChangerControlCommand generateUpdateCommand() {
	        UpdateTapChangerControlCommand command = new UpdateTapChangerControlCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID tapChangerControlId = null;
	protected TapChangerControlSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TapChangerControlTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTapChangerControlList = 0;
}
