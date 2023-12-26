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
 * Test Susceptance class.
 *
 * @author your_name_here
 */
public class SusceptanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SusceptanceTest() {
		subscriber = new SusceptanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SusceptanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Susceptance...");
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
	 * jumpstart the process by instantiating2 Susceptance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		susceptanceId = SusceptanceBusinessDelegate.getSusceptanceInstance()
		.createSusceptance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SusceptanceBusinessDelegate.getSusceptanceInstance()
				.createSusceptance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.susceptanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Susceptance : " + successValue.getSusceptanceId());
							  if (successValue.getSusceptanceId().equals(susceptanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSusceptanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Susceptance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on susceptance consumed")
					);
			subscriber.susceptanceSubscribe( susceptanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Susceptance : " + successValue.getSusceptanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSusceptanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on susceptance for susceptanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Susceptance. 
	 */
	protected Susceptance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Susceptance" );

		Susceptance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Susceptance with primary key" );
		msg.append( susceptanceId );
		
		SusceptanceFetchOneSummary fetchOneSummary = new SusceptanceFetchOneSummary( susceptanceId );

		try {
			entity = SusceptanceBusinessDelegate.getSusceptanceInstance().getSusceptance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Susceptance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Susceptance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Susceptance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Susceptance : " );        
		Susceptance entity = read();
		UpdateSusceptanceCommand command = generateUpdateCommand();
		command.setSusceptanceId(entity.getSusceptanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Susceptance." );

			// for use later on...
			susceptanceId = entity.getSusceptanceId();

			SusceptanceBusinessDelegate proxy = SusceptanceBusinessDelegate.getSusceptanceInstance();  

			proxy.updateSusceptance( command ).get();

			LOGGER.info( "-- Successfully saved Susceptance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + susceptanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Susceptance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Susceptance." );

		Susceptance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Susceptance with id " + susceptanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Susceptance with id " + susceptanceId );

			throw e;
		}

		try{
			SusceptanceBusinessDelegate.getSusceptanceInstance().delete( new DeleteSusceptanceCommand( entity.getSusceptanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Susceptance with id " + susceptanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Susceptance with id " + susceptanceId );

			throw e;
		}
	}

	/**
	 * get all Susceptances.
	 */
	protected List<Susceptance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Susceptances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Susceptance : " );        
		List<Susceptance> collection  = new ArrayList<>();

		try {
			// call the static get method on the SusceptanceBusinessDelegate
			collection = SusceptanceBusinessDelegate.getSusceptanceInstance().getAllSusceptance();
			assertNotNull( collection, "An Empty collection of Susceptance was incorrectly returned.");
			
			// Now print out the values
			Susceptance entity = null;            
			Iterator<Susceptance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSusceptanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SusceptanceTest
	 */
	protected SusceptanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Susceptance
	 * 
	 * @return CreateSusceptanceCommand alias
	 */
	protected CreateSusceptanceCommand generateNewCommand() {
        CreateSusceptanceCommand command = new CreateSusceptanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Susceptance
		 * 
		 * @return UpdateSusceptanceCommand alias
		 */
	protected UpdateSusceptanceCommand generateUpdateCommand() {
	        UpdateSusceptanceCommand command = new UpdateSusceptanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID susceptanceId = null;
	protected SusceptanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SusceptanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSusceptanceList = 0;
}
