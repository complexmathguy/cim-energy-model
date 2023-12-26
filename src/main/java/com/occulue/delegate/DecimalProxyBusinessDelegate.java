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
 * DecimalProxy business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DecimalProxy related services in the case of a DecimalProxy business related service failing.</li>
 * <li>Exposes a simpler, uniform DecimalProxy interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DecimalProxy business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DecimalProxyBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DecimalProxyBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DecimalProxy Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DecimalProxyBusinessDelegate
	*/
	public static DecimalProxyBusinessDelegate getDecimalProxyInstance() {
		return( new DecimalProxyBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDecimalProxy( CreateDecimalProxyCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDecimalProxyId() == null )
				command.setDecimalProxyId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DecimalProxyValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDecimalProxyCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDecimalProxyCommand of DecimalProxy is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DecimalProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDecimalProxyCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDecimalProxy( UpdateDecimalProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DecimalProxyValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDecimalProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DecimalProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDecimalProxyCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDecimalProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DecimalProxyValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDecimalProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DecimalProxy using Id = "  + command.getDecimalProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DecimalProxy via DecimalProxyFetchOneSummary
     * @param 	summary DecimalProxyFetchOneSummary 
     * @return 	DecimalProxyFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DecimalProxy getDecimalProxy( DecimalProxyFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DecimalProxyFetchOneSummary arg cannot be null" );
    	
    	DecimalProxy entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DecimalProxyValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DecimalProxy
        	// --------------------------------------
        	CompletableFuture<DecimalProxy> futureEntity = queryGateway.query(new FindDecimalProxyQuery( new LoadDecimalProxyFilter( summary.getDecimalProxyId() ) ), ResponseTypes.instanceOf(DecimalProxy.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DecimalProxy with id " + summary.getDecimalProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DecimalProxys
     *
     * @return 	List<DecimalProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DecimalProxy> getAllDecimalProxy() 
    throws ProcessingException {
        List<DecimalProxy> list = null;

        try {
        	CompletableFuture<List<DecimalProxy>> futureList = queryGateway.query(new FindAllDecimalProxyQuery(), ResponseTypes.multipleInstancesOf(DecimalProxy.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DecimalProxy";
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
	 * @return		DecimalProxy
	 */
	protected DecimalProxy load( UUID id ) throws ProcessingException {
		decimalProxy = DecimalProxyBusinessDelegate.getDecimalProxyInstance().getDecimalProxy( new DecimalProxyFetchOneSummary(id) );	
		return decimalProxy;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DecimalProxy decimalProxy 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DecimalProxyBusinessDelegate.class.getName());
    
}
