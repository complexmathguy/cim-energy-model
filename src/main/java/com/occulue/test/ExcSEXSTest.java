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
 * Test ExcSEXS class.
 *
 * @author your_name_here
 */
public class ExcSEXSTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ExcSEXSTest() {
		subscriber = new ExcSEXSSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ExcSEXSTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ExcSEXS...");
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
	 * jumpstart the process by instantiating2 ExcSEXS
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		excSEXSId = ExcSEXSBusinessDelegate.getExcSEXSInstance()
		.createExcSEXS( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ExcSEXSBusinessDelegate.getExcSEXSInstance()
				.createExcSEXS( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.excSEXSSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ExcSEXS : " + successValue.getExcSEXSId());
							  if (successValue.getExcSEXSId().equals(excSEXSId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfExcSEXSList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ExcSEXS test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excSEXS consumed")
					);
			subscriber.excSEXSSubscribe( excSEXSId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ExcSEXS : " + successValue.getExcSEXSId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfExcSEXSList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on excSEXS for excSEXSId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ExcSEXS. 
	 */
	protected ExcSEXS read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ExcSEXS" );

		ExcSEXS entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ExcSEXS with primary key" );
		msg.append( excSEXSId );
		
		ExcSEXSFetchOneSummary fetchOneSummary = new ExcSEXSFetchOneSummary( excSEXSId );

		try {
			entity = ExcSEXSBusinessDelegate.getExcSEXSInstance().getExcSEXS( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ExcSEXS " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ExcSEXS.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ExcSEXS." );

		StringBuilder msg = new StringBuilder( "Failed to update a ExcSEXS : " );        
		ExcSEXS entity = read();
		UpdateExcSEXSCommand command = generateUpdateCommand();
		command.setExcSEXSId(entity.getExcSEXSId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ExcSEXS." );

			// for use later on...
			excSEXSId = entity.getExcSEXSId();

			ExcSEXSBusinessDelegate proxy = ExcSEXSBusinessDelegate.getExcSEXSInstance();  

			proxy.updateExcSEXS( command ).get();

			LOGGER.info( "-- Successfully saved ExcSEXS - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + excSEXSId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ExcSEXS.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ExcSEXS." );

		ExcSEXS entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ExcSEXS with id " + excSEXSId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ExcSEXS with id " + excSEXSId );

			throw e;
		}

		try{
			ExcSEXSBusinessDelegate.getExcSEXSInstance().delete( new DeleteExcSEXSCommand( entity.getExcSEXSId() ) ).get();
			LOGGER.info( "-- Successfully deleted ExcSEXS with id " + excSEXSId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ExcSEXS with id " + excSEXSId );

			throw e;
		}
	}

	/**
	 * get all ExcSEXSs.
	 */
	protected List<ExcSEXS> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ExcSEXSs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ExcSEXS : " );        
		List<ExcSEXS> collection  = new ArrayList<>();

		try {
			// call the static get method on the ExcSEXSBusinessDelegate
			collection = ExcSEXSBusinessDelegate.getExcSEXSInstance().getAllExcSEXS();
			assertNotNull( collection, "An Empty collection of ExcSEXS was incorrectly returned.");
			
			// Now print out the values
			ExcSEXS entity = null;            
			Iterator<ExcSEXS> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getExcSEXSId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ExcSEXSTest
	 */
	protected ExcSEXSTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ExcSEXS
	 * 
	 * @return CreateExcSEXSCommand alias
	 */
	protected CreateExcSEXSCommand generateNewCommand() {
        CreateExcSEXSCommand command = new CreateExcSEXSCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ExcSEXS
		 * 
		 * @return UpdateExcSEXSCommand alias
		 */
	protected UpdateExcSEXSCommand generateUpdateCommand() {
	        UpdateExcSEXSCommand command = new UpdateExcSEXSCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID excSEXSId = null;
	protected ExcSEXSSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ExcSEXSTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfExcSEXSList = 0;
}
