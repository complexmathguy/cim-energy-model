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
 * Test PssIEEE3B class.
 *
 * @author your_name_here
 */
public class PssIEEE3BTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssIEEE3BTest() {
		subscriber = new PssIEEE3BSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssIEEE3BTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssIEEE3B...");
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
	 * jumpstart the process by instantiating2 PssIEEE3B
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssIEEE3BId = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance()
		.createPssIEEE3B( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssIEEE3BBusinessDelegate.getPssIEEE3BInstance()
				.createPssIEEE3B( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssIEEE3BSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssIEEE3B : " + successValue.getPssIEEE3BId());
							  if (successValue.getPssIEEE3BId().equals(pssIEEE3BId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssIEEE3BList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssIEEE3B test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssIEEE3B consumed")
					);
			subscriber.pssIEEE3BSubscribe( pssIEEE3BId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssIEEE3B : " + successValue.getPssIEEE3BId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssIEEE3BList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssIEEE3B for pssIEEE3BId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssIEEE3B. 
	 */
	protected PssIEEE3B read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssIEEE3B" );

		PssIEEE3B entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssIEEE3B with primary key" );
		msg.append( pssIEEE3BId );
		
		PssIEEE3BFetchOneSummary fetchOneSummary = new PssIEEE3BFetchOneSummary( pssIEEE3BId );

		try {
			entity = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().getPssIEEE3B( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssIEEE3B " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssIEEE3B.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssIEEE3B." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssIEEE3B : " );        
		PssIEEE3B entity = read();
		UpdatePssIEEE3BCommand command = generateUpdateCommand();
		command.setPssIEEE3BId(entity.getPssIEEE3BId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssIEEE3B." );

			// for use later on...
			pssIEEE3BId = entity.getPssIEEE3BId();

			PssIEEE3BBusinessDelegate proxy = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();  

			proxy.updatePssIEEE3B( command ).get();

			LOGGER.info( "-- Successfully saved PssIEEE3B - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssIEEE3BId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssIEEE3B.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssIEEE3B." );

		PssIEEE3B entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssIEEE3B with id " + pssIEEE3BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssIEEE3B with id " + pssIEEE3BId );

			throw e;
		}

		try{
			PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().delete( new DeletePssIEEE3BCommand( entity.getPssIEEE3BId() ) ).get();
			LOGGER.info( "-- Successfully deleted PssIEEE3B with id " + pssIEEE3BId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssIEEE3B with id " + pssIEEE3BId );

			throw e;
		}
	}

	/**
	 * get all PssIEEE3Bs.
	 */
	protected List<PssIEEE3B> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssIEEE3Bs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssIEEE3B : " );        
		List<PssIEEE3B> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssIEEE3BBusinessDelegate
			collection = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance().getAllPssIEEE3B();
			assertNotNull( collection, "An Empty collection of PssIEEE3B was incorrectly returned.");
			
			// Now print out the values
			PssIEEE3B entity = null;            
			Iterator<PssIEEE3B> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssIEEE3BId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssIEEE3BTest
	 */
	protected PssIEEE3BTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssIEEE3B
	 * 
	 * @return CreatePssIEEE3BCommand alias
	 */
	protected CreatePssIEEE3BCommand generateNewCommand() {
        CreatePssIEEE3BCommand command = new CreatePssIEEE3BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssIEEE3B
		 * 
		 * @return UpdatePssIEEE3BCommand alias
		 */
	protected UpdatePssIEEE3BCommand generateUpdateCommand() {
	        UpdatePssIEEE3BCommand command = new UpdatePssIEEE3BCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssIEEE3BId = null;
	protected PssIEEE3BSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssIEEE3BTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssIEEE3BList = 0;
}
