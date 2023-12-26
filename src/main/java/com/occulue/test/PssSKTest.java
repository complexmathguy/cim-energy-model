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
 * Test PssSK class.
 *
 * @author your_name_here
 */
public class PssSKTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssSKTest() {
		subscriber = new PssSKSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssSKTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssSK...");
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
	 * jumpstart the process by instantiating2 PssSK
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssSKId = PssSKBusinessDelegate.getPssSKInstance()
		.createPssSK( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssSKBusinessDelegate.getPssSKInstance()
				.createPssSK( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssSKSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssSK : " + successValue.getPssSKId());
							  if (successValue.getPssSKId().equals(pssSKId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssSKList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssSK test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssSK consumed")
					);
			subscriber.pssSKSubscribe( pssSKId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssSK : " + successValue.getPssSKId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssSKList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssSK for pssSKId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssSK. 
	 */
	protected PssSK read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssSK" );

		PssSK entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssSK with primary key" );
		msg.append( pssSKId );
		
		PssSKFetchOneSummary fetchOneSummary = new PssSKFetchOneSummary( pssSKId );

		try {
			entity = PssSKBusinessDelegate.getPssSKInstance().getPssSK( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssSK " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssSK.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssSK." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssSK : " );        
		PssSK entity = read();
		UpdatePssSKCommand command = generateUpdateCommand();
		command.setPssSKId(entity.getPssSKId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssSK." );

			// for use later on...
			pssSKId = entity.getPssSKId();

			PssSKBusinessDelegate proxy = PssSKBusinessDelegate.getPssSKInstance();  

			proxy.updatePssSK( command ).get();

			LOGGER.info( "-- Successfully saved PssSK - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssSKId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssSK.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssSK." );

		PssSK entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssSK with id " + pssSKId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssSK with id " + pssSKId );

			throw e;
		}

		try{
			PssSKBusinessDelegate.getPssSKInstance().delete( new DeletePssSKCommand( entity.getPssSKId() ) ).get();
			LOGGER.info( "-- Successfully deleted PssSK with id " + pssSKId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssSK with id " + pssSKId );

			throw e;
		}
	}

	/**
	 * get all PssSKs.
	 */
	protected List<PssSK> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssSKs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssSK : " );        
		List<PssSK> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssSKBusinessDelegate
			collection = PssSKBusinessDelegate.getPssSKInstance().getAllPssSK();
			assertNotNull( collection, "An Empty collection of PssSK was incorrectly returned.");
			
			// Now print out the values
			PssSK entity = null;            
			Iterator<PssSK> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssSKId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssSKTest
	 */
	protected PssSKTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssSK
	 * 
	 * @return CreatePssSKCommand alias
	 */
	protected CreatePssSKCommand generateNewCommand() {
        CreatePssSKCommand command = new CreatePssSKCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssSK
		 * 
		 * @return UpdatePssSKCommand alias
		 */
	protected UpdatePssSKCommand generateUpdateCommand() {
	        UpdatePssSKCommand command = new UpdatePssSKCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssSKId = null;
	protected PssSKSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssSKTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssSKList = 0;
}
