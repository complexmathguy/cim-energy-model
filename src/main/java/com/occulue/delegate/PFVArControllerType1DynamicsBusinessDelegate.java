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
 * PFVArControllerType1Dynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PFVArControllerType1Dynamics related services in the case of a PFVArControllerType1Dynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform PFVArControllerType1Dynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PFVArControllerType1Dynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PFVArControllerType1DynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PFVArControllerType1DynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PFVArControllerType1Dynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PFVArControllerType1DynamicsBusinessDelegate
	*/
	public static PFVArControllerType1DynamicsBusinessDelegate getPFVArControllerType1DynamicsInstance() {
		return( new PFVArControllerType1DynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPFVArControllerType1Dynamics( CreatePFVArControllerType1DynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPFVArControllerType1DynamicsId() == null )
				command.setPFVArControllerType1DynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType1DynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePFVArControllerType1DynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePFVArControllerType1DynamicsCommand of PFVArControllerType1Dynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PFVArControllerType1Dynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePFVArControllerType1DynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePFVArControllerType1Dynamics( UpdatePFVArControllerType1DynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PFVArControllerType1DynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePFVArControllerType1DynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PFVArControllerType1Dynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePFVArControllerType1DynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePFVArControllerType1DynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PFVArControllerType1DynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePFVArControllerType1DynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PFVArControllerType1Dynamics using Id = "  + command.getPFVArControllerType1DynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PFVArControllerType1Dynamics via PFVArControllerType1DynamicsFetchOneSummary
     * @param 	summary PFVArControllerType1DynamicsFetchOneSummary 
     * @return 	PFVArControllerType1DynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PFVArControllerType1Dynamics getPFVArControllerType1Dynamics( PFVArControllerType1DynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PFVArControllerType1DynamicsFetchOneSummary arg cannot be null" );
    	
    	PFVArControllerType1Dynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PFVArControllerType1DynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PFVArControllerType1Dynamics
        	// --------------------------------------
        	CompletableFuture<PFVArControllerType1Dynamics> futureEntity = queryGateway.query(new FindPFVArControllerType1DynamicsQuery( new LoadPFVArControllerType1DynamicsFilter( summary.getPFVArControllerType1DynamicsId() ) ), ResponseTypes.instanceOf(PFVArControllerType1Dynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PFVArControllerType1Dynamics with id " + summary.getPFVArControllerType1DynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PFVArControllerType1Dynamicss
     *
     * @return 	List<PFVArControllerType1Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PFVArControllerType1Dynamics> getAllPFVArControllerType1Dynamics() 
    throws ProcessingException {
        List<PFVArControllerType1Dynamics> list = null;

        try {
        	CompletableFuture<List<PFVArControllerType1Dynamics>> futureList = queryGateway.query(new FindAllPFVArControllerType1DynamicsQuery(), ResponseTypes.multipleInstancesOf(PFVArControllerType1Dynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PFVArControllerType1Dynamics";
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
	 * @return		PFVArControllerType1Dynamics
	 */
	protected PFVArControllerType1Dynamics load( UUID id ) throws ProcessingException {
		pFVArControllerType1Dynamics = PFVArControllerType1DynamicsBusinessDelegate.getPFVArControllerType1DynamicsInstance().getPFVArControllerType1Dynamics( new PFVArControllerType1DynamicsFetchOneSummary(id) );	
		return pFVArControllerType1Dynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PFVArControllerType1Dynamics pFVArControllerType1Dynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PFVArControllerType1DynamicsBusinessDelegate.class.getName());
    
}
