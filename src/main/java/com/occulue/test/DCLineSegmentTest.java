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
 * Test DCLineSegment class.
 *
 * @author your_name_here
 */
public class DCLineSegmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCLineSegmentTest() {
		subscriber = new DCLineSegmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCLineSegmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCLineSegment...");
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
	 * jumpstart the process by instantiating2 DCLineSegment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCLineSegmentId = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance()
		.createDCLineSegment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCLineSegmentBusinessDelegate.getDCLineSegmentInstance()
				.createDCLineSegment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCLineSegmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCLineSegment : " + successValue.getDCLineSegmentId());
							  if (successValue.getDCLineSegmentId().equals(dCLineSegmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCLineSegmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCLineSegment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCLineSegment consumed")
					);
			subscriber.dCLineSegmentSubscribe( dCLineSegmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCLineSegment : " + successValue.getDCLineSegmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCLineSegmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCLineSegment for dCLineSegmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCLineSegment. 
	 */
	protected DCLineSegment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCLineSegment" );

		DCLineSegment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCLineSegment with primary key" );
		msg.append( dCLineSegmentId );
		
		DCLineSegmentFetchOneSummary fetchOneSummary = new DCLineSegmentFetchOneSummary( dCLineSegmentId );

		try {
			entity = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().getDCLineSegment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCLineSegment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCLineSegment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCLineSegment." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCLineSegment : " );        
		DCLineSegment entity = read();
		UpdateDCLineSegmentCommand command = generateUpdateCommand();
		command.setDCLineSegmentId(entity.getDCLineSegmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCLineSegment." );

			// for use later on...
			dCLineSegmentId = entity.getDCLineSegmentId();

			DCLineSegmentBusinessDelegate proxy = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();  

			proxy.updateDCLineSegment( command ).get();

			LOGGER.info( "-- Successfully saved DCLineSegment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCLineSegmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCLineSegment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCLineSegment." );

		DCLineSegment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCLineSegment with id " + dCLineSegmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCLineSegment with id " + dCLineSegmentId );

			throw e;
		}

		try{
			DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().delete( new DeleteDCLineSegmentCommand( entity.getDCLineSegmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCLineSegment with id " + dCLineSegmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCLineSegment with id " + dCLineSegmentId );

			throw e;
		}
	}

	/**
	 * get all DCLineSegments.
	 */
	protected List<DCLineSegment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCLineSegments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCLineSegment : " );        
		List<DCLineSegment> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCLineSegmentBusinessDelegate
			collection = DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().getAllDCLineSegment();
			assertNotNull( collection, "An Empty collection of DCLineSegment was incorrectly returned.");
			
			// Now print out the values
			DCLineSegment entity = null;            
			Iterator<DCLineSegment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCLineSegmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCLineSegmentTest
	 */
	protected DCLineSegmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCLineSegment
	 * 
	 * @return CreateDCLineSegmentCommand alias
	 */
	protected CreateDCLineSegmentCommand generateNewCommand() {
        CreateDCLineSegmentCommand command = new CreateDCLineSegmentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DCLineSegment
		 * 
		 * @return UpdateDCLineSegmentCommand alias
		 */
	protected UpdateDCLineSegmentCommand generateUpdateCommand() {
	        UpdateDCLineSegmentCommand command = new UpdateDCLineSegmentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCLineSegmentId = null;
	protected DCLineSegmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCLineSegmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCLineSegmentList = 0;
}
