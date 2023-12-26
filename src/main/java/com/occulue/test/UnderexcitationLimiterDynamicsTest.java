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
 * Test UnderexcitationLimiterDynamics class.
 *
 * @author your_name_here
 */
public class UnderexcitationLimiterDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcitationLimiterDynamicsTest() {
		subscriber = new UnderexcitationLimiterDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcitationLimiterDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcitationLimiterDynamics...");
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
	 * jumpstart the process by instantiating2 UnderexcitationLimiterDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcitationLimiterDynamicsId = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance()
		.createUnderexcitationLimiterDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance()
				.createUnderexcitationLimiterDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcitationLimiterDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcitationLimiterDynamics : " + successValue.getUnderexcitationLimiterDynamicsId());
							  if (successValue.getUnderexcitationLimiterDynamicsId().equals(underexcitationLimiterDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcitationLimiterDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcitationLimiterDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcitationLimiterDynamics consumed")
					);
			subscriber.underexcitationLimiterDynamicsSubscribe( underexcitationLimiterDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcitationLimiterDynamics : " + successValue.getUnderexcitationLimiterDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcitationLimiterDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcitationLimiterDynamics for underexcitationLimiterDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcitationLimiterDynamics. 
	 */
	protected UnderexcitationLimiterDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcitationLimiterDynamics" );

		UnderexcitationLimiterDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcitationLimiterDynamics with primary key" );
		msg.append( underexcitationLimiterDynamicsId );
		
		UnderexcitationLimiterDynamicsFetchOneSummary fetchOneSummary = new UnderexcitationLimiterDynamicsFetchOneSummary( underexcitationLimiterDynamicsId );

		try {
			entity = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance().getUnderexcitationLimiterDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcitationLimiterDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcitationLimiterDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcitationLimiterDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcitationLimiterDynamics : " );        
		UnderexcitationLimiterDynamics entity = read();
		UpdateUnderexcitationLimiterDynamicsCommand command = generateUpdateCommand();
		command.setUnderexcitationLimiterDynamicsId(entity.getUnderexcitationLimiterDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcitationLimiterDynamics." );

			// for use later on...
			underexcitationLimiterDynamicsId = entity.getUnderexcitationLimiterDynamicsId();

			UnderexcitationLimiterDynamicsBusinessDelegate proxy = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance();  

			proxy.updateUnderexcitationLimiterDynamics( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcitationLimiterDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcitationLimiterDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcitationLimiterDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcitationLimiterDynamics." );

		UnderexcitationLimiterDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcitationLimiterDynamics with id " + underexcitationLimiterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcitationLimiterDynamics with id " + underexcitationLimiterDynamicsId );

			throw e;
		}

		try{
			UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance().delete( new DeleteUnderexcitationLimiterDynamicsCommand( entity.getUnderexcitationLimiterDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcitationLimiterDynamics with id " + underexcitationLimiterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcitationLimiterDynamics with id " + underexcitationLimiterDynamicsId );

			throw e;
		}
	}

	/**
	 * get all UnderexcitationLimiterDynamicss.
	 */
	protected List<UnderexcitationLimiterDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcitationLimiterDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcitationLimiterDynamics : " );        
		List<UnderexcitationLimiterDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcitationLimiterDynamicsBusinessDelegate
			collection = UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance().getAllUnderexcitationLimiterDynamics();
			assertNotNull( collection, "An Empty collection of UnderexcitationLimiterDynamics was incorrectly returned.");
			
			// Now print out the values
			UnderexcitationLimiterDynamics entity = null;            
			Iterator<UnderexcitationLimiterDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcitationLimiterDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcitationLimiterDynamicsTest
	 */
	protected UnderexcitationLimiterDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcitationLimiterDynamics
	 * 
	 * @return CreateUnderexcitationLimiterDynamicsCommand alias
	 */
	protected CreateUnderexcitationLimiterDynamicsCommand generateNewCommand() {
        CreateUnderexcitationLimiterDynamicsCommand command = new CreateUnderexcitationLimiterDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcitationLimiterDynamics
		 * 
		 * @return UpdateUnderexcitationLimiterDynamicsCommand alias
		 */
	protected UpdateUnderexcitationLimiterDynamicsCommand generateUpdateCommand() {
	        UpdateUnderexcitationLimiterDynamicsCommand command = new UpdateUnderexcitationLimiterDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcitationLimiterDynamicsId = null;
	protected UnderexcitationLimiterDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcitationLimiterDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcitationLimiterDynamicsList = 0;
}
