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
 * Test StringProxy class.
 *
 * @author your_name_here
 */
public class StringProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public StringProxyTest() {
		subscriber = new StringProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate StringProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on StringProxy...");
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
	 * jumpstart the process by instantiating2 StringProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		stringProxyId = StringProxyBusinessDelegate.getStringProxyInstance()
		.createStringProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		StringProxyBusinessDelegate.getStringProxyInstance()
				.createStringProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.stringProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for StringProxy : " + successValue.getStringProxyId());
							  if (successValue.getStringProxyId().equals(stringProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfStringProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("StringProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringProxy consumed")
					);
			subscriber.stringProxySubscribe( stringProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for StringProxy : " + successValue.getStringProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfStringProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on stringProxy for stringProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a StringProxy. 
	 */
	protected StringProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created StringProxy" );

		StringProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read StringProxy with primary key" );
		msg.append( stringProxyId );
		
		StringProxyFetchOneSummary fetchOneSummary = new StringProxyFetchOneSummary( stringProxyId );

		try {
			entity = StringProxyBusinessDelegate.getStringProxyInstance().getStringProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found StringProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a StringProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a StringProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a StringProxy : " );        
		StringProxy entity = read();
		UpdateStringProxyCommand command = generateUpdateCommand();
		command.setStringProxyId(entity.getStringProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created StringProxy." );

			// for use later on...
			stringProxyId = entity.getStringProxyId();

			StringProxyBusinessDelegate proxy = StringProxyBusinessDelegate.getStringProxyInstance();  

			proxy.updateStringProxy( command ).get();

			LOGGER.info( "-- Successfully saved StringProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + stringProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a StringProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created StringProxy." );

		StringProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read StringProxy with id " + stringProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read StringProxy with id " + stringProxyId );

			throw e;
		}

		try{
			StringProxyBusinessDelegate.getStringProxyInstance().delete( new DeleteStringProxyCommand( entity.getStringProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted StringProxy with id " + stringProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete StringProxy with id " + stringProxyId );

			throw e;
		}
	}

	/**
	 * get all StringProxys.
	 */
	protected List<StringProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of StringProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all StringProxy : " );        
		List<StringProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the StringProxyBusinessDelegate
			collection = StringProxyBusinessDelegate.getStringProxyInstance().getAllStringProxy();
			assertNotNull( collection, "An Empty collection of StringProxy was incorrectly returned.");
			
			// Now print out the values
			StringProxy entity = null;            
			Iterator<StringProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getStringProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		StringProxyTest
	 */
	protected StringProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated StringProxy
	 * 
	 * @return CreateStringProxyCommand alias
	 */
	protected CreateStringProxyCommand generateNewCommand() {
        CreateStringProxyCommand command = new CreateStringProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated StringProxy
		 * 
		 * @return UpdateStringProxyCommand alias
		 */
	protected UpdateStringProxyCommand generateUpdateCommand() {
	        UpdateStringProxyCommand command = new UpdateStringProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID stringProxyId = null;
	protected StringProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(StringProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfStringProxyList = 0;
}
