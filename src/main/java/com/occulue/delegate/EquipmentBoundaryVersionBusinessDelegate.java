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
 * EquipmentBoundaryVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EquipmentBoundaryVersion related services in the case of a EquipmentBoundaryVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform EquipmentBoundaryVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EquipmentBoundaryVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EquipmentBoundaryVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EquipmentBoundaryVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EquipmentBoundaryVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EquipmentBoundaryVersionBusinessDelegate
	*/
	public static EquipmentBoundaryVersionBusinessDelegate getEquipmentBoundaryVersionInstance() {
		return( new EquipmentBoundaryVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEquipmentBoundaryVersion( CreateEquipmentBoundaryVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEquipmentBoundaryVersionId() == null )
				command.setEquipmentBoundaryVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquipmentBoundaryVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEquipmentBoundaryVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEquipmentBoundaryVersionCommand of EquipmentBoundaryVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EquipmentBoundaryVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEquipmentBoundaryVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEquipmentBoundaryVersion( UpdateEquipmentBoundaryVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EquipmentBoundaryVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEquipmentBoundaryVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EquipmentBoundaryVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEquipmentBoundaryVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEquipmentBoundaryVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquipmentBoundaryVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEquipmentBoundaryVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EquipmentBoundaryVersion using Id = "  + command.getEquipmentBoundaryVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EquipmentBoundaryVersion via EquipmentBoundaryVersionFetchOneSummary
     * @param 	summary EquipmentBoundaryVersionFetchOneSummary 
     * @return 	EquipmentBoundaryVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EquipmentBoundaryVersion getEquipmentBoundaryVersion( EquipmentBoundaryVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EquipmentBoundaryVersionFetchOneSummary arg cannot be null" );
    	
    	EquipmentBoundaryVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EquipmentBoundaryVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EquipmentBoundaryVersion
        	// --------------------------------------
        	CompletableFuture<EquipmentBoundaryVersion> futureEntity = queryGateway.query(new FindEquipmentBoundaryVersionQuery( new LoadEquipmentBoundaryVersionFilter( summary.getEquipmentBoundaryVersionId() ) ), ResponseTypes.instanceOf(EquipmentBoundaryVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EquipmentBoundaryVersion with id " + summary.getEquipmentBoundaryVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EquipmentBoundaryVersions
     *
     * @return 	List<EquipmentBoundaryVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EquipmentBoundaryVersion> getAllEquipmentBoundaryVersion() 
    throws ProcessingException {
        List<EquipmentBoundaryVersion> list = null;

        try {
        	CompletableFuture<List<EquipmentBoundaryVersion>> futureList = queryGateway.query(new FindAllEquipmentBoundaryVersionQuery(), ResponseTypes.multipleInstancesOf(EquipmentBoundaryVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EquipmentBoundaryVersion";
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
	 * @return		EquipmentBoundaryVersion
	 */
	protected EquipmentBoundaryVersion load( UUID id ) throws ProcessingException {
		equipmentBoundaryVersion = EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance().getEquipmentBoundaryVersion( new EquipmentBoundaryVersionFetchOneSummary(id) );	
		return equipmentBoundaryVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EquipmentBoundaryVersion equipmentBoundaryVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EquipmentBoundaryVersionBusinessDelegate.class.getName());
    
}
