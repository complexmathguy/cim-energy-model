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
 * Test PssELIN2 class.
 *
 * @author your_name_here
 */
public class PssELIN2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssELIN2Test() {
		subscriber = new PssELIN2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssELIN2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssELIN2...");
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
	 * jumpstart the process by instantiating2 PssELIN2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssELIN2Id = PssELIN2BusinessDelegate.getPssELIN2Instance()
		.createPssELIN2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssELIN2BusinessDelegate.getPssELIN2Instance()
				.createPssELIN2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssELIN2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssELIN2 : " + successValue.getPssELIN2Id());
							  if (successValue.getPssELIN2Id().equals(pssELIN2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssELIN2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssELIN2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssELIN2 consumed")
					);
			subscriber.pssELIN2Subscribe( pssELIN2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssELIN2 : " + successValue.getPssELIN2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssELIN2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssELIN2 for pssELIN2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssELIN2. 
	 */
	protected PssELIN2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssELIN2" );

		PssELIN2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssELIN2 with primary key" );
		msg.append( pssELIN2Id );
		
		PssELIN2FetchOneSummary fetchOneSummary = new PssELIN2FetchOneSummary( pssELIN2Id );

		try {
			entity = PssELIN2BusinessDelegate.getPssELIN2Instance().getPssELIN2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssELIN2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssELIN2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssELIN2." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssELIN2 : " );        
		PssELIN2 entity = read();
		UpdatePssELIN2Command command = generateUpdateCommand();
		command.setPssELIN2Id(entity.getPssELIN2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssELIN2." );

			// for use later on...
			pssELIN2Id = entity.getPssELIN2Id();

			PssELIN2BusinessDelegate proxy = PssELIN2BusinessDelegate.getPssELIN2Instance();  

			proxy.updatePssELIN2( command ).get();

			LOGGER.info( "-- Successfully saved PssELIN2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssELIN2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssELIN2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssELIN2." );

		PssELIN2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssELIN2 with id " + pssELIN2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssELIN2 with id " + pssELIN2Id );

			throw e;
		}

		try{
			PssELIN2BusinessDelegate.getPssELIN2Instance().delete( new DeletePssELIN2Command( entity.getPssELIN2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted PssELIN2 with id " + pssELIN2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssELIN2 with id " + pssELIN2Id );

			throw e;
		}
	}

	/**
	 * get all PssELIN2s.
	 */
	protected List<PssELIN2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssELIN2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssELIN2 : " );        
		List<PssELIN2> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssELIN2BusinessDelegate
			collection = PssELIN2BusinessDelegate.getPssELIN2Instance().getAllPssELIN2();
			assertNotNull( collection, "An Empty collection of PssELIN2 was incorrectly returned.");
			
			// Now print out the values
			PssELIN2 entity = null;            
			Iterator<PssELIN2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssELIN2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssELIN2Test
	 */
	protected PssELIN2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssELIN2
	 * 
	 * @return CreatePssELIN2Command alias
	 */
	protected CreatePssELIN2Command generateNewCommand() {
        CreatePssELIN2Command command = new CreatePssELIN2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssELIN2
		 * 
		 * @return UpdatePssELIN2Command alias
		 */
	protected UpdatePssELIN2Command generateUpdateCommand() {
	        UpdatePssELIN2Command command = new UpdatePssELIN2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssELIN2Id = null;
	protected PssELIN2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssELIN2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssELIN2List = 0;
}
