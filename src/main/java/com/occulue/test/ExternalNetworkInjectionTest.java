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
 * Test ExternalNetworkInjection class.
 *
 * @author your_name_here
 */
public class ExternalNetworkInjectionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExternalNetworkInjectionTest() {
		subscriber = new ExternalNetworkInjectionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExternalNetworkInjectionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExternalNetworkInjection...");
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
	 * jumpstart the process by instantiating2 ExternalNetworkInjection
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		externalNetworkInjectionId = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
		.createExternalNetworkInjection( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance()
				.createExternalNetworkInjection( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.externalNetworkInjectionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExternalNetworkInjection : " + successValue.getExternalNetworkInjectionId());
							  if (successValue.getExternalNetworkInjectionId().equals(externalNetworkInjectionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExternalNetworkInjectionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExternalNetworkInjection test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on externalNetworkInjection consumed")
					);
			subscriber.externalNetworkInjectionSubscribe( externalNetworkInjectionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExternalNetworkInjection : " + successValue.getExternalNetworkInjectionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExternalNetworkInjectionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on externalNetworkInjection for externalNetworkInjectionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExternalNetworkInjection. 
	 */
	protected ExternalNetworkInjection read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExternalNetworkInjection" );

		ExternalNetworkInjection entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExternalNetworkInjection with primary key" );
		msg.append( externalNetworkInjectionId );
		
		ExternalNetworkInjectionFetchOneSummary fetchOneSummary = new ExternalNetworkInjectionFetchOneSummary( externalNetworkInjectionId );

		try {
			entity = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().getExternalNetworkInjection( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExternalNetworkInjection " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExternalNetworkInjection.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExternalNetworkInjection." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExternalNetworkInjection : " );        
		ExternalNetworkInjection entity = read();
		UpdateExternalNetworkInjectionCommand command = generateUpdateCommand();
		command.setExternalNetworkInjectionId(entity.getExternalNetworkInjectionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExternalNetworkInjection." );

			// for use later on...
			externalNetworkInjectionId = entity.getExternalNetworkInjectionId();

			ExternalNetworkInjectionBusinessDelegate proxy = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance();  

			proxy.updateExternalNetworkInjection( command ).get();

			LOGGER.info( "-- Successfully saved ExternalNetworkInjection - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + externalNetworkInjectionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExternalNetworkInjection.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExternalNetworkInjection." );

		ExternalNetworkInjection entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExternalNetworkInjection with id " + externalNetworkInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExternalNetworkInjection with id " + externalNetworkInjectionId );

			throw e;
		}

		try{
			ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().delete( new DeleteExternalNetworkInjectionCommand( entity.getExternalNetworkInjectionId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExternalNetworkInjection with id " + externalNetworkInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExternalNetworkInjection with id " + externalNetworkInjectionId );

			throw e;
		}
	}

	/**
	 * get all ExternalNetworkInjections.
	 */
	protected List<ExternalNetworkInjection> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExternalNetworkInjections:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExternalNetworkInjection : " );        
		List<ExternalNetworkInjection> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExternalNetworkInjectionBusinessDelegate
			collection = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().getAllExternalNetworkInjection();
			assertNotNull( collection, "An Empty collection of ExternalNetworkInjection was incorrectly returned.");
			
			// Now print out the values
			ExternalNetworkInjection entity = null;            
			Iterator<ExternalNetworkInjection> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExternalNetworkInjectionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExternalNetworkInjectionTest
	 */
	protected ExternalNetworkInjectionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExternalNetworkInjection
	 * 
	 * @return CreateExternalNetworkInjectionCommand alias
	 */
	protected CreateExternalNetworkInjectionCommand generateNewCommand() {
        CreateExternalNetworkInjectionCommand command = new CreateExternalNetworkInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExternalNetworkInjection
		 * 
		 * @return UpdateExternalNetworkInjectionCommand alias
		 */
	protected UpdateExternalNetworkInjectionCommand generateUpdateCommand() {
	        UpdateExternalNetworkInjectionCommand command = new UpdateExternalNetworkInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID externalNetworkInjectionId = null;
	protected ExternalNetworkInjectionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExternalNetworkInjectionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExternalNetworkInjectionList = 0;
}
