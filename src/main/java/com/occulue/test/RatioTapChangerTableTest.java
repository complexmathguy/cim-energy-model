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
 * Test RatioTapChangerTable class.
 *
 * @author your_name_here
 */
public class RatioTapChangerTableTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RatioTapChangerTableTest() {
		subscriber = new RatioTapChangerTableSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RatioTapChangerTableTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RatioTapChangerTable...");
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
	 * jumpstart the process by instantiating2 RatioTapChangerTable
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		ratioTapChangerTableId = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance()
		.createRatioTapChangerTable( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance()
				.createRatioTapChangerTable( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.ratioTapChangerTableSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RatioTapChangerTable : " + successValue.getRatioTapChangerTableId());
							  if (successValue.getRatioTapChangerTableId().equals(ratioTapChangerTableId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRatioTapChangerTableList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RatioTapChangerTable test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChangerTable consumed")
					);
			subscriber.ratioTapChangerTableSubscribe( ratioTapChangerTableId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RatioTapChangerTable : " + successValue.getRatioTapChangerTableId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRatioTapChangerTableList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on ratioTapChangerTable for ratioTapChangerTableId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RatioTapChangerTable. 
	 */
	protected RatioTapChangerTable read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RatioTapChangerTable" );

		RatioTapChangerTable entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RatioTapChangerTable with primary key" );
		msg.append( ratioTapChangerTableId );
		
		RatioTapChangerTableFetchOneSummary fetchOneSummary = new RatioTapChangerTableFetchOneSummary( ratioTapChangerTableId );

		try {
			entity = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().getRatioTapChangerTable( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RatioTapChangerTable " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RatioTapChangerTable.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RatioTapChangerTable." );

		StringBuilder msg = new StringBuilder( "Failed to update a RatioTapChangerTable : " );        
		RatioTapChangerTable entity = read();
		UpdateRatioTapChangerTableCommand command = generateUpdateCommand();
		command.setRatioTapChangerTableId(entity.getRatioTapChangerTableId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RatioTapChangerTable." );

			// for use later on...
			ratioTapChangerTableId = entity.getRatioTapChangerTableId();

			RatioTapChangerTableBusinessDelegate proxy = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance();  

			proxy.updateRatioTapChangerTable( command ).get();

			LOGGER.info( "-- Successfully saved RatioTapChangerTable - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + ratioTapChangerTableId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RatioTapChangerTable.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RatioTapChangerTable." );

		RatioTapChangerTable entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RatioTapChangerTable with id " + ratioTapChangerTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RatioTapChangerTable with id " + ratioTapChangerTableId );

			throw e;
		}

		try{
			RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().delete( new DeleteRatioTapChangerTableCommand( entity.getRatioTapChangerTableId() ) ).get();
			LOGGER.info( "-- Successfully deleted RatioTapChangerTable with id " + ratioTapChangerTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RatioTapChangerTable with id " + ratioTapChangerTableId );

			throw e;
		}
	}

	/**
	 * get all RatioTapChangerTables.
	 */
	protected List<RatioTapChangerTable> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RatioTapChangerTables:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RatioTapChangerTable : " );        
		List<RatioTapChangerTable> collection  = new ArrayList<>();

		try {
			// call the static get method on the RatioTapChangerTableBusinessDelegate
			collection = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().getAllRatioTapChangerTable();
			assertNotNull( collection, "An Empty collection of RatioTapChangerTable was incorrectly returned.");
			
			// Now print out the values
			RatioTapChangerTable entity = null;            
			Iterator<RatioTapChangerTable> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRatioTapChangerTableId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RatioTapChangerTableTest
	 */
	protected RatioTapChangerTableTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RatioTapChangerTable
	 * 
	 * @return CreateRatioTapChangerTableCommand alias
	 */
	protected CreateRatioTapChangerTableCommand generateNewCommand() {
        CreateRatioTapChangerTableCommand command = new CreateRatioTapChangerTableCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated RatioTapChangerTable
		 * 
		 * @return UpdateRatioTapChangerTableCommand alias
		 */
	protected UpdateRatioTapChangerTableCommand generateUpdateCommand() {
	        UpdateRatioTapChangerTableCommand command = new UpdateRatioTapChangerTableCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID ratioTapChangerTableId = null;
	protected RatioTapChangerTableSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RatioTapChangerTableTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRatioTapChangerTableList = 0;
}
