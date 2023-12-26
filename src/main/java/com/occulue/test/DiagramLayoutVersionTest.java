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
 * Test DiagramLayoutVersion class.
 *
 * @author your_name_here
 */
public class DiagramLayoutVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramLayoutVersionTest() {
		subscriber = new DiagramLayoutVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramLayoutVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramLayoutVersion...");
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
	 * jumpstart the process by instantiating2 DiagramLayoutVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramLayoutVersionId = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
		.createDiagramLayoutVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
				.createDiagramLayoutVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramLayoutVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramLayoutVersion : " + successValue.getDiagramLayoutVersionId());
							  if (successValue.getDiagramLayoutVersionId().equals(diagramLayoutVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramLayoutVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramLayoutVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramLayoutVersion consumed")
					);
			subscriber.diagramLayoutVersionSubscribe( diagramLayoutVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramLayoutVersion : " + successValue.getDiagramLayoutVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramLayoutVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramLayoutVersion for diagramLayoutVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramLayoutVersion. 
	 */
	protected DiagramLayoutVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramLayoutVersion" );

		DiagramLayoutVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramLayoutVersion with primary key" );
		msg.append( diagramLayoutVersionId );
		
		DiagramLayoutVersionFetchOneSummary fetchOneSummary = new DiagramLayoutVersionFetchOneSummary( diagramLayoutVersionId );

		try {
			entity = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().getDiagramLayoutVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramLayoutVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramLayoutVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramLayoutVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramLayoutVersion : " );        
		DiagramLayoutVersion entity = read();
		UpdateDiagramLayoutVersionCommand command = generateUpdateCommand();
		command.setDiagramLayoutVersionId(entity.getDiagramLayoutVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramLayoutVersion." );

			// for use later on...
			diagramLayoutVersionId = entity.getDiagramLayoutVersionId();

			DiagramLayoutVersionBusinessDelegate proxy = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance();  

			proxy.updateDiagramLayoutVersion( command ).get();

			LOGGER.info( "-- Successfully saved DiagramLayoutVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramLayoutVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramLayoutVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramLayoutVersion." );

		DiagramLayoutVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramLayoutVersion with id " + diagramLayoutVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramLayoutVersion with id " + diagramLayoutVersionId );

			throw e;
		}

		try{
			DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().delete( new DeleteDiagramLayoutVersionCommand( entity.getDiagramLayoutVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramLayoutVersion with id " + diagramLayoutVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramLayoutVersion with id " + diagramLayoutVersionId );

			throw e;
		}
	}

	/**
	 * get all DiagramLayoutVersions.
	 */
	protected List<DiagramLayoutVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramLayoutVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramLayoutVersion : " );        
		List<DiagramLayoutVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramLayoutVersionBusinessDelegate
			collection = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().getAllDiagramLayoutVersion();
			assertNotNull( collection, "An Empty collection of DiagramLayoutVersion was incorrectly returned.");
			
			// Now print out the values
			DiagramLayoutVersion entity = null;            
			Iterator<DiagramLayoutVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramLayoutVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramLayoutVersionTest
	 */
	protected DiagramLayoutVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramLayoutVersion
	 * 
	 * @return CreateDiagramLayoutVersionCommand alias
	 */
	protected CreateDiagramLayoutVersionCommand generateNewCommand() {
        CreateDiagramLayoutVersionCommand command = new CreateDiagramLayoutVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramLayoutVersion
		 * 
		 * @return UpdateDiagramLayoutVersionCommand alias
		 */
	protected UpdateDiagramLayoutVersionCommand generateUpdateCommand() {
	        UpdateDiagramLayoutVersionCommand command = new UpdateDiagramLayoutVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramLayoutVersionId = null;
	protected DiagramLayoutVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramLayoutVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramLayoutVersionList = 0;
}
