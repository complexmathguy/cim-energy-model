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
 * Test StaticVarCompensator class.
 *
 * @author your_name_here
 */
public class StaticVarCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StaticVarCompensatorTest() {
		subscriber = new StaticVarCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StaticVarCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StaticVarCompensator...");
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
	 * jumpstart the process by instantiating2 StaticVarCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		staticVarCompensatorId = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
		.createStaticVarCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
				.createStaticVarCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.staticVarCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StaticVarCompensator : " + successValue.getStaticVarCompensatorId());
							  if (successValue.getStaticVarCompensatorId().equals(staticVarCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStaticVarCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StaticVarCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on staticVarCompensator consumed")
					);
			subscriber.staticVarCompensatorSubscribe( staticVarCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StaticVarCompensator : " + successValue.getStaticVarCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStaticVarCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on staticVarCompensator for staticVarCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StaticVarCompensator. 
	 */
	protected StaticVarCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StaticVarCompensator" );

		StaticVarCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StaticVarCompensator with primary key" );
		msg.append( staticVarCompensatorId );
		
		StaticVarCompensatorFetchOneSummary fetchOneSummary = new StaticVarCompensatorFetchOneSummary( staticVarCompensatorId );

		try {
			entity = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().getStaticVarCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StaticVarCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StaticVarCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StaticVarCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a StaticVarCompensator : " );        
		StaticVarCompensator entity = read();
		UpdateStaticVarCompensatorCommand command = generateUpdateCommand();
		command.setStaticVarCompensatorId(entity.getStaticVarCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StaticVarCompensator." );

			// for use later on...
			staticVarCompensatorId = entity.getStaticVarCompensatorId();

			StaticVarCompensatorBusinessDelegate proxy = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();  

			proxy.updateStaticVarCompensator( command ).get();

			LOGGER.info( "-- Successfully saved StaticVarCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + staticVarCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StaticVarCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StaticVarCompensator." );

		StaticVarCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StaticVarCompensator with id " + staticVarCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StaticVarCompensator with id " + staticVarCompensatorId );

			throw e;
		}

		try{
			StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().delete( new DeleteStaticVarCompensatorCommand( entity.getStaticVarCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted StaticVarCompensator with id " + staticVarCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StaticVarCompensator with id " + staticVarCompensatorId );

			throw e;
		}
	}

	/**
	 * get all StaticVarCompensators.
	 */
	protected List<StaticVarCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StaticVarCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StaticVarCompensator : " );        
		List<StaticVarCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the StaticVarCompensatorBusinessDelegate
			collection = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().getAllStaticVarCompensator();
			assertNotNull( collection, "An Empty collection of StaticVarCompensator was incorrectly returned.");
			
			// Now print out the values
			StaticVarCompensator entity = null;            
			Iterator<StaticVarCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStaticVarCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StaticVarCompensatorTest
	 */
	protected StaticVarCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StaticVarCompensator
	 * 
	 * @return CreateStaticVarCompensatorCommand alias
	 */
	protected CreateStaticVarCompensatorCommand generateNewCommand() {
        CreateStaticVarCompensatorCommand command = new CreateStaticVarCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated StaticVarCompensator
		 * 
		 * @return UpdateStaticVarCompensatorCommand alias
		 */
	protected UpdateStaticVarCompensatorCommand generateUpdateCommand() {
	        UpdateStaticVarCompensatorCommand command = new UpdateStaticVarCompensatorCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID staticVarCompensatorId = null;
	protected StaticVarCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StaticVarCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStaticVarCompensatorList = 0;
}
