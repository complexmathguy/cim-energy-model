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
 * ProtectedSwitch business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ProtectedSwitch related services in the case of a ProtectedSwitch business related service failing.</li>
 * <li>Exposes a simpler, uniform ProtectedSwitch interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ProtectedSwitch business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ProtectedSwitchBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ProtectedSwitchBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ProtectedSwitch Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ProtectedSwitchBusinessDelegate
	*/
	public static ProtectedSwitchBusinessDelegate getProtectedSwitchInstance() {
		return( new ProtectedSwitchBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createProtectedSwitch( CreateProtectedSwitchCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getProtectedSwitchId() == null )
				command.setProtectedSwitchId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ProtectedSwitchValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateProtectedSwitchCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateProtectedSwitchCommand of ProtectedSwitch is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ProtectedSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateProtectedSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateProtectedSwitch( UpdateProtectedSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ProtectedSwitchValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateProtectedSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ProtectedSwitch - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteProtectedSwitchCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteProtectedSwitchCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ProtectedSwitchValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteProtectedSwitchCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ProtectedSwitch using Id = "  + command.getProtectedSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ProtectedSwitch via ProtectedSwitchFetchOneSummary
     * @param 	summary ProtectedSwitchFetchOneSummary 
     * @return 	ProtectedSwitchFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ProtectedSwitch getProtectedSwitch( ProtectedSwitchFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ProtectedSwitchFetchOneSummary arg cannot be null" );
    	
    	ProtectedSwitch entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ProtectedSwitchValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ProtectedSwitch
        	// --------------------------------------
        	CompletableFuture<ProtectedSwitch> futureEntity = queryGateway.query(new FindProtectedSwitchQuery( new LoadProtectedSwitchFilter( summary.getProtectedSwitchId() ) ), ResponseTypes.instanceOf(ProtectedSwitch.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ProtectedSwitch with id " + summary.getProtectedSwitchId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ProtectedSwitchs
     *
     * @return 	List<ProtectedSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ProtectedSwitch> getAllProtectedSwitch() 
    throws ProcessingException {
        List<ProtectedSwitch> list = null;

        try {
        	CompletableFuture<List<ProtectedSwitch>> futureList = queryGateway.query(new FindAllProtectedSwitchQuery(), ResponseTypes.multipleInstancesOf(ProtectedSwitch.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ProtectedSwitch";
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
	 * @return		ProtectedSwitch
	 */
	protected ProtectedSwitch load( UUID id ) throws ProcessingException {
		protectedSwitch = ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().getProtectedSwitch( new ProtectedSwitchFetchOneSummary(id) );	
		return protectedSwitch;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ProtectedSwitch protectedSwitch 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ProtectedSwitchBusinessDelegate.class.getName());
    
}
