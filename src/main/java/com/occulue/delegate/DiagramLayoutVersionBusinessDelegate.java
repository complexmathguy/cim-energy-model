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
 * DiagramLayoutVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DiagramLayoutVersion related services in the case of a DiagramLayoutVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform DiagramLayoutVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DiagramLayoutVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DiagramLayoutVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DiagramLayoutVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DiagramLayoutVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DiagramLayoutVersionBusinessDelegate
	*/
	public static DiagramLayoutVersionBusinessDelegate getDiagramLayoutVersionInstance() {
		return( new DiagramLayoutVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDiagramLayoutVersion( CreateDiagramLayoutVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDiagramLayoutVersionId() == null )
				command.setDiagramLayoutVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramLayoutVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDiagramLayoutVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDiagramLayoutVersionCommand of DiagramLayoutVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DiagramLayoutVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDiagramLayoutVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDiagramLayoutVersion( UpdateDiagramLayoutVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DiagramLayoutVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDiagramLayoutVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DiagramLayoutVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDiagramLayoutVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDiagramLayoutVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DiagramLayoutVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDiagramLayoutVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DiagramLayoutVersion using Id = "  + command.getDiagramLayoutVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DiagramLayoutVersion via DiagramLayoutVersionFetchOneSummary
     * @param 	summary DiagramLayoutVersionFetchOneSummary 
     * @return 	DiagramLayoutVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DiagramLayoutVersion getDiagramLayoutVersion( DiagramLayoutVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DiagramLayoutVersionFetchOneSummary arg cannot be null" );
    	
    	DiagramLayoutVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DiagramLayoutVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DiagramLayoutVersion
        	// --------------------------------------
        	CompletableFuture<DiagramLayoutVersion> futureEntity = queryGateway.query(new FindDiagramLayoutVersionQuery( new LoadDiagramLayoutVersionFilter( summary.getDiagramLayoutVersionId() ) ), ResponseTypes.instanceOf(DiagramLayoutVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DiagramLayoutVersion with id " + summary.getDiagramLayoutVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DiagramLayoutVersions
     *
     * @return 	List<DiagramLayoutVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DiagramLayoutVersion> getAllDiagramLayoutVersion() 
    throws ProcessingException {
        List<DiagramLayoutVersion> list = null;

        try {
        	CompletableFuture<List<DiagramLayoutVersion>> futureList = queryGateway.query(new FindAllDiagramLayoutVersionQuery(), ResponseTypes.multipleInstancesOf(DiagramLayoutVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DiagramLayoutVersion";
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
	 * @return		DiagramLayoutVersion
	 */
	protected DiagramLayoutVersion load( UUID id ) throws ProcessingException {
		diagramLayoutVersion = DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().getDiagramLayoutVersion( new DiagramLayoutVersionFetchOneSummary(id) );	
		return diagramLayoutVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DiagramLayoutVersion diagramLayoutVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DiagramLayoutVersionBusinessDelegate.class.getName());
    
}
