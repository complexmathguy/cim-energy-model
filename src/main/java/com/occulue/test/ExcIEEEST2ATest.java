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
 * Test ExcIEEEST2A class.
 *
 * @author your_name_here
 */
public class ExcIEEEST2ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEST2ATest() {
		subscriber = new ExcIEEEST2ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEST2ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEST2A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEST2A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEST2AId = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance()
		.createExcIEEEST2A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance()
				.createExcIEEEST2A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEST2ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEST2A : " + successValue.getExcIEEEST2AId());
							  if (successValue.getExcIEEEST2AId().equals(excIEEEST2AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEST2AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEST2A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST2A consumed")
					);
			subscriber.excIEEEST2ASubscribe( excIEEEST2AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEST2A : " + successValue.getExcIEEEST2AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEST2AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST2A for excIEEEST2AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEST2A. 
	 */
	protected ExcIEEEST2A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEST2A" );

		ExcIEEEST2A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEST2A with primary key" );
		msg.append( excIEEEST2AId );
		
		ExcIEEEST2AFetchOneSummary fetchOneSummary = new ExcIEEEST2AFetchOneSummary( excIEEEST2AId );

		try {
			entity = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().getExcIEEEST2A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEST2A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEST2A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEST2A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEST2A : " );        
		ExcIEEEST2A entity = read();
		UpdateExcIEEEST2ACommand command = generateUpdateCommand();
		command.setExcIEEEST2AId(entity.getExcIEEEST2AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEST2A." );

			// for use later on...
			excIEEEST2AId = entity.getExcIEEEST2AId();

			ExcIEEEST2ABusinessDelegate proxy = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance();  

			proxy.updateExcIEEEST2A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEST2A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEST2AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEST2A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEST2A." );

		ExcIEEEST2A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEST2A with id " + excIEEEST2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEST2A with id " + excIEEEST2AId );

			throw e;
		}

		try{
			ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().delete( new DeleteExcIEEEST2ACommand( entity.getExcIEEEST2AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEST2A with id " + excIEEEST2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEST2A with id " + excIEEEST2AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEST2As.
	 */
	protected List<ExcIEEEST2A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEST2As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEST2A : " );        
		List<ExcIEEEST2A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEST2ABusinessDelegate
			collection = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().getAllExcIEEEST2A();
			assertNotNull( collection, "An Empty collection of ExcIEEEST2A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEST2A entity = null;            
			Iterator<ExcIEEEST2A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEST2AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEST2ATest
	 */
	protected ExcIEEEST2ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEST2A
	 * 
	 * @return CreateExcIEEEST2ACommand alias
	 */
	protected CreateExcIEEEST2ACommand generateNewCommand() {
        CreateExcIEEEST2ACommand command = new CreateExcIEEEST2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEST2A
		 * 
		 * @return UpdateExcIEEEST2ACommand alias
		 */
	protected UpdateExcIEEEST2ACommand generateUpdateCommand() {
	        UpdateExcIEEEST2ACommand command = new UpdateExcIEEEST2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEST2AId = null;
	protected ExcIEEEST2ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEST2ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEST2AList = 0;
}
