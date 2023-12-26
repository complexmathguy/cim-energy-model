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
 * Test UnderexcitationLimiterUserDefined class.
 *
 * @author your_name_here
 */
public class UnderexcitationLimiterUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcitationLimiterUserDefinedTest() {
		subscriber = new UnderexcitationLimiterUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcitationLimiterUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcitationLimiterUserDefined...");
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
	 * jumpstart the process by instantiating2 UnderexcitationLimiterUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcitationLimiterUserDefinedId = UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance()
		.createUnderexcitationLimiterUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance()
				.createUnderexcitationLimiterUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcitationLimiterUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcitationLimiterUserDefined : " + successValue.getUnderexcitationLimiterUserDefinedId());
							  if (successValue.getUnderexcitationLimiterUserDefinedId().equals(underexcitationLimiterUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcitationLimiterUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcitationLimiterUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcitationLimiterUserDefined consumed")
					);
			subscriber.underexcitationLimiterUserDefinedSubscribe( underexcitationLimiterUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcitationLimiterUserDefined : " + successValue.getUnderexcitationLimiterUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcitationLimiterUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcitationLimiterUserDefined for underexcitationLimiterUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcitationLimiterUserDefined. 
	 */
	protected UnderexcitationLimiterUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcitationLimiterUserDefined" );

		UnderexcitationLimiterUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcitationLimiterUserDefined with primary key" );
		msg.append( underexcitationLimiterUserDefinedId );
		
		UnderexcitationLimiterUserDefinedFetchOneSummary fetchOneSummary = new UnderexcitationLimiterUserDefinedFetchOneSummary( underexcitationLimiterUserDefinedId );

		try {
			entity = UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance().getUnderexcitationLimiterUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcitationLimiterUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcitationLimiterUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcitationLimiterUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcitationLimiterUserDefined : " );        
		UnderexcitationLimiterUserDefined entity = read();
		UpdateUnderexcitationLimiterUserDefinedCommand command = generateUpdateCommand();
		command.setUnderexcitationLimiterUserDefinedId(entity.getUnderexcitationLimiterUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcitationLimiterUserDefined." );

			// for use later on...
			underexcitationLimiterUserDefinedId = entity.getUnderexcitationLimiterUserDefinedId();

			UnderexcitationLimiterUserDefinedBusinessDelegate proxy = UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance();  

			proxy.updateUnderexcitationLimiterUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcitationLimiterUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcitationLimiterUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcitationLimiterUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcitationLimiterUserDefined." );

		UnderexcitationLimiterUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcitationLimiterUserDefined with id " + underexcitationLimiterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcitationLimiterUserDefined with id " + underexcitationLimiterUserDefinedId );

			throw e;
		}

		try{
			UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance().delete( new DeleteUnderexcitationLimiterUserDefinedCommand( entity.getUnderexcitationLimiterUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcitationLimiterUserDefined with id " + underexcitationLimiterUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcitationLimiterUserDefined with id " + underexcitationLimiterUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all UnderexcitationLimiterUserDefineds.
	 */
	protected List<UnderexcitationLimiterUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcitationLimiterUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcitationLimiterUserDefined : " );        
		List<UnderexcitationLimiterUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcitationLimiterUserDefinedBusinessDelegate
			collection = UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance().getAllUnderexcitationLimiterUserDefined();
			assertNotNull( collection, "An Empty collection of UnderexcitationLimiterUserDefined was incorrectly returned.");
			
			// Now print out the values
			UnderexcitationLimiterUserDefined entity = null;            
			Iterator<UnderexcitationLimiterUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcitationLimiterUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcitationLimiterUserDefinedTest
	 */
	protected UnderexcitationLimiterUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcitationLimiterUserDefined
	 * 
	 * @return CreateUnderexcitationLimiterUserDefinedCommand alias
	 */
	protected CreateUnderexcitationLimiterUserDefinedCommand generateNewCommand() {
        CreateUnderexcitationLimiterUserDefinedCommand command = new CreateUnderexcitationLimiterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcitationLimiterUserDefined
		 * 
		 * @return UpdateUnderexcitationLimiterUserDefinedCommand alias
		 */
	protected UpdateUnderexcitationLimiterUserDefinedCommand generateUpdateCommand() {
	        UpdateUnderexcitationLimiterUserDefinedCommand command = new UpdateUnderexcitationLimiterUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcitationLimiterUserDefinedId = null;
	protected UnderexcitationLimiterUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcitationLimiterUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcitationLimiterUserDefinedList = 0;
}
