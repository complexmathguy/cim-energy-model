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
 * Test ReportingGroup class.
 *
 * @author your_name_here
 */
public class ReportingGroupTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public ReportingGroupTest() {
		subscriber = new ReportingGroupSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate ReportingGroupTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on ReportingGroup...");
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
	 * jumpstart the process by instantiating2 ReportingGroup
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		reportingGroupId = ReportingGroupBusinessDelegate.getReportingGroupInstance()
		.createReportingGroup( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		ReportingGroupBusinessDelegate.getReportingGroupInstance()
				.createReportingGroup( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.reportingGroupSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for ReportingGroup : " + successValue.getReportingGroupId());
							  if (successValue.getReportingGroupId().equals(reportingGroupId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfReportingGroupList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("ReportingGroup test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reportingGroup consumed")
					);
			subscriber.reportingGroupSubscribe( reportingGroupId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for ReportingGroup : " + successValue.getReportingGroupId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfReportingGroupList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on reportingGroup for reportingGroupId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a ReportingGroup. 
	 */
	protected ReportingGroup read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created ReportingGroup" );

		ReportingGroup entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read ReportingGroup with primary key" );
		msg.append( reportingGroupId );
		
		ReportingGroupFetchOneSummary fetchOneSummary = new ReportingGroupFetchOneSummary( reportingGroupId );

		try {
			entity = ReportingGroupBusinessDelegate.getReportingGroupInstance().getReportingGroup( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found ReportingGroup " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a ReportingGroup.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a ReportingGroup." );

		StringBuilder msg = new StringBuilder( "Failed to update a ReportingGroup : " );        
		ReportingGroup entity = read();
		UpdateReportingGroupCommand command = generateUpdateCommand();
		command.setReportingGroupId(entity.getReportingGroupId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created ReportingGroup." );

			// for use later on...
			reportingGroupId = entity.getReportingGroupId();

			ReportingGroupBusinessDelegate proxy = ReportingGroupBusinessDelegate.getReportingGroupInstance();  

			proxy.updateReportingGroup( command ).get();

			LOGGER.info( "-- Successfully saved ReportingGroup - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + reportingGroupId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a ReportingGroup.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created ReportingGroup." );

		ReportingGroup entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read ReportingGroup with id " + reportingGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read ReportingGroup with id " + reportingGroupId );

			throw e;
		}

		try{
			ReportingGroupBusinessDelegate.getReportingGroupInstance().delete( new DeleteReportingGroupCommand( entity.getReportingGroupId() ) ).get();
			LOGGER.info( "-- Successfully deleted ReportingGroup with id " + reportingGroupId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete ReportingGroup with id " + reportingGroupId );

			throw e;
		}
	}

	/**
	 * get all ReportingGroups.
	 */
	protected List<ReportingGroup> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of ReportingGroups:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all ReportingGroup : " );        
		List<ReportingGroup> collection  = new ArrayList<>();

		try {
			// call the static get method on the ReportingGroupBusinessDelegate
			collection = ReportingGroupBusinessDelegate.getReportingGroupInstance().getAllReportingGroup();
			assertNotNull( collection, "An Empty collection of ReportingGroup was incorrectly returned.");
			
			// Now print out the values
			ReportingGroup entity = null;            
			Iterator<ReportingGroup> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getReportingGroupId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		ReportingGroupTest
	 */
	protected ReportingGroupTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated ReportingGroup
	 * 
	 * @return CreateReportingGroupCommand alias
	 */
	protected CreateReportingGroupCommand generateNewCommand() {
        CreateReportingGroupCommand command = new CreateReportingGroupCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated ReportingGroup
		 * 
		 * @return UpdateReportingGroupCommand alias
		 */
	protected UpdateReportingGroupCommand generateUpdateCommand() {
	        UpdateReportingGroupCommand command = new UpdateReportingGroupCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID reportingGroupId = null;
	protected ReportingGroupSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(ReportingGroupTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfReportingGroupList = 0;
}
