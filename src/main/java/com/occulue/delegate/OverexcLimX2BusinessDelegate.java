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
 * OverexcLimX2 business delegate class.
 * <p>
 * This class implements the Business Delegate design pattern for the purpose of:
 * <ol>
 * <li>Reducing coupling between the business tier and a client of the business tier by hiding all business-tier implementation details</li>
 * <li>Improving the available of OverexcLimX2 related services in the case of a OverexcLimX2 business related service failing.</li>
 * <li>Exposes a simpler, uniform OverexcLimX2 interface to the business tier, making it easy for clients to consume a simple Java object.</li>
 * <li>Hides the communication protocol that may be required to fulfill OverexcLimX2 business related services.</li>
 * </ol>
 * <p>
 * @author your_name_here
 */
public class OverexcLimX2BusinessDelegate 
extends BaseBusinessDelegate {
//************************************************************************
// Public Methods
//************************************************************************
    /** 
     * Default Constructor 
     */
    public OverexcLimX2BusinessDelegate()  {
    	queryGateway 		= applicationContext.getBean(QueryGateway.class);
    	commandGateway 		= applicationContext.getBean(CommandGateway.class);
    	queryUpdateEmitter  = applicationContext.getBean(QueryUpdateEmitter.class);
	}


   /**
	* OverexcLimX2 Business Delegate Factory Method
	*
	* All methods are expected to be self-sufficient.
	*
	* @return 	OverexcLimX2BusinessDelegate
	*/
	public static OverexcLimX2BusinessDelegate getOverexcLimX2Instance() {
		return( new OverexcLimX2BusinessDelegate() );
	}
 
   /**
    * Creates the provided command.
    * 
    * @param		command ${class.getCreateCommandAlias()}
    * @exception    ProcessingException
    * @exception	IllegalArgumentException
    * @return		CompletableFuture<UUID>
    */
	public CompletableFuture<UUID> createOverexcLimX2( CreateOverexcLimX2Command command )
    throws ProcessingException, IllegalArgumentException {

		CompletableFuture<UUID> completableFuture = null;
				
		try {
			// --------------------------------------
        	// assign identity now if none
        	// -------------------------------------- 
			if ( command.getOverexcLimX2Id() == null )
				command.setOverexcLimX2Id( UUID.randomUUID() );
				
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcLimX2Validator.getInstance().validate( command );    

    		// ---------------------------------------
    		// issue the CreateOverexcLimX2Command - by convention the future return value for a create command
        	// that is handled by the constructor of an aggregate will return the UUID 
    		// ---------------------------------------
        	completableFuture = commandGateway.send( command );
        	
			LOGGER.log( Level.INFO, "return from Command Gateway for CreateOverexcLimX2Command of OverexcLimX2 is " + command );
			
        }
        catch (Exception exc) {
            final String errMsg = "Unable to create OverexcLimX2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return completableFuture;
    }

   /**
    * Update the provided command.
    * @param		command UpdateOverexcLimX2Command
    * @return		CompletableFuture<Void>
    * @exception    ProcessingException
    * @exception  	IllegalArgumentException
    */
    public CompletableFuture<Void> updateOverexcLimX2( UpdateOverexcLimX2Command command ) 
    throws ProcessingException, IllegalArgumentException {
    	CompletableFuture<Void> completableFuture = null;
    	
    	try {       

			// --------------------------------------
        	// validate 
        	// --------------------------------------    	
        	OverexcLimX2Validator.getInstance().validate( command );    

        	// --------------------------------------
        	// issue the UpdateOverexcLimX2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
    	}
        catch (Exception exc) {
            final String errMsg = "Unable to save OverexcLimX2 - " + exc;
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        
    	return completableFuture;
    }
   
   /**
    * Deletes the associatied value object
    * @param		command DeleteOverexcLimX2Command
    * @return		CompletableFuture<Void>
    * @exception 	ProcessingException
    */
    public CompletableFuture<Void> delete( DeleteOverexcLimX2Command command ) 
    throws ProcessingException, IllegalArgumentException {	
    	
    	CompletableFuture<Void> completableFuture = null;
    	
        try {  
			// --------------------------------------
        	// validate the command
        	// --------------------------------------    	
        	OverexcLimX2Validator.getInstance().validate( command );    
        	
        	// --------------------------------------
        	// issue the DeleteOverexcLimX2Command and return right away
        	// --------------------------------------    	
        	completableFuture = commandGateway.send( command );
        }
        catch (Exception exc) {
            final String errMsg = "Unable to delete OverexcLimX2 using Id = "  + command.getOverexcLimX2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }
        
        return completableFuture;
    }

    /**
     * Method to retrieve the OverexcLimX2 via OverexcLimX2FetchOneSummary
     * @param 	summary OverexcLimX2FetchOneSummary 
     * @return 	OverexcLimX2FetchOneResponse
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    public OverexcLimX2 getOverexcLimX2( OverexcLimX2FetchOneSummary summary ) 
    throws ProcessingException, IllegalArgumentException {
    	
    	if( summary == null )
    		throw new IllegalArgumentException( "OverexcLimX2FetchOneSummary arg cannot be null" );
    	
    	OverexcLimX2 entity = null;
    	
        try {
        	// --------------------------------------
        	// validate the fetch one summary
        	// --------------------------------------    	
        	OverexcLimX2Validator.getInstance().validate( summary );    
        	
        	// --------------------------------------
        	// use queryGateway to send request to Find a OverexcLimX2
        	// --------------------------------------
        	CompletableFuture<OverexcLimX2> futureEntity = queryGateway.query(new FindOverexcLimX2Query( new LoadOverexcLimX2Filter( summary.getOverexcLimX2Id() ) ), ResponseTypes.instanceOf(OverexcLimX2.class));
        	
        	entity = futureEntity.get();
        }
        catch( Exception exc ) {
            final String errMsg = "Unable to locate OverexcLimX2 with id " + summary.getOverexcLimX2Id();
            LOGGER.log( Level.WARNING, errMsg, exc );
            throw new ProcessingException( errMsg, exc );
        }
        finally {
        }        
        
        return entity;
    }


    /**
     * Method to retrieve a collection of all OverexcLimX2s
     *
     * @return 	List<OverexcLimX2> 
     * @exception ProcessingException Thrown if any problems
     */
    public List<OverexcLimX2> getAllOverexcLimX2() 
    throws ProcessingException {
        List<OverexcLimX2> list = null;

        try {
        	CompletableFuture<List<OverexcLimX2>> futureList = queryGateway.query(new FindAllOverexcLimX2Query(), ResponseTypes.multipleInstancesOf(OverexcLimX2.class));
        	
        	list = futureList.get();
        }
        catch( Exception exc ) {
            String errMsg = "Failed to get all OverexcLimX2";
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
	 * @return		OverexcLimX2
	 */
	protected OverexcLimX2 load( UUID id ) throws ProcessingException {
		overexcLimX2 = OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().getOverexcLimX2( new OverexcLimX2FetchOneSummary(id) );	
		return overexcLimX2;
	}


//************************************************************************
// Attributes
//************************************************************************
	private final QueryGateway queryGateway;
	private final CommandGateway commandGateway;
	private final QueryUpdateEmitter queryUpdateEmitter;
	private OverexcLimX2 overexcLimX2 	= null;
    private static final Logger LOGGER 			= Logger.getLogger(OverexcLimX2BusinessDelegate.class.getName());
    
}
