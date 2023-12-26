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
 * Test PhaseTapChangerTabular class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerTabularTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerTabularTest() {
		subscriber = new PhaseTapChangerTabularSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerTabularTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerTabular...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerTabular
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerTabularId = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance()
		.createPhaseTapChangerTabular( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance()
				.createPhaseTapChangerTabular( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerTabularSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerTabular : " + successValue.getPhaseTapChangerTabularId());
							  if (successValue.getPhaseTapChangerTabularId().equals(phaseTapChangerTabularId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerTabularList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerTabular test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTabular consumed")
					);
			subscriber.phaseTapChangerTabularSubscribe( phaseTapChangerTabularId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerTabular : " + successValue.getPhaseTapChangerTabularId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerTabularList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTabular for phaseTapChangerTabularId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerTabular. 
	 */
	protected PhaseTapChangerTabular read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerTabular" );

		PhaseTapChangerTabular entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerTabular with primary key" );
		msg.append( phaseTapChangerTabularId );
		
		PhaseTapChangerTabularFetchOneSummary fetchOneSummary = new PhaseTapChangerTabularFetchOneSummary( phaseTapChangerTabularId );

		try {
			entity = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance().getPhaseTapChangerTabular( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerTabular " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerTabular.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerTabular." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerTabular : " );        
		PhaseTapChangerTabular entity = read();
		UpdatePhaseTapChangerTabularCommand command = generateUpdateCommand();
		command.setPhaseTapChangerTabularId(entity.getPhaseTapChangerTabularId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerTabular." );

			// for use later on...
			phaseTapChangerTabularId = entity.getPhaseTapChangerTabularId();

			PhaseTapChangerTabularBusinessDelegate proxy = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance();  

			proxy.updatePhaseTapChangerTabular( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerTabular - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerTabularId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerTabular.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerTabular." );

		PhaseTapChangerTabular entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerTabular with id " + phaseTapChangerTabularId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerTabular with id " + phaseTapChangerTabularId );

			throw e;
		}

		try{
			PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance().delete( new DeletePhaseTapChangerTabularCommand( entity.getPhaseTapChangerTabularId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerTabular with id " + phaseTapChangerTabularId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerTabular with id " + phaseTapChangerTabularId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerTabulars.
	 */
	protected List<PhaseTapChangerTabular> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerTabulars:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerTabular : " );        
		List<PhaseTapChangerTabular> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerTabularBusinessDelegate
			collection = PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance().getAllPhaseTapChangerTabular();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerTabular was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerTabular entity = null;            
			Iterator<PhaseTapChangerTabular> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerTabularId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerTabularTest
	 */
	protected PhaseTapChangerTabularTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerTabular
	 * 
	 * @return CreatePhaseTapChangerTabularCommand alias
	 */
	protected CreatePhaseTapChangerTabularCommand generateNewCommand() {
        CreatePhaseTapChangerTabularCommand command = new CreatePhaseTapChangerTabularCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerTabular
		 * 
		 * @return UpdatePhaseTapChangerTabularCommand alias
		 */
	protected UpdatePhaseTapChangerTabularCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerTabularCommand command = new UpdatePhaseTapChangerTabularCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerTabularId = null;
	protected PhaseTapChangerTabularSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerTabularTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerTabularList = 0;
}
