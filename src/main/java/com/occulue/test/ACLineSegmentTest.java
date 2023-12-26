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
 * Test ACLineSegment class.
 *
 * @author your_name_here
 */
public class ACLineSegmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ACLineSegmentTest() {
		subscriber = new ACLineSegmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ACLineSegmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ACLineSegment...");
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
	 * jumpstart the process by instantiating2 ACLineSegment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		aCLineSegmentId = ACLineSegmentBusinessDelegate.getACLineSegmentInstance()
		.createACLineSegment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ACLineSegmentBusinessDelegate.getACLineSegmentInstance()
				.createACLineSegment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.aCLineSegmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ACLineSegment : " + successValue.getACLineSegmentId());
							  if (successValue.getACLineSegmentId().equals(aCLineSegmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfACLineSegmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ACLineSegment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCLineSegment consumed")
					);
			subscriber.aCLineSegmentSubscribe( aCLineSegmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ACLineSegment : " + successValue.getACLineSegmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfACLineSegmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCLineSegment for aCLineSegmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ACLineSegment. 
	 */
	protected ACLineSegment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ACLineSegment" );

		ACLineSegment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ACLineSegment with primary key" );
		msg.append( aCLineSegmentId );
		
		ACLineSegmentFetchOneSummary fetchOneSummary = new ACLineSegmentFetchOneSummary( aCLineSegmentId );

		try {
			entity = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().getACLineSegment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ACLineSegment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ACLineSegment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ACLineSegment." );

		StringBuilder msg = new StringBuilder( "Failed to update a ACLineSegment : " );        
		ACLineSegment entity = read();
		UpdateACLineSegmentCommand command = generateUpdateCommand();
		command.setACLineSegmentId(entity.getACLineSegmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ACLineSegment." );

			// for use later on...
			aCLineSegmentId = entity.getACLineSegmentId();

			ACLineSegmentBusinessDelegate proxy = ACLineSegmentBusinessDelegate.getACLineSegmentInstance();  

			proxy.updateACLineSegment( command ).get();

			LOGGER.info( "-- Successfully saved ACLineSegment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + aCLineSegmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ACLineSegment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ACLineSegment." );

		ACLineSegment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ACLineSegment with id " + aCLineSegmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ACLineSegment with id " + aCLineSegmentId );

			throw e;
		}

		try{
			ACLineSegmentBusinessDelegate.getACLineSegmentInstance().delete( new DeleteACLineSegmentCommand( entity.getACLineSegmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted ACLineSegment with id " + aCLineSegmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ACLineSegment with id " + aCLineSegmentId );

			throw e;
		}
	}

	/**
	 * get all ACLineSegments.
	 */
	protected List<ACLineSegment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ACLineSegments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ACLineSegment : " );        
		List<ACLineSegment> collection  = new ArrayList<>();

		try {
			// call the static get method on the ACLineSegmentBusinessDelegate
			collection = ACLineSegmentBusinessDelegate.getACLineSegmentInstance().getAllACLineSegment();
			assertNotNull( collection, "An Empty collection of ACLineSegment was incorrectly returned.");
			
			// Now print out the values
			ACLineSegment entity = null;            
			Iterator<ACLineSegment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getACLineSegmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ACLineSegmentTest
	 */
	protected ACLineSegmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ACLineSegment
	 * 
	 * @return CreateACLineSegmentCommand alias
	 */
	protected CreateACLineSegmentCommand generateNewCommand() {
        CreateACLineSegmentCommand command = new CreateACLineSegmentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ACLineSegment
		 * 
		 * @return UpdateACLineSegmentCommand alias
		 */
	protected UpdateACLineSegmentCommand generateUpdateCommand() {
	        UpdateACLineSegmentCommand command = new UpdateACLineSegmentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID aCLineSegmentId = null;
	protected ACLineSegmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ACLineSegmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfACLineSegmentList = 0;
}
