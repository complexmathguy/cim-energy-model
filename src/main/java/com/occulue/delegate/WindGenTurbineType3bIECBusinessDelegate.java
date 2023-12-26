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
 * WindGenTurbineType3bIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindGenTurbineType3bIEC related services in the case of a WindGenTurbineType3bIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindGenTurbineType3bIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType3bIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindGenTurbineType3bIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindGenTurbineType3bIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindGenTurbineType3bIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindGenTurbineType3bIECBusinessDelegate
	*/
	public static WindGenTurbineType3bIECBusinessDelegate getWindGenTurbineType3bIECInstance() {
		return( new WindGenTurbineType3bIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindGenTurbineType3bIEC( CreateWindGenTurbineType3bIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindGenTurbineType3bIECId() == null )
				command.setWindGenTurbineType3bIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType3bIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindGenTurbineType3bIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindGenTurbineType3bIECCommand of WindGenTurbineType3bIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindGenTurbineType3bIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindGenTurbineType3bIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindGenTurbineType3bIEC( UpdateWindGenTurbineType3bIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindGenTurbineType3bIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindGenTurbineType3bIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindGenTurbineType3bIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindGenTurbineType3bIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindGenTurbineType3bIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType3bIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindGenTurbineType3bIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindGenTurbineType3bIEC using Id = "  + command.getWindGenTurbineType3bIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindGenTurbineType3bIEC via WindGenTurbineType3bIECFetchOneSummary
     * @param 	summary WindGenTurbineType3bIECFetchOneSummary 
     * @return 	WindGenTurbineType3bIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindGenTurbineType3bIEC getWindGenTurbineType3bIEC( WindGenTurbineType3bIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindGenTurbineType3bIECFetchOneSummary arg cannot be null" );
    	
    	WindGenTurbineType3bIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindGenTurbineType3bIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindGenTurbineType3bIEC
        	// --------------------------------------
        	CompletableFuture<WindGenTurbineType3bIEC> futureEntity = queryGateway.query(new FindWindGenTurbineType3bIECQuery( new LoadWindGenTurbineType3bIECFilter( summary.getWindGenTurbineType3bIECId() ) ), ResponseTypes.instanceOf(WindGenTurbineType3bIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindGenTurbineType3bIEC with id " + summary.getWindGenTurbineType3bIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindGenTurbineType3bIECs
     *
     * @return 	List<WindGenTurbineType3bIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindGenTurbineType3bIEC> getAllWindGenTurbineType3bIEC() 
    throws ProcessingException {
        List<WindGenTurbineType3bIEC> list = null;

        try {
        	CompletableFuture<List<WindGenTurbineType3bIEC>> futureList = queryGateway.query(new FindAllWindGenTurbineType3bIECQuery(), ResponseTypes.multipleInstancesOf(WindGenTurbineType3bIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindGenTurbineType3bIEC";
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
	 * @return		WindGenTurbineType3bIEC
	 */
	protected WindGenTurbineType3bIEC load( UUID id ) throws ProcessingException {
		windGenTurbineType3bIEC = WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance().getWindGenTurbineType3bIEC( new WindGenTurbineType3bIECFetchOneSummary(id) );	
		return windGenTurbineType3bIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindGenTurbineType3bIEC windGenTurbineType3bIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindGenTurbineType3bIECBusinessDelegate.class.getName());
    
}
