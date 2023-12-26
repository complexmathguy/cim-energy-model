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
 * Test PFVArType1IEEEVArController class.
 *
 * @author your_name_here
 */
public class PFVArType1IEEEVArControllerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArType1IEEEVArControllerTest() {
		subscriber = new PFVArType1IEEEVArControllerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArType1IEEEVArControllerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArType1IEEEVArController...");
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
	 * jumpstart the process by instantiating2 PFVArType1IEEEVArController
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArType1IEEEVArControllerId = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
		.createPFVArType1IEEEVArController( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
				.createPFVArType1IEEEVArController( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArType1IEEEVArControllerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArType1IEEEVArController : " + successValue.getPFVArType1IEEEVArControllerId());
							  if (successValue.getPFVArType1IEEEVArControllerId().equals(pFVArType1IEEEVArControllerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArType1IEEEVArControllerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArType1IEEEVArController test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType1IEEEVArController consumed")
					);
			subscriber.pFVArType1IEEEVArControllerSubscribe( pFVArType1IEEEVArControllerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArType1IEEEVArController : " + successValue.getPFVArType1IEEEVArControllerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArType1IEEEVArControllerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType1IEEEVArController for pFVArType1IEEEVArControllerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArType1IEEEVArController. 
	 */
	protected PFVArType1IEEEVArController read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArType1IEEEVArController" );

		PFVArType1IEEEVArController entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArType1IEEEVArController with primary key" );
		msg.append( pFVArType1IEEEVArControllerId );
		
		PFVArType1IEEEVArControllerFetchOneSummary fetchOneSummary = new PFVArType1IEEEVArControllerFetchOneSummary( pFVArType1IEEEVArControllerId );

		try {
			entity = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().getPFVArType1IEEEVArController( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArType1IEEEVArController " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArType1IEEEVArController.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArType1IEEEVArController." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArType1IEEEVArController : " );        
		PFVArType1IEEEVArController entity = read();
		UpdatePFVArType1IEEEVArControllerCommand command = generateUpdateCommand();
		command.setPFVArType1IEEEVArControllerId(entity.getPFVArType1IEEEVArControllerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArType1IEEEVArController." );

			// for use later on...
			pFVArType1IEEEVArControllerId = entity.getPFVArType1IEEEVArControllerId();

			PFVArType1IEEEVArControllerBusinessDelegate proxy = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();  

			proxy.updatePFVArType1IEEEVArController( command ).get();

			LOGGER.info( "-- Successfully saved PFVArType1IEEEVArController - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArType1IEEEVArControllerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArType1IEEEVArController.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArType1IEEEVArController." );

		PFVArType1IEEEVArController entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArType1IEEEVArController with id " + pFVArType1IEEEVArControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArType1IEEEVArController with id " + pFVArType1IEEEVArControllerId );

			throw e;
		}

		try{
			PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().delete( new DeletePFVArType1IEEEVArControllerCommand( entity.getPFVArType1IEEEVArControllerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArType1IEEEVArController with id " + pFVArType1IEEEVArControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArType1IEEEVArController with id " + pFVArType1IEEEVArControllerId );

			throw e;
		}
	}

	/**
	 * get all PFVArType1IEEEVArControllers.
	 */
	protected List<PFVArType1IEEEVArController> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArType1IEEEVArControllers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArType1IEEEVArController : " );        
		List<PFVArType1IEEEVArController> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArType1IEEEVArControllerBusinessDelegate
			collection = PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance().getAllPFVArType1IEEEVArController();
			assertNotNull( collection, "An Empty collection of PFVArType1IEEEVArController was incorrectly returned.");
			
			// Now print out the values
			PFVArType1IEEEVArController entity = null;            
			Iterator<PFVArType1IEEEVArController> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArType1IEEEVArControllerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArType1IEEEVArControllerTest
	 */
	protected PFVArType1IEEEVArControllerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArType1IEEEVArController
	 * 
	 * @return CreatePFVArType1IEEEVArControllerCommand alias
	 */
	protected CreatePFVArType1IEEEVArControllerCommand generateNewCommand() {
        CreatePFVArType1IEEEVArControllerCommand command = new CreatePFVArType1IEEEVArControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArType1IEEEVArController
		 * 
		 * @return UpdatePFVArType1IEEEVArControllerCommand alias
		 */
	protected UpdatePFVArType1IEEEVArControllerCommand generateUpdateCommand() {
	        UpdatePFVArType1IEEEVArControllerCommand command = new UpdatePFVArType1IEEEVArControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArType1IEEEVArControllerId = null;
	protected PFVArType1IEEEVArControllerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArType1IEEEVArControllerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArType1IEEEVArControllerList = 0;
}
