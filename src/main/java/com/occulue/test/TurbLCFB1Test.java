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
 * Test TurbLCFB1 class.
 *
 * @author your_name_here
 */
public class TurbLCFB1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TurbLCFB1Test() {
		subscriber = new TurbLCFB1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TurbLCFB1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TurbLCFB1...");
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
	 * jumpstart the process by instantiating2 TurbLCFB1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		turbLCFB1Id = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance()
		.createTurbLCFB1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TurbLCFB1BusinessDelegate.getTurbLCFB1Instance()
				.createTurbLCFB1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.turbLCFB1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TurbLCFB1 : " + successValue.getTurbLCFB1Id());
							  if (successValue.getTurbLCFB1Id().equals(turbLCFB1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTurbLCFB1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TurbLCFB1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbLCFB1 consumed")
					);
			subscriber.turbLCFB1Subscribe( turbLCFB1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TurbLCFB1 : " + successValue.getTurbLCFB1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTurbLCFB1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on turbLCFB1 for turbLCFB1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TurbLCFB1. 
	 */
	protected TurbLCFB1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TurbLCFB1" );

		TurbLCFB1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TurbLCFB1 with primary key" );
		msg.append( turbLCFB1Id );
		
		TurbLCFB1FetchOneSummary fetchOneSummary = new TurbLCFB1FetchOneSummary( turbLCFB1Id );

		try {
			entity = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().getTurbLCFB1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TurbLCFB1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TurbLCFB1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TurbLCFB1." );

		StringBuilder msg = new StringBuilder( "Failed to update a TurbLCFB1 : " );        
		TurbLCFB1 entity = read();
		UpdateTurbLCFB1Command command = generateUpdateCommand();
		command.setTurbLCFB1Id(entity.getTurbLCFB1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TurbLCFB1." );

			// for use later on...
			turbLCFB1Id = entity.getTurbLCFB1Id();

			TurbLCFB1BusinessDelegate proxy = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();  

			proxy.updateTurbLCFB1( command ).get();

			LOGGER.info( "-- Successfully saved TurbLCFB1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + turbLCFB1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TurbLCFB1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TurbLCFB1." );

		TurbLCFB1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TurbLCFB1 with id " + turbLCFB1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TurbLCFB1 with id " + turbLCFB1Id );

			throw e;
		}

		try{
			TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().delete( new DeleteTurbLCFB1Command( entity.getTurbLCFB1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted TurbLCFB1 with id " + turbLCFB1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TurbLCFB1 with id " + turbLCFB1Id );

			throw e;
		}
	}

	/**
	 * get all TurbLCFB1s.
	 */
	protected List<TurbLCFB1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TurbLCFB1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TurbLCFB1 : " );        
		List<TurbLCFB1> collection  = new ArrayList<>();

		try {
			// call the static get method on the TurbLCFB1BusinessDelegate
			collection = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().getAllTurbLCFB1();
			assertNotNull( collection, "An Empty collection of TurbLCFB1 was incorrectly returned.");
			
			// Now print out the values
			TurbLCFB1 entity = null;            
			Iterator<TurbLCFB1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTurbLCFB1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TurbLCFB1Test
	 */
	protected TurbLCFB1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TurbLCFB1
	 * 
	 * @return CreateTurbLCFB1Command alias
	 */
	protected CreateTurbLCFB1Command generateNewCommand() {
        CreateTurbLCFB1Command command = new CreateTurbLCFB1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TurbLCFB1
		 * 
		 * @return UpdateTurbLCFB1Command alias
		 */
	protected UpdateTurbLCFB1Command generateUpdateCommand() {
	        UpdateTurbLCFB1Command command = new UpdateTurbLCFB1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID turbLCFB1Id = null;
	protected TurbLCFB1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TurbLCFB1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfTurbLCFB1List = 0;
}
