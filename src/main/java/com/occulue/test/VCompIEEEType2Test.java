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
 * Test VCompIEEEType2 class.
 *
 * @author your_name_here
 */
public class VCompIEEEType2Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VCompIEEEType2Test() {
		subscriber = new VCompIEEEType2Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VCompIEEEType2Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VCompIEEEType2...");
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
	 * jumpstart the process by instantiating2 VCompIEEEType2
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		vCompIEEEType2Id = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance()
		.createVCompIEEEType2( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance()
				.createVCompIEEEType2( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.vCompIEEEType2Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VCompIEEEType2 : " + successValue.getVCompIEEEType2Id());
							  if (successValue.getVCompIEEEType2Id().equals(vCompIEEEType2Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVCompIEEEType2List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VCompIEEEType2 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vCompIEEEType2 consumed")
					);
			subscriber.vCompIEEEType2Subscribe( vCompIEEEType2Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VCompIEEEType2 : " + successValue.getVCompIEEEType2Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVCompIEEEType2List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vCompIEEEType2 for vCompIEEEType2Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VCompIEEEType2. 
	 */
	protected VCompIEEEType2 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VCompIEEEType2" );

		VCompIEEEType2 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VCompIEEEType2 with primary key" );
		msg.append( vCompIEEEType2Id );
		
		VCompIEEEType2FetchOneSummary fetchOneSummary = new VCompIEEEType2FetchOneSummary( vCompIEEEType2Id );

		try {
			entity = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().getVCompIEEEType2( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VCompIEEEType2 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VCompIEEEType2.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VCompIEEEType2." );

		StringBuilder msg = new StringBuilder( "Failed to update a VCompIEEEType2 : " );        
		VCompIEEEType2 entity = read();
		UpdateVCompIEEEType2Command command = generateUpdateCommand();
		command.setVCompIEEEType2Id(entity.getVCompIEEEType2Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VCompIEEEType2." );

			// for use later on...
			vCompIEEEType2Id = entity.getVCompIEEEType2Id();

			VCompIEEEType2BusinessDelegate proxy = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance();  

			proxy.updateVCompIEEEType2( command ).get();

			LOGGER.info( "-- Successfully saved VCompIEEEType2 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + vCompIEEEType2Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VCompIEEEType2.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VCompIEEEType2." );

		VCompIEEEType2 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VCompIEEEType2 with id " + vCompIEEEType2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VCompIEEEType2 with id " + vCompIEEEType2Id );

			throw e;
		}

		try{
			VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().delete( new DeleteVCompIEEEType2Command( entity.getVCompIEEEType2Id() ) ).get();
			LOGGER.info( "-- Successfully deleted VCompIEEEType2 with id " + vCompIEEEType2Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VCompIEEEType2 with id " + vCompIEEEType2Id );

			throw e;
		}
	}

	/**
	 * get all VCompIEEEType2s.
	 */
	protected List<VCompIEEEType2> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VCompIEEEType2s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VCompIEEEType2 : " );        
		List<VCompIEEEType2> collection  = new ArrayList<>();

		try {
			// call the static get method on the VCompIEEEType2BusinessDelegate
			collection = VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().getAllVCompIEEEType2();
			assertNotNull( collection, "An Empty collection of VCompIEEEType2 was incorrectly returned.");
			
			// Now print out the values
			VCompIEEEType2 entity = null;            
			Iterator<VCompIEEEType2> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVCompIEEEType2Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VCompIEEEType2Test
	 */
	protected VCompIEEEType2Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VCompIEEEType2
	 * 
	 * @return CreateVCompIEEEType2Command alias
	 */
	protected CreateVCompIEEEType2Command generateNewCommand() {
        CreateVCompIEEEType2Command command = new CreateVCompIEEEType2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VCompIEEEType2
		 * 
		 * @return UpdateVCompIEEEType2Command alias
		 */
	protected UpdateVCompIEEEType2Command generateUpdateCommand() {
	        UpdateVCompIEEEType2Command command = new UpdateVCompIEEEType2Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID vCompIEEEType2Id = null;
	protected VCompIEEEType2Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VCompIEEEType2Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfVCompIEEEType2List = 0;
}
