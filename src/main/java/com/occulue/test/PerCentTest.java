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
 * Test PerCent class.
 *
 * @author your_name_here
 */
public class PerCentTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PerCentTest() {
		subscriber = new PerCentSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PerCentTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PerCent...");
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
	 * jumpstart the process by instantiating2 PerCent
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		perCentId = PerCentBusinessDelegate.getPerCentInstance()
		.createPerCent( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PerCentBusinessDelegate.getPerCentInstance()
				.createPerCent( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.perCentSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PerCent : " + successValue.getPerCentId());
							  if (successValue.getPerCentId().equals(perCentId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPerCentList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PerCent test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on perCent consumed")
					);
			subscriber.perCentSubscribe( perCentId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PerCent : " + successValue.getPerCentId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPerCentList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on perCent for perCentId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PerCent. 
	 */
	protected PerCent read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PerCent" );

		PerCent entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PerCent with primary key" );
		msg.append( perCentId );
		
		PerCentFetchOneSummary fetchOneSummary = new PerCentFetchOneSummary( perCentId );

		try {
			entity = PerCentBusinessDelegate.getPerCentInstance().getPerCent( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PerCent " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PerCent.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PerCent." );

		StringBuilder msg = new StringBuilder( "Failed to update a PerCent : " );        
		PerCent entity = read();
		UpdatePerCentCommand command = generateUpdateCommand();
		command.setPerCentId(entity.getPerCentId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PerCent." );

			// for use later on...
			perCentId = entity.getPerCentId();

			PerCentBusinessDelegate proxy = PerCentBusinessDelegate.getPerCentInstance();  

			proxy.updatePerCent( command ).get();

			LOGGER.info( "-- Successfully saved PerCent - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + perCentId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PerCent.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PerCent." );

		PerCent entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PerCent with id " + perCentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PerCent with id " + perCentId );

			throw e;
		}

		try{
			PerCentBusinessDelegate.getPerCentInstance().delete( new DeletePerCentCommand( entity.getPerCentId() ) ).get();
			LOGGER.info( "-- Successfully deleted PerCent with id " + perCentId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PerCent with id " + perCentId );

			throw e;
		}
	}

	/**
	 * get all PerCents.
	 */
	protected List<PerCent> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PerCents:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PerCent : " );        
		List<PerCent> collection  = new ArrayList<>();

		try {
			// call the static get method on the PerCentBusinessDelegate
			collection = PerCentBusinessDelegate.getPerCentInstance().getAllPerCent();
			assertNotNull( collection, "An Empty collection of PerCent was incorrectly returned.");
			
			// Now print out the values
			PerCent entity = null;            
			Iterator<PerCent> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPerCentId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PerCentTest
	 */
	protected PerCentTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PerCent
	 * 
	 * @return CreatePerCentCommand alias
	 */
	protected CreatePerCentCommand generateNewCommand() {
        CreatePerCentCommand command = new CreatePerCentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PerCent
		 * 
		 * @return UpdatePerCentCommand alias
		 */
	protected UpdatePerCentCommand generateUpdateCommand() {
	        UpdatePerCentCommand command = new UpdatePerCentCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID perCentId = null;
	protected PerCentSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PerCentTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPerCentList = 0;
}
