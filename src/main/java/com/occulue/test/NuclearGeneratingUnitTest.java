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
 * Test NuclearGeneratingUnit class.
 *
 * @author your_name_here
 */
public class NuclearGeneratingUnitTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NuclearGeneratingUnitTest() {
		subscriber = new NuclearGeneratingUnitSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NuclearGeneratingUnitTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NuclearGeneratingUnit...");
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
	 * jumpstart the process by instantiating2 NuclearGeneratingUnit
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nuclearGeneratingUnitId = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance()
		.createNuclearGeneratingUnit( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance()
				.createNuclearGeneratingUnit( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nuclearGeneratingUnitSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NuclearGeneratingUnit : " + successValue.getNuclearGeneratingUnitId());
							  if (successValue.getNuclearGeneratingUnitId().equals(nuclearGeneratingUnitId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNuclearGeneratingUnitList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NuclearGeneratingUnit test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nuclearGeneratingUnit consumed")
					);
			subscriber.nuclearGeneratingUnitSubscribe( nuclearGeneratingUnitId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NuclearGeneratingUnit : " + successValue.getNuclearGeneratingUnitId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNuclearGeneratingUnitList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nuclearGeneratingUnit for nuclearGeneratingUnitId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NuclearGeneratingUnit. 
	 */
	protected NuclearGeneratingUnit read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NuclearGeneratingUnit" );

		NuclearGeneratingUnit entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NuclearGeneratingUnit with primary key" );
		msg.append( nuclearGeneratingUnitId );
		
		NuclearGeneratingUnitFetchOneSummary fetchOneSummary = new NuclearGeneratingUnitFetchOneSummary( nuclearGeneratingUnitId );

		try {
			entity = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance().getNuclearGeneratingUnit( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NuclearGeneratingUnit " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NuclearGeneratingUnit.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NuclearGeneratingUnit." );

		StringBuilder msg = new StringBuilder( "Failed to update a NuclearGeneratingUnit : " );        
		NuclearGeneratingUnit entity = read();
		UpdateNuclearGeneratingUnitCommand command = generateUpdateCommand();
		command.setNuclearGeneratingUnitId(entity.getNuclearGeneratingUnitId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NuclearGeneratingUnit." );

			// for use later on...
			nuclearGeneratingUnitId = entity.getNuclearGeneratingUnitId();

			NuclearGeneratingUnitBusinessDelegate proxy = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance();  

			proxy.updateNuclearGeneratingUnit( command ).get();

			LOGGER.info( "-- Successfully saved NuclearGeneratingUnit - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nuclearGeneratingUnitId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NuclearGeneratingUnit.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NuclearGeneratingUnit." );

		NuclearGeneratingUnit entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NuclearGeneratingUnit with id " + nuclearGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NuclearGeneratingUnit with id " + nuclearGeneratingUnitId );

			throw e;
		}

		try{
			NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance().delete( new DeleteNuclearGeneratingUnitCommand( entity.getNuclearGeneratingUnitId() ) ).get();
			LOGGER.info( "-- Successfully deleted NuclearGeneratingUnit with id " + nuclearGeneratingUnitId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NuclearGeneratingUnit with id " + nuclearGeneratingUnitId );

			throw e;
		}
	}

	/**
	 * get all NuclearGeneratingUnits.
	 */
	protected List<NuclearGeneratingUnit> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NuclearGeneratingUnits:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NuclearGeneratingUnit : " );        
		List<NuclearGeneratingUnit> collection  = new ArrayList<>();

		try {
			// call the static get method on the NuclearGeneratingUnitBusinessDelegate
			collection = NuclearGeneratingUnitBusinessDelegate.getNuclearGeneratingUnitInstance().getAllNuclearGeneratingUnit();
			assertNotNull( collection, "An Empty collection of NuclearGeneratingUnit was incorrectly returned.");
			
			// Now print out the values
			NuclearGeneratingUnit entity = null;            
			Iterator<NuclearGeneratingUnit> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNuclearGeneratingUnitId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NuclearGeneratingUnitTest
	 */
	protected NuclearGeneratingUnitTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NuclearGeneratingUnit
	 * 
	 * @return CreateNuclearGeneratingUnitCommand alias
	 */
	protected CreateNuclearGeneratingUnitCommand generateNewCommand() {
        CreateNuclearGeneratingUnitCommand command = new CreateNuclearGeneratingUnitCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated NuclearGeneratingUnit
		 * 
		 * @return UpdateNuclearGeneratingUnitCommand alias
		 */
	protected UpdateNuclearGeneratingUnitCommand generateUpdateCommand() {
	        UpdateNuclearGeneratingUnitCommand command = new UpdateNuclearGeneratingUnitCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nuclearGeneratingUnitId = null;
	protected NuclearGeneratingUnitSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NuclearGeneratingUnitTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNuclearGeneratingUnitList = 0;
}
