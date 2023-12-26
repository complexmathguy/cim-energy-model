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
 * Test PssSB4 class.
 *
 * @author your_name_here
 */
public class PssSB4Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssSB4Test() {
		subscriber = new PssSB4Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssSB4Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssSB4...");
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
	 * jumpstart the process by instantiating2 PssSB4
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssSB4Id = PssSB4BusinessDelegate.getPssSB4Instance()
		.createPssSB4( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssSB4BusinessDelegate.getPssSB4Instance()
				.createPssSB4( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssSB4Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssSB4 : " + successValue.getPssSB4Id());
							  if (successValue.getPssSB4Id().equals(pssSB4Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssSB4List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssSB4 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssSB4 consumed")
					);
			subscriber.pssSB4Subscribe( pssSB4Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssSB4 : " + successValue.getPssSB4Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssSB4List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssSB4 for pssSB4Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssSB4. 
	 */
	protected PssSB4 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssSB4" );

		PssSB4 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssSB4 with primary key" );
		msg.append( pssSB4Id );
		
		PssSB4FetchOneSummary fetchOneSummary = new PssSB4FetchOneSummary( pssSB4Id );

		try {
			entity = PssSB4BusinessDelegate.getPssSB4Instance().getPssSB4( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssSB4 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssSB4.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssSB4." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssSB4 : " );        
		PssSB4 entity = read();
		UpdatePssSB4Command command = generateUpdateCommand();
		command.setPssSB4Id(entity.getPssSB4Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssSB4." );

			// for use later on...
			pssSB4Id = entity.getPssSB4Id();

			PssSB4BusinessDelegate proxy = PssSB4BusinessDelegate.getPssSB4Instance();  

			proxy.updatePssSB4( command ).get();

			LOGGER.info( "-- Successfully saved PssSB4 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssSB4Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssSB4.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssSB4." );

		PssSB4 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssSB4 with id " + pssSB4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssSB4 with id " + pssSB4Id );

			throw e;
		}

		try{
			PssSB4BusinessDelegate.getPssSB4Instance().delete( new DeletePssSB4Command( entity.getPssSB4Id() ) ).get();
			LOGGER.info( "-- Successfully deleted PssSB4 with id " + pssSB4Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssSB4 with id " + pssSB4Id );

			throw e;
		}
	}

	/**
	 * get all PssSB4s.
	 */
	protected List<PssSB4> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssSB4s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssSB4 : " );        
		List<PssSB4> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssSB4BusinessDelegate
			collection = PssSB4BusinessDelegate.getPssSB4Instance().getAllPssSB4();
			assertNotNull( collection, "An Empty collection of PssSB4 was incorrectly returned.");
			
			// Now print out the values
			PssSB4 entity = null;            
			Iterator<PssSB4> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssSB4Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssSB4Test
	 */
	protected PssSB4Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssSB4
	 * 
	 * @return CreatePssSB4Command alias
	 */
	protected CreatePssSB4Command generateNewCommand() {
        CreatePssSB4Command command = new CreatePssSB4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssSB4
		 * 
		 * @return UpdatePssSB4Command alias
		 */
	protected UpdatePssSB4Command generateUpdateCommand() {
	        UpdatePssSB4Command command = new UpdatePssSB4Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssSB4Id = null;
	protected PssSB4Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssSB4Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssSB4List = 0;
}
