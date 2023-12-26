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
 * EquipmentContainer business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EquipmentContainer related services in the case of a EquipmentContainer business related service failing.</li>
 * <li>Exposes a simpler, uniform EquipmentContainer interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EquipmentContainer business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EquipmentContainerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EquipmentContainerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EquipmentContainer Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EquipmentContainerBusinessDelegate
	*/
	public static EquipmentContainerBusinessDelegate getEquipmentContainerInstance() {
		return( new EquipmentContainerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEquipmentContainer( CreateEquipmentContainerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEquipmentContainerId() == null )
				command.setEquipmentContainerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquipmentContainerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEquipmentContainerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEquipmentContainerCommand of EquipmentContainer is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EquipmentContainer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEquipmentContainerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEquipmentContainer( UpdateEquipmentContainerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EquipmentContainerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEquipmentContainerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EquipmentContainer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEquipmentContainerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEquipmentContainerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquipmentContainerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEquipmentContainerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EquipmentContainer using Id = "  + command.getEquipmentContainerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EquipmentContainer via EquipmentContainerFetchOneSummary
     * @param 	summary EquipmentContainerFetchOneSummary 
     * @return 	EquipmentContainerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EquipmentContainer getEquipmentContainer( EquipmentContainerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EquipmentContainerFetchOneSummary arg cannot be null" );
    	
    	EquipmentContainer entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EquipmentContainerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EquipmentContainer
        	// --------------------------------------
        	CompletableFuture<EquipmentContainer> futureEntity = queryGateway.query(new FindEquipmentContainerQuery( new LoadEquipmentContainerFilter( summary.getEquipmentContainerId() ) ), ResponseTypes.instanceOf(EquipmentContainer.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EquipmentContainer with id " + summary.getEquipmentContainerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EquipmentContainers
     *
     * @return 	List<EquipmentContainer> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EquipmentContainer> getAllEquipmentContainer() 
    throws ProcessingException {
        List<EquipmentContainer> list = null;

        try {
        	CompletableFuture<List<EquipmentContainer>> futureList = queryGateway.query(new FindAllEquipmentContainerQuery(), ResponseTypes.multipleInstancesOf(EquipmentContainer.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EquipmentContainer";
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
	 * @return		EquipmentContainer
	 */
	protected EquipmentContainer load( UUID id ) throws ProcessingException {
		equipmentContainer = EquipmentContainerBusinessDelegate.getEquipmentContainerInstance().getEquipmentContainer( new EquipmentContainerFetchOneSummary(id) );	
		return equipmentContainer;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EquipmentContainer equipmentContainer 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EquipmentContainerBusinessDelegate.class.getName());
    
}
