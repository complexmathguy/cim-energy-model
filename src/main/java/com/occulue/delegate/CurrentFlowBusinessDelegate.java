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
 * CurrentFlow business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of CurrentFlow related services in the case of a CurrentFlow business related service failing.</li>
 * <li>Exposes a simpler, uniform CurrentFlow interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill CurrentFlow business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class CurrentFlowBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public CurrentFlowBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* CurrentFlow Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	CurrentFlowBusinessDelegate
	*/
	public static CurrentFlowBusinessDelegate getCurrentFlowInstance() {
		return( new CurrentFlowBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createCurrentFlow( CreateCurrentFlowCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getCurrentFlowId() == null )
				command.setCurrentFlowId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CurrentFlowValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateCurrentFlowCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateCurrentFlowCommand of CurrentFlow is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create CurrentFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateCurrentFlowCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateCurrentFlow( UpdateCurrentFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	CurrentFlowValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateCurrentFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save CurrentFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteCurrentFlowCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteCurrentFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CurrentFlowValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteCurrentFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete CurrentFlow using Id = "  + command.getCurrentFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the CurrentFlow via CurrentFlowFetchOneSummary
     * @param 	summary CurrentFlowFetchOneSummary 
     * @return 	CurrentFlowFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public CurrentFlow getCurrentFlow( CurrentFlowFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "CurrentFlowFetchOneSummary arg cannot be null" );
    	
    	CurrentFlow entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	CurrentFlowValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a CurrentFlow
        	// --------------------------------------
        	CompletableFuture<CurrentFlow> futureEntity = queryGateway.query(new FindCurrentFlowQuery( new LoadCurrentFlowFilter( summary.getCurrentFlowId() ) ), ResponseTypes.instanceOf(CurrentFlow.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate CurrentFlow with id " + summary.getCurrentFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all CurrentFlows
     *
     * @return 	List<CurrentFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<CurrentFlow> getAllCurrentFlow() 
    throws ProcessingException {
        List<CurrentFlow> list = null;

        try {
        	CompletableFuture<List<CurrentFlow>> futureList = queryGateway.query(new FindAllCurrentFlowQuery(), ResponseTypes.multipleInstancesOf(CurrentFlow.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all CurrentFlow";
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
	 * @return		CurrentFlow
	 */
	protected CurrentFlow load( UUID id ) throws ProcessingException {
		currentFlow = CurrentFlowBusinessDelegate.getCurrentFlowInstance().getCurrentFlow( new CurrentFlowFetchOneSummary(id) );	
		return currentFlow;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private CurrentFlow currentFlow 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(CurrentFlowBusinessDelegate.class.getName());
    
}
