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
 * WindContRotorRIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindContRotorRIEC related services in the case of a WindContRotorRIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindContRotorRIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindContRotorRIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindContRotorRIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindContRotorRIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindContRotorRIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindContRotorRIECBusinessDelegate
	*/
	public static WindContRotorRIECBusinessDelegate getWindContRotorRIECInstance() {
		return( new WindContRotorRIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindContRotorRIEC( CreateWindContRotorRIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindContRotorRIECId() == null )
				command.setWindContRotorRIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContRotorRIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindContRotorRIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindContRotorRIECCommand of WindContRotorRIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindContRotorRIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindContRotorRIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindContRotorRIEC( UpdateWindContRotorRIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindContRotorRIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindContRotorRIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindContRotorRIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindContRotorRIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindContRotorRIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContRotorRIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindContRotorRIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindContRotorRIEC using Id = "  + command.getWindContRotorRIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindContRotorRIEC via WindContRotorRIECFetchOneSummary
     * @param 	summary WindContRotorRIECFetchOneSummary 
     * @return 	WindContRotorRIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindContRotorRIEC getWindContRotorRIEC( WindContRotorRIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindContRotorRIECFetchOneSummary arg cannot be null" );
    	
    	WindContRotorRIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindContRotorRIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindContRotorRIEC
        	// --------------------------------------
        	CompletableFuture<WindContRotorRIEC> futureEntity = queryGateway.query(new FindWindContRotorRIECQuery( new LoadWindContRotorRIECFilter( summary.getWindContRotorRIECId() ) ), ResponseTypes.instanceOf(WindContRotorRIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindContRotorRIEC with id " + summary.getWindContRotorRIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindContRotorRIECs
     *
     * @return 	List<WindContRotorRIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindContRotorRIEC> getAllWindContRotorRIEC() 
    throws ProcessingException {
        List<WindContRotorRIEC> list = null;

        try {
        	CompletableFuture<List<WindContRotorRIEC>> futureList = queryGateway.query(new FindAllWindContRotorRIECQuery(), ResponseTypes.multipleInstancesOf(WindContRotorRIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindContRotorRIEC";
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
	 * @return		WindContRotorRIEC
	 */
	protected WindContRotorRIEC load( UUID id ) throws ProcessingException {
		windContRotorRIEC = WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().getWindContRotorRIEC( new WindContRotorRIECFetchOneSummary(id) );	
		return windContRotorRIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindContRotorRIEC windContRotorRIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindContRotorRIECBusinessDelegate.class.getName());
    
}
