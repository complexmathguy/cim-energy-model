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
 * Test SwitchIt class.
 *
 * @author your_name_here
 */
public class SwitchItTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SwitchItTest() {
		subscriber = new SwitchItSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SwitchItTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SwitchIt...");
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
	 * jumpstart the process by instantiating2 SwitchIt
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		switchItId = SwitchItBusinessDelegate.getSwitchItInstance()
		.createSwitchIt( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SwitchItBusinessDelegate.getSwitchItInstance()
				.createSwitchIt( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.switchItSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SwitchIt : " + successValue.getSwitchItId());
							  if (successValue.getSwitchItId().equals(switchItId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSwitchItList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SwitchIt test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchIt consumed")
					);
			subscriber.switchItSubscribe( switchItId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SwitchIt : " + successValue.getSwitchItId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSwitchItList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchIt for switchItId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SwitchIt. 
	 */
	protected SwitchIt read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SwitchIt" );

		SwitchIt entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SwitchIt with primary key" );
		msg.append( switchItId );
		
		SwitchItFetchOneSummary fetchOneSummary = new SwitchItFetchOneSummary( switchItId );

		try {
			entity = SwitchItBusinessDelegate.getSwitchItInstance().getSwitchIt( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SwitchIt " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SwitchIt.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SwitchIt." );

		StringBuilder msg = new StringBuilder( "Failed to update a SwitchIt : " );        
		SwitchIt entity = read();
		UpdateSwitchItCommand command = generateUpdateCommand();
		command.setSwitchItId(entity.getSwitchItId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SwitchIt." );

			// for use later on...
			switchItId = entity.getSwitchItId();

			SwitchItBusinessDelegate proxy = SwitchItBusinessDelegate.getSwitchItInstance();  

			proxy.updateSwitchIt( command ).get();

			LOGGER.info( "-- Successfully saved SwitchIt - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + switchItId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SwitchIt.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SwitchIt." );

		SwitchIt entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SwitchIt with id " + switchItId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SwitchIt with id " + switchItId );

			throw e;
		}

		try{
			SwitchItBusinessDelegate.getSwitchItInstance().delete( new DeleteSwitchItCommand( entity.getSwitchItId() ) ).get();
			LOGGER.info( "-- Successfully deleted SwitchIt with id " + switchItId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SwitchIt with id " + switchItId );

			throw e;
		}
	}

	/**
	 * get all SwitchIts.
	 */
	protected List<SwitchIt> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SwitchIts:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SwitchIt : " );        
		List<SwitchIt> collection  = new ArrayList<>();

		try {
			// call the static get method on the SwitchItBusinessDelegate
			collection = SwitchItBusinessDelegate.getSwitchItInstance().getAllSwitchIt();
			assertNotNull( collection, "An Empty collection of SwitchIt was incorrectly returned.");
			
			// Now print out the values
			SwitchIt entity = null;            
			Iterator<SwitchIt> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSwitchItId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SwitchItTest
	 */
	protected SwitchItTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SwitchIt
	 * 
	 * @return CreateSwitchItCommand alias
	 */
	protected CreateSwitchItCommand generateNewCommand() {
        CreateSwitchItCommand command = new CreateSwitchItCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SwitchIt
		 * 
		 * @return UpdateSwitchItCommand alias
		 */
	protected UpdateSwitchItCommand generateUpdateCommand() {
	        UpdateSwitchItCommand command = new UpdateSwitchItCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID switchItId = null;
	protected SwitchItSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SwitchItTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSwitchItList = 0;
}
