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
 * Test LoadMotor class.
 *
 * @author your_name_here
 */
public class LoadMotorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadMotorTest() {
		subscriber = new LoadMotorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadMotorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadMotor...");
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
	 * jumpstart the process by instantiating2 LoadMotor
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadMotorId = LoadMotorBusinessDelegate.getLoadMotorInstance()
		.createLoadMotor( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadMotorBusinessDelegate.getLoadMotorInstance()
				.createLoadMotor( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadMotorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadMotor : " + successValue.getLoadMotorId());
							  if (successValue.getLoadMotorId().equals(loadMotorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadMotorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadMotor test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadMotor consumed")
					);
			subscriber.loadMotorSubscribe( loadMotorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadMotor : " + successValue.getLoadMotorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadMotorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadMotor for loadMotorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadMotor. 
	 */
	protected LoadMotor read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadMotor" );

		LoadMotor entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadMotor with primary key" );
		msg.append( loadMotorId );
		
		LoadMotorFetchOneSummary fetchOneSummary = new LoadMotorFetchOneSummary( loadMotorId );

		try {
			entity = LoadMotorBusinessDelegate.getLoadMotorInstance().getLoadMotor( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadMotor " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadMotor.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadMotor." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadMotor : " );        
		LoadMotor entity = read();
		UpdateLoadMotorCommand command = generateUpdateCommand();
		command.setLoadMotorId(entity.getLoadMotorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadMotor." );

			// for use later on...
			loadMotorId = entity.getLoadMotorId();

			LoadMotorBusinessDelegate proxy = LoadMotorBusinessDelegate.getLoadMotorInstance();  

			proxy.updateLoadMotor( command ).get();

			LOGGER.info( "-- Successfully saved LoadMotor - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadMotorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadMotor.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadMotor." );

		LoadMotor entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadMotor with id " + loadMotorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadMotor with id " + loadMotorId );

			throw e;
		}

		try{
			LoadMotorBusinessDelegate.getLoadMotorInstance().delete( new DeleteLoadMotorCommand( entity.getLoadMotorId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadMotor with id " + loadMotorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadMotor with id " + loadMotorId );

			throw e;
		}
	}

	/**
	 * get all LoadMotors.
	 */
	protected List<LoadMotor> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadMotors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadMotor : " );        
		List<LoadMotor> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadMotorBusinessDelegate
			collection = LoadMotorBusinessDelegate.getLoadMotorInstance().getAllLoadMotor();
			assertNotNull( collection, "An Empty collection of LoadMotor was incorrectly returned.");
			
			// Now print out the values
			LoadMotor entity = null;            
			Iterator<LoadMotor> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadMotorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadMotorTest
	 */
	protected LoadMotorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadMotor
	 * 
	 * @return CreateLoadMotorCommand alias
	 */
	protected CreateLoadMotorCommand generateNewCommand() {
        CreateLoadMotorCommand command = new CreateLoadMotorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadMotor
		 * 
		 * @return UpdateLoadMotorCommand alias
		 */
	protected UpdateLoadMotorCommand generateUpdateCommand() {
	        UpdateLoadMotorCommand command = new UpdateLoadMotorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadMotorId = null;
	protected LoadMotorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadMotorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadMotorList = 0;
}
