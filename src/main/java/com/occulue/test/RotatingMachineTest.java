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
 * Test RotatingMachine class.
 *
 * @author your_name_here
 */
public class RotatingMachineTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RotatingMachineTest() {
		subscriber = new RotatingMachineSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RotatingMachineTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RotatingMachine...");
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
	 * jumpstart the process by instantiating2 RotatingMachine
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		rotatingMachineId = RotatingMachineBusinessDelegate.getRotatingMachineInstance()
		.createRotatingMachine( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RotatingMachineBusinessDelegate.getRotatingMachineInstance()
				.createRotatingMachine( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.rotatingMachineSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RotatingMachine : " + successValue.getRotatingMachineId());
							  if (successValue.getRotatingMachineId().equals(rotatingMachineId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRotatingMachineList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RotatingMachine test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotatingMachine consumed")
					);
			subscriber.rotatingMachineSubscribe( rotatingMachineId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RotatingMachine : " + successValue.getRotatingMachineId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRotatingMachineList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotatingMachine for rotatingMachineId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RotatingMachine. 
	 */
	protected RotatingMachine read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RotatingMachine" );

		RotatingMachine entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RotatingMachine with primary key" );
		msg.append( rotatingMachineId );
		
		RotatingMachineFetchOneSummary fetchOneSummary = new RotatingMachineFetchOneSummary( rotatingMachineId );

		try {
			entity = RotatingMachineBusinessDelegate.getRotatingMachineInstance().getRotatingMachine( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RotatingMachine " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RotatingMachine.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RotatingMachine." );

		StringBuilder msg = new StringBuilder( "Failed to update a RotatingMachine : " );        
		RotatingMachine entity = read();
		UpdateRotatingMachineCommand command = generateUpdateCommand();
		command.setRotatingMachineId(entity.getRotatingMachineId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RotatingMachine." );

			// for use later on...
			rotatingMachineId = entity.getRotatingMachineId();

			RotatingMachineBusinessDelegate proxy = RotatingMachineBusinessDelegate.getRotatingMachineInstance();  

			proxy.updateRotatingMachine( command ).get();

			LOGGER.info( "-- Successfully saved RotatingMachine - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + rotatingMachineId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RotatingMachine.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RotatingMachine." );

		RotatingMachine entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RotatingMachine with id " + rotatingMachineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RotatingMachine with id " + rotatingMachineId );

			throw e;
		}

		try{
			RotatingMachineBusinessDelegate.getRotatingMachineInstance().delete( new DeleteRotatingMachineCommand( entity.getRotatingMachineId() ) ).get();
			LOGGER.info( "-- Successfully deleted RotatingMachine with id " + rotatingMachineId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RotatingMachine with id " + rotatingMachineId );

			throw e;
		}
	}

	/**
	 * get all RotatingMachines.
	 */
	protected List<RotatingMachine> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RotatingMachines:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RotatingMachine : " );        
		List<RotatingMachine> collection  = new ArrayList<>();

		try {
			// call the static get method on the RotatingMachineBusinessDelegate
			collection = RotatingMachineBusinessDelegate.getRotatingMachineInstance().getAllRotatingMachine();
			assertNotNull( collection, "An Empty collection of RotatingMachine was incorrectly returned.");
			
			// Now print out the values
			RotatingMachine entity = null;            
			Iterator<RotatingMachine> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRotatingMachineId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RotatingMachineTest
	 */
	protected RotatingMachineTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RotatingMachine
	 * 
	 * @return CreateRotatingMachineCommand alias
	 */
	protected CreateRotatingMachineCommand generateNewCommand() {
        CreateRotatingMachineCommand command = new CreateRotatingMachineCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RotatingMachine
		 * 
		 * @return UpdateRotatingMachineCommand alias
		 */
	protected UpdateRotatingMachineCommand generateUpdateCommand() {
	        UpdateRotatingMachineCommand command = new UpdateRotatingMachineCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID rotatingMachineId = null;
	protected RotatingMachineSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RotatingMachineTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRotatingMachineList = 0;
}
