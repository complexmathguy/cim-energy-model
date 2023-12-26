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
 * WindGenType4IEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindGenType4IEC related services in the case of a WindGenType4IEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindGenType4IEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindGenType4IEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindGenType4IECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindGenType4IECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindGenType4IEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindGenType4IECBusinessDelegate
	*/
	public static WindGenType4IECBusinessDelegate getWindGenType4IECInstance() {
		return( new WindGenType4IECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindGenType4IEC( CreateWindGenType4IECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindGenType4IECId() == null )
				command.setWindGenType4IECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenType4IECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindGenType4IECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindGenType4IECCommand of WindGenType4IEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindGenType4IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindGenType4IECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindGenType4IEC( UpdateWindGenType4IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindGenType4IECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindGenType4IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindGenType4IEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindGenType4IECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindGenType4IECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGenType4IECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindGenType4IECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindGenType4IEC using Id = "  + command.getWindGenType4IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindGenType4IEC via WindGenType4IECFetchOneSummary
     * @param 	summary WindGenType4IECFetchOneSummary 
     * @return 	WindGenType4IECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindGenType4IEC getWindGenType4IEC( WindGenType4IECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindGenType4IECFetchOneSummary arg cannot be null" );
    	
    	WindGenType4IEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindGenType4IECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindGenType4IEC
        	// --------------------------------------
        	CompletableFuture<WindGenType4IEC> futureEntity = queryGateway.query(new FindWindGenType4IECQuery( new LoadWindGenType4IECFilter( summary.getWindGenType4IECId() ) ), ResponseTypes.instanceOf(WindGenType4IEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindGenType4IEC with id " + summary.getWindGenType4IECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindGenType4IECs
     *
     * @return 	List<WindGenType4IEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindGenType4IEC> getAllWindGenType4IEC() 
    throws ProcessingException {
        List<WindGenType4IEC> list = null;

        try {
        	CompletableFuture<List<WindGenType4IEC>> futureList = queryGateway.query(new FindAllWindGenType4IECQuery(), ResponseTypes.multipleInstancesOf(WindGenType4IEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindGenType4IEC";
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
	 * @return		WindGenType4IEC
	 */
	protected WindGenType4IEC load( UUID id ) throws ProcessingException {
		windGenType4IEC = WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().getWindGenType4IEC( new WindGenType4IECFetchOneSummary(id) );	
		return windGenType4IEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindGenType4IEC windGenType4IEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindGenType4IECBusinessDelegate.class.getName());
    
}
