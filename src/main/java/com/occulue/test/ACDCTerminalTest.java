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
 * Test ACDCTerminal class.
 *
 * @author your_name_here
 */
public class ACDCTerminalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ACDCTerminalTest() {
		subscriber = new ACDCTerminalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ACDCTerminalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ACDCTerminal...");
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
	 * jumpstart the process by instantiating2 ACDCTerminal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		aCDCTerminalId = ACDCTerminalBusinessDelegate.getACDCTerminalInstance()
		.createACDCTerminal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ACDCTerminalBusinessDelegate.getACDCTerminalInstance()
				.createACDCTerminal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.aCDCTerminalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ACDCTerminal : " + successValue.getACDCTerminalId());
							  if (successValue.getACDCTerminalId().equals(aCDCTerminalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfACDCTerminalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ACDCTerminal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCTerminal consumed")
					);
			subscriber.aCDCTerminalSubscribe( aCDCTerminalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ACDCTerminal : " + successValue.getACDCTerminalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfACDCTerminalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCTerminal for aCDCTerminalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ACDCTerminal. 
	 */
	protected ACDCTerminal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ACDCTerminal" );

		ACDCTerminal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ACDCTerminal with primary key" );
		msg.append( aCDCTerminalId );
		
		ACDCTerminalFetchOneSummary fetchOneSummary = new ACDCTerminalFetchOneSummary( aCDCTerminalId );

		try {
			entity = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().getACDCTerminal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ACDCTerminal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ACDCTerminal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ACDCTerminal." );

		StringBuilder msg = new StringBuilder( "Failed to update a ACDCTerminal : " );        
		ACDCTerminal entity = read();
		UpdateACDCTerminalCommand command = generateUpdateCommand();
		command.setACDCTerminalId(entity.getACDCTerminalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ACDCTerminal." );

			// for use later on...
			aCDCTerminalId = entity.getACDCTerminalId();

			ACDCTerminalBusinessDelegate proxy = ACDCTerminalBusinessDelegate.getACDCTerminalInstance();  

			proxy.updateACDCTerminal( command ).get();

			LOGGER.info( "-- Successfully saved ACDCTerminal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + aCDCTerminalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ACDCTerminal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ACDCTerminal." );

		ACDCTerminal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ACDCTerminal with id " + aCDCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ACDCTerminal with id " + aCDCTerminalId );

			throw e;
		}

		try{
			ACDCTerminalBusinessDelegate.getACDCTerminalInstance().delete( new DeleteACDCTerminalCommand( entity.getACDCTerminalId() ) ).get();
			LOGGER.info( "-- Successfully deleted ACDCTerminal with id " + aCDCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ACDCTerminal with id " + aCDCTerminalId );

			throw e;
		}
	}

	/**
	 * get all ACDCTerminals.
	 */
	protected List<ACDCTerminal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ACDCTerminals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ACDCTerminal : " );        
		List<ACDCTerminal> collection  = new ArrayList<>();

		try {
			// call the static get method on the ACDCTerminalBusinessDelegate
			collection = ACDCTerminalBusinessDelegate.getACDCTerminalInstance().getAllACDCTerminal();
			assertNotNull( collection, "An Empty collection of ACDCTerminal was incorrectly returned.");
			
			// Now print out the values
			ACDCTerminal entity = null;            
			Iterator<ACDCTerminal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getACDCTerminalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ACDCTerminalTest
	 */
	protected ACDCTerminalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ACDCTerminal
	 * 
	 * @return CreateACDCTerminalCommand alias
	 */
	protected CreateACDCTerminalCommand generateNewCommand() {
        CreateACDCTerminalCommand command = new CreateACDCTerminalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ACDCTerminal
		 * 
		 * @return UpdateACDCTerminalCommand alias
		 */
	protected UpdateACDCTerminalCommand generateUpdateCommand() {
	        UpdateACDCTerminalCommand command = new UpdateACDCTerminalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID aCDCTerminalId = null;
	protected ACDCTerminalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ACDCTerminalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfACDCTerminalList = 0;
}
