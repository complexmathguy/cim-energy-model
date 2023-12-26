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
 * Test ExcIEEEDC4B class.
 *
 * @author your_name_here
 */
public class ExcIEEEDC4BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEDC4BTest() {
		subscriber = new ExcIEEEDC4BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEDC4BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEDC4B...");
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
	 * jumpstart the process by instantiating2 ExcIEEEDC4B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEDC4BId = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance()
		.createExcIEEEDC4B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance()
				.createExcIEEEDC4B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEDC4BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEDC4B : " + successValue.getExcIEEEDC4BId());
							  if (successValue.getExcIEEEDC4BId().equals(excIEEEDC4BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEDC4BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEDC4B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC4B consumed")
					);
			subscriber.excIEEEDC4BSubscribe( excIEEEDC4BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEDC4B : " + successValue.getExcIEEEDC4BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEDC4BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC4B for excIEEEDC4BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEDC4B. 
	 */
	protected ExcIEEEDC4B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEDC4B" );

		ExcIEEEDC4B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEDC4B with primary key" );
		msg.append( excIEEEDC4BId );
		
		ExcIEEEDC4BFetchOneSummary fetchOneSummary = new ExcIEEEDC4BFetchOneSummary( excIEEEDC4BId );

		try {
			entity = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().getExcIEEEDC4B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEDC4B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEDC4B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEDC4B." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEDC4B : " );        
		ExcIEEEDC4B entity = read();
		UpdateExcIEEEDC4BCommand command = generateUpdateCommand();
		command.setExcIEEEDC4BId(entity.getExcIEEEDC4BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEDC4B." );

			// for use later on...
			excIEEEDC4BId = entity.getExcIEEEDC4BId();

			ExcIEEEDC4BBusinessDelegate proxy = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance();  

			proxy.updateExcIEEEDC4B( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEDC4B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEDC4BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEDC4B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEDC4B." );

		ExcIEEEDC4B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEDC4B with id " + excIEEEDC4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEDC4B with id " + excIEEEDC4BId );

			throw e;
		}

		try{
			ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().delete( new DeleteExcIEEEDC4BCommand( entity.getExcIEEEDC4BId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEDC4B with id " + excIEEEDC4BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEDC4B with id " + excIEEEDC4BId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEDC4Bs.
	 */
	protected List<ExcIEEEDC4B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEDC4Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEDC4B : " );        
		List<ExcIEEEDC4B> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEDC4BBusinessDelegate
			collection = ExcIEEEDC4BBusinessDelegate.getExcIEEEDC4BInstance().getAllExcIEEEDC4B();
			assertNotNull( collection, "An Empty collection of ExcIEEEDC4B was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEDC4B entity = null;            
			Iterator<ExcIEEEDC4B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEDC4BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEDC4BTest
	 */
	protected ExcIEEEDC4BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEDC4B
	 * 
	 * @return CreateExcIEEEDC4BCommand alias
	 */
	protected CreateExcIEEEDC4BCommand generateNewCommand() {
        CreateExcIEEEDC4BCommand command = new CreateExcIEEEDC4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEDC4B
		 * 
		 * @return UpdateExcIEEEDC4BCommand alias
		 */
	protected UpdateExcIEEEDC4BCommand generateUpdateCommand() {
	        UpdateExcIEEEDC4BCommand command = new UpdateExcIEEEDC4BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEDC4BId = null;
	protected ExcIEEEDC4BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEDC4BList = 0;
}
