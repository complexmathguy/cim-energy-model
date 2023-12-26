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
 * Test ExcELIN1 class.
 *
 * @author your_name_here
 */
public class ExcELIN1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcELIN1Test() {
		subscriber = new ExcELIN1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcELIN1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcELIN1...");
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
	 * jumpstart the process by instantiating2 ExcELIN1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excELIN1Id = ExcELIN1BusinessDelegate.getExcELIN1Instance()
		.createExcELIN1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcELIN1BusinessDelegate.getExcELIN1Instance()
				.createExcELIN1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excELIN1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcELIN1 : " + successValue.getExcELIN1Id());
							  if (successValue.getExcELIN1Id().equals(excELIN1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcELIN1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcELIN1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excELIN1 consumed")
					);
			subscriber.excELIN1Subscribe( excELIN1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcELIN1 : " + successValue.getExcELIN1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcELIN1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excELIN1 for excELIN1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcELIN1. 
	 */
	protected ExcELIN1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcELIN1" );

		ExcELIN1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcELIN1 with primary key" );
		msg.append( excELIN1Id );
		
		ExcELIN1FetchOneSummary fetchOneSummary = new ExcELIN1FetchOneSummary( excELIN1Id );

		try {
			entity = ExcELIN1BusinessDelegate.getExcELIN1Instance().getExcELIN1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcELIN1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcELIN1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcELIN1." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcELIN1 : " );        
		ExcELIN1 entity = read();
		UpdateExcELIN1Command command = generateUpdateCommand();
		command.setExcELIN1Id(entity.getExcELIN1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcELIN1." );

			// for use later on...
			excELIN1Id = entity.getExcELIN1Id();

			ExcELIN1BusinessDelegate proxy = ExcELIN1BusinessDelegate.getExcELIN1Instance();  

			proxy.updateExcELIN1( command ).get();

			LOGGER.info( "-- Successfully saved ExcELIN1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excELIN1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcELIN1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcELIN1." );

		ExcELIN1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcELIN1 with id " + excELIN1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcELIN1 with id " + excELIN1Id );

			throw e;
		}

		try{
			ExcELIN1BusinessDelegate.getExcELIN1Instance().delete( new DeleteExcELIN1Command( entity.getExcELIN1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcELIN1 with id " + excELIN1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcELIN1 with id " + excELIN1Id );

			throw e;
		}
	}

	/**
	 * get all ExcELIN1s.
	 */
	protected List<ExcELIN1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcELIN1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcELIN1 : " );        
		List<ExcELIN1> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcELIN1BusinessDelegate
			collection = ExcELIN1BusinessDelegate.getExcELIN1Instance().getAllExcELIN1();
			assertNotNull( collection, "An Empty collection of ExcELIN1 was incorrectly returned.");
			
			// Now print out the values
			ExcELIN1 entity = null;            
			Iterator<ExcELIN1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcELIN1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcELIN1Test
	 */
	protected ExcELIN1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcELIN1
	 * 
	 * @return CreateExcELIN1Command alias
	 */
	protected CreateExcELIN1Command generateNewCommand() {
        CreateExcELIN1Command command = new CreateExcELIN1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcELIN1
		 * 
		 * @return UpdateExcELIN1Command alias
		 */
	protected UpdateExcELIN1Command generateUpdateCommand() {
	        UpdateExcELIN1Command command = new UpdateExcELIN1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excELIN1Id = null;
	protected ExcELIN1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcELIN1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcELIN1List = 0;
}
