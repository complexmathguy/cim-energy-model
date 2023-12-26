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
 * Test CurveData class.
 *
 * @author your_name_here
 */
public class CurveDataTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CurveDataTest() {
		subscriber = new CurveDataSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CurveDataTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on CurveData...");
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
	 * jumpstart the process by instantiating2 CurveData
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		curveDataId = CurveDataBusinessDelegate.getCurveDataInstance()
		.createCurveData( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CurveDataBusinessDelegate.getCurveDataInstance()
				.createCurveData( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.curveDataSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for CurveData : " + successValue.getCurveDataId());
							  if (successValue.getCurveDataId().equals(curveDataId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCurveDataList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("CurveData test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on curveData consumed")
					);
			subscriber.curveDataSubscribe( curveDataId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for CurveData : " + successValue.getCurveDataId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCurveDataList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on curveData for curveDataId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a CurveData. 
	 */
	protected CurveData read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created CurveData" );

		CurveData entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read CurveData with primary key" );
		msg.append( curveDataId );
		
		CurveDataFetchOneSummary fetchOneSummary = new CurveDataFetchOneSummary( curveDataId );

		try {
			entity = CurveDataBusinessDelegate.getCurveDataInstance().getCurveData( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found CurveData " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a CurveData.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a CurveData." );

		StringBuilder msg = new StringBuilder( "Failed to update a CurveData : " );        
		CurveData entity = read();
		UpdateCurveDataCommand command = generateUpdateCommand();
		command.setCurveDataId(entity.getCurveDataId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created CurveData." );

			// for use later on...
			curveDataId = entity.getCurveDataId();

			CurveDataBusinessDelegate proxy = CurveDataBusinessDelegate.getCurveDataInstance();  

			proxy.updateCurveData( command ).get();

			LOGGER.info( "-- Successfully saved CurveData - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + curveDataId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a CurveData.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created CurveData." );

		CurveData entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read CurveData with id " + curveDataId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read CurveData with id " + curveDataId );

			throw e;
		}

		try{
			CurveDataBusinessDelegate.getCurveDataInstance().delete( new DeleteCurveDataCommand( entity.getCurveDataId() ) ).get();
			LOGGER.info( "-- Successfully deleted CurveData with id " + curveDataId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete CurveData with id " + curveDataId );

			throw e;
		}
	}

	/**
	 * get all CurveDatas.
	 */
	protected List<CurveData> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of CurveDatas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all CurveData : " );        
		List<CurveData> collection  = new ArrayList<>();

		try {
			// call the static get method on the CurveDataBusinessDelegate
			collection = CurveDataBusinessDelegate.getCurveDataInstance().getAllCurveData();
			assertNotNull( collection, "An Empty collection of CurveData was incorrectly returned.");
			
			// Now print out the values
			CurveData entity = null;            
			Iterator<CurveData> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCurveDataId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CurveDataTest
	 */
	protected CurveDataTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated CurveData
	 * 
	 * @return CreateCurveDataCommand alias
	 */
	protected CreateCurveDataCommand generateNewCommand() {
        CreateCurveDataCommand command = new CreateCurveDataCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated CurveData
		 * 
		 * @return UpdateCurveDataCommand alias
		 */
	protected UpdateCurveDataCommand generateUpdateCommand() {
	        UpdateCurveDataCommand command = new UpdateCurveDataCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID curveDataId = null;
	protected CurveDataSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CurveDataTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCurveDataList = 0;
}
