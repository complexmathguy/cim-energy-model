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
 * ExcitationSystemDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcitationSystemDynamics related services in the case of a ExcitationSystemDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcitationSystemDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcitationSystemDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcitationSystemDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcitationSystemDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcitationSystemDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcitationSystemDynamicsBusinessDelegate
	*/
	public static ExcitationSystemDynamicsBusinessDelegate getExcitationSystemDynamicsInstance() {
		return( new ExcitationSystemDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcitationSystemDynamics( CreateExcitationSystemDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcitationSystemDynamicsId() == null )
				command.setExcitationSystemDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcitationSystemDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcitationSystemDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcitationSystemDynamicsCommand of ExcitationSystemDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcitationSystemDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcitationSystemDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcitationSystemDynamics( UpdateExcitationSystemDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcitationSystemDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcitationSystemDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcitationSystemDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcitationSystemDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcitationSystemDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcitationSystemDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcitationSystemDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcitationSystemDynamics using Id = "  + command.getExcitationSystemDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcitationSystemDynamics via ExcitationSystemDynamicsFetchOneSummary
     * @param 	summary ExcitationSystemDynamicsFetchOneSummary 
     * @return 	ExcitationSystemDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcitationSystemDynamics getExcitationSystemDynamics( ExcitationSystemDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcitationSystemDynamicsFetchOneSummary arg cannot be null" );
    	
    	ExcitationSystemDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcitationSystemDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcitationSystemDynamics
        	// --------------------------------------
        	CompletableFuture<ExcitationSystemDynamics> futureEntity = queryGateway.query(new FindExcitationSystemDynamicsQuery( new LoadExcitationSystemDynamicsFilter( summary.getExcitationSystemDynamicsId() ) ), ResponseTypes.instanceOf(ExcitationSystemDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcitationSystemDynamics with id " + summary.getExcitationSystemDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcitationSystemDynamicss
     *
     * @return 	List<ExcitationSystemDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcitationSystemDynamics> getAllExcitationSystemDynamics() 
    throws ProcessingException {
        List<ExcitationSystemDynamics> list = null;

        try {
        	CompletableFuture<List<ExcitationSystemDynamics>> futureList = queryGateway.query(new FindAllExcitationSystemDynamicsQuery(), ResponseTypes.multipleInstancesOf(ExcitationSystemDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcitationSystemDynamics";
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
	 * @return		ExcitationSystemDynamics
	 */
	protected ExcitationSystemDynamics load( UUID id ) throws ProcessingException {
		excitationSystemDynamics = ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance().getExcitationSystemDynamics( new ExcitationSystemDynamicsFetchOneSummary(id) );	
		return excitationSystemDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcitationSystemDynamics excitationSystemDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcitationSystemDynamicsBusinessDelegate.class.getName());
    
}
