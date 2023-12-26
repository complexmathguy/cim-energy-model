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
 * Test Line class.
 *
 * @author your_name_here
 */
public class LineTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LineTest() {
		subscriber = new LineSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LineTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Line...");
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
	 * jumpstart the process by instantiating2 Line
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		lineId = LineBusinessDelegate.getLineInstance()
		.createLine( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LineBusinessDelegate.getLineInstance()
				.createLine( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.lineSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Line : " + successValue.getLineId());
							  if (successValue.getLineId().equals(lineId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLineList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Line test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on line consumed")
					);
			subscriber.lineSubscribe( lineId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Line : " + successValue.getLineId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLineList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on line for lineId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Line. 
	 */
	protected Line read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Line" );

		Line entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Line with primary key" );
		msg.append( lineId );
		
		LineFetchOneSummary fetchOneSummary = new LineFetchOneSummary( lineId );

		try {
			entity = LineBusinessDelegate.getLineInstance().getLine( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Line " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Line.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Line." );

		StringBuilder msg = new StringBuilder( "Failed to update a Line : " );        
		Line entity = read();
		UpdateLineCommand command = generateUpdateCommand();
		command.setLineId(entity.getLineId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Line." );

			// for use later on...
			lineId = entity.getLineId();

			LineBusinessDelegate proxy = LineBusinessDelegate.getLineInstance();  

			proxy.updateLine( command ).get();

			LOGGER.info( "-- Successfully saved Line - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + lineId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Line.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Line." );

		Line entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Line with id " + lineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Line with id " + lineId );

			throw e;
		}

		try{
			LineBusinessDelegate.getLineInstance().delete( new DeleteLineCommand( entity.getLineId() ) ).get();
			LOGGER.info( "-- Successfully deleted Line with id " + lineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Line with id " + lineId );

			throw e;
		}
	}

	/**
	 * get all Lines.
	 */
	protected List<Line> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Lines:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Line : " );        
		List<Line> collection  = new ArrayList<>();

		try {
			// call the static get method on the LineBusinessDelegate
			collection = LineBusinessDelegate.getLineInstance().getAllLine();
			assertNotNull( collection, "An Empty collection of Line was incorrectly returned.");
			
			// Now print out the values
			Line entity = null;            
			Iterator<Line> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLineId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LineTest
	 */
	protected LineTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Line
	 * 
	 * @return CreateLineCommand alias
	 */
	protected CreateLineCommand generateNewCommand() {
        CreateLineCommand command = new CreateLineCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Line
		 * 
		 * @return UpdateLineCommand alias
		 */
	protected UpdateLineCommand generateUpdateCommand() {
	        UpdateLineCommand command = new UpdateLineCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID lineId = null;
	protected LineSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LineTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLineList = 0;
}
