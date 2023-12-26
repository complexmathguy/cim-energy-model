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
 * ProprietaryParameterDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ProprietaryParameterDynamics related services in the case of a ProprietaryParameterDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform ProprietaryParameterDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ProprietaryParameterDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ProprietaryParameterDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ProprietaryParameterDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ProprietaryParameterDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ProprietaryParameterDynamicsBusinessDelegate
	*/
	public static ProprietaryParameterDynamicsBusinessDelegate getProprietaryParameterDynamicsInstance() {
		return( new ProprietaryParameterDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createProprietaryParameterDynamics( CreateProprietaryParameterDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getProprietaryParameterDynamicsId() == null )
				command.setProprietaryParameterDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ProprietaryParameterDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateProprietaryParameterDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateProprietaryParameterDynamicsCommand of ProprietaryParameterDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ProprietaryParameterDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateProprietaryParameterDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateProprietaryParameterDynamics( UpdateProprietaryParameterDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ProprietaryParameterDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateProprietaryParameterDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ProprietaryParameterDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteProprietaryParameterDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteProprietaryParameterDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ProprietaryParameterDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteProprietaryParameterDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ProprietaryParameterDynamics using Id = "  + command.getProprietaryParameterDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ProprietaryParameterDynamics via ProprietaryParameterDynamicsFetchOneSummary
     * @param 	summary ProprietaryParameterDynamicsFetchOneSummary 
     * @return 	ProprietaryParameterDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ProprietaryParameterDynamics getProprietaryParameterDynamics( ProprietaryParameterDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ProprietaryParameterDynamicsFetchOneSummary arg cannot be null" );
    	
    	ProprietaryParameterDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ProprietaryParameterDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ProprietaryParameterDynamics
        	// --------------------------------------
        	CompletableFuture<ProprietaryParameterDynamics> futureEntity = queryGateway.query(new FindProprietaryParameterDynamicsQuery( new LoadProprietaryParameterDynamicsFilter( summary.getProprietaryParameterDynamicsId() ) ), ResponseTypes.instanceOf(ProprietaryParameterDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ProprietaryParameterDynamics with id " + summary.getProprietaryParameterDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ProprietaryParameterDynamicss
     *
     * @return 	List<ProprietaryParameterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ProprietaryParameterDynamics> getAllProprietaryParameterDynamics() 
    throws ProcessingException {
        List<ProprietaryParameterDynamics> list = null;

        try {
        	CompletableFuture<List<ProprietaryParameterDynamics>> futureList = queryGateway.query(new FindAllProprietaryParameterDynamicsQuery(), ResponseTypes.multipleInstancesOf(ProprietaryParameterDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ProprietaryParameterDynamics";
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
	 * @return		ProprietaryParameterDynamics
	 */
	protected ProprietaryParameterDynamics load( UUID id ) throws ProcessingException {
		proprietaryParameterDynamics = ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance().getProprietaryParameterDynamics( new ProprietaryParameterDynamicsFetchOneSummary(id) );	
		return proprietaryParameterDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ProprietaryParameterDynamics proprietaryParameterDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ProprietaryParameterDynamicsBusinessDelegate.class.getName());
    
}
