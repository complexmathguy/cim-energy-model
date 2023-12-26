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
 * Test WindType3or4UserDefined class.
 *
 * @author your_name_here
 */
public class WindType3or4UserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindType3or4UserDefinedTest() {
		subscriber = new WindType3or4UserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindType3or4UserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindType3or4UserDefined...");
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
	 * jumpstart the process by instantiating2 WindType3or4UserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windType3or4UserDefinedId = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
		.createWindType3or4UserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance()
				.createWindType3or4UserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windType3or4UserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindType3or4UserDefined : " + successValue.getWindType3or4UserDefinedId());
							  if (successValue.getWindType3or4UserDefinedId().equals(windType3or4UserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindType3or4UserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindType3or4UserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windType3or4UserDefined consumed")
					);
			subscriber.windType3or4UserDefinedSubscribe( windType3or4UserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindType3or4UserDefined : " + successValue.getWindType3or4UserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindType3or4UserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windType3or4UserDefined for windType3or4UserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindType3or4UserDefined. 
	 */
	protected WindType3or4UserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindType3or4UserDefined" );

		WindType3or4UserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindType3or4UserDefined with primary key" );
		msg.append( windType3or4UserDefinedId );
		
		WindType3or4UserDefinedFetchOneSummary fetchOneSummary = new WindType3or4UserDefinedFetchOneSummary( windType3or4UserDefinedId );

		try {
			entity = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().getWindType3or4UserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindType3or4UserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindType3or4UserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindType3or4UserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindType3or4UserDefined : " );        
		WindType3or4UserDefined entity = read();
		UpdateWindType3or4UserDefinedCommand command = generateUpdateCommand();
		command.setWindType3or4UserDefinedId(entity.getWindType3or4UserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindType3or4UserDefined." );

			// for use later on...
			windType3or4UserDefinedId = entity.getWindType3or4UserDefinedId();

			WindType3or4UserDefinedBusinessDelegate proxy = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance();  

			proxy.updateWindType3or4UserDefined( command ).get();

			LOGGER.info( "-- Successfully saved WindType3or4UserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windType3or4UserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindType3or4UserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindType3or4UserDefined." );

		WindType3or4UserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindType3or4UserDefined with id " + windType3or4UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindType3or4UserDefined with id " + windType3or4UserDefinedId );

			throw e;
		}

		try{
			WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().delete( new DeleteWindType3or4UserDefinedCommand( entity.getWindType3or4UserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindType3or4UserDefined with id " + windType3or4UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindType3or4UserDefined with id " + windType3or4UserDefinedId );

			throw e;
		}
	}

	/**
	 * get all WindType3or4UserDefineds.
	 */
	protected List<WindType3or4UserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindType3or4UserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindType3or4UserDefined : " );        
		List<WindType3or4UserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindType3or4UserDefinedBusinessDelegate
			collection = WindType3or4UserDefinedBusinessDelegate.getWindType3or4UserDefinedInstance().getAllWindType3or4UserDefined();
			assertNotNull( collection, "An Empty collection of WindType3or4UserDefined was incorrectly returned.");
			
			// Now print out the values
			WindType3or4UserDefined entity = null;            
			Iterator<WindType3or4UserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindType3or4UserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindType3or4UserDefinedTest
	 */
	protected WindType3or4UserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindType3or4UserDefined
	 * 
	 * @return CreateWindType3or4UserDefinedCommand alias
	 */
	protected CreateWindType3or4UserDefinedCommand generateNewCommand() {
        CreateWindType3or4UserDefinedCommand command = new CreateWindType3or4UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindType3or4UserDefined
		 * 
		 * @return UpdateWindType3or4UserDefinedCommand alias
		 */
	protected UpdateWindType3or4UserDefinedCommand generateUpdateCommand() {
	        UpdateWindType3or4UserDefinedCommand command = new UpdateWindType3or4UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windType3or4UserDefinedId = null;
	protected WindType3or4UserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindType3or4UserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindType3or4UserDefinedList = 0;
}
