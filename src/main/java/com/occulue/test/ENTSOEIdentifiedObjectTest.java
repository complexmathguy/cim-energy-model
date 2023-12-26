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
 * Test ENTSOEIdentifiedObject class.
 *
 * @author your_name_here
 */
public class ENTSOEIdentifiedObjectTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ENTSOEIdentifiedObjectTest() {
		subscriber = new ENTSOEIdentifiedObjectSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ENTSOEIdentifiedObjectTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ENTSOEIdentifiedObject...");
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
	 * jumpstart the process by instantiating2 ENTSOEIdentifiedObject
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		eNTSOEIdentifiedObjectId = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
		.createENTSOEIdentifiedObject( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
				.createENTSOEIdentifiedObject( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.eNTSOEIdentifiedObjectSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ENTSOEIdentifiedObject : " + successValue.getENTSOEIdentifiedObjectId());
							  if (successValue.getENTSOEIdentifiedObjectId().equals(eNTSOEIdentifiedObjectId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfENTSOEIdentifiedObjectList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ENTSOEIdentifiedObject test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEIdentifiedObject consumed")
					);
			subscriber.eNTSOEIdentifiedObjectSubscribe( eNTSOEIdentifiedObjectId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ENTSOEIdentifiedObject : " + successValue.getENTSOEIdentifiedObjectId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfENTSOEIdentifiedObjectList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEIdentifiedObject for eNTSOEIdentifiedObjectId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ENTSOEIdentifiedObject. 
	 */
	protected ENTSOEIdentifiedObject read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ENTSOEIdentifiedObject" );

		ENTSOEIdentifiedObject entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ENTSOEIdentifiedObject with primary key" );
		msg.append( eNTSOEIdentifiedObjectId );
		
		ENTSOEIdentifiedObjectFetchOneSummary fetchOneSummary = new ENTSOEIdentifiedObjectFetchOneSummary( eNTSOEIdentifiedObjectId );

		try {
			entity = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().getENTSOEIdentifiedObject( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ENTSOEIdentifiedObject " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ENTSOEIdentifiedObject.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ENTSOEIdentifiedObject." );

		StringBuilder msg = new StringBuilder( "Failed to update a ENTSOEIdentifiedObject : " );        
		ENTSOEIdentifiedObject entity = read();
		UpdateENTSOEIdentifiedObjectCommand command = generateUpdateCommand();
		command.setENTSOEIdentifiedObjectId(entity.getENTSOEIdentifiedObjectId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ENTSOEIdentifiedObject." );

			// for use later on...
			eNTSOEIdentifiedObjectId = entity.getENTSOEIdentifiedObjectId();

			ENTSOEIdentifiedObjectBusinessDelegate proxy = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance();  

			proxy.updateENTSOEIdentifiedObject( command ).get();

			LOGGER.info( "-- Successfully saved ENTSOEIdentifiedObject - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + eNTSOEIdentifiedObjectId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ENTSOEIdentifiedObject.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ENTSOEIdentifiedObject." );

		ENTSOEIdentifiedObject entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ENTSOEIdentifiedObject with id " + eNTSOEIdentifiedObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ENTSOEIdentifiedObject with id " + eNTSOEIdentifiedObjectId );

			throw e;
		}

		try{
			ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().delete( new DeleteENTSOEIdentifiedObjectCommand( entity.getENTSOEIdentifiedObjectId() ) ).get();
			LOGGER.info( "-- Successfully deleted ENTSOEIdentifiedObject with id " + eNTSOEIdentifiedObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ENTSOEIdentifiedObject with id " + eNTSOEIdentifiedObjectId );

			throw e;
		}
	}

	/**
	 * get all ENTSOEIdentifiedObjects.
	 */
	protected List<ENTSOEIdentifiedObject> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ENTSOEIdentifiedObjects:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ENTSOEIdentifiedObject : " );        
		List<ENTSOEIdentifiedObject> collection  = new ArrayList<>();

		try {
			// call the static get method on the ENTSOEIdentifiedObjectBusinessDelegate
			collection = ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance().getAllENTSOEIdentifiedObject();
			assertNotNull( collection, "An Empty collection of ENTSOEIdentifiedObject was incorrectly returned.");
			
			// Now print out the values
			ENTSOEIdentifiedObject entity = null;            
			Iterator<ENTSOEIdentifiedObject> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getENTSOEIdentifiedObjectId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ENTSOEIdentifiedObjectTest
	 */
	protected ENTSOEIdentifiedObjectTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ENTSOEIdentifiedObject
	 * 
	 * @return CreateENTSOEIdentifiedObjectCommand alias
	 */
	protected CreateENTSOEIdentifiedObjectCommand generateNewCommand() {
        CreateENTSOEIdentifiedObjectCommand command = new CreateENTSOEIdentifiedObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ENTSOEIdentifiedObject
		 * 
		 * @return UpdateENTSOEIdentifiedObjectCommand alias
		 */
	protected UpdateENTSOEIdentifiedObjectCommand generateUpdateCommand() {
	        UpdateENTSOEIdentifiedObjectCommand command = new UpdateENTSOEIdentifiedObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID eNTSOEIdentifiedObjectId = null;
	protected ENTSOEIdentifiedObjectSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ENTSOEIdentifiedObjectTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfENTSOEIdentifiedObjectList = 0;
}
