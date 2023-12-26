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
 * Test SynchronousMachineDetailed class.
 *
 * @author your_name_here
 */
public class SynchronousMachineDetailedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineDetailedTest() {
		subscriber = new SynchronousMachineDetailedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineDetailedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineDetailed...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineDetailed
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineDetailedId = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
		.createSynchronousMachineDetailed( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
				.createSynchronousMachineDetailed( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineDetailedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineDetailed : " + successValue.getSynchronousMachineDetailedId());
							  if (successValue.getSynchronousMachineDetailedId().equals(synchronousMachineDetailedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineDetailedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineDetailed test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineDetailed consumed")
					);
			subscriber.synchronousMachineDetailedSubscribe( synchronousMachineDetailedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineDetailed : " + successValue.getSynchronousMachineDetailedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineDetailedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineDetailed for synchronousMachineDetailedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineDetailed. 
	 */
	protected SynchronousMachineDetailed read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineDetailed" );

		SynchronousMachineDetailed entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineDetailed with primary key" );
		msg.append( synchronousMachineDetailedId );
		
		SynchronousMachineDetailedFetchOneSummary fetchOneSummary = new SynchronousMachineDetailedFetchOneSummary( synchronousMachineDetailedId );

		try {
			entity = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().getSynchronousMachineDetailed( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineDetailed " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineDetailed.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineDetailed." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineDetailed : " );        
		SynchronousMachineDetailed entity = read();
		UpdateSynchronousMachineDetailedCommand command = generateUpdateCommand();
		command.setSynchronousMachineDetailedId(entity.getSynchronousMachineDetailedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineDetailed." );

			// for use later on...
			synchronousMachineDetailedId = entity.getSynchronousMachineDetailedId();

			SynchronousMachineDetailedBusinessDelegate proxy = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();  

			proxy.updateSynchronousMachineDetailed( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineDetailed - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineDetailedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineDetailed.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineDetailed." );

		SynchronousMachineDetailed entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineDetailed with id " + synchronousMachineDetailedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineDetailed with id " + synchronousMachineDetailedId );

			throw e;
		}

		try{
			SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().delete( new DeleteSynchronousMachineDetailedCommand( entity.getSynchronousMachineDetailedId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineDetailed with id " + synchronousMachineDetailedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineDetailed with id " + synchronousMachineDetailedId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineDetaileds.
	 */
	protected List<SynchronousMachineDetailed> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineDetaileds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineDetailed : " );        
		List<SynchronousMachineDetailed> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineDetailedBusinessDelegate
			collection = SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance().getAllSynchronousMachineDetailed();
			assertNotNull( collection, "An Empty collection of SynchronousMachineDetailed was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineDetailed entity = null;            
			Iterator<SynchronousMachineDetailed> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineDetailedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineDetailedTest
	 */
	protected SynchronousMachineDetailedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineDetailed
	 * 
	 * @return CreateSynchronousMachineDetailedCommand alias
	 */
	protected CreateSynchronousMachineDetailedCommand generateNewCommand() {
        CreateSynchronousMachineDetailedCommand command = new CreateSynchronousMachineDetailedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineDetailed
		 * 
		 * @return UpdateSynchronousMachineDetailedCommand alias
		 */
	protected UpdateSynchronousMachineDetailedCommand generateUpdateCommand() {
	        UpdateSynchronousMachineDetailedCommand command = new UpdateSynchronousMachineDetailedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineDetailedId = null;
	protected SynchronousMachineDetailedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineDetailedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineDetailedList = 0;
}
