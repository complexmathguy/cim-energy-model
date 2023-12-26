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
 * ConformLoadGroup business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ConformLoadGroup related services in the case of a ConformLoadGroup business related service failing.</li>
 * <li>Exposes a simpler, uniform ConformLoadGroup interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ConformLoadGroup business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ConformLoadGroupBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ConformLoadGroupBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ConformLoadGroup Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ConformLoadGroupBusinessDelegate
	*/
	public static ConformLoadGroupBusinessDelegate getConformLoadGroupInstance() {
		return( new ConformLoadGroupBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createConformLoadGroup( CreateConformLoadGroupCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getConformLoadGroupId() == null )
				command.setConformLoadGroupId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConformLoadGroupValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateConformLoadGroupCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateConformLoadGroupCommand of ConformLoadGroup is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ConformLoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateConformLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateConformLoadGroup( UpdateConformLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ConformLoadGroupValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateConformLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ConformLoadGroup - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteConformLoadGroupCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteConformLoadGroupCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConformLoadGroupValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteConformLoadGroupCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ConformLoadGroup using Id = "  + command.getConformLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ConformLoadGroup via ConformLoadGroupFetchOneSummary
     * @param 	summary ConformLoadGroupFetchOneSummary 
     * @return 	ConformLoadGroupFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ConformLoadGroup getConformLoadGroup( ConformLoadGroupFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ConformLoadGroupFetchOneSummary arg cannot be null" );
    	
    	ConformLoadGroup entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ConformLoadGroupValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ConformLoadGroup
        	// --------------------------------------
        	CompletableFuture<ConformLoadGroup> futureEntity = queryGateway.query(new FindConformLoadGroupQuery( new LoadConformLoadGroupFilter( summary.getConformLoadGroupId() ) ), ResponseTypes.instanceOf(ConformLoadGroup.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ConformLoadGroup with id " + summary.getConformLoadGroupId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ConformLoadGroups
     *
     * @return 	List<ConformLoadGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ConformLoadGroup> getAllConformLoadGroup() 
    throws ProcessingException {
        List<ConformLoadGroup> list = null;

        try {
        	CompletableFuture<List<ConformLoadGroup>> futureList = queryGateway.query(new FindAllConformLoadGroupQuery(), ResponseTypes.multipleInstancesOf(ConformLoadGroup.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ConformLoadGroup";
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
	 * @return		ConformLoadGroup
	 */
	protected ConformLoadGroup load( UUID id ) throws ProcessingException {
		conformLoadGroup = ConformLoadGroupBusinessDelegate.getConformLoadGroupInstance().getConformLoadGroup( new ConformLoadGroupFetchOneSummary(id) );	
		return conformLoadGroup;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ConformLoadGroup conformLoadGroup 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ConformLoadGroupBusinessDelegate.class.getName());
    
}
