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
 * ExcOEX3T business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcOEX3T related services in the case of a ExcOEX3T business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcOEX3T interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcOEX3T business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcOEX3TBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcOEX3TBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcOEX3T Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcOEX3TBusinessDelegate
	*/
	public static ExcOEX3TBusinessDelegate getExcOEX3TInstance() {
		return( new ExcOEX3TBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcOEX3T( CreateExcOEX3TCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcOEX3TId() == null )
				command.setExcOEX3TId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcOEX3TValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcOEX3TCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcOEX3TCommand of ExcOEX3T is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcOEX3T - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcOEX3TCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcOEX3T( UpdateExcOEX3TCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcOEX3TValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcOEX3TCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcOEX3T - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcOEX3TCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcOEX3TCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcOEX3TValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcOEX3TCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcOEX3T using Id = "  + command.getExcOEX3TId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcOEX3T via ExcOEX3TFetchOneSummary
     * @param 	summary ExcOEX3TFetchOneSummary 
     * @return 	ExcOEX3TFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcOEX3T getExcOEX3T( ExcOEX3TFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcOEX3TFetchOneSummary arg cannot be null" );
    	
    	ExcOEX3T entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcOEX3TValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcOEX3T
        	// --------------------------------------
        	CompletableFuture<ExcOEX3T> futureEntity = queryGateway.query(new FindExcOEX3TQuery( new LoadExcOEX3TFilter( summary.getExcOEX3TId() ) ), ResponseTypes.instanceOf(ExcOEX3T.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcOEX3T with id " + summary.getExcOEX3TId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcOEX3Ts
     *
     * @return 	List<ExcOEX3T> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcOEX3T> getAllExcOEX3T() 
    throws ProcessingException {
        List<ExcOEX3T> list = null;

        try {
        	CompletableFuture<List<ExcOEX3T>> futureList = queryGateway.query(new FindAllExcOEX3TQuery(), ResponseTypes.multipleInstancesOf(ExcOEX3T.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcOEX3T";
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
	 * @return		ExcOEX3T
	 */
	protected ExcOEX3T load( UUID id ) throws ProcessingException {
		excOEX3T = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().getExcOEX3T( new ExcOEX3TFetchOneSummary(id) );	
		return excOEX3T;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcOEX3T excOEX3T 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcOEX3TBusinessDelegate.class.getName());
    
}
