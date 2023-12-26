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
 * Test OverexcLimX2 class.
 *
 * @author your_name_here
 */
public class OverexcLimX2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcLimX2Test() {
		subscriber = new OverexcLimX2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcLimX2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcLimX2...");
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
	 * jumpstart the process by instantiating2 OverexcLimX2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcLimX2Id = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance()
		.createOverexcLimX2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcLimX2BusinessDelegate.getOverexcLimX2Instance()
				.createOverexcLimX2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcLimX2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcLimX2 : " + successValue.getOverexcLimX2Id());
							  if (successValue.getOverexcLimX2Id().equals(overexcLimX2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcLimX2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcLimX2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimX2 consumed")
					);
			subscriber.overexcLimX2Subscribe( overexcLimX2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcLimX2 : " + successValue.getOverexcLimX2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcLimX2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLimX2 for overexcLimX2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcLimX2. 
	 */
	protected OverexcLimX2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcLimX2" );

		OverexcLimX2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcLimX2 with primary key" );
		msg.append( overexcLimX2Id );
		
		OverexcLimX2FetchOneSummary fetchOneSummary = new OverexcLimX2FetchOneSummary( overexcLimX2Id );

		try {
			entity = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().getOverexcLimX2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcLimX2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcLimX2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcLimX2." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcLimX2 : " );        
		OverexcLimX2 entity = read();
		UpdateOverexcLimX2Command command = generateUpdateCommand();
		command.setOverexcLimX2Id(entity.getOverexcLimX2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcLimX2." );

			// for use later on...
			overexcLimX2Id = entity.getOverexcLimX2Id();

			OverexcLimX2BusinessDelegate proxy = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();  

			proxy.updateOverexcLimX2( command ).get();

			LOGGER.info( "-- Successfully saved OverexcLimX2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcLimX2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcLimX2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcLimX2." );

		OverexcLimX2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcLimX2 with id " + overexcLimX2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcLimX2 with id " + overexcLimX2Id );

			throw e;
		}

		try{
			OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().delete( new DeleteOverexcLimX2Command( entity.getOverexcLimX2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcLimX2 with id " + overexcLimX2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcLimX2 with id " + overexcLimX2Id );

			throw e;
		}
	}

	/**
	 * get all OverexcLimX2s.
	 */
	protected List<OverexcLimX2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcLimX2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcLimX2 : " );        
		List<OverexcLimX2> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcLimX2BusinessDelegate
			collection = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().getAllOverexcLimX2();
			assertNotNull( collection, "An Empty collection of OverexcLimX2 was incorrectly returned.");
			
			// Now print out the values
			OverexcLimX2 entity = null;            
			Iterator<OverexcLimX2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcLimX2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcLimX2Test
	 */
	protected OverexcLimX2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcLimX2
	 * 
	 * @return CreateOverexcLimX2Command alias
	 */
	protected CreateOverexcLimX2Command generateNewCommand() {
        CreateOverexcLimX2Command command = new CreateOverexcLimX2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcLimX2
		 * 
		 * @return UpdateOverexcLimX2Command alias
		 */
	protected UpdateOverexcLimX2Command generateUpdateCommand() {
	        UpdateOverexcLimX2Command command = new UpdateOverexcLimX2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcLimX2Id = null;
	protected OverexcLimX2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcLimX2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcLimX2List = 0;
}
