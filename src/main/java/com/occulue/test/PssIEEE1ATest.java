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
 * Test PssIEEE1A class.
 *
 * @author your_name_here
 */
public class PssIEEE1ATest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssIEEE1ATest() {
		subscriber = new PssIEEE1ASubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssIEEE1ATest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssIEEE1A...");
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
	 * jumpstart the process by instantiating2 PssIEEE1A
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssIEEE1AId = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance()
		.createPssIEEE1A( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssIEEE1ABusinessDelegate.getPssIEEE1AInstance()
				.createPssIEEE1A( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssIEEE1ASubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssIEEE1A : " + successValue.getPssIEEE1AId());
							  if (successValue.getPssIEEE1AId().equals(pssIEEE1AId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssIEEE1AList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssIEEE1A test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssIEEE1A consumed")
					);
			subscriber.pssIEEE1ASubscribe( pssIEEE1AId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssIEEE1A : " + successValue.getPssIEEE1AId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssIEEE1AList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssIEEE1A for pssIEEE1AId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssIEEE1A. 
	 */
	protected PssIEEE1A read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssIEEE1A" );

		PssIEEE1A entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssIEEE1A with primary key" );
		msg.append( pssIEEE1AId );
		
		PssIEEE1AFetchOneSummary fetchOneSummary = new PssIEEE1AFetchOneSummary( pssIEEE1AId );

		try {
			entity = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().getPssIEEE1A( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssIEEE1A " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssIEEE1A.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssIEEE1A." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssIEEE1A : " );        
		PssIEEE1A entity = read();
		UpdatePssIEEE1ACommand command = generateUpdateCommand();
		command.setPssIEEE1AId(entity.getPssIEEE1AId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssIEEE1A." );

			// for use later on...
			pssIEEE1AId = entity.getPssIEEE1AId();

			PssIEEE1ABusinessDelegate proxy = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance();  

			proxy.updatePssIEEE1A( command ).get();

			LOGGER.info( "-- Successfully saved PssIEEE1A - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssIEEE1AId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssIEEE1A.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssIEEE1A." );

		PssIEEE1A entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssIEEE1A with id " + pssIEEE1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssIEEE1A with id " + pssIEEE1AId );

			throw e;
		}

		try{
			PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().delete( new DeletePssIEEE1ACommand( entity.getPssIEEE1AId() ) ).get();
			LOGGER.info( "-- Successfully deleted PssIEEE1A with id " + pssIEEE1AId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssIEEE1A with id " + pssIEEE1AId );

			throw e;
		}
	}

	/**
	 * get all PssIEEE1As.
	 */
	protected List<PssIEEE1A> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssIEEE1As:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssIEEE1A : " );        
		List<PssIEEE1A> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssIEEE1ABusinessDelegate
			collection = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().getAllPssIEEE1A();
			assertNotNull( collection, "An Empty collection of PssIEEE1A was incorrectly returned.");
			
			// Now print out the values
			PssIEEE1A entity = null;            
			Iterator<PssIEEE1A> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssIEEE1AId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssIEEE1ATest
	 */
	protected PssIEEE1ATest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssIEEE1A
	 * 
	 * @return CreatePssIEEE1ACommand alias
	 */
	protected CreatePssIEEE1ACommand generateNewCommand() {
        CreatePssIEEE1ACommand command = new CreatePssIEEE1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssIEEE1A
		 * 
		 * @return UpdatePssIEEE1ACommand alias
		 */
	protected UpdatePssIEEE1ACommand generateUpdateCommand() {
	        UpdatePssIEEE1ACommand command = new UpdatePssIEEE1ACommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssIEEE1AId = null;
	protected PssIEEE1ASubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssIEEE1ATest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssIEEE1AList = 0;
}
