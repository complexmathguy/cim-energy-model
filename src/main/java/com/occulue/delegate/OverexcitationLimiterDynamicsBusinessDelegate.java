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
 * OverexcitationLimiterDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of OverexcitationLimiterDynamics related services in the case of a OverexcitationLimiterDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform OverexcitationLimiterDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill OverexcitationLimiterDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class OverexcitationLimiterDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public OverexcitationLimiterDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* OverexcitationLimiterDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	OverexcitationLimiterDynamicsBusinessDelegate
	*/
	public static OverexcitationLimiterDynamicsBusinessDelegate getOverexcitationLimiterDynamicsInstance() {
		return( new OverexcitationLimiterDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createOverexcitationLimiterDynamics( CreateOverexcitationLimiterDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getOverexcitationLimiterDynamicsId() == null )
				command.setOverexcitationLimiterDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcitationLimiterDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateOverexcitationLimiterDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateOverexcitationLimiterDynamicsCommand of OverexcitationLimiterDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create OverexcitationLimiterDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateOverexcitationLimiterDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateOverexcitationLimiterDynamics( UpdateOverexcitationLimiterDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	OverexcitationLimiterDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateOverexcitationLimiterDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save OverexcitationLimiterDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteOverexcitationLimiterDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteOverexcitationLimiterDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcitationLimiterDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteOverexcitationLimiterDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete OverexcitationLimiterDynamics using Id = "  + command.getOverexcitationLimiterDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the OverexcitationLimiterDynamics via OverexcitationLimiterDynamicsFetchOneSummary
     * @param 	summary OverexcitationLimiterDynamicsFetchOneSummary 
     * @return 	OverexcitationLimiterDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public OverexcitationLimiterDynamics getOverexcitationLimiterDynamics( OverexcitationLimiterDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "OverexcitationLimiterDynamicsFetchOneSummary arg cannot be null" );
    	
    	OverexcitationLimiterDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	OverexcitationLimiterDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a OverexcitationLimiterDynamics
        	// --------------------------------------
        	CompletableFuture<OverexcitationLimiterDynamics> futureEntity = queryGateway.query(new FindOverexcitationLimiterDynamicsQuery( new LoadOverexcitationLimiterDynamicsFilter( summary.getOverexcitationLimiterDynamicsId() ) ), ResponseTypes.instanceOf(OverexcitationLimiterDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate OverexcitationLimiterDynamics with id " + summary.getOverexcitationLimiterDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all OverexcitationLimiterDynamicss
     *
     * @return 	List<OverexcitationLimiterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<OverexcitationLimiterDynamics> getAllOverexcitationLimiterDynamics() 
    throws ProcessingException {
        List<OverexcitationLimiterDynamics> list = null;

        try {
        	CompletableFuture<List<OverexcitationLimiterDynamics>> futureList = queryGateway.query(new FindAllOverexcitationLimiterDynamicsQuery(), ResponseTypes.multipleInstancesOf(OverexcitationLimiterDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all OverexcitationLimiterDynamics";
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
	 * @return		OverexcitationLimiterDynamics
	 */
	protected OverexcitationLimiterDynamics load( UUID id ) throws ProcessingException {
		overexcitationLimiterDynamics = OverexcitationLimiterDynamicsBusinessDelegate.getOverexcitationLimiterDynamicsInstance().getOverexcitationLimiterDynamics( new OverexcitationLimiterDynamicsFetchOneSummary(id) );	
		return overexcitationLimiterDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private OverexcitationLimiterDynamics overexcitationLimiterDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(OverexcitationLimiterDynamicsBusinessDelegate.class.getName());
    
}
