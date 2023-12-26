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
 * Test Substation class.
 *
 * @author your_name_here
 */
public class SubstationTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SubstationTest() {
		subscriber = new SubstationSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SubstationTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Substation...");
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
	 * jumpstart the process by instantiating2 Substation
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		substationId = SubstationBusinessDelegate.getSubstationInstance()
		.createSubstation( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SubstationBusinessDelegate.getSubstationInstance()
				.createSubstation( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.substationSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Substation : " + successValue.getSubstationId());
							  if (successValue.getSubstationId().equals(substationId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSubstationList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Substation test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on substation consumed")
					);
			subscriber.substationSubscribe( substationId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Substation : " + successValue.getSubstationId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSubstationList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on substation for substationId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Substation. 
	 */
	protected Substation read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Substation" );

		Substation entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Substation with primary key" );
		msg.append( substationId );
		
		SubstationFetchOneSummary fetchOneSummary = new SubstationFetchOneSummary( substationId );

		try {
			entity = SubstationBusinessDelegate.getSubstationInstance().getSubstation( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Substation " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Substation.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Substation." );

		StringBuilder msg = new StringBuilder( "Failed to update a Substation : " );        
		Substation entity = read();
		UpdateSubstationCommand command = generateUpdateCommand();
		command.setSubstationId(entity.getSubstationId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Substation." );

			// for use later on...
			substationId = entity.getSubstationId();

			SubstationBusinessDelegate proxy = SubstationBusinessDelegate.getSubstationInstance();  

			proxy.updateSubstation( command ).get();

			LOGGER.info( "-- Successfully saved Substation - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + substationId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Substation.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Substation." );

		Substation entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Substation with id " + substationId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Substation with id " + substationId );

			throw e;
		}

		try{
			SubstationBusinessDelegate.getSubstationInstance().delete( new DeleteSubstationCommand( entity.getSubstationId() ) ).get();
			LOGGER.info( "-- Successfully deleted Substation with id " + substationId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Substation with id " + substationId );

			throw e;
		}
	}

	/**
	 * get all Substations.
	 */
	protected List<Substation> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Substations:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Substation : " );        
		List<Substation> collection  = new ArrayList<>();

		try {
			// call the static get method on the SubstationBusinessDelegate
			collection = SubstationBusinessDelegate.getSubstationInstance().getAllSubstation();
			assertNotNull( collection, "An Empty collection of Substation was incorrectly returned.");
			
			// Now print out the values
			Substation entity = null;            
			Iterator<Substation> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSubstationId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SubstationTest
	 */
	protected SubstationTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Substation
	 * 
	 * @return CreateSubstationCommand alias
	 */
	protected CreateSubstationCommand generateNewCommand() {
        CreateSubstationCommand command = new CreateSubstationCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Substation
		 * 
		 * @return UpdateSubstationCommand alias
		 */
	protected UpdateSubstationCommand generateUpdateCommand() {
	        UpdateSubstationCommand command = new UpdateSubstationCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID substationId = null;
	protected SubstationSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SubstationTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSubstationList = 0;
}
