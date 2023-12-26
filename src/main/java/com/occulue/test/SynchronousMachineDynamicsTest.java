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
 * Test SynchronousMachineDynamics class.
 *
 * @author your_name_here
 */
public class SynchronousMachineDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineDynamicsTest() {
		subscriber = new SynchronousMachineDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineDynamics...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineDynamicsId = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance()
		.createSynchronousMachineDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance()
				.createSynchronousMachineDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineDynamics : " + successValue.getSynchronousMachineDynamicsId());
							  if (successValue.getSynchronousMachineDynamicsId().equals(synchronousMachineDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineDynamics consumed")
					);
			subscriber.synchronousMachineDynamicsSubscribe( synchronousMachineDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineDynamics : " + successValue.getSynchronousMachineDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineDynamics for synchronousMachineDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineDynamics. 
	 */
	protected SynchronousMachineDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineDynamics" );

		SynchronousMachineDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineDynamics with primary key" );
		msg.append( synchronousMachineDynamicsId );
		
		SynchronousMachineDynamicsFetchOneSummary fetchOneSummary = new SynchronousMachineDynamicsFetchOneSummary( synchronousMachineDynamicsId );

		try {
			entity = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().getSynchronousMachineDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineDynamics : " );        
		SynchronousMachineDynamics entity = read();
		UpdateSynchronousMachineDynamicsCommand command = generateUpdateCommand();
		command.setSynchronousMachineDynamicsId(entity.getSynchronousMachineDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineDynamics." );

			// for use later on...
			synchronousMachineDynamicsId = entity.getSynchronousMachineDynamicsId();

			SynchronousMachineDynamicsBusinessDelegate proxy = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance();  

			proxy.updateSynchronousMachineDynamics( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineDynamics." );

		SynchronousMachineDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineDynamics with id " + synchronousMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineDynamics with id " + synchronousMachineDynamicsId );

			throw e;
		}

		try{
			SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().delete( new DeleteSynchronousMachineDynamicsCommand( entity.getSynchronousMachineDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineDynamics with id " + synchronousMachineDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineDynamics with id " + synchronousMachineDynamicsId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineDynamicss.
	 */
	protected List<SynchronousMachineDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineDynamics : " );        
		List<SynchronousMachineDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineDynamicsBusinessDelegate
			collection = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().getAllSynchronousMachineDynamics();
			assertNotNull( collection, "An Empty collection of SynchronousMachineDynamics was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineDynamics entity = null;            
			Iterator<SynchronousMachineDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineDynamicsTest
	 */
	protected SynchronousMachineDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineDynamics
	 * 
	 * @return CreateSynchronousMachineDynamicsCommand alias
	 */
	protected CreateSynchronousMachineDynamicsCommand generateNewCommand() {
        CreateSynchronousMachineDynamicsCommand command = new CreateSynchronousMachineDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineDynamics
		 * 
		 * @return UpdateSynchronousMachineDynamicsCommand alias
		 */
	protected UpdateSynchronousMachineDynamicsCommand generateUpdateCommand() {
	        UpdateSynchronousMachineDynamicsCommand command = new UpdateSynchronousMachineDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineDynamicsId = null;
	protected SynchronousMachineDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineDynamicsList = 0;
}
