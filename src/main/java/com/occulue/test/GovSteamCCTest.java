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
 * Test GovSteamCC class.
 *
 * @author your_name_here
 */
public class GovSteamCCTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteamCCTest() {
		subscriber = new GovSteamCCSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteamCCTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteamCC...");
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
	 * jumpstart the process by instantiating2 GovSteamCC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteamCCId = GovSteamCCBusinessDelegate.getGovSteamCCInstance()
		.createGovSteamCC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteamCCBusinessDelegate.getGovSteamCCInstance()
				.createGovSteamCC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteamCCSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteamCC : " + successValue.getGovSteamCCId());
							  if (successValue.getGovSteamCCId().equals(govSteamCCId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteamCCList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteamCC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamCC consumed")
					);
			subscriber.govSteamCCSubscribe( govSteamCCId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteamCC : " + successValue.getGovSteamCCId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteamCCList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamCC for govSteamCCId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteamCC. 
	 */
	protected GovSteamCC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteamCC" );

		GovSteamCC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteamCC with primary key" );
		msg.append( govSteamCCId );
		
		GovSteamCCFetchOneSummary fetchOneSummary = new GovSteamCCFetchOneSummary( govSteamCCId );

		try {
			entity = GovSteamCCBusinessDelegate.getGovSteamCCInstance().getGovSteamCC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteamCC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteamCC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteamCC." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteamCC : " );        
		GovSteamCC entity = read();
		UpdateGovSteamCCCommand command = generateUpdateCommand();
		command.setGovSteamCCId(entity.getGovSteamCCId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteamCC." );

			// for use later on...
			govSteamCCId = entity.getGovSteamCCId();

			GovSteamCCBusinessDelegate proxy = GovSteamCCBusinessDelegate.getGovSteamCCInstance();  

			proxy.updateGovSteamCC( command ).get();

			LOGGER.info( "-- Successfully saved GovSteamCC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteamCCId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteamCC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteamCC." );

		GovSteamCC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteamCC with id " + govSteamCCId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteamCC with id " + govSteamCCId );

			throw e;
		}

		try{
			GovSteamCCBusinessDelegate.getGovSteamCCInstance().delete( new DeleteGovSteamCCCommand( entity.getGovSteamCCId() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteamCC with id " + govSteamCCId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteamCC with id " + govSteamCCId );

			throw e;
		}
	}

	/**
	 * get all GovSteamCCs.
	 */
	protected List<GovSteamCC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteamCCs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteamCC : " );        
		List<GovSteamCC> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteamCCBusinessDelegate
			collection = GovSteamCCBusinessDelegate.getGovSteamCCInstance().getAllGovSteamCC();
			assertNotNull( collection, "An Empty collection of GovSteamCC was incorrectly returned.");
			
			// Now print out the values
			GovSteamCC entity = null;            
			Iterator<GovSteamCC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteamCCId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteamCCTest
	 */
	protected GovSteamCCTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteamCC
	 * 
	 * @return CreateGovSteamCCCommand alias
	 */
	protected CreateGovSteamCCCommand generateNewCommand() {
        CreateGovSteamCCCommand command = new CreateGovSteamCCCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteamCC
		 * 
		 * @return UpdateGovSteamCCCommand alias
		 */
	protected UpdateGovSteamCCCommand generateUpdateCommand() {
	        UpdateGovSteamCCCommand command = new UpdateGovSteamCCCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteamCCId = null;
	protected GovSteamCCSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteamCCTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteamCCList = 0;
}
