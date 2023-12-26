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
 * Test WindAeroLinearIEC class.
 *
 * @author your_name_here
 */
public class WindAeroLinearIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindAeroLinearIECTest() {
		subscriber = new WindAeroLinearIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindAeroLinearIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindAeroLinearIEC...");
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
	 * jumpstart the process by instantiating2 WindAeroLinearIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windAeroLinearIECId = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance()
		.createWindAeroLinearIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance()
				.createWindAeroLinearIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windAeroLinearIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindAeroLinearIEC : " + successValue.getWindAeroLinearIECId());
							  if (successValue.getWindAeroLinearIECId().equals(windAeroLinearIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindAeroLinearIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindAeroLinearIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windAeroLinearIEC consumed")
					);
			subscriber.windAeroLinearIECSubscribe( windAeroLinearIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindAeroLinearIEC : " + successValue.getWindAeroLinearIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindAeroLinearIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windAeroLinearIEC for windAeroLinearIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindAeroLinearIEC. 
	 */
	protected WindAeroLinearIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindAeroLinearIEC" );

		WindAeroLinearIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindAeroLinearIEC with primary key" );
		msg.append( windAeroLinearIECId );
		
		WindAeroLinearIECFetchOneSummary fetchOneSummary = new WindAeroLinearIECFetchOneSummary( windAeroLinearIECId );

		try {
			entity = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().getWindAeroLinearIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindAeroLinearIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindAeroLinearIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindAeroLinearIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindAeroLinearIEC : " );        
		WindAeroLinearIEC entity = read();
		UpdateWindAeroLinearIECCommand command = generateUpdateCommand();
		command.setWindAeroLinearIECId(entity.getWindAeroLinearIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindAeroLinearIEC." );

			// for use later on...
			windAeroLinearIECId = entity.getWindAeroLinearIECId();

			WindAeroLinearIECBusinessDelegate proxy = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();  

			proxy.updateWindAeroLinearIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindAeroLinearIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windAeroLinearIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindAeroLinearIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindAeroLinearIEC." );

		WindAeroLinearIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindAeroLinearIEC with id " + windAeroLinearIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindAeroLinearIEC with id " + windAeroLinearIECId );

			throw e;
		}

		try{
			WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().delete( new DeleteWindAeroLinearIECCommand( entity.getWindAeroLinearIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindAeroLinearIEC with id " + windAeroLinearIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindAeroLinearIEC with id " + windAeroLinearIECId );

			throw e;
		}
	}

	/**
	 * get all WindAeroLinearIECs.
	 */
	protected List<WindAeroLinearIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindAeroLinearIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindAeroLinearIEC : " );        
		List<WindAeroLinearIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindAeroLinearIECBusinessDelegate
			collection = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().getAllWindAeroLinearIEC();
			assertNotNull( collection, "An Empty collection of WindAeroLinearIEC was incorrectly returned.");
			
			// Now print out the values
			WindAeroLinearIEC entity = null;            
			Iterator<WindAeroLinearIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindAeroLinearIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindAeroLinearIECTest
	 */
	protected WindAeroLinearIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindAeroLinearIEC
	 * 
	 * @return CreateWindAeroLinearIECCommand alias
	 */
	protected CreateWindAeroLinearIECCommand generateNewCommand() {
        CreateWindAeroLinearIECCommand command = new CreateWindAeroLinearIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindAeroLinearIEC
		 * 
		 * @return UpdateWindAeroLinearIECCommand alias
		 */
	protected UpdateWindAeroLinearIECCommand generateUpdateCommand() {
	        UpdateWindAeroLinearIECCommand command = new UpdateWindAeroLinearIECCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windAeroLinearIECId = null;
	protected WindAeroLinearIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindAeroLinearIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindAeroLinearIECList = 0;
}
