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
 * Test IdentifiedObject class.
 *
 * @author your_name_here
 */
public class IdentifiedObjectTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public IdentifiedObjectTest() {
		subscriber = new IdentifiedObjectSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate IdentifiedObjectTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on IdentifiedObject...");
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
	 * jumpstart the process by instantiating2 IdentifiedObject
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		identifiedObjectId = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
		.createIdentifiedObject( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
				.createIdentifiedObject( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.identifiedObjectSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for IdentifiedObject : " + successValue.getIdentifiedObjectId());
							  if (successValue.getIdentifiedObjectId().equals(identifiedObjectId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfIdentifiedObjectList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("IdentifiedObject test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on identifiedObject consumed")
					);
			subscriber.identifiedObjectSubscribe( identifiedObjectId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for IdentifiedObject : " + successValue.getIdentifiedObjectId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfIdentifiedObjectList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on identifiedObject for identifiedObjectId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a IdentifiedObject. 
	 */
	protected IdentifiedObject read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created IdentifiedObject" );

		IdentifiedObject entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read IdentifiedObject with primary key" );
		msg.append( identifiedObjectId );
		
		IdentifiedObjectFetchOneSummary fetchOneSummary = new IdentifiedObjectFetchOneSummary( identifiedObjectId );

		try {
			entity = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().getIdentifiedObject( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found IdentifiedObject " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a IdentifiedObject.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a IdentifiedObject." );

		StringBuilder msg = new StringBuilder( "Failed to update a IdentifiedObject : " );        
		IdentifiedObject entity = read();
		UpdateIdentifiedObjectCommand command = generateUpdateCommand();
		command.setIdentifiedObjectId(entity.getIdentifiedObjectId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created IdentifiedObject." );

			// for use later on...
			identifiedObjectId = entity.getIdentifiedObjectId();

			IdentifiedObjectBusinessDelegate proxy = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();  

			proxy.updateIdentifiedObject( command ).get();

			LOGGER.info( "-- Successfully saved IdentifiedObject - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + identifiedObjectId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a IdentifiedObject.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created IdentifiedObject." );

		IdentifiedObject entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read IdentifiedObject with id " + identifiedObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read IdentifiedObject with id " + identifiedObjectId );

			throw e;
		}

		try{
			IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().delete( new DeleteIdentifiedObjectCommand( entity.getIdentifiedObjectId() ) ).get();
			LOGGER.info( "-- Successfully deleted IdentifiedObject with id " + identifiedObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete IdentifiedObject with id " + identifiedObjectId );

			throw e;
		}
	}

	/**
	 * get all IdentifiedObjects.
	 */
	protected List<IdentifiedObject> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of IdentifiedObjects:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all IdentifiedObject : " );        
		List<IdentifiedObject> collection  = new ArrayList<>();

		try {
			// call the static get method on the IdentifiedObjectBusinessDelegate
			collection = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().getAllIdentifiedObject();
			assertNotNull( collection, "An Empty collection of IdentifiedObject was incorrectly returned.");
			
			// Now print out the values
			IdentifiedObject entity = null;            
			Iterator<IdentifiedObject> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getIdentifiedObjectId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		IdentifiedObjectTest
	 */
	protected IdentifiedObjectTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated IdentifiedObject
	 * 
	 * @return CreateIdentifiedObjectCommand alias
	 */
	protected CreateIdentifiedObjectCommand generateNewCommand() {
        CreateIdentifiedObjectCommand command = new CreateIdentifiedObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated IdentifiedObject
		 * 
		 * @return UpdateIdentifiedObjectCommand alias
		 */
	protected UpdateIdentifiedObjectCommand generateUpdateCommand() {
	        UpdateIdentifiedObjectCommand command = new UpdateIdentifiedObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID identifiedObjectId = null;
	protected IdentifiedObjectSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(IdentifiedObjectTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfIdentifiedObjectList = 0;
}
