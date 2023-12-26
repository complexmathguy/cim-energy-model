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
 * WindGenTurbineType1IEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindGenTurbineType1IEC related services in the case of a WindGenTurbineType1IEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindGenTurbineType1IEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType1IEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindGenTurbineType1IECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindGenTurbineType1IECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindGenTurbineType1IEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindGenTurbineType1IECBusinessDelegate
	*/
	public static WindGenTurbineType1IECBusinessDelegate getWindGenTurbineType1IECInstance() {
		return( new WindGenTurbineType1IECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindGenTurbineType1IEC( CreateWindGenTurbineType1IECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindGenTurbineType1IECId() == null )
				command.setWindGenTurbineType1IECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType1IECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindGenTurbineType1IECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindGenTurbineType1IECCommand of WindGenTurbineType1IEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindGenTurbineType1IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindGenTurbineType1IECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindGenTurbineType1IEC( UpdateWindGenTurbineType1IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindGenTurbineType1IECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindGenTurbineType1IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindGenTurbineType1IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindGenTurbineType1IECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindGenTurbineType1IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType1IECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindGenTurbineType1IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindGenTurbineType1IEC using Id = "  + command.getWindGenTurbineType1IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindGenTurbineType1IEC via WindGenTurbineType1IECFetchOneSummary
     * @param 	summary WindGenTurbineType1IECFetchOneSummary 
     * @return 	WindGenTurbineType1IECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindGenTurbineType1IEC getWindGenTurbineType1IEC( WindGenTurbineType1IECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindGenTurbineType1IECFetchOneSummary arg cannot be null" );
    	
    	WindGenTurbineType1IEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindGenTurbineType1IECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindGenTurbineType1IEC
        	// --------------------------------------
        	CompletableFuture<WindGenTurbineType1IEC> futureEntity = queryGateway.query(new FindWindGenTurbineType1IECQuery( new LoadWindGenTurbineType1IECFilter( summary.getWindGenTurbineType1IECId() ) ), ResponseTypes.instanceOf(WindGenTurbineType1IEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindGenTurbineType1IEC with id " + summary.getWindGenTurbineType1IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindGenTurbineType1IECs
     *
     * @return 	List<WindGenTurbineType1IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindGenTurbineType1IEC> getAllWindGenTurbineType1IEC() 
    throws ProcessingException {
        List<WindGenTurbineType1IEC> list = null;

        try {
        	CompletableFuture<List<WindGenTurbineType1IEC>> futureList = queryGateway.query(new FindAllWindGenTurbineType1IECQuery(), ResponseTypes.multipleInstancesOf(WindGenTurbineType1IEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindGenTurbineType1IEC";
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
	 * @return		WindGenTurbineType1IEC
	 */
	protected WindGenTurbineType1IEC load( UUID id ) throws ProcessingException {
		windGenTurbineType1IEC = WindGenTurbineType1IECBusinessDelegate.getWindGenTurbineType1IECInstance().getWindGenTurbineType1IEC( new WindGenTurbineType1IECFetchOneSummary(id) );	
		return windGenTurbineType1IEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindGenTurbineType1IEC windGenTurbineType1IEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindGenTurbineType1IECBusinessDelegate.class.getName());
    
}
