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
 * Test ENTSOEJunction class.
 *
 * @author your_name_here
 */
public class ENTSOEJunctionTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ENTSOEJunctionTest() {
		subscriber = new ENTSOEJunctionSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ENTSOEJunctionTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ENTSOEJunction...");
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
	 * jumpstart the process by instantiating2 ENTSOEJunction
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		eNTSOEJunctionId = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance()
		.createENTSOEJunction( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance()
				.createENTSOEJunction( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.eNTSOEJunctionSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ENTSOEJunction : " + successValue.getENTSOEJunctionId());
							  if (successValue.getENTSOEJunctionId().equals(eNTSOEJunctionId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfENTSOEJunctionList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ENTSOEJunction test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEJunction consumed")
					);
			subscriber.eNTSOEJunctionSubscribe( eNTSOEJunctionId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ENTSOEJunction : " + successValue.getENTSOEJunctionId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfENTSOEJunctionList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEJunction for eNTSOEJunctionId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ENTSOEJunction. 
	 */
	protected ENTSOEJunction read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ENTSOEJunction" );

		ENTSOEJunction entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ENTSOEJunction with primary key" );
		msg.append( eNTSOEJunctionId );
		
		ENTSOEJunctionFetchOneSummary fetchOneSummary = new ENTSOEJunctionFetchOneSummary( eNTSOEJunctionId );

		try {
			entity = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().getENTSOEJunction( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ENTSOEJunction " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ENTSOEJunction.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ENTSOEJunction." );

		StringBuilder msg = new StringBuilder( "Failed to update a ENTSOEJunction : " );        
		ENTSOEJunction entity = read();
		UpdateENTSOEJunctionCommand command = generateUpdateCommand();
		command.setENTSOEJunctionId(entity.getENTSOEJunctionId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ENTSOEJunction." );

			// for use later on...
			eNTSOEJunctionId = entity.getENTSOEJunctionId();

			ENTSOEJunctionBusinessDelegate proxy = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance();  

			proxy.updateENTSOEJunction( command ).get();

			LOGGER.info( "-- Successfully saved ENTSOEJunction - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + eNTSOEJunctionId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ENTSOEJunction.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ENTSOEJunction." );

		ENTSOEJunction entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ENTSOEJunction with id " + eNTSOEJunctionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ENTSOEJunction with id " + eNTSOEJunctionId );

			throw e;
		}

		try{
			ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().delete( new DeleteENTSOEJunctionCommand( entity.getENTSOEJunctionId() ) ).get();
			LOGGER.info( "-- Successfully deleted ENTSOEJunction with id " + eNTSOEJunctionId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ENTSOEJunction with id " + eNTSOEJunctionId );

			throw e;
		}
	}

	/**
	 * get all ENTSOEJunctions.
	 */
	protected List<ENTSOEJunction> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ENTSOEJunctions:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ENTSOEJunction : " );        
		List<ENTSOEJunction> collection  = new ArrayList<>();

		try {
			// call the static get method on the ENTSOEJunctionBusinessDelegate
			collection = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().getAllENTSOEJunction();
			assertNotNull( collection, "An Empty collection of ENTSOEJunction was incorrectly returned.");
			
			// Now print out the values
			ENTSOEJunction entity = null;            
			Iterator<ENTSOEJunction> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getENTSOEJunctionId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ENTSOEJunctionTest
	 */
	protected ENTSOEJunctionTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ENTSOEJunction
	 * 
	 * @return CreateENTSOEJunctionCommand alias
	 */
	protected CreateENTSOEJunctionCommand generateNewCommand() {
        CreateENTSOEJunctionCommand command = new CreateENTSOEJunctionCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ENTSOEJunction
		 * 
		 * @return UpdateENTSOEJunctionCommand alias
		 */
	protected UpdateENTSOEJunctionCommand generateUpdateCommand() {
	        UpdateENTSOEJunctionCommand command = new UpdateENTSOEJunctionCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID eNTSOEJunctionId = null;
	protected ENTSOEJunctionSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ENTSOEJunctionTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfENTSOEJunctionList = 0;
}
