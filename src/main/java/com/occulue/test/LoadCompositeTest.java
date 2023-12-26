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
 * Test LoadComposite class.
 *
 * @author your_name_here
 */
public class LoadCompositeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public LoadCompositeTest() {
		subscriber = new LoadCompositeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate LoadCompositeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on LoadComposite...");
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
	 * jumpstart the process by instantiating2 LoadComposite
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		loadCompositeId = LoadCompositeBusinessDelegate.getLoadCompositeInstance()
		.createLoadComposite( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		LoadCompositeBusinessDelegate.getLoadCompositeInstance()
				.createLoadComposite( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.loadCompositeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for LoadComposite : " + successValue.getLoadCompositeId());
							  if (successValue.getLoadCompositeId().equals(loadCompositeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfLoadCompositeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("LoadComposite test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadComposite consumed")
					);
			subscriber.loadCompositeSubscribe( loadCompositeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for LoadComposite : " + successValue.getLoadCompositeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfLoadCompositeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on loadComposite for loadCompositeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a LoadComposite. 
	 */
	protected LoadComposite read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created LoadComposite" );

		LoadComposite entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read LoadComposite with primary key" );
		msg.append( loadCompositeId );
		
		LoadCompositeFetchOneSummary fetchOneSummary = new LoadCompositeFetchOneSummary( loadCompositeId );

		try {
			entity = LoadCompositeBusinessDelegate.getLoadCompositeInstance().getLoadComposite( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found LoadComposite " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a LoadComposite.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a LoadComposite." );

		StringBuilder msg = new StringBuilder( "Failed to update a LoadComposite : " );        
		LoadComposite entity = read();
		UpdateLoadCompositeCommand command = generateUpdateCommand();
		command.setLoadCompositeId(entity.getLoadCompositeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created LoadComposite." );

			// for use later on...
			loadCompositeId = entity.getLoadCompositeId();

			LoadCompositeBusinessDelegate proxy = LoadCompositeBusinessDelegate.getLoadCompositeInstance();  

			proxy.updateLoadComposite( command ).get();

			LOGGER.info( "-- Successfully saved LoadComposite - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + loadCompositeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a LoadComposite.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created LoadComposite." );

		LoadComposite entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read LoadComposite with id " + loadCompositeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read LoadComposite with id " + loadCompositeId );

			throw e;
		}

		try{
			LoadCompositeBusinessDelegate.getLoadCompositeInstance().delete( new DeleteLoadCompositeCommand( entity.getLoadCompositeId() ) ).get();
			LOGGER.info( "-- Successfully deleted LoadComposite with id " + loadCompositeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete LoadComposite with id " + loadCompositeId );

			throw e;
		}
	}

	/**
	 * get all LoadComposites.
	 */
	protected List<LoadComposite> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of LoadComposites:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all LoadComposite : " );        
		List<LoadComposite> collection  = new ArrayList<>();

		try {
			// call the static get method on the LoadCompositeBusinessDelegate
			collection = LoadCompositeBusinessDelegate.getLoadCompositeInstance().getAllLoadComposite();
			assertNotNull( collection, "An Empty collection of LoadComposite was incorrectly returned.");
			
			// Now print out the values
			LoadComposite entity = null;            
			Iterator<LoadComposite> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getLoadCompositeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		LoadCompositeTest
	 */
	protected LoadCompositeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated LoadComposite
	 * 
	 * @return CreateLoadCompositeCommand alias
	 */
	protected CreateLoadCompositeCommand generateNewCommand() {
        CreateLoadCompositeCommand command = new CreateLoadCompositeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated LoadComposite
		 * 
		 * @return UpdateLoadCompositeCommand alias
		 */
	protected UpdateLoadCompositeCommand generateUpdateCommand() {
	        UpdateLoadCompositeCommand command = new UpdateLoadCompositeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID loadCompositeId = null;
	protected LoadCompositeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(LoadCompositeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfLoadCompositeList = 0;
}
