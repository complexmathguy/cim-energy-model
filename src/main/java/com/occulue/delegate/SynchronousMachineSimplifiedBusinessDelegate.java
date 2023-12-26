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
 * SynchronousMachineSimplified business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SynchronousMachineSimplified related services in the case of a SynchronousMachineSimplified business related service failing.</li>
 * <li>Exposes a simpler, uniform SynchronousMachineSimplified interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SynchronousMachineSimplified business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SynchronousMachineSimplifiedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SynchronousMachineSimplifiedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SynchronousMachineSimplified Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SynchronousMachineSimplifiedBusinessDelegate
	*/
	public static SynchronousMachineSimplifiedBusinessDelegate getSynchronousMachineSimplifiedInstance() {
		return( new SynchronousMachineSimplifiedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSynchronousMachineSimplified( CreateSynchronousMachineSimplifiedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSynchronousMachineSimplifiedId() == null )
				command.setSynchronousMachineSimplifiedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineSimplifiedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSynchronousMachineSimplifiedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSynchronousMachineSimplifiedCommand of SynchronousMachineSimplified is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SynchronousMachineSimplified - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSynchronousMachineSimplifiedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSynchronousMachineSimplified( UpdateSynchronousMachineSimplifiedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SynchronousMachineSimplifiedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSynchronousMachineSimplifiedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SynchronousMachineSimplified - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSynchronousMachineSimplifiedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSynchronousMachineSimplifiedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SynchronousMachineSimplifiedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSynchronousMachineSimplifiedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SynchronousMachineSimplified using Id = "  + command.getSynchronousMachineSimplifiedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SynchronousMachineSimplified via SynchronousMachineSimplifiedFetchOneSummary
     * @param 	summary SynchronousMachineSimplifiedFetchOneSummary 
     * @return 	SynchronousMachineSimplifiedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SynchronousMachineSimplified getSynchronousMachineSimplified( SynchronousMachineSimplifiedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SynchronousMachineSimplifiedFetchOneSummary arg cannot be null" );
    	
    	SynchronousMachineSimplified entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SynchronousMachineSimplifiedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SynchronousMachineSimplified
        	// --------------------------------------
        	CompletableFuture<SynchronousMachineSimplified> futureEntity = queryGateway.query(new FindSynchronousMachineSimplifiedQuery( new LoadSynchronousMachineSimplifiedFilter( summary.getSynchronousMachineSimplifiedId() ) ), ResponseTypes.instanceOf(SynchronousMachineSimplified.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SynchronousMachineSimplified with id " + summary.getSynchronousMachineSimplifiedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SynchronousMachineSimplifieds
     *
     * @return 	List<SynchronousMachineSimplified> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SynchronousMachineSimplified> getAllSynchronousMachineSimplified() 
    throws ProcessingException {
        List<SynchronousMachineSimplified> list = null;

        try {
        	CompletableFuture<List<SynchronousMachineSimplified>> futureList = queryGateway.query(new FindAllSynchronousMachineSimplifiedQuery(), ResponseTypes.multipleInstancesOf(SynchronousMachineSimplified.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SynchronousMachineSimplified";
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
	 * @return		SynchronousMachineSimplified
	 */
	protected SynchronousMachineSimplified load( UUID id ) throws ProcessingException {
		synchronousMachineSimplified = SynchronousMachineSimplifiedBusinessDelegate.getSynchronousMachineSimplifiedInstance().getSynchronousMachineSimplified( new SynchronousMachineSimplifiedFetchOneSummary(id) );	
		return synchronousMachineSimplified;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SynchronousMachineSimplified synchronousMachineSimplified 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SynchronousMachineSimplifiedBusinessDelegate.class.getName());
    
}
