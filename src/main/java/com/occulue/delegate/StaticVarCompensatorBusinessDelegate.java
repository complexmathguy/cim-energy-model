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
 * StaticVarCompensator business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of StaticVarCompensator related services in the case of a StaticVarCompensator business related service failing.</li>
 * <li>Exposes a simpler, uniform StaticVarCompensator interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill StaticVarCompensator business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class StaticVarCompensatorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public StaticVarCompensatorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* StaticVarCompensator Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	StaticVarCompensatorBusinessDelegate
	*/
	public static StaticVarCompensatorBusinessDelegate getStaticVarCompensatorInstance() {
		return( new StaticVarCompensatorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createStaticVarCompensator( CreateStaticVarCompensatorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getStaticVarCompensatorId() == null )
				command.setStaticVarCompensatorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StaticVarCompensatorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateStaticVarCompensatorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateStaticVarCompensatorCommand of StaticVarCompensator is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create StaticVarCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateStaticVarCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateStaticVarCompensator( UpdateStaticVarCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	StaticVarCompensatorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateStaticVarCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save StaticVarCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteStaticVarCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteStaticVarCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StaticVarCompensatorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteStaticVarCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete StaticVarCompensator using Id = "  + command.getStaticVarCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the StaticVarCompensator via StaticVarCompensatorFetchOneSummary
     * @param 	summary StaticVarCompensatorFetchOneSummary 
     * @return 	StaticVarCompensatorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public StaticVarCompensator getStaticVarCompensator( StaticVarCompensatorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "StaticVarCompensatorFetchOneSummary arg cannot be null" );
    	
    	StaticVarCompensator entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	StaticVarCompensatorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a StaticVarCompensator
        	// --------------------------------------
        	CompletableFuture<StaticVarCompensator> futureEntity = queryGateway.query(new FindStaticVarCompensatorQuery( new LoadStaticVarCompensatorFilter( summary.getStaticVarCompensatorId() ) ), ResponseTypes.instanceOf(StaticVarCompensator.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate StaticVarCompensator with id " + summary.getStaticVarCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all StaticVarCompensators
     *
     * @return 	List<StaticVarCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<StaticVarCompensator> getAllStaticVarCompensator() 
    throws ProcessingException {
        List<StaticVarCompensator> list = null;

        try {
        	CompletableFuture<List<StaticVarCompensator>> futureList = queryGateway.query(new FindAllStaticVarCompensatorQuery(), ResponseTypes.multipleInstancesOf(StaticVarCompensator.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all StaticVarCompensator";
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
	 * @return		StaticVarCompensator
	 */
	protected StaticVarCompensator load( UUID id ) throws ProcessingException {
		staticVarCompensator = StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().getStaticVarCompensator( new StaticVarCompensatorFetchOneSummary(id) );	
		return staticVarCompensator;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private StaticVarCompensator staticVarCompensator 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(StaticVarCompensatorBusinessDelegate.class.getName());
    
}
