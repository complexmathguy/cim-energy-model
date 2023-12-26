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
 * Test PssPTIST1 class.
 *
 * @author your_name_here
 */
public class PssPTIST1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssPTIST1Test() {
		subscriber = new PssPTIST1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssPTIST1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssPTIST1...");
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
	 * jumpstart the process by instantiating2 PssPTIST1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssPTIST1Id = PssPTIST1BusinessDelegate.getPssPTIST1Instance()
		.createPssPTIST1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssPTIST1BusinessDelegate.getPssPTIST1Instance()
				.createPssPTIST1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssPTIST1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssPTIST1 : " + successValue.getPssPTIST1Id());
							  if (successValue.getPssPTIST1Id().equals(pssPTIST1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssPTIST1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssPTIST1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssPTIST1 consumed")
					);
			subscriber.pssPTIST1Subscribe( pssPTIST1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssPTIST1 : " + successValue.getPssPTIST1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssPTIST1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssPTIST1 for pssPTIST1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssPTIST1. 
	 */
	protected PssPTIST1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssPTIST1" );

		PssPTIST1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssPTIST1 with primary key" );
		msg.append( pssPTIST1Id );
		
		PssPTIST1FetchOneSummary fetchOneSummary = new PssPTIST1FetchOneSummary( pssPTIST1Id );

		try {
			entity = PssPTIST1BusinessDelegate.getPssPTIST1Instance().getPssPTIST1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssPTIST1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssPTIST1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssPTIST1." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssPTIST1 : " );        
		PssPTIST1 entity = read();
		UpdatePssPTIST1Command command = generateUpdateCommand();
		command.setPssPTIST1Id(entity.getPssPTIST1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssPTIST1." );

			// for use later on...
			pssPTIST1Id = entity.getPssPTIST1Id();

			PssPTIST1BusinessDelegate proxy = PssPTIST1BusinessDelegate.getPssPTIST1Instance();  

			proxy.updatePssPTIST1( command ).get();

			LOGGER.info( "-- Successfully saved PssPTIST1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssPTIST1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssPTIST1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssPTIST1." );

		PssPTIST1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssPTIST1 with id " + pssPTIST1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssPTIST1 with id " + pssPTIST1Id );

			throw e;
		}

		try{
			PssPTIST1BusinessDelegate.getPssPTIST1Instance().delete( new DeletePssPTIST1Command( entity.getPssPTIST1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted PssPTIST1 with id " + pssPTIST1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssPTIST1 with id " + pssPTIST1Id );

			throw e;
		}
	}

	/**
	 * get all PssPTIST1s.
	 */
	protected List<PssPTIST1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssPTIST1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssPTIST1 : " );        
		List<PssPTIST1> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssPTIST1BusinessDelegate
			collection = PssPTIST1BusinessDelegate.getPssPTIST1Instance().getAllPssPTIST1();
			assertNotNull( collection, "An Empty collection of PssPTIST1 was incorrectly returned.");
			
			// Now print out the values
			PssPTIST1 entity = null;            
			Iterator<PssPTIST1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssPTIST1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssPTIST1Test
	 */
	protected PssPTIST1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssPTIST1
	 * 
	 * @return CreatePssPTIST1Command alias
	 */
	protected CreatePssPTIST1Command generateNewCommand() {
        CreatePssPTIST1Command command = new CreatePssPTIST1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssPTIST1
		 * 
		 * @return UpdatePssPTIST1Command alias
		 */
	protected UpdatePssPTIST1Command generateUpdateCommand() {
	        UpdatePssPTIST1Command command = new UpdatePssPTIST1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssPTIST1Id = null;
	protected PssPTIST1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssPTIST1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssPTIST1List = 0;
}
