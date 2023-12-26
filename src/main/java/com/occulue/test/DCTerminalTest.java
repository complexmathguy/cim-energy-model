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
 * Test DCTerminal class.
 *
 * @author your_name_here
 */
public class DCTerminalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCTerminalTest() {
		subscriber = new DCTerminalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCTerminalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCTerminal...");
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
	 * jumpstart the process by instantiating2 DCTerminal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCTerminalId = DCTerminalBusinessDelegate.getDCTerminalInstance()
		.createDCTerminal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCTerminalBusinessDelegate.getDCTerminalInstance()
				.createDCTerminal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCTerminalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCTerminal : " + successValue.getDCTerminalId());
							  if (successValue.getDCTerminalId().equals(dCTerminalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCTerminalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCTerminal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTerminal consumed")
					);
			subscriber.dCTerminalSubscribe( dCTerminalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCTerminal : " + successValue.getDCTerminalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCTerminalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTerminal for dCTerminalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCTerminal. 
	 */
	protected DCTerminal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCTerminal" );

		DCTerminal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCTerminal with primary key" );
		msg.append( dCTerminalId );
		
		DCTerminalFetchOneSummary fetchOneSummary = new DCTerminalFetchOneSummary( dCTerminalId );

		try {
			entity = DCTerminalBusinessDelegate.getDCTerminalInstance().getDCTerminal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCTerminal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCTerminal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCTerminal." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCTerminal : " );        
		DCTerminal entity = read();
		UpdateDCTerminalCommand command = generateUpdateCommand();
		command.setDCTerminalId(entity.getDCTerminalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCTerminal." );

			// for use later on...
			dCTerminalId = entity.getDCTerminalId();

			DCTerminalBusinessDelegate proxy = DCTerminalBusinessDelegate.getDCTerminalInstance();  

			proxy.updateDCTerminal( command ).get();

			LOGGER.info( "-- Successfully saved DCTerminal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCTerminalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCTerminal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCTerminal." );

		DCTerminal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCTerminal with id " + dCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCTerminal with id " + dCTerminalId );

			throw e;
		}

		try{
			DCTerminalBusinessDelegate.getDCTerminalInstance().delete( new DeleteDCTerminalCommand( entity.getDCTerminalId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCTerminal with id " + dCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCTerminal with id " + dCTerminalId );

			throw e;
		}
	}

	/**
	 * get all DCTerminals.
	 */
	protected List<DCTerminal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCTerminals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCTerminal : " );        
		List<DCTerminal> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCTerminalBusinessDelegate
			collection = DCTerminalBusinessDelegate.getDCTerminalInstance().getAllDCTerminal();
			assertNotNull( collection, "An Empty collection of DCTerminal was incorrectly returned.");
			
			// Now print out the values
			DCTerminal entity = null;            
			Iterator<DCTerminal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCTerminalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCTerminalTest
	 */
	protected DCTerminalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCTerminal
	 * 
	 * @return CreateDCTerminalCommand alias
	 */
	protected CreateDCTerminalCommand generateNewCommand() {
        CreateDCTerminalCommand command = new CreateDCTerminalCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCTerminal
		 * 
		 * @return UpdateDCTerminalCommand alias
		 */
	protected UpdateDCTerminalCommand generateUpdateCommand() {
	        UpdateDCTerminalCommand command = new UpdateDCTerminalCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCTerminalId = null;
	protected DCTerminalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCTerminalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCTerminalList = 0;
}
