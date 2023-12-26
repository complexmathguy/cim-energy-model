/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.delegate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.concurrent.*;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.validator.*;

/**
 * GovHydroIEEE0 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydroIEEE0 related services in the case of a GovHydroIEEE0 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydroIEEE0 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydroIEEE0 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydroIEEE0BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydroIEEE0BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydroIEEE0 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydroIEEE0BusinessDelegate
	*/
	public static GovHydroIEEE0BusinessDelegate getGovHydroIEEE0Instance() {
		return( new GovHydroIEEE0BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydroIEEE0( CreateGovHydroIEEE0Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydroIEEE0Id() == null )
				command.setGovHydroIEEE0Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroIEEE0Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydroIEEE0Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydroIEEE0Command of GovHydroIEEE0 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydroIEEE0 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydroIEEE0Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydroIEEE0( UpdateGovHydroIEEE0Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydroIEEE0Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydroIEEE0Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydroIEEE0 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydroIEEE0Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydroIEEE0Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydroIEEE0Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydroIEEE0Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydroIEEE0 using Id = "  + command.getGovHydroIEEE0Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydroIEEE0 via GovHydroIEEE0FetchOneSummary
     * @param 	summary GovHydroIEEE0FetchOneSummary 
     * @return 	GovHydroIEEE0FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydroIEEE0 getGovHydroIEEE0( GovHydroIEEE0FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydroIEEE0FetchOneSummary arg cannot be null" );
    	
    	GovHydroIEEE0 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydroIEEE0Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydroIEEE0
        	// --------------------------------------
        	CompletableFuture<GovHydroIEEE0> futureEntity = queryGateway.query(new FindGovHydroIEEE0Query( new LoadGovHydroIEEE0Filter( summary.getGovHydroIEEE0Id() ) ), ResponseTypes.instanceOf(GovHydroIEEE0.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydroIEEE0 with id " + summary.getGovHydroIEEE0Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydroIEEE0s
     *
     * @return 	List<GovHydroIEEE0> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydroIEEE0> getAllGovHydroIEEE0() 
    throws ProcessingException {
        List<GovHydroIEEE0> list = null;

        try {
        	CompletableFuture<List<GovHydroIEEE0>> futureList = queryGateway.query(new FindAllGovHydroIEEE0Query(), ResponseTypes.multipleInstancesOf(GovHydroIEEE0.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydroIEEE0";
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return list;
    }




	/**
	 * Internal helper method to load the root 
	 * 
	 * @param		id	UUID
	 * @return		GovHydroIEEE0
	 */
	protected GovHydroIEEE0 load( UUID id ) throws ProcessingException {
		govHydroIEEE0 = GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().getGovHydroIEEE0( new GovHydroIEEE0FetchOneSummary(id) );	
		return govHydroIEEE0;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydroIEEE0 govHydroIEEE0 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydroIEEE0BusinessDelegate.class.getName());
    
}
