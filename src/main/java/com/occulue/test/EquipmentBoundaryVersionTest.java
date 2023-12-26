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
 * Test EquipmentBoundaryVersion class.
 *
 * @author your_name_here
 */
public class EquipmentBoundaryVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquipmentBoundaryVersionTest() {
		subscriber = new EquipmentBoundaryVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquipmentBoundaryVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquipmentBoundaryVersion...");
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
	 * jumpstart the process by instantiating2 EquipmentBoundaryVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equipmentBoundaryVersionId = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
		.createEquipmentBoundaryVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
				.createEquipmentBoundaryVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equipmentBoundaryVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquipmentBoundaryVersion : " + successValue.getEquipmentBoundaryVersionId());
							  if (successValue.getEquipmentBoundaryVersionId().equals(equipmentBoundaryVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquipmentBoundaryVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquipmentBoundaryVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentBoundaryVersion consumed")
					);
			subscriber.equipmentBoundaryVersionSubscribe( equipmentBoundaryVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquipmentBoundaryVersion : " + successValue.getEquipmentBoundaryVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquipmentBoundaryVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentBoundaryVersion for equipmentBoundaryVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquipmentBoundaryVersion. 
	 */
	protected EquipmentBoundaryVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquipmentBoundaryVersion" );

		EquipmentBoundaryVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquipmentBoundaryVersion with primary key" );
		msg.append( equipmentBoundaryVersionId );
		
		EquipmentBoundaryVersionFetchOneSummary fetchOneSummary = new EquipmentBoundaryVersionFetchOneSummary( equipmentBoundaryVersionId );

		try {
			entity = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().getEquipmentBoundaryVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquipmentBoundaryVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquipmentBoundaryVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquipmentBoundaryVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquipmentBoundaryVersion : " );        
		EquipmentBoundaryVersion entity = read();
		UpdateEquipmentBoundaryVersionCommand command = generateUpdateCommand();
		command.setEquipmentBoundaryVersionId(entity.getEquipmentBoundaryVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquipmentBoundaryVersion." );

			// for use later on...
			equipmentBoundaryVersionId = entity.getEquipmentBoundaryVersionId();

			EquipmentBoundaryVersionBusinessDelegate proxy = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();  

			proxy.updateEquipmentBoundaryVersion( command ).get();

			LOGGER.info( "-- Successfully saved EquipmentBoundaryVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equipmentBoundaryVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquipmentBoundaryVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquipmentBoundaryVersion." );

		EquipmentBoundaryVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquipmentBoundaryVersion with id " + equipmentBoundaryVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquipmentBoundaryVersion with id " + equipmentBoundaryVersionId );

			throw e;
		}

		try{
			EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().delete( new DeleteEquipmentBoundaryVersionCommand( entity.getEquipmentBoundaryVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquipmentBoundaryVersion with id " + equipmentBoundaryVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquipmentBoundaryVersion with id " + equipmentBoundaryVersionId );

			throw e;
		}
	}

	/**
	 * get all EquipmentBoundaryVersions.
	 */
	protected List<EquipmentBoundaryVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquipmentBoundaryVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquipmentBoundaryVersion : " );        
		List<EquipmentBoundaryVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquipmentBoundaryVersionBusinessDelegate
			collection = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().getAllEquipmentBoundaryVersion();
			assertNotNull( collection, "An Empty collection of EquipmentBoundaryVersion was incorrectly returned.");
			
			// Now print out the values
			EquipmentBoundaryVersion entity = null;            
			Iterator<EquipmentBoundaryVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquipmentBoundaryVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquipmentBoundaryVersionTest
	 */
	protected EquipmentBoundaryVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquipmentBoundaryVersion
	 * 
	 * @return CreateEquipmentBoundaryVersionCommand alias
	 */
	protected CreateEquipmentBoundaryVersionCommand generateNewCommand() {
        CreateEquipmentBoundaryVersionCommand command = new CreateEquipmentBoundaryVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EquipmentBoundaryVersion
		 * 
		 * @return UpdateEquipmentBoundaryVersionCommand alias
		 */
	protected UpdateEquipmentBoundaryVersionCommand generateUpdateCommand() {
	        UpdateEquipmentBoundaryVersionCommand command = new UpdateEquipmentBoundaryVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equipmentBoundaryVersionId = null;
	protected EquipmentBoundaryVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquipmentBoundaryVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquipmentBoundaryVersionList = 0;
}
