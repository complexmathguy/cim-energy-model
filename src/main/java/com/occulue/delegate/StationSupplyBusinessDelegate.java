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
 * StationSupply business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of StationSupply related services in the case of a StationSupply business related service failing.</li>
 * <li>Exposes a simpler, uniform StationSupply interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill StationSupply business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class StationSupplyBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public StationSupplyBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* StationSupply Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	StationSupplyBusinessDelegate
	*/
	public static StationSupplyBusinessDelegate getStationSupplyInstance() {
		return( new StationSupplyBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createStationSupply( CreateStationSupplyCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getStationSupplyId() == null )
				command.setStationSupplyId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StationSupplyValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateStationSupplyCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateStationSupplyCommand of StationSupply is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create StationSupply - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateStationSupplyCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateStationSupply( UpdateStationSupplyCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	StationSupplyValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateStationSupplyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save StationSupply - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteStationSupplyCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteStationSupplyCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	StationSupplyValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteStationSupplyCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete StationSupply using Id = "  + command.getStationSupplyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the StationSupply via StationSupplyFetchOneSummary
     * @param 	summary StationSupplyFetchOneSummary 
     * @return 	StationSupplyFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public StationSupply getStationSupply( StationSupplyFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "StationSupplyFetchOneSummary arg cannot be null" );
    	
    	StationSupply entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	StationSupplyValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a StationSupply
        	// --------------------------------------
        	CompletableFuture<StationSupply> futureEntity = queryGateway.query(new FindStationSupplyQuery( new LoadStationSupplyFilter( summary.getStationSupplyId() ) ), ResponseTypes.instanceOf(StationSupply.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate StationSupply with id " + summary.getStationSupplyId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all StationSupplys
     *
     * @return 	List<StationSupply> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<StationSupply> getAllStationSupply() 
    throws ProcessingException {
        List<StationSupply> list = null;

        try {
        	CompletableFuture<List<StationSupply>> futureList = queryGateway.query(new FindAllStationSupplyQuery(), ResponseTypes.multipleInstancesOf(StationSupply.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all StationSupply";
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
	 * @return		StationSupply
	 */
	protected StationSupply load( UUID id ) throws ProcessingException {
		stationSupply = StationSupplyBusinessDelegate.getStationSupplyInstance().getStationSupply( new StationSupplyFetchOneSummary(id) );	
		return stationSupply;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private StationSupply stationSupply 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(StationSupplyBusinessDelegate.class.getName());
    
}
