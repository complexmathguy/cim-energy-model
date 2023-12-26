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
 * PositionPoint business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of PositionPoint related services in the case of a PositionPoint business related service failing.</li>
 * <li>Exposes a simpler, uniform PositionPoint interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill PositionPoint business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class PositionPointBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public PositionPointBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* PositionPoint Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	PositionPointBusinessDelegate
	*/
	public static PositionPointBusinessDelegate getPositionPointInstance() {
		return( new PositionPointBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createPositionPoint( CreatePositionPointCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getPositionPointId() == null )
				command.setPositionPointId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PositionPointValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreatePositionPointCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreatePositionPointCommand of PositionPoint is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create PositionPoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdatePositionPointCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updatePositionPoint( UpdatePositionPointCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	PositionPointValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdatePositionPointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save PositionPoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeletePositionPointCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeletePositionPointCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	PositionPointValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeletePositionPointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete PositionPoint using Id = "  + command.getPositionPointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the PositionPoint via PositionPointFetchOneSummary
     * @param 	summary PositionPointFetchOneSummary 
     * @return 	PositionPointFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public PositionPoint getPositionPoint( PositionPointFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "PositionPointFetchOneSummary arg cannot be null" );
    	
    	PositionPoint entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	PositionPointValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a PositionPoint
        	// --------------------------------------
        	CompletableFuture<PositionPoint> futureEntity = queryGateway.query(new FindPositionPointQuery( new LoadPositionPointFilter( summary.getPositionPointId() ) ), ResponseTypes.instanceOf(PositionPoint.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate PositionPoint with id " + summary.getPositionPointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all PositionPoints
     *
     * @return 	List<PositionPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<PositionPoint> getAllPositionPoint() 
    throws ProcessingException {
        List<PositionPoint> list = null;

        try {
        	CompletableFuture<List<PositionPoint>> futureList = queryGateway.query(new FindAllPositionPointQuery(), ResponseTypes.multipleInstancesOf(PositionPoint.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all PositionPoint";
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
	 * @return		PositionPoint
	 */
	protected PositionPoint load( UUID id ) throws ProcessingException {
		positionPoint = PositionPointBusinessDelegate.getPositionPointInstance().getPositionPoint( new PositionPointFetchOneSummary(id) );	
		return positionPoint;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private PositionPoint positionPoint 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(PositionPointBusinessDelegate.class.getName());
    
}
