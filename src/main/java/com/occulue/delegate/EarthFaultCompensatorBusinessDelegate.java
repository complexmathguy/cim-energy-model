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
 * EarthFaultCompensator business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of EarthFaultCompensator related services in the case of a EarthFaultCompensator business related service failing.</li>
 * <li>Exposes a simpler, uniform EarthFaultCompensator interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill EarthFaultCompensator business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class EarthFaultCompensatorBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public EarthFaultCompensatorBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* EarthFaultCompensator Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	EarthFaultCompensatorBusinessDelegate
	*/
	public static EarthFaultCompensatorBusinessDelegate getEarthFaultCompensatorInstance() {
		return( new EarthFaultCompensatorBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createEarthFaultCompensator( CreateEarthFaultCompensatorCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getEarthFaultCompensatorId() == null )
				command.setEarthFaultCompensatorId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EarthFaultCompensatorValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateEarthFaultCompensatorCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateEarthFaultCompensatorCommand of EarthFaultCompensator is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create EarthFaultCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateEarthFaultCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateEarthFaultCompensator( UpdateEarthFaultCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	EarthFaultCompensatorValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateEarthFaultCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save EarthFaultCompensator - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteEarthFaultCompensatorCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteEarthFaultCompensatorCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	EarthFaultCompensatorValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteEarthFaultCompensatorCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete EarthFaultCompensator using Id = "  + command.getEarthFaultCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the EarthFaultCompensator via EarthFaultCompensatorFetchOneSummary
     * @param 	summary EarthFaultCompensatorFetchOneSummary 
     * @return 	EarthFaultCompensatorFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public EarthFaultCompensator getEarthFaultCompensator( EarthFaultCompensatorFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "EarthFaultCompensatorFetchOneSummary arg cannot be null" );
    	
    	EarthFaultCompensator entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	EarthFaultCompensatorValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a EarthFaultCompensator
        	// --------------------------------------
        	CompletableFuture<EarthFaultCompensator> futureEntity = queryGateway.query(new FindEarthFaultCompensatorQuery( new LoadEarthFaultCompensatorFilter( summary.getEarthFaultCompensatorId() ) ), ResponseTypes.instanceOf(EarthFaultCompensator.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate EarthFaultCompensator with id " + summary.getEarthFaultCompensatorId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all EarthFaultCompensators
     *
     * @return 	List<EarthFaultCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<EarthFaultCompensator> getAllEarthFaultCompensator() 
    throws ProcessingException {
        List<EarthFaultCompensator> list = null;

        try {
        	CompletableFuture<List<EarthFaultCompensator>> futureList = queryGateway.query(new FindAllEarthFaultCompensatorQuery(), ResponseTypes.multipleInstancesOf(EarthFaultCompensator.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all EarthFaultCompensator";
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
	 * @return		EarthFaultCompensator
	 */
	protected EarthFaultCompensator load( UUID id ) throws ProcessingException {
		earthFaultCompensator = EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().getEarthFaultCompensator( new EarthFaultCompensatorFetchOneSummary(id) );	
		return earthFaultCompensator;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private EarthFaultCompensator earthFaultCompensator 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(EarthFaultCompensatorBusinessDelegate.class.getName());
    
}
