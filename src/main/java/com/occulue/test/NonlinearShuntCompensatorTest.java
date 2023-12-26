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
 * Test NonlinearShuntCompensator class.
 *
 * @author your_name_here
 */
public class NonlinearShuntCompensatorTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public NonlinearShuntCompensatorTest() {
		subscriber = new NonlinearShuntCompensatorSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate NonlinearShuntCompensatorTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on NonlinearShuntCompensator...");
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
	 * jumpstart the process by instantiating2 NonlinearShuntCompensator
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		nonlinearShuntCompensatorId = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance()
		.createNonlinearShuntCompensator( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance()
				.createNonlinearShuntCompensator( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.nonlinearShuntCompensatorSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for NonlinearShuntCompensator : " + successValue.getNonlinearShuntCompensatorId());
							  if (successValue.getNonlinearShuntCompensatorId().equals(nonlinearShuntCompensatorId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfNonlinearShuntCompensatorList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("NonlinearShuntCompensator test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonlinearShuntCompensator consumed")
					);
			subscriber.nonlinearShuntCompensatorSubscribe( nonlinearShuntCompensatorId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for NonlinearShuntCompensator : " + successValue.getNonlinearShuntCompensatorId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfNonlinearShuntCompensatorList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on nonlinearShuntCompensator for nonlinearShuntCompensatorId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a NonlinearShuntCompensator. 
	 */
	protected NonlinearShuntCompensator read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created NonlinearShuntCompensator" );

		NonlinearShuntCompensator entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read NonlinearShuntCompensator with primary key" );
		msg.append( nonlinearShuntCompensatorId );
		
		NonlinearShuntCompensatorFetchOneSummary fetchOneSummary = new NonlinearShuntCompensatorFetchOneSummary( nonlinearShuntCompensatorId );

		try {
			entity = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().getNonlinearShuntCompensator( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found NonlinearShuntCompensator " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a NonlinearShuntCompensator.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a NonlinearShuntCompensator." );

		StringBuilder msg = new StringBuilder( "Failed to update a NonlinearShuntCompensator : " );        
		NonlinearShuntCompensator entity = read();
		UpdateNonlinearShuntCompensatorCommand command = generateUpdateCommand();
		command.setNonlinearShuntCompensatorId(entity.getNonlinearShuntCompensatorId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created NonlinearShuntCompensator." );

			// for use later on...
			nonlinearShuntCompensatorId = entity.getNonlinearShuntCompensatorId();

			NonlinearShuntCompensatorBusinessDelegate proxy = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance();  

			proxy.updateNonlinearShuntCompensator( command ).get();

			LOGGER.info( "-- Successfully saved NonlinearShuntCompensator - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + nonlinearShuntCompensatorId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a NonlinearShuntCompensator.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created NonlinearShuntCompensator." );

		NonlinearShuntCompensator entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read NonlinearShuntCompensator with id " + nonlinearShuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read NonlinearShuntCompensator with id " + nonlinearShuntCompensatorId );

			throw e;
		}

		try{
			NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().delete( new DeleteNonlinearShuntCompensatorCommand( entity.getNonlinearShuntCompensatorId() ) ).get();
			LOGGER.info( "-- Successfully deleted NonlinearShuntCompensator with id " + nonlinearShuntCompensatorId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete NonlinearShuntCompensator with id " + nonlinearShuntCompensatorId );

			throw e;
		}
	}

	/**
	 * get all NonlinearShuntCompensators.
	 */
	protected List<NonlinearShuntCompensator> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of NonlinearShuntCompensators:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all NonlinearShuntCompensator : " );        
		List<NonlinearShuntCompensator> collection  = new ArrayList<>();

		try {
			// call the static get method on the NonlinearShuntCompensatorBusinessDelegate
			collection = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().getAllNonlinearShuntCompensator();
			assertNotNull( collection, "An Empty collection of NonlinearShuntCompensator was incorrectly returned.");
			
			// Now print out the values
			NonlinearShuntCompensator entity = null;            
			Iterator<NonlinearShuntCompensator> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getNonlinearShuntCompensatorId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		NonlinearShuntCompensatorTest
	 */
	protected NonlinearShuntCompensatorTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated NonlinearShuntCompensator
	 * 
	 * @return CreateNonlinearShuntCompensatorCommand alias
	 */
	protected CreateNonlinearShuntCompensatorCommand generateNewCommand() {
        CreateNonlinearShuntCompensatorCommand command = new CreateNonlinearShuntCompensatorCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated NonlinearShuntCompensator
		 * 
		 * @return UpdateNonlinearShuntCompensatorCommand alias
		 */
	protected UpdateNonlinearShuntCompensatorCommand generateUpdateCommand() {
	        UpdateNonlinearShuntCompensatorCommand command = new UpdateNonlinearShuntCompensatorCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID nonlinearShuntCompensatorId = null;
	protected NonlinearShuntCompensatorSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(NonlinearShuntCompensatorTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfNonlinearShuntCompensatorList = 0;
}
