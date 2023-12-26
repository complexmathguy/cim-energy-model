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
 * AnalogLimitSet business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AnalogLimitSet related services in the case of a AnalogLimitSet business related service failing.</li>
 * <li>Exposes a simpler, uniform AnalogLimitSet interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AnalogLimitSet business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AnalogLimitSetBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AnalogLimitSetBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AnalogLimitSet Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AnalogLimitSetBusinessDelegate
	*/
	public static AnalogLimitSetBusinessDelegate getAnalogLimitSetInstance() {
		return( new AnalogLimitSetBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAnalogLimitSet( CreateAnalogLimitSetCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAnalogLimitSetId() == null )
				command.setAnalogLimitSetId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogLimitSetValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAnalogLimitSetCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAnalogLimitSetCommand of AnalogLimitSet is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AnalogLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAnalogLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAnalogLimitSet( UpdateAnalogLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AnalogLimitSetValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAnalogLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AnalogLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAnalogLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAnalogLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AnalogLimitSetValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAnalogLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AnalogLimitSet using Id = "  + command.getAnalogLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AnalogLimitSet via AnalogLimitSetFetchOneSummary
     * @param 	summary AnalogLimitSetFetchOneSummary 
     * @return 	AnalogLimitSetFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AnalogLimitSet getAnalogLimitSet( AnalogLimitSetFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AnalogLimitSetFetchOneSummary arg cannot be null" );
    	
    	AnalogLimitSet entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AnalogLimitSetValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AnalogLimitSet
        	// --------------------------------------
        	CompletableFuture<AnalogLimitSet> futureEntity = queryGateway.query(new FindAnalogLimitSetQuery( new LoadAnalogLimitSetFilter( summary.getAnalogLimitSetId() ) ), ResponseTypes.instanceOf(AnalogLimitSet.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AnalogLimitSet with id " + summary.getAnalogLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AnalogLimitSets
     *
     * @return 	List<AnalogLimitSet> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AnalogLimitSet> getAllAnalogLimitSet() 
    throws ProcessingException {
        List<AnalogLimitSet> list = null;

        try {
        	CompletableFuture<List<AnalogLimitSet>> futureList = queryGateway.query(new FindAllAnalogLimitSetQuery(), ResponseTypes.multipleInstancesOf(AnalogLimitSet.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AnalogLimitSet";
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
	 * @return		AnalogLimitSet
	 */
	protected AnalogLimitSet load( UUID id ) throws ProcessingException {
		analogLimitSet = AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().getAnalogLimitSet( new AnalogLimitSetFetchOneSummary(id) );	
		return analogLimitSet;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AnalogLimitSet analogLimitSet 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AnalogLimitSetBusinessDelegate.class.getName());
    
}
