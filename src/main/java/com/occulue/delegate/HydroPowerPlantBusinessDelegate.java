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
 * HydroPowerPlant business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of HydroPowerPlant related services in the case of a HydroPowerPlant business related service failing.</li>
 * <li>Exposes a simpler, uniform HydroPowerPlant interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill HydroPowerPlant business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class HydroPowerPlantBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public HydroPowerPlantBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* HydroPowerPlant Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	HydroPowerPlantBusinessDelegate
	*/
	public static HydroPowerPlantBusinessDelegate getHydroPowerPlantInstance() {
		return( new HydroPowerPlantBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createHydroPowerPlant( CreateHydroPowerPlantCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getHydroPowerPlantId() == null )
				command.setHydroPowerPlantId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	HydroPowerPlantValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateHydroPowerPlantCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateHydroPowerPlantCommand of HydroPowerPlant is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create HydroPowerPlant - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateHydroPowerPlantCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateHydroPowerPlant( UpdateHydroPowerPlantCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	HydroPowerPlantValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateHydroPowerPlantCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save HydroPowerPlant - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteHydroPowerPlantCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteHydroPowerPlantCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	HydroPowerPlantValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteHydroPowerPlantCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete HydroPowerPlant using Id = "  + command.getHydroPowerPlantId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the HydroPowerPlant via HydroPowerPlantFetchOneSummary
     * @param 	summary HydroPowerPlantFetchOneSummary 
     * @return 	HydroPowerPlantFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public HydroPowerPlant getHydroPowerPlant( HydroPowerPlantFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "HydroPowerPlantFetchOneSummary arg cannot be null" );
    	
    	HydroPowerPlant entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	HydroPowerPlantValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a HydroPowerPlant
        	// --------------------------------------
        	CompletableFuture<HydroPowerPlant> futureEntity = queryGateway.query(new FindHydroPowerPlantQuery( new LoadHydroPowerPlantFilter( summary.getHydroPowerPlantId() ) ), ResponseTypes.instanceOf(HydroPowerPlant.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate HydroPowerPlant with id " + summary.getHydroPowerPlantId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all HydroPowerPlants
     *
     * @return 	List<HydroPowerPlant> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<HydroPowerPlant> getAllHydroPowerPlant() 
    throws ProcessingException {
        List<HydroPowerPlant> list = null;

        try {
        	CompletableFuture<List<HydroPowerPlant>> futureList = queryGateway.query(new FindAllHydroPowerPlantQuery(), ResponseTypes.multipleInstancesOf(HydroPowerPlant.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all HydroPowerPlant";
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
	 * @return		HydroPowerPlant
	 */
	protected HydroPowerPlant load( UUID id ) throws ProcessingException {
		hydroPowerPlant = HydroPowerPlantBusinessDelegate.getHydroPowerPlantInstance().getHydroPowerPlant( new HydroPowerPlantFetchOneSummary(id) );	
		return hydroPowerPlant;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private HydroPowerPlant hydroPowerPlant 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(HydroPowerPlantBusinessDelegate.class.getName());
    
}
