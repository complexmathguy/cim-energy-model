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
 * IdentifiedObject business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of IdentifiedObject related services in the case of a IdentifiedObject business related service failing.</li>
 * <li>Exposes a simpler, uniform IdentifiedObject interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill IdentifiedObject business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class IdentifiedObjectBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public IdentifiedObjectBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* IdentifiedObject Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	IdentifiedObjectBusinessDelegate
	*/
	public static IdentifiedObjectBusinessDelegate getIdentifiedObjectInstance() {
		return( new IdentifiedObjectBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createIdentifiedObject( CreateIdentifiedObjectCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getIdentifiedObjectId() == null )
				command.setIdentifiedObjectId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	IdentifiedObjectValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateIdentifiedObjectCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateIdentifiedObjectCommand of IdentifiedObject is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create IdentifiedObject - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateIdentifiedObjectCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateIdentifiedObject( UpdateIdentifiedObjectCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	IdentifiedObjectValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateIdentifiedObjectCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save IdentifiedObject - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteIdentifiedObjectCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteIdentifiedObjectCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	IdentifiedObjectValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteIdentifiedObjectCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete IdentifiedObject using Id = "  + command.getIdentifiedObjectId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the IdentifiedObject via IdentifiedObjectFetchOneSummary
     * @param 	summary IdentifiedObjectFetchOneSummary 
     * @return 	IdentifiedObjectFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public IdentifiedObject getIdentifiedObject( IdentifiedObjectFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "IdentifiedObjectFetchOneSummary arg cannot be null" );
    	
    	IdentifiedObject entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	IdentifiedObjectValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a IdentifiedObject
        	// --------------------------------------
        	CompletableFuture<IdentifiedObject> futureEntity = queryGateway.query(new FindIdentifiedObjectQuery( new LoadIdentifiedObjectFilter( summary.getIdentifiedObjectId() ) ), ResponseTypes.instanceOf(IdentifiedObject.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate IdentifiedObject with id " + summary.getIdentifiedObjectId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all IdentifiedObjects
     *
     * @return 	List<IdentifiedObject> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<IdentifiedObject> getAllIdentifiedObject() 
    throws ProcessingException {
        List<IdentifiedObject> list = null;

        try {
        	CompletableFuture<List<IdentifiedObject>> futureList = queryGateway.query(new FindAllIdentifiedObjectQuery(), ResponseTypes.multipleInstancesOf(IdentifiedObject.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all IdentifiedObject";
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
	 * @return		IdentifiedObject
	 */
	protected IdentifiedObject load( UUID id ) throws ProcessingException {
		identifiedObject = IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().getIdentifiedObject( new IdentifiedObjectFetchOneSummary(id) );	
		return identifiedObject;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private IdentifiedObject identifiedObject 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(IdentifiedObjectBusinessDelegate.class.getName());
    
}
