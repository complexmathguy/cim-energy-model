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
 * DCDisconnector business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCDisconnector related services in the case of a DCDisconnector business related service failing.</li>
 * <li>Exposes a simpler, uniform DCDisconnector interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCDisconnector business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCDisconnectorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCDisconnectorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCDisconnector Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCDisconnectorBusinessDelegate
	*/
	public static DCDisconnectorBusinessDelegate getDCDisconnectorInstance() {
		return( new DCDisconnectorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCDisconnector( CreateDCDisconnectorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCDisconnectorId() == null )
				command.setDCDisconnectorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCDisconnectorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCDisconnectorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCDisconnectorCommand of DCDisconnector is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCDisconnector - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCDisconnectorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCDisconnector( UpdateDCDisconnectorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCDisconnectorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCDisconnectorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCDisconnector - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCDisconnectorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCDisconnectorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCDisconnectorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCDisconnectorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCDisconnector using Id = "  + command.getDCDisconnectorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCDisconnector via DCDisconnectorFetchOneSummary
     * @param 	summary DCDisconnectorFetchOneSummary 
     * @return 	DCDisconnectorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCDisconnector getDCDisconnector( DCDisconnectorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCDisconnectorFetchOneSummary arg cannot be null" );
    	
    	DCDisconnector entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCDisconnectorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCDisconnector
        	// --------------------------------------
        	CompletableFuture<DCDisconnector> futureEntity = queryGateway.query(new FindDCDisconnectorQuery( new LoadDCDisconnectorFilter( summary.getDCDisconnectorId() ) ), ResponseTypes.instanceOf(DCDisconnector.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCDisconnector with id " + summary.getDCDisconnectorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCDisconnectors
     *
     * @return 	List<DCDisconnector> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCDisconnector> getAllDCDisconnector() 
    throws ProcessingException {
        List<DCDisconnector> list = null;

        try {
        	CompletableFuture<List<DCDisconnector>> futureList = queryGateway.query(new FindAllDCDisconnectorQuery(), ResponseTypes.multipleInstancesOf(DCDisconnector.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCDisconnector";
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
	 * @return		DCDisconnector
	 */
	protected DCDisconnector load( UUID id ) throws ProcessingException {
		dCDisconnector = DCDisconnectorBusinessDelegate.getDCDisconnectorInstance().getDCDisconnector( new DCDisconnectorFetchOneSummary(id) );	
		return dCDisconnector;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCDisconnector dCDisconnector 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCDisconnectorBusinessDelegate.class.getName());
    
}
