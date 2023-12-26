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
 * Test TransformerEnd class.
 *
 * @author your_name_here
 */
public class TransformerEndTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TransformerEndTest() {
		subscriber = new TransformerEndSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TransformerEndTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TransformerEnd...");
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
	 * jumpstart the process by instantiating2 TransformerEnd
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		transformerEndId = TransformerEndBusinessDelegate.getTransformerEndInstance()
		.createTransformerEnd( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TransformerEndBusinessDelegate.getTransformerEndInstance()
				.createTransformerEnd( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.transformerEndSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TransformerEnd : " + successValue.getTransformerEndId());
							  if (successValue.getTransformerEndId().equals(transformerEndId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTransformerEndList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TransformerEnd test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on transformerEnd consumed")
					);
			subscriber.transformerEndSubscribe( transformerEndId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TransformerEnd : " + successValue.getTransformerEndId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTransformerEndList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on transformerEnd for transformerEndId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TransformerEnd. 
	 */
	protected TransformerEnd read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TransformerEnd" );

		TransformerEnd entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TransformerEnd with primary key" );
		msg.append( transformerEndId );
		
		TransformerEndFetchOneSummary fetchOneSummary = new TransformerEndFetchOneSummary( transformerEndId );

		try {
			entity = TransformerEndBusinessDelegate.getTransformerEndInstance().getTransformerEnd( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TransformerEnd " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TransformerEnd.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TransformerEnd." );

		StringBuilder msg = new StringBuilder( "Failed to update a TransformerEnd : " );        
		TransformerEnd entity = read();
		UpdateTransformerEndCommand command = generateUpdateCommand();
		command.setTransformerEndId(entity.getTransformerEndId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TransformerEnd." );

			// for use later on...
			transformerEndId = entity.getTransformerEndId();

			TransformerEndBusinessDelegate proxy = TransformerEndBusinessDelegate.getTransformerEndInstance();  

			proxy.updateTransformerEnd( command ).get();

			LOGGER.info( "-- Successfully saved TransformerEnd - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + transformerEndId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TransformerEnd.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TransformerEnd." );

		TransformerEnd entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TransformerEnd with id " + transformerEndId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TransformerEnd with id " + transformerEndId );

			throw e;
		}

		try{
			TransformerEndBusinessDelegate.getTransformerEndInstance().delete( new DeleteTransformerEndCommand( entity.getTransformerEndId() ) ).get();
			LOGGER.info( "-- Successfully deleted TransformerEnd with id " + transformerEndId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TransformerEnd with id " + transformerEndId );

			throw e;
		}
	}

	/**
	 * get all TransformerEnds.
	 */
	protected List<TransformerEnd> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TransformerEnds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TransformerEnd : " );        
		List<TransformerEnd> collection  = new ArrayList<>();

		try {
			// call the static get method on the TransformerEndBusinessDelegate
			collection = TransformerEndBusinessDelegate.getTransformerEndInstance().getAllTransformerEnd();
			assertNotNull( collection, "An Empty collection of TransformerEnd was incorrectly returned.");
			
			// Now print out the values
			TransformerEnd entity = null;            
			Iterator<TransformerEnd> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTransformerEndId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TransformerEndTest
	 */
	protected TransformerEndTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TransformerEnd
	 * 
	 * @return CreateTransformerEndCommand alias
	 */
	protected CreateTransformerEndCommand generateNewCommand() {
        CreateTransformerEndCommand command = new CreateTransformerEndCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TransformerEnd
		 * 
		 * @return UpdateTransformerEndCommand alias
		 */
	protected UpdateTransformerEndCommand generateUpdateCommand() {
	        UpdateTransformerEndCommand command = new UpdateTransformerEndCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID transformerEndId = null;
	protected TransformerEndSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TransformerEndTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTransformerEndList = 0;
}
