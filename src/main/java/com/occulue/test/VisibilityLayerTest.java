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
 * Test VisibilityLayer class.
 *
 * @author your_name_here
 */
public class VisibilityLayerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VisibilityLayerTest() {
		subscriber = new VisibilityLayerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VisibilityLayerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VisibilityLayer...");
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
	 * jumpstart the process by instantiating2 VisibilityLayer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		visibilityLayerId = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance()
		.createVisibilityLayer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VisibilityLayerBusinessDelegate.getVisibilityLayerInstance()
				.createVisibilityLayer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.visibilityLayerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VisibilityLayer : " + successValue.getVisibilityLayerId());
							  if (successValue.getVisibilityLayerId().equals(visibilityLayerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVisibilityLayerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VisibilityLayer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on visibilityLayer consumed")
					);
			subscriber.visibilityLayerSubscribe( visibilityLayerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VisibilityLayer : " + successValue.getVisibilityLayerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVisibilityLayerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on visibilityLayer for visibilityLayerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VisibilityLayer. 
	 */
	protected VisibilityLayer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VisibilityLayer" );

		VisibilityLayer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VisibilityLayer with primary key" );
		msg.append( visibilityLayerId );
		
		VisibilityLayerFetchOneSummary fetchOneSummary = new VisibilityLayerFetchOneSummary( visibilityLayerId );

		try {
			entity = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance().getVisibilityLayer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VisibilityLayer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VisibilityLayer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VisibilityLayer." );

		StringBuilder msg = new StringBuilder( "Failed to update a VisibilityLayer : " );        
		VisibilityLayer entity = read();
		UpdateVisibilityLayerCommand command = generateUpdateCommand();
		command.setVisibilityLayerId(entity.getVisibilityLayerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VisibilityLayer." );

			// for use later on...
			visibilityLayerId = entity.getVisibilityLayerId();

			VisibilityLayerBusinessDelegate proxy = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance();  

			proxy.updateVisibilityLayer( command ).get();

			LOGGER.info( "-- Successfully saved VisibilityLayer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + visibilityLayerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VisibilityLayer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VisibilityLayer." );

		VisibilityLayer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VisibilityLayer with id " + visibilityLayerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VisibilityLayer with id " + visibilityLayerId );

			throw e;
		}

		try{
			VisibilityLayerBusinessDelegate.getVisibilityLayerInstance().delete( new DeleteVisibilityLayerCommand( entity.getVisibilityLayerId() ) ).get();
			LOGGER.info( "-- Successfully deleted VisibilityLayer with id " + visibilityLayerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VisibilityLayer with id " + visibilityLayerId );

			throw e;
		}
	}

	/**
	 * get all VisibilityLayers.
	 */
	protected List<VisibilityLayer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VisibilityLayers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VisibilityLayer : " );        
		List<VisibilityLayer> collection  = new ArrayList<>();

		try {
			// call the static get method on the VisibilityLayerBusinessDelegate
			collection = VisibilityLayerBusinessDelegate.getVisibilityLayerInstance().getAllVisibilityLayer();
			assertNotNull( collection, "An Empty collection of VisibilityLayer was incorrectly returned.");
			
			// Now print out the values
			VisibilityLayer entity = null;            
			Iterator<VisibilityLayer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVisibilityLayerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VisibilityLayerTest
	 */
	protected VisibilityLayerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VisibilityLayer
	 * 
	 * @return CreateVisibilityLayerCommand alias
	 */
	protected CreateVisibilityLayerCommand generateNewCommand() {
        CreateVisibilityLayerCommand command = new CreateVisibilityLayerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VisibilityLayer
		 * 
		 * @return UpdateVisibilityLayerCommand alias
		 */
	protected UpdateVisibilityLayerCommand generateUpdateCommand() {
	        UpdateVisibilityLayerCommand command = new UpdateVisibilityLayerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID visibilityLayerId = null;
	protected VisibilityLayerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VisibilityLayerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVisibilityLayerList = 0;
}
