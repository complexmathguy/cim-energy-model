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
 * Test OverexcLim2 class.
 *
 * @author your_name_here
 */
public class OverexcLim2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OverexcLim2Test() {
		subscriber = new OverexcLim2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OverexcLim2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OverexcLim2...");
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
	 * jumpstart the process by instantiating2 OverexcLim2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		overexcLim2Id = OverexcLim2BusinessDelegate.getOverexcLim2Instance()
		.createOverexcLim2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OverexcLim2BusinessDelegate.getOverexcLim2Instance()
				.createOverexcLim2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.overexcLim2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OverexcLim2 : " + successValue.getOverexcLim2Id());
							  if (successValue.getOverexcLim2Id().equals(overexcLim2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOverexcLim2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OverexcLim2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLim2 consumed")
					);
			subscriber.overexcLim2Subscribe( overexcLim2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OverexcLim2 : " + successValue.getOverexcLim2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOverexcLim2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on overexcLim2 for overexcLim2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OverexcLim2. 
	 */
	protected OverexcLim2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OverexcLim2" );

		OverexcLim2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OverexcLim2 with primary key" );
		msg.append( overexcLim2Id );
		
		OverexcLim2FetchOneSummary fetchOneSummary = new OverexcLim2FetchOneSummary( overexcLim2Id );

		try {
			entity = OverexcLim2BusinessDelegate.getOverexcLim2Instance().getOverexcLim2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OverexcLim2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OverexcLim2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OverexcLim2." );

		StringBuilder msg = new StringBuilder( "Failed to update a OverexcLim2 : " );        
		OverexcLim2 entity = read();
		UpdateOverexcLim2Command command = generateUpdateCommand();
		command.setOverexcLim2Id(entity.getOverexcLim2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OverexcLim2." );

			// for use later on...
			overexcLim2Id = entity.getOverexcLim2Id();

			OverexcLim2BusinessDelegate proxy = OverexcLim2BusinessDelegate.getOverexcLim2Instance();  

			proxy.updateOverexcLim2( command ).get();

			LOGGER.info( "-- Successfully saved OverexcLim2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + overexcLim2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OverexcLim2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OverexcLim2." );

		OverexcLim2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OverexcLim2 with id " + overexcLim2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OverexcLim2 with id " + overexcLim2Id );

			throw e;
		}

		try{
			OverexcLim2BusinessDelegate.getOverexcLim2Instance().delete( new DeleteOverexcLim2Command( entity.getOverexcLim2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted OverexcLim2 with id " + overexcLim2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OverexcLim2 with id " + overexcLim2Id );

			throw e;
		}
	}

	/**
	 * get all OverexcLim2s.
	 */
	protected List<OverexcLim2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OverexcLim2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OverexcLim2 : " );        
		List<OverexcLim2> collection  = new ArrayList<>();

		try {
			// call the static get method on the OverexcLim2BusinessDelegate
			collection = OverexcLim2BusinessDelegate.getOverexcLim2Instance().getAllOverexcLim2();
			assertNotNull( collection, "An Empty collection of OverexcLim2 was incorrectly returned.");
			
			// Now print out the values
			OverexcLim2 entity = null;            
			Iterator<OverexcLim2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOverexcLim2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OverexcLim2Test
	 */
	protected OverexcLim2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OverexcLim2
	 * 
	 * @return CreateOverexcLim2Command alias
	 */
	protected CreateOverexcLim2Command generateNewCommand() {
        CreateOverexcLim2Command command = new CreateOverexcLim2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OverexcLim2
		 * 
		 * @return UpdateOverexcLim2Command alias
		 */
	protected UpdateOverexcLim2Command generateUpdateCommand() {
	        UpdateOverexcLim2Command command = new UpdateOverexcLim2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID overexcLim2Id = null;
	protected OverexcLim2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OverexcLim2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfOverexcLim2List = 0;
}
