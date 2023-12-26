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
 * Quality61850 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of Quality61850 related services in the case of a Quality61850 business related service failing.</li>
 * <li>Exposes a simpler, uniform Quality61850 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill Quality61850 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class Quality61850BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public Quality61850BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* Quality61850 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	Quality61850BusinessDelegate
	*/
	public static Quality61850BusinessDelegate getQuality61850Instance() {
		return( new Quality61850BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createQuality61850( CreateQuality61850Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getQuality61850Id() == null )
				command.setQuality61850Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	Quality61850Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateQuality61850Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateQuality61850Command of Quality61850 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create Quality61850 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateQuality61850Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateQuality61850( UpdateQuality61850Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	Quality61850Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateQuality61850Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save Quality61850 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteQuality61850Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteQuality61850Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	Quality61850Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteQuality61850Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete Quality61850 using Id = "  + command.getQuality61850Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the Quality61850 via Quality61850FetchOneSummary
     * @param 	summary Quality61850FetchOneSummary 
     * @return 	Quality61850FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public Quality61850 getQuality61850( Quality61850FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "Quality61850FetchOneSummary arg cannot be null" );
    	
    	Quality61850 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	Quality61850Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a Quality61850
        	// --------------------------------------
        	CompletableFuture<Quality61850> futureEntity = queryGateway.query(new FindQuality61850Query( new LoadQuality61850Filter( summary.getQuality61850Id() ) ), ResponseTypes.instanceOf(Quality61850.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate Quality61850 with id " + summary.getQuality61850Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all Quality61850s
     *
     * @return 	List<Quality61850> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<Quality61850> getAllQuality61850() 
    throws ProcessingException {
        List<Quality61850> list = null;

        try {
        	CompletableFuture<List<Quality61850>> futureList = queryGateway.query(new FindAllQuality61850Query(), ResponseTypes.multipleInstancesOf(Quality61850.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all Quality61850";
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
	 * @return		Quality61850
	 */
	protected Quality61850 load( UUID id ) throws ProcessingException {
		quality61850 = Quality61850BusinessDelegate.getQuality61850Instance().getQuality61850( new Quality61850FetchOneSummary(id) );	
		return quality61850;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private Quality61850 quality61850 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(Quality61850BusinessDelegate.class.getName());
    
}
