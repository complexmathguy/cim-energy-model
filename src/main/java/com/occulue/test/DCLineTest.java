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
 * Test DCLine class.
 *
 * @author your_name_here
 */
public class DCLineTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCLineTest() {
		subscriber = new DCLineSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCLineTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCLine...");
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
	 * jumpstart the process by instantiating2 DCLine
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCLineId = DCLineBusinessDelegate.getDCLineInstance()
		.createDCLine( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCLineBusinessDelegate.getDCLineInstance()
				.createDCLine( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCLineSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCLine : " + successValue.getDCLineId());
							  if (successValue.getDCLineId().equals(dCLineId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCLineList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCLine test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCLine consumed")
					);
			subscriber.dCLineSubscribe( dCLineId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCLine : " + successValue.getDCLineId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCLineList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCLine for dCLineId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCLine. 
	 */
	protected DCLine read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCLine" );

		DCLine entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCLine with primary key" );
		msg.append( dCLineId );
		
		DCLineFetchOneSummary fetchOneSummary = new DCLineFetchOneSummary( dCLineId );

		try {
			entity = DCLineBusinessDelegate.getDCLineInstance().getDCLine( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCLine " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCLine.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCLine." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCLine : " );        
		DCLine entity = read();
		UpdateDCLineCommand command = generateUpdateCommand();
		command.setDCLineId(entity.getDCLineId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCLine." );

			// for use later on...
			dCLineId = entity.getDCLineId();

			DCLineBusinessDelegate proxy = DCLineBusinessDelegate.getDCLineInstance();  

			proxy.updateDCLine( command ).get();

			LOGGER.info( "-- Successfully saved DCLine - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCLineId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCLine.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCLine." );

		DCLine entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCLine with id " + dCLineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCLine with id " + dCLineId );

			throw e;
		}

		try{
			DCLineBusinessDelegate.getDCLineInstance().delete( new DeleteDCLineCommand( entity.getDCLineId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCLine with id " + dCLineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCLine with id " + dCLineId );

			throw e;
		}
	}

	/**
	 * get all DCLines.
	 */
	protected List<DCLine> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCLines:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCLine : " );        
		List<DCLine> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCLineBusinessDelegate
			collection = DCLineBusinessDelegate.getDCLineInstance().getAllDCLine();
			assertNotNull( collection, "An Empty collection of DCLine was incorrectly returned.");
			
			// Now print out the values
			DCLine entity = null;            
			Iterator<DCLine> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCLineId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCLineTest
	 */
	protected DCLineTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCLine
	 * 
	 * @return CreateDCLineCommand alias
	 */
	protected CreateDCLineCommand generateNewCommand() {
        CreateDCLineCommand command = new CreateDCLineCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCLine
		 * 
		 * @return UpdateDCLineCommand alias
		 */
	protected UpdateDCLineCommand generateUpdateCommand() {
	        UpdateDCLineCommand command = new UpdateDCLineCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCLineId = null;
	protected DCLineSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCLineTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCLineList = 0;
}
