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
 * EnergyConsumer business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EnergyConsumer related services in the case of a EnergyConsumer business related service failing.</li>
 * <li>Exposes a simpler, uniform EnergyConsumer interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EnergyConsumer business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EnergyConsumerBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EnergyConsumerBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EnergyConsumer Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EnergyConsumerBusinessDelegate
	*/
	public static EnergyConsumerBusinessDelegate getEnergyConsumerInstance() {
		return( new EnergyConsumerBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEnergyConsumer( CreateEnergyConsumerCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEnergyConsumerId() == null )
				command.setEnergyConsumerId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergyConsumerValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEnergyConsumerCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEnergyConsumerCommand of EnergyConsumer is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EnergyConsumer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEnergyConsumerCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEnergyConsumer( UpdateEnergyConsumerCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EnergyConsumerValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEnergyConsumerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EnergyConsumer - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEnergyConsumerCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEnergyConsumerCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergyConsumerValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEnergyConsumerCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EnergyConsumer using Id = "  + command.getEnergyConsumerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EnergyConsumer via EnergyConsumerFetchOneSummary
     * @param 	summary EnergyConsumerFetchOneSummary 
     * @return 	EnergyConsumerFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EnergyConsumer getEnergyConsumer( EnergyConsumerFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EnergyConsumerFetchOneSummary arg cannot be null" );
    	
    	EnergyConsumer entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EnergyConsumerValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EnergyConsumer
        	// --------------------------------------
        	CompletableFuture<EnergyConsumer> futureEntity = queryGateway.query(new FindEnergyConsumerQuery( new LoadEnergyConsumerFilter( summary.getEnergyConsumerId() ) ), ResponseTypes.instanceOf(EnergyConsumer.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EnergyConsumer with id " + summary.getEnergyConsumerId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EnergyConsumers
     *
     * @return 	List<EnergyConsumer> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EnergyConsumer> getAllEnergyConsumer() 
    throws ProcessingException {
        List<EnergyConsumer> list = null;

        try {
        	CompletableFuture<List<EnergyConsumer>> futureList = queryGateway.query(new FindAllEnergyConsumerQuery(), ResponseTypes.multipleInstancesOf(EnergyConsumer.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EnergyConsumer";
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
	 * @return		EnergyConsumer
	 */
	protected EnergyConsumer load( UUID id ) throws ProcessingException {
		energyConsumer = EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().getEnergyConsumer( new EnergyConsumerFetchOneSummary(id) );	
		return energyConsumer;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EnergyConsumer energyConsumer 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EnergyConsumerBusinessDelegate.class.getName());
    
}
