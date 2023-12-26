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
 * Test LinearShuntCompensator class.
 *
 * @author your_name_here
 */
public class LinearShuntCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LinearShuntCompensatorTest() {
		subscriber = new LinearShuntCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LinearShuntCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LinearShuntCompensator...");
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
	 * jumpstart the process by instantiating2 LinearShuntCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		linearShuntCompensatorId = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
		.createLinearShuntCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
				.createLinearShuntCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.linearShuntCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LinearShuntCompensator : " + successValue.getLinearShuntCompensatorId());
							  if (successValue.getLinearShuntCompensatorId().equals(linearShuntCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLinearShuntCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LinearShuntCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on linearShuntCompensator consumed")
					);
			subscriber.linearShuntCompensatorSubscribe( linearShuntCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LinearShuntCompensator : " + successValue.getLinearShuntCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLinearShuntCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on linearShuntCompensator for linearShuntCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LinearShuntCompensator. 
	 */
	protected LinearShuntCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LinearShuntCompensator" );

		LinearShuntCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LinearShuntCompensator with primary key" );
		msg.append( linearShuntCompensatorId );
		
		LinearShuntCompensatorFetchOneSummary fetchOneSummary = new LinearShuntCompensatorFetchOneSummary( linearShuntCompensatorId );

		try {
			entity = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().getLinearShuntCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LinearShuntCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LinearShuntCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LinearShuntCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a LinearShuntCompensator : " );        
		LinearShuntCompensator entity = read();
		UpdateLinearShuntCompensatorCommand command = generateUpdateCommand();
		command.setLinearShuntCompensatorId(entity.getLinearShuntCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LinearShuntCompensator." );

			// for use later on...
			linearShuntCompensatorId = entity.getLinearShuntCompensatorId();

			LinearShuntCompensatorBusinessDelegate proxy = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();  

			proxy.updateLinearShuntCompensator( command ).get();

			LOGGER.info( "-- Successfully saved LinearShuntCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + linearShuntCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LinearShuntCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LinearShuntCompensator." );

		LinearShuntCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LinearShuntCompensator with id " + linearShuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LinearShuntCompensator with id " + linearShuntCompensatorId );

			throw e;
		}

		try{
			LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().delete( new DeleteLinearShuntCompensatorCommand( entity.getLinearShuntCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted LinearShuntCompensator with id " + linearShuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LinearShuntCompensator with id " + linearShuntCompensatorId );

			throw e;
		}
	}

	/**
	 * get all LinearShuntCompensators.
	 */
	protected List<LinearShuntCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LinearShuntCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LinearShuntCompensator : " );        
		List<LinearShuntCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the LinearShuntCompensatorBusinessDelegate
			collection = LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance().getAllLinearShuntCompensator();
			assertNotNull( collection, "An Empty collection of LinearShuntCompensator was incorrectly returned.");
			
			// Now print out the values
			LinearShuntCompensator entity = null;            
			Iterator<LinearShuntCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLinearShuntCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LinearShuntCompensatorTest
	 */
	protected LinearShuntCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LinearShuntCompensator
	 * 
	 * @return CreateLinearShuntCompensatorCommand alias
	 */
	protected CreateLinearShuntCompensatorCommand generateNewCommand() {
        CreateLinearShuntCompensatorCommand command = new CreateLinearShuntCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LinearShuntCompensator
		 * 
		 * @return UpdateLinearShuntCompensatorCommand alias
		 */
	protected UpdateLinearShuntCompensatorCommand generateUpdateCommand() {
	        UpdateLinearShuntCompensatorCommand command = new UpdateLinearShuntCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID linearShuntCompensatorId = null;
	protected LinearShuntCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LinearShuntCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLinearShuntCompensatorList = 0;
}
