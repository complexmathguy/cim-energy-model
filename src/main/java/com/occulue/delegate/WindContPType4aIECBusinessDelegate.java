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
 * WindContPType4aIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindContPType4aIEC related services in the case of a WindContPType4aIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindContPType4aIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindContPType4aIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindContPType4aIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindContPType4aIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindContPType4aIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindContPType4aIECBusinessDelegate
	*/
	public static WindContPType4aIECBusinessDelegate getWindContPType4aIECInstance() {
		return( new WindContPType4aIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindContPType4aIEC( CreateWindContPType4aIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindContPType4aIECId() == null )
				command.setWindContPType4aIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPType4aIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindContPType4aIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindContPType4aIECCommand of WindContPType4aIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindContPType4aIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindContPType4aIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindContPType4aIEC( UpdateWindContPType4aIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindContPType4aIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindContPType4aIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindContPType4aIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindContPType4aIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindContPType4aIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPType4aIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindContPType4aIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindContPType4aIEC using Id = "  + command.getWindContPType4aIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindContPType4aIEC via WindContPType4aIECFetchOneSummary
     * @param 	summary WindContPType4aIECFetchOneSummary 
     * @return 	WindContPType4aIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindContPType4aIEC getWindContPType4aIEC( WindContPType4aIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindContPType4aIECFetchOneSummary arg cannot be null" );
    	
    	WindContPType4aIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindContPType4aIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindContPType4aIEC
        	// --------------------------------------
        	CompletableFuture<WindContPType4aIEC> futureEntity = queryGateway.query(new FindWindContPType4aIECQuery( new LoadWindContPType4aIECFilter( summary.getWindContPType4aIECId() ) ), ResponseTypes.instanceOf(WindContPType4aIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindContPType4aIEC with id " + summary.getWindContPType4aIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindContPType4aIECs
     *
     * @return 	List<WindContPType4aIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindContPType4aIEC> getAllWindContPType4aIEC() 
    throws ProcessingException {
        List<WindContPType4aIEC> list = null;

        try {
        	CompletableFuture<List<WindContPType4aIEC>> futureList = queryGateway.query(new FindAllWindContPType4aIECQuery(), ResponseTypes.multipleInstancesOf(WindContPType4aIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindContPType4aIEC";
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
	 * @return		WindContPType4aIEC
	 */
	protected WindContPType4aIEC load( UUID id ) throws ProcessingException {
		windContPType4aIEC = WindContPType4aIECBusinessDelegate.getWindContPType4aIECInstance().getWindContPType4aIEC( new WindContPType4aIECFetchOneSummary(id) );	
		return windContPType4aIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindContPType4aIEC windContPType4aIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindContPType4aIECBusinessDelegate.class.getName());
    
}
