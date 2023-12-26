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
 * Test TopologyVersion class.
 *
 * @author your_name_here
 */
public class TopologyVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TopologyVersionTest() {
		subscriber = new TopologyVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TopologyVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TopologyVersion...");
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
	 * jumpstart the process by instantiating2 TopologyVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		topologyVersionId = TopologyVersionBusinessDelegate.getTopologyVersionInstance()
		.createTopologyVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TopologyVersionBusinessDelegate.getTopologyVersionInstance()
				.createTopologyVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.topologyVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TopologyVersion : " + successValue.getTopologyVersionId());
							  if (successValue.getTopologyVersionId().equals(topologyVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTopologyVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TopologyVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologyVersion consumed")
					);
			subscriber.topologyVersionSubscribe( topologyVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TopologyVersion : " + successValue.getTopologyVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTopologyVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologyVersion for topologyVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TopologyVersion. 
	 */
	protected TopologyVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TopologyVersion" );

		TopologyVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TopologyVersion with primary key" );
		msg.append( topologyVersionId );
		
		TopologyVersionFetchOneSummary fetchOneSummary = new TopologyVersionFetchOneSummary( topologyVersionId );

		try {
			entity = TopologyVersionBusinessDelegate.getTopologyVersionInstance().getTopologyVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TopologyVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TopologyVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TopologyVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a TopologyVersion : " );        
		TopologyVersion entity = read();
		UpdateTopologyVersionCommand command = generateUpdateCommand();
		command.setTopologyVersionId(entity.getTopologyVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TopologyVersion." );

			// for use later on...
			topologyVersionId = entity.getTopologyVersionId();

			TopologyVersionBusinessDelegate proxy = TopologyVersionBusinessDelegate.getTopologyVersionInstance();  

			proxy.updateTopologyVersion( command ).get();

			LOGGER.info( "-- Successfully saved TopologyVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + topologyVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TopologyVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TopologyVersion." );

		TopologyVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TopologyVersion with id " + topologyVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TopologyVersion with id " + topologyVersionId );

			throw e;
		}

		try{
			TopologyVersionBusinessDelegate.getTopologyVersionInstance().delete( new DeleteTopologyVersionCommand( entity.getTopologyVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted TopologyVersion with id " + topologyVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TopologyVersion with id " + topologyVersionId );

			throw e;
		}
	}

	/**
	 * get all TopologyVersions.
	 */
	protected List<TopologyVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TopologyVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TopologyVersion : " );        
		List<TopologyVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the TopologyVersionBusinessDelegate
			collection = TopologyVersionBusinessDelegate.getTopologyVersionInstance().getAllTopologyVersion();
			assertNotNull( collection, "An Empty collection of TopologyVersion was incorrectly returned.");
			
			// Now print out the values
			TopologyVersion entity = null;            
			Iterator<TopologyVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTopologyVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TopologyVersionTest
	 */
	protected TopologyVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TopologyVersion
	 * 
	 * @return CreateTopologyVersionCommand alias
	 */
	protected CreateTopologyVersionCommand generateNewCommand() {
        CreateTopologyVersionCommand command = new CreateTopologyVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TopologyVersion
		 * 
		 * @return UpdateTopologyVersionCommand alias
		 */
	protected UpdateTopologyVersionCommand generateUpdateCommand() {
	        UpdateTopologyVersionCommand command = new UpdateTopologyVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID topologyVersionId = null;
	protected TopologyVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TopologyVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTopologyVersionList = 0;
}
