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
 * Test DiagramObjectGluePoint class.
 *
 * @author your_name_here
 */
public class DiagramObjectGluePointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramObjectGluePointTest() {
		subscriber = new DiagramObjectGluePointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramObjectGluePointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramObjectGluePoint...");
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
	 * jumpstart the process by instantiating2 DiagramObjectGluePoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramObjectGluePointId = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance()
		.createDiagramObjectGluePoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance()
				.createDiagramObjectGluePoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramObjectGluePointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramObjectGluePoint : " + successValue.getDiagramObjectGluePointId());
							  if (successValue.getDiagramObjectGluePointId().equals(diagramObjectGluePointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramObjectGluePointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramObjectGluePoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectGluePoint consumed")
					);
			subscriber.diagramObjectGluePointSubscribe( diagramObjectGluePointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramObjectGluePoint : " + successValue.getDiagramObjectGluePointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramObjectGluePointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectGluePoint for diagramObjectGluePointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramObjectGluePoint. 
	 */
	protected DiagramObjectGluePoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramObjectGluePoint" );

		DiagramObjectGluePoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramObjectGluePoint with primary key" );
		msg.append( diagramObjectGluePointId );
		
		DiagramObjectGluePointFetchOneSummary fetchOneSummary = new DiagramObjectGluePointFetchOneSummary( diagramObjectGluePointId );

		try {
			entity = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().getDiagramObjectGluePoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramObjectGluePoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramObjectGluePoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramObjectGluePoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramObjectGluePoint : " );        
		DiagramObjectGluePoint entity = read();
		UpdateDiagramObjectGluePointCommand command = generateUpdateCommand();
		command.setDiagramObjectGluePointId(entity.getDiagramObjectGluePointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramObjectGluePoint." );

			// for use later on...
			diagramObjectGluePointId = entity.getDiagramObjectGluePointId();

			DiagramObjectGluePointBusinessDelegate proxy = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance();  

			proxy.updateDiagramObjectGluePoint( command ).get();

			LOGGER.info( "-- Successfully saved DiagramObjectGluePoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramObjectGluePointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramObjectGluePoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramObjectGluePoint." );

		DiagramObjectGluePoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramObjectGluePoint with id " + diagramObjectGluePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramObjectGluePoint with id " + diagramObjectGluePointId );

			throw e;
		}

		try{
			DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().delete( new DeleteDiagramObjectGluePointCommand( entity.getDiagramObjectGluePointId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramObjectGluePoint with id " + diagramObjectGluePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramObjectGluePoint with id " + diagramObjectGluePointId );

			throw e;
		}
	}

	/**
	 * get all DiagramObjectGluePoints.
	 */
	protected List<DiagramObjectGluePoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramObjectGluePoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramObjectGluePoint : " );        
		List<DiagramObjectGluePoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramObjectGluePointBusinessDelegate
			collection = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().getAllDiagramObjectGluePoint();
			assertNotNull( collection, "An Empty collection of DiagramObjectGluePoint was incorrectly returned.");
			
			// Now print out the values
			DiagramObjectGluePoint entity = null;            
			Iterator<DiagramObjectGluePoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramObjectGluePointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramObjectGluePointTest
	 */
	protected DiagramObjectGluePointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramObjectGluePoint
	 * 
	 * @return CreateDiagramObjectGluePointCommand alias
	 */
	protected CreateDiagramObjectGluePointCommand generateNewCommand() {
        CreateDiagramObjectGluePointCommand command = new CreateDiagramObjectGluePointCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramObjectGluePoint
		 * 
		 * @return UpdateDiagramObjectGluePointCommand alias
		 */
	protected UpdateDiagramObjectGluePointCommand generateUpdateCommand() {
	        UpdateDiagramObjectGluePointCommand command = new UpdateDiagramObjectGluePointCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramObjectGluePointId = null;
	protected DiagramObjectGluePointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramObjectGluePointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramObjectGluePointList = 0;
}
