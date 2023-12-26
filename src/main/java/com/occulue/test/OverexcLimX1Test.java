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
 * Test OverexcLimX1 class.
 *
 * @author your_name_here
 */
public class OverexcLimX1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcLimX1Test() {
		subscriber = new OverexcLimX1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcLimX1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcLimX1...");
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
	 * jumpstart the process by instantiating2 OverexcLimX1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcLimX1Id = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance()
		.createOverexcLimX1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcLimX1BusinessDelegate.getOverexcLimX1Instance()
				.createOverexcLimX1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcLimX1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcLimX1 : " + successValue.getOverexcLimX1Id());
							  if (successValue.getOverexcLimX1Id().equals(overexcLimX1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcLimX1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcLimX1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimX1 consumed")
					);
			subscriber.overexcLimX1Subscribe( overexcLimX1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcLimX1 : " + successValue.getOverexcLimX1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcLimX1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimX1 for overexcLimX1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcLimX1. 
	 */
	protected OverexcLimX1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcLimX1" );

		OverexcLimX1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcLimX1 with primary key" );
		msg.append( overexcLimX1Id );
		
		OverexcLimX1FetchOneSummary fetchOneSummary = new OverexcLimX1FetchOneSummary( overexcLimX1Id );

		try {
			entity = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().getOverexcLimX1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcLimX1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcLimX1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcLimX1." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcLimX1 : " );        
		OverexcLimX1 entity = read();
		UpdateOverexcLimX1Command command = generateUpdateCommand();
		command.setOverexcLimX1Id(entity.getOverexcLimX1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcLimX1." );

			// for use later on...
			overexcLimX1Id = entity.getOverexcLimX1Id();

			OverexcLimX1BusinessDelegate proxy = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();  

			proxy.updateOverexcLimX1( command ).get();

			LOGGER.info( "-- Successfully saved OverexcLimX1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcLimX1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcLimX1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcLimX1." );

		OverexcLimX1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcLimX1 with id " + overexcLimX1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcLimX1 with id " + overexcLimX1Id );

			throw e;
		}

		try{
			OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().delete( new DeleteOverexcLimX1Command( entity.getOverexcLimX1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcLimX1 with id " + overexcLimX1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcLimX1 with id " + overexcLimX1Id );

			throw e;
		}
	}

	/**
	 * get all OverexcLimX1s.
	 */
	protected List<OverexcLimX1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcLimX1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcLimX1 : " );        
		List<OverexcLimX1> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcLimX1BusinessDelegate
			collection = OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().getAllOverexcLimX1();
			assertNotNull( collection, "An Empty collection of OverexcLimX1 was incorrectly returned.");
			
			// Now print out the values
			OverexcLimX1 entity = null;            
			Iterator<OverexcLimX1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcLimX1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcLimX1Test
	 */
	protected OverexcLimX1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcLimX1
	 * 
	 * @return CreateOverexcLimX1Command alias
	 */
	protected CreateOverexcLimX1Command generateNewCommand() {
        CreateOverexcLimX1Command command = new CreateOverexcLimX1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcLimX1
		 * 
		 * @return UpdateOverexcLimX1Command alias
		 */
	protected UpdateOverexcLimX1Command generateUpdateCommand() {
	        UpdateOverexcLimX1Command command = new UpdateOverexcLimX1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcLimX1Id = null;
	protected OverexcLimX1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcLimX1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcLimX1List = 0;
}
