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
 * Test HydroGeneratingUnit class.
 *
 * @author your_name_here
 */
public class HydroGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public HydroGeneratingUnitTest() {
		subscriber = new HydroGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate HydroGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on HydroGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 HydroGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		hydroGeneratingUnitId = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance()
		.createHydroGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance()
				.createHydroGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.hydroGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for HydroGeneratingUnit : " + successValue.getHydroGeneratingUnitId());
							  if (successValue.getHydroGeneratingUnitId().equals(hydroGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfHydroGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("HydroGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroGeneratingUnit consumed")
					);
			subscriber.hydroGeneratingUnitSubscribe( hydroGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for HydroGeneratingUnit : " + successValue.getHydroGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfHydroGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroGeneratingUnit for hydroGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a HydroGeneratingUnit. 
	 */
	protected HydroGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created HydroGeneratingUnit" );

		HydroGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read HydroGeneratingUnit with primary key" );
		msg.append( hydroGeneratingUnitId );
		
		HydroGeneratingUnitFetchOneSummary fetchOneSummary = new HydroGeneratingUnitFetchOneSummary( hydroGeneratingUnitId );

		try {
			entity = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().getHydroGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found HydroGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a HydroGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a HydroGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a HydroGeneratingUnit : " );        
		HydroGeneratingUnit entity = read();
		UpdateHydroGeneratingUnitCommand command = generateUpdateCommand();
		command.setHydroGeneratingUnitId(entity.getHydroGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created HydroGeneratingUnit." );

			// for use later on...
			hydroGeneratingUnitId = entity.getHydroGeneratingUnitId();

			HydroGeneratingUnitBusinessDelegate proxy = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance();  

			proxy.updateHydroGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved HydroGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + hydroGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a HydroGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created HydroGeneratingUnit." );

		HydroGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read HydroGeneratingUnit with id " + hydroGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read HydroGeneratingUnit with id " + hydroGeneratingUnitId );

			throw e;
		}

		try{
			HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().delete( new DeleteHydroGeneratingUnitCommand( entity.getHydroGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted HydroGeneratingUnit with id " + hydroGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete HydroGeneratingUnit with id " + hydroGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all HydroGeneratingUnits.
	 */
	protected List<HydroGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of HydroGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all HydroGeneratingUnit : " );        
		List<HydroGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the HydroGeneratingUnitBusinessDelegate
			collection = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().getAllHydroGeneratingUnit();
			assertNotNull( collection, "An Empty collection of HydroGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			HydroGeneratingUnit entity = null;            
			Iterator<HydroGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getHydroGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		HydroGeneratingUnitTest
	 */
	protected HydroGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated HydroGeneratingUnit
	 * 
	 * @return CreateHydroGeneratingUnitCommand alias
	 */
	protected CreateHydroGeneratingUnitCommand generateNewCommand() {
        CreateHydroGeneratingUnitCommand command = new CreateHydroGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated HydroGeneratingUnit
		 * 
		 * @return UpdateHydroGeneratingUnitCommand alias
		 */
	protected UpdateHydroGeneratingUnitCommand generateUpdateCommand() {
	        UpdateHydroGeneratingUnitCommand command = new UpdateHydroGeneratingUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID hydroGeneratingUnitId = null;
	protected HydroGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(HydroGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfHydroGeneratingUnitList = 0;
}
