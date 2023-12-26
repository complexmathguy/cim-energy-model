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
 * Test EnergyArea class.
 *
 * @author your_name_here
 */
public class EnergyAreaTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EnergyAreaTest() {
		subscriber = new EnergyAreaSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EnergyAreaTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EnergyArea...");
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
	 * jumpstart the process by instantiating2 EnergyArea
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		energyAreaId = EnergyAreaBusinessDelegate.getEnergyAreaInstance()
		.createEnergyArea( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EnergyAreaBusinessDelegate.getEnergyAreaInstance()
				.createEnergyArea( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.energyAreaSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EnergyArea : " + successValue.getEnergyAreaId());
							  if (successValue.getEnergyAreaId().equals(energyAreaId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEnergyAreaList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EnergyArea test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energyArea consumed")
					);
			subscriber.energyAreaSubscribe( energyAreaId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EnergyArea : " + successValue.getEnergyAreaId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEnergyAreaList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energyArea for energyAreaId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EnergyArea. 
	 */
	protected EnergyArea read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EnergyArea" );

		EnergyArea entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EnergyArea with primary key" );
		msg.append( energyAreaId );
		
		EnergyAreaFetchOneSummary fetchOneSummary = new EnergyAreaFetchOneSummary( energyAreaId );

		try {
			entity = EnergyAreaBusinessDelegate.getEnergyAreaInstance().getEnergyArea( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EnergyArea " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EnergyArea.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EnergyArea." );

		StringBuilder msg = new StringBuilder( "Failed to update a EnergyArea : " );        
		EnergyArea entity = read();
		UpdateEnergyAreaCommand command = generateUpdateCommand();
		command.setEnergyAreaId(entity.getEnergyAreaId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EnergyArea." );

			// for use later on...
			energyAreaId = entity.getEnergyAreaId();

			EnergyAreaBusinessDelegate proxy = EnergyAreaBusinessDelegate.getEnergyAreaInstance();  

			proxy.updateEnergyArea( command ).get();

			LOGGER.info( "-- Successfully saved EnergyArea - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + energyAreaId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EnergyArea.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EnergyArea." );

		EnergyArea entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EnergyArea with id " + energyAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EnergyArea with id " + energyAreaId );

			throw e;
		}

		try{
			EnergyAreaBusinessDelegate.getEnergyAreaInstance().delete( new DeleteEnergyAreaCommand( entity.getEnergyAreaId() ) ).get();
			LOGGER.info( "-- Successfully deleted EnergyArea with id " + energyAreaId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EnergyArea with id " + energyAreaId );

			throw e;
		}
	}

	/**
	 * get all EnergyAreas.
	 */
	protected List<EnergyArea> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EnergyAreas:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EnergyArea : " );        
		List<EnergyArea> collection  = new ArrayList<>();

		try {
			// call the static get method on the EnergyAreaBusinessDelegate
			collection = EnergyAreaBusinessDelegate.getEnergyAreaInstance().getAllEnergyArea();
			assertNotNull( collection, "An Empty collection of EnergyArea was incorrectly returned.");
			
			// Now print out the values
			EnergyArea entity = null;            
			Iterator<EnergyArea> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEnergyAreaId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EnergyAreaTest
	 */
	protected EnergyAreaTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EnergyArea
	 * 
	 * @return CreateEnergyAreaCommand alias
	 */
	protected CreateEnergyAreaCommand generateNewCommand() {
        CreateEnergyAreaCommand command = new CreateEnergyAreaCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EnergyArea
		 * 
		 * @return UpdateEnergyAreaCommand alias
		 */
	protected UpdateEnergyAreaCommand generateUpdateCommand() {
	        UpdateEnergyAreaCommand command = new UpdateEnergyAreaCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID energyAreaId = null;
	protected EnergyAreaSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EnergyAreaTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEnergyAreaList = 0;
}
