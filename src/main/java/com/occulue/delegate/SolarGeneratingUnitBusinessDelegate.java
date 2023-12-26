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
 * SolarGeneratingUnit business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of SolarGeneratingUnit related services in the case of a SolarGeneratingUnit business related service failing.</li>
 * <li>Exposes a simpler, uniform SolarGeneratingUnit interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill SolarGeneratingUnit business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class SolarGeneratingUnitBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public SolarGeneratingUnitBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* SolarGeneratingUnit Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	SolarGeneratingUnitBusinessDelegate
	*/
	public static SolarGeneratingUnitBusinessDelegate getSolarGeneratingUnitInstance() {
		return( new SolarGeneratingUnitBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createSolarGeneratingUnit( CreateSolarGeneratingUnitCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getSolarGeneratingUnitId() == null )
				command.setSolarGeneratingUnitId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SolarGeneratingUnitValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateSolarGeneratingUnitCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateSolarGeneratingUnitCommand of SolarGeneratingUnit is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create SolarGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateSolarGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateSolarGeneratingUnit( UpdateSolarGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	SolarGeneratingUnitValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateSolarGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save SolarGeneratingUnit - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteSolarGeneratingUnitCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteSolarGeneratingUnitCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	SolarGeneratingUnitValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteSolarGeneratingUnitCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete SolarGeneratingUnit using Id = "  + command.getSolarGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the SolarGeneratingUnit via SolarGeneratingUnitFetchOneSummary
     * @param 	summary SolarGeneratingUnitFetchOneSummary 
     * @return 	SolarGeneratingUnitFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public SolarGeneratingUnit getSolarGeneratingUnit( SolarGeneratingUnitFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "SolarGeneratingUnitFetchOneSummary arg cannot be null" );
    	
    	SolarGeneratingUnit entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	SolarGeneratingUnitValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a SolarGeneratingUnit
        	// --------------------------------------
        	CompletableFuture<SolarGeneratingUnit> futureEntity = queryGateway.query(new FindSolarGeneratingUnitQuery( new LoadSolarGeneratingUnitFilter( summary.getSolarGeneratingUnitId() ) ), ResponseTypes.instanceOf(SolarGeneratingUnit.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate SolarGeneratingUnit with id " + summary.getSolarGeneratingUnitId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all SolarGeneratingUnits
     *
     * @return 	List<SolarGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<SolarGeneratingUnit> getAllSolarGeneratingUnit() 
    throws ProcessingException {
        List<SolarGeneratingUnit> list = null;

        try {
        	CompletableFuture<List<SolarGeneratingUnit>> futureList = queryGateway.query(new FindAllSolarGeneratingUnitQuery(), ResponseTypes.multipleInstancesOf(SolarGeneratingUnit.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all SolarGeneratingUnit";
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
	 * @return		SolarGeneratingUnit
	 */
	protected SolarGeneratingUnit load( UUID id ) throws ProcessingException {
		solarGeneratingUnit = SolarGeneratingUnitBusinessDelegate.getSolarGeneratingUnitInstance().getSolarGeneratingUnit( new SolarGeneratingUnitFetchOneSummary(id) );	
		return solarGeneratingUnit;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private SolarGeneratingUnit solarGeneratingUnit 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(SolarGeneratingUnitBusinessDelegate.class.getName());
    
}
