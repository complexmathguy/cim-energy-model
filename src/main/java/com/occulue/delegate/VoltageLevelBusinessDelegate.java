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
 * VoltageLevel business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of VoltageLevel related services in the case of a VoltageLevel business related service failing.</li>
 * <li>Exposes a simpler, uniform VoltageLevel interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill VoltageLevel business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class VoltageLevelBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public VoltageLevelBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* VoltageLevel Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	VoltageLevelBusinessDelegate
	*/
	public static VoltageLevelBusinessDelegate getVoltageLevelInstance() {
		return( new VoltageLevelBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createVoltageLevel( CreateVoltageLevelCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getVoltageLevelId() == null )
				command.setVoltageLevelId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageLevelValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateVoltageLevelCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateVoltageLevelCommand of VoltageLevel is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create VoltageLevel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateVoltageLevelCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateVoltageLevel( UpdateVoltageLevelCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	VoltageLevelValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateVoltageLevelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save VoltageLevel - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteVoltageLevelCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteVoltageLevelCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	VoltageLevelValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteVoltageLevelCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete VoltageLevel using Id = "  + command.getVoltageLevelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the VoltageLevel via VoltageLevelFetchOneSummary
     * @param 	summary VoltageLevelFetchOneSummary 
     * @return 	VoltageLevelFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public VoltageLevel getVoltageLevel( VoltageLevelFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "VoltageLevelFetchOneSummary arg cannot be null" );
    	
    	VoltageLevel entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	VoltageLevelValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a VoltageLevel
        	// --------------------------------------
        	CompletableFuture<VoltageLevel> futureEntity = queryGateway.query(new FindVoltageLevelQuery( new LoadVoltageLevelFilter( summary.getVoltageLevelId() ) ), ResponseTypes.instanceOf(VoltageLevel.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate VoltageLevel with id " + summary.getVoltageLevelId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all VoltageLevels
     *
     * @return 	List<VoltageLevel> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<VoltageLevel> getAllVoltageLevel() 
    throws ProcessingException {
        List<VoltageLevel> list = null;

        try {
        	CompletableFuture<List<VoltageLevel>> futureList = queryGateway.query(new FindAllVoltageLevelQuery(), ResponseTypes.multipleInstancesOf(VoltageLevel.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all VoltageLevel";
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
	 * @return		VoltageLevel
	 */
	protected VoltageLevel load( UUID id ) throws ProcessingException {
		voltageLevel = VoltageLevelBusinessDelegate.getVoltageLevelInstance().getVoltageLevel( new VoltageLevelFetchOneSummary(id) );	
		return voltageLevel;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private VoltageLevel voltageLevel 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(VoltageLevelBusinessDelegate.class.getName());
    
}
