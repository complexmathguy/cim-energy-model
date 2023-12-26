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
 * Test ExcAVR3 class.
 *
 * @author your_name_here
 */
public class ExcAVR3Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAVR3Test() {
		subscriber = new ExcAVR3Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAVR3Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAVR3...");
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
	 * jumpstart the process by instantiating2 ExcAVR3
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAVR3Id = ExcAVR3BusinessDelegate.getExcAVR3Instance()
		.createExcAVR3( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAVR3BusinessDelegate.getExcAVR3Instance()
				.createExcAVR3( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAVR3Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAVR3 : " + successValue.getExcAVR3Id());
							  if (successValue.getExcAVR3Id().equals(excAVR3Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAVR3List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAVR3 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR3 consumed")
					);
			subscriber.excAVR3Subscribe( excAVR3Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAVR3 : " + successValue.getExcAVR3Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAVR3List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR3 for excAVR3Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAVR3. 
	 */
	protected ExcAVR3 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAVR3" );

		ExcAVR3 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAVR3 with primary key" );
		msg.append( excAVR3Id );
		
		ExcAVR3FetchOneSummary fetchOneSummary = new ExcAVR3FetchOneSummary( excAVR3Id );

		try {
			entity = ExcAVR3BusinessDelegate.getExcAVR3Instance().getExcAVR3( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAVR3 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAVR3.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAVR3." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAVR3 : " );        
		ExcAVR3 entity = read();
		UpdateExcAVR3Command command = generateUpdateCommand();
		command.setExcAVR3Id(entity.getExcAVR3Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAVR3." );

			// for use later on...
			excAVR3Id = entity.getExcAVR3Id();

			ExcAVR3BusinessDelegate proxy = ExcAVR3BusinessDelegate.getExcAVR3Instance();  

			proxy.updateExcAVR3( command ).get();

			LOGGER.info( "-- Successfully saved ExcAVR3 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAVR3Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAVR3.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAVR3." );

		ExcAVR3 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAVR3 with id " + excAVR3Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAVR3 with id " + excAVR3Id );

			throw e;
		}

		try{
			ExcAVR3BusinessDelegate.getExcAVR3Instance().delete( new DeleteExcAVR3Command( entity.getExcAVR3Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAVR3 with id " + excAVR3Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAVR3 with id " + excAVR3Id );

			throw e;
		}
	}

	/**
	 * get all ExcAVR3s.
	 */
	protected List<ExcAVR3> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAVR3s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAVR3 : " );        
		List<ExcAVR3> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAVR3BusinessDelegate
			collection = ExcAVR3BusinessDelegate.getExcAVR3Instance().getAllExcAVR3();
			assertNotNull( collection, "An Empty collection of ExcAVR3 was incorrectly returned.");
			
			// Now print out the values
			ExcAVR3 entity = null;            
			Iterator<ExcAVR3> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAVR3Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAVR3Test
	 */
	protected ExcAVR3Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAVR3
	 * 
	 * @return CreateExcAVR3Command alias
	 */
	protected CreateExcAVR3Command generateNewCommand() {
        CreateExcAVR3Command command = new CreateExcAVR3Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAVR3
		 * 
		 * @return UpdateExcAVR3Command alias
		 */
	protected UpdateExcAVR3Command generateUpdateCommand() {
	        UpdateExcAVR3Command command = new UpdateExcAVR3Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAVR3Id = null;
	protected ExcAVR3Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAVR3Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAVR3List = 0;
}
