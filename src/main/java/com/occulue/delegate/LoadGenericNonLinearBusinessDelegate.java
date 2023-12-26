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
 * LoadGenericNonLinear business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of LoadGenericNonLinear related services in the case of a LoadGenericNonLinear business related service failing.</li>
 * <li>Exposes a simpler, uniform LoadGenericNonLinear interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill LoadGenericNonLinear business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class LoadGenericNonLinearBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public LoadGenericNonLinearBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* LoadGenericNonLinear Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	LoadGenericNonLinearBusinessDelegate
	*/
	public static LoadGenericNonLinearBusinessDelegate getLoadGenericNonLinearInstance() {
		return( new LoadGenericNonLinearBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createLoadGenericNonLinear( CreateLoadGenericNonLinearCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getLoadGenericNonLinearId() == null )
				command.setLoadGenericNonLinearId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadGenericNonLinearValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateLoadGenericNonLinearCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateLoadGenericNonLinearCommand of LoadGenericNonLinear is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create LoadGenericNonLinear - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateLoadGenericNonLinearCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateLoadGenericNonLinear( UpdateLoadGenericNonLinearCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	LoadGenericNonLinearValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateLoadGenericNonLinearCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save LoadGenericNonLinear - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteLoadGenericNonLinearCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteLoadGenericNonLinearCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadGenericNonLinearValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteLoadGenericNonLinearCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete LoadGenericNonLinear using Id = "  + command.getLoadGenericNonLinearId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the LoadGenericNonLinear via LoadGenericNonLinearFetchOneSummary
     * @param 	summary LoadGenericNonLinearFetchOneSummary 
     * @return 	LoadGenericNonLinearFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public LoadGenericNonLinear getLoadGenericNonLinear( LoadGenericNonLinearFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "LoadGenericNonLinearFetchOneSummary arg cannot be null" );
    	
    	LoadGenericNonLinear entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	LoadGenericNonLinearValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a LoadGenericNonLinear
        	// --------------------------------------
        	CompletableFuture<LoadGenericNonLinear> futureEntity = queryGateway.query(new FindLoadGenericNonLinearQuery( new LoadLoadGenericNonLinearFilter( summary.getLoadGenericNonLinearId() ) ), ResponseTypes.instanceOf(LoadGenericNonLinear.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate LoadGenericNonLinear with id " + summary.getLoadGenericNonLinearId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all LoadGenericNonLinears
     *
     * @return 	List<LoadGenericNonLinear> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<LoadGenericNonLinear> getAllLoadGenericNonLinear() 
    throws ProcessingException {
        List<LoadGenericNonLinear> list = null;

        try {
        	CompletableFuture<List<LoadGenericNonLinear>> futureList = queryGateway.query(new FindAllLoadGenericNonLinearQuery(), ResponseTypes.multipleInstancesOf(LoadGenericNonLinear.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all LoadGenericNonLinear";
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
	 * @return		LoadGenericNonLinear
	 */
	protected LoadGenericNonLinear load( UUID id ) throws ProcessingException {
		loadGenericNonLinear = LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().getLoadGenericNonLinear( new LoadGenericNonLinearFetchOneSummary(id) );	
		return loadGenericNonLinear;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private LoadGenericNonLinear loadGenericNonLinear 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(LoadGenericNonLinearBusinessDelegate.class.getName());
    
}
