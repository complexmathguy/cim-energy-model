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
 * Test BoundaryExtensions class.
 *
 * @author your_name_here
 */
public class BoundaryExtensionsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BoundaryExtensionsTest() {
		subscriber = new BoundaryExtensionsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BoundaryExtensionsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BoundaryExtensions...");
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
	 * jumpstart the process by instantiating2 BoundaryExtensions
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		boundaryExtensionsId = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
		.createBoundaryExtensions( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
				.createBoundaryExtensions( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.boundaryExtensionsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BoundaryExtensions : " + successValue.getBoundaryExtensionsId());
							  if (successValue.getBoundaryExtensionsId().equals(boundaryExtensionsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBoundaryExtensionsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BoundaryExtensions test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on boundaryExtensions consumed")
					);
			subscriber.boundaryExtensionsSubscribe( boundaryExtensionsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BoundaryExtensions : " + successValue.getBoundaryExtensionsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBoundaryExtensionsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on boundaryExtensions for boundaryExtensionsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BoundaryExtensions. 
	 */
	protected BoundaryExtensions read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BoundaryExtensions" );

		BoundaryExtensions entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BoundaryExtensions with primary key" );
		msg.append( boundaryExtensionsId );
		
		BoundaryExtensionsFetchOneSummary fetchOneSummary = new BoundaryExtensionsFetchOneSummary( boundaryExtensionsId );

		try {
			entity = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().getBoundaryExtensions( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BoundaryExtensions " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BoundaryExtensions.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BoundaryExtensions." );

		StringBuilder msg = new StringBuilder( "Failed to update a BoundaryExtensions : " );        
		BoundaryExtensions entity = read();
		UpdateBoundaryExtensionsCommand command = generateUpdateCommand();
		command.setBoundaryExtensionsId(entity.getBoundaryExtensionsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BoundaryExtensions." );

			// for use later on...
			boundaryExtensionsId = entity.getBoundaryExtensionsId();

			BoundaryExtensionsBusinessDelegate proxy = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();  

			proxy.updateBoundaryExtensions( command ).get();

			LOGGER.info( "-- Successfully saved BoundaryExtensions - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + boundaryExtensionsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BoundaryExtensions.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BoundaryExtensions." );

		BoundaryExtensions entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BoundaryExtensions with id " + boundaryExtensionsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BoundaryExtensions with id " + boundaryExtensionsId );

			throw e;
		}

		try{
			BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().delete( new DeleteBoundaryExtensionsCommand( entity.getBoundaryExtensionsId() ) ).get();
			LOGGER.info( "-- Successfully deleted BoundaryExtensions with id " + boundaryExtensionsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BoundaryExtensions with id " + boundaryExtensionsId );

			throw e;
		}
	}

	/**
	 * get all BoundaryExtensionss.
	 */
	protected List<BoundaryExtensions> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BoundaryExtensionss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BoundaryExtensions : " );        
		List<BoundaryExtensions> collection  = new ArrayList<>();

		try {
			// call the static get method on the BoundaryExtensionsBusinessDelegate
			collection = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().getAllBoundaryExtensions();
			assertNotNull( collection, "An Empty collection of BoundaryExtensions was incorrectly returned.");
			
			// Now print out the values
			BoundaryExtensions entity = null;            
			Iterator<BoundaryExtensions> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBoundaryExtensionsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BoundaryExtensionsTest
	 */
	protected BoundaryExtensionsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BoundaryExtensions
	 * 
	 * @return CreateBoundaryExtensionsCommand alias
	 */
	protected CreateBoundaryExtensionsCommand generateNewCommand() {
        CreateBoundaryExtensionsCommand command = new CreateBoundaryExtensionsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated BoundaryExtensions
		 * 
		 * @return UpdateBoundaryExtensionsCommand alias
		 */
	protected UpdateBoundaryExtensionsCommand generateUpdateCommand() {
	        UpdateBoundaryExtensionsCommand command = new UpdateBoundaryExtensionsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID boundaryExtensionsId = null;
	protected BoundaryExtensionsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BoundaryExtensionsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBoundaryExtensionsList = 0;
}
