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
 * Test ExcIEEEDC2A class.
 *
 * @author your_name_here
 */
public class ExcIEEEDC2ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEDC2ATest() {
		subscriber = new ExcIEEEDC2ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEDC2ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEDC2A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEDC2A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEDC2AId = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance()
		.createExcIEEEDC2A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance()
				.createExcIEEEDC2A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEDC2ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEDC2A : " + successValue.getExcIEEEDC2AId());
							  if (successValue.getExcIEEEDC2AId().equals(excIEEEDC2AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEDC2AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEDC2A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC2A consumed")
					);
			subscriber.excIEEEDC2ASubscribe( excIEEEDC2AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEDC2A : " + successValue.getExcIEEEDC2AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEDC2AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC2A for excIEEEDC2AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEDC2A. 
	 */
	protected ExcIEEEDC2A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEDC2A" );

		ExcIEEEDC2A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEDC2A with primary key" );
		msg.append( excIEEEDC2AId );
		
		ExcIEEEDC2AFetchOneSummary fetchOneSummary = new ExcIEEEDC2AFetchOneSummary( excIEEEDC2AId );

		try {
			entity = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().getExcIEEEDC2A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEDC2A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEDC2A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEDC2A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEDC2A : " );        
		ExcIEEEDC2A entity = read();
		UpdateExcIEEEDC2ACommand command = generateUpdateCommand();
		command.setExcIEEEDC2AId(entity.getExcIEEEDC2AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEDC2A." );

			// for use later on...
			excIEEEDC2AId = entity.getExcIEEEDC2AId();

			ExcIEEEDC2ABusinessDelegate proxy = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance();  

			proxy.updateExcIEEEDC2A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEDC2A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEDC2AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEDC2A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEDC2A." );

		ExcIEEEDC2A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEDC2A with id " + excIEEEDC2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEDC2A with id " + excIEEEDC2AId );

			throw e;
		}

		try{
			ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().delete( new DeleteExcIEEEDC2ACommand( entity.getExcIEEEDC2AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEDC2A with id " + excIEEEDC2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEDC2A with id " + excIEEEDC2AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEDC2As.
	 */
	protected List<ExcIEEEDC2A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEDC2As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEDC2A : " );        
		List<ExcIEEEDC2A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEDC2ABusinessDelegate
			collection = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().getAllExcIEEEDC2A();
			assertNotNull( collection, "An Empty collection of ExcIEEEDC2A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEDC2A entity = null;            
			Iterator<ExcIEEEDC2A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEDC2AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEDC2ATest
	 */
	protected ExcIEEEDC2ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEDC2A
	 * 
	 * @return CreateExcIEEEDC2ACommand alias
	 */
	protected CreateExcIEEEDC2ACommand generateNewCommand() {
        CreateExcIEEEDC2ACommand command = new CreateExcIEEEDC2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEDC2A
		 * 
		 * @return UpdateExcIEEEDC2ACommand alias
		 */
	protected UpdateExcIEEEDC2ACommand generateUpdateCommand() {
	        UpdateExcIEEEDC2ACommand command = new UpdateExcIEEEDC2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEDC2AId = null;
	protected ExcIEEEDC2ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEDC2ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEDC2AList = 0;
}
