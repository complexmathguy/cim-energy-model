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
 * DiagramObjectGluePoint business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiagramObjectGluePoint related services in the case of a DiagramObjectGluePoint business related service failing.</li>
 * <li>Exposes a simpler, uniform DiagramObjectGluePoint interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiagramObjectGluePoint business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiagramObjectGluePointBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiagramObjectGluePointBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiagramObjectGluePoint Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiagramObjectGluePointBusinessDelegate
	*/
	public static DiagramObjectGluePointBusinessDelegate getDiagramObjectGluePointInstance() {
		return( new DiagramObjectGluePointBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiagramObjectGluePoint( CreateDiagramObjectGluePointCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiagramObjectGluePointId() == null )
				command.setDiagramObjectGluePointId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramObjectGluePointValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiagramObjectGluePointCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiagramObjectGluePointCommand of DiagramObjectGluePoint is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiagramObjectGluePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiagramObjectGluePointCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiagramObjectGluePoint( UpdateDiagramObjectGluePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiagramObjectGluePointValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiagramObjectGluePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiagramObjectGluePoint - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiagramObjectGluePointCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiagramObjectGluePointCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramObjectGluePointValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiagramObjectGluePointCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiagramObjectGluePoint using Id = "  + command.getDiagramObjectGluePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiagramObjectGluePoint via DiagramObjectGluePointFetchOneSummary
     * @param 	summary DiagramObjectGluePointFetchOneSummary 
     * @return 	DiagramObjectGluePointFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiagramObjectGluePoint getDiagramObjectGluePoint( DiagramObjectGluePointFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiagramObjectGluePointFetchOneSummary arg cannot be null" );
    	
    	DiagramObjectGluePoint entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiagramObjectGluePointValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiagramObjectGluePoint
        	// --------------------------------------
        	CompletableFuture<DiagramObjectGluePoint> futureEntity = queryGateway.query(new FindDiagramObjectGluePointQuery( new LoadDiagramObjectGluePointFilter( summary.getDiagramObjectGluePointId() ) ), ResponseTypes.instanceOf(DiagramObjectGluePoint.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiagramObjectGluePoint with id " + summary.getDiagramObjectGluePointId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiagramObjectGluePoints
     *
     * @return 	List<DiagramObjectGluePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiagramObjectGluePoint> getAllDiagramObjectGluePoint() 
    throws ProcessingException {
        List<DiagramObjectGluePoint> list = null;

        try {
        	CompletableFuture<List<DiagramObjectGluePoint>> futureList = queryGateway.query(new FindAllDiagramObjectGluePointQuery(), ResponseTypes.multipleInstancesOf(DiagramObjectGluePoint.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiagramObjectGluePoint";
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
	 * @return		DiagramObjectGluePoint
	 */
	protected DiagramObjectGluePoint load( UUID id ) throws ProcessingException {
		diagramObjectGluePoint = DiagramObjectGluePointBusinessDelegate.getDiagramObjectGluePointInstance().getDiagramObjectGluePoint( new DiagramObjectGluePointFetchOneSummary(id) );	
		return diagramObjectGluePoint;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiagramObjectGluePoint diagramObjectGluePoint 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiagramObjectGluePointBusinessDelegate.class.getName());
    
}
