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
 * ThermalGeneratingUnit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ThermalGeneratingUnit related services in the case of a ThermalGeneratingUnit business related service failing.</li>
 * <li>Exposes a simpler, uniform ThermalGeneratingUnit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ThermalGeneratingUnit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ThermalGeneratingUnitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ThermalGeneratingUnitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ThermalGeneratingUnit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ThermalGeneratingUnitBusinessDelegate
	*/
	public static ThermalGeneratingUnitBusinessDelegate getThermalGeneratingUnitInstance() {
		return( new ThermalGeneratingUnitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createThermalGeneratingUnit( CreateThermalGeneratingUnitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getThermalGeneratingUnitId() == null )
				command.setThermalGeneratingUnitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ThermalGeneratingUnitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateThermalGeneratingUnitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateThermalGeneratingUnitCommand of ThermalGeneratingUnit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ThermalGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateThermalGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateThermalGeneratingUnit( UpdateThermalGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ThermalGeneratingUnitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateThermalGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ThermalGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteThermalGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteThermalGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ThermalGeneratingUnitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteThermalGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ThermalGeneratingUnit using Id = "  + command.getThermalGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ThermalGeneratingUnit via ThermalGeneratingUnitFetchOneSummary
     * @param 	summary ThermalGeneratingUnitFetchOneSummary 
     * @return 	ThermalGeneratingUnitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ThermalGeneratingUnit getThermalGeneratingUnit( ThermalGeneratingUnitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ThermalGeneratingUnitFetchOneSummary arg cannot be null" );
    	
    	ThermalGeneratingUnit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ThermalGeneratingUnitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ThermalGeneratingUnit
        	// --------------------------------------
        	CompletableFuture<ThermalGeneratingUnit> futureEntity = queryGateway.query(new FindThermalGeneratingUnitQuery( new LoadThermalGeneratingUnitFilter( summary.getThermalGeneratingUnitId() ) ), ResponseTypes.instanceOf(ThermalGeneratingUnit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ThermalGeneratingUnit with id " + summary.getThermalGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ThermalGeneratingUnits
     *
     * @return 	List<ThermalGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ThermalGeneratingUnit> getAllThermalGeneratingUnit() 
    throws ProcessingException {
        List<ThermalGeneratingUnit> list = null;

        try {
        	CompletableFuture<List<ThermalGeneratingUnit>> futureList = queryGateway.query(new FindAllThermalGeneratingUnitQuery(), ResponseTypes.multipleInstancesOf(ThermalGeneratingUnit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ThermalGeneratingUnit";
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
	 * @return		ThermalGeneratingUnit
	 */
	protected ThermalGeneratingUnit load( UUID id ) throws ProcessingException {
		thermalGeneratingUnit = ThermalGeneratingUnitBusinessDelegate.getThermalGeneratingUnitInstance().getThermalGeneratingUnit( new ThermalGeneratingUnitFetchOneSummary(id) );	
		return thermalGeneratingUnit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ThermalGeneratingUnit thermalGeneratingUnit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ThermalGeneratingUnitBusinessDelegate.class.getName());
    
}
