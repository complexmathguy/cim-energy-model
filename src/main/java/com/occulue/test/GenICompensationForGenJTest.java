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
 * Test GenICompensationForGenJ class.
 *
 * @author your_name_here
 */
public class GenICompensationForGenJTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public GenICompensationForGenJTest() {
		subscriber = new GenICompensationForGenJSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate GenICompensationForGenJTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on GenICompensationForGenJ...");
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
	 * jumpstart the process by instantiating2 GenICompensationForGenJ
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		genICompensationForGenJId = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
		.createGenICompensationForGenJ( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance()
				.createGenICompensationForGenJ( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.genICompensationForGenJSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for GenICompensationForGenJ : " + successValue.getGenICompensationForGenJId());
							  if (successValue.getGenICompensationForGenJId().equals(genICompensationForGenJId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfGenICompensationForGenJList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("GenICompensationForGenJ test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on genICompensationForGenJ consumed")
					);
			subscriber.genICompensationForGenJSubscribe( genICompensationForGenJId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for GenICompensationForGenJ : " + successValue.getGenICompensationForGenJId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfGenICompensationForGenJList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on genICompensationForGenJ for genICompensationForGenJId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a GenICompensationForGenJ. 
	 */
	protected GenICompensationForGenJ read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created GenICompensationForGenJ" );

		GenICompensationForGenJ entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read GenICompensationForGenJ with primary key" );
		msg.append( genICompensationForGenJId );
		
		GenICompensationForGenJFetchOneSummary fetchOneSummary = new GenICompensationForGenJFetchOneSummary( genICompensationForGenJId );

		try {
			entity = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().getGenICompensationForGenJ( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found GenICompensationForGenJ " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a GenICompensationForGenJ.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a GenICompensationForGenJ." );

		StringBuilder msg = new StringBuilder( "Failed to update a GenICompensationForGenJ : " );        
		GenICompensationForGenJ entity = read();
		UpdateGenICompensationForGenJCommand command = generateUpdateCommand();
		command.setGenICompensationForGenJId(entity.getGenICompensationForGenJId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created GenICompensationForGenJ." );

			// for use later on...
			genICompensationForGenJId = entity.getGenICompensationForGenJId();

			GenICompensationForGenJBusinessDelegate proxy = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance();  

			proxy.updateGenICompensationForGenJ( command ).get();

			LOGGER.info( "-- Successfully saved GenICompensationForGenJ - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + genICompensationForGenJId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a GenICompensationForGenJ.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created GenICompensationForGenJ." );

		GenICompensationForGenJ entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read GenICompensationForGenJ with id " + genICompensationForGenJId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read GenICompensationForGenJ with id " + genICompensationForGenJId );

			throw e;
		}

		try{
			GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().delete( new DeleteGenICompensationForGenJCommand( entity.getGenICompensationForGenJId() ) ).get();
			LOGGER.info( "-- Successfully deleted GenICompensationForGenJ with id " + genICompensationForGenJId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete GenICompensationForGenJ with id " + genICompensationForGenJId );

			throw e;
		}
	}

	/**
	 * get all GenICompensationForGenJs.
	 */
	protected List<GenICompensationForGenJ> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of GenICompensationForGenJs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all GenICompensationForGenJ : " );        
		List<GenICompensationForGenJ> collection  = new ArrayList<>();

		try {
			// call the static get method on the GenICompensationForGenJBusinessDelegate
			collection = GenICompensationForGenJBusinessDelegate.getGenICompensationForGenJInstance().getAllGenICompensationForGenJ();
			assertNotNull( collection, "An Empty collection of GenICompensationForGenJ was incorrectly returned.");
			
			// Now print out the values
			GenICompensationForGenJ entity = null;            
			Iterator<GenICompensationForGenJ> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getGenICompensationForGenJId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		GenICompensationForGenJTest
	 */
	protected GenICompensationForGenJTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated GenICompensationForGenJ
	 * 
	 * @return CreateGenICompensationForGenJCommand alias
	 */
	protected CreateGenICompensationForGenJCommand generateNewCommand() {
        CreateGenICompensationForGenJCommand command = new CreateGenICompensationForGenJCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated GenICompensationForGenJ
		 * 
		 * @return UpdateGenICompensationForGenJCommand alias
		 */
	protected UpdateGenICompensationForGenJCommand generateUpdateCommand() {
	        UpdateGenICompensationForGenJCommand command = new UpdateGenICompensationForGenJCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID genICompensationForGenJId = null;
	protected GenICompensationForGenJSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(GenICompensationForGenJTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfGenICompensationForGenJList = 0;
}
