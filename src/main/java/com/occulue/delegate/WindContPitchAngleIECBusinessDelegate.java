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
 * WindContPitchAngleIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindContPitchAngleIEC related services in the case of a WindContPitchAngleIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindContPitchAngleIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindContPitchAngleIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindContPitchAngleIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindContPitchAngleIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindContPitchAngleIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindContPitchAngleIECBusinessDelegate
	*/
	public static WindContPitchAngleIECBusinessDelegate getWindContPitchAngleIECInstance() {
		return( new WindContPitchAngleIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindContPitchAngleIEC( CreateWindContPitchAngleIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindContPitchAngleIECId() == null )
				command.setWindContPitchAngleIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPitchAngleIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindContPitchAngleIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindContPitchAngleIECCommand of WindContPitchAngleIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindContPitchAngleIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindContPitchAngleIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindContPitchAngleIEC( UpdateWindContPitchAngleIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindContPitchAngleIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindContPitchAngleIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindContPitchAngleIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindContPitchAngleIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindContPitchAngleIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindContPitchAngleIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindContPitchAngleIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindContPitchAngleIEC using Id = "  + command.getWindContPitchAngleIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindContPitchAngleIEC via WindContPitchAngleIECFetchOneSummary
     * @param 	summary WindContPitchAngleIECFetchOneSummary 
     * @return 	WindContPitchAngleIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindContPitchAngleIEC getWindContPitchAngleIEC( WindContPitchAngleIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindContPitchAngleIECFetchOneSummary arg cannot be null" );
    	
    	WindContPitchAngleIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindContPitchAngleIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindContPitchAngleIEC
        	// --------------------------------------
        	CompletableFuture<WindContPitchAngleIEC> futureEntity = queryGateway.query(new FindWindContPitchAngleIECQuery( new LoadWindContPitchAngleIECFilter( summary.getWindContPitchAngleIECId() ) ), ResponseTypes.instanceOf(WindContPitchAngleIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindContPitchAngleIEC with id " + summary.getWindContPitchAngleIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindContPitchAngleIECs
     *
     * @return 	List<WindContPitchAngleIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindContPitchAngleIEC> getAllWindContPitchAngleIEC() 
    throws ProcessingException {
        List<WindContPitchAngleIEC> list = null;

        try {
        	CompletableFuture<List<WindContPitchAngleIEC>> futureList = queryGateway.query(new FindAllWindContPitchAngleIECQuery(), ResponseTypes.multipleInstancesOf(WindContPitchAngleIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindContPitchAngleIEC";
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
	 * @return		WindContPitchAngleIEC
	 */
	protected WindContPitchAngleIEC load( UUID id ) throws ProcessingException {
		windContPitchAngleIEC = WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().getWindContPitchAngleIEC( new WindContPitchAngleIECFetchOneSummary(id) );	
		return windContPitchAngleIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindContPitchAngleIEC windContPitchAngleIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindContPitchAngleIECBusinessDelegate.class.getName());
    
}
