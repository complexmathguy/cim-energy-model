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
 * ExcIEEEAC7B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEAC7B related services in the case of a ExcIEEEAC7B business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEAC7B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC7B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEAC7BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEAC7BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEAC7B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEAC7BBusinessDelegate
	*/
	public static ExcIEEEAC7BBusinessDelegate getExcIEEEAC7BInstance() {
		return( new ExcIEEEAC7BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEAC7B( CreateExcIEEEAC7BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEAC7BId() == null )
				command.setExcIEEEAC7BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC7BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEAC7BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEAC7BCommand of ExcIEEEAC7B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEAC7B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEAC7BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEAC7B( UpdateExcIEEEAC7BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEAC7BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEAC7BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEAC7B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEAC7BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEAC7BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC7BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEAC7BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEAC7B using Id = "  + command.getExcIEEEAC7BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEAC7B via ExcIEEEAC7BFetchOneSummary
     * @param 	summary ExcIEEEAC7BFetchOneSummary 
     * @return 	ExcIEEEAC7BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEAC7B getExcIEEEAC7B( ExcIEEEAC7BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEAC7BFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEAC7B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEAC7BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEAC7B
        	// --------------------------------------
        	CompletableFuture<ExcIEEEAC7B> futureEntity = queryGateway.query(new FindExcIEEEAC7BQuery( new LoadExcIEEEAC7BFilter( summary.getExcIEEEAC7BId() ) ), ResponseTypes.instanceOf(ExcIEEEAC7B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEAC7B with id " + summary.getExcIEEEAC7BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEAC7Bs
     *
     * @return 	List<ExcIEEEAC7B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEAC7B> getAllExcIEEEAC7B() 
    throws ProcessingException {
        List<ExcIEEEAC7B> list = null;

        try {
        	CompletableFuture<List<ExcIEEEAC7B>> futureList = queryGateway.query(new FindAllExcIEEEAC7BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC7B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEAC7B";
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
	 * @return		ExcIEEEAC7B
	 */
	protected ExcIEEEAC7B load( UUID id ) throws ProcessingException {
		excIEEEAC7B = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().getExcIEEEAC7B( new ExcIEEEAC7BFetchOneSummary(id) );	
		return excIEEEAC7B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEAC7B excIEEEAC7B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEAC7BBusinessDelegate.class.getName());
    
}
