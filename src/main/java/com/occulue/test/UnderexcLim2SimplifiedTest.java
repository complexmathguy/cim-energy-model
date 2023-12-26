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
 * Test UnderexcLim2Simplified class.
 *
 * @author your_name_here
 */
public class UnderexcLim2SimplifiedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcLim2SimplifiedTest() {
		subscriber = new UnderexcLim2SimplifiedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcLim2SimplifiedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcLim2Simplified...");
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
	 * jumpstart the process by instantiating2 UnderexcLim2Simplified
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcLim2SimplifiedId = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
		.createUnderexcLim2Simplified( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance()
				.createUnderexcLim2Simplified( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcLim2SimplifiedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcLim2Simplified : " + successValue.getUnderexcLim2SimplifiedId());
							  if (successValue.getUnderexcLim2SimplifiedId().equals(underexcLim2SimplifiedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcLim2SimplifiedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcLim2Simplified test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLim2Simplified consumed")
					);
			subscriber.underexcLim2SimplifiedSubscribe( underexcLim2SimplifiedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcLim2Simplified : " + successValue.getUnderexcLim2SimplifiedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcLim2SimplifiedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLim2Simplified for underexcLim2SimplifiedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcLim2Simplified. 
	 */
	protected UnderexcLim2Simplified read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcLim2Simplified" );

		UnderexcLim2Simplified entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcLim2Simplified with primary key" );
		msg.append( underexcLim2SimplifiedId );
		
		UnderexcLim2SimplifiedFetchOneSummary fetchOneSummary = new UnderexcLim2SimplifiedFetchOneSummary( underexcLim2SimplifiedId );

		try {
			entity = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().getUnderexcLim2Simplified( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcLim2Simplified " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcLim2Simplified.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcLim2Simplified." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcLim2Simplified : " );        
		UnderexcLim2Simplified entity = read();
		UpdateUnderexcLim2SimplifiedCommand command = generateUpdateCommand();
		command.setUnderexcLim2SimplifiedId(entity.getUnderexcLim2SimplifiedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcLim2Simplified." );

			// for use later on...
			underexcLim2SimplifiedId = entity.getUnderexcLim2SimplifiedId();

			UnderexcLim2SimplifiedBusinessDelegate proxy = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance();  

			proxy.updateUnderexcLim2Simplified( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcLim2Simplified - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcLim2SimplifiedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcLim2Simplified.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcLim2Simplified." );

		UnderexcLim2Simplified entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcLim2Simplified with id " + underexcLim2SimplifiedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcLim2Simplified with id " + underexcLim2SimplifiedId );

			throw e;
		}

		try{
			UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().delete( new DeleteUnderexcLim2SimplifiedCommand( entity.getUnderexcLim2SimplifiedId() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcLim2Simplified with id " + underexcLim2SimplifiedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcLim2Simplified with id " + underexcLim2SimplifiedId );

			throw e;
		}
	}

	/**
	 * get all UnderexcLim2Simplifieds.
	 */
	protected List<UnderexcLim2Simplified> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcLim2Simplifieds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcLim2Simplified : " );        
		List<UnderexcLim2Simplified> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcLim2SimplifiedBusinessDelegate
			collection = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().getAllUnderexcLim2Simplified();
			assertNotNull( collection, "An Empty collection of UnderexcLim2Simplified was incorrectly returned.");
			
			// Now print out the values
			UnderexcLim2Simplified entity = null;            
			Iterator<UnderexcLim2Simplified> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcLim2SimplifiedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcLim2SimplifiedTest
	 */
	protected UnderexcLim2SimplifiedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcLim2Simplified
	 * 
	 * @return CreateUnderexcLim2SimplifiedCommand alias
	 */
	protected CreateUnderexcLim2SimplifiedCommand generateNewCommand() {
        CreateUnderexcLim2SimplifiedCommand command = new CreateUnderexcLim2SimplifiedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcLim2Simplified
		 * 
		 * @return UpdateUnderexcLim2SimplifiedCommand alias
		 */
	protected UpdateUnderexcLim2SimplifiedCommand generateUpdateCommand() {
	        UpdateUnderexcLim2SimplifiedCommand command = new UpdateUnderexcLim2SimplifiedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcLim2SimplifiedId = null;
	protected UnderexcLim2SimplifiedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcLim2SimplifiedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcLim2SimplifiedList = 0;
}
