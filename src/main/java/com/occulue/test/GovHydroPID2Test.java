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
 * Test GovHydroPID2 class.
 *
 * @author your_name_here
 */
public class GovHydroPID2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovHydroPID2Test() {
		subscriber = new GovHydroPID2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovHydroPID2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovHydroPID2...");
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
	 * jumpstart the process by instantiating2 GovHydroPID2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govHydroPID2Id = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance()
		.createGovHydroPID2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovHydroPID2BusinessDelegate.getGovHydroPID2Instance()
				.createGovHydroPID2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govHydroPID2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovHydroPID2 : " + successValue.getGovHydroPID2Id());
							  if (successValue.getGovHydroPID2Id().equals(govHydroPID2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovHydroPID2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovHydroPID2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroPID2 consumed")
					);
			subscriber.govHydroPID2Subscribe( govHydroPID2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovHydroPID2 : " + successValue.getGovHydroPID2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovHydroPID2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroPID2 for govHydroPID2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovHydroPID2. 
	 */
	protected GovHydroPID2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovHydroPID2" );

		GovHydroPID2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovHydroPID2 with primary key" );
		msg.append( govHydroPID2Id );
		
		GovHydroPID2FetchOneSummary fetchOneSummary = new GovHydroPID2FetchOneSummary( govHydroPID2Id );

		try {
			entity = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().getGovHydroPID2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovHydroPID2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovHydroPID2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovHydroPID2." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovHydroPID2 : " );        
		GovHydroPID2 entity = read();
		UpdateGovHydroPID2Command command = generateUpdateCommand();
		command.setGovHydroPID2Id(entity.getGovHydroPID2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovHydroPID2." );

			// for use later on...
			govHydroPID2Id = entity.getGovHydroPID2Id();

			GovHydroPID2BusinessDelegate proxy = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance();  

			proxy.updateGovHydroPID2( command ).get();

			LOGGER.info( "-- Successfully saved GovHydroPID2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govHydroPID2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovHydroPID2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovHydroPID2." );

		GovHydroPID2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovHydroPID2 with id " + govHydroPID2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovHydroPID2 with id " + govHydroPID2Id );

			throw e;
		}

		try{
			GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().delete( new DeleteGovHydroPID2Command( entity.getGovHydroPID2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovHydroPID2 with id " + govHydroPID2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovHydroPID2 with id " + govHydroPID2Id );

			throw e;
		}
	}

	/**
	 * get all GovHydroPID2s.
	 */
	protected List<GovHydroPID2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovHydroPID2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovHydroPID2 : " );        
		List<GovHydroPID2> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovHydroPID2BusinessDelegate
			collection = GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().getAllGovHydroPID2();
			assertNotNull( collection, "An Empty collection of GovHydroPID2 was incorrectly returned.");
			
			// Now print out the values
			GovHydroPID2 entity = null;            
			Iterator<GovHydroPID2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovHydroPID2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovHydroPID2Test
	 */
	protected GovHydroPID2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovHydroPID2
	 * 
	 * @return CreateGovHydroPID2Command alias
	 */
	protected CreateGovHydroPID2Command generateNewCommand() {
        CreateGovHydroPID2Command command = new CreateGovHydroPID2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovHydroPID2
		 * 
		 * @return UpdateGovHydroPID2Command alias
		 */
	protected UpdateGovHydroPID2Command generateUpdateCommand() {
	        UpdateGovHydroPID2Command command = new UpdateGovHydroPID2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govHydroPID2Id = null;
	protected GovHydroPID2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovHydroPID2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovHydroPID2List = 0;
}
