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
 * DynamicsVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DynamicsVersion related services in the case of a DynamicsVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform DynamicsVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DynamicsVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DynamicsVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DynamicsVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DynamicsVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DynamicsVersionBusinessDelegate
	*/
	public static DynamicsVersionBusinessDelegate getDynamicsVersionInstance() {
		return( new DynamicsVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDynamicsVersion( CreateDynamicsVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDynamicsVersionId() == null )
				command.setDynamicsVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDynamicsVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDynamicsVersionCommand of DynamicsVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DynamicsVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDynamicsVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDynamicsVersion( UpdateDynamicsVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DynamicsVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDynamicsVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DynamicsVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDynamicsVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDynamicsVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDynamicsVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DynamicsVersion using Id = "  + command.getDynamicsVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DynamicsVersion via DynamicsVersionFetchOneSummary
     * @param 	summary DynamicsVersionFetchOneSummary 
     * @return 	DynamicsVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DynamicsVersion getDynamicsVersion( DynamicsVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DynamicsVersionFetchOneSummary arg cannot be null" );
    	
    	DynamicsVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DynamicsVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DynamicsVersion
        	// --------------------------------------
        	CompletableFuture<DynamicsVersion> futureEntity = queryGateway.query(new FindDynamicsVersionQuery( new LoadDynamicsVersionFilter( summary.getDynamicsVersionId() ) ), ResponseTypes.instanceOf(DynamicsVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DynamicsVersion with id " + summary.getDynamicsVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DynamicsVersions
     *
     * @return 	List<DynamicsVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DynamicsVersion> getAllDynamicsVersion() 
    throws ProcessingException {
        List<DynamicsVersion> list = null;

        try {
        	CompletableFuture<List<DynamicsVersion>> futureList = queryGateway.query(new FindAllDynamicsVersionQuery(), ResponseTypes.multipleInstancesOf(DynamicsVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DynamicsVersion";
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
	 * @return		DynamicsVersion
	 */
	protected DynamicsVersion load( UUID id ) throws ProcessingException {
		dynamicsVersion = DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().getDynamicsVersion( new DynamicsVersionFetchOneSummary(id) );	
		return dynamicsVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DynamicsVersion dynamicsVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DynamicsVersionBusinessDelegate.class.getName());
    
}
