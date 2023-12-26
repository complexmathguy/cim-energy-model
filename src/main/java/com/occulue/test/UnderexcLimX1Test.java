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
 * Test UnderexcLimX1 class.
 *
 * @author your_name_here
 */
public class UnderexcLimX1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcLimX1Test() {
		subscriber = new UnderexcLimX1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcLimX1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcLimX1...");
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
	 * jumpstart the process by instantiating2 UnderexcLimX1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcLimX1Id = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance()
		.createUnderexcLimX1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance()
				.createUnderexcLimX1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcLimX1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcLimX1 : " + successValue.getUnderexcLimX1Id());
							  if (successValue.getUnderexcLimX1Id().equals(underexcLimX1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcLimX1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcLimX1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimX1 consumed")
					);
			subscriber.underexcLimX1Subscribe( underexcLimX1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcLimX1 : " + successValue.getUnderexcLimX1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcLimX1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimX1 for underexcLimX1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcLimX1. 
	 */
	protected UnderexcLimX1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcLimX1" );

		UnderexcLimX1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcLimX1 with primary key" );
		msg.append( underexcLimX1Id );
		
		UnderexcLimX1FetchOneSummary fetchOneSummary = new UnderexcLimX1FetchOneSummary( underexcLimX1Id );

		try {
			entity = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().getUnderexcLimX1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcLimX1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcLimX1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcLimX1." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcLimX1 : " );        
		UnderexcLimX1 entity = read();
		UpdateUnderexcLimX1Command command = generateUpdateCommand();
		command.setUnderexcLimX1Id(entity.getUnderexcLimX1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcLimX1." );

			// for use later on...
			underexcLimX1Id = entity.getUnderexcLimX1Id();

			UnderexcLimX1BusinessDelegate proxy = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance();  

			proxy.updateUnderexcLimX1( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcLimX1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcLimX1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcLimX1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcLimX1." );

		UnderexcLimX1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcLimX1 with id " + underexcLimX1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcLimX1 with id " + underexcLimX1Id );

			throw e;
		}

		try{
			UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().delete( new DeleteUnderexcLimX1Command( entity.getUnderexcLimX1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcLimX1 with id " + underexcLimX1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcLimX1 with id " + underexcLimX1Id );

			throw e;
		}
	}

	/**
	 * get all UnderexcLimX1s.
	 */
	protected List<UnderexcLimX1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcLimX1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcLimX1 : " );        
		List<UnderexcLimX1> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcLimX1BusinessDelegate
			collection = UnderexcLimX1BusinessDelegate.getUnderexcLimX1Instance().getAllUnderexcLimX1();
			assertNotNull( collection, "An Empty collection of UnderexcLimX1 was incorrectly returned.");
			
			// Now print out the values
			UnderexcLimX1 entity = null;            
			Iterator<UnderexcLimX1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcLimX1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcLimX1Test
	 */
	protected UnderexcLimX1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcLimX1
	 * 
	 * @return CreateUnderexcLimX1Command alias
	 */
	protected CreateUnderexcLimX1Command generateNewCommand() {
        CreateUnderexcLimX1Command command = new CreateUnderexcLimX1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcLimX1
		 * 
		 * @return UpdateUnderexcLimX1Command alias
		 */
	protected UpdateUnderexcLimX1Command generateUpdateCommand() {
	        UpdateUnderexcLimX1Command command = new UpdateUnderexcLimX1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcLimX1Id = null;
	protected UnderexcLimX1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcLimX1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcLimX1List = 0;
}
