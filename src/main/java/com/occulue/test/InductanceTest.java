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
 * Test Inductance class.
 *
 * @author your_name_here
 */
public class InductanceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public InductanceTest() {
		subscriber = new InductanceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate InductanceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Inductance...");
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
	 * jumpstart the process by instantiating2 Inductance
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		inductanceId = InductanceBusinessDelegate.getInductanceInstance()
		.createInductance( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		InductanceBusinessDelegate.getInductanceInstance()
				.createInductance( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.inductanceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Inductance : " + successValue.getInductanceId());
							  if (successValue.getInductanceId().equals(inductanceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfInductanceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Inductance test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on inductance consumed")
					);
			subscriber.inductanceSubscribe( inductanceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Inductance : " + successValue.getInductanceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfInductanceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on inductance for inductanceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Inductance. 
	 */
	protected Inductance read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Inductance" );

		Inductance entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Inductance with primary key" );
		msg.append( inductanceId );
		
		InductanceFetchOneSummary fetchOneSummary = new InductanceFetchOneSummary( inductanceId );

		try {
			entity = InductanceBusinessDelegate.getInductanceInstance().getInductance( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Inductance " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Inductance.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Inductance." );

		StringBuilder msg = new StringBuilder( "Failed to update a Inductance : " );        
		Inductance entity = read();
		UpdateInductanceCommand command = generateUpdateCommand();
		command.setInductanceId(entity.getInductanceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Inductance." );

			// for use later on...
			inductanceId = entity.getInductanceId();

			InductanceBusinessDelegate proxy = InductanceBusinessDelegate.getInductanceInstance();  

			proxy.updateInductance( command ).get();

			LOGGER.info( "-- Successfully saved Inductance - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + inductanceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Inductance.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Inductance." );

		Inductance entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Inductance with id " + inductanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Inductance with id " + inductanceId );

			throw e;
		}

		try{
			InductanceBusinessDelegate.getInductanceInstance().delete( new DeleteInductanceCommand( entity.getInductanceId() ) ).get();
			LOGGER.info( "-- Successfully deleted Inductance with id " + inductanceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Inductance with id " + inductanceId );

			throw e;
		}
	}

	/**
	 * get all Inductances.
	 */
	protected List<Inductance> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Inductances:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Inductance : " );        
		List<Inductance> collection  = new ArrayList<>();

		try {
			// call the static get method on the InductanceBusinessDelegate
			collection = InductanceBusinessDelegate.getInductanceInstance().getAllInductance();
			assertNotNull( collection, "An Empty collection of Inductance was incorrectly returned.");
			
			// Now print out the values
			Inductance entity = null;            
			Iterator<Inductance> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getInductanceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		InductanceTest
	 */
	protected InductanceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Inductance
	 * 
	 * @return CreateInductanceCommand alias
	 */
	protected CreateInductanceCommand generateNewCommand() {
        CreateInductanceCommand command = new CreateInductanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Inductance
		 * 
		 * @return UpdateInductanceCommand alias
		 */
	protected UpdateInductanceCommand generateUpdateCommand() {
	        UpdateInductanceCommand command = new UpdateInductanceCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID inductanceId = null;
	protected InductanceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(InductanceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfInductanceList = 0;
}
