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
 * Test Connector class.
 *
 * @author your_name_here
 */
public class ConnectorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConnectorTest() {
		subscriber = new ConnectorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConnectorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Connector...");
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
	 * jumpstart the process by instantiating2 Connector
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		connectorId = ConnectorBusinessDelegate.getConnectorInstance()
		.createConnector( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConnectorBusinessDelegate.getConnectorInstance()
				.createConnector( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.connectorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Connector : " + successValue.getConnectorId());
							  if (successValue.getConnectorId().equals(connectorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConnectorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Connector test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connector consumed")
					);
			subscriber.connectorSubscribe( connectorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Connector : " + successValue.getConnectorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConnectorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connector for connectorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Connector. 
	 */
	protected Connector read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Connector" );

		Connector entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Connector with primary key" );
		msg.append( connectorId );
		
		ConnectorFetchOneSummary fetchOneSummary = new ConnectorFetchOneSummary( connectorId );

		try {
			entity = ConnectorBusinessDelegate.getConnectorInstance().getConnector( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Connector " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Connector.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Connector." );

		StringBuilder msg = new StringBuilder( "Failed to update a Connector : " );        
		Connector entity = read();
		UpdateConnectorCommand command = generateUpdateCommand();
		command.setConnectorId(entity.getConnectorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Connector." );

			// for use later on...
			connectorId = entity.getConnectorId();

			ConnectorBusinessDelegate proxy = ConnectorBusinessDelegate.getConnectorInstance();  

			proxy.updateConnector( command ).get();

			LOGGER.info( "-- Successfully saved Connector - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + connectorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Connector.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Connector." );

		Connector entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Connector with id " + connectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Connector with id " + connectorId );

			throw e;
		}

		try{
			ConnectorBusinessDelegate.getConnectorInstance().delete( new DeleteConnectorCommand( entity.getConnectorId() ) ).get();
			LOGGER.info( "-- Successfully deleted Connector with id " + connectorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Connector with id " + connectorId );

			throw e;
		}
	}

	/**
	 * get all Connectors.
	 */
	protected List<Connector> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Connectors:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Connector : " );        
		List<Connector> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConnectorBusinessDelegate
			collection = ConnectorBusinessDelegate.getConnectorInstance().getAllConnector();
			assertNotNull( collection, "An Empty collection of Connector was incorrectly returned.");
			
			// Now print out the values
			Connector entity = null;            
			Iterator<Connector> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConnectorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConnectorTest
	 */
	protected ConnectorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Connector
	 * 
	 * @return CreateConnectorCommand alias
	 */
	protected CreateConnectorCommand generateNewCommand() {
        CreateConnectorCommand command = new CreateConnectorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Connector
		 * 
		 * @return UpdateConnectorCommand alias
		 */
	protected UpdateConnectorCommand generateUpdateCommand() {
	        UpdateConnectorCommand command = new UpdateConnectorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID connectorId = null;
	protected ConnectorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConnectorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConnectorList = 0;
}
