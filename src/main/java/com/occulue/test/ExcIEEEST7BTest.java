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
 * Test ExcIEEEST7B class.
 *
 * @author your_name_here
 */
public class ExcIEEEST7BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEST7BTest() {
		subscriber = new ExcIEEEST7BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEST7BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEST7B...");
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
	 * jumpstart the process by instantiating2 ExcIEEEST7B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEST7BId = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance()
		.createExcIEEEST7B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance()
				.createExcIEEEST7B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEST7BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEST7B : " + successValue.getExcIEEEST7BId());
							  if (successValue.getExcIEEEST7BId().equals(excIEEEST7BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEST7BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEST7B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST7B consumed")
					);
			subscriber.excIEEEST7BSubscribe( excIEEEST7BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEST7B : " + successValue.getExcIEEEST7BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEST7BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEST7B for excIEEEST7BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEST7B. 
	 */
	protected ExcIEEEST7B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEST7B" );

		ExcIEEEST7B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEST7B with primary key" );
		msg.append( excIEEEST7BId );
		
		ExcIEEEST7BFetchOneSummary fetchOneSummary = new ExcIEEEST7BFetchOneSummary( excIEEEST7BId );

		try {
			entity = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().getExcIEEEST7B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEST7B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEST7B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEST7B." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEST7B : " );        
		ExcIEEEST7B entity = read();
		UpdateExcIEEEST7BCommand command = generateUpdateCommand();
		command.setExcIEEEST7BId(entity.getExcIEEEST7BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEST7B." );

			// for use later on...
			excIEEEST7BId = entity.getExcIEEEST7BId();

			ExcIEEEST7BBusinessDelegate proxy = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance();  

			proxy.updateExcIEEEST7B( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEST7B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEST7BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEST7B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEST7B." );

		ExcIEEEST7B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEST7B with id " + excIEEEST7BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEST7B with id " + excIEEEST7BId );

			throw e;
		}

		try{
			ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().delete( new DeleteExcIEEEST7BCommand( entity.getExcIEEEST7BId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEST7B with id " + excIEEEST7BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEST7B with id " + excIEEEST7BId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEST7Bs.
	 */
	protected List<ExcIEEEST7B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEST7Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEST7B : " );        
		List<ExcIEEEST7B> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEST7BBusinessDelegate
			collection = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().getAllExcIEEEST7B();
			assertNotNull( collection, "An Empty collection of ExcIEEEST7B was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEST7B entity = null;            
			Iterator<ExcIEEEST7B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEST7BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEST7BTest
	 */
	protected ExcIEEEST7BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEST7B
	 * 
	 * @return CreateExcIEEEST7BCommand alias
	 */
	protected CreateExcIEEEST7BCommand generateNewCommand() {
        CreateExcIEEEST7BCommand command = new CreateExcIEEEST7BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEST7B
		 * 
		 * @return UpdateExcIEEEST7BCommand alias
		 */
	protected UpdateExcIEEEST7BCommand generateUpdateCommand() {
	        UpdateExcIEEEST7BCommand command = new UpdateExcIEEEST7BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEST7BId = null;
	protected ExcIEEEST7BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEST7BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEST7BList = 0;
}
