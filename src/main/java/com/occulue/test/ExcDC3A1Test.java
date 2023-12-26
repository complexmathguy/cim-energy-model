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
 * Test ExcDC3A1 class.
 *
 * @author your_name_here
 */
public class ExcDC3A1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcDC3A1Test() {
		subscriber = new ExcDC3A1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcDC3A1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcDC3A1...");
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
	 * jumpstart the process by instantiating2 ExcDC3A1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excDC3A1Id = ExcDC3A1BusinessDelegate.getExcDC3A1Instance()
		.createExcDC3A1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcDC3A1BusinessDelegate.getExcDC3A1Instance()
				.createExcDC3A1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excDC3A1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcDC3A1 : " + successValue.getExcDC3A1Id());
							  if (successValue.getExcDC3A1Id().equals(excDC3A1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcDC3A1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcDC3A1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excDC3A1 consumed")
					);
			subscriber.excDC3A1Subscribe( excDC3A1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcDC3A1 : " + successValue.getExcDC3A1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcDC3A1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excDC3A1 for excDC3A1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcDC3A1. 
	 */
	protected ExcDC3A1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcDC3A1" );

		ExcDC3A1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcDC3A1 with primary key" );
		msg.append( excDC3A1Id );
		
		ExcDC3A1FetchOneSummary fetchOneSummary = new ExcDC3A1FetchOneSummary( excDC3A1Id );

		try {
			entity = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().getExcDC3A1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcDC3A1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcDC3A1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcDC3A1." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcDC3A1 : " );        
		ExcDC3A1 entity = read();
		UpdateExcDC3A1Command command = generateUpdateCommand();
		command.setExcDC3A1Id(entity.getExcDC3A1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcDC3A1." );

			// for use later on...
			excDC3A1Id = entity.getExcDC3A1Id();

			ExcDC3A1BusinessDelegate proxy = ExcDC3A1BusinessDelegate.getExcDC3A1Instance();  

			proxy.updateExcDC3A1( command ).get();

			LOGGER.info( "-- Successfully saved ExcDC3A1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excDC3A1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcDC3A1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcDC3A1." );

		ExcDC3A1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcDC3A1 with id " + excDC3A1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcDC3A1 with id " + excDC3A1Id );

			throw e;
		}

		try{
			ExcDC3A1BusinessDelegate.getExcDC3A1Instance().delete( new DeleteExcDC3A1Command( entity.getExcDC3A1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcDC3A1 with id " + excDC3A1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcDC3A1 with id " + excDC3A1Id );

			throw e;
		}
	}

	/**
	 * get all ExcDC3A1s.
	 */
	protected List<ExcDC3A1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcDC3A1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcDC3A1 : " );        
		List<ExcDC3A1> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcDC3A1BusinessDelegate
			collection = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().getAllExcDC3A1();
			assertNotNull( collection, "An Empty collection of ExcDC3A1 was incorrectly returned.");
			
			// Now print out the values
			ExcDC3A1 entity = null;            
			Iterator<ExcDC3A1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcDC3A1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcDC3A1Test
	 */
	protected ExcDC3A1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcDC3A1
	 * 
	 * @return CreateExcDC3A1Command alias
	 */
	protected CreateExcDC3A1Command generateNewCommand() {
        CreateExcDC3A1Command command = new CreateExcDC3A1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcDC3A1
		 * 
		 * @return UpdateExcDC3A1Command alias
		 */
	protected UpdateExcDC3A1Command generateUpdateCommand() {
	        UpdateExcDC3A1Command command = new UpdateExcDC3A1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excDC3A1Id = null;
	protected ExcDC3A1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcDC3A1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcDC3A1List = 0;
}
