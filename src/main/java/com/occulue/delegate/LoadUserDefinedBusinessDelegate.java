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
 * LoadUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of LoadUserDefined related services in the case of a LoadUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform LoadUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill LoadUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class LoadUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public LoadUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* LoadUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	LoadUserDefinedBusinessDelegate
	*/
	public static LoadUserDefinedBusinessDelegate getLoadUserDefinedInstance() {
		return( new LoadUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createLoadUserDefined( CreateLoadUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getLoadUserDefinedId() == null )
				command.setLoadUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateLoadUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateLoadUserDefinedCommand of LoadUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create LoadUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateLoadUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateLoadUserDefined( UpdateLoadUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	LoadUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateLoadUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save LoadUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteLoadUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteLoadUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteLoadUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete LoadUserDefined using Id = "  + command.getLoadUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the LoadUserDefined via LoadUserDefinedFetchOneSummary
     * @param 	summary LoadUserDefinedFetchOneSummary 
     * @return 	LoadUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public LoadUserDefined getLoadUserDefined( LoadUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "LoadUserDefinedFetchOneSummary arg cannot be null" );
    	
    	LoadUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	LoadUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a LoadUserDefined
        	// --------------------------------------
        	CompletableFuture<LoadUserDefined> futureEntity = queryGateway.query(new FindLoadUserDefinedQuery( new LoadLoadUserDefinedFilter( summary.getLoadUserDefinedId() ) ), ResponseTypes.instanceOf(LoadUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate LoadUserDefined with id " + summary.getLoadUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all LoadUserDefineds
     *
     * @return 	List<LoadUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<LoadUserDefined> getAllLoadUserDefined() 
    throws ProcessingException {
        List<LoadUserDefined> list = null;

        try {
        	CompletableFuture<List<LoadUserDefined>> futureList = queryGateway.query(new FindAllLoadUserDefinedQuery(), ResponseTypes.multipleInstancesOf(LoadUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all LoadUserDefined";
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
	 * @return		LoadUserDefined
	 */
	protected LoadUserDefined load( UUID id ) throws ProcessingException {
		loadUserDefined = LoadUserDefinedBusinessDelegate.getLoadUserDefinedInstance().getLoadUserDefined( new LoadUserDefinedFetchOneSummary(id) );	
		return loadUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private LoadUserDefined loadUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(LoadUserDefinedBusinessDelegate.class.getName());
    
}
