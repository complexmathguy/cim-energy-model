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
 * Test AngleDegrees class.
 *
 * @author your_name_here
 */
public class AngleDegreesTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public AngleDegreesTest() {
		subscriber = new AngleDegreesSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate AngleDegreesTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on AngleDegrees...");
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
	 * jumpstart the process by instantiating2 AngleDegrees
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		angleDegreesId = AngleDegreesBusinessDelegate.getAngleDegreesInstance()
		.createAngleDegrees( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		AngleDegreesBusinessDelegate.getAngleDegreesInstance()
				.createAngleDegrees( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.angleDegreesSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for AngleDegrees : " + successValue.getAngleDegreesId());
							  if (successValue.getAngleDegreesId().equals(angleDegreesId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfAngleDegreesList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("AngleDegrees test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on angleDegrees consumed")
					);
			subscriber.angleDegreesSubscribe( angleDegreesId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for AngleDegrees : " + successValue.getAngleDegreesId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfAngleDegreesList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on angleDegrees for angleDegreesId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a AngleDegrees. 
	 */
	protected AngleDegrees read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created AngleDegrees" );

		AngleDegrees entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read AngleDegrees with primary key" );
		msg.append( angleDegreesId );
		
		AngleDegreesFetchOneSummary fetchOneSummary = new AngleDegreesFetchOneSummary( angleDegreesId );

		try {
			entity = AngleDegreesBusinessDelegate.getAngleDegreesInstance().getAngleDegrees( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found AngleDegrees " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a AngleDegrees.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a AngleDegrees." );

		StringBuilder msg = new StringBuilder( "Failed to update a AngleDegrees : " );        
		AngleDegrees entity = read();
		UpdateAngleDegreesCommand command = generateUpdateCommand();
		command.setAngleDegreesId(entity.getAngleDegreesId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created AngleDegrees." );

			// for use later on...
			angleDegreesId = entity.getAngleDegreesId();

			AngleDegreesBusinessDelegate proxy = AngleDegreesBusinessDelegate.getAngleDegreesInstance();  

			proxy.updateAngleDegrees( command ).get();

			LOGGER.info( "-- Successfully saved AngleDegrees - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + angleDegreesId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a AngleDegrees.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created AngleDegrees." );

		AngleDegrees entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read AngleDegrees with id " + angleDegreesId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read AngleDegrees with id " + angleDegreesId );

			throw e;
		}

		try{
			AngleDegreesBusinessDelegate.getAngleDegreesInstance().delete( new DeleteAngleDegreesCommand( entity.getAngleDegreesId() ) ).get();
			LOGGER.info( "-- Successfully deleted AngleDegrees with id " + angleDegreesId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete AngleDegrees with id " + angleDegreesId );

			throw e;
		}
	}

	/**
	 * get all AngleDegreess.
	 */
	protected List<AngleDegrees> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of AngleDegreess:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all AngleDegrees : " );        
		List<AngleDegrees> collection  = new ArrayList<>();

		try {
			// call the static get method on the AngleDegreesBusinessDelegate
			collection = AngleDegreesBusinessDelegate.getAngleDegreesInstance().getAllAngleDegrees();
			assertNotNull( collection, "An Empty collection of AngleDegrees was incorrectly returned.");
			
			// Now print out the values
			AngleDegrees entity = null;            
			Iterator<AngleDegrees> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getAngleDegreesId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		AngleDegreesTest
	 */
	protected AngleDegreesTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated AngleDegrees
	 * 
	 * @return CreateAngleDegreesCommand alias
	 */
	protected CreateAngleDegreesCommand generateNewCommand() {
        CreateAngleDegreesCommand command = new CreateAngleDegreesCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated AngleDegrees
		 * 
		 * @return UpdateAngleDegreesCommand alias
		 */
	protected UpdateAngleDegreesCommand generateUpdateCommand() {
	        UpdateAngleDegreesCommand command = new UpdateAngleDegreesCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID angleDegreesId = null;
	protected AngleDegreesSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(AngleDegreesTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfAngleDegreesList = 0;
}
