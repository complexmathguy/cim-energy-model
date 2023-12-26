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
 * Test SolarGeneratingUnit class.
 *
 * @author your_name_here
 */
public class SolarGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SolarGeneratingUnitTest() {
		subscriber = new SolarGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SolarGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SolarGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 SolarGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		solarGeneratingUnitId = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance()
		.createSolarGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance()
				.createSolarGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.solarGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SolarGeneratingUnit : " + successValue.getSolarGeneratingUnitId());
							  if (successValue.getSolarGeneratingUnitId().equals(solarGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSolarGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SolarGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on solarGeneratingUnit consumed")
					);
			subscriber.solarGeneratingUnitSubscribe( solarGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SolarGeneratingUnit : " + successValue.getSolarGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSolarGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on solarGeneratingUnit for solarGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SolarGeneratingUnit. 
	 */
	protected SolarGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SolarGeneratingUnit" );

		SolarGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SolarGeneratingUnit with primary key" );
		msg.append( solarGeneratingUnitId );
		
		SolarGeneratingUnitFetchOneSummary fetchOneSummary = new SolarGeneratingUnitFetchOneSummary( solarGeneratingUnitId );

		try {
			entity = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().getSolarGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SolarGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SolarGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SolarGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a SolarGeneratingUnit : " );        
		SolarGeneratingUnit entity = read();
		UpdateSolarGeneratingUnitCommand command = generateUpdateCommand();
		command.setSolarGeneratingUnitId(entity.getSolarGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SolarGeneratingUnit." );

			// for use later on...
			solarGeneratingUnitId = entity.getSolarGeneratingUnitId();

			SolarGeneratingUnitBusinessDelegate proxy = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance();  

			proxy.updateSolarGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved SolarGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + solarGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SolarGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SolarGeneratingUnit." );

		SolarGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SolarGeneratingUnit with id " + solarGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SolarGeneratingUnit with id " + solarGeneratingUnitId );

			throw e;
		}

		try{
			SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().delete( new DeleteSolarGeneratingUnitCommand( entity.getSolarGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted SolarGeneratingUnit with id " + solarGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SolarGeneratingUnit with id " + solarGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all SolarGeneratingUnits.
	 */
	protected List<SolarGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SolarGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SolarGeneratingUnit : " );        
		List<SolarGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the SolarGeneratingUnitBusinessDelegate
			collection = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().getAllSolarGeneratingUnit();
			assertNotNull( collection, "An Empty collection of SolarGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			SolarGeneratingUnit entity = null;            
			Iterator<SolarGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSolarGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SolarGeneratingUnitTest
	 */
	protected SolarGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SolarGeneratingUnit
	 * 
	 * @return CreateSolarGeneratingUnitCommand alias
	 */
	protected CreateSolarGeneratingUnitCommand generateNewCommand() {
        CreateSolarGeneratingUnitCommand command = new CreateSolarGeneratingUnitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SolarGeneratingUnit
		 * 
		 * @return UpdateSolarGeneratingUnitCommand alias
		 */
	protected UpdateSolarGeneratingUnitCommand generateUpdateCommand() {
	        UpdateSolarGeneratingUnitCommand command = new UpdateSolarGeneratingUnitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID solarGeneratingUnitId = null;
	protected SolarGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SolarGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSolarGeneratingUnitList = 0;
}
