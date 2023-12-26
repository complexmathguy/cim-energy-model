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
 * Test SubGeographicalRegion class.
 *
 * @author your_name_here
 */
public class SubGeographicalRegionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SubGeographicalRegionTest() {
		subscriber = new SubGeographicalRegionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SubGeographicalRegionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SubGeographicalRegion...");
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
	 * jumpstart the process by instantiating2 SubGeographicalRegion
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		subGeographicalRegionId = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
		.createSubGeographicalRegion( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
				.createSubGeographicalRegion( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.subGeographicalRegionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SubGeographicalRegion : " + successValue.getSubGeographicalRegionId());
							  if (successValue.getSubGeographicalRegionId().equals(subGeographicalRegionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSubGeographicalRegionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SubGeographicalRegion test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on subGeographicalRegion consumed")
					);
			subscriber.subGeographicalRegionSubscribe( subGeographicalRegionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SubGeographicalRegion : " + successValue.getSubGeographicalRegionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSubGeographicalRegionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on subGeographicalRegion for subGeographicalRegionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SubGeographicalRegion. 
	 */
	protected SubGeographicalRegion read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SubGeographicalRegion" );

		SubGeographicalRegion entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SubGeographicalRegion with primary key" );
		msg.append( subGeographicalRegionId );
		
		SubGeographicalRegionFetchOneSummary fetchOneSummary = new SubGeographicalRegionFetchOneSummary( subGeographicalRegionId );

		try {
			entity = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().getSubGeographicalRegion( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SubGeographicalRegion " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SubGeographicalRegion.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SubGeographicalRegion." );

		StringBuilder msg = new StringBuilder( "Failed to update a SubGeographicalRegion : " );        
		SubGeographicalRegion entity = read();
		UpdateSubGeographicalRegionCommand command = generateUpdateCommand();
		command.setSubGeographicalRegionId(entity.getSubGeographicalRegionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SubGeographicalRegion." );

			// for use later on...
			subGeographicalRegionId = entity.getSubGeographicalRegionId();

			SubGeographicalRegionBusinessDelegate proxy = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance();  

			proxy.updateSubGeographicalRegion( command ).get();

			LOGGER.info( "-- Successfully saved SubGeographicalRegion - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + subGeographicalRegionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SubGeographicalRegion.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SubGeographicalRegion." );

		SubGeographicalRegion entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SubGeographicalRegion with id " + subGeographicalRegionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SubGeographicalRegion with id " + subGeographicalRegionId );

			throw e;
		}

		try{
			SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().delete( new DeleteSubGeographicalRegionCommand( entity.getSubGeographicalRegionId() ) ).get();
			LOGGER.info( "-- Successfully deleted SubGeographicalRegion with id " + subGeographicalRegionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SubGeographicalRegion with id " + subGeographicalRegionId );

			throw e;
		}
	}

	/**
	 * get all SubGeographicalRegions.
	 */
	protected List<SubGeographicalRegion> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SubGeographicalRegions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SubGeographicalRegion : " );        
		List<SubGeographicalRegion> collection  = new ArrayList<>();

		try {
			// call the static get method on the SubGeographicalRegionBusinessDelegate
			collection = SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance().getAllSubGeographicalRegion();
			assertNotNull( collection, "An Empty collection of SubGeographicalRegion was incorrectly returned.");
			
			// Now print out the values
			SubGeographicalRegion entity = null;            
			Iterator<SubGeographicalRegion> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSubGeographicalRegionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SubGeographicalRegionTest
	 */
	protected SubGeographicalRegionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SubGeographicalRegion
	 * 
	 * @return CreateSubGeographicalRegionCommand alias
	 */
	protected CreateSubGeographicalRegionCommand generateNewCommand() {
        CreateSubGeographicalRegionCommand command = new CreateSubGeographicalRegionCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SubGeographicalRegion
		 * 
		 * @return UpdateSubGeographicalRegionCommand alias
		 */
	protected UpdateSubGeographicalRegionCommand generateUpdateCommand() {
	        UpdateSubGeographicalRegionCommand command = new UpdateSubGeographicalRegionCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID subGeographicalRegionId = null;
	protected SubGeographicalRegionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SubGeographicalRegionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSubGeographicalRegionList = 0;
}
