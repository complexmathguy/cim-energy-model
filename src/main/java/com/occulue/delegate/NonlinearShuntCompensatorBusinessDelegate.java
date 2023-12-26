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
 * NonlinearShuntCompensator business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of NonlinearShuntCompensator related services in the case of a NonlinearShuntCompensator business related service failing.</li>
 * <li>Exposes a simpler, uniform NonlinearShuntCompensator interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill NonlinearShuntCompensator business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class NonlinearShuntCompensatorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public NonlinearShuntCompensatorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* NonlinearShuntCompensator Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	NonlinearShuntCompensatorBusinessDelegate
	*/
	public static NonlinearShuntCompensatorBusinessDelegate getNonlinearShuntCompensatorInstance() {
		return( new NonlinearShuntCompensatorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createNonlinearShuntCompensator( CreateNonlinearShuntCompensatorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getNonlinearShuntCompensatorId() == null )
				command.setNonlinearShuntCompensatorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonlinearShuntCompensatorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateNonlinearShuntCompensatorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateNonlinearShuntCompensatorCommand of NonlinearShuntCompensator is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create NonlinearShuntCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateNonlinearShuntCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateNonlinearShuntCompensator( UpdateNonlinearShuntCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	NonlinearShuntCompensatorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateNonlinearShuntCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save NonlinearShuntCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteNonlinearShuntCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteNonlinearShuntCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonlinearShuntCompensatorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteNonlinearShuntCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete NonlinearShuntCompensator using Id = "  + command.getNonlinearShuntCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the NonlinearShuntCompensator via NonlinearShuntCompensatorFetchOneSummary
     * @param 	summary NonlinearShuntCompensatorFetchOneSummary 
     * @return 	NonlinearShuntCompensatorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public NonlinearShuntCompensator getNonlinearShuntCompensator( NonlinearShuntCompensatorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "NonlinearShuntCompensatorFetchOneSummary arg cannot be null" );
    	
    	NonlinearShuntCompensator entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	NonlinearShuntCompensatorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a NonlinearShuntCompensator
        	// --------------------------------------
        	CompletableFuture<NonlinearShuntCompensator> futureEntity = queryGateway.query(new FindNonlinearShuntCompensatorQuery( new LoadNonlinearShuntCompensatorFilter( summary.getNonlinearShuntCompensatorId() ) ), ResponseTypes.instanceOf(NonlinearShuntCompensator.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate NonlinearShuntCompensator with id " + summary.getNonlinearShuntCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all NonlinearShuntCompensators
     *
     * @return 	List<NonlinearShuntCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<NonlinearShuntCompensator> getAllNonlinearShuntCompensator() 
    throws ProcessingException {
        List<NonlinearShuntCompensator> list = null;

        try {
        	CompletableFuture<List<NonlinearShuntCompensator>> futureList = queryGateway.query(new FindAllNonlinearShuntCompensatorQuery(), ResponseTypes.multipleInstancesOf(NonlinearShuntCompensator.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all NonlinearShuntCompensator";
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
	 * @return		NonlinearShuntCompensator
	 */
	protected NonlinearShuntCompensator load( UUID id ) throws ProcessingException {
		nonlinearShuntCompensator = NonlinearShuntCompensatorBusinessDelegate.getNonlinearShuntCompensatorInstance().getNonlinearShuntCompensator( new NonlinearShuntCompensatorFetchOneSummary(id) );	
		return nonlinearShuntCompensator;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private NonlinearShuntCompensator nonlinearShuntCompensator 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(NonlinearShuntCompensatorBusinessDelegate.class.getName());
    
}
