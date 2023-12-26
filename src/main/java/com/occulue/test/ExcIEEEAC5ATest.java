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
 * Test ExcIEEEAC5A class.
 *
 * @author your_name_here
 */
public class ExcIEEEAC5ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEAC5ATest() {
		subscriber = new ExcIEEEAC5ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEAC5ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEAC5A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEAC5A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEAC5AId = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance()
		.createExcIEEEAC5A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance()
				.createExcIEEEAC5A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEAC5ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEAC5A : " + successValue.getExcIEEEAC5AId());
							  if (successValue.getExcIEEEAC5AId().equals(excIEEEAC5AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEAC5AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEAC5A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC5A consumed")
					);
			subscriber.excIEEEAC5ASubscribe( excIEEEAC5AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEAC5A : " + successValue.getExcIEEEAC5AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEAC5AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC5A for excIEEEAC5AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEAC5A. 
	 */
	protected ExcIEEEAC5A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEAC5A" );

		ExcIEEEAC5A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEAC5A with primary key" );
		msg.append( excIEEEAC5AId );
		
		ExcIEEEAC5AFetchOneSummary fetchOneSummary = new ExcIEEEAC5AFetchOneSummary( excIEEEAC5AId );

		try {
			entity = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().getExcIEEEAC5A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEAC5A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEAC5A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEAC5A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEAC5A : " );        
		ExcIEEEAC5A entity = read();
		UpdateExcIEEEAC5ACommand command = generateUpdateCommand();
		command.setExcIEEEAC5AId(entity.getExcIEEEAC5AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEAC5A." );

			// for use later on...
			excIEEEAC5AId = entity.getExcIEEEAC5AId();

			ExcIEEEAC5ABusinessDelegate proxy = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance();  

			proxy.updateExcIEEEAC5A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEAC5A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEAC5AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEAC5A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEAC5A." );

		ExcIEEEAC5A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEAC5A with id " + excIEEEAC5AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEAC5A with id " + excIEEEAC5AId );

			throw e;
		}

		try{
			ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().delete( new DeleteExcIEEEAC5ACommand( entity.getExcIEEEAC5AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEAC5A with id " + excIEEEAC5AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEAC5A with id " + excIEEEAC5AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEAC5As.
	 */
	protected List<ExcIEEEAC5A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEAC5As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEAC5A : " );        
		List<ExcIEEEAC5A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEAC5ABusinessDelegate
			collection = ExcIEEEAC5ABusinessDelegate.getExcIEEEAC5AInstance().getAllExcIEEEAC5A();
			assertNotNull( collection, "An Empty collection of ExcIEEEAC5A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEAC5A entity = null;            
			Iterator<ExcIEEEAC5A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEAC5AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEAC5ATest
	 */
	protected ExcIEEEAC5ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEAC5A
	 * 
	 * @return CreateExcIEEEAC5ACommand alias
	 */
	protected CreateExcIEEEAC5ACommand generateNewCommand() {
        CreateExcIEEEAC5ACommand command = new CreateExcIEEEAC5ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEAC5A
		 * 
		 * @return UpdateExcIEEEAC5ACommand alias
		 */
	protected UpdateExcIEEEAC5ACommand generateUpdateCommand() {
	        UpdateExcIEEEAC5ACommand command = new UpdateExcIEEEAC5ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEAC5AId = null;
	protected ExcIEEEAC5ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEAC5ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEAC5AList = 0;
}
