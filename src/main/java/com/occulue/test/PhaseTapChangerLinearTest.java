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
 * Test PhaseTapChangerLinear class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerLinearTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerLinearTest() {
		subscriber = new PhaseTapChangerLinearSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerLinearTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerLinear...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerLinear
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerLinearId = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
		.createPhaseTapChangerLinear( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
				.createPhaseTapChangerLinear( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerLinearSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerLinear : " + successValue.getPhaseTapChangerLinearId());
							  if (successValue.getPhaseTapChangerLinearId().equals(phaseTapChangerLinearId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerLinearList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerLinear test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerLinear consumed")
					);
			subscriber.phaseTapChangerLinearSubscribe( phaseTapChangerLinearId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerLinear : " + successValue.getPhaseTapChangerLinearId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerLinearList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerLinear for phaseTapChangerLinearId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerLinear. 
	 */
	protected PhaseTapChangerLinear read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerLinear" );

		PhaseTapChangerLinear entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerLinear with primary key" );
		msg.append( phaseTapChangerLinearId );
		
		PhaseTapChangerLinearFetchOneSummary fetchOneSummary = new PhaseTapChangerLinearFetchOneSummary( phaseTapChangerLinearId );

		try {
			entity = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().getPhaseTapChangerLinear( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerLinear " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerLinear.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerLinear." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerLinear : " );        
		PhaseTapChangerLinear entity = read();
		UpdatePhaseTapChangerLinearCommand command = generateUpdateCommand();
		command.setPhaseTapChangerLinearId(entity.getPhaseTapChangerLinearId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerLinear." );

			// for use later on...
			phaseTapChangerLinearId = entity.getPhaseTapChangerLinearId();

			PhaseTapChangerLinearBusinessDelegate proxy = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();  

			proxy.updatePhaseTapChangerLinear( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerLinear - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerLinearId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerLinear.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerLinear." );

		PhaseTapChangerLinear entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerLinear with id " + phaseTapChangerLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerLinear with id " + phaseTapChangerLinearId );

			throw e;
		}

		try{
			PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().delete( new DeletePhaseTapChangerLinearCommand( entity.getPhaseTapChangerLinearId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerLinear with id " + phaseTapChangerLinearId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerLinear with id " + phaseTapChangerLinearId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerLinears.
	 */
	protected List<PhaseTapChangerLinear> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerLinears:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerLinear : " );        
		List<PhaseTapChangerLinear> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerLinearBusinessDelegate
			collection = PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().getAllPhaseTapChangerLinear();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerLinear was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerLinear entity = null;            
			Iterator<PhaseTapChangerLinear> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerLinearId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerLinearTest
	 */
	protected PhaseTapChangerLinearTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerLinear
	 * 
	 * @return CreatePhaseTapChangerLinearCommand alias
	 */
	protected CreatePhaseTapChangerLinearCommand generateNewCommand() {
        CreatePhaseTapChangerLinearCommand command = new CreatePhaseTapChangerLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerLinear
		 * 
		 * @return UpdatePhaseTapChangerLinearCommand alias
		 */
	protected UpdatePhaseTapChangerLinearCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerLinearCommand command = new UpdatePhaseTapChangerLinearCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerLinearId = null;
	protected PhaseTapChangerLinearSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerLinearTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerLinearList = 0;
}
