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
 * Test CsConverter class.
 *
 * @author your_name_here
 */
public class CsConverterTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CsConverterTest() {
		subscriber = new CsConverterSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CsConverterTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CsConverter...");
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
	 * jumpstart the process by instantiating2 CsConverter
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		csConverterId = CsConverterBusinessDelegate.getCsConverterInstance()
		.createCsConverter( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CsConverterBusinessDelegate.getCsConverterInstance()
				.createCsConverter( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.csConverterSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CsConverter : " + successValue.getCsConverterId());
							  if (successValue.getCsConverterId().equals(csConverterId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCsConverterList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CsConverter test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on csConverter consumed")
					);
			subscriber.csConverterSubscribe( csConverterId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CsConverter : " + successValue.getCsConverterId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCsConverterList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on csConverter for csConverterId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CsConverter. 
	 */
	protected CsConverter read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CsConverter" );

		CsConverter entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CsConverter with primary key" );
		msg.append( csConverterId );
		
		CsConverterFetchOneSummary fetchOneSummary = new CsConverterFetchOneSummary( csConverterId );

		try {
			entity = CsConverterBusinessDelegate.getCsConverterInstance().getCsConverter( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CsConverter " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CsConverter.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CsConverter." );

		StringBuilder msg = new StringBuilder( "Failed to update a CsConverter : " );        
		CsConverter entity = read();
		UpdateCsConverterCommand command = generateUpdateCommand();
		command.setCsConverterId(entity.getCsConverterId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CsConverter." );

			// for use later on...
			csConverterId = entity.getCsConverterId();

			CsConverterBusinessDelegate proxy = CsConverterBusinessDelegate.getCsConverterInstance();  

			proxy.updateCsConverter( command ).get();

			LOGGER.info( "-- Successfully saved CsConverter - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + csConverterId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CsConverter.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CsConverter." );

		CsConverter entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CsConverter with id " + csConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CsConverter with id " + csConverterId );

			throw e;
		}

		try{
			CsConverterBusinessDelegate.getCsConverterInstance().delete( new DeleteCsConverterCommand( entity.getCsConverterId() ) ).get();
			LOGGER.info( "-- Successfully deleted CsConverter with id " + csConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CsConverter with id " + csConverterId );

			throw e;
		}
	}

	/**
	 * get all CsConverters.
	 */
	protected List<CsConverter> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CsConverters:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CsConverter : " );        
		List<CsConverter> collection  = new ArrayList<>();

		try {
			// call the static get method on the CsConverterBusinessDelegate
			collection = CsConverterBusinessDelegate.getCsConverterInstance().getAllCsConverter();
			assertNotNull( collection, "An Empty collection of CsConverter was incorrectly returned.");
			
			// Now print out the values
			CsConverter entity = null;            
			Iterator<CsConverter> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCsConverterId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CsConverterTest
	 */
	protected CsConverterTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CsConverter
	 * 
	 * @return CreateCsConverterCommand alias
	 */
	protected CreateCsConverterCommand generateNewCommand() {
        CreateCsConverterCommand command = new CreateCsConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CsConverter
		 * 
		 * @return UpdateCsConverterCommand alias
		 */
	protected UpdateCsConverterCommand generateUpdateCommand() {
	        UpdateCsConverterCommand command = new UpdateCsConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID csConverterId = null;
	protected CsConverterSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CsConverterTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCsConverterList = 0;
}
