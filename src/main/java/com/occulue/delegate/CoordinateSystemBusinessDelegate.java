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
 * CoordinateSystem business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of CoordinateSystem related services in the case of a CoordinateSystem business related service failing.</li>
 * <li>Exposes a simpler, uniform CoordinateSystem interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill CoordinateSystem business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class CoordinateSystemBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public CoordinateSystemBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* CoordinateSystem Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	CoordinateSystemBusinessDelegate
	*/
	public static CoordinateSystemBusinessDelegate getCoordinateSystemInstance() {
		return( new CoordinateSystemBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createCoordinateSystem( CreateCoordinateSystemCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getCoordinateSystemId() == null )
				command.setCoordinateSystemId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CoordinateSystemValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateCoordinateSystemCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateCoordinateSystemCommand of CoordinateSystem is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create CoordinateSystem - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateCoordinateSystemCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateCoordinateSystem( UpdateCoordinateSystemCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	CoordinateSystemValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateCoordinateSystemCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save CoordinateSystem - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteCoordinateSystemCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteCoordinateSystemCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	CoordinateSystemValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteCoordinateSystemCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete CoordinateSystem using Id = "  + command.getCoordinateSystemId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the CoordinateSystem via CoordinateSystemFetchOneSummary
     * @param 	summary CoordinateSystemFetchOneSummary 
     * @return 	CoordinateSystemFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public CoordinateSystem getCoordinateSystem( CoordinateSystemFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "CoordinateSystemFetchOneSummary arg cannot be null" );
    	
    	CoordinateSystem entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	CoordinateSystemValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a CoordinateSystem
        	// --------------------------------------
        	CompletableFuture<CoordinateSystem> futureEntity = queryGateway.query(new FindCoordinateSystemQuery( new LoadCoordinateSystemFilter( summary.getCoordinateSystemId() ) ), ResponseTypes.instanceOf(CoordinateSystem.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate CoordinateSystem with id " + summary.getCoordinateSystemId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all CoordinateSystems
     *
     * @return 	List<CoordinateSystem> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<CoordinateSystem> getAllCoordinateSystem() 
    throws ProcessingException {
        List<CoordinateSystem> list = null;

        try {
        	CompletableFuture<List<CoordinateSystem>> futureList = queryGateway.query(new FindAllCoordinateSystemQuery(), ResponseTypes.multipleInstancesOf(CoordinateSystem.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all CoordinateSystem";
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
	 * @return		CoordinateSystem
	 */
	protected CoordinateSystem load( UUID id ) throws ProcessingException {
		coordinateSystem = CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().getCoordinateSystem( new CoordinateSystemFetchOneSummary(id) );	
		return coordinateSystem;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private CoordinateSystem coordinateSystem 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(CoordinateSystemBusinessDelegate.class.getName());
    
}
