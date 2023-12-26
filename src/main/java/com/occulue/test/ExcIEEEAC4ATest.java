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
 * Test ExcIEEEAC4A class.
 *
 * @author your_name_here
 */
public class ExcIEEEAC4ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEAC4ATest() {
		subscriber = new ExcIEEEAC4ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEAC4ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEAC4A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEAC4A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEAC4AId = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance()
		.createExcIEEEAC4A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance()
				.createExcIEEEAC4A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEAC4ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEAC4A : " + successValue.getExcIEEEAC4AId());
							  if (successValue.getExcIEEEAC4AId().equals(excIEEEAC4AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEAC4AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEAC4A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC4A consumed")
					);
			subscriber.excIEEEAC4ASubscribe( excIEEEAC4AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEAC4A : " + successValue.getExcIEEEAC4AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEAC4AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEAC4A for excIEEEAC4AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEAC4A. 
	 */
	protected ExcIEEEAC4A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEAC4A" );

		ExcIEEEAC4A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEAC4A with primary key" );
		msg.append( excIEEEAC4AId );
		
		ExcIEEEAC4AFetchOneSummary fetchOneSummary = new ExcIEEEAC4AFetchOneSummary( excIEEEAC4AId );

		try {
			entity = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().getExcIEEEAC4A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEAC4A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEAC4A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEAC4A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEAC4A : " );        
		ExcIEEEAC4A entity = read();
		UpdateExcIEEEAC4ACommand command = generateUpdateCommand();
		command.setExcIEEEAC4AId(entity.getExcIEEEAC4AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEAC4A." );

			// for use later on...
			excIEEEAC4AId = entity.getExcIEEEAC4AId();

			ExcIEEEAC4ABusinessDelegate proxy = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance();  

			proxy.updateExcIEEEAC4A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEAC4A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEAC4AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEAC4A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEAC4A." );

		ExcIEEEAC4A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEAC4A with id " + excIEEEAC4AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEAC4A with id " + excIEEEAC4AId );

			throw e;
		}

		try{
			ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().delete( new DeleteExcIEEEAC4ACommand( entity.getExcIEEEAC4AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEAC4A with id " + excIEEEAC4AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEAC4A with id " + excIEEEAC4AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEAC4As.
	 */
	protected List<ExcIEEEAC4A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEAC4As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEAC4A : " );        
		List<ExcIEEEAC4A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEAC4ABusinessDelegate
			collection = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().getAllExcIEEEAC4A();
			assertNotNull( collection, "An Empty collection of ExcIEEEAC4A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEAC4A entity = null;            
			Iterator<ExcIEEEAC4A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEAC4AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEAC4ATest
	 */
	protected ExcIEEEAC4ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEAC4A
	 * 
	 * @return CreateExcIEEEAC4ACommand alias
	 */
	protected CreateExcIEEEAC4ACommand generateNewCommand() {
        CreateExcIEEEAC4ACommand command = new CreateExcIEEEAC4ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEAC4A
		 * 
		 * @return UpdateExcIEEEAC4ACommand alias
		 */
	protected UpdateExcIEEEAC4ACommand generateUpdateCommand() {
	        UpdateExcIEEEAC4ACommand command = new UpdateExcIEEEAC4ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEAC4AId = null;
	protected ExcIEEEAC4ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEAC4ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEAC4AList = 0;
}
