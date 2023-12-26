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
 * Test VoltageAdjusterDynamics class.
 *
 * @author your_name_here
 */
public class VoltageAdjusterDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageAdjusterDynamicsTest() {
		subscriber = new VoltageAdjusterDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageAdjusterDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageAdjusterDynamics...");
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
	 * jumpstart the process by instantiating2 VoltageAdjusterDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageAdjusterDynamicsId = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
		.createVoltageAdjusterDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
				.createVoltageAdjusterDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageAdjusterDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageAdjusterDynamics : " + successValue.getVoltageAdjusterDynamicsId());
							  if (successValue.getVoltageAdjusterDynamicsId().equals(voltageAdjusterDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageAdjusterDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageAdjusterDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageAdjusterDynamics consumed")
					);
			subscriber.voltageAdjusterDynamicsSubscribe( voltageAdjusterDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageAdjusterDynamics : " + successValue.getVoltageAdjusterDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageAdjusterDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageAdjusterDynamics for voltageAdjusterDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageAdjusterDynamics. 
	 */
	protected VoltageAdjusterDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageAdjusterDynamics" );

		VoltageAdjusterDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageAdjusterDynamics with primary key" );
		msg.append( voltageAdjusterDynamicsId );
		
		VoltageAdjusterDynamicsFetchOneSummary fetchOneSummary = new VoltageAdjusterDynamicsFetchOneSummary( voltageAdjusterDynamicsId );

		try {
			entity = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().getVoltageAdjusterDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageAdjusterDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageAdjusterDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageAdjusterDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageAdjusterDynamics : " );        
		VoltageAdjusterDynamics entity = read();
		UpdateVoltageAdjusterDynamicsCommand command = generateUpdateCommand();
		command.setVoltageAdjusterDynamicsId(entity.getVoltageAdjusterDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageAdjusterDynamics." );

			// for use later on...
			voltageAdjusterDynamicsId = entity.getVoltageAdjusterDynamicsId();

			VoltageAdjusterDynamicsBusinessDelegate proxy = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance();  

			proxy.updateVoltageAdjusterDynamics( command ).get();

			LOGGER.info( "-- Successfully saved VoltageAdjusterDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageAdjusterDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageAdjusterDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageAdjusterDynamics." );

		VoltageAdjusterDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageAdjusterDynamics with id " + voltageAdjusterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageAdjusterDynamics with id " + voltageAdjusterDynamicsId );

			throw e;
		}

		try{
			VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().delete( new DeleteVoltageAdjusterDynamicsCommand( entity.getVoltageAdjusterDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageAdjusterDynamics with id " + voltageAdjusterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageAdjusterDynamics with id " + voltageAdjusterDynamicsId );

			throw e;
		}
	}

	/**
	 * get all VoltageAdjusterDynamicss.
	 */
	protected List<VoltageAdjusterDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageAdjusterDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageAdjusterDynamics : " );        
		List<VoltageAdjusterDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageAdjusterDynamicsBusinessDelegate
			collection = VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance().getAllVoltageAdjusterDynamics();
			assertNotNull( collection, "An Empty collection of VoltageAdjusterDynamics was incorrectly returned.");
			
			// Now print out the values
			VoltageAdjusterDynamics entity = null;            
			Iterator<VoltageAdjusterDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageAdjusterDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageAdjusterDynamicsTest
	 */
	protected VoltageAdjusterDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageAdjusterDynamics
	 * 
	 * @return CreateVoltageAdjusterDynamicsCommand alias
	 */
	protected CreateVoltageAdjusterDynamicsCommand generateNewCommand() {
        CreateVoltageAdjusterDynamicsCommand command = new CreateVoltageAdjusterDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageAdjusterDynamics
		 * 
		 * @return UpdateVoltageAdjusterDynamicsCommand alias
		 */
	protected UpdateVoltageAdjusterDynamicsCommand generateUpdateCommand() {
	        UpdateVoltageAdjusterDynamicsCommand command = new UpdateVoltageAdjusterDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageAdjusterDynamicsId = null;
	protected VoltageAdjusterDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageAdjusterDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageAdjusterDynamicsList = 0;
}
