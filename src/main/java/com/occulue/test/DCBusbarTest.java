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
 * Test DCBusbar class.
 *
 * @author your_name_here
 */
public class DCBusbarTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCBusbarTest() {
		subscriber = new DCBusbarSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCBusbarTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCBusbar...");
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
	 * jumpstart the process by instantiating2 DCBusbar
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCBusbarId = DCBusbarBusinessDelegate.getDCBusbarInstance()
		.createDCBusbar( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCBusbarBusinessDelegate.getDCBusbarInstance()
				.createDCBusbar( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCBusbarSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCBusbar : " + successValue.getDCBusbarId());
							  if (successValue.getDCBusbarId().equals(dCBusbarId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCBusbarList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCBusbar test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBusbar consumed")
					);
			subscriber.dCBusbarSubscribe( dCBusbarId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCBusbar : " + successValue.getDCBusbarId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCBusbarList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCBusbar for dCBusbarId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCBusbar. 
	 */
	protected DCBusbar read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCBusbar" );

		DCBusbar entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCBusbar with primary key" );
		msg.append( dCBusbarId );
		
		DCBusbarFetchOneSummary fetchOneSummary = new DCBusbarFetchOneSummary( dCBusbarId );

		try {
			entity = DCBusbarBusinessDelegate.getDCBusbarInstance().getDCBusbar( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCBusbar " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCBusbar.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCBusbar." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCBusbar : " );        
		DCBusbar entity = read();
		UpdateDCBusbarCommand command = generateUpdateCommand();
		command.setDCBusbarId(entity.getDCBusbarId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCBusbar." );

			// for use later on...
			dCBusbarId = entity.getDCBusbarId();

			DCBusbarBusinessDelegate proxy = DCBusbarBusinessDelegate.getDCBusbarInstance();  

			proxy.updateDCBusbar( command ).get();

			LOGGER.info( "-- Successfully saved DCBusbar - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCBusbarId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCBusbar.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCBusbar." );

		DCBusbar entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCBusbar with id " + dCBusbarId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCBusbar with id " + dCBusbarId );

			throw e;
		}

		try{
			DCBusbarBusinessDelegate.getDCBusbarInstance().delete( new DeleteDCBusbarCommand( entity.getDCBusbarId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCBusbar with id " + dCBusbarId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCBusbar with id " + dCBusbarId );

			throw e;
		}
	}

	/**
	 * get all DCBusbars.
	 */
	protected List<DCBusbar> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCBusbars:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCBusbar : " );        
		List<DCBusbar> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCBusbarBusinessDelegate
			collection = DCBusbarBusinessDelegate.getDCBusbarInstance().getAllDCBusbar();
			assertNotNull( collection, "An Empty collection of DCBusbar was incorrectly returned.");
			
			// Now print out the values
			DCBusbar entity = null;            
			Iterator<DCBusbar> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCBusbarId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCBusbarTest
	 */
	protected DCBusbarTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCBusbar
	 * 
	 * @return CreateDCBusbarCommand alias
	 */
	protected CreateDCBusbarCommand generateNewCommand() {
        CreateDCBusbarCommand command = new CreateDCBusbarCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCBusbar
		 * 
		 * @return UpdateDCBusbarCommand alias
		 */
	protected UpdateDCBusbarCommand generateUpdateCommand() {
	        UpdateDCBusbarCommand command = new UpdateDCBusbarCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCBusbarId = null;
	protected DCBusbarSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCBusbarTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCBusbarList = 0;
}
