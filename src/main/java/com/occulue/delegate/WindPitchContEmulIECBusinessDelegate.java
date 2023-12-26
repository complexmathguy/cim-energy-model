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
 * WindPitchContEmulIEC business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindPitchContEmulIEC related services in the case of a WindPitchContEmulIEC business related service failing.</li>
 * <li>Exposes a simpler, uniform WindPitchContEmulIEC interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindPitchContEmulIEC business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindPitchContEmulIECBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindPitchContEmulIECBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindPitchContEmulIEC Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindPitchContEmulIECBusinessDelegate
	*/
	public static WindPitchContEmulIECBusinessDelegate getWindPitchContEmulIECInstance() {
		return( new WindPitchContEmulIECBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindPitchContEmulIEC( CreateWindPitchContEmulIECCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindPitchContEmulIECId() == null )
				command.setWindPitchContEmulIECId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPitchContEmulIECValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindPitchContEmulIECCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindPitchContEmulIECCommand of WindPitchContEmulIEC is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindPitchContEmulIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindPitchContEmulIECCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindPitchContEmulIEC( UpdateWindPitchContEmulIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindPitchContEmulIECValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindPitchContEmulIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindPitchContEmulIEC - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindPitchContEmulIECCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindPitchContEmulIECCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindPitchContEmulIECValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindPitchContEmulIECCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindPitchContEmulIEC using Id = "  + command.getWindPitchContEmulIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindPitchContEmulIEC via WindPitchContEmulIECFetchOneSummary
     * @param 	summary WindPitchContEmulIECFetchOneSummary 
     * @return 	WindPitchContEmulIECFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindPitchContEmulIEC getWindPitchContEmulIEC( WindPitchContEmulIECFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindPitchContEmulIECFetchOneSummary arg cannot be null" );
    	
    	WindPitchContEmulIEC entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindPitchContEmulIECValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindPitchContEmulIEC
        	// --------------------------------------
        	CompletableFuture<WindPitchContEmulIEC> futureEntity = queryGateway.query(new FindWindPitchContEmulIECQuery( new LoadWindPitchContEmulIECFilter( summary.getWindPitchContEmulIECId() ) ), ResponseTypes.instanceOf(WindPitchContEmulIEC.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindPitchContEmulIEC with id " + summary.getWindPitchContEmulIECId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindPitchContEmulIECs
     *
     * @return 	List<WindPitchContEmulIEC> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindPitchContEmulIEC> getAllWindPitchContEmulIEC() 
    throws ProcessingException {
        List<WindPitchContEmulIEC> list = null;

        try {
        	CompletableFuture<List<WindPitchContEmulIEC>> futureList = queryGateway.query(new FindAllWindPitchContEmulIECQuery(), ResponseTypes.multipleInstancesOf(WindPitchContEmulIEC.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindPitchContEmulIEC";
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
	 * @return		WindPitchContEmulIEC
	 */
	protected WindPitchContEmulIEC load( UUID id ) throws ProcessingException {
		windPitchContEmulIEC = WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance().getWindPitchContEmulIEC( new WindPitchContEmulIECFetchOneSummary(id) );	
		return windPitchContEmulIEC;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindPitchContEmulIEC windPitchContEmulIEC 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindPitchContEmulIECBusinessDelegate.class.getName());
    
}
