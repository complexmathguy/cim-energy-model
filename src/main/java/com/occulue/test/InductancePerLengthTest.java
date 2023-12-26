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
 * Test InductancePerLength class.
 *
 * @author your_name_here
 */
public class InductancePerLengthTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public InductancePerLengthTest() {
		subscriber = new InductancePerLengthSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate InductancePerLengthTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on InductancePerLength...");
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
	 * jumpstart the process by instantiating2 InductancePerLength
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		inductancePerLengthId = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance()
		.createInductancePerLength( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		InductancePerLengthBusinessDelegate.getInductancePerLengthInstance()
				.createInductancePerLength( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.inductancePerLengthSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for InductancePerLength : " + successValue.getInductancePerLengthId());
							  if (successValue.getInductancePerLengthId().equals(inductancePerLengthId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfInductancePerLengthList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("InductancePerLength test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on inductancePerLength consumed")
					);
			subscriber.inductancePerLengthSubscribe( inductancePerLengthId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for InductancePerLength : " + successValue.getInductancePerLengthId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfInductancePerLengthList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on inductancePerLength for inductancePerLengthId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a InductancePerLength. 
	 */
	protected InductancePerLength read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created InductancePerLength" );

		InductancePerLength entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read InductancePerLength with primary key" );
		msg.append( inductancePerLengthId );
		
		InductancePerLengthFetchOneSummary fetchOneSummary = new InductancePerLengthFetchOneSummary( inductancePerLengthId );

		try {
			entity = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().getInductancePerLength( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found InductancePerLength " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a InductancePerLength.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a InductancePerLength." );

		StringBuilder msg = new StringBuilder( "Failed to update a InductancePerLength : " );        
		InductancePerLength entity = read();
		UpdateInductancePerLengthCommand command = generateUpdateCommand();
		command.setInductancePerLengthId(entity.getInductancePerLengthId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created InductancePerLength." );

			// for use later on...
			inductancePerLengthId = entity.getInductancePerLengthId();

			InductancePerLengthBusinessDelegate proxy = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance();  

			proxy.updateInductancePerLength( command ).get();

			LOGGER.info( "-- Successfully saved InductancePerLength - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + inductancePerLengthId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a InductancePerLength.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created InductancePerLength." );

		InductancePerLength entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read InductancePerLength with id " + inductancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read InductancePerLength with id " + inductancePerLengthId );

			throw e;
		}

		try{
			InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().delete( new DeleteInductancePerLengthCommand( entity.getInductancePerLengthId() ) ).get();
			LOGGER.info( "-- Successfully deleted InductancePerLength with id " + inductancePerLengthId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete InductancePerLength with id " + inductancePerLengthId );

			throw e;
		}
	}

	/**
	 * get all InductancePerLengths.
	 */
	protected List<InductancePerLength> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of InductancePerLengths:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all InductancePerLength : " );        
		List<InductancePerLength> collection  = new ArrayList<>();

		try {
			// call the static get method on the InductancePerLengthBusinessDelegate
			collection = InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().getAllInductancePerLength();
			assertNotNull( collection, "An Empty collection of InductancePerLength was incorrectly returned.");
			
			// Now print out the values
			InductancePerLength entity = null;            
			Iterator<InductancePerLength> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getInductancePerLengthId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		InductancePerLengthTest
	 */
	protected InductancePerLengthTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated InductancePerLength
	 * 
	 * @return CreateInductancePerLengthCommand alias
	 */
	protected CreateInductancePerLengthCommand generateNewCommand() {
        CreateInductancePerLengthCommand command = new CreateInductancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated InductancePerLength
		 * 
		 * @return UpdateInductancePerLengthCommand alias
		 */
	protected UpdateInductancePerLengthCommand generateUpdateCommand() {
	        UpdateInductancePerLengthCommand command = new UpdateInductancePerLengthCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID inductancePerLengthId = null;
	protected InductancePerLengthSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(InductancePerLengthTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfInductancePerLengthList = 0;
}
