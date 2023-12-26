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
 * Test DiscExcContIEEEDEC2A class.
 *
 * @author your_name_here
 */
public class DiscExcContIEEEDEC2ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscExcContIEEEDEC2ATest() {
		subscriber = new DiscExcContIEEEDEC2ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscExcContIEEEDEC2ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscExcContIEEEDEC2A...");
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
	 * jumpstart the process by instantiating2 DiscExcContIEEEDEC2A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discExcContIEEEDEC2AId = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance()
		.createDiscExcContIEEEDEC2A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance()
				.createDiscExcContIEEEDEC2A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discExcContIEEEDEC2ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscExcContIEEEDEC2A : " + successValue.getDiscExcContIEEEDEC2AId());
							  if (successValue.getDiscExcContIEEEDEC2AId().equals(discExcContIEEEDEC2AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscExcContIEEEDEC2AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscExcContIEEEDEC2A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC2A consumed")
					);
			subscriber.discExcContIEEEDEC2ASubscribe( discExcContIEEEDEC2AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscExcContIEEEDEC2A : " + successValue.getDiscExcContIEEEDEC2AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscExcContIEEEDEC2AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC2A for discExcContIEEEDEC2AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscExcContIEEEDEC2A. 
	 */
	protected DiscExcContIEEEDEC2A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscExcContIEEEDEC2A" );

		DiscExcContIEEEDEC2A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscExcContIEEEDEC2A with primary key" );
		msg.append( discExcContIEEEDEC2AId );
		
		DiscExcContIEEEDEC2AFetchOneSummary fetchOneSummary = new DiscExcContIEEEDEC2AFetchOneSummary( discExcContIEEEDEC2AId );

		try {
			entity = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().getDiscExcContIEEEDEC2A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscExcContIEEEDEC2A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscExcContIEEEDEC2A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscExcContIEEEDEC2A." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscExcContIEEEDEC2A : " );        
		DiscExcContIEEEDEC2A entity = read();
		UpdateDiscExcContIEEEDEC2ACommand command = generateUpdateCommand();
		command.setDiscExcContIEEEDEC2AId(entity.getDiscExcContIEEEDEC2AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscExcContIEEEDEC2A." );

			// for use later on...
			discExcContIEEEDEC2AId = entity.getDiscExcContIEEEDEC2AId();

			DiscExcContIEEEDEC2ABusinessDelegate proxy = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();  

			proxy.updateDiscExcContIEEEDEC2A( command ).get();

			LOGGER.info( "-- Successfully saved DiscExcContIEEEDEC2A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discExcContIEEEDEC2AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscExcContIEEEDEC2A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscExcContIEEEDEC2A." );

		DiscExcContIEEEDEC2A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscExcContIEEEDEC2A with id " + discExcContIEEEDEC2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscExcContIEEEDEC2A with id " + discExcContIEEEDEC2AId );

			throw e;
		}

		try{
			DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().delete( new DeleteDiscExcContIEEEDEC2ACommand( entity.getDiscExcContIEEEDEC2AId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscExcContIEEEDEC2A with id " + discExcContIEEEDEC2AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscExcContIEEEDEC2A with id " + discExcContIEEEDEC2AId );

			throw e;
		}
	}

	/**
	 * get all DiscExcContIEEEDEC2As.
	 */
	protected List<DiscExcContIEEEDEC2A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscExcContIEEEDEC2As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscExcContIEEEDEC2A : " );        
		List<DiscExcContIEEEDEC2A> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscExcContIEEEDEC2ABusinessDelegate
			collection = DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().getAllDiscExcContIEEEDEC2A();
			assertNotNull( collection, "An Empty collection of DiscExcContIEEEDEC2A was incorrectly returned.");
			
			// Now print out the values
			DiscExcContIEEEDEC2A entity = null;            
			Iterator<DiscExcContIEEEDEC2A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscExcContIEEEDEC2AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscExcContIEEEDEC2ATest
	 */
	protected DiscExcContIEEEDEC2ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscExcContIEEEDEC2A
	 * 
	 * @return CreateDiscExcContIEEEDEC2ACommand alias
	 */
	protected CreateDiscExcContIEEEDEC2ACommand generateNewCommand() {
        CreateDiscExcContIEEEDEC2ACommand command = new CreateDiscExcContIEEEDEC2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscExcContIEEEDEC2A
		 * 
		 * @return UpdateDiscExcContIEEEDEC2ACommand alias
		 */
	protected UpdateDiscExcContIEEEDEC2ACommand generateUpdateCommand() {
	        UpdateDiscExcContIEEEDEC2ACommand command = new UpdateDiscExcContIEEEDEC2ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discExcContIEEEDEC2AId = null;
	protected DiscExcContIEEEDEC2ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC2ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscExcContIEEEDEC2AList = 0;
}
