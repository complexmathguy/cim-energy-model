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
 * Test GovSteamFV2 class.
 *
 * @author your_name_here
 */
public class GovSteamFV2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteamFV2Test() {
		subscriber = new GovSteamFV2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteamFV2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteamFV2...");
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
	 * jumpstart the process by instantiating2 GovSteamFV2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteamFV2Id = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance()
		.createGovSteamFV2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteamFV2BusinessDelegate.getGovSteamFV2Instance()
				.createGovSteamFV2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteamFV2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteamFV2 : " + successValue.getGovSteamFV2Id());
							  if (successValue.getGovSteamFV2Id().equals(govSteamFV2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteamFV2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteamFV2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamFV2 consumed")
					);
			subscriber.govSteamFV2Subscribe( govSteamFV2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteamFV2 : " + successValue.getGovSteamFV2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteamFV2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamFV2 for govSteamFV2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteamFV2. 
	 */
	protected GovSteamFV2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteamFV2" );

		GovSteamFV2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteamFV2 with primary key" );
		msg.append( govSteamFV2Id );
		
		GovSteamFV2FetchOneSummary fetchOneSummary = new GovSteamFV2FetchOneSummary( govSteamFV2Id );

		try {
			entity = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().getGovSteamFV2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteamFV2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteamFV2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteamFV2." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteamFV2 : " );        
		GovSteamFV2 entity = read();
		UpdateGovSteamFV2Command command = generateUpdateCommand();
		command.setGovSteamFV2Id(entity.getGovSteamFV2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteamFV2." );

			// for use later on...
			govSteamFV2Id = entity.getGovSteamFV2Id();

			GovSteamFV2BusinessDelegate proxy = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance();  

			proxy.updateGovSteamFV2( command ).get();

			LOGGER.info( "-- Successfully saved GovSteamFV2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteamFV2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteamFV2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteamFV2." );

		GovSteamFV2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteamFV2 with id " + govSteamFV2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteamFV2 with id " + govSteamFV2Id );

			throw e;
		}

		try{
			GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().delete( new DeleteGovSteamFV2Command( entity.getGovSteamFV2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteamFV2 with id " + govSteamFV2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteamFV2 with id " + govSteamFV2Id );

			throw e;
		}
	}

	/**
	 * get all GovSteamFV2s.
	 */
	protected List<GovSteamFV2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteamFV2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteamFV2 : " );        
		List<GovSteamFV2> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteamFV2BusinessDelegate
			collection = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().getAllGovSteamFV2();
			assertNotNull( collection, "An Empty collection of GovSteamFV2 was incorrectly returned.");
			
			// Now print out the values
			GovSteamFV2 entity = null;            
			Iterator<GovSteamFV2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteamFV2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteamFV2Test
	 */
	protected GovSteamFV2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteamFV2
	 * 
	 * @return CreateGovSteamFV2Command alias
	 */
	protected CreateGovSteamFV2Command generateNewCommand() {
        CreateGovSteamFV2Command command = new CreateGovSteamFV2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteamFV2
		 * 
		 * @return UpdateGovSteamFV2Command alias
		 */
	protected UpdateGovSteamFV2Command generateUpdateCommand() {
	        UpdateGovSteamFV2Command command = new UpdateGovSteamFV2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteamFV2Id = null;
	protected GovSteamFV2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteamFV2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteamFV2List = 0;
}
