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
 * Test RotatingMachineDynamics class.
 *
 * @author your_name_here
 */
public class RotatingMachineDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RotatingMachineDynamicsTest() {
		subscriber = new RotatingMachineDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RotatingMachineDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RotatingMachineDynamics...");
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
	 * jumpstart the process by instantiating2 RotatingMachineDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		rotatingMachineDynamicsId = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
		.createRotatingMachineDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
				.createRotatingMachineDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.rotatingMachineDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RotatingMachineDynamics : " + successValue.getRotatingMachineDynamicsId());
							  if (successValue.getRotatingMachineDynamicsId().equals(rotatingMachineDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRotatingMachineDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RotatingMachineDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotatingMachineDynamics consumed")
					);
			subscriber.rotatingMachineDynamicsSubscribe( rotatingMachineDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RotatingMachineDynamics : " + successValue.getRotatingMachineDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRotatingMachineDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on rotatingMachineDynamics for rotatingMachineDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RotatingMachineDynamics. 
	 */
	protected RotatingMachineDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RotatingMachineDynamics" );

		RotatingMachineDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RotatingMachineDynamics with primary key" );
		msg.append( rotatingMachineDynamicsId );
		
		RotatingMachineDynamicsFetchOneSummary fetchOneSummary = new RotatingMachineDynamicsFetchOneSummary( rotatingMachineDynamicsId );

		try {
			entity = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().getRotatingMachineDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RotatingMachineDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RotatingMachineDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RotatingMachineDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a RotatingMachineDynamics : " );        
		RotatingMachineDynamics entity = read();
		UpdateRotatingMachineDynamicsCommand command = generateUpdateCommand();
		command.setRotatingMachineDynamicsId(entity.getRotatingMachineDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RotatingMachineDynamics." );

			// for use later on...
			rotatingMachineDynamicsId = entity.getRotatingMachineDynamicsId();

			RotatingMachineDynamicsBusinessDelegate proxy = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();  

			proxy.updateRotatingMachineDynamics( command ).get();

			LOGGER.info( "-- Successfully saved RotatingMachineDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + rotatingMachineDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RotatingMachineDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RotatingMachineDynamics." );

		RotatingMachineDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RotatingMachineDynamics with id " + rotatingMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RotatingMachineDynamics with id " + rotatingMachineDynamicsId );

			throw e;
		}

		try{
			RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().delete( new DeleteRotatingMachineDynamicsCommand( entity.getRotatingMachineDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted RotatingMachineDynamics with id " + rotatingMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RotatingMachineDynamics with id " + rotatingMachineDynamicsId );

			throw e;
		}
	}

	/**
	 * get all RotatingMachineDynamicss.
	 */
	protected List<RotatingMachineDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RotatingMachineDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RotatingMachineDynamics : " );        
		List<RotatingMachineDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the RotatingMachineDynamicsBusinessDelegate
			collection = RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance().getAllRotatingMachineDynamics();
			assertNotNull( collection, "An Empty collection of RotatingMachineDynamics was incorrectly returned.");
			
			// Now print out the values
			RotatingMachineDynamics entity = null;            
			Iterator<RotatingMachineDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRotatingMachineDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RotatingMachineDynamicsTest
	 */
	protected RotatingMachineDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RotatingMachineDynamics
	 * 
	 * @return CreateRotatingMachineDynamicsCommand alias
	 */
	protected CreateRotatingMachineDynamicsCommand generateNewCommand() {
        CreateRotatingMachineDynamicsCommand command = new CreateRotatingMachineDynamicsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RotatingMachineDynamics
		 * 
		 * @return UpdateRotatingMachineDynamicsCommand alias
		 */
	protected UpdateRotatingMachineDynamicsCommand generateUpdateCommand() {
	        UpdateRotatingMachineDynamicsCommand command = new UpdateRotatingMachineDynamicsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID rotatingMachineDynamicsId = null;
	protected RotatingMachineDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RotatingMachineDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRotatingMachineDynamicsList = 0;
}
