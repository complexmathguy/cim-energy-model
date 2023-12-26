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
 * Test VsCapabilityCurve class.
 *
 * @author your_name_here
 */
public class VsCapabilityCurveTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VsCapabilityCurveTest() {
		subscriber = new VsCapabilityCurveSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VsCapabilityCurveTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VsCapabilityCurve...");
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
	 * jumpstart the process by instantiating2 VsCapabilityCurve
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		vsCapabilityCurveId = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance()
		.createVsCapabilityCurve( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance()
				.createVsCapabilityCurve( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.vsCapabilityCurveSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VsCapabilityCurve : " + successValue.getVsCapabilityCurveId());
							  if (successValue.getVsCapabilityCurveId().equals(vsCapabilityCurveId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVsCapabilityCurveList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VsCapabilityCurve test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vsCapabilityCurve consumed")
					);
			subscriber.vsCapabilityCurveSubscribe( vsCapabilityCurveId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VsCapabilityCurve : " + successValue.getVsCapabilityCurveId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVsCapabilityCurveList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vsCapabilityCurve for vsCapabilityCurveId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VsCapabilityCurve. 
	 */
	protected VsCapabilityCurve read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VsCapabilityCurve" );

		VsCapabilityCurve entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VsCapabilityCurve with primary key" );
		msg.append( vsCapabilityCurveId );
		
		VsCapabilityCurveFetchOneSummary fetchOneSummary = new VsCapabilityCurveFetchOneSummary( vsCapabilityCurveId );

		try {
			entity = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().getVsCapabilityCurve( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VsCapabilityCurve " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VsCapabilityCurve.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VsCapabilityCurve." );

		StringBuilder msg = new StringBuilder( "Failed to update a VsCapabilityCurve : " );        
		VsCapabilityCurve entity = read();
		UpdateVsCapabilityCurveCommand command = generateUpdateCommand();
		command.setVsCapabilityCurveId(entity.getVsCapabilityCurveId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VsCapabilityCurve." );

			// for use later on...
			vsCapabilityCurveId = entity.getVsCapabilityCurveId();

			VsCapabilityCurveBusinessDelegate proxy = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance();  

			proxy.updateVsCapabilityCurve( command ).get();

			LOGGER.info( "-- Successfully saved VsCapabilityCurve - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + vsCapabilityCurveId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VsCapabilityCurve.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VsCapabilityCurve." );

		VsCapabilityCurve entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VsCapabilityCurve with id " + vsCapabilityCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VsCapabilityCurve with id " + vsCapabilityCurveId );

			throw e;
		}

		try{
			VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().delete( new DeleteVsCapabilityCurveCommand( entity.getVsCapabilityCurveId() ) ).get();
			LOGGER.info( "-- Successfully deleted VsCapabilityCurve with id " + vsCapabilityCurveId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VsCapabilityCurve with id " + vsCapabilityCurveId );

			throw e;
		}
	}

	/**
	 * get all VsCapabilityCurves.
	 */
	protected List<VsCapabilityCurve> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VsCapabilityCurves:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VsCapabilityCurve : " );        
		List<VsCapabilityCurve> collection  = new ArrayList<>();

		try {
			// call the static get method on the VsCapabilityCurveBusinessDelegate
			collection = VsCapabilityCurveBusinessDelegate.getVsCapabilityCurveInstance().getAllVsCapabilityCurve();
			assertNotNull( collection, "An Empty collection of VsCapabilityCurve was incorrectly returned.");
			
			// Now print out the values
			VsCapabilityCurve entity = null;            
			Iterator<VsCapabilityCurve> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVsCapabilityCurveId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VsCapabilityCurveTest
	 */
	protected VsCapabilityCurveTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VsCapabilityCurve
	 * 
	 * @return CreateVsCapabilityCurveCommand alias
	 */
	protected CreateVsCapabilityCurveCommand generateNewCommand() {
        CreateVsCapabilityCurveCommand command = new CreateVsCapabilityCurveCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated VsCapabilityCurve
		 * 
		 * @return UpdateVsCapabilityCurveCommand alias
		 */
	protected UpdateVsCapabilityCurveCommand generateUpdateCommand() {
	        UpdateVsCapabilityCurveCommand command = new UpdateVsCapabilityCurveCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID vsCapabilityCurveId = null;
	protected VsCapabilityCurveSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VsCapabilityCurveTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVsCapabilityCurveList = 0;
}
