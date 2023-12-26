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
 * Test RegulatingCondEq class.
 *
 * @author your_name_here
 */
public class RegulatingCondEqTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public RegulatingCondEqTest() {
		subscriber = new RegulatingCondEqSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate RegulatingCondEqTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on RegulatingCondEq...");
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
	 * jumpstart the process by instantiating2 RegulatingCondEq
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		regulatingCondEqId = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
		.createRegulatingCondEq( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
				.createRegulatingCondEq( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.regulatingCondEqSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for RegulatingCondEq : " + successValue.getRegulatingCondEqId());
							  if (successValue.getRegulatingCondEqId().equals(regulatingCondEqId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfRegulatingCondEqList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("RegulatingCondEq test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulatingCondEq consumed")
					);
			subscriber.regulatingCondEqSubscribe( regulatingCondEqId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for RegulatingCondEq : " + successValue.getRegulatingCondEqId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfRegulatingCondEqList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on regulatingCondEq for regulatingCondEqId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a RegulatingCondEq. 
	 */
	protected RegulatingCondEq read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created RegulatingCondEq" );

		RegulatingCondEq entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read RegulatingCondEq with primary key" );
		msg.append( regulatingCondEqId );
		
		RegulatingCondEqFetchOneSummary fetchOneSummary = new RegulatingCondEqFetchOneSummary( regulatingCondEqId );

		try {
			entity = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().getRegulatingCondEq( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found RegulatingCondEq " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a RegulatingCondEq.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a RegulatingCondEq." );

		StringBuilder msg = new StringBuilder( "Failed to update a RegulatingCondEq : " );        
		RegulatingCondEq entity = read();
		UpdateRegulatingCondEqCommand command = generateUpdateCommand();
		command.setRegulatingCondEqId(entity.getRegulatingCondEqId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created RegulatingCondEq." );

			// for use later on...
			regulatingCondEqId = entity.getRegulatingCondEqId();

			RegulatingCondEqBusinessDelegate proxy = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();  

			proxy.updateRegulatingCondEq( command ).get();

			LOGGER.info( "-- Successfully saved RegulatingCondEq - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + regulatingCondEqId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a RegulatingCondEq.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created RegulatingCondEq." );

		RegulatingCondEq entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read RegulatingCondEq with id " + regulatingCondEqId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read RegulatingCondEq with id " + regulatingCondEqId );

			throw e;
		}

		try{
			RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().delete( new DeleteRegulatingCondEqCommand( entity.getRegulatingCondEqId() ) ).get();
			LOGGER.info( "-- Successfully deleted RegulatingCondEq with id " + regulatingCondEqId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete RegulatingCondEq with id " + regulatingCondEqId );

			throw e;
		}
	}

	/**
	 * get all RegulatingCondEqs.
	 */
	protected List<RegulatingCondEq> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of RegulatingCondEqs:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all RegulatingCondEq : " );        
		List<RegulatingCondEq> collection  = new ArrayList<>();

		try {
			// call the static get method on the RegulatingCondEqBusinessDelegate
			collection = RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().getAllRegulatingCondEq();
			assertNotNull( collection, "An Empty collection of RegulatingCondEq was incorrectly returned.");
			
			// Now print out the values
			RegulatingCondEq entity = null;            
			Iterator<RegulatingCondEq> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getRegulatingCondEqId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		RegulatingCondEqTest
	 */
	protected RegulatingCondEqTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated RegulatingCondEq
	 * 
	 * @return CreateRegulatingCondEqCommand alias
	 */
	protected CreateRegulatingCondEqCommand generateNewCommand() {
        CreateRegulatingCondEqCommand command = new CreateRegulatingCondEqCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated RegulatingCondEq
		 * 
		 * @return UpdateRegulatingCondEqCommand alias
		 */
	protected UpdateRegulatingCondEqCommand generateUpdateCommand() {
	        UpdateRegulatingCondEqCommand command = new UpdateRegulatingCondEqCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID regulatingCondEqId = null;
	protected RegulatingCondEqSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(RegulatingCondEqTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfRegulatingCondEqList = 0;
}
