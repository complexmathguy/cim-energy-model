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
 * Test ACDCConverter class.
 *
 * @author your_name_here
 */
public class ACDCConverterTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ACDCConverterTest() {
		subscriber = new ACDCConverterSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ACDCConverterTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ACDCConverter...");
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
	 * jumpstart the process by instantiating2 ACDCConverter
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		aCDCConverterId = ACDCConverterBusinessDelegate.getACDCConverterInstance()
		.createACDCConverter( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ACDCConverterBusinessDelegate.getACDCConverterInstance()
				.createACDCConverter( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.aCDCConverterSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ACDCConverter : " + successValue.getACDCConverterId());
							  if (successValue.getACDCConverterId().equals(aCDCConverterId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfACDCConverterList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ACDCConverter test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCConverter consumed")
					);
			subscriber.aCDCConverterSubscribe( aCDCConverterId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ACDCConverter : " + successValue.getACDCConverterId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfACDCConverterList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on aCDCConverter for aCDCConverterId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ACDCConverter. 
	 */
	protected ACDCConverter read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ACDCConverter" );

		ACDCConverter entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ACDCConverter with primary key" );
		msg.append( aCDCConverterId );
		
		ACDCConverterFetchOneSummary fetchOneSummary = new ACDCConverterFetchOneSummary( aCDCConverterId );

		try {
			entity = ACDCConverterBusinessDelegate.getACDCConverterInstance().getACDCConverter( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ACDCConverter " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ACDCConverter.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ACDCConverter." );

		StringBuilder msg = new StringBuilder( "Failed to update a ACDCConverter : " );        
		ACDCConverter entity = read();
		UpdateACDCConverterCommand command = generateUpdateCommand();
		command.setACDCConverterId(entity.getACDCConverterId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ACDCConverter." );

			// for use later on...
			aCDCConverterId = entity.getACDCConverterId();

			ACDCConverterBusinessDelegate proxy = ACDCConverterBusinessDelegate.getACDCConverterInstance();  

			proxy.updateACDCConverter( command ).get();

			LOGGER.info( "-- Successfully saved ACDCConverter - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + aCDCConverterId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ACDCConverter.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ACDCConverter." );

		ACDCConverter entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ACDCConverter with id " + aCDCConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ACDCConverter with id " + aCDCConverterId );

			throw e;
		}

		try{
			ACDCConverterBusinessDelegate.getACDCConverterInstance().delete( new DeleteACDCConverterCommand( entity.getACDCConverterId() ) ).get();
			LOGGER.info( "-- Successfully deleted ACDCConverter with id " + aCDCConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ACDCConverter with id " + aCDCConverterId );

			throw e;
		}
	}

	/**
	 * get all ACDCConverters.
	 */
	protected List<ACDCConverter> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ACDCConverters:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ACDCConverter : " );        
		List<ACDCConverter> collection  = new ArrayList<>();

		try {
			// call the static get method on the ACDCConverterBusinessDelegate
			collection = ACDCConverterBusinessDelegate.getACDCConverterInstance().getAllACDCConverter();
			assertNotNull( collection, "An Empty collection of ACDCConverter was incorrectly returned.");
			
			// Now print out the values
			ACDCConverter entity = null;            
			Iterator<ACDCConverter> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getACDCConverterId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ACDCConverterTest
	 */
	protected ACDCConverterTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ACDCConverter
	 * 
	 * @return CreateACDCConverterCommand alias
	 */
	protected CreateACDCConverterCommand generateNewCommand() {
        CreateACDCConverterCommand command = new CreateACDCConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ACDCConverter
		 * 
		 * @return UpdateACDCConverterCommand alias
		 */
	protected UpdateACDCConverterCommand generateUpdateCommand() {
	        UpdateACDCConverterCommand command = new UpdateACDCConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID aCDCConverterId = null;
	protected ACDCConverterSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ACDCConverterTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfACDCConverterList = 0;
}
