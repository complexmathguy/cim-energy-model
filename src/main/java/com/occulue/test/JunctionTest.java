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
 * Test Junction class.
 *
 * @author your_name_here
 */
public class JunctionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public JunctionTest() {
		subscriber = new JunctionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate JunctionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Junction...");
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
	 * jumpstart the process by instantiating2 Junction
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		junctionId = JunctionBusinessDelegate.getJunctionInstance()
		.createJunction( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		JunctionBusinessDelegate.getJunctionInstance()
				.createJunction( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.junctionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Junction : " + successValue.getJunctionId());
							  if (successValue.getJunctionId().equals(junctionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfJunctionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Junction test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on junction consumed")
					);
			subscriber.junctionSubscribe( junctionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Junction : " + successValue.getJunctionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfJunctionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on junction for junctionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Junction. 
	 */
	protected Junction read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Junction" );

		Junction entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Junction with primary key" );
		msg.append( junctionId );
		
		JunctionFetchOneSummary fetchOneSummary = new JunctionFetchOneSummary( junctionId );

		try {
			entity = JunctionBusinessDelegate.getJunctionInstance().getJunction( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Junction " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Junction.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Junction." );

		StringBuilder msg = new StringBuilder( "Failed to update a Junction : " );        
		Junction entity = read();
		UpdateJunctionCommand command = generateUpdateCommand();
		command.setJunctionId(entity.getJunctionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Junction." );

			// for use later on...
			junctionId = entity.getJunctionId();

			JunctionBusinessDelegate proxy = JunctionBusinessDelegate.getJunctionInstance();  

			proxy.updateJunction( command ).get();

			LOGGER.info( "-- Successfully saved Junction - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + junctionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Junction.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Junction." );

		Junction entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Junction with id " + junctionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Junction with id " + junctionId );

			throw e;
		}

		try{
			JunctionBusinessDelegate.getJunctionInstance().delete( new DeleteJunctionCommand( entity.getJunctionId() ) ).get();
			LOGGER.info( "-- Successfully deleted Junction with id " + junctionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Junction with id " + junctionId );

			throw e;
		}
	}

	/**
	 * get all Junctions.
	 */
	protected List<Junction> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Junctions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Junction : " );        
		List<Junction> collection  = new ArrayList<>();

		try {
			// call the static get method on the JunctionBusinessDelegate
			collection = JunctionBusinessDelegate.getJunctionInstance().getAllJunction();
			assertNotNull( collection, "An Empty collection of Junction was incorrectly returned.");
			
			// Now print out the values
			Junction entity = null;            
			Iterator<Junction> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getJunctionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		JunctionTest
	 */
	protected JunctionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Junction
	 * 
	 * @return CreateJunctionCommand alias
	 */
	protected CreateJunctionCommand generateNewCommand() {
        CreateJunctionCommand command = new CreateJunctionCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Junction
		 * 
		 * @return UpdateJunctionCommand alias
		 */
	protected UpdateJunctionCommand generateUpdateCommand() {
	        UpdateJunctionCommand command = new UpdateJunctionCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID junctionId = null;
	protected JunctionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(JunctionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfJunctionList = 0;
}
