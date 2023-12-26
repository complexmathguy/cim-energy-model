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
 * Test GovSteamIEEE1 class.
 *
 * @author your_name_here
 */
public class GovSteamIEEE1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteamIEEE1Test() {
		subscriber = new GovSteamIEEE1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteamIEEE1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteamIEEE1...");
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
	 * jumpstart the process by instantiating2 GovSteamIEEE1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteamIEEE1Id = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance()
		.createGovSteamIEEE1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance()
				.createGovSteamIEEE1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteamIEEE1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteamIEEE1 : " + successValue.getGovSteamIEEE1Id());
							  if (successValue.getGovSteamIEEE1Id().equals(govSteamIEEE1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteamIEEE1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteamIEEE1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamIEEE1 consumed")
					);
			subscriber.govSteamIEEE1Subscribe( govSteamIEEE1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteamIEEE1 : " + successValue.getGovSteamIEEE1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteamIEEE1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteamIEEE1 for govSteamIEEE1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteamIEEE1. 
	 */
	protected GovSteamIEEE1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteamIEEE1" );

		GovSteamIEEE1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteamIEEE1 with primary key" );
		msg.append( govSteamIEEE1Id );
		
		GovSteamIEEE1FetchOneSummary fetchOneSummary = new GovSteamIEEE1FetchOneSummary( govSteamIEEE1Id );

		try {
			entity = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().getGovSteamIEEE1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteamIEEE1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteamIEEE1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteamIEEE1." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteamIEEE1 : " );        
		GovSteamIEEE1 entity = read();
		UpdateGovSteamIEEE1Command command = generateUpdateCommand();
		command.setGovSteamIEEE1Id(entity.getGovSteamIEEE1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteamIEEE1." );

			// for use later on...
			govSteamIEEE1Id = entity.getGovSteamIEEE1Id();

			GovSteamIEEE1BusinessDelegate proxy = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance();  

			proxy.updateGovSteamIEEE1( command ).get();

			LOGGER.info( "-- Successfully saved GovSteamIEEE1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteamIEEE1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteamIEEE1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteamIEEE1." );

		GovSteamIEEE1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteamIEEE1 with id " + govSteamIEEE1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteamIEEE1 with id " + govSteamIEEE1Id );

			throw e;
		}

		try{
			GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().delete( new DeleteGovSteamIEEE1Command( entity.getGovSteamIEEE1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteamIEEE1 with id " + govSteamIEEE1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteamIEEE1 with id " + govSteamIEEE1Id );

			throw e;
		}
	}

	/**
	 * get all GovSteamIEEE1s.
	 */
	protected List<GovSteamIEEE1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteamIEEE1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteamIEEE1 : " );        
		List<GovSteamIEEE1> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteamIEEE1BusinessDelegate
			collection = GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().getAllGovSteamIEEE1();
			assertNotNull( collection, "An Empty collection of GovSteamIEEE1 was incorrectly returned.");
			
			// Now print out the values
			GovSteamIEEE1 entity = null;            
			Iterator<GovSteamIEEE1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteamIEEE1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteamIEEE1Test
	 */
	protected GovSteamIEEE1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteamIEEE1
	 * 
	 * @return CreateGovSteamIEEE1Command alias
	 */
	protected CreateGovSteamIEEE1Command generateNewCommand() {
        CreateGovSteamIEEE1Command command = new CreateGovSteamIEEE1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteamIEEE1
		 * 
		 * @return UpdateGovSteamIEEE1Command alias
		 */
	protected UpdateGovSteamIEEE1Command generateUpdateCommand() {
	        UpdateGovSteamIEEE1Command command = new UpdateGovSteamIEEE1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteamIEEE1Id = null;
	protected GovSteamIEEE1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteamIEEE1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteamIEEE1List = 0;
}
