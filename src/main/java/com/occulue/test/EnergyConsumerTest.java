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
 * Test EnergyConsumer class.
 *
 * @author your_name_here
 */
public class EnergyConsumerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EnergyConsumerTest() {
		subscriber = new EnergyConsumerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EnergyConsumerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EnergyConsumer...");
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
	 * jumpstart the process by instantiating2 EnergyConsumer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		energyConsumerId = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance()
		.createEnergyConsumer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EnergyConsumerBusinessDelegate.getEnergyConsumerInstance()
				.createEnergyConsumer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.energyConsumerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EnergyConsumer : " + successValue.getEnergyConsumerId());
							  if (successValue.getEnergyConsumerId().equals(energyConsumerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEnergyConsumerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EnergyConsumer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energyConsumer consumed")
					);
			subscriber.energyConsumerSubscribe( energyConsumerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EnergyConsumer : " + successValue.getEnergyConsumerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEnergyConsumerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energyConsumer for energyConsumerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EnergyConsumer. 
	 */
	protected EnergyConsumer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EnergyConsumer" );

		EnergyConsumer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EnergyConsumer with primary key" );
		msg.append( energyConsumerId );
		
		EnergyConsumerFetchOneSummary fetchOneSummary = new EnergyConsumerFetchOneSummary( energyConsumerId );

		try {
			entity = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().getEnergyConsumer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EnergyConsumer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EnergyConsumer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EnergyConsumer." );

		StringBuilder msg = new StringBuilder( "Failed to update a EnergyConsumer : " );        
		EnergyConsumer entity = read();
		UpdateEnergyConsumerCommand command = generateUpdateCommand();
		command.setEnergyConsumerId(entity.getEnergyConsumerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EnergyConsumer." );

			// for use later on...
			energyConsumerId = entity.getEnergyConsumerId();

			EnergyConsumerBusinessDelegate proxy = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();  

			proxy.updateEnergyConsumer( command ).get();

			LOGGER.info( "-- Successfully saved EnergyConsumer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + energyConsumerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EnergyConsumer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EnergyConsumer." );

		EnergyConsumer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EnergyConsumer with id " + energyConsumerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EnergyConsumer with id " + energyConsumerId );

			throw e;
		}

		try{
			EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().delete( new DeleteEnergyConsumerCommand( entity.getEnergyConsumerId() ) ).get();
			LOGGER.info( "-- Successfully deleted EnergyConsumer with id " + energyConsumerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EnergyConsumer with id " + energyConsumerId );

			throw e;
		}
	}

	/**
	 * get all EnergyConsumers.
	 */
	protected List<EnergyConsumer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EnergyConsumers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EnergyConsumer : " );        
		List<EnergyConsumer> collection  = new ArrayList<>();

		try {
			// call the static get method on the EnergyConsumerBusinessDelegate
			collection = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().getAllEnergyConsumer();
			assertNotNull( collection, "An Empty collection of EnergyConsumer was incorrectly returned.");
			
			// Now print out the values
			EnergyConsumer entity = null;            
			Iterator<EnergyConsumer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEnergyConsumerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EnergyConsumerTest
	 */
	protected EnergyConsumerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EnergyConsumer
	 * 
	 * @return CreateEnergyConsumerCommand alias
	 */
	protected CreateEnergyConsumerCommand generateNewCommand() {
        CreateEnergyConsumerCommand command = new CreateEnergyConsumerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated EnergyConsumer
		 * 
		 * @return UpdateEnergyConsumerCommand alias
		 */
	protected UpdateEnergyConsumerCommand generateUpdateCommand() {
	        UpdateEnergyConsumerCommand command = new UpdateEnergyConsumerCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID energyConsumerId = null;
	protected EnergyConsumerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EnergyConsumerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEnergyConsumerList = 0;
}
