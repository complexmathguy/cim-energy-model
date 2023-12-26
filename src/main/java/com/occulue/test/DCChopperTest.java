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
 * Test DCChopper class.
 *
 * @author your_name_here
 */
public class DCChopperTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCChopperTest() {
		subscriber = new DCChopperSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCChopperTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCChopper...");
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
	 * jumpstart the process by instantiating2 DCChopper
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCChopperId = DCChopperBusinessDelegate.getDCChopperInstance()
		.createDCChopper( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCChopperBusinessDelegate.getDCChopperInstance()
				.createDCChopper( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCChopperSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCChopper : " + successValue.getDCChopperId());
							  if (successValue.getDCChopperId().equals(dCChopperId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCChopperList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCChopper test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCChopper consumed")
					);
			subscriber.dCChopperSubscribe( dCChopperId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCChopper : " + successValue.getDCChopperId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCChopperList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCChopper for dCChopperId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCChopper. 
	 */
	protected DCChopper read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCChopper" );

		DCChopper entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCChopper with primary key" );
		msg.append( dCChopperId );
		
		DCChopperFetchOneSummary fetchOneSummary = new DCChopperFetchOneSummary( dCChopperId );

		try {
			entity = DCChopperBusinessDelegate.getDCChopperInstance().getDCChopper( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCChopper " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCChopper.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCChopper." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCChopper : " );        
		DCChopper entity = read();
		UpdateDCChopperCommand command = generateUpdateCommand();
		command.setDCChopperId(entity.getDCChopperId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCChopper." );

			// for use later on...
			dCChopperId = entity.getDCChopperId();

			DCChopperBusinessDelegate proxy = DCChopperBusinessDelegate.getDCChopperInstance();  

			proxy.updateDCChopper( command ).get();

			LOGGER.info( "-- Successfully saved DCChopper - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCChopperId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCChopper.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCChopper." );

		DCChopper entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCChopper with id " + dCChopperId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCChopper with id " + dCChopperId );

			throw e;
		}

		try{
			DCChopperBusinessDelegate.getDCChopperInstance().delete( new DeleteDCChopperCommand( entity.getDCChopperId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCChopper with id " + dCChopperId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCChopper with id " + dCChopperId );

			throw e;
		}
	}

	/**
	 * get all DCChoppers.
	 */
	protected List<DCChopper> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCChoppers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCChopper : " );        
		List<DCChopper> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCChopperBusinessDelegate
			collection = DCChopperBusinessDelegate.getDCChopperInstance().getAllDCChopper();
			assertNotNull( collection, "An Empty collection of DCChopper was incorrectly returned.");
			
			// Now print out the values
			DCChopper entity = null;            
			Iterator<DCChopper> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCChopperId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCChopperTest
	 */
	protected DCChopperTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCChopper
	 * 
	 * @return CreateDCChopperCommand alias
	 */
	protected CreateDCChopperCommand generateNewCommand() {
        CreateDCChopperCommand command = new CreateDCChopperCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCChopper
		 * 
		 * @return UpdateDCChopperCommand alias
		 */
	protected UpdateDCChopperCommand generateUpdateCommand() {
	        UpdateDCChopperCommand command = new UpdateDCChopperCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCChopperId = null;
	protected DCChopperSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCChopperTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCChopperList = 0;
}
