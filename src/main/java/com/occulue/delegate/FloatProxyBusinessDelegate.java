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
 * FloatProxy business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of FloatProxy related services in the case of a FloatProxy business related service failing.</li>
 * <li>Exposes a simpler, uniform FloatProxy interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill FloatProxy business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class FloatProxyBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public FloatProxyBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* FloatProxy Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	FloatProxyBusinessDelegate
	*/
	public static FloatProxyBusinessDelegate getFloatProxyInstance() {
		return( new FloatProxyBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createFloatProxy( CreateFloatProxyCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getFloatProxyId() == null )
				command.setFloatProxyId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	FloatProxyValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateFloatProxyCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateFloatProxyCommand of FloatProxy is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create FloatProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateFloatProxyCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateFloatProxy( UpdateFloatProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	FloatProxyValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateFloatProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save FloatProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteFloatProxyCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteFloatProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	FloatProxyValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteFloatProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete FloatProxy using Id = "  + command.getFloatProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the FloatProxy via FloatProxyFetchOneSummary
     * @param 	summary FloatProxyFetchOneSummary 
     * @return 	FloatProxyFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public FloatProxy getFloatProxy( FloatProxyFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "FloatProxyFetchOneSummary arg cannot be null" );
    	
    	FloatProxy entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	FloatProxyValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a FloatProxy
        	// --------------------------------------
        	CompletableFuture<FloatProxy> futureEntity = queryGateway.query(new FindFloatProxyQuery( new LoadFloatProxyFilter( summary.getFloatProxyId() ) ), ResponseTypes.instanceOf(FloatProxy.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate FloatProxy with id " + summary.getFloatProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all FloatProxys
     *
     * @return 	List<FloatProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<FloatProxy> getAllFloatProxy() 
    throws ProcessingException {
        List<FloatProxy> list = null;

        try {
        	CompletableFuture<List<FloatProxy>> futureList = queryGateway.query(new FindAllFloatProxyQuery(), ResponseTypes.multipleInstancesOf(FloatProxy.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all FloatProxy";
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
	 * @return		FloatProxy
	 */
	protected FloatProxy load( UUID id ) throws ProcessingException {
		floatProxy = FloatProxyBusinessDelegate.getFloatProxyInstance().getFloatProxy( new FloatProxyFetchOneSummary(id) );	
		return floatProxy;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private FloatProxy floatProxy 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(FloatProxyBusinessDelegate.class.getName());
    
}
