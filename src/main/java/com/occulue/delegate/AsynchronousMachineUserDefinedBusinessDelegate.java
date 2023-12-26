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
 * AsynchronousMachineUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AsynchronousMachineUserDefined related services in the case of a AsynchronousMachineUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform AsynchronousMachineUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AsynchronousMachineUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AsynchronousMachineUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AsynchronousMachineUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AsynchronousMachineUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AsynchronousMachineUserDefinedBusinessDelegate
	*/
	public static AsynchronousMachineUserDefinedBusinessDelegate getAsynchronousMachineUserDefinedInstance() {
		return( new AsynchronousMachineUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAsynchronousMachineUserDefined( CreateAsynchronousMachineUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAsynchronousMachineUserDefinedId() == null )
				command.setAsynchronousMachineUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAsynchronousMachineUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAsynchronousMachineUserDefinedCommand of AsynchronousMachineUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AsynchronousMachineUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAsynchronousMachineUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAsynchronousMachineUserDefined( UpdateAsynchronousMachineUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AsynchronousMachineUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAsynchronousMachineUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AsynchronousMachineUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAsynchronousMachineUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAsynchronousMachineUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AsynchronousMachineUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAsynchronousMachineUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AsynchronousMachineUserDefined using Id = "  + command.getAsynchronousMachineUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AsynchronousMachineUserDefined via AsynchronousMachineUserDefinedFetchOneSummary
     * @param 	summary AsynchronousMachineUserDefinedFetchOneSummary 
     * @return 	AsynchronousMachineUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AsynchronousMachineUserDefined getAsynchronousMachineUserDefined( AsynchronousMachineUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AsynchronousMachineUserDefinedFetchOneSummary arg cannot be null" );
    	
    	AsynchronousMachineUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AsynchronousMachineUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AsynchronousMachineUserDefined
        	// --------------------------------------
        	CompletableFuture<AsynchronousMachineUserDefined> futureEntity = queryGateway.query(new FindAsynchronousMachineUserDefinedQuery( new LoadAsynchronousMachineUserDefinedFilter( summary.getAsynchronousMachineUserDefinedId() ) ), ResponseTypes.instanceOf(AsynchronousMachineUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AsynchronousMachineUserDefined with id " + summary.getAsynchronousMachineUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AsynchronousMachineUserDefineds
     *
     * @return 	List<AsynchronousMachineUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AsynchronousMachineUserDefined> getAllAsynchronousMachineUserDefined() 
    throws ProcessingException {
        List<AsynchronousMachineUserDefined> list = null;

        try {
        	CompletableFuture<List<AsynchronousMachineUserDefined>> futureList = queryGateway.query(new FindAllAsynchronousMachineUserDefinedQuery(), ResponseTypes.multipleInstancesOf(AsynchronousMachineUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AsynchronousMachineUserDefined";
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
	 * @return		AsynchronousMachineUserDefined
	 */
	protected AsynchronousMachineUserDefined load( UUID id ) throws ProcessingException {
		asynchronousMachineUserDefined = AsynchronousMachineUserDefinedBusinessDelegate.getAsynchronousMachineUserDefinedInstance().getAsynchronousMachineUserDefined( new AsynchronousMachineUserDefinedFetchOneSummary(id) );	
		return asynchronousMachineUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AsynchronousMachineUserDefined asynchronousMachineUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AsynchronousMachineUserDefinedBusinessDelegate.class.getName());
    
}
