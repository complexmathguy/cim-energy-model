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
 * Test OperationalLimitSet class.
 *
 * @author your_name_here
 */
public class OperationalLimitSetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OperationalLimitSetTest() {
		subscriber = new OperationalLimitSetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OperationalLimitSetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OperationalLimitSet...");
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
	 * jumpstart the process by instantiating2 OperationalLimitSet
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		operationalLimitSetId = OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
		.createOperationalLimitSet( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
				.createOperationalLimitSet( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.operationalLimitSetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OperationalLimitSet : " + successValue.getOperationalLimitSetId());
							  if (successValue.getOperationalLimitSetId().equals(operationalLimitSetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOperationalLimitSetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OperationalLimitSet test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimitSet consumed")
					);
			subscriber.operationalLimitSetSubscribe( operationalLimitSetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OperationalLimitSet : " + successValue.getOperationalLimitSetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOperationalLimitSetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimitSet for operationalLimitSetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OperationalLimitSet. 
	 */
	protected OperationalLimitSet read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OperationalLimitSet" );

		OperationalLimitSet entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OperationalLimitSet with primary key" );
		msg.append( operationalLimitSetId );
		
		OperationalLimitSetFetchOneSummary fetchOneSummary = new OperationalLimitSetFetchOneSummary( operationalLimitSetId );

		try {
			entity = OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance().getOperationalLimitSet( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OperationalLimitSet " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OperationalLimitSet.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OperationalLimitSet." );

		StringBuilder msg = new StringBuilder( "Failed to update a OperationalLimitSet : " );        
		OperationalLimitSet entity = read();
		UpdateOperationalLimitSetCommand command = generateUpdateCommand();
		command.setOperationalLimitSetId(entity.getOperationalLimitSetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OperationalLimitSet." );

			// for use later on...
			operationalLimitSetId = entity.getOperationalLimitSetId();

			OperationalLimitSetBusinessDelegate proxy = OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance();  

			proxy.updateOperationalLimitSet( command ).get();

			LOGGER.info( "-- Successfully saved OperationalLimitSet - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + operationalLimitSetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OperationalLimitSet.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OperationalLimitSet." );

		OperationalLimitSet entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OperationalLimitSet with id " + operationalLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OperationalLimitSet with id " + operationalLimitSetId );

			throw e;
		}

		try{
			OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance().delete( new DeleteOperationalLimitSetCommand( entity.getOperationalLimitSetId() ) ).get();
			LOGGER.info( "-- Successfully deleted OperationalLimitSet with id " + operationalLimitSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OperationalLimitSet with id " + operationalLimitSetId );

			throw e;
		}
	}

	/**
	 * get all OperationalLimitSets.
	 */
	protected List<OperationalLimitSet> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OperationalLimitSets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OperationalLimitSet : " );        
		List<OperationalLimitSet> collection  = new ArrayList<>();

		try {
			// call the static get method on the OperationalLimitSetBusinessDelegate
			collection = OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance().getAllOperationalLimitSet();
			assertNotNull( collection, "An Empty collection of OperationalLimitSet was incorrectly returned.");
			
			// Now print out the values
			OperationalLimitSet entity = null;            
			Iterator<OperationalLimitSet> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOperationalLimitSetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OperationalLimitSetTest
	 */
	protected OperationalLimitSetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OperationalLimitSet
	 * 
	 * @return CreateOperationalLimitSetCommand alias
	 */
	protected CreateOperationalLimitSetCommand generateNewCommand() {
        CreateOperationalLimitSetCommand command = new CreateOperationalLimitSetCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated OperationalLimitSet
		 * 
		 * @return UpdateOperationalLimitSetCommand alias
		 */
	protected UpdateOperationalLimitSetCommand generateUpdateCommand() {
	        UpdateOperationalLimitSetCommand command = new UpdateOperationalLimitSetCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID operationalLimitSetId = null;
	protected OperationalLimitSetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OperationalLimitSetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOperationalLimitSetList = 0;
}
