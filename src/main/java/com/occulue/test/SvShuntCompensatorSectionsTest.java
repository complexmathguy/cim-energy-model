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
 * Test SvShuntCompensatorSections class.
 *
 * @author your_name_here
 */
public class SvShuntCompensatorSectionsTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public SvShuntCompensatorSectionsTest() {
		subscriber = new SvShuntCompensatorSectionsSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate SvShuntCompensatorSectionsTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on SvShuntCompensatorSections...");
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
	 * jumpstart the process by instantiating2 SvShuntCompensatorSections
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		svShuntCompensatorSectionsId = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
		.createSvShuntCompensatorSections( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance()
				.createSvShuntCompensatorSections( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.svShuntCompensatorSectionsSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for SvShuntCompensatorSections : " + successValue.getSvShuntCompensatorSectionsId());
							  if (successValue.getSvShuntCompensatorSectionsId().equals(svShuntCompensatorSectionsId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfSvShuntCompensatorSectionsList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("SvShuntCompensatorSections test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svShuntCompensatorSections consumed")
					);
			subscriber.svShuntCompensatorSectionsSubscribe( svShuntCompensatorSectionsId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for SvShuntCompensatorSections : " + successValue.getSvShuntCompensatorSectionsId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfSvShuntCompensatorSectionsList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on svShuntCompensatorSections for svShuntCompensatorSectionsId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a SvShuntCompensatorSections. 
	 */
	protected SvShuntCompensatorSections read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created SvShuntCompensatorSections" );

		SvShuntCompensatorSections entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read SvShuntCompensatorSections with primary key" );
		msg.append( svShuntCompensatorSectionsId );
		
		SvShuntCompensatorSectionsFetchOneSummary fetchOneSummary = new SvShuntCompensatorSectionsFetchOneSummary( svShuntCompensatorSectionsId );

		try {
			entity = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().getSvShuntCompensatorSections( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found SvShuntCompensatorSections " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a SvShuntCompensatorSections.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a SvShuntCompensatorSections." );

		StringBuilder msg = new StringBuilder( "Failed to update a SvShuntCompensatorSections : " );        
		SvShuntCompensatorSections entity = read();
		UpdateSvShuntCompensatorSectionsCommand command = generateUpdateCommand();
		command.setSvShuntCompensatorSectionsId(entity.getSvShuntCompensatorSectionsId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created SvShuntCompensatorSections." );

			// for use later on...
			svShuntCompensatorSectionsId = entity.getSvShuntCompensatorSectionsId();

			SvShuntCompensatorSectionsBusinessDelegate proxy = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance();  

			proxy.updateSvShuntCompensatorSections( command ).get();

			LOGGER.info( "-- Successfully saved SvShuntCompensatorSections - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + svShuntCompensatorSectionsId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a SvShuntCompensatorSections.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created SvShuntCompensatorSections." );

		SvShuntCompensatorSections entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read SvShuntCompensatorSections with id " + svShuntCompensatorSectionsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read SvShuntCompensatorSections with id " + svShuntCompensatorSectionsId );

			throw e;
		}

		try{
			SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().delete( new DeleteSvShuntCompensatorSectionsCommand( entity.getSvShuntCompensatorSectionsId() ) ).get();
			LOGGER.info( "-- Successfully deleted SvShuntCompensatorSections with id " + svShuntCompensatorSectionsId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete SvShuntCompensatorSections with id " + svShuntCompensatorSectionsId );

			throw e;
		}
	}

	/**
	 * get all SvShuntCompensatorSectionss.
	 */
	protected List<SvShuntCompensatorSections> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of SvShuntCompensatorSectionss:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all SvShuntCompensatorSections : " );        
		List<SvShuntCompensatorSections> collection  = new ArrayList<>();

		try {
			// call the static get method on the SvShuntCompensatorSectionsBusinessDelegate
			collection = SvShuntCompensatorSectionsBusinessDelegate.getSvShuntCompensatorSectionsInstance().getAllSvShuntCompensatorSections();
			assertNotNull( collection, "An Empty collection of SvShuntCompensatorSections was incorrectly returned.");
			
			// Now print out the values
			SvShuntCompensatorSections entity = null;            
			Iterator<SvShuntCompensatorSections> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getSvShuntCompensatorSectionsId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		SvShuntCompensatorSectionsTest
	 */
	protected SvShuntCompensatorSectionsTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated SvShuntCompensatorSections
	 * 
	 * @return CreateSvShuntCompensatorSectionsCommand alias
	 */
	protected CreateSvShuntCompensatorSectionsCommand generateNewCommand() {
        CreateSvShuntCompensatorSectionsCommand command = new CreateSvShuntCompensatorSectionsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated SvShuntCompensatorSections
		 * 
		 * @return UpdateSvShuntCompensatorSectionsCommand alias
		 */
	protected UpdateSvShuntCompensatorSectionsCommand generateUpdateCommand() {
	        UpdateSvShuntCompensatorSectionsCommand command = new UpdateSvShuntCompensatorSectionsCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID svShuntCompensatorSectionsId = null;
	protected SvShuntCompensatorSectionsSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(SvShuntCompensatorSectionsTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfSvShuntCompensatorSectionsList = 0;
}
