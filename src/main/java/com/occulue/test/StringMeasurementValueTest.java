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
 * Test StringMeasurementValue class.
 *
 * @author your_name_here
 */
public class StringMeasurementValueTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StringMeasurementValueTest() {
		subscriber = new StringMeasurementValueSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StringMeasurementValueTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StringMeasurementValue...");
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
	 * jumpstart the process by instantiating2 StringMeasurementValue
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		stringMeasurementValueId = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
		.createStringMeasurementValue( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
				.createStringMeasurementValue( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.stringMeasurementValueSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StringMeasurementValue : " + successValue.getStringMeasurementValueId());
							  if (successValue.getStringMeasurementValueId().equals(stringMeasurementValueId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStringMeasurementValueList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StringMeasurementValue test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringMeasurementValue consumed")
					);
			subscriber.stringMeasurementValueSubscribe( stringMeasurementValueId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StringMeasurementValue : " + successValue.getStringMeasurementValueId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStringMeasurementValueList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringMeasurementValue for stringMeasurementValueId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StringMeasurementValue. 
	 */
	protected StringMeasurementValue read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StringMeasurementValue" );

		StringMeasurementValue entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StringMeasurementValue with primary key" );
		msg.append( stringMeasurementValueId );
		
		StringMeasurementValueFetchOneSummary fetchOneSummary = new StringMeasurementValueFetchOneSummary( stringMeasurementValueId );

		try {
			entity = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().getStringMeasurementValue( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StringMeasurementValue " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StringMeasurementValue.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StringMeasurementValue." );

		StringBuilder msg = new StringBuilder( "Failed to update a StringMeasurementValue : " );        
		StringMeasurementValue entity = read();
		UpdateStringMeasurementValueCommand command = generateUpdateCommand();
		command.setStringMeasurementValueId(entity.getStringMeasurementValueId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StringMeasurementValue." );

			// for use later on...
			stringMeasurementValueId = entity.getStringMeasurementValueId();

			StringMeasurementValueBusinessDelegate proxy = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance();  

			proxy.updateStringMeasurementValue( command ).get();

			LOGGER.info( "-- Successfully saved StringMeasurementValue - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + stringMeasurementValueId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StringMeasurementValue.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StringMeasurementValue." );

		StringMeasurementValue entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StringMeasurementValue with id " + stringMeasurementValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StringMeasurementValue with id " + stringMeasurementValueId );

			throw e;
		}

		try{
			StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().delete( new DeleteStringMeasurementValueCommand( entity.getStringMeasurementValueId() ) ).get();
			LOGGER.info( "-- Successfully deleted StringMeasurementValue with id " + stringMeasurementValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StringMeasurementValue with id " + stringMeasurementValueId );

			throw e;
		}
	}

	/**
	 * get all StringMeasurementValues.
	 */
	protected List<StringMeasurementValue> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StringMeasurementValues:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StringMeasurementValue : " );        
		List<StringMeasurementValue> collection  = new ArrayList<>();

		try {
			// call the static get method on the StringMeasurementValueBusinessDelegate
			collection = StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance().getAllStringMeasurementValue();
			assertNotNull( collection, "An Empty collection of StringMeasurementValue was incorrectly returned.");
			
			// Now print out the values
			StringMeasurementValue entity = null;            
			Iterator<StringMeasurementValue> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStringMeasurementValueId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StringMeasurementValueTest
	 */
	protected StringMeasurementValueTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StringMeasurementValue
	 * 
	 * @return CreateStringMeasurementValueCommand alias
	 */
	protected CreateStringMeasurementValueCommand generateNewCommand() {
        CreateStringMeasurementValueCommand command = new CreateStringMeasurementValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated StringMeasurementValue
		 * 
		 * @return UpdateStringMeasurementValueCommand alias
		 */
	protected UpdateStringMeasurementValueCommand generateUpdateCommand() {
	        UpdateStringMeasurementValueCommand command = new UpdateStringMeasurementValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID stringMeasurementValueId = null;
	protected StringMeasurementValueSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StringMeasurementValueTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStringMeasurementValueList = 0;
}
