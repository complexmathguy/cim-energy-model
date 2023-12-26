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
 * Test StringMeasurement class.
 *
 * @author your_name_here
 */
public class StringMeasurementTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StringMeasurementTest() {
		subscriber = new StringMeasurementSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StringMeasurementTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StringMeasurement...");
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
	 * jumpstart the process by instantiating2 StringMeasurement
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		stringMeasurementId = StringMeasurementBusinessDelegate.getStringMeasurementInstance()
		.createStringMeasurement( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StringMeasurementBusinessDelegate.getStringMeasurementInstance()
				.createStringMeasurement( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.stringMeasurementSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StringMeasurement : " + successValue.getStringMeasurementId());
							  if (successValue.getStringMeasurementId().equals(stringMeasurementId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStringMeasurementList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StringMeasurement test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringMeasurement consumed")
					);
			subscriber.stringMeasurementSubscribe( stringMeasurementId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StringMeasurement : " + successValue.getStringMeasurementId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStringMeasurementList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringMeasurement for stringMeasurementId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StringMeasurement. 
	 */
	protected StringMeasurement read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StringMeasurement" );

		StringMeasurement entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StringMeasurement with primary key" );
		msg.append( stringMeasurementId );
		
		StringMeasurementFetchOneSummary fetchOneSummary = new StringMeasurementFetchOneSummary( stringMeasurementId );

		try {
			entity = StringMeasurementBusinessDelegate.getStringMeasurementInstance().getStringMeasurement( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StringMeasurement " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StringMeasurement.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StringMeasurement." );

		StringBuilder msg = new StringBuilder( "Failed to update a StringMeasurement : " );        
		StringMeasurement entity = read();
		UpdateStringMeasurementCommand command = generateUpdateCommand();
		command.setStringMeasurementId(entity.getStringMeasurementId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StringMeasurement." );

			// for use later on...
			stringMeasurementId = entity.getStringMeasurementId();

			StringMeasurementBusinessDelegate proxy = StringMeasurementBusinessDelegate.getStringMeasurementInstance();  

			proxy.updateStringMeasurement( command ).get();

			LOGGER.info( "-- Successfully saved StringMeasurement - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + stringMeasurementId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StringMeasurement.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StringMeasurement." );

		StringMeasurement entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StringMeasurement with id " + stringMeasurementId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StringMeasurement with id " + stringMeasurementId );

			throw e;
		}

		try{
			StringMeasurementBusinessDelegate.getStringMeasurementInstance().delete( new DeleteStringMeasurementCommand( entity.getStringMeasurementId() ) ).get();
			LOGGER.info( "-- Successfully deleted StringMeasurement with id " + stringMeasurementId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StringMeasurement with id " + stringMeasurementId );

			throw e;
		}
	}

	/**
	 * get all StringMeasurements.
	 */
	protected List<StringMeasurement> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StringMeasurements:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StringMeasurement : " );        
		List<StringMeasurement> collection  = new ArrayList<>();

		try {
			// call the static get method on the StringMeasurementBusinessDelegate
			collection = StringMeasurementBusinessDelegate.getStringMeasurementInstance().getAllStringMeasurement();
			assertNotNull( collection, "An Empty collection of StringMeasurement was incorrectly returned.");
			
			// Now print out the values
			StringMeasurement entity = null;            
			Iterator<StringMeasurement> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStringMeasurementId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StringMeasurementTest
	 */
	protected StringMeasurementTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StringMeasurement
	 * 
	 * @return CreateStringMeasurementCommand alias
	 */
	protected CreateStringMeasurementCommand generateNewCommand() {
        CreateStringMeasurementCommand command = new CreateStringMeasurementCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated StringMeasurement
		 * 
		 * @return UpdateStringMeasurementCommand alias
		 */
	protected UpdateStringMeasurementCommand generateUpdateCommand() {
	        UpdateStringMeasurementCommand command = new UpdateStringMeasurementCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID stringMeasurementId = null;
	protected StringMeasurementSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StringMeasurementTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStringMeasurementList = 0;
}
