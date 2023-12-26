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
 * Test OverexcLimIEEE class.
 *
 * @author your_name_here
 */
public class OverexcLimIEEETest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcLimIEEETest() {
		subscriber = new OverexcLimIEEESubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcLimIEEETest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcLimIEEE...");
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
	 * jumpstart the process by instantiating2 OverexcLimIEEE
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcLimIEEEId = OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance()
		.createOverexcLimIEEE( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance()
				.createOverexcLimIEEE( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcLimIEEESubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcLimIEEE : " + successValue.getOverexcLimIEEEId());
							  if (successValue.getOverexcLimIEEEId().equals(overexcLimIEEEId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcLimIEEEList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcLimIEEE test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimIEEE consumed")
					);
			subscriber.overexcLimIEEESubscribe( overexcLimIEEEId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcLimIEEE : " + successValue.getOverexcLimIEEEId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcLimIEEEList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimIEEE for overexcLimIEEEId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcLimIEEE. 
	 */
	protected OverexcLimIEEE read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcLimIEEE" );

		OverexcLimIEEE entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcLimIEEE with primary key" );
		msg.append( overexcLimIEEEId );
		
		OverexcLimIEEEFetchOneSummary fetchOneSummary = new OverexcLimIEEEFetchOneSummary( overexcLimIEEEId );

		try {
			entity = OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().getOverexcLimIEEE( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcLimIEEE " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcLimIEEE.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcLimIEEE." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcLimIEEE : " );        
		OverexcLimIEEE entity = read();
		UpdateOverexcLimIEEECommand command = generateUpdateCommand();
		command.setOverexcLimIEEEId(entity.getOverexcLimIEEEId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcLimIEEE." );

			// for use later on...
			overexcLimIEEEId = entity.getOverexcLimIEEEId();

			OverexcLimIEEEBusinessDelegate proxy = OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();  

			proxy.updateOverexcLimIEEE( command ).get();

			LOGGER.info( "-- Successfully saved OverexcLimIEEE - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcLimIEEEId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcLimIEEE.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcLimIEEE." );

		OverexcLimIEEE entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcLimIEEE with id " + overexcLimIEEEId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcLimIEEE with id " + overexcLimIEEEId );

			throw e;
		}

		try{
			OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().delete( new DeleteOverexcLimIEEECommand( entity.getOverexcLimIEEEId() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcLimIEEE with id " + overexcLimIEEEId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcLimIEEE with id " + overexcLimIEEEId );

			throw e;
		}
	}

	/**
	 * get all OverexcLimIEEEs.
	 */
	protected List<OverexcLimIEEE> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcLimIEEEs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcLimIEEE : " );        
		List<OverexcLimIEEE> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcLimIEEEBusinessDelegate
			collection = OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().getAllOverexcLimIEEE();
			assertNotNull( collection, "An Empty collection of OverexcLimIEEE was incorrectly returned.");
			
			// Now print out the values
			OverexcLimIEEE entity = null;            
			Iterator<OverexcLimIEEE> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcLimIEEEId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcLimIEEETest
	 */
	protected OverexcLimIEEETest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcLimIEEE
	 * 
	 * @return CreateOverexcLimIEEECommand alias
	 */
	protected CreateOverexcLimIEEECommand generateNewCommand() {
        CreateOverexcLimIEEECommand command = new CreateOverexcLimIEEECommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcLimIEEE
		 * 
		 * @return UpdateOverexcLimIEEECommand alias
		 */
	protected UpdateOverexcLimIEEECommand generateUpdateCommand() {
	        UpdateOverexcLimIEEECommand command = new UpdateOverexcLimIEEECommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcLimIEEEId = null;
	protected OverexcLimIEEESubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcLimIEEETest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcLimIEEEList = 0;
}
