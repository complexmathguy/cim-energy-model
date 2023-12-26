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
 * Test Discrete class.
 *
 * @author your_name_here
 */
public class DiscreteTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscreteTest() {
		subscriber = new DiscreteSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscreteTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Discrete...");
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
	 * jumpstart the process by instantiating2 Discrete
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discreteId = DiscreteBusinessDelegate.getDiscreteInstance()
		.createDiscrete( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscreteBusinessDelegate.getDiscreteInstance()
				.createDiscrete( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discreteSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Discrete : " + successValue.getDiscreteId());
							  if (successValue.getDiscreteId().equals(discreteId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscreteList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Discrete test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discrete consumed")
					);
			subscriber.discreteSubscribe( discreteId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Discrete : " + successValue.getDiscreteId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscreteList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discrete for discreteId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Discrete. 
	 */
	protected Discrete read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Discrete" );

		Discrete entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Discrete with primary key" );
		msg.append( discreteId );
		
		DiscreteFetchOneSummary fetchOneSummary = new DiscreteFetchOneSummary( discreteId );

		try {
			entity = DiscreteBusinessDelegate.getDiscreteInstance().getDiscrete( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Discrete " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Discrete.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Discrete." );

		StringBuilder msg = new StringBuilder( "Failed to update a Discrete : " );        
		Discrete entity = read();
		UpdateDiscreteCommand command = generateUpdateCommand();
		command.setDiscreteId(entity.getDiscreteId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Discrete." );

			// for use later on...
			discreteId = entity.getDiscreteId();

			DiscreteBusinessDelegate proxy = DiscreteBusinessDelegate.getDiscreteInstance();  

			proxy.updateDiscrete( command ).get();

			LOGGER.info( "-- Successfully saved Discrete - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discreteId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Discrete.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Discrete." );

		Discrete entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Discrete with id " + discreteId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Discrete with id " + discreteId );

			throw e;
		}

		try{
			DiscreteBusinessDelegate.getDiscreteInstance().delete( new DeleteDiscreteCommand( entity.getDiscreteId() ) ).get();
			LOGGER.info( "-- Successfully deleted Discrete with id " + discreteId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Discrete with id " + discreteId );

			throw e;
		}
	}

	/**
	 * get all Discretes.
	 */
	protected List<Discrete> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Discretes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Discrete : " );        
		List<Discrete> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscreteBusinessDelegate
			collection = DiscreteBusinessDelegate.getDiscreteInstance().getAllDiscrete();
			assertNotNull( collection, "An Empty collection of Discrete was incorrectly returned.");
			
			// Now print out the values
			Discrete entity = null;            
			Iterator<Discrete> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscreteId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscreteTest
	 */
	protected DiscreteTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Discrete
	 * 
	 * @return CreateDiscreteCommand alias
	 */
	protected CreateDiscreteCommand generateNewCommand() {
        CreateDiscreteCommand command = new CreateDiscreteCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Discrete
		 * 
		 * @return UpdateDiscreteCommand alias
		 */
	protected UpdateDiscreteCommand generateUpdateCommand() {
	        UpdateDiscreteCommand command = new UpdateDiscreteCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discreteId = null;
	protected DiscreteSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscreteTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscreteList = 0;
}
