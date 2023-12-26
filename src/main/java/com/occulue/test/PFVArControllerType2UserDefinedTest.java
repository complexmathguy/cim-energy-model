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
 * Test PFVArControllerType2UserDefined class.
 *
 * @author your_name_here
 */
public class PFVArControllerType2UserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArControllerType2UserDefinedTest() {
		subscriber = new PFVArControllerType2UserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArControllerType2UserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArControllerType2UserDefined...");
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
	 * jumpstart the process by instantiating2 PFVArControllerType2UserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArControllerType2UserDefinedId = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance()
		.createPFVArControllerType2UserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance()
				.createPFVArControllerType2UserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArControllerType2UserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArControllerType2UserDefined : " + successValue.getPFVArControllerType2UserDefinedId());
							  if (successValue.getPFVArControllerType2UserDefinedId().equals(pFVArControllerType2UserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArControllerType2UserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArControllerType2UserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType2UserDefined consumed")
					);
			subscriber.pFVArControllerType2UserDefinedSubscribe( pFVArControllerType2UserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArControllerType2UserDefined : " + successValue.getPFVArControllerType2UserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArControllerType2UserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType2UserDefined for pFVArControllerType2UserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArControllerType2UserDefined. 
	 */
	protected PFVArControllerType2UserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArControllerType2UserDefined" );

		PFVArControllerType2UserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArControllerType2UserDefined with primary key" );
		msg.append( pFVArControllerType2UserDefinedId );
		
		PFVArControllerType2UserDefinedFetchOneSummary fetchOneSummary = new PFVArControllerType2UserDefinedFetchOneSummary( pFVArControllerType2UserDefinedId );

		try {
			entity = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().getPFVArControllerType2UserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArControllerType2UserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArControllerType2UserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArControllerType2UserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArControllerType2UserDefined : " );        
		PFVArControllerType2UserDefined entity = read();
		UpdatePFVArControllerType2UserDefinedCommand command = generateUpdateCommand();
		command.setPFVArControllerType2UserDefinedId(entity.getPFVArControllerType2UserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArControllerType2UserDefined." );

			// for use later on...
			pFVArControllerType2UserDefinedId = entity.getPFVArControllerType2UserDefinedId();

			PFVArControllerType2UserDefinedBusinessDelegate proxy = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance();  

			proxy.updatePFVArControllerType2UserDefined( command ).get();

			LOGGER.info( "-- Successfully saved PFVArControllerType2UserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArControllerType2UserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArControllerType2UserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArControllerType2UserDefined." );

		PFVArControllerType2UserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArControllerType2UserDefined with id " + pFVArControllerType2UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArControllerType2UserDefined with id " + pFVArControllerType2UserDefinedId );

			throw e;
		}

		try{
			PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().delete( new DeletePFVArControllerType2UserDefinedCommand( entity.getPFVArControllerType2UserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArControllerType2UserDefined with id " + pFVArControllerType2UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArControllerType2UserDefined with id " + pFVArControllerType2UserDefinedId );

			throw e;
		}
	}

	/**
	 * get all PFVArControllerType2UserDefineds.
	 */
	protected List<PFVArControllerType2UserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArControllerType2UserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArControllerType2UserDefined : " );        
		List<PFVArControllerType2UserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArControllerType2UserDefinedBusinessDelegate
			collection = PFVArControllerType2UserDefinedBusinessDelegate.getPFVArControllerType2UserDefinedInstance().getAllPFVArControllerType2UserDefined();
			assertNotNull( collection, "An Empty collection of PFVArControllerType2UserDefined was incorrectly returned.");
			
			// Now print out the values
			PFVArControllerType2UserDefined entity = null;            
			Iterator<PFVArControllerType2UserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArControllerType2UserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArControllerType2UserDefinedTest
	 */
	protected PFVArControllerType2UserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArControllerType2UserDefined
	 * 
	 * @return CreatePFVArControllerType2UserDefinedCommand alias
	 */
	protected CreatePFVArControllerType2UserDefinedCommand generateNewCommand() {
        CreatePFVArControllerType2UserDefinedCommand command = new CreatePFVArControllerType2UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArControllerType2UserDefined
		 * 
		 * @return UpdatePFVArControllerType2UserDefinedCommand alias
		 */
	protected UpdatePFVArControllerType2UserDefinedCommand generateUpdateCommand() {
	        UpdatePFVArControllerType2UserDefinedCommand command = new UpdatePFVArControllerType2UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArControllerType2UserDefinedId = null;
	protected PFVArControllerType2UserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArControllerType2UserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArControllerType2UserDefinedList = 0;
}
