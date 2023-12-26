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
 * Test PFVArControllerType1UserDefined class.
 *
 * @author your_name_here
 */
public class PFVArControllerType1UserDefinedTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PFVArControllerType1UserDefinedTest() {
		subscriber = new PFVArControllerType1UserDefinedSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PFVArControllerType1UserDefinedTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PFVArControllerType1UserDefined...");
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
	 * jumpstart the process by instantiating2 PFVArControllerType1UserDefined
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		pFVArControllerType1UserDefinedId = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance()
		.createPFVArControllerType1UserDefined( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance()
				.createPFVArControllerType1UserDefined( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.pFVArControllerType1UserDefinedSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PFVArControllerType1UserDefined : " + successValue.getPFVArControllerType1UserDefinedId());
							  if (successValue.getPFVArControllerType1UserDefinedId().equals(pFVArControllerType1UserDefinedId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPFVArControllerType1UserDefinedList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PFVArControllerType1UserDefined test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType1UserDefined consumed")
					);
			subscriber.pFVArControllerType1UserDefinedSubscribe( pFVArControllerType1UserDefinedId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PFVArControllerType1UserDefined : " + successValue.getPFVArControllerType1UserDefinedId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPFVArControllerType1UserDefinedList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on pFVArControllerType1UserDefined for pFVArControllerType1UserDefinedId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PFVArControllerType1UserDefined. 
	 */
	protected PFVArControllerType1UserDefined read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PFVArControllerType1UserDefined" );

		PFVArControllerType1UserDefined entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PFVArControllerType1UserDefined with primary key" );
		msg.append( pFVArControllerType1UserDefinedId );
		
		PFVArControllerType1UserDefinedFetchOneSummary fetchOneSummary = new PFVArControllerType1UserDefinedFetchOneSummary( pFVArControllerType1UserDefinedId );

		try {
			entity = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().getPFVArControllerType1UserDefined( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PFVArControllerType1UserDefined " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PFVArControllerType1UserDefined.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PFVArControllerType1UserDefined." );

		StringBuilder msg = new StringBuilder( "Failed to update a PFVArControllerType1UserDefined : " );        
		PFVArControllerType1UserDefined entity = read();
		UpdatePFVArControllerType1UserDefinedCommand command = generateUpdateCommand();
		command.setPFVArControllerType1UserDefinedId(entity.getPFVArControllerType1UserDefinedId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PFVArControllerType1UserDefined." );

			// for use later on...
			pFVArControllerType1UserDefinedId = entity.getPFVArControllerType1UserDefinedId();

			PFVArControllerType1UserDefinedBusinessDelegate proxy = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance();  

			proxy.updatePFVArControllerType1UserDefined( command ).get();

			LOGGER.info( "-- Successfully saved PFVArControllerType1UserDefined - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + pFVArControllerType1UserDefinedId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PFVArControllerType1UserDefined.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PFVArControllerType1UserDefined." );

		PFVArControllerType1UserDefined entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PFVArControllerType1UserDefined with id " + pFVArControllerType1UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PFVArControllerType1UserDefined with id " + pFVArControllerType1UserDefinedId );

			throw e;
		}

		try{
			PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().delete( new DeletePFVArControllerType1UserDefinedCommand( entity.getPFVArControllerType1UserDefinedId() ) ).get();
			LOGGER.info( "-- Successfully deleted PFVArControllerType1UserDefined with id " + pFVArControllerType1UserDefinedId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PFVArControllerType1UserDefined with id " + pFVArControllerType1UserDefinedId );

			throw e;
		}
	}

	/**
	 * get all PFVArControllerType1UserDefineds.
	 */
	protected List<PFVArControllerType1UserDefined> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PFVArControllerType1UserDefineds:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PFVArControllerType1UserDefined : " );        
		List<PFVArControllerType1UserDefined> collection  = new ArrayList<>();

		try {
			// call the static get method on the PFVArControllerType1UserDefinedBusinessDelegate
			collection = PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance().getAllPFVArControllerType1UserDefined();
			assertNotNull( collection, "An Empty collection of PFVArControllerType1UserDefined was incorrectly returned.");
			
			// Now print out the values
			PFVArControllerType1UserDefined entity = null;            
			Iterator<PFVArControllerType1UserDefined> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPFVArControllerType1UserDefinedId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PFVArControllerType1UserDefinedTest
	 */
	protected PFVArControllerType1UserDefinedTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PFVArControllerType1UserDefined
	 * 
	 * @return CreatePFVArControllerType1UserDefinedCommand alias
	 */
	protected CreatePFVArControllerType1UserDefinedCommand generateNewCommand() {
        CreatePFVArControllerType1UserDefinedCommand command = new CreatePFVArControllerType1UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated PFVArControllerType1UserDefined
		 * 
		 * @return UpdatePFVArControllerType1UserDefinedCommand alias
		 */
	protected UpdatePFVArControllerType1UserDefinedCommand generateUpdateCommand() {
	        UpdatePFVArControllerType1UserDefinedCommand command = new UpdatePFVArControllerType1UserDefinedCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID pFVArControllerType1UserDefinedId = null;
	protected PFVArControllerType1UserDefinedSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PFVArControllerType1UserDefinedTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPFVArControllerType1UserDefinedList = 0;
}
