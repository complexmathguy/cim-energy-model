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
 * Test WindType1or2UserDefined class.
 *
 * @author your_name_here
 */
public class WindType1or2UserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public WindType1or2UserDefinedTest() {
		subscriber = new WindType1or2UserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate WindType1or2UserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on WindType1or2UserDefined...");
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
	 * jumpstart the process by instantiating2 WindType1or2UserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		windType1or2UserDefinedId = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance()
		.createWindType1or2UserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance()
				.createWindType1or2UserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.windType1or2UserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for WindType1or2UserDefined : " + successValue.getWindType1or2UserDefinedId());
							  if (successValue.getWindType1or2UserDefinedId().equals(windType1or2UserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfWindType1or2UserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("WindType1or2UserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windType1or2UserDefined consumed")
					);
			subscriber.windType1or2UserDefinedSubscribe( windType1or2UserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for WindType1or2UserDefined : " + successValue.getWindType1or2UserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfWindType1or2UserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on windType1or2UserDefined for windType1or2UserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a WindType1or2UserDefined. 
	 */
	protected WindType1or2UserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created WindType1or2UserDefined" );

		WindType1or2UserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read WindType1or2UserDefined with primary key" );
		msg.append( windType1or2UserDefinedId );
		
		WindType1or2UserDefinedFetchOneSummary fetchOneSummary = new WindType1or2UserDefinedFetchOneSummary( windType1or2UserDefinedId );

		try {
			entity = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().getWindType1or2UserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found WindType1or2UserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a WindType1or2UserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a WindType1or2UserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a WindType1or2UserDefined : " );        
		WindType1or2UserDefined entity = read();
		UpdateWindType1or2UserDefinedCommand command = generateUpdateCommand();
		command.setWindType1or2UserDefinedId(entity.getWindType1or2UserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created WindType1or2UserDefined." );

			// for use later on...
			windType1or2UserDefinedId = entity.getWindType1or2UserDefinedId();

			WindType1or2UserDefinedBusinessDelegate proxy = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance();  

			proxy.updateWindType1or2UserDefined( command ).get();

			LOGGER.info( "-- Successfully saved WindType1or2UserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + windType1or2UserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a WindType1or2UserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created WindType1or2UserDefined." );

		WindType1or2UserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read WindType1or2UserDefined with id " + windType1or2UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read WindType1or2UserDefined with id " + windType1or2UserDefinedId );

			throw e;
		}

		try{
			WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().delete( new DeleteWindType1or2UserDefinedCommand( entity.getWindType1or2UserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted WindType1or2UserDefined with id " + windType1or2UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete WindType1or2UserDefined with id " + windType1or2UserDefinedId );

			throw e;
		}
	}

	/**
	 * get all WindType1or2UserDefineds.
	 */
	protected List<WindType1or2UserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of WindType1or2UserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all WindType1or2UserDefined : " );        
		List<WindType1or2UserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the WindType1or2UserDefinedBusinessDelegate
			collection = WindType1or2UserDefinedBusinessDelegate.getWindType1or2UserDefinedInstance().getAllWindType1or2UserDefined();
			assertNotNull( collection, "An Empty collection of WindType1or2UserDefined was incorrectly returned.");
			
			// Now print out the values
			WindType1or2UserDefined entity = null;            
			Iterator<WindType1or2UserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getWindType1or2UserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		WindType1or2UserDefinedTest
	 */
	protected WindType1or2UserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated WindType1or2UserDefined
	 * 
	 * @return CreateWindType1or2UserDefinedCommand alias
	 */
	protected CreateWindType1or2UserDefinedCommand generateNewCommand() {
        CreateWindType1or2UserDefinedCommand command = new CreateWindType1or2UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated WindType1or2UserDefined
		 * 
		 * @return UpdateWindType1or2UserDefinedCommand alias
		 */
	protected UpdateWindType1or2UserDefinedCommand generateUpdateCommand() {
	        UpdateWindType1or2UserDefinedCommand command = new UpdateWindType1or2UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID windType1or2UserDefinedId = null;
	protected WindType1or2UserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(WindType1or2UserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfWindType1or2UserDefinedList = 0;
}
