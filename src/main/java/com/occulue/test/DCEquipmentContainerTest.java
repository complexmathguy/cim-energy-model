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
 * Test DCEquipmentContainer class.
 *
 * @author your_name_here
 */
public class DCEquipmentContainerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DCEquipmentContainerTest() {
		subscriber = new DCEquipmentContainerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DCEquipmentContainerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DCEquipmentContainer...");
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
	 * jumpstart the process by instantiating2 DCEquipmentContainer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dCEquipmentContainerId = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance()
		.createDCEquipmentContainer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance()
				.createDCEquipmentContainer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dCEquipmentContainerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DCEquipmentContainer : " + successValue.getDCEquipmentContainerId());
							  if (successValue.getDCEquipmentContainerId().equals(dCEquipmentContainerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDCEquipmentContainerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DCEquipmentContainer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCEquipmentContainer consumed")
					);
			subscriber.dCEquipmentContainerSubscribe( dCEquipmentContainerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DCEquipmentContainer : " + successValue.getDCEquipmentContainerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDCEquipmentContainerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dCEquipmentContainer for dCEquipmentContainerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DCEquipmentContainer. 
	 */
	protected DCEquipmentContainer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DCEquipmentContainer" );

		DCEquipmentContainer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DCEquipmentContainer with primary key" );
		msg.append( dCEquipmentContainerId );
		
		DCEquipmentContainerFetchOneSummary fetchOneSummary = new DCEquipmentContainerFetchOneSummary( dCEquipmentContainerId );

		try {
			entity = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().getDCEquipmentContainer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DCEquipmentContainer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DCEquipmentContainer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DCEquipmentContainer." );

		StringBuilder msg = new StringBuilder( "Failed to update a DCEquipmentContainer : " );        
		DCEquipmentContainer entity = read();
		UpdateDCEquipmentContainerCommand command = generateUpdateCommand();
		command.setDCEquipmentContainerId(entity.getDCEquipmentContainerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DCEquipmentContainer." );

			// for use later on...
			dCEquipmentContainerId = entity.getDCEquipmentContainerId();

			DCEquipmentContainerBusinessDelegate proxy = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance();  

			proxy.updateDCEquipmentContainer( command ).get();

			LOGGER.info( "-- Successfully saved DCEquipmentContainer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dCEquipmentContainerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DCEquipmentContainer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DCEquipmentContainer." );

		DCEquipmentContainer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DCEquipmentContainer with id " + dCEquipmentContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DCEquipmentContainer with id " + dCEquipmentContainerId );

			throw e;
		}

		try{
			DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().delete( new DeleteDCEquipmentContainerCommand( entity.getDCEquipmentContainerId() ) ).get();
			LOGGER.info( "-- Successfully deleted DCEquipmentContainer with id " + dCEquipmentContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DCEquipmentContainer with id " + dCEquipmentContainerId );

			throw e;
		}
	}

	/**
	 * get all DCEquipmentContainers.
	 */
	protected List<DCEquipmentContainer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DCEquipmentContainers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DCEquipmentContainer : " );        
		List<DCEquipmentContainer> collection  = new ArrayList<>();

		try {
			// call the static get method on the DCEquipmentContainerBusinessDelegate
			collection = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().getAllDCEquipmentContainer();
			assertNotNull( collection, "An Empty collection of DCEquipmentContainer was incorrectly returned.");
			
			// Now print out the values
			DCEquipmentContainer entity = null;            
			Iterator<DCEquipmentContainer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDCEquipmentContainerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DCEquipmentContainerTest
	 */
	protected DCEquipmentContainerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DCEquipmentContainer
	 * 
	 * @return CreateDCEquipmentContainerCommand alias
	 */
	protected CreateDCEquipmentContainerCommand generateNewCommand() {
        CreateDCEquipmentContainerCommand command = new CreateDCEquipmentContainerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DCEquipmentContainer
		 * 
		 * @return UpdateDCEquipmentContainerCommand alias
		 */
	protected UpdateDCEquipmentContainerCommand generateUpdateCommand() {
	        UpdateDCEquipmentContainerCommand command = new UpdateDCEquipmentContainerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dCEquipmentContainerId = null;
	protected DCEquipmentContainerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DCEquipmentContainerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDCEquipmentContainerList = 0;
}
