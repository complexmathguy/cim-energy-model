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
 * Test Diagram class.
 *
 * @author your_name_here
 */
public class DiagramTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiagramTest() {
		subscriber = new DiagramSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiagramTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Diagram...");
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
	 * jumpstart the process by instantiating2 Diagram
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		diagramId = DiagramBusinessDelegate.getDiagramInstance()
		.createDiagram( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiagramBusinessDelegate.getDiagramInstance()
				.createDiagram( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.diagramSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Diagram : " + successValue.getDiagramId());
							  if (successValue.getDiagramId().equals(diagramId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiagramList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Diagram test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagram consumed")
					);
			subscriber.diagramSubscribe( diagramId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Diagram : " + successValue.getDiagramId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiagramList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on diagram for diagramId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Diagram. 
	 */
	protected Diagram read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Diagram" );

		Diagram entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Diagram with primary key" );
		msg.append( diagramId );
		
		DiagramFetchOneSummary fetchOneSummary = new DiagramFetchOneSummary( diagramId );

		try {
			entity = DiagramBusinessDelegate.getDiagramInstance().getDiagram( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Diagram " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Diagram.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Diagram." );

		StringBuilder msg = new StringBuilder( "Failed to update a Diagram : " );        
		Diagram entity = read();
		UpdateDiagramCommand command = generateUpdateCommand();
		command.setDiagramId(entity.getDiagramId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Diagram." );

			// for use later on...
			diagramId = entity.getDiagramId();

			DiagramBusinessDelegate proxy = DiagramBusinessDelegate.getDiagramInstance();  

			proxy.updateDiagram( command ).get();

			LOGGER.info( "-- Successfully saved Diagram - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + diagramId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Diagram.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Diagram." );

		Diagram entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Diagram with id " + diagramId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Diagram with id " + diagramId );

			throw e;
		}

		try{
			DiagramBusinessDelegate.getDiagramInstance().delete( new DeleteDiagramCommand( entity.getDiagramId() ) ).get();
			LOGGER.info( "-- Successfully deleted Diagram with id " + diagramId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Diagram with id " + diagramId );

			throw e;
		}
	}

	/**
	 * get all Diagrams.
	 */
	protected List<Diagram> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Diagrams:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Diagram : " );        
		List<Diagram> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiagramBusinessDelegate
			collection = DiagramBusinessDelegate.getDiagramInstance().getAllDiagram();
			assertNotNull( collection, "An Empty collection of Diagram was incorrectly returned.");
			
			// Now print out the values
			Diagram entity = null;            
			Iterator<Diagram> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiagramId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiagramTest
	 */
	protected DiagramTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Diagram
	 * 
	 * @return CreateDiagramCommand alias
	 */
	protected CreateDiagramCommand generateNewCommand() {
        CreateDiagramCommand command = new CreateDiagramCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Diagram
		 * 
		 * @return UpdateDiagramCommand alias
		 */
	protected UpdateDiagramCommand generateUpdateCommand() {
	        UpdateDiagramCommand command = new UpdateDiagramCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID diagramId = null;
	protected DiagramSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiagramTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiagramList = 0;
}
