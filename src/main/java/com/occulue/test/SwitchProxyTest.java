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
 * Test SwitchProxy class.
 *
 * @author your_name_here
 */
public class SwitchProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SwitchProxyTest() {
		subscriber = new SwitchProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SwitchProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SwitchProxy...");
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
	 * jumpstart the process by instantiating2 SwitchProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		switchProxyId = SwitchProxyBusinessDelegate.getSwitchProxyInstance()
		.createSwitchProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SwitchProxyBusinessDelegate.getSwitchProxyInstance()
				.createSwitchProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.switchProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SwitchProxy : " + successValue.getSwitchProxyId());
							  if (successValue.getSwitchProxyId().equals(switchProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSwitchProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SwitchProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchProxy consumed")
					);
			subscriber.switchProxySubscribe( switchProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SwitchProxy : " + successValue.getSwitchProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSwitchProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on switchProxy for switchProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SwitchProxy. 
	 */
	protected SwitchProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SwitchProxy" );

		SwitchProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SwitchProxy with primary key" );
		msg.append( switchProxyId );
		
		SwitchProxyFetchOneSummary fetchOneSummary = new SwitchProxyFetchOneSummary( switchProxyId );

		try {
			entity = SwitchProxyBusinessDelegate.getSwitchProxyInstance().getSwitchProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SwitchProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SwitchProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SwitchProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a SwitchProxy : " );        
		SwitchProxy entity = read();
		UpdateSwitchProxyCommand command = generateUpdateCommand();
		command.setSwitchProxyId(entity.getSwitchProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SwitchProxy." );

			// for use later on...
			switchProxyId = entity.getSwitchProxyId();

			SwitchProxyBusinessDelegate proxy = SwitchProxyBusinessDelegate.getSwitchProxyInstance();  

			proxy.updateSwitchProxy( command ).get();

			LOGGER.info( "-- Successfully saved SwitchProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + switchProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SwitchProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SwitchProxy." );

		SwitchProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SwitchProxy with id " + switchProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SwitchProxy with id " + switchProxyId );

			throw e;
		}

		try{
			SwitchProxyBusinessDelegate.getSwitchProxyInstance().delete( new DeleteSwitchProxyCommand( entity.getSwitchProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted SwitchProxy with id " + switchProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SwitchProxy with id " + switchProxyId );

			throw e;
		}
	}

	/**
	 * get all SwitchProxys.
	 */
	protected List<SwitchProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SwitchProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SwitchProxy : " );        
		List<SwitchProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the SwitchProxyBusinessDelegate
			collection = SwitchProxyBusinessDelegate.getSwitchProxyInstance().getAllSwitchProxy();
			assertNotNull( collection, "An Empty collection of SwitchProxy was incorrectly returned.");
			
			// Now print out the values
			SwitchProxy entity = null;            
			Iterator<SwitchProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSwitchProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SwitchProxyTest
	 */
	protected SwitchProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SwitchProxy
	 * 
	 * @return CreateSwitchProxyCommand alias
	 */
	protected CreateSwitchProxyCommand generateNewCommand() {
        CreateSwitchProxyCommand command = new CreateSwitchProxyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SwitchProxy
		 * 
		 * @return UpdateSwitchProxyCommand alias
		 */
	protected UpdateSwitchProxyCommand generateUpdateCommand() {
	        UpdateSwitchProxyCommand command = new UpdateSwitchProxyCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID switchProxyId = null;
	protected SwitchProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SwitchProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSwitchProxyList = 0;
}
