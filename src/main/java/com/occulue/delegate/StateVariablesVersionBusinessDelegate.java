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
 * StateVariablesVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of StateVariablesVersion related services in the case of a StateVariablesVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform StateVariablesVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill StateVariablesVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class StateVariablesVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public StateVariablesVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* StateVariablesVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	StateVariablesVersionBusinessDelegate
	*/
	public static StateVariablesVersionBusinessDelegate getStateVariablesVersionInstance() {
		return( new StateVariablesVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createStateVariablesVersion( CreateStateVariablesVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getStateVariablesVersionId() == null )
				command.setStateVariablesVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StateVariablesVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateStateVariablesVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateStateVariablesVersionCommand of StateVariablesVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create StateVariablesVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateStateVariablesVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateStateVariablesVersion( UpdateStateVariablesVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	StateVariablesVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateStateVariablesVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save StateVariablesVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteStateVariablesVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteStateVariablesVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StateVariablesVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteStateVariablesVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete StateVariablesVersion using Id = "  + command.getStateVariablesVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the StateVariablesVersion via StateVariablesVersionFetchOneSummary
     * @param 	summary StateVariablesVersionFetchOneSummary 
     * @return 	StateVariablesVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public StateVariablesVersion getStateVariablesVersion( StateVariablesVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "StateVariablesVersionFetchOneSummary arg cannot be null" );
    	
    	StateVariablesVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	StateVariablesVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a StateVariablesVersion
        	// --------------------------------------
        	CompletableFuture<StateVariablesVersion> futureEntity = queryGateway.query(new FindStateVariablesVersionQuery( new LoadStateVariablesVersionFilter( summary.getStateVariablesVersionId() ) ), ResponseTypes.instanceOf(StateVariablesVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate StateVariablesVersion with id " + summary.getStateVariablesVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all StateVariablesVersions
     *
     * @return 	List<StateVariablesVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<StateVariablesVersion> getAllStateVariablesVersion() 
    throws ProcessingException {
        List<StateVariablesVersion> list = null;

        try {
        	CompletableFuture<List<StateVariablesVersion>> futureList = queryGateway.query(new FindAllStateVariablesVersionQuery(), ResponseTypes.multipleInstancesOf(StateVariablesVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all StateVariablesVersion";
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
	 * @return		StateVariablesVersion
	 */
	protected StateVariablesVersion load( UUID id ) throws ProcessingException {
		stateVariablesVersion = StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().getStateVariablesVersion( new StateVariablesVersionFetchOneSummary(id) );	
		return stateVariablesVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private StateVariablesVersion stateVariablesVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(StateVariablesVersionBusinessDelegate.class.getName());
    
}
