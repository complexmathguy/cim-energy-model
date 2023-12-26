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
 * Test CapacitancePerLength class.
 *
 * @author your_name_here
 */
public class CapacitancePerLengthTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CapacitancePerLengthTest() {
		subscriber = new CapacitancePerLengthSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CapacitancePerLengthTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CapacitancePerLength...");
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
	 * jumpstart the process by instantiating2 CapacitancePerLength
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		capacitancePerLengthId = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
		.createCapacitancePerLength( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
				.createCapacitancePerLength( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.capacitancePerLengthSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CapacitancePerLength : " + successValue.getCapacitancePerLengthId());
							  if (successValue.getCapacitancePerLengthId().equals(capacitancePerLengthId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCapacitancePerLengthList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CapacitancePerLength test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on capacitancePerLength consumed")
					);
			subscriber.capacitancePerLengthSubscribe( capacitancePerLengthId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CapacitancePerLength : " + successValue.getCapacitancePerLengthId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCapacitancePerLengthList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on capacitancePerLength for capacitancePerLengthId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CapacitancePerLength. 
	 */
	protected CapacitancePerLength read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CapacitancePerLength" );

		CapacitancePerLength entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CapacitancePerLength with primary key" );
		msg.append( capacitancePerLengthId );
		
		CapacitancePerLengthFetchOneSummary fetchOneSummary = new CapacitancePerLengthFetchOneSummary( capacitancePerLengthId );

		try {
			entity = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().getCapacitancePerLength( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CapacitancePerLength " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CapacitancePerLength.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CapacitancePerLength." );

		StringBuilder msg = new StringBuilder( "Failed to update a CapacitancePerLength : " );        
		CapacitancePerLength entity = read();
		UpdateCapacitancePerLengthCommand command = generateUpdateCommand();
		command.setCapacitancePerLengthId(entity.getCapacitancePerLengthId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CapacitancePerLength." );

			// for use later on...
			capacitancePerLengthId = entity.getCapacitancePerLengthId();

			CapacitancePerLengthBusinessDelegate proxy = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance();  

			proxy.updateCapacitancePerLength( command ).get();

			LOGGER.info( "-- Successfully saved CapacitancePerLength - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + capacitancePerLengthId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CapacitancePerLength.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CapacitancePerLength." );

		CapacitancePerLength entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CapacitancePerLength with id " + capacitancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CapacitancePerLength with id " + capacitancePerLengthId );

			throw e;
		}

		try{
			CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().delete( new DeleteCapacitancePerLengthCommand( entity.getCapacitancePerLengthId() ) ).get();
			LOGGER.info( "-- Successfully deleted CapacitancePerLength with id " + capacitancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CapacitancePerLength with id " + capacitancePerLengthId );

			throw e;
		}
	}

	/**
	 * get all CapacitancePerLengths.
	 */
	protected List<CapacitancePerLength> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CapacitancePerLengths:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CapacitancePerLength : " );        
		List<CapacitancePerLength> collection  = new ArrayList<>();

		try {
			// call the static get method on the CapacitancePerLengthBusinessDelegate
			collection = CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance().getAllCapacitancePerLength();
			assertNotNull( collection, "An Empty collection of CapacitancePerLength was incorrectly returned.");
			
			// Now print out the values
			CapacitancePerLength entity = null;            
			Iterator<CapacitancePerLength> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCapacitancePerLengthId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CapacitancePerLengthTest
	 */
	protected CapacitancePerLengthTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CapacitancePerLength
	 * 
	 * @return CreateCapacitancePerLengthCommand alias
	 */
	protected CreateCapacitancePerLengthCommand generateNewCommand() {
        CreateCapacitancePerLengthCommand command = new CreateCapacitancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CapacitancePerLength
		 * 
		 * @return UpdateCapacitancePerLengthCommand alias
		 */
	protected UpdateCapacitancePerLengthCommand generateUpdateCommand() {
	        UpdateCapacitancePerLengthCommand command = new UpdateCapacitancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID capacitancePerLengthId = null;
	protected CapacitancePerLengthSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CapacitancePerLengthTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCapacitancePerLengthList = 0;
}
