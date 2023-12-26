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
 * Test DiscontinuousExcitationControlDynamics class.
 *
 * @author your_name_here
 */
public class DiscontinuousExcitationControlDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscontinuousExcitationControlDynamicsTest() {
		subscriber = new DiscontinuousExcitationControlDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscontinuousExcitationControlDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscontinuousExcitationControlDynamics...");
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
	 * jumpstart the process by instantiating2 DiscontinuousExcitationControlDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discontinuousExcitationControlDynamicsId = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance()
		.createDiscontinuousExcitationControlDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance()
				.createDiscontinuousExcitationControlDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discontinuousExcitationControlDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscontinuousExcitationControlDynamics : " + successValue.getDiscontinuousExcitationControlDynamicsId());
							  if (successValue.getDiscontinuousExcitationControlDynamicsId().equals(discontinuousExcitationControlDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscontinuousExcitationControlDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscontinuousExcitationControlDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discontinuousExcitationControlDynamics consumed")
					);
			subscriber.discontinuousExcitationControlDynamicsSubscribe( discontinuousExcitationControlDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscontinuousExcitationControlDynamics : " + successValue.getDiscontinuousExcitationControlDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscontinuousExcitationControlDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discontinuousExcitationControlDynamics for discontinuousExcitationControlDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscontinuousExcitationControlDynamics. 
	 */
	protected DiscontinuousExcitationControlDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscontinuousExcitationControlDynamics" );

		DiscontinuousExcitationControlDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscontinuousExcitationControlDynamics with primary key" );
		msg.append( discontinuousExcitationControlDynamicsId );
		
		DiscontinuousExcitationControlDynamicsFetchOneSummary fetchOneSummary = new DiscontinuousExcitationControlDynamicsFetchOneSummary( discontinuousExcitationControlDynamicsId );

		try {
			entity = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().getDiscontinuousExcitationControlDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscontinuousExcitationControlDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscontinuousExcitationControlDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscontinuousExcitationControlDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscontinuousExcitationControlDynamics : " );        
		DiscontinuousExcitationControlDynamics entity = read();
		UpdateDiscontinuousExcitationControlDynamicsCommand command = generateUpdateCommand();
		command.setDiscontinuousExcitationControlDynamicsId(entity.getDiscontinuousExcitationControlDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscontinuousExcitationControlDynamics." );

			// for use later on...
			discontinuousExcitationControlDynamicsId = entity.getDiscontinuousExcitationControlDynamicsId();

			DiscontinuousExcitationControlDynamicsBusinessDelegate proxy = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance();  

			proxy.updateDiscontinuousExcitationControlDynamics( command ).get();

			LOGGER.info( "-- Successfully saved DiscontinuousExcitationControlDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discontinuousExcitationControlDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscontinuousExcitationControlDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscontinuousExcitationControlDynamics." );

		DiscontinuousExcitationControlDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscontinuousExcitationControlDynamics with id " + discontinuousExcitationControlDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscontinuousExcitationControlDynamics with id " + discontinuousExcitationControlDynamicsId );

			throw e;
		}

		try{
			DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().delete( new DeleteDiscontinuousExcitationControlDynamicsCommand( entity.getDiscontinuousExcitationControlDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscontinuousExcitationControlDynamics with id " + discontinuousExcitationControlDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscontinuousExcitationControlDynamics with id " + discontinuousExcitationControlDynamicsId );

			throw e;
		}
	}

	/**
	 * get all DiscontinuousExcitationControlDynamicss.
	 */
	protected List<DiscontinuousExcitationControlDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscontinuousExcitationControlDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscontinuousExcitationControlDynamics : " );        
		List<DiscontinuousExcitationControlDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscontinuousExcitationControlDynamicsBusinessDelegate
			collection = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().getAllDiscontinuousExcitationControlDynamics();
			assertNotNull( collection, "An Empty collection of DiscontinuousExcitationControlDynamics was incorrectly returned.");
			
			// Now print out the values
			DiscontinuousExcitationControlDynamics entity = null;            
			Iterator<DiscontinuousExcitationControlDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscontinuousExcitationControlDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscontinuousExcitationControlDynamicsTest
	 */
	protected DiscontinuousExcitationControlDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscontinuousExcitationControlDynamics
	 * 
	 * @return CreateDiscontinuousExcitationControlDynamicsCommand alias
	 */
	protected CreateDiscontinuousExcitationControlDynamicsCommand generateNewCommand() {
        CreateDiscontinuousExcitationControlDynamicsCommand command = new CreateDiscontinuousExcitationControlDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscontinuousExcitationControlDynamics
		 * 
		 * @return UpdateDiscontinuousExcitationControlDynamicsCommand alias
		 */
	protected UpdateDiscontinuousExcitationControlDynamicsCommand generateUpdateCommand() {
	        UpdateDiscontinuousExcitationControlDynamicsCommand command = new UpdateDiscontinuousExcitationControlDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discontinuousExcitationControlDynamicsId = null;
	protected DiscontinuousExcitationControlDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscontinuousExcitationControlDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscontinuousExcitationControlDynamicsList = 0;
}
