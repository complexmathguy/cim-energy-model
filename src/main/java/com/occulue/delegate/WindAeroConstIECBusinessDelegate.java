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
 * WindAeroConstIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindAeroConstIEC related services in the case of a WindAeroConstIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindAeroConstIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindAeroConstIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindAeroConstIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindAeroConstIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindAeroConstIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindAeroConstIECBusinessDelegate
	*/
	public static WindAeroConstIECBusinessDelegate getWindAeroConstIECInstance() {
		return( new WindAeroConstIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindAeroConstIEC( CreateWindAeroConstIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindAeroConstIECId() == null )
				command.setWindAeroConstIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindAeroConstIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindAeroConstIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindAeroConstIECCommand of WindAeroConstIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindAeroConstIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindAeroConstIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindAeroConstIEC( UpdateWindAeroConstIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindAeroConstIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindAeroConstIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindAeroConstIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindAeroConstIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindAeroConstIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindAeroConstIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindAeroConstIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindAeroConstIEC using Id = "  + command.getWindAeroConstIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindAeroConstIEC via WindAeroConstIECFetchOneSummary
     * @param 	summary WindAeroConstIECFetchOneSummary 
     * @return 	WindAeroConstIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindAeroConstIEC getWindAeroConstIEC( WindAeroConstIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindAeroConstIECFetchOneSummary arg cannot be null" );
    	
    	WindAeroConstIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindAeroConstIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindAeroConstIEC
        	// --------------------------------------
        	CompletableFuture<WindAeroConstIEC> futureEntity = queryGateway.query(new FindWindAeroConstIECQuery( new LoadWindAeroConstIECFilter( summary.getWindAeroConstIECId() ) ), ResponseTypes.instanceOf(WindAeroConstIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindAeroConstIEC with id " + summary.getWindAeroConstIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindAeroConstIECs
     *
     * @return 	List<WindAeroConstIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindAeroConstIEC> getAllWindAeroConstIEC() 
    throws ProcessingException {
        List<WindAeroConstIEC> list = null;

        try {
        	CompletableFuture<List<WindAeroConstIEC>> futureList = queryGateway.query(new FindAllWindAeroConstIECQuery(), ResponseTypes.multipleInstancesOf(WindAeroConstIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindAeroConstIEC";
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
	 * @return		WindAeroConstIEC
	 */
	protected WindAeroConstIEC load( UUID id ) throws ProcessingException {
		windAeroConstIEC = WindAeroConstIECBusinessDelegate.getWindAeroConstIECInstance().getWindAeroConstIEC( new WindAeroConstIECFetchOneSummary(id) );	
		return windAeroConstIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindAeroConstIEC windAeroConstIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindAeroConstIECBusinessDelegate.class.getName());
    
}
