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
 * LoadGroup business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of LoadGroup related services in the case of a LoadGroup business related service failing.</li>
 * <li>Exposes a simpler, uniform LoadGroup interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill LoadGroup business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class LoadGroupBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public LoadGroupBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* LoadGroup Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	LoadGroupBusinessDelegate
	*/
	public static LoadGroupBusinessDelegate getLoadGroupInstance() {
		return( new LoadGroupBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createLoadGroup( CreateLoadGroupCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getLoadGroupId() == null )
				command.setLoadGroupId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadGroupValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateLoadGroupCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateLoadGroupCommand of LoadGroup is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create LoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateLoadGroup( UpdateLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	LoadGroupValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save LoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadGroupValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete LoadGroup using Id = "  + command.getLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the LoadGroup via LoadGroupFetchOneSummary
     * @param 	summary LoadGroupFetchOneSummary 
     * @return 	LoadGroupFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public LoadGroup getLoadGroup( LoadGroupFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "LoadGroupFetchOneSummary arg cannot be null" );
    	
    	LoadGroup entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	LoadGroupValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a LoadGroup
        	// --------------------------------------
        	CompletableFuture<LoadGroup> futureEntity = queryGateway.query(new FindLoadGroupQuery( new LoadLoadGroupFilter( summary.getLoadGroupId() ) ), ResponseTypes.instanceOf(LoadGroup.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate LoadGroup with id " + summary.getLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all LoadGroups
     *
     * @return 	List<LoadGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<LoadGroup> getAllLoadGroup() 
    throws ProcessingException {
        List<LoadGroup> list = null;

        try {
        	CompletableFuture<List<LoadGroup>> futureList = queryGateway.query(new FindAllLoadGroupQuery(), ResponseTypes.multipleInstancesOf(LoadGroup.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all LoadGroup";
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
	 * @return		LoadGroup
	 */
	protected LoadGroup load( UUID id ) throws ProcessingException {
		loadGroup = LoadGroupBusinessDelegate.getLoadGroupInstance().getLoadGroup( new LoadGroupFetchOneSummary(id) );	
		return loadGroup;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private LoadGroup loadGroup 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(LoadGroupBusinessDelegate.class.getName());
    
}
