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
 * Test Simple_Float class.
 *
 * @author your_name_here
 */
public class Simple_FloatTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public Simple_FloatTest() {
		subscriber = new Simple_FloatSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate Simple_FloatTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Simple_Float...");
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
	 * jumpstart the process by instantiating2 Simple_Float
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		simple_FloatId = Simple_FloatBusinessDelegate.getSimple_FloatInstance()
		.createSimple_Float( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		Simple_FloatBusinessDelegate.getSimple_FloatInstance()
				.createSimple_Float( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.simple_FloatSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Simple_Float : " + successValue.getSimple_FloatId());
							  if (successValue.getSimple_FloatId().equals(simple_FloatId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSimple_FloatList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Simple_Float test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on simple_Float consumed")
					);
			subscriber.simple_FloatSubscribe( simple_FloatId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Simple_Float : " + successValue.getSimple_FloatId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSimple_FloatList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on simple_Float for simple_FloatId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Simple_Float. 
	 */
	protected Simple_Float read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Simple_Float" );

		Simple_Float entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Simple_Float with primary key" );
		msg.append( simple_FloatId );
		
		Simple_FloatFetchOneSummary fetchOneSummary = new Simple_FloatFetchOneSummary( simple_FloatId );

		try {
			entity = Simple_FloatBusinessDelegate.getSimple_FloatInstance().getSimple_Float( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Simple_Float " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Simple_Float.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Simple_Float." );

		StringBuilder msg = new StringBuilder( "Failed to update a Simple_Float : " );        
		Simple_Float entity = read();
		UpdateSimple_FloatCommand command = generateUpdateCommand();
		command.setSimple_FloatId(entity.getSimple_FloatId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Simple_Float." );

			// for use later on...
			simple_FloatId = entity.getSimple_FloatId();

			Simple_FloatBusinessDelegate proxy = Simple_FloatBusinessDelegate.getSimple_FloatInstance();  

			proxy.updateSimple_Float( command ).get();

			LOGGER.info( "-- Successfully saved Simple_Float - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + simple_FloatId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Simple_Float.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Simple_Float." );

		Simple_Float entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Simple_Float with id " + simple_FloatId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Simple_Float with id " + simple_FloatId );

			throw e;
		}

		try{
			Simple_FloatBusinessDelegate.getSimple_FloatInstance().delete( new DeleteSimple_FloatCommand( entity.getSimple_FloatId() ) ).get();
			LOGGER.info( "-- Successfully deleted Simple_Float with id " + simple_FloatId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Simple_Float with id " + simple_FloatId );

			throw e;
		}
	}

	/**
	 * get all Simple_Floats.
	 */
	protected List<Simple_Float> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Simple_Floats:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Simple_Float : " );        
		List<Simple_Float> collection  = new ArrayList<>();

		try {
			// call the static get method on the Simple_FloatBusinessDelegate
			collection = Simple_FloatBusinessDelegate.getSimple_FloatInstance().getAllSimple_Float();
			assertNotNull( collection, "An Empty collection of Simple_Float was incorrectly returned.");
			
			// Now print out the values
			Simple_Float entity = null;            
			Iterator<Simple_Float> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSimple_FloatId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		Simple_FloatTest
	 */
	protected Simple_FloatTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Simple_Float
	 * 
	 * @return CreateSimple_FloatCommand alias
	 */
	protected CreateSimple_FloatCommand generateNewCommand() {
        CreateSimple_FloatCommand command = new CreateSimple_FloatCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Simple_Float
		 * 
		 * @return UpdateSimple_FloatCommand alias
		 */
	protected UpdateSimple_FloatCommand generateUpdateCommand() {
	        UpdateSimple_FloatCommand command = new UpdateSimple_FloatCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID simple_FloatId = null;
	protected Simple_FloatSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(Simple_FloatTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSimple_FloatList = 0;
}
