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
 * EquivalentEquipment business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EquivalentEquipment related services in the case of a EquivalentEquipment business related service failing.</li>
 * <li>Exposes a simpler, uniform EquivalentEquipment interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EquivalentEquipment business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EquivalentEquipmentBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EquivalentEquipmentBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EquivalentEquipment Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EquivalentEquipmentBusinessDelegate
	*/
	public static EquivalentEquipmentBusinessDelegate getEquivalentEquipmentInstance() {
		return( new EquivalentEquipmentBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEquivalentEquipment( CreateEquivalentEquipmentCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEquivalentEquipmentId() == null )
				command.setEquivalentEquipmentId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentEquipmentValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEquivalentEquipmentCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEquivalentEquipmentCommand of EquivalentEquipment is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EquivalentEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEquivalentEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEquivalentEquipment( UpdateEquivalentEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EquivalentEquipmentValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEquivalentEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EquivalentEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEquivalentEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEquivalentEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EquivalentEquipmentValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEquivalentEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EquivalentEquipment using Id = "  + command.getEquivalentEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EquivalentEquipment via EquivalentEquipmentFetchOneSummary
     * @param 	summary EquivalentEquipmentFetchOneSummary 
     * @return 	EquivalentEquipmentFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EquivalentEquipment getEquivalentEquipment( EquivalentEquipmentFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EquivalentEquipmentFetchOneSummary arg cannot be null" );
    	
    	EquivalentEquipment entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EquivalentEquipmentValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EquivalentEquipment
        	// --------------------------------------
        	CompletableFuture<EquivalentEquipment> futureEntity = queryGateway.query(new FindEquivalentEquipmentQuery( new LoadEquivalentEquipmentFilter( summary.getEquivalentEquipmentId() ) ), ResponseTypes.instanceOf(EquivalentEquipment.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EquivalentEquipment with id " + summary.getEquivalentEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EquivalentEquipments
     *
     * @return 	List<EquivalentEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EquivalentEquipment> getAllEquivalentEquipment() 
    throws ProcessingException {
        List<EquivalentEquipment> list = null;

        try {
        	CompletableFuture<List<EquivalentEquipment>> futureList = queryGateway.query(new FindAllEquivalentEquipmentQuery(), ResponseTypes.multipleInstancesOf(EquivalentEquipment.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EquivalentEquipment";
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
	 * @return		EquivalentEquipment
	 */
	protected EquivalentEquipment load( UUID id ) throws ProcessingException {
		equivalentEquipment = EquivalentEquipmentBusinessDelegate.getEquivalentEquipmentInstance().getEquivalentEquipment( new EquivalentEquipmentFetchOneSummary(id) );	
		return equivalentEquipment;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EquivalentEquipment equivalentEquipment 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EquivalentEquipmentBusinessDelegate.class.getName());
    
}
