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
 * SynchronousMachineTimeConstantReactance business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SynchronousMachineTimeConstantReactance related services in the case of a SynchronousMachineTimeConstantReactance business related service failing.</li>
 * <li>Exposes a simpler, uniform SynchronousMachineTimeConstantReactance interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SynchronousMachineTimeConstantReactance business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SynchronousMachineTimeConstantReactanceBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SynchronousMachineTimeConstantReactanceBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SynchronousMachineTimeConstantReactance Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SynchronousMachineTimeConstantReactanceBusinessDelegate
	*/
	public static SynchronousMachineTimeConstantReactanceBusinessDelegate getSynchronousMachineTimeConstantReactanceInstance() {
		return( new SynchronousMachineTimeConstantReactanceBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSynchronousMachineTimeConstantReactance( CreateSynchronousMachineTimeConstantReactanceCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSynchronousMachineTimeConstantReactanceId() == null )
				command.setSynchronousMachineTimeConstantReactanceId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineTimeConstantReactanceValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSynchronousMachineTimeConstantReactanceCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSynchronousMachineTimeConstantReactanceCommand of SynchronousMachineTimeConstantReactance is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SynchronousMachineTimeConstantReactance - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSynchronousMachineTimeConstantReactanceCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSynchronousMachineTimeConstantReactance( UpdateSynchronousMachineTimeConstantReactanceCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SynchronousMachineTimeConstantReactanceValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSynchronousMachineTimeConstantReactanceCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SynchronousMachineTimeConstantReactance - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSynchronousMachineTimeConstantReactanceCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSynchronousMachineTimeConstantReactanceCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineTimeConstantReactanceValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSynchronousMachineTimeConstantReactanceCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SynchronousMachineTimeConstantReactance using Id = "  + command.getSynchronousMachineTimeConstantReactanceId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SynchronousMachineTimeConstantReactance via SynchronousMachineTimeConstantReactanceFetchOneSummary
     * @param 	summary SynchronousMachineTimeConstantReactanceFetchOneSummary 
     * @return 	SynchronousMachineTimeConstantReactanceFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SynchronousMachineTimeConstantReactance getSynchronousMachineTimeConstantReactance( SynchronousMachineTimeConstantReactanceFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SynchronousMachineTimeConstantReactanceFetchOneSummary arg cannot be null" );
    	
    	SynchronousMachineTimeConstantReactance entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SynchronousMachineTimeConstantReactanceValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SynchronousMachineTimeConstantReactance
        	// --------------------------------------
        	CompletableFuture<SynchronousMachineTimeConstantReactance> futureEntity = queryGateway.query(new FindSynchronousMachineTimeConstantReactanceQuery( new LoadSynchronousMachineTimeConstantReactanceFilter( summary.getSynchronousMachineTimeConstantReactanceId() ) ), ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SynchronousMachineTimeConstantReactance with id " + summary.getSynchronousMachineTimeConstantReactanceId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
     *
     * @return 	List<SynchronousMachineTimeConstantReactance> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SynchronousMachineTimeConstantReactance> getAllSynchronousMachineTimeConstantReactance() 
    throws ProcessingException {
        List<SynchronousMachineTimeConstantReactance> list = null;

        try {
        	CompletableFuture<List<SynchronousMachineTimeConstantReactance>> futureList = queryGateway.query(new FindAllSynchronousMachineTimeConstantReactanceQuery(), ResponseTypes.multipleInstancesOf(SynchronousMachineTimeConstantReactance.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SynchronousMachineTimeConstantReactance";
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
	 * @return		SynchronousMachineTimeConstantReactance
	 */
	protected SynchronousMachineTimeConstantReactance load( UUID id ) throws ProcessingException {
		synchronousMachineTimeConstantReactance = SynchronousMachineTimeConstantReactanceBusinessDelegate.getSynchronousMachineTimeConstantReactanceInstance().getSynchronousMachineTimeConstantReactance( new SynchronousMachineTimeConstantReactanceFetchOneSummary(id) );	
		return synchronousMachineTimeConstantReactance;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SynchronousMachineTimeConstantReactanceBusinessDelegate.class.getName());
    
}
