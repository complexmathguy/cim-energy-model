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
 * WindTurbineType4aIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindTurbineType4aIEC related services in the case of a WindTurbineType4aIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindTurbineType4aIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindTurbineType4aIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindTurbineType4aIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindTurbineType4aIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindTurbineType4aIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindTurbineType4aIECBusinessDelegate
	*/
	public static WindTurbineType4aIECBusinessDelegate getWindTurbineType4aIECInstance() {
		return( new WindTurbineType4aIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindTurbineType4aIEC( CreateWindTurbineType4aIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindTurbineType4aIECId() == null )
				command.setWindTurbineType4aIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType4aIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindTurbineType4aIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindTurbineType4aIECCommand of WindTurbineType4aIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindTurbineType4aIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindTurbineType4aIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindTurbineType4aIEC( UpdateWindTurbineType4aIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindTurbineType4aIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindTurbineType4aIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindTurbineType4aIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindTurbineType4aIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindTurbineType4aIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType4aIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindTurbineType4aIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindTurbineType4aIEC using Id = "  + command.getWindTurbineType4aIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindTurbineType4aIEC via WindTurbineType4aIECFetchOneSummary
     * @param 	summary WindTurbineType4aIECFetchOneSummary 
     * @return 	WindTurbineType4aIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindTurbineType4aIEC getWindTurbineType4aIEC( WindTurbineType4aIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindTurbineType4aIECFetchOneSummary arg cannot be null" );
    	
    	WindTurbineType4aIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindTurbineType4aIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindTurbineType4aIEC
        	// --------------------------------------
        	CompletableFuture<WindTurbineType4aIEC> futureEntity = queryGateway.query(new FindWindTurbineType4aIECQuery( new LoadWindTurbineType4aIECFilter( summary.getWindTurbineType4aIECId() ) ), ResponseTypes.instanceOf(WindTurbineType4aIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindTurbineType4aIEC with id " + summary.getWindTurbineType4aIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindTurbineType4aIECs
     *
     * @return 	List<WindTurbineType4aIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindTurbineType4aIEC> getAllWindTurbineType4aIEC() 
    throws ProcessingException {
        List<WindTurbineType4aIEC> list = null;

        try {
        	CompletableFuture<List<WindTurbineType4aIEC>> futureList = queryGateway.query(new FindAllWindTurbineType4aIECQuery(), ResponseTypes.multipleInstancesOf(WindTurbineType4aIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindTurbineType4aIEC";
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
	 * @return		WindTurbineType4aIEC
	 */
	protected WindTurbineType4aIEC load( UUID id ) throws ProcessingException {
		windTurbineType4aIEC = WindTurbineType4aIECBusinessDelegate.getWindTurbineType4aIECInstance().getWindTurbineType4aIEC( new WindTurbineType4aIECFetchOneSummary(id) );	
		return windTurbineType4aIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindTurbineType4aIEC windTurbineType4aIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindTurbineType4aIECBusinessDelegate.class.getName());
    
}
