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
 * Test ConductingEquipment class.
 *
 * @author your_name_here
 */
public class ConductingEquipmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConductingEquipmentTest() {
		subscriber = new ConductingEquipmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConductingEquipmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConductingEquipment...");
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
	 * jumpstart the process by instantiating2 ConductingEquipment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conductingEquipmentId = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance()
		.createConductingEquipment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance()
				.createConductingEquipment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conductingEquipmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConductingEquipment : " + successValue.getConductingEquipmentId());
							  if (successValue.getConductingEquipmentId().equals(conductingEquipmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConductingEquipmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConductingEquipment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductingEquipment consumed")
					);
			subscriber.conductingEquipmentSubscribe( conductingEquipmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConductingEquipment : " + successValue.getConductingEquipmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConductingEquipmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conductingEquipment for conductingEquipmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConductingEquipment. 
	 */
	protected ConductingEquipment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConductingEquipment" );

		ConductingEquipment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConductingEquipment with primary key" );
		msg.append( conductingEquipmentId );
		
		ConductingEquipmentFetchOneSummary fetchOneSummary = new ConductingEquipmentFetchOneSummary( conductingEquipmentId );

		try {
			entity = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().getConductingEquipment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConductingEquipment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConductingEquipment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConductingEquipment." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConductingEquipment : " );        
		ConductingEquipment entity = read();
		UpdateConductingEquipmentCommand command = generateUpdateCommand();
		command.setConductingEquipmentId(entity.getConductingEquipmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConductingEquipment." );

			// for use later on...
			conductingEquipmentId = entity.getConductingEquipmentId();

			ConductingEquipmentBusinessDelegate proxy = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance();  

			proxy.updateConductingEquipment( command ).get();

			LOGGER.info( "-- Successfully saved ConductingEquipment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conductingEquipmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConductingEquipment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConductingEquipment." );

		ConductingEquipment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConductingEquipment with id " + conductingEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConductingEquipment with id " + conductingEquipmentId );

			throw e;
		}

		try{
			ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().delete( new DeleteConductingEquipmentCommand( entity.getConductingEquipmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConductingEquipment with id " + conductingEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConductingEquipment with id " + conductingEquipmentId );

			throw e;
		}
	}

	/**
	 * get all ConductingEquipments.
	 */
	protected List<ConductingEquipment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConductingEquipments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConductingEquipment : " );        
		List<ConductingEquipment> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConductingEquipmentBusinessDelegate
			collection = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().getAllConductingEquipment();
			assertNotNull( collection, "An Empty collection of ConductingEquipment was incorrectly returned.");
			
			// Now print out the values
			ConductingEquipment entity = null;            
			Iterator<ConductingEquipment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConductingEquipmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConductingEquipmentTest
	 */
	protected ConductingEquipmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConductingEquipment
	 * 
	 * @return CreateConductingEquipmentCommand alias
	 */
	protected CreateConductingEquipmentCommand generateNewCommand() {
        CreateConductingEquipmentCommand command = new CreateConductingEquipmentCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ConductingEquipment
		 * 
		 * @return UpdateConductingEquipmentCommand alias
		 */
	protected UpdateConductingEquipmentCommand generateUpdateCommand() {
	        UpdateConductingEquipmentCommand command = new UpdateConductingEquipmentCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conductingEquipmentId = null;
	protected ConductingEquipmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConductingEquipmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConductingEquipmentList = 0;
}
