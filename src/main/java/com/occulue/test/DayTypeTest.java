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
 * Test DayType class.
 *
 * @author your_name_here
 */
public class DayTypeTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DayTypeTest() {
		subscriber = new DayTypeSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DayTypeTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DayType...");
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
	 * jumpstart the process by instantiating2 DayType
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dayTypeId = DayTypeBusinessDelegate.getDayTypeInstance()
		.createDayType( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DayTypeBusinessDelegate.getDayTypeInstance()
				.createDayType( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dayTypeSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DayType : " + successValue.getDayTypeId());
							  if (successValue.getDayTypeId().equals(dayTypeId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDayTypeList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DayType test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dayType consumed")
					);
			subscriber.dayTypeSubscribe( dayTypeId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DayType : " + successValue.getDayTypeId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDayTypeList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dayType for dayTypeId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DayType. 
	 */
	protected DayType read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DayType" );

		DayType entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DayType with primary key" );
		msg.append( dayTypeId );
		
		DayTypeFetchOneSummary fetchOneSummary = new DayTypeFetchOneSummary( dayTypeId );

		try {
			entity = DayTypeBusinessDelegate.getDayTypeInstance().getDayType( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DayType " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DayType.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DayType." );

		StringBuilder msg = new StringBuilder( "Failed to update a DayType : " );        
		DayType entity = read();
		UpdateDayTypeCommand command = generateUpdateCommand();
		command.setDayTypeId(entity.getDayTypeId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DayType." );

			// for use later on...
			dayTypeId = entity.getDayTypeId();

			DayTypeBusinessDelegate proxy = DayTypeBusinessDelegate.getDayTypeInstance();  

			proxy.updateDayType( command ).get();

			LOGGER.info( "-- Successfully saved DayType - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dayTypeId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DayType.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DayType." );

		DayType entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DayType with id " + dayTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DayType with id " + dayTypeId );

			throw e;
		}

		try{
			DayTypeBusinessDelegate.getDayTypeInstance().delete( new DeleteDayTypeCommand( entity.getDayTypeId() ) ).get();
			LOGGER.info( "-- Successfully deleted DayType with id " + dayTypeId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DayType with id " + dayTypeId );

			throw e;
		}
	}

	/**
	 * get all DayTypes.
	 */
	protected List<DayType> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DayTypes:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DayType : " );        
		List<DayType> collection  = new ArrayList<>();

		try {
			// call the static get method on the DayTypeBusinessDelegate
			collection = DayTypeBusinessDelegate.getDayTypeInstance().getAllDayType();
			assertNotNull( collection, "An Empty collection of DayType was incorrectly returned.");
			
			// Now print out the values
			DayType entity = null;            
			Iterator<DayType> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDayTypeId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DayTypeTest
	 */
	protected DayTypeTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DayType
	 * 
	 * @return CreateDayTypeCommand alias
	 */
	protected CreateDayTypeCommand generateNewCommand() {
        CreateDayTypeCommand command = new CreateDayTypeCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated DayType
		 * 
		 * @return UpdateDayTypeCommand alias
		 */
	protected UpdateDayTypeCommand generateUpdateCommand() {
	        UpdateDayTypeCommand command = new UpdateDayTypeCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dayTypeId = null;
	protected DayTypeSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DayTypeTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDayTypeList = 0;
}
