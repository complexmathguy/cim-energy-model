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
 * WindContCurrLimIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindContCurrLimIEC related services in the case of a WindContCurrLimIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindContCurrLimIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindContCurrLimIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindContCurrLimIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindContCurrLimIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindContCurrLimIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindContCurrLimIECBusinessDelegate
	*/
	public static WindContCurrLimIECBusinessDelegate getWindContCurrLimIECInstance() {
		return( new WindContCurrLimIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindContCurrLimIEC( CreateWindContCurrLimIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindContCurrLimIECId() == null )
				command.setWindContCurrLimIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContCurrLimIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindContCurrLimIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindContCurrLimIECCommand of WindContCurrLimIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindContCurrLimIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindContCurrLimIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindContCurrLimIEC( UpdateWindContCurrLimIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindContCurrLimIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindContCurrLimIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindContCurrLimIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindContCurrLimIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindContCurrLimIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContCurrLimIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindContCurrLimIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindContCurrLimIEC using Id = "  + command.getWindContCurrLimIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindContCurrLimIEC via WindContCurrLimIECFetchOneSummary
     * @param 	summary WindContCurrLimIECFetchOneSummary 
     * @return 	WindContCurrLimIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindContCurrLimIEC getWindContCurrLimIEC( WindContCurrLimIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindContCurrLimIECFetchOneSummary arg cannot be null" );
    	
    	WindContCurrLimIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindContCurrLimIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindContCurrLimIEC
        	// --------------------------------------
        	CompletableFuture<WindContCurrLimIEC> futureEntity = queryGateway.query(new FindWindContCurrLimIECQuery( new LoadWindContCurrLimIECFilter( summary.getWindContCurrLimIECId() ) ), ResponseTypes.instanceOf(WindContCurrLimIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindContCurrLimIEC with id " + summary.getWindContCurrLimIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindContCurrLimIECs
     *
     * @return 	List<WindContCurrLimIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindContCurrLimIEC> getAllWindContCurrLimIEC() 
    throws ProcessingException {
        List<WindContCurrLimIEC> list = null;

        try {
        	CompletableFuture<List<WindContCurrLimIEC>> futureList = queryGateway.query(new FindAllWindContCurrLimIECQuery(), ResponseTypes.multipleInstancesOf(WindContCurrLimIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindContCurrLimIEC";
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
	 * @return		WindContCurrLimIEC
	 */
	protected WindContCurrLimIEC load( UUID id ) throws ProcessingException {
		windContCurrLimIEC = WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().getWindContCurrLimIEC( new WindContCurrLimIECFetchOneSummary(id) );	
		return windContCurrLimIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindContCurrLimIEC windContCurrLimIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindContCurrLimIECBusinessDelegate.class.getName());
    
}
