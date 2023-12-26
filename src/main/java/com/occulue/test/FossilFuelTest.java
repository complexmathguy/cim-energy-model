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
 * Test FossilFuel class.
 *
 * @author your_name_here
 */
public class FossilFuelTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public FossilFuelTest() {
		subscriber = new FossilFuelSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate FossilFuelTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on FossilFuel...");
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
	 * jumpstart the process by instantiating2 FossilFuel
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		fossilFuelId = FossilFuelBusinessDelegate.getFossilFuelInstance()
		.createFossilFuel( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		FossilFuelBusinessDelegate.getFossilFuelInstance()
				.createFossilFuel( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.fossilFuelSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for FossilFuel : " + successValue.getFossilFuelId());
							  if (successValue.getFossilFuelId().equals(fossilFuelId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfFossilFuelList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("FossilFuel test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on fossilFuel consumed")
					);
			subscriber.fossilFuelSubscribe( fossilFuelId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for FossilFuel : " + successValue.getFossilFuelId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfFossilFuelList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on fossilFuel for fossilFuelId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a FossilFuel. 
	 */
	protected FossilFuel read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created FossilFuel" );

		FossilFuel entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read FossilFuel with primary key" );
		msg.append( fossilFuelId );
		
		FossilFuelFetchOneSummary fetchOneSummary = new FossilFuelFetchOneSummary( fossilFuelId );

		try {
			entity = FossilFuelBusinessDelegate.getFossilFuelInstance().getFossilFuel( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found FossilFuel " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a FossilFuel.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a FossilFuel." );

		StringBuilder msg = new StringBuilder( "Failed to update a FossilFuel : " );        
		FossilFuel entity = read();
		UpdateFossilFuelCommand command = generateUpdateCommand();
		command.setFossilFuelId(entity.getFossilFuelId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created FossilFuel." );

			// for use later on...
			fossilFuelId = entity.getFossilFuelId();

			FossilFuelBusinessDelegate proxy = FossilFuelBusinessDelegate.getFossilFuelInstance();  

			proxy.updateFossilFuel( command ).get();

			LOGGER.info( "-- Successfully saved FossilFuel - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + fossilFuelId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a FossilFuel.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created FossilFuel." );

		FossilFuel entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read FossilFuel with id " + fossilFuelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read FossilFuel with id " + fossilFuelId );

			throw e;
		}

		try{
			FossilFuelBusinessDelegate.getFossilFuelInstance().delete( new DeleteFossilFuelCommand( entity.getFossilFuelId() ) ).get();
			LOGGER.info( "-- Successfully deleted FossilFuel with id " + fossilFuelId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete FossilFuel with id " + fossilFuelId );

			throw e;
		}
	}

	/**
	 * get all FossilFuels.
	 */
	protected List<FossilFuel> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of FossilFuels:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all FossilFuel : " );        
		List<FossilFuel> collection  = new ArrayList<>();

		try {
			// call the static get method on the FossilFuelBusinessDelegate
			collection = FossilFuelBusinessDelegate.getFossilFuelInstance().getAllFossilFuel();
			assertNotNull( collection, "An Empty collection of FossilFuel was incorrectly returned.");
			
			// Now print out the values
			FossilFuel entity = null;            
			Iterator<FossilFuel> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getFossilFuelId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		FossilFuelTest
	 */
	protected FossilFuelTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated FossilFuel
	 * 
	 * @return CreateFossilFuelCommand alias
	 */
	protected CreateFossilFuelCommand generateNewCommand() {
        CreateFossilFuelCommand command = new CreateFossilFuelCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated FossilFuel
		 * 
		 * @return UpdateFossilFuelCommand alias
		 */
	protected UpdateFossilFuelCommand generateUpdateCommand() {
	        UpdateFossilFuelCommand command = new UpdateFossilFuelCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID fossilFuelId = null;
	protected FossilFuelSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(FossilFuelTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfFossilFuelList = 0;
}
