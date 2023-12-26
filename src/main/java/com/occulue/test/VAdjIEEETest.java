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
 * Test VAdjIEEE class.
 *
 * @author your_name_here
 */
public class VAdjIEEETest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VAdjIEEETest() {
		subscriber = new VAdjIEEESubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VAdjIEEETest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VAdjIEEE...");
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
	 * jumpstart the process by instantiating2 VAdjIEEE
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		vAdjIEEEId = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance()
		.createVAdjIEEE( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VAdjIEEEBusinessDelegate.getVAdjIEEEInstance()
				.createVAdjIEEE( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.vAdjIEEESubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VAdjIEEE : " + successValue.getVAdjIEEEId());
							  if (successValue.getVAdjIEEEId().equals(vAdjIEEEId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVAdjIEEEList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VAdjIEEE test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vAdjIEEE consumed")
					);
			subscriber.vAdjIEEESubscribe( vAdjIEEEId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VAdjIEEE : " + successValue.getVAdjIEEEId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVAdjIEEEList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vAdjIEEE for vAdjIEEEId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VAdjIEEE. 
	 */
	protected VAdjIEEE read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VAdjIEEE" );

		VAdjIEEE entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VAdjIEEE with primary key" );
		msg.append( vAdjIEEEId );
		
		VAdjIEEEFetchOneSummary fetchOneSummary = new VAdjIEEEFetchOneSummary( vAdjIEEEId );

		try {
			entity = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().getVAdjIEEE( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VAdjIEEE " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VAdjIEEE.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VAdjIEEE." );

		StringBuilder msg = new StringBuilder( "Failed to update a VAdjIEEE : " );        
		VAdjIEEE entity = read();
		UpdateVAdjIEEECommand command = generateUpdateCommand();
		command.setVAdjIEEEId(entity.getVAdjIEEEId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VAdjIEEE." );

			// for use later on...
			vAdjIEEEId = entity.getVAdjIEEEId();

			VAdjIEEEBusinessDelegate proxy = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance();  

			proxy.updateVAdjIEEE( command ).get();

			LOGGER.info( "-- Successfully saved VAdjIEEE - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + vAdjIEEEId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VAdjIEEE.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VAdjIEEE." );

		VAdjIEEE entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VAdjIEEE with id " + vAdjIEEEId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VAdjIEEE with id " + vAdjIEEEId );

			throw e;
		}

		try{
			VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().delete( new DeleteVAdjIEEECommand( entity.getVAdjIEEEId() ) ).get();
			LOGGER.info( "-- Successfully deleted VAdjIEEE with id " + vAdjIEEEId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VAdjIEEE with id " + vAdjIEEEId );

			throw e;
		}
	}

	/**
	 * get all VAdjIEEEs.
	 */
	protected List<VAdjIEEE> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VAdjIEEEs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VAdjIEEE : " );        
		List<VAdjIEEE> collection  = new ArrayList<>();

		try {
			// call the static get method on the VAdjIEEEBusinessDelegate
			collection = VAdjIEEEBusinessDelegate.getVAdjIEEEInstance().getAllVAdjIEEE();
			assertNotNull( collection, "An Empty collection of VAdjIEEE was incorrectly returned.");
			
			// Now print out the values
			VAdjIEEE entity = null;            
			Iterator<VAdjIEEE> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVAdjIEEEId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VAdjIEEETest
	 */
	protected VAdjIEEETest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VAdjIEEE
	 * 
	 * @return CreateVAdjIEEECommand alias
	 */
	protected CreateVAdjIEEECommand generateNewCommand() {
        CreateVAdjIEEECommand command = new CreateVAdjIEEECommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VAdjIEEE
		 * 
		 * @return UpdateVAdjIEEECommand alias
		 */
	protected UpdateVAdjIEEECommand generateUpdateCommand() {
	        UpdateVAdjIEEECommand command = new UpdateVAdjIEEECommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID vAdjIEEEId = null;
	protected VAdjIEEESubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VAdjIEEETest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVAdjIEEEList = 0;
}
