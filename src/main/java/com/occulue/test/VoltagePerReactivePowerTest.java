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
 * Test VoltagePerReactivePower class.
 *
 * @author your_name_here
 */
public class VoltagePerReactivePowerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltagePerReactivePowerTest() {
		subscriber = new VoltagePerReactivePowerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltagePerReactivePowerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltagePerReactivePower...");
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
	 * jumpstart the process by instantiating2 VoltagePerReactivePower
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltagePerReactivePowerId = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
		.createVoltagePerReactivePower( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
				.createVoltagePerReactivePower( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltagePerReactivePowerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltagePerReactivePower : " + successValue.getVoltagePerReactivePowerId());
							  if (successValue.getVoltagePerReactivePowerId().equals(voltagePerReactivePowerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltagePerReactivePowerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltagePerReactivePower test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltagePerReactivePower consumed")
					);
			subscriber.voltagePerReactivePowerSubscribe( voltagePerReactivePowerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltagePerReactivePower : " + successValue.getVoltagePerReactivePowerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltagePerReactivePowerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltagePerReactivePower for voltagePerReactivePowerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltagePerReactivePower. 
	 */
	protected VoltagePerReactivePower read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltagePerReactivePower" );

		VoltagePerReactivePower entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltagePerReactivePower with primary key" );
		msg.append( voltagePerReactivePowerId );
		
		VoltagePerReactivePowerFetchOneSummary fetchOneSummary = new VoltagePerReactivePowerFetchOneSummary( voltagePerReactivePowerId );

		try {
			entity = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().getVoltagePerReactivePower( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltagePerReactivePower " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltagePerReactivePower.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltagePerReactivePower." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltagePerReactivePower : " );        
		VoltagePerReactivePower entity = read();
		UpdateVoltagePerReactivePowerCommand command = generateUpdateCommand();
		command.setVoltagePerReactivePowerId(entity.getVoltagePerReactivePowerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltagePerReactivePower." );

			// for use later on...
			voltagePerReactivePowerId = entity.getVoltagePerReactivePowerId();

			VoltagePerReactivePowerBusinessDelegate proxy = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance();  

			proxy.updateVoltagePerReactivePower( command ).get();

			LOGGER.info( "-- Successfully saved VoltagePerReactivePower - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltagePerReactivePowerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltagePerReactivePower.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltagePerReactivePower." );

		VoltagePerReactivePower entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltagePerReactivePower with id " + voltagePerReactivePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltagePerReactivePower with id " + voltagePerReactivePowerId );

			throw e;
		}

		try{
			VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().delete( new DeleteVoltagePerReactivePowerCommand( entity.getVoltagePerReactivePowerId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltagePerReactivePower with id " + voltagePerReactivePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltagePerReactivePower with id " + voltagePerReactivePowerId );

			throw e;
		}
	}

	/**
	 * get all VoltagePerReactivePowers.
	 */
	protected List<VoltagePerReactivePower> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltagePerReactivePowers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltagePerReactivePower : " );        
		List<VoltagePerReactivePower> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltagePerReactivePowerBusinessDelegate
			collection = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().getAllVoltagePerReactivePower();
			assertNotNull( collection, "An Empty collection of VoltagePerReactivePower was incorrectly returned.");
			
			// Now print out the values
			VoltagePerReactivePower entity = null;            
			Iterator<VoltagePerReactivePower> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltagePerReactivePowerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltagePerReactivePowerTest
	 */
	protected VoltagePerReactivePowerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltagePerReactivePower
	 * 
	 * @return CreateVoltagePerReactivePowerCommand alias
	 */
	protected CreateVoltagePerReactivePowerCommand generateNewCommand() {
        CreateVoltagePerReactivePowerCommand command = new CreateVoltagePerReactivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltagePerReactivePower
		 * 
		 * @return UpdateVoltagePerReactivePowerCommand alias
		 */
	protected UpdateVoltagePerReactivePowerCommand generateUpdateCommand() {
	        UpdateVoltagePerReactivePowerCommand command = new UpdateVoltagePerReactivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltagePerReactivePowerId = null;
	protected VoltagePerReactivePowerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltagePerReactivePowerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltagePerReactivePowerList = 0;
}
