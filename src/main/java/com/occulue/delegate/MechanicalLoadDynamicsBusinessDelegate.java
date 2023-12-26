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
 * MechanicalLoadDynamics business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of MechanicalLoadDynamics related services in the case of a MechanicalLoadDynamics business related service failing.</li>
 * <li>Exposes a simpler, uniform MechanicalLoadDynamics interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill MechanicalLoadDynamics business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class MechanicalLoadDynamicsBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public MechanicalLoadDynamicsBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* MechanicalLoadDynamics Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	MechanicalLoadDynamicsBusinessDelegate
	*/
	public static MechanicalLoadDynamicsBusinessDelegate getMechanicalLoadDynamicsInstance() {
		return( new MechanicalLoadDynamicsBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createMechanicalLoadDynamics( CreateMechanicalLoadDynamicsCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getMechanicalLoadDynamicsId() == null )
				command.setMechanicalLoadDynamicsId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechanicalLoadDynamicsValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateMechanicalLoadDynamicsCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateMechanicalLoadDynamicsCommand of MechanicalLoadDynamics is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create MechanicalLoadDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateMechanicalLoadDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateMechanicalLoadDynamics( UpdateMechanicalLoadDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	MechanicalLoadDynamicsValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateMechanicalLoadDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save MechanicalLoadDynamics - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteMechanicalLoadDynamicsCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteMechanicalLoadDynamicsCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	MechanicalLoadDynamicsValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteMechanicalLoadDynamicsCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete MechanicalLoadDynamics using Id = "  + command.getMechanicalLoadDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the MechanicalLoadDynamics via MechanicalLoadDynamicsFetchOneSummary
     * @param 	summary MechanicalLoadDynamicsFetchOneSummary 
     * @return 	MechanicalLoadDynamicsFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public MechanicalLoadDynamics getMechanicalLoadDynamics( MechanicalLoadDynamicsFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "MechanicalLoadDynamicsFetchOneSummary arg cannot be null" );
    	
    	MechanicalLoadDynamics entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	MechanicalLoadDynamicsValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a MechanicalLoadDynamics
        	// --------------------------------------
        	CompletableFuture<MechanicalLoadDynamics> futureEntity = queryGateway.query(new FindMechanicalLoadDynamicsQuery( new LoadMechanicalLoadDynamicsFilter( summary.getMechanicalLoadDynamicsId() ) ), ResponseTypes.instanceOf(MechanicalLoadDynamics.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate MechanicalLoadDynamics with id " + summary.getMechanicalLoadDynamicsId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all MechanicalLoadDynamicss
     *
     * @return 	List<MechanicalLoadDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<MechanicalLoadDynamics> getAllMechanicalLoadDynamics() 
    throws ProcessingException {
        List<MechanicalLoadDynamics> list = null;

        try {
        	CompletableFuture<List<MechanicalLoadDynamics>> futureList = queryGateway.query(new FindAllMechanicalLoadDynamicsQuery(), ResponseTypes.multipleInstancesOf(MechanicalLoadDynamics.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all MechanicalLoadDynamics";
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
	 * @return		MechanicalLoadDynamics
	 */
	protected MechanicalLoadDynamics load( UUID id ) throws ProcessingException {
		mechanicalLoadDynamics = MechanicalLoadDynamicsBusinessDelegate.getMechanicalLoadDynamicsInstance().getMechanicalLoadDynamics( new MechanicalLoadDynamicsFetchOneSummary(id) );	
		return mechanicalLoadDynamics;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private MechanicalLoadDynamics mechanicalLoadDynamics 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(MechanicalLoadDynamicsBusinessDelegate.class.getName());
    
}
