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
 * Test EquivalentInjection class.
 *
 * @author your_name_here
 */
public class EquivalentInjectionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquivalentInjectionTest() {
		subscriber = new EquivalentInjectionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquivalentInjectionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquivalentInjection...");
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
	 * jumpstart the process by instantiating2 EquivalentInjection
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equivalentInjectionId = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
		.createEquivalentInjection( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance()
				.createEquivalentInjection( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equivalentInjectionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquivalentInjection : " + successValue.getEquivalentInjectionId());
							  if (successValue.getEquivalentInjectionId().equals(equivalentInjectionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquivalentInjectionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquivalentInjection test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentInjection consumed")
					);
			subscriber.equivalentInjectionSubscribe( equivalentInjectionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquivalentInjection : " + successValue.getEquivalentInjectionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquivalentInjectionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentInjection for equivalentInjectionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquivalentInjection. 
	 */
	protected EquivalentInjection read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquivalentInjection" );

		EquivalentInjection entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquivalentInjection with primary key" );
		msg.append( equivalentInjectionId );
		
		EquivalentInjectionFetchOneSummary fetchOneSummary = new EquivalentInjectionFetchOneSummary( equivalentInjectionId );

		try {
			entity = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().getEquivalentInjection( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquivalentInjection " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquivalentInjection.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquivalentInjection." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquivalentInjection : " );        
		EquivalentInjection entity = read();
		UpdateEquivalentInjectionCommand command = generateUpdateCommand();
		command.setEquivalentInjectionId(entity.getEquivalentInjectionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquivalentInjection." );

			// for use later on...
			equivalentInjectionId = entity.getEquivalentInjectionId();

			EquivalentInjectionBusinessDelegate proxy = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance();  

			proxy.updateEquivalentInjection( command ).get();

			LOGGER.info( "-- Successfully saved EquivalentInjection - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equivalentInjectionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquivalentInjection.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquivalentInjection." );

		EquivalentInjection entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquivalentInjection with id " + equivalentInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquivalentInjection with id " + equivalentInjectionId );

			throw e;
		}

		try{
			EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().delete( new DeleteEquivalentInjectionCommand( entity.getEquivalentInjectionId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquivalentInjection with id " + equivalentInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquivalentInjection with id " + equivalentInjectionId );

			throw e;
		}
	}

	/**
	 * get all EquivalentInjections.
	 */
	protected List<EquivalentInjection> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquivalentInjections:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquivalentInjection : " );        
		List<EquivalentInjection> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquivalentInjectionBusinessDelegate
			collection = EquivalentInjectionBusinessDelegate.getEquivalentInjectionInstance().getAllEquivalentInjection();
			assertNotNull( collection, "An Empty collection of EquivalentInjection was incorrectly returned.");
			
			// Now print out the values
			EquivalentInjection entity = null;            
			Iterator<EquivalentInjection> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquivalentInjectionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquivalentInjectionTest
	 */
	protected EquivalentInjectionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquivalentInjection
	 * 
	 * @return CreateEquivalentInjectionCommand alias
	 */
	protected CreateEquivalentInjectionCommand generateNewCommand() {
        CreateEquivalentInjectionCommand command = new CreateEquivalentInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EquivalentInjection
		 * 
		 * @return UpdateEquivalentInjectionCommand alias
		 */
	protected UpdateEquivalentInjectionCommand generateUpdateCommand() {
	        UpdateEquivalentInjectionCommand command = new UpdateEquivalentInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equivalentInjectionId = null;
	protected EquivalentInjectionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquivalentInjectionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquivalentInjectionList = 0;
}
