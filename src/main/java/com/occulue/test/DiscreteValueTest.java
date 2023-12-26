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
 * Test DiscreteValue class.
 *
 * @author your_name_here
 */
public class DiscreteValueTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscreteValueTest() {
		subscriber = new DiscreteValueSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscreteValueTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscreteValue...");
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
	 * jumpstart the process by instantiating2 DiscreteValue
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discreteValueId = DiscreteValueBusinessDelegate.getDiscreteValueInstance()
		.createDiscreteValue( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscreteValueBusinessDelegate.getDiscreteValueInstance()
				.createDiscreteValue( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discreteValueSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscreteValue : " + successValue.getDiscreteValueId());
							  if (successValue.getDiscreteValueId().equals(discreteValueId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscreteValueList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscreteValue test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discreteValue consumed")
					);
			subscriber.discreteValueSubscribe( discreteValueId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscreteValue : " + successValue.getDiscreteValueId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscreteValueList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discreteValue for discreteValueId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscreteValue. 
	 */
	protected DiscreteValue read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscreteValue" );

		DiscreteValue entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscreteValue with primary key" );
		msg.append( discreteValueId );
		
		DiscreteValueFetchOneSummary fetchOneSummary = new DiscreteValueFetchOneSummary( discreteValueId );

		try {
			entity = DiscreteValueBusinessDelegate.getDiscreteValueInstance().getDiscreteValue( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscreteValue " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscreteValue.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscreteValue." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscreteValue : " );        
		DiscreteValue entity = read();
		UpdateDiscreteValueCommand command = generateUpdateCommand();
		command.setDiscreteValueId(entity.getDiscreteValueId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscreteValue." );

			// for use later on...
			discreteValueId = entity.getDiscreteValueId();

			DiscreteValueBusinessDelegate proxy = DiscreteValueBusinessDelegate.getDiscreteValueInstance();  

			proxy.updateDiscreteValue( command ).get();

			LOGGER.info( "-- Successfully saved DiscreteValue - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discreteValueId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscreteValue.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscreteValue." );

		DiscreteValue entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscreteValue with id " + discreteValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscreteValue with id " + discreteValueId );

			throw e;
		}

		try{
			DiscreteValueBusinessDelegate.getDiscreteValueInstance().delete( new DeleteDiscreteValueCommand( entity.getDiscreteValueId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscreteValue with id " + discreteValueId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscreteValue with id " + discreteValueId );

			throw e;
		}
	}

	/**
	 * get all DiscreteValues.
	 */
	protected List<DiscreteValue> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscreteValues:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscreteValue : " );        
		List<DiscreteValue> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscreteValueBusinessDelegate
			collection = DiscreteValueBusinessDelegate.getDiscreteValueInstance().getAllDiscreteValue();
			assertNotNull( collection, "An Empty collection of DiscreteValue was incorrectly returned.");
			
			// Now print out the values
			DiscreteValue entity = null;            
			Iterator<DiscreteValue> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscreteValueId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscreteValueTest
	 */
	protected DiscreteValueTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscreteValue
	 * 
	 * @return CreateDiscreteValueCommand alias
	 */
	protected CreateDiscreteValueCommand generateNewCommand() {
        CreateDiscreteValueCommand command = new CreateDiscreteValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscreteValue
		 * 
		 * @return UpdateDiscreteValueCommand alias
		 */
	protected UpdateDiscreteValueCommand generateUpdateCommand() {
	        UpdateDiscreteValueCommand command = new UpdateDiscreteValueCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discreteValueId = null;
	protected DiscreteValueSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscreteValueTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscreteValueList = 0;
}
