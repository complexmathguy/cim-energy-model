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
 * Test HydroPump class.
 *
 * @author your_name_here
 */
public class HydroPumpTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public HydroPumpTest() {
		subscriber = new HydroPumpSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate HydroPumpTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on HydroPump...");
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
	 * jumpstart the process by instantiating2 HydroPump
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		hydroPumpId = HydroPumpBusinessDelegate.getHydroPumpInstance()
		.createHydroPump( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		HydroPumpBusinessDelegate.getHydroPumpInstance()
				.createHydroPump( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.hydroPumpSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for HydroPump : " + successValue.getHydroPumpId());
							  if (successValue.getHydroPumpId().equals(hydroPumpId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfHydroPumpList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("HydroPump test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroPump consumed")
					);
			subscriber.hydroPumpSubscribe( hydroPumpId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for HydroPump : " + successValue.getHydroPumpId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfHydroPumpList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on hydroPump for hydroPumpId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a HydroPump. 
	 */
	protected HydroPump read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created HydroPump" );

		HydroPump entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read HydroPump with primary key" );
		msg.append( hydroPumpId );
		
		HydroPumpFetchOneSummary fetchOneSummary = new HydroPumpFetchOneSummary( hydroPumpId );

		try {
			entity = HydroPumpBusinessDelegate.getHydroPumpInstance().getHydroPump( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found HydroPump " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a HydroPump.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a HydroPump." );

		StringBuilder msg = new StringBuilder( "Failed to update a HydroPump : " );        
		HydroPump entity = read();
		UpdateHydroPumpCommand command = generateUpdateCommand();
		command.setHydroPumpId(entity.getHydroPumpId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created HydroPump." );

			// for use later on...
			hydroPumpId = entity.getHydroPumpId();

			HydroPumpBusinessDelegate proxy = HydroPumpBusinessDelegate.getHydroPumpInstance();  

			proxy.updateHydroPump( command ).get();

			LOGGER.info( "-- Successfully saved HydroPump - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + hydroPumpId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a HydroPump.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created HydroPump." );

		HydroPump entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read HydroPump with id " + hydroPumpId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read HydroPump with id " + hydroPumpId );

			throw e;
		}

		try{
			HydroPumpBusinessDelegate.getHydroPumpInstance().delete( new DeleteHydroPumpCommand( entity.getHydroPumpId() ) ).get();
			LOGGER.info( "-- Successfully deleted HydroPump with id " + hydroPumpId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete HydroPump with id " + hydroPumpId );

			throw e;
		}
	}

	/**
	 * get all HydroPumps.
	 */
	protected List<HydroPump> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of HydroPumps:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all HydroPump : " );        
		List<HydroPump> collection  = new ArrayList<>();

		try {
			// call the static get method on the HydroPumpBusinessDelegate
			collection = HydroPumpBusinessDelegate.getHydroPumpInstance().getAllHydroPump();
			assertNotNull( collection, "An Empty collection of HydroPump was incorrectly returned.");
			
			// Now print out the values
			HydroPump entity = null;            
			Iterator<HydroPump> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getHydroPumpId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		HydroPumpTest
	 */
	protected HydroPumpTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated HydroPump
	 * 
	 * @return CreateHydroPumpCommand alias
	 */
	protected CreateHydroPumpCommand generateNewCommand() {
        CreateHydroPumpCommand command = new CreateHydroPumpCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated HydroPump
		 * 
		 * @return UpdateHydroPumpCommand alias
		 */
	protected UpdateHydroPumpCommand generateUpdateCommand() {
	        UpdateHydroPumpCommand command = new UpdateHydroPumpCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID hydroPumpId = null;
	protected HydroPumpSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(HydroPumpTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfHydroPumpList = 0;
}
