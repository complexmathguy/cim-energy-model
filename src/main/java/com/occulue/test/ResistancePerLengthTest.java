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
 * Test ResistancePerLength class.
 *
 * @author your_name_here
 */
public class ResistancePerLengthTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ResistancePerLengthTest() {
		subscriber = new ResistancePerLengthSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ResistancePerLengthTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ResistancePerLength...");
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
	 * jumpstart the process by instantiating2 ResistancePerLength
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		resistancePerLengthId = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance()
		.createResistancePerLength( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance()
				.createResistancePerLength( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.resistancePerLengthSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ResistancePerLength : " + successValue.getResistancePerLengthId());
							  if (successValue.getResistancePerLengthId().equals(resistancePerLengthId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfResistancePerLengthList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ResistancePerLength test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on resistancePerLength consumed")
					);
			subscriber.resistancePerLengthSubscribe( resistancePerLengthId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ResistancePerLength : " + successValue.getResistancePerLengthId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfResistancePerLengthList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on resistancePerLength for resistancePerLengthId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ResistancePerLength. 
	 */
	protected ResistancePerLength read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ResistancePerLength" );

		ResistancePerLength entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ResistancePerLength with primary key" );
		msg.append( resistancePerLengthId );
		
		ResistancePerLengthFetchOneSummary fetchOneSummary = new ResistancePerLengthFetchOneSummary( resistancePerLengthId );

		try {
			entity = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().getResistancePerLength( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ResistancePerLength " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ResistancePerLength.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ResistancePerLength." );

		StringBuilder msg = new StringBuilder( "Failed to update a ResistancePerLength : " );        
		ResistancePerLength entity = read();
		UpdateResistancePerLengthCommand command = generateUpdateCommand();
		command.setResistancePerLengthId(entity.getResistancePerLengthId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ResistancePerLength." );

			// for use later on...
			resistancePerLengthId = entity.getResistancePerLengthId();

			ResistancePerLengthBusinessDelegate proxy = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance();  

			proxy.updateResistancePerLength( command ).get();

			LOGGER.info( "-- Successfully saved ResistancePerLength - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + resistancePerLengthId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ResistancePerLength.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ResistancePerLength." );

		ResistancePerLength entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ResistancePerLength with id " + resistancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ResistancePerLength with id " + resistancePerLengthId );

			throw e;
		}

		try{
			ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().delete( new DeleteResistancePerLengthCommand( entity.getResistancePerLengthId() ) ).get();
			LOGGER.info( "-- Successfully deleted ResistancePerLength with id " + resistancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ResistancePerLength with id " + resistancePerLengthId );

			throw e;
		}
	}

	/**
	 * get all ResistancePerLengths.
	 */
	protected List<ResistancePerLength> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ResistancePerLengths:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ResistancePerLength : " );        
		List<ResistancePerLength> collection  = new ArrayList<>();

		try {
			// call the static get method on the ResistancePerLengthBusinessDelegate
			collection = ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance().getAllResistancePerLength();
			assertNotNull( collection, "An Empty collection of ResistancePerLength was incorrectly returned.");
			
			// Now print out the values
			ResistancePerLength entity = null;            
			Iterator<ResistancePerLength> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getResistancePerLengthId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ResistancePerLengthTest
	 */
	protected ResistancePerLengthTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ResistancePerLength
	 * 
	 * @return CreateResistancePerLengthCommand alias
	 */
	protected CreateResistancePerLengthCommand generateNewCommand() {
        CreateResistancePerLengthCommand command = new CreateResistancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ResistancePerLength
		 * 
		 * @return UpdateResistancePerLengthCommand alias
		 */
	protected UpdateResistancePerLengthCommand generateUpdateCommand() {
	        UpdateResistancePerLengthCommand command = new UpdateResistancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID resistancePerLengthId = null;
	protected ResistancePerLengthSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ResistancePerLengthTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfResistancePerLengthList = 0;
}
