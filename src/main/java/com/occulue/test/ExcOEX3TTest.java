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
 * Test ExcOEX3T class.
 *
 * @author your_name_here
 */
public class ExcOEX3TTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcOEX3TTest() {
		subscriber = new ExcOEX3TSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcOEX3TTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcOEX3T...");
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
	 * jumpstart the process by instantiating2 ExcOEX3T
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excOEX3TId = ExcOEX3TBusinessDelegate.getExcOEX3TInstance()
		.createExcOEX3T( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcOEX3TBusinessDelegate.getExcOEX3TInstance()
				.createExcOEX3T( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excOEX3TSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcOEX3T : " + successValue.getExcOEX3TId());
							  if (successValue.getExcOEX3TId().equals(excOEX3TId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcOEX3TList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcOEX3T test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excOEX3T consumed")
					);
			subscriber.excOEX3TSubscribe( excOEX3TId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcOEX3T : " + successValue.getExcOEX3TId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcOEX3TList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excOEX3T for excOEX3TId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcOEX3T. 
	 */
	protected ExcOEX3T read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcOEX3T" );

		ExcOEX3T entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcOEX3T with primary key" );
		msg.append( excOEX3TId );
		
		ExcOEX3TFetchOneSummary fetchOneSummary = new ExcOEX3TFetchOneSummary( excOEX3TId );

		try {
			entity = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().getExcOEX3T( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcOEX3T " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcOEX3T.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcOEX3T." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcOEX3T : " );        
		ExcOEX3T entity = read();
		UpdateExcOEX3TCommand command = generateUpdateCommand();
		command.setExcOEX3TId(entity.getExcOEX3TId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcOEX3T." );

			// for use later on...
			excOEX3TId = entity.getExcOEX3TId();

			ExcOEX3TBusinessDelegate proxy = ExcOEX3TBusinessDelegate.getExcOEX3TInstance();  

			proxy.updateExcOEX3T( command ).get();

			LOGGER.info( "-- Successfully saved ExcOEX3T - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excOEX3TId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcOEX3T.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcOEX3T." );

		ExcOEX3T entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcOEX3T with id " + excOEX3TId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcOEX3T with id " + excOEX3TId );

			throw e;
		}

		try{
			ExcOEX3TBusinessDelegate.getExcOEX3TInstance().delete( new DeleteExcOEX3TCommand( entity.getExcOEX3TId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcOEX3T with id " + excOEX3TId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcOEX3T with id " + excOEX3TId );

			throw e;
		}
	}

	/**
	 * get all ExcOEX3Ts.
	 */
	protected List<ExcOEX3T> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcOEX3Ts:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcOEX3T : " );        
		List<ExcOEX3T> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcOEX3TBusinessDelegate
			collection = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().getAllExcOEX3T();
			assertNotNull( collection, "An Empty collection of ExcOEX3T was incorrectly returned.");
			
			// Now print out the values
			ExcOEX3T entity = null;            
			Iterator<ExcOEX3T> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcOEX3TId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcOEX3TTest
	 */
	protected ExcOEX3TTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcOEX3T
	 * 
	 * @return CreateExcOEX3TCommand alias
	 */
	protected CreateExcOEX3TCommand generateNewCommand() {
        CreateExcOEX3TCommand command = new CreateExcOEX3TCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcOEX3T
		 * 
		 * @return UpdateExcOEX3TCommand alias
		 */
	protected UpdateExcOEX3TCommand generateUpdateCommand() {
	        UpdateExcOEX3TCommand command = new UpdateExcOEX3TCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excOEX3TId = null;
	protected ExcOEX3TSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcOEX3TTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcOEX3TList = 0;
}
