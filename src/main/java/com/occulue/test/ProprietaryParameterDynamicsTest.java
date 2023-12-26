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
 * Test ProprietaryParameterDynamics class.
 *
 * @author your_name_here
 */
public class ProprietaryParameterDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ProprietaryParameterDynamicsTest() {
		subscriber = new ProprietaryParameterDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ProprietaryParameterDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ProprietaryParameterDynamics...");
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
	 * jumpstart the process by instantiating2 ProprietaryParameterDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		proprietaryParameterDynamicsId = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance()
		.createProprietaryParameterDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance()
				.createProprietaryParameterDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.proprietaryParameterDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ProprietaryParameterDynamics : " + successValue.getProprietaryParameterDynamicsId());
							  if (successValue.getProprietaryParameterDynamicsId().equals(proprietaryParameterDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfProprietaryParameterDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ProprietaryParameterDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on proprietaryParameterDynamics consumed")
					);
			subscriber.proprietaryParameterDynamicsSubscribe( proprietaryParameterDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ProprietaryParameterDynamics : " + successValue.getProprietaryParameterDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfProprietaryParameterDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on proprietaryParameterDynamics for proprietaryParameterDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ProprietaryParameterDynamics. 
	 */
	protected ProprietaryParameterDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ProprietaryParameterDynamics" );

		ProprietaryParameterDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ProprietaryParameterDynamics with primary key" );
		msg.append( proprietaryParameterDynamicsId );
		
		ProprietaryParameterDynamicsFetchOneSummary fetchOneSummary = new ProprietaryParameterDynamicsFetchOneSummary( proprietaryParameterDynamicsId );

		try {
			entity = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().getProprietaryParameterDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ProprietaryParameterDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ProprietaryParameterDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ProprietaryParameterDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a ProprietaryParameterDynamics : " );        
		ProprietaryParameterDynamics entity = read();
		UpdateProprietaryParameterDynamicsCommand command = generateUpdateCommand();
		command.setProprietaryParameterDynamicsId(entity.getProprietaryParameterDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ProprietaryParameterDynamics." );

			// for use later on...
			proprietaryParameterDynamicsId = entity.getProprietaryParameterDynamicsId();

			ProprietaryParameterDynamicsBusinessDelegate proxy = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();  

			proxy.updateProprietaryParameterDynamics( command ).get();

			LOGGER.info( "-- Successfully saved ProprietaryParameterDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + proprietaryParameterDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ProprietaryParameterDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ProprietaryParameterDynamics." );

		ProprietaryParameterDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ProprietaryParameterDynamics with id " + proprietaryParameterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ProprietaryParameterDynamics with id " + proprietaryParameterDynamicsId );

			throw e;
		}

		try{
			ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().delete( new DeleteProprietaryParameterDynamicsCommand( entity.getProprietaryParameterDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted ProprietaryParameterDynamics with id " + proprietaryParameterDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ProprietaryParameterDynamics with id " + proprietaryParameterDynamicsId );

			throw e;
		}
	}

	/**
	 * get all ProprietaryParameterDynamicss.
	 */
	protected List<ProprietaryParameterDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ProprietaryParameterDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ProprietaryParameterDynamics : " );        
		List<ProprietaryParameterDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the ProprietaryParameterDynamicsBusinessDelegate
			collection = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().getAllProprietaryParameterDynamics();
			assertNotNull( collection, "An Empty collection of ProprietaryParameterDynamics was incorrectly returned.");
			
			// Now print out the values
			ProprietaryParameterDynamics entity = null;            
			Iterator<ProprietaryParameterDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getProprietaryParameterDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ProprietaryParameterDynamicsTest
	 */
	protected ProprietaryParameterDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ProprietaryParameterDynamics
	 * 
	 * @return CreateProprietaryParameterDynamicsCommand alias
	 */
	protected CreateProprietaryParameterDynamicsCommand generateNewCommand() {
        CreateProprietaryParameterDynamicsCommand command = new CreateProprietaryParameterDynamicsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ProprietaryParameterDynamics
		 * 
		 * @return UpdateProprietaryParameterDynamicsCommand alias
		 */
	protected UpdateProprietaryParameterDynamicsCommand generateUpdateCommand() {
	        UpdateProprietaryParameterDynamicsCommand command = new UpdateProprietaryParameterDynamicsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID proprietaryParameterDynamicsId = null;
	protected ProprietaryParameterDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ProprietaryParameterDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfProprietaryParameterDynamicsList = 0;
}
