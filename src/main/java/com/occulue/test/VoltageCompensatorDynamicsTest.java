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
 * Test VoltageCompensatorDynamics class.
 *
 * @author your_name_here
 */
public class VoltageCompensatorDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageCompensatorDynamicsTest() {
		subscriber = new VoltageCompensatorDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageCompensatorDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageCompensatorDynamics...");
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
	 * jumpstart the process by instantiating2 VoltageCompensatorDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageCompensatorDynamicsId = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance()
		.createVoltageCompensatorDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance()
				.createVoltageCompensatorDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageCompensatorDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageCompensatorDynamics : " + successValue.getVoltageCompensatorDynamicsId());
							  if (successValue.getVoltageCompensatorDynamicsId().equals(voltageCompensatorDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageCompensatorDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageCompensatorDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageCompensatorDynamics consumed")
					);
			subscriber.voltageCompensatorDynamicsSubscribe( voltageCompensatorDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageCompensatorDynamics : " + successValue.getVoltageCompensatorDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageCompensatorDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageCompensatorDynamics for voltageCompensatorDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageCompensatorDynamics. 
	 */
	protected VoltageCompensatorDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageCompensatorDynamics" );

		VoltageCompensatorDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageCompensatorDynamics with primary key" );
		msg.append( voltageCompensatorDynamicsId );
		
		VoltageCompensatorDynamicsFetchOneSummary fetchOneSummary = new VoltageCompensatorDynamicsFetchOneSummary( voltageCompensatorDynamicsId );

		try {
			entity = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().getVoltageCompensatorDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageCompensatorDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageCompensatorDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageCompensatorDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageCompensatorDynamics : " );        
		VoltageCompensatorDynamics entity = read();
		UpdateVoltageCompensatorDynamicsCommand command = generateUpdateCommand();
		command.setVoltageCompensatorDynamicsId(entity.getVoltageCompensatorDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageCompensatorDynamics." );

			// for use later on...
			voltageCompensatorDynamicsId = entity.getVoltageCompensatorDynamicsId();

			VoltageCompensatorDynamicsBusinessDelegate proxy = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance();  

			proxy.updateVoltageCompensatorDynamics( command ).get();

			LOGGER.info( "-- Successfully saved VoltageCompensatorDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageCompensatorDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageCompensatorDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageCompensatorDynamics." );

		VoltageCompensatorDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageCompensatorDynamics with id " + voltageCompensatorDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageCompensatorDynamics with id " + voltageCompensatorDynamicsId );

			throw e;
		}

		try{
			VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().delete( new DeleteVoltageCompensatorDynamicsCommand( entity.getVoltageCompensatorDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageCompensatorDynamics with id " + voltageCompensatorDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageCompensatorDynamics with id " + voltageCompensatorDynamicsId );

			throw e;
		}
	}

	/**
	 * get all VoltageCompensatorDynamicss.
	 */
	protected List<VoltageCompensatorDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageCompensatorDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageCompensatorDynamics : " );        
		List<VoltageCompensatorDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageCompensatorDynamicsBusinessDelegate
			collection = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().getAllVoltageCompensatorDynamics();
			assertNotNull( collection, "An Empty collection of VoltageCompensatorDynamics was incorrectly returned.");
			
			// Now print out the values
			VoltageCompensatorDynamics entity = null;            
			Iterator<VoltageCompensatorDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageCompensatorDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageCompensatorDynamicsTest
	 */
	protected VoltageCompensatorDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageCompensatorDynamics
	 * 
	 * @return CreateVoltageCompensatorDynamicsCommand alias
	 */
	protected CreateVoltageCompensatorDynamicsCommand generateNewCommand() {
        CreateVoltageCompensatorDynamicsCommand command = new CreateVoltageCompensatorDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageCompensatorDynamics
		 * 
		 * @return UpdateVoltageCompensatorDynamicsCommand alias
		 */
	protected UpdateVoltageCompensatorDynamicsCommand generateUpdateCommand() {
	        UpdateVoltageCompensatorDynamicsCommand command = new UpdateVoltageCompensatorDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageCompensatorDynamicsId = null;
	protected VoltageCompensatorDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageCompensatorDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageCompensatorDynamicsList = 0;
}
