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
 * Test ExcST4B class.
 *
 * @author your_name_here
 */
public class ExcST4BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcST4BTest() {
		subscriber = new ExcST4BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcST4BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcST4B...");
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
	 * jumpstart the process by instantiating2 ExcST4B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excST4BId = ExcST4BBusinessDelegate.getExcST4BInstance()
		.createExcST4B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcST4BBusinessDelegate.getExcST4BInstance()
				.createExcST4B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excST4BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcST4B : " + successValue.getExcST4BId());
							  if (successValue.getExcST4BId().equals(excST4BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcST4BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcST4B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excST4B consumed")
					);
			subscriber.excST4BSubscribe( excST4BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcST4B : " + successValue.getExcST4BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcST4BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excST4B for excST4BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcST4B. 
	 */
	protected ExcST4B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcST4B" );

		ExcST4B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcST4B with primary key" );
		msg.append( excST4BId );
		
		ExcST4BFetchOneSummary fetchOneSummary = new ExcST4BFetchOneSummary( excST4BId );

		try {
			entity = ExcST4BBusinessDelegate.getExcST4BInstance().getExcST4B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcST4B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcST4B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcST4B." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcST4B : " );        
		ExcST4B entity = read();
		UpdateExcST4BCommand command = generateUpdateCommand();
		command.setExcST4BId(entity.getExcST4BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcST4B." );

			// for use later on...
			excST4BId = entity.getExcST4BId();

			ExcST4BBusinessDelegate proxy = ExcST4BBusinessDelegate.getExcST4BInstance();  

			proxy.updateExcST4B( command ).get();

			LOGGER.info( "-- Successfully saved ExcST4B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excST4BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcST4B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcST4B." );

		ExcST4B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcST4B with id " + excST4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcST4B with id " + excST4BId );

			throw e;
		}

		try{
			ExcST4BBusinessDelegate.getExcST4BInstance().delete( new DeleteExcST4BCommand( entity.getExcST4BId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcST4B with id " + excST4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcST4B with id " + excST4BId );

			throw e;
		}
	}

	/**
	 * get all ExcST4Bs.
	 */
	protected List<ExcST4B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcST4Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcST4B : " );        
		List<ExcST4B> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcST4BBusinessDelegate
			collection = ExcST4BBusinessDelegate.getExcST4BInstance().getAllExcST4B();
			assertNotNull( collection, "An Empty collection of ExcST4B was incorrectly returned.");
			
			// Now print out the values
			ExcST4B entity = null;            
			Iterator<ExcST4B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcST4BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcST4BTest
	 */
	protected ExcST4BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcST4B
	 * 
	 * @return CreateExcST4BCommand alias
	 */
	protected CreateExcST4BCommand generateNewCommand() {
        CreateExcST4BCommand command = new CreateExcST4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcST4B
		 * 
		 * @return UpdateExcST4BCommand alias
		 */
	protected UpdateExcST4BCommand generateUpdateCommand() {
	        UpdateExcST4BCommand command = new UpdateExcST4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excST4BId = null;
	protected ExcST4BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcST4BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcST4BList = 0;
}
