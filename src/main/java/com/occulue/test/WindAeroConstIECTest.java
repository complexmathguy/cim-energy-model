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
 * Test WindAeroConstIEC class.
 *
 * @author your_name_here
 */
public class WindAeroConstIECTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindAeroConstIECTest() {
		subscriber = new WindAeroConstIECSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindAeroConstIECTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindAeroConstIEC...");
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
	 * jumpstart the process by instantiating2 WindAeroConstIEC
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windAeroConstIECId = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance()
		.createWindAeroConstIEC( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance()
				.createWindAeroConstIEC( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windAeroConstIECSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindAeroConstIEC : " + successValue.getWindAeroConstIECId());
							  if (successValue.getWindAeroConstIECId().equals(windAeroConstIECId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindAeroConstIECList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindAeroConstIEC test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windAeroConstIEC consumed")
					);
			subscriber.windAeroConstIECSubscribe( windAeroConstIECId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindAeroConstIEC : " + successValue.getWindAeroConstIECId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindAeroConstIECList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windAeroConstIEC for windAeroConstIECId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindAeroConstIEC. 
	 */
	protected WindAeroConstIEC read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindAeroConstIEC" );

		WindAeroConstIEC entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindAeroConstIEC with primary key" );
		msg.append( windAeroConstIECId );
		
		WindAeroConstIECFetchOneSummary fetchOneSummary = new WindAeroConstIECFetchOneSummary( windAeroConstIECId );

		try {
			entity = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().getWindAeroConstIEC( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindAeroConstIEC " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindAeroConstIEC.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindAeroConstIEC." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindAeroConstIEC : " );        
		WindAeroConstIEC entity = read();
		UpdateWindAeroConstIECCommand command = generateUpdateCommand();
		command.setWindAeroConstIECId(entity.getWindAeroConstIECId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindAeroConstIEC." );

			// for use later on...
			windAeroConstIECId = entity.getWindAeroConstIECId();

			WindAeroConstIECBusinessDelegate proxy = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance();  

			proxy.updateWindAeroConstIEC( command ).get();

			LOGGER.info( "-- Successfully saved WindAeroConstIEC - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windAeroConstIECId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindAeroConstIEC.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindAeroConstIEC." );

		WindAeroConstIEC entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindAeroConstIEC with id " + windAeroConstIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindAeroConstIEC with id " + windAeroConstIECId );

			throw e;
		}

		try{
			WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().delete( new DeleteWindAeroConstIECCommand( entity.getWindAeroConstIECId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindAeroConstIEC with id " + windAeroConstIECId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindAeroConstIEC with id " + windAeroConstIECId );

			throw e;
		}
	}

	/**
	 * get all WindAeroConstIECs.
	 */
	protected List<WindAeroConstIEC> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindAeroConstIECs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindAeroConstIEC : " );        
		List<WindAeroConstIEC> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindAeroConstIECBusinessDelegate
			collection = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().getAllWindAeroConstIEC();
			assertNotNull( collection, "An Empty collection of WindAeroConstIEC was incorrectly returned.");
			
			// Now print out the values
			WindAeroConstIEC entity = null;            
			Iterator<WindAeroConstIEC> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindAeroConstIECId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindAeroConstIECTest
	 */
	protected WindAeroConstIECTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindAeroConstIEC
	 * 
	 * @return CreateWindAeroConstIECCommand alias
	 */
	protected CreateWindAeroConstIECCommand generateNewCommand() {
        CreateWindAeroConstIECCommand command = new CreateWindAeroConstIECCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated WindAeroConstIEC
		 * 
		 * @return UpdateWindAeroConstIECCommand alias
		 */
	protected UpdateWindAeroConstIECCommand generateUpdateCommand() {
	        UpdateWindAeroConstIECCommand command = new UpdateWindAeroConstIECCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windAeroConstIECId = null;
	protected WindAeroConstIECSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindAeroConstIECTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindAeroConstIECList = 0;
}
