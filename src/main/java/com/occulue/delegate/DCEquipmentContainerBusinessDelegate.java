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
 * DCEquipmentContainer business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCEquipmentContainer related services in the case of a DCEquipmentContainer business related service failing.</li>
 * <li>Exposes a simpler, uniform DCEquipmentContainer interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCEquipmentContainer business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCEquipmentContainerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCEquipmentContainerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCEquipmentContainer Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCEquipmentContainerBusinessDelegate
	*/
	public static DCEquipmentContainerBusinessDelegate getDCEquipmentContainerInstance() {
		return( new DCEquipmentContainerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCEquipmentContainer( CreateDCEquipmentContainerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCEquipmentContainerId() == null )
				command.setDCEquipmentContainerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCEquipmentContainerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCEquipmentContainerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCEquipmentContainerCommand of DCEquipmentContainer is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCEquipmentContainer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCEquipmentContainerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCEquipmentContainer( UpdateDCEquipmentContainerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCEquipmentContainerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCEquipmentContainerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCEquipmentContainer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCEquipmentContainerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCEquipmentContainerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCEquipmentContainerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCEquipmentContainerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCEquipmentContainer using Id = "  + command.getDCEquipmentContainerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCEquipmentContainer via DCEquipmentContainerFetchOneSummary
     * @param 	summary DCEquipmentContainerFetchOneSummary 
     * @return 	DCEquipmentContainerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCEquipmentContainer getDCEquipmentContainer( DCEquipmentContainerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCEquipmentContainerFetchOneSummary arg cannot be null" );
    	
    	DCEquipmentContainer entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCEquipmentContainerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCEquipmentContainer
        	// --------------------------------------
        	CompletableFuture<DCEquipmentContainer> futureEntity = queryGateway.query(new FindDCEquipmentContainerQuery( new LoadDCEquipmentContainerFilter( summary.getDCEquipmentContainerId() ) ), ResponseTypes.instanceOf(DCEquipmentContainer.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCEquipmentContainer with id " + summary.getDCEquipmentContainerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCEquipmentContainers
     *
     * @return 	List<DCEquipmentContainer> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCEquipmentContainer> getAllDCEquipmentContainer() 
    throws ProcessingException {
        List<DCEquipmentContainer> list = null;

        try {
        	CompletableFuture<List<DCEquipmentContainer>> futureList = queryGateway.query(new FindAllDCEquipmentContainerQuery(), ResponseTypes.multipleInstancesOf(DCEquipmentContainer.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCEquipmentContainer";
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
	 * @return		DCEquipmentContainer
	 */
	protected DCEquipmentContainer load( UUID id ) throws ProcessingException {
		dCEquipmentContainer = DCEquipmentContainerBusinessDelegate.getDCEquipmentContainerInstance().getDCEquipmentContainer( new DCEquipmentContainerFetchOneSummary(id) );	
		return dCEquipmentContainer;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCEquipmentContainer dCEquipmentContainer 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCEquipmentContainerBusinessDelegate.class.getName());
    
}
