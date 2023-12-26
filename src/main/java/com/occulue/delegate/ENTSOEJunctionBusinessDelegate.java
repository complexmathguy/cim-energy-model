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
 * ENTSOEJunction business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ENTSOEJunction related services in the case of a ENTSOEJunction business related service failing.</li>
 * <li>Exposes a simpler, uniform ENTSOEJunction interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ENTSOEJunction business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ENTSOEJunctionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ENTSOEJunctionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ENTSOEJunction Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ENTSOEJunctionBusinessDelegate
	*/
	public static ENTSOEJunctionBusinessDelegate getENTSOEJunctionInstance() {
		return( new ENTSOEJunctionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createENTSOEJunction( CreateENTSOEJunctionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getENTSOEJunctionId() == null )
				command.setENTSOEJunctionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEJunctionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateENTSOEJunctionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateENTSOEJunctionCommand of ENTSOEJunction is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ENTSOEJunction - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateENTSOEJunctionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateENTSOEJunction( UpdateENTSOEJunctionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ENTSOEJunctionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateENTSOEJunctionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ENTSOEJunction - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteENTSOEJunctionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteENTSOEJunctionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEJunctionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteENTSOEJunctionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ENTSOEJunction using Id = "  + command.getENTSOEJunctionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ENTSOEJunction via ENTSOEJunctionFetchOneSummary
     * @param 	summary ENTSOEJunctionFetchOneSummary 
     * @return 	ENTSOEJunctionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ENTSOEJunction getENTSOEJunction( ENTSOEJunctionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ENTSOEJunctionFetchOneSummary arg cannot be null" );
    	
    	ENTSOEJunction entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ENTSOEJunctionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ENTSOEJunction
        	// --------------------------------------
        	CompletableFuture<ENTSOEJunction> futureEntity = queryGateway.query(new FindENTSOEJunctionQuery( new LoadENTSOEJunctionFilter( summary.getENTSOEJunctionId() ) ), ResponseTypes.instanceOf(ENTSOEJunction.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ENTSOEJunction with id " + summary.getENTSOEJunctionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ENTSOEJunctions
     *
     * @return 	List<ENTSOEJunction> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ENTSOEJunction> getAllENTSOEJunction() 
    throws ProcessingException {
        List<ENTSOEJunction> list = null;

        try {
        	CompletableFuture<List<ENTSOEJunction>> futureList = queryGateway.query(new FindAllENTSOEJunctionQuery(), ResponseTypes.multipleInstancesOf(ENTSOEJunction.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ENTSOEJunction";
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
	 * @return		ENTSOEJunction
	 */
	protected ENTSOEJunction load( UUID id ) throws ProcessingException {
		eNTSOEJunction = ENTSOEJunctionBusinessDelegate.getENTSOEJunctionInstance().getENTSOEJunction( new ENTSOEJunctionFetchOneSummary(id) );	
		return eNTSOEJunction;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ENTSOEJunction eNTSOEJunction 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ENTSOEJunctionBusinessDelegate.class.getName());
    
}
