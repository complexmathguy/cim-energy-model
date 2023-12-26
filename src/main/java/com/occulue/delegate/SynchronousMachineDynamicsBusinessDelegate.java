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
 * SynchronousMachineDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SynchronousMachineDynamics related services in the case of a SynchronousMachineDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform SynchronousMachineDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SynchronousMachineDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SynchronousMachineDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SynchronousMachineDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SynchronousMachineDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SynchronousMachineDynamicsBusinessDelegate
	*/
	public static SynchronousMachineDynamicsBusinessDelegate getSynchronousMachineDynamicsInstance() {
		return( new SynchronousMachineDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSynchronousMachineDynamics( CreateSynchronousMachineDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSynchronousMachineDynamicsId() == null )
				command.setSynchronousMachineDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSynchronousMachineDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSynchronousMachineDynamicsCommand of SynchronousMachineDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SynchronousMachineDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSynchronousMachineDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSynchronousMachineDynamics( UpdateSynchronousMachineDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SynchronousMachineDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSynchronousMachineDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SynchronousMachineDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSynchronousMachineDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSynchronousMachineDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSynchronousMachineDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SynchronousMachineDynamics using Id = "  + command.getSynchronousMachineDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SynchronousMachineDynamics via SynchronousMachineDynamicsFetchOneSummary
     * @param 	summary SynchronousMachineDynamicsFetchOneSummary 
     * @return 	SynchronousMachineDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SynchronousMachineDynamics getSynchronousMachineDynamics( SynchronousMachineDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SynchronousMachineDynamicsFetchOneSummary arg cannot be null" );
    	
    	SynchronousMachineDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SynchronousMachineDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SynchronousMachineDynamics
        	// --------------------------------------
        	CompletableFuture<SynchronousMachineDynamics> futureEntity = queryGateway.query(new FindSynchronousMachineDynamicsQuery( new LoadSynchronousMachineDynamicsFilter( summary.getSynchronousMachineDynamicsId() ) ), ResponseTypes.instanceOf(SynchronousMachineDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SynchronousMachineDynamics with id " + summary.getSynchronousMachineDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SynchronousMachineDynamicss
     *
     * @return 	List<SynchronousMachineDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SynchronousMachineDynamics> getAllSynchronousMachineDynamics() 
    throws ProcessingException {
        List<SynchronousMachineDynamics> list = null;

        try {
        	CompletableFuture<List<SynchronousMachineDynamics>> futureList = queryGateway.query(new FindAllSynchronousMachineDynamicsQuery(), ResponseTypes.multipleInstancesOf(SynchronousMachineDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SynchronousMachineDynamics";
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
	 * @return		SynchronousMachineDynamics
	 */
	protected SynchronousMachineDynamics load( UUID id ) throws ProcessingException {
		synchronousMachineDynamics = SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance().getSynchronousMachineDynamics( new SynchronousMachineDynamicsFetchOneSummary(id) );	
		return synchronousMachineDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SynchronousMachineDynamics synchronousMachineDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SynchronousMachineDynamicsBusinessDelegate.class.getName());
    
}
