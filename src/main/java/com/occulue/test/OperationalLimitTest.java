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
 * Test OperationalLimit class.
 *
 * @author your_name_here
 */
public class OperationalLimitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OperationalLimitTest() {
		subscriber = new OperationalLimitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OperationalLimitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OperationalLimit...");
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
	 * jumpstart the process by instantiating2 OperationalLimit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		operationalLimitId = OperationalLimitBusinessDelegate.getOperationalLimitInstance()
		.createOperationalLimit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OperationalLimitBusinessDelegate.getOperationalLimitInstance()
				.createOperationalLimit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.operationalLimitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OperationalLimit : " + successValue.getOperationalLimitId());
							  if (successValue.getOperationalLimitId().equals(operationalLimitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOperationalLimitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OperationalLimit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimit consumed")
					);
			subscriber.operationalLimitSubscribe( operationalLimitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OperationalLimit : " + successValue.getOperationalLimitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOperationalLimitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimit for operationalLimitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OperationalLimit. 
	 */
	protected OperationalLimit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OperationalLimit" );

		OperationalLimit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OperationalLimit with primary key" );
		msg.append( operationalLimitId );
		
		OperationalLimitFetchOneSummary fetchOneSummary = new OperationalLimitFetchOneSummary( operationalLimitId );

		try {
			entity = OperationalLimitBusinessDelegate.getOperationalLimitInstance().getOperationalLimit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OperationalLimit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OperationalLimit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OperationalLimit." );

		StringBuilder msg = new StringBuilder( "Failed to update a OperationalLimit : " );        
		OperationalLimit entity = read();
		UpdateOperationalLimitCommand command = generateUpdateCommand();
		command.setOperationalLimitId(entity.getOperationalLimitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OperationalLimit." );

			// for use later on...
			operationalLimitId = entity.getOperationalLimitId();

			OperationalLimitBusinessDelegate proxy = OperationalLimitBusinessDelegate.getOperationalLimitInstance();  

			proxy.updateOperationalLimit( command ).get();

			LOGGER.info( "-- Successfully saved OperationalLimit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + operationalLimitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OperationalLimit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OperationalLimit." );

		OperationalLimit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OperationalLimit with id " + operationalLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OperationalLimit with id " + operationalLimitId );

			throw e;
		}

		try{
			OperationalLimitBusinessDelegate.getOperationalLimitInstance().delete( new DeleteOperationalLimitCommand( entity.getOperationalLimitId() ) ).get();
			LOGGER.info( "-- Successfully deleted OperationalLimit with id " + operationalLimitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OperationalLimit with id " + operationalLimitId );

			throw e;
		}
	}

	/**
	 * get all OperationalLimits.
	 */
	protected List<OperationalLimit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OperationalLimits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OperationalLimit : " );        
		List<OperationalLimit> collection  = new ArrayList<>();

		try {
			// call the static get method on the OperationalLimitBusinessDelegate
			collection = OperationalLimitBusinessDelegate.getOperationalLimitInstance().getAllOperationalLimit();
			assertNotNull( collection, "An Empty collection of OperationalLimit was incorrectly returned.");
			
			// Now print out the values
			OperationalLimit entity = null;            
			Iterator<OperationalLimit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOperationalLimitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OperationalLimitTest
	 */
	protected OperationalLimitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OperationalLimit
	 * 
	 * @return CreateOperationalLimitCommand alias
	 */
	protected CreateOperationalLimitCommand generateNewCommand() {
        CreateOperationalLimitCommand command = new CreateOperationalLimitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated OperationalLimit
		 * 
		 * @return UpdateOperationalLimitCommand alias
		 */
	protected UpdateOperationalLimitCommand generateUpdateCommand() {
	        UpdateOperationalLimitCommand command = new UpdateOperationalLimitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID operationalLimitId = null;
	protected OperationalLimitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OperationalLimitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOperationalLimitList = 0;
}
