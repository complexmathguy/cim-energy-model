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
 * Test Equipment class.
 *
 * @author your_name_here
 */
public class EquipmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquipmentTest() {
		subscriber = new EquipmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquipmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Equipment...");
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
	 * jumpstart the process by instantiating2 Equipment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equipmentId = EquipmentBusinessDelegate.getEquipmentInstance()
		.createEquipment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquipmentBusinessDelegate.getEquipmentInstance()
				.createEquipment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equipmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Equipment : " + successValue.getEquipmentId());
							  if (successValue.getEquipmentId().equals(equipmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquipmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Equipment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipment consumed")
					);
			subscriber.equipmentSubscribe( equipmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Equipment : " + successValue.getEquipmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquipmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipment for equipmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Equipment. 
	 */
	protected Equipment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Equipment" );

		Equipment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Equipment with primary key" );
		msg.append( equipmentId );
		
		EquipmentFetchOneSummary fetchOneSummary = new EquipmentFetchOneSummary( equipmentId );

		try {
			entity = EquipmentBusinessDelegate.getEquipmentInstance().getEquipment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Equipment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Equipment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Equipment." );

		StringBuilder msg = new StringBuilder( "Failed to update a Equipment : " );        
		Equipment entity = read();
		UpdateEquipmentCommand command = generateUpdateCommand();
		command.setEquipmentId(entity.getEquipmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Equipment." );

			// for use later on...
			equipmentId = entity.getEquipmentId();

			EquipmentBusinessDelegate proxy = EquipmentBusinessDelegate.getEquipmentInstance();  

			proxy.updateEquipment( command ).get();

			LOGGER.info( "-- Successfully saved Equipment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equipmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Equipment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Equipment." );

		Equipment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Equipment with id " + equipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Equipment with id " + equipmentId );

			throw e;
		}

		try{
			EquipmentBusinessDelegate.getEquipmentInstance().delete( new DeleteEquipmentCommand( entity.getEquipmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted Equipment with id " + equipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Equipment with id " + equipmentId );

			throw e;
		}
	}

	/**
	 * get all Equipments.
	 */
	protected List<Equipment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Equipments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Equipment : " );        
		List<Equipment> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquipmentBusinessDelegate
			collection = EquipmentBusinessDelegate.getEquipmentInstance().getAllEquipment();
			assertNotNull( collection, "An Empty collection of Equipment was incorrectly returned.");
			
			// Now print out the values
			Equipment entity = null;            
			Iterator<Equipment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquipmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquipmentTest
	 */
	protected EquipmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Equipment
	 * 
	 * @return CreateEquipmentCommand alias
	 */
	protected CreateEquipmentCommand generateNewCommand() {
        CreateEquipmentCommand command = new CreateEquipmentCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Equipment
		 * 
		 * @return UpdateEquipmentCommand alias
		 */
	protected UpdateEquipmentCommand generateUpdateCommand() {
	        UpdateEquipmentCommand command = new UpdateEquipmentCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equipmentId = null;
	protected EquipmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquipmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquipmentList = 0;
}
