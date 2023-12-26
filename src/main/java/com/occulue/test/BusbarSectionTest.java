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
 * Test BusbarSection class.
 *
 * @author your_name_here
 */
public class BusbarSectionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BusbarSectionTest() {
		subscriber = new BusbarSectionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BusbarSectionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BusbarSection...");
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
	 * jumpstart the process by instantiating2 BusbarSection
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		busbarSectionId = BusbarSectionBusinessDelegate.getBusbarSectionInstance()
		.createBusbarSection( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BusbarSectionBusinessDelegate.getBusbarSectionInstance()
				.createBusbarSection( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.busbarSectionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BusbarSection : " + successValue.getBusbarSectionId());
							  if (successValue.getBusbarSectionId().equals(busbarSectionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBusbarSectionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BusbarSection test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on busbarSection consumed")
					);
			subscriber.busbarSectionSubscribe( busbarSectionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BusbarSection : " + successValue.getBusbarSectionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBusbarSectionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on busbarSection for busbarSectionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BusbarSection. 
	 */
	protected BusbarSection read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BusbarSection" );

		BusbarSection entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BusbarSection with primary key" );
		msg.append( busbarSectionId );
		
		BusbarSectionFetchOneSummary fetchOneSummary = new BusbarSectionFetchOneSummary( busbarSectionId );

		try {
			entity = BusbarSectionBusinessDelegate.getBusbarSectionInstance().getBusbarSection( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BusbarSection " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BusbarSection.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BusbarSection." );

		StringBuilder msg = new StringBuilder( "Failed to update a BusbarSection : " );        
		BusbarSection entity = read();
		UpdateBusbarSectionCommand command = generateUpdateCommand();
		command.setBusbarSectionId(entity.getBusbarSectionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BusbarSection." );

			// for use later on...
			busbarSectionId = entity.getBusbarSectionId();

			BusbarSectionBusinessDelegate proxy = BusbarSectionBusinessDelegate.getBusbarSectionInstance();  

			proxy.updateBusbarSection( command ).get();

			LOGGER.info( "-- Successfully saved BusbarSection - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + busbarSectionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BusbarSection.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BusbarSection." );

		BusbarSection entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BusbarSection with id " + busbarSectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BusbarSection with id " + busbarSectionId );

			throw e;
		}

		try{
			BusbarSectionBusinessDelegate.getBusbarSectionInstance().delete( new DeleteBusbarSectionCommand( entity.getBusbarSectionId() ) ).get();
			LOGGER.info( "-- Successfully deleted BusbarSection with id " + busbarSectionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BusbarSection with id " + busbarSectionId );

			throw e;
		}
	}

	/**
	 * get all BusbarSections.
	 */
	protected List<BusbarSection> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BusbarSections:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BusbarSection : " );        
		List<BusbarSection> collection  = new ArrayList<>();

		try {
			// call the static get method on the BusbarSectionBusinessDelegate
			collection = BusbarSectionBusinessDelegate.getBusbarSectionInstance().getAllBusbarSection();
			assertNotNull( collection, "An Empty collection of BusbarSection was incorrectly returned.");
			
			// Now print out the values
			BusbarSection entity = null;            
			Iterator<BusbarSection> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBusbarSectionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BusbarSectionTest
	 */
	protected BusbarSectionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BusbarSection
	 * 
	 * @return CreateBusbarSectionCommand alias
	 */
	protected CreateBusbarSectionCommand generateNewCommand() {
        CreateBusbarSectionCommand command = new CreateBusbarSectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated BusbarSection
		 * 
		 * @return UpdateBusbarSectionCommand alias
		 */
	protected UpdateBusbarSectionCommand generateUpdateCommand() {
	        UpdateBusbarSectionCommand command = new UpdateBusbarSectionCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID busbarSectionId = null;
	protected BusbarSectionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BusbarSectionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBusbarSectionList = 0;
}
