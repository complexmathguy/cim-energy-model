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
 * BooleanProxy business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of BooleanProxy related services in the case of a BooleanProxy business related service failing.</li>
 * <li>Exposes a simpler, uniform BooleanProxy interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill BooleanProxy business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class BooleanProxyBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public BooleanProxyBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* BooleanProxy Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	BooleanProxyBusinessDelegate
	*/
	public static BooleanProxyBusinessDelegate getBooleanProxyInstance() {
		return( new BooleanProxyBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createBooleanProxy( CreateBooleanProxyCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getBooleanProxyId() == null )
				command.setBooleanProxyId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BooleanProxyValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateBooleanProxyCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateBooleanProxyCommand of BooleanProxy is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create BooleanProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateBooleanProxyCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateBooleanProxy( UpdateBooleanProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	BooleanProxyValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateBooleanProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save BooleanProxy - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteBooleanProxyCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteBooleanProxyCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	BooleanProxyValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteBooleanProxyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete BooleanProxy using Id = "  + command.getBooleanProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the BooleanProxy via BooleanProxyFetchOneSummary
     * @param 	summary BooleanProxyFetchOneSummary 
     * @return 	BooleanProxyFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public BooleanProxy getBooleanProxy( BooleanProxyFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "BooleanProxyFetchOneSummary arg cannot be null" );
    	
    	BooleanProxy entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	BooleanProxyValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a BooleanProxy
        	// --------------------------------------
        	CompletableFuture<BooleanProxy> futureEntity = queryGateway.query(new FindBooleanProxyQuery( new LoadBooleanProxyFilter( summary.getBooleanProxyId() ) ), ResponseTypes.instanceOf(BooleanProxy.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate BooleanProxy with id " + summary.getBooleanProxyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all BooleanProxys
     *
     * @return 	List<BooleanProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<BooleanProxy> getAllBooleanProxy() 
    throws ProcessingException {
        List<BooleanProxy> list = null;

        try {
        	CompletableFuture<List<BooleanProxy>> futureList = queryGateway.query(new FindAllBooleanProxyQuery(), ResponseTypes.multipleInstancesOf(BooleanProxy.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all BooleanProxy";
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
	 * @return		BooleanProxy
	 */
	protected BooleanProxy load( UUID id ) throws ProcessingException {
		booleanProxy = BooleanProxyBusinessDelegate.getBooleanProxyInstance().getBooleanProxy( new BooleanProxyFetchOneSummary(id) );	
		return booleanProxy;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private BooleanProxy booleanProxy 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(BooleanProxyBusinessDelegate.class.getName());
    
}
