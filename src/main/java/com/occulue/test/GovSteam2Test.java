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
 * Test GovSteam2 class.
 *
 * @author your_name_here
 */
public class GovSteam2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovSteam2Test() {
		subscriber = new GovSteam2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovSteam2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovSteam2...");
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
	 * jumpstart the process by instantiating2 GovSteam2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govSteam2Id = GovSteam2BusinessDelegate.getGovSteam2Instance()
		.createGovSteam2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovSteam2BusinessDelegate.getGovSteam2Instance()
				.createGovSteam2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govSteam2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovSteam2 : " + successValue.getGovSteam2Id());
							  if (successValue.getGovSteam2Id().equals(govSteam2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovSteam2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovSteam2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteam2 consumed")
					);
			subscriber.govSteam2Subscribe( govSteam2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovSteam2 : " + successValue.getGovSteam2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovSteam2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govSteam2 for govSteam2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovSteam2. 
	 */
	protected GovSteam2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovSteam2" );

		GovSteam2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovSteam2 with primary key" );
		msg.append( govSteam2Id );
		
		GovSteam2FetchOneSummary fetchOneSummary = new GovSteam2FetchOneSummary( govSteam2Id );

		try {
			entity = GovSteam2BusinessDelegate.getGovSteam2Instance().getGovSteam2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovSteam2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovSteam2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovSteam2." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovSteam2 : " );        
		GovSteam2 entity = read();
		UpdateGovSteam2Command command = generateUpdateCommand();
		command.setGovSteam2Id(entity.getGovSteam2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovSteam2." );

			// for use later on...
			govSteam2Id = entity.getGovSteam2Id();

			GovSteam2BusinessDelegate proxy = GovSteam2BusinessDelegate.getGovSteam2Instance();  

			proxy.updateGovSteam2( command ).get();

			LOGGER.info( "-- Successfully saved GovSteam2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govSteam2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovSteam2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovSteam2." );

		GovSteam2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovSteam2 with id " + govSteam2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovSteam2 with id " + govSteam2Id );

			throw e;
		}

		try{
			GovSteam2BusinessDelegate.getGovSteam2Instance().delete( new DeleteGovSteam2Command( entity.getGovSteam2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovSteam2 with id " + govSteam2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovSteam2 with id " + govSteam2Id );

			throw e;
		}
	}

	/**
	 * get all GovSteam2s.
	 */
	protected List<GovSteam2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovSteam2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovSteam2 : " );        
		List<GovSteam2> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovSteam2BusinessDelegate
			collection = GovSteam2BusinessDelegate.getGovSteam2Instance().getAllGovSteam2();
			assertNotNull( collection, "An Empty collection of GovSteam2 was incorrectly returned.");
			
			// Now print out the values
			GovSteam2 entity = null;            
			Iterator<GovSteam2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovSteam2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovSteam2Test
	 */
	protected GovSteam2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovSteam2
	 * 
	 * @return CreateGovSteam2Command alias
	 */
	protected CreateGovSteam2Command generateNewCommand() {
        CreateGovSteam2Command command = new CreateGovSteam2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovSteam2
		 * 
		 * @return UpdateGovSteam2Command alias
		 */
	protected UpdateGovSteam2Command generateUpdateCommand() {
	        UpdateGovSteam2Command command = new UpdateGovSteam2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govSteam2Id = null;
	protected GovSteam2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovSteam2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovSteam2List = 0;
}
