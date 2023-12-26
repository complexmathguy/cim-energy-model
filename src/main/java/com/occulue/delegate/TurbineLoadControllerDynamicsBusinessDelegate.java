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
 * TurbineLoadControllerDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TurbineLoadControllerDynamics related services in the case of a TurbineLoadControllerDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform TurbineLoadControllerDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TurbineLoadControllerDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TurbineLoadControllerDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TurbineLoadControllerDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TurbineLoadControllerDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TurbineLoadControllerDynamicsBusinessDelegate
	*/
	public static TurbineLoadControllerDynamicsBusinessDelegate getTurbineLoadControllerDynamicsInstance() {
		return( new TurbineLoadControllerDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTurbineLoadControllerDynamics( CreateTurbineLoadControllerDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTurbineLoadControllerDynamicsId() == null )
				command.setTurbineLoadControllerDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbineLoadControllerDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTurbineLoadControllerDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTurbineLoadControllerDynamicsCommand of TurbineLoadControllerDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TurbineLoadControllerDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTurbineLoadControllerDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTurbineLoadControllerDynamics( UpdateTurbineLoadControllerDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TurbineLoadControllerDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTurbineLoadControllerDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TurbineLoadControllerDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTurbineLoadControllerDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTurbineLoadControllerDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbineLoadControllerDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTurbineLoadControllerDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TurbineLoadControllerDynamics using Id = "  + command.getTurbineLoadControllerDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TurbineLoadControllerDynamics via TurbineLoadControllerDynamicsFetchOneSummary
     * @param 	summary TurbineLoadControllerDynamicsFetchOneSummary 
     * @return 	TurbineLoadControllerDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TurbineLoadControllerDynamics getTurbineLoadControllerDynamics( TurbineLoadControllerDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TurbineLoadControllerDynamicsFetchOneSummary arg cannot be null" );
    	
    	TurbineLoadControllerDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TurbineLoadControllerDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TurbineLoadControllerDynamics
        	// --------------------------------------
        	CompletableFuture<TurbineLoadControllerDynamics> futureEntity = queryGateway.query(new FindTurbineLoadControllerDynamicsQuery( new LoadTurbineLoadControllerDynamicsFilter( summary.getTurbineLoadControllerDynamicsId() ) ), ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TurbineLoadControllerDynamics with id " + summary.getTurbineLoadControllerDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TurbineLoadControllerDynamicss
     *
     * @return 	List<TurbineLoadControllerDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TurbineLoadControllerDynamics> getAllTurbineLoadControllerDynamics() 
    throws ProcessingException {
        List<TurbineLoadControllerDynamics> list = null;

        try {
        	CompletableFuture<List<TurbineLoadControllerDynamics>> futureList = queryGateway.query(new FindAllTurbineLoadControllerDynamicsQuery(), ResponseTypes.multipleInstancesOf(TurbineLoadControllerDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TurbineLoadControllerDynamics";
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
	 * @return		TurbineLoadControllerDynamics
	 */
	protected TurbineLoadControllerDynamics load( UUID id ) throws ProcessingException {
		turbineLoadControllerDynamics = TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance().getTurbineLoadControllerDynamics( new TurbineLoadControllerDynamicsFetchOneSummary(id) );	
		return turbineLoadControllerDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TurbineLoadControllerDynamics turbineLoadControllerDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TurbineLoadControllerDynamicsBusinessDelegate.class.getName());
    
}
