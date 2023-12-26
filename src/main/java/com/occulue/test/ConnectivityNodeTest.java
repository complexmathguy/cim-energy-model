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
 * Test ConnectivityNode class.
 *
 * @author your_name_here
 */
public class ConnectivityNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConnectivityNodeTest() {
		subscriber = new ConnectivityNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConnectivityNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConnectivityNode...");
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
	 * jumpstart the process by instantiating2 ConnectivityNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		connectivityNodeId = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
		.createConnectivityNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
				.createConnectivityNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.connectivityNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConnectivityNode : " + successValue.getConnectivityNodeId());
							  if (successValue.getConnectivityNodeId().equals(connectivityNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConnectivityNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConnectivityNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connectivityNode consumed")
					);
			subscriber.connectivityNodeSubscribe( connectivityNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConnectivityNode : " + successValue.getConnectivityNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConnectivityNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connectivityNode for connectivityNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConnectivityNode. 
	 */
	protected ConnectivityNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConnectivityNode" );

		ConnectivityNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConnectivityNode with primary key" );
		msg.append( connectivityNodeId );
		
		ConnectivityNodeFetchOneSummary fetchOneSummary = new ConnectivityNodeFetchOneSummary( connectivityNodeId );

		try {
			entity = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().getConnectivityNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConnectivityNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConnectivityNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConnectivityNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConnectivityNode : " );        
		ConnectivityNode entity = read();
		UpdateConnectivityNodeCommand command = generateUpdateCommand();
		command.setConnectivityNodeId(entity.getConnectivityNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConnectivityNode." );

			// for use later on...
			connectivityNodeId = entity.getConnectivityNodeId();

			ConnectivityNodeBusinessDelegate proxy = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();  

			proxy.updateConnectivityNode( command ).get();

			LOGGER.info( "-- Successfully saved ConnectivityNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + connectivityNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConnectivityNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConnectivityNode." );

		ConnectivityNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConnectivityNode with id " + connectivityNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConnectivityNode with id " + connectivityNodeId );

			throw e;
		}

		try{
			ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().delete( new DeleteConnectivityNodeCommand( entity.getConnectivityNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConnectivityNode with id " + connectivityNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConnectivityNode with id " + connectivityNodeId );

			throw e;
		}
	}

	/**
	 * get all ConnectivityNodes.
	 */
	protected List<ConnectivityNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConnectivityNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConnectivityNode : " );        
		List<ConnectivityNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConnectivityNodeBusinessDelegate
			collection = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().getAllConnectivityNode();
			assertNotNull( collection, "An Empty collection of ConnectivityNode was incorrectly returned.");
			
			// Now print out the values
			ConnectivityNode entity = null;            
			Iterator<ConnectivityNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConnectivityNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConnectivityNodeTest
	 */
	protected ConnectivityNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConnectivityNode
	 * 
	 * @return CreateConnectivityNodeCommand alias
	 */
	protected CreateConnectivityNodeCommand generateNewCommand() {
        CreateConnectivityNodeCommand command = new CreateConnectivityNodeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ConnectivityNode
		 * 
		 * @return UpdateConnectivityNodeCommand alias
		 */
	protected UpdateConnectivityNodeCommand generateUpdateCommand() {
	        UpdateConnectivityNodeCommand command = new UpdateConnectivityNodeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID connectivityNodeId = null;
	protected ConnectivityNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConnectivityNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConnectivityNodeList = 0;
}
