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
 * DCBusbar business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCBusbar related services in the case of a DCBusbar business related service failing.</li>
 * <li>Exposes a simpler, uniform DCBusbar interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCBusbar business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCBusbarBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCBusbarBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCBusbar Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCBusbarBusinessDelegate
	*/
	public static DCBusbarBusinessDelegate getDCBusbarInstance() {
		return( new DCBusbarBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCBusbar( CreateDCBusbarCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCBusbarId() == null )
				command.setDCBusbarId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCBusbarValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCBusbarCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCBusbarCommand of DCBusbar is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCBusbar - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCBusbarCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCBusbar( UpdateDCBusbarCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCBusbarValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCBusbarCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCBusbar - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCBusbarCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCBusbarCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCBusbarValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCBusbarCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCBusbar using Id = "  + command.getDCBusbarId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCBusbar via DCBusbarFetchOneSummary
     * @param 	summary DCBusbarFetchOneSummary 
     * @return 	DCBusbarFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCBusbar getDCBusbar( DCBusbarFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCBusbarFetchOneSummary arg cannot be null" );
    	
    	DCBusbar entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCBusbarValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCBusbar
        	// --------------------------------------
        	CompletableFuture<DCBusbar> futureEntity = queryGateway.query(new FindDCBusbarQuery( new LoadDCBusbarFilter( summary.getDCBusbarId() ) ), ResponseTypes.instanceOf(DCBusbar.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCBusbar with id " + summary.getDCBusbarId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCBusbars
     *
     * @return 	List<DCBusbar> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCBusbar> getAllDCBusbar() 
    throws ProcessingException {
        List<DCBusbar> list = null;

        try {
        	CompletableFuture<List<DCBusbar>> futureList = queryGateway.query(new FindAllDCBusbarQuery(), ResponseTypes.multipleInstancesOf(DCBusbar.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCBusbar";
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
	 * @return		DCBusbar
	 */
	protected DCBusbar load( UUID id ) throws ProcessingException {
		dCBusbar = DCBusbarBusinessDelegate.getDCBusbarInstance().getDCBusbar( new DCBusbarFetchOneSummary(id) );	
		return dCBusbar;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCBusbar dCBusbar 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCBusbarBusinessDelegate.class.getName());
    
}
