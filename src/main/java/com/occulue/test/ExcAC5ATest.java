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
 * Test ExcAC5A class.
 *
 * @author your_name_here
 */
public class ExcAC5ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAC5ATest() {
		subscriber = new ExcAC5ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAC5ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAC5A...");
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
	 * jumpstart the process by instantiating2 ExcAC5A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAC5AId = ExcAC5ABusinessDelegate.getExcAC5AInstance()
		.createExcAC5A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAC5ABusinessDelegate.getExcAC5AInstance()
				.createExcAC5A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAC5ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAC5A : " + successValue.getExcAC5AId());
							  if (successValue.getExcAC5AId().equals(excAC5AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAC5AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAC5A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAC5A consumed")
					);
			subscriber.excAC5ASubscribe( excAC5AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAC5A : " + successValue.getExcAC5AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAC5AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAC5A for excAC5AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAC5A. 
	 */
	protected ExcAC5A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAC5A" );

		ExcAC5A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAC5A with primary key" );
		msg.append( excAC5AId );
		
		ExcAC5AFetchOneSummary fetchOneSummary = new ExcAC5AFetchOneSummary( excAC5AId );

		try {
			entity = ExcAC5ABusinessDelegate.getExcAC5AInstance().getExcAC5A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAC5A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAC5A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAC5A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAC5A : " );        
		ExcAC5A entity = read();
		UpdateExcAC5ACommand command = generateUpdateCommand();
		command.setExcAC5AId(entity.getExcAC5AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAC5A." );

			// for use later on...
			excAC5AId = entity.getExcAC5AId();

			ExcAC5ABusinessDelegate proxy = ExcAC5ABusinessDelegate.getExcAC5AInstance();  

			proxy.updateExcAC5A( command ).get();

			LOGGER.info( "-- Successfully saved ExcAC5A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAC5AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAC5A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAC5A." );

		ExcAC5A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAC5A with id " + excAC5AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAC5A with id " + excAC5AId );

			throw e;
		}

		try{
			ExcAC5ABusinessDelegate.getExcAC5AInstance().delete( new DeleteExcAC5ACommand( entity.getExcAC5AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAC5A with id " + excAC5AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAC5A with id " + excAC5AId );

			throw e;
		}
	}

	/**
	 * get all ExcAC5As.
	 */
	protected List<ExcAC5A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAC5As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAC5A : " );        
		List<ExcAC5A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAC5ABusinessDelegate
			collection = ExcAC5ABusinessDelegate.getExcAC5AInstance().getAllExcAC5A();
			assertNotNull( collection, "An Empty collection of ExcAC5A was incorrectly returned.");
			
			// Now print out the values
			ExcAC5A entity = null;            
			Iterator<ExcAC5A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAC5AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAC5ATest
	 */
	protected ExcAC5ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAC5A
	 * 
	 * @return CreateExcAC5ACommand alias
	 */
	protected CreateExcAC5ACommand generateNewCommand() {
        CreateExcAC5ACommand command = new CreateExcAC5ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAC5A
		 * 
		 * @return UpdateExcAC5ACommand alias
		 */
	protected UpdateExcAC5ACommand generateUpdateCommand() {
	        UpdateExcAC5ACommand command = new UpdateExcAC5ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAC5AId = null;
	protected ExcAC5ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAC5ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAC5AList = 0;
}
