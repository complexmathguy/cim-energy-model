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
 * Test ExtensionVersion class.
 *
 * @author your_name_here
 */
public class ExtensionVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExtensionVersionTest() {
		subscriber = new ExtensionVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExtensionVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExtensionVersion...");
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
	 * jumpstart the process by instantiating2 ExtensionVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		extensionVersionId = ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
		.createExtensionVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
				.createExtensionVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.extensionVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExtensionVersion : " + successValue.getExtensionVersionId());
							  if (successValue.getExtensionVersionId().equals(extensionVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExtensionVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExtensionVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on extensionVersion consumed")
					);
			subscriber.extensionVersionSubscribe( extensionVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExtensionVersion : " + successValue.getExtensionVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExtensionVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on extensionVersion for extensionVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExtensionVersion. 
	 */
	protected ExtensionVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExtensionVersion" );

		ExtensionVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExtensionVersion with primary key" );
		msg.append( extensionVersionId );
		
		ExtensionVersionFetchOneSummary fetchOneSummary = new ExtensionVersionFetchOneSummary( extensionVersionId );

		try {
			entity = ExtensionVersionBusinessDelegate.getExtensionVersionInstance().getExtensionVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExtensionVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExtensionVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExtensionVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExtensionVersion : " );        
		ExtensionVersion entity = read();
		UpdateExtensionVersionCommand command = generateUpdateCommand();
		command.setExtensionVersionId(entity.getExtensionVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExtensionVersion." );

			// for use later on...
			extensionVersionId = entity.getExtensionVersionId();

			ExtensionVersionBusinessDelegate proxy = ExtensionVersionBusinessDelegate.getExtensionVersionInstance();  

			proxy.updateExtensionVersion( command ).get();

			LOGGER.info( "-- Successfully saved ExtensionVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + extensionVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExtensionVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExtensionVersion." );

		ExtensionVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExtensionVersion with id " + extensionVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExtensionVersion with id " + extensionVersionId );

			throw e;
		}

		try{
			ExtensionVersionBusinessDelegate.getExtensionVersionInstance().delete( new DeleteExtensionVersionCommand( entity.getExtensionVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExtensionVersion with id " + extensionVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExtensionVersion with id " + extensionVersionId );

			throw e;
		}
	}

	/**
	 * get all ExtensionVersions.
	 */
	protected List<ExtensionVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExtensionVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExtensionVersion : " );        
		List<ExtensionVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExtensionVersionBusinessDelegate
			collection = ExtensionVersionBusinessDelegate.getExtensionVersionInstance().getAllExtensionVersion();
			assertNotNull( collection, "An Empty collection of ExtensionVersion was incorrectly returned.");
			
			// Now print out the values
			ExtensionVersion entity = null;            
			Iterator<ExtensionVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExtensionVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExtensionVersionTest
	 */
	protected ExtensionVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExtensionVersion
	 * 
	 * @return CreateExtensionVersionCommand alias
	 */
	protected CreateExtensionVersionCommand generateNewCommand() {
        CreateExtensionVersionCommand command = new CreateExtensionVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExtensionVersion
		 * 
		 * @return UpdateExtensionVersionCommand alias
		 */
	protected UpdateExtensionVersionCommand generateUpdateCommand() {
	        UpdateExtensionVersionCommand command = new UpdateExtensionVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID extensionVersionId = null;
	protected ExtensionVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExtensionVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExtensionVersionList = 0;
}
