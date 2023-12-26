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
 * Test ExcSCRX class.
 *
 * @author your_name_here
 */
public class ExcSCRXTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcSCRXTest() {
		subscriber = new ExcSCRXSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcSCRXTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcSCRX...");
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
	 * jumpstart the process by instantiating2 ExcSCRX
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excSCRXId = ExcSCRXBusinessDelegate.getExcSCRXInstance()
		.createExcSCRX( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcSCRXBusinessDelegate.getExcSCRXInstance()
				.createExcSCRX( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excSCRXSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcSCRX : " + successValue.getExcSCRXId());
							  if (successValue.getExcSCRXId().equals(excSCRXId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcSCRXList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcSCRX test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excSCRX consumed")
					);
			subscriber.excSCRXSubscribe( excSCRXId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcSCRX : " + successValue.getExcSCRXId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcSCRXList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excSCRX for excSCRXId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcSCRX. 
	 */
	protected ExcSCRX read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcSCRX" );

		ExcSCRX entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcSCRX with primary key" );
		msg.append( excSCRXId );
		
		ExcSCRXFetchOneSummary fetchOneSummary = new ExcSCRXFetchOneSummary( excSCRXId );

		try {
			entity = ExcSCRXBusinessDelegate.getExcSCRXInstance().getExcSCRX( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcSCRX " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcSCRX.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcSCRX." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcSCRX : " );        
		ExcSCRX entity = read();
		UpdateExcSCRXCommand command = generateUpdateCommand();
		command.setExcSCRXId(entity.getExcSCRXId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcSCRX." );

			// for use later on...
			excSCRXId = entity.getExcSCRXId();

			ExcSCRXBusinessDelegate proxy = ExcSCRXBusinessDelegate.getExcSCRXInstance();  

			proxy.updateExcSCRX( command ).get();

			LOGGER.info( "-- Successfully saved ExcSCRX - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excSCRXId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcSCRX.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcSCRX." );

		ExcSCRX entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcSCRX with id " + excSCRXId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcSCRX with id " + excSCRXId );

			throw e;
		}

		try{
			ExcSCRXBusinessDelegate.getExcSCRXInstance().delete( new DeleteExcSCRXCommand( entity.getExcSCRXId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcSCRX with id " + excSCRXId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcSCRX with id " + excSCRXId );

			throw e;
		}
	}

	/**
	 * get all ExcSCRXs.
	 */
	protected List<ExcSCRX> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcSCRXs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcSCRX : " );        
		List<ExcSCRX> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcSCRXBusinessDelegate
			collection = ExcSCRXBusinessDelegate.getExcSCRXInstance().getAllExcSCRX();
			assertNotNull( collection, "An Empty collection of ExcSCRX was incorrectly returned.");
			
			// Now print out the values
			ExcSCRX entity = null;            
			Iterator<ExcSCRX> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcSCRXId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcSCRXTest
	 */
	protected ExcSCRXTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcSCRX
	 * 
	 * @return CreateExcSCRXCommand alias
	 */
	protected CreateExcSCRXCommand generateNewCommand() {
        CreateExcSCRXCommand command = new CreateExcSCRXCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcSCRX
		 * 
		 * @return UpdateExcSCRXCommand alias
		 */
	protected UpdateExcSCRXCommand generateUpdateCommand() {
	        UpdateExcSCRXCommand command = new UpdateExcSCRXCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excSCRXId = null;
	protected ExcSCRXSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcSCRXTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcSCRXList = 0;
}
