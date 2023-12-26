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
 * Test EnergySource class.
 *
 * @author your_name_here
 */
public class EnergySourceTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EnergySourceTest() {
		subscriber = new EnergySourceSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EnergySourceTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EnergySource...");
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
	 * jumpstart the process by instantiating2 EnergySource
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		energySourceId = EnergySourceBusinessDelegate.getEnergySourceInstance()
		.createEnergySource( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EnergySourceBusinessDelegate.getEnergySourceInstance()
				.createEnergySource( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.energySourceSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EnergySource : " + successValue.getEnergySourceId());
							  if (successValue.getEnergySourceId().equals(energySourceId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEnergySourceList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EnergySource test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energySource consumed")
					);
			subscriber.energySourceSubscribe( energySourceId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EnergySource : " + successValue.getEnergySourceId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEnergySourceList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energySource for energySourceId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EnergySource. 
	 */
	protected EnergySource read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EnergySource" );

		EnergySource entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EnergySource with primary key" );
		msg.append( energySourceId );
		
		EnergySourceFetchOneSummary fetchOneSummary = new EnergySourceFetchOneSummary( energySourceId );

		try {
			entity = EnergySourceBusinessDelegate.getEnergySourceInstance().getEnergySource( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EnergySource " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EnergySource.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EnergySource." );

		StringBuilder msg = new StringBuilder( "Failed to update a EnergySource : " );        
		EnergySource entity = read();
		UpdateEnergySourceCommand command = generateUpdateCommand();
		command.setEnergySourceId(entity.getEnergySourceId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EnergySource." );

			// for use later on...
			energySourceId = entity.getEnergySourceId();

			EnergySourceBusinessDelegate proxy = EnergySourceBusinessDelegate.getEnergySourceInstance();  

			proxy.updateEnergySource( command ).get();

			LOGGER.info( "-- Successfully saved EnergySource - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + energySourceId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EnergySource.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EnergySource." );

		EnergySource entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EnergySource with id " + energySourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EnergySource with id " + energySourceId );

			throw e;
		}

		try{
			EnergySourceBusinessDelegate.getEnergySourceInstance().delete( new DeleteEnergySourceCommand( entity.getEnergySourceId() ) ).get();
			LOGGER.info( "-- Successfully deleted EnergySource with id " + energySourceId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EnergySource with id " + energySourceId );

			throw e;
		}
	}

	/**
	 * get all EnergySources.
	 */
	protected List<EnergySource> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EnergySources:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EnergySource : " );        
		List<EnergySource> collection  = new ArrayList<>();

		try {
			// call the static get method on the EnergySourceBusinessDelegate
			collection = EnergySourceBusinessDelegate.getEnergySourceInstance().getAllEnergySource();
			assertNotNull( collection, "An Empty collection of EnergySource was incorrectly returned.");
			
			// Now print out the values
			EnergySource entity = null;            
			Iterator<EnergySource> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEnergySourceId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EnergySourceTest
	 */
	protected EnergySourceTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EnergySource
	 * 
	 * @return CreateEnergySourceCommand alias
	 */
	protected CreateEnergySourceCommand generateNewCommand() {
        CreateEnergySourceCommand command = new CreateEnergySourceCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EnergySource
		 * 
		 * @return UpdateEnergySourceCommand alias
		 */
	protected UpdateEnergySourceCommand generateUpdateCommand() {
	        UpdateEnergySourceCommand command = new UpdateEnergySourceCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID energySourceId = null;
	protected EnergySourceSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EnergySourceTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEnergySourceList = 0;
}
