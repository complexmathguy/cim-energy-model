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
 * PowerSystemStabilizerDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PowerSystemStabilizerDynamics related services in the case of a PowerSystemStabilizerDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform PowerSystemStabilizerDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PowerSystemStabilizerDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PowerSystemStabilizerDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PowerSystemStabilizerDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PowerSystemStabilizerDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PowerSystemStabilizerDynamicsBusinessDelegate
	*/
	public static PowerSystemStabilizerDynamicsBusinessDelegate getPowerSystemStabilizerDynamicsInstance() {
		return( new PowerSystemStabilizerDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPowerSystemStabilizerDynamics( CreatePowerSystemStabilizerDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPowerSystemStabilizerDynamicsId() == null )
				command.setPowerSystemStabilizerDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerSystemStabilizerDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePowerSystemStabilizerDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePowerSystemStabilizerDynamicsCommand of PowerSystemStabilizerDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PowerSystemStabilizerDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePowerSystemStabilizerDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePowerSystemStabilizerDynamics( UpdatePowerSystemStabilizerDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PowerSystemStabilizerDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePowerSystemStabilizerDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PowerSystemStabilizerDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePowerSystemStabilizerDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePowerSystemStabilizerDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerSystemStabilizerDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePowerSystemStabilizerDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PowerSystemStabilizerDynamics using Id = "  + command.getPowerSystemStabilizerDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PowerSystemStabilizerDynamics via PowerSystemStabilizerDynamicsFetchOneSummary
     * @param 	summary PowerSystemStabilizerDynamicsFetchOneSummary 
     * @return 	PowerSystemStabilizerDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PowerSystemStabilizerDynamics getPowerSystemStabilizerDynamics( PowerSystemStabilizerDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PowerSystemStabilizerDynamicsFetchOneSummary arg cannot be null" );
    	
    	PowerSystemStabilizerDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PowerSystemStabilizerDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PowerSystemStabilizerDynamics
        	// --------------------------------------
        	CompletableFuture<PowerSystemStabilizerDynamics> futureEntity = queryGateway.query(new FindPowerSystemStabilizerDynamicsQuery( new LoadPowerSystemStabilizerDynamicsFilter( summary.getPowerSystemStabilizerDynamicsId() ) ), ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PowerSystemStabilizerDynamics with id " + summary.getPowerSystemStabilizerDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PowerSystemStabilizerDynamicss
     *
     * @return 	List<PowerSystemStabilizerDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PowerSystemStabilizerDynamics> getAllPowerSystemStabilizerDynamics() 
    throws ProcessingException {
        List<PowerSystemStabilizerDynamics> list = null;

        try {
        	CompletableFuture<List<PowerSystemStabilizerDynamics>> futureList = queryGateway.query(new FindAllPowerSystemStabilizerDynamicsQuery(), ResponseTypes.multipleInstancesOf(PowerSystemStabilizerDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PowerSystemStabilizerDynamics";
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
	 * @return		PowerSystemStabilizerDynamics
	 */
	protected PowerSystemStabilizerDynamics load( UUID id ) throws ProcessingException {
		powerSystemStabilizerDynamics = PowerSystemStabilizerDynamicsBusinessDelegate.getPowerSystemStabilizerDynamicsInstance().getPowerSystemStabilizerDynamics( new PowerSystemStabilizerDynamicsFetchOneSummary(id) );	
		return powerSystemStabilizerDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PowerSystemStabilizerDynamics powerSystemStabilizerDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PowerSystemStabilizerDynamicsBusinessDelegate.class.getName());
    
}
