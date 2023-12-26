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
 * Test ExcIEEEST6B class.
 *
 * @author your_name_here
 */
public class ExcIEEEST6BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEST6BTest() {
		subscriber = new ExcIEEEST6BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEST6BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEST6B...");
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
	 * jumpstart the process by instantiating2 ExcIEEEST6B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEST6BId = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance()
		.createExcIEEEST6B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance()
				.createExcIEEEST6B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEST6BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEST6B : " + successValue.getExcIEEEST6BId());
							  if (successValue.getExcIEEEST6BId().equals(excIEEEST6BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEST6BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEST6B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST6B consumed")
					);
			subscriber.excIEEEST6BSubscribe( excIEEEST6BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEST6B : " + successValue.getExcIEEEST6BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEST6BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST6B for excIEEEST6BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEST6B. 
	 */
	protected ExcIEEEST6B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEST6B" );

		ExcIEEEST6B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEST6B with primary key" );
		msg.append( excIEEEST6BId );
		
		ExcIEEEST6BFetchOneSummary fetchOneSummary = new ExcIEEEST6BFetchOneSummary( excIEEEST6BId );

		try {
			entity = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().getExcIEEEST6B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEST6B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEST6B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEST6B." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEST6B : " );        
		ExcIEEEST6B entity = read();
		UpdateExcIEEEST6BCommand command = generateUpdateCommand();
		command.setExcIEEEST6BId(entity.getExcIEEEST6BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEST6B." );

			// for use later on...
			excIEEEST6BId = entity.getExcIEEEST6BId();

			ExcIEEEST6BBusinessDelegate proxy = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();  

			proxy.updateExcIEEEST6B( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEST6B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEST6BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEST6B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEST6B." );

		ExcIEEEST6B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEST6B with id " + excIEEEST6BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEST6B with id " + excIEEEST6BId );

			throw e;
		}

		try{
			ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().delete( new DeleteExcIEEEST6BCommand( entity.getExcIEEEST6BId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEST6B with id " + excIEEEST6BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEST6B with id " + excIEEEST6BId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEST6Bs.
	 */
	protected List<ExcIEEEST6B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEST6Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEST6B : " );        
		List<ExcIEEEST6B> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEST6BBusinessDelegate
			collection = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().getAllExcIEEEST6B();
			assertNotNull( collection, "An Empty collection of ExcIEEEST6B was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEST6B entity = null;            
			Iterator<ExcIEEEST6B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEST6BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEST6BTest
	 */
	protected ExcIEEEST6BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEST6B
	 * 
	 * @return CreateExcIEEEST6BCommand alias
	 */
	protected CreateExcIEEEST6BCommand generateNewCommand() {
        CreateExcIEEEST6BCommand command = new CreateExcIEEEST6BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEST6B
		 * 
		 * @return UpdateExcIEEEST6BCommand alias
		 */
	protected UpdateExcIEEEST6BCommand generateUpdateCommand() {
	        UpdateExcIEEEST6BCommand command = new UpdateExcIEEEST6BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEST6BId = null;
	protected ExcIEEEST6BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEST6BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEST6BList = 0;
}
