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
 * ConnectivityNode business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ConnectivityNode related services in the case of a ConnectivityNode business related service failing.</li>
 * <li>Exposes a simpler, uniform ConnectivityNode interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ConnectivityNode business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ConnectivityNodeBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ConnectivityNodeBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ConnectivityNode Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ConnectivityNodeBusinessDelegate
	*/
	public static ConnectivityNodeBusinessDelegate getConnectivityNodeInstance() {
		return( new ConnectivityNodeBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createConnectivityNode( CreateConnectivityNodeCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getConnectivityNodeId() == null )
				command.setConnectivityNodeId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConnectivityNodeValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateConnectivityNodeCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateConnectivityNodeCommand of ConnectivityNode is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ConnectivityNode - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateConnectivityNodeCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateConnectivityNode( UpdateConnectivityNodeCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ConnectivityNodeValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateConnectivityNodeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ConnectivityNode - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteConnectivityNodeCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteConnectivityNodeCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ConnectivityNodeValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteConnectivityNodeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ConnectivityNode using Id = "  + command.getConnectivityNodeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ConnectivityNode via ConnectivityNodeFetchOneSummary
     * @param 	summary ConnectivityNodeFetchOneSummary 
     * @return 	ConnectivityNodeFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ConnectivityNode getConnectivityNode( ConnectivityNodeFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ConnectivityNodeFetchOneSummary arg cannot be null" );
    	
    	ConnectivityNode entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ConnectivityNodeValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ConnectivityNode
        	// --------------------------------------
        	CompletableFuture<ConnectivityNode> futureEntity = queryGateway.query(new FindConnectivityNodeQuery( new LoadConnectivityNodeFilter( summary.getConnectivityNodeId() ) ), ResponseTypes.instanceOf(ConnectivityNode.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ConnectivityNode with id " + summary.getConnectivityNodeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ConnectivityNodes
     *
     * @return 	List<ConnectivityNode> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ConnectivityNode> getAllConnectivityNode() 
    throws ProcessingException {
        List<ConnectivityNode> list = null;

        try {
        	CompletableFuture<List<ConnectivityNode>> futureList = queryGateway.query(new FindAllConnectivityNodeQuery(), ResponseTypes.multipleInstancesOf(ConnectivityNode.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ConnectivityNode";
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
	 * @return		ConnectivityNode
	 */
	protected ConnectivityNode load( UUID id ) throws ProcessingException {
		connectivityNode = ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().getConnectivityNode( new ConnectivityNodeFetchOneSummary(id) );	
		return connectivityNode;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ConnectivityNode connectivityNode 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ConnectivityNodeBusinessDelegate.class.getName());
    
}
