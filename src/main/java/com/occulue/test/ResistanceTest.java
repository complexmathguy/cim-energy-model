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
 * Test Resistance class.
 *
 * @author your_name_here
 */
public class ResistanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ResistanceTest() {
		subscriber = new ResistanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ResistanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Resistance...");
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
	 * jumpstart the process by instantiating2 Resistance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		resistanceId = ResistanceBusinessDelegate.getResistanceInstance()
		.createResistance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ResistanceBusinessDelegate.getResistanceInstance()
				.createResistance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.resistanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Resistance : " + successValue.getResistanceId());
							  if (successValue.getResistanceId().equals(resistanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfResistanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Resistance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on resistance consumed")
					);
			subscriber.resistanceSubscribe( resistanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Resistance : " + successValue.getResistanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfResistanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on resistance for resistanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Resistance. 
	 */
	protected Resistance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Resistance" );

		Resistance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Resistance with primary key" );
		msg.append( resistanceId );
		
		ResistanceFetchOneSummary fetchOneSummary = new ResistanceFetchOneSummary( resistanceId );

		try {
			entity = ResistanceBusinessDelegate.getResistanceInstance().getResistance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Resistance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Resistance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Resistance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Resistance : " );        
		Resistance entity = read();
		UpdateResistanceCommand command = generateUpdateCommand();
		command.setResistanceId(entity.getResistanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Resistance." );

			// for use later on...
			resistanceId = entity.getResistanceId();

			ResistanceBusinessDelegate proxy = ResistanceBusinessDelegate.getResistanceInstance();  

			proxy.updateResistance( command ).get();

			LOGGER.info( "-- Successfully saved Resistance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + resistanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Resistance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Resistance." );

		Resistance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Resistance with id " + resistanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Resistance with id " + resistanceId );

			throw e;
		}

		try{
			ResistanceBusinessDelegate.getResistanceInstance().delete( new DeleteResistanceCommand( entity.getResistanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Resistance with id " + resistanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Resistance with id " + resistanceId );

			throw e;
		}
	}

	/**
	 * get all Resistances.
	 */
	protected List<Resistance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Resistances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Resistance : " );        
		List<Resistance> collection  = new ArrayList<>();

		try {
			// call the static get method on the ResistanceBusinessDelegate
			collection = ResistanceBusinessDelegate.getResistanceInstance().getAllResistance();
			assertNotNull( collection, "An Empty collection of Resistance was incorrectly returned.");
			
			// Now print out the values
			Resistance entity = null;            
			Iterator<Resistance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getResistanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ResistanceTest
	 */
	protected ResistanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Resistance
	 * 
	 * @return CreateResistanceCommand alias
	 */
	protected CreateResistanceCommand generateNewCommand() {
        CreateResistanceCommand command = new CreateResistanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Resistance
		 * 
		 * @return UpdateResistanceCommand alias
		 */
	protected UpdateResistanceCommand generateUpdateCommand() {
	        UpdateResistanceCommand command = new UpdateResistanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID resistanceId = null;
	protected ResistanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ResistanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfResistanceList = 0;
}
