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
 * Test PerLengthDCLineParameter class.
 *
 * @author your_name_here
 */
public class PerLengthDCLineParameterTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PerLengthDCLineParameterTest() {
		subscriber = new PerLengthDCLineParameterSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PerLengthDCLineParameterTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PerLengthDCLineParameter...");
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
	 * jumpstart the process by instantiating2 PerLengthDCLineParameter
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		perLengthDCLineParameterId = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
		.createPerLengthDCLineParameter( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
				.createPerLengthDCLineParameter( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.perLengthDCLineParameterSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PerLengthDCLineParameter : " + successValue.getPerLengthDCLineParameterId());
							  if (successValue.getPerLengthDCLineParameterId().equals(perLengthDCLineParameterId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPerLengthDCLineParameterList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PerLengthDCLineParameter test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on perLengthDCLineParameter consumed")
					);
			subscriber.perLengthDCLineParameterSubscribe( perLengthDCLineParameterId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PerLengthDCLineParameter : " + successValue.getPerLengthDCLineParameterId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPerLengthDCLineParameterList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on perLengthDCLineParameter for perLengthDCLineParameterId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PerLengthDCLineParameter. 
	 */
	protected PerLengthDCLineParameter read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PerLengthDCLineParameter" );

		PerLengthDCLineParameter entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PerLengthDCLineParameter with primary key" );
		msg.append( perLengthDCLineParameterId );
		
		PerLengthDCLineParameterFetchOneSummary fetchOneSummary = new PerLengthDCLineParameterFetchOneSummary( perLengthDCLineParameterId );

		try {
			entity = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().getPerLengthDCLineParameter( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PerLengthDCLineParameter " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PerLengthDCLineParameter.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PerLengthDCLineParameter." );

		StringBuilder msg = new StringBuilder( "Failed to update a PerLengthDCLineParameter : " );        
		PerLengthDCLineParameter entity = read();
		UpdatePerLengthDCLineParameterCommand command = generateUpdateCommand();
		command.setPerLengthDCLineParameterId(entity.getPerLengthDCLineParameterId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PerLengthDCLineParameter." );

			// for use later on...
			perLengthDCLineParameterId = entity.getPerLengthDCLineParameterId();

			PerLengthDCLineParameterBusinessDelegate proxy = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();  

			proxy.updatePerLengthDCLineParameter( command ).get();

			LOGGER.info( "-- Successfully saved PerLengthDCLineParameter - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + perLengthDCLineParameterId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PerLengthDCLineParameter.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PerLengthDCLineParameter." );

		PerLengthDCLineParameter entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PerLengthDCLineParameter with id " + perLengthDCLineParameterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PerLengthDCLineParameter with id " + perLengthDCLineParameterId );

			throw e;
		}

		try{
			PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().delete( new DeletePerLengthDCLineParameterCommand( entity.getPerLengthDCLineParameterId() ) ).get();
			LOGGER.info( "-- Successfully deleted PerLengthDCLineParameter with id " + perLengthDCLineParameterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PerLengthDCLineParameter with id " + perLengthDCLineParameterId );

			throw e;
		}
	}

	/**
	 * get all PerLengthDCLineParameters.
	 */
	protected List<PerLengthDCLineParameter> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PerLengthDCLineParameters:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PerLengthDCLineParameter : " );        
		List<PerLengthDCLineParameter> collection  = new ArrayList<>();

		try {
			// call the static get method on the PerLengthDCLineParameterBusinessDelegate
			collection = PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance().getAllPerLengthDCLineParameter();
			assertNotNull( collection, "An Empty collection of PerLengthDCLineParameter was incorrectly returned.");
			
			// Now print out the values
			PerLengthDCLineParameter entity = null;            
			Iterator<PerLengthDCLineParameter> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPerLengthDCLineParameterId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PerLengthDCLineParameterTest
	 */
	protected PerLengthDCLineParameterTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PerLengthDCLineParameter
	 * 
	 * @return CreatePerLengthDCLineParameterCommand alias
	 */
	protected CreatePerLengthDCLineParameterCommand generateNewCommand() {
        CreatePerLengthDCLineParameterCommand command = new CreatePerLengthDCLineParameterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PerLengthDCLineParameter
		 * 
		 * @return UpdatePerLengthDCLineParameterCommand alias
		 */
	protected UpdatePerLengthDCLineParameterCommand generateUpdateCommand() {
	        UpdatePerLengthDCLineParameterCommand command = new UpdatePerLengthDCLineParameterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID perLengthDCLineParameterId = null;
	protected PerLengthDCLineParameterSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PerLengthDCLineParameterTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPerLengthDCLineParameterList = 0;
}
