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
 * Test EquivalentEquipment class.
 *
 * @author your_name_here
 */
public class EquivalentEquipmentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquivalentEquipmentTest() {
		subscriber = new EquivalentEquipmentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquivalentEquipmentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquivalentEquipment...");
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
	 * jumpstart the process by instantiating2 EquivalentEquipment
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equivalentEquipmentId = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
		.createEquivalentEquipment( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance()
				.createEquivalentEquipment( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equivalentEquipmentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquivalentEquipment : " + successValue.getEquivalentEquipmentId());
							  if (successValue.getEquivalentEquipmentId().equals(equivalentEquipmentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquivalentEquipmentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquivalentEquipment test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentEquipment consumed")
					);
			subscriber.equivalentEquipmentSubscribe( equivalentEquipmentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquivalentEquipment : " + successValue.getEquivalentEquipmentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquivalentEquipmentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentEquipment for equivalentEquipmentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquivalentEquipment. 
	 */
	protected EquivalentEquipment read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquivalentEquipment" );

		EquivalentEquipment entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquivalentEquipment with primary key" );
		msg.append( equivalentEquipmentId );
		
		EquivalentEquipmentFetchOneSummary fetchOneSummary = new EquivalentEquipmentFetchOneSummary( equivalentEquipmentId );

		try {
			entity = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().getEquivalentEquipment( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquivalentEquipment " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquivalentEquipment.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquivalentEquipment." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquivalentEquipment : " );        
		EquivalentEquipment entity = read();
		UpdateEquivalentEquipmentCommand command = generateUpdateCommand();
		command.setEquivalentEquipmentId(entity.getEquivalentEquipmentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquivalentEquipment." );

			// for use later on...
			equivalentEquipmentId = entity.getEquivalentEquipmentId();

			EquivalentEquipmentBusinessDelegate proxy = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance();  

			proxy.updateEquivalentEquipment( command ).get();

			LOGGER.info( "-- Successfully saved EquivalentEquipment - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equivalentEquipmentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquivalentEquipment.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquivalentEquipment." );

		EquivalentEquipment entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquivalentEquipment with id " + equivalentEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquivalentEquipment with id " + equivalentEquipmentId );

			throw e;
		}

		try{
			EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().delete( new DeleteEquivalentEquipmentCommand( entity.getEquivalentEquipmentId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquivalentEquipment with id " + equivalentEquipmentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquivalentEquipment with id " + equivalentEquipmentId );

			throw e;
		}
	}

	/**
	 * get all EquivalentEquipments.
	 */
	protected List<EquivalentEquipment> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquivalentEquipments:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquivalentEquipment : " );        
		List<EquivalentEquipment> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquivalentEquipmentBusinessDelegate
			collection = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().getAllEquivalentEquipment();
			assertNotNull( collection, "An Empty collection of EquivalentEquipment was incorrectly returned.");
			
			// Now print out the values
			EquivalentEquipment entity = null;            
			Iterator<EquivalentEquipment> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquivalentEquipmentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquivalentEquipmentTest
	 */
	protected EquivalentEquipmentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquivalentEquipment
	 * 
	 * @return CreateEquivalentEquipmentCommand alias
	 */
	protected CreateEquivalentEquipmentCommand generateNewCommand() {
        CreateEquivalentEquipmentCommand command = new CreateEquivalentEquipmentCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EquivalentEquipment
		 * 
		 * @return UpdateEquivalentEquipmentCommand alias
		 */
	protected UpdateEquivalentEquipmentCommand generateUpdateCommand() {
	        UpdateEquivalentEquipmentCommand command = new UpdateEquivalentEquipmentCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equivalentEquipmentId = null;
	protected EquivalentEquipmentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquivalentEquipmentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquivalentEquipmentList = 0;
}
