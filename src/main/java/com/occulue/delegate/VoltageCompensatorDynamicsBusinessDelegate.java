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
 * VoltageCompensatorDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VoltageCompensatorDynamics related services in the case of a VoltageCompensatorDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform VoltageCompensatorDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VoltageCompensatorDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VoltageCompensatorDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VoltageCompensatorDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VoltageCompensatorDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VoltageCompensatorDynamicsBusinessDelegate
	*/
	public static VoltageCompensatorDynamicsBusinessDelegate getVoltageCompensatorDynamicsInstance() {
		return( new VoltageCompensatorDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVoltageCompensatorDynamics( CreateVoltageCompensatorDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVoltageCompensatorDynamicsId() == null )
				command.setVoltageCompensatorDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageCompensatorDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVoltageCompensatorDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVoltageCompensatorDynamicsCommand of VoltageCompensatorDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VoltageCompensatorDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVoltageCompensatorDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVoltageCompensatorDynamics( UpdateVoltageCompensatorDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VoltageCompensatorDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVoltageCompensatorDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VoltageCompensatorDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVoltageCompensatorDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVoltageCompensatorDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageCompensatorDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVoltageCompensatorDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VoltageCompensatorDynamics using Id = "  + command.getVoltageCompensatorDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VoltageCompensatorDynamics via VoltageCompensatorDynamicsFetchOneSummary
     * @param 	summary VoltageCompensatorDynamicsFetchOneSummary 
     * @return 	VoltageCompensatorDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VoltageCompensatorDynamics getVoltageCompensatorDynamics( VoltageCompensatorDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VoltageCompensatorDynamicsFetchOneSummary arg cannot be null" );
    	
    	VoltageCompensatorDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VoltageCompensatorDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VoltageCompensatorDynamics
        	// --------------------------------------
        	CompletableFuture<VoltageCompensatorDynamics> futureEntity = queryGateway.query(new FindVoltageCompensatorDynamicsQuery( new LoadVoltageCompensatorDynamicsFilter( summary.getVoltageCompensatorDynamicsId() ) ), ResponseTypes.instanceOf(VoltageCompensatorDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VoltageCompensatorDynamics with id " + summary.getVoltageCompensatorDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VoltageCompensatorDynamicss
     *
     * @return 	List<VoltageCompensatorDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VoltageCompensatorDynamics> getAllVoltageCompensatorDynamics() 
    throws ProcessingException {
        List<VoltageCompensatorDynamics> list = null;

        try {
        	CompletableFuture<List<VoltageCompensatorDynamics>> futureList = queryGateway.query(new FindAllVoltageCompensatorDynamicsQuery(), ResponseTypes.multipleInstancesOf(VoltageCompensatorDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VoltageCompensatorDynamics";
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
	 * @return		VoltageCompensatorDynamics
	 */
	protected VoltageCompensatorDynamics load( UUID id ) throws ProcessingException {
		voltageCompensatorDynamics = VoltageCompensatorDynamicsBusinessDelegate.getVoltageCompensatorDynamicsInstance().getVoltageCompensatorDynamics( new VoltageCompensatorDynamicsFetchOneSummary(id) );	
		return voltageCompensatorDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VoltageCompensatorDynamics voltageCompensatorDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VoltageCompensatorDynamicsBusinessDelegate.class.getName());
    
}
