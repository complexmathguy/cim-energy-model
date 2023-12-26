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
 * Test ExcAVR5 class.
 *
 * @author your_name_here
 */
public class ExcAVR5Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAVR5Test() {
		subscriber = new ExcAVR5Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAVR5Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAVR5...");
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
	 * jumpstart the process by instantiating2 ExcAVR5
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAVR5Id = ExcAVR5BusinessDelegate.getExcAVR5Instance()
		.createExcAVR5( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAVR5BusinessDelegate.getExcAVR5Instance()
				.createExcAVR5( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAVR5Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAVR5 : " + successValue.getExcAVR5Id());
							  if (successValue.getExcAVR5Id().equals(excAVR5Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAVR5List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAVR5 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR5 consumed")
					);
			subscriber.excAVR5Subscribe( excAVR5Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAVR5 : " + successValue.getExcAVR5Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAVR5List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR5 for excAVR5Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAVR5. 
	 */
	protected ExcAVR5 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAVR5" );

		ExcAVR5 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAVR5 with primary key" );
		msg.append( excAVR5Id );
		
		ExcAVR5FetchOneSummary fetchOneSummary = new ExcAVR5FetchOneSummary( excAVR5Id );

		try {
			entity = ExcAVR5BusinessDelegate.getExcAVR5Instance().getExcAVR5( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAVR5 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAVR5.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAVR5." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAVR5 : " );        
		ExcAVR5 entity = read();
		UpdateExcAVR5Command command = generateUpdateCommand();
		command.setExcAVR5Id(entity.getExcAVR5Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAVR5." );

			// for use later on...
			excAVR5Id = entity.getExcAVR5Id();

			ExcAVR5BusinessDelegate proxy = ExcAVR5BusinessDelegate.getExcAVR5Instance();  

			proxy.updateExcAVR5( command ).get();

			LOGGER.info( "-- Successfully saved ExcAVR5 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAVR5Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAVR5.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAVR5." );

		ExcAVR5 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAVR5 with id " + excAVR5Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAVR5 with id " + excAVR5Id );

			throw e;
		}

		try{
			ExcAVR5BusinessDelegate.getExcAVR5Instance().delete( new DeleteExcAVR5Command( entity.getExcAVR5Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAVR5 with id " + excAVR5Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAVR5 with id " + excAVR5Id );

			throw e;
		}
	}

	/**
	 * get all ExcAVR5s.
	 */
	protected List<ExcAVR5> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAVR5s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAVR5 : " );        
		List<ExcAVR5> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAVR5BusinessDelegate
			collection = ExcAVR5BusinessDelegate.getExcAVR5Instance().getAllExcAVR5();
			assertNotNull( collection, "An Empty collection of ExcAVR5 was incorrectly returned.");
			
			// Now print out the values
			ExcAVR5 entity = null;            
			Iterator<ExcAVR5> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAVR5Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAVR5Test
	 */
	protected ExcAVR5Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAVR5
	 * 
	 * @return CreateExcAVR5Command alias
	 */
	protected CreateExcAVR5Command generateNewCommand() {
        CreateExcAVR5Command command = new CreateExcAVR5Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAVR5
		 * 
		 * @return UpdateExcAVR5Command alias
		 */
	protected UpdateExcAVR5Command generateUpdateCommand() {
	        UpdateExcAVR5Command command = new UpdateExcAVR5Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAVR5Id = null;
	protected ExcAVR5Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAVR5Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAVR5List = 0;
}
