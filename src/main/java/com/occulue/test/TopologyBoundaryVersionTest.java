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
 * Test TopologyBoundaryVersion class.
 *
 * @author your_name_here
 */
public class TopologyBoundaryVersionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TopologyBoundaryVersionTest() {
		subscriber = new TopologyBoundaryVersionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TopologyBoundaryVersionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TopologyBoundaryVersion...");
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
	 * jumpstart the process by instantiating2 TopologyBoundaryVersion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		topologyBoundaryVersionId = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
		.createTopologyBoundaryVersion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
				.createTopologyBoundaryVersion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.topologyBoundaryVersionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TopologyBoundaryVersion : " + successValue.getTopologyBoundaryVersionId());
							  if (successValue.getTopologyBoundaryVersionId().equals(topologyBoundaryVersionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTopologyBoundaryVersionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TopologyBoundaryVersion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologyBoundaryVersion consumed")
					);
			subscriber.topologyBoundaryVersionSubscribe( topologyBoundaryVersionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TopologyBoundaryVersion : " + successValue.getTopologyBoundaryVersionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTopologyBoundaryVersionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologyBoundaryVersion for topologyBoundaryVersionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TopologyBoundaryVersion. 
	 */
	protected TopologyBoundaryVersion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TopologyBoundaryVersion" );

		TopologyBoundaryVersion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TopologyBoundaryVersion with primary key" );
		msg.append( topologyBoundaryVersionId );
		
		TopologyBoundaryVersionFetchOneSummary fetchOneSummary = new TopologyBoundaryVersionFetchOneSummary( topologyBoundaryVersionId );

		try {
			entity = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().getTopologyBoundaryVersion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TopologyBoundaryVersion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TopologyBoundaryVersion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TopologyBoundaryVersion." );

		StringBuilder msg = new StringBuilder( "Failed to update a TopologyBoundaryVersion : " );        
		TopologyBoundaryVersion entity = read();
		UpdateTopologyBoundaryVersionCommand command = generateUpdateCommand();
		command.setTopologyBoundaryVersionId(entity.getTopologyBoundaryVersionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TopologyBoundaryVersion." );

			// for use later on...
			topologyBoundaryVersionId = entity.getTopologyBoundaryVersionId();

			TopologyBoundaryVersionBusinessDelegate proxy = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();  

			proxy.updateTopologyBoundaryVersion( command ).get();

			LOGGER.info( "-- Successfully saved TopologyBoundaryVersion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + topologyBoundaryVersionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TopologyBoundaryVersion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TopologyBoundaryVersion." );

		TopologyBoundaryVersion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TopologyBoundaryVersion with id " + topologyBoundaryVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TopologyBoundaryVersion with id " + topologyBoundaryVersionId );

			throw e;
		}

		try{
			TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().delete( new DeleteTopologyBoundaryVersionCommand( entity.getTopologyBoundaryVersionId() ) ).get();
			LOGGER.info( "-- Successfully deleted TopologyBoundaryVersion with id " + topologyBoundaryVersionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TopologyBoundaryVersion with id " + topologyBoundaryVersionId );

			throw e;
		}
	}

	/**
	 * get all TopologyBoundaryVersions.
	 */
	protected List<TopologyBoundaryVersion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TopologyBoundaryVersions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TopologyBoundaryVersion : " );        
		List<TopologyBoundaryVersion> collection  = new ArrayList<>();

		try {
			// call the static get method on the TopologyBoundaryVersionBusinessDelegate
			collection = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().getAllTopologyBoundaryVersion();
			assertNotNull( collection, "An Empty collection of TopologyBoundaryVersion was incorrectly returned.");
			
			// Now print out the values
			TopologyBoundaryVersion entity = null;            
			Iterator<TopologyBoundaryVersion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTopologyBoundaryVersionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TopologyBoundaryVersionTest
	 */
	protected TopologyBoundaryVersionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TopologyBoundaryVersion
	 * 
	 * @return CreateTopologyBoundaryVersionCommand alias
	 */
	protected CreateTopologyBoundaryVersionCommand generateNewCommand() {
        CreateTopologyBoundaryVersionCommand command = new CreateTopologyBoundaryVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TopologyBoundaryVersion
		 * 
		 * @return UpdateTopologyBoundaryVersionCommand alias
		 */
	protected UpdateTopologyBoundaryVersionCommand generateUpdateCommand() {
	        UpdateTopologyBoundaryVersionCommand command = new UpdateTopologyBoundaryVersionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID topologyBoundaryVersionId = null;
	protected TopologyBoundaryVersionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TopologyBoundaryVersionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTopologyBoundaryVersionList = 0;
}
