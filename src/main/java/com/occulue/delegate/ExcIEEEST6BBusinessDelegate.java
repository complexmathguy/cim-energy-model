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
 * ExcIEEEST6B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEST6B related services in the case of a ExcIEEEST6B business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEST6B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEST6B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEST6BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEST6BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEST6B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEST6BBusinessDelegate
	*/
	public static ExcIEEEST6BBusinessDelegate getExcIEEEST6BInstance() {
		return( new ExcIEEEST6BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEST6B( CreateExcIEEEST6BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEST6BId() == null )
				command.setExcIEEEST6BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEST6BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEST6BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEST6BCommand of ExcIEEEST6B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEST6B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEST6BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEST6B( UpdateExcIEEEST6BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEST6BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEST6BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEST6B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEST6BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEST6BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEST6BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEST6BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEST6B using Id = "  + command.getExcIEEEST6BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEST6B via ExcIEEEST6BFetchOneSummary
     * @param 	summary ExcIEEEST6BFetchOneSummary 
     * @return 	ExcIEEEST6BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEST6B getExcIEEEST6B( ExcIEEEST6BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEST6BFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEST6B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEST6BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEST6B
        	// --------------------------------------
        	CompletableFuture<ExcIEEEST6B> futureEntity = queryGateway.query(new FindExcIEEEST6BQuery( new LoadExcIEEEST6BFilter( summary.getExcIEEEST6BId() ) ), ResponseTypes.instanceOf(ExcIEEEST6B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEST6B with id " + summary.getExcIEEEST6BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEST6Bs
     *
     * @return 	List<ExcIEEEST6B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEST6B> getAllExcIEEEST6B() 
    throws ProcessingException {
        List<ExcIEEEST6B> list = null;

        try {
        	CompletableFuture<List<ExcIEEEST6B>> futureList = queryGateway.query(new FindAllExcIEEEST6BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEST6B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEST6B";
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
	 * @return		ExcIEEEST6B
	 */
	protected ExcIEEEST6B load( UUID id ) throws ProcessingException {
		excIEEEST6B = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().getExcIEEEST6B( new ExcIEEEST6BFetchOneSummary(id) );	
		return excIEEEST6B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEST6B excIEEEST6B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEST6BBusinessDelegate.class.getName());
    
}
