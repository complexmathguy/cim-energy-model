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
 * BoundaryExtensions business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of BoundaryExtensions related services in the case of a BoundaryExtensions business related service failing.</li>
 * <li>Exposes a simpler, uniform BoundaryExtensions interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill BoundaryExtensions business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class BoundaryExtensionsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public BoundaryExtensionsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* BoundaryExtensions Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	BoundaryExtensionsBusinessDelegate
	*/
	public static BoundaryExtensionsBusinessDelegate getBoundaryExtensionsInstance() {
		return( new BoundaryExtensionsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createBoundaryExtensions( CreateBoundaryExtensionsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getBoundaryExtensionsId() == null )
				command.setBoundaryExtensionsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BoundaryExtensionsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateBoundaryExtensionsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateBoundaryExtensionsCommand of BoundaryExtensions is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create BoundaryExtensions - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateBoundaryExtensionsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateBoundaryExtensions( UpdateBoundaryExtensionsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	BoundaryExtensionsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateBoundaryExtensionsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save BoundaryExtensions - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteBoundaryExtensionsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteBoundaryExtensionsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BoundaryExtensionsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteBoundaryExtensionsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete BoundaryExtensions using Id = "  + command.getBoundaryExtensionsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the BoundaryExtensions via BoundaryExtensionsFetchOneSummary
     * @param 	summary BoundaryExtensionsFetchOneSummary 
     * @return 	BoundaryExtensionsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public BoundaryExtensions getBoundaryExtensions( BoundaryExtensionsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "BoundaryExtensionsFetchOneSummary arg cannot be null" );
    	
    	BoundaryExtensions entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	BoundaryExtensionsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a BoundaryExtensions
        	// --------------------------------------
        	CompletableFuture<BoundaryExtensions> futureEntity = queryGateway.query(new FindBoundaryExtensionsQuery( new LoadBoundaryExtensionsFilter( summary.getBoundaryExtensionsId() ) ), ResponseTypes.instanceOf(BoundaryExtensions.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate BoundaryExtensions with id " + summary.getBoundaryExtensionsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all BoundaryExtensionss
     *
     * @return 	List<BoundaryExtensions> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<BoundaryExtensions> getAllBoundaryExtensions() 
    throws ProcessingException {
        List<BoundaryExtensions> list = null;

        try {
        	CompletableFuture<List<BoundaryExtensions>> futureList = queryGateway.query(new FindAllBoundaryExtensionsQuery(), ResponseTypes.multipleInstancesOf(BoundaryExtensions.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all BoundaryExtensions";
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
	 * @return		BoundaryExtensions
	 */
	protected BoundaryExtensions load( UUID id ) throws ProcessingException {
		boundaryExtensions = BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().getBoundaryExtensions( new BoundaryExtensionsFetchOneSummary(id) );	
		return boundaryExtensions;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private BoundaryExtensions boundaryExtensions 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(BoundaryExtensionsBusinessDelegate.class.getName());
    
}
