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
 * Test Accumulator class.
 *
 * @author your_name_here
 */
public class AccumulatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AccumulatorTest() {
		subscriber = new AccumulatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AccumulatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Accumulator...");
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
	 * jumpstart the process by instantiating2 Accumulator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		accumulatorId = AccumulatorBusinessDelegate.getAccumulatorInstance()
		.createAccumulator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AccumulatorBusinessDelegate.getAccumulatorInstance()
				.createAccumulator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.accumulatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Accumulator : " + successValue.getAccumulatorId());
							  if (successValue.getAccumulatorId().equals(accumulatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAccumulatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Accumulator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulator consumed")
					);
			subscriber.accumulatorSubscribe( accumulatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Accumulator : " + successValue.getAccumulatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAccumulatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on accumulator for accumulatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Accumulator. 
	 */
	protected Accumulator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Accumulator" );

		Accumulator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Accumulator with primary key" );
		msg.append( accumulatorId );
		
		AccumulatorFetchOneSummary fetchOneSummary = new AccumulatorFetchOneSummary( accumulatorId );

		try {
			entity = AccumulatorBusinessDelegate.getAccumulatorInstance().getAccumulator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Accumulator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Accumulator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Accumulator." );

		StringBuilder msg = new StringBuilder( "Failed to update a Accumulator : " );        
		Accumulator entity = read();
		UpdateAccumulatorCommand command = generateUpdateCommand();
		command.setAccumulatorId(entity.getAccumulatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Accumulator." );

			// for use later on...
			accumulatorId = entity.getAccumulatorId();

			AccumulatorBusinessDelegate proxy = AccumulatorBusinessDelegate.getAccumulatorInstance();  

			proxy.updateAccumulator( command ).get();

			LOGGER.info( "-- Successfully saved Accumulator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + accumulatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Accumulator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Accumulator." );

		Accumulator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Accumulator with id " + accumulatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Accumulator with id " + accumulatorId );

			throw e;
		}

		try{
			AccumulatorBusinessDelegate.getAccumulatorInstance().delete( new DeleteAccumulatorCommand( entity.getAccumulatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted Accumulator with id " + accumulatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Accumulator with id " + accumulatorId );

			throw e;
		}
	}

	/**
	 * get all Accumulators.
	 */
	protected List<Accumulator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Accumulators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Accumulator : " );        
		List<Accumulator> collection  = new ArrayList<>();

		try {
			// call the static get method on the AccumulatorBusinessDelegate
			collection = AccumulatorBusinessDelegate.getAccumulatorInstance().getAllAccumulator();
			assertNotNull( collection, "An Empty collection of Accumulator was incorrectly returned.");
			
			// Now print out the values
			Accumulator entity = null;            
			Iterator<Accumulator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAccumulatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AccumulatorTest
	 */
	protected AccumulatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Accumulator
	 * 
	 * @return CreateAccumulatorCommand alias
	 */
	protected CreateAccumulatorCommand generateNewCommand() {
        CreateAccumulatorCommand command = new CreateAccumulatorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Accumulator
		 * 
		 * @return UpdateAccumulatorCommand alias
		 */
	protected UpdateAccumulatorCommand generateUpdateCommand() {
	        UpdateAccumulatorCommand command = new UpdateAccumulatorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID accumulatorId = null;
	protected AccumulatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AccumulatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAccumulatorList = 0;
}
