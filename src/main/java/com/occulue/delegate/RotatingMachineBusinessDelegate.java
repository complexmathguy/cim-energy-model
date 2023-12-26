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
 * RotatingMachine business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RotatingMachine related services in the case of a RotatingMachine business related service failing.</li>
 * <li>Exposes a simpler, uniform RotatingMachine interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RotatingMachine business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RotatingMachineBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RotatingMachineBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RotatingMachine Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RotatingMachineBusinessDelegate
	*/
	public static RotatingMachineBusinessDelegate getRotatingMachineInstance() {
		return( new RotatingMachineBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRotatingMachine( CreateRotatingMachineCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRotatingMachineId() == null )
				command.setRotatingMachineId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RotatingMachineValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRotatingMachineCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRotatingMachineCommand of RotatingMachine is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RotatingMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRotatingMachineCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRotatingMachine( UpdateRotatingMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RotatingMachineValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRotatingMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RotatingMachine - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRotatingMachineCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRotatingMachineCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RotatingMachineValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRotatingMachineCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RotatingMachine using Id = "  + command.getRotatingMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RotatingMachine via RotatingMachineFetchOneSummary
     * @param 	summary RotatingMachineFetchOneSummary 
     * @return 	RotatingMachineFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RotatingMachine getRotatingMachine( RotatingMachineFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RotatingMachineFetchOneSummary arg cannot be null" );
    	
    	RotatingMachine entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RotatingMachineValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RotatingMachine
        	// --------------------------------------
        	CompletableFuture<RotatingMachine> futureEntity = queryGateway.query(new FindRotatingMachineQuery( new LoadRotatingMachineFilter( summary.getRotatingMachineId() ) ), ResponseTypes.instanceOf(RotatingMachine.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RotatingMachine with id " + summary.getRotatingMachineId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RotatingMachines
     *
     * @return 	List<RotatingMachine> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RotatingMachine> getAllRotatingMachine() 
    throws ProcessingException {
        List<RotatingMachine> list = null;

        try {
        	CompletableFuture<List<RotatingMachine>> futureList = queryGateway.query(new FindAllRotatingMachineQuery(), ResponseTypes.multipleInstancesOf(RotatingMachine.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RotatingMachine";
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
	 * @return		RotatingMachine
	 */
	protected RotatingMachine load( UUID id ) throws ProcessingException {
		rotatingMachine = RotatingMachineBusinessDelegate.getRotatingMachineInstance().getRotatingMachine( new RotatingMachineFetchOneSummary(id) );	
		return rotatingMachine;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RotatingMachine rotatingMachine 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RotatingMachineBusinessDelegate.class.getName());
    
}
