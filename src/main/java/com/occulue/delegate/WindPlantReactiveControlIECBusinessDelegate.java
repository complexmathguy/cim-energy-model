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
 * WindPlantReactiveControlIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindPlantReactiveControlIEC related services in the case of a WindPlantReactiveControlIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindPlantReactiveControlIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindPlantReactiveControlIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindPlantReactiveControlIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindPlantReactiveControlIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindPlantReactiveControlIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindPlantReactiveControlIECBusinessDelegate
	*/
	public static WindPlantReactiveControlIECBusinessDelegate getWindPlantReactiveControlIECInstance() {
		return( new WindPlantReactiveControlIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindPlantReactiveControlIEC( CreateWindPlantReactiveControlIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindPlantReactiveControlIECId() == null )
				command.setWindPlantReactiveControlIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPlantReactiveControlIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindPlantReactiveControlIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindPlantReactiveControlIECCommand of WindPlantReactiveControlIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindPlantReactiveControlIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindPlantReactiveControlIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindPlantReactiveControlIEC( UpdateWindPlantReactiveControlIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindPlantReactiveControlIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindPlantReactiveControlIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindPlantReactiveControlIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindPlantReactiveControlIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindPlantReactiveControlIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPlantReactiveControlIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindPlantReactiveControlIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindPlantReactiveControlIEC using Id = "  + command.getWindPlantReactiveControlIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindPlantReactiveControlIEC via WindPlantReactiveControlIECFetchOneSummary
     * @param 	summary WindPlantReactiveControlIECFetchOneSummary 
     * @return 	WindPlantReactiveControlIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindPlantReactiveControlIEC getWindPlantReactiveControlIEC( WindPlantReactiveControlIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindPlantReactiveControlIECFetchOneSummary arg cannot be null" );
    	
    	WindPlantReactiveControlIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindPlantReactiveControlIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindPlantReactiveControlIEC
        	// --------------------------------------
        	CompletableFuture<WindPlantReactiveControlIEC> futureEntity = queryGateway.query(new FindWindPlantReactiveControlIECQuery( new LoadWindPlantReactiveControlIECFilter( summary.getWindPlantReactiveControlIECId() ) ), ResponseTypes.instanceOf(WindPlantReactiveControlIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindPlantReactiveControlIEC with id " + summary.getWindPlantReactiveControlIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindPlantReactiveControlIECs
     *
     * @return 	List<WindPlantReactiveControlIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindPlantReactiveControlIEC> getAllWindPlantReactiveControlIEC() 
    throws ProcessingException {
        List<WindPlantReactiveControlIEC> list = null;

        try {
        	CompletableFuture<List<WindPlantReactiveControlIEC>> futureList = queryGateway.query(new FindAllWindPlantReactiveControlIECQuery(), ResponseTypes.multipleInstancesOf(WindPlantReactiveControlIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindPlantReactiveControlIEC";
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
	 * @return		WindPlantReactiveControlIEC
	 */
	protected WindPlantReactiveControlIEC load( UUID id ) throws ProcessingException {
		windPlantReactiveControlIEC = WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance().getWindPlantReactiveControlIEC( new WindPlantReactiveControlIECFetchOneSummary(id) );	
		return windPlantReactiveControlIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindPlantReactiveControlIEC windPlantReactiveControlIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindPlantReactiveControlIECBusinessDelegate.class.getName());
    
}
