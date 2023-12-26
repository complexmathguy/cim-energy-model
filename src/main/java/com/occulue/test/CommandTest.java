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
 * Test Command class.
 *
 * @author your_name_here
 */
public class CommandTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CommandTest() {
		subscriber = new CommandSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CommandTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Command...");
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
	 * jumpstart the process by instantiating2 Command
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		commandId = CommandBusinessDelegate.getCommandInstance()
		.createCommand( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CommandBusinessDelegate.getCommandInstance()
				.createCommand( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.commandSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Command : " + successValue.getCommandId());
							  if (successValue.getCommandId().equals(commandId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCommandList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Command test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on command consumed")
					);
			subscriber.commandSubscribe( commandId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Command : " + successValue.getCommandId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCommandList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on command for commandId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Command. 
	 */
	protected Command read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Command" );

		Command entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Command with primary key" );
		msg.append( commandId );
		
		CommandFetchOneSummary fetchOneSummary = new CommandFetchOneSummary( commandId );

		try {
			entity = CommandBusinessDelegate.getCommandInstance().getCommand( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Command " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Command.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Command." );

		StringBuilder msg = new StringBuilder( "Failed to update a Command : " );        
		Command entity = read();
		UpdateCommandCommand command = generateUpdateCommand();
		command.setCommandId(entity.getCommandId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Command." );

			// for use later on...
			commandId = entity.getCommandId();

			CommandBusinessDelegate proxy = CommandBusinessDelegate.getCommandInstance();  

			proxy.updateCommand( command ).get();

			LOGGER.info( "-- Successfully saved Command - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + commandId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Command.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Command." );

		Command entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Command with id " + commandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Command with id " + commandId );

			throw e;
		}

		try{
			CommandBusinessDelegate.getCommandInstance().delete( new DeleteCommandCommand( entity.getCommandId() ) ).get();
			LOGGER.info( "-- Successfully deleted Command with id " + commandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Command with id " + commandId );

			throw e;
		}
	}

	/**
	 * get all Commands.
	 */
	protected List<Command> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Commands:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Command : " );        
		List<Command> collection  = new ArrayList<>();

		try {
			// call the static get method on the CommandBusinessDelegate
			collection = CommandBusinessDelegate.getCommandInstance().getAllCommand();
			assertNotNull( collection, "An Empty collection of Command was incorrectly returned.");
			
			// Now print out the values
			Command entity = null;            
			Iterator<Command> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCommandId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CommandTest
	 */
	protected CommandTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Command
	 * 
	 * @return CreateCommandCommand alias
	 */
	protected CreateCommandCommand generateNewCommand() {
        CreateCommandCommand command = new CreateCommandCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Command
		 * 
		 * @return UpdateCommandCommand alias
		 */
	protected UpdateCommandCommand generateUpdateCommand() {
	        UpdateCommandCommand command = new UpdateCommandCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID commandId = null;
	protected CommandSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CommandTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCommandList = 0;
}
