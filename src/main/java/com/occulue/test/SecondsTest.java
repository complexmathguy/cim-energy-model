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
 * Test Seconds class.
 *
 * @author your_name_here
 */
public class SecondsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SecondsTest() {
		subscriber = new SecondsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SecondsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Seconds...");
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
	 * jumpstart the process by instantiating2 Seconds
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		secondsId = SecondsBusinessDelegate.getSecondsInstance()
		.createSeconds( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SecondsBusinessDelegate.getSecondsInstance()
				.createSeconds( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.secondsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Seconds : " + successValue.getSecondsId());
							  if (successValue.getSecondsId().equals(secondsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSecondsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Seconds test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seconds consumed")
					);
			subscriber.secondsSubscribe( secondsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Seconds : " + successValue.getSecondsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSecondsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on seconds for secondsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Seconds. 
	 */
	protected Seconds read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Seconds" );

		Seconds entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Seconds with primary key" );
		msg.append( secondsId );
		
		SecondsFetchOneSummary fetchOneSummary = new SecondsFetchOneSummary( secondsId );

		try {
			entity = SecondsBusinessDelegate.getSecondsInstance().getSeconds( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Seconds " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Seconds.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Seconds." );

		StringBuilder msg = new StringBuilder( "Failed to update a Seconds : " );        
		Seconds entity = read();
		UpdateSecondsCommand command = generateUpdateCommand();
		command.setSecondsId(entity.getSecondsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Seconds." );

			// for use later on...
			secondsId = entity.getSecondsId();

			SecondsBusinessDelegate proxy = SecondsBusinessDelegate.getSecondsInstance();  

			proxy.updateSeconds( command ).get();

			LOGGER.info( "-- Successfully saved Seconds - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + secondsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Seconds.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Seconds." );

		Seconds entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Seconds with id " + secondsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Seconds with id " + secondsId );

			throw e;
		}

		try{
			SecondsBusinessDelegate.getSecondsInstance().delete( new DeleteSecondsCommand( entity.getSecondsId() ) ).get();
			LOGGER.info( "-- Successfully deleted Seconds with id " + secondsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Seconds with id " + secondsId );

			throw e;
		}
	}

	/**
	 * get all Secondss.
	 */
	protected List<Seconds> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Secondss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Seconds : " );        
		List<Seconds> collection  = new ArrayList<>();

		try {
			// call the static get method on the SecondsBusinessDelegate
			collection = SecondsBusinessDelegate.getSecondsInstance().getAllSeconds();
			assertNotNull( collection, "An Empty collection of Seconds was incorrectly returned.");
			
			// Now print out the values
			Seconds entity = null;            
			Iterator<Seconds> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSecondsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SecondsTest
	 */
	protected SecondsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Seconds
	 * 
	 * @return CreateSecondsCommand alias
	 */
	protected CreateSecondsCommand generateNewCommand() {
        CreateSecondsCommand command = new CreateSecondsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Seconds
		 * 
		 * @return UpdateSecondsCommand alias
		 */
	protected UpdateSecondsCommand generateUpdateCommand() {
	        UpdateSecondsCommand command = new UpdateSecondsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID secondsId = null;
	protected SecondsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SecondsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSecondsList = 0;
}
