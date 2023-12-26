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
 * Test ACDCConverterDCTerminal class.
 *
 * @author your_name_here
 */
public class ACDCConverterDCTerminalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ACDCConverterDCTerminalTest() {
		subscriber = new ACDCConverterDCTerminalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ACDCConverterDCTerminalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ACDCConverterDCTerminal...");
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
	 * jumpstart the process by instantiating2 ACDCConverterDCTerminal
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		aCDCConverterDCTerminalId = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance()
		.createACDCConverterDCTerminal( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance()
				.createACDCConverterDCTerminal( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.aCDCConverterDCTerminalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ACDCConverterDCTerminal : " + successValue.getACDCConverterDCTerminalId());
							  if (successValue.getACDCConverterDCTerminalId().equals(aCDCConverterDCTerminalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfACDCConverterDCTerminalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ACDCConverterDCTerminal test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCConverterDCTerminal consumed")
					);
			subscriber.aCDCConverterDCTerminalSubscribe( aCDCConverterDCTerminalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ACDCConverterDCTerminal : " + successValue.getACDCConverterDCTerminalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfACDCConverterDCTerminalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCConverterDCTerminal for aCDCConverterDCTerminalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ACDCConverterDCTerminal. 
	 */
	protected ACDCConverterDCTerminal read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ACDCConverterDCTerminal" );

		ACDCConverterDCTerminal entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ACDCConverterDCTerminal with primary key" );
		msg.append( aCDCConverterDCTerminalId );
		
		ACDCConverterDCTerminalFetchOneSummary fetchOneSummary = new ACDCConverterDCTerminalFetchOneSummary( aCDCConverterDCTerminalId );

		try {
			entity = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().getACDCConverterDCTerminal( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ACDCConverterDCTerminal " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ACDCConverterDCTerminal.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ACDCConverterDCTerminal." );

		StringBuilder msg = new StringBuilder( "Failed to update a ACDCConverterDCTerminal : " );        
		ACDCConverterDCTerminal entity = read();
		UpdateACDCConverterDCTerminalCommand command = generateUpdateCommand();
		command.setACDCConverterDCTerminalId(entity.getACDCConverterDCTerminalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ACDCConverterDCTerminal." );

			// for use later on...
			aCDCConverterDCTerminalId = entity.getACDCConverterDCTerminalId();

			ACDCConverterDCTerminalBusinessDelegate proxy = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance();  

			proxy.updateACDCConverterDCTerminal( command ).get();

			LOGGER.info( "-- Successfully saved ACDCConverterDCTerminal - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + aCDCConverterDCTerminalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ACDCConverterDCTerminal.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ACDCConverterDCTerminal." );

		ACDCConverterDCTerminal entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ACDCConverterDCTerminal with id " + aCDCConverterDCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ACDCConverterDCTerminal with id " + aCDCConverterDCTerminalId );

			throw e;
		}

		try{
			ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().delete( new DeleteACDCConverterDCTerminalCommand( entity.getACDCConverterDCTerminalId() ) ).get();
			LOGGER.info( "-- Successfully deleted ACDCConverterDCTerminal with id " + aCDCConverterDCTerminalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ACDCConverterDCTerminal with id " + aCDCConverterDCTerminalId );

			throw e;
		}
	}

	/**
	 * get all ACDCConverterDCTerminals.
	 */
	protected List<ACDCConverterDCTerminal> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ACDCConverterDCTerminals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ACDCConverterDCTerminal : " );        
		List<ACDCConverterDCTerminal> collection  = new ArrayList<>();

		try {
			// call the static get method on the ACDCConverterDCTerminalBusinessDelegate
			collection = ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance().getAllACDCConverterDCTerminal();
			assertNotNull( collection, "An Empty collection of ACDCConverterDCTerminal was incorrectly returned.");
			
			// Now print out the values
			ACDCConverterDCTerminal entity = null;            
			Iterator<ACDCConverterDCTerminal> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getACDCConverterDCTerminalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ACDCConverterDCTerminalTest
	 */
	protected ACDCConverterDCTerminalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ACDCConverterDCTerminal
	 * 
	 * @return CreateACDCConverterDCTerminalCommand alias
	 */
	protected CreateACDCConverterDCTerminalCommand generateNewCommand() {
        CreateACDCConverterDCTerminalCommand command = new CreateACDCConverterDCTerminalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ACDCConverterDCTerminal
		 * 
		 * @return UpdateACDCConverterDCTerminalCommand alias
		 */
	protected UpdateACDCConverterDCTerminalCommand generateUpdateCommand() {
	        UpdateACDCConverterDCTerminalCommand command = new UpdateACDCConverterDCTerminalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID aCDCConverterDCTerminalId = null;
	protected ACDCConverterDCTerminalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ACDCConverterDCTerminalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfACDCConverterDCTerminalList = 0;
}
