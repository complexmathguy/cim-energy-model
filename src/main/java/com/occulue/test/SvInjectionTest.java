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
 * Test SvInjection class.
 *
 * @author your_name_here
 */
public class SvInjectionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvInjectionTest() {
		subscriber = new SvInjectionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvInjectionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvInjection...");
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
	 * jumpstart the process by instantiating2 SvInjection
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svInjectionId = SvInjectionBusinessDelegate.getSvInjectionInstance()
		.createSvInjection( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvInjectionBusinessDelegate.getSvInjectionInstance()
				.createSvInjection( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svInjectionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvInjection : " + successValue.getSvInjectionId());
							  if (successValue.getSvInjectionId().equals(svInjectionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvInjectionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvInjection test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svInjection consumed")
					);
			subscriber.svInjectionSubscribe( svInjectionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvInjection : " + successValue.getSvInjectionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvInjectionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svInjection for svInjectionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvInjection. 
	 */
	protected SvInjection read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvInjection" );

		SvInjection entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvInjection with primary key" );
		msg.append( svInjectionId );
		
		SvInjectionFetchOneSummary fetchOneSummary = new SvInjectionFetchOneSummary( svInjectionId );

		try {
			entity = SvInjectionBusinessDelegate.getSvInjectionInstance().getSvInjection( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvInjection " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvInjection.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvInjection." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvInjection : " );        
		SvInjection entity = read();
		UpdateSvInjectionCommand command = generateUpdateCommand();
		command.setSvInjectionId(entity.getSvInjectionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvInjection." );

			// for use later on...
			svInjectionId = entity.getSvInjectionId();

			SvInjectionBusinessDelegate proxy = SvInjectionBusinessDelegate.getSvInjectionInstance();  

			proxy.updateSvInjection( command ).get();

			LOGGER.info( "-- Successfully saved SvInjection - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svInjectionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvInjection.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvInjection." );

		SvInjection entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvInjection with id " + svInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvInjection with id " + svInjectionId );

			throw e;
		}

		try{
			SvInjectionBusinessDelegate.getSvInjectionInstance().delete( new DeleteSvInjectionCommand( entity.getSvInjectionId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvInjection with id " + svInjectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvInjection with id " + svInjectionId );

			throw e;
		}
	}

	/**
	 * get all SvInjections.
	 */
	protected List<SvInjection> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvInjections:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvInjection : " );        
		List<SvInjection> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvInjectionBusinessDelegate
			collection = SvInjectionBusinessDelegate.getSvInjectionInstance().getAllSvInjection();
			assertNotNull( collection, "An Empty collection of SvInjection was incorrectly returned.");
			
			// Now print out the values
			SvInjection entity = null;            
			Iterator<SvInjection> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvInjectionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvInjectionTest
	 */
	protected SvInjectionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvInjection
	 * 
	 * @return CreateSvInjectionCommand alias
	 */
	protected CreateSvInjectionCommand generateNewCommand() {
        CreateSvInjectionCommand command = new CreateSvInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvInjection
		 * 
		 * @return UpdateSvInjectionCommand alias
		 */
	protected UpdateSvInjectionCommand generateUpdateCommand() {
	        UpdateSvInjectionCommand command = new UpdateSvInjectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svInjectionId = null;
	protected SvInjectionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvInjectionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvInjectionList = 0;
}
