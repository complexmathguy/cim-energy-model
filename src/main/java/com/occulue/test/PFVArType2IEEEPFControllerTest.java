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
 * Test PFVArType2IEEEPFController class.
 *
 * @author your_name_here
 */
public class PFVArType2IEEEPFControllerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArType2IEEEPFControllerTest() {
		subscriber = new PFVArType2IEEEPFControllerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArType2IEEEPFControllerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArType2IEEEPFController...");
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
	 * jumpstart the process by instantiating2 PFVArType2IEEEPFController
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArType2IEEEPFControllerId = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
		.createPFVArType2IEEEPFController( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
				.createPFVArType2IEEEPFController( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArType2IEEEPFControllerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArType2IEEEPFController : " + successValue.getPFVArType2IEEEPFControllerId());
							  if (successValue.getPFVArType2IEEEPFControllerId().equals(pFVArType2IEEEPFControllerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArType2IEEEPFControllerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArType2IEEEPFController test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2IEEEPFController consumed")
					);
			subscriber.pFVArType2IEEEPFControllerSubscribe( pFVArType2IEEEPFControllerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArType2IEEEPFController : " + successValue.getPFVArType2IEEEPFControllerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArType2IEEEPFControllerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2IEEEPFController for pFVArType2IEEEPFControllerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArType2IEEEPFController. 
	 */
	protected PFVArType2IEEEPFController read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArType2IEEEPFController" );

		PFVArType2IEEEPFController entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArType2IEEEPFController with primary key" );
		msg.append( pFVArType2IEEEPFControllerId );
		
		PFVArType2IEEEPFControllerFetchOneSummary fetchOneSummary = new PFVArType2IEEEPFControllerFetchOneSummary( pFVArType2IEEEPFControllerId );

		try {
			entity = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().getPFVArType2IEEEPFController( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArType2IEEEPFController " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArType2IEEEPFController.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArType2IEEEPFController." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArType2IEEEPFController : " );        
		PFVArType2IEEEPFController entity = read();
		UpdatePFVArType2IEEEPFControllerCommand command = generateUpdateCommand();
		command.setPFVArType2IEEEPFControllerId(entity.getPFVArType2IEEEPFControllerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArType2IEEEPFController." );

			// for use later on...
			pFVArType2IEEEPFControllerId = entity.getPFVArType2IEEEPFControllerId();

			PFVArType2IEEEPFControllerBusinessDelegate proxy = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();  

			proxy.updatePFVArType2IEEEPFController( command ).get();

			LOGGER.info( "-- Successfully saved PFVArType2IEEEPFController - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArType2IEEEPFControllerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArType2IEEEPFController.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArType2IEEEPFController." );

		PFVArType2IEEEPFController entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArType2IEEEPFController with id " + pFVArType2IEEEPFControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArType2IEEEPFController with id " + pFVArType2IEEEPFControllerId );

			throw e;
		}

		try{
			PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().delete( new DeletePFVArType2IEEEPFControllerCommand( entity.getPFVArType2IEEEPFControllerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArType2IEEEPFController with id " + pFVArType2IEEEPFControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArType2IEEEPFController with id " + pFVArType2IEEEPFControllerId );

			throw e;
		}
	}

	/**
	 * get all PFVArType2IEEEPFControllers.
	 */
	protected List<PFVArType2IEEEPFController> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArType2IEEEPFControllers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArType2IEEEPFController : " );        
		List<PFVArType2IEEEPFController> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArType2IEEEPFControllerBusinessDelegate
			collection = PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance().getAllPFVArType2IEEEPFController();
			assertNotNull( collection, "An Empty collection of PFVArType2IEEEPFController was incorrectly returned.");
			
			// Now print out the values
			PFVArType2IEEEPFController entity = null;            
			Iterator<PFVArType2IEEEPFController> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArType2IEEEPFControllerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArType2IEEEPFControllerTest
	 */
	protected PFVArType2IEEEPFControllerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArType2IEEEPFController
	 * 
	 * @return CreatePFVArType2IEEEPFControllerCommand alias
	 */
	protected CreatePFVArType2IEEEPFControllerCommand generateNewCommand() {
        CreatePFVArType2IEEEPFControllerCommand command = new CreatePFVArType2IEEEPFControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArType2IEEEPFController
		 * 
		 * @return UpdatePFVArType2IEEEPFControllerCommand alias
		 */
	protected UpdatePFVArType2IEEEPFControllerCommand generateUpdateCommand() {
	        UpdatePFVArType2IEEEPFControllerCommand command = new UpdatePFVArType2IEEEPFControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArType2IEEEPFControllerId = null;
	protected PFVArType2IEEEPFControllerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArType2IEEEPFControllerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArType2IEEEPFControllerList = 0;
}
