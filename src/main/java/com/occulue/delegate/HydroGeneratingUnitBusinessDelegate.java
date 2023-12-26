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
 * HydroGeneratingUnit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of HydroGeneratingUnit related services in the case of a HydroGeneratingUnit business related service failing.</li>
 * <li>Exposes a simpler, uniform HydroGeneratingUnit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill HydroGeneratingUnit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class HydroGeneratingUnitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public HydroGeneratingUnitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* HydroGeneratingUnit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	HydroGeneratingUnitBusinessDelegate
	*/
	public static HydroGeneratingUnitBusinessDelegate getHydroGeneratingUnitInstance() {
		return( new HydroGeneratingUnitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createHydroGeneratingUnit( CreateHydroGeneratingUnitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getHydroGeneratingUnitId() == null )
				command.setHydroGeneratingUnitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	HydroGeneratingUnitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateHydroGeneratingUnitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateHydroGeneratingUnitCommand of HydroGeneratingUnit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create HydroGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateHydroGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateHydroGeneratingUnit( UpdateHydroGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	HydroGeneratingUnitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateHydroGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save HydroGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteHydroGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteHydroGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	HydroGeneratingUnitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteHydroGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete HydroGeneratingUnit using Id = "  + command.getHydroGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the HydroGeneratingUnit via HydroGeneratingUnitFetchOneSummary
     * @param 	summary HydroGeneratingUnitFetchOneSummary 
     * @return 	HydroGeneratingUnitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public HydroGeneratingUnit getHydroGeneratingUnit( HydroGeneratingUnitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "HydroGeneratingUnitFetchOneSummary arg cannot be null" );
    	
    	HydroGeneratingUnit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	HydroGeneratingUnitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a HydroGeneratingUnit
        	// --------------------------------------
        	CompletableFuture<HydroGeneratingUnit> futureEntity = queryGateway.query(new FindHydroGeneratingUnitQuery( new LoadHydroGeneratingUnitFilter( summary.getHydroGeneratingUnitId() ) ), ResponseTypes.instanceOf(HydroGeneratingUnit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate HydroGeneratingUnit with id " + summary.getHydroGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all HydroGeneratingUnits
     *
     * @return 	List<HydroGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<HydroGeneratingUnit> getAllHydroGeneratingUnit() 
    throws ProcessingException {
        List<HydroGeneratingUnit> list = null;

        try {
        	CompletableFuture<List<HydroGeneratingUnit>> futureList = queryGateway.query(new FindAllHydroGeneratingUnitQuery(), ResponseTypes.multipleInstancesOf(HydroGeneratingUnit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all HydroGeneratingUnit";
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
	 * @return		HydroGeneratingUnit
	 */
	protected HydroGeneratingUnit load( UUID id ) throws ProcessingException {
		hydroGeneratingUnit = HydroGeneratingUnitBusinessDelegate.getHydroGeneratingUnitInstance().getHydroGeneratingUnit( new HydroGeneratingUnitFetchOneSummary(id) );	
		return hydroGeneratingUnit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private HydroGeneratingUnit hydroGeneratingUnit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(HydroGeneratingUnitBusinessDelegate.class.getName());
    
}
