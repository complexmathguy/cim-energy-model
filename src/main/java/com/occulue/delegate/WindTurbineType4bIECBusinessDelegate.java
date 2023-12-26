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
 * WindTurbineType4bIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindTurbineType4bIEC related services in the case of a WindTurbineType4bIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindTurbineType4bIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindTurbineType4bIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindTurbineType4bIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindTurbineType4bIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindTurbineType4bIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindTurbineType4bIECBusinessDelegate
	*/
	public static WindTurbineType4bIECBusinessDelegate getWindTurbineType4bIECInstance() {
		return( new WindTurbineType4bIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindTurbineType4bIEC( CreateWindTurbineType4bIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindTurbineType4bIECId() == null )
				command.setWindTurbineType4bIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType4bIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindTurbineType4bIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindTurbineType4bIECCommand of WindTurbineType4bIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindTurbineType4bIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindTurbineType4bIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindTurbineType4bIEC( UpdateWindTurbineType4bIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindTurbineType4bIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindTurbineType4bIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindTurbineType4bIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindTurbineType4bIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindTurbineType4bIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType4bIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindTurbineType4bIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindTurbineType4bIEC using Id = "  + command.getWindTurbineType4bIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindTurbineType4bIEC via WindTurbineType4bIECFetchOneSummary
     * @param 	summary WindTurbineType4bIECFetchOneSummary 
     * @return 	WindTurbineType4bIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindTurbineType4bIEC getWindTurbineType4bIEC( WindTurbineType4bIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindTurbineType4bIECFetchOneSummary arg cannot be null" );
    	
    	WindTurbineType4bIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindTurbineType4bIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindTurbineType4bIEC
        	// --------------------------------------
        	CompletableFuture<WindTurbineType4bIEC> futureEntity = queryGateway.query(new FindWindTurbineType4bIECQuery( new LoadWindTurbineType4bIECFilter( summary.getWindTurbineType4bIECId() ) ), ResponseTypes.instanceOf(WindTurbineType4bIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindTurbineType4bIEC with id " + summary.getWindTurbineType4bIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindTurbineType4bIECs
     *
     * @return 	List<WindTurbineType4bIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindTurbineType4bIEC> getAllWindTurbineType4bIEC() 
    throws ProcessingException {
        List<WindTurbineType4bIEC> list = null;

        try {
        	CompletableFuture<List<WindTurbineType4bIEC>> futureList = queryGateway.query(new FindAllWindTurbineType4bIECQuery(), ResponseTypes.multipleInstancesOf(WindTurbineType4bIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindTurbineType4bIEC";
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
	 * @return		WindTurbineType4bIEC
	 */
	protected WindTurbineType4bIEC load( UUID id ) throws ProcessingException {
		windTurbineType4bIEC = WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance().getWindTurbineType4bIEC( new WindTurbineType4bIECFetchOneSummary(id) );	
		return windTurbineType4bIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindTurbineType4bIEC windTurbineType4bIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindTurbineType4bIECBusinessDelegate.class.getName());
    
}
