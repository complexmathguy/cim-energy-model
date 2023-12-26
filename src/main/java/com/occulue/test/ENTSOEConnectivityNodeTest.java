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
 * Test ENTSOEConnectivityNode class.
 *
 * @author your_name_here
 */
public class ENTSOEConnectivityNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ENTSOEConnectivityNodeTest() {
		subscriber = new ENTSOEConnectivityNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ENTSOEConnectivityNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ENTSOEConnectivityNode...");
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
	 * jumpstart the process by instantiating2 ENTSOEConnectivityNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		eNTSOEConnectivityNodeId = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance()
		.createENTSOEConnectivityNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance()
				.createENTSOEConnectivityNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.eNTSOEConnectivityNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ENTSOEConnectivityNode : " + successValue.getENTSOEConnectivityNodeId());
							  if (successValue.getENTSOEConnectivityNodeId().equals(eNTSOEConnectivityNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfENTSOEConnectivityNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ENTSOEConnectivityNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEConnectivityNode consumed")
					);
			subscriber.eNTSOEConnectivityNodeSubscribe( eNTSOEConnectivityNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ENTSOEConnectivityNode : " + successValue.getENTSOEConnectivityNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfENTSOEConnectivityNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEConnectivityNode for eNTSOEConnectivityNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ENTSOEConnectivityNode. 
	 */
	protected ENTSOEConnectivityNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ENTSOEConnectivityNode" );

		ENTSOEConnectivityNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ENTSOEConnectivityNode with primary key" );
		msg.append( eNTSOEConnectivityNodeId );
		
		ENTSOEConnectivityNodeFetchOneSummary fetchOneSummary = new ENTSOEConnectivityNodeFetchOneSummary( eNTSOEConnectivityNodeId );

		try {
			entity = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().getENTSOEConnectivityNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ENTSOEConnectivityNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ENTSOEConnectivityNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ENTSOEConnectivityNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a ENTSOEConnectivityNode : " );        
		ENTSOEConnectivityNode entity = read();
		UpdateENTSOEConnectivityNodeCommand command = generateUpdateCommand();
		command.setENTSOEConnectivityNodeId(entity.getENTSOEConnectivityNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ENTSOEConnectivityNode." );

			// for use later on...
			eNTSOEConnectivityNodeId = entity.getENTSOEConnectivityNodeId();

			ENTSOEConnectivityNodeBusinessDelegate proxy = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance();  

			proxy.updateENTSOEConnectivityNode( command ).get();

			LOGGER.info( "-- Successfully saved ENTSOEConnectivityNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + eNTSOEConnectivityNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ENTSOEConnectivityNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ENTSOEConnectivityNode." );

		ENTSOEConnectivityNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ENTSOEConnectivityNode with id " + eNTSOEConnectivityNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ENTSOEConnectivityNode with id " + eNTSOEConnectivityNodeId );

			throw e;
		}

		try{
			ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().delete( new DeleteENTSOEConnectivityNodeCommand( entity.getENTSOEConnectivityNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted ENTSOEConnectivityNode with id " + eNTSOEConnectivityNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ENTSOEConnectivityNode with id " + eNTSOEConnectivityNodeId );

			throw e;
		}
	}

	/**
	 * get all ENTSOEConnectivityNodes.
	 */
	protected List<ENTSOEConnectivityNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ENTSOEConnectivityNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ENTSOEConnectivityNode : " );        
		List<ENTSOEConnectivityNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the ENTSOEConnectivityNodeBusinessDelegate
			collection = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().getAllENTSOEConnectivityNode();
			assertNotNull( collection, "An Empty collection of ENTSOEConnectivityNode was incorrectly returned.");
			
			// Now print out the values
			ENTSOEConnectivityNode entity = null;            
			Iterator<ENTSOEConnectivityNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getENTSOEConnectivityNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ENTSOEConnectivityNodeTest
	 */
	protected ENTSOEConnectivityNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ENTSOEConnectivityNode
	 * 
	 * @return CreateENTSOEConnectivityNodeCommand alias
	 */
	protected CreateENTSOEConnectivityNodeCommand generateNewCommand() {
        CreateENTSOEConnectivityNodeCommand command = new CreateENTSOEConnectivityNodeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ENTSOEConnectivityNode
		 * 
		 * @return UpdateENTSOEConnectivityNodeCommand alias
		 */
	protected UpdateENTSOEConnectivityNodeCommand generateUpdateCommand() {
	        UpdateENTSOEConnectivityNodeCommand command = new UpdateENTSOEConnectivityNodeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID eNTSOEConnectivityNodeId = null;
	protected ENTSOEConnectivityNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ENTSOEConnectivityNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfENTSOEConnectivityNodeList = 0;
}
