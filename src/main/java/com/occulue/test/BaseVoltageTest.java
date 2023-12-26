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
 * Test BaseVoltage class.
 *
 * @author your_name_here
 */
public class BaseVoltageTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BaseVoltageTest() {
		subscriber = new BaseVoltageSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BaseVoltageTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BaseVoltage...");
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
	 * jumpstart the process by instantiating2 BaseVoltage
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		baseVoltageId = BaseVoltageBusinessDelegate.getBaseVoltageInstance()
		.createBaseVoltage( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BaseVoltageBusinessDelegate.getBaseVoltageInstance()
				.createBaseVoltage( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.baseVoltageSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BaseVoltage : " + successValue.getBaseVoltageId());
							  if (successValue.getBaseVoltageId().equals(baseVoltageId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBaseVoltageList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BaseVoltage test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on baseVoltage consumed")
					);
			subscriber.baseVoltageSubscribe( baseVoltageId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BaseVoltage : " + successValue.getBaseVoltageId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBaseVoltageList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on baseVoltage for baseVoltageId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BaseVoltage. 
	 */
	protected BaseVoltage read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BaseVoltage" );

		BaseVoltage entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BaseVoltage with primary key" );
		msg.append( baseVoltageId );
		
		BaseVoltageFetchOneSummary fetchOneSummary = new BaseVoltageFetchOneSummary( baseVoltageId );

		try {
			entity = BaseVoltageBusinessDelegate.getBaseVoltageInstance().getBaseVoltage( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BaseVoltage " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BaseVoltage.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BaseVoltage." );

		StringBuilder msg = new StringBuilder( "Failed to update a BaseVoltage : " );        
		BaseVoltage entity = read();
		UpdateBaseVoltageCommand command = generateUpdateCommand();
		command.setBaseVoltageId(entity.getBaseVoltageId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BaseVoltage." );

			// for use later on...
			baseVoltageId = entity.getBaseVoltageId();

			BaseVoltageBusinessDelegate proxy = BaseVoltageBusinessDelegate.getBaseVoltageInstance();  

			proxy.updateBaseVoltage( command ).get();

			LOGGER.info( "-- Successfully saved BaseVoltage - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + baseVoltageId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BaseVoltage.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BaseVoltage." );

		BaseVoltage entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BaseVoltage with id " + baseVoltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BaseVoltage with id " + baseVoltageId );

			throw e;
		}

		try{
			BaseVoltageBusinessDelegate.getBaseVoltageInstance().delete( new DeleteBaseVoltageCommand( entity.getBaseVoltageId() ) ).get();
			LOGGER.info( "-- Successfully deleted BaseVoltage with id " + baseVoltageId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BaseVoltage with id " + baseVoltageId );

			throw e;
		}
	}

	/**
	 * get all BaseVoltages.
	 */
	protected List<BaseVoltage> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BaseVoltages:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BaseVoltage : " );        
		List<BaseVoltage> collection  = new ArrayList<>();

		try {
			// call the static get method on the BaseVoltageBusinessDelegate
			collection = BaseVoltageBusinessDelegate.getBaseVoltageInstance().getAllBaseVoltage();
			assertNotNull( collection, "An Empty collection of BaseVoltage was incorrectly returned.");
			
			// Now print out the values
			BaseVoltage entity = null;            
			Iterator<BaseVoltage> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBaseVoltageId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BaseVoltageTest
	 */
	protected BaseVoltageTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BaseVoltage
	 * 
	 * @return CreateBaseVoltageCommand alias
	 */
	protected CreateBaseVoltageCommand generateNewCommand() {
        CreateBaseVoltageCommand command = new CreateBaseVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated BaseVoltage
		 * 
		 * @return UpdateBaseVoltageCommand alias
		 */
	protected UpdateBaseVoltageCommand generateUpdateCommand() {
	        UpdateBaseVoltageCommand command = new UpdateBaseVoltageCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID baseVoltageId = null;
	protected BaseVoltageSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BaseVoltageTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBaseVoltageList = 0;
}
