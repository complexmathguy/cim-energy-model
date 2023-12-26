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
 * Test UnderexcLimIEEE1 class.
 *
 * @author your_name_here
 */
public class UnderexcLimIEEE1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcLimIEEE1Test() {
		subscriber = new UnderexcLimIEEE1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcLimIEEE1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcLimIEEE1...");
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
	 * jumpstart the process by instantiating2 UnderexcLimIEEE1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcLimIEEE1Id = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance()
		.createUnderexcLimIEEE1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance()
				.createUnderexcLimIEEE1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcLimIEEE1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcLimIEEE1 : " + successValue.getUnderexcLimIEEE1Id());
							  if (successValue.getUnderexcLimIEEE1Id().equals(underexcLimIEEE1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcLimIEEE1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcLimIEEE1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimIEEE1 consumed")
					);
			subscriber.underexcLimIEEE1Subscribe( underexcLimIEEE1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcLimIEEE1 : " + successValue.getUnderexcLimIEEE1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcLimIEEE1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimIEEE1 for underexcLimIEEE1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcLimIEEE1. 
	 */
	protected UnderexcLimIEEE1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcLimIEEE1" );

		UnderexcLimIEEE1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcLimIEEE1 with primary key" );
		msg.append( underexcLimIEEE1Id );
		
		UnderexcLimIEEE1FetchOneSummary fetchOneSummary = new UnderexcLimIEEE1FetchOneSummary( underexcLimIEEE1Id );

		try {
			entity = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().getUnderexcLimIEEE1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcLimIEEE1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcLimIEEE1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcLimIEEE1." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcLimIEEE1 : " );        
		UnderexcLimIEEE1 entity = read();
		UpdateUnderexcLimIEEE1Command command = generateUpdateCommand();
		command.setUnderexcLimIEEE1Id(entity.getUnderexcLimIEEE1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcLimIEEE1." );

			// for use later on...
			underexcLimIEEE1Id = entity.getUnderexcLimIEEE1Id();

			UnderexcLimIEEE1BusinessDelegate proxy = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();  

			proxy.updateUnderexcLimIEEE1( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcLimIEEE1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcLimIEEE1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcLimIEEE1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcLimIEEE1." );

		UnderexcLimIEEE1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcLimIEEE1 with id " + underexcLimIEEE1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcLimIEEE1 with id " + underexcLimIEEE1Id );

			throw e;
		}

		try{
			UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().delete( new DeleteUnderexcLimIEEE1Command( entity.getUnderexcLimIEEE1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcLimIEEE1 with id " + underexcLimIEEE1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcLimIEEE1 with id " + underexcLimIEEE1Id );

			throw e;
		}
	}

	/**
	 * get all UnderexcLimIEEE1s.
	 */
	protected List<UnderexcLimIEEE1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcLimIEEE1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcLimIEEE1 : " );        
		List<UnderexcLimIEEE1> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcLimIEEE1BusinessDelegate
			collection = UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().getAllUnderexcLimIEEE1();
			assertNotNull( collection, "An Empty collection of UnderexcLimIEEE1 was incorrectly returned.");
			
			// Now print out the values
			UnderexcLimIEEE1 entity = null;            
			Iterator<UnderexcLimIEEE1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcLimIEEE1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcLimIEEE1Test
	 */
	protected UnderexcLimIEEE1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcLimIEEE1
	 * 
	 * @return CreateUnderexcLimIEEE1Command alias
	 */
	protected CreateUnderexcLimIEEE1Command generateNewCommand() {
        CreateUnderexcLimIEEE1Command command = new CreateUnderexcLimIEEE1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcLimIEEE1
		 * 
		 * @return UpdateUnderexcLimIEEE1Command alias
		 */
	protected UpdateUnderexcLimIEEE1Command generateUpdateCommand() {
	        UpdateUnderexcLimIEEE1Command command = new UpdateUnderexcLimIEEE1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcLimIEEE1Id = null;
	protected UnderexcLimIEEE1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcLimIEEE1List = 0;
}
