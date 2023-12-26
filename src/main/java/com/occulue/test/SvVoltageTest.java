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
 * Test SvVoltage class.
 *
 * @author your_name_here
 */
public class SvVoltageTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvVoltageTest() {
		subscriber = new SvVoltageSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvVoltageTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvVoltage...");
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
	 * jumpstart the process by instantiating2 SvVoltage
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svVoltageId = SvVoltageBusinessDelegate.getSvVoltageInstance()
		.createSvVoltage( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvVoltageBusinessDelegate.getSvVoltageInstance()
				.createSvVoltage( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svVoltageSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvVoltage : " + successValue.getSvVoltageId());
							  if (successValue.getSvVoltageId().equals(svVoltageId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvVoltageList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvVoltage test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svVoltage consumed")
					);
			subscriber.svVoltageSubscribe( svVoltageId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvVoltage : " + successValue.getSvVoltageId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvVoltageList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svVoltage for svVoltageId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvVoltage. 
	 */
	protected SvVoltage read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvVoltage" );

		SvVoltage entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvVoltage with primary key" );
		msg.append( svVoltageId );
		
		SvVoltageFetchOneSummary fetchOneSummary = new SvVoltageFetchOneSummary( svVoltageId );

		try {
			entity = SvVoltageBusinessDelegate.getSvVoltageInstance().getSvVoltage( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvVoltage " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvVoltage.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvVoltage." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvVoltage : " );        
		SvVoltage entity = read();
		UpdateSvVoltageCommand command = generateUpdateCommand();
		command.setSvVoltageId(entity.getSvVoltageId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvVoltage." );

			// for use later on...
			svVoltageId = entity.getSvVoltageId();

			SvVoltageBusinessDelegate proxy = SvVoltageBusinessDelegate.getSvVoltageInstance();  

			proxy.updateSvVoltage( command ).get();

			LOGGER.info( "-- Successfully saved SvVoltage - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svVoltageId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvVoltage.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvVoltage." );

		SvVoltage entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvVoltage with id " + svVoltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvVoltage with id " + svVoltageId );

			throw e;
		}

		try{
			SvVoltageBusinessDelegate.getSvVoltageInstance().delete( new DeleteSvVoltageCommand( entity.getSvVoltageId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvVoltage with id " + svVoltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvVoltage with id " + svVoltageId );

			throw e;
		}
	}

	/**
	 * get all SvVoltages.
	 */
	protected List<SvVoltage> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvVoltages:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvVoltage : " );        
		List<SvVoltage> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvVoltageBusinessDelegate
			collection = SvVoltageBusinessDelegate.getSvVoltageInstance().getAllSvVoltage();
			assertNotNull( collection, "An Empty collection of SvVoltage was incorrectly returned.");
			
			// Now print out the values
			SvVoltage entity = null;            
			Iterator<SvVoltage> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvVoltageId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvVoltageTest
	 */
	protected SvVoltageTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvVoltage
	 * 
	 * @return CreateSvVoltageCommand alias
	 */
	protected CreateSvVoltageCommand generateNewCommand() {
        CreateSvVoltageCommand command = new CreateSvVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvVoltage
		 * 
		 * @return UpdateSvVoltageCommand alias
		 */
	protected UpdateSvVoltageCommand generateUpdateCommand() {
	        UpdateSvVoltageCommand command = new UpdateSvVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svVoltageId = null;
	protected SvVoltageSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvVoltageTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvVoltageList = 0;
}
