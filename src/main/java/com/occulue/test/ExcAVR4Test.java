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
 * Test ExcAVR4 class.
 *
 * @author your_name_here
 */
public class ExcAVR4Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcAVR4Test() {
		subscriber = new ExcAVR4Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcAVR4Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcAVR4...");
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
	 * jumpstart the process by instantiating2 ExcAVR4
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excAVR4Id = ExcAVR4BusinessDelegate.getExcAVR4Instance()
		.createExcAVR4( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcAVR4BusinessDelegate.getExcAVR4Instance()
				.createExcAVR4( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excAVR4Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcAVR4 : " + successValue.getExcAVR4Id());
							  if (successValue.getExcAVR4Id().equals(excAVR4Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcAVR4List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcAVR4 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR4 consumed")
					);
			subscriber.excAVR4Subscribe( excAVR4Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcAVR4 : " + successValue.getExcAVR4Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcAVR4List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excAVR4 for excAVR4Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcAVR4. 
	 */
	protected ExcAVR4 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcAVR4" );

		ExcAVR4 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcAVR4 with primary key" );
		msg.append( excAVR4Id );
		
		ExcAVR4FetchOneSummary fetchOneSummary = new ExcAVR4FetchOneSummary( excAVR4Id );

		try {
			entity = ExcAVR4BusinessDelegate.getExcAVR4Instance().getExcAVR4( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcAVR4 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcAVR4.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcAVR4." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcAVR4 : " );        
		ExcAVR4 entity = read();
		UpdateExcAVR4Command command = generateUpdateCommand();
		command.setExcAVR4Id(entity.getExcAVR4Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcAVR4." );

			// for use later on...
			excAVR4Id = entity.getExcAVR4Id();

			ExcAVR4BusinessDelegate proxy = ExcAVR4BusinessDelegate.getExcAVR4Instance();  

			proxy.updateExcAVR4( command ).get();

			LOGGER.info( "-- Successfully saved ExcAVR4 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excAVR4Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcAVR4.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcAVR4." );

		ExcAVR4 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcAVR4 with id " + excAVR4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcAVR4 with id " + excAVR4Id );

			throw e;
		}

		try{
			ExcAVR4BusinessDelegate.getExcAVR4Instance().delete( new DeleteExcAVR4Command( entity.getExcAVR4Id() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcAVR4 with id " + excAVR4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcAVR4 with id " + excAVR4Id );

			throw e;
		}
	}

	/**
	 * get all ExcAVR4s.
	 */
	protected List<ExcAVR4> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcAVR4s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcAVR4 : " );        
		List<ExcAVR4> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcAVR4BusinessDelegate
			collection = ExcAVR4BusinessDelegate.getExcAVR4Instance().getAllExcAVR4();
			assertNotNull( collection, "An Empty collection of ExcAVR4 was incorrectly returned.");
			
			// Now print out the values
			ExcAVR4 entity = null;            
			Iterator<ExcAVR4> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcAVR4Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcAVR4Test
	 */
	protected ExcAVR4Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcAVR4
	 * 
	 * @return CreateExcAVR4Command alias
	 */
	protected CreateExcAVR4Command generateNewCommand() {
        CreateExcAVR4Command command = new CreateExcAVR4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcAVR4
		 * 
		 * @return UpdateExcAVR4Command alias
		 */
	protected UpdateExcAVR4Command generateUpdateCommand() {
	        UpdateExcAVR4Command command = new UpdateExcAVR4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excAVR4Id = null;
	protected ExcAVR4Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcAVR4Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcAVR4List = 0;
}
