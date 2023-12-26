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
 * Test DateProxy class.
 *
 * @author your_name_here
 */
public class DateProxyTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DateProxyTest() {
		subscriber = new DateProxySubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DateProxyTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DateProxy...");
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
	 * jumpstart the process by instantiating2 DateProxy
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dateProxyId = DateProxyBusinessDelegate.getDateProxyInstance()
		.createDateProxy( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DateProxyBusinessDelegate.getDateProxyInstance()
				.createDateProxy( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dateProxySubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DateProxy : " + successValue.getDateProxyId());
							  if (successValue.getDateProxyId().equals(dateProxyId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDateProxyList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DateProxy test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dateProxy consumed")
					);
			subscriber.dateProxySubscribe( dateProxyId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DateProxy : " + successValue.getDateProxyId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDateProxyList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dateProxy for dateProxyId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DateProxy. 
	 */
	protected DateProxy read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DateProxy" );

		DateProxy entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DateProxy with primary key" );
		msg.append( dateProxyId );
		
		DateProxyFetchOneSummary fetchOneSummary = new DateProxyFetchOneSummary( dateProxyId );

		try {
			entity = DateProxyBusinessDelegate.getDateProxyInstance().getDateProxy( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DateProxy " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DateProxy.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DateProxy." );

		StringBuilder msg = new StringBuilder( "Failed to update a DateProxy : " );        
		DateProxy entity = read();
		UpdateDateProxyCommand command = generateUpdateCommand();
		command.setDateProxyId(entity.getDateProxyId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DateProxy." );

			// for use later on...
			dateProxyId = entity.getDateProxyId();

			DateProxyBusinessDelegate proxy = DateProxyBusinessDelegate.getDateProxyInstance();  

			proxy.updateDateProxy( command ).get();

			LOGGER.info( "-- Successfully saved DateProxy - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dateProxyId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DateProxy.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DateProxy." );

		DateProxy entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DateProxy with id " + dateProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DateProxy with id " + dateProxyId );

			throw e;
		}

		try{
			DateProxyBusinessDelegate.getDateProxyInstance().delete( new DeleteDateProxyCommand( entity.getDateProxyId() ) ).get();
			LOGGER.info( "-- Successfully deleted DateProxy with id " + dateProxyId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DateProxy with id " + dateProxyId );

			throw e;
		}
	}

	/**
	 * get all DateProxys.
	 */
	protected List<DateProxy> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DateProxys:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DateProxy : " );        
		List<DateProxy> collection  = new ArrayList<>();

		try {
			// call the static get method on the DateProxyBusinessDelegate
			collection = DateProxyBusinessDelegate.getDateProxyInstance().getAllDateProxy();
			assertNotNull( collection, "An Empty collection of DateProxy was incorrectly returned.");
			
			// Now print out the values
			DateProxy entity = null;            
			Iterator<DateProxy> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDateProxyId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DateProxyTest
	 */
	protected DateProxyTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DateProxy
	 * 
	 * @return CreateDateProxyCommand alias
	 */
	protected CreateDateProxyCommand generateNewCommand() {
        CreateDateProxyCommand command = new CreateDateProxyCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DateProxy
		 * 
		 * @return UpdateDateProxyCommand alias
		 */
	protected UpdateDateProxyCommand generateUpdateCommand() {
	        UpdateDateProxyCommand command = new UpdateDateProxyCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dateProxyId = null;
	protected DateProxySubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DateProxyTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDateProxyList = 0;
}
