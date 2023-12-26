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
 * Test ExcitationSystemDynamics class.
 *
 * @author your_name_here
 */
public class ExcitationSystemDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcitationSystemDynamicsTest() {
		subscriber = new ExcitationSystemDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcitationSystemDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcitationSystemDynamics...");
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
	 * jumpstart the process by instantiating2 ExcitationSystemDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excitationSystemDynamicsId = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
		.createExcitationSystemDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
				.createExcitationSystemDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excitationSystemDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcitationSystemDynamics : " + successValue.getExcitationSystemDynamicsId());
							  if (successValue.getExcitationSystemDynamicsId().equals(excitationSystemDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcitationSystemDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcitationSystemDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excitationSystemDynamics consumed")
					);
			subscriber.excitationSystemDynamicsSubscribe( excitationSystemDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcitationSystemDynamics : " + successValue.getExcitationSystemDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcitationSystemDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excitationSystemDynamics for excitationSystemDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcitationSystemDynamics. 
	 */
	protected ExcitationSystemDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcitationSystemDynamics" );

		ExcitationSystemDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcitationSystemDynamics with primary key" );
		msg.append( excitationSystemDynamicsId );
		
		ExcitationSystemDynamicsFetchOneSummary fetchOneSummary = new ExcitationSystemDynamicsFetchOneSummary( excitationSystemDynamicsId );

		try {
			entity = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().getExcitationSystemDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcitationSystemDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcitationSystemDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcitationSystemDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcitationSystemDynamics : " );        
		ExcitationSystemDynamics entity = read();
		UpdateExcitationSystemDynamicsCommand command = generateUpdateCommand();
		command.setExcitationSystemDynamicsId(entity.getExcitationSystemDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcitationSystemDynamics." );

			// for use later on...
			excitationSystemDynamicsId = entity.getExcitationSystemDynamicsId();

			ExcitationSystemDynamicsBusinessDelegate proxy = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance();  

			proxy.updateExcitationSystemDynamics( command ).get();

			LOGGER.info( "-- Successfully saved ExcitationSystemDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excitationSystemDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcitationSystemDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcitationSystemDynamics." );

		ExcitationSystemDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcitationSystemDynamics with id " + excitationSystemDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcitationSystemDynamics with id " + excitationSystemDynamicsId );

			throw e;
		}

		try{
			ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().delete( new DeleteExcitationSystemDynamicsCommand( entity.getExcitationSystemDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcitationSystemDynamics with id " + excitationSystemDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcitationSystemDynamics with id " + excitationSystemDynamicsId );

			throw e;
		}
	}

	/**
	 * get all ExcitationSystemDynamicss.
	 */
	protected List<ExcitationSystemDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcitationSystemDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcitationSystemDynamics : " );        
		List<ExcitationSystemDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcitationSystemDynamicsBusinessDelegate
			collection = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().getAllExcitationSystemDynamics();
			assertNotNull( collection, "An Empty collection of ExcitationSystemDynamics was incorrectly returned.");
			
			// Now print out the values
			ExcitationSystemDynamics entity = null;            
			Iterator<ExcitationSystemDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcitationSystemDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcitationSystemDynamicsTest
	 */
	protected ExcitationSystemDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcitationSystemDynamics
	 * 
	 * @return CreateExcitationSystemDynamicsCommand alias
	 */
	protected CreateExcitationSystemDynamicsCommand generateNewCommand() {
        CreateExcitationSystemDynamicsCommand command = new CreateExcitationSystemDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcitationSystemDynamics
		 * 
		 * @return UpdateExcitationSystemDynamicsCommand alias
		 */
	protected UpdateExcitationSystemDynamicsCommand generateUpdateCommand() {
	        UpdateExcitationSystemDynamicsCommand command = new UpdateExcitationSystemDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excitationSystemDynamicsId = null;
	protected ExcitationSystemDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcitationSystemDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcitationSystemDynamicsList = 0;
}
