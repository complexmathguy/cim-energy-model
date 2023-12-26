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
 * NonConformLoadGroup business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of NonConformLoadGroup related services in the case of a NonConformLoadGroup business related service failing.</li>
 * <li>Exposes a simpler, uniform NonConformLoadGroup interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill NonConformLoadGroup business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class NonConformLoadGroupBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public NonConformLoadGroupBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* NonConformLoadGroup Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	NonConformLoadGroupBusinessDelegate
	*/
	public static NonConformLoadGroupBusinessDelegate getNonConformLoadGroupInstance() {
		return( new NonConformLoadGroupBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createNonConformLoadGroup( CreateNonConformLoadGroupCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getNonConformLoadGroupId() == null )
				command.setNonConformLoadGroupId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonConformLoadGroupValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateNonConformLoadGroupCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateNonConformLoadGroupCommand of NonConformLoadGroup is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create NonConformLoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateNonConformLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateNonConformLoadGroup( UpdateNonConformLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	NonConformLoadGroupValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateNonConformLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save NonConformLoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteNonConformLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteNonConformLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	NonConformLoadGroupValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteNonConformLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete NonConformLoadGroup using Id = "  + command.getNonConformLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the NonConformLoadGroup via NonConformLoadGroupFetchOneSummary
     * @param 	summary NonConformLoadGroupFetchOneSummary 
     * @return 	NonConformLoadGroupFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public NonConformLoadGroup getNonConformLoadGroup( NonConformLoadGroupFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "NonConformLoadGroupFetchOneSummary arg cannot be null" );
    	
    	NonConformLoadGroup entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	NonConformLoadGroupValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a NonConformLoadGroup
        	// --------------------------------------
        	CompletableFuture<NonConformLoadGroup> futureEntity = queryGateway.query(new FindNonConformLoadGroupQuery( new LoadNonConformLoadGroupFilter( summary.getNonConformLoadGroupId() ) ), ResponseTypes.instanceOf(NonConformLoadGroup.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate NonConformLoadGroup with id " + summary.getNonConformLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all NonConformLoadGroups
     *
     * @return 	List<NonConformLoadGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<NonConformLoadGroup> getAllNonConformLoadGroup() 
    throws ProcessingException {
        List<NonConformLoadGroup> list = null;

        try {
        	CompletableFuture<List<NonConformLoadGroup>> futureList = queryGateway.query(new FindAllNonConformLoadGroupQuery(), ResponseTypes.multipleInstancesOf(NonConformLoadGroup.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all NonConformLoadGroup";
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
	 * @return		NonConformLoadGroup
	 */
	protected NonConformLoadGroup load( UUID id ) throws ProcessingException {
		nonConformLoadGroup = NonConformLoadGroupBusinessDelegate.getNonConformLoadGroupInstance().getNonConformLoadGroup( new NonConformLoadGroupFetchOneSummary(id) );	
		return nonConformLoadGroup;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private NonConformLoadGroup nonConformLoadGroup 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(NonConformLoadGroupBusinessDelegate.class.getName());
    
}
