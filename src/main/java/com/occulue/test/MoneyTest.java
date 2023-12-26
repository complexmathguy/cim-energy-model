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
 * Test Money class.
 *
 * @author your_name_here
 */
public class MoneyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public MoneyTest() {
		subscriber = new MoneySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate MoneyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Money...");
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
	 * jumpstart the process by instantiating2 Money
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		moneyId = MoneyBusinessDelegate.getMoneyInstance()
		.createMoney( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		MoneyBusinessDelegate.getMoneyInstance()
				.createMoney( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.moneySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Money : " + successValue.getMoneyId());
							  if (successValue.getMoneyId().equals(moneyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfMoneyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Money test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on money consumed")
					);
			subscriber.moneySubscribe( moneyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Money : " + successValue.getMoneyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfMoneyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on money for moneyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Money. 
	 */
	protected Money read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Money" );

		Money entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Money with primary key" );
		msg.append( moneyId );
		
		MoneyFetchOneSummary fetchOneSummary = new MoneyFetchOneSummary( moneyId );

		try {
			entity = MoneyBusinessDelegate.getMoneyInstance().getMoney( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Money " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Money.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Money." );

		StringBuilder msg = new StringBuilder( "Failed to update a Money : " );        
		Money entity = read();
		UpdateMoneyCommand command = generateUpdateCommand();
		command.setMoneyId(entity.getMoneyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Money." );

			// for use later on...
			moneyId = entity.getMoneyId();

			MoneyBusinessDelegate proxy = MoneyBusinessDelegate.getMoneyInstance();  

			proxy.updateMoney( command ).get();

			LOGGER.info( "-- Successfully saved Money - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + moneyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Money.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Money." );

		Money entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Money with id " + moneyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Money with id " + moneyId );

			throw e;
		}

		try{
			MoneyBusinessDelegate.getMoneyInstance().delete( new DeleteMoneyCommand( entity.getMoneyId() ) ).get();
			LOGGER.info( "-- Successfully deleted Money with id " + moneyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Money with id " + moneyId );

			throw e;
		}
	}

	/**
	 * get all Moneys.
	 */
	protected List<Money> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Moneys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Money : " );        
		List<Money> collection  = new ArrayList<>();

		try {
			// call the static get method on the MoneyBusinessDelegate
			collection = MoneyBusinessDelegate.getMoneyInstance().getAllMoney();
			assertNotNull( collection, "An Empty collection of Money was incorrectly returned.");
			
			// Now print out the values
			Money entity = null;            
			Iterator<Money> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getMoneyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		MoneyTest
	 */
	protected MoneyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Money
	 * 
	 * @return CreateMoneyCommand alias
	 */
	protected CreateMoneyCommand generateNewCommand() {
        CreateMoneyCommand command = new CreateMoneyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Money
		 * 
		 * @return UpdateMoneyCommand alias
		 */
	protected UpdateMoneyCommand generateUpdateCommand() {
	        UpdateMoneyCommand command = new UpdateMoneyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID moneyId = null;
	protected MoneySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(MoneyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfMoneyList = 0;
}
