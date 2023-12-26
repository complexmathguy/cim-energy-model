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
 * ExcIEEEST5B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEST5B related services in the case of a ExcIEEEST5B business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEST5B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEST5B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEST5BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEST5BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEST5B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEST5BBusinessDelegate
	*/
	public static ExcIEEEST5BBusinessDelegate getExcIEEEST5BInstance() {
		return( new ExcIEEEST5BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEST5B( CreateExcIEEEST5BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEST5BId() == null )
				command.setExcIEEEST5BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEST5BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEST5BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEST5BCommand of ExcIEEEST5B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEST5B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEST5BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEST5B( UpdateExcIEEEST5BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEST5BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEST5BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEST5B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEST5BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEST5BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEST5BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEST5BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEST5B using Id = "  + command.getExcIEEEST5BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEST5B via ExcIEEEST5BFetchOneSummary
     * @param 	summary ExcIEEEST5BFetchOneSummary 
     * @return 	ExcIEEEST5BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEST5B getExcIEEEST5B( ExcIEEEST5BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEST5BFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEST5B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEST5BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEST5B
        	// --------------------------------------
        	CompletableFuture<ExcIEEEST5B> futureEntity = queryGateway.query(new FindExcIEEEST5BQuery( new LoadExcIEEEST5BFilter( summary.getExcIEEEST5BId() ) ), ResponseTypes.instanceOf(ExcIEEEST5B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEST5B with id " + summary.getExcIEEEST5BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEST5Bs
     *
     * @return 	List<ExcIEEEST5B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEST5B> getAllExcIEEEST5B() 
    throws ProcessingException {
        List<ExcIEEEST5B> list = null;

        try {
        	CompletableFuture<List<ExcIEEEST5B>> futureList = queryGateway.query(new FindAllExcIEEEST5BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEST5B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEST5B";
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
	 * @return		ExcIEEEST5B
	 */
	protected ExcIEEEST5B load( UUID id ) throws ProcessingException {
		excIEEEST5B = ExcIEEEST5BBusinessDelegate.getExcIEEEST5BInstance().getExcIEEEST5B( new ExcIEEEST5BFetchOneSummary(id) );	
		return excIEEEST5B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEST5B excIEEEST5B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEST5BBusinessDelegate.class.getName());
    
}
