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
 * ActivePowerLimit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ActivePowerLimit related services in the case of a ActivePowerLimit business related service failing.</li>
 * <li>Exposes a simpler, uniform ActivePowerLimit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ActivePowerLimit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ActivePowerLimitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ActivePowerLimitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ActivePowerLimit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ActivePowerLimitBusinessDelegate
	*/
	public static ActivePowerLimitBusinessDelegate getActivePowerLimitInstance() {
		return( new ActivePowerLimitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createActivePowerLimit( CreateActivePowerLimitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getActivePowerLimitId() == null )
				command.setActivePowerLimitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerLimitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateActivePowerLimitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateActivePowerLimitCommand of ActivePowerLimit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ActivePowerLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateActivePowerLimitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateActivePowerLimit( UpdateActivePowerLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ActivePowerLimitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateActivePowerLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ActivePowerLimit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteActivePowerLimitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteActivePowerLimitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ActivePowerLimitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteActivePowerLimitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ActivePowerLimit using Id = "  + command.getActivePowerLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ActivePowerLimit via ActivePowerLimitFetchOneSummary
     * @param 	summary ActivePowerLimitFetchOneSummary 
     * @return 	ActivePowerLimitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ActivePowerLimit getActivePowerLimit( ActivePowerLimitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ActivePowerLimitFetchOneSummary arg cannot be null" );
    	
    	ActivePowerLimit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ActivePowerLimitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ActivePowerLimit
        	// --------------------------------------
        	CompletableFuture<ActivePowerLimit> futureEntity = queryGateway.query(new FindActivePowerLimitQuery( new LoadActivePowerLimitFilter( summary.getActivePowerLimitId() ) ), ResponseTypes.instanceOf(ActivePowerLimit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ActivePowerLimit with id " + summary.getActivePowerLimitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ActivePowerLimits
     *
     * @return 	List<ActivePowerLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ActivePowerLimit> getAllActivePowerLimit() 
    throws ProcessingException {
        List<ActivePowerLimit> list = null;

        try {
        	CompletableFuture<List<ActivePowerLimit>> futureList = queryGateway.query(new FindAllActivePowerLimitQuery(), ResponseTypes.multipleInstancesOf(ActivePowerLimit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ActivePowerLimit";
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
	 * @return		ActivePowerLimit
	 */
	protected ActivePowerLimit load( UUID id ) throws ProcessingException {
		activePowerLimit = ActivePowerLimitBusinessDelegate.getActivePowerLimitInstance().getActivePowerLimit( new ActivePowerLimitFetchOneSummary(id) );	
		return activePowerLimit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ActivePowerLimit activePowerLimit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ActivePowerLimitBusinessDelegate.class.getName());
    
}
