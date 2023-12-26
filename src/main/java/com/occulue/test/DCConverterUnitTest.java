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
 * Test DCConverterUnit class.
 *
 * @author your_name_here
 */
public class DCConverterUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCConverterUnitTest() {
		subscriber = new DCConverterUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCConverterUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCConverterUnit...");
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
	 * jumpstart the process by instantiating2 DCConverterUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCConverterUnitId = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance()
		.createDCConverterUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCConverterUnitBusinessDelegate.getDCConverterUnitInstance()
				.createDCConverterUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCConverterUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCConverterUnit : " + successValue.getDCConverterUnitId());
							  if (successValue.getDCConverterUnitId().equals(dCConverterUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCConverterUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCConverterUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCConverterUnit consumed")
					);
			subscriber.dCConverterUnitSubscribe( dCConverterUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCConverterUnit : " + successValue.getDCConverterUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCConverterUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCConverterUnit for dCConverterUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCConverterUnit. 
	 */
	protected DCConverterUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCConverterUnit" );

		DCConverterUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCConverterUnit with primary key" );
		msg.append( dCConverterUnitId );
		
		DCConverterUnitFetchOneSummary fetchOneSummary = new DCConverterUnitFetchOneSummary( dCConverterUnitId );

		try {
			entity = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().getDCConverterUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCConverterUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCConverterUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCConverterUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCConverterUnit : " );        
		DCConverterUnit entity = read();
		UpdateDCConverterUnitCommand command = generateUpdateCommand();
		command.setDCConverterUnitId(entity.getDCConverterUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCConverterUnit." );

			// for use later on...
			dCConverterUnitId = entity.getDCConverterUnitId();

			DCConverterUnitBusinessDelegate proxy = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance();  

			proxy.updateDCConverterUnit( command ).get();

			LOGGER.info( "-- Successfully saved DCConverterUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCConverterUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCConverterUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCConverterUnit." );

		DCConverterUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCConverterUnit with id " + dCConverterUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCConverterUnit with id " + dCConverterUnitId );

			throw e;
		}

		try{
			DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().delete( new DeleteDCConverterUnitCommand( entity.getDCConverterUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCConverterUnit with id " + dCConverterUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCConverterUnit with id " + dCConverterUnitId );

			throw e;
		}
	}

	/**
	 * get all DCConverterUnits.
	 */
	protected List<DCConverterUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCConverterUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCConverterUnit : " );        
		List<DCConverterUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCConverterUnitBusinessDelegate
			collection = DCConverterUnitBusinessDelegate.getDCConverterUnitInstance().getAllDCConverterUnit();
			assertNotNull( collection, "An Empty collection of DCConverterUnit was incorrectly returned.");
			
			// Now print out the values
			DCConverterUnit entity = null;            
			Iterator<DCConverterUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCConverterUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCConverterUnitTest
	 */
	protected DCConverterUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCConverterUnit
	 * 
	 * @return CreateDCConverterUnitCommand alias
	 */
	protected CreateDCConverterUnitCommand generateNewCommand() {
        CreateDCConverterUnitCommand command = new CreateDCConverterUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DCConverterUnit
		 * 
		 * @return UpdateDCConverterUnitCommand alias
		 */
	protected UpdateDCConverterUnitCommand generateUpdateCommand() {
	        UpdateDCConverterUnitCommand command = new UpdateDCConverterUnitCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCConverterUnitId = null;
	protected DCConverterUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCConverterUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCConverterUnitList = 0;
}
