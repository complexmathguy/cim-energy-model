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
 * AsynchronousMachineDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AsynchronousMachineDynamics related services in the case of a AsynchronousMachineDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform AsynchronousMachineDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AsynchronousMachineDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AsynchronousMachineDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AsynchronousMachineDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AsynchronousMachineDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AsynchronousMachineDynamicsBusinessDelegate
	*/
	public static AsynchronousMachineDynamicsBusinessDelegate getAsynchronousMachineDynamicsInstance() {
		return( new AsynchronousMachineDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAsynchronousMachineDynamics( CreateAsynchronousMachineDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAsynchronousMachineDynamicsId() == null )
				command.setAsynchronousMachineDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAsynchronousMachineDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAsynchronousMachineDynamicsCommand of AsynchronousMachineDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AsynchronousMachineDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAsynchronousMachineDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAsynchronousMachineDynamics( UpdateAsynchronousMachineDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AsynchronousMachineDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAsynchronousMachineDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AsynchronousMachineDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAsynchronousMachineDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAsynchronousMachineDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAsynchronousMachineDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AsynchronousMachineDynamics using Id = "  + command.getAsynchronousMachineDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AsynchronousMachineDynamics via AsynchronousMachineDynamicsFetchOneSummary
     * @param 	summary AsynchronousMachineDynamicsFetchOneSummary 
     * @return 	AsynchronousMachineDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AsynchronousMachineDynamics getAsynchronousMachineDynamics( AsynchronousMachineDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AsynchronousMachineDynamicsFetchOneSummary arg cannot be null" );
    	
    	AsynchronousMachineDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AsynchronousMachineDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AsynchronousMachineDynamics
        	// --------------------------------------
        	CompletableFuture<AsynchronousMachineDynamics> futureEntity = queryGateway.query(new FindAsynchronousMachineDynamicsQuery( new LoadAsynchronousMachineDynamicsFilter( summary.getAsynchronousMachineDynamicsId() ) ), ResponseTypes.instanceOf(AsynchronousMachineDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AsynchronousMachineDynamics with id " + summary.getAsynchronousMachineDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AsynchronousMachineDynamicss
     *
     * @return 	List<AsynchronousMachineDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AsynchronousMachineDynamics> getAllAsynchronousMachineDynamics() 
    throws ProcessingException {
        List<AsynchronousMachineDynamics> list = null;

        try {
        	CompletableFuture<List<AsynchronousMachineDynamics>> futureList = queryGateway.query(new FindAllAsynchronousMachineDynamicsQuery(), ResponseTypes.multipleInstancesOf(AsynchronousMachineDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AsynchronousMachineDynamics";
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
	 * @return		AsynchronousMachineDynamics
	 */
	protected AsynchronousMachineDynamics load( UUID id ) throws ProcessingException {
		asynchronousMachineDynamics = AsynchronousMachineDynamicsBusinessDelegate.getAsynchronousMachineDynamicsInstance().getAsynchronousMachineDynamics( new AsynchronousMachineDynamicsFetchOneSummary(id) );	
		return asynchronousMachineDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AsynchronousMachineDynamics asynchronousMachineDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AsynchronousMachineDynamicsBusinessDelegate.class.getName());
    
}
