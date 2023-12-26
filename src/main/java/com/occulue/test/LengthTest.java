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
 * Test Length class.
 *
 * @author your_name_here
 */
public class LengthTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LengthTest() {
		subscriber = new LengthSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LengthTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Length...");
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
	 * jumpstart the process by instantiating2 Length
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		lengthId = LengthBusinessDelegate.getLengthInstance()
		.createLength( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LengthBusinessDelegate.getLengthInstance()
				.createLength( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.lengthSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Length : " + successValue.getLengthId());
							  if (successValue.getLengthId().equals(lengthId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLengthList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Length test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on length consumed")
					);
			subscriber.lengthSubscribe( lengthId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Length : " + successValue.getLengthId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLengthList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on length for lengthId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Length. 
	 */
	protected Length read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Length" );

		Length entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Length with primary key" );
		msg.append( lengthId );
		
		LengthFetchOneSummary fetchOneSummary = new LengthFetchOneSummary( lengthId );

		try {
			entity = LengthBusinessDelegate.getLengthInstance().getLength( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Length " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Length.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Length." );

		StringBuilder msg = new StringBuilder( "Failed to update a Length : " );        
		Length entity = read();
		UpdateLengthCommand command = generateUpdateCommand();
		command.setLengthId(entity.getLengthId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Length." );

			// for use later on...
			lengthId = entity.getLengthId();

			LengthBusinessDelegate proxy = LengthBusinessDelegate.getLengthInstance();  

			proxy.updateLength( command ).get();

			LOGGER.info( "-- Successfully saved Length - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + lengthId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Length.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Length." );

		Length entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Length with id " + lengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Length with id " + lengthId );

			throw e;
		}

		try{
			LengthBusinessDelegate.getLengthInstance().delete( new DeleteLengthCommand( entity.getLengthId() ) ).get();
			LOGGER.info( "-- Successfully deleted Length with id " + lengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Length with id " + lengthId );

			throw e;
		}
	}

	/**
	 * get all Lengths.
	 */
	protected List<Length> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Lengths:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Length : " );        
		List<Length> collection  = new ArrayList<>();

		try {
			// call the static get method on the LengthBusinessDelegate
			collection = LengthBusinessDelegate.getLengthInstance().getAllLength();
			assertNotNull( collection, "An Empty collection of Length was incorrectly returned.");
			
			// Now print out the values
			Length entity = null;            
			Iterator<Length> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLengthId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LengthTest
	 */
	protected LengthTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Length
	 * 
	 * @return CreateLengthCommand alias
	 */
	protected CreateLengthCommand generateNewCommand() {
        CreateLengthCommand command = new CreateLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Length
		 * 
		 * @return UpdateLengthCommand alias
		 */
	protected UpdateLengthCommand generateUpdateCommand() {
	        UpdateLengthCommand command = new UpdateLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID lengthId = null;
	protected LengthSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LengthTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLengthList = 0;
}
