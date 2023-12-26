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
 * Test SteadyStateHypothesisVersion class.
 *
 * @author your_name_here
 */
public class SteadyStateHypothesisVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SteadyStateHypothesisVersionTest() {
		subscriber = new SteadyStateHypothesisVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SteadyStateHypothesisVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SteadyStateHypothesisVersion...");
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
	 * jumpstart the process by instantiating2 SteadyStateHypothesisVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		steadyStateHypothesisVersionId = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
		.createSteadyStateHypothesisVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
				.createSteadyStateHypothesisVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.steadyStateHypothesisVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SteadyStateHypothesisVersion : " + successValue.getSteadyStateHypothesisVersionId());
							  if (successValue.getSteadyStateHypothesisVersionId().equals(steadyStateHypothesisVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSteadyStateHypothesisVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SteadyStateHypothesisVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on steadyStateHypothesisVersion consumed")
					);
			subscriber.steadyStateHypothesisVersionSubscribe( steadyStateHypothesisVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SteadyStateHypothesisVersion : " + successValue.getSteadyStateHypothesisVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSteadyStateHypothesisVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on steadyStateHypothesisVersion for steadyStateHypothesisVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SteadyStateHypothesisVersion. 
	 */
	protected SteadyStateHypothesisVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SteadyStateHypothesisVersion" );

		SteadyStateHypothesisVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SteadyStateHypothesisVersion with primary key" );
		msg.append( steadyStateHypothesisVersionId );
		
		SteadyStateHypothesisVersionFetchOneSummary fetchOneSummary = new SteadyStateHypothesisVersionFetchOneSummary( steadyStateHypothesisVersionId );

		try {
			entity = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().getSteadyStateHypothesisVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SteadyStateHypothesisVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SteadyStateHypothesisVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SteadyStateHypothesisVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a SteadyStateHypothesisVersion : " );        
		SteadyStateHypothesisVersion entity = read();
		UpdateSteadyStateHypothesisVersionCommand command = generateUpdateCommand();
		command.setSteadyStateHypothesisVersionId(entity.getSteadyStateHypothesisVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SteadyStateHypothesisVersion." );

			// for use later on...
			steadyStateHypothesisVersionId = entity.getSteadyStateHypothesisVersionId();

			SteadyStateHypothesisVersionBusinessDelegate proxy = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();  

			proxy.updateSteadyStateHypothesisVersion( command ).get();

			LOGGER.info( "-- Successfully saved SteadyStateHypothesisVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + steadyStateHypothesisVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SteadyStateHypothesisVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SteadyStateHypothesisVersion." );

		SteadyStateHypothesisVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SteadyStateHypothesisVersion with id " + steadyStateHypothesisVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SteadyStateHypothesisVersion with id " + steadyStateHypothesisVersionId );

			throw e;
		}

		try{
			SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().delete( new DeleteSteadyStateHypothesisVersionCommand( entity.getSteadyStateHypothesisVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted SteadyStateHypothesisVersion with id " + steadyStateHypothesisVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SteadyStateHypothesisVersion with id " + steadyStateHypothesisVersionId );

			throw e;
		}
	}

	/**
	 * get all SteadyStateHypothesisVersions.
	 */
	protected List<SteadyStateHypothesisVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SteadyStateHypothesisVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SteadyStateHypothesisVersion : " );        
		List<SteadyStateHypothesisVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the SteadyStateHypothesisVersionBusinessDelegate
			collection = SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance().getAllSteadyStateHypothesisVersion();
			assertNotNull( collection, "An Empty collection of SteadyStateHypothesisVersion was incorrectly returned.");
			
			// Now print out the values
			SteadyStateHypothesisVersion entity = null;            
			Iterator<SteadyStateHypothesisVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSteadyStateHypothesisVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SteadyStateHypothesisVersionTest
	 */
	protected SteadyStateHypothesisVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SteadyStateHypothesisVersion
	 * 
	 * @return CreateSteadyStateHypothesisVersionCommand alias
	 */
	protected CreateSteadyStateHypothesisVersionCommand generateNewCommand() {
        CreateSteadyStateHypothesisVersionCommand command = new CreateSteadyStateHypothesisVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SteadyStateHypothesisVersion
		 * 
		 * @return UpdateSteadyStateHypothesisVersionCommand alias
		 */
	protected UpdateSteadyStateHypothesisVersionCommand generateUpdateCommand() {
	        UpdateSteadyStateHypothesisVersionCommand command = new UpdateSteadyStateHypothesisVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID steadyStateHypothesisVersionId = null;
	protected SteadyStateHypothesisVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SteadyStateHypothesisVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSteadyStateHypothesisVersionList = 0;
}
