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
 * Test OverexcitationLimiterDynamics class.
 *
 * @author your_name_here
 */
public class OverexcitationLimiterDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcitationLimiterDynamicsTest() {
		subscriber = new OverexcitationLimiterDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcitationLimiterDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcitationLimiterDynamics...");
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
	 * jumpstart the process by instantiating2 OverexcitationLimiterDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcitationLimiterDynamicsId = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance()
		.createOverexcitationLimiterDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance()
				.createOverexcitationLimiterDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcitationLimiterDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcitationLimiterDynamics : " + successValue.getOverexcitationLimiterDynamicsId());
							  if (successValue.getOverexcitationLimiterDynamicsId().equals(overexcitationLimiterDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcitationLimiterDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcitationLimiterDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcitationLimiterDynamics consumed")
					);
			subscriber.overexcitationLimiterDynamicsSubscribe( overexcitationLimiterDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcitationLimiterDynamics : " + successValue.getOverexcitationLimiterDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcitationLimiterDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcitationLimiterDynamics for overexcitationLimiterDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcitationLimiterDynamics. 
	 */
	protected OverexcitationLimiterDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcitationLimiterDynamics" );

		OverexcitationLimiterDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcitationLimiterDynamics with primary key" );
		msg.append( overexcitationLimiterDynamicsId );
		
		OverexcitationLimiterDynamicsFetchOneSummary fetchOneSummary = new OverexcitationLimiterDynamicsFetchOneSummary( overexcitationLimiterDynamicsId );

		try {
			entity = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().getOverexcitationLimiterDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcitationLimiterDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcitationLimiterDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcitationLimiterDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcitationLimiterDynamics : " );        
		OverexcitationLimiterDynamics entity = read();
		UpdateOverexcitationLimiterDynamicsCommand command = generateUpdateCommand();
		command.setOverexcitationLimiterDynamicsId(entity.getOverexcitationLimiterDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcitationLimiterDynamics." );

			// for use later on...
			overexcitationLimiterDynamicsId = entity.getOverexcitationLimiterDynamicsId();

			OverexcitationLimiterDynamicsBusinessDelegate proxy = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance();  

			proxy.updateOverexcitationLimiterDynamics( command ).get();

			LOGGER.info( "-- Successfully saved OverexcitationLimiterDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcitationLimiterDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcitationLimiterDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcitationLimiterDynamics." );

		OverexcitationLimiterDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcitationLimiterDynamics with id " + overexcitationLimiterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcitationLimiterDynamics with id " + overexcitationLimiterDynamicsId );

			throw e;
		}

		try{
			OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().delete( new DeleteOverexcitationLimiterDynamicsCommand( entity.getOverexcitationLimiterDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcitationLimiterDynamics with id " + overexcitationLimiterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcitationLimiterDynamics with id " + overexcitationLimiterDynamicsId );

			throw e;
		}
	}

	/**
	 * get all OverexcitationLimiterDynamicss.
	 */
	protected List<OverexcitationLimiterDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcitationLimiterDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcitationLimiterDynamics : " );        
		List<OverexcitationLimiterDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcitationLimiterDynamicsBusinessDelegate
			collection = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().getAllOverexcitationLimiterDynamics();
			assertNotNull( collection, "An Empty collection of OverexcitationLimiterDynamics was incorrectly returned.");
			
			// Now print out the values
			OverexcitationLimiterDynamics entity = null;            
			Iterator<OverexcitationLimiterDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcitationLimiterDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcitationLimiterDynamicsTest
	 */
	protected OverexcitationLimiterDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcitationLimiterDynamics
	 * 
	 * @return CreateOverexcitationLimiterDynamicsCommand alias
	 */
	protected CreateOverexcitationLimiterDynamicsCommand generateNewCommand() {
        CreateOverexcitationLimiterDynamicsCommand command = new CreateOverexcitationLimiterDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcitationLimiterDynamics
		 * 
		 * @return UpdateOverexcitationLimiterDynamicsCommand alias
		 */
	protected UpdateOverexcitationLimiterDynamicsCommand generateUpdateCommand() {
	        UpdateOverexcitationLimiterDynamicsCommand command = new UpdateOverexcitationLimiterDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcitationLimiterDynamicsId = null;
	protected OverexcitationLimiterDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcitationLimiterDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcitationLimiterDynamicsList = 0;
}
