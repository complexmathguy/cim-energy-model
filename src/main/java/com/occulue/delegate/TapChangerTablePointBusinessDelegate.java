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
 * TapChangerTablePoint business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TapChangerTablePoint related services in the case of a TapChangerTablePoint business related service failing.</li>
 * <li>Exposes a simpler, uniform TapChangerTablePoint interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TapChangerTablePoint business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TapChangerTablePointBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TapChangerTablePointBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TapChangerTablePoint Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TapChangerTablePointBusinessDelegate
	*/
	public static TapChangerTablePointBusinessDelegate getTapChangerTablePointInstance() {
		return( new TapChangerTablePointBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTapChangerTablePoint( CreateTapChangerTablePointCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTapChangerTablePointId() == null )
				command.setTapChangerTablePointId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TapChangerTablePointValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTapChangerTablePointCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTapChangerTablePointCommand of TapChangerTablePoint is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TapChangerTablePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTapChangerTablePointCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTapChangerTablePoint( UpdateTapChangerTablePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TapChangerTablePointValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTapChangerTablePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TapChangerTablePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTapChangerTablePointCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTapChangerTablePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TapChangerTablePointValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTapChangerTablePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TapChangerTablePoint using Id = "  + command.getTapChangerTablePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TapChangerTablePoint via TapChangerTablePointFetchOneSummary
     * @param 	summary TapChangerTablePointFetchOneSummary 
     * @return 	TapChangerTablePointFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TapChangerTablePoint getTapChangerTablePoint( TapChangerTablePointFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TapChangerTablePointFetchOneSummary arg cannot be null" );
    	
    	TapChangerTablePoint entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TapChangerTablePointValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TapChangerTablePoint
        	// --------------------------------------
        	CompletableFuture<TapChangerTablePoint> futureEntity = queryGateway.query(new FindTapChangerTablePointQuery( new LoadTapChangerTablePointFilter( summary.getTapChangerTablePointId() ) ), ResponseTypes.instanceOf(TapChangerTablePoint.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TapChangerTablePoint with id " + summary.getTapChangerTablePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TapChangerTablePoints
     *
     * @return 	List<TapChangerTablePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TapChangerTablePoint> getAllTapChangerTablePoint() 
    throws ProcessingException {
        List<TapChangerTablePoint> list = null;

        try {
        	CompletableFuture<List<TapChangerTablePoint>> futureList = queryGateway.query(new FindAllTapChangerTablePointQuery(), ResponseTypes.multipleInstancesOf(TapChangerTablePoint.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TapChangerTablePoint";
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
	 * @return		TapChangerTablePoint
	 */
	protected TapChangerTablePoint load( UUID id ) throws ProcessingException {
		tapChangerTablePoint = TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().getTapChangerTablePoint( new TapChangerTablePointFetchOneSummary(id) );	
		return tapChangerTablePoint;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TapChangerTablePoint tapChangerTablePoint 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TapChangerTablePointBusinessDelegate.class.getName());
    
}
