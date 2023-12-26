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
 * TransformerEnd business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TransformerEnd related services in the case of a TransformerEnd business related service failing.</li>
 * <li>Exposes a simpler, uniform TransformerEnd interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TransformerEnd business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TransformerEndBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TransformerEndBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TransformerEnd Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TransformerEndBusinessDelegate
	*/
	public static TransformerEndBusinessDelegate getTransformerEndInstance() {
		return( new TransformerEndBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTransformerEnd( CreateTransformerEndCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTransformerEndId() == null )
				command.setTransformerEndId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TransformerEndValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTransformerEndCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTransformerEndCommand of TransformerEnd is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TransformerEnd - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTransformerEndCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTransformerEnd( UpdateTransformerEndCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TransformerEndValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTransformerEndCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TransformerEnd - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTransformerEndCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTransformerEndCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TransformerEndValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTransformerEndCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TransformerEnd using Id = "  + command.getTransformerEndId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TransformerEnd via TransformerEndFetchOneSummary
     * @param 	summary TransformerEndFetchOneSummary 
     * @return 	TransformerEndFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TransformerEnd getTransformerEnd( TransformerEndFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TransformerEndFetchOneSummary arg cannot be null" );
    	
    	TransformerEnd entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TransformerEndValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TransformerEnd
        	// --------------------------------------
        	CompletableFuture<TransformerEnd> futureEntity = queryGateway.query(new FindTransformerEndQuery( new LoadTransformerEndFilter( summary.getTransformerEndId() ) ), ResponseTypes.instanceOf(TransformerEnd.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TransformerEnd with id " + summary.getTransformerEndId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TransformerEnds
     *
     * @return 	List<TransformerEnd> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TransformerEnd> getAllTransformerEnd() 
    throws ProcessingException {
        List<TransformerEnd> list = null;

        try {
        	CompletableFuture<List<TransformerEnd>> futureList = queryGateway.query(new FindAllTransformerEndQuery(), ResponseTypes.multipleInstancesOf(TransformerEnd.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TransformerEnd";
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
	 * @return		TransformerEnd
	 */
	protected TransformerEnd load( UUID id ) throws ProcessingException {
		transformerEnd = TransformerEndBusinessDelegate.getTransformerEndInstance().getTransformerEnd( new TransformerEndFetchOneSummary(id) );	
		return transformerEnd;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TransformerEnd transformerEnd 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TransformerEndBusinessDelegate.class.getName());
    
}
