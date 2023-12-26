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
 * CurrentLimit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of CurrentLimit related services in the case of a CurrentLimit business related service failing.</li>
 * <li>Exposes a simpler, uniform CurrentLimit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill CurrentLimit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class CurrentLimitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public CurrentLimitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* CurrentLimit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	CurrentLimitBusinessDelegate
	*/
	public static CurrentLimitBusinessDelegate getCurrentLimitInstance() {
		return( new CurrentLimitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createCurrentLimit( CreateCurrentLimitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getCurrentLimitId() == null )
				command.setCurrentLimitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CurrentLimitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateCurrentLimitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateCurrentLimitCommand of CurrentLimit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create CurrentLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateCurrentLimitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateCurrentLimit( UpdateCurrentLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	CurrentLimitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateCurrentLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save CurrentLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteCurrentLimitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteCurrentLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CurrentLimitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteCurrentLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete CurrentLimit using Id = "  + command.getCurrentLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the CurrentLimit via CurrentLimitFetchOneSummary
     * @param 	summary CurrentLimitFetchOneSummary 
     * @return 	CurrentLimitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public CurrentLimit getCurrentLimit( CurrentLimitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "CurrentLimitFetchOneSummary arg cannot be null" );
    	
    	CurrentLimit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	CurrentLimitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a CurrentLimit
        	// --------------------------------------
        	CompletableFuture<CurrentLimit> futureEntity = queryGateway.query(new FindCurrentLimitQuery( new LoadCurrentLimitFilter( summary.getCurrentLimitId() ) ), ResponseTypes.instanceOf(CurrentLimit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate CurrentLimit with id " + summary.getCurrentLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all CurrentLimits
     *
     * @return 	List<CurrentLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<CurrentLimit> getAllCurrentLimit() 
    throws ProcessingException {
        List<CurrentLimit> list = null;

        try {
        	CompletableFuture<List<CurrentLimit>> futureList = queryGateway.query(new FindAllCurrentLimitQuery(), ResponseTypes.multipleInstancesOf(CurrentLimit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all CurrentLimit";
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
	 * @return		CurrentLimit
	 */
	protected CurrentLimit load( UUID id ) throws ProcessingException {
		currentLimit = CurrentLimitBusinessDelegate.getCurrentLimitInstance().getCurrentLimit( new CurrentLimitFetchOneSummary(id) );	
		return currentLimit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private CurrentLimit currentLimit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(CurrentLimitBusinessDelegate.class.getName());
    
}
