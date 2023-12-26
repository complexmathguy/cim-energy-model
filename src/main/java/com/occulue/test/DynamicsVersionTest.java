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
 * Test DynamicsVersion class.
 *
 * @author your_name_here
 */
public class DynamicsVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DynamicsVersionTest() {
		subscriber = new DynamicsVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DynamicsVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DynamicsVersion...");
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
	 * jumpstart the process by instantiating2 DynamicsVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dynamicsVersionId = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
		.createDynamicsVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
				.createDynamicsVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dynamicsVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DynamicsVersion : " + successValue.getDynamicsVersionId());
							  if (successValue.getDynamicsVersionId().equals(dynamicsVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDynamicsVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DynamicsVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsVersion consumed")
					);
			subscriber.dynamicsVersionSubscribe( dynamicsVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DynamicsVersion : " + successValue.getDynamicsVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDynamicsVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsVersion for dynamicsVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DynamicsVersion. 
	 */
	protected DynamicsVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DynamicsVersion" );

		DynamicsVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DynamicsVersion with primary key" );
		msg.append( dynamicsVersionId );
		
		DynamicsVersionFetchOneSummary fetchOneSummary = new DynamicsVersionFetchOneSummary( dynamicsVersionId );

		try {
			entity = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().getDynamicsVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DynamicsVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DynamicsVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DynamicsVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a DynamicsVersion : " );        
		DynamicsVersion entity = read();
		UpdateDynamicsVersionCommand command = generateUpdateCommand();
		command.setDynamicsVersionId(entity.getDynamicsVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DynamicsVersion." );

			// for use later on...
			dynamicsVersionId = entity.getDynamicsVersionId();

			DynamicsVersionBusinessDelegate proxy = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();  

			proxy.updateDynamicsVersion( command ).get();

			LOGGER.info( "-- Successfully saved DynamicsVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dynamicsVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DynamicsVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DynamicsVersion." );

		DynamicsVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DynamicsVersion with id " + dynamicsVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DynamicsVersion with id " + dynamicsVersionId );

			throw e;
		}

		try{
			DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().delete( new DeleteDynamicsVersionCommand( entity.getDynamicsVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted DynamicsVersion with id " + dynamicsVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DynamicsVersion with id " + dynamicsVersionId );

			throw e;
		}
	}

	/**
	 * get all DynamicsVersions.
	 */
	protected List<DynamicsVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DynamicsVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DynamicsVersion : " );        
		List<DynamicsVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the DynamicsVersionBusinessDelegate
			collection = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().getAllDynamicsVersion();
			assertNotNull( collection, "An Empty collection of DynamicsVersion was incorrectly returned.");
			
			// Now print out the values
			DynamicsVersion entity = null;            
			Iterator<DynamicsVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDynamicsVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DynamicsVersionTest
	 */
	protected DynamicsVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DynamicsVersion
	 * 
	 * @return CreateDynamicsVersionCommand alias
	 */
	protected CreateDynamicsVersionCommand generateNewCommand() {
        CreateDynamicsVersionCommand command = new CreateDynamicsVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DynamicsVersion
		 * 
		 * @return UpdateDynamicsVersionCommand alias
		 */
	protected UpdateDynamicsVersionCommand generateUpdateCommand() {
	        UpdateDynamicsVersionCommand command = new UpdateDynamicsVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dynamicsVersionId = null;
	protected DynamicsVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DynamicsVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDynamicsVersionList = 0;
}
