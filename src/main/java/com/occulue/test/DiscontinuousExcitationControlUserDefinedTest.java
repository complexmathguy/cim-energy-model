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
 * Test DiscontinuousExcitationControlUserDefined class.
 *
 * @author your_name_here
 */
public class DiscontinuousExcitationControlUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscontinuousExcitationControlUserDefinedTest() {
		subscriber = new DiscontinuousExcitationControlUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscontinuousExcitationControlUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscontinuousExcitationControlUserDefined...");
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
	 * jumpstart the process by instantiating2 DiscontinuousExcitationControlUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discontinuousExcitationControlUserDefinedId = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance()
		.createDiscontinuousExcitationControlUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance()
				.createDiscontinuousExcitationControlUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discontinuousExcitationControlUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscontinuousExcitationControlUserDefined : " + successValue.getDiscontinuousExcitationControlUserDefinedId());
							  if (successValue.getDiscontinuousExcitationControlUserDefinedId().equals(discontinuousExcitationControlUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscontinuousExcitationControlUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscontinuousExcitationControlUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discontinuousExcitationControlUserDefined consumed")
					);
			subscriber.discontinuousExcitationControlUserDefinedSubscribe( discontinuousExcitationControlUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscontinuousExcitationControlUserDefined : " + successValue.getDiscontinuousExcitationControlUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscontinuousExcitationControlUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discontinuousExcitationControlUserDefined for discontinuousExcitationControlUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscontinuousExcitationControlUserDefined. 
	 */
	protected DiscontinuousExcitationControlUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscontinuousExcitationControlUserDefined" );

		DiscontinuousExcitationControlUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscontinuousExcitationControlUserDefined with primary key" );
		msg.append( discontinuousExcitationControlUserDefinedId );
		
		DiscontinuousExcitationControlUserDefinedFetchOneSummary fetchOneSummary = new DiscontinuousExcitationControlUserDefinedFetchOneSummary( discontinuousExcitationControlUserDefinedId );

		try {
			entity = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().getDiscontinuousExcitationControlUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscontinuousExcitationControlUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscontinuousExcitationControlUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscontinuousExcitationControlUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscontinuousExcitationControlUserDefined : " );        
		DiscontinuousExcitationControlUserDefined entity = read();
		UpdateDiscontinuousExcitationControlUserDefinedCommand command = generateUpdateCommand();
		command.setDiscontinuousExcitationControlUserDefinedId(entity.getDiscontinuousExcitationControlUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscontinuousExcitationControlUserDefined." );

			// for use later on...
			discontinuousExcitationControlUserDefinedId = entity.getDiscontinuousExcitationControlUserDefinedId();

			DiscontinuousExcitationControlUserDefinedBusinessDelegate proxy = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance();  

			proxy.updateDiscontinuousExcitationControlUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved DiscontinuousExcitationControlUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discontinuousExcitationControlUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscontinuousExcitationControlUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscontinuousExcitationControlUserDefined." );

		DiscontinuousExcitationControlUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscontinuousExcitationControlUserDefined with id " + discontinuousExcitationControlUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscontinuousExcitationControlUserDefined with id " + discontinuousExcitationControlUserDefinedId );

			throw e;
		}

		try{
			DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().delete( new DeleteDiscontinuousExcitationControlUserDefinedCommand( entity.getDiscontinuousExcitationControlUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscontinuousExcitationControlUserDefined with id " + discontinuousExcitationControlUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscontinuousExcitationControlUserDefined with id " + discontinuousExcitationControlUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all DiscontinuousExcitationControlUserDefineds.
	 */
	protected List<DiscontinuousExcitationControlUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscontinuousExcitationControlUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscontinuousExcitationControlUserDefined : " );        
		List<DiscontinuousExcitationControlUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscontinuousExcitationControlUserDefinedBusinessDelegate
			collection = DiscontinuousExcitationControlUserDefinedBusinessDelegate.getDiscontinuousExcitationControlUserDefinedInstance().getAllDiscontinuousExcitationControlUserDefined();
			assertNotNull( collection, "An Empty collection of DiscontinuousExcitationControlUserDefined was incorrectly returned.");
			
			// Now print out the values
			DiscontinuousExcitationControlUserDefined entity = null;            
			Iterator<DiscontinuousExcitationControlUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscontinuousExcitationControlUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscontinuousExcitationControlUserDefinedTest
	 */
	protected DiscontinuousExcitationControlUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscontinuousExcitationControlUserDefined
	 * 
	 * @return CreateDiscontinuousExcitationControlUserDefinedCommand alias
	 */
	protected CreateDiscontinuousExcitationControlUserDefinedCommand generateNewCommand() {
        CreateDiscontinuousExcitationControlUserDefinedCommand command = new CreateDiscontinuousExcitationControlUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscontinuousExcitationControlUserDefined
		 * 
		 * @return UpdateDiscontinuousExcitationControlUserDefinedCommand alias
		 */
	protected UpdateDiscontinuousExcitationControlUserDefinedCommand generateUpdateCommand() {
	        UpdateDiscontinuousExcitationControlUserDefinedCommand command = new UpdateDiscontinuousExcitationControlUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discontinuousExcitationControlUserDefinedId = null;
	protected DiscontinuousExcitationControlUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscontinuousExcitationControlUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscontinuousExcitationControlUserDefinedList = 0;
}
