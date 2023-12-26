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
 * ConductingEquipment business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ConductingEquipment related services in the case of a ConductingEquipment business related service failing.</li>
 * <li>Exposes a simpler, uniform ConductingEquipment interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ConductingEquipment business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ConductingEquipmentBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ConductingEquipmentBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ConductingEquipment Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ConductingEquipmentBusinessDelegate
	*/
	public static ConductingEquipmentBusinessDelegate getConductingEquipmentInstance() {
		return( new ConductingEquipmentBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createConductingEquipment( CreateConductingEquipmentCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getConductingEquipmentId() == null )
				command.setConductingEquipmentId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConductingEquipmentValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateConductingEquipmentCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateConductingEquipmentCommand of ConductingEquipment is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ConductingEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateConductingEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateConductingEquipment( UpdateConductingEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ConductingEquipmentValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateConductingEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ConductingEquipment - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteConductingEquipmentCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteConductingEquipmentCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConductingEquipmentValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteConductingEquipmentCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ConductingEquipment using Id = "  + command.getConductingEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ConductingEquipment via ConductingEquipmentFetchOneSummary
     * @param 	summary ConductingEquipmentFetchOneSummary 
     * @return 	ConductingEquipmentFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ConductingEquipment getConductingEquipment( ConductingEquipmentFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ConductingEquipmentFetchOneSummary arg cannot be null" );
    	
    	ConductingEquipment entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ConductingEquipmentValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ConductingEquipment
        	// --------------------------------------
        	CompletableFuture<ConductingEquipment> futureEntity = queryGateway.query(new FindConductingEquipmentQuery( new LoadConductingEquipmentFilter( summary.getConductingEquipmentId() ) ), ResponseTypes.instanceOf(ConductingEquipment.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ConductingEquipment with id " + summary.getConductingEquipmentId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ConductingEquipments
     *
     * @return 	List<ConductingEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ConductingEquipment> getAllConductingEquipment() 
    throws ProcessingException {
        List<ConductingEquipment> list = null;

        try {
        	CompletableFuture<List<ConductingEquipment>> futureList = queryGateway.query(new FindAllConductingEquipmentQuery(), ResponseTypes.multipleInstancesOf(ConductingEquipment.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ConductingEquipment";
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
	 * @return		ConductingEquipment
	 */
	protected ConductingEquipment load( UUID id ) throws ProcessingException {
		conductingEquipment = ConductingEquipmentBusinessDelegate.getConductingEquipmentInstance().getConductingEquipment( new ConductingEquipmentFetchOneSummary(id) );	
		return conductingEquipment;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ConductingEquipment conductingEquipment 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ConductingEquipmentBusinessDelegate.class.getName());
    
}
