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
 * Test DiagramObjectStyle class.
 *
 * @author your_name_here
 */
public class DiagramObjectStyleTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramObjectStyleTest() {
		subscriber = new DiagramObjectStyleSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramObjectStyleTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiagramObjectStyle...");
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
	 * jumpstart the process by instantiating2 DiagramObjectStyle
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramObjectStyleId = DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance()
		.createDiagramObjectStyle( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance()
				.createDiagramObjectStyle( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramObjectStyleSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiagramObjectStyle : " + successValue.getDiagramObjectStyleId());
							  if (successValue.getDiagramObjectStyleId().equals(diagramObjectStyleId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramObjectStyleList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiagramObjectStyle test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectStyle consumed")
					);
			subscriber.diagramObjectStyleSubscribe( diagramObjectStyleId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiagramObjectStyle : " + successValue.getDiagramObjectStyleId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramObjectStyleList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagramObjectStyle for diagramObjectStyleId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiagramObjectStyle. 
	 */
	protected DiagramObjectStyle read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiagramObjectStyle" );

		DiagramObjectStyle entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiagramObjectStyle with primary key" );
		msg.append( diagramObjectStyleId );
		
		DiagramObjectStyleFetchOneSummary fetchOneSummary = new DiagramObjectStyleFetchOneSummary( diagramObjectStyleId );

		try {
			entity = DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance().getDiagramObjectStyle( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiagramObjectStyle " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiagramObjectStyle.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiagramObjectStyle." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiagramObjectStyle : " );        
		DiagramObjectStyle entity = read();
		UpdateDiagramObjectStyleCommand command = generateUpdateCommand();
		command.setDiagramObjectStyleId(entity.getDiagramObjectStyleId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiagramObjectStyle." );

			// for use later on...
			diagramObjectStyleId = entity.getDiagramObjectStyleId();

			DiagramObjectStyleBusinessDelegate proxy = DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance();  

			proxy.updateDiagramObjectStyle( command ).get();

			LOGGER.info( "-- Successfully saved DiagramObjectStyle - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramObjectStyleId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiagramObjectStyle.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiagramObjectStyle." );

		DiagramObjectStyle entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiagramObjectStyle with id " + diagramObjectStyleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiagramObjectStyle with id " + diagramObjectStyleId );

			throw e;
		}

		try{
			DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance().delete( new DeleteDiagramObjectStyleCommand( entity.getDiagramObjectStyleId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiagramObjectStyle with id " + diagramObjectStyleId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiagramObjectStyle with id " + diagramObjectStyleId );

			throw e;
		}
	}

	/**
	 * get all DiagramObjectStyles.
	 */
	protected List<DiagramObjectStyle> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiagramObjectStyles:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiagramObjectStyle : " );        
		List<DiagramObjectStyle> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramObjectStyleBusinessDelegate
			collection = DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance().getAllDiagramObjectStyle();
			assertNotNull( collection, "An Empty collection of DiagramObjectStyle was incorrectly returned.");
			
			// Now print out the values
			DiagramObjectStyle entity = null;            
			Iterator<DiagramObjectStyle> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramObjectStyleId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramObjectStyleTest
	 */
	protected DiagramObjectStyleTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiagramObjectStyle
	 * 
	 * @return CreateDiagramObjectStyleCommand alias
	 */
	protected CreateDiagramObjectStyleCommand generateNewCommand() {
        CreateDiagramObjectStyleCommand command = new CreateDiagramObjectStyleCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DiagramObjectStyle
		 * 
		 * @return UpdateDiagramObjectStyleCommand alias
		 */
	protected UpdateDiagramObjectStyleCommand generateUpdateCommand() {
	        UpdateDiagramObjectStyleCommand command = new UpdateDiagramObjectStyleCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramObjectStyleId = null;
	protected DiagramObjectStyleSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramObjectStyleTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramObjectStyleList = 0;
}
