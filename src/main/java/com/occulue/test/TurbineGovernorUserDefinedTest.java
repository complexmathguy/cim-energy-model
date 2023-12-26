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
 * Test TurbineGovernorUserDefined class.
 *
 * @author your_name_here
 */
public class TurbineGovernorUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TurbineGovernorUserDefinedTest() {
		subscriber = new TurbineGovernorUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TurbineGovernorUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TurbineGovernorUserDefined...");
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
	 * jumpstart the process by instantiating2 TurbineGovernorUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		turbineGovernorUserDefinedId = TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance()
		.createTurbineGovernorUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance()
				.createTurbineGovernorUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.turbineGovernorUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TurbineGovernorUserDefined : " + successValue.getTurbineGovernorUserDefinedId());
							  if (successValue.getTurbineGovernorUserDefinedId().equals(turbineGovernorUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTurbineGovernorUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TurbineGovernorUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineGovernorUserDefined consumed")
					);
			subscriber.turbineGovernorUserDefinedSubscribe( turbineGovernorUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TurbineGovernorUserDefined : " + successValue.getTurbineGovernorUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTurbineGovernorUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbineGovernorUserDefined for turbineGovernorUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TurbineGovernorUserDefined. 
	 */
	protected TurbineGovernorUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TurbineGovernorUserDefined" );

		TurbineGovernorUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TurbineGovernorUserDefined with primary key" );
		msg.append( turbineGovernorUserDefinedId );
		
		TurbineGovernorUserDefinedFetchOneSummary fetchOneSummary = new TurbineGovernorUserDefinedFetchOneSummary( turbineGovernorUserDefinedId );

		try {
			entity = TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance().getTurbineGovernorUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TurbineGovernorUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TurbineGovernorUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TurbineGovernorUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a TurbineGovernorUserDefined : " );        
		TurbineGovernorUserDefined entity = read();
		UpdateTurbineGovernorUserDefinedCommand command = generateUpdateCommand();
		command.setTurbineGovernorUserDefinedId(entity.getTurbineGovernorUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TurbineGovernorUserDefined." );

			// for use later on...
			turbineGovernorUserDefinedId = entity.getTurbineGovernorUserDefinedId();

			TurbineGovernorUserDefinedBusinessDelegate proxy = TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance();  

			proxy.updateTurbineGovernorUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved TurbineGovernorUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + turbineGovernorUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TurbineGovernorUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TurbineGovernorUserDefined." );

		TurbineGovernorUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TurbineGovernorUserDefined with id " + turbineGovernorUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TurbineGovernorUserDefined with id " + turbineGovernorUserDefinedId );

			throw e;
		}

		try{
			TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance().delete( new DeleteTurbineGovernorUserDefinedCommand( entity.getTurbineGovernorUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted TurbineGovernorUserDefined with id " + turbineGovernorUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TurbineGovernorUserDefined with id " + turbineGovernorUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all TurbineGovernorUserDefineds.
	 */
	protected List<TurbineGovernorUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TurbineGovernorUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TurbineGovernorUserDefined : " );        
		List<TurbineGovernorUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the TurbineGovernorUserDefinedBusinessDelegate
			collection = TurbineGovernorUserDefinedBusinessDelegate.getTurbineGovernorUserDefinedInstance().getAllTurbineGovernorUserDefined();
			assertNotNull( collection, "An Empty collection of TurbineGovernorUserDefined was incorrectly returned.");
			
			// Now print out the values
			TurbineGovernorUserDefined entity = null;            
			Iterator<TurbineGovernorUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTurbineGovernorUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TurbineGovernorUserDefinedTest
	 */
	protected TurbineGovernorUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TurbineGovernorUserDefined
	 * 
	 * @return CreateTurbineGovernorUserDefinedCommand alias
	 */
	protected CreateTurbineGovernorUserDefinedCommand generateNewCommand() {
        CreateTurbineGovernorUserDefinedCommand command = new CreateTurbineGovernorUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TurbineGovernorUserDefined
		 * 
		 * @return UpdateTurbineGovernorUserDefinedCommand alias
		 */
	protected UpdateTurbineGovernorUserDefinedCommand generateUpdateCommand() {
	        UpdateTurbineGovernorUserDefinedCommand command = new UpdateTurbineGovernorUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID turbineGovernorUserDefinedId = null;
	protected TurbineGovernorUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TurbineGovernorUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTurbineGovernorUserDefinedList = 0;
}
