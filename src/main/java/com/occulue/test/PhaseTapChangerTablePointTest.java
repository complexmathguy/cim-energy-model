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
 * Test PhaseTapChangerTablePoint class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerTablePointTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerTablePointTest() {
		subscriber = new PhaseTapChangerTablePointSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerTablePointTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerTablePoint...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerTablePoint
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerTablePointId = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
		.createPhaseTapChangerTablePoint( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
				.createPhaseTapChangerTablePoint( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerTablePointSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerTablePoint : " + successValue.getPhaseTapChangerTablePointId());
							  if (successValue.getPhaseTapChangerTablePointId().equals(phaseTapChangerTablePointId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerTablePointList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerTablePoint test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTablePoint consumed")
					);
			subscriber.phaseTapChangerTablePointSubscribe( phaseTapChangerTablePointId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerTablePoint : " + successValue.getPhaseTapChangerTablePointId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerTablePointList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTablePoint for phaseTapChangerTablePointId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerTablePoint. 
	 */
	protected PhaseTapChangerTablePoint read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerTablePoint" );

		PhaseTapChangerTablePoint entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerTablePoint with primary key" );
		msg.append( phaseTapChangerTablePointId );
		
		PhaseTapChangerTablePointFetchOneSummary fetchOneSummary = new PhaseTapChangerTablePointFetchOneSummary( phaseTapChangerTablePointId );

		try {
			entity = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().getPhaseTapChangerTablePoint( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerTablePoint " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerTablePoint.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerTablePoint." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerTablePoint : " );        
		PhaseTapChangerTablePoint entity = read();
		UpdatePhaseTapChangerTablePointCommand command = generateUpdateCommand();
		command.setPhaseTapChangerTablePointId(entity.getPhaseTapChangerTablePointId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerTablePoint." );

			// for use later on...
			phaseTapChangerTablePointId = entity.getPhaseTapChangerTablePointId();

			PhaseTapChangerTablePointBusinessDelegate proxy = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance();  

			proxy.updatePhaseTapChangerTablePoint( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerTablePoint - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerTablePointId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerTablePoint.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerTablePoint." );

		PhaseTapChangerTablePoint entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerTablePoint with id " + phaseTapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerTablePoint with id " + phaseTapChangerTablePointId );

			throw e;
		}

		try{
			PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().delete( new DeletePhaseTapChangerTablePointCommand( entity.getPhaseTapChangerTablePointId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerTablePoint with id " + phaseTapChangerTablePointId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerTablePoint with id " + phaseTapChangerTablePointId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerTablePoints.
	 */
	protected List<PhaseTapChangerTablePoint> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerTablePoints:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerTablePoint : " );        
		List<PhaseTapChangerTablePoint> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerTablePointBusinessDelegate
			collection = PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance().getAllPhaseTapChangerTablePoint();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerTablePoint was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerTablePoint entity = null;            
			Iterator<PhaseTapChangerTablePoint> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerTablePointId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerTablePointTest
	 */
	protected PhaseTapChangerTablePointTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerTablePoint
	 * 
	 * @return CreatePhaseTapChangerTablePointCommand alias
	 */
	protected CreatePhaseTapChangerTablePointCommand generateNewCommand() {
        CreatePhaseTapChangerTablePointCommand command = new CreatePhaseTapChangerTablePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerTablePoint
		 * 
		 * @return UpdatePhaseTapChangerTablePointCommand alias
		 */
	protected UpdatePhaseTapChangerTablePointCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerTablePointCommand command = new UpdatePhaseTapChangerTablePointCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerTablePointId = null;
	protected PhaseTapChangerTablePointSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerTablePointTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerTablePointList = 0;
}
