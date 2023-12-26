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
 * Test VsConverter class.
 *
 * @author your_name_here
 */
public class VsConverterTest{

    // ------------------------------------
	// default constructor
    // ------------------------------------
	public VsConverterTest() {
		subscriber = new VsConverterSubscriber();
	}

	// test methods
	@Test
	/*
	 * Initiate VsConverterTest.
	 */
	public void startTest() throws Throwable {
		try {
			LOGGER.info("**********************************************************");
			LOGGER.info("Beginning test on VsConverter...");
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
	 * jumpstart the process by instantiating2 VsConverter
	 */
	protected void jumpStart() throws Throwable {
		LOGGER.info( "\n======== create instances to get the ball rolling  ======== ");

		vsConverterId = VsConverterBusinessDelegate.getVsConverterInstance()
		.createVsConverter( generateNewCommand() )
		.get();

		// ---------------------------------------------
		// set up query subscriptions after the 1st create
		// ---------------------------------------------
		testingStep = "create";
		setUpQuerySubscriptions();

		VsConverterBusinessDelegate.getVsConverterInstance()
				.createVsConverter( generateNewCommand() )
				.get();

	}

	/** 
	 * Set up query subscriptions
	 */
	protected void setUpQuerySubscriptions() throws Throwable {
		LOGGER.info( "\n======== Setting Up Query Subscriptions ======== ");
			
		try {            
			subscriber.vsConverterSubscribe().updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetAll update received for VsConverter : " + successValue.getVsConverterId());
							  if (successValue.getVsConverterId().equals(vsConverterId)) {
								  if (testingStep.equals("create")) {
									  testingStep = "update";
									  update();
								  } else if (testingStep.equals("delete")) {
									  testingStep = "complete";
									  state( getAll().size() == sizeOfVsConverterList - 1 , "value not deleted from list");
									  LOGGER.info("**********************************************************");
									  LOGGER.info("VsConverter test completed successfully...");
									  LOGGER.info("**********************************************************\n");
								  }
							  }
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vsConverter consumed")
					);
			subscriber.vsConverterSubscribe( vsConverterId ).updates().subscribe(
					  successValue -> {
						  LOGGER.info(successValue.toString());
						  try {
							  LOGGER.info("GetOne update received for VsConverter : " + successValue.getVsConverterId() + " in step " + testingStep);
							  testingStep = "delete";
							  sizeOfVsConverterList = getAll().size();
							  delete();
						  } catch( Throwable exc ) {
							  LOGGER.warning( exc.getMessage() );
						  }
					  },
					  error -> LOGGER.warning(error.getMessage()),
					  () -> LOGGER.info("Subscription on vsConverter for vsConverterId consumed")

					);
			

			}
			catch (Exception e) {
				LOGGER.warning( e.getMessage() );
				throw e;
			}
		}
		
		/** 
	 * read a VsConverter. 
	 */
	protected VsConverter read() throws Throwable {
		LOGGER.info( "\n======== READ ======== ");
		LOGGER.info( "-- Reading a previously created VsConverter" );

		VsConverter entity = null;
		StringBuilder msg = new StringBuilder( "-- Failed to read VsConverter with primary key" );
		msg.append( vsConverterId );
		
		VsConverterFetchOneSummary fetchOneSummary = new VsConverterFetchOneSummary( vsConverterId );

		try {
			entity = VsConverterBusinessDelegate.getVsConverterInstance().getVsConverter( fetchOneSummary );

			assertNotNull( entity,msg.toString() );

			LOGGER.info( "-- Successfully found VsConverter " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : " + e );

			throw e;
		}
		
		return entity;
	}

	/** 
	 * updating a VsConverter.
	 */
	protected void update() throws Throwable {
		LOGGER.info( "\n======== UPDATE ======== ");
		LOGGER.info( "-- Attempting to update a VsConverter." );

		StringBuilder msg = new StringBuilder( "Failed to update a VsConverter : " );        
		VsConverter entity = read();
		UpdateVsConverterCommand command = generateUpdateCommand();
		command.setVsConverterId(entity.getVsConverterId());

		try {            
			assertNotNull( entity, msg.toString() );

			LOGGER.info( "-- Now updating the created VsConverter." );

			// for use later on...
			vsConverterId = entity.getVsConverterId();

			VsConverterBusinessDelegate proxy = VsConverterBusinessDelegate.getVsConverterInstance();  

			proxy.updateVsConverter( command ).get();

			LOGGER.info( "-- Successfully saved VsConverter - " + entity.toString() );
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( msg.toString() + " : primarykey = " + vsConverterId + " : command -" +  command + " : " + e );

			throw e;
		}
	}

	/** 
	 * delete a VsConverter.
	 */
	protected void delete() throws Throwable {
		LOGGER.info( "\n======== DELETE ======== ");
		LOGGER.info( "-- Deleting a previously created VsConverter." );

		VsConverter entity = null;
		
		try{
		    entity = read(); 
			LOGGER.info( "-- Successfully read VsConverter with id " + vsConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to read VsConverter with id " + vsConverterId );

			throw e;
		}

		try{
			VsConverterBusinessDelegate.getVsConverterInstance().delete( new DeleteVsConverterCommand( entity.getVsConverterId() ) ).get();
			LOGGER.info( "-- Successfully deleted VsConverter with id " + vsConverterId );            
		}
		catch ( Throwable e ) {
			LOGGER.warning( unexpectedErrorMsg );
			LOGGER.warning( "-- Failed to delete VsConverter with id " + vsConverterId );

			throw e;
		}
	}

	/**
	 * get all VsConverters.
	 */
	protected List<VsConverter> getAll() throws Throwable {    
		LOGGER.info( "======== GETALL ======== ");
		LOGGER.info( "-- Retrieving Collection of VsConverters:" );

		StringBuilder msg = new StringBuilder( "-- Failed to get all VsConverter : " );        
		List<VsConverter> collection  = new ArrayList<>();

		try {
			// call the static get method on the VsConverterBusinessDelegate
			collection = VsConverterBusinessDelegate.getVsConverterInstance().getAllVsConverter();
			assertNotNull( collection, "An Empty collection of VsConverter was incorrectly returned.");
			
			// Now print out the values
			VsConverter entity = null;            
			Iterator<VsConverter> iter = collection.iterator();
			int index = 1;

			while( iter.hasNext() ) {
				// Retrieve the entity   
				entity = iter.next();

				assertNotNull( entity,"-- null entity in Collection." );
				assertNotNull( entity.getVsConverterId(), "-- entity in Collection has a null primary key" );        

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
	 * @return		VsConverterTest
	 */
	protected VsConverterTest setHandler(Handler handler) {
		if ( handler != null )
			LOGGER.addHandler(handler); 
		return this;
	}

	/**
	 * Returns a new populated VsConverter
	 * 
	 * @return CreateVsConverterCommand alias
	 */
	protected CreateVsConverterCommand generateNewCommand() {
        CreateVsConverterCommand command = new CreateVsConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
		
		return( command );
	}

		/**
		 * Returns a new populated VsConverter
		 * 
		 * @return UpdateVsConverterCommand alias
		 */
	protected UpdateVsConverterCommand generateUpdateCommand() {
	        UpdateVsConverterCommand command = new UpdateVsConverterCommand( null,  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16),  org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(16) );
			
			return( command );
		}
	//-----------------------------------------------------
	// attributes 
	//-----------------------------------------------------
	protected UUID vsConverterId = null;
	protected VsConverterSubscriber subscriber = null;
	private final String unexpectedErrorMsg = ":::::::::::::: Unexpected Error :::::::::::::::::";
	private final Logger LOGGER = Logger.getLogger(VsConverterTest.class.getName());
	private String testingStep = "";
	private Integer sizeOfVsConverterList = 0;
}
