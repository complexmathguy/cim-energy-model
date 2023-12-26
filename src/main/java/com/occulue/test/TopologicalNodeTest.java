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
 * Test TopologicalNode class.
 *
 * @author your_name_here
 */
public class TopologicalNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TopologicalNodeTest() {
		subscriber = new TopologicalNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TopologicalNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TopologicalNode...");
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
	 * jumpstart the process by instantiating2 TopologicalNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		topologicalNodeId = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
		.createTopologicalNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
				.createTopologicalNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.topologicalNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TopologicalNode : " + successValue.getTopologicalNodeId());
							  if (successValue.getTopologicalNodeId().equals(topologicalNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTopologicalNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TopologicalNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologicalNode consumed")
					);
			subscriber.topologicalNodeSubscribe( topologicalNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TopologicalNode : " + successValue.getTopologicalNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTopologicalNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on topologicalNode for topologicalNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TopologicalNode. 
	 */
	protected TopologicalNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TopologicalNode" );

		TopologicalNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TopologicalNode with primary key" );
		msg.append( topologicalNodeId );
		
		TopologicalNodeFetchOneSummary fetchOneSummary = new TopologicalNodeFetchOneSummary( topologicalNodeId );

		try {
			entity = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().getTopologicalNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TopologicalNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TopologicalNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TopologicalNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a TopologicalNode : " );        
		TopologicalNode entity = read();
		UpdateTopologicalNodeCommand command = generateUpdateCommand();
		command.setTopologicalNodeId(entity.getTopologicalNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TopologicalNode." );

			// for use later on...
			topologicalNodeId = entity.getTopologicalNodeId();

			TopologicalNodeBusinessDelegate proxy = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();  

			proxy.updateTopologicalNode( command ).get();

			LOGGER.info( "-- Successfully saved TopologicalNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + topologicalNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TopologicalNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TopologicalNode." );

		TopologicalNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TopologicalNode with id " + topologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TopologicalNode with id " + topologicalNodeId );

			throw e;
		}

		try{
			TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().delete( new DeleteTopologicalNodeCommand( entity.getTopologicalNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted TopologicalNode with id " + topologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TopologicalNode with id " + topologicalNodeId );

			throw e;
		}
	}

	/**
	 * get all TopologicalNodes.
	 */
	protected List<TopologicalNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TopologicalNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TopologicalNode : " );        
		List<TopologicalNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the TopologicalNodeBusinessDelegate
			collection = TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().getAllTopologicalNode();
			assertNotNull( collection, "An Empty collection of TopologicalNode was incorrectly returned.");
			
			// Now print out the values
			TopologicalNode entity = null;            
			Iterator<TopologicalNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTopologicalNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TopologicalNodeTest
	 */
	protected TopologicalNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TopologicalNode
	 * 
	 * @return CreateTopologicalNodeCommand alias
	 */
	protected CreateTopologicalNodeCommand generateNewCommand() {
        CreateTopologicalNodeCommand command = new CreateTopologicalNodeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TopologicalNode
		 * 
		 * @return UpdateTopologicalNodeCommand alias
		 */
	protected UpdateTopologicalNodeCommand generateUpdateCommand() {
	        UpdateTopologicalNodeCommand command = new UpdateTopologicalNodeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID topologicalNodeId = null;
	protected TopologicalNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TopologicalNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTopologicalNodeList = 0;
}
