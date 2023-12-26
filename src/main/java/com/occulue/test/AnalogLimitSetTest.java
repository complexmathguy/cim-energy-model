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
 * Test AnalogLimitSet class.
 *
 * @author your_name_here
 */
public class AnalogLimitSetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AnalogLimitSetTest() {
		subscriber = new AnalogLimitSetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AnalogLimitSetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AnalogLimitSet...");
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
	 * jumpstart the process by instantiating2 AnalogLimitSet
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		analogLimitSetId = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance()
		.createAnalogLimitSet( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance()
				.createAnalogLimitSet( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.analogLimitSetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AnalogLimitSet : " + successValue.getAnalogLimitSetId());
							  if (successValue.getAnalogLimitSetId().equals(analogLimitSetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAnalogLimitSetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AnalogLimitSet test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogLimitSet consumed")
					);
			subscriber.analogLimitSetSubscribe( analogLimitSetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AnalogLimitSet : " + successValue.getAnalogLimitSetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAnalogLimitSetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on analogLimitSet for analogLimitSetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AnalogLimitSet. 
	 */
	protected AnalogLimitSet read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AnalogLimitSet" );

		AnalogLimitSet entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AnalogLimitSet with primary key" );
		msg.append( analogLimitSetId );
		
		AnalogLimitSetFetchOneSummary fetchOneSummary = new AnalogLimitSetFetchOneSummary( analogLimitSetId );

		try {
			entity = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().getAnalogLimitSet( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AnalogLimitSet " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AnalogLimitSet.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AnalogLimitSet." );

		StringBuilder msg = new StringBuilder( "Failed to update a AnalogLimitSet : " );        
		AnalogLimitSet entity = read();
		UpdateAnalogLimitSetCommand command = generateUpdateCommand();
		command.setAnalogLimitSetId(entity.getAnalogLimitSetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AnalogLimitSet." );

			// for use later on...
			analogLimitSetId = entity.getAnalogLimitSetId();

			AnalogLimitSetBusinessDelegate proxy = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance();  

			proxy.updateAnalogLimitSet( command ).get();

			LOGGER.info( "-- Successfully saved AnalogLimitSet - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + analogLimitSetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AnalogLimitSet.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AnalogLimitSet." );

		AnalogLimitSet entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AnalogLimitSet with id " + analogLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AnalogLimitSet with id " + analogLimitSetId );

			throw e;
		}

		try{
			AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().delete( new DeleteAnalogLimitSetCommand( entity.getAnalogLimitSetId() ) ).get();
			LOGGER.info( "-- Successfully deleted AnalogLimitSet with id " + analogLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AnalogLimitSet with id " + analogLimitSetId );

			throw e;
		}
	}

	/**
	 * get all AnalogLimitSets.
	 */
	protected List<AnalogLimitSet> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AnalogLimitSets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AnalogLimitSet : " );        
		List<AnalogLimitSet> collection  = new ArrayList<>();

		try {
			// call the static get method on the AnalogLimitSetBusinessDelegate
			collection = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().getAllAnalogLimitSet();
			assertNotNull( collection, "An Empty collection of AnalogLimitSet was incorrectly returned.");
			
			// Now print out the values
			AnalogLimitSet entity = null;            
			Iterator<AnalogLimitSet> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAnalogLimitSetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AnalogLimitSetTest
	 */
	protected AnalogLimitSetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AnalogLimitSet
	 * 
	 * @return CreateAnalogLimitSetCommand alias
	 */
	protected CreateAnalogLimitSetCommand generateNewCommand() {
        CreateAnalogLimitSetCommand command = new CreateAnalogLimitSetCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated AnalogLimitSet
		 * 
		 * @return UpdateAnalogLimitSetCommand alias
		 */
	protected UpdateAnalogLimitSetCommand generateUpdateCommand() {
	        UpdateAnalogLimitSetCommand command = new UpdateAnalogLimitSetCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID analogLimitSetId = null;
	protected AnalogLimitSetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AnalogLimitSetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAnalogLimitSetList = 0;
}
