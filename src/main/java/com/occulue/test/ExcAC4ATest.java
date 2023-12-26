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
 * Test ExcAC4A class.
 *
 * @author your_name_here
 */
public class ExcAC4ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAC4ATest() {
		subscriber = new ExcAC4ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAC4ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAC4A...");
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
	 * jumpstart the process by instantiating2 ExcAC4A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAC4AId = ExcAC4ABusinessDelegate.getExcAC4AInstance()
		.createExcAC4A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAC4ABusinessDelegate.getExcAC4AInstance()
				.createExcAC4A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAC4ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAC4A : " + successValue.getExcAC4AId());
							  if (successValue.getExcAC4AId().equals(excAC4AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAC4AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAC4A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAC4A consumed")
					);
			subscriber.excAC4ASubscribe( excAC4AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAC4A : " + successValue.getExcAC4AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAC4AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAC4A for excAC4AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAC4A. 
	 */
	protected ExcAC4A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAC4A" );

		ExcAC4A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAC4A with primary key" );
		msg.append( excAC4AId );
		
		ExcAC4AFetchOneSummary fetchOneSummary = new ExcAC4AFetchOneSummary( excAC4AId );

		try {
			entity = ExcAC4ABusinessDelegate.getExcAC4AInstance().getExcAC4A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAC4A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAC4A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAC4A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAC4A : " );        
		ExcAC4A entity = read();
		UpdateExcAC4ACommand command = generateUpdateCommand();
		command.setExcAC4AId(entity.getExcAC4AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAC4A." );

			// for use later on...
			excAC4AId = entity.getExcAC4AId();

			ExcAC4ABusinessDelegate proxy = ExcAC4ABusinessDelegate.getExcAC4AInstance();  

			proxy.updateExcAC4A( command ).get();

			LOGGER.info( "-- Successfully saved ExcAC4A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAC4AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAC4A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAC4A." );

		ExcAC4A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAC4A with id " + excAC4AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAC4A with id " + excAC4AId );

			throw e;
		}

		try{
			ExcAC4ABusinessDelegate.getExcAC4AInstance().delete( new DeleteExcAC4ACommand( entity.getExcAC4AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAC4A with id " + excAC4AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAC4A with id " + excAC4AId );

			throw e;
		}
	}

	/**
	 * get all ExcAC4As.
	 */
	protected List<ExcAC4A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAC4As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAC4A : " );        
		List<ExcAC4A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAC4ABusinessDelegate
			collection = ExcAC4ABusinessDelegate.getExcAC4AInstance().getAllExcAC4A();
			assertNotNull( collection, "An Empty collection of ExcAC4A was incorrectly returned.");
			
			// Now print out the values
			ExcAC4A entity = null;            
			Iterator<ExcAC4A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAC4AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAC4ATest
	 */
	protected ExcAC4ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAC4A
	 * 
	 * @return CreateExcAC4ACommand alias
	 */
	protected CreateExcAC4ACommand generateNewCommand() {
        CreateExcAC4ACommand command = new CreateExcAC4ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAC4A
		 * 
		 * @return UpdateExcAC4ACommand alias
		 */
	protected UpdateExcAC4ACommand generateUpdateCommand() {
	        UpdateExcAC4ACommand command = new UpdateExcAC4ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAC4AId = null;
	protected ExcAC4ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAC4ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAC4AList = 0;
}
