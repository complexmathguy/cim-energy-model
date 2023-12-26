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
 * Test RatioTapChanger class.
 *
 * @author your_name_here
 */
public class RatioTapChangerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RatioTapChangerTest() {
		subscriber = new RatioTapChangerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RatioTapChangerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RatioTapChanger...");
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
	 * jumpstart the process by instantiating2 RatioTapChanger
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		ratioTapChangerId = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance()
		.createRatioTapChanger( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RatioTapChangerBusinessDelegate.getRatioTapChangerInstance()
				.createRatioTapChanger( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.ratioTapChangerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RatioTapChanger : " + successValue.getRatioTapChangerId());
							  if (successValue.getRatioTapChangerId().equals(ratioTapChangerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRatioTapChangerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RatioTapChanger test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChanger consumed")
					);
			subscriber.ratioTapChangerSubscribe( ratioTapChangerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RatioTapChanger : " + successValue.getRatioTapChangerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRatioTapChangerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChanger for ratioTapChangerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RatioTapChanger. 
	 */
	protected RatioTapChanger read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RatioTapChanger" );

		RatioTapChanger entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RatioTapChanger with primary key" );
		msg.append( ratioTapChangerId );
		
		RatioTapChangerFetchOneSummary fetchOneSummary = new RatioTapChangerFetchOneSummary( ratioTapChangerId );

		try {
			entity = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().getRatioTapChanger( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RatioTapChanger " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RatioTapChanger.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RatioTapChanger." );

		StringBuilder msg = new StringBuilder( "Failed to update a RatioTapChanger : " );        
		RatioTapChanger entity = read();
		UpdateRatioTapChangerCommand command = generateUpdateCommand();
		command.setRatioTapChangerId(entity.getRatioTapChangerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RatioTapChanger." );

			// for use later on...
			ratioTapChangerId = entity.getRatioTapChangerId();

			RatioTapChangerBusinessDelegate proxy = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance();  

			proxy.updateRatioTapChanger( command ).get();

			LOGGER.info( "-- Successfully saved RatioTapChanger - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + ratioTapChangerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RatioTapChanger.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RatioTapChanger." );

		RatioTapChanger entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RatioTapChanger with id " + ratioTapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RatioTapChanger with id " + ratioTapChangerId );

			throw e;
		}

		try{
			RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().delete( new DeleteRatioTapChangerCommand( entity.getRatioTapChangerId() ) ).get();
			LOGGER.info( "-- Successfully deleted RatioTapChanger with id " + ratioTapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RatioTapChanger with id " + ratioTapChangerId );

			throw e;
		}
	}

	/**
	 * get all RatioTapChangers.
	 */
	protected List<RatioTapChanger> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RatioTapChangers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RatioTapChanger : " );        
		List<RatioTapChanger> collection  = new ArrayList<>();

		try {
			// call the static get method on the RatioTapChangerBusinessDelegate
			collection = RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().getAllRatioTapChanger();
			assertNotNull( collection, "An Empty collection of RatioTapChanger was incorrectly returned.");
			
			// Now print out the values
			RatioTapChanger entity = null;            
			Iterator<RatioTapChanger> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRatioTapChangerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RatioTapChangerTest
	 */
	protected RatioTapChangerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RatioTapChanger
	 * 
	 * @return CreateRatioTapChangerCommand alias
	 */
	protected CreateRatioTapChangerCommand generateNewCommand() {
        CreateRatioTapChangerCommand command = new CreateRatioTapChangerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RatioTapChanger
		 * 
		 * @return UpdateRatioTapChangerCommand alias
		 */
	protected UpdateRatioTapChangerCommand generateUpdateCommand() {
	        UpdateRatioTapChangerCommand command = new UpdateRatioTapChangerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID ratioTapChangerId = null;
	protected RatioTapChangerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RatioTapChangerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRatioTapChangerList = 0;
}
