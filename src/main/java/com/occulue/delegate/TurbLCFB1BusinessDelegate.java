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
 * TurbLCFB1 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of TurbLCFB1 related services in the case of a TurbLCFB1 business related service failing.</li>
 * <li>Exposes a simpler, uniform TurbLCFB1 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill TurbLCFB1 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class TurbLCFB1BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public TurbLCFB1BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* TurbLCFB1 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	TurbLCFB1BusinessDelegate
	*/
	public static TurbLCFB1BusinessDelegate getTurbLCFB1Instance() {
		return( new TurbLCFB1BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createTurbLCFB1( CreateTurbLCFB1Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getTurbLCFB1Id() == null )
				command.setTurbLCFB1Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbLCFB1Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateTurbLCFB1Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateTurbLCFB1Command of TurbLCFB1 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create TurbLCFB1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateTurbLCFB1Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateTurbLCFB1( UpdateTurbLCFB1Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	TurbLCFB1Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateTurbLCFB1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save TurbLCFB1 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteTurbLCFB1Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteTurbLCFB1Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	TurbLCFB1Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteTurbLCFB1Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete TurbLCFB1 using Id = "  + command.getTurbLCFB1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the TurbLCFB1 via TurbLCFB1FetchOneSummary
     * @param 	summary TurbLCFB1FetchOneSummary 
     * @return 	TurbLCFB1FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public TurbLCFB1 getTurbLCFB1( TurbLCFB1FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "TurbLCFB1FetchOneSummary arg cannot be null" );
    	
    	TurbLCFB1 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	TurbLCFB1Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a TurbLCFB1
        	// --------------------------------------
        	CompletableFuture<TurbLCFB1> futureEntity = queryGateway.query(new FindTurbLCFB1Query( new LoadTurbLCFB1Filter( summary.getTurbLCFB1Id() ) ), ResponseTypes.instanceOf(TurbLCFB1.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate TurbLCFB1 with id " + summary.getTurbLCFB1Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all TurbLCFB1s
     *
     * @return 	List<TurbLCFB1> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<TurbLCFB1> getAllTurbLCFB1() 
    throws ProcessingException {
        List<TurbLCFB1> list = null;

        try {
        	CompletableFuture<List<TurbLCFB1>> futureList = queryGateway.query(new FindAllTurbLCFB1Query(), ResponseTypes.multipleInstancesOf(TurbLCFB1.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all TurbLCFB1";
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
	 * @return		TurbLCFB1
	 */
	protected TurbLCFB1 load( UUID id ) throws ProcessingException {
		turbLCFB1 = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().getTurbLCFB1( new TurbLCFB1FetchOneSummary(id) );	
		return turbLCFB1;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private TurbLCFB1 turbLCFB1 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(TurbLCFB1BusinessDelegate.class.getName());
    
}
