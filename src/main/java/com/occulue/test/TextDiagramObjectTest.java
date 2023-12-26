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
 * Test TextDiagramObject class.
 *
 * @author your_name_here
 */
public class TextDiagramObjectTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public TextDiagramObjectTest() {
		subscriber = new TextDiagramObjectSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate TextDiagramObjectTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on TextDiagramObject...");
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
	 * jumpstart the process by instantiating2 TextDiagramObject
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		textDiagramObjectId = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
		.createTextDiagramObject( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
				.createTextDiagramObject( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.textDiagramObjectSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for TextDiagramObject : " + successValue.getTextDiagramObjectId());
							  if (successValue.getTextDiagramObjectId().equals(textDiagramObjectId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfTextDiagramObjectList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("TextDiagramObject test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on textDiagramObject consumed")
					);
			subscriber.textDiagramObjectSubscribe( textDiagramObjectId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for TextDiagramObject : " + successValue.getTextDiagramObjectId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfTextDiagramObjectList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on textDiagramObject for textDiagramObjectId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a TextDiagramObject. 
	 */
	protected TextDiagramObject read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created TextDiagramObject" );

		TextDiagramObject entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read TextDiagramObject with primary key" );
		msg.append( textDiagramObjectId );
		
		TextDiagramObjectFetchOneSummary fetchOneSummary = new TextDiagramObjectFetchOneSummary( textDiagramObjectId );

		try {
			entity = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().getTextDiagramObject( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found TextDiagramObject " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a TextDiagramObject.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a TextDiagramObject." );

		StringBuilder msg = new StringBuilder( "Failed to update a TextDiagramObject : " );        
		TextDiagramObject entity = read();
		UpdateTextDiagramObjectCommand command = generateUpdateCommand();
		command.setTextDiagramObjectId(entity.getTextDiagramObjectId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created TextDiagramObject." );

			// for use later on...
			textDiagramObjectId = entity.getTextDiagramObjectId();

			TextDiagramObjectBusinessDelegate proxy = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance();  

			proxy.updateTextDiagramObject( command ).get();

			LOGGER.info( "-- Successfully saved TextDiagramObject - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + textDiagramObjectId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a TextDiagramObject.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created TextDiagramObject." );

		TextDiagramObject entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read TextDiagramObject with id " + textDiagramObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read TextDiagramObject with id " + textDiagramObjectId );

			throw e;
		}

		try{
			TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().delete( new DeleteTextDiagramObjectCommand( entity.getTextDiagramObjectId() ) ).get();
			LOGGER.info( "-- Successfully deleted TextDiagramObject with id " + textDiagramObjectId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete TextDiagramObject with id " + textDiagramObjectId );

			throw e;
		}
	}

	/**
	 * get all TextDiagramObjects.
	 */
	protected List<TextDiagramObject> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of TextDiagramObjects:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all TextDiagramObject : " );        
		List<TextDiagramObject> collection  = new ArrayList<>();

		try {
			// call the static get method on the TextDiagramObjectBusinessDelegate
			collection = TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().getAllTextDiagramObject();
			assertNotNull( collection, "An Empty collection of TextDiagramObject was incorrectly returned.");
			
			// Now print out the values
			TextDiagramObject entity = null;            
			Iterator<TextDiagramObject> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getTextDiagramObjectId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		TextDiagramObjectTest
	 */
	protected TextDiagramObjectTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated TextDiagramObject
	 * 
	 * @return CreateTextDiagramObjectCommand alias
	 */
	protected CreateTextDiagramObjectCommand generateNewCommand() {
        CreateTextDiagramObjectCommand command = new CreateTextDiagramObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated TextDiagramObject
		 * 
		 * @return UpdateTextDiagramObjectCommand alias
		 */
	protected UpdateTextDiagramObjectCommand generateUpdateCommand() {
	        UpdateTextDiagramObjectCommand command = new UpdateTextDiagramObjectCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID textDiagramObjectId = null;
	protected TextDiagramObjectSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(TextDiagramObjectTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfTextDiagramObjectList = 0;
}
