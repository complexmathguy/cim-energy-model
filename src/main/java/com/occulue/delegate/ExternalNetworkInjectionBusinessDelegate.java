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
 * ExternalNetworkInjection business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExternalNetworkInjection related services in the case of a ExternalNetworkInjection business related service failing.</li>
 * <li>Exposes a simpler, uniform ExternalNetworkInjection interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExternalNetworkInjection business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExternalNetworkInjectionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExternalNetworkInjectionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExternalNetworkInjection Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExternalNetworkInjectionBusinessDelegate
	*/
	public static ExternalNetworkInjectionBusinessDelegate getExternalNetworkInjectionInstance() {
		return( new ExternalNetworkInjectionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExternalNetworkInjection( CreateExternalNetworkInjectionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExternalNetworkInjectionId() == null )
				command.setExternalNetworkInjectionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExternalNetworkInjectionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExternalNetworkInjectionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExternalNetworkInjectionCommand of ExternalNetworkInjection is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExternalNetworkInjection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExternalNetworkInjectionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExternalNetworkInjection( UpdateExternalNetworkInjectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExternalNetworkInjectionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExternalNetworkInjectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExternalNetworkInjection - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExternalNetworkInjectionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExternalNetworkInjectionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExternalNetworkInjectionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExternalNetworkInjectionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExternalNetworkInjection using Id = "  + command.getExternalNetworkInjectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExternalNetworkInjection via ExternalNetworkInjectionFetchOneSummary
     * @param 	summary ExternalNetworkInjectionFetchOneSummary 
     * @return 	ExternalNetworkInjectionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExternalNetworkInjection getExternalNetworkInjection( ExternalNetworkInjectionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExternalNetworkInjectionFetchOneSummary arg cannot be null" );
    	
    	ExternalNetworkInjection entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExternalNetworkInjectionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExternalNetworkInjection
        	// --------------------------------------
        	CompletableFuture<ExternalNetworkInjection> futureEntity = queryGateway.query(new FindExternalNetworkInjectionQuery( new LoadExternalNetworkInjectionFilter( summary.getExternalNetworkInjectionId() ) ), ResponseTypes.instanceOf(ExternalNetworkInjection.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExternalNetworkInjection with id " + summary.getExternalNetworkInjectionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExternalNetworkInjections
     *
     * @return 	List<ExternalNetworkInjection> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExternalNetworkInjection> getAllExternalNetworkInjection() 
    throws ProcessingException {
        List<ExternalNetworkInjection> list = null;

        try {
        	CompletableFuture<List<ExternalNetworkInjection>> futureList = queryGateway.query(new FindAllExternalNetworkInjectionQuery(), ResponseTypes.multipleInstancesOf(ExternalNetworkInjection.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExternalNetworkInjection";
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
	 * @return		ExternalNetworkInjection
	 */
	protected ExternalNetworkInjection load( UUID id ) throws ProcessingException {
		externalNetworkInjection = ExternalNetworkInjectionBusinessDelegate.getExternalNetworkInjectionInstance().getExternalNetworkInjection( new ExternalNetworkInjectionFetchOneSummary(id) );	
		return externalNetworkInjection;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExternalNetworkInjection externalNetworkInjection 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExternalNetworkInjectionBusinessDelegate.class.getName());
    
}
