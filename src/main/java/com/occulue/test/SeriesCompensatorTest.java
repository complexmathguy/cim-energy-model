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
 * Test SeriesCompensator class.
 *
 * @author your_name_here
 */
public class SeriesCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SeriesCompensatorTest() {
		subscriber = new SeriesCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SeriesCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SeriesCompensator...");
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
	 * jumpstart the process by instantiating2 SeriesCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		seriesCompensatorId = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
		.createSeriesCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
				.createSeriesCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.seriesCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SeriesCompensator : " + successValue.getSeriesCompensatorId());
							  if (successValue.getSeriesCompensatorId().equals(seriesCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSeriesCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SeriesCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seriesCompensator consumed")
					);
			subscriber.seriesCompensatorSubscribe( seriesCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SeriesCompensator : " + successValue.getSeriesCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSeriesCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seriesCompensator for seriesCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SeriesCompensator. 
	 */
	protected SeriesCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SeriesCompensator" );

		SeriesCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SeriesCompensator with primary key" );
		msg.append( seriesCompensatorId );
		
		SeriesCompensatorFetchOneSummary fetchOneSummary = new SeriesCompensatorFetchOneSummary( seriesCompensatorId );

		try {
			entity = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().getSeriesCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SeriesCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SeriesCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SeriesCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a SeriesCompensator : " );        
		SeriesCompensator entity = read();
		UpdateSeriesCompensatorCommand command = generateUpdateCommand();
		command.setSeriesCompensatorId(entity.getSeriesCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SeriesCompensator." );

			// for use later on...
			seriesCompensatorId = entity.getSeriesCompensatorId();

			SeriesCompensatorBusinessDelegate proxy = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();  

			proxy.updateSeriesCompensator( command ).get();

			LOGGER.info( "-- Successfully saved SeriesCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + seriesCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SeriesCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SeriesCompensator." );

		SeriesCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SeriesCompensator with id " + seriesCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SeriesCompensator with id " + seriesCompensatorId );

			throw e;
		}

		try{
			SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().delete( new DeleteSeriesCompensatorCommand( entity.getSeriesCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted SeriesCompensator with id " + seriesCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SeriesCompensator with id " + seriesCompensatorId );

			throw e;
		}
	}

	/**
	 * get all SeriesCompensators.
	 */
	protected List<SeriesCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SeriesCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SeriesCompensator : " );        
		List<SeriesCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the SeriesCompensatorBusinessDelegate
			collection = SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().getAllSeriesCompensator();
			assertNotNull( collection, "An Empty collection of SeriesCompensator was incorrectly returned.");
			
			// Now print out the values
			SeriesCompensator entity = null;            
			Iterator<SeriesCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSeriesCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SeriesCompensatorTest
	 */
	protected SeriesCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SeriesCompensator
	 * 
	 * @return CreateSeriesCompensatorCommand alias
	 */
	protected CreateSeriesCompensatorCommand generateNewCommand() {
        CreateSeriesCompensatorCommand command = new CreateSeriesCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SeriesCompensator
		 * 
		 * @return UpdateSeriesCompensatorCommand alias
		 */
	protected UpdateSeriesCompensatorCommand generateUpdateCommand() {
	        UpdateSeriesCompensatorCommand command = new UpdateSeriesCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID seriesCompensatorId = null;
	protected SeriesCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SeriesCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSeriesCompensatorList = 0;
}
