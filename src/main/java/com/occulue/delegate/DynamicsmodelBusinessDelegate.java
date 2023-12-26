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
 * Dynamicsmodel business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of Dynamicsmodel related services in the case of a Dynamicsmodel business related service failing.</li>
 * <li>Exposes a simpler, uniform Dynamicsmodel interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill Dynamicsmodel business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DynamicsmodelBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DynamicsmodelBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* Dynamicsmodel Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DynamicsmodelBusinessDelegate
	*/
	public static DynamicsmodelBusinessDelegate getDynamicsmodelInstance() {
		return( new DynamicsmodelBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDynamicsmodel( CreateDynamicsmodelCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDynamicsmodelId() == null )
				command.setDynamicsmodelId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsmodelValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDynamicsmodelCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDynamicsmodelCommand of Dynamicsmodel is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create Dynamicsmodel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDynamicsmodelCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDynamicsmodel( UpdateDynamicsmodelCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DynamicsmodelValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDynamicsmodelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save Dynamicsmodel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDynamicsmodelCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDynamicsmodelCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsmodelValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDynamicsmodelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete Dynamicsmodel using Id = "  + command.getDynamicsmodelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the Dynamicsmodel via DynamicsmodelFetchOneSummary
     * @param 	summary DynamicsmodelFetchOneSummary 
     * @return 	DynamicsmodelFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public Dynamicsmodel getDynamicsmodel( DynamicsmodelFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DynamicsmodelFetchOneSummary arg cannot be null" );
    	
    	Dynamicsmodel entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DynamicsmodelValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a Dynamicsmodel
        	// --------------------------------------
        	CompletableFuture<Dynamicsmodel> futureEntity = queryGateway.query(new FindDynamicsmodelQuery( new LoadDynamicsmodelFilter( summary.getDynamicsmodelId() ) ), ResponseTypes.instanceOf(Dynamicsmodel.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate Dynamicsmodel with id " + summary.getDynamicsmodelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all Dynamicsmodels
     *
     * @return 	List<Dynamicsmodel> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<Dynamicsmodel> getAllDynamicsmodel() 
    throws ProcessingException {
        List<Dynamicsmodel> list = null;

        try {
        	CompletableFuture<List<Dynamicsmodel>> futureList = queryGateway.query(new FindAllDynamicsmodelQuery(), ResponseTypes.multipleInstancesOf(Dynamicsmodel.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all Dynamicsmodel";
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
	 * @return		Dynamicsmodel
	 */
	protected Dynamicsmodel load( UUID id ) throws ProcessingException {
		dynamicsmodel = DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().getDynamicsmodel( new DynamicsmodelFetchOneSummary(id) );	
		return dynamicsmodel;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private Dynamicsmodel dynamicsmodel 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DynamicsmodelBusinessDelegate.class.getName());
    
}
