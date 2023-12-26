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
 * Test PFVArControllerType2Dynamics class.
 *
 * @author your_name_here
 */
public class PFVArControllerType2DynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArControllerType2DynamicsTest() {
		subscriber = new PFVArControllerType2DynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArControllerType2DynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArControllerType2Dynamics...");
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
	 * jumpstart the process by instantiating2 PFVArControllerType2Dynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArControllerType2DynamicsId = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
		.createPFVArControllerType2Dynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance()
				.createPFVArControllerType2Dynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArControllerType2DynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArControllerType2Dynamics : " + successValue.getPFVArControllerType2DynamicsId());
							  if (successValue.getPFVArControllerType2DynamicsId().equals(pFVArControllerType2DynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArControllerType2DynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArControllerType2Dynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType2Dynamics consumed")
					);
			subscriber.pFVArControllerType2DynamicsSubscribe( pFVArControllerType2DynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArControllerType2Dynamics : " + successValue.getPFVArControllerType2DynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArControllerType2DynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType2Dynamics for pFVArControllerType2DynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArControllerType2Dynamics. 
	 */
	protected PFVArControllerType2Dynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArControllerType2Dynamics" );

		PFVArControllerType2Dynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArControllerType2Dynamics with primary key" );
		msg.append( pFVArControllerType2DynamicsId );
		
		PFVArControllerType2DynamicsFetchOneSummary fetchOneSummary = new PFVArControllerType2DynamicsFetchOneSummary( pFVArControllerType2DynamicsId );

		try {
			entity = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().getPFVArControllerType2Dynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArControllerType2Dynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArControllerType2Dynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArControllerType2Dynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArControllerType2Dynamics : " );        
		PFVArControllerType2Dynamics entity = read();
		UpdatePFVArControllerType2DynamicsCommand command = generateUpdateCommand();
		command.setPFVArControllerType2DynamicsId(entity.getPFVArControllerType2DynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArControllerType2Dynamics." );

			// for use later on...
			pFVArControllerType2DynamicsId = entity.getPFVArControllerType2DynamicsId();

			PFVArControllerType2DynamicsBusinessDelegate proxy = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance();  

			proxy.updatePFVArControllerType2Dynamics( command ).get();

			LOGGER.info( "-- Successfully saved PFVArControllerType2Dynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArControllerType2DynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArControllerType2Dynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArControllerType2Dynamics." );

		PFVArControllerType2Dynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArControllerType2Dynamics with id " + pFVArControllerType2DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArControllerType2Dynamics with id " + pFVArControllerType2DynamicsId );

			throw e;
		}

		try{
			PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().delete( new DeletePFVArControllerType2DynamicsCommand( entity.getPFVArControllerType2DynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArControllerType2Dynamics with id " + pFVArControllerType2DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArControllerType2Dynamics with id " + pFVArControllerType2DynamicsId );

			throw e;
		}
	}

	/**
	 * get all PFVArControllerType2Dynamicss.
	 */
	protected List<PFVArControllerType2Dynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArControllerType2Dynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArControllerType2Dynamics : " );        
		List<PFVArControllerType2Dynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArControllerType2DynamicsBusinessDelegate
			collection = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().getAllPFVArControllerType2Dynamics();
			assertNotNull( collection, "An Empty collection of PFVArControllerType2Dynamics was incorrectly returned.");
			
			// Now print out the values
			PFVArControllerType2Dynamics entity = null;            
			Iterator<PFVArControllerType2Dynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArControllerType2DynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArControllerType2DynamicsTest
	 */
	protected PFVArControllerType2DynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArControllerType2Dynamics
	 * 
	 * @return CreatePFVArControllerType2DynamicsCommand alias
	 */
	protected CreatePFVArControllerType2DynamicsCommand generateNewCommand() {
        CreatePFVArControllerType2DynamicsCommand command = new CreatePFVArControllerType2DynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArControllerType2Dynamics
		 * 
		 * @return UpdatePFVArControllerType2DynamicsCommand alias
		 */
	protected UpdatePFVArControllerType2DynamicsCommand generateUpdateCommand() {
	        UpdatePFVArControllerType2DynamicsCommand command = new UpdatePFVArControllerType2DynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArControllerType2DynamicsId = null;
	protected PFVArControllerType2DynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArControllerType2DynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArControllerType2DynamicsList = 0;
}
