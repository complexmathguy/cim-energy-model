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
 * Test AngleRadians class.
 *
 * @author your_name_here
 */
public class AngleRadiansTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AngleRadiansTest() {
		subscriber = new AngleRadiansSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AngleRadiansTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AngleRadians...");
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
	 * jumpstart the process by instantiating2 AngleRadians
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		angleRadiansId = AngleRadiansBusinessDelegate.getAngleRadiansInstance()
		.createAngleRadians( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AngleRadiansBusinessDelegate.getAngleRadiansInstance()
				.createAngleRadians( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.angleRadiansSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AngleRadians : " + successValue.getAngleRadiansId());
							  if (successValue.getAngleRadiansId().equals(angleRadiansId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAngleRadiansList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AngleRadians test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on angleRadians consumed")
					);
			subscriber.angleRadiansSubscribe( angleRadiansId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AngleRadians : " + successValue.getAngleRadiansId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAngleRadiansList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on angleRadians for angleRadiansId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AngleRadians. 
	 */
	protected AngleRadians read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AngleRadians" );

		AngleRadians entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AngleRadians with primary key" );
		msg.append( angleRadiansId );
		
		AngleRadiansFetchOneSummary fetchOneSummary = new AngleRadiansFetchOneSummary( angleRadiansId );

		try {
			entity = AngleRadiansBusinessDelegate.getAngleRadiansInstance().getAngleRadians( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AngleRadians " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AngleRadians.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AngleRadians." );

		StringBuilder msg = new StringBuilder( "Failed to update a AngleRadians : " );        
		AngleRadians entity = read();
		UpdateAngleRadiansCommand command = generateUpdateCommand();
		command.setAngleRadiansId(entity.getAngleRadiansId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AngleRadians." );

			// for use later on...
			angleRadiansId = entity.getAngleRadiansId();

			AngleRadiansBusinessDelegate proxy = AngleRadiansBusinessDelegate.getAngleRadiansInstance();  

			proxy.updateAngleRadians( command ).get();

			LOGGER.info( "-- Successfully saved AngleRadians - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + angleRadiansId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AngleRadians.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AngleRadians." );

		AngleRadians entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AngleRadians with id " + angleRadiansId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AngleRadians with id " + angleRadiansId );

			throw e;
		}

		try{
			AngleRadiansBusinessDelegate.getAngleRadiansInstance().delete( new DeleteAngleRadiansCommand( entity.getAngleRadiansId() ) ).get();
			LOGGER.info( "-- Successfully deleted AngleRadians with id " + angleRadiansId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AngleRadians with id " + angleRadiansId );

			throw e;
		}
	}

	/**
	 * get all AngleRadianss.
	 */
	protected List<AngleRadians> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AngleRadianss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AngleRadians : " );        
		List<AngleRadians> collection  = new ArrayList<>();

		try {
			// call the static get method on the AngleRadiansBusinessDelegate
			collection = AngleRadiansBusinessDelegate.getAngleRadiansInstance().getAllAngleRadians();
			assertNotNull( collection, "An Empty collection of AngleRadians was incorrectly returned.");
			
			// Now print out the values
			AngleRadians entity = null;            
			Iterator<AngleRadians> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAngleRadiansId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AngleRadiansTest
	 */
	protected AngleRadiansTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AngleRadians
	 * 
	 * @return CreateAngleRadiansCommand alias
	 */
	protected CreateAngleRadiansCommand generateNewCommand() {
        CreateAngleRadiansCommand command = new CreateAngleRadiansCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AngleRadians
		 * 
		 * @return UpdateAngleRadiansCommand alias
		 */
	protected UpdateAngleRadiansCommand generateUpdateCommand() {
	        UpdateAngleRadiansCommand command = new UpdateAngleRadiansCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID angleRadiansId = null;
	protected AngleRadiansSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AngleRadiansTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAngleRadiansList = 0;
}
