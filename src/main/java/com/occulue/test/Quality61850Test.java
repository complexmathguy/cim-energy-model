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
 * Test Quality61850 class.
 *
 * @author your_name_here
 */
public class Quality61850Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public Quality61850Test() {
		subscriber = new Quality61850Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate Quality61850Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Quality61850...");
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
	 * jumpstart the process by instantiating2 Quality61850
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		quality61850Id = Quality61850BusinessDelegate.getQuality61850Instance()
		.createQuality61850( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		Quality61850BusinessDelegate.getQuality61850Instance()
				.createQuality61850( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.quality61850Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Quality61850 : " + successValue.getQuality61850Id());
							  if (successValue.getQuality61850Id().equals(quality61850Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfQuality61850List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Quality61850 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on quality61850 consumed")
					);
			subscriber.quality61850Subscribe( quality61850Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Quality61850 : " + successValue.getQuality61850Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfQuality61850List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on quality61850 for quality61850Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Quality61850. 
	 */
	protected Quality61850 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Quality61850" );

		Quality61850 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Quality61850 with primary key" );
		msg.append( quality61850Id );
		
		Quality61850FetchOneSummary fetchOneSummary = new Quality61850FetchOneSummary( quality61850Id );

		try {
			entity = Quality61850BusinessDelegate.getQuality61850Instance().getQuality61850( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Quality61850 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Quality61850.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Quality61850." );

		StringBuilder msg = new StringBuilder( "Failed to update a Quality61850 : " );        
		Quality61850 entity = read();
		UpdateQuality61850Command command = generateUpdateCommand();
		command.setQuality61850Id(entity.getQuality61850Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Quality61850." );

			// for use later on...
			quality61850Id = entity.getQuality61850Id();

			Quality61850BusinessDelegate proxy = Quality61850BusinessDelegate.getQuality61850Instance();  

			proxy.updateQuality61850( command ).get();

			LOGGER.info( "-- Successfully saved Quality61850 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + quality61850Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Quality61850.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Quality61850." );

		Quality61850 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Quality61850 with id " + quality61850Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Quality61850 with id " + quality61850Id );

			throw e;
		}

		try{
			Quality61850BusinessDelegate.getQuality61850Instance().delete( new DeleteQuality61850Command( entity.getQuality61850Id() ) ).get();
			LOGGER.info( "-- Successfully deleted Quality61850 with id " + quality61850Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Quality61850 with id " + quality61850Id );

			throw e;
		}
	}

	/**
	 * get all Quality61850s.
	 */
	protected List<Quality61850> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Quality61850s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Quality61850 : " );        
		List<Quality61850> collection  = new ArrayList<>();

		try {
			// call the static get method on the Quality61850BusinessDelegate
			collection = Quality61850BusinessDelegate.getQuality61850Instance().getAllQuality61850();
			assertNotNull( collection, "An Empty collection of Quality61850 was incorrectly returned.");
			
			// Now print out the values
			Quality61850 entity = null;            
			Iterator<Quality61850> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getQuality61850Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		Quality61850Test
	 */
	protected Quality61850Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Quality61850
	 * 
	 * @return CreateQuality61850Command alias
	 */
	protected CreateQuality61850Command generateNewCommand() {
        CreateQuality61850Command command = new CreateQuality61850Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Quality61850
		 * 
		 * @return UpdateQuality61850Command alias
		 */
	protected UpdateQuality61850Command generateUpdateCommand() {
	        UpdateQuality61850Command command = new UpdateQuality61850Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID quality61850Id = null;
	protected Quality61850Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(Quality61850Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfQuality61850List = 0;
}
