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
 * Test ENTSOEOperationalLimitType class.
 *
 * @author your_name_here
 */
public class ENTSOEOperationalLimitTypeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ENTSOEOperationalLimitTypeTest() {
		subscriber = new ENTSOEOperationalLimitTypeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ENTSOEOperationalLimitTypeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ENTSOEOperationalLimitType...");
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
	 * jumpstart the process by instantiating2 ENTSOEOperationalLimitType
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		eNTSOEOperationalLimitTypeId = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance()
		.createENTSOEOperationalLimitType( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance()
				.createENTSOEOperationalLimitType( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.eNTSOEOperationalLimitTypeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ENTSOEOperationalLimitType : " + successValue.getENTSOEOperationalLimitTypeId());
							  if (successValue.getENTSOEOperationalLimitTypeId().equals(eNTSOEOperationalLimitTypeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfENTSOEOperationalLimitTypeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ENTSOEOperationalLimitType test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEOperationalLimitType consumed")
					);
			subscriber.eNTSOEOperationalLimitTypeSubscribe( eNTSOEOperationalLimitTypeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ENTSOEOperationalLimitType : " + successValue.getENTSOEOperationalLimitTypeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfENTSOEOperationalLimitTypeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on eNTSOEOperationalLimitType for eNTSOEOperationalLimitTypeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ENTSOEOperationalLimitType. 
	 */
	protected ENTSOEOperationalLimitType read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ENTSOEOperationalLimitType" );

		ENTSOEOperationalLimitType entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ENTSOEOperationalLimitType with primary key" );
		msg.append( eNTSOEOperationalLimitTypeId );
		
		ENTSOEOperationalLimitTypeFetchOneSummary fetchOneSummary = new ENTSOEOperationalLimitTypeFetchOneSummary( eNTSOEOperationalLimitTypeId );

		try {
			entity = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().getENTSOEOperationalLimitType( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ENTSOEOperationalLimitType " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ENTSOEOperationalLimitType.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ENTSOEOperationalLimitType." );

		StringBuilder msg = new StringBuilder( "Failed to update a ENTSOEOperationalLimitType : " );        
		ENTSOEOperationalLimitType entity = read();
		UpdateENTSOEOperationalLimitTypeCommand command = generateUpdateCommand();
		command.setENTSOEOperationalLimitTypeId(entity.getENTSOEOperationalLimitTypeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ENTSOEOperationalLimitType." );

			// for use later on...
			eNTSOEOperationalLimitTypeId = entity.getENTSOEOperationalLimitTypeId();

			ENTSOEOperationalLimitTypeBusinessDelegate proxy = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance();  

			proxy.updateENTSOEOperationalLimitType( command ).get();

			LOGGER.info( "-- Successfully saved ENTSOEOperationalLimitType - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + eNTSOEOperationalLimitTypeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ENTSOEOperationalLimitType.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ENTSOEOperationalLimitType." );

		ENTSOEOperationalLimitType entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ENTSOEOperationalLimitType with id " + eNTSOEOperationalLimitTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ENTSOEOperationalLimitType with id " + eNTSOEOperationalLimitTypeId );

			throw e;
		}

		try{
			ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().delete( new DeleteENTSOEOperationalLimitTypeCommand( entity.getENTSOEOperationalLimitTypeId() ) ).get();
			LOGGER.info( "-- Successfully deleted ENTSOEOperationalLimitType with id " + eNTSOEOperationalLimitTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ENTSOEOperationalLimitType with id " + eNTSOEOperationalLimitTypeId );

			throw e;
		}
	}

	/**
	 * get all ENTSOEOperationalLimitTypes.
	 */
	protected List<ENTSOEOperationalLimitType> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ENTSOEOperationalLimitTypes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ENTSOEOperationalLimitType : " );        
		List<ENTSOEOperationalLimitType> collection  = new ArrayList<>();

		try {
			// call the static get method on the ENTSOEOperationalLimitTypeBusinessDelegate
			collection = ENTSOEOperationalLimitTypeBusinessDelegate.getENTSOEOperationalLimitTypeInstance().getAllENTSOEOperationalLimitType();
			assertNotNull( collection, "An Empty collection of ENTSOEOperationalLimitType was incorrectly returned.");
			
			// Now print out the values
			ENTSOEOperationalLimitType entity = null;            
			Iterator<ENTSOEOperationalLimitType> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getENTSOEOperationalLimitTypeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ENTSOEOperationalLimitTypeTest
	 */
	protected ENTSOEOperationalLimitTypeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ENTSOEOperationalLimitType
	 * 
	 * @return CreateENTSOEOperationalLimitTypeCommand alias
	 */
	protected CreateENTSOEOperationalLimitTypeCommand generateNewCommand() {
        CreateENTSOEOperationalLimitTypeCommand command = new CreateENTSOEOperationalLimitTypeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated ENTSOEOperationalLimitType
		 * 
		 * @return UpdateENTSOEOperationalLimitTypeCommand alias
		 */
	protected UpdateENTSOEOperationalLimitTypeCommand generateUpdateCommand() {
	        UpdateENTSOEOperationalLimitTypeCommand command = new UpdateENTSOEOperationalLimitTypeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID eNTSOEOperationalLimitTypeId = null;
	protected ENTSOEOperationalLimitTypeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ENTSOEOperationalLimitTypeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfENTSOEOperationalLimitTypeList = 0;
}
