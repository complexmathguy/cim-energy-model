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
 * ExcIEEEAC4A business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ExcIEEEAC4A related services in the case of a ExcIEEEAC4A business related service failing.</li>
 * <li>Exposes a simpler, uniform ExcIEEEAC4A interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC4A business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ExcIEEEAC4ABusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ExcIEEEAC4ABusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ExcIEEEAC4A Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ExcIEEEAC4ABusinessDelegate
	*/
	public static ExcIEEEAC4ABusinessDelegate getExcIEEEAC4AInstance() {
		return( new ExcIEEEAC4ABusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createExcIEEEAC4A( CreateExcIEEEAC4ACommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getExcIEEEAC4AId() == null )
				command.setExcIEEEAC4AId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC4AValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateExcIEEEAC4ACommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateExcIEEEAC4ACommand of ExcIEEEAC4A is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ExcIEEEAC4A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateExcIEEEAC4ACommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateExcIEEEAC4A( UpdateExcIEEEAC4ACommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ExcIEEEAC4AValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateExcIEEEAC4ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ExcIEEEAC4A - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteExcIEEEAC4ACommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteExcIEEEAC4ACommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ExcIEEEAC4AValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteExcIEEEAC4ACommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ExcIEEEAC4A using Id = "  + command.getExcIEEEAC4AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ExcIEEEAC4A via ExcIEEEAC4AFetchOneSummary
     * @param 	summary ExcIEEEAC4AFetchOneSummary 
     * @return 	ExcIEEEAC4AFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ExcIEEEAC4A getExcIEEEAC4A( ExcIEEEAC4AFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ExcIEEEAC4AFetchOneSummary arg cannot be null" );
    	
    	ExcIEEEAC4A entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ExcIEEEAC4AValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ExcIEEEAC4A
        	// --------------------------------------
        	CompletableFuture<ExcIEEEAC4A> futureEntity = queryGateway.query(new FindExcIEEEAC4AQuery( new LoadExcIEEEAC4AFilter( summary.getExcIEEEAC4AId() ) ), ResponseTypes.instanceOf(ExcIEEEAC4A.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ExcIEEEAC4A with id " + summary.getExcIEEEAC4AId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ExcIEEEAC4As
     *
     * @return 	List<ExcIEEEAC4A> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ExcIEEEAC4A> getAllExcIEEEAC4A() 
    throws ProcessingException {
        List<ExcIEEEAC4A> list = null;

        try {
        	CompletableFuture<List<ExcIEEEAC4A>> futureList = queryGateway.query(new FindAllExcIEEEAC4AQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC4A.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ExcIEEEAC4A";
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
	 * @return		ExcIEEEAC4A
	 */
	protected ExcIEEEAC4A load( UUID id ) throws ProcessingException {
		excIEEEAC4A = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().getExcIEEEAC4A( new ExcIEEEAC4AFetchOneSummary(id) );	
		return excIEEEAC4A;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ExcIEEEAC4A excIEEEAC4A 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ExcIEEEAC4ABusinessDelegate.class.getName());
    
}
