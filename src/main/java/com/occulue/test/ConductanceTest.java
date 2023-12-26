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
 * Test Conductance class.
 *
 * @author your_name_here
 */
public class ConductanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConductanceTest() {
		subscriber = new ConductanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConductanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Conductance...");
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
	 * jumpstart the process by instantiating2 Conductance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conductanceId = ConductanceBusinessDelegate.getConductanceInstance()
		.createConductance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConductanceBusinessDelegate.getConductanceInstance()
				.createConductance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conductanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Conductance : " + successValue.getConductanceId());
							  if (successValue.getConductanceId().equals(conductanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConductanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Conductance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductance consumed")
					);
			subscriber.conductanceSubscribe( conductanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Conductance : " + successValue.getConductanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConductanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductance for conductanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Conductance. 
	 */
	protected Conductance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Conductance" );

		Conductance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Conductance with primary key" );
		msg.append( conductanceId );
		
		ConductanceFetchOneSummary fetchOneSummary = new ConductanceFetchOneSummary( conductanceId );

		try {
			entity = ConductanceBusinessDelegate.getConductanceInstance().getConductance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Conductance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Conductance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Conductance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Conductance : " );        
		Conductance entity = read();
		UpdateConductanceCommand command = generateUpdateCommand();
		command.setConductanceId(entity.getConductanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Conductance." );

			// for use later on...
			conductanceId = entity.getConductanceId();

			ConductanceBusinessDelegate proxy = ConductanceBusinessDelegate.getConductanceInstance();  

			proxy.updateConductance( command ).get();

			LOGGER.info( "-- Successfully saved Conductance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conductanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Conductance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Conductance." );

		Conductance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Conductance with id " + conductanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Conductance with id " + conductanceId );

			throw e;
		}

		try{
			ConductanceBusinessDelegate.getConductanceInstance().delete( new DeleteConductanceCommand( entity.getConductanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Conductance with id " + conductanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Conductance with id " + conductanceId );

			throw e;
		}
	}

	/**
	 * get all Conductances.
	 */
	protected List<Conductance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Conductances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Conductance : " );        
		List<Conductance> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConductanceBusinessDelegate
			collection = ConductanceBusinessDelegate.getConductanceInstance().getAllConductance();
			assertNotNull( collection, "An Empty collection of Conductance was incorrectly returned.");
			
			// Now print out the values
			Conductance entity = null;            
			Iterator<Conductance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConductanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConductanceTest
	 */
	protected ConductanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Conductance
	 * 
	 * @return CreateConductanceCommand alias
	 */
	protected CreateConductanceCommand generateNewCommand() {
        CreateConductanceCommand command = new CreateConductanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Conductance
		 * 
		 * @return UpdateConductanceCommand alias
		 */
	protected UpdateConductanceCommand generateUpdateCommand() {
	        UpdateConductanceCommand command = new UpdateConductanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conductanceId = null;
	protected ConductanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConductanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConductanceList = 0;
}
