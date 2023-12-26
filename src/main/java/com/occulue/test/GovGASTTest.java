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
 * Test GovGAST class.
 *
 * @author your_name_here
 */
public class GovGASTTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovGASTTest() {
		subscriber = new GovGASTSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovGASTTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovGAST...");
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
	 * jumpstart the process by instantiating2 GovGAST
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govGASTId = GovGASTBusinessDelegate.getGovGASTInstance()
		.createGovGAST( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovGASTBusinessDelegate.getGovGASTInstance()
				.createGovGAST( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govGASTSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovGAST : " + successValue.getGovGASTId());
							  if (successValue.getGovGASTId().equals(govGASTId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovGASTList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovGAST test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govGAST consumed")
					);
			subscriber.govGASTSubscribe( govGASTId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovGAST : " + successValue.getGovGASTId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovGASTList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govGAST for govGASTId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovGAST. 
	 */
	protected GovGAST read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovGAST" );

		GovGAST entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovGAST with primary key" );
		msg.append( govGASTId );
		
		GovGASTFetchOneSummary fetchOneSummary = new GovGASTFetchOneSummary( govGASTId );

		try {
			entity = GovGASTBusinessDelegate.getGovGASTInstance().getGovGAST( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovGAST " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovGAST.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovGAST." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovGAST : " );        
		GovGAST entity = read();
		UpdateGovGASTCommand command = generateUpdateCommand();
		command.setGovGASTId(entity.getGovGASTId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovGAST." );

			// for use later on...
			govGASTId = entity.getGovGASTId();

			GovGASTBusinessDelegate proxy = GovGASTBusinessDelegate.getGovGASTInstance();  

			proxy.updateGovGAST( command ).get();

			LOGGER.info( "-- Successfully saved GovGAST - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govGASTId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovGAST.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovGAST." );

		GovGAST entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovGAST with id " + govGASTId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovGAST with id " + govGASTId );

			throw e;
		}

		try{
			GovGASTBusinessDelegate.getGovGASTInstance().delete( new DeleteGovGASTCommand( entity.getGovGASTId() ) ).get();
			LOGGER.info( "-- Successfully deleted GovGAST with id " + govGASTId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovGAST with id " + govGASTId );

			throw e;
		}
	}

	/**
	 * get all GovGASTs.
	 */
	protected List<GovGAST> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovGASTs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovGAST : " );        
		List<GovGAST> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovGASTBusinessDelegate
			collection = GovGASTBusinessDelegate.getGovGASTInstance().getAllGovGAST();
			assertNotNull( collection, "An Empty collection of GovGAST was incorrectly returned.");
			
			// Now print out the values
			GovGAST entity = null;            
			Iterator<GovGAST> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovGASTId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovGASTTest
	 */
	protected GovGASTTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovGAST
	 * 
	 * @return CreateGovGASTCommand alias
	 */
	protected CreateGovGASTCommand generateNewCommand() {
        CreateGovGASTCommand command = new CreateGovGASTCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovGAST
		 * 
		 * @return UpdateGovGASTCommand alias
		 */
	protected UpdateGovGASTCommand generateUpdateCommand() {
	        UpdateGovGASTCommand command = new UpdateGovGASTCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govGASTId = null;
	protected GovGASTSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovGASTTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovGASTList = 0;
}
