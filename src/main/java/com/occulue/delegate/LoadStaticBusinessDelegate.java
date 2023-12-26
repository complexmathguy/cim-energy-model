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
 * LoadStatic business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of LoadStatic related services in the case of a LoadStatic business related service failing.</li>
 * <li>Exposes a simpler, uniform LoadStatic interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill LoadStatic business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class LoadStaticBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public LoadStaticBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* LoadStatic Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	LoadStaticBusinessDelegate
	*/
	public static LoadStaticBusinessDelegate getLoadStaticInstance() {
		return( new LoadStaticBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createLoadStatic( CreateLoadStaticCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getLoadStaticId() == null )
				command.setLoadStaticId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadStaticValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateLoadStaticCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateLoadStaticCommand of LoadStatic is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create LoadStatic - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateLoadStaticCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateLoadStatic( UpdateLoadStaticCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	LoadStaticValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateLoadStaticCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save LoadStatic - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteLoadStaticCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteLoadStaticCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	LoadStaticValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteLoadStaticCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete LoadStatic using Id = "  + command.getLoadStaticId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the LoadStatic via LoadStaticFetchOneSummary
     * @param 	summary LoadStaticFetchOneSummary 
     * @return 	LoadStaticFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public LoadStatic getLoadStatic( LoadStaticFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "LoadStaticFetchOneSummary arg cannot be null" );
    	
    	LoadStatic entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	LoadStaticValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a LoadStatic
        	// --------------------------------------
        	CompletableFuture<LoadStatic> futureEntity = queryGateway.query(new FindLoadStaticQuery( new LoadLoadStaticFilter( summary.getLoadStaticId() ) ), ResponseTypes.instanceOf(LoadStatic.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate LoadStatic with id " + summary.getLoadStaticId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all LoadStatics
     *
     * @return 	List<LoadStatic> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<LoadStatic> getAllLoadStatic() 
    throws ProcessingException {
        List<LoadStatic> list = null;

        try {
        	CompletableFuture<List<LoadStatic>> futureList = queryGateway.query(new FindAllLoadStaticQuery(), ResponseTypes.multipleInstancesOf(LoadStatic.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all LoadStatic";
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
	 * @return		LoadStatic
	 */
	protected LoadStatic load( UUID id ) throws ProcessingException {
		loadStatic = LoadStaticBusinessDelegate.getLoadStaticInstance().getLoadStatic( new LoadStaticFetchOneSummary(id) );	
		return loadStatic;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private LoadStatic loadStatic 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(LoadStaticBusinessDelegate.class.getName());
    
}
