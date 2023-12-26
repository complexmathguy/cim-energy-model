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
 * Test GeneratingUnit class.
 *
 * @author your_name_here
 */
public class GeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GeneratingUnitTest() {
		subscriber = new GeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GeneratingUnit...");
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
	 * jumpstart the process by instantiating2 GeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		generatingUnitId = GeneratingUnitBusinessDelegate.getGeneratingUnitInstance()
		.createGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GeneratingUnitBusinessDelegate.getGeneratingUnitInstance()
				.createGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.generatingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GeneratingUnit : " + successValue.getGeneratingUnitId());
							  if (successValue.getGeneratingUnitId().equals(generatingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on generatingUnit consumed")
					);
			subscriber.generatingUnitSubscribe( generatingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GeneratingUnit : " + successValue.getGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on generatingUnit for generatingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GeneratingUnit. 
	 */
	protected GeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GeneratingUnit" );

		GeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GeneratingUnit with primary key" );
		msg.append( generatingUnitId );
		
		GeneratingUnitFetchOneSummary fetchOneSummary = new GeneratingUnitFetchOneSummary( generatingUnitId );

		try {
			entity = GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().getGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a GeneratingUnit : " );        
		GeneratingUnit entity = read();
		UpdateGeneratingUnitCommand command = generateUpdateCommand();
		command.setGeneratingUnitId(entity.getGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GeneratingUnit." );

			// for use later on...
			generatingUnitId = entity.getGeneratingUnitId();

			GeneratingUnitBusinessDelegate proxy = GeneratingUnitBusinessDelegate.getGeneratingUnitInstance();  

			proxy.updateGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved GeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + generatingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GeneratingUnit." );

		GeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GeneratingUnit with id " + generatingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GeneratingUnit with id " + generatingUnitId );

			throw e;
		}

		try{
			GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().delete( new DeleteGeneratingUnitCommand( entity.getGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted GeneratingUnit with id " + generatingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GeneratingUnit with id " + generatingUnitId );

			throw e;
		}
	}

	/**
	 * get all GeneratingUnits.
	 */
	protected List<GeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GeneratingUnit : " );        
		List<GeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the GeneratingUnitBusinessDelegate
			collection = GeneratingUnitBusinessDelegate.getGeneratingUnitInstance().getAllGeneratingUnit();
			assertNotNull( collection, "An Empty collection of GeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			GeneratingUnit entity = null;            
			Iterator<GeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GeneratingUnitTest
	 */
	protected GeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GeneratingUnit
	 * 
	 * @return CreateGeneratingUnitCommand alias
	 */
	protected CreateGeneratingUnitCommand generateNewCommand() {
        CreateGeneratingUnitCommand command = new CreateGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GeneratingUnit
		 * 
		 * @return UpdateGeneratingUnitCommand alias
		 */
	protected UpdateGeneratingUnitCommand generateUpdateCommand() {
	        UpdateGeneratingUnitCommand command = new UpdateGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID generatingUnitId = null;
	protected GeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGeneratingUnitList = 0;
}
