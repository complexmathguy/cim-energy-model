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
 * Test AnalogValue class.
 *
 * @author your_name_here
 */
public class AnalogValueTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AnalogValueTest() {
		subscriber = new AnalogValueSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AnalogValueTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AnalogValue...");
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
	 * jumpstart the process by instantiating2 AnalogValue
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		analogValueId = AnalogValueBusinessDelegate.getAnalogValueInstance()
		.createAnalogValue( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AnalogValueBusinessDelegate.getAnalogValueInstance()
				.createAnalogValue( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.analogValueSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AnalogValue : " + successValue.getAnalogValueId());
							  if (successValue.getAnalogValueId().equals(analogValueId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAnalogValueList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AnalogValue test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogValue consumed")
					);
			subscriber.analogValueSubscribe( analogValueId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AnalogValue : " + successValue.getAnalogValueId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAnalogValueList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogValue for analogValueId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AnalogValue. 
	 */
	protected AnalogValue read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AnalogValue" );

		AnalogValue entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AnalogValue with primary key" );
		msg.append( analogValueId );
		
		AnalogValueFetchOneSummary fetchOneSummary = new AnalogValueFetchOneSummary( analogValueId );

		try {
			entity = AnalogValueBusinessDelegate.getAnalogValueInstance().getAnalogValue( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AnalogValue " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AnalogValue.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AnalogValue." );

		StringBuilder msg = new StringBuilder( "Failed to update a AnalogValue : " );        
		AnalogValue entity = read();
		UpdateAnalogValueCommand command = generateUpdateCommand();
		command.setAnalogValueId(entity.getAnalogValueId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AnalogValue." );

			// for use later on...
			analogValueId = entity.getAnalogValueId();

			AnalogValueBusinessDelegate proxy = AnalogValueBusinessDelegate.getAnalogValueInstance();  

			proxy.updateAnalogValue( command ).get();

			LOGGER.info( "-- Successfully saved AnalogValue - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + analogValueId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AnalogValue.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AnalogValue." );

		AnalogValue entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AnalogValue with id " + analogValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AnalogValue with id " + analogValueId );

			throw e;
		}

		try{
			AnalogValueBusinessDelegate.getAnalogValueInstance().delete( new DeleteAnalogValueCommand( entity.getAnalogValueId() ) ).get();
			LOGGER.info( "-- Successfully deleted AnalogValue with id " + analogValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AnalogValue with id " + analogValueId );

			throw e;
		}
	}

	/**
	 * get all AnalogValues.
	 */
	protected List<AnalogValue> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AnalogValues:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AnalogValue : " );        
		List<AnalogValue> collection  = new ArrayList<>();

		try {
			// call the static get method on the AnalogValueBusinessDelegate
			collection = AnalogValueBusinessDelegate.getAnalogValueInstance().getAllAnalogValue();
			assertNotNull( collection, "An Empty collection of AnalogValue was incorrectly returned.");
			
			// Now print out the values
			AnalogValue entity = null;            
			Iterator<AnalogValue> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAnalogValueId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AnalogValueTest
	 */
	protected AnalogValueTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AnalogValue
	 * 
	 * @return CreateAnalogValueCommand alias
	 */
	protected CreateAnalogValueCommand generateNewCommand() {
        CreateAnalogValueCommand command = new CreateAnalogValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AnalogValue
		 * 
		 * @return UpdateAnalogValueCommand alias
		 */
	protected UpdateAnalogValueCommand generateUpdateCommand() {
	        UpdateAnalogValueCommand command = new UpdateAnalogValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID analogValueId = null;
	protected AnalogValueSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AnalogValueTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAnalogValueList = 0;
}
