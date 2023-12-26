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
 * Test Bay class.
 *
 * @author your_name_here
 */
public class BayTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BayTest() {
		subscriber = new BaySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BayTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Bay...");
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
	 * jumpstart the process by instantiating2 Bay
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		bayId = BayBusinessDelegate.getBayInstance()
		.createBay( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BayBusinessDelegate.getBayInstance()
				.createBay( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.baySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Bay : " + successValue.getBayId());
							  if (successValue.getBayId().equals(bayId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBayList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Bay test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on bay consumed")
					);
			subscriber.baySubscribe( bayId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Bay : " + successValue.getBayId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBayList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on bay for bayId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Bay. 
	 */
	protected Bay read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Bay" );

		Bay entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Bay with primary key" );
		msg.append( bayId );
		
		BayFetchOneSummary fetchOneSummary = new BayFetchOneSummary( bayId );

		try {
			entity = BayBusinessDelegate.getBayInstance().getBay( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Bay " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Bay.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Bay." );

		StringBuilder msg = new StringBuilder( "Failed to update a Bay : " );        
		Bay entity = read();
		UpdateBayCommand command = generateUpdateCommand();
		command.setBayId(entity.getBayId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Bay." );

			// for use later on...
			bayId = entity.getBayId();

			BayBusinessDelegate proxy = BayBusinessDelegate.getBayInstance();  

			proxy.updateBay( command ).get();

			LOGGER.info( "-- Successfully saved Bay - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + bayId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Bay.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Bay." );

		Bay entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Bay with id " + bayId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Bay with id " + bayId );

			throw e;
		}

		try{
			BayBusinessDelegate.getBayInstance().delete( new DeleteBayCommand( entity.getBayId() ) ).get();
			LOGGER.info( "-- Successfully deleted Bay with id " + bayId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Bay with id " + bayId );

			throw e;
		}
	}

	/**
	 * get all Bays.
	 */
	protected List<Bay> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Bays:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Bay : " );        
		List<Bay> collection  = new ArrayList<>();

		try {
			// call the static get method on the BayBusinessDelegate
			collection = BayBusinessDelegate.getBayInstance().getAllBay();
			assertNotNull( collection, "An Empty collection of Bay was incorrectly returned.");
			
			// Now print out the values
			Bay entity = null;            
			Iterator<Bay> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBayId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BayTest
	 */
	protected BayTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Bay
	 * 
	 * @return CreateBayCommand alias
	 */
	protected CreateBayCommand generateNewCommand() {
        CreateBayCommand command = new CreateBayCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Bay
		 * 
		 * @return UpdateBayCommand alias
		 */
	protected UpdateBayCommand generateUpdateCommand() {
	        UpdateBayCommand command = new UpdateBayCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID bayId = null;
	protected BaySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BayTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBayList = 0;
}
