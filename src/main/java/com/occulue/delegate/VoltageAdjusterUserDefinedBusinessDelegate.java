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
 * VoltageAdjusterUserDefined business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VoltageAdjusterUserDefined related services in the case of a VoltageAdjusterUserDefined business related service failing.</li>
 * <li>Exposes a simpler, uniform VoltageAdjusterUserDefined interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VoltageAdjusterUserDefined business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VoltageAdjusterUserDefinedBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VoltageAdjusterUserDefinedBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VoltageAdjusterUserDefined Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VoltageAdjusterUserDefinedBusinessDelegate
	*/
	public static VoltageAdjusterUserDefinedBusinessDelegate getVoltageAdjusterUserDefinedInstance() {
		return( new VoltageAdjusterUserDefinedBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVoltageAdjusterUserDefined( CreateVoltageAdjusterUserDefinedCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVoltageAdjusterUserDefinedId() == null )
				command.setVoltageAdjusterUserDefinedId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageAdjusterUserDefinedValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVoltageAdjusterUserDefinedCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVoltageAdjusterUserDefinedCommand of VoltageAdjusterUserDefined is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VoltageAdjusterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVoltageAdjusterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVoltageAdjusterUserDefined( UpdateVoltageAdjusterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VoltageAdjusterUserDefinedValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVoltageAdjusterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VoltageAdjusterUserDefined - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVoltageAdjusterUserDefinedCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVoltageAdjusterUserDefinedCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageAdjusterUserDefinedValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVoltageAdjusterUserDefinedCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VoltageAdjusterUserDefined using Id = "  + command.getVoltageAdjusterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VoltageAdjusterUserDefined via VoltageAdjusterUserDefinedFetchOneSummary
     * @param 	summary VoltageAdjusterUserDefinedFetchOneSummary 
     * @return 	VoltageAdjusterUserDefinedFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VoltageAdjusterUserDefined getVoltageAdjusterUserDefined( VoltageAdjusterUserDefinedFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VoltageAdjusterUserDefinedFetchOneSummary arg cannot be null" );
    	
    	VoltageAdjusterUserDefined entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VoltageAdjusterUserDefinedValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VoltageAdjusterUserDefined
        	// --------------------------------------
        	CompletableFuture<VoltageAdjusterUserDefined> futureEntity = queryGateway.query(new FindVoltageAdjusterUserDefinedQuery( new LoadVoltageAdjusterUserDefinedFilter( summary.getVoltageAdjusterUserDefinedId() ) ), ResponseTypes.instanceOf(VoltageAdjusterUserDefined.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VoltageAdjusterUserDefined with id " + summary.getVoltageAdjusterUserDefinedId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VoltageAdjusterUserDefineds
     *
     * @return 	List<VoltageAdjusterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VoltageAdjusterUserDefined> getAllVoltageAdjusterUserDefined() 
    throws ProcessingException {
        List<VoltageAdjusterUserDefined> list = null;

        try {
        	CompletableFuture<List<VoltageAdjusterUserDefined>> futureList = queryGateway.query(new FindAllVoltageAdjusterUserDefinedQuery(), ResponseTypes.multipleInstancesOf(VoltageAdjusterUserDefined.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VoltageAdjusterUserDefined";
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
	 * @return		VoltageAdjusterUserDefined
	 */
	protected VoltageAdjusterUserDefined load( UUID id ) throws ProcessingException {
		voltageAdjusterUserDefined = VoltageAdjusterUserDefinedBusinessDelegate.getVoltageAdjusterUserDefinedInstance().getVoltageAdjusterUserDefined( new VoltageAdjusterUserDefinedFetchOneSummary(id) );	
		return voltageAdjusterUserDefined;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VoltageAdjusterUserDefined voltageAdjusterUserDefined 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VoltageAdjusterUserDefinedBusinessDelegate.class.getName());
    
}
