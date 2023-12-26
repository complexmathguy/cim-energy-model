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
 * Test ApparentPower class.
 *
 * @author your_name_here
 */
public class ApparentPowerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ApparentPowerTest() {
		subscriber = new ApparentPowerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ApparentPowerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ApparentPower...");
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
	 * jumpstart the process by instantiating2 ApparentPower
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		apparentPowerId = ApparentPowerBusinessDelegate.getApparentPowerInstance()
		.createApparentPower( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ApparentPowerBusinessDelegate.getApparentPowerInstance()
				.createApparentPower( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.apparentPowerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ApparentPower : " + successValue.getApparentPowerId());
							  if (successValue.getApparentPowerId().equals(apparentPowerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfApparentPowerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ApparentPower test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on apparentPower consumed")
					);
			subscriber.apparentPowerSubscribe( apparentPowerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ApparentPower : " + successValue.getApparentPowerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfApparentPowerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on apparentPower for apparentPowerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ApparentPower. 
	 */
	protected ApparentPower read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ApparentPower" );

		ApparentPower entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ApparentPower with primary key" );
		msg.append( apparentPowerId );
		
		ApparentPowerFetchOneSummary fetchOneSummary = new ApparentPowerFetchOneSummary( apparentPowerId );

		try {
			entity = ApparentPowerBusinessDelegate.getApparentPowerInstance().getApparentPower( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ApparentPower " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ApparentPower.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ApparentPower." );

		StringBuilder msg = new StringBuilder( "Failed to update a ApparentPower : " );        
		ApparentPower entity = read();
		UpdateApparentPowerCommand command = generateUpdateCommand();
		command.setApparentPowerId(entity.getApparentPowerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ApparentPower." );

			// for use later on...
			apparentPowerId = entity.getApparentPowerId();

			ApparentPowerBusinessDelegate proxy = ApparentPowerBusinessDelegate.getApparentPowerInstance();  

			proxy.updateApparentPower( command ).get();

			LOGGER.info( "-- Successfully saved ApparentPower - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + apparentPowerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ApparentPower.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ApparentPower." );

		ApparentPower entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ApparentPower with id " + apparentPowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ApparentPower with id " + apparentPowerId );

			throw e;
		}

		try{
			ApparentPowerBusinessDelegate.getApparentPowerInstance().delete( new DeleteApparentPowerCommand( entity.getApparentPowerId() ) ).get();
			LOGGER.info( "-- Successfully deleted ApparentPower with id " + apparentPowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ApparentPower with id " + apparentPowerId );

			throw e;
		}
	}

	/**
	 * get all ApparentPowers.
	 */
	protected List<ApparentPower> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ApparentPowers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ApparentPower : " );        
		List<ApparentPower> collection  = new ArrayList<>();

		try {
			// call the static get method on the ApparentPowerBusinessDelegate
			collection = ApparentPowerBusinessDelegate.getApparentPowerInstance().getAllApparentPower();
			assertNotNull( collection, "An Empty collection of ApparentPower was incorrectly returned.");
			
			// Now print out the values
			ApparentPower entity = null;            
			Iterator<ApparentPower> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getApparentPowerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ApparentPowerTest
	 */
	protected ApparentPowerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ApparentPower
	 * 
	 * @return CreateApparentPowerCommand alias
	 */
	protected CreateApparentPowerCommand generateNewCommand() {
        CreateApparentPowerCommand command = new CreateApparentPowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ApparentPower
		 * 
		 * @return UpdateApparentPowerCommand alias
		 */
	protected UpdateApparentPowerCommand generateUpdateCommand() {
	        UpdateApparentPowerCommand command = new UpdateApparentPowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID apparentPowerId = null;
	protected ApparentPowerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ApparentPowerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfApparentPowerList = 0;
}
