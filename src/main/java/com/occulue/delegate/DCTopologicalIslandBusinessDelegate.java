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
 * DCTopologicalIsland business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DCTopologicalIsland related services in the case of a DCTopologicalIsland business related service failing.</li>
 * <li>Exposes a simpler, uniform DCTopologicalIsland interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DCTopologicalIsland business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DCTopologicalIslandBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DCTopologicalIslandBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DCTopologicalIsland Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DCTopologicalIslandBusinessDelegate
	*/
	public static DCTopologicalIslandBusinessDelegate getDCTopologicalIslandInstance() {
		return( new DCTopologicalIslandBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDCTopologicalIsland( CreateDCTopologicalIslandCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDCTopologicalIslandId() == null )
				command.setDCTopologicalIslandId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCTopologicalIslandValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDCTopologicalIslandCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDCTopologicalIslandCommand of DCTopologicalIsland is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DCTopologicalIsland - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDCTopologicalIslandCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDCTopologicalIsland( UpdateDCTopologicalIslandCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DCTopologicalIslandValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDCTopologicalIslandCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DCTopologicalIsland - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDCTopologicalIslandCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDCTopologicalIslandCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DCTopologicalIslandValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDCTopologicalIslandCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DCTopologicalIsland using Id = "  + command.getDCTopologicalIslandId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DCTopologicalIsland via DCTopologicalIslandFetchOneSummary
     * @param 	summary DCTopologicalIslandFetchOneSummary 
     * @return 	DCTopologicalIslandFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DCTopologicalIsland getDCTopologicalIsland( DCTopologicalIslandFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DCTopologicalIslandFetchOneSummary arg cannot be null" );
    	
    	DCTopologicalIsland entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DCTopologicalIslandValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DCTopologicalIsland
        	// --------------------------------------
        	CompletableFuture<DCTopologicalIsland> futureEntity = queryGateway.query(new FindDCTopologicalIslandQuery( new LoadDCTopologicalIslandFilter( summary.getDCTopologicalIslandId() ) ), ResponseTypes.instanceOf(DCTopologicalIsland.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DCTopologicalIsland with id " + summary.getDCTopologicalIslandId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DCTopologicalIslands
     *
     * @return 	List<DCTopologicalIsland> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DCTopologicalIsland> getAllDCTopologicalIsland() 
    throws ProcessingException {
        List<DCTopologicalIsland> list = null;

        try {
        	CompletableFuture<List<DCTopologicalIsland>> futureList = queryGateway.query(new FindAllDCTopologicalIslandQuery(), ResponseTypes.multipleInstancesOf(DCTopologicalIsland.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DCTopologicalIsland";
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
	 * @return		DCTopologicalIsland
	 */
	protected DCTopologicalIsland load( UUID id ) throws ProcessingException {
		dCTopologicalIsland = DCTopologicalIslandBusinessDelegate.getDCTopologicalIslandInstance().getDCTopologicalIsland( new DCTopologicalIslandFetchOneSummary(id) );	
		return dCTopologicalIsland;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DCTopologicalIsland dCTopologicalIsland 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DCTopologicalIslandBusinessDelegate.class.getName());
    
}
