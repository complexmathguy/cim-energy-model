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
 * Test GeographicalLocationVersion class.
 *
 * @author your_name_here
 */
public class GeographicalLocationVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GeographicalLocationVersionTest() {
		subscriber = new GeographicalLocationVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GeographicalLocationVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GeographicalLocationVersion...");
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
	 * jumpstart the process by instantiating2 GeographicalLocationVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		geographicalLocationVersionId = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
		.createGeographicalLocationVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
				.createGeographicalLocationVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.geographicalLocationVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GeographicalLocationVersion : " + successValue.getGeographicalLocationVersionId());
							  if (successValue.getGeographicalLocationVersionId().equals(geographicalLocationVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGeographicalLocationVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GeographicalLocationVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on geographicalLocationVersion consumed")
					);
			subscriber.geographicalLocationVersionSubscribe( geographicalLocationVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GeographicalLocationVersion : " + successValue.getGeographicalLocationVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGeographicalLocationVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on geographicalLocationVersion for geographicalLocationVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GeographicalLocationVersion. 
	 */
	protected GeographicalLocationVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GeographicalLocationVersion" );

		GeographicalLocationVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GeographicalLocationVersion with primary key" );
		msg.append( geographicalLocationVersionId );
		
		GeographicalLocationVersionFetchOneSummary fetchOneSummary = new GeographicalLocationVersionFetchOneSummary( geographicalLocationVersionId );

		try {
			entity = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().getGeographicalLocationVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GeographicalLocationVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GeographicalLocationVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GeographicalLocationVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a GeographicalLocationVersion : " );        
		GeographicalLocationVersion entity = read();
		UpdateGeographicalLocationVersionCommand command = generateUpdateCommand();
		command.setGeographicalLocationVersionId(entity.getGeographicalLocationVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GeographicalLocationVersion." );

			// for use later on...
			geographicalLocationVersionId = entity.getGeographicalLocationVersionId();

			GeographicalLocationVersionBusinessDelegate proxy = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();  

			proxy.updateGeographicalLocationVersion( command ).get();

			LOGGER.info( "-- Successfully saved GeographicalLocationVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + geographicalLocationVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GeographicalLocationVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GeographicalLocationVersion." );

		GeographicalLocationVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GeographicalLocationVersion with id " + geographicalLocationVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GeographicalLocationVersion with id " + geographicalLocationVersionId );

			throw e;
		}

		try{
			GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().delete( new DeleteGeographicalLocationVersionCommand( entity.getGeographicalLocationVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted GeographicalLocationVersion with id " + geographicalLocationVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GeographicalLocationVersion with id " + geographicalLocationVersionId );

			throw e;
		}
	}

	/**
	 * get all GeographicalLocationVersions.
	 */
	protected List<GeographicalLocationVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GeographicalLocationVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GeographicalLocationVersion : " );        
		List<GeographicalLocationVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the GeographicalLocationVersionBusinessDelegate
			collection = GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance().getAllGeographicalLocationVersion();
			assertNotNull( collection, "An Empty collection of GeographicalLocationVersion was incorrectly returned.");
			
			// Now print out the values
			GeographicalLocationVersion entity = null;            
			Iterator<GeographicalLocationVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGeographicalLocationVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GeographicalLocationVersionTest
	 */
	protected GeographicalLocationVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GeographicalLocationVersion
	 * 
	 * @return CreateGeographicalLocationVersionCommand alias
	 */
	protected CreateGeographicalLocationVersionCommand generateNewCommand() {
        CreateGeographicalLocationVersionCommand command = new CreateGeographicalLocationVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GeographicalLocationVersion
		 * 
		 * @return UpdateGeographicalLocationVersionCommand alias
		 */
	protected UpdateGeographicalLocationVersionCommand generateUpdateCommand() {
	        UpdateGeographicalLocationVersionCommand command = new UpdateGeographicalLocationVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID geographicalLocationVersionId = null;
	protected GeographicalLocationVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GeographicalLocationVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGeographicalLocationVersionList = 0;
}
