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
 * Test OperationalLimitType class.
 *
 * @author your_name_here
 */
public class OperationalLimitTypeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public OperationalLimitTypeTest() {
		subscriber = new OperationalLimitTypeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate OperationalLimitTypeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on OperationalLimitType...");
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
	 * jumpstart the process by instantiating2 OperationalLimitType
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		operationalLimitTypeId = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance()
		.createOperationalLimitType( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance()
				.createOperationalLimitType( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.operationalLimitTypeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for OperationalLimitType : " + successValue.getOperationalLimitTypeId());
							  if (successValue.getOperationalLimitTypeId().equals(operationalLimitTypeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfOperationalLimitTypeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("OperationalLimitType test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimitType consumed")
					);
			subscriber.operationalLimitTypeSubscribe( operationalLimitTypeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for OperationalLimitType : " + successValue.getOperationalLimitTypeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfOperationalLimitTypeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on operationalLimitType for operationalLimitTypeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a OperationalLimitType. 
	 */
	protected OperationalLimitType read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created OperationalLimitType" );

		OperationalLimitType entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read OperationalLimitType with primary key" );
		msg.append( operationalLimitTypeId );
		
		OperationalLimitTypeFetchOneSummary fetchOneSummary = new OperationalLimitTypeFetchOneSummary( operationalLimitTypeId );

		try {
			entity = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().getOperationalLimitType( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found OperationalLimitType " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a OperationalLimitType.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a OperationalLimitType." );

		StringBuilder msg = new StringBuilder( "Failed to update a OperationalLimitType : " );        
		OperationalLimitType entity = read();
		UpdateOperationalLimitTypeCommand command = generateUpdateCommand();
		command.setOperationalLimitTypeId(entity.getOperationalLimitTypeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created OperationalLimitType." );

			// for use later on...
			operationalLimitTypeId = entity.getOperationalLimitTypeId();

			OperationalLimitTypeBusinessDelegate proxy = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance();  

			proxy.updateOperationalLimitType( command ).get();

			LOGGER.info( "-- Successfully saved OperationalLimitType - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + operationalLimitTypeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a OperationalLimitType.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created OperationalLimitType." );

		OperationalLimitType entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read OperationalLimitType with id " + operationalLimitTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read OperationalLimitType with id " + operationalLimitTypeId );

			throw e;
		}

		try{
			OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().delete( new DeleteOperationalLimitTypeCommand( entity.getOperationalLimitTypeId() ) ).get();
			LOGGER.info( "-- Successfully deleted OperationalLimitType with id " + operationalLimitTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete OperationalLimitType with id " + operationalLimitTypeId );

			throw e;
		}
	}

	/**
	 * get all OperationalLimitTypes.
	 */
	protected List<OperationalLimitType> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of OperationalLimitTypes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all OperationalLimitType : " );        
		List<OperationalLimitType> collection  = new ArrayList<>();

		try {
			// call the static get method on the OperationalLimitTypeBusinessDelegate
			collection = OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance().getAllOperationalLimitType();
			assertNotNull( collection, "An Empty collection of OperationalLimitType was incorrectly returned.");
			
			// Now print out the values
			OperationalLimitType entity = null;            
			Iterator<OperationalLimitType> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getOperationalLimitTypeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		OperationalLimitTypeTest
	 */
	protected OperationalLimitTypeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated OperationalLimitType
	 * 
	 * @return CreateOperationalLimitTypeCommand alias
	 */
	protected CreateOperationalLimitTypeCommand generateNewCommand() {
        CreateOperationalLimitTypeCommand command = new CreateOperationalLimitTypeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated OperationalLimitType
		 * 
		 * @return UpdateOperationalLimitTypeCommand alias
		 */
	protected UpdateOperationalLimitTypeCommand generateUpdateCommand() {
	        UpdateOperationalLimitTypeCommand command = new UpdateOperationalLimitTypeCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID operationalLimitTypeId = null;
	protected OperationalLimitTypeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(OperationalLimitTypeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfOperationalLimitTypeList = 0;
}
