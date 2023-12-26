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
 * Test EquivalentBranch class.
 *
 * @author your_name_here
 */
public class EquivalentBranchTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquivalentBranchTest() {
		subscriber = new EquivalentBranchSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquivalentBranchTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquivalentBranch...");
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
	 * jumpstart the process by instantiating2 EquivalentBranch
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equivalentBranchId = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance()
		.createEquivalentBranch( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquivalentBranchBusinessDelegate.getEquivalentBranchInstance()
				.createEquivalentBranch( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equivalentBranchSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquivalentBranch : " + successValue.getEquivalentBranchId());
							  if (successValue.getEquivalentBranchId().equals(equivalentBranchId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquivalentBranchList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquivalentBranch test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentBranch consumed")
					);
			subscriber.equivalentBranchSubscribe( equivalentBranchId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquivalentBranch : " + successValue.getEquivalentBranchId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquivalentBranchList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equivalentBranch for equivalentBranchId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquivalentBranch. 
	 */
	protected EquivalentBranch read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquivalentBranch" );

		EquivalentBranch entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquivalentBranch with primary key" );
		msg.append( equivalentBranchId );
		
		EquivalentBranchFetchOneSummary fetchOneSummary = new EquivalentBranchFetchOneSummary( equivalentBranchId );

		try {
			entity = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().getEquivalentBranch( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquivalentBranch " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquivalentBranch.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquivalentBranch." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquivalentBranch : " );        
		EquivalentBranch entity = read();
		UpdateEquivalentBranchCommand command = generateUpdateCommand();
		command.setEquivalentBranchId(entity.getEquivalentBranchId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquivalentBranch." );

			// for use later on...
			equivalentBranchId = entity.getEquivalentBranchId();

			EquivalentBranchBusinessDelegate proxy = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();  

			proxy.updateEquivalentBranch( command ).get();

			LOGGER.info( "-- Successfully saved EquivalentBranch - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equivalentBranchId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquivalentBranch.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquivalentBranch." );

		EquivalentBranch entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquivalentBranch with id " + equivalentBranchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquivalentBranch with id " + equivalentBranchId );

			throw e;
		}

		try{
			EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().delete( new DeleteEquivalentBranchCommand( entity.getEquivalentBranchId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquivalentBranch with id " + equivalentBranchId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquivalentBranch with id " + equivalentBranchId );

			throw e;
		}
	}

	/**
	 * get all EquivalentBranchs.
	 */
	protected List<EquivalentBranch> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquivalentBranchs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquivalentBranch : " );        
		List<EquivalentBranch> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquivalentBranchBusinessDelegate
			collection = EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().getAllEquivalentBranch();
			assertNotNull( collection, "An Empty collection of EquivalentBranch was incorrectly returned.");
			
			// Now print out the values
			EquivalentBranch entity = null;            
			Iterator<EquivalentBranch> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquivalentBranchId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquivalentBranchTest
	 */
	protected EquivalentBranchTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquivalentBranch
	 * 
	 * @return CreateEquivalentBranchCommand alias
	 */
	protected CreateEquivalentBranchCommand generateNewCommand() {
        CreateEquivalentBranchCommand command = new CreateEquivalentBranchCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EquivalentBranch
		 * 
		 * @return UpdateEquivalentBranchCommand alias
		 */
	protected UpdateEquivalentBranchCommand generateUpdateCommand() {
	        UpdateEquivalentBranchCommand command = new UpdateEquivalentBranchCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equivalentBranchId = null;
	protected EquivalentBranchSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquivalentBranchTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquivalentBranchList = 0;
}
