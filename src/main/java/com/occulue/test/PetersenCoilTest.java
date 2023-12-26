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
 * Test PetersenCoil class.
 *
 * @author your_name_here
 */
public class PetersenCoilTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PetersenCoilTest() {
		subscriber = new PetersenCoilSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PetersenCoilTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PetersenCoil...");
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
	 * jumpstart the process by instantiating2 PetersenCoil
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		petersenCoilId = PetersenCoilBusinessDelegate.getPetersenCoilInstance()
		.createPetersenCoil( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PetersenCoilBusinessDelegate.getPetersenCoilInstance()
				.createPetersenCoil( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.petersenCoilSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PetersenCoil : " + successValue.getPetersenCoilId());
							  if (successValue.getPetersenCoilId().equals(petersenCoilId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPetersenCoilList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PetersenCoil test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on petersenCoil consumed")
					);
			subscriber.petersenCoilSubscribe( petersenCoilId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PetersenCoil : " + successValue.getPetersenCoilId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPetersenCoilList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on petersenCoil for petersenCoilId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PetersenCoil. 
	 */
	protected PetersenCoil read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PetersenCoil" );

		PetersenCoil entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PetersenCoil with primary key" );
		msg.append( petersenCoilId );
		
		PetersenCoilFetchOneSummary fetchOneSummary = new PetersenCoilFetchOneSummary( petersenCoilId );

		try {
			entity = PetersenCoilBusinessDelegate.getPetersenCoilInstance().getPetersenCoil( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PetersenCoil " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PetersenCoil.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PetersenCoil." );

		StringBuilder msg = new StringBuilder( "Failed to update a PetersenCoil : " );        
		PetersenCoil entity = read();
		UpdatePetersenCoilCommand command = generateUpdateCommand();
		command.setPetersenCoilId(entity.getPetersenCoilId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PetersenCoil." );

			// for use later on...
			petersenCoilId = entity.getPetersenCoilId();

			PetersenCoilBusinessDelegate proxy = PetersenCoilBusinessDelegate.getPetersenCoilInstance();  

			proxy.updatePetersenCoil( command ).get();

			LOGGER.info( "-- Successfully saved PetersenCoil - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + petersenCoilId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PetersenCoil.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PetersenCoil." );

		PetersenCoil entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PetersenCoil with id " + petersenCoilId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PetersenCoil with id " + petersenCoilId );

			throw e;
		}

		try{
			PetersenCoilBusinessDelegate.getPetersenCoilInstance().delete( new DeletePetersenCoilCommand( entity.getPetersenCoilId() ) ).get();
			LOGGER.info( "-- Successfully deleted PetersenCoil with id " + petersenCoilId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PetersenCoil with id " + petersenCoilId );

			throw e;
		}
	}

	/**
	 * get all PetersenCoils.
	 */
	protected List<PetersenCoil> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PetersenCoils:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PetersenCoil : " );        
		List<PetersenCoil> collection  = new ArrayList<>();

		try {
			// call the static get method on the PetersenCoilBusinessDelegate
			collection = PetersenCoilBusinessDelegate.getPetersenCoilInstance().getAllPetersenCoil();
			assertNotNull( collection, "An Empty collection of PetersenCoil was incorrectly returned.");
			
			// Now print out the values
			PetersenCoil entity = null;            
			Iterator<PetersenCoil> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPetersenCoilId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PetersenCoilTest
	 */
	protected PetersenCoilTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PetersenCoil
	 * 
	 * @return CreatePetersenCoilCommand alias
	 */
	protected CreatePetersenCoilCommand generateNewCommand() {
        CreatePetersenCoilCommand command = new CreatePetersenCoilCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PetersenCoil
		 * 
		 * @return UpdatePetersenCoilCommand alias
		 */
	protected UpdatePetersenCoilCommand generateUpdateCommand() {
	        UpdatePetersenCoilCommand command = new UpdatePetersenCoilCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID petersenCoilId = null;
	protected PetersenCoilSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PetersenCoilTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPetersenCoilList = 0;
}
