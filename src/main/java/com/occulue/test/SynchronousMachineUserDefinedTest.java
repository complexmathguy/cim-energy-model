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
 * Test SynchronousMachineUserDefined class.
 *
 * @author your_name_here
 */
public class SynchronousMachineUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SynchronousMachineUserDefinedTest() {
		subscriber = new SynchronousMachineUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SynchronousMachineUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SynchronousMachineUserDefined...");
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
	 * jumpstart the process by instantiating2 SynchronousMachineUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		synchronousMachineUserDefinedId = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
		.createSynchronousMachineUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance()
				.createSynchronousMachineUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.synchronousMachineUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SynchronousMachineUserDefined : " + successValue.getSynchronousMachineUserDefinedId());
							  if (successValue.getSynchronousMachineUserDefinedId().equals(synchronousMachineUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSynchronousMachineUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SynchronousMachineUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineUserDefined consumed")
					);
			subscriber.synchronousMachineUserDefinedSubscribe( synchronousMachineUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SynchronousMachineUserDefined : " + successValue.getSynchronousMachineUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSynchronousMachineUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on synchronousMachineUserDefined for synchronousMachineUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SynchronousMachineUserDefined. 
	 */
	protected SynchronousMachineUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SynchronousMachineUserDefined" );

		SynchronousMachineUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SynchronousMachineUserDefined with primary key" );
		msg.append( synchronousMachineUserDefinedId );
		
		SynchronousMachineUserDefinedFetchOneSummary fetchOneSummary = new SynchronousMachineUserDefinedFetchOneSummary( synchronousMachineUserDefinedId );

		try {
			entity = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().getSynchronousMachineUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SynchronousMachineUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SynchronousMachineUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SynchronousMachineUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a SynchronousMachineUserDefined : " );        
		SynchronousMachineUserDefined entity = read();
		UpdateSynchronousMachineUserDefinedCommand command = generateUpdateCommand();
		command.setSynchronousMachineUserDefinedId(entity.getSynchronousMachineUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SynchronousMachineUserDefined." );

			// for use later on...
			synchronousMachineUserDefinedId = entity.getSynchronousMachineUserDefinedId();

			SynchronousMachineUserDefinedBusinessDelegate proxy = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance();  

			proxy.updateSynchronousMachineUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved SynchronousMachineUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + synchronousMachineUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SynchronousMachineUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SynchronousMachineUserDefined." );

		SynchronousMachineUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SynchronousMachineUserDefined with id " + synchronousMachineUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SynchronousMachineUserDefined with id " + synchronousMachineUserDefinedId );

			throw e;
		}

		try{
			SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().delete( new DeleteSynchronousMachineUserDefinedCommand( entity.getSynchronousMachineUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted SynchronousMachineUserDefined with id " + synchronousMachineUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SynchronousMachineUserDefined with id " + synchronousMachineUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all SynchronousMachineUserDefineds.
	 */
	protected List<SynchronousMachineUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SynchronousMachineUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SynchronousMachineUserDefined : " );        
		List<SynchronousMachineUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the SynchronousMachineUserDefinedBusinessDelegate
			collection = SynchronousMachineUserDefinedBusinessDelegate.getSynchronousMachineUserDefinedInstance().getAllSynchronousMachineUserDefined();
			assertNotNull( collection, "An Empty collection of SynchronousMachineUserDefined was incorrectly returned.");
			
			// Now print out the values
			SynchronousMachineUserDefined entity = null;            
			Iterator<SynchronousMachineUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSynchronousMachineUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SynchronousMachineUserDefinedTest
	 */
	protected SynchronousMachineUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SynchronousMachineUserDefined
	 * 
	 * @return CreateSynchronousMachineUserDefinedCommand alias
	 */
	protected CreateSynchronousMachineUserDefinedCommand generateNewCommand() {
        CreateSynchronousMachineUserDefinedCommand command = new CreateSynchronousMachineUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SynchronousMachineUserDefined
		 * 
		 * @return UpdateSynchronousMachineUserDefinedCommand alias
		 */
	protected UpdateSynchronousMachineUserDefinedCommand generateUpdateCommand() {
	        UpdateSynchronousMachineUserDefinedCommand command = new UpdateSynchronousMachineUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID synchronousMachineUserDefinedId = null;
	protected SynchronousMachineUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SynchronousMachineUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSynchronousMachineUserDefinedList = 0;
}
