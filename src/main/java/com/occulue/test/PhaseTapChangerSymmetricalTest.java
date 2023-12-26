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
 * Test PhaseTapChangerSymmetrical class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerSymmetricalTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerSymmetricalTest() {
		subscriber = new PhaseTapChangerSymmetricalSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerSymmetricalTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerSymmetrical...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerSymmetrical
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerSymmetricalId = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance()
		.createPhaseTapChangerSymmetrical( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance()
				.createPhaseTapChangerSymmetrical( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerSymmetricalSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerSymmetrical : " + successValue.getPhaseTapChangerSymmetricalId());
							  if (successValue.getPhaseTapChangerSymmetricalId().equals(phaseTapChangerSymmetricalId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerSymmetricalList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerSymmetrical test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerSymmetrical consumed")
					);
			subscriber.phaseTapChangerSymmetricalSubscribe( phaseTapChangerSymmetricalId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerSymmetrical : " + successValue.getPhaseTapChangerSymmetricalId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerSymmetricalList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerSymmetrical for phaseTapChangerSymmetricalId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerSymmetrical. 
	 */
	protected PhaseTapChangerSymmetrical read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerSymmetrical" );

		PhaseTapChangerSymmetrical entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerSymmetrical with primary key" );
		msg.append( phaseTapChangerSymmetricalId );
		
		PhaseTapChangerSymmetricalFetchOneSummary fetchOneSummary = new PhaseTapChangerSymmetricalFetchOneSummary( phaseTapChangerSymmetricalId );

		try {
			entity = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().getPhaseTapChangerSymmetrical( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerSymmetrical " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerSymmetrical.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerSymmetrical." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerSymmetrical : " );        
		PhaseTapChangerSymmetrical entity = read();
		UpdatePhaseTapChangerSymmetricalCommand command = generateUpdateCommand();
		command.setPhaseTapChangerSymmetricalId(entity.getPhaseTapChangerSymmetricalId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerSymmetrical." );

			// for use later on...
			phaseTapChangerSymmetricalId = entity.getPhaseTapChangerSymmetricalId();

			PhaseTapChangerSymmetricalBusinessDelegate proxy = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance();  

			proxy.updatePhaseTapChangerSymmetrical( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerSymmetrical - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerSymmetricalId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerSymmetrical.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerSymmetrical." );

		PhaseTapChangerSymmetrical entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerSymmetrical with id " + phaseTapChangerSymmetricalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerSymmetrical with id " + phaseTapChangerSymmetricalId );

			throw e;
		}

		try{
			PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().delete( new DeletePhaseTapChangerSymmetricalCommand( entity.getPhaseTapChangerSymmetricalId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerSymmetrical with id " + phaseTapChangerSymmetricalId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerSymmetrical with id " + phaseTapChangerSymmetricalId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerSymmetricals.
	 */
	protected List<PhaseTapChangerSymmetrical> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerSymmetricals:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerSymmetrical : " );        
		List<PhaseTapChangerSymmetrical> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerSymmetricalBusinessDelegate
			collection = PhaseTapChangerSymmetricalBusinessDelegate.getPhaseTapChangerSymmetricalInstance().getAllPhaseTapChangerSymmetrical();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerSymmetrical was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerSymmetrical entity = null;            
			Iterator<PhaseTapChangerSymmetrical> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerSymmetricalId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerSymmetricalTest
	 */
	protected PhaseTapChangerSymmetricalTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerSymmetrical
	 * 
	 * @return CreatePhaseTapChangerSymmetricalCommand alias
	 */
	protected CreatePhaseTapChangerSymmetricalCommand generateNewCommand() {
        CreatePhaseTapChangerSymmetricalCommand command = new CreatePhaseTapChangerSymmetricalCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerSymmetrical
		 * 
		 * @return UpdatePhaseTapChangerSymmetricalCommand alias
		 */
	protected UpdatePhaseTapChangerSymmetricalCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerSymmetricalCommand command = new UpdatePhaseTapChangerSymmetricalCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerSymmetricalId = null;
	protected PhaseTapChangerSymmetricalSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerSymmetricalTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerSymmetricalList = 0;
}
