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
 * Test DynamicsFunctionBlock class.
 *
 * @author your_name_here
 */
public class DynamicsFunctionBlockTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public DynamicsFunctionBlockTest() {
		subscriber = new DynamicsFunctionBlockSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate DynamicsFunctionBlockTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on DynamicsFunctionBlock...");
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
	 * jumpstart the process by instantiating2 DynamicsFunctionBlock
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		dynamicsFunctionBlockId = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
		.createDynamicsFunctionBlock( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance()
				.createDynamicsFunctionBlock( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.dynamicsFunctionBlockSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for DynamicsFunctionBlock : " + successValue.getDynamicsFunctionBlockId());
							  if (successValue.getDynamicsFunctionBlockId().equals(dynamicsFunctionBlockId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfDynamicsFunctionBlockList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("DynamicsFunctionBlock test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsFunctionBlock consumed")
					);
			subscriber.dynamicsFunctionBlockSubscribe( dynamicsFunctionBlockId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for DynamicsFunctionBlock : " + successValue.getDynamicsFunctionBlockId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfDynamicsFunctionBlockList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on dynamicsFunctionBlock for dynamicsFunctionBlockId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a DynamicsFunctionBlock. 
	 */
	protected DynamicsFunctionBlock read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created DynamicsFunctionBlock" );

		DynamicsFunctionBlock entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read DynamicsFunctionBlock with primary key" );
		msg.append( dynamicsFunctionBlockId );
		
		DynamicsFunctionBlockFetchOneSummary fetchOneSummary = new DynamicsFunctionBlockFetchOneSummary( dynamicsFunctionBlockId );

		try {
			entity = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().getDynamicsFunctionBlock( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found DynamicsFunctionBlock " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a DynamicsFunctionBlock.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a DynamicsFunctionBlock." );

		StringBuilder msg = new StringBuilder( "Failed to update a DynamicsFunctionBlock : " );        
		DynamicsFunctionBlock entity = read();
		UpdateDynamicsFunctionBlockCommand command = generateUpdateCommand();
		command.setDynamicsFunctionBlockId(entity.getDynamicsFunctionBlockId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created DynamicsFunctionBlock." );

			// for use later on...
			dynamicsFunctionBlockId = entity.getDynamicsFunctionBlockId();

			DynamicsFunctionBlockBusinessDelegate proxy = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance();  

			proxy.updateDynamicsFunctionBlock( command ).get();

			LOGGER.info( "-- Successfully saved DynamicsFunctionBlock - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + dynamicsFunctionBlockId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a DynamicsFunctionBlock.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created DynamicsFunctionBlock." );

		DynamicsFunctionBlock entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read DynamicsFunctionBlock with id " + dynamicsFunctionBlockId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read DynamicsFunctionBlock with id " + dynamicsFunctionBlockId );

			throw e;
		}

		try{
			DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().delete( new DeleteDynamicsFunctionBlockCommand( entity.getDynamicsFunctionBlockId() ) ).get();
			LOGGER.info( "-- Successfully deleted DynamicsFunctionBlock with id " + dynamicsFunctionBlockId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete DynamicsFunctionBlock with id " + dynamicsFunctionBlockId );

			throw e;
		}
	}

	/**
	 * get all DynamicsFunctionBlocks.
	 */
	protected List<DynamicsFunctionBlock> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of DynamicsFunctionBlocks:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all DynamicsFunctionBlock : " );        
		List<DynamicsFunctionBlock> collection  = new ArrayList<>();

		try {
			// call the static get method on the DynamicsFunctionBlockBusinessDelegate
			collection = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().getAllDynamicsFunctionBlock();
			assertNotNull( collection, "An Empty collection of DynamicsFunctionBlock was incorrectly returned.");
			
			// Now print out the values
			DynamicsFunctionBlock entity = null;            
			Iterator<DynamicsFunctionBlock> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getDynamicsFunctionBlockId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		DynamicsFunctionBlockTest
	 */
	protected DynamicsFunctionBlockTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated DynamicsFunctionBlock
	 * 
	 * @return CreateDynamicsFunctionBlockCommand alias
	 */
	protected CreateDynamicsFunctionBlockCommand generateNewCommand() {
        CreateDynamicsFunctionBlockCommand command = new CreateDynamicsFunctionBlockCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated DynamicsFunctionBlock
		 * 
		 * @return UpdateDynamicsFunctionBlockCommand alias
		 */
	protected UpdateDynamicsFunctionBlockCommand generateUpdateCommand() {
	        UpdateDynamicsFunctionBlockCommand command = new UpdateDynamicsFunctionBlockCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID dynamicsFunctionBlockId = null;
	protected DynamicsFunctionBlockSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(DynamicsFunctionBlockTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfDynamicsFunctionBlockList = 0;
}
