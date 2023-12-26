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
 * ENTSOEConnectivityNode business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of ENTSOEConnectivityNode related services in the case of a ENTSOEConnectivityNode business related service failing.</li>
 * <li>Exposes a simpler, uniform ENTSOEConnectivityNode interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill ENTSOEConnectivityNode business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class ENTSOEConnectivityNodeBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public ENTSOEConnectivityNodeBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* ENTSOEConnectivityNode Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	ENTSOEConnectivityNodeBusinessDelegate
	*/
	public static ENTSOEConnectivityNodeBusinessDelegate getENTSOEConnectivityNodeInstance() {
		return( new ENTSOEConnectivityNodeBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createENTSOEConnectivityNode( CreateENTSOEConnectivityNodeCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getENTSOEConnectivityNodeId() == null )
				command.setENTSOEConnectivityNodeId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEConnectivityNodeValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateENTSOEConnectivityNodeCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateENTSOEConnectivityNodeCommand of ENTSOEConnectivityNode is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create ENTSOEConnectivityNode - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateENTSOEConnectivityNodeCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateENTSOEConnectivityNode( UpdateENTSOEConnectivityNodeCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	ENTSOEConnectivityNodeValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateENTSOEConnectivityNodeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save ENTSOEConnectivityNode - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteENTSOEConnectivityNodeCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteENTSOEConnectivityNodeCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	ENTSOEConnectivityNodeValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteENTSOEConnectivityNodeCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete ENTSOEConnectivityNode using Id = "  + command.getENTSOEConnectivityNodeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the ENTSOEConnectivityNode via ENTSOEConnectivityNodeFetchOneSummary
     * @param 	summary ENTSOEConnectivityNodeFetchOneSummary 
     * @return 	ENTSOEConnectivityNodeFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public ENTSOEConnectivityNode getENTSOEConnectivityNode( ENTSOEConnectivityNodeFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "ENTSOEConnectivityNodeFetchOneSummary arg cannot be null" );
    	
    	ENTSOEConnectivityNode entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	ENTSOEConnectivityNodeValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a ENTSOEConnectivityNode
        	// --------------------------------------
        	CompletableFuture<ENTSOEConnectivityNode> futureEntity = queryGateway.query(new FindENTSOEConnectivityNodeQuery( new LoadENTSOEConnectivityNodeFilter( summary.getENTSOEConnectivityNodeId() ) ), ResponseTypes.instanceOf(ENTSOEConnectivityNode.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate ENTSOEConnectivityNode with id " + summary.getENTSOEConnectivityNodeId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all ENTSOEConnectivityNodes
     *
     * @return 	List<ENTSOEConnectivityNode> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<ENTSOEConnectivityNode> getAllENTSOEConnectivityNode() 
    throws ProcessingException {
        List<ENTSOEConnectivityNode> list = null;

        try {
        	CompletableFuture<List<ENTSOEConnectivityNode>> futureList = queryGateway.query(new FindAllENTSOEConnectivityNodeQuery(), ResponseTypes.multipleInstancesOf(ENTSOEConnectivityNode.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all ENTSOEConnectivityNode";
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
	 * @return		ENTSOEConnectivityNode
	 */
	protected ENTSOEConnectivityNode load( UUID id ) throws ProcessingException {
		eNTSOEConnectivityNode = ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance().getENTSOEConnectivityNode( new ENTSOEConnectivityNodeFetchOneSummary(id) );	
		return eNTSOEConnectivityNode;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private ENTSOEConnectivityNode eNTSOEConnectivityNode 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(ENTSOEConnectivityNodeBusinessDelegate.class.getName());
    
}
