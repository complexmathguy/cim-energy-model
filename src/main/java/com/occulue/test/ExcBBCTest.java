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
 * Test ExcBBC class.
 *
 * @author your_name_here
 */
public class ExcBBCTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcBBCTest() {
		subscriber = new ExcBBCSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcBBCTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcBBC...");
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
	 * jumpstart the process by instantiating2 ExcBBC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excBBCId = ExcBBCBusinessDelegate.getExcBBCInstance()
		.createExcBBC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcBBCBusinessDelegate.getExcBBCInstance()
				.createExcBBC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excBBCSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcBBC : " + successValue.getExcBBCId());
							  if (successValue.getExcBBCId().equals(excBBCId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcBBCList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcBBC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excBBC consumed")
					);
			subscriber.excBBCSubscribe( excBBCId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcBBC : " + successValue.getExcBBCId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcBBCList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excBBC for excBBCId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcBBC. 
	 */
	protected ExcBBC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcBBC" );

		ExcBBC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcBBC with primary key" );
		msg.append( excBBCId );
		
		ExcBBCFetchOneSummary fetchOneSummary = new ExcBBCFetchOneSummary( excBBCId );

		try {
			entity = ExcBBCBusinessDelegate.getExcBBCInstance().getExcBBC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcBBC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcBBC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcBBC." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcBBC : " );        
		ExcBBC entity = read();
		UpdateExcBBCCommand command = generateUpdateCommand();
		command.setExcBBCId(entity.getExcBBCId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcBBC." );

			// for use later on...
			excBBCId = entity.getExcBBCId();

			ExcBBCBusinessDelegate proxy = ExcBBCBusinessDelegate.getExcBBCInstance();  

			proxy.updateExcBBC( command ).get();

			LOGGER.info( "-- Successfully saved ExcBBC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excBBCId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcBBC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcBBC." );

		ExcBBC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcBBC with id " + excBBCId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcBBC with id " + excBBCId );

			throw e;
		}

		try{
			ExcBBCBusinessDelegate.getExcBBCInstance().delete( new DeleteExcBBCCommand( entity.getExcBBCId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcBBC with id " + excBBCId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcBBC with id " + excBBCId );

			throw e;
		}
	}

	/**
	 * get all ExcBBCs.
	 */
	protected List<ExcBBC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcBBCs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcBBC : " );        
		List<ExcBBC> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcBBCBusinessDelegate
			collection = ExcBBCBusinessDelegate.getExcBBCInstance().getAllExcBBC();
			assertNotNull( collection, "An Empty collection of ExcBBC was incorrectly returned.");
			
			// Now print out the values
			ExcBBC entity = null;            
			Iterator<ExcBBC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcBBCId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcBBCTest
	 */
	protected ExcBBCTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcBBC
	 * 
	 * @return CreateExcBBCCommand alias
	 */
	protected CreateExcBBCCommand generateNewCommand() {
        CreateExcBBCCommand command = new CreateExcBBCCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcBBC
		 * 
		 * @return UpdateExcBBCCommand alias
		 */
	protected UpdateExcBBCCommand generateUpdateCommand() {
	        UpdateExcBBCCommand command = new UpdateExcBBCCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excBBCId = null;
	protected ExcBBCSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcBBCTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcBBCList = 0;
}
