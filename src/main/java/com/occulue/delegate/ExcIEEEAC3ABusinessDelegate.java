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
 * ExcIEEEAC3A business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEAC3A related services in the case of a ExcIEEEAC3A business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEAC3A interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC3A business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEAC3ABusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEAC3ABusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEAC3A Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEAC3ABusinessDelegate
	*/
	public static ExcIEEEAC3ABusinessDelegate getExcIEEEAC3AInstance() {
		return( new ExcIEEEAC3ABusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEAC3A( CreateExcIEEEAC3ACommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEAC3AId() == null )
				command.setExcIEEEAC3AId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC3AValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEAC3ACommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEAC3ACommand of ExcIEEEAC3A is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEAC3A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEAC3ACommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEAC3A( UpdateExcIEEEAC3ACommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEAC3AValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEAC3ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEAC3A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEAC3ACommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEAC3ACommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC3AValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEAC3ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEAC3A using Id = "  + command.getExcIEEEAC3AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEAC3A via ExcIEEEAC3AFetchOneSummary
     * @param 	summary ExcIEEEAC3AFetchOneSummary 
     * @return 	ExcIEEEAC3AFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEAC3A getExcIEEEAC3A( ExcIEEEAC3AFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEAC3AFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEAC3A entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEAC3AValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEAC3A
        	// --------------------------------------
        	CompletableFuture<ExcIEEEAC3A> futureEntity = queryGateway.query(new FindExcIEEEAC3AQuery( new LoadExcIEEEAC3AFilter( summary.getExcIEEEAC3AId() ) ), ResponseTypes.instanceOf(ExcIEEEAC3A.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEAC3A with id " + summary.getExcIEEEAC3AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEAC3As
     *
     * @return 	List<ExcIEEEAC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEAC3A> getAllExcIEEEAC3A() 
    throws ProcessingException {
        List<ExcIEEEAC3A> list = null;

        try {
        	CompletableFuture<List<ExcIEEEAC3A>> futureList = queryGateway.query(new FindAllExcIEEEAC3AQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC3A.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEAC3A";
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
	 * @return		ExcIEEEAC3A
	 */
	protected ExcIEEEAC3A load( UUID id ) throws ProcessingException {
		excIEEEAC3A = ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance().getExcIEEEAC3A( new ExcIEEEAC3AFetchOneSummary(id) );	
		return excIEEEAC3A;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEAC3A excIEEEAC3A 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEAC3ABusinessDelegate.class.getName());
    
}
