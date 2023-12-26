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
 * Test SvStatus class.
 *
 * @author your_name_here
 */
public class SvStatusTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvStatusTest() {
		subscriber = new SvStatusSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvStatusTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvStatus...");
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
	 * jumpstart the process by instantiating2 SvStatus
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svStatusId = SvStatusBusinessDelegate.getSvStatusInstance()
		.createSvStatus( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvStatusBusinessDelegate.getSvStatusInstance()
				.createSvStatus( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svStatusSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvStatus : " + successValue.getSvStatusId());
							  if (successValue.getSvStatusId().equals(svStatusId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvStatusList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvStatus test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svStatus consumed")
					);
			subscriber.svStatusSubscribe( svStatusId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvStatus : " + successValue.getSvStatusId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvStatusList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svStatus for svStatusId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvStatus. 
	 */
	protected SvStatus read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvStatus" );

		SvStatus entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvStatus with primary key" );
		msg.append( svStatusId );
		
		SvStatusFetchOneSummary fetchOneSummary = new SvStatusFetchOneSummary( svStatusId );

		try {
			entity = SvStatusBusinessDelegate.getSvStatusInstance().getSvStatus( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvStatus " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvStatus.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvStatus." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvStatus : " );        
		SvStatus entity = read();
		UpdateSvStatusCommand command = generateUpdateCommand();
		command.setSvStatusId(entity.getSvStatusId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvStatus." );

			// for use later on...
			svStatusId = entity.getSvStatusId();

			SvStatusBusinessDelegate proxy = SvStatusBusinessDelegate.getSvStatusInstance();  

			proxy.updateSvStatus( command ).get();

			LOGGER.info( "-- Successfully saved SvStatus - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svStatusId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvStatus.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvStatus." );

		SvStatus entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvStatus with id " + svStatusId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvStatus with id " + svStatusId );

			throw e;
		}

		try{
			SvStatusBusinessDelegate.getSvStatusInstance().delete( new DeleteSvStatusCommand( entity.getSvStatusId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvStatus with id " + svStatusId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvStatus with id " + svStatusId );

			throw e;
		}
	}

	/**
	 * get all SvStatuss.
	 */
	protected List<SvStatus> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvStatuss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvStatus : " );        
		List<SvStatus> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvStatusBusinessDelegate
			collection = SvStatusBusinessDelegate.getSvStatusInstance().getAllSvStatus();
			assertNotNull( collection, "An Empty collection of SvStatus was incorrectly returned.");
			
			// Now print out the values
			SvStatus entity = null;            
			Iterator<SvStatus> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvStatusId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvStatusTest
	 */
	protected SvStatusTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvStatus
	 * 
	 * @return CreateSvStatusCommand alias
	 */
	protected CreateSvStatusCommand generateNewCommand() {
        CreateSvStatusCommand command = new CreateSvStatusCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvStatus
		 * 
		 * @return UpdateSvStatusCommand alias
		 */
	protected UpdateSvStatusCommand generateUpdateCommand() {
	        UpdateSvStatusCommand command = new UpdateSvStatusCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svStatusId = null;
	protected SvStatusSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvStatusTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvStatusList = 0;
}
