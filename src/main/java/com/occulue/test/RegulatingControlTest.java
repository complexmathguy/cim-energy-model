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
 * Test RegulatingControl class.
 *
 * @author your_name_here
 */
public class RegulatingControlTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RegulatingControlTest() {
		subscriber = new RegulatingControlSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RegulatingControlTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RegulatingControl...");
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
	 * jumpstart the process by instantiating2 RegulatingControl
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		regulatingControlId = RegulatingControlBusinessDelegate.getRegulatingControlInstance()
		.createRegulatingControl( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RegulatingControlBusinessDelegate.getRegulatingControlInstance()
				.createRegulatingControl( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.regulatingControlSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RegulatingControl : " + successValue.getRegulatingControlId());
							  if (successValue.getRegulatingControlId().equals(regulatingControlId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRegulatingControlList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RegulatingControl test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulatingControl consumed")
					);
			subscriber.regulatingControlSubscribe( regulatingControlId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RegulatingControl : " + successValue.getRegulatingControlId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRegulatingControlList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulatingControl for regulatingControlId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RegulatingControl. 
	 */
	protected RegulatingControl read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RegulatingControl" );

		RegulatingControl entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RegulatingControl with primary key" );
		msg.append( regulatingControlId );
		
		RegulatingControlFetchOneSummary fetchOneSummary = new RegulatingControlFetchOneSummary( regulatingControlId );

		try {
			entity = RegulatingControlBusinessDelegate.getRegulatingControlInstance().getRegulatingControl( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RegulatingControl " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RegulatingControl.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RegulatingControl." );

		StringBuilder msg = new StringBuilder( "Failed to update a RegulatingControl : " );        
		RegulatingControl entity = read();
		UpdateRegulatingControlCommand command = generateUpdateCommand();
		command.setRegulatingControlId(entity.getRegulatingControlId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RegulatingControl." );

			// for use later on...
			regulatingControlId = entity.getRegulatingControlId();

			RegulatingControlBusinessDelegate proxy = RegulatingControlBusinessDelegate.getRegulatingControlInstance();  

			proxy.updateRegulatingControl( command ).get();

			LOGGER.info( "-- Successfully saved RegulatingControl - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + regulatingControlId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RegulatingControl.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RegulatingControl." );

		RegulatingControl entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RegulatingControl with id " + regulatingControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RegulatingControl with id " + regulatingControlId );

			throw e;
		}

		try{
			RegulatingControlBusinessDelegate.getRegulatingControlInstance().delete( new DeleteRegulatingControlCommand( entity.getRegulatingControlId() ) ).get();
			LOGGER.info( "-- Successfully deleted RegulatingControl with id " + regulatingControlId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RegulatingControl with id " + regulatingControlId );

			throw e;
		}
	}

	/**
	 * get all RegulatingControls.
	 */
	protected List<RegulatingControl> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RegulatingControls:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RegulatingControl : " );        
		List<RegulatingControl> collection  = new ArrayList<>();

		try {
			// call the static get method on the RegulatingControlBusinessDelegate
			collection = RegulatingControlBusinessDelegate.getRegulatingControlInstance().getAllRegulatingControl();
			assertNotNull( collection, "An Empty collection of RegulatingControl was incorrectly returned.");
			
			// Now print out the values
			RegulatingControl entity = null;            
			Iterator<RegulatingControl> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRegulatingControlId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RegulatingControlTest
	 */
	protected RegulatingControlTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RegulatingControl
	 * 
	 * @return CreateRegulatingControlCommand alias
	 */
	protected CreateRegulatingControlCommand generateNewCommand() {
        CreateRegulatingControlCommand command = new CreateRegulatingControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated RegulatingControl
		 * 
		 * @return UpdateRegulatingControlCommand alias
		 */
	protected UpdateRegulatingControlCommand generateUpdateCommand() {
	        UpdateRegulatingControlCommand command = new UpdateRegulatingControlCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID regulatingControlId = null;
	protected RegulatingControlSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RegulatingControlTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRegulatingControlList = 0;
}
