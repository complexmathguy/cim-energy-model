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
 * TieFlow business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TieFlow related services in the case of a TieFlow business related service failing.</li>
 * <li>Exposes a simpler, uniform TieFlow interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TieFlow business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TieFlowBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TieFlowBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TieFlow Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TieFlowBusinessDelegate
	*/
	public static TieFlowBusinessDelegate getTieFlowInstance() {
		return( new TieFlowBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTieFlow( CreateTieFlowCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTieFlowId() == null )
				command.setTieFlowId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TieFlowValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTieFlowCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTieFlowCommand of TieFlow is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TieFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTieFlowCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTieFlow( UpdateTieFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TieFlowValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTieFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TieFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTieFlowCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTieFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TieFlowValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTieFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TieFlow using Id = "  + command.getTieFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TieFlow via TieFlowFetchOneSummary
     * @param 	summary TieFlowFetchOneSummary 
     * @return 	TieFlowFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TieFlow getTieFlow( TieFlowFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TieFlowFetchOneSummary arg cannot be null" );
    	
    	TieFlow entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TieFlowValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TieFlow
        	// --------------------------------------
        	CompletableFuture<TieFlow> futureEntity = queryGateway.query(new FindTieFlowQuery( new LoadTieFlowFilter( summary.getTieFlowId() ) ), ResponseTypes.instanceOf(TieFlow.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TieFlow with id " + summary.getTieFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TieFlows
     *
     * @return 	List<TieFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TieFlow> getAllTieFlow() 
    throws ProcessingException {
        List<TieFlow> list = null;

        try {
        	CompletableFuture<List<TieFlow>> futureList = queryGateway.query(new FindAllTieFlowQuery(), ResponseTypes.multipleInstancesOf(TieFlow.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TieFlow";
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
	 * @return		TieFlow
	 */
	protected TieFlow load( UUID id ) throws ProcessingException {
		tieFlow = TieFlowBusinessDelegate.getTieFlowInstance().getTieFlow( new TieFlowFetchOneSummary(id) );	
		return tieFlow;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TieFlow tieFlow 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TieFlowBusinessDelegate.class.getName());
    
}
