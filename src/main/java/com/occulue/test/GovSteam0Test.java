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
 * Test GovSteam0 class.
 *
 * @author your_name_here
 */
public class GovSteam0Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteam0Test() {
		subscriber = new GovSteam0Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteam0Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteam0...");
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
	 * jumpstart the process by instantiating2 GovSteam0
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteam0Id = GovSteam0BusinessDelegate.getGovSteam0Instance()
		.createGovSteam0( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteam0BusinessDelegate.getGovSteam0Instance()
				.createGovSteam0( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteam0Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteam0 : " + successValue.getGovSteam0Id());
							  if (successValue.getGovSteam0Id().equals(govSteam0Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteam0List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteam0 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteam0 consumed")
					);
			subscriber.govSteam0Subscribe( govSteam0Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteam0 : " + successValue.getGovSteam0Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteam0List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteam0 for govSteam0Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteam0. 
	 */
	protected GovSteam0 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteam0" );

		GovSteam0 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteam0 with primary key" );
		msg.append( govSteam0Id );
		
		GovSteam0FetchOneSummary fetchOneSummary = new GovSteam0FetchOneSummary( govSteam0Id );

		try {
			entity = GovSteam0BusinessDelegate.getGovSteam0Instance().getGovSteam0( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteam0 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteam0.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteam0." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteam0 : " );        
		GovSteam0 entity = read();
		UpdateGovSteam0Command command = generateUpdateCommand();
		command.setGovSteam0Id(entity.getGovSteam0Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteam0." );

			// for use later on...
			govSteam0Id = entity.getGovSteam0Id();

			GovSteam0BusinessDelegate proxy = GovSteam0BusinessDelegate.getGovSteam0Instance();  

			proxy.updateGovSteam0( command ).get();

			LOGGER.info( "-- Successfully saved GovSteam0 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteam0Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteam0.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteam0." );

		GovSteam0 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteam0 with id " + govSteam0Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteam0 with id " + govSteam0Id );

			throw e;
		}

		try{
			GovSteam0BusinessDelegate.getGovSteam0Instance().delete( new DeleteGovSteam0Command( entity.getGovSteam0Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteam0 with id " + govSteam0Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteam0 with id " + govSteam0Id );

			throw e;
		}
	}

	/**
	 * get all GovSteam0s.
	 */
	protected List<GovSteam0> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteam0s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteam0 : " );        
		List<GovSteam0> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteam0BusinessDelegate
			collection = GovSteam0BusinessDelegate.getGovSteam0Instance().getAllGovSteam0();
			assertNotNull( collection, "An Empty collection of GovSteam0 was incorrectly returned.");
			
			// Now print out the values
			GovSteam0 entity = null;            
			Iterator<GovSteam0> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteam0Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteam0Test
	 */
	protected GovSteam0Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteam0
	 * 
	 * @return CreateGovSteam0Command alias
	 */
	protected CreateGovSteam0Command generateNewCommand() {
        CreateGovSteam0Command command = new CreateGovSteam0Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteam0
		 * 
		 * @return UpdateGovSteam0Command alias
		 */
	protected UpdateGovSteam0Command generateUpdateCommand() {
	        UpdateGovSteam0Command command = new UpdateGovSteam0Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteam0Id = null;
	protected GovSteam0Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteam0Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteam0List = 0;
}
