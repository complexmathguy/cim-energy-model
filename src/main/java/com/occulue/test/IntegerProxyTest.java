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
 * Test IntegerProxy class.
 *
 * @author your_name_here
 */
public class IntegerProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public IntegerProxyTest() {
		subscriber = new IntegerProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate IntegerProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on IntegerProxy...");
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
	 * jumpstart the process by instantiating2 IntegerProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		integerProxyId = IntegerProxyBusinessDelegate.getIntegerProxyInstance()
		.createIntegerProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		IntegerProxyBusinessDelegate.getIntegerProxyInstance()
				.createIntegerProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.integerProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for IntegerProxy : " + successValue.getIntegerProxyId());
							  if (successValue.getIntegerProxyId().equals(integerProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfIntegerProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("IntegerProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on integerProxy consumed")
					);
			subscriber.integerProxySubscribe( integerProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for IntegerProxy : " + successValue.getIntegerProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfIntegerProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on integerProxy for integerProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a IntegerProxy. 
	 */
	protected IntegerProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created IntegerProxy" );

		IntegerProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read IntegerProxy with primary key" );
		msg.append( integerProxyId );
		
		IntegerProxyFetchOneSummary fetchOneSummary = new IntegerProxyFetchOneSummary( integerProxyId );

		try {
			entity = IntegerProxyBusinessDelegate.getIntegerProxyInstance().getIntegerProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found IntegerProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a IntegerProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a IntegerProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a IntegerProxy : " );        
		IntegerProxy entity = read();
		UpdateIntegerProxyCommand command = generateUpdateCommand();
		command.setIntegerProxyId(entity.getIntegerProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created IntegerProxy." );

			// for use later on...
			integerProxyId = entity.getIntegerProxyId();

			IntegerProxyBusinessDelegate proxy = IntegerProxyBusinessDelegate.getIntegerProxyInstance();  

			proxy.updateIntegerProxy( command ).get();

			LOGGER.info( "-- Successfully saved IntegerProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + integerProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a IntegerProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created IntegerProxy." );

		IntegerProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read IntegerProxy with id " + integerProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read IntegerProxy with id " + integerProxyId );

			throw e;
		}

		try{
			IntegerProxyBusinessDelegate.getIntegerProxyInstance().delete( new DeleteIntegerProxyCommand( entity.getIntegerProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted IntegerProxy with id " + integerProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete IntegerProxy with id " + integerProxyId );

			throw e;
		}
	}

	/**
	 * get all IntegerProxys.
	 */
	protected List<IntegerProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of IntegerProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all IntegerProxy : " );        
		List<IntegerProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the IntegerProxyBusinessDelegate
			collection = IntegerProxyBusinessDelegate.getIntegerProxyInstance().getAllIntegerProxy();
			assertNotNull( collection, "An Empty collection of IntegerProxy was incorrectly returned.");
			
			// Now print out the values
			IntegerProxy entity = null;            
			Iterator<IntegerProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getIntegerProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		IntegerProxyTest
	 */
	protected IntegerProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated IntegerProxy
	 * 
	 * @return CreateIntegerProxyCommand alias
	 */
	protected CreateIntegerProxyCommand generateNewCommand() {
        CreateIntegerProxyCommand command = new CreateIntegerProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated IntegerProxy
		 * 
		 * @return UpdateIntegerProxyCommand alias
		 */
	protected UpdateIntegerProxyCommand generateUpdateCommand() {
	        UpdateIntegerProxyCommand command = new UpdateIntegerProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID integerProxyId = null;
	protected IntegerProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(IntegerProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfIntegerProxyList = 0;
}
