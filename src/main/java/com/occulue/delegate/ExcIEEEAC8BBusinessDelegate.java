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
 * ExcIEEEAC8B business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEAC8B related services in the case of a ExcIEEEAC8B business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEAC8B interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC8B business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEAC8BBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEAC8BBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEAC8B Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEAC8BBusinessDelegate
	*/
	public static ExcIEEEAC8BBusinessDelegate getExcIEEEAC8BInstance() {
		return( new ExcIEEEAC8BBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEAC8B( CreateExcIEEEAC8BCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEAC8BId() == null )
				command.setExcIEEEAC8BId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC8BValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEAC8BCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEAC8BCommand of ExcIEEEAC8B is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEAC8B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEAC8BCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEAC8B( UpdateExcIEEEAC8BCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEAC8BValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEAC8BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEAC8B - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEAC8BCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEAC8BCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC8BValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEAC8BCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEAC8B using Id = "  + command.getExcIEEEAC8BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEAC8B via ExcIEEEAC8BFetchOneSummary
     * @param 	summary ExcIEEEAC8BFetchOneSummary 
     * @return 	ExcIEEEAC8BFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEAC8B getExcIEEEAC8B( ExcIEEEAC8BFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEAC8BFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEAC8B entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEAC8BValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEAC8B
        	// --------------------------------------
        	CompletableFuture<ExcIEEEAC8B> futureEntity = queryGateway.query(new FindExcIEEEAC8BQuery( new LoadExcIEEEAC8BFilter( summary.getExcIEEEAC8BId() ) ), ResponseTypes.instanceOf(ExcIEEEAC8B.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEAC8B with id " + summary.getExcIEEEAC8BId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEAC8Bs
     *
     * @return 	List<ExcIEEEAC8B> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEAC8B> getAllExcIEEEAC8B() 
    throws ProcessingException {
        List<ExcIEEEAC8B> list = null;

        try {
        	CompletableFuture<List<ExcIEEEAC8B>> futureList = queryGateway.query(new FindAllExcIEEEAC8BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC8B.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEAC8B";
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
	 * @return		ExcIEEEAC8B
	 */
	protected ExcIEEEAC8B load( UUID id ) throws ProcessingException {
		excIEEEAC8B = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().getExcIEEEAC8B( new ExcIEEEAC8BFetchOneSummary(id) );	
		return excIEEEAC8B;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEAC8B excIEEEAC8B 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEAC8BBusinessDelegate.class.getName());
    
}
