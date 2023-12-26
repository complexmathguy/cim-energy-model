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
 * Test ConformLoad class.
 *
 * @author your_name_here
 */
public class ConformLoadTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ConformLoadTest() {
		subscriber = new ConformLoadSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ConformLoadTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ConformLoad...");
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
	 * jumpstart the process by instantiating2 ConformLoad
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		conformLoadId = ConformLoadBusinessDelegate.getConformLoadInstance()
		.createConformLoad( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ConformLoadBusinessDelegate.getConformLoadInstance()
				.createConformLoad( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.conformLoadSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ConformLoad : " + successValue.getConformLoadId());
							  if (successValue.getConformLoadId().equals(conformLoadId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfConformLoadList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ConformLoad test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoad consumed")
					);
			subscriber.conformLoadSubscribe( conformLoadId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ConformLoad : " + successValue.getConformLoadId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfConformLoadList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on conformLoad for conformLoadId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ConformLoad. 
	 */
	protected ConformLoad read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ConformLoad" );

		ConformLoad entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ConformLoad with primary key" );
		msg.append( conformLoadId );
		
		ConformLoadFetchOneSummary fetchOneSummary = new ConformLoadFetchOneSummary( conformLoadId );

		try {
			entity = ConformLoadBusinessDelegate.getConformLoadInstance().getConformLoad( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ConformLoad " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ConformLoad.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ConformLoad." );

		StringBuilder msg = new StringBuilder( "Failed to update a ConformLoad : " );        
		ConformLoad entity = read();
		UpdateConformLoadCommand command = generateUpdateCommand();
		command.setConformLoadId(entity.getConformLoadId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ConformLoad." );

			// for use later on...
			conformLoadId = entity.getConformLoadId();

			ConformLoadBusinessDelegate proxy = ConformLoadBusinessDelegate.getConformLoadInstance();  

			proxy.updateConformLoad( command ).get();

			LOGGER.info( "-- Successfully saved ConformLoad - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + conformLoadId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ConformLoad.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ConformLoad." );

		ConformLoad entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ConformLoad with id " + conformLoadId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ConformLoad with id " + conformLoadId );

			throw e;
		}

		try{
			ConformLoadBusinessDelegate.getConformLoadInstance().delete( new DeleteConformLoadCommand( entity.getConformLoadId() ) ).get();
			LOGGER.info( "-- Successfully deleted ConformLoad with id " + conformLoadId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ConformLoad with id " + conformLoadId );

			throw e;
		}
	}

	/**
	 * get all ConformLoads.
	 */
	protected List<ConformLoad> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ConformLoads:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ConformLoad : " );        
		List<ConformLoad> collection  = new ArrayList<>();

		try {
			// call the static get method on the ConformLoadBusinessDelegate
			collection = ConformLoadBusinessDelegate.getConformLoadInstance().getAllConformLoad();
			assertNotNull( collection, "An Empty collection of ConformLoad was incorrectly returned.");
			
			// Now print out the values
			ConformLoad entity = null;            
			Iterator<ConformLoad> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getConformLoadId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ConformLoadTest
	 */
	protected ConformLoadTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ConformLoad
	 * 
	 * @return CreateConformLoadCommand alias
	 */
	protected CreateConformLoadCommand generateNewCommand() {
        CreateConformLoadCommand command = new CreateConformLoadCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ConformLoad
		 * 
		 * @return UpdateConformLoadCommand alias
		 */
	protected UpdateConformLoadCommand generateUpdateCommand() {
	        UpdateConformLoadCommand command = new UpdateConformLoadCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID conformLoadId = null;
	protected ConformLoadSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ConformLoadTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfConformLoadList = 0;
}
