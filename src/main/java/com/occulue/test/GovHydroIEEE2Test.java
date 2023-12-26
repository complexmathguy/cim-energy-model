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
 * Test GovHydroIEEE2 class.
 *
 * @author your_name_here
 */
public class GovHydroIEEE2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovHydroIEEE2Test() {
		subscriber = new GovHydroIEEE2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovHydroIEEE2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovHydroIEEE2...");
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
	 * jumpstart the process by instantiating2 GovHydroIEEE2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govHydroIEEE2Id = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance()
		.createGovHydroIEEE2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance()
				.createGovHydroIEEE2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govHydroIEEE2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovHydroIEEE2 : " + successValue.getGovHydroIEEE2Id());
							  if (successValue.getGovHydroIEEE2Id().equals(govHydroIEEE2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovHydroIEEE2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovHydroIEEE2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroIEEE2 consumed")
					);
			subscriber.govHydroIEEE2Subscribe( govHydroIEEE2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovHydroIEEE2 : " + successValue.getGovHydroIEEE2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovHydroIEEE2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroIEEE2 for govHydroIEEE2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovHydroIEEE2. 
	 */
	protected GovHydroIEEE2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovHydroIEEE2" );

		GovHydroIEEE2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovHydroIEEE2 with primary key" );
		msg.append( govHydroIEEE2Id );
		
		GovHydroIEEE2FetchOneSummary fetchOneSummary = new GovHydroIEEE2FetchOneSummary( govHydroIEEE2Id );

		try {
			entity = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().getGovHydroIEEE2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovHydroIEEE2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovHydroIEEE2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovHydroIEEE2." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovHydroIEEE2 : " );        
		GovHydroIEEE2 entity = read();
		UpdateGovHydroIEEE2Command command = generateUpdateCommand();
		command.setGovHydroIEEE2Id(entity.getGovHydroIEEE2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovHydroIEEE2." );

			// for use later on...
			govHydroIEEE2Id = entity.getGovHydroIEEE2Id();

			GovHydroIEEE2BusinessDelegate proxy = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance();  

			proxy.updateGovHydroIEEE2( command ).get();

			LOGGER.info( "-- Successfully saved GovHydroIEEE2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govHydroIEEE2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovHydroIEEE2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovHydroIEEE2." );

		GovHydroIEEE2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovHydroIEEE2 with id " + govHydroIEEE2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovHydroIEEE2 with id " + govHydroIEEE2Id );

			throw e;
		}

		try{
			GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().delete( new DeleteGovHydroIEEE2Command( entity.getGovHydroIEEE2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovHydroIEEE2 with id " + govHydroIEEE2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovHydroIEEE2 with id " + govHydroIEEE2Id );

			throw e;
		}
	}

	/**
	 * get all GovHydroIEEE2s.
	 */
	protected List<GovHydroIEEE2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovHydroIEEE2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovHydroIEEE2 : " );        
		List<GovHydroIEEE2> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovHydroIEEE2BusinessDelegate
			collection = GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().getAllGovHydroIEEE2();
			assertNotNull( collection, "An Empty collection of GovHydroIEEE2 was incorrectly returned.");
			
			// Now print out the values
			GovHydroIEEE2 entity = null;            
			Iterator<GovHydroIEEE2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovHydroIEEE2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovHydroIEEE2Test
	 */
	protected GovHydroIEEE2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovHydroIEEE2
	 * 
	 * @return CreateGovHydroIEEE2Command alias
	 */
	protected CreateGovHydroIEEE2Command generateNewCommand() {
        CreateGovHydroIEEE2Command command = new CreateGovHydroIEEE2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovHydroIEEE2
		 * 
		 * @return UpdateGovHydroIEEE2Command alias
		 */
	protected UpdateGovHydroIEEE2Command generateUpdateCommand() {
	        UpdateGovHydroIEEE2Command command = new UpdateGovHydroIEEE2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govHydroIEEE2Id = null;
	protected GovHydroIEEE2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovHydroIEEE2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovHydroIEEE2List = 0;
}
