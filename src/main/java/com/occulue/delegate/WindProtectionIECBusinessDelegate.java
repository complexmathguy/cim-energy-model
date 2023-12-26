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
 * WindProtectionIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindProtectionIEC related services in the case of a WindProtectionIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindProtectionIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindProtectionIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindProtectionIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindProtectionIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindProtectionIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindProtectionIECBusinessDelegate
	*/
	public static WindProtectionIECBusinessDelegate getWindProtectionIECInstance() {
		return( new WindProtectionIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindProtectionIEC( CreateWindProtectionIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindProtectionIECId() == null )
				command.setWindProtectionIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindProtectionIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindProtectionIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindProtectionIECCommand of WindProtectionIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindProtectionIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindProtectionIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindProtectionIEC( UpdateWindProtectionIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindProtectionIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindProtectionIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindProtectionIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindProtectionIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindProtectionIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindProtectionIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindProtectionIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindProtectionIEC using Id = "  + command.getWindProtectionIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindProtectionIEC via WindProtectionIECFetchOneSummary
     * @param 	summary WindProtectionIECFetchOneSummary 
     * @return 	WindProtectionIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindProtectionIEC getWindProtectionIEC( WindProtectionIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindProtectionIECFetchOneSummary arg cannot be null" );
    	
    	WindProtectionIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindProtectionIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindProtectionIEC
        	// --------------------------------------
        	CompletableFuture<WindProtectionIEC> futureEntity = queryGateway.query(new FindWindProtectionIECQuery( new LoadWindProtectionIECFilter( summary.getWindProtectionIECId() ) ), ResponseTypes.instanceOf(WindProtectionIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindProtectionIEC with id " + summary.getWindProtectionIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindProtectionIECs
     *
     * @return 	List<WindProtectionIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindProtectionIEC> getAllWindProtectionIEC() 
    throws ProcessingException {
        List<WindProtectionIEC> list = null;

        try {
        	CompletableFuture<List<WindProtectionIEC>> futureList = queryGateway.query(new FindAllWindProtectionIECQuery(), ResponseTypes.multipleInstancesOf(WindProtectionIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindProtectionIEC";
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
	 * @return		WindProtectionIEC
	 */
	protected WindProtectionIEC load( UUID id ) throws ProcessingException {
		windProtectionIEC = WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().getWindProtectionIEC( new WindProtectionIECFetchOneSummary(id) );	
		return windProtectionIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindProtectionIEC windProtectionIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindProtectionIECBusinessDelegate.class.getName());
    
}
