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
 * AsynchronousMachine business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AsynchronousMachine related services in the case of a AsynchronousMachine business related service failing.</li>
 * <li>Exposes a simpler, uniform AsynchronousMachine interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AsynchronousMachine business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AsynchronousMachineBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AsynchronousMachineBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AsynchronousMachine Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AsynchronousMachineBusinessDelegate
	*/
	public static AsynchronousMachineBusinessDelegate getAsynchronousMachineInstance() {
		return( new AsynchronousMachineBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAsynchronousMachine( CreateAsynchronousMachineCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAsynchronousMachineId() == null )
				command.setAsynchronousMachineId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAsynchronousMachineCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAsynchronousMachineCommand of AsynchronousMachine is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AsynchronousMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAsynchronousMachineCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAsynchronousMachine( UpdateAsynchronousMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AsynchronousMachineValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAsynchronousMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AsynchronousMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAsynchronousMachineCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAsynchronousMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAsynchronousMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AsynchronousMachine using Id = "  + command.getAsynchronousMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AsynchronousMachine via AsynchronousMachineFetchOneSummary
     * @param 	summary AsynchronousMachineFetchOneSummary 
     * @return 	AsynchronousMachineFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AsynchronousMachine getAsynchronousMachine( AsynchronousMachineFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AsynchronousMachineFetchOneSummary arg cannot be null" );
    	
    	AsynchronousMachine entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AsynchronousMachineValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AsynchronousMachine
        	// --------------------------------------
        	CompletableFuture<AsynchronousMachine> futureEntity = queryGateway.query(new FindAsynchronousMachineQuery( new LoadAsynchronousMachineFilter( summary.getAsynchronousMachineId() ) ), ResponseTypes.instanceOf(AsynchronousMachine.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AsynchronousMachine with id " + summary.getAsynchronousMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AsynchronousMachines
     *
     * @return 	List<AsynchronousMachine> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AsynchronousMachine> getAllAsynchronousMachine() 
    throws ProcessingException {
        List<AsynchronousMachine> list = null;

        try {
        	CompletableFuture<List<AsynchronousMachine>> futureList = queryGateway.query(new FindAllAsynchronousMachineQuery(), ResponseTypes.multipleInstancesOf(AsynchronousMachine.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AsynchronousMachine";
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
	 * @return		AsynchronousMachine
	 */
	protected AsynchronousMachine load( UUID id ) throws ProcessingException {
		asynchronousMachine = AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().getAsynchronousMachine( new AsynchronousMachineFetchOneSummary(id) );	
		return asynchronousMachine;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AsynchronousMachine asynchronousMachine 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AsynchronousMachineBusinessDelegate.class.getName());
    
}
