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
 * Test EquipmentContainer class.
 *
 * @author your_name_here
 */
public class EquipmentContainerTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EquipmentContainerTest() {
		subscriber = new EquipmentContainerSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EquipmentContainerTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EquipmentContainer...");
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
	 * jumpstart the process by instantiating2 EquipmentContainer
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		equipmentContainerId = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance()
		.createEquipmentContainer( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EquipmentContainerBusinessDelegate.getEquipmentContainerInstance()
				.createEquipmentContainer( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.equipmentContainerSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EquipmentContainer : " + successValue.getEquipmentContainerId());
							  if (successValue.getEquipmentContainerId().equals(equipmentContainerId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEquipmentContainerList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EquipmentContainer test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentContainer consumed")
					);
			subscriber.equipmentContainerSubscribe( equipmentContainerId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EquipmentContainer : " + successValue.getEquipmentContainerId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEquipmentContainerList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on equipmentContainer for equipmentContainerId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EquipmentContainer. 
	 */
	protected EquipmentContainer read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EquipmentContainer" );

		EquipmentContainer entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EquipmentContainer with primary key" );
		msg.append( equipmentContainerId );
		
		EquipmentContainerFetchOneSummary fetchOneSummary = new EquipmentContainerFetchOneSummary( equipmentContainerId );

		try {
			entity = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().getEquipmentContainer( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EquipmentContainer " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EquipmentContainer.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EquipmentContainer." );

		StringBuilder msg = new StringBuilder( "Failed to update a EquipmentContainer : " );        
		EquipmentContainer entity = read();
		UpdateEquipmentContainerCommand command = generateUpdateCommand();
		command.setEquipmentContainerId(entity.getEquipmentContainerId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EquipmentContainer." );

			// for use later on...
			equipmentContainerId = entity.getEquipmentContainerId();

			EquipmentContainerBusinessDelegate proxy = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance();  

			proxy.updateEquipmentContainer( command ).get();

			LOGGER.info( "-- Successfully saved EquipmentContainer - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + equipmentContainerId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EquipmentContainer.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EquipmentContainer." );

		EquipmentContainer entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EquipmentContainer with id " + equipmentContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EquipmentContainer with id " + equipmentContainerId );

			throw e;
		}

		try{
			EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().delete( new DeleteEquipmentContainerCommand( entity.getEquipmentContainerId() ) ).get();
			LOGGER.info( "-- Successfully deleted EquipmentContainer with id " + equipmentContainerId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EquipmentContainer with id " + equipmentContainerId );

			throw e;
		}
	}

	/**
	 * get all EquipmentContainers.
	 */
	protected List<EquipmentContainer> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EquipmentContainers:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EquipmentContainer : " );        
		List<EquipmentContainer> collection  = new ArrayList<>();

		try {
			// call the static get method on the EquipmentContainerBusinessDelegate
			collection = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().getAllEquipmentContainer();
			assertNotNull( collection, "An Empty collection of EquipmentContainer was incorrectly returned.");
			
			// Now print out the values
			EquipmentContainer entity = null;            
			Iterator<EquipmentContainer> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEquipmentContainerId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EquipmentContainerTest
	 */
	protected EquipmentContainerTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EquipmentContainer
	 * 
	 * @return CreateEquipmentContainerCommand alias
	 */
	protected CreateEquipmentContainerCommand generateNewCommand() {
        CreateEquipmentContainerCommand command = new CreateEquipmentContainerCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EquipmentContainer
		 * 
		 * @return UpdateEquipmentContainerCommand alias
		 */
	protected UpdateEquipmentContainerCommand generateUpdateCommand() {
	        UpdateEquipmentContainerCommand command = new UpdateEquipmentContainerCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID equipmentContainerId = null;
	protected EquipmentContainerSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EquipmentContainerTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEquipmentContainerList = 0;
}
