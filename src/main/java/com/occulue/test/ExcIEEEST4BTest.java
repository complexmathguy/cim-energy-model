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
 * Test ExcIEEEST4B class.
 *
 * @author your_name_here
 */
public class ExcIEEEST4BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEST4BTest() {
		subscriber = new ExcIEEEST4BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEST4BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEST4B...");
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
	 * jumpstart the process by instantiating2 ExcIEEEST4B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEST4BId = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance()
		.createExcIEEEST4B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance()
				.createExcIEEEST4B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEST4BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEST4B : " + successValue.getExcIEEEST4BId());
							  if (successValue.getExcIEEEST4BId().equals(excIEEEST4BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEST4BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEST4B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST4B consumed")
					);
			subscriber.excIEEEST4BSubscribe( excIEEEST4BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEST4B : " + successValue.getExcIEEEST4BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEST4BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST4B for excIEEEST4BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEST4B. 
	 */
	protected ExcIEEEST4B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEST4B" );

		ExcIEEEST4B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEST4B with primary key" );
		msg.append( excIEEEST4BId );
		
		ExcIEEEST4BFetchOneSummary fetchOneSummary = new ExcIEEEST4BFetchOneSummary( excIEEEST4BId );

		try {
			entity = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().getExcIEEEST4B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEST4B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEST4B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEST4B." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEST4B : " );        
		ExcIEEEST4B entity = read();
		UpdateExcIEEEST4BCommand command = generateUpdateCommand();
		command.setExcIEEEST4BId(entity.getExcIEEEST4BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEST4B." );

			// for use later on...
			excIEEEST4BId = entity.getExcIEEEST4BId();

			ExcIEEEST4BBusinessDelegate proxy = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance();  

			proxy.updateExcIEEEST4B( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEST4B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEST4BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEST4B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEST4B." );

		ExcIEEEST4B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEST4B with id " + excIEEEST4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEST4B with id " + excIEEEST4BId );

			throw e;
		}

		try{
			ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().delete( new DeleteExcIEEEST4BCommand( entity.getExcIEEEST4BId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEST4B with id " + excIEEEST4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEST4B with id " + excIEEEST4BId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEST4Bs.
	 */
	protected List<ExcIEEEST4B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEST4Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEST4B : " );        
		List<ExcIEEEST4B> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEST4BBusinessDelegate
			collection = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().getAllExcIEEEST4B();
			assertNotNull( collection, "An Empty collection of ExcIEEEST4B was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEST4B entity = null;            
			Iterator<ExcIEEEST4B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEST4BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEST4BTest
	 */
	protected ExcIEEEST4BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEST4B
	 * 
	 * @return CreateExcIEEEST4BCommand alias
	 */
	protected CreateExcIEEEST4BCommand generateNewCommand() {
        CreateExcIEEEST4BCommand command = new CreateExcIEEEST4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEST4B
		 * 
		 * @return UpdateExcIEEEST4BCommand alias
		 */
	protected UpdateExcIEEEST4BCommand generateUpdateCommand() {
	        UpdateExcIEEEST4BCommand command = new UpdateExcIEEEST4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEST4BId = null;
	protected ExcIEEEST4BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEST4BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEST4BList = 0;
}
