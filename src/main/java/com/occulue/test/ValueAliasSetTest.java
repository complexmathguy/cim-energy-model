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
 * Test ValueAliasSet class.
 *
 * @author your_name_here
 */
public class ValueAliasSetTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ValueAliasSetTest() {
		subscriber = new ValueAliasSetSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ValueAliasSetTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ValueAliasSet...");
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
	 * jumpstart the process by instantiating2 ValueAliasSet
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		valueAliasSetId = ValueAliasSetBusinessDelegate.getValueAliasSetInstance()
		.createValueAliasSet( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ValueAliasSetBusinessDelegate.getValueAliasSetInstance()
				.createValueAliasSet( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.valueAliasSetSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ValueAliasSet : " + successValue.getValueAliasSetId());
							  if (successValue.getValueAliasSetId().equals(valueAliasSetId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfValueAliasSetList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ValueAliasSet test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on valueAliasSet consumed")
					);
			subscriber.valueAliasSetSubscribe( valueAliasSetId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ValueAliasSet : " + successValue.getValueAliasSetId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfValueAliasSetList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on valueAliasSet for valueAliasSetId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ValueAliasSet. 
	 */
	protected ValueAliasSet read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ValueAliasSet" );

		ValueAliasSet entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ValueAliasSet with primary key" );
		msg.append( valueAliasSetId );
		
		ValueAliasSetFetchOneSummary fetchOneSummary = new ValueAliasSetFetchOneSummary( valueAliasSetId );

		try {
			entity = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().getValueAliasSet( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ValueAliasSet " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ValueAliasSet.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ValueAliasSet." );

		StringBuilder msg = new StringBuilder( "Failed to update a ValueAliasSet : " );        
		ValueAliasSet entity = read();
		UpdateValueAliasSetCommand command = generateUpdateCommand();
		command.setValueAliasSetId(entity.getValueAliasSetId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ValueAliasSet." );

			// for use later on...
			valueAliasSetId = entity.getValueAliasSetId();

			ValueAliasSetBusinessDelegate proxy = ValueAliasSetBusinessDelegate.getValueAliasSetInstance();  

			proxy.updateValueAliasSet( command ).get();

			LOGGER.info( "-- Successfully saved ValueAliasSet - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + valueAliasSetId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ValueAliasSet.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ValueAliasSet." );

		ValueAliasSet entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ValueAliasSet with id " + valueAliasSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ValueAliasSet with id " + valueAliasSetId );

			throw e;
		}

		try{
			ValueAliasSetBusinessDelegate.getValueAliasSetInstance().delete( new DeleteValueAliasSetCommand( entity.getValueAliasSetId() ) ).get();
			LOGGER.info( "-- Successfully deleted ValueAliasSet with id " + valueAliasSetId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ValueAliasSet with id " + valueAliasSetId );

			throw e;
		}
	}

	/**
	 * get all ValueAliasSets.
	 */
	protected List<ValueAliasSet> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ValueAliasSets:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ValueAliasSet : " );        
		List<ValueAliasSet> collection  = new ArrayList<>();

		try {
			// call the static get method on the ValueAliasSetBusinessDelegate
			collection = ValueAliasSetBusinessDelegate.getValueAliasSetInstance().getAllValueAliasSet();
			assertNotNull( collection, "An Empty collection of ValueAliasSet was incorrectly returned.");
			
			// Now print out the values
			ValueAliasSet entity = null;            
			Iterator<ValueAliasSet> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getValueAliasSetId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ValueAliasSetTest
	 */
	protected ValueAliasSetTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ValueAliasSet
	 * 
	 * @return CreateValueAliasSetCommand alias
	 */
	protected CreateValueAliasSetCommand generateNewCommand() {
        CreateValueAliasSetCommand command = new CreateValueAliasSetCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ValueAliasSet
		 * 
		 * @return UpdateValueAliasSetCommand alias
		 */
	protected UpdateValueAliasSetCommand generateUpdateCommand() {
	        UpdateValueAliasSetCommand command = new UpdateValueAliasSetCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID valueAliasSetId = null;
	protected ValueAliasSetSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ValueAliasSetTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfValueAliasSetList = 0;
}
