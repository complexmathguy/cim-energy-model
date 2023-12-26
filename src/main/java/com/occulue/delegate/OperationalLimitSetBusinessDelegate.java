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
 * OperationalLimitSet business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of OperationalLimitSet related services in the case of a OperationalLimitSet business related service failing.</li>
 * <li>Exposes a simpler, uniform OperationalLimitSet interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill OperationalLimitSet business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class OperationalLimitSetBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public OperationalLimitSetBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* OperationalLimitSet Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	OperationalLimitSetBusinessDelegate
	*/
	public static OperationalLimitSetBusinessDelegate getOperationalLimitSetInstance() {
		return( new OperationalLimitSetBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createOperationalLimitSet( CreateOperationalLimitSetCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getOperationalLimitSetId() == null )
				command.setOperationalLimitSetId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OperationalLimitSetValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateOperationalLimitSetCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateOperationalLimitSetCommand of OperationalLimitSet is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create OperationalLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateOperationalLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateOperationalLimitSet( UpdateOperationalLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	OperationalLimitSetValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateOperationalLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save OperationalLimitSet - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteOperationalLimitSetCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteOperationalLimitSetCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OperationalLimitSetValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteOperationalLimitSetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete OperationalLimitSet using Id = "  + command.getOperationalLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the OperationalLimitSet via OperationalLimitSetFetchOneSummary
     * @param 	summary OperationalLimitSetFetchOneSummary 
     * @return 	OperationalLimitSetFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public OperationalLimitSet getOperationalLimitSet( OperationalLimitSetFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "OperationalLimitSetFetchOneSummary arg cannot be null" );
    	
    	OperationalLimitSet entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	OperationalLimitSetValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a OperationalLimitSet
        	// --------------------------------------
        	CompletableFuture<OperationalLimitSet> futureEntity = queryGateway.query(new FindOperationalLimitSetQuery( new LoadOperationalLimitSetFilter( summary.getOperationalLimitSetId() ) ), ResponseTypes.instanceOf(OperationalLimitSet.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate OperationalLimitSet with id " + summary.getOperationalLimitSetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all OperationalLimitSets
     *
     * @return 	List<OperationalLimitSet> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<OperationalLimitSet> getAllOperationalLimitSet() 
    throws ProcessingException {
        List<OperationalLimitSet> list = null;

        try {
        	CompletableFuture<List<OperationalLimitSet>> futureList = queryGateway.query(new FindAllOperationalLimitSetQuery(), ResponseTypes.multipleInstancesOf(OperationalLimitSet.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all OperationalLimitSet";
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
	 * @return		OperationalLimitSet
	 */
	protected OperationalLimitSet load( UUID id ) throws ProcessingException {
		operationalLimitSet = OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance().getOperationalLimitSet( new OperationalLimitSetFetchOneSummary(id) );	
		return operationalLimitSet;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private OperationalLimitSet operationalLimitSet 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(OperationalLimitSetBusinessDelegate.class.getName());
    
}
