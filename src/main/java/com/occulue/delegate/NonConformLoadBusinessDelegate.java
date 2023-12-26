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
 * NonConformLoad business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of NonConformLoad related services in the case of a NonConformLoad business related service failing.</li>
 * <li>Exposes a simpler, uniform NonConformLoad interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill NonConformLoad business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class NonConformLoadBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public NonConformLoadBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* NonConformLoad Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	NonConformLoadBusinessDelegate
	*/
	public static NonConformLoadBusinessDelegate getNonConformLoadInstance() {
		return( new NonConformLoadBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createNonConformLoad( CreateNonConformLoadCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getNonConformLoadId() == null )
				command.setNonConformLoadId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonConformLoadValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateNonConformLoadCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateNonConformLoadCommand of NonConformLoad is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create NonConformLoad - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateNonConformLoadCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateNonConformLoad( UpdateNonConformLoadCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	NonConformLoadValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateNonConformLoadCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save NonConformLoad - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteNonConformLoadCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteNonConformLoadCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonConformLoadValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteNonConformLoadCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete NonConformLoad using Id = "  + command.getNonConformLoadId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the NonConformLoad via NonConformLoadFetchOneSummary
     * @param 	summary NonConformLoadFetchOneSummary 
     * @return 	NonConformLoadFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public NonConformLoad getNonConformLoad( NonConformLoadFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "NonConformLoadFetchOneSummary arg cannot be null" );
    	
    	NonConformLoad entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	NonConformLoadValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a NonConformLoad
        	// --------------------------------------
        	CompletableFuture<NonConformLoad> futureEntity = queryGateway.query(new FindNonConformLoadQuery( new LoadNonConformLoadFilter( summary.getNonConformLoadId() ) ), ResponseTypes.instanceOf(NonConformLoad.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate NonConformLoad with id " + summary.getNonConformLoadId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all NonConformLoads
     *
     * @return 	List<NonConformLoad> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<NonConformLoad> getAllNonConformLoad() 
    throws ProcessingException {
        List<NonConformLoad> list = null;

        try {
        	CompletableFuture<List<NonConformLoad>> futureList = queryGateway.query(new FindAllNonConformLoadQuery(), ResponseTypes.multipleInstancesOf(NonConformLoad.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all NonConformLoad";
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
	 * @return		NonConformLoad
	 */
	protected NonConformLoad load( UUID id ) throws ProcessingException {
		nonConformLoad = NonConformLoadBusinessDelegate.getNonConformLoadInstance().getNonConformLoad( new NonConformLoadFetchOneSummary(id) );	
		return nonConformLoad;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private NonConformLoad nonConformLoad 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(NonConformLoadBusinessDelegate.class.getName());
    
}
