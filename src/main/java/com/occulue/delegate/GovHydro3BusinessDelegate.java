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
 * GovHydro3 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GovHydro3 related services in the case of a GovHydro3 business related service failing.</li>
 * <li>Exposes a simpler, uniform GovHydro3 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GovHydro3 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GovHydro3BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GovHydro3BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GovHydro3 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GovHydro3BusinessDelegate
	*/
	public static GovHydro3BusinessDelegate getGovHydro3Instance() {
		return( new GovHydro3BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGovHydro3( CreateGovHydro3Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGovHydro3Id() == null )
				command.setGovHydro3Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydro3Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGovHydro3Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGovHydro3Command of GovHydro3 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GovHydro3 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGovHydro3Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGovHydro3( UpdateGovHydro3Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GovHydro3Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGovHydro3Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GovHydro3 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGovHydro3Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGovHydro3Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GovHydro3Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGovHydro3Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GovHydro3 using Id = "  + command.getGovHydro3Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GovHydro3 via GovHydro3FetchOneSummary
     * @param 	summary GovHydro3FetchOneSummary 
     * @return 	GovHydro3FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GovHydro3 getGovHydro3( GovHydro3FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GovHydro3FetchOneSummary arg cannot be null" );
    	
    	GovHydro3 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GovHydro3Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GovHydro3
        	// --------------------------------------
        	CompletableFuture<GovHydro3> futureEntity = queryGateway.query(new FindGovHydro3Query( new LoadGovHydro3Filter( summary.getGovHydro3Id() ) ), ResponseTypes.instanceOf(GovHydro3.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GovHydro3 with id " + summary.getGovHydro3Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GovHydro3s
     *
     * @return 	List<GovHydro3> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GovHydro3> getAllGovHydro3() 
    throws ProcessingException {
        List<GovHydro3> list = null;

        try {
        	CompletableFuture<List<GovHydro3>> futureList = queryGateway.query(new FindAllGovHydro3Query(), ResponseTypes.multipleInstancesOf(GovHydro3.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GovHydro3";
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
	 * @return		GovHydro3
	 */
	protected GovHydro3 load( UUID id ) throws ProcessingException {
		govHydro3 = GovHydro3BusinessDelegate.getGovHydro3Instance().getGovHydro3( new GovHydro3FetchOneSummary(id) );	
		return govHydro3;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GovHydro3 govHydro3 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GovHydro3BusinessDelegate.class.getName());
    
}
