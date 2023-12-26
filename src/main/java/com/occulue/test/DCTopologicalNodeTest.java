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
 * Test DCTopologicalNode class.
 *
 * @author your_name_here
 */
public class DCTopologicalNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCTopologicalNodeTest() {
		subscriber = new DCTopologicalNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCTopologicalNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCTopologicalNode...");
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
	 * jumpstart the process by instantiating2 DCTopologicalNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCTopologicalNodeId = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance()
		.createDCTopologicalNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance()
				.createDCTopologicalNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCTopologicalNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCTopologicalNode : " + successValue.getDCTopologicalNodeId());
							  if (successValue.getDCTopologicalNodeId().equals(dCTopologicalNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCTopologicalNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCTopologicalNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTopologicalNode consumed")
					);
			subscriber.dCTopologicalNodeSubscribe( dCTopologicalNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCTopologicalNode : " + successValue.getDCTopologicalNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCTopologicalNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCTopologicalNode for dCTopologicalNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCTopologicalNode. 
	 */
	protected DCTopologicalNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCTopologicalNode" );

		DCTopologicalNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCTopologicalNode with primary key" );
		msg.append( dCTopologicalNodeId );
		
		DCTopologicalNodeFetchOneSummary fetchOneSummary = new DCTopologicalNodeFetchOneSummary( dCTopologicalNodeId );

		try {
			entity = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance().getDCTopologicalNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCTopologicalNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCTopologicalNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCTopologicalNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCTopologicalNode : " );        
		DCTopologicalNode entity = read();
		UpdateDCTopologicalNodeCommand command = generateUpdateCommand();
		command.setDCTopologicalNodeId(entity.getDCTopologicalNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCTopologicalNode." );

			// for use later on...
			dCTopologicalNodeId = entity.getDCTopologicalNodeId();

			DCTopologicalNodeBusinessDelegate proxy = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance();  

			proxy.updateDCTopologicalNode( command ).get();

			LOGGER.info( "-- Successfully saved DCTopologicalNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCTopologicalNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCTopologicalNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCTopologicalNode." );

		DCTopologicalNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCTopologicalNode with id " + dCTopologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCTopologicalNode with id " + dCTopologicalNodeId );

			throw e;
		}

		try{
			DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance().delete( new DeleteDCTopologicalNodeCommand( entity.getDCTopologicalNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCTopologicalNode with id " + dCTopologicalNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCTopologicalNode with id " + dCTopologicalNodeId );

			throw e;
		}
	}

	/**
	 * get all DCTopologicalNodes.
	 */
	protected List<DCTopologicalNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCTopologicalNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCTopologicalNode : " );        
		List<DCTopologicalNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCTopologicalNodeBusinessDelegate
			collection = DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance().getAllDCTopologicalNode();
			assertNotNull( collection, "An Empty collection of DCTopologicalNode was incorrectly returned.");
			
			// Now print out the values
			DCTopologicalNode entity = null;            
			Iterator<DCTopologicalNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCTopologicalNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCTopologicalNodeTest
	 */
	protected DCTopologicalNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCTopologicalNode
	 * 
	 * @return CreateDCTopologicalNodeCommand alias
	 */
	protected CreateDCTopologicalNodeCommand generateNewCommand() {
        CreateDCTopologicalNodeCommand command = new CreateDCTopologicalNodeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCTopologicalNode
		 * 
		 * @return UpdateDCTopologicalNodeCommand alias
		 */
	protected UpdateDCTopologicalNodeCommand generateUpdateCommand() {
	        UpdateDCTopologicalNodeCommand command = new UpdateDCTopologicalNodeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCTopologicalNodeId = null;
	protected DCTopologicalNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCTopologicalNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCTopologicalNodeList = 0;
}
