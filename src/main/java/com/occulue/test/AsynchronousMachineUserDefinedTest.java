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
 * Test AsynchronousMachineUserDefined class.
 *
 * @author your_name_here
 */
public class AsynchronousMachineUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AsynchronousMachineUserDefinedTest() {
		subscriber = new AsynchronousMachineUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AsynchronousMachineUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AsynchronousMachineUserDefined...");
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
	 * jumpstart the process by instantiating2 AsynchronousMachineUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		asynchronousMachineUserDefinedId = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
		.createAsynchronousMachineUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance()
				.createAsynchronousMachineUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.asynchronousMachineUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AsynchronousMachineUserDefined : " + successValue.getAsynchronousMachineUserDefinedId());
							  if (successValue.getAsynchronousMachineUserDefinedId().equals(asynchronousMachineUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAsynchronousMachineUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AsynchronousMachineUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineUserDefined consumed")
					);
			subscriber.asynchronousMachineUserDefinedSubscribe( asynchronousMachineUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AsynchronousMachineUserDefined : " + successValue.getAsynchronousMachineUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAsynchronousMachineUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on asynchronousMachineUserDefined for asynchronousMachineUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AsynchronousMachineUserDefined. 
	 */
	protected AsynchronousMachineUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AsynchronousMachineUserDefined" );

		AsynchronousMachineUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AsynchronousMachineUserDefined with primary key" );
		msg.append( asynchronousMachineUserDefinedId );
		
		AsynchronousMachineUserDefinedFetchOneSummary fetchOneSummary = new AsynchronousMachineUserDefinedFetchOneSummary( asynchronousMachineUserDefinedId );

		try {
			entity = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().getAsynchronousMachineUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AsynchronousMachineUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AsynchronousMachineUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AsynchronousMachineUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a AsynchronousMachineUserDefined : " );        
		AsynchronousMachineUserDefined entity = read();
		UpdateAsynchronousMachineUserDefinedCommand command = generateUpdateCommand();
		command.setAsynchronousMachineUserDefinedId(entity.getAsynchronousMachineUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AsynchronousMachineUserDefined." );

			// for use later on...
			asynchronousMachineUserDefinedId = entity.getAsynchronousMachineUserDefinedId();

			AsynchronousMachineUserDefinedBusinessDelegate proxy = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance();  

			proxy.updateAsynchronousMachineUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved AsynchronousMachineUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + asynchronousMachineUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AsynchronousMachineUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AsynchronousMachineUserDefined." );

		AsynchronousMachineUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AsynchronousMachineUserDefined with id " + asynchronousMachineUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AsynchronousMachineUserDefined with id " + asynchronousMachineUserDefinedId );

			throw e;
		}

		try{
			AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().delete( new DeleteAsynchronousMachineUserDefinedCommand( entity.getAsynchronousMachineUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted AsynchronousMachineUserDefined with id " + asynchronousMachineUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AsynchronousMachineUserDefined with id " + asynchronousMachineUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all AsynchronousMachineUserDefineds.
	 */
	protected List<AsynchronousMachineUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AsynchronousMachineUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AsynchronousMachineUserDefined : " );        
		List<AsynchronousMachineUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the AsynchronousMachineUserDefinedBusinessDelegate
			collection = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().getAllAsynchronousMachineUserDefined();
			assertNotNull( collection, "An Empty collection of AsynchronousMachineUserDefined was incorrectly returned.");
			
			// Now print out the values
			AsynchronousMachineUserDefined entity = null;            
			Iterator<AsynchronousMachineUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAsynchronousMachineUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AsynchronousMachineUserDefinedTest
	 */
	protected AsynchronousMachineUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AsynchronousMachineUserDefined
	 * 
	 * @return CreateAsynchronousMachineUserDefinedCommand alias
	 */
	protected CreateAsynchronousMachineUserDefinedCommand generateNewCommand() {
        CreateAsynchronousMachineUserDefinedCommand command = new CreateAsynchronousMachineUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AsynchronousMachineUserDefined
		 * 
		 * @return UpdateAsynchronousMachineUserDefinedCommand alias
		 */
	protected UpdateAsynchronousMachineUserDefinedCommand generateUpdateCommand() {
	        UpdateAsynchronousMachineUserDefinedCommand command = new UpdateAsynchronousMachineUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID asynchronousMachineUserDefinedId = null;
	protected AsynchronousMachineUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AsynchronousMachineUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAsynchronousMachineUserDefinedList = 0;
}
