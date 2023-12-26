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
 * SynchronousMachine business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SynchronousMachine related services in the case of a SynchronousMachine business related service failing.</li>
 * <li>Exposes a simpler, uniform SynchronousMachine interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SynchronousMachine business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SynchronousMachineBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SynchronousMachineBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SynchronousMachine Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SynchronousMachineBusinessDelegate
	*/
	public static SynchronousMachineBusinessDelegate getSynchronousMachineInstance() {
		return( new SynchronousMachineBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSynchronousMachine( CreateSynchronousMachineCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSynchronousMachineId() == null )
				command.setSynchronousMachineId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSynchronousMachineCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSynchronousMachineCommand of SynchronousMachine is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SynchronousMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSynchronousMachineCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSynchronousMachine( UpdateSynchronousMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SynchronousMachineValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSynchronousMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SynchronousMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSynchronousMachineCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSynchronousMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSynchronousMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SynchronousMachine using Id = "  + command.getSynchronousMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SynchronousMachine via SynchronousMachineFetchOneSummary
     * @param 	summary SynchronousMachineFetchOneSummary 
     * @return 	SynchronousMachineFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SynchronousMachine getSynchronousMachine( SynchronousMachineFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SynchronousMachineFetchOneSummary arg cannot be null" );
    	
    	SynchronousMachine entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SynchronousMachineValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SynchronousMachine
        	// --------------------------------------
        	CompletableFuture<SynchronousMachine> futureEntity = queryGateway.query(new FindSynchronousMachineQuery( new LoadSynchronousMachineFilter( summary.getSynchronousMachineId() ) ), ResponseTypes.instanceOf(SynchronousMachine.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SynchronousMachine with id " + summary.getSynchronousMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SynchronousMachines
     *
     * @return 	List<SynchronousMachine> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SynchronousMachine> getAllSynchronousMachine() 
    throws ProcessingException {
        List<SynchronousMachine> list = null;

        try {
        	CompletableFuture<List<SynchronousMachine>> futureList = queryGateway.query(new FindAllSynchronousMachineQuery(), ResponseTypes.multipleInstancesOf(SynchronousMachine.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SynchronousMachine";
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
	 * @return		SynchronousMachine
	 */
	protected SynchronousMachine load( UUID id ) throws ProcessingException {
		synchronousMachine = SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().getSynchronousMachine( new SynchronousMachineFetchOneSummary(id) );	
		return synchronousMachine;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SynchronousMachine synchronousMachine 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SynchronousMachineBusinessDelegate.class.getName());
    
}
