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
 * TurbineGovernorDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TurbineGovernorDynamics related services in the case of a TurbineGovernorDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform TurbineGovernorDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TurbineGovernorDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TurbineGovernorDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TurbineGovernorDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TurbineGovernorDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TurbineGovernorDynamicsBusinessDelegate
	*/
	public static TurbineGovernorDynamicsBusinessDelegate getTurbineGovernorDynamicsInstance() {
		return( new TurbineGovernorDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTurbineGovernorDynamics( CreateTurbineGovernorDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTurbineGovernorDynamicsId() == null )
				command.setTurbineGovernorDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbineGovernorDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTurbineGovernorDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTurbineGovernorDynamicsCommand of TurbineGovernorDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TurbineGovernorDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTurbineGovernorDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTurbineGovernorDynamics( UpdateTurbineGovernorDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TurbineGovernorDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTurbineGovernorDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TurbineGovernorDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTurbineGovernorDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTurbineGovernorDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbineGovernorDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTurbineGovernorDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TurbineGovernorDynamics using Id = "  + command.getTurbineGovernorDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TurbineGovernorDynamics via TurbineGovernorDynamicsFetchOneSummary
     * @param 	summary TurbineGovernorDynamicsFetchOneSummary 
     * @return 	TurbineGovernorDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TurbineGovernorDynamics getTurbineGovernorDynamics( TurbineGovernorDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TurbineGovernorDynamicsFetchOneSummary arg cannot be null" );
    	
    	TurbineGovernorDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TurbineGovernorDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TurbineGovernorDynamics
        	// --------------------------------------
        	CompletableFuture<TurbineGovernorDynamics> futureEntity = queryGateway.query(new FindTurbineGovernorDynamicsQuery( new LoadTurbineGovernorDynamicsFilter( summary.getTurbineGovernorDynamicsId() ) ), ResponseTypes.instanceOf(TurbineGovernorDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TurbineGovernorDynamics with id " + summary.getTurbineGovernorDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TurbineGovernorDynamicss
     *
     * @return 	List<TurbineGovernorDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TurbineGovernorDynamics> getAllTurbineGovernorDynamics() 
    throws ProcessingException {
        List<TurbineGovernorDynamics> list = null;

        try {
        	CompletableFuture<List<TurbineGovernorDynamics>> futureList = queryGateway.query(new FindAllTurbineGovernorDynamicsQuery(), ResponseTypes.multipleInstancesOf(TurbineGovernorDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TurbineGovernorDynamics";
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
	 * @return		TurbineGovernorDynamics
	 */
	protected TurbineGovernorDynamics load( UUID id ) throws ProcessingException {
		turbineGovernorDynamics = TurbineGovernorDynamicsBusinessDelegate.getTurbineGovernorDynamicsInstance().getTurbineGovernorDynamics( new TurbineGovernorDynamicsFetchOneSummary(id) );	
		return turbineGovernorDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TurbineGovernorDynamics turbineGovernorDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TurbineGovernorDynamicsBusinessDelegate.class.getName());
    
}
