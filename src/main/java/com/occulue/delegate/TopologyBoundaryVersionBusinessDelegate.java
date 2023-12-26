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
 * TopologyBoundaryVersion business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TopologyBoundaryVersion related services in the case of a TopologyBoundaryVersion business related service failing.</li>
 * <li>Exposes a simpler, uniform TopologyBoundaryVersion interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TopologyBoundaryVersion business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TopologyBoundaryVersionBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TopologyBoundaryVersionBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TopologyBoundaryVersion Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TopologyBoundaryVersionBusinessDelegate
	*/
	public static TopologyBoundaryVersionBusinessDelegate getTopologyBoundaryVersionInstance() {
		return( new TopologyBoundaryVersionBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTopologyBoundaryVersion( CreateTopologyBoundaryVersionCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTopologyBoundaryVersionId() == null )
				command.setTopologyBoundaryVersionId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TopologyBoundaryVersionValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTopologyBoundaryVersionCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTopologyBoundaryVersionCommand of TopologyBoundaryVersion is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TopologyBoundaryVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTopologyBoundaryVersionCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTopologyBoundaryVersion( UpdateTopologyBoundaryVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TopologyBoundaryVersionValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTopologyBoundaryVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TopologyBoundaryVersion - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTopologyBoundaryVersionCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTopologyBoundaryVersionCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TopologyBoundaryVersionValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTopologyBoundaryVersionCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TopologyBoundaryVersion using Id = "  + command.getTopologyBoundaryVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TopologyBoundaryVersion via TopologyBoundaryVersionFetchOneSummary
     * @param 	summary TopologyBoundaryVersionFetchOneSummary 
     * @return 	TopologyBoundaryVersionFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TopologyBoundaryVersion getTopologyBoundaryVersion( TopologyBoundaryVersionFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TopologyBoundaryVersionFetchOneSummary arg cannot be null" );
    	
    	TopologyBoundaryVersion entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TopologyBoundaryVersionValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TopologyBoundaryVersion
        	// --------------------------------------
        	CompletableFuture<TopologyBoundaryVersion> futureEntity = queryGateway.query(new FindTopologyBoundaryVersionQuery( new LoadTopologyBoundaryVersionFilter( summary.getTopologyBoundaryVersionId() ) ), ResponseTypes.instanceOf(TopologyBoundaryVersion.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TopologyBoundaryVersion with id " + summary.getTopologyBoundaryVersionId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TopologyBoundaryVersions
     *
     * @return 	List<TopologyBoundaryVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TopologyBoundaryVersion> getAllTopologyBoundaryVersion() 
    throws ProcessingException {
        List<TopologyBoundaryVersion> list = null;

        try {
        	CompletableFuture<List<TopologyBoundaryVersion>> futureList = queryGateway.query(new FindAllTopologyBoundaryVersionQuery(), ResponseTypes.multipleInstancesOf(TopologyBoundaryVersion.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TopologyBoundaryVersion";
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
	 * @return		TopologyBoundaryVersion
	 */
	protected TopologyBoundaryVersion load( UUID id ) throws ProcessingException {
		topologyBoundaryVersion = TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance().getTopologyBoundaryVersion( new TopologyBoundaryVersionFetchOneSummary(id) );	
		return topologyBoundaryVersion;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TopologyBoundaryVersion topologyBoundaryVersion 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TopologyBoundaryVersionBusinessDelegate.class.getName());
    
}
