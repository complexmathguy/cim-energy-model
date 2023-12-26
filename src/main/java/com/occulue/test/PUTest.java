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
 * Test PU class.
 *
 * @author your_name_here
 */
public class PUTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PUTest() {
		subscriber = new PUSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PUTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PU...");
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
	 * jumpstart the process by instantiating2 PU
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pUId = PUBusinessDelegate.getPUInstance()
		.createPU( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PUBusinessDelegate.getPUInstance()
				.createPU( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pUSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PU : " + successValue.getPUId());
							  if (successValue.getPUId().equals(pUId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPUList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PU test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pU consumed")
					);
			subscriber.pUSubscribe( pUId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PU : " + successValue.getPUId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPUList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pU for pUId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PU. 
	 */
	protected PU read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PU" );

		PU entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PU with primary key" );
		msg.append( pUId );
		
		PUFetchOneSummary fetchOneSummary = new PUFetchOneSummary( pUId );

		try {
			entity = PUBusinessDelegate.getPUInstance().getPU( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PU " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PU.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PU." );

		StringBuilder msg = new StringBuilder( "Failed to update a PU : " );        
		PU entity = read();
		UpdatePUCommand command = generateUpdateCommand();
		command.setPUId(entity.getPUId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PU." );

			// for use later on...
			pUId = entity.getPUId();

			PUBusinessDelegate proxy = PUBusinessDelegate.getPUInstance();  

			proxy.updatePU( command ).get();

			LOGGER.info( "-- Successfully saved PU - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pUId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PU.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PU." );

		PU entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PU with id " + pUId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PU with id " + pUId );

			throw e;
		}

		try{
			PUBusinessDelegate.getPUInstance().delete( new DeletePUCommand( entity.getPUId() ) ).get();
			LOGGER.info( "-- Successfully deleted PU with id " + pUId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PU with id " + pUId );

			throw e;
		}
	}

	/**
	 * get all PUs.
	 */
	protected List<PU> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PUs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PU : " );        
		List<PU> collection  = new ArrayList<>();

		try {
			// call the static get method on the PUBusinessDelegate
			collection = PUBusinessDelegate.getPUInstance().getAllPU();
			assertNotNull( collection, "An Empty collection of PU was incorrectly returned.");
			
			// Now print out the values
			PU entity = null;            
			Iterator<PU> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPUId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PUTest
	 */
	protected PUTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PU
	 * 
	 * @return CreatePUCommand alias
	 */
	protected CreatePUCommand generateNewCommand() {
        CreatePUCommand command = new CreatePUCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PU
		 * 
		 * @return UpdatePUCommand alias
		 */
	protected UpdatePUCommand generateUpdateCommand() {
	        UpdatePUCommand command = new UpdatePUCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pUId = null;
	protected PUSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PUTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPUList = 0;
}
