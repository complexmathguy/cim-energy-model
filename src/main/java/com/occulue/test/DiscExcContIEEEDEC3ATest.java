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
 * Test DiscExcContIEEEDEC3A class.
 *
 * @author your_name_here
 */
public class DiscExcContIEEEDEC3ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DiscExcContIEEEDEC3ATest() {
		subscriber = new DiscExcContIEEEDEC3ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DiscExcContIEEEDEC3ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DiscExcContIEEEDEC3A...");
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
	 * jumpstart the process by instantiating2 DiscExcContIEEEDEC3A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		discExcContIEEEDEC3AId = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance()
		.createDiscExcContIEEEDEC3A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance()
				.createDiscExcContIEEEDEC3A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.discExcContIEEEDEC3ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DiscExcContIEEEDEC3A : " + successValue.getDiscExcContIEEEDEC3AId());
							  if (successValue.getDiscExcContIEEEDEC3AId().equals(discExcContIEEEDEC3AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDiscExcContIEEEDEC3AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DiscExcContIEEEDEC3A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC3A consumed")
					);
			subscriber.discExcContIEEEDEC3ASubscribe( discExcContIEEEDEC3AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DiscExcContIEEEDEC3A : " + successValue.getDiscExcContIEEEDEC3AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDiscExcContIEEEDEC3AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on discExcContIEEEDEC3A for discExcContIEEEDEC3AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DiscExcContIEEEDEC3A. 
	 */
	protected DiscExcContIEEEDEC3A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DiscExcContIEEEDEC3A" );

		DiscExcContIEEEDEC3A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DiscExcContIEEEDEC3A with primary key" );
		msg.append( discExcContIEEEDEC3AId );
		
		DiscExcContIEEEDEC3AFetchOneSummary fetchOneSummary = new DiscExcContIEEEDEC3AFetchOneSummary( discExcContIEEEDEC3AId );

		try {
			entity = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().getDiscExcContIEEEDEC3A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DiscExcContIEEEDEC3A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DiscExcContIEEEDEC3A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DiscExcContIEEEDEC3A." );

		StringBuilder msg = new StringBuilder( "Failed to update a DiscExcContIEEEDEC3A : " );        
		DiscExcContIEEEDEC3A entity = read();
		UpdateDiscExcContIEEEDEC3ACommand command = generateUpdateCommand();
		command.setDiscExcContIEEEDEC3AId(entity.getDiscExcContIEEEDEC3AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DiscExcContIEEEDEC3A." );

			// for use later on...
			discExcContIEEEDEC3AId = entity.getDiscExcContIEEEDEC3AId();

			DiscExcContIEEEDEC3ABusinessDelegate proxy = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance();  

			proxy.updateDiscExcContIEEEDEC3A( command ).get();

			LOGGER.info( "-- Successfully saved DiscExcContIEEEDEC3A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + discExcContIEEEDEC3AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DiscExcContIEEEDEC3A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DiscExcContIEEEDEC3A." );

		DiscExcContIEEEDEC3A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DiscExcContIEEEDEC3A with id " + discExcContIEEEDEC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DiscExcContIEEEDEC3A with id " + discExcContIEEEDEC3AId );

			throw e;
		}

		try{
			DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().delete( new DeleteDiscExcContIEEEDEC3ACommand( entity.getDiscExcContIEEEDEC3AId() ) ).get();
			LOGGER.info( "-- Successfully deleted DiscExcContIEEEDEC3A with id " + discExcContIEEEDEC3AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DiscExcContIEEEDEC3A with id " + discExcContIEEEDEC3AId );

			throw e;
		}
	}

	/**
	 * get all DiscExcContIEEEDEC3As.
	 */
	protected List<DiscExcContIEEEDEC3A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DiscExcContIEEEDEC3As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DiscExcContIEEEDEC3A : " );        
		List<DiscExcContIEEEDEC3A> collection  = new ArrayList<>();

		try {
			// call the static get method on the DiscExcContIEEEDEC3ABusinessDelegate
			collection = DiscExcContIEEEDEC3ABusinessDelegate.getDiscExcContIEEEDEC3AInstance().getAllDiscExcContIEEEDEC3A();
			assertNotNull( collection, "An Empty collection of DiscExcContIEEEDEC3A was incorrectly returned.");
			
			// Now print out the values
			DiscExcContIEEEDEC3A entity = null;            
			Iterator<DiscExcContIEEEDEC3A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDiscExcContIEEEDEC3AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DiscExcContIEEEDEC3ATest
	 */
	protected DiscExcContIEEEDEC3ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DiscExcContIEEEDEC3A
	 * 
	 * @return CreateDiscExcContIEEEDEC3ACommand alias
	 */
	protected CreateDiscExcContIEEEDEC3ACommand generateNewCommand() {
        CreateDiscExcContIEEEDEC3ACommand command = new CreateDiscExcContIEEEDEC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DiscExcContIEEEDEC3A
		 * 
		 * @return UpdateDiscExcContIEEEDEC3ACommand alias
		 */
	protected UpdateDiscExcContIEEEDEC3ACommand generateUpdateCommand() {
	        UpdateDiscExcContIEEEDEC3ACommand command = new UpdateDiscExcContIEEEDEC3ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID discExcContIEEEDEC3AId = null;
	protected DiscExcContIEEEDEC3ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DiscExcContIEEEDEC3ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDiscExcContIEEEDEC3AList = 0;
}
