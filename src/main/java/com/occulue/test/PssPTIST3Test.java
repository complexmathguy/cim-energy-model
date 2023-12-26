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
 * Test PssPTIST3 class.
 *
 * @author your_name_here
 */
public class PssPTIST3Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PssPTIST3Test() {
		subscriber = new PssPTIST3Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PssPTIST3Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PssPTIST3...");
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
	 * jumpstart the process by instantiating2 PssPTIST3
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pssPTIST3Id = PssPTIST3BusinessDelegate.getPssPTIST3Instance()
		.createPssPTIST3( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PssPTIST3BusinessDelegate.getPssPTIST3Instance()
				.createPssPTIST3( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pssPTIST3Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PssPTIST3 : " + successValue.getPssPTIST3Id());
							  if (successValue.getPssPTIST3Id().equals(pssPTIST3Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPssPTIST3List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PssPTIST3 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssPTIST3 consumed")
					);
			subscriber.pssPTIST3Subscribe( pssPTIST3Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PssPTIST3 : " + successValue.getPssPTIST3Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPssPTIST3List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pssPTIST3 for pssPTIST3Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PssPTIST3. 
	 */
	protected PssPTIST3 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PssPTIST3" );

		PssPTIST3 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PssPTIST3 with primary key" );
		msg.append( pssPTIST3Id );
		
		PssPTIST3FetchOneSummary fetchOneSummary = new PssPTIST3FetchOneSummary( pssPTIST3Id );

		try {
			entity = PssPTIST3BusinessDelegate.getPssPTIST3Instance().getPssPTIST3( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PssPTIST3 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PssPTIST3.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PssPTIST3." );

		StringBuilder msg = new StringBuilder( "Failed to update a PssPTIST3 : " );        
		PssPTIST3 entity = read();
		UpdatePssPTIST3Command command = generateUpdateCommand();
		command.setPssPTIST3Id(entity.getPssPTIST3Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PssPTIST3." );

			// for use later on...
			pssPTIST3Id = entity.getPssPTIST3Id();

			PssPTIST3BusinessDelegate proxy = PssPTIST3BusinessDelegate.getPssPTIST3Instance();  

			proxy.updatePssPTIST3( command ).get();

			LOGGER.info( "-- Successfully saved PssPTIST3 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pssPTIST3Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PssPTIST3.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PssPTIST3." );

		PssPTIST3 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PssPTIST3 with id " + pssPTIST3Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PssPTIST3 with id " + pssPTIST3Id );

			throw e;
		}

		try{
			PssPTIST3BusinessDelegate.getPssPTIST3Instance().delete( new DeletePssPTIST3Command( entity.getPssPTIST3Id() ) ).get();
			LOGGER.info( "-- Successfully deleted PssPTIST3 with id " + pssPTIST3Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PssPTIST3 with id " + pssPTIST3Id );

			throw e;
		}
	}

	/**
	 * get all PssPTIST3s.
	 */
	protected List<PssPTIST3> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PssPTIST3s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PssPTIST3 : " );        
		List<PssPTIST3> collection  = new ArrayList<>();

		try {
			// call the static get method on the PssPTIST3BusinessDelegate
			collection = PssPTIST3BusinessDelegate.getPssPTIST3Instance().getAllPssPTIST3();
			assertNotNull( collection, "An Empty collection of PssPTIST3 was incorrectly returned.");
			
			// Now print out the values
			PssPTIST3 entity = null;            
			Iterator<PssPTIST3> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPssPTIST3Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PssPTIST3Test
	 */
	protected PssPTIST3Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PssPTIST3
	 * 
	 * @return CreatePssPTIST3Command alias
	 */
	protected CreatePssPTIST3Command generateNewCommand() {
        CreatePssPTIST3Command command = new CreatePssPTIST3Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PssPTIST3
		 * 
		 * @return UpdatePssPTIST3Command alias
		 */
	protected UpdatePssPTIST3Command generateUpdateCommand() {
	        UpdatePssPTIST3Command command = new UpdatePssPTIST3Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pssPTIST3Id = null;
	protected PssPTIST3Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PssPTIST3Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfPssPTIST3List = 0;
}
