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
 * Test ValueToAlias class.
 *
 * @author your_name_here
 */
public class ValueToAliasTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ValueToAliasTest() {
		subscriber = new ValueToAliasSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ValueToAliasTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ValueToAlias...");
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
	 * jumpstart the process by instantiating2 ValueToAlias
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		valueToAliasId = ValueToAliasBusinessDelegate.getValueToAliasInstance()
		.createValueToAlias( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ValueToAliasBusinessDelegate.getValueToAliasInstance()
				.createValueToAlias( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.valueToAliasSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ValueToAlias : " + successValue.getValueToAliasId());
							  if (successValue.getValueToAliasId().equals(valueToAliasId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfValueToAliasList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ValueToAlias test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on valueToAlias consumed")
					);
			subscriber.valueToAliasSubscribe( valueToAliasId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ValueToAlias : " + successValue.getValueToAliasId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfValueToAliasList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on valueToAlias for valueToAliasId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ValueToAlias. 
	 */
	protected ValueToAlias read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ValueToAlias" );

		ValueToAlias entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ValueToAlias with primary key" );
		msg.append( valueToAliasId );
		
		ValueToAliasFetchOneSummary fetchOneSummary = new ValueToAliasFetchOneSummary( valueToAliasId );

		try {
			entity = ValueToAliasBusinessDelegate.getValueToAliasInstance().getValueToAlias( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ValueToAlias " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ValueToAlias.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ValueToAlias." );

		StringBuilder msg = new StringBuilder( "Failed to update a ValueToAlias : " );        
		ValueToAlias entity = read();
		UpdateValueToAliasCommand command = generateUpdateCommand();
		command.setValueToAliasId(entity.getValueToAliasId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ValueToAlias." );

			// for use later on...
			valueToAliasId = entity.getValueToAliasId();

			ValueToAliasBusinessDelegate proxy = ValueToAliasBusinessDelegate.getValueToAliasInstance();  

			proxy.updateValueToAlias( command ).get();

			LOGGER.info( "-- Successfully saved ValueToAlias - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + valueToAliasId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ValueToAlias.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ValueToAlias." );

		ValueToAlias entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ValueToAlias with id " + valueToAliasId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ValueToAlias with id " + valueToAliasId );

			throw e;
		}

		try{
			ValueToAliasBusinessDelegate.getValueToAliasInstance().delete( new DeleteValueToAliasCommand( entity.getValueToAliasId() ) ).get();
			LOGGER.info( "-- Successfully deleted ValueToAlias with id " + valueToAliasId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ValueToAlias with id " + valueToAliasId );

			throw e;
		}
	}

	/**
	 * get all ValueToAliass.
	 */
	protected List<ValueToAlias> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ValueToAliass:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ValueToAlias : " );        
		List<ValueToAlias> collection  = new ArrayList<>();

		try {
			// call the static get method on the ValueToAliasBusinessDelegate
			collection = ValueToAliasBusinessDelegate.getValueToAliasInstance().getAllValueToAlias();
			assertNotNull( collection, "An Empty collection of ValueToAlias was incorrectly returned.");
			
			// Now print out the values
			ValueToAlias entity = null;            
			Iterator<ValueToAlias> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getValueToAliasId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ValueToAliasTest
	 */
	protected ValueToAliasTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ValueToAlias
	 * 
	 * @return CreateValueToAliasCommand alias
	 */
	protected CreateValueToAliasCommand generateNewCommand() {
        CreateValueToAliasCommand command = new CreateValueToAliasCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ValueToAlias
		 * 
		 * @return UpdateValueToAliasCommand alias
		 */
	protected UpdateValueToAliasCommand generateUpdateCommand() {
	        UpdateValueToAliasCommand command = new UpdateValueToAliasCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID valueToAliasId = null;
	protected ValueToAliasSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ValueToAliasTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfValueToAliasList = 0;
}
