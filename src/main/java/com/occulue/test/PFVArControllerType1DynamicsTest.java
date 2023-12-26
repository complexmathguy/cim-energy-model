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
 * Test PFVArControllerType1Dynamics class.
 *
 * @author your_name_here
 */
public class PFVArControllerType1DynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArControllerType1DynamicsTest() {
		subscriber = new PFVArControllerType1DynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArControllerType1DynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArControllerType1Dynamics...");
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
	 * jumpstart the process by instantiating2 PFVArControllerType1Dynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArControllerType1DynamicsId = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
		.createPFVArControllerType1Dynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance()
				.createPFVArControllerType1Dynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArControllerType1DynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArControllerType1Dynamics : " + successValue.getPFVArControllerType1DynamicsId());
							  if (successValue.getPFVArControllerType1DynamicsId().equals(pFVArControllerType1DynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArControllerType1DynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArControllerType1Dynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType1Dynamics consumed")
					);
			subscriber.pFVArControllerType1DynamicsSubscribe( pFVArControllerType1DynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArControllerType1Dynamics : " + successValue.getPFVArControllerType1DynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArControllerType1DynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType1Dynamics for pFVArControllerType1DynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArControllerType1Dynamics. 
	 */
	protected PFVArControllerType1Dynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArControllerType1Dynamics" );

		PFVArControllerType1Dynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArControllerType1Dynamics with primary key" );
		msg.append( pFVArControllerType1DynamicsId );
		
		PFVArControllerType1DynamicsFetchOneSummary fetchOneSummary = new PFVArControllerType1DynamicsFetchOneSummary( pFVArControllerType1DynamicsId );

		try {
			entity = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().getPFVArControllerType1Dynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArControllerType1Dynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArControllerType1Dynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArControllerType1Dynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArControllerType1Dynamics : " );        
		PFVArControllerType1Dynamics entity = read();
		UpdatePFVArControllerType1DynamicsCommand command = generateUpdateCommand();
		command.setPFVArControllerType1DynamicsId(entity.getPFVArControllerType1DynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArControllerType1Dynamics." );

			// for use later on...
			pFVArControllerType1DynamicsId = entity.getPFVArControllerType1DynamicsId();

			PFVArControllerType1DynamicsBusinessDelegate proxy = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance();  

			proxy.updatePFVArControllerType1Dynamics( command ).get();

			LOGGER.info( "-- Successfully saved PFVArControllerType1Dynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArControllerType1DynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArControllerType1Dynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArControllerType1Dynamics." );

		PFVArControllerType1Dynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArControllerType1Dynamics with id " + pFVArControllerType1DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArControllerType1Dynamics with id " + pFVArControllerType1DynamicsId );

			throw e;
		}

		try{
			PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().delete( new DeletePFVArControllerType1DynamicsCommand( entity.getPFVArControllerType1DynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArControllerType1Dynamics with id " + pFVArControllerType1DynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArControllerType1Dynamics with id " + pFVArControllerType1DynamicsId );

			throw e;
		}
	}

	/**
	 * get all PFVArControllerType1Dynamicss.
	 */
	protected List<PFVArControllerType1Dynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArControllerType1Dynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArControllerType1Dynamics : " );        
		List<PFVArControllerType1Dynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArControllerType1DynamicsBusinessDelegate
			collection = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().getAllPFVArControllerType1Dynamics();
			assertNotNull( collection, "An Empty collection of PFVArControllerType1Dynamics was incorrectly returned.");
			
			// Now print out the values
			PFVArControllerType1Dynamics entity = null;            
			Iterator<PFVArControllerType1Dynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArControllerType1DynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArControllerType1DynamicsTest
	 */
	protected PFVArControllerType1DynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArControllerType1Dynamics
	 * 
	 * @return CreatePFVArControllerType1DynamicsCommand alias
	 */
	protected CreatePFVArControllerType1DynamicsCommand generateNewCommand() {
        CreatePFVArControllerType1DynamicsCommand command = new CreatePFVArControllerType1DynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArControllerType1Dynamics
		 * 
		 * @return UpdatePFVArControllerType1DynamicsCommand alias
		 */
	protected UpdatePFVArControllerType1DynamicsCommand generateUpdateCommand() {
	        UpdatePFVArControllerType1DynamicsCommand command = new UpdatePFVArControllerType1DynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArControllerType1DynamicsId = null;
	protected PFVArControllerType1DynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArControllerType1DynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArControllerType1DynamicsList = 0;
}
