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
 * Test ExcIEEEDC1A class.
 *
 * @author your_name_here
 */
public class ExcIEEEDC1ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEDC1ATest() {
		subscriber = new ExcIEEEDC1ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEDC1ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEDC1A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEDC1A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEDC1AId = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance()
		.createExcIEEEDC1A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance()
				.createExcIEEEDC1A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEDC1ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEDC1A : " + successValue.getExcIEEEDC1AId());
							  if (successValue.getExcIEEEDC1AId().equals(excIEEEDC1AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEDC1AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEDC1A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC1A consumed")
					);
			subscriber.excIEEEDC1ASubscribe( excIEEEDC1AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEDC1A : " + successValue.getExcIEEEDC1AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEDC1AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC1A for excIEEEDC1AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEDC1A. 
	 */
	protected ExcIEEEDC1A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEDC1A" );

		ExcIEEEDC1A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEDC1A with primary key" );
		msg.append( excIEEEDC1AId );
		
		ExcIEEEDC1AFetchOneSummary fetchOneSummary = new ExcIEEEDC1AFetchOneSummary( excIEEEDC1AId );

		try {
			entity = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().getExcIEEEDC1A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEDC1A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEDC1A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEDC1A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEDC1A : " );        
		ExcIEEEDC1A entity = read();
		UpdateExcIEEEDC1ACommand command = generateUpdateCommand();
		command.setExcIEEEDC1AId(entity.getExcIEEEDC1AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEDC1A." );

			// for use later on...
			excIEEEDC1AId = entity.getExcIEEEDC1AId();

			ExcIEEEDC1ABusinessDelegate proxy = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance();  

			proxy.updateExcIEEEDC1A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEDC1A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEDC1AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEDC1A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEDC1A." );

		ExcIEEEDC1A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEDC1A with id " + excIEEEDC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEDC1A with id " + excIEEEDC1AId );

			throw e;
		}

		try{
			ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().delete( new DeleteExcIEEEDC1ACommand( entity.getExcIEEEDC1AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEDC1A with id " + excIEEEDC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEDC1A with id " + excIEEEDC1AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEDC1As.
	 */
	protected List<ExcIEEEDC1A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEDC1As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEDC1A : " );        
		List<ExcIEEEDC1A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEDC1ABusinessDelegate
			collection = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().getAllExcIEEEDC1A();
			assertNotNull( collection, "An Empty collection of ExcIEEEDC1A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEDC1A entity = null;            
			Iterator<ExcIEEEDC1A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEDC1AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEDC1ATest
	 */
	protected ExcIEEEDC1ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEDC1A
	 * 
	 * @return CreateExcIEEEDC1ACommand alias
	 */
	protected CreateExcIEEEDC1ACommand generateNewCommand() {
        CreateExcIEEEDC1ACommand command = new CreateExcIEEEDC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEDC1A
		 * 
		 * @return UpdateExcIEEEDC1ACommand alias
		 */
	protected UpdateExcIEEEDC1ACommand generateUpdateCommand() {
	        UpdateExcIEEEDC1ACommand command = new UpdateExcIEEEDC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEDC1AId = null;
	protected ExcIEEEDC1ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEDC1ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEDC1AList = 0;
}
