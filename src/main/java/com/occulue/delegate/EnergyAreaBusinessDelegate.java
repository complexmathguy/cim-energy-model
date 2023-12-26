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
 * EnergyArea business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EnergyArea related services in the case of a EnergyArea business related service failing.</li>
 * <li>Exposes a simpler, uniform EnergyArea interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EnergyArea business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EnergyAreaBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EnergyAreaBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EnergyArea Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EnergyAreaBusinessDelegate
	*/
	public static EnergyAreaBusinessDelegate getEnergyAreaInstance() {
		return( new EnergyAreaBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEnergyArea( CreateEnergyAreaCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEnergyAreaId() == null )
				command.setEnergyAreaId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergyAreaValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEnergyAreaCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEnergyAreaCommand of EnergyArea is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EnergyArea - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEnergyAreaCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEnergyArea( UpdateEnergyAreaCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EnergyAreaValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEnergyAreaCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EnergyArea - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEnergyAreaCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEnergyAreaCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EnergyAreaValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEnergyAreaCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EnergyArea using Id = "  + command.getEnergyAreaId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EnergyArea via EnergyAreaFetchOneSummary
     * @param 	summary EnergyAreaFetchOneSummary 
     * @return 	EnergyAreaFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EnergyArea getEnergyArea( EnergyAreaFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EnergyAreaFetchOneSummary arg cannot be null" );
    	
    	EnergyArea entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EnergyAreaValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EnergyArea
        	// --------------------------------------
        	CompletableFuture<EnergyArea> futureEntity = queryGateway.query(new FindEnergyAreaQuery( new LoadEnergyAreaFilter( summary.getEnergyAreaId() ) ), ResponseTypes.instanceOf(EnergyArea.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EnergyArea with id " + summary.getEnergyAreaId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EnergyAreas
     *
     * @return 	List<EnergyArea> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EnergyArea> getAllEnergyArea() 
    throws ProcessingException {
        List<EnergyArea> list = null;

        try {
        	CompletableFuture<List<EnergyArea>> futureList = queryGateway.query(new FindAllEnergyAreaQuery(), ResponseTypes.multipleInstancesOf(EnergyArea.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EnergyArea";
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
	 * @return		EnergyArea
	 */
	protected EnergyArea load( UUID id ) throws ProcessingException {
		energyArea = EnergyAreaBusinessDelegate.getEnergyAreaInstance().getEnergyArea( new EnergyAreaFetchOneSummary(id) );	
		return energyArea;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EnergyArea energyArea 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EnergyAreaBusinessDelegate.class.getName());
    
}
