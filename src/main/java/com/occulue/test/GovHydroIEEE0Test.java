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
 * Test GovHydroIEEE0 class.
 *
 * @author your_name_here
 */
public class GovHydroIEEE0Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovHydroIEEE0Test() {
		subscriber = new GovHydroIEEE0Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovHydroIEEE0Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovHydroIEEE0...");
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
	 * jumpstart the process by instantiating2 GovHydroIEEE0
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govHydroIEEE0Id = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance()
		.createGovHydroIEEE0( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance()
				.createGovHydroIEEE0( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govHydroIEEE0Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovHydroIEEE0 : " + successValue.getGovHydroIEEE0Id());
							  if (successValue.getGovHydroIEEE0Id().equals(govHydroIEEE0Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovHydroIEEE0List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovHydroIEEE0 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroIEEE0 consumed")
					);
			subscriber.govHydroIEEE0Subscribe( govHydroIEEE0Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovHydroIEEE0 : " + successValue.getGovHydroIEEE0Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovHydroIEEE0List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroIEEE0 for govHydroIEEE0Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovHydroIEEE0. 
	 */
	protected GovHydroIEEE0 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovHydroIEEE0" );

		GovHydroIEEE0 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovHydroIEEE0 with primary key" );
		msg.append( govHydroIEEE0Id );
		
		GovHydroIEEE0FetchOneSummary fetchOneSummary = new GovHydroIEEE0FetchOneSummary( govHydroIEEE0Id );

		try {
			entity = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().getGovHydroIEEE0( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovHydroIEEE0 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovHydroIEEE0.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovHydroIEEE0." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovHydroIEEE0 : " );        
		GovHydroIEEE0 entity = read();
		UpdateGovHydroIEEE0Command command = generateUpdateCommand();
		command.setGovHydroIEEE0Id(entity.getGovHydroIEEE0Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovHydroIEEE0." );

			// for use later on...
			govHydroIEEE0Id = entity.getGovHydroIEEE0Id();

			GovHydroIEEE0BusinessDelegate proxy = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();  

			proxy.updateGovHydroIEEE0( command ).get();

			LOGGER.info( "-- Successfully saved GovHydroIEEE0 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govHydroIEEE0Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovHydroIEEE0.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovHydroIEEE0." );

		GovHydroIEEE0 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovHydroIEEE0 with id " + govHydroIEEE0Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovHydroIEEE0 with id " + govHydroIEEE0Id );

			throw e;
		}

		try{
			GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().delete( new DeleteGovHydroIEEE0Command( entity.getGovHydroIEEE0Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovHydroIEEE0 with id " + govHydroIEEE0Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovHydroIEEE0 with id " + govHydroIEEE0Id );

			throw e;
		}
	}

	/**
	 * get all GovHydroIEEE0s.
	 */
	protected List<GovHydroIEEE0> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovHydroIEEE0s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovHydroIEEE0 : " );        
		List<GovHydroIEEE0> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovHydroIEEE0BusinessDelegate
			collection = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().getAllGovHydroIEEE0();
			assertNotNull( collection, "An Empty collection of GovHydroIEEE0 was incorrectly returned.");
			
			// Now print out the values
			GovHydroIEEE0 entity = null;            
			Iterator<GovHydroIEEE0> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovHydroIEEE0Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovHydroIEEE0Test
	 */
	protected GovHydroIEEE0Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovHydroIEEE0
	 * 
	 * @return CreateGovHydroIEEE0Command alias
	 */
	protected CreateGovHydroIEEE0Command generateNewCommand() {
        CreateGovHydroIEEE0Command command = new CreateGovHydroIEEE0Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovHydroIEEE0
		 * 
		 * @return UpdateGovHydroIEEE0Command alias
		 */
	protected UpdateGovHydroIEEE0Command generateUpdateCommand() {
	        UpdateGovHydroIEEE0Command command = new UpdateGovHydroIEEE0Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govHydroIEEE0Id = null;
	protected GovHydroIEEE0Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovHydroIEEE0Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovHydroIEEE0List = 0;
}
