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
 * Test DiagramObject class.
 *
 * @author your_name_here
 */
public class DiagramObjectTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramObjectTest() {
		subscriber = new DiagramObjectSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramObjectTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramObject...");
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
	 * jumpstart the process by instantiating2 DiagramObject
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramObjectId = DiagramObjectBusinessDelegate.getDiagramObjectInstance()
		.createDiagramObject( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramObjectBusinessDelegate.getDiagramObjectInstance()
				.createDiagramObject( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramObjectSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramObject : " + successValue.getDiagramObjectId());
							  if (successValue.getDiagramObjectId().equals(diagramObjectId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramObjectList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramObject test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObject consumed")
					);
			subscriber.diagramObjectSubscribe( diagramObjectId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramObject : " + successValue.getDiagramObjectId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramObjectList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObject for diagramObjectId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramObject. 
	 */
	protected DiagramObject read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramObject" );

		DiagramObject entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramObject with primary key" );
		msg.append( diagramObjectId );
		
		DiagramObjectFetchOneSummary fetchOneSummary = new DiagramObjectFetchOneSummary( diagramObjectId );

		try {
			entity = DiagramObjectBusinessDelegate.getDiagramObjectInstance().getDiagramObject( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramObject " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramObject.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramObject." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramObject : " );        
		DiagramObject entity = read();
		UpdateDiagramObjectCommand command = generateUpdateCommand();
		command.setDiagramObjectId(entity.getDiagramObjectId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramObject." );

			// for use later on...
			diagramObjectId = entity.getDiagramObjectId();

			DiagramObjectBusinessDelegate proxy = DiagramObjectBusinessDelegate.getDiagramObjectInstance();  

			proxy.updateDiagramObject( command ).get();

			LOGGER.info( "-- Successfully saved DiagramObject - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramObjectId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramObject.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramObject." );

		DiagramObject entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramObject with id " + diagramObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramObject with id " + diagramObjectId );

			throw e;
		}

		try{
			DiagramObjectBusinessDelegate.getDiagramObjectInstance().delete( new DeleteDiagramObjectCommand( entity.getDiagramObjectId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramObject with id " + diagramObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramObject with id " + diagramObjectId );

			throw e;
		}
	}

	/**
	 * get all DiagramObjects.
	 */
	protected List<DiagramObject> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramObjects:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramObject : " );        
		List<DiagramObject> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramObjectBusinessDelegate
			collection = DiagramObjectBusinessDelegate.getDiagramObjectInstance().getAllDiagramObject();
			assertNotNull( collection, "An Empty collection of DiagramObject was incorrectly returned.");
			
			// Now print out the values
			DiagramObject entity = null;            
			Iterator<DiagramObject> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramObjectId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramObjectTest
	 */
	protected DiagramObjectTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramObject
	 * 
	 * @return CreateDiagramObjectCommand alias
	 */
	protected CreateDiagramObjectCommand generateNewCommand() {
        CreateDiagramObjectCommand command = new CreateDiagramObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramObject
		 * 
		 * @return UpdateDiagramObjectCommand alias
		 */
	protected UpdateDiagramObjectCommand generateUpdateCommand() {
	        UpdateDiagramObjectCommand command = new UpdateDiagramObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramObjectId = null;
	protected DiagramObjectSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramObjectTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramObjectList = 0;
}
