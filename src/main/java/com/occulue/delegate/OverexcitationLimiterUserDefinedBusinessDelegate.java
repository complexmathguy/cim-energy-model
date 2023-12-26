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
 * OverexcitationLimiterUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of OverexcitationLimiterUserDefined related services in the case of a OverexcitationLimiterUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform OverexcitationLimiterUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill OverexcitationLimiterUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class OverexcitationLimiterUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public OverexcitationLimiterUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* OverexcitationLimiterUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	OverexcitationLimiterUserDefinedBusinessDelegate
	*/
	public static OverexcitationLimiterUserDefinedBusinessDelegate getOverexcitationLimiterUserDefinedInstance() {
		return( new OverexcitationLimiterUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createOverexcitationLimiterUserDefined( CreateOverexcitationLimiterUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getOverexcitationLimiterUserDefinedId() == null )
				command.setOverexcitationLimiterUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcitationLimiterUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateOverexcitationLimiterUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateOverexcitationLimiterUserDefinedCommand of OverexcitationLimiterUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create OverexcitationLimiterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateOverexcitationLimiterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateOverexcitationLimiterUserDefined( UpdateOverexcitationLimiterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	OverexcitationLimiterUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateOverexcitationLimiterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save OverexcitationLimiterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteOverexcitationLimiterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteOverexcitationLimiterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcitationLimiterUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteOverexcitationLimiterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete OverexcitationLimiterUserDefined using Id = "  + command.getOverexcitationLimiterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the OverexcitationLimiterUserDefined via OverexcitationLimiterUserDefinedFetchOneSummary
     * @param 	summary OverexcitationLimiterUserDefinedFetchOneSummary 
     * @return 	OverexcitationLimiterUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public OverexcitationLimiterUserDefined getOverexcitationLimiterUserDefined( OverexcitationLimiterUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "OverexcitationLimiterUserDefinedFetchOneSummary arg cannot be null" );
    	
    	OverexcitationLimiterUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	OverexcitationLimiterUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a OverexcitationLimiterUserDefined
        	// --------------------------------------
        	CompletableFuture<OverexcitationLimiterUserDefined> futureEntity = queryGateway.query(new FindOverexcitationLimiterUserDefinedQuery( new LoadOverexcitationLimiterUserDefinedFilter( summary.getOverexcitationLimiterUserDefinedId() ) ), ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate OverexcitationLimiterUserDefined with id " + summary.getOverexcitationLimiterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all OverexcitationLimiterUserDefineds
     *
     * @return 	List<OverexcitationLimiterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<OverexcitationLimiterUserDefined> getAllOverexcitationLimiterUserDefined() 
    throws ProcessingException {
        List<OverexcitationLimiterUserDefined> list = null;

        try {
        	CompletableFuture<List<OverexcitationLimiterUserDefined>> futureList = queryGateway.query(new FindAllOverexcitationLimiterUserDefinedQuery(), ResponseTypes.multipleInstancesOf(OverexcitationLimiterUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all OverexcitationLimiterUserDefined";
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
	 * @return		OverexcitationLimiterUserDefined
	 */
	protected OverexcitationLimiterUserDefined load( UUID id ) throws ProcessingException {
		overexcitationLimiterUserDefined = OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance().getOverexcitationLimiterUserDefined( new OverexcitationLimiterUserDefinedFetchOneSummary(id) );	
		return overexcitationLimiterUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private OverexcitationLimiterUserDefined overexcitationLimiterUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(OverexcitationLimiterUserDefinedBusinessDelegate.class.getName());
    
}
