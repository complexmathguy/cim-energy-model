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
 * Test Staticpowersystemmodel class.
 *
 * @author your_name_here
 */
public class StaticpowersystemmodelTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StaticpowersystemmodelTest() {
		subscriber = new StaticpowersystemmodelSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StaticpowersystemmodelTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Staticpowersystemmodel...");
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
	 * jumpstart the process by instantiating2 Staticpowersystemmodel
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		staticpowersystemmodelId = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance()
		.createStaticpowersystemmodel( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance()
				.createStaticpowersystemmodel( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.staticpowersystemmodelSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Staticpowersystemmodel : " + successValue.getStaticpowersystemmodelId());
							  if (successValue.getStaticpowersystemmodelId().equals(staticpowersystemmodelId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStaticpowersystemmodelList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Staticpowersystemmodel test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on staticpowersystemmodel consumed")
					);
			subscriber.staticpowersystemmodelSubscribe( staticpowersystemmodelId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Staticpowersystemmodel : " + successValue.getStaticpowersystemmodelId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStaticpowersystemmodelList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on staticpowersystemmodel for staticpowersystemmodelId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Staticpowersystemmodel. 
	 */
	protected Staticpowersystemmodel read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Staticpowersystemmodel" );

		Staticpowersystemmodel entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Staticpowersystemmodel with primary key" );
		msg.append( staticpowersystemmodelId );
		
		StaticpowersystemmodelFetchOneSummary fetchOneSummary = new StaticpowersystemmodelFetchOneSummary( staticpowersystemmodelId );

		try {
			entity = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().getStaticpowersystemmodel( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Staticpowersystemmodel " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Staticpowersystemmodel.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Staticpowersystemmodel." );

		StringBuilder msg = new StringBuilder( "Failed to update a Staticpowersystemmodel : " );        
		Staticpowersystemmodel entity = read();
		UpdateStaticpowersystemmodelCommand command = generateUpdateCommand();
		command.setStaticpowersystemmodelId(entity.getStaticpowersystemmodelId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Staticpowersystemmodel." );

			// for use later on...
			staticpowersystemmodelId = entity.getStaticpowersystemmodelId();

			StaticpowersystemmodelBusinessDelegate proxy = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance();  

			proxy.updateStaticpowersystemmodel( command ).get();

			LOGGER.info( "-- Successfully saved Staticpowersystemmodel - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + staticpowersystemmodelId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Staticpowersystemmodel.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Staticpowersystemmodel." );

		Staticpowersystemmodel entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Staticpowersystemmodel with id " + staticpowersystemmodelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Staticpowersystemmodel with id " + staticpowersystemmodelId );

			throw e;
		}

		try{
			StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().delete( new DeleteStaticpowersystemmodelCommand( entity.getStaticpowersystemmodelId() ) ).get();
			LOGGER.info( "-- Successfully deleted Staticpowersystemmodel with id " + staticpowersystemmodelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Staticpowersystemmodel with id " + staticpowersystemmodelId );

			throw e;
		}
	}

	/**
	 * get all Staticpowersystemmodels.
	 */
	protected List<Staticpowersystemmodel> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Staticpowersystemmodels:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Staticpowersystemmodel : " );        
		List<Staticpowersystemmodel> collection  = new ArrayList<>();

		try {
			// call the static get method on the StaticpowersystemmodelBusinessDelegate
			collection = StaticpowersystemmodelBusinessDelegate.getStaticpowersystemmodelInstance().getAllStaticpowersystemmodel();
			assertNotNull( collection, "An Empty collection of Staticpowersystemmodel was incorrectly returned.");
			
			// Now print out the values
			Staticpowersystemmodel entity = null;            
			Iterator<Staticpowersystemmodel> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStaticpowersystemmodelId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StaticpowersystemmodelTest
	 */
	protected StaticpowersystemmodelTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Staticpowersystemmodel
	 * 
	 * @return CreateStaticpowersystemmodelCommand alias
	 */
	protected CreateStaticpowersystemmodelCommand generateNewCommand() {
        CreateStaticpowersystemmodelCommand command = new CreateStaticpowersystemmodelCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Staticpowersystemmodel
		 * 
		 * @return UpdateStaticpowersystemmodelCommand alias
		 */
	protected UpdateStaticpowersystemmodelCommand generateUpdateCommand() {
	        UpdateStaticpowersystemmodelCommand command = new UpdateStaticpowersystemmodelCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID staticpowersystemmodelId = null;
	protected StaticpowersystemmodelSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StaticpowersystemmodelTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStaticpowersystemmodelList = 0;
}
