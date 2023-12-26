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
 * Test Control class.
 *
 * @author your_name_here
 */
public class ControlTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ControlTest() {
		subscriber = new ControlSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ControlTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Control...");
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
	 * jumpstart the process by instantiating2 Control
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		controlId = ControlBusinessDelegate.getControlInstance()
		.createControl( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ControlBusinessDelegate.getControlInstance()
				.createControl( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.controlSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Control : " + successValue.getControlId());
							  if (successValue.getControlId().equals(controlId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfControlList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Control test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on control consumed")
					);
			subscriber.controlSubscribe( controlId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Control : " + successValue.getControlId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfControlList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on control for controlId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Control. 
	 */
	protected Control read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Control" );

		Control entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Control with primary key" );
		msg.append( controlId );
		
		ControlFetchOneSummary fetchOneSummary = new ControlFetchOneSummary( controlId );

		try {
			entity = ControlBusinessDelegate.getControlInstance().getControl( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Control " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Control.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Control." );

		StringBuilder msg = new StringBuilder( "Failed to update a Control : " );        
		Control entity = read();
		UpdateControlCommand command = generateUpdateCommand();
		command.setControlId(entity.getControlId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Control." );

			// for use later on...
			controlId = entity.getControlId();

			ControlBusinessDelegate proxy = ControlBusinessDelegate.getControlInstance();  

			proxy.updateControl( command ).get();

			LOGGER.info( "-- Successfully saved Control - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + controlId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Control.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Control." );

		Control entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Control with id " + controlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Control with id " + controlId );

			throw e;
		}

		try{
			ControlBusinessDelegate.getControlInstance().delete( new DeleteControlCommand( entity.getControlId() ) ).get();
			LOGGER.info( "-- Successfully deleted Control with id " + controlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Control with id " + controlId );

			throw e;
		}
	}

	/**
	 * get all Controls.
	 */
	protected List<Control> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Controls:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Control : " );        
		List<Control> collection  = new ArrayList<>();

		try {
			// call the static get method on the ControlBusinessDelegate
			collection = ControlBusinessDelegate.getControlInstance().getAllControl();
			assertNotNull( collection, "An Empty collection of Control was incorrectly returned.");
			
			// Now print out the values
			Control entity = null;            
			Iterator<Control> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getControlId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ControlTest
	 */
	protected ControlTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Control
	 * 
	 * @return CreateControlCommand alias
	 */
	protected CreateControlCommand generateNewCommand() {
        CreateControlCommand command = new CreateControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Control
		 * 
		 * @return UpdateControlCommand alias
		 */
	protected UpdateControlCommand generateUpdateCommand() {
	        UpdateControlCommand command = new UpdateControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID controlId = null;
	protected ControlSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ControlTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfControlList = 0;
}
