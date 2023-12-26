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
 * Test DCDisconnector class.
 *
 * @author your_name_here
 */
public class DCDisconnectorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCDisconnectorTest() {
		subscriber = new DCDisconnectorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCDisconnectorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCDisconnector...");
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
	 * jumpstart the process by instantiating2 DCDisconnector
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCDisconnectorId = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance()
		.createDCDisconnector( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCDisconnectorBusinessDelegate.getDCDisconnectorInstance()
				.createDCDisconnector( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCDisconnectorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCDisconnector : " + successValue.getDCDisconnectorId());
							  if (successValue.getDCDisconnectorId().equals(dCDisconnectorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCDisconnectorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCDisconnector test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCDisconnector consumed")
					);
			subscriber.dCDisconnectorSubscribe( dCDisconnectorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCDisconnector : " + successValue.getDCDisconnectorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCDisconnectorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCDisconnector for dCDisconnectorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCDisconnector. 
	 */
	protected DCDisconnector read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCDisconnector" );

		DCDisconnector entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCDisconnector with primary key" );
		msg.append( dCDisconnectorId );
		
		DCDisconnectorFetchOneSummary fetchOneSummary = new DCDisconnectorFetchOneSummary( dCDisconnectorId );

		try {
			entity = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().getDCDisconnector( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCDisconnector " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCDisconnector.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCDisconnector." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCDisconnector : " );        
		DCDisconnector entity = read();
		UpdateDCDisconnectorCommand command = generateUpdateCommand();
		command.setDCDisconnectorId(entity.getDCDisconnectorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCDisconnector." );

			// for use later on...
			dCDisconnectorId = entity.getDCDisconnectorId();

			DCDisconnectorBusinessDelegate proxy = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance();  

			proxy.updateDCDisconnector( command ).get();

			LOGGER.info( "-- Successfully saved DCDisconnector - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCDisconnectorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCDisconnector.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCDisconnector." );

		DCDisconnector entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCDisconnector with id " + dCDisconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCDisconnector with id " + dCDisconnectorId );

			throw e;
		}

		try{
			DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().delete( new DeleteDCDisconnectorCommand( entity.getDCDisconnectorId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCDisconnector with id " + dCDisconnectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCDisconnector with id " + dCDisconnectorId );

			throw e;
		}
	}

	/**
	 * get all DCDisconnectors.
	 */
	protected List<DCDisconnector> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCDisconnectors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCDisconnector : " );        
		List<DCDisconnector> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCDisconnectorBusinessDelegate
			collection = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().getAllDCDisconnector();
			assertNotNull( collection, "An Empty collection of DCDisconnector was incorrectly returned.");
			
			// Now print out the values
			DCDisconnector entity = null;            
			Iterator<DCDisconnector> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCDisconnectorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCDisconnectorTest
	 */
	protected DCDisconnectorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCDisconnector
	 * 
	 * @return CreateDCDisconnectorCommand alias
	 */
	protected CreateDCDisconnectorCommand generateNewCommand() {
        CreateDCDisconnectorCommand command = new CreateDCDisconnectorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCDisconnector
		 * 
		 * @return UpdateDCDisconnectorCommand alias
		 */
	protected UpdateDCDisconnectorCommand generateUpdateCommand() {
	        UpdateDCDisconnectorCommand command = new UpdateDCDisconnectorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCDisconnectorId = null;
	protected DCDisconnectorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCDisconnectorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCDisconnectorList = 0;
}
