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
 * Test Unresolvedname class.
 *
 * @author your_name_here
 */
public class UnresolvednameTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public UnresolvednameTest() {
		subscriber = new UnresolvednameSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate UnresolvednameTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Unresolvedname...");
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
	 * jumpstart the process by instantiating2 Unresolvedname
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		unresolvednameId = UnresolvednameBusinessDelegate.getUnresolvednameInstance()
		.createUnresolvedname( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		UnresolvednameBusinessDelegate.getUnresolvednameInstance()
				.createUnresolvedname( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.unresolvednameSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Unresolvedname : " + successValue.getUnresolvednameId());
							  if (successValue.getUnresolvednameId().equals(unresolvednameId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfUnresolvednameList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Unresolvedname test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on unresolvedname consumed")
					);
			subscriber.unresolvednameSubscribe( unresolvednameId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Unresolvedname : " + successValue.getUnresolvednameId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfUnresolvednameList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on unresolvedname for unresolvednameId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Unresolvedname. 
	 */
	protected Unresolvedname read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Unresolvedname" );

		Unresolvedname entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Unresolvedname with primary key" );
		msg.append( unresolvednameId );
		
		UnresolvednameFetchOneSummary fetchOneSummary = new UnresolvednameFetchOneSummary( unresolvednameId );

		try {
			entity = UnresolvednameBusinessDelegate.getUnresolvednameInstance().getUnresolvedname( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Unresolvedname " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Unresolvedname.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Unresolvedname." );

		StringBuilder msg = new StringBuilder( "Failed to update a Unresolvedname : " );        
		Unresolvedname entity = read();
		UpdateUnresolvednameCommand command = generateUpdateCommand();
		command.setUnresolvednameId(entity.getUnresolvednameId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Unresolvedname." );

			// for use later on...
			unresolvednameId = entity.getUnresolvednameId();

			UnresolvednameBusinessDelegate proxy = UnresolvednameBusinessDelegate.getUnresolvednameInstance();  

			proxy.updateUnresolvedname( command ).get();

			LOGGER.info( "-- Successfully saved Unresolvedname - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + unresolvednameId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Unresolvedname.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Unresolvedname." );

		Unresolvedname entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Unresolvedname with id " + unresolvednameId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Unresolvedname with id " + unresolvednameId );

			throw e;
		}

		try{
			UnresolvednameBusinessDelegate.getUnresolvednameInstance().delete( new DeleteUnresolvednameCommand( entity.getUnresolvednameId() ) ).get();
			LOGGER.info( "-- Successfully deleted Unresolvedname with id " + unresolvednameId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Unresolvedname with id " + unresolvednameId );

			throw e;
		}
	}

	/**
	 * get all Unresolvednames.
	 */
	protected List<Unresolvedname> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Unresolvednames:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Unresolvedname : " );        
		List<Unresolvedname> collection  = new ArrayList<>();

		try {
			// call the static get method on the UnresolvednameBusinessDelegate
			collection = UnresolvednameBusinessDelegate.getUnresolvednameInstance().getAllUnresolvedname();
			assertNotNull( collection, "An Empty collection of Unresolvedname was incorrectly returned.");
			
			// Now print out the values
			Unresolvedname entity = null;            
			Iterator<Unresolvedname> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getUnresolvednameId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		UnresolvednameTest
	 */
	protected UnresolvednameTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Unresolvedname
	 * 
	 * @return CreateUnresolvednameCommand alias
	 */
	protected CreateUnresolvednameCommand generateNewCommand() {
        CreateUnresolvednameCommand command = new CreateUnresolvednameCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated Unresolvedname
		 * 
		 * @return UpdateUnresolvednameCommand alias
		 */
	protected UpdateUnresolvednameCommand generateUpdateCommand() {
	        UpdateUnresolvednameCommand command = new UpdateUnresolvednameCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID unresolvednameId = null;
	protected UnresolvednameSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(UnresolvednameTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfUnresolvednameList = 0;
}
