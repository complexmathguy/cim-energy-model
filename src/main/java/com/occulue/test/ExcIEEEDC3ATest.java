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
 * Test ExcIEEEDC3A class.
 *
 * @author your_name_here
 */
public class ExcIEEEDC3ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcIEEEDC3ATest() {
		subscriber = new ExcIEEEDC3ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcIEEEDC3ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcIEEEDC3A...");
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
	 * jumpstart the process by instantiating2 ExcIEEEDC3A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excIEEEDC3AId = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance()
		.createExcIEEEDC3A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance()
				.createExcIEEEDC3A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excIEEEDC3ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcIEEEDC3A : " + successValue.getExcIEEEDC3AId());
							  if (successValue.getExcIEEEDC3AId().equals(excIEEEDC3AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcIEEEDC3AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcIEEEDC3A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC3A consumed")
					);
			subscriber.excIEEEDC3ASubscribe( excIEEEDC3AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcIEEEDC3A : " + successValue.getExcIEEEDC3AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcIEEEDC3AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excIEEEDC3A for excIEEEDC3AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcIEEEDC3A. 
	 */
	protected ExcIEEEDC3A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcIEEEDC3A" );

		ExcIEEEDC3A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcIEEEDC3A with primary key" );
		msg.append( excIEEEDC3AId );
		
		ExcIEEEDC3AFetchOneSummary fetchOneSummary = new ExcIEEEDC3AFetchOneSummary( excIEEEDC3AId );

		try {
			entity = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().getExcIEEEDC3A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcIEEEDC3A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcIEEEDC3A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcIEEEDC3A." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcIEEEDC3A : " );        
		ExcIEEEDC3A entity = read();
		UpdateExcIEEEDC3ACommand command = generateUpdateCommand();
		command.setExcIEEEDC3AId(entity.getExcIEEEDC3AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcIEEEDC3A." );

			// for use later on...
			excIEEEDC3AId = entity.getExcIEEEDC3AId();

			ExcIEEEDC3ABusinessDelegate proxy = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();  

			proxy.updateExcIEEEDC3A( command ).get();

			LOGGER.info( "-- Successfully saved ExcIEEEDC3A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excIEEEDC3AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcIEEEDC3A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcIEEEDC3A." );

		ExcIEEEDC3A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcIEEEDC3A with id " + excIEEEDC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcIEEEDC3A with id " + excIEEEDC3AId );

			throw e;
		}

		try{
			ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().delete( new DeleteExcIEEEDC3ACommand( entity.getExcIEEEDC3AId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcIEEEDC3A with id " + excIEEEDC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcIEEEDC3A with id " + excIEEEDC3AId );

			throw e;
		}
	}

	/**
	 * get all ExcIEEEDC3As.
	 */
	protected List<ExcIEEEDC3A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcIEEEDC3As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcIEEEDC3A : " );        
		List<ExcIEEEDC3A> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcIEEEDC3ABusinessDelegate
			collection = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().getAllExcIEEEDC3A();
			assertNotNull( collection, "An Empty collection of ExcIEEEDC3A was incorrectly returned.");
			
			// Now print out the values
			ExcIEEEDC3A entity = null;            
			Iterator<ExcIEEEDC3A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcIEEEDC3AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcIEEEDC3ATest
	 */
	protected ExcIEEEDC3ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcIEEEDC3A
	 * 
	 * @return CreateExcIEEEDC3ACommand alias
	 */
	protected CreateExcIEEEDC3ACommand generateNewCommand() {
        CreateExcIEEEDC3ACommand command = new CreateExcIEEEDC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcIEEEDC3A
		 * 
		 * @return UpdateExcIEEEDC3ACommand alias
		 */
	protected UpdateExcIEEEDC3ACommand generateUpdateCommand() {
	        UpdateExcIEEEDC3ACommand command = new UpdateExcIEEEDC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excIEEEDC3AId = null;
	protected ExcIEEEDC3ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcIEEEDC3ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcIEEEDC3AList = 0;
}
