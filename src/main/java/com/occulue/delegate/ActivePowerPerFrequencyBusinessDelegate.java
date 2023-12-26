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
 * ActivePowerPerFrequency business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ActivePowerPerFrequency related services in the case of a ActivePowerPerFrequency business related service failing.</li>
 * <li>Exposes a simpler, uniform ActivePowerPerFrequency interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ActivePowerPerFrequency business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ActivePowerPerFrequencyBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ActivePowerPerFrequencyBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ActivePowerPerFrequency Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ActivePowerPerFrequencyBusinessDelegate
	*/
	public static ActivePowerPerFrequencyBusinessDelegate getActivePowerPerFrequencyInstance() {
		return( new ActivePowerPerFrequencyBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createActivePowerPerFrequency( CreateActivePowerPerFrequencyCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getActivePowerPerFrequencyId() == null )
				command.setActivePowerPerFrequencyId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerPerFrequencyValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateActivePowerPerFrequencyCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateActivePowerPerFrequencyCommand of ActivePowerPerFrequency is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ActivePowerPerFrequency - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateActivePowerPerFrequencyCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateActivePowerPerFrequency( UpdateActivePowerPerFrequencyCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ActivePowerPerFrequencyValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateActivePowerPerFrequencyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ActivePowerPerFrequency - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteActivePowerPerFrequencyCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteActivePowerPerFrequencyCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerPerFrequencyValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteActivePowerPerFrequencyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ActivePowerPerFrequency using Id = "  + command.getActivePowerPerFrequencyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ActivePowerPerFrequency via ActivePowerPerFrequencyFetchOneSummary
     * @param 	summary ActivePowerPerFrequencyFetchOneSummary 
     * @return 	ActivePowerPerFrequencyFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ActivePowerPerFrequency getActivePowerPerFrequency( ActivePowerPerFrequencyFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ActivePowerPerFrequencyFetchOneSummary arg cannot be null" );
    	
    	ActivePowerPerFrequency entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ActivePowerPerFrequencyValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ActivePowerPerFrequency
        	// --------------------------------------
        	CompletableFuture<ActivePowerPerFrequency> futureEntity = queryGateway.query(new FindActivePowerPerFrequencyQuery( new LoadActivePowerPerFrequencyFilter( summary.getActivePowerPerFrequencyId() ) ), ResponseTypes.instanceOf(ActivePowerPerFrequency.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ActivePowerPerFrequency with id " + summary.getActivePowerPerFrequencyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ActivePowerPerFrequencys
     *
     * @return 	List<ActivePowerPerFrequency> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ActivePowerPerFrequency> getAllActivePowerPerFrequency() 
    throws ProcessingException {
        List<ActivePowerPerFrequency> list = null;

        try {
        	CompletableFuture<List<ActivePowerPerFrequency>> futureList = queryGateway.query(new FindAllActivePowerPerFrequencyQuery(), ResponseTypes.multipleInstancesOf(ActivePowerPerFrequency.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ActivePowerPerFrequency";
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
	 * @return		ActivePowerPerFrequency
	 */
	protected ActivePowerPerFrequency load( UUID id ) throws ProcessingException {
		activePowerPerFrequency = ActivePowerPerFrequencyBusinessDelegate.getActivePowerPerFrequencyInstance().getActivePowerPerFrequency( new ActivePowerPerFrequencyFetchOneSummary(id) );	
		return activePowerPerFrequency;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ActivePowerPerFrequency activePowerPerFrequency 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ActivePowerPerFrequencyBusinessDelegate.class.getName());
    
}
