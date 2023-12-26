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
 * Test FloatProxy class.
 *
 * @author your_name_here
 */
public class FloatProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public FloatProxyTest() {
		subscriber = new FloatProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate FloatProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on FloatProxy...");
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
	 * jumpstart the process by instantiating2 FloatProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		floatProxyId = FloatProxyBusinessDelegate.getFloatProxyInstance()
		.createFloatProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		FloatProxyBusinessDelegate.getFloatProxyInstance()
				.createFloatProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.floatProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for FloatProxy : " + successValue.getFloatProxyId());
							  if (successValue.getFloatProxyId().equals(floatProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfFloatProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("FloatProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on floatProxy consumed")
					);
			subscriber.floatProxySubscribe( floatProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for FloatProxy : " + successValue.getFloatProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfFloatProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on floatProxy for floatProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a FloatProxy. 
	 */
	protected FloatProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created FloatProxy" );

		FloatProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read FloatProxy with primary key" );
		msg.append( floatProxyId );
		
		FloatProxyFetchOneSummary fetchOneSummary = new FloatProxyFetchOneSummary( floatProxyId );

		try {
			entity = FloatProxyBusinessDelegate.getFloatProxyInstance().getFloatProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found FloatProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a FloatProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a FloatProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a FloatProxy : " );        
		FloatProxy entity = read();
		UpdateFloatProxyCommand command = generateUpdateCommand();
		command.setFloatProxyId(entity.getFloatProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created FloatProxy." );

			// for use later on...
			floatProxyId = entity.getFloatProxyId();

			FloatProxyBusinessDelegate proxy = FloatProxyBusinessDelegate.getFloatProxyInstance();  

			proxy.updateFloatProxy( command ).get();

			LOGGER.info( "-- Successfully saved FloatProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + floatProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a FloatProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created FloatProxy." );

		FloatProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read FloatProxy with id " + floatProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read FloatProxy with id " + floatProxyId );

			throw e;
		}

		try{
			FloatProxyBusinessDelegate.getFloatProxyInstance().delete( new DeleteFloatProxyCommand( entity.getFloatProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted FloatProxy with id " + floatProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete FloatProxy with id " + floatProxyId );

			throw e;
		}
	}

	/**
	 * get all FloatProxys.
	 */
	protected List<FloatProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of FloatProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all FloatProxy : " );        
		List<FloatProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the FloatProxyBusinessDelegate
			collection = FloatProxyBusinessDelegate.getFloatProxyInstance().getAllFloatProxy();
			assertNotNull( collection, "An Empty collection of FloatProxy was incorrectly returned.");
			
			// Now print out the values
			FloatProxy entity = null;            
			Iterator<FloatProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getFloatProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		FloatProxyTest
	 */
	protected FloatProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated FloatProxy
	 * 
	 * @return CreateFloatProxyCommand alias
	 */
	protected CreateFloatProxyCommand generateNewCommand() {
        CreateFloatProxyCommand command = new CreateFloatProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated FloatProxy
		 * 
		 * @return UpdateFloatProxyCommand alias
		 */
	protected UpdateFloatProxyCommand generateUpdateCommand() {
	        UpdateFloatProxyCommand command = new UpdateFloatProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID floatProxyId = null;
	protected FloatProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(FloatProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfFloatProxyList = 0;
}
