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
 * Test ExcitationSystemUserDefined class.
 *
 * @author your_name_here
 */
public class ExcitationSystemUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcitationSystemUserDefinedTest() {
		subscriber = new ExcitationSystemUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcitationSystemUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcitationSystemUserDefined...");
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
	 * jumpstart the process by instantiating2 ExcitationSystemUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excitationSystemUserDefinedId = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance()
		.createExcitationSystemUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance()
				.createExcitationSystemUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excitationSystemUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcitationSystemUserDefined : " + successValue.getExcitationSystemUserDefinedId());
							  if (successValue.getExcitationSystemUserDefinedId().equals(excitationSystemUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcitationSystemUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcitationSystemUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excitationSystemUserDefined consumed")
					);
			subscriber.excitationSystemUserDefinedSubscribe( excitationSystemUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcitationSystemUserDefined : " + successValue.getExcitationSystemUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcitationSystemUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excitationSystemUserDefined for excitationSystemUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcitationSystemUserDefined. 
	 */
	protected ExcitationSystemUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcitationSystemUserDefined" );

		ExcitationSystemUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcitationSystemUserDefined with primary key" );
		msg.append( excitationSystemUserDefinedId );
		
		ExcitationSystemUserDefinedFetchOneSummary fetchOneSummary = new ExcitationSystemUserDefinedFetchOneSummary( excitationSystemUserDefinedId );

		try {
			entity = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().getExcitationSystemUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcitationSystemUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcitationSystemUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcitationSystemUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcitationSystemUserDefined : " );        
		ExcitationSystemUserDefined entity = read();
		UpdateExcitationSystemUserDefinedCommand command = generateUpdateCommand();
		command.setExcitationSystemUserDefinedId(entity.getExcitationSystemUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcitationSystemUserDefined." );

			// for use later on...
			excitationSystemUserDefinedId = entity.getExcitationSystemUserDefinedId();

			ExcitationSystemUserDefinedBusinessDelegate proxy = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance();  

			proxy.updateExcitationSystemUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved ExcitationSystemUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excitationSystemUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcitationSystemUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcitationSystemUserDefined." );

		ExcitationSystemUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcitationSystemUserDefined with id " + excitationSystemUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcitationSystemUserDefined with id " + excitationSystemUserDefinedId );

			throw e;
		}

		try{
			ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().delete( new DeleteExcitationSystemUserDefinedCommand( entity.getExcitationSystemUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcitationSystemUserDefined with id " + excitationSystemUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcitationSystemUserDefined with id " + excitationSystemUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all ExcitationSystemUserDefineds.
	 */
	protected List<ExcitationSystemUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcitationSystemUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcitationSystemUserDefined : " );        
		List<ExcitationSystemUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcitationSystemUserDefinedBusinessDelegate
			collection = ExcitationSystemUserDefinedBusinessDelegate.getExcitationSystemUserDefinedInstance().getAllExcitationSystemUserDefined();
			assertNotNull( collection, "An Empty collection of ExcitationSystemUserDefined was incorrectly returned.");
			
			// Now print out the values
			ExcitationSystemUserDefined entity = null;            
			Iterator<ExcitationSystemUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcitationSystemUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcitationSystemUserDefinedTest
	 */
	protected ExcitationSystemUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcitationSystemUserDefined
	 * 
	 * @return CreateExcitationSystemUserDefinedCommand alias
	 */
	protected CreateExcitationSystemUserDefinedCommand generateNewCommand() {
        CreateExcitationSystemUserDefinedCommand command = new CreateExcitationSystemUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcitationSystemUserDefined
		 * 
		 * @return UpdateExcitationSystemUserDefinedCommand alias
		 */
	protected UpdateExcitationSystemUserDefinedCommand generateUpdateCommand() {
	        UpdateExcitationSystemUserDefinedCommand command = new UpdateExcitationSystemUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excitationSystemUserDefinedId = null;
	protected ExcitationSystemUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcitationSystemUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcitationSystemUserDefinedList = 0;
}
