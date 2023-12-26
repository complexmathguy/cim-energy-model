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
 * Test DiagramStyle class.
 *
 * @author your_name_here
 */
public class DiagramStyleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramStyleTest() {
		subscriber = new DiagramStyleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramStyleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramStyle...");
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
	 * jumpstart the process by instantiating2 DiagramStyle
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramStyleId = DiagramStyleBusinessDelegate.getDiagramStyleInstance()
		.createDiagramStyle( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramStyleBusinessDelegate.getDiagramStyleInstance()
				.createDiagramStyle( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramStyleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramStyle : " + successValue.getDiagramStyleId());
							  if (successValue.getDiagramStyleId().equals(diagramStyleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramStyleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramStyle test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramStyle consumed")
					);
			subscriber.diagramStyleSubscribe( diagramStyleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramStyle : " + successValue.getDiagramStyleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramStyleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramStyle for diagramStyleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramStyle. 
	 */
	protected DiagramStyle read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramStyle" );

		DiagramStyle entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramStyle with primary key" );
		msg.append( diagramStyleId );
		
		DiagramStyleFetchOneSummary fetchOneSummary = new DiagramStyleFetchOneSummary( diagramStyleId );

		try {
			entity = DiagramStyleBusinessDelegate.getDiagramStyleInstance().getDiagramStyle( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramStyle " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramStyle.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramStyle." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramStyle : " );        
		DiagramStyle entity = read();
		UpdateDiagramStyleCommand command = generateUpdateCommand();
		command.setDiagramStyleId(entity.getDiagramStyleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramStyle." );

			// for use later on...
			diagramStyleId = entity.getDiagramStyleId();

			DiagramStyleBusinessDelegate proxy = DiagramStyleBusinessDelegate.getDiagramStyleInstance();  

			proxy.updateDiagramStyle( command ).get();

			LOGGER.info( "-- Successfully saved DiagramStyle - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramStyleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramStyle.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramStyle." );

		DiagramStyle entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramStyle with id " + diagramStyleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramStyle with id " + diagramStyleId );

			throw e;
		}

		try{
			DiagramStyleBusinessDelegate.getDiagramStyleInstance().delete( new DeleteDiagramStyleCommand( entity.getDiagramStyleId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramStyle with id " + diagramStyleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramStyle with id " + diagramStyleId );

			throw e;
		}
	}

	/**
	 * get all DiagramStyles.
	 */
	protected List<DiagramStyle> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramStyles:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramStyle : " );        
		List<DiagramStyle> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramStyleBusinessDelegate
			collection = DiagramStyleBusinessDelegate.getDiagramStyleInstance().getAllDiagramStyle();
			assertNotNull( collection, "An Empty collection of DiagramStyle was incorrectly returned.");
			
			// Now print out the values
			DiagramStyle entity = null;            
			Iterator<DiagramStyle> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramStyleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramStyleTest
	 */
	protected DiagramStyleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramStyle
	 * 
	 * @return CreateDiagramStyleCommand alias
	 */
	protected CreateDiagramStyleCommand generateNewCommand() {
        CreateDiagramStyleCommand command = new CreateDiagramStyleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramStyle
		 * 
		 * @return UpdateDiagramStyleCommand alias
		 */
	protected UpdateDiagramStyleCommand generateUpdateCommand() {
	        UpdateDiagramStyleCommand command = new UpdateDiagramStyleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramStyleId = null;
	protected DiagramStyleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramStyleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramStyleList = 0;
}
