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
 * PowerTransformer business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PowerTransformer related services in the case of a PowerTransformer business related service failing.</li>
 * <li>Exposes a simpler, uniform PowerTransformer interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PowerTransformer business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PowerTransformerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PowerTransformerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PowerTransformer Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PowerTransformerBusinessDelegate
	*/
	public static PowerTransformerBusinessDelegate getPowerTransformerInstance() {
		return( new PowerTransformerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPowerTransformer( CreatePowerTransformerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPowerTransformerId() == null )
				command.setPowerTransformerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerTransformerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePowerTransformerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePowerTransformerCommand of PowerTransformer is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PowerTransformer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePowerTransformerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePowerTransformer( UpdatePowerTransformerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PowerTransformerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePowerTransformerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PowerTransformer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePowerTransformerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePowerTransformerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerTransformerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePowerTransformerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PowerTransformer using Id = "  + command.getPowerTransformerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PowerTransformer via PowerTransformerFetchOneSummary
     * @param 	summary PowerTransformerFetchOneSummary 
     * @return 	PowerTransformerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PowerTransformer getPowerTransformer( PowerTransformerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PowerTransformerFetchOneSummary arg cannot be null" );
    	
    	PowerTransformer entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PowerTransformerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PowerTransformer
        	// --------------------------------------
        	CompletableFuture<PowerTransformer> futureEntity = queryGateway.query(new FindPowerTransformerQuery( new LoadPowerTransformerFilter( summary.getPowerTransformerId() ) ), ResponseTypes.instanceOf(PowerTransformer.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PowerTransformer with id " + summary.getPowerTransformerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PowerTransformers
     *
     * @return 	List<PowerTransformer> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PowerTransformer> getAllPowerTransformer() 
    throws ProcessingException {
        List<PowerTransformer> list = null;

        try {
        	CompletableFuture<List<PowerTransformer>> futureList = queryGateway.query(new FindAllPowerTransformerQuery(), ResponseTypes.multipleInstancesOf(PowerTransformer.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PowerTransformer";
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
	 * @return		PowerTransformer
	 */
	protected PowerTransformer load( UUID id ) throws ProcessingException {
		powerTransformer = PowerTransformerBusinessDelegate.getPowerTransformerInstance().getPowerTransformer( new PowerTransformerFetchOneSummary(id) );	
		return powerTransformer;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PowerTransformer powerTransformer 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PowerTransformerBusinessDelegate.class.getName());
    
}
