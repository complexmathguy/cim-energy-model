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
 * Test EquipmentVersion class.
 *
 * @author your_name_here
 */
public class EquipmentVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquipmentVersionTest() {
		subscriber = new EquipmentVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquipmentVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquipmentVersion...");
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
	 * jumpstart the process by instantiating2 EquipmentVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equipmentVersionId = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
		.createEquipmentVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquipmentVersionBusinessDelegate.getEquipmentVersionInstance()
				.createEquipmentVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equipmentVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquipmentVersion : " + successValue.getEquipmentVersionId());
							  if (successValue.getEquipmentVersionId().equals(equipmentVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquipmentVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquipmentVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentVersion consumed")
					);
			subscriber.equipmentVersionSubscribe( equipmentVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquipmentVersion : " + successValue.getEquipmentVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquipmentVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentVersion for equipmentVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquipmentVersion. 
	 */
	protected EquipmentVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquipmentVersion" );

		EquipmentVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquipmentVersion with primary key" );
		msg.append( equipmentVersionId );
		
		EquipmentVersionFetchOneSummary fetchOneSummary = new EquipmentVersionFetchOneSummary( equipmentVersionId );

		try {
			entity = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().getEquipmentVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquipmentVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquipmentVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquipmentVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquipmentVersion : " );        
		EquipmentVersion entity = read();
		UpdateEquipmentVersionCommand command = generateUpdateCommand();
		command.setEquipmentVersionId(entity.getEquipmentVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquipmentVersion." );

			// for use later on...
			equipmentVersionId = entity.getEquipmentVersionId();

			EquipmentVersionBusinessDelegate proxy = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance();  

			proxy.updateEquipmentVersion( command ).get();

			LOGGER.info( "-- Successfully saved EquipmentVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equipmentVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquipmentVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquipmentVersion." );

		EquipmentVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquipmentVersion with id " + equipmentVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquipmentVersion with id " + equipmentVersionId );

			throw e;
		}

		try{
			EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().delete( new DeleteEquipmentVersionCommand( entity.getEquipmentVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquipmentVersion with id " + equipmentVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquipmentVersion with id " + equipmentVersionId );

			throw e;
		}
	}

	/**
	 * get all EquipmentVersions.
	 */
	protected List<EquipmentVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquipmentVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquipmentVersion : " );        
		List<EquipmentVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquipmentVersionBusinessDelegate
			collection = EquipmentVersionBusinessDelegate.getEquipmentVersionInstance().getAllEquipmentVersion();
			assertNotNull( collection, "An Empty collection of EquipmentVersion was incorrectly returned.");
			
			// Now print out the values
			EquipmentVersion entity = null;            
			Iterator<EquipmentVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquipmentVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquipmentVersionTest
	 */
	protected EquipmentVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquipmentVersion
	 * 
	 * @return CreateEquipmentVersionCommand alias
	 */
	protected CreateEquipmentVersionCommand generateNewCommand() {
        CreateEquipmentVersionCommand command = new CreateEquipmentVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EquipmentVersion
		 * 
		 * @return UpdateEquipmentVersionCommand alias
		 */
	protected UpdateEquipmentVersionCommand generateUpdateCommand() {
	        UpdateEquipmentVersionCommand command = new UpdateEquipmentVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equipmentVersionId = null;
	protected EquipmentVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquipmentVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquipmentVersionList = 0;
}
