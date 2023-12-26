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
 * Test TapChanger class.
 *
 * @author your_name_here
 */
public class TapChangerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TapChangerTest() {
		subscriber = new TapChangerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TapChangerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TapChanger...");
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
	 * jumpstart the process by instantiating2 TapChanger
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		tapChangerId = TapChangerBusinessDelegate.getTapChangerInstance()
		.createTapChanger( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TapChangerBusinessDelegate.getTapChangerInstance()
				.createTapChanger( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.tapChangerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TapChanger : " + successValue.getTapChangerId());
							  if (successValue.getTapChangerId().equals(tapChangerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTapChangerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TapChanger test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChanger consumed")
					);
			subscriber.tapChangerSubscribe( tapChangerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TapChanger : " + successValue.getTapChangerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTapChangerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on tapChanger for tapChangerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TapChanger. 
	 */
	protected TapChanger read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TapChanger" );

		TapChanger entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TapChanger with primary key" );
		msg.append( tapChangerId );
		
		TapChangerFetchOneSummary fetchOneSummary = new TapChangerFetchOneSummary( tapChangerId );

		try {
			entity = TapChangerBusinessDelegate.getTapChangerInstance().getTapChanger( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TapChanger " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TapChanger.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TapChanger." );

		StringBuilder msg = new StringBuilder( "Failed to update a TapChanger : " );        
		TapChanger entity = read();
		UpdateTapChangerCommand command = generateUpdateCommand();
		command.setTapChangerId(entity.getTapChangerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TapChanger." );

			// for use later on...
			tapChangerId = entity.getTapChangerId();

			TapChangerBusinessDelegate proxy = TapChangerBusinessDelegate.getTapChangerInstance();  

			proxy.updateTapChanger( command ).get();

			LOGGER.info( "-- Successfully saved TapChanger - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + tapChangerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TapChanger.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TapChanger." );

		TapChanger entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TapChanger with id " + tapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TapChanger with id " + tapChangerId );

			throw e;
		}

		try{
			TapChangerBusinessDelegate.getTapChangerInstance().delete( new DeleteTapChangerCommand( entity.getTapChangerId() ) ).get();
			LOGGER.info( "-- Successfully deleted TapChanger with id " + tapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TapChanger with id " + tapChangerId );

			throw e;
		}
	}

	/**
	 * get all TapChangers.
	 */
	protected List<TapChanger> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TapChangers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TapChanger : " );        
		List<TapChanger> collection  = new ArrayList<>();

		try {
			// call the static get method on the TapChangerBusinessDelegate
			collection = TapChangerBusinessDelegate.getTapChangerInstance().getAllTapChanger();
			assertNotNull( collection, "An Empty collection of TapChanger was incorrectly returned.");
			
			// Now print out the values
			TapChanger entity = null;            
			Iterator<TapChanger> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTapChangerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TapChangerTest
	 */
	protected TapChangerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TapChanger
	 * 
	 * @return CreateTapChangerCommand alias
	 */
	protected CreateTapChangerCommand generateNewCommand() {
        CreateTapChangerCommand command = new CreateTapChangerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TapChanger
		 * 
		 * @return UpdateTapChangerCommand alias
		 */
	protected UpdateTapChangerCommand generateUpdateCommand() {
	        UpdateTapChangerCommand command = new UpdateTapChangerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID tapChangerId = null;
	protected TapChangerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TapChangerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTapChangerList = 0;
}
