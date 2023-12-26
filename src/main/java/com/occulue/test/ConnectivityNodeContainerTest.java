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
 * Test ConnectivityNodeContainer class.
 *
 * @author your_name_here
 */
public class ConnectivityNodeContainerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConnectivityNodeContainerTest() {
		subscriber = new ConnectivityNodeContainerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConnectivityNodeContainerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConnectivityNodeContainer...");
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
	 * jumpstart the process by instantiating2 ConnectivityNodeContainer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		connectivityNodeContainerId = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance()
		.createConnectivityNodeContainer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance()
				.createConnectivityNodeContainer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.connectivityNodeContainerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConnectivityNodeContainer : " + successValue.getConnectivityNodeContainerId());
							  if (successValue.getConnectivityNodeContainerId().equals(connectivityNodeContainerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConnectivityNodeContainerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConnectivityNodeContainer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connectivityNodeContainer consumed")
					);
			subscriber.connectivityNodeContainerSubscribe( connectivityNodeContainerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConnectivityNodeContainer : " + successValue.getConnectivityNodeContainerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConnectivityNodeContainerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on connectivityNodeContainer for connectivityNodeContainerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConnectivityNodeContainer. 
	 */
	protected ConnectivityNodeContainer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConnectivityNodeContainer" );

		ConnectivityNodeContainer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConnectivityNodeContainer with primary key" );
		msg.append( connectivityNodeContainerId );
		
		ConnectivityNodeContainerFetchOneSummary fetchOneSummary = new ConnectivityNodeContainerFetchOneSummary( connectivityNodeContainerId );

		try {
			entity = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().getConnectivityNodeContainer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConnectivityNodeContainer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConnectivityNodeContainer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConnectivityNodeContainer." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConnectivityNodeContainer : " );        
		ConnectivityNodeContainer entity = read();
		UpdateConnectivityNodeContainerCommand command = generateUpdateCommand();
		command.setConnectivityNodeContainerId(entity.getConnectivityNodeContainerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConnectivityNodeContainer." );

			// for use later on...
			connectivityNodeContainerId = entity.getConnectivityNodeContainerId();

			ConnectivityNodeContainerBusinessDelegate proxy = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance();  

			proxy.updateConnectivityNodeContainer( command ).get();

			LOGGER.info( "-- Successfully saved ConnectivityNodeContainer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + connectivityNodeContainerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConnectivityNodeContainer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConnectivityNodeContainer." );

		ConnectivityNodeContainer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConnectivityNodeContainer with id " + connectivityNodeContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConnectivityNodeContainer with id " + connectivityNodeContainerId );

			throw e;
		}

		try{
			ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().delete( new DeleteConnectivityNodeContainerCommand( entity.getConnectivityNodeContainerId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConnectivityNodeContainer with id " + connectivityNodeContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConnectivityNodeContainer with id " + connectivityNodeContainerId );

			throw e;
		}
	}

	/**
	 * get all ConnectivityNodeContainers.
	 */
	protected List<ConnectivityNodeContainer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConnectivityNodeContainers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConnectivityNodeContainer : " );        
		List<ConnectivityNodeContainer> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConnectivityNodeContainerBusinessDelegate
			collection = ConnectivityNodeContainerBusinessDelegate.getConnectivityNodeContainerInstance().getAllConnectivityNodeContainer();
			assertNotNull( collection, "An Empty collection of ConnectivityNodeContainer was incorrectly returned.");
			
			// Now print out the values
			ConnectivityNodeContainer entity = null;            
			Iterator<ConnectivityNodeContainer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConnectivityNodeContainerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConnectivityNodeContainerTest
	 */
	protected ConnectivityNodeContainerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConnectivityNodeContainer
	 * 
	 * @return CreateConnectivityNodeContainerCommand alias
	 */
	protected CreateConnectivityNodeContainerCommand generateNewCommand() {
        CreateConnectivityNodeContainerCommand command = new CreateConnectivityNodeContainerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ConnectivityNodeContainer
		 * 
		 * @return UpdateConnectivityNodeContainerCommand alias
		 */
	protected UpdateConnectivityNodeContainerCommand generateUpdateCommand() {
	        UpdateConnectivityNodeContainerCommand command = new UpdateConnectivityNodeContainerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID connectivityNodeContainerId = null;
	protected ConnectivityNodeContainerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConnectivityNodeContainerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConnectivityNodeContainerList = 0;
}
