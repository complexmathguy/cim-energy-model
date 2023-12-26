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
 * Test DomainVersion class.
 *
 * @author your_name_here
 */
public class DomainVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DomainVersionTest() {
		subscriber = new DomainVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DomainVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DomainVersion...");
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
	 * jumpstart the process by instantiating2 DomainVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		domainVersionId = DomainVersionBusinessDelegate.getDomainVersionInstance()
		.createDomainVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DomainVersionBusinessDelegate.getDomainVersionInstance()
				.createDomainVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.domainVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DomainVersion : " + successValue.getDomainVersionId());
							  if (successValue.getDomainVersionId().equals(domainVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDomainVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DomainVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on domainVersion consumed")
					);
			subscriber.domainVersionSubscribe( domainVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DomainVersion : " + successValue.getDomainVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDomainVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on domainVersion for domainVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DomainVersion. 
	 */
	protected DomainVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DomainVersion" );

		DomainVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DomainVersion with primary key" );
		msg.append( domainVersionId );
		
		DomainVersionFetchOneSummary fetchOneSummary = new DomainVersionFetchOneSummary( domainVersionId );

		try {
			entity = DomainVersionBusinessDelegate.getDomainVersionInstance().getDomainVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DomainVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DomainVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DomainVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a DomainVersion : " );        
		DomainVersion entity = read();
		UpdateDomainVersionCommand command = generateUpdateCommand();
		command.setDomainVersionId(entity.getDomainVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DomainVersion." );

			// for use later on...
			domainVersionId = entity.getDomainVersionId();

			DomainVersionBusinessDelegate proxy = DomainVersionBusinessDelegate.getDomainVersionInstance();  

			proxy.updateDomainVersion( command ).get();

			LOGGER.info( "-- Successfully saved DomainVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + domainVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DomainVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DomainVersion." );

		DomainVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DomainVersion with id " + domainVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DomainVersion with id " + domainVersionId );

			throw e;
		}

		try{
			DomainVersionBusinessDelegate.getDomainVersionInstance().delete( new DeleteDomainVersionCommand( entity.getDomainVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted DomainVersion with id " + domainVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DomainVersion with id " + domainVersionId );

			throw e;
		}
	}

	/**
	 * get all DomainVersions.
	 */
	protected List<DomainVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DomainVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DomainVersion : " );        
		List<DomainVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the DomainVersionBusinessDelegate
			collection = DomainVersionBusinessDelegate.getDomainVersionInstance().getAllDomainVersion();
			assertNotNull( collection, "An Empty collection of DomainVersion was incorrectly returned.");
			
			// Now print out the values
			DomainVersion entity = null;            
			Iterator<DomainVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDomainVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DomainVersionTest
	 */
	protected DomainVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DomainVersion
	 * 
	 * @return CreateDomainVersionCommand alias
	 */
	protected CreateDomainVersionCommand generateNewCommand() {
        CreateDomainVersionCommand command = new CreateDomainVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DomainVersion
		 * 
		 * @return UpdateDomainVersionCommand alias
		 */
	protected UpdateDomainVersionCommand generateUpdateCommand() {
	        UpdateDomainVersionCommand command = new UpdateDomainVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID domainVersionId = null;
	protected DomainVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DomainVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDomainVersionList = 0;
}
