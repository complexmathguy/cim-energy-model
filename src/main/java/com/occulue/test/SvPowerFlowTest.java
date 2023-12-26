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
 * Test SvPowerFlow class.
 *
 * @author your_name_here
 */
public class SvPowerFlowTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvPowerFlowTest() {
		subscriber = new SvPowerFlowSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvPowerFlowTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvPowerFlow...");
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
	 * jumpstart the process by instantiating2 SvPowerFlow
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svPowerFlowId = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance()
		.createSvPowerFlow( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvPowerFlowBusinessDelegate.getSvPowerFlowInstance()
				.createSvPowerFlow( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svPowerFlowSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvPowerFlow : " + successValue.getSvPowerFlowId());
							  if (successValue.getSvPowerFlowId().equals(svPowerFlowId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvPowerFlowList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvPowerFlow test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svPowerFlow consumed")
					);
			subscriber.svPowerFlowSubscribe( svPowerFlowId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvPowerFlow : " + successValue.getSvPowerFlowId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvPowerFlowList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svPowerFlow for svPowerFlowId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvPowerFlow. 
	 */
	protected SvPowerFlow read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvPowerFlow" );

		SvPowerFlow entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvPowerFlow with primary key" );
		msg.append( svPowerFlowId );
		
		SvPowerFlowFetchOneSummary fetchOneSummary = new SvPowerFlowFetchOneSummary( svPowerFlowId );

		try {
			entity = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().getSvPowerFlow( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvPowerFlow " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvPowerFlow.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvPowerFlow." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvPowerFlow : " );        
		SvPowerFlow entity = read();
		UpdateSvPowerFlowCommand command = generateUpdateCommand();
		command.setSvPowerFlowId(entity.getSvPowerFlowId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvPowerFlow." );

			// for use later on...
			svPowerFlowId = entity.getSvPowerFlowId();

			SvPowerFlowBusinessDelegate proxy = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();  

			proxy.updateSvPowerFlow( command ).get();

			LOGGER.info( "-- Successfully saved SvPowerFlow - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svPowerFlowId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvPowerFlow.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvPowerFlow." );

		SvPowerFlow entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvPowerFlow with id " + svPowerFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvPowerFlow with id " + svPowerFlowId );

			throw e;
		}

		try{
			SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().delete( new DeleteSvPowerFlowCommand( entity.getSvPowerFlowId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvPowerFlow with id " + svPowerFlowId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvPowerFlow with id " + svPowerFlowId );

			throw e;
		}
	}

	/**
	 * get all SvPowerFlows.
	 */
	protected List<SvPowerFlow> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvPowerFlows:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvPowerFlow : " );        
		List<SvPowerFlow> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvPowerFlowBusinessDelegate
			collection = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().getAllSvPowerFlow();
			assertNotNull( collection, "An Empty collection of SvPowerFlow was incorrectly returned.");
			
			// Now print out the values
			SvPowerFlow entity = null;            
			Iterator<SvPowerFlow> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvPowerFlowId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvPowerFlowTest
	 */
	protected SvPowerFlowTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvPowerFlow
	 * 
	 * @return CreateSvPowerFlowCommand alias
	 */
	protected CreateSvPowerFlowCommand generateNewCommand() {
        CreateSvPowerFlowCommand command = new CreateSvPowerFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvPowerFlow
		 * 
		 * @return UpdateSvPowerFlowCommand alias
		 */
	protected UpdateSvPowerFlowCommand generateUpdateCommand() {
	        UpdateSvPowerFlowCommand command = new UpdateSvPowerFlowCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svPowerFlowId = null;
	protected SvPowerFlowSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvPowerFlowTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvPowerFlowList = 0;
}
