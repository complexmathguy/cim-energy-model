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
 * Test ReactivePower class.
 *
 * @author your_name_here
 */
public class ReactivePowerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ReactivePowerTest() {
		subscriber = new ReactivePowerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ReactivePowerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ReactivePower...");
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
	 * jumpstart the process by instantiating2 ReactivePower
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		reactivePowerId = ReactivePowerBusinessDelegate.getReactivePowerInstance()
		.createReactivePower( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ReactivePowerBusinessDelegate.getReactivePowerInstance()
				.createReactivePower( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.reactivePowerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ReactivePower : " + successValue.getReactivePowerId());
							  if (successValue.getReactivePowerId().equals(reactivePowerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfReactivePowerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ReactivePower test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactivePower consumed")
					);
			subscriber.reactivePowerSubscribe( reactivePowerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ReactivePower : " + successValue.getReactivePowerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfReactivePowerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reactivePower for reactivePowerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ReactivePower. 
	 */
	protected ReactivePower read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ReactivePower" );

		ReactivePower entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ReactivePower with primary key" );
		msg.append( reactivePowerId );
		
		ReactivePowerFetchOneSummary fetchOneSummary = new ReactivePowerFetchOneSummary( reactivePowerId );

		try {
			entity = ReactivePowerBusinessDelegate.getReactivePowerInstance().getReactivePower( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ReactivePower " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ReactivePower.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ReactivePower." );

		StringBuilder msg = new StringBuilder( "Failed to update a ReactivePower : " );        
		ReactivePower entity = read();
		UpdateReactivePowerCommand command = generateUpdateCommand();
		command.setReactivePowerId(entity.getReactivePowerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ReactivePower." );

			// for use later on...
			reactivePowerId = entity.getReactivePowerId();

			ReactivePowerBusinessDelegate proxy = ReactivePowerBusinessDelegate.getReactivePowerInstance();  

			proxy.updateReactivePower( command ).get();

			LOGGER.info( "-- Successfully saved ReactivePower - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + reactivePowerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ReactivePower.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ReactivePower." );

		ReactivePower entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ReactivePower with id " + reactivePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ReactivePower with id " + reactivePowerId );

			throw e;
		}

		try{
			ReactivePowerBusinessDelegate.getReactivePowerInstance().delete( new DeleteReactivePowerCommand( entity.getReactivePowerId() ) ).get();
			LOGGER.info( "-- Successfully deleted ReactivePower with id " + reactivePowerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ReactivePower with id " + reactivePowerId );

			throw e;
		}
	}

	/**
	 * get all ReactivePowers.
	 */
	protected List<ReactivePower> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ReactivePowers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ReactivePower : " );        
		List<ReactivePower> collection  = new ArrayList<>();

		try {
			// call the static get method on the ReactivePowerBusinessDelegate
			collection = ReactivePowerBusinessDelegate.getReactivePowerInstance().getAllReactivePower();
			assertNotNull( collection, "An Empty collection of ReactivePower was incorrectly returned.");
			
			// Now print out the values
			ReactivePower entity = null;            
			Iterator<ReactivePower> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getReactivePowerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ReactivePowerTest
	 */
	protected ReactivePowerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ReactivePower
	 * 
	 * @return CreateReactivePowerCommand alias
	 */
	protected CreateReactivePowerCommand generateNewCommand() {
        CreateReactivePowerCommand command = new CreateReactivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ReactivePower
		 * 
		 * @return UpdateReactivePowerCommand alias
		 */
	protected UpdateReactivePowerCommand generateUpdateCommand() {
	        UpdateReactivePowerCommand command = new UpdateReactivePowerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID reactivePowerId = null;
	protected ReactivePowerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ReactivePowerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfReactivePowerList = 0;
}
