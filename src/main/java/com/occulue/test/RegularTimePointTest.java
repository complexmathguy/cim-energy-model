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
 * Test RegularTimePoint class.
 *
 * @author your_name_here
 */
public class RegularTimePointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RegularTimePointTest() {
		subscriber = new RegularTimePointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RegularTimePointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RegularTimePoint...");
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
	 * jumpstart the process by instantiating2 RegularTimePoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		regularTimePointId = RegularTimePointBusinessDelegate.getRegularTimePointInstance()
		.createRegularTimePoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RegularTimePointBusinessDelegate.getRegularTimePointInstance()
				.createRegularTimePoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.regularTimePointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RegularTimePoint : " + successValue.getRegularTimePointId());
							  if (successValue.getRegularTimePointId().equals(regularTimePointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRegularTimePointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RegularTimePoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regularTimePoint consumed")
					);
			subscriber.regularTimePointSubscribe( regularTimePointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RegularTimePoint : " + successValue.getRegularTimePointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRegularTimePointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regularTimePoint for regularTimePointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RegularTimePoint. 
	 */
	protected RegularTimePoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RegularTimePoint" );

		RegularTimePoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RegularTimePoint with primary key" );
		msg.append( regularTimePointId );
		
		RegularTimePointFetchOneSummary fetchOneSummary = new RegularTimePointFetchOneSummary( regularTimePointId );

		try {
			entity = RegularTimePointBusinessDelegate.getRegularTimePointInstance().getRegularTimePoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RegularTimePoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RegularTimePoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RegularTimePoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a RegularTimePoint : " );        
		RegularTimePoint entity = read();
		UpdateRegularTimePointCommand command = generateUpdateCommand();
		command.setRegularTimePointId(entity.getRegularTimePointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RegularTimePoint." );

			// for use later on...
			regularTimePointId = entity.getRegularTimePointId();

			RegularTimePointBusinessDelegate proxy = RegularTimePointBusinessDelegate.getRegularTimePointInstance();  

			proxy.updateRegularTimePoint( command ).get();

			LOGGER.info( "-- Successfully saved RegularTimePoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + regularTimePointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RegularTimePoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RegularTimePoint." );

		RegularTimePoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RegularTimePoint with id " + regularTimePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RegularTimePoint with id " + regularTimePointId );

			throw e;
		}

		try{
			RegularTimePointBusinessDelegate.getRegularTimePointInstance().delete( new DeleteRegularTimePointCommand( entity.getRegularTimePointId() ) ).get();
			LOGGER.info( "-- Successfully deleted RegularTimePoint with id " + regularTimePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RegularTimePoint with id " + regularTimePointId );

			throw e;
		}
	}

	/**
	 * get all RegularTimePoints.
	 */
	protected List<RegularTimePoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RegularTimePoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RegularTimePoint : " );        
		List<RegularTimePoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the RegularTimePointBusinessDelegate
			collection = RegularTimePointBusinessDelegate.getRegularTimePointInstance().getAllRegularTimePoint();
			assertNotNull( collection, "An Empty collection of RegularTimePoint was incorrectly returned.");
			
			// Now print out the values
			RegularTimePoint entity = null;            
			Iterator<RegularTimePoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRegularTimePointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RegularTimePointTest
	 */
	protected RegularTimePointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RegularTimePoint
	 * 
	 * @return CreateRegularTimePointCommand alias
	 */
	protected CreateRegularTimePointCommand generateNewCommand() {
        CreateRegularTimePointCommand command = new CreateRegularTimePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RegularTimePoint
		 * 
		 * @return UpdateRegularTimePointCommand alias
		 */
	protected UpdateRegularTimePointCommand generateUpdateCommand() {
	        UpdateRegularTimePointCommand command = new UpdateRegularTimePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID regularTimePointId = null;
	protected RegularTimePointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RegularTimePointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRegularTimePointList = 0;
}
