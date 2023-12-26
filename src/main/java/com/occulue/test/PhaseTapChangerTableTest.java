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
 * Test PhaseTapChangerTable class.
 *
 * @author your_name_here
 */
public class PhaseTapChangerTableTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public PhaseTapChangerTableTest() {
		subscriber = new PhaseTapChangerTableSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate PhaseTapChangerTableTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on PhaseTapChangerTable...");
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
	 * jumpstart the process by instantiating2 PhaseTapChangerTable
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		phaseTapChangerTableId = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance()
		.createPhaseTapChangerTable( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance()
				.createPhaseTapChangerTable( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.phaseTapChangerTableSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for PhaseTapChangerTable : " + successValue.getPhaseTapChangerTableId());
							  if (successValue.getPhaseTapChangerTableId().equals(phaseTapChangerTableId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfPhaseTapChangerTableList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("PhaseTapChangerTable test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTable consumed")
					);
			subscriber.phaseTapChangerTableSubscribe( phaseTapChangerTableId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for PhaseTapChangerTable : " + successValue.getPhaseTapChangerTableId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfPhaseTapChangerTableList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on phaseTapChangerTable for phaseTapChangerTableId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a PhaseTapChangerTable. 
	 */
	protected PhaseTapChangerTable read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created PhaseTapChangerTable" );

		PhaseTapChangerTable entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read PhaseTapChangerTable with primary key" );
		msg.append( phaseTapChangerTableId );
		
		PhaseTapChangerTableFetchOneSummary fetchOneSummary = new PhaseTapChangerTableFetchOneSummary( phaseTapChangerTableId );

		try {
			entity = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().getPhaseTapChangerTable( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found PhaseTapChangerTable " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a PhaseTapChangerTable.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a PhaseTapChangerTable." );

		StringBuilder msg = new StringBuilder( "Failed to update a PhaseTapChangerTable : " );        
		PhaseTapChangerTable entity = read();
		UpdatePhaseTapChangerTableCommand command = generateUpdateCommand();
		command.setPhaseTapChangerTableId(entity.getPhaseTapChangerTableId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created PhaseTapChangerTable." );

			// for use later on...
			phaseTapChangerTableId = entity.getPhaseTapChangerTableId();

			PhaseTapChangerTableBusinessDelegate proxy = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance();  

			proxy.updatePhaseTapChangerTable( command ).get();

			LOGGER.info( "-- Successfully saved PhaseTapChangerTable - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + phaseTapChangerTableId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a PhaseTapChangerTable.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created PhaseTapChangerTable." );

		PhaseTapChangerTable entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read PhaseTapChangerTable with id " + phaseTapChangerTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read PhaseTapChangerTable with id " + phaseTapChangerTableId );

			throw e;
		}

		try{
			PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().delete( new DeletePhaseTapChangerTableCommand( entity.getPhaseTapChangerTableId() ) ).get();
			LOGGER.info( "-- Successfully deleted PhaseTapChangerTable with id " + phaseTapChangerTableId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete PhaseTapChangerTable with id " + phaseTapChangerTableId );

			throw e;
		}
	}

	/**
	 * get all PhaseTapChangerTables.
	 */
	protected List<PhaseTapChangerTable> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of PhaseTapChangerTables:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all PhaseTapChangerTable : " );        
		List<PhaseTapChangerTable> collection  = new ArrayList<>();

		try {
			// call the static get method on the PhaseTapChangerTableBusinessDelegate
			collection = PhaseTapChangerTableBusinessDelegate.getPhaseTapChangerTableInstance().getAllPhaseTapChangerTable();
			assertNotNull( collection, "An Empty collection of PhaseTapChangerTable was incorrectly returned.");
			
			// Now print out the values
			PhaseTapChangerTable entity = null;            
			Iterator<PhaseTapChangerTable> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getPhaseTapChangerTableId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		PhaseTapChangerTableTest
	 */
	protected PhaseTapChangerTableTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated PhaseTapChangerTable
	 * 
	 * @return CreatePhaseTapChangerTableCommand alias
	 */
	protected CreatePhaseTapChangerTableCommand generateNewCommand() {
        CreatePhaseTapChangerTableCommand command = new CreatePhaseTapChangerTableCommand( null );
		
		return( command );
	}

		/**
		 * Returns a new populated PhaseTapChangerTable
		 * 
		 * @return UpdatePhaseTapChangerTableCommand alias
		 */
	protected UpdatePhaseTapChangerTableCommand generateUpdateCommand() {
	        UpdatePhaseTapChangerTableCommand command = new UpdatePhaseTapChangerTableCommand( null );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID phaseTapChangerTableId = null;
	protected PhaseTapChangerTableSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(PhaseTapChangerTableTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfPhaseTapChangerTableList = 0;
}
