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
 * Test GovHydroPelton class.
 *
 * @author your_name_here
 */
public class GovHydroPeltonTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovHydroPeltonTest() {
		subscriber = new GovHydroPeltonSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovHydroPeltonTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovHydroPelton...");
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
	 * jumpstart the process by instantiating2 GovHydroPelton
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govHydroPeltonId = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
		.createGovHydroPelton( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
				.createGovHydroPelton( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govHydroPeltonSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovHydroPelton : " + successValue.getGovHydroPeltonId());
							  if (successValue.getGovHydroPeltonId().equals(govHydroPeltonId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovHydroPeltonList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovHydroPelton test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroPelton consumed")
					);
			subscriber.govHydroPeltonSubscribe( govHydroPeltonId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovHydroPelton : " + successValue.getGovHydroPeltonId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovHydroPeltonList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govHydroPelton for govHydroPeltonId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovHydroPelton. 
	 */
	protected GovHydroPelton read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovHydroPelton" );

		GovHydroPelton entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovHydroPelton with primary key" );
		msg.append( govHydroPeltonId );
		
		GovHydroPeltonFetchOneSummary fetchOneSummary = new GovHydroPeltonFetchOneSummary( govHydroPeltonId );

		try {
			entity = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().getGovHydroPelton( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovHydroPelton " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovHydroPelton.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovHydroPelton." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovHydroPelton : " );        
		GovHydroPelton entity = read();
		UpdateGovHydroPeltonCommand command = generateUpdateCommand();
		command.setGovHydroPeltonId(entity.getGovHydroPeltonId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovHydroPelton." );

			// for use later on...
			govHydroPeltonId = entity.getGovHydroPeltonId();

			GovHydroPeltonBusinessDelegate proxy = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();  

			proxy.updateGovHydroPelton( command ).get();

			LOGGER.info( "-- Successfully saved GovHydroPelton - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govHydroPeltonId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovHydroPelton.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovHydroPelton." );

		GovHydroPelton entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovHydroPelton with id " + govHydroPeltonId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovHydroPelton with id " + govHydroPeltonId );

			throw e;
		}

		try{
			GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().delete( new DeleteGovHydroPeltonCommand( entity.getGovHydroPeltonId() ) ).get();
			LOGGER.info( "-- Successfully deleted GovHydroPelton with id " + govHydroPeltonId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovHydroPelton with id " + govHydroPeltonId );

			throw e;
		}
	}

	/**
	 * get all GovHydroPeltons.
	 */
	protected List<GovHydroPelton> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovHydroPeltons:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovHydroPelton : " );        
		List<GovHydroPelton> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovHydroPeltonBusinessDelegate
			collection = GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().getAllGovHydroPelton();
			assertNotNull( collection, "An Empty collection of GovHydroPelton was incorrectly returned.");
			
			// Now print out the values
			GovHydroPelton entity = null;            
			Iterator<GovHydroPelton> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovHydroPeltonId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovHydroPeltonTest
	 */
	protected GovHydroPeltonTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovHydroPelton
	 * 
	 * @return CreateGovHydroPeltonCommand alias
	 */
	protected CreateGovHydroPeltonCommand generateNewCommand() {
        CreateGovHydroPeltonCommand command = new CreateGovHydroPeltonCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovHydroPelton
		 * 
		 * @return UpdateGovHydroPeltonCommand alias
		 */
	protected UpdateGovHydroPeltonCommand generateUpdateCommand() {
	        UpdateGovHydroPeltonCommand command = new UpdateGovHydroPeltonCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govHydroPeltonId = null;
	protected GovHydroPeltonSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovHydroPeltonTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovHydroPeltonList = 0;
}
