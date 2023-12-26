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
 * Test VoltageLevel class.
 *
 * @author your_name_here
 */
public class VoltageLevelTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VoltageLevelTest() {
		subscriber = new VoltageLevelSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VoltageLevelTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VoltageLevel...");
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
	 * jumpstart the process by instantiating2 VoltageLevel
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		voltageLevelId = VoltageLevelBusinessDelegate.getVoltageLevelInstance()
		.createVoltageLevel( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VoltageLevelBusinessDelegate.getVoltageLevelInstance()
				.createVoltageLevel( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.voltageLevelSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VoltageLevel : " + successValue.getVoltageLevelId());
							  if (successValue.getVoltageLevelId().equals(voltageLevelId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVoltageLevelList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VoltageLevel test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageLevel consumed")
					);
			subscriber.voltageLevelSubscribe( voltageLevelId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VoltageLevel : " + successValue.getVoltageLevelId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVoltageLevelList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on voltageLevel for voltageLevelId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VoltageLevel. 
	 */
	protected VoltageLevel read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VoltageLevel" );

		VoltageLevel entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VoltageLevel with primary key" );
		msg.append( voltageLevelId );
		
		VoltageLevelFetchOneSummary fetchOneSummary = new VoltageLevelFetchOneSummary( voltageLevelId );

		try {
			entity = VoltageLevelBusinessDelegate.getVoltageLevelInstance().getVoltageLevel( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VoltageLevel " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VoltageLevel.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VoltageLevel." );

		StringBuilder msg = new StringBuilder( "Failed to update a VoltageLevel : " );        
		VoltageLevel entity = read();
		UpdateVoltageLevelCommand command = generateUpdateCommand();
		command.setVoltageLevelId(entity.getVoltageLevelId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VoltageLevel." );

			// for use later on...
			voltageLevelId = entity.getVoltageLevelId();

			VoltageLevelBusinessDelegate proxy = VoltageLevelBusinessDelegate.getVoltageLevelInstance();  

			proxy.updateVoltageLevel( command ).get();

			LOGGER.info( "-- Successfully saved VoltageLevel - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + voltageLevelId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VoltageLevel.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VoltageLevel." );

		VoltageLevel entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VoltageLevel with id " + voltageLevelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VoltageLevel with id " + voltageLevelId );

			throw e;
		}

		try{
			VoltageLevelBusinessDelegate.getVoltageLevelInstance().delete( new DeleteVoltageLevelCommand( entity.getVoltageLevelId() ) ).get();
			LOGGER.info( "-- Successfully deleted VoltageLevel with id " + voltageLevelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VoltageLevel with id " + voltageLevelId );

			throw e;
		}
	}

	/**
	 * get all VoltageLevels.
	 */
	protected List<VoltageLevel> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VoltageLevels:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VoltageLevel : " );        
		List<VoltageLevel> collection  = new ArrayList<>();

		try {
			// call the static get method on the VoltageLevelBusinessDelegate
			collection = VoltageLevelBusinessDelegate.getVoltageLevelInstance().getAllVoltageLevel();
			assertNotNull( collection, "An Empty collection of VoltageLevel was incorrectly returned.");
			
			// Now print out the values
			VoltageLevel entity = null;            
			Iterator<VoltageLevel> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVoltageLevelId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VoltageLevelTest
	 */
	protected VoltageLevelTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VoltageLevel
	 * 
	 * @return CreateVoltageLevelCommand alias
	 */
	protected CreateVoltageLevelCommand generateNewCommand() {
        CreateVoltageLevelCommand command = new CreateVoltageLevelCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VoltageLevel
		 * 
		 * @return UpdateVoltageLevelCommand alias
		 */
	protected UpdateVoltageLevelCommand generateUpdateCommand() {
	        UpdateVoltageLevelCommand command = new UpdateVoltageLevelCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID voltageLevelId = null;
	protected VoltageLevelSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VoltageLevelTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVoltageLevelList = 0;
}
