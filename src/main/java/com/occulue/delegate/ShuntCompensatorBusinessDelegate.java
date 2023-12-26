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
 * ShuntCompensator business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ShuntCompensator related services in the case of a ShuntCompensator business related service failing.</li>
 * <li>Exposes a simpler, uniform ShuntCompensator interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ShuntCompensator business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ShuntCompensatorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ShuntCompensatorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ShuntCompensator Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ShuntCompensatorBusinessDelegate
	*/
	public static ShuntCompensatorBusinessDelegate getShuntCompensatorInstance() {
		return( new ShuntCompensatorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createShuntCompensator( CreateShuntCompensatorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getShuntCompensatorId() == null )
				command.setShuntCompensatorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ShuntCompensatorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateShuntCompensatorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateShuntCompensatorCommand of ShuntCompensator is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ShuntCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateShuntCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateShuntCompensator( UpdateShuntCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ShuntCompensatorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateShuntCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ShuntCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteShuntCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteShuntCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ShuntCompensatorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteShuntCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ShuntCompensator using Id = "  + command.getShuntCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ShuntCompensator via ShuntCompensatorFetchOneSummary
     * @param 	summary ShuntCompensatorFetchOneSummary 
     * @return 	ShuntCompensatorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ShuntCompensator getShuntCompensator( ShuntCompensatorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ShuntCompensatorFetchOneSummary arg cannot be null" );
    	
    	ShuntCompensator entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ShuntCompensatorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ShuntCompensator
        	// --------------------------------------
        	CompletableFuture<ShuntCompensator> futureEntity = queryGateway.query(new FindShuntCompensatorQuery( new LoadShuntCompensatorFilter( summary.getShuntCompensatorId() ) ), ResponseTypes.instanceOf(ShuntCompensator.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ShuntCompensator with id " + summary.getShuntCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ShuntCompensators
     *
     * @return 	List<ShuntCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ShuntCompensator> getAllShuntCompensator() 
    throws ProcessingException {
        List<ShuntCompensator> list = null;

        try {
        	CompletableFuture<List<ShuntCompensator>> futureList = queryGateway.query(new FindAllShuntCompensatorQuery(), ResponseTypes.multipleInstancesOf(ShuntCompensator.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ShuntCompensator";
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
	 * @return		ShuntCompensator
	 */
	protected ShuntCompensator load( UUID id ) throws ProcessingException {
		shuntCompensator = ShuntCompensatorBusinessDelegate.getShuntCompensatorInstance().getShuntCompensator( new ShuntCompensatorFetchOneSummary(id) );	
		return shuntCompensator;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ShuntCompensator shuntCompensator 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ShuntCompensatorBusinessDelegate.class.getName());
    
}
