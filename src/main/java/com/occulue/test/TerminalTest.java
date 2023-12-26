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
 * Test Terminal class.
 *
 * @author your_name_here
 */
public class TerminalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TerminalTest() {
		subscriber = new TerminalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TerminalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Terminal...");
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
	 * jumpstart the process by instantiating2 Terminal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		terminalId = TerminalBusinessDelegate.getTerminalInstance()
		.createTerminal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TerminalBusinessDelegate.getTerminalInstance()
				.createTerminal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.terminalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Terminal : " + successValue.getTerminalId());
							  if (successValue.getTerminalId().equals(terminalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTerminalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Terminal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on terminal consumed")
					);
			subscriber.terminalSubscribe( terminalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Terminal : " + successValue.getTerminalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTerminalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on terminal for terminalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Terminal. 
	 */
	protected Terminal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Terminal" );

		Terminal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Terminal with primary key" );
		msg.append( terminalId );
		
		TerminalFetchOneSummary fetchOneSummary = new TerminalFetchOneSummary( terminalId );

		try {
			entity = TerminalBusinessDelegate.getTerminalInstance().getTerminal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Terminal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Terminal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Terminal." );

		StringBuilder msg = new StringBuilder( "Failed to update a Terminal : " );        
		Terminal entity = read();
		UpdateTerminalCommand command = generateUpdateCommand();
		command.setTerminalId(entity.getTerminalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Terminal." );

			// for use later on...
			terminalId = entity.getTerminalId();

			TerminalBusinessDelegate proxy = TerminalBusinessDelegate.getTerminalInstance();  

			proxy.updateTerminal( command ).get();

			LOGGER.info( "-- Successfully saved Terminal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + terminalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Terminal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Terminal." );

		Terminal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Terminal with id " + terminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Terminal with id " + terminalId );

			throw e;
		}

		try{
			TerminalBusinessDelegate.getTerminalInstance().delete( new DeleteTerminalCommand( entity.getTerminalId() ) ).get();
			LOGGER.info( "-- Successfully deleted Terminal with id " + terminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Terminal with id " + terminalId );

			throw e;
		}
	}

	/**
	 * get all Terminals.
	 */
	protected List<Terminal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Terminals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Terminal : " );        
		List<Terminal> collection  = new ArrayList<>();

		try {
			// call the static get method on the TerminalBusinessDelegate
			collection = TerminalBusinessDelegate.getTerminalInstance().getAllTerminal();
			assertNotNull( collection, "An Empty collection of Terminal was incorrectly returned.");
			
			// Now print out the values
			Terminal entity = null;            
			Iterator<Terminal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTerminalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TerminalTest
	 */
	protected TerminalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Terminal
	 * 
	 * @return CreateTerminalCommand alias
	 */
	protected CreateTerminalCommand generateNewCommand() {
        CreateTerminalCommand command = new CreateTerminalCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Terminal
		 * 
		 * @return UpdateTerminalCommand alias
		 */
	protected UpdateTerminalCommand generateUpdateCommand() {
	        UpdateTerminalCommand command = new UpdateTerminalCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID terminalId = null;
	protected TerminalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TerminalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTerminalList = 0;
}
