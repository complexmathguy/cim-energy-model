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
 * Test ExcCZ class.
 *
 * @author your_name_here
 */
public class ExcCZTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcCZTest() {
		subscriber = new ExcCZSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcCZTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcCZ...");
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
	 * jumpstart the process by instantiating2 ExcCZ
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excCZId = ExcCZBusinessDelegate.getExcCZInstance()
		.createExcCZ( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcCZBusinessDelegate.getExcCZInstance()
				.createExcCZ( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excCZSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcCZ : " + successValue.getExcCZId());
							  if (successValue.getExcCZId().equals(excCZId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcCZList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcCZ test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excCZ consumed")
					);
			subscriber.excCZSubscribe( excCZId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcCZ : " + successValue.getExcCZId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcCZList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excCZ for excCZId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcCZ. 
	 */
	protected ExcCZ read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcCZ" );

		ExcCZ entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcCZ with primary key" );
		msg.append( excCZId );
		
		ExcCZFetchOneSummary fetchOneSummary = new ExcCZFetchOneSummary( excCZId );

		try {
			entity = ExcCZBusinessDelegate.getExcCZInstance().getExcCZ( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcCZ " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcCZ.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcCZ." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcCZ : " );        
		ExcCZ entity = read();
		UpdateExcCZCommand command = generateUpdateCommand();
		command.setExcCZId(entity.getExcCZId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcCZ." );

			// for use later on...
			excCZId = entity.getExcCZId();

			ExcCZBusinessDelegate proxy = ExcCZBusinessDelegate.getExcCZInstance();  

			proxy.updateExcCZ( command ).get();

			LOGGER.info( "-- Successfully saved ExcCZ - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excCZId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcCZ.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcCZ." );

		ExcCZ entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcCZ with id " + excCZId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcCZ with id " + excCZId );

			throw e;
		}

		try{
			ExcCZBusinessDelegate.getExcCZInstance().delete( new DeleteExcCZCommand( entity.getExcCZId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcCZ with id " + excCZId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcCZ with id " + excCZId );

			throw e;
		}
	}

	/**
	 * get all ExcCZs.
	 */
	protected List<ExcCZ> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcCZs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcCZ : " );        
		List<ExcCZ> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcCZBusinessDelegate
			collection = ExcCZBusinessDelegate.getExcCZInstance().getAllExcCZ();
			assertNotNull( collection, "An Empty collection of ExcCZ was incorrectly returned.");
			
			// Now print out the values
			ExcCZ entity = null;            
			Iterator<ExcCZ> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcCZId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcCZTest
	 */
	protected ExcCZTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcCZ
	 * 
	 * @return CreateExcCZCommand alias
	 */
	protected CreateExcCZCommand generateNewCommand() {
        CreateExcCZCommand command = new CreateExcCZCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcCZ
		 * 
		 * @return UpdateExcCZCommand alias
		 */
	protected UpdateExcCZCommand generateUpdateCommand() {
	        UpdateExcCZCommand command = new UpdateExcCZCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excCZId = null;
	protected ExcCZSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcCZTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcCZList = 0;
}
