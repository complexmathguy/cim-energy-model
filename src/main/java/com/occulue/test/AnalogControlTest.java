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
 * Test AnalogControl class.
 *
 * @author your_name_here
 */
public class AnalogControlTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AnalogControlTest() {
		subscriber = new AnalogControlSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AnalogControlTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AnalogControl...");
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
	 * jumpstart the process by instantiating2 AnalogControl
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		analogControlId = AnalogControlBusinessDelegate.getAnalogControlInstance()
		.createAnalogControl( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AnalogControlBusinessDelegate.getAnalogControlInstance()
				.createAnalogControl( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.analogControlSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AnalogControl : " + successValue.getAnalogControlId());
							  if (successValue.getAnalogControlId().equals(analogControlId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAnalogControlList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AnalogControl test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogControl consumed")
					);
			subscriber.analogControlSubscribe( analogControlId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AnalogControl : " + successValue.getAnalogControlId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAnalogControlList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogControl for analogControlId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AnalogControl. 
	 */
	protected AnalogControl read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AnalogControl" );

		AnalogControl entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AnalogControl with primary key" );
		msg.append( analogControlId );
		
		AnalogControlFetchOneSummary fetchOneSummary = new AnalogControlFetchOneSummary( analogControlId );

		try {
			entity = AnalogControlBusinessDelegate.getAnalogControlInstance().getAnalogControl( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AnalogControl " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AnalogControl.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AnalogControl." );

		StringBuilder msg = new StringBuilder( "Failed to update a AnalogControl : " );        
		AnalogControl entity = read();
		UpdateAnalogControlCommand command = generateUpdateCommand();
		command.setAnalogControlId(entity.getAnalogControlId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AnalogControl." );

			// for use later on...
			analogControlId = entity.getAnalogControlId();

			AnalogControlBusinessDelegate proxy = AnalogControlBusinessDelegate.getAnalogControlInstance();  

			proxy.updateAnalogControl( command ).get();

			LOGGER.info( "-- Successfully saved AnalogControl - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + analogControlId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AnalogControl.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AnalogControl." );

		AnalogControl entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AnalogControl with id " + analogControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AnalogControl with id " + analogControlId );

			throw e;
		}

		try{
			AnalogControlBusinessDelegate.getAnalogControlInstance().delete( new DeleteAnalogControlCommand( entity.getAnalogControlId() ) ).get();
			LOGGER.info( "-- Successfully deleted AnalogControl with id " + analogControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AnalogControl with id " + analogControlId );

			throw e;
		}
	}

	/**
	 * get all AnalogControls.
	 */
	protected List<AnalogControl> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AnalogControls:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AnalogControl : " );        
		List<AnalogControl> collection  = new ArrayList<>();

		try {
			// call the static get method on the AnalogControlBusinessDelegate
			collection = AnalogControlBusinessDelegate.getAnalogControlInstance().getAllAnalogControl();
			assertNotNull( collection, "An Empty collection of AnalogControl was incorrectly returned.");
			
			// Now print out the values
			AnalogControl entity = null;            
			Iterator<AnalogControl> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAnalogControlId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AnalogControlTest
	 */
	protected AnalogControlTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AnalogControl
	 * 
	 * @return CreateAnalogControlCommand alias
	 */
	protected CreateAnalogControlCommand generateNewCommand() {
        CreateAnalogControlCommand command = new CreateAnalogControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AnalogControl
		 * 
		 * @return UpdateAnalogControlCommand alias
		 */
	protected UpdateAnalogControlCommand generateUpdateCommand() {
	        UpdateAnalogControlCommand command = new UpdateAnalogControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID analogControlId = null;
	protected AnalogControlSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AnalogControlTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAnalogControlList = 0;
}
