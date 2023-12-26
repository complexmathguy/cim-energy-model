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
 * Test EarthFaultCompensator class.
 *
 * @author your_name_here
 */
public class EarthFaultCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EarthFaultCompensatorTest() {
		subscriber = new EarthFaultCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EarthFaultCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EarthFaultCompensator...");
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
	 * jumpstart the process by instantiating2 EarthFaultCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		earthFaultCompensatorId = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance()
		.createEarthFaultCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance()
				.createEarthFaultCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.earthFaultCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EarthFaultCompensator : " + successValue.getEarthFaultCompensatorId());
							  if (successValue.getEarthFaultCompensatorId().equals(earthFaultCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEarthFaultCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EarthFaultCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on earthFaultCompensator consumed")
					);
			subscriber.earthFaultCompensatorSubscribe( earthFaultCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EarthFaultCompensator : " + successValue.getEarthFaultCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEarthFaultCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on earthFaultCompensator for earthFaultCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EarthFaultCompensator. 
	 */
	protected EarthFaultCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EarthFaultCompensator" );

		EarthFaultCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EarthFaultCompensator with primary key" );
		msg.append( earthFaultCompensatorId );
		
		EarthFaultCompensatorFetchOneSummary fetchOneSummary = new EarthFaultCompensatorFetchOneSummary( earthFaultCompensatorId );

		try {
			entity = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().getEarthFaultCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EarthFaultCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EarthFaultCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EarthFaultCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a EarthFaultCompensator : " );        
		EarthFaultCompensator entity = read();
		UpdateEarthFaultCompensatorCommand command = generateUpdateCommand();
		command.setEarthFaultCompensatorId(entity.getEarthFaultCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EarthFaultCompensator." );

			// for use later on...
			earthFaultCompensatorId = entity.getEarthFaultCompensatorId();

			EarthFaultCompensatorBusinessDelegate proxy = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance();  

			proxy.updateEarthFaultCompensator( command ).get();

			LOGGER.info( "-- Successfully saved EarthFaultCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + earthFaultCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EarthFaultCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EarthFaultCompensator." );

		EarthFaultCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EarthFaultCompensator with id " + earthFaultCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EarthFaultCompensator with id " + earthFaultCompensatorId );

			throw e;
		}

		try{
			EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().delete( new DeleteEarthFaultCompensatorCommand( entity.getEarthFaultCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted EarthFaultCompensator with id " + earthFaultCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EarthFaultCompensator with id " + earthFaultCompensatorId );

			throw e;
		}
	}

	/**
	 * get all EarthFaultCompensators.
	 */
	protected List<EarthFaultCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EarthFaultCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EarthFaultCompensator : " );        
		List<EarthFaultCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the EarthFaultCompensatorBusinessDelegate
			collection = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().getAllEarthFaultCompensator();
			assertNotNull( collection, "An Empty collection of EarthFaultCompensator was incorrectly returned.");
			
			// Now print out the values
			EarthFaultCompensator entity = null;            
			Iterator<EarthFaultCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEarthFaultCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EarthFaultCompensatorTest
	 */
	protected EarthFaultCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EarthFaultCompensator
	 * 
	 * @return CreateEarthFaultCompensatorCommand alias
	 */
	protected CreateEarthFaultCompensatorCommand generateNewCommand() {
        CreateEarthFaultCompensatorCommand command = new CreateEarthFaultCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EarthFaultCompensator
		 * 
		 * @return UpdateEarthFaultCompensatorCommand alias
		 */
	protected UpdateEarthFaultCompensatorCommand generateUpdateCommand() {
	        UpdateEarthFaultCompensatorCommand command = new UpdateEarthFaultCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID earthFaultCompensatorId = null;
	protected EarthFaultCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EarthFaultCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEarthFaultCompensatorList = 0;
}
