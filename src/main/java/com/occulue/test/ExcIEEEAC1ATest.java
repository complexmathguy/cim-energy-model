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
 * Test ExcIEEEAC1A class.
 *
 * @author your_name_here
 */
public class ExcIEEEAC1ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEAC1ATest() {
		subscriber = new ExcIEEEAC1ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEAC1ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEAC1A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEAC1A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEAC1AId = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance()
		.createExcIEEEAC1A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance()
				.createExcIEEEAC1A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEAC1ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEAC1A : " + successValue.getExcIEEEAC1AId());
							  if (successValue.getExcIEEEAC1AId().equals(excIEEEAC1AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEAC1AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEAC1A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC1A consumed")
					);
			subscriber.excIEEEAC1ASubscribe( excIEEEAC1AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEAC1A : " + successValue.getExcIEEEAC1AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEAC1AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC1A for excIEEEAC1AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEAC1A. 
	 */
	protected ExcIEEEAC1A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEAC1A" );

		ExcIEEEAC1A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEAC1A with primary key" );
		msg.append( excIEEEAC1AId );
		
		ExcIEEEAC1AFetchOneSummary fetchOneSummary = new ExcIEEEAC1AFetchOneSummary( excIEEEAC1AId );

		try {
			entity = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().getExcIEEEAC1A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEAC1A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEAC1A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEAC1A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEAC1A : " );        
		ExcIEEEAC1A entity = read();
		UpdateExcIEEEAC1ACommand command = generateUpdateCommand();
		command.setExcIEEEAC1AId(entity.getExcIEEEAC1AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEAC1A." );

			// for use later on...
			excIEEEAC1AId = entity.getExcIEEEAC1AId();

			ExcIEEEAC1ABusinessDelegate proxy = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance();  

			proxy.updateExcIEEEAC1A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEAC1A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEAC1AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEAC1A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEAC1A." );

		ExcIEEEAC1A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEAC1A with id " + excIEEEAC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEAC1A with id " + excIEEEAC1AId );

			throw e;
		}

		try{
			ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().delete( new DeleteExcIEEEAC1ACommand( entity.getExcIEEEAC1AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEAC1A with id " + excIEEEAC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEAC1A with id " + excIEEEAC1AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEAC1As.
	 */
	protected List<ExcIEEEAC1A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEAC1As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEAC1A : " );        
		List<ExcIEEEAC1A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEAC1ABusinessDelegate
			collection = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().getAllExcIEEEAC1A();
			assertNotNull( collection, "An Empty collection of ExcIEEEAC1A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEAC1A entity = null;            
			Iterator<ExcIEEEAC1A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEAC1AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEAC1ATest
	 */
	protected ExcIEEEAC1ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEAC1A
	 * 
	 * @return CreateExcIEEEAC1ACommand alias
	 */
	protected CreateExcIEEEAC1ACommand generateNewCommand() {
        CreateExcIEEEAC1ACommand command = new CreateExcIEEEAC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEAC1A
		 * 
		 * @return UpdateExcIEEEAC1ACommand alias
		 */
	protected UpdateExcIEEEAC1ACommand generateUpdateCommand() {
	        UpdateExcIEEEAC1ACommand command = new UpdateExcIEEEAC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEAC1AId = null;
	protected ExcIEEEAC1ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEAC1ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEAC1AList = 0;
}
