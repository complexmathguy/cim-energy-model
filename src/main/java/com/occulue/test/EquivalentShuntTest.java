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
 * Test EquivalentShunt class.
 *
 * @author your_name_here
 */
public class EquivalentShuntTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquivalentShuntTest() {
		subscriber = new EquivalentShuntSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquivalentShuntTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquivalentShunt...");
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
	 * jumpstart the process by instantiating2 EquivalentShunt
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equivalentShuntId = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance()
		.createEquivalentShunt( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquivalentShuntBusinessDelegate.getEquivalentShuntInstance()
				.createEquivalentShunt( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equivalentShuntSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquivalentShunt : " + successValue.getEquivalentShuntId());
							  if (successValue.getEquivalentShuntId().equals(equivalentShuntId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquivalentShuntList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquivalentShunt test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentShunt consumed")
					);
			subscriber.equivalentShuntSubscribe( equivalentShuntId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquivalentShunt : " + successValue.getEquivalentShuntId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquivalentShuntList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentShunt for equivalentShuntId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquivalentShunt. 
	 */
	protected EquivalentShunt read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquivalentShunt" );

		EquivalentShunt entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquivalentShunt with primary key" );
		msg.append( equivalentShuntId );
		
		EquivalentShuntFetchOneSummary fetchOneSummary = new EquivalentShuntFetchOneSummary( equivalentShuntId );

		try {
			entity = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().getEquivalentShunt( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquivalentShunt " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquivalentShunt.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquivalentShunt." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquivalentShunt : " );        
		EquivalentShunt entity = read();
		UpdateEquivalentShuntCommand command = generateUpdateCommand();
		command.setEquivalentShuntId(entity.getEquivalentShuntId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquivalentShunt." );

			// for use later on...
			equivalentShuntId = entity.getEquivalentShuntId();

			EquivalentShuntBusinessDelegate proxy = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance();  

			proxy.updateEquivalentShunt( command ).get();

			LOGGER.info( "-- Successfully saved EquivalentShunt - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equivalentShuntId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquivalentShunt.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquivalentShunt." );

		EquivalentShunt entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquivalentShunt with id " + equivalentShuntId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquivalentShunt with id " + equivalentShuntId );

			throw e;
		}

		try{
			EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().delete( new DeleteEquivalentShuntCommand( entity.getEquivalentShuntId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquivalentShunt with id " + equivalentShuntId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquivalentShunt with id " + equivalentShuntId );

			throw e;
		}
	}

	/**
	 * get all EquivalentShunts.
	 */
	protected List<EquivalentShunt> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquivalentShunts:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquivalentShunt : " );        
		List<EquivalentShunt> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquivalentShuntBusinessDelegate
			collection = EquivalentShuntBusinessDelegate.getEquivalentShuntInstance().getAllEquivalentShunt();
			assertNotNull( collection, "An Empty collection of EquivalentShunt was incorrectly returned.");
			
			// Now print out the values
			EquivalentShunt entity = null;            
			Iterator<EquivalentShunt> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquivalentShuntId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquivalentShuntTest
	 */
	protected EquivalentShuntTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquivalentShunt
	 * 
	 * @return CreateEquivalentShuntCommand alias
	 */
	protected CreateEquivalentShuntCommand generateNewCommand() {
        CreateEquivalentShuntCommand command = new CreateEquivalentShuntCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EquivalentShunt
		 * 
		 * @return UpdateEquivalentShuntCommand alias
		 */
	protected UpdateEquivalentShuntCommand generateUpdateCommand() {
	        UpdateEquivalentShuntCommand command = new UpdateEquivalentShuntCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equivalentShuntId = null;
	protected EquivalentShuntSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquivalentShuntTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquivalentShuntList = 0;
}
