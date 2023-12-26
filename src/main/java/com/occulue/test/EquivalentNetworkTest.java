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
 * Test EquivalentNetwork class.
 *
 * @author your_name_here
 */
public class EquivalentNetworkTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquivalentNetworkTest() {
		subscriber = new EquivalentNetworkSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquivalentNetworkTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquivalentNetwork...");
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
	 * jumpstart the process by instantiating2 EquivalentNetwork
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equivalentNetworkId = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance()
		.createEquivalentNetwork( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance()
				.createEquivalentNetwork( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equivalentNetworkSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquivalentNetwork : " + successValue.getEquivalentNetworkId());
							  if (successValue.getEquivalentNetworkId().equals(equivalentNetworkId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquivalentNetworkList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquivalentNetwork test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentNetwork consumed")
					);
			subscriber.equivalentNetworkSubscribe( equivalentNetworkId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquivalentNetwork : " + successValue.getEquivalentNetworkId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquivalentNetworkList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentNetwork for equivalentNetworkId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquivalentNetwork. 
	 */
	protected EquivalentNetwork read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquivalentNetwork" );

		EquivalentNetwork entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquivalentNetwork with primary key" );
		msg.append( equivalentNetworkId );
		
		EquivalentNetworkFetchOneSummary fetchOneSummary = new EquivalentNetworkFetchOneSummary( equivalentNetworkId );

		try {
			entity = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().getEquivalentNetwork( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquivalentNetwork " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquivalentNetwork.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquivalentNetwork." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquivalentNetwork : " );        
		EquivalentNetwork entity = read();
		UpdateEquivalentNetworkCommand command = generateUpdateCommand();
		command.setEquivalentNetworkId(entity.getEquivalentNetworkId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquivalentNetwork." );

			// for use later on...
			equivalentNetworkId = entity.getEquivalentNetworkId();

			EquivalentNetworkBusinessDelegate proxy = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance();  

			proxy.updateEquivalentNetwork( command ).get();

			LOGGER.info( "-- Successfully saved EquivalentNetwork - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equivalentNetworkId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquivalentNetwork.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquivalentNetwork." );

		EquivalentNetwork entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquivalentNetwork with id " + equivalentNetworkId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquivalentNetwork with id " + equivalentNetworkId );

			throw e;
		}

		try{
			EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().delete( new DeleteEquivalentNetworkCommand( entity.getEquivalentNetworkId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquivalentNetwork with id " + equivalentNetworkId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquivalentNetwork with id " + equivalentNetworkId );

			throw e;
		}
	}

	/**
	 * get all EquivalentNetworks.
	 */
	protected List<EquivalentNetwork> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquivalentNetworks:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquivalentNetwork : " );        
		List<EquivalentNetwork> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquivalentNetworkBusinessDelegate
			collection = EquivalentNetworkBusinessDelegate.getEquivalentNetworkInstance().getAllEquivalentNetwork();
			assertNotNull( collection, "An Empty collection of EquivalentNetwork was incorrectly returned.");
			
			// Now print out the values
			EquivalentNetwork entity = null;            
			Iterator<EquivalentNetwork> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquivalentNetworkId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquivalentNetworkTest
	 */
	protected EquivalentNetworkTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquivalentNetwork
	 * 
	 * @return CreateEquivalentNetworkCommand alias
	 */
	protected CreateEquivalentNetworkCommand generateNewCommand() {
        CreateEquivalentNetworkCommand command = new CreateEquivalentNetworkCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EquivalentNetwork
		 * 
		 * @return UpdateEquivalentNetworkCommand alias
		 */
	protected UpdateEquivalentNetworkCommand generateUpdateCommand() {
	        UpdateEquivalentNetworkCommand command = new UpdateEquivalentNetworkCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equivalentNetworkId = null;
	protected EquivalentNetworkSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquivalentNetworkTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquivalentNetworkList = 0;
}
