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
 * Test ApparentPowerLimit class.
 *
 * @author your_name_here
 */
public class ApparentPowerLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ApparentPowerLimitTest() {
		subscriber = new ApparentPowerLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ApparentPowerLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ApparentPowerLimit...");
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
	 * jumpstart the process by instantiating2 ApparentPowerLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		apparentPowerLimitId = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance()
		.createApparentPowerLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance()
				.createApparentPowerLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.apparentPowerLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ApparentPowerLimit : " + successValue.getApparentPowerLimitId());
							  if (successValue.getApparentPowerLimitId().equals(apparentPowerLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfApparentPowerLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ApparentPowerLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on apparentPowerLimit consumed")
					);
			subscriber.apparentPowerLimitSubscribe( apparentPowerLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ApparentPowerLimit : " + successValue.getApparentPowerLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfApparentPowerLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on apparentPowerLimit for apparentPowerLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ApparentPowerLimit. 
	 */
	protected ApparentPowerLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ApparentPowerLimit" );

		ApparentPowerLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ApparentPowerLimit with primary key" );
		msg.append( apparentPowerLimitId );
		
		ApparentPowerLimitFetchOneSummary fetchOneSummary = new ApparentPowerLimitFetchOneSummary( apparentPowerLimitId );

		try {
			entity = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().getApparentPowerLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ApparentPowerLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ApparentPowerLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ApparentPowerLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a ApparentPowerLimit : " );        
		ApparentPowerLimit entity = read();
		UpdateApparentPowerLimitCommand command = generateUpdateCommand();
		command.setApparentPowerLimitId(entity.getApparentPowerLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ApparentPowerLimit." );

			// for use later on...
			apparentPowerLimitId = entity.getApparentPowerLimitId();

			ApparentPowerLimitBusinessDelegate proxy = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance();  

			proxy.updateApparentPowerLimit( command ).get();

			LOGGER.info( "-- Successfully saved ApparentPowerLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + apparentPowerLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ApparentPowerLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ApparentPowerLimit." );

		ApparentPowerLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ApparentPowerLimit with id " + apparentPowerLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ApparentPowerLimit with id " + apparentPowerLimitId );

			throw e;
		}

		try{
			ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().delete( new DeleteApparentPowerLimitCommand( entity.getApparentPowerLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted ApparentPowerLimit with id " + apparentPowerLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ApparentPowerLimit with id " + apparentPowerLimitId );

			throw e;
		}
	}

	/**
	 * get all ApparentPowerLimits.
	 */
	protected List<ApparentPowerLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ApparentPowerLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ApparentPowerLimit : " );        
		List<ApparentPowerLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the ApparentPowerLimitBusinessDelegate
			collection = ApparentPowerLimitBusinessDelegate.getApparentPowerLimitInstance().getAllApparentPowerLimit();
			assertNotNull( collection, "An Empty collection of ApparentPowerLimit was incorrectly returned.");
			
			// Now print out the values
			ApparentPowerLimit entity = null;            
			Iterator<ApparentPowerLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getApparentPowerLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ApparentPowerLimitTest
	 */
	protected ApparentPowerLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ApparentPowerLimit
	 * 
	 * @return CreateApparentPowerLimitCommand alias
	 */
	protected CreateApparentPowerLimitCommand generateNewCommand() {
        CreateApparentPowerLimitCommand command = new CreateApparentPowerLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ApparentPowerLimit
		 * 
		 * @return UpdateApparentPowerLimitCommand alias
		 */
	protected UpdateApparentPowerLimitCommand generateUpdateCommand() {
	        UpdateApparentPowerLimitCommand command = new UpdateApparentPowerLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID apparentPowerLimitId = null;
	protected ApparentPowerLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ApparentPowerLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfApparentPowerLimitList = 0;
}
