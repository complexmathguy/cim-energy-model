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
 * Test ExcAVR2 class.
 *
 * @author your_name_here
 */
public class ExcAVR2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAVR2Test() {
		subscriber = new ExcAVR2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAVR2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAVR2...");
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
	 * jumpstart the process by instantiating2 ExcAVR2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAVR2Id = ExcAVR2BusinessDelegate.getExcAVR2Instance()
		.createExcAVR2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAVR2BusinessDelegate.getExcAVR2Instance()
				.createExcAVR2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAVR2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAVR2 : " + successValue.getExcAVR2Id());
							  if (successValue.getExcAVR2Id().equals(excAVR2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAVR2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAVR2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR2 consumed")
					);
			subscriber.excAVR2Subscribe( excAVR2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAVR2 : " + successValue.getExcAVR2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAVR2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR2 for excAVR2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAVR2. 
	 */
	protected ExcAVR2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAVR2" );

		ExcAVR2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAVR2 with primary key" );
		msg.append( excAVR2Id );
		
		ExcAVR2FetchOneSummary fetchOneSummary = new ExcAVR2FetchOneSummary( excAVR2Id );

		try {
			entity = ExcAVR2BusinessDelegate.getExcAVR2Instance().getExcAVR2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAVR2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAVR2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAVR2." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAVR2 : " );        
		ExcAVR2 entity = read();
		UpdateExcAVR2Command command = generateUpdateCommand();
		command.setExcAVR2Id(entity.getExcAVR2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAVR2." );

			// for use later on...
			excAVR2Id = entity.getExcAVR2Id();

			ExcAVR2BusinessDelegate proxy = ExcAVR2BusinessDelegate.getExcAVR2Instance();  

			proxy.updateExcAVR2( command ).get();

			LOGGER.info( "-- Successfully saved ExcAVR2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAVR2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAVR2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAVR2." );

		ExcAVR2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAVR2 with id " + excAVR2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAVR2 with id " + excAVR2Id );

			throw e;
		}

		try{
			ExcAVR2BusinessDelegate.getExcAVR2Instance().delete( new DeleteExcAVR2Command( entity.getExcAVR2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAVR2 with id " + excAVR2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAVR2 with id " + excAVR2Id );

			throw e;
		}
	}

	/**
	 * get all ExcAVR2s.
	 */
	protected List<ExcAVR2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAVR2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAVR2 : " );        
		List<ExcAVR2> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAVR2BusinessDelegate
			collection = ExcAVR2BusinessDelegate.getExcAVR2Instance().getAllExcAVR2();
			assertNotNull( collection, "An Empty collection of ExcAVR2 was incorrectly returned.");
			
			// Now print out the values
			ExcAVR2 entity = null;            
			Iterator<ExcAVR2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAVR2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAVR2Test
	 */
	protected ExcAVR2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAVR2
	 * 
	 * @return CreateExcAVR2Command alias
	 */
	protected CreateExcAVR2Command generateNewCommand() {
        CreateExcAVR2Command command = new CreateExcAVR2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAVR2
		 * 
		 * @return UpdateExcAVR2Command alias
		 */
	protected UpdateExcAVR2Command generateUpdateCommand() {
	        UpdateExcAVR2Command command = new UpdateExcAVR2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAVR2Id = null;
	protected ExcAVR2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAVR2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAVR2List = 0;
}
