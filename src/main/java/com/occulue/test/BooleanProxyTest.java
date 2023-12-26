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
 * Test BooleanProxy class.
 *
 * @author your_name_here
 */
public class BooleanProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public BooleanProxyTest() {
		subscriber = new BooleanProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate BooleanProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on BooleanProxy...");
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
	 * jumpstart the process by instantiating2 BooleanProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		booleanProxyId = BooleanProxyBusinessDelegate.getBooleanProxyInstance()
		.createBooleanProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		BooleanProxyBusinessDelegate.getBooleanProxyInstance()
				.createBooleanProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.booleanProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for BooleanProxy : " + successValue.getBooleanProxyId());
							  if (successValue.getBooleanProxyId().equals(booleanProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfBooleanProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("BooleanProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on booleanProxy consumed")
					);
			subscriber.booleanProxySubscribe( booleanProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for BooleanProxy : " + successValue.getBooleanProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfBooleanProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on booleanProxy for booleanProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a BooleanProxy. 
	 */
	protected BooleanProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created BooleanProxy" );

		BooleanProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read BooleanProxy with primary key" );
		msg.append( booleanProxyId );
		
		BooleanProxyFetchOneSummary fetchOneSummary = new BooleanProxyFetchOneSummary( booleanProxyId );

		try {
			entity = BooleanProxyBusinessDelegate.getBooleanProxyInstance().getBooleanProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found BooleanProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a BooleanProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a BooleanProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a BooleanProxy : " );        
		BooleanProxy entity = read();
		UpdateBooleanProxyCommand command = generateUpdateCommand();
		command.setBooleanProxyId(entity.getBooleanProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created BooleanProxy." );

			// for use later on...
			booleanProxyId = entity.getBooleanProxyId();

			BooleanProxyBusinessDelegate proxy = BooleanProxyBusinessDelegate.getBooleanProxyInstance();  

			proxy.updateBooleanProxy( command ).get();

			LOGGER.info( "-- Successfully saved BooleanProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + booleanProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a BooleanProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created BooleanProxy." );

		BooleanProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read BooleanProxy with id " + booleanProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read BooleanProxy with id " + booleanProxyId );

			throw e;
		}

		try{
			BooleanProxyBusinessDelegate.getBooleanProxyInstance().delete( new DeleteBooleanProxyCommand( entity.getBooleanProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted BooleanProxy with id " + booleanProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete BooleanProxy with id " + booleanProxyId );

			throw e;
		}
	}

	/**
	 * get all BooleanProxys.
	 */
	protected List<BooleanProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of BooleanProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all BooleanProxy : " );        
		List<BooleanProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the BooleanProxyBusinessDelegate
			collection = BooleanProxyBusinessDelegate.getBooleanProxyInstance().getAllBooleanProxy();
			assertNotNull( collection, "An Empty collection of BooleanProxy was incorrectly returned.");
			
			// Now print out the values
			BooleanProxy entity = null;            
			Iterator<BooleanProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getBooleanProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		BooleanProxyTest
	 */
	protected BooleanProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated BooleanProxy
	 * 
	 * @return CreateBooleanProxyCommand alias
	 */
	protected CreateBooleanProxyCommand generateNewCommand() {
        CreateBooleanProxyCommand command = new CreateBooleanProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated BooleanProxy
		 * 
		 * @return UpdateBooleanProxyCommand alias
		 */
	protected UpdateBooleanProxyCommand generateUpdateCommand() {
	        UpdateBooleanProxyCommand command = new UpdateBooleanProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID booleanProxyId = null;
	protected BooleanProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(BooleanProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfBooleanProxyList = 0;
}
