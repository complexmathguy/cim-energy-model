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
 * Test SubLoadArea class.
 *
 * @author your_name_here
 */
public class SubLoadAreaTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SubLoadAreaTest() {
		subscriber = new SubLoadAreaSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SubLoadAreaTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SubLoadArea...");
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
	 * jumpstart the process by instantiating2 SubLoadArea
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		subLoadAreaId = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance()
		.createSubLoadArea( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SubLoadAreaBusinessDelegate.getSubLoadAreaInstance()
				.createSubLoadArea( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.subLoadAreaSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SubLoadArea : " + successValue.getSubLoadAreaId());
							  if (successValue.getSubLoadAreaId().equals(subLoadAreaId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSubLoadAreaList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SubLoadArea test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on subLoadArea consumed")
					);
			subscriber.subLoadAreaSubscribe( subLoadAreaId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SubLoadArea : " + successValue.getSubLoadAreaId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSubLoadAreaList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on subLoadArea for subLoadAreaId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SubLoadArea. 
	 */
	protected SubLoadArea read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SubLoadArea" );

		SubLoadArea entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SubLoadArea with primary key" );
		msg.append( subLoadAreaId );
		
		SubLoadAreaFetchOneSummary fetchOneSummary = new SubLoadAreaFetchOneSummary( subLoadAreaId );

		try {
			entity = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().getSubLoadArea( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SubLoadArea " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SubLoadArea.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SubLoadArea." );

		StringBuilder msg = new StringBuilder( "Failed to update a SubLoadArea : " );        
		SubLoadArea entity = read();
		UpdateSubLoadAreaCommand command = generateUpdateCommand();
		command.setSubLoadAreaId(entity.getSubLoadAreaId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SubLoadArea." );

			// for use later on...
			subLoadAreaId = entity.getSubLoadAreaId();

			SubLoadAreaBusinessDelegate proxy = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance();  

			proxy.updateSubLoadArea( command ).get();

			LOGGER.info( "-- Successfully saved SubLoadArea - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + subLoadAreaId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SubLoadArea.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SubLoadArea." );

		SubLoadArea entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SubLoadArea with id " + subLoadAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SubLoadArea with id " + subLoadAreaId );

			throw e;
		}

		try{
			SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().delete( new DeleteSubLoadAreaCommand( entity.getSubLoadAreaId() ) ).get();
			LOGGER.info( "-- Successfully deleted SubLoadArea with id " + subLoadAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SubLoadArea with id " + subLoadAreaId );

			throw e;
		}
	}

	/**
	 * get all SubLoadAreas.
	 */
	protected List<SubLoadArea> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SubLoadAreas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SubLoadArea : " );        
		List<SubLoadArea> collection  = new ArrayList<>();

		try {
			// call the static get method on the SubLoadAreaBusinessDelegate
			collection = SubLoadAreaBusinessDelegate.getSubLoadAreaInstance().getAllSubLoadArea();
			assertNotNull( collection, "An Empty collection of SubLoadArea was incorrectly returned.");
			
			// Now print out the values
			SubLoadArea entity = null;            
			Iterator<SubLoadArea> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSubLoadAreaId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SubLoadAreaTest
	 */
	protected SubLoadAreaTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SubLoadArea
	 * 
	 * @return CreateSubLoadAreaCommand alias
	 */
	protected CreateSubLoadAreaCommand generateNewCommand() {
        CreateSubLoadAreaCommand command = new CreateSubLoadAreaCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated SubLoadArea
		 * 
		 * @return UpdateSubLoadAreaCommand alias
		 */
	protected UpdateSubLoadAreaCommand generateUpdateCommand() {
	        UpdateSubLoadAreaCommand command = new UpdateSubLoadAreaCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID subLoadAreaId = null;
	protected SubLoadAreaSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SubLoadAreaTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSubLoadAreaList = 0;
}
