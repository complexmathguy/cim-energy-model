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
 * AccumulatorReset business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of AccumulatorReset related services in the case of a AccumulatorReset business related service failing.</li>
 * <li>Exposes a simpler, uniform AccumulatorReset interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill AccumulatorReset business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class AccumulatorResetBusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public AccumulatorResetBusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* AccumulatorReset Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	AccumulatorResetBusinessDelegate
	*/
	public static AccumulatorResetBusinessDelegate getAccumulatorResetInstance() {
		return( new AccumulatorResetBusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createAccumulatorReset( CreateAccumulatorResetCommand command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getAccumulatorResetId() == null )
				command.setAccumulatorResetId( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AccumulatorResetValidator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateAccumulatorResetCommand - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateAccumulatorResetCommand of AccumulatorReset is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create AccumulatorReset - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateAccumulatorResetCommand
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateAccumulatorReset( UpdateAccumulatorResetCommand command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	AccumulatorResetValidator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateAccumulatorResetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save AccumulatorReset - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteAccumulatorResetCommand
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteAccumulatorResetCommand command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	AccumulatorResetValidator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteAccumulatorResetCommand and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete AccumulatorReset using Id = "  + command.getAccumulatorResetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the AccumulatorReset via AccumulatorResetFetchOneSummary
     * @param 	summary AccumulatorResetFetchOneSummary 
     * @return 	AccumulatorResetFetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public AccumulatorReset getAccumulatorReset( AccumulatorResetFetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "AccumulatorResetFetchOneSummary arg cannot be null" );
    	
    	AccumulatorReset entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	AccumulatorResetValidator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a AccumulatorReset
        	// --------------------------------------
        	CompletableFuture<AccumulatorReset> futureEntity = queryGateway.query(new FindAccumulatorResetQuery( new LoadAccumulatorResetFilter( summary.getAccumulatorResetId() ) ), ResponseTypes.instanceOf(AccumulatorReset.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate AccumulatorReset with id " + summary.getAccumulatorResetId();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all AccumulatorResets
     *
     * @return 	List<AccumulatorReset> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<AccumulatorReset> getAllAccumulatorReset() 
    throws ProcessingException {
        List<AccumulatorReset> list = null;

        try {
        	CompletableFuture<List<AccumulatorReset>> futureList = queryGateway.query(new FindAllAccumulatorResetQuery(), ResponseTypes.multipleInstancesOf(AccumulatorReset.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all AccumulatorReset";
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
	 * @return		AccumulatorReset
	 */
	protected AccumulatorReset load( UUID id ) throws ProcessingException {
		accumulatorReset = AccumulatorResetBusinessDelegate.getAccumulatorResetInstance().getAccumulatorReset( new AccumulatorResetFetchOneSummary(id) );	
		return accumulatorReset;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private AccumulatorReset accumulatorReset 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(AccumulatorResetBusinessDelegate.class.getName());
    
}
