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
 * DiagramObjectPoint business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiagramObjectPoint related services in the case of a DiagramObjectPoint business related service failing.</li>
 * <li>Exposes a simpler, uniform DiagramObjectPoint interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiagramObjectPoint business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiagramObjectPointBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiagramObjectPointBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiagramObjectPoint Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiagramObjectPointBusinessDelegate
	*/
	public static DiagramObjectPointBusinessDelegate getDiagramObjectPointInstance() {
		return( new DiagramObjectPointBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiagramObjectPoint( CreateDiagramObjectPointCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiagramObjectPointId() == null )
				command.setDiagramObjectPointId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramObjectPointValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiagramObjectPointCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiagramObjectPointCommand of DiagramObjectPoint is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiagramObjectPoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiagramObjectPointCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiagramObjectPoint( UpdateDiagramObjectPointCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiagramObjectPointValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiagramObjectPointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiagramObjectPoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiagramObjectPointCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiagramObjectPointCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramObjectPointValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiagramObjectPointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiagramObjectPoint using Id = "  + command.getDiagramObjectPointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiagramObjectPoint via DiagramObjectPointFetchOneSummary
     * @param 	summary DiagramObjectPointFetchOneSummary 
     * @return 	DiagramObjectPointFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiagramObjectPoint getDiagramObjectPoint( DiagramObjectPointFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiagramObjectPointFetchOneSummary arg cannot be null" );
    	
    	DiagramObjectPoint entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiagramObjectPointValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiagramObjectPoint
        	// --------------------------------------
        	CompletableFuture<DiagramObjectPoint> futureEntity = queryGateway.query(new FindDiagramObjectPointQuery( new LoadDiagramObjectPointFilter( summary.getDiagramObjectPointId() ) ), ResponseTypes.instanceOf(DiagramObjectPoint.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiagramObjectPoint with id " + summary.getDiagramObjectPointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiagramObjectPoints
     *
     * @return 	List<DiagramObjectPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiagramObjectPoint> getAllDiagramObjectPoint() 
    throws ProcessingException {
        List<DiagramObjectPoint> list = null;

        try {
        	CompletableFuture<List<DiagramObjectPoint>> futureList = queryGateway.query(new FindAllDiagramObjectPointQuery(), ResponseTypes.multipleInstancesOf(DiagramObjectPoint.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiagramObjectPoint";
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
	 * @return		DiagramObjectPoint
	 */
	protected DiagramObjectPoint load( UUID id ) throws ProcessingException {
		diagramObjectPoint = DiagramObjectPointBusinessDelegate.getDiagramObjectPointInstance().getDiagramObjectPoint( new DiagramObjectPointFetchOneSummary(id) );	
		return diagramObjectPoint;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiagramObjectPoint diagramObjectPoint 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiagramObjectPointBusinessDelegate.class.getName());
    
}
