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
 * VoltagePerReactivePower business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VoltagePerReactivePower related services in the case of a VoltagePerReactivePower business related service failing.</li>
 * <li>Exposes a simpler, uniform VoltagePerReactivePower interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VoltagePerReactivePower business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VoltagePerReactivePowerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VoltagePerReactivePowerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VoltagePerReactivePower Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VoltagePerReactivePowerBusinessDelegate
	*/
	public static VoltagePerReactivePowerBusinessDelegate getVoltagePerReactivePowerInstance() {
		return( new VoltagePerReactivePowerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVoltagePerReactivePower( CreateVoltagePerReactivePowerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVoltagePerReactivePowerId() == null )
				command.setVoltagePerReactivePowerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltagePerReactivePowerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVoltagePerReactivePowerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVoltagePerReactivePowerCommand of VoltagePerReactivePower is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VoltagePerReactivePower - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVoltagePerReactivePowerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVoltagePerReactivePower( UpdateVoltagePerReactivePowerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VoltagePerReactivePowerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVoltagePerReactivePowerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VoltagePerReactivePower - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVoltagePerReactivePowerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVoltagePerReactivePowerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltagePerReactivePowerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVoltagePerReactivePowerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VoltagePerReactivePower using Id = "  + command.getVoltagePerReactivePowerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VoltagePerReactivePower via VoltagePerReactivePowerFetchOneSummary
     * @param 	summary VoltagePerReactivePowerFetchOneSummary 
     * @return 	VoltagePerReactivePowerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VoltagePerReactivePower getVoltagePerReactivePower( VoltagePerReactivePowerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VoltagePerReactivePowerFetchOneSummary arg cannot be null" );
    	
    	VoltagePerReactivePower entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VoltagePerReactivePowerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VoltagePerReactivePower
        	// --------------------------------------
        	CompletableFuture<VoltagePerReactivePower> futureEntity = queryGateway.query(new FindVoltagePerReactivePowerQuery( new LoadVoltagePerReactivePowerFilter( summary.getVoltagePerReactivePowerId() ) ), ResponseTypes.instanceOf(VoltagePerReactivePower.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VoltagePerReactivePower with id " + summary.getVoltagePerReactivePowerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VoltagePerReactivePowers
     *
     * @return 	List<VoltagePerReactivePower> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VoltagePerReactivePower> getAllVoltagePerReactivePower() 
    throws ProcessingException {
        List<VoltagePerReactivePower> list = null;

        try {
        	CompletableFuture<List<VoltagePerReactivePower>> futureList = queryGateway.query(new FindAllVoltagePerReactivePowerQuery(), ResponseTypes.multipleInstancesOf(VoltagePerReactivePower.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VoltagePerReactivePower";
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
	 * @return		VoltagePerReactivePower
	 */
	protected VoltagePerReactivePower load( UUID id ) throws ProcessingException {
		voltagePerReactivePower = VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance().getVoltagePerReactivePower( new VoltagePerReactivePowerFetchOneSummary(id) );	
		return voltagePerReactivePower;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VoltagePerReactivePower voltagePerReactivePower 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VoltagePerReactivePowerBusinessDelegate.class.getName());
    
}
