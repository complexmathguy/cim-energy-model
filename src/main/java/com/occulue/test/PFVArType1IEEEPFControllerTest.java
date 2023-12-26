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
 * Test PFVArType1IEEEPFController class.
 *
 * @author your_name_here
 */
public class PFVArType1IEEEPFControllerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArType1IEEEPFControllerTest() {
		subscriber = new PFVArType1IEEEPFControllerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArType1IEEEPFControllerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArType1IEEEPFController...");
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
	 * jumpstart the process by instantiating2 PFVArType1IEEEPFController
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArType1IEEEPFControllerId = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
		.createPFVArType1IEEEPFController( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
				.createPFVArType1IEEEPFController( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArType1IEEEPFControllerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArType1IEEEPFController : " + successValue.getPFVArType1IEEEPFControllerId());
							  if (successValue.getPFVArType1IEEEPFControllerId().equals(pFVArType1IEEEPFControllerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArType1IEEEPFControllerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArType1IEEEPFController test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType1IEEEPFController consumed")
					);
			subscriber.pFVArType1IEEEPFControllerSubscribe( pFVArType1IEEEPFControllerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArType1IEEEPFController : " + successValue.getPFVArType1IEEEPFControllerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArType1IEEEPFControllerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType1IEEEPFController for pFVArType1IEEEPFControllerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArType1IEEEPFController. 
	 */
	protected PFVArType1IEEEPFController read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArType1IEEEPFController" );

		PFVArType1IEEEPFController entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArType1IEEEPFController with primary key" );
		msg.append( pFVArType1IEEEPFControllerId );
		
		PFVArType1IEEEPFControllerFetchOneSummary fetchOneSummary = new PFVArType1IEEEPFControllerFetchOneSummary( pFVArType1IEEEPFControllerId );

		try {
			entity = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().getPFVArType1IEEEPFController( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArType1IEEEPFController " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArType1IEEEPFController.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArType1IEEEPFController." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArType1IEEEPFController : " );        
		PFVArType1IEEEPFController entity = read();
		UpdatePFVArType1IEEEPFControllerCommand command = generateUpdateCommand();
		command.setPFVArType1IEEEPFControllerId(entity.getPFVArType1IEEEPFControllerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArType1IEEEPFController." );

			// for use later on...
			pFVArType1IEEEPFControllerId = entity.getPFVArType1IEEEPFControllerId();

			PFVArType1IEEEPFControllerBusinessDelegate proxy = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();  

			proxy.updatePFVArType1IEEEPFController( command ).get();

			LOGGER.info( "-- Successfully saved PFVArType1IEEEPFController - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArType1IEEEPFControllerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArType1IEEEPFController.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArType1IEEEPFController." );

		PFVArType1IEEEPFController entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArType1IEEEPFController with id " + pFVArType1IEEEPFControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArType1IEEEPFController with id " + pFVArType1IEEEPFControllerId );

			throw e;
		}

		try{
			PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().delete( new DeletePFVArType1IEEEPFControllerCommand( entity.getPFVArType1IEEEPFControllerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArType1IEEEPFController with id " + pFVArType1IEEEPFControllerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArType1IEEEPFController with id " + pFVArType1IEEEPFControllerId );

			throw e;
		}
	}

	/**
	 * get all PFVArType1IEEEPFControllers.
	 */
	protected List<PFVArType1IEEEPFController> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArType1IEEEPFControllers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArType1IEEEPFController : " );        
		List<PFVArType1IEEEPFController> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArType1IEEEPFControllerBusinessDelegate
			collection = PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance().getAllPFVArType1IEEEPFController();
			assertNotNull( collection, "An Empty collection of PFVArType1IEEEPFController was incorrectly returned.");
			
			// Now print out the values
			PFVArType1IEEEPFController entity = null;            
			Iterator<PFVArType1IEEEPFController> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArType1IEEEPFControllerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArType1IEEEPFControllerTest
	 */
	protected PFVArType1IEEEPFControllerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArType1IEEEPFController
	 * 
	 * @return CreatePFVArType1IEEEPFControllerCommand alias
	 */
	protected CreatePFVArType1IEEEPFControllerCommand generateNewCommand() {
        CreatePFVArType1IEEEPFControllerCommand command = new CreatePFVArType1IEEEPFControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArType1IEEEPFController
		 * 
		 * @return UpdatePFVArType1IEEEPFControllerCommand alias
		 */
	protected UpdatePFVArType1IEEEPFControllerCommand generateUpdateCommand() {
	        UpdatePFVArType1IEEEPFControllerCommand command = new UpdatePFVArType1IEEEPFControllerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArType1IEEEPFControllerId = null;
	protected PFVArType1IEEEPFControllerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArType1IEEEPFControllerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArType1IEEEPFControllerList = 0;
}
