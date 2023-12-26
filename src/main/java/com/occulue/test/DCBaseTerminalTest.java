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
 * Test DCBaseTerminal class.
 *
 * @author your_name_here
 */
public class DCBaseTerminalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCBaseTerminalTest() {
		subscriber = new DCBaseTerminalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCBaseTerminalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCBaseTerminal...");
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
	 * jumpstart the process by instantiating2 DCBaseTerminal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCBaseTerminalId = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance()
		.createDCBaseTerminal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance()
				.createDCBaseTerminal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCBaseTerminalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCBaseTerminal : " + successValue.getDCBaseTerminalId());
							  if (successValue.getDCBaseTerminalId().equals(dCBaseTerminalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCBaseTerminalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCBaseTerminal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBaseTerminal consumed")
					);
			subscriber.dCBaseTerminalSubscribe( dCBaseTerminalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCBaseTerminal : " + successValue.getDCBaseTerminalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCBaseTerminalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBaseTerminal for dCBaseTerminalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCBaseTerminal. 
	 */
	protected DCBaseTerminal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCBaseTerminal" );

		DCBaseTerminal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCBaseTerminal with primary key" );
		msg.append( dCBaseTerminalId );
		
		DCBaseTerminalFetchOneSummary fetchOneSummary = new DCBaseTerminalFetchOneSummary( dCBaseTerminalId );

		try {
			entity = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().getDCBaseTerminal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCBaseTerminal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCBaseTerminal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCBaseTerminal." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCBaseTerminal : " );        
		DCBaseTerminal entity = read();
		UpdateDCBaseTerminalCommand command = generateUpdateCommand();
		command.setDCBaseTerminalId(entity.getDCBaseTerminalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCBaseTerminal." );

			// for use later on...
			dCBaseTerminalId = entity.getDCBaseTerminalId();

			DCBaseTerminalBusinessDelegate proxy = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance();  

			proxy.updateDCBaseTerminal( command ).get();

			LOGGER.info( "-- Successfully saved DCBaseTerminal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCBaseTerminalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCBaseTerminal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCBaseTerminal." );

		DCBaseTerminal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCBaseTerminal with id " + dCBaseTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCBaseTerminal with id " + dCBaseTerminalId );

			throw e;
		}

		try{
			DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().delete( new DeleteDCBaseTerminalCommand( entity.getDCBaseTerminalId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCBaseTerminal with id " + dCBaseTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCBaseTerminal with id " + dCBaseTerminalId );

			throw e;
		}
	}

	/**
	 * get all DCBaseTerminals.
	 */
	protected List<DCBaseTerminal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCBaseTerminals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCBaseTerminal : " );        
		List<DCBaseTerminal> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCBaseTerminalBusinessDelegate
			collection = DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().getAllDCBaseTerminal();
			assertNotNull( collection, "An Empty collection of DCBaseTerminal was incorrectly returned.");
			
			// Now print out the values
			DCBaseTerminal entity = null;            
			Iterator<DCBaseTerminal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCBaseTerminalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCBaseTerminalTest
	 */
	protected DCBaseTerminalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCBaseTerminal
	 * 
	 * @return CreateDCBaseTerminalCommand alias
	 */
	protected CreateDCBaseTerminalCommand generateNewCommand() {
        CreateDCBaseTerminalCommand command = new CreateDCBaseTerminalCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCBaseTerminal
		 * 
		 * @return UpdateDCBaseTerminalCommand alias
		 */
	protected UpdateDCBaseTerminalCommand generateUpdateCommand() {
	        UpdateDCBaseTerminalCommand command = new UpdateDCBaseTerminalCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCBaseTerminalId = null;
	protected DCBaseTerminalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCBaseTerminalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCBaseTerminalList = 0;
}
