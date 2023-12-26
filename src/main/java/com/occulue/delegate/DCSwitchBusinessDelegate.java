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
 * DCSwitch business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCSwitch related services in the case of a DCSwitch business related service failing.</li>
 * <li>Exposes a simpler, uniform DCSwitch interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCSwitch business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCSwitchBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCSwitchBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCSwitch Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCSwitchBusinessDelegate
	*/
	public static DCSwitchBusinessDelegate getDCSwitchInstance() {
		return( new DCSwitchBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCSwitch( CreateDCSwitchCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCSwitchId() == null )
				command.setDCSwitchId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCSwitchValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCSwitchCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCSwitchCommand of DCSwitch is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCSwitch( UpdateDCSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCSwitchValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCSwitchValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCSwitch using Id = "  + command.getDCSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCSwitch via DCSwitchFetchOneSummary
     * @param 	summary DCSwitchFetchOneSummary 
     * @return 	DCSwitchFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCSwitch getDCSwitch( DCSwitchFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCSwitchFetchOneSummary arg cannot be null" );
    	
    	DCSwitch entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCSwitchValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCSwitch
        	// --------------------------------------
        	CompletableFuture<DCSwitch> futureEntity = queryGateway.query(new FindDCSwitchQuery( new LoadDCSwitchFilter( summary.getDCSwitchId() ) ), ResponseTypes.instanceOf(DCSwitch.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCSwitch with id " + summary.getDCSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCSwitchs
     *
     * @return 	List<DCSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCSwitch> getAllDCSwitch() 
    throws ProcessingException {
        List<DCSwitch> list = null;

        try {
        	CompletableFuture<List<DCSwitch>> futureList = queryGateway.query(new FindAllDCSwitchQuery(), ResponseTypes.multipleInstancesOf(DCSwitch.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCSwitch";
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
	 * @return		DCSwitch
	 */
	protected DCSwitch load( UUID id ) throws ProcessingException {
		dCSwitch = DCSwitchBusinessDelegate.getDCSwitchInstance().getDCSwitch( new DCSwitchFetchOneSummary(id) );	
		return dCSwitch;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCSwitch dCSwitch 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCSwitchBusinessDelegate.class.getName());
    
}
