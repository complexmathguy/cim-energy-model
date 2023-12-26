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
 * Test DCSeriesDevice class.
 *
 * @author your_name_here
 */
public class DCSeriesDeviceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCSeriesDeviceTest() {
		subscriber = new DCSeriesDeviceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCSeriesDeviceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCSeriesDevice...");
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
	 * jumpstart the process by instantiating2 DCSeriesDevice
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCSeriesDeviceId = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance()
		.createDCSeriesDevice( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance()
				.createDCSeriesDevice( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCSeriesDeviceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCSeriesDevice : " + successValue.getDCSeriesDeviceId());
							  if (successValue.getDCSeriesDeviceId().equals(dCSeriesDeviceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCSeriesDeviceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCSeriesDevice test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCSeriesDevice consumed")
					);
			subscriber.dCSeriesDeviceSubscribe( dCSeriesDeviceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCSeriesDevice : " + successValue.getDCSeriesDeviceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCSeriesDeviceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCSeriesDevice for dCSeriesDeviceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCSeriesDevice. 
	 */
	protected DCSeriesDevice read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCSeriesDevice" );

		DCSeriesDevice entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCSeriesDevice with primary key" );
		msg.append( dCSeriesDeviceId );
		
		DCSeriesDeviceFetchOneSummary fetchOneSummary = new DCSeriesDeviceFetchOneSummary( dCSeriesDeviceId );

		try {
			entity = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().getDCSeriesDevice( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCSeriesDevice " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCSeriesDevice.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCSeriesDevice." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCSeriesDevice : " );        
		DCSeriesDevice entity = read();
		UpdateDCSeriesDeviceCommand command = generateUpdateCommand();
		command.setDCSeriesDeviceId(entity.getDCSeriesDeviceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCSeriesDevice." );

			// for use later on...
			dCSeriesDeviceId = entity.getDCSeriesDeviceId();

			DCSeriesDeviceBusinessDelegate proxy = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();  

			proxy.updateDCSeriesDevice( command ).get();

			LOGGER.info( "-- Successfully saved DCSeriesDevice - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCSeriesDeviceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCSeriesDevice.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCSeriesDevice." );

		DCSeriesDevice entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCSeriesDevice with id " + dCSeriesDeviceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCSeriesDevice with id " + dCSeriesDeviceId );

			throw e;
		}

		try{
			DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().delete( new DeleteDCSeriesDeviceCommand( entity.getDCSeriesDeviceId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCSeriesDevice with id " + dCSeriesDeviceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCSeriesDevice with id " + dCSeriesDeviceId );

			throw e;
		}
	}

	/**
	 * get all DCSeriesDevices.
	 */
	protected List<DCSeriesDevice> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCSeriesDevices:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCSeriesDevice : " );        
		List<DCSeriesDevice> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCSeriesDeviceBusinessDelegate
			collection = DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().getAllDCSeriesDevice();
			assertNotNull( collection, "An Empty collection of DCSeriesDevice was incorrectly returned.");
			
			// Now print out the values
			DCSeriesDevice entity = null;            
			Iterator<DCSeriesDevice> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCSeriesDeviceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCSeriesDeviceTest
	 */
	protected DCSeriesDeviceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCSeriesDevice
	 * 
	 * @return CreateDCSeriesDeviceCommand alias
	 */
	protected CreateDCSeriesDeviceCommand generateNewCommand() {
        CreateDCSeriesDeviceCommand command = new CreateDCSeriesDeviceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DCSeriesDevice
		 * 
		 * @return UpdateDCSeriesDeviceCommand alias
		 */
	protected UpdateDCSeriesDeviceCommand generateUpdateCommand() {
	        UpdateDCSeriesDeviceCommand command = new UpdateDCSeriesDeviceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCSeriesDeviceId = null;
	protected DCSeriesDeviceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCSeriesDeviceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCSeriesDeviceList = 0;
}
