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
 * Test TurbineLoadControllerUserDefined class.
 *
 * @author your_name_here
 */
public class TurbineLoadControllerUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TurbineLoadControllerUserDefinedTest() {
		subscriber = new TurbineLoadControllerUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TurbineLoadControllerUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TurbineLoadControllerUserDefined...");
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
	 * jumpstart the process by instantiating2 TurbineLoadControllerUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		turbineLoadControllerUserDefinedId = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance()
		.createTurbineLoadControllerUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance()
				.createTurbineLoadControllerUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.turbineLoadControllerUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TurbineLoadControllerUserDefined : " + successValue.getTurbineLoadControllerUserDefinedId());
							  if (successValue.getTurbineLoadControllerUserDefinedId().equals(turbineLoadControllerUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTurbineLoadControllerUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TurbineLoadControllerUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineLoadControllerUserDefined consumed")
					);
			subscriber.turbineLoadControllerUserDefinedSubscribe( turbineLoadControllerUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TurbineLoadControllerUserDefined : " + successValue.getTurbineLoadControllerUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTurbineLoadControllerUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineLoadControllerUserDefined for turbineLoadControllerUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TurbineLoadControllerUserDefined. 
	 */
	protected TurbineLoadControllerUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TurbineLoadControllerUserDefined" );

		TurbineLoadControllerUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TurbineLoadControllerUserDefined with primary key" );
		msg.append( turbineLoadControllerUserDefinedId );
		
		TurbineLoadControllerUserDefinedFetchOneSummary fetchOneSummary = new TurbineLoadControllerUserDefinedFetchOneSummary( turbineLoadControllerUserDefinedId );

		try {
			entity = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().getTurbineLoadControllerUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TurbineLoadControllerUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TurbineLoadControllerUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TurbineLoadControllerUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a TurbineLoadControllerUserDefined : " );        
		TurbineLoadControllerUserDefined entity = read();
		UpdateTurbineLoadControllerUserDefinedCommand command = generateUpdateCommand();
		command.setTurbineLoadControllerUserDefinedId(entity.getTurbineLoadControllerUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TurbineLoadControllerUserDefined." );

			// for use later on...
			turbineLoadControllerUserDefinedId = entity.getTurbineLoadControllerUserDefinedId();

			TurbineLoadControllerUserDefinedBusinessDelegate proxy = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance();  

			proxy.updateTurbineLoadControllerUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved TurbineLoadControllerUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + turbineLoadControllerUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TurbineLoadControllerUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TurbineLoadControllerUserDefined." );

		TurbineLoadControllerUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TurbineLoadControllerUserDefined with id " + turbineLoadControllerUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TurbineLoadControllerUserDefined with id " + turbineLoadControllerUserDefinedId );

			throw e;
		}

		try{
			TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().delete( new DeleteTurbineLoadControllerUserDefinedCommand( entity.getTurbineLoadControllerUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted TurbineLoadControllerUserDefined with id " + turbineLoadControllerUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TurbineLoadControllerUserDefined with id " + turbineLoadControllerUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all TurbineLoadControllerUserDefineds.
	 */
	protected List<TurbineLoadControllerUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TurbineLoadControllerUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TurbineLoadControllerUserDefined : " );        
		List<TurbineLoadControllerUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the TurbineLoadControllerUserDefinedBusinessDelegate
			collection = TurbineLoadControllerUserDefinedBusinessDelegate.getTurbineLoadControllerUserDefinedInstance().getAllTurbineLoadControllerUserDefined();
			assertNotNull( collection, "An Empty collection of TurbineLoadControllerUserDefined was incorrectly returned.");
			
			// Now print out the values
			TurbineLoadControllerUserDefined entity = null;            
			Iterator<TurbineLoadControllerUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTurbineLoadControllerUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TurbineLoadControllerUserDefinedTest
	 */
	protected TurbineLoadControllerUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TurbineLoadControllerUserDefined
	 * 
	 * @return CreateTurbineLoadControllerUserDefinedCommand alias
	 */
	protected CreateTurbineLoadControllerUserDefinedCommand generateNewCommand() {
        CreateTurbineLoadControllerUserDefinedCommand command = new CreateTurbineLoadControllerUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TurbineLoadControllerUserDefined
		 * 
		 * @return UpdateTurbineLoadControllerUserDefinedCommand alias
		 */
	protected UpdateTurbineLoadControllerUserDefinedCommand generateUpdateCommand() {
	        UpdateTurbineLoadControllerUserDefinedCommand command = new UpdateTurbineLoadControllerUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID turbineLoadControllerUserDefinedId = null;
	protected TurbineLoadControllerUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TurbineLoadControllerUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTurbineLoadControllerUserDefinedList = 0;
}
