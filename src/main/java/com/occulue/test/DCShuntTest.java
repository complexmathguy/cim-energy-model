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
 * Test DCShunt class.
 *
 * @author your_name_here
 */
public class DCShuntTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCShuntTest() {
		subscriber = new DCShuntSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCShuntTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCShunt...");
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
	 * jumpstart the process by instantiating2 DCShunt
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCShuntId = DCShuntBusinessDelegate.getDCShuntInstance()
		.createDCShunt( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCShuntBusinessDelegate.getDCShuntInstance()
				.createDCShunt( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCShuntSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCShunt : " + successValue.getDCShuntId());
							  if (successValue.getDCShuntId().equals(dCShuntId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCShuntList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCShunt test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCShunt consumed")
					);
			subscriber.dCShuntSubscribe( dCShuntId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCShunt : " + successValue.getDCShuntId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCShuntList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCShunt for dCShuntId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCShunt. 
	 */
	protected DCShunt read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCShunt" );

		DCShunt entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCShunt with primary key" );
		msg.append( dCShuntId );
		
		DCShuntFetchOneSummary fetchOneSummary = new DCShuntFetchOneSummary( dCShuntId );

		try {
			entity = DCShuntBusinessDelegate.getDCShuntInstance().getDCShunt( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCShunt " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCShunt.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCShunt." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCShunt : " );        
		DCShunt entity = read();
		UpdateDCShuntCommand command = generateUpdateCommand();
		command.setDCShuntId(entity.getDCShuntId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCShunt." );

			// for use later on...
			dCShuntId = entity.getDCShuntId();

			DCShuntBusinessDelegate proxy = DCShuntBusinessDelegate.getDCShuntInstance();  

			proxy.updateDCShunt( command ).get();

			LOGGER.info( "-- Successfully saved DCShunt - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCShuntId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCShunt.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCShunt." );

		DCShunt entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCShunt with id " + dCShuntId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCShunt with id " + dCShuntId );

			throw e;
		}

		try{
			DCShuntBusinessDelegate.getDCShuntInstance().delete( new DeleteDCShuntCommand( entity.getDCShuntId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCShunt with id " + dCShuntId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCShunt with id " + dCShuntId );

			throw e;
		}
	}

	/**
	 * get all DCShunts.
	 */
	protected List<DCShunt> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCShunts:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCShunt : " );        
		List<DCShunt> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCShuntBusinessDelegate
			collection = DCShuntBusinessDelegate.getDCShuntInstance().getAllDCShunt();
			assertNotNull( collection, "An Empty collection of DCShunt was incorrectly returned.");
			
			// Now print out the values
			DCShunt entity = null;            
			Iterator<DCShunt> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCShuntId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCShuntTest
	 */
	protected DCShuntTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCShunt
	 * 
	 * @return CreateDCShuntCommand alias
	 */
	protected CreateDCShuntCommand generateNewCommand() {
        CreateDCShuntCommand command = new CreateDCShuntCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DCShunt
		 * 
		 * @return UpdateDCShuntCommand alias
		 */
	protected UpdateDCShuntCommand generateUpdateCommand() {
	        UpdateDCShuntCommand command = new UpdateDCShuntCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCShuntId = null;
	protected DCShuntSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCShuntTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCShuntList = 0;
}
