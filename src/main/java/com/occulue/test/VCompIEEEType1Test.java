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
 * Test VCompIEEEType1 class.
 *
 * @author your_name_here
 */
public class VCompIEEEType1Test{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VCompIEEEType1Test() {
		subscriber = new VCompIEEEType1Subscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VCompIEEEType1Test.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VCompIEEEType1...");
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
	 * jumpstart the process by instantiating2 VCompIEEEType1
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		vCompIEEEType1Id = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance()
		.createVCompIEEEType1( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance()
				.createVCompIEEEType1( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.vCompIEEEType1Subscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VCompIEEEType1 : " + successValue.getVCompIEEEType1Id());
							  if (successValue.getVCompIEEEType1Id().equals(vCompIEEEType1Id)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVCompIEEEType1List - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VCompIEEEType1 test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vCompIEEEType1 consumed")
					);
			subscriber.vCompIEEEType1Subscribe( vCompIEEEType1Id ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VCompIEEEType1 : " + successValue.getVCompIEEEType1Id() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVCompIEEEType1List = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vCompIEEEType1 for vCompIEEEType1Id consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VCompIEEEType1. 
	 */
	protected VCompIEEEType1 read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VCompIEEEType1" );

		VCompIEEEType1 entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VCompIEEEType1 with primary key" );
		msg.append( vCompIEEEType1Id );
		
		VCompIEEEType1FetchOneSummary fetchOneSummary = new VCompIEEEType1FetchOneSummary( vCompIEEEType1Id );

		try {
			entity = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().getVCompIEEEType1( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VCompIEEEType1 " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VCompIEEEType1.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VCompIEEEType1." );

		StringBuilder msg = new StringBuilder( "Failed to update a VCompIEEEType1 : " );        
		VCompIEEEType1 entity = read();
		UpdateVCompIEEEType1Command command = generateUpdateCommand();
		command.setVCompIEEEType1Id(entity.getVCompIEEEType1Id());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VCompIEEEType1." );

			// for use later on...
			vCompIEEEType1Id = entity.getVCompIEEEType1Id();

			VCompIEEEType1BusinessDelegate proxy = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance();  

			proxy.updateVCompIEEEType1( command ).get();

			LOGGER.info( "-- Successfully saved VCompIEEEType1 - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + vCompIEEEType1Id + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VCompIEEEType1.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VCompIEEEType1." );

		VCompIEEEType1 entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VCompIEEEType1 with id " + vCompIEEEType1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VCompIEEEType1 with id " + vCompIEEEType1Id );

			throw e;
		}

		try{
			VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().delete( new DeleteVCompIEEEType1Command( entity.getVCompIEEEType1Id() ) ).get();
			LOGGER.info( "-- Successfully deleted VCompIEEEType1 with id " + vCompIEEEType1Id );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VCompIEEEType1 with id " + vCompIEEEType1Id );

			throw e;
		}
	}

	/**
	 * get all VCompIEEEType1s.
	 */
	protected List<VCompIEEEType1> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VCompIEEEType1s:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VCompIEEEType1 : " );        
		List<VCompIEEEType1> collection  = new ArrayList<>();

		try {
			// call the static get method on the VCompIEEEType1BusinessDelegate
			collection = VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().getAllVCompIEEEType1();
			assertNotNull( collection, "An Empty collection of VCompIEEEType1 was incorrectly returned.");
			
			// Now print out the values
			VCompIEEEType1 entity = null;            
			Iterator<VCompIEEEType1> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVCompIEEEType1Id(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VCompIEEEType1Test
	 */
	protected VCompIEEEType1Test setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VCompIEEEType1
	 * 
	 * @return CreateVCompIEEEType1Command alias
	 */
	protected CreateVCompIEEEType1Command generateNewCommand() {
        CreateVCompIEEEType1Command command = new CreateVCompIEEEType1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VCompIEEEType1
		 * 
		 * @return UpdateVCompIEEEType1Command alias
		 */
	protected UpdateVCompIEEEType1Command generateUpdateCommand() {
	        UpdateVCompIEEEType1Command command = new UpdateVCompIEEEType1Command( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID vCompIEEEType1Id = null;
	protected VCompIEEEType1Subscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VCompIEEEType1Test.class.getName());
	private String testingStep = "";
	private Integer sizeOfVCompIEEEType1List = 0;
}
