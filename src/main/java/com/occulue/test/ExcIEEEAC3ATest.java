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
 * Test ExcIEEEAC3A class.
 *
 * @author your_name_here
 */
public class ExcIEEEAC3ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEAC3ATest() {
		subscriber = new ExcIEEEAC3ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEAC3ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEAC3A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEAC3A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEAC3AId = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance()
		.createExcIEEEAC3A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance()
				.createExcIEEEAC3A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEAC3ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEAC3A : " + successValue.getExcIEEEAC3AId());
							  if (successValue.getExcIEEEAC3AId().equals(excIEEEAC3AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEAC3AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEAC3A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC3A consumed")
					);
			subscriber.excIEEEAC3ASubscribe( excIEEEAC3AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEAC3A : " + successValue.getExcIEEEAC3AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEAC3AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC3A for excIEEEAC3AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEAC3A. 
	 */
	protected ExcIEEEAC3A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEAC3A" );

		ExcIEEEAC3A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEAC3A with primary key" );
		msg.append( excIEEEAC3AId );
		
		ExcIEEEAC3AFetchOneSummary fetchOneSummary = new ExcIEEEAC3AFetchOneSummary( excIEEEAC3AId );

		try {
			entity = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().getExcIEEEAC3A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEAC3A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEAC3A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEAC3A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEAC3A : " );        
		ExcIEEEAC3A entity = read();
		UpdateExcIEEEAC3ACommand command = generateUpdateCommand();
		command.setExcIEEEAC3AId(entity.getExcIEEEAC3AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEAC3A." );

			// for use later on...
			excIEEEAC3AId = entity.getExcIEEEAC3AId();

			ExcIEEEAC3ABusinessDelegate proxy = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();  

			proxy.updateExcIEEEAC3A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEAC3A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEAC3AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEAC3A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEAC3A." );

		ExcIEEEAC3A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEAC3A with id " + excIEEEAC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEAC3A with id " + excIEEEAC3AId );

			throw e;
		}

		try{
			ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().delete( new DeleteExcIEEEAC3ACommand( entity.getExcIEEEAC3AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEAC3A with id " + excIEEEAC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEAC3A with id " + excIEEEAC3AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEAC3As.
	 */
	protected List<ExcIEEEAC3A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEAC3As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEAC3A : " );        
		List<ExcIEEEAC3A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEAC3ABusinessDelegate
			collection = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().getAllExcIEEEAC3A();
			assertNotNull( collection, "An Empty collection of ExcIEEEAC3A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEAC3A entity = null;            
			Iterator<ExcIEEEAC3A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEAC3AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEAC3ATest
	 */
	protected ExcIEEEAC3ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEAC3A
	 * 
	 * @return CreateExcIEEEAC3ACommand alias
	 */
	protected CreateExcIEEEAC3ACommand generateNewCommand() {
        CreateExcIEEEAC3ACommand command = new CreateExcIEEEAC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEAC3A
		 * 
		 * @return UpdateExcIEEEAC3ACommand alias
		 */
	protected UpdateExcIEEEAC3ACommand generateUpdateCommand() {
	        UpdateExcIEEEAC3ACommand command = new UpdateExcIEEEAC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEAC3AId = null;
	protected ExcIEEEAC3ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEAC3ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEAC3AList = 0;
}
