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
 * Test MutualCoupling class.
 *
 * @author your_name_here
 */
public class MutualCouplingTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MutualCouplingTest() {
		subscriber = new MutualCouplingSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MutualCouplingTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MutualCoupling...");
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
	 * jumpstart the process by instantiating2 MutualCoupling
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		mutualCouplingId = MutualCouplingBusinessDelegate.getMutualCouplingInstance()
		.createMutualCoupling( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MutualCouplingBusinessDelegate.getMutualCouplingInstance()
				.createMutualCoupling( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.mutualCouplingSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MutualCoupling : " + successValue.getMutualCouplingId());
							  if (successValue.getMutualCouplingId().equals(mutualCouplingId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMutualCouplingList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MutualCoupling test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mutualCoupling consumed")
					);
			subscriber.mutualCouplingSubscribe( mutualCouplingId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MutualCoupling : " + successValue.getMutualCouplingId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMutualCouplingList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mutualCoupling for mutualCouplingId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MutualCoupling. 
	 */
	protected MutualCoupling read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MutualCoupling" );

		MutualCoupling entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MutualCoupling with primary key" );
		msg.append( mutualCouplingId );
		
		MutualCouplingFetchOneSummary fetchOneSummary = new MutualCouplingFetchOneSummary( mutualCouplingId );

		try {
			entity = MutualCouplingBusinessDelegate.getMutualCouplingInstance().getMutualCoupling( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MutualCoupling " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MutualCoupling.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MutualCoupling." );

		StringBuilder msg = new StringBuilder( "Failed to update a MutualCoupling : " );        
		MutualCoupling entity = read();
		UpdateMutualCouplingCommand command = generateUpdateCommand();
		command.setMutualCouplingId(entity.getMutualCouplingId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MutualCoupling." );

			// for use later on...
			mutualCouplingId = entity.getMutualCouplingId();

			MutualCouplingBusinessDelegate proxy = MutualCouplingBusinessDelegate.getMutualCouplingInstance();  

			proxy.updateMutualCoupling( command ).get();

			LOGGER.info( "-- Successfully saved MutualCoupling - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + mutualCouplingId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MutualCoupling.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MutualCoupling." );

		MutualCoupling entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MutualCoupling with id " + mutualCouplingId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MutualCoupling with id " + mutualCouplingId );

			throw e;
		}

		try{
			MutualCouplingBusinessDelegate.getMutualCouplingInstance().delete( new DeleteMutualCouplingCommand( entity.getMutualCouplingId() ) ).get();
			LOGGER.info( "-- Successfully deleted MutualCoupling with id " + mutualCouplingId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MutualCoupling with id " + mutualCouplingId );

			throw e;
		}
	}

	/**
	 * get all MutualCouplings.
	 */
	protected List<MutualCoupling> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MutualCouplings:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MutualCoupling : " );        
		List<MutualCoupling> collection  = new ArrayList<>();

		try {
			// call the static get method on the MutualCouplingBusinessDelegate
			collection = MutualCouplingBusinessDelegate.getMutualCouplingInstance().getAllMutualCoupling();
			assertNotNull( collection, "An Empty collection of MutualCoupling was incorrectly returned.");
			
			// Now print out the values
			MutualCoupling entity = null;            
			Iterator<MutualCoupling> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMutualCouplingId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MutualCouplingTest
	 */
	protected MutualCouplingTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MutualCoupling
	 * 
	 * @return CreateMutualCouplingCommand alias
	 */
	protected CreateMutualCouplingCommand generateNewCommand() {
        CreateMutualCouplingCommand command = new CreateMutualCouplingCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated MutualCoupling
		 * 
		 * @return UpdateMutualCouplingCommand alias
		 */
	protected UpdateMutualCouplingCommand generateUpdateCommand() {
	        UpdateMutualCouplingCommand command = new UpdateMutualCouplingCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID mutualCouplingId = null;
	protected MutualCouplingSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MutualCouplingTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMutualCouplingList = 0;
}
