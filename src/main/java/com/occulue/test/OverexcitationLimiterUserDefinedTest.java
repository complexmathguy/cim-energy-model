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
 * Test OverexcitationLimiterUserDefined class.
 *
 * @author your_name_here
 */
public class OverexcitationLimiterUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcitationLimiterUserDefinedTest() {
		subscriber = new OverexcitationLimiterUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcitationLimiterUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcitationLimiterUserDefined...");
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
	 * jumpstart the process by instantiating2 OverexcitationLimiterUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcitationLimiterUserDefinedId = OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance()
		.createOverexcitationLimiterUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance()
				.createOverexcitationLimiterUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcitationLimiterUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcitationLimiterUserDefined : " + successValue.getOverexcitationLimiterUserDefinedId());
							  if (successValue.getOverexcitationLimiterUserDefinedId().equals(overexcitationLimiterUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcitationLimiterUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcitationLimiterUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcitationLimiterUserDefined consumed")
					);
			subscriber.overexcitationLimiterUserDefinedSubscribe( overexcitationLimiterUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcitationLimiterUserDefined : " + successValue.getOverexcitationLimiterUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcitationLimiterUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcitationLimiterUserDefined for overexcitationLimiterUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcitationLimiterUserDefined. 
	 */
	protected OverexcitationLimiterUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcitationLimiterUserDefined" );

		OverexcitationLimiterUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcitationLimiterUserDefined with primary key" );
		msg.append( overexcitationLimiterUserDefinedId );
		
		OverexcitationLimiterUserDefinedFetchOneSummary fetchOneSummary = new OverexcitationLimiterUserDefinedFetchOneSummary( overexcitationLimiterUserDefinedId );

		try {
			entity = OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance().getOverexcitationLimiterUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcitationLimiterUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcitationLimiterUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcitationLimiterUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcitationLimiterUserDefined : " );        
		OverexcitationLimiterUserDefined entity = read();
		UpdateOverexcitationLimiterUserDefinedCommand command = generateUpdateCommand();
		command.setOverexcitationLimiterUserDefinedId(entity.getOverexcitationLimiterUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcitationLimiterUserDefined." );

			// for use later on...
			overexcitationLimiterUserDefinedId = entity.getOverexcitationLimiterUserDefinedId();

			OverexcitationLimiterUserDefinedBusinessDelegate proxy = OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance();  

			proxy.updateOverexcitationLimiterUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved OverexcitationLimiterUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcitationLimiterUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcitationLimiterUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcitationLimiterUserDefined." );

		OverexcitationLimiterUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcitationLimiterUserDefined with id " + overexcitationLimiterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcitationLimiterUserDefined with id " + overexcitationLimiterUserDefinedId );

			throw e;
		}

		try{
			OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance().delete( new DeleteOverexcitationLimiterUserDefinedCommand( entity.getOverexcitationLimiterUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcitationLimiterUserDefined with id " + overexcitationLimiterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcitationLimiterUserDefined with id " + overexcitationLimiterUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all OverexcitationLimiterUserDefineds.
	 */
	protected List<OverexcitationLimiterUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcitationLimiterUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcitationLimiterUserDefined : " );        
		List<OverexcitationLimiterUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcitationLimiterUserDefinedBusinessDelegate
			collection = OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance().getAllOverexcitationLimiterUserDefined();
			assertNotNull( collection, "An Empty collection of OverexcitationLimiterUserDefined was incorrectly returned.");
			
			// Now print out the values
			OverexcitationLimiterUserDefined entity = null;            
			Iterator<OverexcitationLimiterUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcitationLimiterUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcitationLimiterUserDefinedTest
	 */
	protected OverexcitationLimiterUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcitationLimiterUserDefined
	 * 
	 * @return CreateOverexcitationLimiterUserDefinedCommand alias
	 */
	protected CreateOverexcitationLimiterUserDefinedCommand generateNewCommand() {
        CreateOverexcitationLimiterUserDefinedCommand command = new CreateOverexcitationLimiterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcitationLimiterUserDefined
		 * 
		 * @return UpdateOverexcitationLimiterUserDefinedCommand alias
		 */
	protected UpdateOverexcitationLimiterUserDefinedCommand generateUpdateCommand() {
	        UpdateOverexcitationLimiterUserDefinedCommand command = new UpdateOverexcitationLimiterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcitationLimiterUserDefinedId = null;
	protected OverexcitationLimiterUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcitationLimiterUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcitationLimiterUserDefinedList = 0;
}
