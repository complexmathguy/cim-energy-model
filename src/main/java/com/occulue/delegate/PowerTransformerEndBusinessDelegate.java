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
 * PowerTransformerEnd business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PowerTransformerEnd related services in the case of a PowerTransformerEnd business related service failing.</li>
 * <li>Exposes a simpler, uniform PowerTransformerEnd interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PowerTransformerEnd business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PowerTransformerEndBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PowerTransformerEndBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PowerTransformerEnd Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PowerTransformerEndBusinessDelegate
	*/
	public static PowerTransformerEndBusinessDelegate getPowerTransformerEndInstance() {
		return( new PowerTransformerEndBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPowerTransformerEnd( CreatePowerTransformerEndCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPowerTransformerEndId() == null )
				command.setPowerTransformerEndId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerTransformerEndValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePowerTransformerEndCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePowerTransformerEndCommand of PowerTransformerEnd is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PowerTransformerEnd - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePowerTransformerEndCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePowerTransformerEnd( UpdatePowerTransformerEndCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PowerTransformerEndValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePowerTransformerEndCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PowerTransformerEnd - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePowerTransformerEndCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePowerTransformerEndCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PowerTransformerEndValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePowerTransformerEndCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PowerTransformerEnd using Id = "  + command.getPowerTransformerEndId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PowerTransformerEnd via PowerTransformerEndFetchOneSummary
     * @param 	summary PowerTransformerEndFetchOneSummary 
     * @return 	PowerTransformerEndFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PowerTransformerEnd getPowerTransformerEnd( PowerTransformerEndFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PowerTransformerEndFetchOneSummary arg cannot be null" );
    	
    	PowerTransformerEnd entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PowerTransformerEndValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PowerTransformerEnd
        	// --------------------------------------
        	CompletableFuture<PowerTransformerEnd> futureEntity = queryGateway.query(new FindPowerTransformerEndQuery( new LoadPowerTransformerEndFilter( summary.getPowerTransformerEndId() ) ), ResponseTypes.instanceOf(PowerTransformerEnd.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PowerTransformerEnd with id " + summary.getPowerTransformerEndId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PowerTransformerEnds
     *
     * @return 	List<PowerTransformerEnd> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PowerTransformerEnd> getAllPowerTransformerEnd() 
    throws ProcessingException {
        List<PowerTransformerEnd> list = null;

        try {
        	CompletableFuture<List<PowerTransformerEnd>> futureList = queryGateway.query(new FindAllPowerTransformerEndQuery(), ResponseTypes.multipleInstancesOf(PowerTransformerEnd.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PowerTransformerEnd";
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
	 * @return		PowerTransformerEnd
	 */
	protected PowerTransformerEnd load( UUID id ) throws ProcessingException {
		powerTransformerEnd = PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().getPowerTransformerEnd( new PowerTransformerEndFetchOneSummary(id) );	
		return powerTransformerEnd;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PowerTransformerEnd powerTransformerEnd 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PowerTransformerEndBusinessDelegate.class.getName());
    
}
