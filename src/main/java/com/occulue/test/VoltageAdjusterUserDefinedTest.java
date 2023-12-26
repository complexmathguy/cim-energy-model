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
 * Test VoltageAdjusterUserDefined class.
 *
 * @author your_name_here
 */
public class VoltageAdjusterUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageAdjusterUserDefinedTest() {
		subscriber = new VoltageAdjusterUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageAdjusterUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageAdjusterUserDefined...");
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
	 * jumpstart the process by instantiating2 VoltageAdjusterUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageAdjusterUserDefinedId = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
		.createVoltageAdjusterUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance()
				.createVoltageAdjusterUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageAdjusterUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageAdjusterUserDefined : " + successValue.getVoltageAdjusterUserDefinedId());
							  if (successValue.getVoltageAdjusterUserDefinedId().equals(voltageAdjusterUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageAdjusterUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageAdjusterUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageAdjusterUserDefined consumed")
					);
			subscriber.voltageAdjusterUserDefinedSubscribe( voltageAdjusterUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageAdjusterUserDefined : " + successValue.getVoltageAdjusterUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageAdjusterUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageAdjusterUserDefined for voltageAdjusterUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageAdjusterUserDefined. 
	 */
	protected VoltageAdjusterUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageAdjusterUserDefined" );

		VoltageAdjusterUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageAdjusterUserDefined with primary key" );
		msg.append( voltageAdjusterUserDefinedId );
		
		VoltageAdjusterUserDefinedFetchOneSummary fetchOneSummary = new VoltageAdjusterUserDefinedFetchOneSummary( voltageAdjusterUserDefinedId );

		try {
			entity = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().getVoltageAdjusterUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageAdjusterUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageAdjusterUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageAdjusterUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageAdjusterUserDefined : " );        
		VoltageAdjusterUserDefined entity = read();
		UpdateVoltageAdjusterUserDefinedCommand command = generateUpdateCommand();
		command.setVoltageAdjusterUserDefinedId(entity.getVoltageAdjusterUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageAdjusterUserDefined." );

			// for use later on...
			voltageAdjusterUserDefinedId = entity.getVoltageAdjusterUserDefinedId();

			VoltageAdjusterUserDefinedBusinessDelegate proxy = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance();  

			proxy.updateVoltageAdjusterUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved VoltageAdjusterUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageAdjusterUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageAdjusterUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageAdjusterUserDefined." );

		VoltageAdjusterUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageAdjusterUserDefined with id " + voltageAdjusterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageAdjusterUserDefined with id " + voltageAdjusterUserDefinedId );

			throw e;
		}

		try{
			VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().delete( new DeleteVoltageAdjusterUserDefinedCommand( entity.getVoltageAdjusterUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageAdjusterUserDefined with id " + voltageAdjusterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageAdjusterUserDefined with id " + voltageAdjusterUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all VoltageAdjusterUserDefineds.
	 */
	protected List<VoltageAdjusterUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageAdjusterUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageAdjusterUserDefined : " );        
		List<VoltageAdjusterUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageAdjusterUserDefinedBusinessDelegate
			collection = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().getAllVoltageAdjusterUserDefined();
			assertNotNull( collection, "An Empty collection of VoltageAdjusterUserDefined was incorrectly returned.");
			
			// Now print out the values
			VoltageAdjusterUserDefined entity = null;            
			Iterator<VoltageAdjusterUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageAdjusterUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageAdjusterUserDefinedTest
	 */
	protected VoltageAdjusterUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageAdjusterUserDefined
	 * 
	 * @return CreateVoltageAdjusterUserDefinedCommand alias
	 */
	protected CreateVoltageAdjusterUserDefinedCommand generateNewCommand() {
        CreateVoltageAdjusterUserDefinedCommand command = new CreateVoltageAdjusterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageAdjusterUserDefined
		 * 
		 * @return UpdateVoltageAdjusterUserDefinedCommand alias
		 */
	protected UpdateVoltageAdjusterUserDefinedCommand generateUpdateCommand() {
	        UpdateVoltageAdjusterUserDefinedCommand command = new UpdateVoltageAdjusterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageAdjusterUserDefinedId = null;
	protected VoltageAdjusterUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageAdjusterUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageAdjusterUserDefinedList = 0;
}
