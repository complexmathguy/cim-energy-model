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
 * Test EnergySchedulingType class.
 *
 * @author your_name_here
 */
public class EnergySchedulingTypeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public EnergySchedulingTypeTest() {
		subscriber = new EnergySchedulingTypeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate EnergySchedulingTypeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on EnergySchedulingType...");
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
	 * jumpstart the process by instantiating2 EnergySchedulingType
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		energySchedulingTypeId = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance()
		.createEnergySchedulingType( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance()
				.createEnergySchedulingType( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.energySchedulingTypeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for EnergySchedulingType : " + successValue.getEnergySchedulingTypeId());
							  if (successValue.getEnergySchedulingTypeId().equals(energySchedulingTypeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfEnergySchedulingTypeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("EnergySchedulingType test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energySchedulingType consumed")
					);
			subscriber.energySchedulingTypeSubscribe( energySchedulingTypeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for EnergySchedulingType : " + successValue.getEnergySchedulingTypeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfEnergySchedulingTypeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on energySchedulingType for energySchedulingTypeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a EnergySchedulingType. 
	 */
	protected EnergySchedulingType read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created EnergySchedulingType" );

		EnergySchedulingType entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read EnergySchedulingType with primary key" );
		msg.append( energySchedulingTypeId );
		
		EnergySchedulingTypeFetchOneSummary fetchOneSummary = new EnergySchedulingTypeFetchOneSummary( energySchedulingTypeId );

		try {
			entity = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().getEnergySchedulingType( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found EnergySchedulingType " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a EnergySchedulingType.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a EnergySchedulingType." );

		StringBuilder msg = new StringBuilder( "Failed to update a EnergySchedulingType : " );        
		EnergySchedulingType entity = read();
		UpdateEnergySchedulingTypeCommand command = generateUpdateCommand();
		command.setEnergySchedulingTypeId(entity.getEnergySchedulingTypeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created EnergySchedulingType." );

			// for use later on...
			energySchedulingTypeId = entity.getEnergySchedulingTypeId();

			EnergySchedulingTypeBusinessDelegate proxy = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance();  

			proxy.updateEnergySchedulingType( command ).get();

			LOGGER.info( "-- Successfully saved EnergySchedulingType - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + energySchedulingTypeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a EnergySchedulingType.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created EnergySchedulingType." );

		EnergySchedulingType entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read EnergySchedulingType with id " + energySchedulingTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read EnergySchedulingType with id " + energySchedulingTypeId );

			throw e;
		}

		try{
			EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().delete( new DeleteEnergySchedulingTypeCommand( entity.getEnergySchedulingTypeId() ) ).get();
			LOGGER.info( "-- Successfully deleted EnergySchedulingType with id " + energySchedulingTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete EnergySchedulingType with id " + energySchedulingTypeId );

			throw e;
		}
	}

	/**
	 * get all EnergySchedulingTypes.
	 */
	protected List<EnergySchedulingType> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of EnergySchedulingTypes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all EnergySchedulingType : " );        
		List<EnergySchedulingType> collection  = new ArrayList<>();

		try {
			// call the static get method on the EnergySchedulingTypeBusinessDelegate
			collection = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().getAllEnergySchedulingType();
			assertNotNull( collection, "An Empty collection of EnergySchedulingType was incorrectly returned.");
			
			// Now print out the values
			EnergySchedulingType entity = null;            
			Iterator<EnergySchedulingType> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getEnergySchedulingTypeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		EnergySchedulingTypeTest
	 */
	protected EnergySchedulingTypeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated EnergySchedulingType
	 * 
	 * @return CreateEnergySchedulingTypeCommand alias
	 */
	protected CreateEnergySchedulingTypeCommand generateNewCommand() {
        CreateEnergySchedulingTypeCommand command = new CreateEnergySchedulingTypeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated EnergySchedulingType
		 * 
		 * @return UpdateEnergySchedulingTypeCommand alias
		 */
	protected UpdateEnergySchedulingTypeCommand generateUpdateCommand() {
	        UpdateEnergySchedulingTypeCommand command = new UpdateEnergySchedulingTypeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID energySchedulingTypeId = null;
	protected EnergySchedulingTypeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(EnergySchedulingTypeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfEnergySchedulingTypeList = 0;
}
