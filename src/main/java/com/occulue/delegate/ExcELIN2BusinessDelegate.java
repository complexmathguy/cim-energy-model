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
 * ExcELIN2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcELIN2 related services in the case of a ExcELIN2 business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcELIN2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcELIN2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcELIN2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcELIN2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcELIN2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcELIN2BusinessDelegate
	*/
	public static ExcELIN2BusinessDelegate getExcELIN2Instance() {
		return( new ExcELIN2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcELIN2( CreateExcELIN2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcELIN2Id() == null )
				command.setExcELIN2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcELIN2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcELIN2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcELIN2Command of ExcELIN2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcELIN2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcELIN2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcELIN2( UpdateExcELIN2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcELIN2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcELIN2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcELIN2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcELIN2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcELIN2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcELIN2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcELIN2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcELIN2 using Id = "  + command.getExcELIN2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcELIN2 via ExcELIN2FetchOneSummary
     * @param 	summary ExcELIN2FetchOneSummary 
     * @return 	ExcELIN2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcELIN2 getExcELIN2( ExcELIN2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcELIN2FetchOneSummary arg cannot be null" );
    	
    	ExcELIN2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcELIN2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcELIN2
        	// --------------------------------------
        	CompletableFuture<ExcELIN2> futureEntity = queryGateway.query(new FindExcELIN2Query( new LoadExcELIN2Filter( summary.getExcELIN2Id() ) ), ResponseTypes.instanceOf(ExcELIN2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcELIN2 with id " + summary.getExcELIN2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcELIN2s
     *
     * @return 	List<ExcELIN2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcELIN2> getAllExcELIN2() 
    throws ProcessingException {
        List<ExcELIN2> list = null;

        try {
        	CompletableFuture<List<ExcELIN2>> futureList = queryGateway.query(new FindAllExcELIN2Query(), ResponseTypes.multipleInstancesOf(ExcELIN2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcELIN2";
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
	 * @return		ExcELIN2
	 */
	protected ExcELIN2 load( UUID id ) throws ProcessingException {
		excELIN2 = ExcELIN2BusinessDelegate.getExcELIN2Instance().getExcELIN2( new ExcELIN2FetchOneSummary(id) );	
		return excELIN2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcELIN2 excELIN2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcELIN2BusinessDelegate.class.getName());
    
}
