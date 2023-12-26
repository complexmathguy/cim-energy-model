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
 * Test ControlArea class.
 *
 * @author your_name_here
 */
public class ControlAreaTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ControlAreaTest() {
		subscriber = new ControlAreaSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ControlAreaTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ControlArea...");
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
	 * jumpstart the process by instantiating2 ControlArea
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		controlAreaId = ControlAreaBusinessDelegate.getControlAreaInstance()
		.createControlArea( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ControlAreaBusinessDelegate.getControlAreaInstance()
				.createControlArea( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.controlAreaSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ControlArea : " + successValue.getControlAreaId());
							  if (successValue.getControlAreaId().equals(controlAreaId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfControlAreaList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ControlArea test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on controlArea consumed")
					);
			subscriber.controlAreaSubscribe( controlAreaId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ControlArea : " + successValue.getControlAreaId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfControlAreaList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on controlArea for controlAreaId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ControlArea. 
	 */
	protected ControlArea read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ControlArea" );

		ControlArea entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ControlArea with primary key" );
		msg.append( controlAreaId );
		
		ControlAreaFetchOneSummary fetchOneSummary = new ControlAreaFetchOneSummary( controlAreaId );

		try {
			entity = ControlAreaBusinessDelegate.getControlAreaInstance().getControlArea( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ControlArea " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ControlArea.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ControlArea." );

		StringBuilder msg = new StringBuilder( "Failed to update a ControlArea : " );        
		ControlArea entity = read();
		UpdateControlAreaCommand command = generateUpdateCommand();
		command.setControlAreaId(entity.getControlAreaId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ControlArea." );

			// for use later on...
			controlAreaId = entity.getControlAreaId();

			ControlAreaBusinessDelegate proxy = ControlAreaBusinessDelegate.getControlAreaInstance();  

			proxy.updateControlArea( command ).get();

			LOGGER.info( "-- Successfully saved ControlArea - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + controlAreaId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ControlArea.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ControlArea." );

		ControlArea entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ControlArea with id " + controlAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ControlArea with id " + controlAreaId );

			throw e;
		}

		try{
			ControlAreaBusinessDelegate.getControlAreaInstance().delete( new DeleteControlAreaCommand( entity.getControlAreaId() ) ).get();
			LOGGER.info( "-- Successfully deleted ControlArea with id " + controlAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ControlArea with id " + controlAreaId );

			throw e;
		}
	}

	/**
	 * get all ControlAreas.
	 */
	protected List<ControlArea> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ControlAreas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ControlArea : " );        
		List<ControlArea> collection  = new ArrayList<>();

		try {
			// call the static get method on the ControlAreaBusinessDelegate
			collection = ControlAreaBusinessDelegate.getControlAreaInstance().getAllControlArea();
			assertNotNull( collection, "An Empty collection of ControlArea was incorrectly returned.");
			
			// Now print out the values
			ControlArea entity = null;            
			Iterator<ControlArea> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getControlAreaId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ControlAreaTest
	 */
	protected ControlAreaTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ControlArea
	 * 
	 * @return CreateControlAreaCommand alias
	 */
	protected CreateControlAreaCommand generateNewCommand() {
        CreateControlAreaCommand command = new CreateControlAreaCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ControlArea
		 * 
		 * @return UpdateControlAreaCommand alias
		 */
	protected UpdateControlAreaCommand generateUpdateCommand() {
	        UpdateControlAreaCommand command = new UpdateControlAreaCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID controlAreaId = null;
	protected ControlAreaSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ControlAreaTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfControlAreaList = 0;
}
