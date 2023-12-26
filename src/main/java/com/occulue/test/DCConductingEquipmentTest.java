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
 * Test DCConductingEquipment class.
 *
 * @author your_name_here
 */
public class DCConductingEquipmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCConductingEquipmentTest() {
		subscriber = new DCConductingEquipmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCConductingEquipmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCConductingEquipment...");
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
	 * jumpstart the process by instantiating2 DCConductingEquipment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCConductingEquipmentId = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance()
		.createDCConductingEquipment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance()
				.createDCConductingEquipment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCConductingEquipmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCConductingEquipment : " + successValue.getDCConductingEquipmentId());
							  if (successValue.getDCConductingEquipmentId().equals(dCConductingEquipmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCConductingEquipmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCConductingEquipment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCConductingEquipment consumed")
					);
			subscriber.dCConductingEquipmentSubscribe( dCConductingEquipmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCConductingEquipment : " + successValue.getDCConductingEquipmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCConductingEquipmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCConductingEquipment for dCConductingEquipmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCConductingEquipment. 
	 */
	protected DCConductingEquipment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCConductingEquipment" );

		DCConductingEquipment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCConductingEquipment with primary key" );
		msg.append( dCConductingEquipmentId );
		
		DCConductingEquipmentFetchOneSummary fetchOneSummary = new DCConductingEquipmentFetchOneSummary( dCConductingEquipmentId );

		try {
			entity = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().getDCConductingEquipment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCConductingEquipment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCConductingEquipment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCConductingEquipment." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCConductingEquipment : " );        
		DCConductingEquipment entity = read();
		UpdateDCConductingEquipmentCommand command = generateUpdateCommand();
		command.setDCConductingEquipmentId(entity.getDCConductingEquipmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCConductingEquipment." );

			// for use later on...
			dCConductingEquipmentId = entity.getDCConductingEquipmentId();

			DCConductingEquipmentBusinessDelegate proxy = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance();  

			proxy.updateDCConductingEquipment( command ).get();

			LOGGER.info( "-- Successfully saved DCConductingEquipment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCConductingEquipmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCConductingEquipment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCConductingEquipment." );

		DCConductingEquipment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCConductingEquipment with id " + dCConductingEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCConductingEquipment with id " + dCConductingEquipmentId );

			throw e;
		}

		try{
			DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().delete( new DeleteDCConductingEquipmentCommand( entity.getDCConductingEquipmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCConductingEquipment with id " + dCConductingEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCConductingEquipment with id " + dCConductingEquipmentId );

			throw e;
		}
	}

	/**
	 * get all DCConductingEquipments.
	 */
	protected List<DCConductingEquipment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCConductingEquipments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCConductingEquipment : " );        
		List<DCConductingEquipment> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCConductingEquipmentBusinessDelegate
			collection = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().getAllDCConductingEquipment();
			assertNotNull( collection, "An Empty collection of DCConductingEquipment was incorrectly returned.");
			
			// Now print out the values
			DCConductingEquipment entity = null;            
			Iterator<DCConductingEquipment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCConductingEquipmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCConductingEquipmentTest
	 */
	protected DCConductingEquipmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCConductingEquipment
	 * 
	 * @return CreateDCConductingEquipmentCommand alias
	 */
	protected CreateDCConductingEquipmentCommand generateNewCommand() {
        CreateDCConductingEquipmentCommand command = new CreateDCConductingEquipmentCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCConductingEquipment
		 * 
		 * @return UpdateDCConductingEquipmentCommand alias
		 */
	protected UpdateDCConductingEquipmentCommand generateUpdateCommand() {
	        UpdateDCConductingEquipmentCommand command = new UpdateDCConductingEquipmentCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCConductingEquipmentId = null;
	protected DCConductingEquipmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCConductingEquipmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCConductingEquipmentList = 0;
}
