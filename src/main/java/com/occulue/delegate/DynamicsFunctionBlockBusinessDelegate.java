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
 * DynamicsFunctionBlock business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of DynamicsFunctionBlock related services in the case of a DynamicsFunctionBlock business related service failing.</li>
 * <li>Exposes a simpler, uniform DynamicsFunctionBlock interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill DynamicsFunctionBlock business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class DynamicsFunctionBlockBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public DynamicsFunctionBlockBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* DynamicsFunctionBlock Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	DynamicsFunctionBlockBusinessDelegate
	*/
	public static DynamicsFunctionBlockBusinessDelegate getDynamicsFunctionBlockInstance() {
		return( new DynamicsFunctionBlockBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createDynamicsFunctionBlock( CreateDynamicsFunctionBlockCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getDynamicsFunctionBlockId() == null )
				command.setDynamicsFunctionBlockId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsFunctionBlockValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateDynamicsFunctionBlockCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateDynamicsFunctionBlockCommand of DynamicsFunctionBlock is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create DynamicsFunctionBlock - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateDynamicsFunctionBlockCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateDynamicsFunctionBlock( UpdateDynamicsFunctionBlockCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	DynamicsFunctionBlockValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateDynamicsFunctionBlockCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save DynamicsFunctionBlock - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteDynamicsFunctionBlockCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteDynamicsFunctionBlockCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	DynamicsFunctionBlockValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteDynamicsFunctionBlockCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete DynamicsFunctionBlock using Id = "  + command.getDynamicsFunctionBlockId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the DynamicsFunctionBlock via DynamicsFunctionBlockFetchOneSummary
     * @param 	summary DynamicsFunctionBlockFetchOneSummary 
     * @return 	DynamicsFunctionBlockFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public DynamicsFunctionBlock getDynamicsFunctionBlock( DynamicsFunctionBlockFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "DynamicsFunctionBlockFetchOneSummary arg cannot be null" );
    	
    	DynamicsFunctionBlock entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	DynamicsFunctionBlockValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a DynamicsFunctionBlock
        	// --------------------------------------
        	CompletableFuture<DynamicsFunctionBlock> futureEntity = queryGateway.query(new FindDynamicsFunctionBlockQuery( new LoadDynamicsFunctionBlockFilter( summary.getDynamicsFunctionBlockId() ) ), ResponseTypes.instanceOf(DynamicsFunctionBlock.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate DynamicsFunctionBlock with id " + summary.getDynamicsFunctionBlockId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all DynamicsFunctionBlocks
     *
     * @return 	List<DynamicsFunctionBlock> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<DynamicsFunctionBlock> getAllDynamicsFunctionBlock() 
    throws ProcessingException {
        List<DynamicsFunctionBlock> list = null;

        try {
        	CompletableFuture<List<DynamicsFunctionBlock>> futureList = queryGateway.query(new FindAllDynamicsFunctionBlockQuery(), ResponseTypes.multipleInstancesOf(DynamicsFunctionBlock.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all DynamicsFunctionBlock";
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
	 * @return		DynamicsFunctionBlock
	 */
	protected DynamicsFunctionBlock load( UUID id ) throws ProcessingException {
		dynamicsFunctionBlock = DynamicsFunctionBlockBusinessDelegate.getDynamicsFunctionBlockInstance().getDynamicsFunctionBlock( new DynamicsFunctionBlockFetchOneSummary(id) );	
		return dynamicsFunctionBlock;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private DynamicsFunctionBlock dynamicsFunctionBlock 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(DynamicsFunctionBlockBusinessDelegate.class.getName());
    
}
