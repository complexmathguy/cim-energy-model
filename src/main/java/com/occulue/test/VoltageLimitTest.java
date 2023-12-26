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
 * Test VoltageLimit class.
 *
 * @author your_name_here
 */
public class VoltageLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageLimitTest() {
		subscriber = new VoltageLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageLimit...");
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
	 * jumpstart the process by instantiating2 VoltageLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageLimitId = VoltageLimitBusinessDelegate.getVoltageLimitInstance()
		.createVoltageLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageLimitBusinessDelegate.getVoltageLimitInstance()
				.createVoltageLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageLimit : " + successValue.getVoltageLimitId());
							  if (successValue.getVoltageLimitId().equals(voltageLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageLimit consumed")
					);
			subscriber.voltageLimitSubscribe( voltageLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageLimit : " + successValue.getVoltageLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageLimit for voltageLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageLimit. 
	 */
	protected VoltageLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageLimit" );

		VoltageLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageLimit with primary key" );
		msg.append( voltageLimitId );
		
		VoltageLimitFetchOneSummary fetchOneSummary = new VoltageLimitFetchOneSummary( voltageLimitId );

		try {
			entity = VoltageLimitBusinessDelegate.getVoltageLimitInstance().getVoltageLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageLimit : " );        
		VoltageLimit entity = read();
		UpdateVoltageLimitCommand command = generateUpdateCommand();
		command.setVoltageLimitId(entity.getVoltageLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageLimit." );

			// for use later on...
			voltageLimitId = entity.getVoltageLimitId();

			VoltageLimitBusinessDelegate proxy = VoltageLimitBusinessDelegate.getVoltageLimitInstance();  

			proxy.updateVoltageLimit( command ).get();

			LOGGER.info( "-- Successfully saved VoltageLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageLimit." );

		VoltageLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageLimit with id " + voltageLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageLimit with id " + voltageLimitId );

			throw e;
		}

		try{
			VoltageLimitBusinessDelegate.getVoltageLimitInstance().delete( new DeleteVoltageLimitCommand( entity.getVoltageLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageLimit with id " + voltageLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageLimit with id " + voltageLimitId );

			throw e;
		}
	}

	/**
	 * get all VoltageLimits.
	 */
	protected List<VoltageLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageLimit : " );        
		List<VoltageLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageLimitBusinessDelegate
			collection = VoltageLimitBusinessDelegate.getVoltageLimitInstance().getAllVoltageLimit();
			assertNotNull( collection, "An Empty collection of VoltageLimit was incorrectly returned.");
			
			// Now print out the values
			VoltageLimit entity = null;            
			Iterator<VoltageLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageLimitTest
	 */
	protected VoltageLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageLimit
	 * 
	 * @return CreateVoltageLimitCommand alias
	 */
	protected CreateVoltageLimitCommand generateNewCommand() {
        CreateVoltageLimitCommand command = new CreateVoltageLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageLimit
		 * 
		 * @return UpdateVoltageLimitCommand alias
		 */
	protected UpdateVoltageLimitCommand generateUpdateCommand() {
	        UpdateVoltageLimitCommand command = new UpdateVoltageLimitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageLimitId = null;
	protected VoltageLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageLimitList = 0;
}
