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
 * Test PhaseTapChangerNonLinear class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerNonLinearTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerNonLinearTest() {
		subscriber = new PhaseTapChangerNonLinearSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerNonLinearTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerNonLinear...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerNonLinear
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerNonLinearId = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
		.createPhaseTapChangerNonLinear( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
				.createPhaseTapChangerNonLinear( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerNonLinearSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerNonLinear : " + successValue.getPhaseTapChangerNonLinearId());
							  if (successValue.getPhaseTapChangerNonLinearId().equals(phaseTapChangerNonLinearId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerNonLinearList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerNonLinear test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerNonLinear consumed")
					);
			subscriber.phaseTapChangerNonLinearSubscribe( phaseTapChangerNonLinearId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerNonLinear : " + successValue.getPhaseTapChangerNonLinearId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerNonLinearList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerNonLinear for phaseTapChangerNonLinearId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerNonLinear. 
	 */
	protected PhaseTapChangerNonLinear read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerNonLinear" );

		PhaseTapChangerNonLinear entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerNonLinear with primary key" );
		msg.append( phaseTapChangerNonLinearId );
		
		PhaseTapChangerNonLinearFetchOneSummary fetchOneSummary = new PhaseTapChangerNonLinearFetchOneSummary( phaseTapChangerNonLinearId );

		try {
			entity = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().getPhaseTapChangerNonLinear( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerNonLinear " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerNonLinear.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerNonLinear." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerNonLinear : " );        
		PhaseTapChangerNonLinear entity = read();
		UpdatePhaseTapChangerNonLinearCommand command = generateUpdateCommand();
		command.setPhaseTapChangerNonLinearId(entity.getPhaseTapChangerNonLinearId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerNonLinear." );

			// for use later on...
			phaseTapChangerNonLinearId = entity.getPhaseTapChangerNonLinearId();

			PhaseTapChangerNonLinearBusinessDelegate proxy = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();  

			proxy.updatePhaseTapChangerNonLinear( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerNonLinear - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerNonLinearId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerNonLinear.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerNonLinear." );

		PhaseTapChangerNonLinear entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerNonLinear with id " + phaseTapChangerNonLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerNonLinear with id " + phaseTapChangerNonLinearId );

			throw e;
		}

		try{
			PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().delete( new DeletePhaseTapChangerNonLinearCommand( entity.getPhaseTapChangerNonLinearId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerNonLinear with id " + phaseTapChangerNonLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerNonLinear with id " + phaseTapChangerNonLinearId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerNonLinears.
	 */
	protected List<PhaseTapChangerNonLinear> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerNonLinears:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerNonLinear : " );        
		List<PhaseTapChangerNonLinear> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerNonLinearBusinessDelegate
			collection = PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance().getAllPhaseTapChangerNonLinear();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerNonLinear was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerNonLinear entity = null;            
			Iterator<PhaseTapChangerNonLinear> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerNonLinearId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerNonLinearTest
	 */
	protected PhaseTapChangerNonLinearTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerNonLinear
	 * 
	 * @return CreatePhaseTapChangerNonLinearCommand alias
	 */
	protected CreatePhaseTapChangerNonLinearCommand generateNewCommand() {
        CreatePhaseTapChangerNonLinearCommand command = new CreatePhaseTapChangerNonLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerNonLinear
		 * 
		 * @return UpdatePhaseTapChangerNonLinearCommand alias
		 */
	protected UpdatePhaseTapChangerNonLinearCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerNonLinearCommand command = new UpdatePhaseTapChangerNonLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerNonLinearId = null;
	protected PhaseTapChangerNonLinearSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerNonLinearTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerNonLinearList = 0;
}
