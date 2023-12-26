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
 * Test DCNode class.
 *
 * @author your_name_here
 */
public class DCNodeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCNodeTest() {
		subscriber = new DCNodeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCNodeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCNode...");
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
	 * jumpstart the process by instantiating2 DCNode
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCNodeId = DCNodeBusinessDelegate.getDCNodeInstance()
		.createDCNode( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCNodeBusinessDelegate.getDCNodeInstance()
				.createDCNode( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCNodeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCNode : " + successValue.getDCNodeId());
							  if (successValue.getDCNodeId().equals(dCNodeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCNodeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCNode test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCNode consumed")
					);
			subscriber.dCNodeSubscribe( dCNodeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCNode : " + successValue.getDCNodeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCNodeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCNode for dCNodeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCNode. 
	 */
	protected DCNode read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCNode" );

		DCNode entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCNode with primary key" );
		msg.append( dCNodeId );
		
		DCNodeFetchOneSummary fetchOneSummary = new DCNodeFetchOneSummary( dCNodeId );

		try {
			entity = DCNodeBusinessDelegate.getDCNodeInstance().getDCNode( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCNode " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCNode.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCNode." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCNode : " );        
		DCNode entity = read();
		UpdateDCNodeCommand command = generateUpdateCommand();
		command.setDCNodeId(entity.getDCNodeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCNode." );

			// for use later on...
			dCNodeId = entity.getDCNodeId();

			DCNodeBusinessDelegate proxy = DCNodeBusinessDelegate.getDCNodeInstance();  

			proxy.updateDCNode( command ).get();

			LOGGER.info( "-- Successfully saved DCNode - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCNodeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCNode.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCNode." );

		DCNode entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCNode with id " + dCNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCNode with id " + dCNodeId );

			throw e;
		}

		try{
			DCNodeBusinessDelegate.getDCNodeInstance().delete( new DeleteDCNodeCommand( entity.getDCNodeId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCNode with id " + dCNodeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCNode with id " + dCNodeId );

			throw e;
		}
	}

	/**
	 * get all DCNodes.
	 */
	protected List<DCNode> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCNodes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCNode : " );        
		List<DCNode> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCNodeBusinessDelegate
			collection = DCNodeBusinessDelegate.getDCNodeInstance().getAllDCNode();
			assertNotNull( collection, "An Empty collection of DCNode was incorrectly returned.");
			
			// Now print out the values
			DCNode entity = null;            
			Iterator<DCNode> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCNodeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCNodeTest
	 */
	protected DCNodeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCNode
	 * 
	 * @return CreateDCNodeCommand alias
	 */
	protected CreateDCNodeCommand generateNewCommand() {
        CreateDCNodeCommand command = new CreateDCNodeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCNode
		 * 
		 * @return UpdateDCNodeCommand alias
		 */
	protected UpdateDCNodeCommand generateUpdateCommand() {
	        UpdateDCNodeCommand command = new UpdateDCNodeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCNodeId = null;
	protected DCNodeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCNodeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCNodeList = 0;
}
