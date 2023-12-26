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
 * Test ENTSOETopologicalNode class.
 *
 * @author your_name_here
 */
public class ENTSOETopologicalNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ENTSOETopologicalNodeTest() {
		subscriber = new ENTSOETopologicalNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ENTSOETopologicalNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ENTSOETopologicalNode...");
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
	 * jumpstart the process by instantiating2 ENTSOETopologicalNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		eNTSOETopologicalNodeId = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance()
		.createENTSOETopologicalNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance()
				.createENTSOETopologicalNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.eNTSOETopologicalNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ENTSOETopologicalNode : " + successValue.getENTSOETopologicalNodeId());
							  if (successValue.getENTSOETopologicalNodeId().equals(eNTSOETopologicalNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfENTSOETopologicalNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ENTSOETopologicalNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOETopologicalNode consumed")
					);
			subscriber.eNTSOETopologicalNodeSubscribe( eNTSOETopologicalNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ENTSOETopologicalNode : " + successValue.getENTSOETopologicalNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfENTSOETopologicalNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOETopologicalNode for eNTSOETopologicalNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ENTSOETopologicalNode. 
	 */
	protected ENTSOETopologicalNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ENTSOETopologicalNode" );

		ENTSOETopologicalNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ENTSOETopologicalNode with primary key" );
		msg.append( eNTSOETopologicalNodeId );
		
		ENTSOETopologicalNodeFetchOneSummary fetchOneSummary = new ENTSOETopologicalNodeFetchOneSummary( eNTSOETopologicalNodeId );

		try {
			entity = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().getENTSOETopologicalNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ENTSOETopologicalNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ENTSOETopologicalNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ENTSOETopologicalNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a ENTSOETopologicalNode : " );        
		ENTSOETopologicalNode entity = read();
		UpdateENTSOETopologicalNodeCommand command = generateUpdateCommand();
		command.setENTSOETopologicalNodeId(entity.getENTSOETopologicalNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ENTSOETopologicalNode." );

			// for use later on...
			eNTSOETopologicalNodeId = entity.getENTSOETopologicalNodeId();

			ENTSOETopologicalNodeBusinessDelegate proxy = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance();  

			proxy.updateENTSOETopologicalNode( command ).get();

			LOGGER.info( "-- Successfully saved ENTSOETopologicalNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + eNTSOETopologicalNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ENTSOETopologicalNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ENTSOETopologicalNode." );

		ENTSOETopologicalNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ENTSOETopologicalNode with id " + eNTSOETopologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ENTSOETopologicalNode with id " + eNTSOETopologicalNodeId );

			throw e;
		}

		try{
			ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().delete( new DeleteENTSOETopologicalNodeCommand( entity.getENTSOETopologicalNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted ENTSOETopologicalNode with id " + eNTSOETopologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ENTSOETopologicalNode with id " + eNTSOETopologicalNodeId );

			throw e;
		}
	}

	/**
	 * get all ENTSOETopologicalNodes.
	 */
	protected List<ENTSOETopologicalNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ENTSOETopologicalNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ENTSOETopologicalNode : " );        
		List<ENTSOETopologicalNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the ENTSOETopologicalNodeBusinessDelegate
			collection = ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance().getAllENTSOETopologicalNode();
			assertNotNull( collection, "An Empty collection of ENTSOETopologicalNode was incorrectly returned.");
			
			// Now print out the values
			ENTSOETopologicalNode entity = null;            
			Iterator<ENTSOETopologicalNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getENTSOETopologicalNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ENTSOETopologicalNodeTest
	 */
	protected ENTSOETopologicalNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ENTSOETopologicalNode
	 * 
	 * @return CreateENTSOETopologicalNodeCommand alias
	 */
	protected CreateENTSOETopologicalNodeCommand generateNewCommand() {
        CreateENTSOETopologicalNodeCommand command = new CreateENTSOETopologicalNodeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ENTSOETopologicalNode
		 * 
		 * @return UpdateENTSOETopologicalNodeCommand alias
		 */
	protected UpdateENTSOETopologicalNodeCommand generateUpdateCommand() {
	        UpdateENTSOETopologicalNodeCommand command = new UpdateENTSOETopologicalNodeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID eNTSOETopologicalNodeId = null;
	protected ENTSOETopologicalNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ENTSOETopologicalNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfENTSOETopologicalNodeList = 0;
}
