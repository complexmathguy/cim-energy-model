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
 * Test MechanicalLoadDynamics class.
 *
 * @author your_name_here
 */
public class MechanicalLoadDynamicsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MechanicalLoadDynamicsTest() {
		subscriber = new MechanicalLoadDynamicsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MechanicalLoadDynamicsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MechanicalLoadDynamics...");
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
	 * jumpstart the process by instantiating2 MechanicalLoadDynamics
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		mechanicalLoadDynamicsId = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
		.createMechanicalLoadDynamics( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance()
				.createMechanicalLoadDynamics( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.mechanicalLoadDynamicsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MechanicalLoadDynamics : " + successValue.getMechanicalLoadDynamicsId());
							  if (successValue.getMechanicalLoadDynamicsId().equals(mechanicalLoadDynamicsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMechanicalLoadDynamicsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MechanicalLoadDynamics test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechanicalLoadDynamics consumed")
					);
			subscriber.mechanicalLoadDynamicsSubscribe( mechanicalLoadDynamicsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MechanicalLoadDynamics : " + successValue.getMechanicalLoadDynamicsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMechanicalLoadDynamicsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechanicalLoadDynamics for mechanicalLoadDynamicsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MechanicalLoadDynamics. 
	 */
	protected MechanicalLoadDynamics read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MechanicalLoadDynamics" );

		MechanicalLoadDynamics entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MechanicalLoadDynamics with primary key" );
		msg.append( mechanicalLoadDynamicsId );
		
		MechanicalLoadDynamicsFetchOneSummary fetchOneSummary = new MechanicalLoadDynamicsFetchOneSummary( mechanicalLoadDynamicsId );

		try {
			entity = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().getMechanicalLoadDynamics( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MechanicalLoadDynamics " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MechanicalLoadDynamics.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MechanicalLoadDynamics." );

		StringBuilder msg = new StringBuilder( "Failed to update a MechanicalLoadDynamics : " );        
		MechanicalLoadDynamics entity = read();
		UpdateMechanicalLoadDynamicsCommand command = generateUpdateCommand();
		command.setMechanicalLoadDynamicsId(entity.getMechanicalLoadDynamicsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MechanicalLoadDynamics." );

			// for use later on...
			mechanicalLoadDynamicsId = entity.getMechanicalLoadDynamicsId();

			MechanicalLoadDynamicsBusinessDelegate proxy = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance();  

			proxy.updateMechanicalLoadDynamics( command ).get();

			LOGGER.info( "-- Successfully saved MechanicalLoadDynamics - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + mechanicalLoadDynamicsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MechanicalLoadDynamics.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MechanicalLoadDynamics." );

		MechanicalLoadDynamics entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MechanicalLoadDynamics with id " + mechanicalLoadDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MechanicalLoadDynamics with id " + mechanicalLoadDynamicsId );

			throw e;
		}

		try{
			MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().delete( new DeleteMechanicalLoadDynamicsCommand( entity.getMechanicalLoadDynamicsId() ) ).get();
			LOGGER.info( "-- Successfully deleted MechanicalLoadDynamics with id " + mechanicalLoadDynamicsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MechanicalLoadDynamics with id " + mechanicalLoadDynamicsId );

			throw e;
		}
	}

	/**
	 * get all MechanicalLoadDynamicss.
	 */
	protected List<MechanicalLoadDynamics> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MechanicalLoadDynamicss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MechanicalLoadDynamics : " );        
		List<MechanicalLoadDynamics> collection  = new ArrayList<>();

		try {
			// call the static get method on the MechanicalLoadDynamicsBusinessDelegate
			collection = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().getAllMechanicalLoadDynamics();
			assertNotNull( collection, "An Empty collection of MechanicalLoadDynamics was incorrectly returned.");
			
			// Now print out the values
			MechanicalLoadDynamics entity = null;            
			Iterator<MechanicalLoadDynamics> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMechanicalLoadDynamicsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MechanicalLoadDynamicsTest
	 */
	protected MechanicalLoadDynamicsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MechanicalLoadDynamics
	 * 
	 * @return CreateMechanicalLoadDynamicsCommand alias
	 */
	protected CreateMechanicalLoadDynamicsCommand generateNewCommand() {
        CreateMechanicalLoadDynamicsCommand command = new CreateMechanicalLoadDynamicsCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated MechanicalLoadDynamics
		 * 
		 * @return UpdateMechanicalLoadDynamicsCommand alias
		 */
	protected UpdateMechanicalLoadDynamicsCommand generateUpdateCommand() {
	        UpdateMechanicalLoadDynamicsCommand command = new UpdateMechanicalLoadDynamicsCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID mechanicalLoadDynamicsId = null;
	protected MechanicalLoadDynamicsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MechanicalLoadDynamicsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMechanicalLoadDynamicsList = 0;
}
