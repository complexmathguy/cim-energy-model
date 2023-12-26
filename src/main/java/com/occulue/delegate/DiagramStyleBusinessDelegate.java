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
 * DiagramStyle business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiagramStyle related services in the case of a DiagramStyle business related service failing.</li>
 * <li>Exposes a simpler, uniform DiagramStyle interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiagramStyle business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiagramStyleBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiagramStyleBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiagramStyle Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiagramStyleBusinessDelegate
	*/
	public static DiagramStyleBusinessDelegate getDiagramStyleInstance() {
		return( new DiagramStyleBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiagramStyle( CreateDiagramStyleCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiagramStyleId() == null )
				command.setDiagramStyleId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramStyleValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiagramStyleCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiagramStyleCommand of DiagramStyle is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiagramStyle - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiagramStyleCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiagramStyle( UpdateDiagramStyleCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiagramStyleValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiagramStyleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiagramStyle - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiagramStyleCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiagramStyleCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramStyleValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiagramStyleCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiagramStyle using Id = "  + command.getDiagramStyleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiagramStyle via DiagramStyleFetchOneSummary
     * @param 	summary DiagramStyleFetchOneSummary 
     * @return 	DiagramStyleFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiagramStyle getDiagramStyle( DiagramStyleFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiagramStyleFetchOneSummary arg cannot be null" );
    	
    	DiagramStyle entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiagramStyleValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiagramStyle
        	// --------------------------------------
        	CompletableFuture<DiagramStyle> futureEntity = queryGateway.query(new FindDiagramStyleQuery( new LoadDiagramStyleFilter( summary.getDiagramStyleId() ) ), ResponseTypes.instanceOf(DiagramStyle.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiagramStyle with id " + summary.getDiagramStyleId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiagramStyles
     *
     * @return 	List<DiagramStyle> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiagramStyle> getAllDiagramStyle() 
    throws ProcessingException {
        List<DiagramStyle> list = null;

        try {
        	CompletableFuture<List<DiagramStyle>> futureList = queryGateway.query(new FindAllDiagramStyleQuery(), ResponseTypes.multipleInstancesOf(DiagramStyle.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiagramStyle";
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
	 * @return		DiagramStyle
	 */
	protected DiagramStyle load( UUID id ) throws ProcessingException {
		diagramStyle = DiagramStyleBusinessDelegate.getDiagramStyleInstance().getDiagramStyle( new DiagramStyleFetchOneSummary(id) );	
		return diagramStyle;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiagramStyle diagramStyle 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiagramStyleBusinessDelegate.class.getName());
    
}
