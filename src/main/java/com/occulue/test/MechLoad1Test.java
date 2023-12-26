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
 * Test MechLoad1 class.
 *
 * @author your_name_here
 */
public class MechLoad1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MechLoad1Test() {
		subscriber = new MechLoad1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MechLoad1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on MechLoad1...");
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
	 * jumpstart the process by instantiating2 MechLoad1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		mechLoad1Id = MechLoad1BusinessDelegate.getMechLoad1Instance()
		.createMechLoad1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MechLoad1BusinessDelegate.getMechLoad1Instance()
				.createMechLoad1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.mechLoad1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for MechLoad1 : " + successValue.getMechLoad1Id());
							  if (successValue.getMechLoad1Id().equals(mechLoad1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMechLoad1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("MechLoad1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechLoad1 consumed")
					);
			subscriber.mechLoad1Subscribe( mechLoad1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for MechLoad1 : " + successValue.getMechLoad1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMechLoad1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on mechLoad1 for mechLoad1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a MechLoad1. 
	 */
	protected MechLoad1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created MechLoad1" );

		MechLoad1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read MechLoad1 with primary key" );
		msg.append( mechLoad1Id );
		
		MechLoad1FetchOneSummary fetchOneSummary = new MechLoad1FetchOneSummary( mechLoad1Id );

		try {
			entity = MechLoad1BusinessDelegate.getMechLoad1Instance().getMechLoad1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found MechLoad1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a MechLoad1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a MechLoad1." );

		StringBuilder msg = new StringBuilder( "Failed to update a MechLoad1 : " );        
		MechLoad1 entity = read();
		UpdateMechLoad1Command command = generateUpdateCommand();
		command.setMechLoad1Id(entity.getMechLoad1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created MechLoad1." );

			// for use later on...
			mechLoad1Id = entity.getMechLoad1Id();

			MechLoad1BusinessDelegate proxy = MechLoad1BusinessDelegate.getMechLoad1Instance();  

			proxy.updateMechLoad1( command ).get();

			LOGGER.info( "-- Successfully saved MechLoad1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + mechLoad1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a MechLoad1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created MechLoad1." );

		MechLoad1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read MechLoad1 with id " + mechLoad1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read MechLoad1 with id " + mechLoad1Id );

			throw e;
		}

		try{
			MechLoad1BusinessDelegate.getMechLoad1Instance().delete( new DeleteMechLoad1Command( entity.getMechLoad1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted MechLoad1 with id " + mechLoad1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete MechLoad1 with id " + mechLoad1Id );

			throw e;
		}
	}

	/**
	 * get all MechLoad1s.
	 */
	protected List<MechLoad1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of MechLoad1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all MechLoad1 : " );        
		List<MechLoad1> collection  = new ArrayList<>();

		try {
			// call the static get method on the MechLoad1BusinessDelegate
			collection = MechLoad1BusinessDelegate.getMechLoad1Instance().getAllMechLoad1();
			assertNotNull( collection, "An Empty collection of MechLoad1 was incorrectly returned.");
			
			// Now print out the values
			MechLoad1 entity = null;            
			Iterator<MechLoad1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMechLoad1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MechLoad1Test
	 */
	protected MechLoad1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated MechLoad1
	 * 
	 * @return CreateMechLoad1Command alias
	 */
	protected CreateMechLoad1Command generateNewCommand() {
        CreateMechLoad1Command command = new CreateMechLoad1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated MechLoad1
		 * 
		 * @return UpdateMechLoad1Command alias
		 */
	protected UpdateMechLoad1Command generateUpdateCommand() {
	        UpdateMechLoad1Command command = new UpdateMechLoad1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID mechLoad1Id = null;
	protected MechLoad1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MechLoad1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfMechLoad1List = 0;
}
