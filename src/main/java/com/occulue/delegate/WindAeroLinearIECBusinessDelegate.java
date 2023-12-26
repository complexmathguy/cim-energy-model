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
 * WindAeroLinearIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindAeroLinearIEC related services in the case of a WindAeroLinearIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindAeroLinearIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindAeroLinearIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindAeroLinearIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindAeroLinearIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindAeroLinearIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindAeroLinearIECBusinessDelegate
	*/
	public static WindAeroLinearIECBusinessDelegate getWindAeroLinearIECInstance() {
		return( new WindAeroLinearIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindAeroLinearIEC( CreateWindAeroLinearIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindAeroLinearIECId() == null )
				command.setWindAeroLinearIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindAeroLinearIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindAeroLinearIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindAeroLinearIECCommand of WindAeroLinearIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindAeroLinearIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindAeroLinearIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindAeroLinearIEC( UpdateWindAeroLinearIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindAeroLinearIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindAeroLinearIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindAeroLinearIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindAeroLinearIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindAeroLinearIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindAeroLinearIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindAeroLinearIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindAeroLinearIEC using Id = "  + command.getWindAeroLinearIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindAeroLinearIEC via WindAeroLinearIECFetchOneSummary
     * @param 	summary WindAeroLinearIECFetchOneSummary 
     * @return 	WindAeroLinearIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindAeroLinearIEC getWindAeroLinearIEC( WindAeroLinearIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindAeroLinearIECFetchOneSummary arg cannot be null" );
    	
    	WindAeroLinearIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindAeroLinearIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindAeroLinearIEC
        	// --------------------------------------
        	CompletableFuture<WindAeroLinearIEC> futureEntity = queryGateway.query(new FindWindAeroLinearIECQuery( new LoadWindAeroLinearIECFilter( summary.getWindAeroLinearIECId() ) ), ResponseTypes.instanceOf(WindAeroLinearIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindAeroLinearIEC with id " + summary.getWindAeroLinearIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindAeroLinearIECs
     *
     * @return 	List<WindAeroLinearIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindAeroLinearIEC> getAllWindAeroLinearIEC() 
    throws ProcessingException {
        List<WindAeroLinearIEC> list = null;

        try {
        	CompletableFuture<List<WindAeroLinearIEC>> futureList = queryGateway.query(new FindAllWindAeroLinearIECQuery(), ResponseTypes.multipleInstancesOf(WindAeroLinearIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindAeroLinearIEC";
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
	 * @return		WindAeroLinearIEC
	 */
	protected WindAeroLinearIEC load( UUID id ) throws ProcessingException {
		windAeroLinearIEC = WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().getWindAeroLinearIEC( new WindAeroLinearIECFetchOneSummary(id) );	
		return windAeroLinearIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindAeroLinearIEC windAeroLinearIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindAeroLinearIECBusinessDelegate.class.getName());
    
}
