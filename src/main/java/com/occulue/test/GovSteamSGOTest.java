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
 * Test GovSteamSGO class.
 *
 * @author your_name_here
 */
public class GovSteamSGOTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteamSGOTest() {
		subscriber = new GovSteamSGOSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteamSGOTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteamSGO...");
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
	 * jumpstart the process by instantiating2 GovSteamSGO
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteamSGOId = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance()
		.createGovSteamSGO( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteamSGOBusinessDelegate.getGovSteamSGOInstance()
				.createGovSteamSGO( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteamSGOSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteamSGO : " + successValue.getGovSteamSGOId());
							  if (successValue.getGovSteamSGOId().equals(govSteamSGOId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteamSGOList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteamSGO test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamSGO consumed")
					);
			subscriber.govSteamSGOSubscribe( govSteamSGOId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteamSGO : " + successValue.getGovSteamSGOId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteamSGOList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamSGO for govSteamSGOId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteamSGO. 
	 */
	protected GovSteamSGO read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteamSGO" );

		GovSteamSGO entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteamSGO with primary key" );
		msg.append( govSteamSGOId );
		
		GovSteamSGOFetchOneSummary fetchOneSummary = new GovSteamSGOFetchOneSummary( govSteamSGOId );

		try {
			entity = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().getGovSteamSGO( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteamSGO " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteamSGO.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteamSGO." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteamSGO : " );        
		GovSteamSGO entity = read();
		UpdateGovSteamSGOCommand command = generateUpdateCommand();
		command.setGovSteamSGOId(entity.getGovSteamSGOId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteamSGO." );

			// for use later on...
			govSteamSGOId = entity.getGovSteamSGOId();

			GovSteamSGOBusinessDelegate proxy = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance();  

			proxy.updateGovSteamSGO( command ).get();

			LOGGER.info( "-- Successfully saved GovSteamSGO - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteamSGOId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteamSGO.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteamSGO." );

		GovSteamSGO entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteamSGO with id " + govSteamSGOId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteamSGO with id " + govSteamSGOId );

			throw e;
		}

		try{
			GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().delete( new DeleteGovSteamSGOCommand( entity.getGovSteamSGOId() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteamSGO with id " + govSteamSGOId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteamSGO with id " + govSteamSGOId );

			throw e;
		}
	}

	/**
	 * get all GovSteamSGOs.
	 */
	protected List<GovSteamSGO> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteamSGOs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteamSGO : " );        
		List<GovSteamSGO> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteamSGOBusinessDelegate
			collection = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().getAllGovSteamSGO();
			assertNotNull( collection, "An Empty collection of GovSteamSGO was incorrectly returned.");
			
			// Now print out the values
			GovSteamSGO entity = null;            
			Iterator<GovSteamSGO> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteamSGOId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteamSGOTest
	 */
	protected GovSteamSGOTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteamSGO
	 * 
	 * @return CreateGovSteamSGOCommand alias
	 */
	protected CreateGovSteamSGOCommand generateNewCommand() {
        CreateGovSteamSGOCommand command = new CreateGovSteamSGOCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteamSGO
		 * 
		 * @return UpdateGovSteamSGOCommand alias
		 */
	protected UpdateGovSteamSGOCommand generateUpdateCommand() {
	        UpdateGovSteamSGOCommand command = new UpdateGovSteamSGOCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteamSGOId = null;
	protected GovSteamSGOSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteamSGOTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteamSGOList = 0;
}
