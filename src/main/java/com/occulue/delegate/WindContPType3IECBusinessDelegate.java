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
 * WindContPType3IEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindContPType3IEC related services in the case of a WindContPType3IEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindContPType3IEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindContPType3IEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindContPType3IECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindContPType3IECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindContPType3IEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindContPType3IECBusinessDelegate
	*/
	public static WindContPType3IECBusinessDelegate getWindContPType3IECInstance() {
		return( new WindContPType3IECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindContPType3IEC( CreateWindContPType3IECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindContPType3IECId() == null )
				command.setWindContPType3IECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPType3IECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindContPType3IECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindContPType3IECCommand of WindContPType3IEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindContPType3IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindContPType3IECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindContPType3IEC( UpdateWindContPType3IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindContPType3IECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindContPType3IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindContPType3IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindContPType3IECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindContPType3IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPType3IECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindContPType3IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindContPType3IEC using Id = "  + command.getWindContPType3IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindContPType3IEC via WindContPType3IECFetchOneSummary
     * @param 	summary WindContPType3IECFetchOneSummary 
     * @return 	WindContPType3IECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindContPType3IEC getWindContPType3IEC( WindContPType3IECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindContPType3IECFetchOneSummary arg cannot be null" );
    	
    	WindContPType3IEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindContPType3IECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindContPType3IEC
        	// --------------------------------------
        	CompletableFuture<WindContPType3IEC> futureEntity = queryGateway.query(new FindWindContPType3IECQuery( new LoadWindContPType3IECFilter( summary.getWindContPType3IECId() ) ), ResponseTypes.instanceOf(WindContPType3IEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindContPType3IEC with id " + summary.getWindContPType3IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindContPType3IECs
     *
     * @return 	List<WindContPType3IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindContPType3IEC> getAllWindContPType3IEC() 
    throws ProcessingException {
        List<WindContPType3IEC> list = null;

        try {
        	CompletableFuture<List<WindContPType3IEC>> futureList = queryGateway.query(new FindAllWindContPType3IECQuery(), ResponseTypes.multipleInstancesOf(WindContPType3IEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindContPType3IEC";
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
	 * @return		WindContPType3IEC
	 */
	protected WindContPType3IEC load( UUID id ) throws ProcessingException {
		windContPType3IEC = WindContPType3IECBusinessDelegate.getWindContPType3IECInstance().getWindContPType3IEC( new WindContPType3IECFetchOneSummary(id) );	
		return windContPType3IEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindContPType3IEC windContPType3IEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindContPType3IECBusinessDelegate.class.getName());
    
}
