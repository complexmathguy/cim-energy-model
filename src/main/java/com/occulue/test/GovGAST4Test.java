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
 * Test GovGAST4 class.
 *
 * @author your_name_here
 */
public class GovGAST4Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GovGAST4Test() {
		subscriber = new GovGAST4Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GovGAST4Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GovGAST4...");
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
	 * jumpstart the process by instantiating2 GovGAST4
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		govGAST4Id = GovGAST4BusinessDelegate.getGovGAST4Instance()
		.createGovGAST4( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GovGAST4BusinessDelegate.getGovGAST4Instance()
				.createGovGAST4( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.govGAST4Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GovGAST4 : " + successValue.getGovGAST4Id());
							  if (successValue.getGovGAST4Id().equals(govGAST4Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGovGAST4List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GovGAST4 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govGAST4 consumed")
					);
			subscriber.govGAST4Subscribe( govGAST4Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GovGAST4 : " + successValue.getGovGAST4Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGovGAST4List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on govGAST4 for govGAST4Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GovGAST4. 
	 */
	protected GovGAST4 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GovGAST4" );

		GovGAST4 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GovGAST4 with primary key" );
		msg.append( govGAST4Id );
		
		GovGAST4FetchOneSummary fetchOneSummary = new GovGAST4FetchOneSummary( govGAST4Id );

		try {
			entity = GovGAST4BusinessDelegate.getGovGAST4Instance().getGovGAST4( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GovGAST4 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GovGAST4.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GovGAST4." );

		StringBuilder msg = new StringBuilder( "Failed to update a GovGAST4 : " );        
		GovGAST4 entity = read();
		UpdateGovGAST4Command command = generateUpdateCommand();
		command.setGovGAST4Id(entity.getGovGAST4Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GovGAST4." );

			// for use later on...
			govGAST4Id = entity.getGovGAST4Id();

			GovGAST4BusinessDelegate proxy = GovGAST4BusinessDelegate.getGovGAST4Instance();  

			proxy.updateGovGAST4( command ).get();

			LOGGER.info( "-- Successfully saved GovGAST4 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + govGAST4Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GovGAST4.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GovGAST4." );

		GovGAST4 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GovGAST4 with id " + govGAST4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GovGAST4 with id " + govGAST4Id );

			throw e;
		}

		try{
			GovGAST4BusinessDelegate.getGovGAST4Instance().delete( new DeleteGovGAST4Command( entity.getGovGAST4Id() ) ).get();
			LOGGER.info( "-- Successfully deleted GovGAST4 with id " + govGAST4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GovGAST4 with id " + govGAST4Id );

			throw e;
		}
	}

	/**
	 * get all GovGAST4s.
	 */
	protected List<GovGAST4> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GovGAST4s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GovGAST4 : " );        
		List<GovGAST4> collection  = new ArrayList<>();

		try {
			// call the static get method on the GovGAST4BusinessDelegate
			collection = GovGAST4BusinessDelegate.getGovGAST4Instance().getAllGovGAST4();
			assertNotNull( collection, "An Empty collection of GovGAST4 was incorrectly returned.");
			
			// Now print out the values
			GovGAST4 entity = null;            
			Iterator<GovGAST4> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGovGAST4Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GovGAST4Test
	 */
	protected GovGAST4Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GovGAST4
	 * 
	 * @return CreateGovGAST4Command alias
	 */
	protected CreateGovGAST4Command generateNewCommand() {
        CreateGovGAST4Command command = new CreateGovGAST4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GovGAST4
		 * 
		 * @return UpdateGovGAST4Command alias
		 */
	protected UpdateGovGAST4Command generateUpdateCommand() {
	        UpdateGovGAST4Command command = new UpdateGovGAST4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID govGAST4Id = null;
	protected GovGAST4Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GovGAST4Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfGovGAST4List = 0;
}
