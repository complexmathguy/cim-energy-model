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
 * Test VolumeFlowRate class.
 *
 * @author your_name_here
 */
public class VolumeFlowRateTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VolumeFlowRateTest() {
		subscriber = new VolumeFlowRateSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VolumeFlowRateTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VolumeFlowRate...");
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
	 * jumpstart the process by instantiating2 VolumeFlowRate
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		volumeFlowRateId = VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance()
		.createVolumeFlowRate( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance()
				.createVolumeFlowRate( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.volumeFlowRateSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VolumeFlowRate : " + successValue.getVolumeFlowRateId());
							  if (successValue.getVolumeFlowRateId().equals(volumeFlowRateId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVolumeFlowRateList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VolumeFlowRate test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on volumeFlowRate consumed")
					);
			subscriber.volumeFlowRateSubscribe( volumeFlowRateId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VolumeFlowRate : " + successValue.getVolumeFlowRateId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVolumeFlowRateList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on volumeFlowRate for volumeFlowRateId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VolumeFlowRate. 
	 */
	protected VolumeFlowRate read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VolumeFlowRate" );

		VolumeFlowRate entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VolumeFlowRate with primary key" );
		msg.append( volumeFlowRateId );
		
		VolumeFlowRateFetchOneSummary fetchOneSummary = new VolumeFlowRateFetchOneSummary( volumeFlowRateId );

		try {
			entity = VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().getVolumeFlowRate( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VolumeFlowRate " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VolumeFlowRate.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VolumeFlowRate." );

		StringBuilder msg = new StringBuilder( "Failed to update a VolumeFlowRate : " );        
		VolumeFlowRate entity = read();
		UpdateVolumeFlowRateCommand command = generateUpdateCommand();
		command.setVolumeFlowRateId(entity.getVolumeFlowRateId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VolumeFlowRate." );

			// for use later on...
			volumeFlowRateId = entity.getVolumeFlowRateId();

			VolumeFlowRateBusinessDelegate proxy = VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance();  

			proxy.updateVolumeFlowRate( command ).get();

			LOGGER.info( "-- Successfully saved VolumeFlowRate - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + volumeFlowRateId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VolumeFlowRate.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VolumeFlowRate." );

		VolumeFlowRate entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VolumeFlowRate with id " + volumeFlowRateId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VolumeFlowRate with id " + volumeFlowRateId );

			throw e;
		}

		try{
			VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().delete( new DeleteVolumeFlowRateCommand( entity.getVolumeFlowRateId() ) ).get();
			LOGGER.info( "-- Successfully deleted VolumeFlowRate with id " + volumeFlowRateId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VolumeFlowRate with id " + volumeFlowRateId );

			throw e;
		}
	}

	/**
	 * get all VolumeFlowRates.
	 */
	protected List<VolumeFlowRate> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VolumeFlowRates:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VolumeFlowRate : " );        
		List<VolumeFlowRate> collection  = new ArrayList<>();

		try {
			// call the static get method on the VolumeFlowRateBusinessDelegate
			collection = VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance().getAllVolumeFlowRate();
			assertNotNull( collection, "An Empty collection of VolumeFlowRate was incorrectly returned.");
			
			// Now print out the values
			VolumeFlowRate entity = null;            
			Iterator<VolumeFlowRate> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVolumeFlowRateId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VolumeFlowRateTest
	 */
	protected VolumeFlowRateTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VolumeFlowRate
	 * 
	 * @return CreateVolumeFlowRateCommand alias
	 */
	protected CreateVolumeFlowRateCommand generateNewCommand() {
        CreateVolumeFlowRateCommand command = new CreateVolumeFlowRateCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VolumeFlowRate
		 * 
		 * @return UpdateVolumeFlowRateCommand alias
		 */
	protected UpdateVolumeFlowRateCommand generateUpdateCommand() {
	        UpdateVolumeFlowRateCommand command = new UpdateVolumeFlowRateCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID volumeFlowRateId = null;
	protected VolumeFlowRateSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VolumeFlowRateTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVolumeFlowRateList = 0;
}
