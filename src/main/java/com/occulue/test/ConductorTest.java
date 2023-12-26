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
 * Test Conductor class.
 *
 * @author your_name_here
 */
public class ConductorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConductorTest() {
		subscriber = new ConductorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConductorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Conductor...");
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
	 * jumpstart the process by instantiating2 Conductor
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conductorId = ConductorBusinessDelegate.getConductorInstance()
		.createConductor( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConductorBusinessDelegate.getConductorInstance()
				.createConductor( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conductorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Conductor : " + successValue.getConductorId());
							  if (successValue.getConductorId().equals(conductorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConductorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Conductor test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductor consumed")
					);
			subscriber.conductorSubscribe( conductorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Conductor : " + successValue.getConductorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConductorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductor for conductorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Conductor. 
	 */
	protected Conductor read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Conductor" );

		Conductor entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Conductor with primary key" );
		msg.append( conductorId );
		
		ConductorFetchOneSummary fetchOneSummary = new ConductorFetchOneSummary( conductorId );

		try {
			entity = ConductorBusinessDelegate.getConductorInstance().getConductor( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Conductor " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Conductor.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Conductor." );

		StringBuilder msg = new StringBuilder( "Failed to update a Conductor : " );        
		Conductor entity = read();
		UpdateConductorCommand command = generateUpdateCommand();
		command.setConductorId(entity.getConductorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Conductor." );

			// for use later on...
			conductorId = entity.getConductorId();

			ConductorBusinessDelegate proxy = ConductorBusinessDelegate.getConductorInstance();  

			proxy.updateConductor( command ).get();

			LOGGER.info( "-- Successfully saved Conductor - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conductorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Conductor.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Conductor." );

		Conductor entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Conductor with id " + conductorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Conductor with id " + conductorId );

			throw e;
		}

		try{
			ConductorBusinessDelegate.getConductorInstance().delete( new DeleteConductorCommand( entity.getConductorId() ) ).get();
			LOGGER.info( "-- Successfully deleted Conductor with id " + conductorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Conductor with id " + conductorId );

			throw e;
		}
	}

	/**
	 * get all Conductors.
	 */
	protected List<Conductor> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Conductors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Conductor : " );        
		List<Conductor> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConductorBusinessDelegate
			collection = ConductorBusinessDelegate.getConductorInstance().getAllConductor();
			assertNotNull( collection, "An Empty collection of Conductor was incorrectly returned.");
			
			// Now print out the values
			Conductor entity = null;            
			Iterator<Conductor> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConductorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConductorTest
	 */
	protected ConductorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Conductor
	 * 
	 * @return CreateConductorCommand alias
	 */
	protected CreateConductorCommand generateNewCommand() {
        CreateConductorCommand command = new CreateConductorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Conductor
		 * 
		 * @return UpdateConductorCommand alias
		 */
	protected UpdateConductorCommand generateUpdateCommand() {
	        UpdateConductorCommand command = new UpdateConductorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conductorId = null;
	protected ConductorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConductorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConductorList = 0;
}
