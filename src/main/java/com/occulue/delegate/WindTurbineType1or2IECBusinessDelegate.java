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
 * WindTurbineType1or2IEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindTurbineType1or2IEC related services in the case of a WindTurbineType1or2IEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindTurbineType1or2IEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindTurbineType1or2IEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindTurbineType1or2IECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindTurbineType1or2IECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindTurbineType1or2IEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindTurbineType1or2IECBusinessDelegate
	*/
	public static WindTurbineType1or2IECBusinessDelegate getWindTurbineType1or2IECInstance() {
		return( new WindTurbineType1or2IECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindTurbineType1or2IEC( CreateWindTurbineType1or2IECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindTurbineType1or2IECId() == null )
				command.setWindTurbineType1or2IECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType1or2IECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindTurbineType1or2IECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindTurbineType1or2IECCommand of WindTurbineType1or2IEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindTurbineType1or2IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindTurbineType1or2IECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindTurbineType1or2IEC( UpdateWindTurbineType1or2IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindTurbineType1or2IECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindTurbineType1or2IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindTurbineType1or2IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindTurbineType1or2IECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindTurbineType1or2IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindTurbineType1or2IECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindTurbineType1or2IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindTurbineType1or2IEC using Id = "  + command.getWindTurbineType1or2IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindTurbineType1or2IEC via WindTurbineType1or2IECFetchOneSummary
     * @param 	summary WindTurbineType1or2IECFetchOneSummary 
     * @return 	WindTurbineType1or2IECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindTurbineType1or2IEC getWindTurbineType1or2IEC( WindTurbineType1or2IECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindTurbineType1or2IECFetchOneSummary arg cannot be null" );
    	
    	WindTurbineType1or2IEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindTurbineType1or2IECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindTurbineType1or2IEC
        	// --------------------------------------
        	CompletableFuture<WindTurbineType1or2IEC> futureEntity = queryGateway.query(new FindWindTurbineType1or2IECQuery( new LoadWindTurbineType1or2IECFilter( summary.getWindTurbineType1or2IECId() ) ), ResponseTypes.instanceOf(WindTurbineType1or2IEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindTurbineType1or2IEC with id " + summary.getWindTurbineType1or2IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindTurbineType1or2IECs
     *
     * @return 	List<WindTurbineType1or2IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindTurbineType1or2IEC> getAllWindTurbineType1or2IEC() 
    throws ProcessingException {
        List<WindTurbineType1or2IEC> list = null;

        try {
        	CompletableFuture<List<WindTurbineType1or2IEC>> futureList = queryGateway.query(new FindAllWindTurbineType1or2IECQuery(), ResponseTypes.multipleInstancesOf(WindTurbineType1or2IEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindTurbineType1or2IEC";
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
	 * @return		WindTurbineType1or2IEC
	 */
	protected WindTurbineType1or2IEC load( UUID id ) throws ProcessingException {
		windTurbineType1or2IEC = WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance().getWindTurbineType1or2IEC( new WindTurbineType1or2IECFetchOneSummary(id) );	
		return windTurbineType1or2IEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindTurbineType1or2IEC windTurbineType1or2IEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindTurbineType1or2IECBusinessDelegate.class.getName());
    
}
