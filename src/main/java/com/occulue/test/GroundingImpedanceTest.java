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
 * Test GroundingImpedance class.
 *
 * @author your_name_here
 */
public class GroundingImpedanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GroundingImpedanceTest() {
		subscriber = new GroundingImpedanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GroundingImpedanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GroundingImpedance...");
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
	 * jumpstart the process by instantiating2 GroundingImpedance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		groundingImpedanceId = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance()
		.createGroundingImpedance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance()
				.createGroundingImpedance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.groundingImpedanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GroundingImpedance : " + successValue.getGroundingImpedanceId());
							  if (successValue.getGroundingImpedanceId().equals(groundingImpedanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGroundingImpedanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GroundingImpedance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on groundingImpedance consumed")
					);
			subscriber.groundingImpedanceSubscribe( groundingImpedanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GroundingImpedance : " + successValue.getGroundingImpedanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGroundingImpedanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on groundingImpedance for groundingImpedanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GroundingImpedance. 
	 */
	protected GroundingImpedance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GroundingImpedance" );

		GroundingImpedance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GroundingImpedance with primary key" );
		msg.append( groundingImpedanceId );
		
		GroundingImpedanceFetchOneSummary fetchOneSummary = new GroundingImpedanceFetchOneSummary( groundingImpedanceId );

		try {
			entity = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().getGroundingImpedance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GroundingImpedance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GroundingImpedance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GroundingImpedance." );

		StringBuilder msg = new StringBuilder( "Failed to update a GroundingImpedance : " );        
		GroundingImpedance entity = read();
		UpdateGroundingImpedanceCommand command = generateUpdateCommand();
		command.setGroundingImpedanceId(entity.getGroundingImpedanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GroundingImpedance." );

			// for use later on...
			groundingImpedanceId = entity.getGroundingImpedanceId();

			GroundingImpedanceBusinessDelegate proxy = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance();  

			proxy.updateGroundingImpedance( command ).get();

			LOGGER.info( "-- Successfully saved GroundingImpedance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + groundingImpedanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GroundingImpedance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GroundingImpedance." );

		GroundingImpedance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GroundingImpedance with id " + groundingImpedanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GroundingImpedance with id " + groundingImpedanceId );

			throw e;
		}

		try{
			GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().delete( new DeleteGroundingImpedanceCommand( entity.getGroundingImpedanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted GroundingImpedance with id " + groundingImpedanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GroundingImpedance with id " + groundingImpedanceId );

			throw e;
		}
	}

	/**
	 * get all GroundingImpedances.
	 */
	protected List<GroundingImpedance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GroundingImpedances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GroundingImpedance : " );        
		List<GroundingImpedance> collection  = new ArrayList<>();

		try {
			// call the static get method on the GroundingImpedanceBusinessDelegate
			collection = GroundingImpedanceBusinessDelegate.getGroundingImpedanceInstance().getAllGroundingImpedance();
			assertNotNull( collection, "An Empty collection of GroundingImpedance was incorrectly returned.");
			
			// Now print out the values
			GroundingImpedance entity = null;            
			Iterator<GroundingImpedance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGroundingImpedanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GroundingImpedanceTest
	 */
	protected GroundingImpedanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GroundingImpedance
	 * 
	 * @return CreateGroundingImpedanceCommand alias
	 */
	protected CreateGroundingImpedanceCommand generateNewCommand() {
        CreateGroundingImpedanceCommand command = new CreateGroundingImpedanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GroundingImpedance
		 * 
		 * @return UpdateGroundingImpedanceCommand alias
		 */
	protected UpdateGroundingImpedanceCommand generateUpdateCommand() {
	        UpdateGroundingImpedanceCommand command = new UpdateGroundingImpedanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID groundingImpedanceId = null;
	protected GroundingImpedanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GroundingImpedanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGroundingImpedanceList = 0;
}
