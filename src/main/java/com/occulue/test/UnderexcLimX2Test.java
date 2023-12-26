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
 * Test UnderexcLimX2 class.
 *
 * @author your_name_here
 */
public class UnderexcLimX2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnderexcLimX2Test() {
		subscriber = new UnderexcLimX2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnderexcLimX2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on UnderexcLimX2...");
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
	 * jumpstart the process by instantiating2 UnderexcLimX2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		underexcLimX2Id = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance()
		.createUnderexcLimX2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance()
				.createUnderexcLimX2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.underexcLimX2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for UnderexcLimX2 : " + successValue.getUnderexcLimX2Id());
							  if (successValue.getUnderexcLimX2Id().equals(underexcLimX2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnderexcLimX2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("UnderexcLimX2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimX2 consumed")
					);
			subscriber.underexcLimX2Subscribe( underexcLimX2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for UnderexcLimX2 : " + successValue.getUnderexcLimX2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnderexcLimX2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on underexcLimX2 for underexcLimX2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a UnderexcLimX2. 
	 */
	protected UnderexcLimX2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created UnderexcLimX2" );

		UnderexcLimX2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read UnderexcLimX2 with primary key" );
		msg.append( underexcLimX2Id );
		
		UnderexcLimX2FetchOneSummary fetchOneSummary = new UnderexcLimX2FetchOneSummary( underexcLimX2Id );

		try {
			entity = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().getUnderexcLimX2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found UnderexcLimX2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a UnderexcLimX2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a UnderexcLimX2." );

		StringBuilder msg = new StringBuilder( "Failed to update a UnderexcLimX2 : " );        
		UnderexcLimX2 entity = read();
		UpdateUnderexcLimX2Command command = generateUpdateCommand();
		command.setUnderexcLimX2Id(entity.getUnderexcLimX2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created UnderexcLimX2." );

			// for use later on...
			underexcLimX2Id = entity.getUnderexcLimX2Id();

			UnderexcLimX2BusinessDelegate proxy = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance();  

			proxy.updateUnderexcLimX2( command ).get();

			LOGGER.info( "-- Successfully saved UnderexcLimX2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + underexcLimX2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a UnderexcLimX2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created UnderexcLimX2." );

		UnderexcLimX2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read UnderexcLimX2 with id " + underexcLimX2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read UnderexcLimX2 with id " + underexcLimX2Id );

			throw e;
		}

		try{
			UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().delete( new DeleteUnderexcLimX2Command( entity.getUnderexcLimX2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted UnderexcLimX2 with id " + underexcLimX2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete UnderexcLimX2 with id " + underexcLimX2Id );

			throw e;
		}
	}

	/**
	 * get all UnderexcLimX2s.
	 */
	protected List<UnderexcLimX2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of UnderexcLimX2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all UnderexcLimX2 : " );        
		List<UnderexcLimX2> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnderexcLimX2BusinessDelegate
			collection = UnderexcLimX2BusinessDelegate.getUnderexcLimX2Instance().getAllUnderexcLimX2();
			assertNotNull( collection, "An Empty collection of UnderexcLimX2 was incorrectly returned.");
			
			// Now print out the values
			UnderexcLimX2 entity = null;            
			Iterator<UnderexcLimX2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnderexcLimX2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnderexcLimX2Test
	 */
	protected UnderexcLimX2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated UnderexcLimX2
	 * 
	 * @return CreateUnderexcLimX2Command alias
	 */
	protected CreateUnderexcLimX2Command generateNewCommand() {
        CreateUnderexcLimX2Command command = new CreateUnderexcLimX2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated UnderexcLimX2
		 * 
		 * @return UpdateUnderexcLimX2Command alias
		 */
	protected UpdateUnderexcLimX2Command generateUpdateCommand() {
	        UpdateUnderexcLimX2Command command = new UpdateUnderexcLimX2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID underexcLimX2Id = null;
	protected UnderexcLimX2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnderexcLimX2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnderexcLimX2List = 0;
}
