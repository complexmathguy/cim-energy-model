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
 * ReactivePower business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ReactivePower related services in the case of a ReactivePower business related service failing.</li>
 * <li>Exposes a simpler, uniform ReactivePower interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ReactivePower business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ReactivePowerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ReactivePowerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ReactivePower Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ReactivePowerBusinessDelegate
	*/
	public static ReactivePowerBusinessDelegate getReactivePowerInstance() {
		return( new ReactivePowerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createReactivePower( CreateReactivePowerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getReactivePowerId() == null )
				command.setReactivePowerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReactivePowerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateReactivePowerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateReactivePowerCommand of ReactivePower is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ReactivePower - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateReactivePowerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateReactivePower( UpdateReactivePowerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ReactivePowerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateReactivePowerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ReactivePower - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteReactivePowerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteReactivePowerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ReactivePowerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteReactivePowerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ReactivePower using Id = "  + command.getReactivePowerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ReactivePower via ReactivePowerFetchOneSummary
     * @param 	summary ReactivePowerFetchOneSummary 
     * @return 	ReactivePowerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ReactivePower getReactivePower( ReactivePowerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ReactivePowerFetchOneSummary arg cannot be null" );
    	
    	ReactivePower entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ReactivePowerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ReactivePower
        	// --------------------------------------
        	CompletableFuture<ReactivePower> futureEntity = queryGateway.query(new FindReactivePowerQuery( new LoadReactivePowerFilter( summary.getReactivePowerId() ) ), ResponseTypes.instanceOf(ReactivePower.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ReactivePower with id " + summary.getReactivePowerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ReactivePowers
     *
     * @return 	List<ReactivePower> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ReactivePower> getAllReactivePower() 
    throws ProcessingException {
        List<ReactivePower> list = null;

        try {
        	CompletableFuture<List<ReactivePower>> futureList = queryGateway.query(new FindAllReactivePowerQuery(), ResponseTypes.multipleInstancesOf(ReactivePower.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ReactivePower";
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
	 * @return		ReactivePower
	 */
	protected ReactivePower load( UUID id ) throws ProcessingException {
		reactivePower = ReactivePowerBusinessDelegate.getReactivePowerInstance().getReactivePower( new ReactivePowerFetchOneSummary(id) );	
		return reactivePower;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ReactivePower reactivePower 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ReactivePowerBusinessDelegate.class.getName());
    
}
