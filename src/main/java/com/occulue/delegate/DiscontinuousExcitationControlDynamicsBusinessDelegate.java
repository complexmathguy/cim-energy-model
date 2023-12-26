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
 * DiscontinuousExcitationControlDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiscontinuousExcitationControlDynamics related services in the case of a DiscontinuousExcitationControlDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform DiscontinuousExcitationControlDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiscontinuousExcitationControlDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiscontinuousExcitationControlDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiscontinuousExcitationControlDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiscontinuousExcitationControlDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiscontinuousExcitationControlDynamicsBusinessDelegate
	*/
	public static DiscontinuousExcitationControlDynamicsBusinessDelegate getDiscontinuousExcitationControlDynamicsInstance() {
		return( new DiscontinuousExcitationControlDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiscontinuousExcitationControlDynamics( CreateDiscontinuousExcitationControlDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiscontinuousExcitationControlDynamicsId() == null )
				command.setDiscontinuousExcitationControlDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscontinuousExcitationControlDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiscontinuousExcitationControlDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiscontinuousExcitationControlDynamicsCommand of DiscontinuousExcitationControlDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiscontinuousExcitationControlDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiscontinuousExcitationControlDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiscontinuousExcitationControlDynamics( UpdateDiscontinuousExcitationControlDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiscontinuousExcitationControlDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiscontinuousExcitationControlDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiscontinuousExcitationControlDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiscontinuousExcitationControlDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiscontinuousExcitationControlDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiscontinuousExcitationControlDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiscontinuousExcitationControlDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiscontinuousExcitationControlDynamics using Id = "  + command.getDiscontinuousExcitationControlDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiscontinuousExcitationControlDynamics via DiscontinuousExcitationControlDynamicsFetchOneSummary
     * @param 	summary DiscontinuousExcitationControlDynamicsFetchOneSummary 
     * @return 	DiscontinuousExcitationControlDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiscontinuousExcitationControlDynamics getDiscontinuousExcitationControlDynamics( DiscontinuousExcitationControlDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiscontinuousExcitationControlDynamicsFetchOneSummary arg cannot be null" );
    	
    	DiscontinuousExcitationControlDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiscontinuousExcitationControlDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiscontinuousExcitationControlDynamics
        	// --------------------------------------
        	CompletableFuture<DiscontinuousExcitationControlDynamics> futureEntity = queryGateway.query(new FindDiscontinuousExcitationControlDynamicsQuery( new LoadDiscontinuousExcitationControlDynamicsFilter( summary.getDiscontinuousExcitationControlDynamicsId() ) ), ResponseTypes.instanceOf(DiscontinuousExcitationControlDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiscontinuousExcitationControlDynamics with id " + summary.getDiscontinuousExcitationControlDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiscontinuousExcitationControlDynamicss
     *
     * @return 	List<DiscontinuousExcitationControlDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiscontinuousExcitationControlDynamics> getAllDiscontinuousExcitationControlDynamics() 
    throws ProcessingException {
        List<DiscontinuousExcitationControlDynamics> list = null;

        try {
        	CompletableFuture<List<DiscontinuousExcitationControlDynamics>> futureList = queryGateway.query(new FindAllDiscontinuousExcitationControlDynamicsQuery(), ResponseTypes.multipleInstancesOf(DiscontinuousExcitationControlDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiscontinuousExcitationControlDynamics";
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
	 * @return		DiscontinuousExcitationControlDynamics
	 */
	protected DiscontinuousExcitationControlDynamics load( UUID id ) throws ProcessingException {
		discontinuousExcitationControlDynamics = DiscontinuousExcitationControlDynamicsBusinessDelegate.getDiscontinuousExcitationControlDynamicsInstance().getDiscontinuousExcitationControlDynamics( new DiscontinuousExcitationControlDynamicsFetchOneSummary(id) );	
		return discontinuousExcitationControlDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiscontinuousExcitationControlDynamics discontinuousExcitationControlDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiscontinuousExcitationControlDynamicsBusinessDelegate.class.getName());
    
}
