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
 * WindGenTurbineType2IEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindGenTurbineType2IEC related services in the case of a WindGenTurbineType2IEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindGenTurbineType2IEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType2IEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindGenTurbineType2IECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindGenTurbineType2IECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindGenTurbineType2IEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindGenTurbineType2IECBusinessDelegate
	*/
	public static WindGenTurbineType2IECBusinessDelegate getWindGenTurbineType2IECInstance() {
		return( new WindGenTurbineType2IECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindGenTurbineType2IEC( CreateWindGenTurbineType2IECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindGenTurbineType2IECId() == null )
				command.setWindGenTurbineType2IECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType2IECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindGenTurbineType2IECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindGenTurbineType2IECCommand of WindGenTurbineType2IEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindGenTurbineType2IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindGenTurbineType2IECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindGenTurbineType2IEC( UpdateWindGenTurbineType2IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindGenTurbineType2IECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindGenTurbineType2IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindGenTurbineType2IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindGenTurbineType2IECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindGenTurbineType2IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenTurbineType2IECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindGenTurbineType2IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindGenTurbineType2IEC using Id = "  + command.getWindGenTurbineType2IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindGenTurbineType2IEC via WindGenTurbineType2IECFetchOneSummary
     * @param 	summary WindGenTurbineType2IECFetchOneSummary 
     * @return 	WindGenTurbineType2IECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindGenTurbineType2IEC getWindGenTurbineType2IEC( WindGenTurbineType2IECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindGenTurbineType2IECFetchOneSummary arg cannot be null" );
    	
    	WindGenTurbineType2IEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindGenTurbineType2IECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindGenTurbineType2IEC
        	// --------------------------------------
        	CompletableFuture<WindGenTurbineType2IEC> futureEntity = queryGateway.query(new FindWindGenTurbineType2IECQuery( new LoadWindGenTurbineType2IECFilter( summary.getWindGenTurbineType2IECId() ) ), ResponseTypes.instanceOf(WindGenTurbineType2IEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindGenTurbineType2IEC with id " + summary.getWindGenTurbineType2IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindGenTurbineType2IECs
     *
     * @return 	List<WindGenTurbineType2IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindGenTurbineType2IEC> getAllWindGenTurbineType2IEC() 
    throws ProcessingException {
        List<WindGenTurbineType2IEC> list = null;

        try {
        	CompletableFuture<List<WindGenTurbineType2IEC>> futureList = queryGateway.query(new FindAllWindGenTurbineType2IECQuery(), ResponseTypes.multipleInstancesOf(WindGenTurbineType2IEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindGenTurbineType2IEC";
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
	 * @return		WindGenTurbineType2IEC
	 */
	protected WindGenTurbineType2IEC load( UUID id ) throws ProcessingException {
		windGenTurbineType2IEC = WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance().getWindGenTurbineType2IEC( new WindGenTurbineType2IECFetchOneSummary(id) );	
		return windGenTurbineType2IEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindGenTurbineType2IEC windGenTurbineType2IEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindGenTurbineType2IECBusinessDelegate.class.getName());
    
}
