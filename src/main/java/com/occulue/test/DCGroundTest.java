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
 * Test DCGround class.
 *
 * @author your_name_here
 */
public class DCGroundTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCGroundTest() {
		subscriber = new DCGroundSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCGroundTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCGround...");
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
	 * jumpstart the process by instantiating2 DCGround
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCGroundId = DCGroundBusinessDelegate.getDCGroundInstance()
		.createDCGround( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCGroundBusinessDelegate.getDCGroundInstance()
				.createDCGround( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCGroundSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCGround : " + successValue.getDCGroundId());
							  if (successValue.getDCGroundId().equals(dCGroundId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCGroundList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCGround test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCGround consumed")
					);
			subscriber.dCGroundSubscribe( dCGroundId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCGround : " + successValue.getDCGroundId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCGroundList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCGround for dCGroundId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCGround. 
	 */
	protected DCGround read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCGround" );

		DCGround entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCGround with primary key" );
		msg.append( dCGroundId );
		
		DCGroundFetchOneSummary fetchOneSummary = new DCGroundFetchOneSummary( dCGroundId );

		try {
			entity = DCGroundBusinessDelegate.getDCGroundInstance().getDCGround( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCGround " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCGround.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCGround." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCGround : " );        
		DCGround entity = read();
		UpdateDCGroundCommand command = generateUpdateCommand();
		command.setDCGroundId(entity.getDCGroundId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCGround." );

			// for use later on...
			dCGroundId = entity.getDCGroundId();

			DCGroundBusinessDelegate proxy = DCGroundBusinessDelegate.getDCGroundInstance();  

			proxy.updateDCGround( command ).get();

			LOGGER.info( "-- Successfully saved DCGround - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCGroundId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCGround.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCGround." );

		DCGround entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCGround with id " + dCGroundId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCGround with id " + dCGroundId );

			throw e;
		}

		try{
			DCGroundBusinessDelegate.getDCGroundInstance().delete( new DeleteDCGroundCommand( entity.getDCGroundId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCGround with id " + dCGroundId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCGround with id " + dCGroundId );

			throw e;
		}
	}

	/**
	 * get all DCGrounds.
	 */
	protected List<DCGround> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCGrounds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCGround : " );        
		List<DCGround> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCGroundBusinessDelegate
			collection = DCGroundBusinessDelegate.getDCGroundInstance().getAllDCGround();
			assertNotNull( collection, "An Empty collection of DCGround was incorrectly returned.");
			
			// Now print out the values
			DCGround entity = null;            
			Iterator<DCGround> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCGroundId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCGroundTest
	 */
	protected DCGroundTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCGround
	 * 
	 * @return CreateDCGroundCommand alias
	 */
	protected CreateDCGroundCommand generateNewCommand() {
        CreateDCGroundCommand command = new CreateDCGroundCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DCGround
		 * 
		 * @return UpdateDCGroundCommand alias
		 */
	protected UpdateDCGroundCommand generateUpdateCommand() {
	        UpdateDCGroundCommand command = new UpdateDCGroundCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCGroundId = null;
	protected DCGroundSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCGroundTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCGroundList = 0;
}
