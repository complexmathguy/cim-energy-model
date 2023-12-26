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
 * Test PhaseTapChangerAsymmetrical class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerAsymmetricalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerAsymmetricalTest() {
		subscriber = new PhaseTapChangerAsymmetricalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerAsymmetricalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerAsymmetrical...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerAsymmetrical
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerAsymmetricalId = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance()
		.createPhaseTapChangerAsymmetrical( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance()
				.createPhaseTapChangerAsymmetrical( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerAsymmetricalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerAsymmetrical : " + successValue.getPhaseTapChangerAsymmetricalId());
							  if (successValue.getPhaseTapChangerAsymmetricalId().equals(phaseTapChangerAsymmetricalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerAsymmetricalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerAsymmetrical test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerAsymmetrical consumed")
					);
			subscriber.phaseTapChangerAsymmetricalSubscribe( phaseTapChangerAsymmetricalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerAsymmetrical : " + successValue.getPhaseTapChangerAsymmetricalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerAsymmetricalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerAsymmetrical for phaseTapChangerAsymmetricalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerAsymmetrical. 
	 */
	protected PhaseTapChangerAsymmetrical read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerAsymmetrical" );

		PhaseTapChangerAsymmetrical entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerAsymmetrical with primary key" );
		msg.append( phaseTapChangerAsymmetricalId );
		
		PhaseTapChangerAsymmetricalFetchOneSummary fetchOneSummary = new PhaseTapChangerAsymmetricalFetchOneSummary( phaseTapChangerAsymmetricalId );

		try {
			entity = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().getPhaseTapChangerAsymmetrical( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerAsymmetrical " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerAsymmetrical.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerAsymmetrical." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerAsymmetrical : " );        
		PhaseTapChangerAsymmetrical entity = read();
		UpdatePhaseTapChangerAsymmetricalCommand command = generateUpdateCommand();
		command.setPhaseTapChangerAsymmetricalId(entity.getPhaseTapChangerAsymmetricalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerAsymmetrical." );

			// for use later on...
			phaseTapChangerAsymmetricalId = entity.getPhaseTapChangerAsymmetricalId();

			PhaseTapChangerAsymmetricalBusinessDelegate proxy = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance();  

			proxy.updatePhaseTapChangerAsymmetrical( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerAsymmetrical - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerAsymmetricalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerAsymmetrical.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerAsymmetrical." );

		PhaseTapChangerAsymmetrical entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerAsymmetrical with id " + phaseTapChangerAsymmetricalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerAsymmetrical with id " + phaseTapChangerAsymmetricalId );

			throw e;
		}

		try{
			PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().delete( new DeletePhaseTapChangerAsymmetricalCommand( entity.getPhaseTapChangerAsymmetricalId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerAsymmetrical with id " + phaseTapChangerAsymmetricalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerAsymmetrical with id " + phaseTapChangerAsymmetricalId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerAsymmetricals.
	 */
	protected List<PhaseTapChangerAsymmetrical> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerAsymmetricals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerAsymmetrical : " );        
		List<PhaseTapChangerAsymmetrical> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerAsymmetricalBusinessDelegate
			collection = PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance().getAllPhaseTapChangerAsymmetrical();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerAsymmetrical was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerAsymmetrical entity = null;            
			Iterator<PhaseTapChangerAsymmetrical> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerAsymmetricalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerAsymmetricalTest
	 */
	protected PhaseTapChangerAsymmetricalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerAsymmetrical
	 * 
	 * @return CreatePhaseTapChangerAsymmetricalCommand alias
	 */
	protected CreatePhaseTapChangerAsymmetricalCommand generateNewCommand() {
        CreatePhaseTapChangerAsymmetricalCommand command = new CreatePhaseTapChangerAsymmetricalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerAsymmetrical
		 * 
		 * @return UpdatePhaseTapChangerAsymmetricalCommand alias
		 */
	protected UpdatePhaseTapChangerAsymmetricalCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerAsymmetricalCommand command = new UpdatePhaseTapChangerAsymmetricalCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerAsymmetricalId = null;
	protected PhaseTapChangerAsymmetricalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerAsymmetricalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerAsymmetricalList = 0;
}
