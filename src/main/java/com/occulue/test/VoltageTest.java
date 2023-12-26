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
 * Test Voltage class.
 *
 * @author your_name_here
 */
public class VoltageTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageTest() {
		subscriber = new VoltageSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Voltage...");
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
	 * jumpstart the process by instantiating2 Voltage
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageId = VoltageBusinessDelegate.getVoltageInstance()
		.createVoltage( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageBusinessDelegate.getVoltageInstance()
				.createVoltage( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Voltage : " + successValue.getVoltageId());
							  if (successValue.getVoltageId().equals(voltageId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Voltage test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltage consumed")
					);
			subscriber.voltageSubscribe( voltageId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Voltage : " + successValue.getVoltageId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltage for voltageId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Voltage. 
	 */
	protected Voltage read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Voltage" );

		Voltage entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Voltage with primary key" );
		msg.append( voltageId );
		
		VoltageFetchOneSummary fetchOneSummary = new VoltageFetchOneSummary( voltageId );

		try {
			entity = VoltageBusinessDelegate.getVoltageInstance().getVoltage( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Voltage " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Voltage.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Voltage." );

		StringBuilder msg = new StringBuilder( "Failed to update a Voltage : " );        
		Voltage entity = read();
		UpdateVoltageCommand command = generateUpdateCommand();
		command.setVoltageId(entity.getVoltageId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Voltage." );

			// for use later on...
			voltageId = entity.getVoltageId();

			VoltageBusinessDelegate proxy = VoltageBusinessDelegate.getVoltageInstance();  

			proxy.updateVoltage( command ).get();

			LOGGER.info( "-- Successfully saved Voltage - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Voltage.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Voltage." );

		Voltage entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Voltage with id " + voltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Voltage with id " + voltageId );

			throw e;
		}

		try{
			VoltageBusinessDelegate.getVoltageInstance().delete( new DeleteVoltageCommand( entity.getVoltageId() ) ).get();
			LOGGER.info( "-- Successfully deleted Voltage with id " + voltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Voltage with id " + voltageId );

			throw e;
		}
	}

	/**
	 * get all Voltages.
	 */
	protected List<Voltage> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Voltages:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Voltage : " );        
		List<Voltage> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageBusinessDelegate
			collection = VoltageBusinessDelegate.getVoltageInstance().getAllVoltage();
			assertNotNull( collection, "An Empty collection of Voltage was incorrectly returned.");
			
			// Now print out the values
			Voltage entity = null;            
			Iterator<Voltage> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageTest
	 */
	protected VoltageTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Voltage
	 * 
	 * @return CreateVoltageCommand alias
	 */
	protected CreateVoltageCommand generateNewCommand() {
        CreateVoltageCommand command = new CreateVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Voltage
		 * 
		 * @return UpdateVoltageCommand alias
		 */
	protected UpdateVoltageCommand generateUpdateCommand() {
	        UpdateVoltageCommand command = new UpdateVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageId = null;
	protected VoltageSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageList = 0;
}
