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
 * Test SvTapStep class.
 *
 * @author your_name_here
 */
public class SvTapStepTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvTapStepTest() {
		subscriber = new SvTapStepSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvTapStepTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvTapStep...");
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
	 * jumpstart the process by instantiating2 SvTapStep
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svTapStepId = SvTapStepBusinessDelegate.getSvTapStepInstance()
		.createSvTapStep( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvTapStepBusinessDelegate.getSvTapStepInstance()
				.createSvTapStep( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svTapStepSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvTapStep : " + successValue.getSvTapStepId());
							  if (successValue.getSvTapStepId().equals(svTapStepId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvTapStepList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvTapStep test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svTapStep consumed")
					);
			subscriber.svTapStepSubscribe( svTapStepId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvTapStep : " + successValue.getSvTapStepId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvTapStepList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svTapStep for svTapStepId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvTapStep. 
	 */
	protected SvTapStep read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvTapStep" );

		SvTapStep entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvTapStep with primary key" );
		msg.append( svTapStepId );
		
		SvTapStepFetchOneSummary fetchOneSummary = new SvTapStepFetchOneSummary( svTapStepId );

		try {
			entity = SvTapStepBusinessDelegate.getSvTapStepInstance().getSvTapStep( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvTapStep " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvTapStep.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvTapStep." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvTapStep : " );        
		SvTapStep entity = read();
		UpdateSvTapStepCommand command = generateUpdateCommand();
		command.setSvTapStepId(entity.getSvTapStepId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvTapStep." );

			// for use later on...
			svTapStepId = entity.getSvTapStepId();

			SvTapStepBusinessDelegate proxy = SvTapStepBusinessDelegate.getSvTapStepInstance();  

			proxy.updateSvTapStep( command ).get();

			LOGGER.info( "-- Successfully saved SvTapStep - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svTapStepId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvTapStep.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvTapStep." );

		SvTapStep entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvTapStep with id " + svTapStepId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvTapStep with id " + svTapStepId );

			throw e;
		}

		try{
			SvTapStepBusinessDelegate.getSvTapStepInstance().delete( new DeleteSvTapStepCommand( entity.getSvTapStepId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvTapStep with id " + svTapStepId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvTapStep with id " + svTapStepId );

			throw e;
		}
	}

	/**
	 * get all SvTapSteps.
	 */
	protected List<SvTapStep> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvTapSteps:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvTapStep : " );        
		List<SvTapStep> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvTapStepBusinessDelegate
			collection = SvTapStepBusinessDelegate.getSvTapStepInstance().getAllSvTapStep();
			assertNotNull( collection, "An Empty collection of SvTapStep was incorrectly returned.");
			
			// Now print out the values
			SvTapStep entity = null;            
			Iterator<SvTapStep> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvTapStepId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvTapStepTest
	 */
	protected SvTapStepTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvTapStep
	 * 
	 * @return CreateSvTapStepCommand alias
	 */
	protected CreateSvTapStepCommand generateNewCommand() {
        CreateSvTapStepCommand command = new CreateSvTapStepCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvTapStep
		 * 
		 * @return UpdateSvTapStepCommand alias
		 */
	protected UpdateSvTapStepCommand generateUpdateCommand() {
	        UpdateSvTapStepCommand command = new UpdateSvTapStepCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svTapStepId = null;
	protected SvTapStepSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvTapStepTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvTapStepList = 0;
}
