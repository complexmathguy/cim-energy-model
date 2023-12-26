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
 * PFVArControllerType2Dynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArControllerType2Dynamics related services in the case of a PFVArControllerType2Dynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArControllerType2Dynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArControllerType2Dynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArControllerType2DynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArControllerType2DynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArControllerType2Dynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArControllerType2DynamicsBusinessDelegate
	*/
	public static PFVArControllerType2DynamicsBusinessDelegate getPFVArControllerType2DynamicsInstance() {
		return( new PFVArControllerType2DynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArControllerType2Dynamics( CreatePFVArControllerType2DynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArControllerType2DynamicsId() == null )
				command.setPFVArControllerType2DynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType2DynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArControllerType2DynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArControllerType2DynamicsCommand of PFVArControllerType2Dynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArControllerType2Dynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArControllerType2DynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArControllerType2Dynamics( UpdatePFVArControllerType2DynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArControllerType2DynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArControllerType2DynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArControllerType2Dynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArControllerType2DynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArControllerType2DynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType2DynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArControllerType2DynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArControllerType2Dynamics using Id = "  + command.getPFVArControllerType2DynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArControllerType2Dynamics via PFVArControllerType2DynamicsFetchOneSummary
     * @param 	summary PFVArControllerType2DynamicsFetchOneSummary 
     * @return 	PFVArControllerType2DynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArControllerType2Dynamics getPFVArControllerType2Dynamics( PFVArControllerType2DynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArControllerType2DynamicsFetchOneSummary arg cannot be null" );
    	
    	PFVArControllerType2Dynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArControllerType2DynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArControllerType2Dynamics
        	// --------------------------------------
        	CompletableFuture<PFVArControllerType2Dynamics> futureEntity = queryGateway.query(new FindPFVArControllerType2DynamicsQuery( new LoadPFVArControllerType2DynamicsFilter( summary.getPFVArControllerType2DynamicsId() ) ), ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArControllerType2Dynamics with id " + summary.getPFVArControllerType2DynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArControllerType2Dynamicss
     *
     * @return 	List<PFVArControllerType2Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArControllerType2Dynamics> getAllPFVArControllerType2Dynamics() 
    throws ProcessingException {
        List<PFVArControllerType2Dynamics> list = null;

        try {
        	CompletableFuture<List<PFVArControllerType2Dynamics>> futureList = queryGateway.query(new FindAllPFVArControllerType2DynamicsQuery(), ResponseTypes.multipleInstancesOf(PFVArControllerType2Dynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArControllerType2Dynamics";
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
	 * @return		PFVArControllerType2Dynamics
	 */
	protected PFVArControllerType2Dynamics load( UUID id ) throws ProcessingException {
		pFVArControllerType2Dynamics = PFVArControllerType2DynamicsBusinessDelegate.getPFVArControllerType2DynamicsInstance().getPFVArControllerType2Dynamics( new PFVArControllerType2DynamicsFetchOneSummary(id) );	
		return pFVArControllerType2Dynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArControllerType2Dynamics pFVArControllerType2Dynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArControllerType2DynamicsBusinessDelegate.class.getName());
    
}
