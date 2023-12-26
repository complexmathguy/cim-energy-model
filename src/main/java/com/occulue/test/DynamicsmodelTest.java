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
 * Test Dynamicsmodel class.
 *
 * @author your_name_here
 */
public class DynamicsmodelTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DynamicsmodelTest() {
		subscriber = new DynamicsmodelSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DynamicsmodelTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Dynamicsmodel...");
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
	 * jumpstart the process by instantiating2 Dynamicsmodel
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dynamicsmodelId = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance()
		.createDynamicsmodel( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DynamicsmodelBusinessDelegate.getDynamicsmodelInstance()
				.createDynamicsmodel( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dynamicsmodelSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Dynamicsmodel : " + successValue.getDynamicsmodelId());
							  if (successValue.getDynamicsmodelId().equals(dynamicsmodelId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDynamicsmodelList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Dynamicsmodel test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsmodel consumed")
					);
			subscriber.dynamicsmodelSubscribe( dynamicsmodelId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Dynamicsmodel : " + successValue.getDynamicsmodelId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDynamicsmodelList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsmodel for dynamicsmodelId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Dynamicsmodel. 
	 */
	protected Dynamicsmodel read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Dynamicsmodel" );

		Dynamicsmodel entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Dynamicsmodel with primary key" );
		msg.append( dynamicsmodelId );
		
		DynamicsmodelFetchOneSummary fetchOneSummary = new DynamicsmodelFetchOneSummary( dynamicsmodelId );

		try {
			entity = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().getDynamicsmodel( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Dynamicsmodel " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Dynamicsmodel.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Dynamicsmodel." );

		StringBuilder msg = new StringBuilder( "Failed to update a Dynamicsmodel : " );        
		Dynamicsmodel entity = read();
		UpdateDynamicsmodelCommand command = generateUpdateCommand();
		command.setDynamicsmodelId(entity.getDynamicsmodelId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Dynamicsmodel." );

			// for use later on...
			dynamicsmodelId = entity.getDynamicsmodelId();

			DynamicsmodelBusinessDelegate proxy = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance();  

			proxy.updateDynamicsmodel( command ).get();

			LOGGER.info( "-- Successfully saved Dynamicsmodel - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dynamicsmodelId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Dynamicsmodel.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Dynamicsmodel." );

		Dynamicsmodel entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Dynamicsmodel with id " + dynamicsmodelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Dynamicsmodel with id " + dynamicsmodelId );

			throw e;
		}

		try{
			DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().delete( new DeleteDynamicsmodelCommand( entity.getDynamicsmodelId() ) ).get();
			LOGGER.info( "-- Successfully deleted Dynamicsmodel with id " + dynamicsmodelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Dynamicsmodel with id " + dynamicsmodelId );

			throw e;
		}
	}

	/**
	 * get all Dynamicsmodels.
	 */
	protected List<Dynamicsmodel> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Dynamicsmodels:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Dynamicsmodel : " );        
		List<Dynamicsmodel> collection  = new ArrayList<>();

		try {
			// call the static get method on the DynamicsmodelBusinessDelegate
			collection = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().getAllDynamicsmodel();
			assertNotNull( collection, "An Empty collection of Dynamicsmodel was incorrectly returned.");
			
			// Now print out the values
			Dynamicsmodel entity = null;            
			Iterator<Dynamicsmodel> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDynamicsmodelId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DynamicsmodelTest
	 */
	protected DynamicsmodelTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Dynamicsmodel
	 * 
	 * @return CreateDynamicsmodelCommand alias
	 */
	protected CreateDynamicsmodelCommand generateNewCommand() {
        CreateDynamicsmodelCommand command = new CreateDynamicsmodelCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Dynamicsmodel
		 * 
		 * @return UpdateDynamicsmodelCommand alias
		 */
	protected UpdateDynamicsmodelCommand generateUpdateCommand() {
	        UpdateDynamicsmodelCommand command = new UpdateDynamicsmodelCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dynamicsmodelId = null;
	protected DynamicsmodelSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DynamicsmodelTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDynamicsmodelList = 0;
}
