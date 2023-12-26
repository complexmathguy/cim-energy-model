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
 * Test ExcIEEEST3A class.
 *
 * @author your_name_here
 */
public class ExcIEEEST3ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEST3ATest() {
		subscriber = new ExcIEEEST3ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEST3ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEST3A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEST3A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEST3AId = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance()
		.createExcIEEEST3A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance()
				.createExcIEEEST3A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEST3ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEST3A : " + successValue.getExcIEEEST3AId());
							  if (successValue.getExcIEEEST3AId().equals(excIEEEST3AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEST3AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEST3A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST3A consumed")
					);
			subscriber.excIEEEST3ASubscribe( excIEEEST3AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEST3A : " + successValue.getExcIEEEST3AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEST3AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST3A for excIEEEST3AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEST3A. 
	 */
	protected ExcIEEEST3A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEST3A" );

		ExcIEEEST3A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEST3A with primary key" );
		msg.append( excIEEEST3AId );
		
		ExcIEEEST3AFetchOneSummary fetchOneSummary = new ExcIEEEST3AFetchOneSummary( excIEEEST3AId );

		try {
			entity = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().getExcIEEEST3A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEST3A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEST3A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEST3A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEST3A : " );        
		ExcIEEEST3A entity = read();
		UpdateExcIEEEST3ACommand command = generateUpdateCommand();
		command.setExcIEEEST3AId(entity.getExcIEEEST3AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEST3A." );

			// for use later on...
			excIEEEST3AId = entity.getExcIEEEST3AId();

			ExcIEEEST3ABusinessDelegate proxy = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance();  

			proxy.updateExcIEEEST3A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEST3A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEST3AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEST3A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEST3A." );

		ExcIEEEST3A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEST3A with id " + excIEEEST3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEST3A with id " + excIEEEST3AId );

			throw e;
		}

		try{
			ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().delete( new DeleteExcIEEEST3ACommand( entity.getExcIEEEST3AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEST3A with id " + excIEEEST3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEST3A with id " + excIEEEST3AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEST3As.
	 */
	protected List<ExcIEEEST3A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEST3As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEST3A : " );        
		List<ExcIEEEST3A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEST3ABusinessDelegate
			collection = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().getAllExcIEEEST3A();
			assertNotNull( collection, "An Empty collection of ExcIEEEST3A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEST3A entity = null;            
			Iterator<ExcIEEEST3A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEST3AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEST3ATest
	 */
	protected ExcIEEEST3ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEST3A
	 * 
	 * @return CreateExcIEEEST3ACommand alias
	 */
	protected CreateExcIEEEST3ACommand generateNewCommand() {
        CreateExcIEEEST3ACommand command = new CreateExcIEEEST3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEST3A
		 * 
		 * @return UpdateExcIEEEST3ACommand alias
		 */
	protected UpdateExcIEEEST3ACommand generateUpdateCommand() {
	        UpdateExcIEEEST3ACommand command = new UpdateExcIEEEST3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEST3AId = null;
	protected ExcIEEEST3ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEST3ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEST3AList = 0;
}
