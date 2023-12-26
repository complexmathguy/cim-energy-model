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
 * LoadBreakSwitch business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of LoadBreakSwitch related services in the case of a LoadBreakSwitch business related service failing.</li>
 * <li>Exposes a simpler, uniform LoadBreakSwitch interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill LoadBreakSwitch business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class LoadBreakSwitchBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public LoadBreakSwitchBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* LoadBreakSwitch Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	LoadBreakSwitchBusinessDelegate
	*/
	public static LoadBreakSwitchBusinessDelegate getLoadBreakSwitchInstance() {
		return( new LoadBreakSwitchBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createLoadBreakSwitch( CreateLoadBreakSwitchCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getLoadBreakSwitchId() == null )
				command.setLoadBreakSwitchId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadBreakSwitchValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateLoadBreakSwitchCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateLoadBreakSwitchCommand of LoadBreakSwitch is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create LoadBreakSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateLoadBreakSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateLoadBreakSwitch( UpdateLoadBreakSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	LoadBreakSwitchValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateLoadBreakSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save LoadBreakSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteLoadBreakSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteLoadBreakSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadBreakSwitchValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteLoadBreakSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete LoadBreakSwitch using Id = "  + command.getLoadBreakSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the LoadBreakSwitch via LoadBreakSwitchFetchOneSummary
     * @param 	summary LoadBreakSwitchFetchOneSummary 
     * @return 	LoadBreakSwitchFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public LoadBreakSwitch getLoadBreakSwitch( LoadBreakSwitchFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "LoadBreakSwitchFetchOneSummary arg cannot be null" );
    	
    	LoadBreakSwitch entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	LoadBreakSwitchValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a LoadBreakSwitch
        	// --------------------------------------
        	CompletableFuture<LoadBreakSwitch> futureEntity = queryGateway.query(new FindLoadBreakSwitchQuery( new LoadLoadBreakSwitchFilter( summary.getLoadBreakSwitchId() ) ), ResponseTypes.instanceOf(LoadBreakSwitch.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate LoadBreakSwitch with id " + summary.getLoadBreakSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all LoadBreakSwitchs
     *
     * @return 	List<LoadBreakSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<LoadBreakSwitch> getAllLoadBreakSwitch() 
    throws ProcessingException {
        List<LoadBreakSwitch> list = null;

        try {
        	CompletableFuture<List<LoadBreakSwitch>> futureList = queryGateway.query(new FindAllLoadBreakSwitchQuery(), ResponseTypes.multipleInstancesOf(LoadBreakSwitch.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all LoadBreakSwitch";
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
	 * @return		LoadBreakSwitch
	 */
	protected LoadBreakSwitch load( UUID id ) throws ProcessingException {
		loadBreakSwitch = LoadBreakSwitchBusinessDelegate.getLoadBreakSwitchInstance().getLoadBreakSwitch( new LoadBreakSwitchFetchOneSummary(id) );	
		return loadBreakSwitch;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private LoadBreakSwitch loadBreakSwitch 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(LoadBreakSwitchBusinessDelegate.class.getName());
    
}
