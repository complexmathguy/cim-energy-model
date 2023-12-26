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
 * Test PhaseTapChanger class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerTest() {
		subscriber = new PhaseTapChangerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChanger...");
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
	 * jumpstart the process by instantiating2 PhaseTapChanger
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerId = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance()
		.createPhaseTapChanger( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance()
				.createPhaseTapChanger( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChanger : " + successValue.getPhaseTapChangerId());
							  if (successValue.getPhaseTapChangerId().equals(phaseTapChangerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChanger test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChanger consumed")
					);
			subscriber.phaseTapChangerSubscribe( phaseTapChangerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChanger : " + successValue.getPhaseTapChangerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChanger for phaseTapChangerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChanger. 
	 */
	protected PhaseTapChanger read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChanger" );

		PhaseTapChanger entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChanger with primary key" );
		msg.append( phaseTapChangerId );
		
		PhaseTapChangerFetchOneSummary fetchOneSummary = new PhaseTapChangerFetchOneSummary( phaseTapChangerId );

		try {
			entity = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().getPhaseTapChanger( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChanger " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChanger.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChanger." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChanger : " );        
		PhaseTapChanger entity = read();
		UpdatePhaseTapChangerCommand command = generateUpdateCommand();
		command.setPhaseTapChangerId(entity.getPhaseTapChangerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChanger." );

			// for use later on...
			phaseTapChangerId = entity.getPhaseTapChangerId();

			PhaseTapChangerBusinessDelegate proxy = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance();  

			proxy.updatePhaseTapChanger( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChanger - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChanger.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChanger." );

		PhaseTapChanger entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChanger with id " + phaseTapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChanger with id " + phaseTapChangerId );

			throw e;
		}

		try{
			PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().delete( new DeletePhaseTapChangerCommand( entity.getPhaseTapChangerId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChanger with id " + phaseTapChangerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChanger with id " + phaseTapChangerId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangers.
	 */
	protected List<PhaseTapChanger> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChanger : " );        
		List<PhaseTapChanger> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerBusinessDelegate
			collection = PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().getAllPhaseTapChanger();
			assertNotNull( collection, "An Empty collection of PhaseTapChanger was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChanger entity = null;            
			Iterator<PhaseTapChanger> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerTest
	 */
	protected PhaseTapChangerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChanger
	 * 
	 * @return CreatePhaseTapChangerCommand alias
	 */
	protected CreatePhaseTapChangerCommand generateNewCommand() {
        CreatePhaseTapChangerCommand command = new CreatePhaseTapChangerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChanger
		 * 
		 * @return UpdatePhaseTapChangerCommand alias
		 */
	protected UpdatePhaseTapChangerCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerCommand command = new UpdatePhaseTapChangerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerId = null;
	protected PhaseTapChangerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerList = 0;
}
