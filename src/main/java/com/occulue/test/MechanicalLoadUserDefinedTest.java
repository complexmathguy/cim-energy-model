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
 * Test MechanicalLoadUserDefined class.
 *
 * @author your_name_here
 */
public class MechanicalLoadUserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MechanicalLoadUserDefinedTest() {
		subscriber = new MechanicalLoadUserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MechanicalLoadUserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MechanicalLoadUserDefined...");
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
	 * jumpstart the process by instantiating2 MechanicalLoadUserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		mechanicalLoadUserDefinedId = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance()
		.createMechanicalLoadUserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance()
				.createMechanicalLoadUserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.mechanicalLoadUserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MechanicalLoadUserDefined : " + successValue.getMechanicalLoadUserDefinedId());
							  if (successValue.getMechanicalLoadUserDefinedId().equals(mechanicalLoadUserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMechanicalLoadUserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MechanicalLoadUserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechanicalLoadUserDefined consumed")
					);
			subscriber.mechanicalLoadUserDefinedSubscribe( mechanicalLoadUserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MechanicalLoadUserDefined : " + successValue.getMechanicalLoadUserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMechanicalLoadUserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechanicalLoadUserDefined for mechanicalLoadUserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MechanicalLoadUserDefined. 
	 */
	protected MechanicalLoadUserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MechanicalLoadUserDefined" );

		MechanicalLoadUserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MechanicalLoadUserDefined with primary key" );
		msg.append( mechanicalLoadUserDefinedId );
		
		MechanicalLoadUserDefinedFetchOneSummary fetchOneSummary = new MechanicalLoadUserDefinedFetchOneSummary( mechanicalLoadUserDefinedId );

		try {
			entity = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().getMechanicalLoadUserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MechanicalLoadUserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MechanicalLoadUserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MechanicalLoadUserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a MechanicalLoadUserDefined : " );        
		MechanicalLoadUserDefined entity = read();
		UpdateMechanicalLoadUserDefinedCommand command = generateUpdateCommand();
		command.setMechanicalLoadUserDefinedId(entity.getMechanicalLoadUserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MechanicalLoadUserDefined." );

			// for use later on...
			mechanicalLoadUserDefinedId = entity.getMechanicalLoadUserDefinedId();

			MechanicalLoadUserDefinedBusinessDelegate proxy = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance();  

			proxy.updateMechanicalLoadUserDefined( command ).get();

			LOGGER.info( "-- Successfully saved MechanicalLoadUserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + mechanicalLoadUserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MechanicalLoadUserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MechanicalLoadUserDefined." );

		MechanicalLoadUserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MechanicalLoadUserDefined with id " + mechanicalLoadUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MechanicalLoadUserDefined with id " + mechanicalLoadUserDefinedId );

			throw e;
		}

		try{
			MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().delete( new DeleteMechanicalLoadUserDefinedCommand( entity.getMechanicalLoadUserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted MechanicalLoadUserDefined with id " + mechanicalLoadUserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MechanicalLoadUserDefined with id " + mechanicalLoadUserDefinedId );

			throw e;
		}
	}

	/**
	 * get all MechanicalLoadUserDefineds.
	 */
	protected List<MechanicalLoadUserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MechanicalLoadUserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MechanicalLoadUserDefined : " );        
		List<MechanicalLoadUserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the MechanicalLoadUserDefinedBusinessDelegate
			collection = MechanicalLoadUserDefinedBusinessDelegate.getMechanicalLoadUserDefinedInstance().getAllMechanicalLoadUserDefined();
			assertNotNull( collection, "An Empty collection of MechanicalLoadUserDefined was incorrectly returned.");
			
			// Now print out the values
			MechanicalLoadUserDefined entity = null;            
			Iterator<MechanicalLoadUserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMechanicalLoadUserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MechanicalLoadUserDefinedTest
	 */
	protected MechanicalLoadUserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MechanicalLoadUserDefined
	 * 
	 * @return CreateMechanicalLoadUserDefinedCommand alias
	 */
	protected CreateMechanicalLoadUserDefinedCommand generateNewCommand() {
        CreateMechanicalLoadUserDefinedCommand command = new CreateMechanicalLoadUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated MechanicalLoadUserDefined
		 * 
		 * @return UpdateMechanicalLoadUserDefinedCommand alias
		 */
	protected UpdateMechanicalLoadUserDefinedCommand generateUpdateCommand() {
	        UpdateMechanicalLoadUserDefinedCommand command = new UpdateMechanicalLoadUserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID mechanicalLoadUserDefinedId = null;
	protected MechanicalLoadUserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MechanicalLoadUserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMechanicalLoadUserDefinedList = 0;
}
