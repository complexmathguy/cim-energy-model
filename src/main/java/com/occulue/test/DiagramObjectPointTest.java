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
 * Test DiagramObjectPoint class.
 *
 * @author your_name_here
 */
public class DiagramObjectPointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramObjectPointTest() {
		subscriber = new DiagramObjectPointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramObjectPointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramObjectPoint...");
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
	 * jumpstart the process by instantiating2 DiagramObjectPoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramObjectPointId = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance()
		.createDiagramObjectPoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance()
				.createDiagramObjectPoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramObjectPointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramObjectPoint : " + successValue.getDiagramObjectPointId());
							  if (successValue.getDiagramObjectPointId().equals(diagramObjectPointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramObjectPointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramObjectPoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectPoint consumed")
					);
			subscriber.diagramObjectPointSubscribe( diagramObjectPointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramObjectPoint : " + successValue.getDiagramObjectPointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramObjectPointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectPoint for diagramObjectPointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramObjectPoint. 
	 */
	protected DiagramObjectPoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramObjectPoint" );

		DiagramObjectPoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramObjectPoint with primary key" );
		msg.append( diagramObjectPointId );
		
		DiagramObjectPointFetchOneSummary fetchOneSummary = new DiagramObjectPointFetchOneSummary( diagramObjectPointId );

		try {
			entity = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().getDiagramObjectPoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramObjectPoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramObjectPoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramObjectPoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramObjectPoint : " );        
		DiagramObjectPoint entity = read();
		UpdateDiagramObjectPointCommand command = generateUpdateCommand();
		command.setDiagramObjectPointId(entity.getDiagramObjectPointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramObjectPoint." );

			// for use later on...
			diagramObjectPointId = entity.getDiagramObjectPointId();

			DiagramObjectPointBusinessDelegate proxy = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance();  

			proxy.updateDiagramObjectPoint( command ).get();

			LOGGER.info( "-- Successfully saved DiagramObjectPoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramObjectPointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramObjectPoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramObjectPoint." );

		DiagramObjectPoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramObjectPoint with id " + diagramObjectPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramObjectPoint with id " + diagramObjectPointId );

			throw e;
		}

		try{
			DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().delete( new DeleteDiagramObjectPointCommand( entity.getDiagramObjectPointId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramObjectPoint with id " + diagramObjectPointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramObjectPoint with id " + diagramObjectPointId );

			throw e;
		}
	}

	/**
	 * get all DiagramObjectPoints.
	 */
	protected List<DiagramObjectPoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramObjectPoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramObjectPoint : " );        
		List<DiagramObjectPoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramObjectPointBusinessDelegate
			collection = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().getAllDiagramObjectPoint();
			assertNotNull( collection, "An Empty collection of DiagramObjectPoint was incorrectly returned.");
			
			// Now print out the values
			DiagramObjectPoint entity = null;            
			Iterator<DiagramObjectPoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramObjectPointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramObjectPointTest
	 */
	protected DiagramObjectPointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramObjectPoint
	 * 
	 * @return CreateDiagramObjectPointCommand alias
	 */
	protected CreateDiagramObjectPointCommand generateNewCommand() {
        CreateDiagramObjectPointCommand command = new CreateDiagramObjectPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramObjectPoint
		 * 
		 * @return UpdateDiagramObjectPointCommand alias
		 */
	protected UpdateDiagramObjectPointCommand generateUpdateCommand() {
	        UpdateDiagramObjectPointCommand command = new UpdateDiagramObjectPointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramObjectPointId = null;
	protected DiagramObjectPointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramObjectPointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramObjectPointList = 0;
}
