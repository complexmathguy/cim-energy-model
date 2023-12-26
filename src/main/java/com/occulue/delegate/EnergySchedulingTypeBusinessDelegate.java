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
 * EnergySchedulingType business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EnergySchedulingType related services in the case of a EnergySchedulingType business related service failing.</li>
 * <li>Exposes a simpler, uniform EnergySchedulingType interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EnergySchedulingType business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EnergySchedulingTypeBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EnergySchedulingTypeBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EnergySchedulingType Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EnergySchedulingTypeBusinessDelegate
	*/
	public static EnergySchedulingTypeBusinessDelegate getEnergySchedulingTypeInstance() {
		return( new EnergySchedulingTypeBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEnergySchedulingType( CreateEnergySchedulingTypeCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEnergySchedulingTypeId() == null )
				command.setEnergySchedulingTypeId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergySchedulingTypeValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEnergySchedulingTypeCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEnergySchedulingTypeCommand of EnergySchedulingType is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EnergySchedulingType - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEnergySchedulingTypeCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEnergySchedulingType( UpdateEnergySchedulingTypeCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EnergySchedulingTypeValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEnergySchedulingTypeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EnergySchedulingType - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEnergySchedulingTypeCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEnergySchedulingTypeCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergySchedulingTypeValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEnergySchedulingTypeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EnergySchedulingType using Id = "  + command.getEnergySchedulingTypeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EnergySchedulingType via EnergySchedulingTypeFetchOneSummary
     * @param 	summary EnergySchedulingTypeFetchOneSummary 
     * @return 	EnergySchedulingTypeFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EnergySchedulingType getEnergySchedulingType( EnergySchedulingTypeFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EnergySchedulingTypeFetchOneSummary arg cannot be null" );
    	
    	EnergySchedulingType entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EnergySchedulingTypeValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EnergySchedulingType
        	// --------------------------------------
        	CompletableFuture<EnergySchedulingType> futureEntity = queryGateway.query(new FindEnergySchedulingTypeQuery( new LoadEnergySchedulingTypeFilter( summary.getEnergySchedulingTypeId() ) ), ResponseTypes.instanceOf(EnergySchedulingType.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EnergySchedulingType with id " + summary.getEnergySchedulingTypeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EnergySchedulingTypes
     *
     * @return 	List<EnergySchedulingType> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EnergySchedulingType> getAllEnergySchedulingType() 
    throws ProcessingException {
        List<EnergySchedulingType> list = null;

        try {
        	CompletableFuture<List<EnergySchedulingType>> futureList = queryGateway.query(new FindAllEnergySchedulingTypeQuery(), ResponseTypes.multipleInstancesOf(EnergySchedulingType.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EnergySchedulingType";
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
	 * @return		EnergySchedulingType
	 */
	protected EnergySchedulingType load( UUID id ) throws ProcessingException {
		energySchedulingType = EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance().getEnergySchedulingType( new EnergySchedulingTypeFetchOneSummary(id) );	
		return energySchedulingType;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EnergySchedulingType energySchedulingType 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EnergySchedulingTypeBusinessDelegate.class.getName());
    
}
