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
 * Test SynchronousMachineSimplified class.
 *
 * @author your_name_here
 */
public class SynchronousMachineSimplifiedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineSimplifiedTest() {
		subscriber = new SynchronousMachineSimplifiedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineSimplifiedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineSimplified...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineSimplified
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineSimplifiedId = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance()
		.createSynchronousMachineSimplified( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance()
				.createSynchronousMachineSimplified( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineSimplifiedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineSimplified : " + successValue.getSynchronousMachineSimplifiedId());
							  if (successValue.getSynchronousMachineSimplifiedId().equals(synchronousMachineSimplifiedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineSimplifiedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineSimplified test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineSimplified consumed")
					);
			subscriber.synchronousMachineSimplifiedSubscribe( synchronousMachineSimplifiedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineSimplified : " + successValue.getSynchronousMachineSimplifiedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineSimplifiedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineSimplified for synchronousMachineSimplifiedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineSimplified. 
	 */
	protected SynchronousMachineSimplified read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineSimplified" );

		SynchronousMachineSimplified entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineSimplified with primary key" );
		msg.append( synchronousMachineSimplifiedId );
		
		SynchronousMachineSimplifiedFetchOneSummary fetchOneSummary = new SynchronousMachineSimplifiedFetchOneSummary( synchronousMachineSimplifiedId );

		try {
			entity = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().getSynchronousMachineSimplified( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineSimplified " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineSimplified.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineSimplified." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineSimplified : " );        
		SynchronousMachineSimplified entity = read();
		UpdateSynchronousMachineSimplifiedCommand command = generateUpdateCommand();
		command.setSynchronousMachineSimplifiedId(entity.getSynchronousMachineSimplifiedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineSimplified." );

			// for use later on...
			synchronousMachineSimplifiedId = entity.getSynchronousMachineSimplifiedId();

			SynchronousMachineSimplifiedBusinessDelegate proxy = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance();  

			proxy.updateSynchronousMachineSimplified( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineSimplified - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineSimplifiedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineSimplified.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineSimplified." );

		SynchronousMachineSimplified entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineSimplified with id " + synchronousMachineSimplifiedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineSimplified with id " + synchronousMachineSimplifiedId );

			throw e;
		}

		try{
			SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().delete( new DeleteSynchronousMachineSimplifiedCommand( entity.getSynchronousMachineSimplifiedId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineSimplified with id " + synchronousMachineSimplifiedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineSimplified with id " + synchronousMachineSimplifiedId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineSimplifieds.
	 */
	protected List<SynchronousMachineSimplified> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineSimplifieds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineSimplified : " );        
		List<SynchronousMachineSimplified> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineSimplifiedBusinessDelegate
			collection = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().getAllSynchronousMachineSimplified();
			assertNotNull( collection, "An Empty collection of SynchronousMachineSimplified was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineSimplified entity = null;            
			Iterator<SynchronousMachineSimplified> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineSimplifiedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineSimplifiedTest
	 */
	protected SynchronousMachineSimplifiedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineSimplified
	 * 
	 * @return CreateSynchronousMachineSimplifiedCommand alias
	 */
	protected CreateSynchronousMachineSimplifiedCommand generateNewCommand() {
        CreateSynchronousMachineSimplifiedCommand command = new CreateSynchronousMachineSimplifiedCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineSimplified
		 * 
		 * @return UpdateSynchronousMachineSimplifiedCommand alias
		 */
	protected UpdateSynchronousMachineSimplifiedCommand generateUpdateCommand() {
	        UpdateSynchronousMachineSimplifiedCommand command = new UpdateSynchronousMachineSimplifiedCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineSimplifiedId = null;
	protected SynchronousMachineSimplifiedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineSimplifiedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineSimplifiedList = 0;
}
