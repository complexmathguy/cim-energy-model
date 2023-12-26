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
 * ActivePowerPerCurrentFlow business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ActivePowerPerCurrentFlow related services in the case of a ActivePowerPerCurrentFlow business related service failing.</li>
 * <li>Exposes a simpler, uniform ActivePowerPerCurrentFlow interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ActivePowerPerCurrentFlow business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ActivePowerPerCurrentFlowBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ActivePowerPerCurrentFlowBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ActivePowerPerCurrentFlow Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ActivePowerPerCurrentFlowBusinessDelegate
	*/
	public static ActivePowerPerCurrentFlowBusinessDelegate getActivePowerPerCurrentFlowInstance() {
		return( new ActivePowerPerCurrentFlowBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createActivePowerPerCurrentFlow( CreateActivePowerPerCurrentFlowCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getActivePowerPerCurrentFlowId() == null )
				command.setActivePowerPerCurrentFlowId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerPerCurrentFlowValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateActivePowerPerCurrentFlowCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateActivePowerPerCurrentFlowCommand of ActivePowerPerCurrentFlow is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ActivePowerPerCurrentFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateActivePowerPerCurrentFlowCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateActivePowerPerCurrentFlow( UpdateActivePowerPerCurrentFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ActivePowerPerCurrentFlowValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateActivePowerPerCurrentFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ActivePowerPerCurrentFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteActivePowerPerCurrentFlowCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteActivePowerPerCurrentFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerPerCurrentFlowValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteActivePowerPerCurrentFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ActivePowerPerCurrentFlow using Id = "  + command.getActivePowerPerCurrentFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ActivePowerPerCurrentFlow via ActivePowerPerCurrentFlowFetchOneSummary
     * @param 	summary ActivePowerPerCurrentFlowFetchOneSummary 
     * @return 	ActivePowerPerCurrentFlowFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ActivePowerPerCurrentFlow getActivePowerPerCurrentFlow( ActivePowerPerCurrentFlowFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ActivePowerPerCurrentFlowFetchOneSummary arg cannot be null" );
    	
    	ActivePowerPerCurrentFlow entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ActivePowerPerCurrentFlowValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ActivePowerPerCurrentFlow
        	// --------------------------------------
        	CompletableFuture<ActivePowerPerCurrentFlow> futureEntity = queryGateway.query(new FindActivePowerPerCurrentFlowQuery( new LoadActivePowerPerCurrentFlowFilter( summary.getActivePowerPerCurrentFlowId() ) ), ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ActivePowerPerCurrentFlow with id " + summary.getActivePowerPerCurrentFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ActivePowerPerCurrentFlows
     *
     * @return 	List<ActivePowerPerCurrentFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ActivePowerPerCurrentFlow> getAllActivePowerPerCurrentFlow() 
    throws ProcessingException {
        List<ActivePowerPerCurrentFlow> list = null;

        try {
        	CompletableFuture<List<ActivePowerPerCurrentFlow>> futureList = queryGateway.query(new FindAllActivePowerPerCurrentFlowQuery(), ResponseTypes.multipleInstancesOf(ActivePowerPerCurrentFlow.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ActivePowerPerCurrentFlow";
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
	 * @return		ActivePowerPerCurrentFlow
	 */
	protected ActivePowerPerCurrentFlow load( UUID id ) throws ProcessingException {
		activePowerPerCurrentFlow = ActivePowerPerCurrentFlowBusinessDelegate.getActivePowerPerCurrentFlowInstance().getActivePowerPerCurrentFlow( new ActivePowerPerCurrentFlowFetchOneSummary(id) );	
		return activePowerPerCurrentFlow;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ActivePowerPerCurrentFlow activePowerPerCurrentFlow 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ActivePowerPerCurrentFlowBusinessDelegate.class.getName());
    
}
