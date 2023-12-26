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
 * UnderexcLim2Simplified business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcLim2Simplified related services in the case of a UnderexcLim2Simplified business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcLim2Simplified interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcLim2Simplified business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcLim2SimplifiedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcLim2SimplifiedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcLim2Simplified Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcLim2SimplifiedBusinessDelegate
	*/
	public static UnderexcLim2SimplifiedBusinessDelegate getUnderexcLim2SimplifiedInstance() {
		return( new UnderexcLim2SimplifiedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcLim2Simplified( CreateUnderexcLim2SimplifiedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcLim2SimplifiedId() == null )
				command.setUnderexcLim2SimplifiedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLim2SimplifiedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcLim2SimplifiedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcLim2SimplifiedCommand of UnderexcLim2Simplified is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcLim2Simplified - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcLim2SimplifiedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcLim2Simplified( UpdateUnderexcLim2SimplifiedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcLim2SimplifiedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcLim2SimplifiedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcLim2Simplified - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcLim2SimplifiedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcLim2SimplifiedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcLim2SimplifiedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcLim2SimplifiedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcLim2Simplified using Id = "  + command.getUnderexcLim2SimplifiedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcLim2Simplified via UnderexcLim2SimplifiedFetchOneSummary
     * @param 	summary UnderexcLim2SimplifiedFetchOneSummary 
     * @return 	UnderexcLim2SimplifiedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcLim2Simplified getUnderexcLim2Simplified( UnderexcLim2SimplifiedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcLim2SimplifiedFetchOneSummary arg cannot be null" );
    	
    	UnderexcLim2Simplified entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcLim2SimplifiedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcLim2Simplified
        	// --------------------------------------
        	CompletableFuture<UnderexcLim2Simplified> futureEntity = queryGateway.query(new FindUnderexcLim2SimplifiedQuery( new LoadUnderexcLim2SimplifiedFilter( summary.getUnderexcLim2SimplifiedId() ) ), ResponseTypes.instanceOf(UnderexcLim2Simplified.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcLim2Simplified with id " + summary.getUnderexcLim2SimplifiedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcLim2Simplifieds
     *
     * @return 	List<UnderexcLim2Simplified> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcLim2Simplified> getAllUnderexcLim2Simplified() 
    throws ProcessingException {
        List<UnderexcLim2Simplified> list = null;

        try {
        	CompletableFuture<List<UnderexcLim2Simplified>> futureList = queryGateway.query(new FindAllUnderexcLim2SimplifiedQuery(), ResponseTypes.multipleInstancesOf(UnderexcLim2Simplified.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcLim2Simplified";
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
	 * @return		UnderexcLim2Simplified
	 */
	protected UnderexcLim2Simplified load( UUID id ) throws ProcessingException {
		underexcLim2Simplified = UnderexcLim2SimplifiedBusinessDelegate.getUnderexcLim2SimplifiedInstance().getUnderexcLim2Simplified( new UnderexcLim2SimplifiedFetchOneSummary(id) );	
		return underexcLim2Simplified;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcLim2Simplified underexcLim2Simplified 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcLim2SimplifiedBusinessDelegate.class.getName());
    
}
