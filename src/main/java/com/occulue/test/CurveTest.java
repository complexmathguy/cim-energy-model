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
 * Test Curve class.
 *
 * @author your_name_here
 */
public class CurveTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public CurveTest() {
		subscriber = new CurveSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate CurveTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on Curve...");
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
	 * jumpstart the process by instantiating2 Curve
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		curveId = CurveBusinessDelegate.getCurveInstance()
		.createCurve( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		CurveBusinessDelegate.getCurveInstance()
				.createCurve( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.curveSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for Curve : " + successValue.getCurveId());
							  if (successValue.getCurveId().equals(curveId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfCurveList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("Curve test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on curve consumed")
					);
			subscriber.curveSubscribe( curveId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for Curve : " + successValue.getCurveId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfCurveList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on curve for curveId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a Curve. 
	 */
	protected Curve read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created Curve" );

		Curve entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read Curve with primary key" );
		msg.append( curveId );
		
		CurveFetchOneSummary fetchOneSummary = new CurveFetchOneSummary( curveId );

		try {
			entity = CurveBusinessDelegate.getCurveInstance().getCurve( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found Curve " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a Curve.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a Curve." );

		StringBuilder msg = new StringBuilder( "Failed to update a Curve : " );        
		Curve entity = read();
		UpdateCurveCommand command = generateUpdateCommand();
		command.setCurveId(entity.getCurveId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created Curve." );

			// for use later on...
			curveId = entity.getCurveId();

			CurveBusinessDelegate proxy = CurveBusinessDelegate.getCurveInstance();  

			proxy.updateCurve( command ).get();

			LOGGER.info( "-- Successfully saved Curve - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + curveId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a Curve.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created Curve." );

		Curve entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read Curve with id " + curveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read Curve with id " + curveId );

			throw e;
		}

		try{
			CurveBusinessDelegate.getCurveInstance().delete( new DeleteCurveCommand( entity.getCurveId() ) ).get();
			LOGGER.info( "-- Successfully deleted Curve with id " + curveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete Curve with id " + curveId );

			throw e;
		}
	}

	/**
	 * get all Curves.
	 */
	protected List<Curve> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of Curves:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all Curve : " );        
		List<Curve> collection  = new ArrayList<>();

		try {
			// call the static get method on the CurveBusinessDelegate
			collection = CurveBusinessDelegate.getCurveInstance().getAllCurve();
			assertNotNull( collection, "An Empty collection of Curve was incorrectly returned.");
			
			// Now print out the values
			Curve entity = null;            
			Iterator<Curve> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getCurveId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		CurveTest
	 */
	protected CurveTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated Curve
	 * 
	 * @return CreateCurveCommand alias
	 */
	protected CreateCurveCommand generateNewCommand() {
        CreateCurveCommand command = new CreateCurveCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated Curve
		 * 
		 * @return UpdateCurveCommand alias
		 */
	protected UpdateCurveCommand generateUpdateCommand() {
	        UpdateCurveCommand command = new UpdateCurveCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID curveId = null;
	protected CurveSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(CurveTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfCurveList = 0;
}
