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
 * Test RaiseLowerCommand class.
 *
 * @author your_name_here
 */
public class RaiseLowerCommandTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RaiseLowerCommandTest() {
		subscriber = new RaiseLowerCommandSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RaiseLowerCommandTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RaiseLowerCommand...");
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
	 * jumpstart the process by instantiating2 RaiseLowerCommand
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		raiseLowerCommandId = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
		.createRaiseLowerCommand( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance()
				.createRaiseLowerCommand( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.raiseLowerCommandSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RaiseLowerCommand : " + successValue.getRaiseLowerCommandId());
							  if (successValue.getRaiseLowerCommandId().equals(raiseLowerCommandId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRaiseLowerCommandList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RaiseLowerCommand test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on raiseLowerCommand consumed")
					);
			subscriber.raiseLowerCommandSubscribe( raiseLowerCommandId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RaiseLowerCommand : " + successValue.getRaiseLowerCommandId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRaiseLowerCommandList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on raiseLowerCommand for raiseLowerCommandId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RaiseLowerCommand. 
	 */
	protected RaiseLowerCommand read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RaiseLowerCommand" );

		RaiseLowerCommand entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RaiseLowerCommand with primary key" );
		msg.append( raiseLowerCommandId );
		
		RaiseLowerCommandFetchOneSummary fetchOneSummary = new RaiseLowerCommandFetchOneSummary( raiseLowerCommandId );

		try {
			entity = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().getRaiseLowerCommand( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RaiseLowerCommand " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RaiseLowerCommand.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RaiseLowerCommand." );

		StringBuilder msg = new StringBuilder( "Failed to update a RaiseLowerCommand : " );        
		RaiseLowerCommand entity = read();
		UpdateRaiseLowerCommandCommand command = generateUpdateCommand();
		command.setRaiseLowerCommandId(entity.getRaiseLowerCommandId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RaiseLowerCommand." );

			// for use later on...
			raiseLowerCommandId = entity.getRaiseLowerCommandId();

			RaiseLowerCommandBusinessDelegate proxy = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance();  

			proxy.updateRaiseLowerCommand( command ).get();

			LOGGER.info( "-- Successfully saved RaiseLowerCommand - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + raiseLowerCommandId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RaiseLowerCommand.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RaiseLowerCommand." );

		RaiseLowerCommand entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RaiseLowerCommand with id " + raiseLowerCommandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RaiseLowerCommand with id " + raiseLowerCommandId );

			throw e;
		}

		try{
			RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().delete( new DeleteRaiseLowerCommandCommand( entity.getRaiseLowerCommandId() ) ).get();
			LOGGER.info( "-- Successfully deleted RaiseLowerCommand with id " + raiseLowerCommandId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RaiseLowerCommand with id " + raiseLowerCommandId );

			throw e;
		}
	}

	/**
	 * get all RaiseLowerCommands.
	 */
	protected List<RaiseLowerCommand> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RaiseLowerCommands:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RaiseLowerCommand : " );        
		List<RaiseLowerCommand> collection  = new ArrayList<>();

		try {
			// call the static get method on the RaiseLowerCommandBusinessDelegate
			collection = RaiseLowerCommandBusinessDelegate.getRaiseLowerCommandInstance().getAllRaiseLowerCommand();
			assertNotNull( collection, "An Empty collection of RaiseLowerCommand was incorrectly returned.");
			
			// Now print out the values
			RaiseLowerCommand entity = null;            
			Iterator<RaiseLowerCommand> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRaiseLowerCommandId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RaiseLowerCommandTest
	 */
	protected RaiseLowerCommandTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RaiseLowerCommand
	 * 
	 * @return CreateRaiseLowerCommandCommand alias
	 */
	protected CreateRaiseLowerCommandCommand generateNewCommand() {
        CreateRaiseLowerCommandCommand command = new CreateRaiseLowerCommandCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated RaiseLowerCommand
		 * 
		 * @return UpdateRaiseLowerCommandCommand alias
		 */
	protected UpdateRaiseLowerCommandCommand generateUpdateCommand() {
	        UpdateRaiseLowerCommandCommand command = new UpdateRaiseLowerCommandCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID raiseLowerCommandId = null;
	protected RaiseLowerCommandSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RaiseLowerCommandTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRaiseLowerCommandList = 0;
}
