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
 * RatioTapChangerTable business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of RatioTapChangerTable related services in the case of a RatioTapChangerTable business related service failing.</li>
 * <li>Exposes a simpler, uniform RatioTapChangerTable interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill RatioTapChangerTable business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class RatioTapChangerTableBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public RatioTapChangerTableBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* RatioTapChangerTable Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	RatioTapChangerTableBusinessDelegate
	*/
	public static RatioTapChangerTableBusinessDelegate getRatioTapChangerTableInstance() {
		return( new RatioTapChangerTableBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createRatioTapChangerTable( CreateRatioTapChangerTableCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getRatioTapChangerTableId() == null )
				command.setRatioTapChangerTableId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RatioTapChangerTableValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateRatioTapChangerTableCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateRatioTapChangerTableCommand of RatioTapChangerTable is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create RatioTapChangerTable - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateRatioTapChangerTableCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateRatioTapChangerTable( UpdateRatioTapChangerTableCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	RatioTapChangerTableValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateRatioTapChangerTableCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save RatioTapChangerTable - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteRatioTapChangerTableCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteRatioTapChangerTableCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	RatioTapChangerTableValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteRatioTapChangerTableCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete RatioTapChangerTable using Id = "  + command.getRatioTapChangerTableId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the RatioTapChangerTable via RatioTapChangerTableFetchOneSummary
     * @param 	summary RatioTapChangerTableFetchOneSummary 
     * @return 	RatioTapChangerTableFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public RatioTapChangerTable getRatioTapChangerTable( RatioTapChangerTableFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "RatioTapChangerTableFetchOneSummary arg cannot be null" );
    	
    	RatioTapChangerTable entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	RatioTapChangerTableValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a RatioTapChangerTable
        	// --------------------------------------
        	CompletableFuture<RatioTapChangerTable> futureEntity = queryGateway.query(new FindRatioTapChangerTableQuery( new LoadRatioTapChangerTableFilter( summary.getRatioTapChangerTableId() ) ), ResponseTypes.instanceOf(RatioTapChangerTable.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate RatioTapChangerTable with id " + summary.getRatioTapChangerTableId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all RatioTapChangerTables
     *
     * @return 	List<RatioTapChangerTable> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<RatioTapChangerTable> getAllRatioTapChangerTable() 
    throws ProcessingException {
        List<RatioTapChangerTable> list = null;

        try {
        	CompletableFuture<List<RatioTapChangerTable>> futureList = queryGateway.query(new FindAllRatioTapChangerTableQuery(), ResponseTypes.multipleInstancesOf(RatioTapChangerTable.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all RatioTapChangerTable";
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
	 * @return		RatioTapChangerTable
	 */
	protected RatioTapChangerTable load( UUID id ) throws ProcessingException {
		ratioTapChangerTable = RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance().getRatioTapChangerTable( new RatioTapChangerTableFetchOneSummary(id) );	
		return ratioTapChangerTable;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private RatioTapChangerTable ratioTapChangerTable 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(RatioTapChangerTableBusinessDelegate.class.getName());
    
}
