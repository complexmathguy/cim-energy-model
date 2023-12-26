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
 * AccumulatorLimitSet business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AccumulatorLimitSet related services in the case of a AccumulatorLimitSet business related service failing.</li>
 * <li>Exposes a simpler, uniform AccumulatorLimitSet interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AccumulatorLimitSet business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AccumulatorLimitSetBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AccumulatorLimitSetBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AccumulatorLimitSet Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AccumulatorLimitSetBusinessDelegate
	*/
	public static AccumulatorLimitSetBusinessDelegate getAccumulatorLimitSetInstance() {
		return( new AccumulatorLimitSetBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAccumulatorLimitSet( CreateAccumulatorLimitSetCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAccumulatorLimitSetId() == null )
				command.setAccumulatorLimitSetId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AccumulatorLimitSetValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAccumulatorLimitSetCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAccumulatorLimitSetCommand of AccumulatorLimitSet is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AccumulatorLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAccumulatorLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAccumulatorLimitSet( UpdateAccumulatorLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AccumulatorLimitSetValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAccumulatorLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AccumulatorLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAccumulatorLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAccumulatorLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AccumulatorLimitSetValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAccumulatorLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AccumulatorLimitSet using Id = "  + command.getAccumulatorLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AccumulatorLimitSet via AccumulatorLimitSetFetchOneSummary
     * @param 	summary AccumulatorLimitSetFetchOneSummary 
     * @return 	AccumulatorLimitSetFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AccumulatorLimitSet getAccumulatorLimitSet( AccumulatorLimitSetFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AccumulatorLimitSetFetchOneSummary arg cannot be null" );
    	
    	AccumulatorLimitSet entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AccumulatorLimitSetValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AccumulatorLimitSet
        	// --------------------------------------
        	CompletableFuture<AccumulatorLimitSet> futureEntity = queryGateway.query(new FindAccumulatorLimitSetQuery( new LoadAccumulatorLimitSetFilter( summary.getAccumulatorLimitSetId() ) ), ResponseTypes.instanceOf(AccumulatorLimitSet.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AccumulatorLimitSet with id " + summary.getAccumulatorLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AccumulatorLimitSets
     *
     * @return 	List<AccumulatorLimitSet> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AccumulatorLimitSet> getAllAccumulatorLimitSet() 
    throws ProcessingException {
        List<AccumulatorLimitSet> list = null;

        try {
        	CompletableFuture<List<AccumulatorLimitSet>> futureList = queryGateway.query(new FindAllAccumulatorLimitSetQuery(), ResponseTypes.multipleInstancesOf(AccumulatorLimitSet.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AccumulatorLimitSet";
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
	 * @return		AccumulatorLimitSet
	 */
	protected AccumulatorLimitSet load( UUID id ) throws ProcessingException {
		accumulatorLimitSet = AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().getAccumulatorLimitSet( new AccumulatorLimitSetFetchOneSummary(id) );	
		return accumulatorLimitSet;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AccumulatorLimitSet accumulatorLimitSet 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AccumulatorLimitSetBusinessDelegate.class.getName());
    
}
