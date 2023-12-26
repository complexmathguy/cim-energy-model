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
 * Test Frequency class.
 *
 * @author your_name_here
 */
public class FrequencyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public FrequencyTest() {
		subscriber = new FrequencySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate FrequencyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Frequency...");
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
	 * jumpstart the process by instantiating2 Frequency
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		frequencyId = FrequencyBusinessDelegate.getFrequencyInstance()
		.createFrequency( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		FrequencyBusinessDelegate.getFrequencyInstance()
				.createFrequency( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.frequencySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Frequency : " + successValue.getFrequencyId());
							  if (successValue.getFrequencyId().equals(frequencyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfFrequencyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Frequency test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on frequency consumed")
					);
			subscriber.frequencySubscribe( frequencyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Frequency : " + successValue.getFrequencyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfFrequencyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on frequency for frequencyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Frequency. 
	 */
	protected Frequency read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Frequency" );

		Frequency entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Frequency with primary key" );
		msg.append( frequencyId );
		
		FrequencyFetchOneSummary fetchOneSummary = new FrequencyFetchOneSummary( frequencyId );

		try {
			entity = FrequencyBusinessDelegate.getFrequencyInstance().getFrequency( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Frequency " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Frequency.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Frequency." );

		StringBuilder msg = new StringBuilder( "Failed to update a Frequency : " );        
		Frequency entity = read();
		UpdateFrequencyCommand command = generateUpdateCommand();
		command.setFrequencyId(entity.getFrequencyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Frequency." );

			// for use later on...
			frequencyId = entity.getFrequencyId();

			FrequencyBusinessDelegate proxy = FrequencyBusinessDelegate.getFrequencyInstance();  

			proxy.updateFrequency( command ).get();

			LOGGER.info( "-- Successfully saved Frequency - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + frequencyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Frequency.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Frequency." );

		Frequency entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Frequency with id " + frequencyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Frequency with id " + frequencyId );

			throw e;
		}

		try{
			FrequencyBusinessDelegate.getFrequencyInstance().delete( new DeleteFrequencyCommand( entity.getFrequencyId() ) ).get();
			LOGGER.info( "-- Successfully deleted Frequency with id " + frequencyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Frequency with id " + frequencyId );

			throw e;
		}
	}

	/**
	 * get all Frequencys.
	 */
	protected List<Frequency> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Frequencys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Frequency : " );        
		List<Frequency> collection  = new ArrayList<>();

		try {
			// call the static get method on the FrequencyBusinessDelegate
			collection = FrequencyBusinessDelegate.getFrequencyInstance().getAllFrequency();
			assertNotNull( collection, "An Empty collection of Frequency was incorrectly returned.");
			
			// Now print out the values
			Frequency entity = null;            
			Iterator<Frequency> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getFrequencyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		FrequencyTest
	 */
	protected FrequencyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Frequency
	 * 
	 * @return CreateFrequencyCommand alias
	 */
	protected CreateFrequencyCommand generateNewCommand() {
        CreateFrequencyCommand command = new CreateFrequencyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Frequency
		 * 
		 * @return UpdateFrequencyCommand alias
		 */
	protected UpdateFrequencyCommand generateUpdateCommand() {
	        UpdateFrequencyCommand command = new UpdateFrequencyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID frequencyId = null;
	protected FrequencySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(FrequencyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfFrequencyList = 0;
}
