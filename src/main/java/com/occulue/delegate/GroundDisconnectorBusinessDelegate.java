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
 * GroundDisconnector business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of GroundDisconnector related services in the case of a GroundDisconnector business related service failing.</li>
 * <li>Exposes a simpler, uniform GroundDisconnector interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill GroundDisconnector business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class GroundDisconnectorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public GroundDisconnectorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* GroundDisconnector Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	GroundDisconnectorBusinessDelegate
	*/
	public static GroundDisconnectorBusinessDelegate getGroundDisconnectorInstance() {
		return( new GroundDisconnectorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createGroundDisconnector( CreateGroundDisconnectorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getGroundDisconnectorId() == null )
				command.setGroundDisconnectorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GroundDisconnectorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateGroundDisconnectorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateGroundDisconnectorCommand of GroundDisconnector is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create GroundDisconnector - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateGroundDisconnectorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateGroundDisconnector( UpdateGroundDisconnectorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	GroundDisconnectorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateGroundDisconnectorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save GroundDisconnector - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteGroundDisconnectorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteGroundDisconnectorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	GroundDisconnectorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteGroundDisconnectorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete GroundDisconnector using Id = "  + command.getGroundDisconnectorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the GroundDisconnector via GroundDisconnectorFetchOneSummary
     * @param 	summary GroundDisconnectorFetchOneSummary 
     * @return 	GroundDisconnectorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public GroundDisconnector getGroundDisconnector( GroundDisconnectorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "GroundDisconnectorFetchOneSummary arg cannot be null" );
    	
    	GroundDisconnector entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	GroundDisconnectorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a GroundDisconnector
        	// --------------------------------------
        	CompletableFuture<GroundDisconnector> futureEntity = queryGateway.query(new FindGroundDisconnectorQuery( new LoadGroundDisconnectorFilter( summary.getGroundDisconnectorId() ) ), ResponseTypes.instanceOf(GroundDisconnector.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate GroundDisconnector with id " + summary.getGroundDisconnectorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all GroundDisconnectors
     *
     * @return 	List<GroundDisconnector> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<GroundDisconnector> getAllGroundDisconnector() 
    throws ProcessingException {
        List<GroundDisconnector> list = null;

        try {
        	CompletableFuture<List<GroundDisconnector>> futureList = queryGateway.query(new FindAllGroundDisconnectorQuery(), ResponseTypes.multipleInstancesOf(GroundDisconnector.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all GroundDisconnector";
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
	 * @return		GroundDisconnector
	 */
	protected GroundDisconnector load( UUID id ) throws ProcessingException {
		groundDisconnector = GroundDisconnectorBusinessDelegate.getGroundDisconnectorInstance().getGroundDisconnector( new GroundDisconnectorFetchOneSummary(id) );	
		return groundDisconnector;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private GroundDisconnector groundDisconnector 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(GroundDisconnectorBusinessDelegate.class.getName());
    
}
