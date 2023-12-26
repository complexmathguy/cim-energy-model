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
 * Test Capacitance class.
 *
 * @author your_name_here
 */
public class CapacitanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CapacitanceTest() {
		subscriber = new CapacitanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CapacitanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Capacitance...");
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
	 * jumpstart the process by instantiating2 Capacitance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		capacitanceId = CapacitanceBusinessDelegate.getCapacitanceInstance()
		.createCapacitance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CapacitanceBusinessDelegate.getCapacitanceInstance()
				.createCapacitance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.capacitanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Capacitance : " + successValue.getCapacitanceId());
							  if (successValue.getCapacitanceId().equals(capacitanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCapacitanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Capacitance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on capacitance consumed")
					);
			subscriber.capacitanceSubscribe( capacitanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Capacitance : " + successValue.getCapacitanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCapacitanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on capacitance for capacitanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Capacitance. 
	 */
	protected Capacitance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Capacitance" );

		Capacitance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Capacitance with primary key" );
		msg.append( capacitanceId );
		
		CapacitanceFetchOneSummary fetchOneSummary = new CapacitanceFetchOneSummary( capacitanceId );

		try {
			entity = CapacitanceBusinessDelegate.getCapacitanceInstance().getCapacitance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Capacitance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Capacitance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Capacitance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Capacitance : " );        
		Capacitance entity = read();
		UpdateCapacitanceCommand command = generateUpdateCommand();
		command.setCapacitanceId(entity.getCapacitanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Capacitance." );

			// for use later on...
			capacitanceId = entity.getCapacitanceId();

			CapacitanceBusinessDelegate proxy = CapacitanceBusinessDelegate.getCapacitanceInstance();  

			proxy.updateCapacitance( command ).get();

			LOGGER.info( "-- Successfully saved Capacitance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + capacitanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Capacitance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Capacitance." );

		Capacitance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Capacitance with id " + capacitanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Capacitance with id " + capacitanceId );

			throw e;
		}

		try{
			CapacitanceBusinessDelegate.getCapacitanceInstance().delete( new DeleteCapacitanceCommand( entity.getCapacitanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Capacitance with id " + capacitanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Capacitance with id " + capacitanceId );

			throw e;
		}
	}

	/**
	 * get all Capacitances.
	 */
	protected List<Capacitance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Capacitances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Capacitance : " );        
		List<Capacitance> collection  = new ArrayList<>();

		try {
			// call the static get method on the CapacitanceBusinessDelegate
			collection = CapacitanceBusinessDelegate.getCapacitanceInstance().getAllCapacitance();
			assertNotNull( collection, "An Empty collection of Capacitance was incorrectly returned.");
			
			// Now print out the values
			Capacitance entity = null;            
			Iterator<Capacitance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCapacitanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CapacitanceTest
	 */
	protected CapacitanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Capacitance
	 * 
	 * @return CreateCapacitanceCommand alias
	 */
	protected CreateCapacitanceCommand generateNewCommand() {
        CreateCapacitanceCommand command = new CreateCapacitanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Capacitance
		 * 
		 * @return UpdateCapacitanceCommand alias
		 */
	protected UpdateCapacitanceCommand generateUpdateCommand() {
	        UpdateCapacitanceCommand command = new UpdateCapacitanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID capacitanceId = null;
	protected CapacitanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CapacitanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCapacitanceList = 0;
}
