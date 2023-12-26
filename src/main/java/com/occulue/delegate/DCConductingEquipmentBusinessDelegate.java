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
 * DCConductingEquipment business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCConductingEquipment related services in the case of a DCConductingEquipment business related service failing.</li>
 * <li>Exposes a simpler, uniform DCConductingEquipment interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCConductingEquipment business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCConductingEquipmentBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCConductingEquipmentBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCConductingEquipment Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCConductingEquipmentBusinessDelegate
	*/
	public static DCConductingEquipmentBusinessDelegate getDCConductingEquipmentInstance() {
		return( new DCConductingEquipmentBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCConductingEquipment( CreateDCConductingEquipmentCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCConductingEquipmentId() == null )
				command.setDCConductingEquipmentId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCConductingEquipmentValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCConductingEquipmentCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCConductingEquipmentCommand of DCConductingEquipment is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCConductingEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCConductingEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCConductingEquipment( UpdateDCConductingEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCConductingEquipmentValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCConductingEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCConductingEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCConductingEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCConductingEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCConductingEquipmentValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCConductingEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCConductingEquipment using Id = "  + command.getDCConductingEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCConductingEquipment via DCConductingEquipmentFetchOneSummary
     * @param 	summary DCConductingEquipmentFetchOneSummary 
     * @return 	DCConductingEquipmentFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCConductingEquipment getDCConductingEquipment( DCConductingEquipmentFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCConductingEquipmentFetchOneSummary arg cannot be null" );
    	
    	DCConductingEquipment entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCConductingEquipmentValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCConductingEquipment
        	// --------------------------------------
        	CompletableFuture<DCConductingEquipment> futureEntity = queryGateway.query(new FindDCConductingEquipmentQuery( new LoadDCConductingEquipmentFilter( summary.getDCConductingEquipmentId() ) ), ResponseTypes.instanceOf(DCConductingEquipment.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCConductingEquipment with id " + summary.getDCConductingEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCConductingEquipments
     *
     * @return 	List<DCConductingEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCConductingEquipment> getAllDCConductingEquipment() 
    throws ProcessingException {
        List<DCConductingEquipment> list = null;

        try {
        	CompletableFuture<List<DCConductingEquipment>> futureList = queryGateway.query(new FindAllDCConductingEquipmentQuery(), ResponseTypes.multipleInstancesOf(DCConductingEquipment.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCConductingEquipment";
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
	 * @return		DCConductingEquipment
	 */
	protected DCConductingEquipment load( UUID id ) throws ProcessingException {
		dCConductingEquipment = DCConductingEquipmentBusinessDelegate.getDCConductingEquipmentInstance().getDCConductingEquipment( new DCConductingEquipmentFetchOneSummary(id) );	
		return dCConductingEquipment;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCConductingEquipment dCConductingEquipment 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCConductingEquipmentBusinessDelegate.class.getName());
    
}
