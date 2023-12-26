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
 * Test DecimalProxy class.
 *
 * @author your_name_here
 */
public class DecimalProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DecimalProxyTest() {
		subscriber = new DecimalProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DecimalProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DecimalProxy...");
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
	 * jumpstart the process by instantiating2 DecimalProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		decimalProxyId = DecimalProxyBusinessDelegate.getDecimalProxyInstance()
		.createDecimalProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DecimalProxyBusinessDelegate.getDecimalProxyInstance()
				.createDecimalProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.decimalProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DecimalProxy : " + successValue.getDecimalProxyId());
							  if (successValue.getDecimalProxyId().equals(decimalProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDecimalProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DecimalProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on decimalProxy consumed")
					);
			subscriber.decimalProxySubscribe( decimalProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DecimalProxy : " + successValue.getDecimalProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDecimalProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on decimalProxy for decimalProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DecimalProxy. 
	 */
	protected DecimalProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DecimalProxy" );

		DecimalProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DecimalProxy with primary key" );
		msg.append( decimalProxyId );
		
		DecimalProxyFetchOneSummary fetchOneSummary = new DecimalProxyFetchOneSummary( decimalProxyId );

		try {
			entity = DecimalProxyBusinessDelegate.getDecimalProxyInstance().getDecimalProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DecimalProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DecimalProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DecimalProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a DecimalProxy : " );        
		DecimalProxy entity = read();
		UpdateDecimalProxyCommand command = generateUpdateCommand();
		command.setDecimalProxyId(entity.getDecimalProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DecimalProxy." );

			// for use later on...
			decimalProxyId = entity.getDecimalProxyId();

			DecimalProxyBusinessDelegate proxy = DecimalProxyBusinessDelegate.getDecimalProxyInstance();  

			proxy.updateDecimalProxy( command ).get();

			LOGGER.info( "-- Successfully saved DecimalProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + decimalProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DecimalProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DecimalProxy." );

		DecimalProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DecimalProxy with id " + decimalProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DecimalProxy with id " + decimalProxyId );

			throw e;
		}

		try{
			DecimalProxyBusinessDelegate.getDecimalProxyInstance().delete( new DeleteDecimalProxyCommand( entity.getDecimalProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted DecimalProxy with id " + decimalProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DecimalProxy with id " + decimalProxyId );

			throw e;
		}
	}

	/**
	 * get all DecimalProxys.
	 */
	protected List<DecimalProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DecimalProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DecimalProxy : " );        
		List<DecimalProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the DecimalProxyBusinessDelegate
			collection = DecimalProxyBusinessDelegate.getDecimalProxyInstance().getAllDecimalProxy();
			assertNotNull( collection, "An Empty collection of DecimalProxy was incorrectly returned.");
			
			// Now print out the values
			DecimalProxy entity = null;            
			Iterator<DecimalProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDecimalProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DecimalProxyTest
	 */
	protected DecimalProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DecimalProxy
	 * 
	 * @return CreateDecimalProxyCommand alias
	 */
	protected CreateDecimalProxyCommand generateNewCommand() {
        CreateDecimalProxyCommand command = new CreateDecimalProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DecimalProxy
		 * 
		 * @return UpdateDecimalProxyCommand alias
		 */
	protected UpdateDecimalProxyCommand generateUpdateCommand() {
	        UpdateDecimalProxyCommand command = new UpdateDecimalProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID decimalProxyId = null;
	protected DecimalProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DecimalProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDecimalProxyList = 0;
}
