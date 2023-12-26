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
 * SvPowerFlow business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SvPowerFlow related services in the case of a SvPowerFlow business related service failing.</li>
 * <li>Exposes a simpler, uniform SvPowerFlow interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SvPowerFlow business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SvPowerFlowBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SvPowerFlowBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SvPowerFlow Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SvPowerFlowBusinessDelegate
	*/
	public static SvPowerFlowBusinessDelegate getSvPowerFlowInstance() {
		return( new SvPowerFlowBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSvPowerFlow( CreateSvPowerFlowCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSvPowerFlowId() == null )
				command.setSvPowerFlowId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SvPowerFlowValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSvPowerFlowCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSvPowerFlowCommand of SvPowerFlow is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SvPowerFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSvPowerFlowCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSvPowerFlow( UpdateSvPowerFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SvPowerFlowValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSvPowerFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SvPowerFlow - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSvPowerFlowCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSvPowerFlowCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SvPowerFlowValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSvPowerFlowCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SvPowerFlow using Id = "  + command.getSvPowerFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SvPowerFlow via SvPowerFlowFetchOneSummary
     * @param 	summary SvPowerFlowFetchOneSummary 
     * @return 	SvPowerFlowFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SvPowerFlow getSvPowerFlow( SvPowerFlowFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SvPowerFlowFetchOneSummary arg cannot be null" );
    	
    	SvPowerFlow entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SvPowerFlowValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SvPowerFlow
        	// --------------------------------------
        	CompletableFuture<SvPowerFlow> futureEntity = queryGateway.query(new FindSvPowerFlowQuery( new LoadSvPowerFlowFilter( summary.getSvPowerFlowId() ) ), ResponseTypes.instanceOf(SvPowerFlow.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SvPowerFlow with id " + summary.getSvPowerFlowId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SvPowerFlows
     *
     * @return 	List<SvPowerFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SvPowerFlow> getAllSvPowerFlow() 
    throws ProcessingException {
        List<SvPowerFlow> list = null;

        try {
        	CompletableFuture<List<SvPowerFlow>> futureList = queryGateway.query(new FindAllSvPowerFlowQuery(), ResponseTypes.multipleInstancesOf(SvPowerFlow.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SvPowerFlow";
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
	 * @return		SvPowerFlow
	 */
	protected SvPowerFlow load( UUID id ) throws ProcessingException {
		svPowerFlow = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().getSvPowerFlow( new SvPowerFlowFetchOneSummary(id) );	
		return svPowerFlow;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SvPowerFlow svPowerFlow 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SvPowerFlowBusinessDelegate.class.getName());
    
}
