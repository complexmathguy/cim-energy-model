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
 * Test VoltageCompensatorUserDefined class.
 *
 * @author your_name_here
 */
public class VoltageCompensatorUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageCompensatorUserDefinedTest() {
		subscriber = new VoltageCompensatorUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageCompensatorUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageCompensatorUserDefined...");
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
	 * jumpstart the process by instantiating2 VoltageCompensatorUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageCompensatorUserDefinedId = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance()
		.createVoltageCompensatorUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance()
				.createVoltageCompensatorUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageCompensatorUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageCompensatorUserDefined : " + successValue.getVoltageCompensatorUserDefinedId());
							  if (successValue.getVoltageCompensatorUserDefinedId().equals(voltageCompensatorUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageCompensatorUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageCompensatorUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageCompensatorUserDefined consumed")
					);
			subscriber.voltageCompensatorUserDefinedSubscribe( voltageCompensatorUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageCompensatorUserDefined : " + successValue.getVoltageCompensatorUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageCompensatorUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageCompensatorUserDefined for voltageCompensatorUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageCompensatorUserDefined. 
	 */
	protected VoltageCompensatorUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageCompensatorUserDefined" );

		VoltageCompensatorUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageCompensatorUserDefined with primary key" );
		msg.append( voltageCompensatorUserDefinedId );
		
		VoltageCompensatorUserDefinedFetchOneSummary fetchOneSummary = new VoltageCompensatorUserDefinedFetchOneSummary( voltageCompensatorUserDefinedId );

		try {
			entity = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().getVoltageCompensatorUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageCompensatorUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageCompensatorUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageCompensatorUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageCompensatorUserDefined : " );        
		VoltageCompensatorUserDefined entity = read();
		UpdateVoltageCompensatorUserDefinedCommand command = generateUpdateCommand();
		command.setVoltageCompensatorUserDefinedId(entity.getVoltageCompensatorUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageCompensatorUserDefined." );

			// for use later on...
			voltageCompensatorUserDefinedId = entity.getVoltageCompensatorUserDefinedId();

			VoltageCompensatorUserDefinedBusinessDelegate proxy = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance();  

			proxy.updateVoltageCompensatorUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved VoltageCompensatorUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageCompensatorUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageCompensatorUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageCompensatorUserDefined." );

		VoltageCompensatorUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageCompensatorUserDefined with id " + voltageCompensatorUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageCompensatorUserDefined with id " + voltageCompensatorUserDefinedId );

			throw e;
		}

		try{
			VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().delete( new DeleteVoltageCompensatorUserDefinedCommand( entity.getVoltageCompensatorUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageCompensatorUserDefined with id " + voltageCompensatorUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageCompensatorUserDefined with id " + voltageCompensatorUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all VoltageCompensatorUserDefineds.
	 */
	protected List<VoltageCompensatorUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageCompensatorUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageCompensatorUserDefined : " );        
		List<VoltageCompensatorUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageCompensatorUserDefinedBusinessDelegate
			collection = VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance().getAllVoltageCompensatorUserDefined();
			assertNotNull( collection, "An Empty collection of VoltageCompensatorUserDefined was incorrectly returned.");
			
			// Now print out the values
			VoltageCompensatorUserDefined entity = null;            
			Iterator<VoltageCompensatorUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageCompensatorUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageCompensatorUserDefinedTest
	 */
	protected VoltageCompensatorUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageCompensatorUserDefined
	 * 
	 * @return CreateVoltageCompensatorUserDefinedCommand alias
	 */
	protected CreateVoltageCompensatorUserDefinedCommand generateNewCommand() {
        CreateVoltageCompensatorUserDefinedCommand command = new CreateVoltageCompensatorUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageCompensatorUserDefined
		 * 
		 * @return UpdateVoltageCompensatorUserDefinedCommand alias
		 */
	protected UpdateVoltageCompensatorUserDefinedCommand generateUpdateCommand() {
	        UpdateVoltageCompensatorUserDefinedCommand command = new UpdateVoltageCompensatorUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageCompensatorUserDefinedId = null;
	protected VoltageCompensatorUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageCompensatorUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageCompensatorUserDefinedList = 0;
}
