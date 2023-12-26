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
 * Test PFVArType2Common1 class.
 *
 * @author your_name_here
 */
public class PFVArType2Common1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArType2Common1Test() {
		subscriber = new PFVArType2Common1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArType2Common1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArType2Common1...");
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
	 * jumpstart the process by instantiating2 PFVArType2Common1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArType2Common1Id = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance()
		.createPFVArType2Common1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance()
				.createPFVArType2Common1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArType2Common1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArType2Common1 : " + successValue.getPFVArType2Common1Id());
							  if (successValue.getPFVArType2Common1Id().equals(pFVArType2Common1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArType2Common1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArType2Common1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2Common1 consumed")
					);
			subscriber.pFVArType2Common1Subscribe( pFVArType2Common1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArType2Common1 : " + successValue.getPFVArType2Common1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArType2Common1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArType2Common1 for pFVArType2Common1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArType2Common1. 
	 */
	protected PFVArType2Common1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArType2Common1" );

		PFVArType2Common1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArType2Common1 with primary key" );
		msg.append( pFVArType2Common1Id );
		
		PFVArType2Common1FetchOneSummary fetchOneSummary = new PFVArType2Common1FetchOneSummary( pFVArType2Common1Id );

		try {
			entity = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().getPFVArType2Common1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArType2Common1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArType2Common1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArType2Common1." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArType2Common1 : " );        
		PFVArType2Common1 entity = read();
		UpdatePFVArType2Common1Command command = generateUpdateCommand();
		command.setPFVArType2Common1Id(entity.getPFVArType2Common1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArType2Common1." );

			// for use later on...
			pFVArType2Common1Id = entity.getPFVArType2Common1Id();

			PFVArType2Common1BusinessDelegate proxy = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance();  

			proxy.updatePFVArType2Common1( command ).get();

			LOGGER.info( "-- Successfully saved PFVArType2Common1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArType2Common1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArType2Common1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArType2Common1." );

		PFVArType2Common1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArType2Common1 with id " + pFVArType2Common1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArType2Common1 with id " + pFVArType2Common1Id );

			throw e;
		}

		try{
			PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().delete( new DeletePFVArType2Common1Command( entity.getPFVArType2Common1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArType2Common1 with id " + pFVArType2Common1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArType2Common1 with id " + pFVArType2Common1Id );

			throw e;
		}
	}

	/**
	 * get all PFVArType2Common1s.
	 */
	protected List<PFVArType2Common1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArType2Common1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArType2Common1 : " );        
		List<PFVArType2Common1> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArType2Common1BusinessDelegate
			collection = PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().getAllPFVArType2Common1();
			assertNotNull( collection, "An Empty collection of PFVArType2Common1 was incorrectly returned.");
			
			// Now print out the values
			PFVArType2Common1 entity = null;            
			Iterator<PFVArType2Common1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArType2Common1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArType2Common1Test
	 */
	protected PFVArType2Common1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArType2Common1
	 * 
	 * @return CreatePFVArType2Common1Command alias
	 */
	protected CreatePFVArType2Common1Command generateNewCommand() {
        CreatePFVArType2Common1Command command = new CreatePFVArType2Common1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArType2Common1
		 * 
		 * @return UpdatePFVArType2Common1Command alias
		 */
	protected UpdatePFVArType2Common1Command generateUpdateCommand() {
	        UpdatePFVArType2Common1Command command = new UpdatePFVArType2Common1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArType2Common1Id = null;
	protected PFVArType2Common1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArType2Common1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArType2Common1List = 0;
}
