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
 * Test PFVArType2IEEEVArController class.
 *
 * @author your_name_here
 */
public class PFVArType2IEEEVArControllerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArType2IEEEVArControllerTest() {
		subscriber = new PFVArType2IEEEVArControllerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArType2IEEEVArControllerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArType2IEEEVArController...");
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
	 * jumpstart the process by instantiating2 PFVArType2IEEEVArController
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArType2IEEEVArControllerId = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
		.createPFVArType2IEEEVArController( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
				.createPFVArType2IEEEVArController( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArType2IEEEVArControllerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArType2IEEEVArController : " + successValue.getPFVArType2IEEEVArControllerId());
							  if (successValue.getPFVArType2IEEEVArControllerId().equals(pFVArType2IEEEVArControllerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArType2IEEEVArControllerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArType2IEEEVArController test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2IEEEVArController consumed")
					);
			subscriber.pFVArType2IEEEVArControllerSubscribe( pFVArType2IEEEVArControllerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArType2IEEEVArController : " + successValue.getPFVArType2IEEEVArControllerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArType2IEEEVArControllerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2IEEEVArController for pFVArType2IEEEVArControllerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArType2IEEEVArController. 
	 */
	protected PFVArType2IEEEVArController read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArType2IEEEVArController" );

		PFVArType2IEEEVArController entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArType2IEEEVArController with primary key" );
		msg.append( pFVArType2IEEEVArControllerId );
		
		PFVArType2IEEEVArControllerFetchOneSummary fetchOneSummary = new PFVArType2IEEEVArControllerFetchOneSummary( pFVArType2IEEEVArControllerId );

		try {
			entity = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().getPFVArType2IEEEVArController( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArType2IEEEVArController " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArType2IEEEVArController.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArType2IEEEVArController." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArType2IEEEVArController : " );        
		PFVArType2IEEEVArController entity = read();
		UpdatePFVArType2IEEEVArControllerCommand command = generateUpdateCommand();
		command.setPFVArType2IEEEVArControllerId(entity.getPFVArType2IEEEVArControllerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArType2IEEEVArController." );

			// for use later on...
			pFVArType2IEEEVArControllerId = entity.getPFVArType2IEEEVArControllerId();

			PFVArType2IEEEVArControllerBusinessDelegate proxy = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance();  

			proxy.updatePFVArType2IEEEVArController( command ).get();

			LOGGER.info( "-- Successfully saved PFVArType2IEEEVArController - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArType2IEEEVArControllerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArType2IEEEVArController.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArType2IEEEVArController." );

		PFVArType2IEEEVArController entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArType2IEEEVArController with id " + pFVArType2IEEEVArControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArType2IEEEVArController with id " + pFVArType2IEEEVArControllerId );

			throw e;
		}

		try{
			PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().delete( new DeletePFVArType2IEEEVArControllerCommand( entity.getPFVArType2IEEEVArControllerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArType2IEEEVArController with id " + pFVArType2IEEEVArControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArType2IEEEVArController with id " + pFVArType2IEEEVArControllerId );

			throw e;
		}
	}

	/**
	 * get all PFVArType2IEEEVArControllers.
	 */
	protected List<PFVArType2IEEEVArController> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArType2IEEEVArControllers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArType2IEEEVArController : " );        
		List<PFVArType2IEEEVArController> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArType2IEEEVArControllerBusinessDelegate
			collection = PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance().getAllPFVArType2IEEEVArController();
			assertNotNull( collection, "An Empty collection of PFVArType2IEEEVArController was incorrectly returned.");
			
			// Now print out the values
			PFVArType2IEEEVArController entity = null;            
			Iterator<PFVArType2IEEEVArController> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArType2IEEEVArControllerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArType2IEEEVArControllerTest
	 */
	protected PFVArType2IEEEVArControllerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArType2IEEEVArController
	 * 
	 * @return CreatePFVArType2IEEEVArControllerCommand alias
	 */
	protected CreatePFVArType2IEEEVArControllerCommand generateNewCommand() {
        CreatePFVArType2IEEEVArControllerCommand command = new CreatePFVArType2IEEEVArControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArType2IEEEVArController
		 * 
		 * @return UpdatePFVArType2IEEEVArControllerCommand alias
		 */
	protected UpdatePFVArType2IEEEVArControllerCommand generateUpdateCommand() {
	        UpdatePFVArType2IEEEVArControllerCommand command = new UpdatePFVArType2IEEEVArControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArType2IEEEVArControllerId = null;
	protected PFVArType2IEEEVArControllerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArType2IEEEVArControllerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArType2IEEEVArControllerList = 0;
}
