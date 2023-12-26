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
 * Test ShuntCompensator class.
 *
 * @author your_name_here
 */
public class ShuntCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ShuntCompensatorTest() {
		subscriber = new ShuntCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ShuntCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ShuntCompensator...");
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
	 * jumpstart the process by instantiating2 ShuntCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		shuntCompensatorId = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
		.createShuntCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance()
				.createShuntCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.shuntCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ShuntCompensator : " + successValue.getShuntCompensatorId());
							  if (successValue.getShuntCompensatorId().equals(shuntCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfShuntCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ShuntCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on shuntCompensator consumed")
					);
			subscriber.shuntCompensatorSubscribe( shuntCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ShuntCompensator : " + successValue.getShuntCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfShuntCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on shuntCompensator for shuntCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ShuntCompensator. 
	 */
	protected ShuntCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ShuntCompensator" );

		ShuntCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ShuntCompensator with primary key" );
		msg.append( shuntCompensatorId );
		
		ShuntCompensatorFetchOneSummary fetchOneSummary = new ShuntCompensatorFetchOneSummary( shuntCompensatorId );

		try {
			entity = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().getShuntCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ShuntCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ShuntCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ShuntCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a ShuntCompensator : " );        
		ShuntCompensator entity = read();
		UpdateShuntCompensatorCommand command = generateUpdateCommand();
		command.setShuntCompensatorId(entity.getShuntCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ShuntCompensator." );

			// for use later on...
			shuntCompensatorId = entity.getShuntCompensatorId();

			ShuntCompensatorBusinessDelegate proxy = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance();  

			proxy.updateShuntCompensator( command ).get();

			LOGGER.info( "-- Successfully saved ShuntCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + shuntCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ShuntCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ShuntCompensator." );

		ShuntCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ShuntCompensator with id " + shuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ShuntCompensator with id " + shuntCompensatorId );

			throw e;
		}

		try{
			ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().delete( new DeleteShuntCompensatorCommand( entity.getShuntCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted ShuntCompensator with id " + shuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ShuntCompensator with id " + shuntCompensatorId );

			throw e;
		}
	}

	/**
	 * get all ShuntCompensators.
	 */
	protected List<ShuntCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ShuntCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ShuntCompensator : " );        
		List<ShuntCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the ShuntCompensatorBusinessDelegate
			collection = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().getAllShuntCompensator();
			assertNotNull( collection, "An Empty collection of ShuntCompensator was incorrectly returned.");
			
			// Now print out the values
			ShuntCompensator entity = null;            
			Iterator<ShuntCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getShuntCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ShuntCompensatorTest
	 */
	protected ShuntCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ShuntCompensator
	 * 
	 * @return CreateShuntCompensatorCommand alias
	 */
	protected CreateShuntCompensatorCommand generateNewCommand() {
        CreateShuntCompensatorCommand command = new CreateShuntCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ShuntCompensator
		 * 
		 * @return UpdateShuntCompensatorCommand alias
		 */
	protected UpdateShuntCompensatorCommand generateUpdateCommand() {
	        UpdateShuntCompensatorCommand command = new UpdateShuntCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID shuntCompensatorId = null;
	protected ShuntCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ShuntCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfShuntCompensatorList = 0;
}
