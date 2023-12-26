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
 * Test Analog class.
 *
 * @author your_name_here
 */
public class AnalogTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AnalogTest() {
		subscriber = new AnalogSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AnalogTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Analog...");
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
	 * jumpstart the process by instantiating2 Analog
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		analogId = AnalogBusinessDelegate.getAnalogInstance()
		.createAnalog( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AnalogBusinessDelegate.getAnalogInstance()
				.createAnalog( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.analogSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Analog : " + successValue.getAnalogId());
							  if (successValue.getAnalogId().equals(analogId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAnalogList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Analog test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analog consumed")
					);
			subscriber.analogSubscribe( analogId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Analog : " + successValue.getAnalogId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAnalogList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analog for analogId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Analog. 
	 */
	protected Analog read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Analog" );

		Analog entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Analog with primary key" );
		msg.append( analogId );
		
		AnalogFetchOneSummary fetchOneSummary = new AnalogFetchOneSummary( analogId );

		try {
			entity = AnalogBusinessDelegate.getAnalogInstance().getAnalog( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Analog " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Analog.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Analog." );

		StringBuilder msg = new StringBuilder( "Failed to update a Analog : " );        
		Analog entity = read();
		UpdateAnalogCommand command = generateUpdateCommand();
		command.setAnalogId(entity.getAnalogId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Analog." );

			// for use later on...
			analogId = entity.getAnalogId();

			AnalogBusinessDelegate proxy = AnalogBusinessDelegate.getAnalogInstance();  

			proxy.updateAnalog( command ).get();

			LOGGER.info( "-- Successfully saved Analog - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + analogId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Analog.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Analog." );

		Analog entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Analog with id " + analogId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Analog with id " + analogId );

			throw e;
		}

		try{
			AnalogBusinessDelegate.getAnalogInstance().delete( new DeleteAnalogCommand( entity.getAnalogId() ) ).get();
			LOGGER.info( "-- Successfully deleted Analog with id " + analogId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Analog with id " + analogId );

			throw e;
		}
	}

	/**
	 * get all Analogs.
	 */
	protected List<Analog> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Analogs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Analog : " );        
		List<Analog> collection  = new ArrayList<>();

		try {
			// call the static get method on the AnalogBusinessDelegate
			collection = AnalogBusinessDelegate.getAnalogInstance().getAllAnalog();
			assertNotNull( collection, "An Empty collection of Analog was incorrectly returned.");
			
			// Now print out the values
			Analog entity = null;            
			Iterator<Analog> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAnalogId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AnalogTest
	 */
	protected AnalogTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Analog
	 * 
	 * @return CreateAnalogCommand alias
	 */
	protected CreateAnalogCommand generateNewCommand() {
        CreateAnalogCommand command = new CreateAnalogCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Analog
		 * 
		 * @return UpdateAnalogCommand alias
		 */
	protected UpdateAnalogCommand generateUpdateCommand() {
	        UpdateAnalogCommand command = new UpdateAnalogCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID analogId = null;
	protected AnalogSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AnalogTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAnalogList = 0;
}
