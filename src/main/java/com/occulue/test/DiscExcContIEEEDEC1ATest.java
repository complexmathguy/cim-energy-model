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
 * Test DiscExcContIEEEDEC1A class.
 *
 * @author your_name_here
 */
public class DiscExcContIEEEDEC1ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscExcContIEEEDEC1ATest() {
		subscriber = new DiscExcContIEEEDEC1ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscExcContIEEEDEC1ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscExcContIEEEDEC1A...");
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
	 * jumpstart the process by instantiating2 DiscExcContIEEEDEC1A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discExcContIEEEDEC1AId = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
		.createDiscExcContIEEEDEC1A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
				.createDiscExcContIEEEDEC1A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discExcContIEEEDEC1ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscExcContIEEEDEC1A : " + successValue.getDiscExcContIEEEDEC1AId());
							  if (successValue.getDiscExcContIEEEDEC1AId().equals(discExcContIEEEDEC1AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscExcContIEEEDEC1AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscExcContIEEEDEC1A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC1A consumed")
					);
			subscriber.discExcContIEEEDEC1ASubscribe( discExcContIEEEDEC1AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscExcContIEEEDEC1A : " + successValue.getDiscExcContIEEEDEC1AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscExcContIEEEDEC1AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC1A for discExcContIEEEDEC1AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscExcContIEEEDEC1A. 
	 */
	protected DiscExcContIEEEDEC1A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscExcContIEEEDEC1A" );

		DiscExcContIEEEDEC1A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscExcContIEEEDEC1A with primary key" );
		msg.append( discExcContIEEEDEC1AId );
		
		DiscExcContIEEEDEC1AFetchOneSummary fetchOneSummary = new DiscExcContIEEEDEC1AFetchOneSummary( discExcContIEEEDEC1AId );

		try {
			entity = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().getDiscExcContIEEEDEC1A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscExcContIEEEDEC1A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscExcContIEEEDEC1A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscExcContIEEEDEC1A." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscExcContIEEEDEC1A : " );        
		DiscExcContIEEEDEC1A entity = read();
		UpdateDiscExcContIEEEDEC1ACommand command = generateUpdateCommand();
		command.setDiscExcContIEEEDEC1AId(entity.getDiscExcContIEEEDEC1AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscExcContIEEEDEC1A." );

			// for use later on...
			discExcContIEEEDEC1AId = entity.getDiscExcContIEEEDEC1AId();

			DiscExcContIEEEDEC1ABusinessDelegate proxy = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();  

			proxy.updateDiscExcContIEEEDEC1A( command ).get();

			LOGGER.info( "-- Successfully saved DiscExcContIEEEDEC1A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discExcContIEEEDEC1AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscExcContIEEEDEC1A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscExcContIEEEDEC1A." );

		DiscExcContIEEEDEC1A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscExcContIEEEDEC1A with id " + discExcContIEEEDEC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscExcContIEEEDEC1A with id " + discExcContIEEEDEC1AId );

			throw e;
		}

		try{
			DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().delete( new DeleteDiscExcContIEEEDEC1ACommand( entity.getDiscExcContIEEEDEC1AId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscExcContIEEEDEC1A with id " + discExcContIEEEDEC1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscExcContIEEEDEC1A with id " + discExcContIEEEDEC1AId );

			throw e;
		}
	}

	/**
	 * get all DiscExcContIEEEDEC1As.
	 */
	protected List<DiscExcContIEEEDEC1A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscExcContIEEEDEC1As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscExcContIEEEDEC1A : " );        
		List<DiscExcContIEEEDEC1A> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscExcContIEEEDEC1ABusinessDelegate
			collection = DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().getAllDiscExcContIEEEDEC1A();
			assertNotNull( collection, "An Empty collection of DiscExcContIEEEDEC1A was incorrectly returned.");
			
			// Now print out the values
			DiscExcContIEEEDEC1A entity = null;            
			Iterator<DiscExcContIEEEDEC1A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscExcContIEEEDEC1AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscExcContIEEEDEC1ATest
	 */
	protected DiscExcContIEEEDEC1ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscExcContIEEEDEC1A
	 * 
	 * @return CreateDiscExcContIEEEDEC1ACommand alias
	 */
	protected CreateDiscExcContIEEEDEC1ACommand generateNewCommand() {
        CreateDiscExcContIEEEDEC1ACommand command = new CreateDiscExcContIEEEDEC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscExcContIEEEDEC1A
		 * 
		 * @return UpdateDiscExcContIEEEDEC1ACommand alias
		 */
	protected UpdateDiscExcContIEEEDEC1ACommand generateUpdateCommand() {
	        UpdateDiscExcContIEEEDEC1ACommand command = new UpdateDiscExcContIEEEDEC1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discExcContIEEEDEC1AId = null;
	protected DiscExcContIEEEDEC1ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC1ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscExcContIEEEDEC1AList = 0;
}
