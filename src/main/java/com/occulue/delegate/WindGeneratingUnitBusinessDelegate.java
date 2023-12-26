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
 * WindGeneratingUnit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of WindGeneratingUnit related services in the case of a WindGeneratingUnit business related service failing.</li>
 * <li>Exposes a simpler, uniform WindGeneratingUnit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill WindGeneratingUnit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class WindGeneratingUnitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public WindGeneratingUnitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* WindGeneratingUnit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	WindGeneratingUnitBusinessDelegate
	*/
	public static WindGeneratingUnitBusinessDelegate getWindGeneratingUnitInstance() {
		return( new WindGeneratingUnitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createWindGeneratingUnit( CreateWindGeneratingUnitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getWindGeneratingUnitId() == null )
				command.setWindGeneratingUnitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGeneratingUnitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateWindGeneratingUnitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateWindGeneratingUnitCommand of WindGeneratingUnit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create WindGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateWindGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateWindGeneratingUnit( UpdateWindGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	WindGeneratingUnitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateWindGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save WindGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteWindGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteWindGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	WindGeneratingUnitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteWindGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete WindGeneratingUnit using Id = "  + command.getWindGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the WindGeneratingUnit via WindGeneratingUnitFetchOneSummary
     * @param 	summary WindGeneratingUnitFetchOneSummary 
     * @return 	WindGeneratingUnitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public WindGeneratingUnit getWindGeneratingUnit( WindGeneratingUnitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "WindGeneratingUnitFetchOneSummary arg cannot be null" );
    	
    	WindGeneratingUnit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	WindGeneratingUnitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a WindGeneratingUnit
        	// --------------------------------------
        	CompletableFuture<WindGeneratingUnit> futureEntity = queryGateway.query(new FindWindGeneratingUnitQuery( new LoadWindGeneratingUnitFilter( summary.getWindGeneratingUnitId() ) ), ResponseTypes.instanceOf(WindGeneratingUnit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate WindGeneratingUnit with id " + summary.getWindGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all WindGeneratingUnits
     *
     * @return 	List<WindGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<WindGeneratingUnit> getAllWindGeneratingUnit() 
    throws ProcessingException {
        List<WindGeneratingUnit> list = null;

        try {
        	CompletableFuture<List<WindGeneratingUnit>> futureList = queryGateway.query(new FindAllWindGeneratingUnitQuery(), ResponseTypes.multipleInstancesOf(WindGeneratingUnit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all WindGeneratingUnit";
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
	 * @return		WindGeneratingUnit
	 */
	protected WindGeneratingUnit load( UUID id ) throws ProcessingException {
		windGeneratingUnit = WindGeneratingUnitBusinessDelegate.getWindGeneratingUnitInstance().getWindGeneratingUnit( new WindGeneratingUnitFetchOneSummary(id) );	
		return windGeneratingUnit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private WindGeneratingUnit windGeneratingUnit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(WindGeneratingUnitBusinessDelegate.class.getName());
    
}
