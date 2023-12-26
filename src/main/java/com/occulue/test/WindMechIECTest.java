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
 * Test WindMechIEC class.
 *
 * @author your_name_here
 */
public class WindMechIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindMechIECTest() {
		subscriber = new WindMechIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindMechIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindMechIEC...");
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
	 * jumpstart the process by instantiating2 WindMechIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windMechIECId = WindMechIECBusinessDelegate.getWindMechIECInstance()
		.createWindMechIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindMechIECBusinessDelegate.getWindMechIECInstance()
				.createWindMechIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windMechIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindMechIEC : " + successValue.getWindMechIECId());
							  if (successValue.getWindMechIECId().equals(windMechIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindMechIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindMechIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windMechIEC consumed")
					);
			subscriber.windMechIECSubscribe( windMechIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindMechIEC : " + successValue.getWindMechIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindMechIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windMechIEC for windMechIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindMechIEC. 
	 */
	protected WindMechIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindMechIEC" );

		WindMechIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindMechIEC with primary key" );
		msg.append( windMechIECId );
		
		WindMechIECFetchOneSummary fetchOneSummary = new WindMechIECFetchOneSummary( windMechIECId );

		try {
			entity = WindMechIECBusinessDelegate.getWindMechIECInstance().getWindMechIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindMechIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindMechIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindMechIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindMechIEC : " );        
		WindMechIEC entity = read();
		UpdateWindMechIECCommand command = generateUpdateCommand();
		command.setWindMechIECId(entity.getWindMechIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindMechIEC." );

			// for use later on...
			windMechIECId = entity.getWindMechIECId();

			WindMechIECBusinessDelegate proxy = WindMechIECBusinessDelegate.getWindMechIECInstance();  

			proxy.updateWindMechIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindMechIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windMechIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindMechIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindMechIEC." );

		WindMechIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindMechIEC with id " + windMechIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindMechIEC with id " + windMechIECId );

			throw e;
		}

		try{
			WindMechIECBusinessDelegate.getWindMechIECInstance().delete( new DeleteWindMechIECCommand( entity.getWindMechIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindMechIEC with id " + windMechIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindMechIEC with id " + windMechIECId );

			throw e;
		}
	}

	/**
	 * get all WindMechIECs.
	 */
	protected List<WindMechIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindMechIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindMechIEC : " );        
		List<WindMechIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindMechIECBusinessDelegate
			collection = WindMechIECBusinessDelegate.getWindMechIECInstance().getAllWindMechIEC();
			assertNotNull( collection, "An Empty collection of WindMechIEC was incorrectly returned.");
			
			// Now print out the values
			WindMechIEC entity = null;            
			Iterator<WindMechIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindMechIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindMechIECTest
	 */
	protected WindMechIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindMechIEC
	 * 
	 * @return CreateWindMechIECCommand alias
	 */
	protected CreateWindMechIECCommand generateNewCommand() {
        CreateWindMechIECCommand command = new CreateWindMechIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindMechIEC
		 * 
		 * @return UpdateWindMechIECCommand alias
		 */
	protected UpdateWindMechIECCommand generateUpdateCommand() {
	        UpdateWindMechIECCommand command = new UpdateWindMechIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windMechIECId = null;
	protected WindMechIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindMechIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindMechIECList = 0;
}
