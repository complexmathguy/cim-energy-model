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
 * Test LimitSet class.
 *
 * @author your_name_here
 */
public class LimitSetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LimitSetTest() {
		subscriber = new LimitSetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LimitSetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LimitSet...");
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
	 * jumpstart the process by instantiating2 LimitSet
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		limitSetId = LimitSetBusinessDelegate.getLimitSetInstance()
		.createLimitSet( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LimitSetBusinessDelegate.getLimitSetInstance()
				.createLimitSet( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.limitSetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LimitSet : " + successValue.getLimitSetId());
							  if (successValue.getLimitSetId().equals(limitSetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLimitSetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LimitSet test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on limitSet consumed")
					);
			subscriber.limitSetSubscribe( limitSetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LimitSet : " + successValue.getLimitSetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLimitSetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on limitSet for limitSetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LimitSet. 
	 */
	protected LimitSet read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LimitSet" );

		LimitSet entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LimitSet with primary key" );
		msg.append( limitSetId );
		
		LimitSetFetchOneSummary fetchOneSummary = new LimitSetFetchOneSummary( limitSetId );

		try {
			entity = LimitSetBusinessDelegate.getLimitSetInstance().getLimitSet( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LimitSet " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LimitSet.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LimitSet." );

		StringBuilder msg = new StringBuilder( "Failed to update a LimitSet : " );        
		LimitSet entity = read();
		UpdateLimitSetCommand command = generateUpdateCommand();
		command.setLimitSetId(entity.getLimitSetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LimitSet." );

			// for use later on...
			limitSetId = entity.getLimitSetId();

			LimitSetBusinessDelegate proxy = LimitSetBusinessDelegate.getLimitSetInstance();  

			proxy.updateLimitSet( command ).get();

			LOGGER.info( "-- Successfully saved LimitSet - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + limitSetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LimitSet.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LimitSet." );

		LimitSet entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LimitSet with id " + limitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LimitSet with id " + limitSetId );

			throw e;
		}

		try{
			LimitSetBusinessDelegate.getLimitSetInstance().delete( new DeleteLimitSetCommand( entity.getLimitSetId() ) ).get();
			LOGGER.info( "-- Successfully deleted LimitSet with id " + limitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LimitSet with id " + limitSetId );

			throw e;
		}
	}

	/**
	 * get all LimitSets.
	 */
	protected List<LimitSet> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LimitSets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LimitSet : " );        
		List<LimitSet> collection  = new ArrayList<>();

		try {
			// call the static get method on the LimitSetBusinessDelegate
			collection = LimitSetBusinessDelegate.getLimitSetInstance().getAllLimitSet();
			assertNotNull( collection, "An Empty collection of LimitSet was incorrectly returned.");
			
			// Now print out the values
			LimitSet entity = null;            
			Iterator<LimitSet> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLimitSetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LimitSetTest
	 */
	protected LimitSetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LimitSet
	 * 
	 * @return CreateLimitSetCommand alias
	 */
	protected CreateLimitSetCommand generateNewCommand() {
        CreateLimitSetCommand command = new CreateLimitSetCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LimitSet
		 * 
		 * @return UpdateLimitSetCommand alias
		 */
	protected UpdateLimitSetCommand generateUpdateCommand() {
	        UpdateLimitSetCommand command = new UpdateLimitSetCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID limitSetId = null;
	protected LimitSetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LimitSetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLimitSetList = 0;
}
