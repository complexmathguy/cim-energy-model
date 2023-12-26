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
 * UnderexcitationLimiterUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of UnderexcitationLimiterUserDefined related services in the case of a UnderexcitationLimiterUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform UnderexcitationLimiterUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill UnderexcitationLimiterUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class UnderexcitationLimiterUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public UnderexcitationLimiterUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* UnderexcitationLimiterUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	UnderexcitationLimiterUserDefinedBusinessDelegate
	*/
	public static UnderexcitationLimiterUserDefinedBusinessDelegate getUnderexcitationLimiterUserDefinedInstance() {
		return( new UnderexcitationLimiterUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createUnderexcitationLimiterUserDefined( CreateUnderexcitationLimiterUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getUnderexcitationLimiterUserDefinedId() == null )
				command.setUnderexcitationLimiterUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcitationLimiterUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateUnderexcitationLimiterUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateUnderexcitationLimiterUserDefinedCommand of UnderexcitationLimiterUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create UnderexcitationLimiterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateUnderexcitationLimiterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateUnderexcitationLimiterUserDefined( UpdateUnderexcitationLimiterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	UnderexcitationLimiterUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateUnderexcitationLimiterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save UnderexcitationLimiterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteUnderexcitationLimiterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteUnderexcitationLimiterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	UnderexcitationLimiterUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteUnderexcitationLimiterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete UnderexcitationLimiterUserDefined using Id = "  + command.getUnderexcitationLimiterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the UnderexcitationLimiterUserDefined via UnderexcitationLimiterUserDefinedFetchOneSummary
     * @param 	summary UnderexcitationLimiterUserDefinedFetchOneSummary 
     * @return 	UnderexcitationLimiterUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public UnderexcitationLimiterUserDefined getUnderexcitationLimiterUserDefined( UnderexcitationLimiterUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "UnderexcitationLimiterUserDefinedFetchOneSummary arg cannot be null" );
    	
    	UnderexcitationLimiterUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	UnderexcitationLimiterUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a UnderexcitationLimiterUserDefined
        	// --------------------------------------
        	CompletableFuture<UnderexcitationLimiterUserDefined> futureEntity = queryGateway.query(new FindUnderexcitationLimiterUserDefinedQuery( new LoadUnderexcitationLimiterUserDefinedFilter( summary.getUnderexcitationLimiterUserDefinedId() ) ), ResponseTypes.instanceOf(UnderexcitationLimiterUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate UnderexcitationLimiterUserDefined with id " + summary.getUnderexcitationLimiterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all UnderexcitationLimiterUserDefineds
     *
     * @return 	List<UnderexcitationLimiterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<UnderexcitationLimiterUserDefined> getAllUnderexcitationLimiterUserDefined() 
    throws ProcessingException {
        List<UnderexcitationLimiterUserDefined> list = null;

        try {
        	CompletableFuture<List<UnderexcitationLimiterUserDefined>> futureList = queryGateway.query(new FindAllUnderexcitationLimiterUserDefinedQuery(), ResponseTypes.multipleInstancesOf(UnderexcitationLimiterUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all UnderexcitationLimiterUserDefined";
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
	 * @return		UnderexcitationLimiterUserDefined
	 */
	protected UnderexcitationLimiterUserDefined load( UUID id ) throws ProcessingException {
		underexcitationLimiterUserDefined = UnderexcitationLimiterUserDefinedBusinessDelegate.getUnderexcitationLimiterUserDefinedInstance().getUnderexcitationLimiterUserDefined( new UnderexcitationLimiterUserDefinedFetchOneSummary(id) );	
		return underexcitationLimiterUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private UnderexcitationLimiterUserDefined underexcitationLimiterUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(UnderexcitationLimiterUserDefinedBusinessDelegate.class.getName());
    
}
